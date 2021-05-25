//这里的timer是用状态模拟的：在timer为On时，用户可以立刻让timer到期（变为Off）。
//因此，相较于时间到了自动调用timerOff方法，我的实现要求用户必须显式调用timerOff才能够关闭定时器。
public class SeasonSwitch {
    public enum Status {HEAT,OFF,COOL}
    Status curr_stat = Status.OFF;
    public void heat(ThermostateController t){
        curr_stat=Status.HEAT;
    }
    public void cool(ThermostateController t){
        curr_stat=Status.COOL;
    }
    public void off(ThermostateController t){
        if(curr_stat==Status.HEAT){
            t.frOpen();
        }
        else if(curr_stat==Status.COOL){
            t.arOpen();
        }
    }
    public void timerOff(ThermostateController t){
        t.timer.stop();//由于是模拟的，所以本来应该在外部的触发条件写在了这里面，实际应用时不能这样
        boolean isHotter = t.tempSensor.getIsHotter();
        if(curr_stat==Status.HEAT){
            if(isHotter) t.frOpen();
            else t.frClose();
        }
        else if(curr_stat==Status.COOL){
            if(isHotter) t.arClose();
            else t.arOpen();
        }
        t.timer.start();
    }

    @Override
    public String toString() {
        return curr_stat.name();
    }
}