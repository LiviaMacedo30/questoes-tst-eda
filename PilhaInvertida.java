import java.util.Scanner;

public class PilhaInvertida {
    private int topo;
    private int[] pilha;
    private int[] fila;
    private int head;
    private int tail;

    public PilhaInvertida(int capacidade) {
        this.topo = -1;
        this.pilha = new int[capacidade];
        this.fila = new int[capacidade];
        this.head = -1;
        this.tail = -1;
    }

    public void add(int valor){
        if(isEmptyFila()){
            this.head = 0;
        }
        this.tail = (this.tail+1)%this.fila.length;
        fila[this.tail] = valor;
    }

    public int remove(){
        int valor = fila[head];
        if(this.head == this.tail){
            this.head = -1;
            this.tail = -1;
        }else{
            this.head = (this.head+1)%this.fila.length; // // Move o head para o próximo elemento
        }
        return valor;
    }

    public boolean isEmptyPilha(){
        return topo == -1;
    }
    public boolean isEmptyFila(){
        return head == -1 && tail == -1;
    }
    public int pop(){
        return this.pilha[topo--];
    }
    public void push(int valor){
        this.pilha[++topo] = valor;
    }
    public int getCapacidade() {
        return this.pilha.length;
    }

    public static void invertePilha(PilhaInvertida pilha){
        PilhaInvertida fila = new PilhaInvertida(pilha.getCapacidade());
         while (!pilha.isEmptyPilha()){
             int valor = pilha.pop();
             fila.add(valor);
         }

         while (!fila.isEmptyFila()){
             int valor = fila.remove();
             pilha.push(valor);
         }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tam = sc.nextInt();
        sc.nextLine();
        String[] entrada = sc.nextLine().split(" ");
        PilhaInvertida pilha = new PilhaInvertida(tam);
        for (int i = 0; i < entrada.length; i++) {
            pilha.push(Integer.parseInt(entrada[i]));
        }

        invertePilha(pilha);
        while (!pilha.isEmptyPilha()) {
            System.out.println(pilha.pop());

        }
    }
}
