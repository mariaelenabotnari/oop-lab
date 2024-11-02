package LAB2.Task3;

import LAB2.Task1.Display;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assistant {
    private String assistantName;
    private static List<Display> assignedDisplays;

    public Assistant() {
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

    public void assignDisplay(Display monitor1) {
        assignedDisplays.add(monitor1);
        System.out.println("List of monitors: ");
        System.out.println(assignedDisplays);
    }

    public void assist() {
        for (int i = 0; i < assignedDisplays.size(); i++) {
            for (int j = i + 1; j < assignedDisplays.size(); j++) {
                assignedDisplays.get(i).compareWithMonitors(assignedDisplays.get(j));
            }
        }
    }

    public static Display chooseMonitor() {
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

    public static Display buyDisplay(Display monitorToBuy) {
        Display currentDisplay = null;
        for (int i = 0; i < assignedDisplays.size(); i++) {
            currentDisplay = assignedDisplays.get(i);
            if (monitorToBuy.getModel().equals(currentDisplay.getModel()) &&
                    monitorToBuy.getHeight() == currentDisplay.getHeight() &&
                    monitorToBuy.getWidth() == currentDisplay.getWidth() &&
                    monitorToBuy.getPpi() == currentDisplay.getPpi()) {
                assignedDisplays.remove(i);
                break;
            }
        }
        System.out.println("\nRemaining Monitors: ");
        for (int i = 0; i < assignedDisplays.size(); i++) {
            System.out.println((i + 1) + ": " + assignedDisplays.get(i));
        }
        return currentDisplay;
    }
}
