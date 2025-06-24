import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static int menu(){
        System.out.print("\n[1]Criar uma tarefa\n[2]Concluir uma tarefa\n[3]Mostrar todas as tarefa\n[4]Sair\n");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }

    public static void criarTags(ArrayList<String> tags) {
        while(true){
            System.out.print("De um nome à tag (ou pressione ENTER para continuar): ");
            Scanner sc = new Scanner(System.in);
            String tag = sc.nextLine();
            if (tag.isEmpty()) {
                break;
            }
            tags.add(tag);
        }
    }

    public static ArrayList<String> addTags(ArrayList<String> tags){
        ArrayList<String> selecionadas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        if (tags.size() != 0) {

            System.out.println("Tags disponíveis:");
            for (int i = 0; i < tags.size(); i++) {
                if (tags.get(i) != null) {
                    System.out.printf("%d - %s\n", i, tags.get(i));
                }
            }

            System.out.println("Escolha uma tag ou pressione ENTER para continuar:");
            String opcao = sc.nextLine();
            if (opcao.isEmpty()) {
            } else {
                int entrada = Integer.parseInt(opcao);
                for (int i = 0; i < tags.size(); i++) {
                    if (entrada == i) {
                        selecionadas.add(tags.get(entrada));
                    }
                }
            }

            System.out.println("Quer adicionar outra tag?[s/n]");
            char escolha = sc.next().charAt(0);
            if (escolha == 's') {
                selecionadas.addAll(addTags(tags));
            }
        }
        System.out.println("Criar uma tag?[s/n]");
        char escolha = sc.next().charAt(0);
        if (escolha == 's'){
            criarTags(tags);
            System.out.println("AVISO: Criar uma tag não adiciona ela automaticamente, é necessário selecionar a tag");
            selecionadas.addAll(addTags(tags));
        }
        return selecionadas;
    }

    public static void adicionarTarefa(ArrayList<Tarefas> tarefa, ArrayList<String> tags){

        System.out.print("Escreva o titulo:");
        Scanner sc = new Scanner(System.in);
        String titulo = sc.nextLine();

        System.out.print("Escreva a descrição:");
        String descricao = sc.nextLine();

        Random rand = new Random();
        int id = rand.nextInt(900000) + 100000;

        ArrayList<String> newTags = addTags(tags);

        tarefa.add(new Tarefas(id, titulo, descricao, newTags));
    }

    public static void concluirTarefa(ArrayList<Tarefas> tarefa){
        System.out.println("Escolha uma tarefa para concluir");
        for (int i = 0; i < tarefa.size(); i++) {
            System.out.println("[" + i + "] " + tarefa.get(i).getTitulo());
        }
        Scanner sc = new Scanner(System.in);
        int opcao = sc.nextInt();
        for (int i = 0; i < tarefa.size(); i++){
            if (opcao == i) {
                tarefa.get(i).setSituacao(Boolean.TRUE);
                System.out.println("Tarefa marcada como concluída\n");
            }
        }
    }

    public static void mostrarTarefa(ArrayList<Tarefas> tarefa){
        for (int i = 0; i < tarefa.size(); i++) {
            System.out.printf("ID: %d\n", tarefa.get(i).getId());
            System.out.printf("Título: %s\n", tarefa.get(i).getTitulo());
            System.out.printf("Descrição: %s\n", tarefa.get(i).getDescricao());
            if (tarefa.get(i).getSituacao() == true) {
                System.out.println("Situação: Concluído");
            } else {
                System.out.println("Situação: Pendente");
            }
            if (tarefa.get(i).getTags().size() != 0) {
                System.out.printf("Tags: %s\n\n", String.join(", ", tarefa.get(i).getTags()));
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Tarefas> tarefa = new ArrayList<>();
        ArrayList<String> tags = new ArrayList<>();

        int opcao = 0;
        while (true){

            opcao = menu();

            if (opcao == 1) {
                adicionarTarefa(tarefa, tags);
            } else if (opcao == 2) {
                concluirTarefa(tarefa);
            } else if (opcao == 3) {
                mostrarTarefa(tarefa);
            } else if (opcao == 4) {
                break;
            }
        }
    }
}