import java.util.Scanner;

public class MaxPilha {
    private int topo;
    private int[] pilha;
    private int size;

    public MaxPilha(int capacidade) {
        this.topo = -1;
        this.pilha = new int[capacidade];
        this.size = 0;
    }

    public void push(int valor){
        this.pilha[++topo] = valor;
        size++;
    }
    public int pop(){
        size --;
        return this.pilha[topo--];
    }

    public int getCapacidade() {
        return this.size;
    }
    public int peek() {
        return this.pilha[topo];
    }
    public boolean isEmpty(){
        return this.topo == -1;
    }
    public static int encontraMax(MaxPilha pilha){
        MaxPilha pilhaAux = new MaxPilha(pilha.getCapacidade());
        int max = pilha.peek();
        for (int i =0; i <= pilha.getCapacidade();i++){
            int valor = pilha.pop();
            if(valor > max){
                max = valor;
            }
            pilhaAux.push(valor);
        }
        while (!pilhaAux.isEmpty()){
            int valor = pilhaAux.pop();
            pilha.push(valor);
        }
        return max;
    }



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        MaxPilha pilha = new MaxPilha(entrada.length);
        for (int i =0; i < entrada.length; i++){
            pilha.push(Integer.parseInt(entrada[i]));
        }
        System.out.println(encontraMax(pilha));

    }
}
