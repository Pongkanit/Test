package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField times;
    @FXML
    private TextField delay;
    @FXML
    private Label status;


    @FXML
    public void goOn()
    {
        AutoClicker autoClicker = new AutoClicker();
        double money = Double.parseDouble(times.getText());
        autoClicker.setMoney(money);
        boolean flag = true;
        while(flag) {
            autoClicker.clickMouse();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (autoClicker.money < 50 || autoClicker.winCount == 10){
                flag = false;
            }
        }
    }

//    @FXML
//    public void waitingToDo(int delay) throws Exception{
//        String plusDot = "";
//        for (int i = 0; i < delay/1000; i++ ){
//            Thread.sleep(500);
//            if (plusDot.length() >= 5){
//                plusDot = ".";
//            }
//            plusDot += ".";
//            status.setText("Waiting" + plusDot );
//            Thread.sleep(100);
//            status.setText("Waiting" + plusDot );
//            Thread.sleep(100);
//            status.setText("Waiting" + plusDot );
//            Thread.sleep(100);
//            status.setText("Waiting" + plusDot );
//            Thread.sleep(100);
//            status.setText("Waiting" + plusDot );
//            Thread.sleep(100);
//        }
//
//    }
}