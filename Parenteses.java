import java.util.Scanner;

public class Parenteses {
    private int topo;
    private String[] pilha;
    private int size;

    public Parenteses(int capacidade) {
        this.topo = -1;
        this.pilha = new String[capacidade];
    }
    public void push(String value){
        this.pilha[++topo] = value;
        size++;
   }
    public String pop(){
        size--;
        return this.pilha[topo--];
    }
    public int getCapacidade() {
        return this.size;
    }
    public boolean isEmpty(){
        return this.topo == -1;
    }

    // O código apenas armazena ( na pilha e os remove quando um ) é encontrado
    public static String verificaMat(String entrada){
        Parenteses pilha = new Parenteses(entrada.length());
        for (char car: entrada.toCharArray()){
            if (car == '('){
                pilha.push(String.valueOf(car));
            } else if (car == ')') {
                if(pilha.isEmpty()){
                    return "N";
                }
                pilha.pop();
            }
        }
        return pilha.isEmpty() ? "S" : "N";
    }



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();
        System.out.println(verificaMat(entrada));
    }
}
