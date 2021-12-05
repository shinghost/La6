import java.io.*;
import java.io.IOException;

public class Primer {
    public static void main(String[] args) throws IOException {
        FileReader in = null;
        FileWriter out = null;
        try {
            in = new FileReader("E:\\MyFile1.txt");
            out= new FileWriter("E:\\MyFile2.txt", true);

            int oneByte;
            while ((oneByte = in.read()) != -1) {
                out.write((char)oneByte);
                out.append((char)oneByte);
                System.out.print((char)oneByte);
            }
    } catch (IOException e) {
            System.out.println("Ошибка!!!! ");
    }
        finally{
            in.close();
            out.close();
        }
    }
}
