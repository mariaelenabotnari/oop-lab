package LAB2.Task3;

import LAB2.Task1.Display;

public class Main {
    public static void main(String[] args) {

        Display Monitor1 = new Display(596, 335, 163, "Dell UltraSharp U2720Q");
        Display Monitor2 = new Display(607, 356, 163, "LG 27GN950-B");
        Display Monitor3 = new Display(611, 367, 109, "ASUS TUF Gaming VG27AQ");

        System.out.println("\nTask 3: ");
        Assistant assistant = new Assistant();
        assistant.assignDisplay(Monitor1, Monitor2, Monitor3);

        System.out.println("\nComparing objects");
        Assistant.assist();
        Display monitorToBuy = Assistant.chooseMonitor();
        Assistant.buyDisplay(monitorToBuy);
    }
}
