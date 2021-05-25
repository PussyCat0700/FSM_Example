public class ThermostateController {
    final ACRelay acRelay;
    final BlowerRelay blowerRelay;
    final FurnaceRelay furnaceRelay;
    final FanSwitch fanSwitch;
    final TempSensor tempSensor;
    final SeasonSwitch seasonSwitch;
    final Timer timer;

    public ThermostateController() {
        acRelay = new ACRelay();
        blowerRelay = new BlowerRelay();
        furnaceRelay = new FurnaceRelay();
        fanSwitch = new FanSwitch();
        tempSensor = new TempSensor();
        seasonSwitch = new SeasonSwitch();
        timer = new Timer();
    }
    public void heat(){
        seasonSwitch.heat(this);
        timer.start();
    }
    public void cool(){
        seasonSwitch.cool(this);
        timer.start();
    }
    public void off(){
        timer.stop();
        seasonSwitch.off(this);
    }
    public void fan(){
        fanSwitch.fan(this);
    }
    public void auto(){
        fanSwitch.auto(this);
    }
    public void frOpen(){
        furnaceRelay.open();
        checkFanSwitch();
    }
    public void frClose(){
        furnaceRelay.close();
        checkFanSwitch();
    }
    public void arOpen(){
        acRelay.open();
        checkFanSwitch();
    }
    public void arClose(){
        acRelay.close();
        checkFanSwitch();
    }
    private void checkFanSwitch(){
        if(fanSwitch.isAuto()) fanSwitch.auto(this);
    }
}
