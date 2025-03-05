import java.util.Arrays;
import java.util.Scanner;

public class Pivot {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        int[] seq = new int[entrada.length];
        for(int i =0; i < entrada.length; i++){
            seq[i] = Integer.parseInt(entrada[i]);
        }
        String[] entrada2 = sc.nextLine().split(" ");
        int[] seq2 = new int[entrada.length];
        for(int i =0; i < entrada2.length; i++){
            seq2[i] = Integer.parseInt(entrada2[i]);
        }

        System.out.println(melhorPivot(seq, seq2[0], seq2[1]));
    }

    public static int melhorPivot(int[] seq, int i, int j) {

        int[] valores = {seq[0], seq[seq.length / 2], seq[seq.length - 1]};
        Arrays.sort(valores);

        int dif1 = Math.abs(valores[1] - seq[i]);
        int dif2 = Math.abs(valores[1] - seq[j]);
        if(dif1 <= dif2){
            return i;
        }else{
            return j;
        }

    }
}

