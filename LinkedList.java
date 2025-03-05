import java.util.Scanner;

public class LinkedList {
    private Node1 head;
    private Node1 tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public boolean isEmpty(){
        return this.head == null && this.tail == null;
    }
    public  void addLast(int value){
        Node1 newNode = new Node1(value);
        if(isEmpty()){
            this.head = newNode;
            this.tail = newNode;
        }else {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
        size++;
    }
    public void trocaVizinhos(int index){
        Node1 primeiro = this.head;
        for (int i = 0; i < index; i ++){
            primeiro = primeiro.next;
        }
        Node1 segundo = primeiro.next;
        if(primeiro.prev != null){
            primeiro.prev.next = segundo;
        }else{
            head = segundo;
        }
        if (segundo.next != null){
            segundo.next.prev = primeiro;
        }else {
            tail = primeiro;
        }

        primeiro.next = segundo.next;
        segundo.prev = primeiro.prev;
        primeiro.prev = segundo;
        segundo.next = primeiro;

    }

    public String printList(){
        Node1 aux = this.head;
        StringBuilder sb = new StringBuilder();
        while (aux!= null){
            sb.append(aux.value).append(" ");
            aux = aux.next;
        }
        return sb.toString().trim();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int index = sc.nextInt(); // inteiro representando o índice i do elemento a ser trocado
        sc.nextLine();
        LinkedList list = new LinkedList();
        for (int i =0; i < entrada.length; i++){
            list.addLast(Integer.parseInt(entrada[i]));
        }
        list.trocaVizinhos(index);
        System.out.println(list.printList());
    }


}

class Node1{
    int value;
    Node1 prev;
    Node1 next;

    public Node1(int value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}