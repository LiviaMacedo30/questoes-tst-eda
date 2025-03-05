import java.util.Scanner;

public class PilhaArray {
    private int topo;
    private int[] pilha;
    private int size;

    public PilhaArray(int capacidade) {
        this.topo = -1;
        this.pilha = new int[capacidade];
        this.size = 0;
    }
    public void push(int valor){
        if (isFull()){
            System.out.println("full");
            return;
        }
        this.pilha[++this.topo] = valor;
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
    public boolean isFull(){
        return this.topo == this.pilha.length-1;
    }
    public int getSize(){
        return this.size;
    }
    //Não é para alterar o estado inicial da pilha
    public String print(PilhaArray pilha){
        if(pilha.isEmpty()){
            return "empty";
        }
        StringBuilder sb = new StringBuilder();
        PilhaArray pilhaAux = new PilhaArray(getSize());
        while (!isEmpty()){
            int valor = pilha.pop();
            pilhaAux.push(valor);
        }
        while (!pilhaAux.isEmpty()){
            int valor = pilhaAux.pop();
            pilha.push(valor);
            sb.append(valor).append(" ");
        }
        return sb.toString().trim();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tam = sc.nextInt();
        sc.nextLine();
        PilhaArray pilha = new PilhaArray(tam);
        String[] entrada = sc.nextLine().split(" ");
        while (!entrada[0].equals("end")){
            if(entrada[0].equals("print")){
                System.out.println(pilha.print(pilha));
            } else if (entrada[0].equals("push")) {
                pilha.push(Integer.parseInt(entrada[1]));
            } else if (entrada[0].equals("peek")) {
                System.out.println(pilha.peek());
            } else if (entrada[0].equals("pop")) {
                if (pilha.isEmpty()) {
                    System.out.println("empty");
                }else{
                    pilha.pop();
                }
            }
            entrada = sc.nextLine().split(" ");
        }
    }

}
