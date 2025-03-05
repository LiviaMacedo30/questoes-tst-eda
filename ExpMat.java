import java.util.Scanner;
import java.util.Stack;

public class ExpMat {

    public static int calculaExp(String expressao) {
        Stack<Integer> numeros = new Stack<>();
        Stack<Character> operadores = new Stack<>();

        for (char ele : expressao.toCharArray()) {
            if (Character.isDigit(ele)) {
                // Se for número, converte e empilha
                numeros.push(ele - '0');
            } else if (ele == '+' || ele == '-' || ele == '*' || ele == '/') {
                // Se for operador, empilha
                operadores.push(ele);
            } else if (ele == ')') {
                // Quando fecha parênteses, resolvemos a operação
                int b = numeros.pop();
                int a = numeros.pop();
                char op = operadores.pop();

                // Calcula e empilha o resultado
                if (op == '+') numeros.push(a + b);
                else if (op == '-') numeros.push(a - b);
                else if (op == '*') numeros.push(a * b);
                else if (op == '/') numeros.push(a / b);
            }
        }
        while (!operadores.isEmpty()){
            int b = numeros.pop();
            int a = numeros.pop();
            char op = (char) operadores.pop();
            if(op == '+'){
                numeros.push(a+b);
            } else if (op == '*') {
                numeros.push(a*b);
            }else if (op == '-'){
                numeros.push(a-b);
            }else if (op == '/'){
                numeros.push(a/b);
            }
        }

        return numeros.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expressao = sc.nextLine();
        System.out.println(calculaExp(expressao));
    }
}

