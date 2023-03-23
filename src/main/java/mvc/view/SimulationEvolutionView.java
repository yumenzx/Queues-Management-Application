package mvc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SimulationEvolutionView extends JFrame {

    private JTextArea currentTime;
    private JTextArea textArea;
    private JButton btnStart;
    private List<JLabel> lblQueue;
    private List<JTextField> queueField;

    public SimulationEvolutionView(int nrOfQueues){
        lblQueue = new ArrayList<>(20);
        queueField = new ArrayList<>(20);

        this.setTitle("Simulation Evolution");
        this.setBounds(100, 100, 739, 688);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel lblTime = new JLabel("Time");
        lblTime.setBounds(332, 10, 36, 20);
        lblTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
        this.getContentPane().add(lblTime);

        currentTime = new JTextArea();
        currentTime.setBounds(378, 10, 30, 22);
        currentTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
        this.getContentPane().add(currentTime);

        JLabel lblWaitingClients = new JLabel("Waiting clients");
        lblWaitingClients.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblWaitingClients.setBounds(580, 31, 96, 17);
        this.getContentPane().add(lblWaitingClients);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(572, 49, 109, 447);
        this.getContentPane().add(scrollPane);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));


        lblQueue.add(new JLabel("Queue 1"));
        lblQueue.get(0).setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblQueue.get(0).setBounds(10, 49, 70, 20);

        queueField.add(new JTextField());
        queueField.get(0).setFont(new Font("Tahoma", Font.PLAIN, 14));
        queueField.get(0).setBounds(73, 49, 448, 22);
        queueField.get(0).setColumns(10);

        lblQueue.add(new JLabel("Queue 2:"));
        lblQueue.get(1).setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblQueue.get(1).setBounds(10, 79, 70, 20);

        queueField.add(new JTextField());
        queueField.get(1).setFont(new Font("Tahoma", Font.PLAIN, 14));
        queueField.get(1).setColumns(10);
        queueField.get(1).setBounds(73, 79, 448, 22);

        lblQueue.add(new JLabel("Queue 3:"));
        lblQueue.get(2).setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblQueue.get(2).setBounds(10, 109, 70, 20);

        queueField.add(new JTextField());
        queueField.get(2).setFont(new Font("Tahoma", Font.PLAIN, 14));
        queueField.get(2).setColumns(10);
        queueField.get(2).setBounds(73, 109, 448, 22);

        lblQueue.add(new JLabel("Queue 4:"));
        lblQueue.get(3).setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblQueue.get(3).setBounds(10, 139, 70, 20);

        queueField.add(new JTextField());
        queueField.get(3).setFont(new Font("Tahoma", Font.PLAIN, 14));
        queueField.get(3).setColumns(10);
        queueField.get(3).setBounds(73, 139, 448, 22);

        lblQueue.add(new JLabel("Queue 5:"));
        lblQueue.get(4).setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblQueue.get(4).setBounds(10, 169, 70, 20);

        queueField.add(new JTextField());
        queueField.get(4).setFont(new Font("Tahoma", Font.PLAIN, 14));
        queueField.get(4).setColumns(10);
        queueField.get(4).setBounds(73, 169, 448, 22);

        lblQueue.add(new JLabel("Queue 6:"));
        lblQueue.get(5).setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblQueue.get(5).setBounds(10, 199, 70, 20);

        queueField.add(new JTextField());
        queueField.get(5).setFont(new Font("Tahoma", Font.PLAIN, 14));
        queueField.get(5).setColumns(10);
        queueField.get(5).setBounds(73, 199, 448, 22);

        lblQueue.add(new JLabel("Queue 7:"));
        lblQueue.get(6).setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblQueue.get(6).setBounds(10, 229, 70, 20);

        queueField.add(new JTextField());
        queueField.get(6).setFont(new Font("Tahoma", Font.PLAIN, 14));
        queueField.get(6).setColumns(10);
        queueField.get(6).setBounds(73, 229, 448, 22);

        lblQueue.add(new JLabel("Queue 8:"));
        lblQueue.get(7).setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblQueue.get(7).setBounds(10, 259, 70, 20);

        queueField.add(new JTextField());
        queueField.get(7).setFont(new Font("Tahoma", Font.PLAIN, 14));
        queueField.get(7).setColumns(10);
        queueField.get(7).setBounds(73, 259, 448, 22);

        lblQueue.add(new JLabel("Queue 9:"));
        lblQueue.get(8).setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblQueue.get(8).setBounds(10, 291, 70, 20);

        queueField.add(new JTextField());
        queueField.get(8).setFont(new Font("Tahoma", Font.PLAIN, 14));
        queueField.get(8).setColumns(10);
        queueField.get(8).setBounds(73, 291, 448, 22);

        lblQueue.add(new JLabel("Queue 10:"));
        lblQueue.get(9).setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblQueue.get(9).setBounds(10, 321, 70, 20);

        queueField.add(new JTextField());
        queueField.get(9).setFont(new Font("Tahoma", Font.PLAIN, 14));
        queueField.get(9).setColumns(10);
        queueField.get(9).setBounds(73, 321, 448, 22);

        lblQueue.add(new JLabel("Queue 11:"));
        lblQueue.get(10).setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblQueue.get(10).setBounds(10, 351, 70, 20);

        queueField.add(new JTextField());
        queueField.get(10).setFont(new Font("Tahoma", Font.PLAIN, 14));
        queueField.get(10).setColumns(10);
        queueField.get(10).setBounds(73, 351, 448, 22);

        lblQueue.add( new JLabel("Queue 12:"));
        lblQueue.get(11).setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblQueue.get(11).setBounds(10, 381, 70, 20);

        queueField.add(new JTextField());
        queueField.get(11).setFont(new Font("Tahoma", Font.PLAIN, 14));
        queueField.get(11).setColumns(10);
        queueField.get(11).setBounds(73, 381, 448, 22);

        lblQueue.add(new JLabel("Queue 13:"));
        lblQueue.get(12).setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblQueue.get(12).setBounds(10, 413, 70, 20);

        queueField.add(new JTextField());
        queueField.get(12).setFont(new Font("Tahoma", Font.PLAIN, 14));
        queueField.get(12).setColumns(10);
        queueField.get(12).setBounds(73, 413, 448, 22);

        lblQueue.add(new JLabel("Queue 14:"));
        lblQueue.get(13).setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblQueue.get(13).setBounds(10, 443, 70, 20);

        queueField.add(new JTextField());
        queueField.get(13).setFont(new Font("Tahoma", Font.PLAIN, 14));
        queueField.get(13).setColumns(10);
        queueField.get(13).setBounds(73, 443, 448, 22);

        lblQueue.add(new JLabel("Queue 15:"));
        lblQueue.get(14).setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblQueue.get(14).setBounds(10, 473, 70, 20);

        queueField.add(new JTextField());
        queueField.get(14).setFont(new Font("Tahoma", Font.PLAIN, 14));
        queueField.get(14).setColumns(10);
        queueField.get(14).setBounds(73, 473, 448, 22);

        lblQueue.add( new JLabel("Queue 16:"));
        lblQueue.get(15).setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblQueue.get(15).setBounds(10, 503, 70, 20);

        queueField.add(new JTextField());
        queueField.get(15).setFont(new Font("Tahoma", Font.PLAIN, 14));
        queueField.get(15).setColumns(10);
        queueField.get(15).setBounds(73, 503, 448, 22);

        lblQueue.add( new JLabel("Queue 17:"));
        lblQueue.get(16).setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblQueue.get(16).setBounds(10, 530, 70, 20);

        queueField.add(new JTextField());
        queueField.get(16).setFont(new Font("Tahoma", Font.PLAIN, 14));
        queueField.get(16).setColumns(10);
        queueField.get(16).setBounds(73, 530, 448, 22);

        lblQueue.add(new JLabel("Queue 18:"));
        lblQueue.get(17).setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblQueue.get(17).setBounds(10, 560, 70, 20);

        queueField.add(new JTextField());
        queueField.get(17).setFont(new Font("Tahoma", Font.PLAIN, 14));
        queueField.get(17).setColumns(10);
        queueField.get(17).setBounds(73, 560, 448, 22);

        lblQueue.add(new JLabel("Queue 19:"));
        lblQueue.get(18).setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblQueue.get(18).setBounds(10, 590, 70, 20);

        queueField.add(new JTextField());
        queueField.get(18).setFont(new Font("Tahoma", Font.PLAIN, 14));
        queueField.get(18).setColumns(10);
        queueField.get(18).setBounds(73, 590, 448, 22);

        lblQueue.add(new JLabel("Queue 20"));
        lblQueue.get(19).setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblQueue.get(19).setBounds(10, 620, 70, 20);

        queueField.add(new JTextField());
        queueField.get(19).setFont(new Font("Tahoma", Font.PLAIN, 14));
        queueField.get(19).setColumns(10);
        queueField.get(19).setBounds(73, 620, 448, 22);

        btnStart = new JButton("Start");
        btnStart.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnStart.setBounds(575, 524, 101, 35);
        this.getContentPane().add(btnStart);

        for(int i=0;i<nrOfQueues;i++){
            this.getContentPane().add(lblQueue.get(i));
            this.getContentPane().add(queueField.get(i));
        }

        this.setVisible(true);
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime.setText(currentTime);
    }

    public void setTextArea(String textArea) {
        this.textArea.setText(textArea);
    }

    public void setQueueWaitingList(int queueId,String text){
        queueField.get(queueId-1).setText(text);
    }

    public void addStartButtonListener(ActionListener action){
        btnStart.addActionListener(action);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Rezultate", JOptionPane.INFORMATION_MESSAGE);
    }
}
