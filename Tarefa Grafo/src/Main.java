import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Hashtable<String, ArrayList<String>> tabela =
                new Hashtable<String, ArrayList<String>>();

        ArrayList<String> vizinhosBob
                = new ArrayList<String>();
        vizinhosBob.add("Anuj");
        vizinhosBob.add("Peggy");

        ArrayList<String> vizinhosHarrison
                = new ArrayList<String>();

        vizinhosHarrison.add("Alice");
        vizinhosHarrison.add("Bob");
        vizinhosHarrison.add("Claire");

        ArrayList<String> vizinhosAlice
                = new ArrayList<String>();

        vizinhosAlice.add("Peggy");

        ArrayList<String> vizinhosClaire
                = new ArrayList<String>();

        vizinhosClaire.add("Jonny");
        vizinhosClaire.add("Thom");

        tabela.put("Alice", vizinhosAlice);
        tabela.put("Bob", vizinhosBob);
        tabela.put("Claire", vizinhosClaire);
        tabela.put("Harrison", vizinhosHarrison);

        for (Map.Entry<String, ArrayList<String>> entry : tabela.entrySet()){
            String chave = entry.getKey();
            ArrayList<String> dados = entry.getValue();

            System.out.println("Chave: " + chave + " Dados: " + dados);
        }
    }
}