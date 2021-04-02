public class Tarefa implements Comparable<Tarefa> {
    private String nome;
    private int prioridade;
    
    public Tarefa(String nome, int prioridade) {
        this.nome = nome;
        this.prioridade = prioridade;
    }

    public String getNome() {
        return nome;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
    *  Prioridades menores = mais importantes
    * Subtrai uma da outra pois funciona como o compareTo
    * Caso resultado negativo = prioridade atual é mais importante
    * Caso resultado positivo = outra tarefa é mais importante
    * Caso igual, mesma prioridade
    */
    @Override
    public int compareTo(Tarefa outra) {
        return prioridade - outra.getPrioridade();
    }
}
