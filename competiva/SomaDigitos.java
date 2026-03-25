package competiva;

import java.util.Scanner;

public class SomaDigitos {

    public static int somaDigitos(int n) {
        int soma = 0;
        n = Math.abs(n);

        while (n > 0) {
            soma += n % 10;
            n /= 10;
        }

        return soma;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            System.out.println(somaDigitos(num));
        }

        scanner.close();
    }
}