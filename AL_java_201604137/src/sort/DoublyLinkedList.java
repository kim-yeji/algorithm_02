package sort;

public class DoublyLinkedList {
    
    private Node header;
    private int size;
    public DoublyLinkedList(){
        header = new Node(null);
        size=0;
    }
    
    
    private  class Node{
        
        private Object data;
        private Node previousNode;
        private Node nextNode;
        
        Node(Object data){
            
            this.data = data;
            this.previousNode = null;
            this.nextNode = null;
            
        }
    }
    
    // index��ġ���� ���� ����� �����͸� ��ȯ�Ѵ�.
    public Object get(int index){
        return getNode(index).data;
    }
    
    // ù��° ��带 ��ȯ�Ѵ�.
    public Object getFirst(){
        return get(0);
    }

    
    private Node getNode(int index){
        
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index : "+index+", Size : " + size);
        }
        
        Node node = header;
        
        // index �� ����Ʈ size�� �߰� ���̸� ���������� Ž���Ѵ�.
        if(index < (size/2)){
            
            for(int i =0; i<=index; i++){
                node = node.nextNode;
            }
            
        }else{
            // index�� ����Ʈ size�� �߰����� �ڸ� �ڿ������� Ž���Ѵ�.
            for(int i = size; i > index; i--){
                node = node.previousNode;
        
            }
        }
        
        return node;
    }
    
    // obj �����Ϳ� ���� ����� ��ġ�� ��ȯ�Ѵ�.
    private int getNodeIndex(Object obj){
        
        if(size<=0){
            return -1;
        }
        
        int index =0;
        // ù��° ��带 �����´�.
        Node node = header.nextNode;
        Object nodeDate = node.data;
        
        // ù��° ������ ���� �����͸� ���� ��带 Ž���Ѵ�.
        while(!obj.equals(nodeDate)){
            
            node = node.nextNode;
            
            if(node==null){
                return -1;
            }
            
            nodeDate = node.data;
            index++;
        }
        
        // ��ġ�� ��ȯ�Ѵ�.
        return index;
    }
    
    // ����Ʈ�� ù��°�� �����͸� �����Ѵ�.
    public void addFirst(Object data){
        
        // �����͸� ���� ���ο� ��� ����
        Node newNode = new Node(data);    
        
        // ���ο� ��尡 ���� ���� ù��° ��带 ����Ų��.
        newNode.nextNode = header.nextNode;    
        
        // ����Ʈ�� ������� ������
        if(header.nextNode != null){
            
            // ù ��尡 �ڽ��� �� ���� ���ο� ��带 ����Ų��..
            header.nextNode.previousNode = newNode;
        
        }else{    // ����Ʈ�� ���������
            
            // ����� ������ ��带 ���ο� ���� ����Ű���� �Ѵ�.
            header.previousNode = newNode;
        
        }
        
        // ����� ù��° ���� ���ο� ��带 ����Ű���� �Ѵ�.
        header.nextNode = newNode;
        size++;
    }
    
    public void add(int index, Object data){
        
        // index�� 0 �̸� addFirst() �Լ��� ȣ���Ѵ�.
        if(index ==0){
            
            addFirst(data);
            return;
        }
        
        // ������ index ��ġ�� �� ��带 �����´�.
        Node previous = getNode(index-1);
        
        // ������ index�� ��ġ�� ���� ��带 �����´�.
        Node next = previous.nextNode;
        
        // data�� ���ο� ��� ����
        Node newNode = new Node(data);
        
        // �ճ�尡 ���ο� ��带 �������� ����Ų��.
        previous.nextNode = newNode;
        
        // ���ο� ��尡 �ճ�带 �������� ����Ų��.
        newNode.previousNode = previous;
        
        //���ο� ����� ���� ��忡 ������带 �����Ѵ�.
        newNode.nextNode = next;
        
        // ���� ��ġ�� ������ ��ġ�� �ƴϸ�
        if(newNode.nextNode != null){
            
            // ���� ��尡 ���ο� ��带 �ճ��� �����Ѵ�.
            next.previousNode = newNode;
        
        }else{ // ���� ��ġ�� ������ �̸�
            
            // ����� ����Ű�� ������ ��尡 ���ο� ��尡 �ȴ�..
            header.previousNode = newNode;
        }
        
        size++;
    }
    
    // ������ ��带 ��ȯ�Ѵ�.
    public void addLast(Object data){
        add(size, data);
    }
    
    //data�� �������� �ִ´�.
    public void add(Object data){
        addLast(data);
    }

}