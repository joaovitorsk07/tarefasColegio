import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class JogoAdivinheONumero {

    public static void main(String[] args) {
        // Inicializa o gerador de números aleatórios e o scanner para a entrada do usuário.
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        boolean jogarNovamente;

        System.out.print("Por favor, digite seu nome: ");
        String nomeJogador = scanner.nextLine();
        System.out.println("Bem vindo ao jogos de adivinhar número, Hello Word!");
        System.out.println("----------------------------------------------");
        System.out.println("Eu escolhi um número entre 1 e 100.");


        do {
            // Gera um número aleatório entre 1 e 100 (o 101 é exclusivo, então o intervalo é de 1 a 100).
            int numeroAlvo = random.nextInt(100) + 1;
            int palpite;
            int tentativas = 0;
            boolean adivinhouCorretamente = false;

            while (!adivinhouCorretamente) {
                try {
                    // Solicita o palpite do usuário.
                    System.out.print("\nQual é o seu palpite? ");
                    palpite = scanner.nextInt();
                    tentativas++;

                    // Verifica se o palpite é correto.
                    if (palpite == numeroAlvo) {
                        System.out.println("Parabéns! Você adivinhou o número " + numeroAlvo + " em " + tentativas + " tentativas.");
                        adivinhouCorretamente = true;
                    } else if (palpite > numeroAlvo) {
                        System.out.println("Muito alto. Tente um número menor.");
                    } else {
                        System.out.println("Muito baixo. Tente um número maior.");
                    }
                } catch (InputMismatchException e) {
                    // Lida com entradas que não são números inteiros.
                    System.out.println("Entrada inválida. Por favor, insira um número inteiro.");
                    scanner.next(); // Limpa o buffer de entrada do scanner para evitar um loop infinito.
                }
            }

            // Pergunta ao usuário se ele quer jogar novamente.
            System.out.print("\nDeseja jogar novamente? (s/n): ");
            String resposta = scanner.next();
            jogarNovamente = resposta.equalsIgnoreCase("s");

        } while (jogarNovamente);

        System.out.println("Obrigado por jogar! Até a próxima.");
        scanner.close();
    }
}
