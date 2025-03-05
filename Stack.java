import java.util.Scanner;

import static java.lang.Character.isDigit;

class Stack {
    private int topo;
    private int[] pilha;
    private int size;

    public Stack(int capacidade) {
        this.topo = -1;
        this.pilha = new int[capacidade];
        this.size = 0;
    }

    public boolean isEmpty(){
        return this.topo == -1;
    }
    public void push(int valor){
        this.pilha[++topo] = valor;
    }
    public int pop(){
        return this.pilha[topo--];
    }

    public static double calculaExp(String[] expressao){
        Stack numeros = new Stack(expressao.length);
        for (String ele: expressao){
            if(ehNumero(ele)){
                numeros.push(Integer.parseInt(ele));
            } else {
                int b = numeros.pop();
                int a = numeros.pop();
                if(ele.equals("+")){
                    numeros.push(a+b);
                } else if (ele.equals("-")) {
                    numeros.push(a-b);
                } else if (ele.equals("*")) {
                    numeros.push(a*b);
                }else if (ele.equals("/")){
                    numeros.push(a/b);
                }
            }
        }
        return numeros.pop();
    }
    private static boolean ehNumero(String ele) {
        try {
            Double.parseDouble(ele);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        System.out.println(calculaExp(entrada));
    }
}