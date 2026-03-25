package competiva;

import java.util.Scanner;

public class Palindromo {

    public static boolean isPalindromo(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int esquerda = 0;
        int direita = s.length() - 1;

        while (esquerda < direita) {
            if (s.charAt(esquerda) != s.charAt(direita)) {
                return false;
            }
            esquerda++;
            direita--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String texto = scanner.nextLine();

        if (isPalindromo(texto)) {
            System.out.println("É palíndromo");
        } else {
            System.out.println("Não é palíndromo");
        }

        scanner.close();
    }
}