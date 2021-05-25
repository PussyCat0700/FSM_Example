public class Timer{
    public enum Time {On,OFF}
    Time time =Time.OFF;
    public void start(){
        time=Time.On;
    }
    public void stop(){
        time=Time.OFF;
    }
}