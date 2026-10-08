public class Transition {

    private String stateA;
    private char symbolRead;
    private String stateB;
    private char symbolWrite;
    private char direction;

    public Transition(String stateA, char symbolRead, String stateB, char symbolWrite, char direction) {
        this.stateA = stateA;
        this.symbolRead = symbolRead;
        this.stateB = stateB;
        this.symbolWrite = symbolWrite;
        this.direction = direction;
    }

    public String getStateA() {
        return this.stateA;
    }

    public char getSymbolRead() {
        return this.symbolRead;
    }

    public String getStateB() {
        return this.stateB;
    }

    public char getSymbolWrite() { return this.symbolWrite; }

    public char getDirection() { return this.direction; }
}
