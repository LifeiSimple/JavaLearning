package v1ch08.pair1;

public class Pair<B> {
    private B first;
    private B second;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(B first, B second) {
        this.first = first;
        this.second = second;
    }

    public B getFirst() {
        return first;
    }

    public void setFirst(B first) {
        this.first = first;
    }

    public B getSecond() {
        return second;
    }

    public void setSecond(B second) {
        this.second = second;
    }
}
