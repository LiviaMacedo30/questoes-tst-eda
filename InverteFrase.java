import java.util.ArrayList;
import java.util.Scanner;

public class InverteFrase {

    private int topo;
    private String[] pilha;
    private int size;

    public InverteFrase(int capacidade) {
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
    public int getSize(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.topo == -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();
        InverteFrase pilha = new InverteFrase(entrada.length());
        StringBuilder sb = new StringBuilder();
        for(char c: entrada.toCharArray()){
            if(c != ' '){
                sb.append(c);
            }else{
                pilha.push(sb.toString());
                sb.setLength(0);
            }
        }
        if(sb.length() > 0){
            pilha.push(sb.toString());
        }
        StringBuilder fraseInvertida = new StringBuilder();
        while (!pilha.isEmpty()){
            fraseInvertida.append(pilha.pop()).append(" ");
        }
        fraseInvertida.setLength(entrada.length());
        System.out.println(fraseInvertida.toString());
    }
}
