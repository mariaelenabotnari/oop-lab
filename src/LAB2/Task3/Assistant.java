package LAB2.Task3;

import LAB2.Task1.Display;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assistant {
    private String assistantName;
    private static List<Display> assignedDisplays;

    public Assistant() {
        // Initialize the list in the constructor
        assignedDisplays = new ArrayList<>();
    }

    public void setAssistantName(String assistantName) {
        this.assistantName = assistantName;
    }

    public String getAssistantName() {
        return assistantName;
    }

    public static List<Display> getAssignedDisplays() {
        return assignedDisplays;
    }

    void assignDisplay(Display Monitor1, Display Monitor2, Display Monitor3) {
        getAssignedDisplays().add(Monitor1);
        getAssignedDisplays().add(Monitor2);
        getAssignedDisplays().add(Monitor3);
        System.out.println("List of monitors: ");
        System.out.println(getAssignedDisplays());
    }

    static void assist () {
        ArrayList<Integer> sizes = new ArrayList<Integer>();

        for (int i = 0; i < assignedDisplays.size(); i++) {
            int size = assignedDisplays.get(i).getWidth() * assignedDisplays.get(i).getHeight();
            sizes.add(size);
        }

        Display.compareWithMonitors(sizes.get(0), sizes.get(1), sizes.get(2), assignedDisplays.get(0), assignedDisplays.get(1), assignedDisplays.get(2));
    }

    static Display chooseMonitor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAvailable Monitors:");
        for (int i = 0; i < assignedDisplays.size(); i++) {
            System.out.println((i + 1) + ": " + assignedDisplays.get(i));
        }
        System.out.print("\nChoose a monitor by entering the corresponding number: ");
        int choice = scanner.nextInt();

        if (choice > 0 && choice <= assignedDisplays.size()) {
            return assignedDisplays.get(choice - 1);
        } else {
            return null;
        }
    }

    static Display buyDisplay(Display MonitorToBuy) {
        Display currentDisplay = null;
        for (int i = 0; i < assignedDisplays.size(); i++) {
            currentDisplay = assignedDisplays.get(i);
            if (MonitorToBuy.getModel().equals(currentDisplay.getModel()) &&
                    MonitorToBuy.getHeight() == currentDisplay.getHeight() &&
                    MonitorToBuy.getWidth() == currentDisplay.getWidth() &&
                    MonitorToBuy.getPpi() == currentDisplay.getPpi()) {
                assignedDisplays.remove(i);
            }
        }
        System.out.println("\nRemaining Monitors: ");
        for (int i = 0; i < assignedDisplays.size(); i++) {
            System.out.println((i + 1) + ": " + assignedDisplays.get(i));
        }
        return currentDisplay;
    }
}
