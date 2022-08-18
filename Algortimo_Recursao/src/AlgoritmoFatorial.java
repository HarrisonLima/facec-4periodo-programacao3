//    Crie uma função que calcule o fatorial de um número inteiro qualquer.
//        Ex.: Fatorial de 3 é 3 x 2 x 1.
//        Obs.: Esta função deverá ser recursiva.
//        Deverá enviar o link do código versionado, lembre de adicionar o arquivo .gitignore.

public class AlgoritmoFatorial {
    public static void main(String[] args) {

        AlgoritmoFatorial input = new AlgoritmoFatorial();
        int resultado = input.regressaoFatorial(10);
        System.out.println("Regressao fatorial: " + resultado);
    }
        private static int regressaoFatorial (int numeroFatorial){
            if (numeroFatorial == 0)
                return 1;
            return numeroFatorial * regressaoFatorial(numeroFatorial - 1);
        }
}

