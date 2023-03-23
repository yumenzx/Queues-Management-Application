package mvc.controller;

import mvc.view.SimulationSetupView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimulationSetupController {

    private final SimulationSetupView view;

    public SimulationSetupController() {
        view = new SimulationSetupView();
        view.addSimulateButtonListener(new SimulateListenner());
    }

    class SimulateListenner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int nrClienti, nrCozi, timpSimulare, timpSosireMinim, timpSosireMaxim, timpServireMinim, timpServireMaxim;
            try {
                nrClienti = view.getNrClientsField();
                nrCozi = view.getNrQueuesField();
                timpSimulare = view.getSimulationTimeField();
                timpSosireMinim = view.getMinArrivalTimeField();
                timpSosireMaxim = view.getMaxArrivalTimeField();
                timpServireMinim = view.getMinServiceTimeField();
                timpServireMaxim = view.getMaxServiceTimeField();
            } catch (Exception exception) {
                view.showMessage("Introduceti in fiecare camp cate un numar");
                return;
            }
            if (nrCozi > 20 || timpSimulare < 1 || timpSosireMinim > timpSosireMaxim || timpServireMinim > timpServireMaxim)
                view.showMessage("Introduceti un input corect");
            else
                new SimulationManager(nrClienti, nrCozi, timpSimulare, timpSosireMinim, timpSosireMaxim, timpServireMinim, timpServireMaxim);
        }
    }
}
