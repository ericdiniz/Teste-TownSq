import java.util.ArrayList;
import java.util.Locale;
import java.util.function.Function;

public class Main {
    
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Sorvete[] array = new Sorvete[5];

        array[0] = new Sorvete("flocos", 0);
        array[1] =  new Sorvete("chocolate", 1);
        array[2] =  new Sorvete("morango", 2);
        array[3] =  new Sorvete("creme", 3);
        array[4] =  new Sorvete("napolitano", 4);

        // Entrada de dados da votação realizada
        int[] votacao = { 0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4 };
        int resultado = Votacao.calcularResultado(votacao, array);
        // Resultado esperado = 1
        System.out.println(resultado);
    }
}

class Votacao {

    public static void verificaEmpate(Sorvete[] array){
        for (int i = array.length -1; i > 0; i--) {
            if(array[i].getPontuacao() == array[i-1].getPontuacao()){
                if(array[i].getIndice() > array[i-1].getIndice()){
                    Sorvete t = array[i];
                    array[i] = array[i-1];
                    array[i-1] = t;
                }
            }
        }
    }
    public static void ordenandoPorSelecao(Sorvete[] array) {
        for (int fixo = 0; fixo < array.length - 1; fixo++) {
            int menor = fixo;

            for (int i = menor + 1; i < array.length; i++) {
                if (array[i].getPontuacao() < array[menor].getPontuacao()) {
                    menor = i;
                }
            }
            if (menor != fixo) {
                Sorvete t = array[fixo];
                array[fixo] = array[menor];
                array[menor] = t;
            }
        }
    }
    public static int calcularResultado(int[] votacao, Sorvete[] array) {
        int f = 0, c = 0, m = 0, cr = 0, n = 0;
        for (int i = 0; i < votacao.length; i++) {
            switch (votacao[i]) {
                case 0:
                    f++;
                    break;
                case 1:
                    c++;
                    break;
                case 2:
                    m++;
                    break;
                case 3:
                    cr++;
                    break;
                case 4:
                    n++;
                    break;

                default:
                    break;
            }
        }
        array[0].setPontuacao(f);
        array[1].setPontuacao(c);
        array[2].setPontuacao(m);
        array[3].setPontuacao(cr);
        array[4].setPontuacao(n);

        ordenandoPorSelecao(array);
        verificaEmpate(array);

        return array[4].getIndice();
    }
}

class Sorvete {
    private String sabor;
    private int indice;
    private int pontuacao;

    public Sorvete(String sabor, int indice) {
        this.sabor = sabor;
        this.indice = indice;
    }

    public Sorvete() {
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
