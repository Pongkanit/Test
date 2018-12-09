package sample;
import java.io.PrintWriter;
public class Reader {

    public static void main(String[] args) {
        String input_file="C:\\Users\\PonPonU\\Desktop\\Java Test\\Clicker2\\screencapture.jpg";
        String output_file="C:\\Users\\PonPonU\\Desktop\\Java Test\\Clicker2\\1";
        String tesseract_install_path="C:\\Program Files (x86)\\Tesseract-OCR\\tesseract";
        String[] command =
                {
                        "cmd",
                };
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            new Thread(new SyncPipe(p.getErrorStream(), System.err)).start();
            new Thread(new SyncPipe(p.getInputStream(), System.out)).start();
            PrintWriter stdin = new PrintWriter(p.getOutputStream());
            stdin.println("\""+tesseract_install_path+"\" \""+input_file+"\" \""+output_file+"\" -l eng");
            stdin.close();
            p.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}