import java.util.Scanner;

public class TempSensor {
//    private double roomTemp;
    private boolean isHotter;
    boolean getIsHotter(){
        //模拟getRoomTemp的用户交互（实际应用中不需要）
        System.out.println("Is the room hotter than usual? enter true for hotter and false otherwise.");
        Scanner scan = new Scanner(System.in);
        try{
            isHotter = scan.nextBoolean();
        }catch(Exception e){
            System.err.println("Please Input A boolean type. isHotter="+isHotter);
        }
        return isHotter;
    }
}
