import java.util.NoSuchElementException;
import java.util.Scanner;

public class Pilha {

        private int topo;
        private int[] pilha;

        public Pilha(int capacidade) {
            this.topo = -1;
            this.pilha = new int[capacidade];
        }

        public boolean isEmpty() {
            return this.topo == -1;
        }

        public boolean isFull() {
            return this.topo == this.pilha.length-1;
        }

        // deve lançar exceção caso a pilha esteja cheia.
        public void push(int valor) {
            if(isFull()) throw new RuntimeException("Pilha cheia!");

            this.pilha[++this.topo] = valor;

        }

        // deve lançar exceção caso a pilha esteja vazia.
        public int pop() {
            if(isEmpty()) throw new NoSuchElementException();
            return this.pilha[topo--];
        }

        // deve lançar exceção caso a pilha esteja vazia.
        public int peek() {
            if(isEmpty()) throw new NoSuchElementException();
            return this.pilha[topo];
        }


        // deve retornar uma string representando a pilha. Veja os testes para a especificação
        // detalhada. Não é permitido iterar diretamente sobre o array ou criar arrays. Crie outra pilha, se preciso. Use as operações push, pop,
        // isEmpty etc.
        public String toString() {
            // Cria uma pilha auxiliar para armazenar os valores temporariamente
            Pilha pilhaAux = new Pilha(this.pilha.length);
            StringBuilder sb = new StringBuilder();
            while(!this.isEmpty()){
                int valor = pop();// Remove o elemento do topo da pilha
                sb.append(valor).append(" ");
                pilhaAux.push(valor); // Armazena o valor na pilha auxiliar
            }
            while(!pilhaAux.isEmpty()){
                this.push(pilhaAux.pop());
            }
            if(!sb.isEmpty()){
                sb.setLength(sb.length() -1);
            }
            return sb.toString();
        }

        // Deve retornar a posição da primeira ocorrência do elemento passado como parâmetro. Note que
        // o topo sempre está na primeira posição (0), abaixo do topo é a posição 1 etc. Não confunda
        // com os índices do array. Interprete os testes para a especificação mais detalhada.
        // Não é permitido iterar diretamente sobre o array. Use as operações push, pop,
        // isEmpty etc.
        public int indexOf(int valor) {
            Pilha pilhaAux = new Pilha(this.pilha.length);
            int index = 0;
            int posicao = -1;
            while(!this.isEmpty()){
                int elemento = this.pop();
                pilhaAux.push(elemento);
                if(elemento == valor){
                     posicao = index;
                    break;
                }
                index++;
            }
            while (!pilhaAux.isEmpty()){
                this.push(pilhaAux.pop());
            }
            return posicao;
        }

        public int size() {
            return this.topo+1;
        }

    public static void main(String[] args){
        Pilha pilha = new Pilha(10);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        System.out.println(pilha.toString());
        System.out.println(pilha.indexOf(10));
    }

    }


