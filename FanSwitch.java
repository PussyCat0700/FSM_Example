public class FanSwitch {
    private enum Status {FAN,AUTO}
    private Status status = Status.AUTO;
    public void fan(ThermostateController t){
        status=Status.FAN;
        t.blowerRelay.close();
    }
    public void auto(ThermostateController t){
        status=Status.AUTO;
        if(t.acRelay.isClose()||t.furnaceRelay.isClose()){
            t.blowerRelay.close();
        }
        else if(t.acRelay.isOpen()&&t.furnaceRelay.isOpen()){
            t.blowerRelay.open();//可否直接换成else？
        }
    }
    public boolean isAuto(){
        return status==Status.AUTO;
    }
}
