import java.util.Arrays;
import java.util.Scanner;

public class FuraFila {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int index = sc.nextInt(); // Esse índice marca o início dos idosos na fila.
        int[] seq = new int[entrada.length];
        for(int i =0; i < entrada.length; i++){
            seq[i]= Integer.parseInt(entrada[i]);
        }
        shiftRight(index,seq);
    }
    public static void shiftRight(int index, int[] seq){
        int last = 0;
        for(int i = index; i < seq.length; i++) {
            int valor = seq[i];
            for (int j = i; j > last; j--) {
                seq[j] = seq[j - 1];
            }
            seq[last] = valor;
            last++;
            System.out.println(Arrays.toString(seq));

        }
    }
}
