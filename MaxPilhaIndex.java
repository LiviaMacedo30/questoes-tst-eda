import java.util.Scanner;

public class MaxPilhaIndex {
    private int topo;
    private int[] pilha;
    private int size;

    public MaxPilhaIndex(int capacidade) {
        this.topo = -1;
        this.size = 0;
        this.pilha = new int[capacidade];
    }
    public void push(int i) {
        this.pilha[++topo] = i;
        size++;
    }
    public int pop(){
        size--;
        return this.pilha[topo--];
    }
    public int peek(){
        return this.pilha[topo];
    }
    public boolean isEmpty(){
        return this.topo == -1;
    }
    public int getSize(){
        return this.size;
    }
    public static int maxElemento(MaxPilhaIndex pilha, int index){
        int cont = 0;
        int max = pilha.peek();
        MaxPilhaIndex pilhaAux = new MaxPilhaIndex(pilha.getSize());
        while (cont <= index){
            int valor = pilha.pop();
            if(valor > max){
                max = valor;
            }
            pilhaAux.push(valor);
            cont++;
        }
        while (!pilhaAux.isEmpty()){
            pilha.push(pilhaAux.pop());
        }
        return max;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" "); // elementos a serem adicionados na pilha
        MaxPilhaIndex pilha = new MaxPilhaIndex(entrada.length);
        for(int i =0; i < entrada.length; i ++){
            pilha.push(Integer.parseInt(entrada[i]));
        }
        int indexLimite = sc.nextInt();
        System.out.println(maxElemento(pilha, indexLimite));

    }


}
