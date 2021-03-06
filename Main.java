// Por: João Cervo

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Boolean programaRodando = true;
    static Scanner leitor = new Scanner(System.in);
    static Queue<Tarefa> PQtarefas = new PriorityQueue<Tarefa>(new ComparatorPrioridade());


    public static void main(String[] args) {
        System.out.println("=== Olá! Seja bem vindo! ===");

        while(programaRodando) {
            System.out.println("\nO que deseja fazer?");
            System.out.println("\n0 - Sair");
            System.out.println("1 - Cadastrar uma nova tarefa");
            System.out.println("2 - Extrair e retornar a tarefa mais prioritária");
            System.out.println("3 - Limpar a sequência de tarefas");
            System.out.println("4 - Listar tarefas pendentes");
            System.out.println("5 - Importar uma lista de tarefas de um csv");
            System.out.println("6 - Exportar sua lista de tarefas para um csv");

            int opcao;
            do {
                System.out.print("Sua escolha: ");
                opcao = leitor.nextInt();

                if (opcao < 0 || opcao > 6) {
                    System.out.println("Digite uma opção valida! \n");
                }
            } while (opcao < 0 || opcao > 6);

            lidarComEscolha(opcao);
        }
    }

    static void lidarComEscolha(int escolha) {
        System.out.print("\n\n");

        switch(escolha) {
            case 0:
                sairDoPrograma();
                break;
            case 1:
                cadastrarNovaTarefa();
                break;
            case 2: 
                removerERetornarMaisPrioritaria();
                break;
            case 3:
                limparSequenciaDeTarefas();
                break;
            case 4:
                listarTarefasPendentes();
                break;
            case 5:
                importarCSV();
                break;
            case 6:
                exportarParaCSV();
                break;
            default:
                break;
        }
    }

    static void sairDoPrograma() {
        if(!PQtarefas.isEmpty()) {
            System.out.println("Ei! Aviso antes de sair: ");
            System.out.println("Você possui tarefas pendentes!");
            System.out.println("Mas ja que deseja fugir das suas responsabilidades...");
        }
        System.out.println("Obrigado por usar o programa!");
        System.out.println("Até mais!");

        programaRodando = false;
    }

    static void cadastrarNovaTarefa() {
        System.out.print("Escreva o nome da tarefa que deseja cadastrar: ");
        leitor.nextLine(); // Joga fora o \n nao consumido pelo leitor na escolha do menu
        String nomeTarefa = leitor.nextLine();
        System.out.print("\nAgora escreva o valor da prioridade da tarefa (menor = mais importante): ");
        int prioridade = Integer.parseInt(leitor.nextLine());

        PQtarefas.add(new Tarefa(nomeTarefa, prioridade));
        System.out.println("\nTarefa adicionada com sucesso!");
    }

    static void removerERetornarMaisPrioritaria() {
        if (PQtarefas.isEmpty()) {
            System.out.println("Você não possui tarefas para remover!");
            return;
        }
        
        Tarefa maisPrioritaria = PQtarefas.poll();

        System.out.println("A tarefa: " + maisPrioritaria.getNome() + " era a mais prioritária e foi removida da lista com sucesso!");
    }

    static void limparSequenciaDeTarefas() {
        PQtarefas = new PriorityQueue<Tarefa>(new ComparatorPrioridade());

        System.out.println("Sua lista de tarefas foi limpa!");
    }

    static void listarTarefasPendentes() {
        System.out.println("Sua lista de tarefas: ");
        PQtarefas.forEach(tarefa -> System.out.println(tarefa));
    }

    static void importarCSV() {
        System.out.print("Escreva o nome do arquivo a ser lido (sem a extensão): ");
        leitor.nextLine(); // Joga fora o \n nao consumido pelo leitor na escolha do menu
        String nomeArquivo = leitor.nextLine();

        try {
            LeitorCSV.lerArquivoESalvarEmPQ(nomeArquivo, PQtarefas);
            System.out.println("Lista importada com sucesso!");
        } catch(Exception error) {
            System.out.println("Um erro ocorreu ao ler o arquivo: ");
            System.out.println(error.getMessage());
        }
    }

    static void exportarParaCSV() {
        System.out.print("Escreva o nome do arquivo a ser salvo (sem a extensão): ");
        leitor.nextLine(); 
        String nomeArquivo = leitor.nextLine();

        try {
            LeitorCSV.exportarLista(nomeArquivo, PQtarefas);
            System.out.println("Lista exportada com sucesso!");
        } catch(Exception error) {
            System.out.println("Um erro ocorreu ao exportar o arquivo: ");
            System.out.println(error.getMessage());
        }
    }
}