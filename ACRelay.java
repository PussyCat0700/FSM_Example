public class ACRelay extends Relay {
    private final AC ac;

    public ACRelay() {
        ac = new AC();
    }


    public void close(ThermostateController t) {
        super.close();
        ac.turnOnAC();
    }

    public void open(ThermostateController t) {
        super.open();
        ac.turnOffAC();
    }
    @Override
    public void close() {
        super.close();
        ac.turnOnAC();
    }
    @Override
    public void open() {
        super.open();
        ac.turnOffAC();
    }

}
