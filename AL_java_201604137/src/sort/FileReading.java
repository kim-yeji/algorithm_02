package sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FileReading {
	
    public static DoublyLinkedList readFileForList(String cnt) throws IOException {
        DoublyLinkedList list = new DoublyLinkedList();
		BufferedReader br = new BufferedReader(new FileReader("E:\\yac_work\\_data\\test_"+cnt+".txt"));
		
		int i = 0;
        while(true) {
            String line = br.readLine();
            if (line==null) {
            	break;
            } else {
                list.add(i, Integer.parseInt(line));
            }
            i++;
        }
        
        br.close();
        
        return list;
    }
}