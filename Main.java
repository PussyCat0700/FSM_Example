import java.util.Scanner;
//对于SeasonSwitch的管理：
// 若不置为OFF（维持原状态），则调用seansonswitch.timeroff()，让用户决定温度是不是高于标准（isHotter）
public class Main {
    public static void main(String[] args){
        ThermostateController t = new ThermostateController();
        Scanner scan = new Scanner(System.in);
        while(true){
            displayStatus(t);
            System.out.println("Switch Panel: ");
            System.out.println("1>HEAT\n2>COOL\n3>OFF");
            int n=scan.nextInt();
            switch (n) {
                case 1 -> {
                    t.heat();
                    t.seasonSwitch.timerOff(t);
                }
                case 2 -> {
                    t.cool();
                    t.seasonSwitch.timerOff(t);
                }
                case 3 -> t.off();
                default -> System.out.println("Nothing changed");
            }
            displayStatus(t);
            System.out.println("Fan Switch: ");
            System.out.println("0>quit\n1>Fan\n2>AUTO");
            n=scan.nextInt();
            switch (n) {
                case 1 -> t.fan();
                case 2 -> t.auto();
                default -> System.out.println("Nothing changed");
            }
            if(n==0) break;
        }
    }
    static void displayStatus(ThermostateController t){
        System.err.println("Status: ");
        System.err.println("SeasonSwitch:"+t.seasonSwitch);
        System.err.println("acRelay: "+t.acRelay);
        System.err.println("blowerRelay: "+t.blowerRelay);
        System.err.println("furnaceRelay: "+t.furnaceRelay);
        System.err.println("fanswitch: "+(t.fanSwitch.isAuto()?"Auto":"Fan"));
    }
}
