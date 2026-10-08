import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        TuringMachine tm = new TuringMachine("turing.txt");

        System.out.print("Cuvant de testat: ");
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        sc.close();

        if (tm.analyse(word)) {
            System.out.println("\nCuvantul a fost ACCEPTAT de Masina Turing.");
        }
        else {
            System.out.println("\nCuvantul a fost RESPINS de Masina Turing.");
        }
    }
}