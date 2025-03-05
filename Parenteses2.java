import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Parenteses2 {
    private Deque<String> pilha;

    public Parenteses2() {
        this.pilha = new ArrayDeque<String>();
    }
    public static String verificaMat(String entrada){
        Deque<String> pilha = new ArrayDeque<>();
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
