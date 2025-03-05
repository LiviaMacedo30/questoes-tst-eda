import java.util.Scanner;

public class ElementPilha {
    private int topo;
    private int[] pilha;

    public ElementPilha(int capacidade) {
        this.topo = -1;
        this.pilha = new int[capacidade];
    }

    public void push(int valor){
        this.pilha[++topo] = valor;
    }

    public int pop(){
        return this.pilha[topo--];
    }
    public int qtdElementos(){
        return this.topo+ 1;
    }
    public boolean isEmpty(){
        return topo == -1;
    }

    public static int encontraElemento(int index, ElementPilha pilha){

        ElementPilha pilhaAux = new ElementPilha(pilha.qtdElementos());
        int cont = -1;
        int valorEncontrado = -1;
        while(cont != index) {
            int valor = pilha.pop();
            pilhaAux.push(valor);
            cont++;
            if (cont == index) {
                valorEncontrado = valor;
            }
        }
        // Restaurando a configuração inicial da pilha
        while (!pilhaAux.isEmpty()) {
            pilha.push(pilhaAux.pop());
        }
        return valorEncontrado;

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] seq = new int[entrada.length];
        ElementPilha pilha = new ElementPilha(entrada.length);
        for(int i = 0; i < entrada.length; i++){
            pilha.push(Integer.parseInt(entrada[i]));
        }
        int index = sc.nextInt();
        if(index > pilha.qtdElementos() -1 ){
            System.out.println("indice invalido");
        }else{
            System.out.println(encontraElemento(index, pilha));
        }

    }
}
