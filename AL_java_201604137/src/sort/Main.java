package sort;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
        
		DoublyLinkedList list = null;
		String cnt = "";
		
		cnt = "100";
        System.out.println("============== "+cnt+"개 테스트 ===============");
    	
		list = FileReading.readFileForList(cnt);

        list.bubbleSort();
        list.insertionSort();
        list.selectionSort();
        

		cnt = "1000";
        System.out.println("============== "+cnt+"개 테스트 ===============");
    	
		list = FileReading.readFileForList(cnt);

        list.bubbleSort();
        list.insertionSort();
        list.selectionSort();

        
		cnt = "10000";
        System.out.println("============== "+cnt+"개 테스트 ===============");
    	
		list = FileReading.readFileForList(cnt);

        list.bubbleSort();
        list.insertionSort();
        list.selectionSort();
		
	}

}
