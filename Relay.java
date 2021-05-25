public abstract class Relay {
    protected enum Status {Close_DeviceOn, Open_DeviceOff}
    protected Status curr_stat = Status.Open_DeviceOff;

    public boolean isOpen(){
        return curr_stat==Status.Open_DeviceOff;
    }
    public boolean isClose(){ return curr_stat==Status.Close_DeviceOn; }

    public void open(){ curr_stat= BlowerRelay.Status.Open_DeviceOff; }
    public void close(){ curr_stat= BlowerRelay.Status.Close_DeviceOn; }

    @Override
    public String toString() {
        return curr_stat.name();
    }
}

