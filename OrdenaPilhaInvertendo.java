import java.util.Scanner;

public class OrdenaPilhaInvertendo {
    private int[] pilha;
    private int topo;
    private int size;

    public OrdenaPilhaInvertendo(int capacidade) {
        this.pilha = new int[capacidade];
        this.topo = -1;
        this.size = 0;
    }

    public int peek(){
        return this.pilha[topo];
    }
    public boolean isEmpty(){
        return this.topo == -1;
    }
    public void push(int valor){
        // acrescenta 1 no topo
        this.pilha[++topo] = valor;
        size++;
    }
    public int pop(){
        // reduz 1 no topo
        size--;
        return this.pilha[topo--];
    }

    public int getSize() {
        return size;
    }

    public int getMax(OrdenaPilhaInvertendo pilha){
        int tamanho = pilha.size;
        OrdenaPilhaInvertendo aux = new OrdenaPilhaInvertendo(tamanho);
        int max = pilha.peek();
        int maxIndex = 0;

        for (int i =0; i < tamanho; i++){
            int valor = pilha.pop();
            if(valor >= max){
                max = valor;
                maxIndex = i;
            }
            aux.push(valor);
        }
        while (!aux.isEmpty()){
            int valor = aux.pop();
            pilha.push(valor);
        }
        return maxIndex;
    }
    public void inverte(OrdenaPilhaInvertendo pilha, int index){
        OrdenaPilhaInvertendo aux1 = new OrdenaPilhaInvertendo(getSize());
        OrdenaPilhaInvertendo aux2 = new OrdenaPilhaInvertendo(getSize());

        int cont = 0;
        while (cont <= index){
            int valor = pilha.pop();
            aux1.push(valor);
            cont++;
        }
        while (!aux1.isEmpty()){
            int valor = aux1.pop();
            aux2.push(valor);
        }
        while (!aux2.isEmpty()){
            int valor = aux2.pop();
            pilha.push(valor);
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int capacidade = sc.nextInt();
        sc.nextLine();
        String[] entrada = sc.nextLine().split(" ");
        OrdenaPilhaInvertendo pilha = new OrdenaPilhaInvertendo(capacidade);
        for (int i = 0; i < entrada.length; i++){
            pilha.push(Integer.parseInt(entrada[i]));
        }

        int cont = 0;
        OrdenaPilhaInvertendo resp = new OrdenaPilhaInvertendo(capacidade);
        while (cont < capacidade){
            int index = pilha.getMax(pilha);
            pilha.inverte(pilha,index);
            int valor = pilha.pop();
            resp.push(valor);
            cont++;
        }

        System.out.println("-");
        while (!resp.isEmpty()){
            System.out.println(resp.pop());
        }

    }
}
