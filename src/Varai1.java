//Переписать в результирующий файл слова, начинающиеся с гласных букв.

import java.io.*;
import java.util.Scanner;

public class Varai1 {

    public static boolean check(String word){
        String gl = "ауоиэыяюеёАУОИЭЫЯЮЕЁ";
        char firstChar = word.charAt(0);
        for (int i = 0; i < gl.length(); i++) {
            if (firstChar == gl.charAt(i)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        InputStream in = null;
        Reader file = null;
        BufferedReader buf = null;

        OutputStream out = null;
        Writer wr = null;
        try {
            in = new FileInputStream("/Users/riceghost/Documents/java/in.txt");
            file = new InputStreamReader(in, "utf-8");
            buf = new BufferedReader(file);

            File f2 = new File("/Users/riceghost/Documents/java/out.txt");
            f2.createNewFile();
            out = new FileOutputStream(f2);
            wr = new OutputStreamWriter(out, "utf-8");
            if(f2.exists()){
                String line = " ";
                String [] words;
                while ((line = buf.readLine())!=null){
                    words = line.split(" ");
                    for (int i = 0; i < words.length; i++) {
                        if (check(words[i])){
                            wr.append(words[i] + " ");
                            System.out.println(words[i] + " ");
                        }
                    }
                    wr.append("\n");
                    System.out.println();
                }
            }
        } catch (IOException io){
            io.printStackTrace();
        } finally {
            in.close();
            file.close();
            buf.close();
            out.close();
            wr.flush();
            wr.close();
        }
    }
}
