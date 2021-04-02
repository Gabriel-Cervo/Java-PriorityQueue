import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Boolean programaRodando = true;
    static Scanner leitor = new Scanner(System.in);
    static Queue<Tarefa> PQtarefas = new PriorityQueue<Tarefa>(new ComparatorPrioridade());


    public static void main(String[] args) {


        // Tarefa teste1 = new Tarefa("Comprar Cafe", 10);
        // Tarefa teste2 = new Tarefa("Pagar Aluguel", 2);

        // PQtarefas.add(teste1);
        // PQtarefas.add(teste2);

        // Mostrar com mais prioridade
        // while(true) {
        //     Tarefa e = PQtarefas.poll();
        //     if (e != null) System.out.println(e.getNome());

        //     if(e == null) break;
        // }
        System.out.println("=== Olá! Seja bem vindo! ===");
        while(programaRodando) {
            System.out.println("O que deseja fazer?");
            System.out.println("\n0 - Sair");
            System.out.println("1 - Cadastrar uma nova tarefa");
            System.out.println("2 - Extrair e retornar a tarefa mais prioritária");
            System.out.println("3 - Limpar a sequência de tarefas");
            System.out.println("4 - Listar tarefas pendentes");
            System.out.println("5 - Importar uma lista de tarefas de um csv");
            System.out.println("5 - Exportar sua lista de tarefas para um csv");

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
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
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
            System.out.println("Até mais!");
        }

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
}