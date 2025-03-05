import java.util.Scanner;
import java.util.Arrays;

public class Particionamento {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] seq = new int[entrada.length];
        for(int i =0; i < entrada.length; i++){
            seq[i] = Integer.parseInt(entrada[i]);
        }
        lomuto(seq, 0, seq.length -1);
        System.out.println(Arrays.toString(seq));
    }
    public static void lomuto(int[] seq, int ini, int fim){
        int pivot = seq[fim];
        int i = fim;
        for(int j = i - 1; j >= 0; j--){
            if(seq[j] > pivot){
                i--;
                swap(seq, i, j);
                System.out.println(Arrays.toString(seq));
            }
        }
        swap(seq, fim, i);
        System.out.println(Arrays.toString(seq));
    }

    private static void swap(int[] seq, int i, int j){
        int aux = seq[i];
        seq[i] = seq[j];
        seq[j] = aux;
    }

}
