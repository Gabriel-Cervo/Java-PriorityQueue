import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Tarefa> PQtarefas = new PriorityQueue<Tarefa>(new ComparatorPrioridade());

        Tarefa teste1 = new Tarefa("Comprar Cafe", 10);
        Tarefa teste2 = new Tarefa("Pagar Aluguel", 2);

        PQtarefas.add(teste1);
        PQtarefas.add(teste2);

        // Mostrar com mais prioridade
        while(true) {
            Tarefa e = PQtarefas.poll();
            if (e != null) System.out.println(e.getNome());

            if(e == null) break;
        }
    }
}