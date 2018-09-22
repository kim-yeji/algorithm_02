package sort;
public class DoublyLinkedList {
    // ù��° ��带 ����Ű�� �ʵ�
    private Node head;
    private Node tail;
    private int size = 0;
 
    private class Node {
        // �����Ͱ� ����� �ʵ�
        private Object data;
        // ���� ��带 ����Ű�� �ʵ�
        private Node next;
        private Node prev;
 
        public Node(Object input) {
            this.data = input;
            this.next = null;
            this.prev = null;
        }
 
        // ����� ������ ���� ����ؼ� Ȯ���غ� �� �ִ� ���
        public String toString() {
            return String.valueOf(this.data);
        }
    }
 
    public void addFirst(Object input) {
        // ��带 �����մϴ�.
        Node newNode = new Node(input);
        // ���ο� ����� ���� ���� ��带 �����մϴ�.
        newNode.next = head;
        // ������ ��尡 �־��ٸ� ���� ����� ���� ���� ���ο� ��带 �����մϴ�.
        if (head != null)
            head.prev = newNode;
        // ���� ���ο� ��带 �����մϴ�.
        head = newNode;
        size++;
        if (head.next == null) {
            tail = head;
        }
    }
 
    public void addLast(Object input) {
        // ��带 �����մϴ�.
        Node newNode = new Node(input);
        // ����Ʈ�� ��尡 ���ٸ� ù��° ��带 �߰��ϴ� �޼ҵ带 ����մϴ�.
        if (size == 0) {
            addFirst(input);
        } else {
            // tail�� ���� ���� ������ ��带 �����մϴ�.
            tail.next = newNode;
            // ���ο� ����� ���� ���� tail�� �����մϴ�.
            newNode.prev = tail;
            // ������ ��带 �����մϴ�.
            tail = newNode;
            // ������Ʈ�� ������ 1 ���� ��ŵ�ϴ�.
            size++;
        }
    }
 
    Node getNode(int index) {
        // ����� �ε����� ��ü ��� ���� �ݺ��� ū�� ������ ���
        if (index < size / 2) {
            // head���� next�� �̿��ؼ� �ε����� �ش��ϴ� ��带 ã���ϴ�.
            Node x = head;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            // tail���� prev�� �̿��ؼ� �ε����� �ش��ϴ� ��带 ã���ϴ�.
            Node x = tail;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }
 
    public void add(int k, Object input) {
        // ���� k�� 0�̶�� ù��° ��忡 �߰��ϴ� ���̱� ������ addFirst�� ����մϴ�.
        if (k == 0) {
            addFirst(input);
        } else {
            Node temp1 = getNode(k - 1);
            // k ��° ��带 temp2�� �����մϴ�.
            Node temp2 = temp1.next;
            // ���ο� ��带 �����մϴ�.
            Node newNode = new Node(input);
            // temp1�� ���� ���� ���ο� ��带 �����մϴ�.
            temp1.next = newNode;
            // ���ο� ����� ���� ���� temp2�� �����մϴ�.
            newNode.next = temp2;
            // temp2�� ���� ���� ���ο� ��带 �����մϴ�.
            if (temp2 != null)
                temp2.prev = newNode;
            // ���ο� ����� ���� ���� temp1�� �����մϴ�.
            newNode.prev = temp1;
            size++;
            // ���ο� ����� ���� ��尡 ���ٸ� ���ο� ��尡 ������ ����̱� ������ tail�� �����մϴ�.
            if (newNode.next == null) {
                tail = newNode;
            }
        }
    }
 
    public void printNode() {
        // ��尡 ���ٸ� []�� �����մϴ�.
        if (head == null) {
            System.out.println("no data");
        }
        // Ž���� �����մϴ�.
        Node temp = head;
        // ���� ��尡 ���� ������ �ݺ����� �����մϴ�.
        // ������ ���� ���� ��尡 ���� ������ �Ʒ��� ������ ������ ���� ���ܵ˴ϴ�.
        int i = 1;
        while (temp.next != null) {
            System.out.println(i+".\t"+temp.data);
            temp = temp.next;
            i++;
        }
        // ������ ��带 ��°���� ���Խ�ŵ�ϴ�.
        System.out.println(i+".\t"+temp.data);
    }
 
    public Object removeFirst() {
        // ù��° ��带 temp�� �����ϰ� head�� ���� �ι�° ���� �����մϴ�.
        Node temp = head;
        head = temp.next;
        // �����͸� �����ϱ� ���� ������ ���� �ӽ� ������ ����ϴ�.
        Object returnData = temp.data;
        temp = null;
        // ����Ʈ ���� ��尡 �ִٸ� head�� ���� ��带 null�� �����մϴ�.
        if (head != null)
            head.prev = null;
        size--;
        return returnData;
    }
 
    public Object remove(int k) {
        if (k == 0)
            return removeFirst();
        // k-1��° ��带 temp�� �����մϴ�.
        Node temp = getNode(k - 1);
        // temp.next�� �����ϱ� ���� todoDeleted ������ �����մϴ�.
        Node todoDeleted = temp.next;
        // ���� ��� ��带 ���ῡ�� �и��մϴ�.
        temp.next = temp.next.next;
        if (temp.next != null) {
            // ������ ����� ���� ��带 �����մϴ�.
            temp.next.prev = temp;
        }
        // ������ ����� �����͸� �����ϱ� ���ؼ� returnData�� �����͸� �����մϴ�.
        Object returnData = todoDeleted.data;
        // ������ ��尡 tail�̾��ٸ� tail�� ���� ��带 tail�� �����մϴ�.
        if (todoDeleted == tail) {
            tail = temp;
        }
        // cur.next�� ���� �մϴ�.
        todoDeleted = null;
        size--;
        return returnData;
    }
 
    public Object removeLast() {
        return remove(size - 1);
    }
 
    public int size() {
        return size;
    }
 
    public Object get(int k) {
        Node temp = getNode(k);
        return temp.data;
    }
 
    public int indexOf(Object data) {
        // Ž�� ����� �Ǵ� ��带 temp�� �����մϴ�.
        Node temp = head;
        // Ž�� ����� ���° ������Ʈ�� �ִ����� �ǹ��ϴ� ������ index�� ����մϴ�.
        int index = 0;
        // Ž�� ���� Ž�� ����� ���� ���մϴ�.
        while (temp.data != data) {
            temp = temp.next;
            index++;
            // temp�� ���� null�̶�� ���� �� �̻� Ž�� ����� ���ٴ� ���� �ǹ��մϴ�.�� �� -1�� �����մϴ�.
            if (temp == null)
                return -1;
        }
        // Ž�� ����� ã�Ҵٸ� ����� �ε��� ���� �����մϴ�.
        return index;
    }
 
    // �ݺ��ڸ� �����ؼ� �������ݴϴ�.
    public ListIterator listIterator() {
        return new ListIterator();
    }
 
    public class ListIterator {
        private Node lastReturned;
        private Node next;
        private int nextIndex;
 
        ListIterator() {
            next = head;
            nextIndex = 0;
        }
 
        // �� �޼ҵ带 ȣ���ϸ� cursor�� �������� ���� cursor.next�� ����˴ϴ�.
        public Object next() {
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.data;
        }
 
        // cursor�� ���� ���ٸ� �ٽ� ���ؼ� �� �̻� next�� ���ؼ� ������ ��尡 ���ٸ� false�� �����մϴ�.
        // �̸� ���ؼ� next�� ȣ���ص� �Ǵ����� ������ �Ǵ��� �� �ֽ��ϴ�.
        public boolean hasNext() {
            return nextIndex < size();
        }
 
        public boolean hasPrevious() {
            return nextIndex > 0;
        }
 
        public Object previous() {
            if (next == null) {
                lastReturned = next = tail;
            } else {
                lastReturned = next = next.prev;
            }
            nextIndex--;
            return lastReturned.data;
        }
 
        public void add(Object input) {
            Node newNode = new Node(input);
            if (lastReturned == null) {
                head = newNode;
                newNode.next = next;
            } else {
                lastReturned.next = newNode;
                newNode.prev = lastReturned;
                if (next != null) {
                    newNode.next = next;
                    next.prev = newNode;
                } else {
                    tail = newNode;
                }
            }
            lastReturned = newNode;
            nextIndex++;
            size++;
        }
 
        public void remove() {
            if (nextIndex == 0) {
                throw new IllegalStateException();
            }
            Node n = lastReturned.next;
            Node p = lastReturned.prev;
 
            if (p == null) {
                head = n;
                head.prev = null;
                lastReturned = null;
            } else {
                p.next = next;
                lastReturned.prev = null;
            }
 
            if (n == null) {
                tail = p;
                tail.next = null;
            } else {
                n.prev = p;
            }
 
            if (next == null) {
                lastReturned = tail;
            } else {
                lastReturned = next.prev;
            }
 
            size--;
            nextIndex--;
 
        }
    }
    
    public void bubbleSort(){
    	long start = System.currentTimeMillis();
    	
    	Node temp = null;
		for (int i = 0; i < size; i++) {
			for (int j = 1; j < size - i; j++) {
				if ((int)getNode(j - 1).data > (int)getNode(j).data) {
					temp = getNode(j);
					remove(j);
					add(j-1, temp.data);
				}
			}
			
			if(i%100 == 0){
				System.out.println("b: "+i);
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println("�������� �����ð�: "+(end-start)/1000.0);
    }
    
    public void insertionSort(){
    	long start = System.currentTimeMillis();
    	
    	for (int i = 1; i < size; i++) {
			int temp = (int)getNode(i).data;
			int aux = i - 1;

			while ((aux >= 0) && ((int)getNode(aux).data > temp)) {
				remove(aux + 1);
				add(aux + 1, getNode(aux).data);
				aux--;
			}
			remove(aux + 1);
			add(aux + 1, temp);

			if(i%100 == 0){
				System.out.println("i: "+i);
			}
		}
    	
		long end = System.currentTimeMillis();
		System.out.println("�������� �����ð�: "+(end-start)/1000.0);
    }
    
    public void selectionSort(){
    	long start = System.currentTimeMillis();
    	
		int minIdx; // �ּҰ��� ���� �������� �ε��� ���� ����
		int temp;

		for (int i = 0; i < size - 1; i++) { // size-1 : ������ ��Ҵ� �ڿ������� ���ĵ�
			minIdx = i;
			for (int j = i + 1; j < size; j++) { 
				if ((int)getNode(minIdx).data > (int)getNode(j).data) {
					minIdx = j;
				}
			}
			temp = (int)getNode(minIdx).data;
			remove(minIdx);
			add(minIdx, getNode(i).data);
			
			remove(i);
			add(i, temp);

			if(i%100 == 0){
				System.out.println("s: "+i);
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println("�������� �����ð�: "+(end-start)/1000.0);
    }
 
}