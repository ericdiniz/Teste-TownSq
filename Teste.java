import java.util.ArrayList;
import java.util.Scanner;

public class Teste {
    public static int functionArrayToSabor(ArrayList<Integer> sabores) {
        int codeSabor = 0;
        int[] maiorFrequencia = new int[5];
        int f = 0, c = 0, m = 0, cr = 0, n = 0;
        for (Integer sabor : sabores) {
            if (sabor.equals(0)) {
                f++;
            } else if (sabor.equals(1)) {
                c++;
            } else if (sabor.equals(2)) {
                m++;
            } else if (sabor.equals(3)) {
                cr++;
            } else if (sabor.equals(4)) {
                n++;
            }
        }
        maiorFrequencia[0] = f;
        maiorFrequencia[1] = c;
        maiorFrequencia[2] = m;
        maiorFrequencia[3] = cr;
        maiorFrequencia[4] = n;

        selectionSort(maiorFrequencia);
        codeSabor = maiorFrequencia[4];
        return codeSabor;
    }

    public static void selectionSort(int[] array) {
        for (int fixo = 0; fixo < array.length - 1; fixo++) {
          int menor = fixo;
      
          for (int i = menor + 1; i < array.length; i++) {
             if (array[i] < array[menor]) {
                menor = i;
             }
          }
          if (menor != fixo) {
            int t = array[fixo];
            array[fixo] = array[menor];
            array[menor] = t;
          }
        }
      }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Integer> sabores = new ArrayList<Integer>();
        int entradaSabores;
        System.out.println("Digite o sabor, e para sair digite 5");
        while (s.nextInt() != 5) {
            entradaSabores = s.nextInt();
            if (entradaSabores != 5) {
                sabores.add(entradaSabores);
            }
            System.out.println("Digite os sabores, e para sair digite 5");
        }
        int saborComMaiorFrequencia = functionArrayToSabor(sabores);
        System.out.println();
        System.out.println("Array: " + sabores);
        System.out.println("maior ocorrência: " + saborComMaiorFrequencia);
    }
}