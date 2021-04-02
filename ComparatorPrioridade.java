import java.util.Comparator;


class ComparatorPrioridade implements Comparator<Tarefa>{
    public int compare(Tarefa a, Tarefa b) throws ClassCastException {
        return a.getPrioridade() - b.getPrioridade();
    }
}
