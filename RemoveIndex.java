import java.util.Scanner;

public class RemoveIndex {
    private Node head;
    private Node tail;
    private int size;

    public RemoveIndex() {
        this.head = null;
        this.tail = null;
        this.size = 0;

    }
    public boolean isEmpty(){
        return this.head == null;
    }
    public void addLast(int value){
        Node newNode = new Node(value);
        if (isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        }else {
            this.tail.next = newNode;
            newNode.prev = tail;
            this.tail = newNode;
        }
        size++;
    }
    public void removeFirst(){
        if (this.head.next == null){
            this.head = null;
            this.tail = null;
        }else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        size--;
    }

    public void removeLast(){
        if (this.head.next == null) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        size--;
    }
    public void remove(int index){
        Node aux = this.head;
        for (int i =0; i <= index; i++ ){
            if(i == index){
                if(i == 0){
                    removeFirst();;
                } else if (i == size -1) {
                    removeLast();
                }else {
                    aux.prev.next = aux.next;
                    aux.next.prev = aux.prev;
                    size--;
                }
            }
            aux = aux.next;
        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node aux = this.head;

        while (aux != null){
            sb.append(aux.value).append(" ");
            aux = aux.next;
        }
        return sb.toString().trim();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        RemoveIndex linkedList = new RemoveIndex();
        for (int i =0; i<entrada.length;i++){
            linkedList.addLast(Integer.parseInt(entrada[i]));
        }
        int index = sc.nextInt();
        sc.nextLine();
        linkedList.remove(index);
        System.out.println(linkedList.toString());

    }

}
class Node3{
    int value;
    Node3 next;
    Node3 prev;

    public Node3(int value) {
        this.next = null;
        this.prev = null;
        this.value = value;
    }
}