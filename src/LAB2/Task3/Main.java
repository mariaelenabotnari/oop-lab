package LAB2.Task3;

import LAB2.Task1.Display;

public class Main {
    public static void main(String[] args) {

        Display monitor1 = new Display(596, 335, 163, "Dell UltraSharp U2720Q");
        Display monitor2 = new Display(607, 356, 163, "LG 27GN950-B");
        Display monitor3 = new Display(611, 367, 109, "ASUS TUF Gaming VG27AQ");

        System.out.println("\nTask 3: ");
        Assistant assistant = new Assistant();
        assistant.assignDisplay(monitor1);
        assistant.assignDisplay(monitor2);
        assistant.assignDisplay(monitor2);
        assistant.assignDisplay(monitor3);

        System.out.println("\nComparing objects");
        assistant.assist();

        Display monitorToBuy = Assistant.chooseMonitor();
        Assistant.buyDisplay(monitorToBuy);
        assistant.assist();
    }
}
