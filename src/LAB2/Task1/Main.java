package LAB2.Task1;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nTask 1: ");

        Display Monitor1 = new Display(596, 335, 163, "Dell UltraSharp U2720Q");
        Display Monitor2 = new Display(607, 356, 163, "LG 27GN950-B");
        Display Monitor3 = new Display(611, 367, 109, "ASUS TUF Gaming VG27AQ");

        int size1 = Monitor1.getWidth() * Monitor1.getHeight();
        int size2 = Monitor2.getWidth() * Monitor2.getHeight();
        int size3 = Monitor3.getWidth() * Monitor3.getHeight();

        System.out.println("Comparing the sizes of the monitors");
        Display.compareSize(size1, size2, size3, Monitor1, Monitor2, Monitor3);

        System.out.println("\nComparing the sharpness of the monitors");
        Display.compareSharpness(Monitor1, Monitor2, Monitor3);

        System.out.println("\nCompare the monitors from the point of view of both size and sharpness");
        Display.compareWithMonitors(size1, size2, size3, Monitor1, Monitor2, Monitor3);

    }
}
