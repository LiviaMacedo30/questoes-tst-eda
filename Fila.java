import java.util.NoSuchElementException;
import java.util.Scanner;

public class Fila {

    private int head;
    private int tail;
    private int size;
    private int[] fila;


    public Fila(int capacidade) {
        this.head = -1;
        this.tail = -1;
        this.size = 0;
        this.fila = new int[capacidade];
    }

    public void addLeast(int valor){
        if(isFull()){
            System.out.println("full");
            return;
        }
        if(isEmpty()){
            this.head = 0;
        }
        this.tail = (this.tail+1)%this.fila.length;
        fila[this.tail] = valor;
        size++;
    }
    public void removeFirst(){
        if(isEmpty()){
            System.out.println("empty");
            return;
        }
        if(this.head == this.tail){
            this.head = -1;
            this.tail = -1;
        }else{
            this.head = (this.head+1)%this.fila.length;
        }
        this.size --;


    }
    public int element(){
        return fila[head];
    }

    public String print(){
        if(isEmpty()){
            return "empty";
        }
        StringBuilder out = new StringBuilder();
        int i = head;
        for(int count = 0; count < size; count++){
            out.append(fila[i]).append(" ");
            i = (i+1)%fila.length;
        }
        return out.toString().trim();
    }

    public boolean isEmpty(){
        return this.head == -1 && this.tail == -1;
    }

    public boolean isFull(){
        return (this.tail + 1) % this.fila.length == this.head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacidade = sc.nextInt();
        Fila fila = new Fila(capacidade);  // Create a new Fila instance
        sc.nextLine();  // Consume the newline character after the integer input
        String[] entrada = sc.nextLine().split(" ");
        if (entrada[0].equals("print")){
            System.out.println(fila.print());
        }
        else if(entrada[0].equals("remove")){
            fila.removeFirst();
        } else if (entrada[0].equals("element")) {
            System.out.println(fila.element());
        } else if (entrada[0].equals("add")) {
            fila.addLeast(Integer.parseInt(entrada[1]));
        }
        while(!entrada[0].equals("end")){
            entrada = sc.nextLine().split(" ");
            if (entrada[0].equals("print")){
                System.out.println(fila.print());
            }
            else if(entrada[0].equals("remove")){
                fila.removeFirst();
            } else if (entrada[0].equals("element")) {
                System.out.println(fila.element());
            } else if (entrada[0].equals("add")) {
                fila.addLeast(Integer.parseInt(entrada[1]));
            }
        }

    }





}
