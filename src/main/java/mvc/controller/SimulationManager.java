package mvc.controller;

import mvc.model.Client;
import mvc.model.Coada;
import mvc.view.SimulationEvolutionView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SimulationManager implements Runnable {
    private final SimulationEvolutionView view;

    private final int numarCozi;
    private final int timpSimulare;

    private List<Client> listaClienti;
    private List<Coada> listaCozi;
    AtomicInteger simulationTime;
    private FileWriter writer;

    private float averageWaitingTime = 0;
    private float averageServiceTime;
    private int peakHour;
    private int maximumNumberOfClients = 0;
    private int numarMomente = 0;

    public SimulationManager(int numarClienti, int numarCozi, int timpSimulare, int timpSosireMinim, int timpSosireMaxim, int timpServireMinim, int timpServireMaxim) {
        view = new SimulationEvolutionView(numarCozi);
        view.addStartButtonListener(new StartListenner());

        this.numarCozi = numarCozi;
        this.timpSimulare = timpSimulare;

        simulationTime = new AtomicInteger(0);
        listaClienti = new ArrayList<>();
        listaCozi = new ArrayList<>();

        generateCilents(numarClienti, timpSosireMinim, timpSosireMaxim, timpServireMinim, timpServireMaxim);

        for (int i = 0; i < numarCozi; i++) {
            Coada coada = new Coada();
            listaCozi.add(coada);
        }

        try {
            writer = new FileWriter("log.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        updateView();
    }

    private void generateCilents(int numarClienti, int timpSosireMinim, int timpSosireMaxim, int timpServireMinim, int timpServireMaxim) {
        Random rand = new Random();
        for (int i = 1; i <= numarClienti; i++) {
            int timpSosire = rand.nextInt(timpSosireMinim ,timpSosireMaxim+1);
            int timpServire = rand.nextInt(timpServireMinim,timpServireMaxim+1);

            listaClienti.add(new Client(timpSosire, timpServire));
        }

        Collections.sort(listaClienti);
        averageServiceTime = 0;
        int id = 1;
        for (Client c : listaClienti) {
            c.setId(id++);
            averageServiceTime += c.getTimpServire();
        }
        averageServiceTime /= listaClienti.size();
    }

    private void updateView() {
        view.setCurrentTime(String.format("%d", simulationTime.get()));

        String waitingList = "";
        for (Client c : listaClienti) {
            waitingList += String.format("(%d,%d,%d)\n", c.getId(), c.getTimpSosire(), c.getTimpServire());
        }
        view.setTextArea(waitingList);

        for (int i = 0; i < numarCozi; i++) {
            String status = listaCozi.get(i).toString();
            view.setQueueWaitingList(i + 1, status);
        }
    }

    private boolean getCoadaStatus() {
        for (Coada c : listaCozi)
            if (c.isOpen())
                return true;
        return false;
    }

    private void close() {
        for (Coada c : listaCozi)
            c.close();
    }

    private void getStats() {
        int nrOfClients = 0;
        float waitingTime = 0;
        for (Coada c : listaCozi) {
            nrOfClients += c.getNumberOfClients();
            waitingTime += c.getWaitingTime();
        }

        if(waitingTime != 0)
            numarMomente++;
        averageWaitingTime += waitingTime / numarCozi;

        if (nrOfClients > maximumNumberOfClients) {
            maximumNumberOfClients = nrOfClients;
            peakHour = simulationTime.get();
        }
    }

    private void distribuie() {

        for (int i = 0; i < listaClienti.size(); i++) {
            int minWaitingTime = listaCozi.get(0).getWaitingTime();
            int coada = 0;
            for (int j = 0; j < listaCozi.size(); j++) {
                if (listaCozi.get(j).getWaitingTime() < minWaitingTime) {
                    minWaitingTime = listaCozi.get(j).getWaitingTime();
                    coada = j;
                }
            }

            if (listaClienti.get(i).getTimpSosire() <= simulationTime.get()) {
                Client client = listaClienti.remove(i);
                listaCozi.get(coada).addClient(client);
                i--;
            }
        }
    }


    @Override
    public void run() {
        for (Coada c : listaCozi) {
            Thread t = new Thread(c);
            t.start();
        }

        while (simulationTime.get() <= timpSimulare || getCoadaStatus()) {
            updateView();
            if (simulationTime.get() >= timpSimulare)
                close();
            try {
                writer.write(toString());
                Thread.sleep(1000);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            simulationTime.incrementAndGet();
            distribuie();
            getStats();
        }
        averageWaitingTime /= numarMomente;
        try {
            writer.write(String.format("\nAverage waiting time: %.2f\nAverage service time: %.2f\nPeak hour: %d",averageWaitingTime,averageServiceTime,peakHour));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        view.showMessage(String.format("Average waiting time: %.2f\nAverage service time: %.2f\nPeak hour: %d",averageWaitingTime,averageServiceTime,peakHour));
    }

    @Override
    public String toString() {
        String currentStatus = String.format("\nTime %d\nWaiting clients: ", simulationTime.get());
        for (Client c : listaClienti) {
            currentStatus += String.format("(%d,%d,%d)", c.getId(), c.getTimpSosire(), c.getTimpServire());
        }
        for (int i = 0; i < numarCozi; i++) {
            currentStatus += String.format("\nQueue %d: %s", i + 1, listaCozi.get(i).toString());
        }
        return currentStatus + "\r\n";
    }

    private final SimulationManager _this = this;

    class StartListenner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Thread t = new Thread(_this);
            t.start();
        }
    }
}
