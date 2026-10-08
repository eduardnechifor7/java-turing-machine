import java.util.*;

public class TransitionList {

    private ArrayList<Transition> list = new ArrayList<Transition>();

    public void addTransition(Transition tr) {
        this.list.add(tr);
    }

    public Transition findTransition(String state, char symbol) {
        for (Transition tmp : this.list) {
            if (tmp.getStateA().equals(state) && tmp.getSymbolRead() == symbol) {
                return tmp;
            }
        }
        return null;
    }

    public ArrayList<Transition> getList() {
        return list;
    }
}
