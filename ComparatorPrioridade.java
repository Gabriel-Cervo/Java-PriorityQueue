// Por: João Cervo

import java.util.Comparator;


// Método de comparação
// Caso deseje mudar para comparar os nomes (listar em ordem alfabetica por exemplo)
// Apenas mudar get prioridade para getNome e usar um compareTo ao invés do '-'
class ComparatorPrioridade implements Comparator<Tarefa>{
    public int compare(Tarefa a, Tarefa b) throws ClassCastException {
        return a.getPrioridade() - b.getPrioridade();
    }
}
