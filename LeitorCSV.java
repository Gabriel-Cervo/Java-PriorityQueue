import java.io.*;
import java.util.Queue;

public class LeitorCSV {
    public static void lerArquivoESalvarEmPQ(String nomeArquivo, Queue<Tarefa> lista) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(nomeArquivo + ".csv"));  
        String line = "";

        while ((line = br.readLine()) != null) {  
            String[] tarefa = line.split(",");  
            lista.add(new Tarefa(tarefa[0], Integer.parseInt(tarefa[1])));
        }
        
        br.close();
    }
}
