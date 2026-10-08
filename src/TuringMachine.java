import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TuringMachine {

    private String initial_state;
    private String[] final_states;
    private TransitionList trlist = new TransitionList();
    private static final char BLANK = '#';

    public TuringMachine(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            this.initial_state = br.readLine();
            this.final_states = br.readLine().split(" ");

            String line;
            while ((line = br.readLine()) != null) {
                String[] lineSplit = line.split(" ");
                if (lineSplit.length == 5) {
                    String stateA = lineSplit[0];
                    char symbolRead = lineSplit[1].charAt(0);
                    String stateB = lineSplit[2];
                    char symbolWrite = lineSplit[3].charAt(0);
                    char direction = lineSplit[4].charAt(0);
                    trlist.addTransition(new Transition(stateA, symbolRead, stateB, symbolWrite, direction));
                }
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public boolean analyse(String word) {
        StringBuilder tape = new StringBuilder("#" + word + "#");
        int headPosition = 1;
        String currentState = initial_state;
        int pas = 0;

        System.out.println("----------------------------------");
        System.out.println("Banda initiala: " + word);

        while (true) {
            if (headPosition < 0) {
                System.out.println("Eroare: Capul de citire a depasit limita din stanga e benzii");
                return false;
            }

            if (headPosition >= tape.length()) {
                tape.append(BLANK);
            }

            char currentSymbol = tape.charAt(headPosition);
            Transition transition = trlist.findTransition(currentState, currentSymbol);
            if (transition == null) {
                System.out.println("\nBanda finala: " + tape.toString().replaceAll("#", " ").trim());
                break; // daca nu gasim tranzitie definita, masina se opreste
            }

            System.out.println("\nPas: " + pas);
            System.out.println(currentState + " -> " + transition.getSymbolRead() + " -> " + transition.getStateB());
            System.out.println("Write: " + transition.getSymbolWrite() + " and go: " + transition.getDirection());

            tape.setCharAt(headPosition, transition.getSymbolWrite());
            System.out.println("Banda curenta: " + tape);
            currentState = transition.getStateB();

            if (transition.getDirection() == 'R') {
                headPosition++;
            }
            else if (transition.getDirection() == 'L') {
                headPosition--;
            }

            pas++;
        }

        for (String final_state : final_states) {
            if (final_state.equals(currentState)) {
                return true;
            }
        }

        return false;
    }
}