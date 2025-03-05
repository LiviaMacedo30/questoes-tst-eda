import java.util.Scanner;

public class TrimLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public TrimLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public boolean isEmpty(){
        return this.head == null;
    }
    public void addLast(int value){
        Node newNode = new Node(value);
        if(isEmpty()){
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
        if (this.head.next == null){
            this.head = null;
            this.tail = null;
        }else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        size--;
    }

    public void removeExtremos(int qtdExtremos){
        int cont = 0;
        while (cont < qtdExtremos && size > 1){
            removeFirst();
            if (!isEmpty()) removeLast();
            cont++;
        }
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node aux = this.head;
        while (aux != null){
            sb.append(aux.value).append(" ");
            aux =aux.next;
        }
        if (sb.isEmpty()){
            return "vazia";
        }else {
            return sb.toString().trim();
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        TrimLinkedList linkedList = new TrimLinkedList();
        for (int i = 0; i < entrada.length;i++){
            linkedList.addLast(Integer.parseInt(entrada[i]));
        }
        // representando a quantidade de extremos que deve ser removida da lista.
        int qtdExtremos = sc.nextInt();
        sc.nextLine();
        linkedList.removeExtremos(qtdExtremos);
        System.out.println(linkedList.toString());

    }


}

class Node{
    Node next;
    Node prev;
    int value;

    public Node(int value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
