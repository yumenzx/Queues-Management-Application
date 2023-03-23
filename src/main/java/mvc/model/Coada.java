package mvc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Coada implements Runnable {

    private BlockingQueue<Client> listaClienti;
    private int waitingTime;
    private boolean isOpen;

    public Coada() {
        listaClienti = new ArrayBlockingQueue<>(1000);
        waitingTime = 0;
        isOpen = true;
    }

    public int getNumberOfClients(){
        return listaClienti.size();
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void addClient(Client client) {
        listaClienti.add(client);
        waitingTime += client.getTimpServire();
    }

    public void close() {
        if (listaClienti.size() == 0)
            isOpen = false;
    }

    @Override
    public void run() {
        while (isOpen) {
            if (listaClienti.size() > 0) {
                listaClienti.peek().decreaseTimpServire();
                if (listaClienti.peek().getTimpServire() == 0)
                    listaClienti.remove();
                waitingTime--;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {

        if (listaClienti.size() == 0)
            return "closed";

        String status = "";
        for (Client c : listaClienti) {
            status += String.format("(%d,%d,%d)", c.getId(), c.getTimpSosire(), c.getTimpServire());
        }

        return status;
    }
}
