package sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FileReading {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:/algorithm/Al_02/test_100.txt"));
        while(true) {
            String line = br.readLine();
            if (line==null) break;
            //System.out.println(line);
        }
      
       
        br.close();
    }
}