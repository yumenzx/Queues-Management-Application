package mvc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SimulationSetupView extends JFrame {

    private final JTextField nrClientsField;
    private final JTextField nrQueuesField;
    private final JTextField simulationTimeField;
    private final JTextField minArrivalTimeField;
    private final JTextField minServiceTimeField;
    private final JTextField maxArrivalTimeField;
    private final JTextField maxServiceTimeField;

    private final JButton simulateButton;

    public SimulationSetupView() {
        this.setTitle("Simulation Setup");
        this.setBounds(100, 100, 517, 330);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel lblNumberOfClients = new JLabel("Number of clients:");
        lblNumberOfClients.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNumberOfClients.setBounds(23, 61, 116, 28);
        this.getContentPane().add(lblNumberOfClients);

        JLabel lblNumberOfQueus = new JLabel("Number of queues:");
        lblNumberOfQueus.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNumberOfQueus.setBounds(23, 90, 128, 28);
        this.getContentPane().add(lblNumberOfQueus);

        JLabel lblSimulationTime = new JLabel("Simulation time:");
        lblSimulationTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblSimulationTime.setBounds(23, 128, 102, 28);
        this.getContentPane().add(lblSimulationTime);

        JLabel lblMinimumArr = new JLabel("Minimum arrival time:");
        lblMinimumArr.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblMinimumArr.setBounds(21, 166, 142, 28);
        this.getContentPane().add(lblMinimumArr);

        JLabel lblMaximumArrivalTime = new JLabel("Maximum arrival time:");
        lblMaximumArrivalTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblMaximumArrivalTime.setBounds(259, 166, 152, 28);
        this.getContentPane().add(lblMaximumArrivalTime);

        JLabel lblMaximumServiceTime = new JLabel("Maximum service time:");
        lblMaximumServiceTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblMaximumServiceTime.setBounds(259, 200, 152, 28);
        this.getContentPane().add(lblMaximumServiceTime);

        JLabel lblMinimumServiceTime = new JLabel("Minimum service time:");
        lblMinimumServiceTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblMinimumServiceTime.setBounds(21, 200, 142, 28);
        this.getContentPane().add(lblMinimumServiceTime);

        JLabel lblSimulationSetup = new JLabel("Simulation Setup");
        lblSimulationSetup.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblSimulationSetup.setBounds(173, 10, 161, 34);
        this.getContentPane().add(lblSimulationSetup);

        nrClientsField = new JTextField();
        nrClientsField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nrClientsField.setBounds(171, 68, 62, 21);
        this.getContentPane().add(nrClientsField);
        nrClientsField.setColumns(10);

        nrQueuesField = new JTextField();
        nrQueuesField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        nrQueuesField.setColumns(10);
        nrQueuesField.setBounds(171, 97, 62, 21);
        this.getContentPane().add(nrQueuesField);

        simulationTimeField = new JTextField();
        simulationTimeField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        simulationTimeField.setColumns(10);
        simulationTimeField.setBounds(171, 135, 62, 21);
        this.getContentPane().add(simulationTimeField);

        minArrivalTimeField = new JTextField();
        minArrivalTimeField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        minArrivalTimeField.setColumns(10);
        minArrivalTimeField.setBounds(171, 170, 62, 21);
        this.getContentPane().add(minArrivalTimeField);

        minServiceTimeField = new JTextField();
        minServiceTimeField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        minServiceTimeField.setColumns(10);
        minServiceTimeField.setBounds(171, 204, 62, 21);
        this.getContentPane().add(minServiceTimeField);

        maxArrivalTimeField = new JTextField();
        maxArrivalTimeField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        maxArrivalTimeField.setColumns(10);
        maxArrivalTimeField.setBounds(414, 170, 62, 21);
        this.getContentPane().add(maxArrivalTimeField);

        maxServiceTimeField = new JTextField();
        maxServiceTimeField.setFont(new Font("Tahoma", Font.PLAIN, 14));
        maxServiceTimeField.setColumns(10);
        maxServiceTimeField.setBounds(414, 204, 62, 21);
        this.getContentPane().add(maxServiceTimeField);

        simulateButton = new JButton("Simulate");
        simulateButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        simulateButton.setBounds(189, 249, 116, 34);
        this.getContentPane().add(simulateButton);

        this.setVisible(true);
    }

    public int getNrClientsField() {
        return Integer.parseInt(nrClientsField.getText());
    }

    public int getNrQueuesField() {
        return Integer.parseInt(nrQueuesField.getText());
    }

    public int getSimulationTimeField() {
        return Integer.parseInt(simulationTimeField.getText());
    }

    public int getMinArrivalTimeField() {
        return Integer.parseInt(minArrivalTimeField.getText());
    }

    public int getMinServiceTimeField() {
        return Integer.parseInt(minServiceTimeField.getText());
    }

    public int getMaxArrivalTimeField() {
        return Integer.parseInt(maxArrivalTimeField.getText());
    }

    public int getMaxServiceTimeField() {
        return Integer.parseInt(maxServiceTimeField.getText());
    }

    public void addSimulateButtonListener(ActionListener action) {
        simulateButton.addActionListener(action);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Warning", JOptionPane.INFORMATION_MESSAGE);
    }
}
