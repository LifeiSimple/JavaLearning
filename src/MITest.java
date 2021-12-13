public class MITest implements MyImplement {
    private String tString;

    public MITest(String s) {
        this.settString(s);
    }

    public String gettString() {
        return tString;
    }

    public void settString(String tString) {
        this.tString = tString;
    }

    @Override
    public String testString(String s) {
        String s1 = this.gettString() + s + "add string test";
        return s1;
    }
}