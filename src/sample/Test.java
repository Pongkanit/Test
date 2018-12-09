package sample;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws Exception {

        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
//        Robot robot = new Robot();
//        try {
//            robot.mouseMove(800, 140);
//            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//            robot.delay(100);
//            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//            robot.delay(100);
//            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            Thread.sleep(200);
//            robot.keyPress(KeyEvent.VK_C);
//            Thread.sleep(200);
//            robot.keyRelease(KeyEvent.VK_C);
//            Thread.sleep(200);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//            Thread.sleep(200);
//            String data = (String) Toolkit.getDefaultToolkit()
//                    .getSystemClipboard().getData(DataFlavor.stringFlavor);
//            System.out.println(data);
//            NumberFormat format = NumberFormat.getInstance(Locale.US);
//            Number number = format.parse(data);
//            double money = number.doubleValue();
//            System.out.println(money);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
    }
    public static void ScreenCapture() throws AWTException, IOException {
        BufferedImage screencapture = new Robot().createScreenCapture(
                new Rectangle(1110,60, 253,32));
        File file = new File("screencapture.jpg");
        ImageIO.write(screencapture, "jpg", file);

    }

}
