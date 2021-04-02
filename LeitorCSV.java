import java.io.*;
import java.util.Arrays;
import java.util.Queue;
import java.util.stream.Collectors;

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

    public static void exportarLista(String nomeArquivo, Queue<Tarefa> lista) throws Exception {
        FileWriter writer = new FileWriter(nomeArquivo);

        for (Tarefa tarefa : lista) {
            String[] emString = { tarefa.getNome(), "" + tarefa.getPrioridade() };
            writer.write(Arrays.asList(emString).stream().collect(Collectors.joining(",")));
            writer.write("\n");
        }

        writer.close();
    }
}
