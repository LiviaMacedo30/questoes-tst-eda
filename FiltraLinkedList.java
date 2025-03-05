import java.util.Scanner;

public class FiltraLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public FiltraLinkedList() {
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
        if(this.head.next == null){
            this.head = null;
            this.tail = null;
        }else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        size--;
    }

    public void removeLast(){
        if(this.head.next == null){
            this.head = null;
            this.tail = null;
        }else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        size--;
    }
    public void remove(int value){
        Node aux = this.head;
        while (aux != null){
            Node nextNode = aux.next;
            if(aux.value == value){
                if(aux == this.head){
                    removeFirst();
                } else if (aux == this.tail) {
                    removeLast();
                }else {
                    aux.prev.next = aux.next;
                    aux.next.prev = aux.prev;
                    size--;
                }
            }
            aux = nextNode;
        }
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node aux = this.head;
        while (aux!=null){
            sb.append(aux.value).append(" ");
            aux = aux.next;
        }
        if(sb.toString().equals("")){
            return "vazia";
        }else {
            return sb.toString().trim();
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        FiltraLinkedList linkedList = new FiltraLinkedList();
        for (int i = 0; i < entrada.length; i++){
            linkedList.addLast(Integer.parseInt(entrada[i]));
        }
        int valor = sc.nextInt();
        sc.nextLine();
        linkedList.remove(valor);
        System.out.println(linkedList.toString());
    }
}


class Node2{
    int value;
    Node2 prev;
    Node2 next;

    public Node2(int value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}