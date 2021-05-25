public class BlowerRelay extends Relay{
    private final Blower blower;

    public BlowerRelay(){
        blower = new Blower();
    }

    public void close(ThermostateController t){
        super.close();
        blower.turnOnBlower();
    }
    @Override
    public void close(){
        super.close();
        blower.turnOnBlower();
    }

    public void open(ThermostateController t){
        if(t.fanSwitch.isAuto()) {
            super.open();
            blower.turnOffBlower();
        }
    }
}
