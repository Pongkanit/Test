package sample;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class AutoClicker {
    private Robot robot;
    public static double money = 0;
    private static int falseTimes = 1;
    private String log = "";
    private static int counter = 0;
    public static double winCount = 0;
    private String dateToday;
    public AutoClicker() {
        try {
            System.out.println("what is just happen?");
            robot = new Robot();
        } catch (Exception e) {
            e.printStackTrace();
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        dateToday = dateFormat.format(date);
    }

    public void clickMouse(){
        if (isBetAble()) {
            System.out.println();
            System.out.println(money);
            counter++;
            double current = balance();
            if (falseTimes >= 16) {
                falseTimes = 1;
            } else {
                if (money > current) {
                    falseTimes*= 2 ;
                    log = dateToday + "," + counter + ",Lose " + current + "\r\n";
                } else if (money < current) {
                    falseTimes = 1;
                    log = dateToday + "," + counter + ",Win " + current + "\r\n";
                    winCount++;
                } else {
                    log = dateToday+ ","  + counter + ",Tie  " + current + "\r\n";
                }
            }
            System.out.println(falseTimes);
            if(winCount == 10) return ;
            try {
                money = current;
                int betIt = (int) (Math.random() * 2);
                robot.delay(300);
                switch (betIt) {
                    case 0:
                        for (int i = 1; i <= falseTimes; i++) {
                            robot.mouseMove(1321, 453 );
                            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                            robot.delay(150);
                            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                            robot.delay(300);
                        }
                        break;
                    case 1:
                        for (int i = 1; i <= falseTimes; i++) {
                            robot.mouseMove(1554, 441);
                            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                            robot.delay(150);
                            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                            robot.delay(300);
                        }
                        break;
                }
                robot.delay(150);
                robot.mouseMove(1663, 503);
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.delay(150);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
                robot.delay(15000);
                logWrite(log);
            } catch (Exception e) {
                e.printStackTrace();
            }
//            return 1;
        }
//        return -1;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public boolean isBetAble() {
        try {
            Rectangle rec = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage img = robot.createScreenCapture(rec);
            Color color = new Color(img.getRGB(1502, 461));
            if (color.getGreen() == 133) {
                return true;
            }
            return false;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public static void logWrite(String log) throws Exception {
        try(FileWriter locFile = new FileWriter("log.txt",true)){
            locFile.write(log);
        }
    }
    public static void ScreenCapture() throws AWTException, IOException {
        BufferedImage screencapture = new Robot().createScreenCapture(new Rectangle(1110,60, 253,32));
        File file = new File("screencapture.jpg");
        ImageIO.write(screencapture, "jpg", file);
    }

    public double balance(){
        double balance = -1;
        try {
            robot.mouseMove(718, 131);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(100);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(400);
            robot.mouseMove(800, 140);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(100);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.delay(100);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.keyPress(KeyEvent.VK_CONTROL);
            Thread.sleep(200);
            robot.keyPress(KeyEvent.VK_C);
            Thread.sleep(200);
            robot.keyRelease(KeyEvent.VK_C);
            Thread.sleep(200);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(200);
            String data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
            System.out.println(data);
            NumberFormat format = NumberFormat.getInstance(Locale.US);
            Number number = format.parse(data);
            balance = number.doubleValue();
        } catch (Exception e){
            e.printStackTrace();
        }
        return balance;
    }
}
