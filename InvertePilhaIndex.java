import java.util.Scanner;

public class InvertePilhaIndex {
    private int  topo;
    private int[] pilha;

    public InvertePilhaIndex(int capacidade) {
        this.topo = -1;
        this.pilha = new int[capacidade];
    }

    public void push(int valor){
        this.pilha[++topo] = valor;
    }
    public int pop(){
        return this.pilha[topo--];
    }

    public boolean isEmpty(){
        return topo == -1;
    }
    public static void invertePilha(int index, InvertePilhaIndex pilha, int tam){
        InvertePilhaIndex pilhaAux = new InvertePilhaIndex(tam);
        InvertePilhaIndex pilhaAux2 = new InvertePilhaIndex(tam);
        int cont = 0;
        while (cont <= index){
            int valor = pilha.pop();
            pilhaAux.push(valor);
            cont++;
        }
        while (!pilhaAux.isEmpty()){
            int valor = pilhaAux.pop();
            pilhaAux2.push(valor);
        }
        while (!pilhaAux2.isEmpty()){
            int valor = pilhaAux2.pop();
            pilha.push(valor);
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tamanho = sc.nextInt();
        sc.nextLine(); // serve para consumir a quebra de linha após o número.
        String[] entrada = sc.nextLine().split(" ");
        int index = sc.nextInt();
        InvertePilhaIndex pilha = new InvertePilhaIndex(tamanho);
        for(int i = 0; i < tamanho; i ++){
            pilha.push(Integer.parseInt(entrada[i]));
        }
        invertePilha(index, pilha,tamanho);
        System.out.println("-");
        while (!pilha.isEmpty()){
            System.out.println(pilha.pop());
        }

    }
}
