public class FurnaceRelay extends Relay{
    private final Furnace furnace;

    public FurnaceRelay(){
        furnace=new Furnace();
    }

    public void close(ThermostateController t){
        super.close();
        furnace.turnOnFurnace();
    }
    public void open(ThermostateController t){
        super.open();
       furnace.turnOffFurnace();
    }
    @Override
    public void close(){
        super.close();
        furnace.turnOnFurnace();
    }
    @Override
    public void open(){
        super.open();
        furnace.turnOffFurnace();
    }

}
