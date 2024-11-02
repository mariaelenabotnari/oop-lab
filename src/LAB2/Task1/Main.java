package LAB2.Task1;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nTask 1: ");

        Display monitor1 = new Display(596, 335, 163, "Dell UltraSharp U2720Q");
        Display monitor2 = new Display(607, 356, 163, "LG 27GN950-B");
        Display monitor3 = new Display(611, 367, 109, "ASUS TUF Gaming VG27AQ");

        System.out.println("Comparing the sizes of the monitors:");
        monitor1.compareSize(monitor2);
        monitor2.compareSize(monitor3);

        System.out.println("\nComparing the sharpness of the monitors:");
        monitor1.compareSharpness(monitor2);
        monitor2.compareSharpness(monitor3);

        System.out.println("\nCompare the monitors from the point of view of both size and sharpness:");
        monitor1.compareWithMonitors(monitor2);
        monitor2.compareWithMonitors(monitor3);
    }
}
