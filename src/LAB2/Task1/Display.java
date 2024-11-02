package LAB2.Task1;

public class Display {
    private int width;
    private int height;
    private float ppi;
    private String model;

    //Constructor
    public Display(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Task1.Display{" +
                "width=" + width +
                ", height=" + height +
                ", ppi=" + ppi +
                ", model='" + model + '\'' +
                '}';
    }

    //Getters
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getPpi() {
        return ppi;
    }

    public String getModel() {
        return model;
    }

    public void compareSize(Display Monitor) {
        int size1 = this.height * this.width;
        int size2 = Monitor.height * Monitor.width;

        if (size1 > size2) {
            System.out.println(this.model + " with a display size of " + size1 + " mm " + " has a bigger display size than " + Monitor.model  + " with a display size of " + size2 + " mm " );
        }

        else if (size1 == size2) {
            System.out.println(this.model + " with a display size of " + size1 + " mm " + " has the same display size as " + Monitor.model  + " with a display size of " + size2 + " mm " );
        }

        else if (size1 < size2) {
            System.out.println(Monitor.model + " with a display size of " + size2 + " mm " + " has a bigger display size than " + this.model  + " with a display size of " + size1 + " mm " );
        }
    }

    public void compareSharpness(Display Monitor) {
        if (this.ppi > Monitor.ppi) {
            System.out.println(this.model + " with a sharpness of " + this.ppi + " has a bigger sharpness than " + Monitor.model  + " with a sharpness of " + Monitor.ppi);
        }
        else if (this.ppi < Monitor.ppi) {
            System.out.println(Monitor.model + " with a sharpness of " + Monitor.ppi + " has a bigger sharpness than " + this.model  + " with a sharpness of " + this.ppi);
        }
        else if (this.ppi == Monitor.ppi) {
            System.out.println(this.model + " with a sharpness of " + this.ppi + " has the same sharpness as " + Monitor.model  + " with a sharpness of " + Monitor.ppi);
        }
    }

    public void compareWithMonitors(Display Monitor) {
        this.compareSharpness(Monitor);
        this.compareSize(Monitor);
    }
}