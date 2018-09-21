package sort;

public class Sorting {

	public void insertionSort(int[] data) {
		for(int index=1;index<data.length;index++) {
			int temp = data[index];
			int aux = index-1;
			
			while((aux>=0)&&(data[aux]>temp)) {
				data[aux+1]=data[aux];
				aux--;
			}
			data[aux+1]=temp;
		}
	}
	
	public void bubbleSort(int[] arr) {
		 int size = arr.length;
		int temp=0;
		for(int i=0;i<size;i++) {
			for(int j=1;j<size-i;j++) {
				if(arr[j]<arr[j-1]) {
					temp = arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
	
	   public void selectionSort(int[] data){
	        int size = data.length;
	        int min; //최소값을 가진 데이터의 인덱스 저장 변수
	        int temp;
	        
	        for(int i=0; i<size-1; i++){ // size-1 : 마지막 요소는 자연스럽게 정렬됨
	            min = i;
	            for(int j=i+1; j<size; j++){
	                if(data[min] > data[j]){
	                    min = j;
	                }
	            }
	            temp = data[min];
	            data[min] = data[i];
	            data[i] = temp;
	        }
	    }


}
