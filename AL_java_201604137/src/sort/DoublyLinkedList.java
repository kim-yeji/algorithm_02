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
    
    // index위치에서 얻은 노드의 데이터를 반환한다.
    public Object get(int index){
        return getNode(index).data;
    }
    
    // 첫번째 노드를 반환한다.
    public Object getFirst(){
        return get(0);
    }

    
    private Node getNode(int index){
        
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index : "+index+", Size : " + size);
        }
        
        Node node = header;
        
        // index 가 리스트 size의 중간 앞이면 순차적으로 탐색한다.
        if(index < (size/2)){
            
            for(int i =0; i<=index; i++){
                node = node.nextNode;
            }
            
        }else{
            // index가 리스트 size의 중간보다 뒤면 뒤에서부터 탐색한다.
            for(int i = size; i > index; i--){
                node = node.previousNode;
        
            }
        }
        
        return node;
    }
    
    // obj 데이터와 같은 노드의 위치를 반환한다.
    private int getNodeIndex(Object obj){
        
        if(size<=0){
            return -1;
        }
        
        int index =0;
        // 첫번째 노드를 가져온다.
        Node node = header.nextNode;
        Object nodeDate = node.data;
        
        // 첫번째 노드부터 같은 데이터를 가진 노드를 탐색한다.
        while(!obj.equals(nodeDate)){
            
            node = node.nextNode;
            
            if(node==null){
                return -1;
            }
            
            nodeDate = node.data;
            index++;
        }
        
        // 위치를 반환한다.
        return index;
    }
    
    // 리스트의 첫번째에 데이터를 삽입한다.
    public void addFirst(Object data){
        
        // 데이터를 담은 새로운 노드 생성
        Node newNode = new Node(data);    
        
        // 새로운 노드가 다음 노드로 첫번째 노드를 가리킨다.
        newNode.nextNode = header.nextNode;    
        
        // 리스트가 비어있지 않으면
        if(header.nextNode != null){
            
            // 첫 노드가 자신의 앞 노드로 새로운 노드를 가리킨다..
            header.nextNode.previousNode = newNode;
        
        }else{    // 리스트가 비어있으면
            
            // 헤더가 마지막 노드를 새로운 노드로 가리키도록 한다.
            header.previousNode = newNode;
        
        }
        
        // 헤더가 첫번째 노드로 새로운 노드를 가리키도록 한다.
        header.nextNode = newNode;
        size++;
    }
    
    public void add(int index, Object data){
        
        // index가 0 이면 addFirst() 함수를 호출한다.
        if(index ==0){
            
            addFirst(data);
            return;
        }
        
        // 삽입할 index 위치의 앞 노드를 가져온다.
        Node previous = getNode(index-1);
        
        // 삽입할 index의 위치의 다음 노드를 가져온다.
        Node next = previous.nextNode;
        
        // data로 새로운 노드 생성
        Node newNode = new Node(data);
        
        // 앞노드가 새로운 노드를 다음노드로 가리킨다.
        previous.nextNode = newNode;
        
        // 새로운 노드가 앞노드를 이전노드로 가리킨다.
        newNode.previousNode = previous;
        
        //새로운 노드의 다음 노드에 다음노드를 지정한다.
        newNode.nextNode = next;
        
        // 삽입 위치가 마지막 위치가 아니면
        if(newNode.nextNode != null){
            
            // 다음 노드가 새로운 노드를 앞노드로 지정한다.
            next.previousNode = newNode;
        
        }else{ // 삽입 위치가 마지막 이면
            
            // 헤더가 가리키는 마지막 노드가 새로운 노드가 된다..
            header.previousNode = newNode;
        }
        
        size++;
    }
    
    // 마지막 노드를 반환한다.
    public void addLast(Object data){
        add(size, data);
    }
    
    //data를 마지막에 넣는다.
    public void add(Object data){
        addLast(data);
    }

}