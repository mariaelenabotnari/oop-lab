package LAB2.Task1;

public class Display {
    private int width;
    private int height;
    private float ppi;
    private String model;

    //Constructor
    public Display (int width, int height, float ppi, String model) {
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

    public static void compareSize(int size1, int size2, int size3, Display Monitor1, Display Monitor2, Display Monitor3) {
        if (size1 > size2) {
            System.out.println(Monitor1.model + " with a display size of " + size1 + " mm " + " has a bigger display size than " + Monitor2.model  + " with a display size of " + size2 + " mm " );
        }
        else if (size1 < size2) {
            System.out.println(Monitor2.model  + " with a display size of " + size2 + " mm "  + " has a bigger display size than " + Monitor1.model  + " with a display size of " + size1 + " mm " );
        }
        else {
            System.out.println(Monitor1.model + " and " + Monitor2.model + " have the same display size " + " with a size of " + size1 + " mm " );
        }

        if (size2 > size3) {
            System.out.println(Monitor2.model + " with a display size of " + size2 + " mm "  + " has a bigger display size than " + Monitor3.model + " with a display size of " + size3 + " mm " );
        }
        else if (size2 < size3) {
            System.out.println(Monitor3.model + " with a display size of " + size3 + " mm "  + " has a bigger display size than " + Monitor2.model + " with a display size of " + size2 + " mm " );
        }
        else {
            System.out.println(Monitor2.model + " and " + Monitor3.model + " have the same display size " + " with a size of " + size2 + " mm " );
        }

        if (size1 > size3) {
            System.out.println(Monitor1.model + " with a display size of " + size1 + " mm "  + " has a bigger display size than " + Monitor3.model + " with a display size of " + size3 + " mm " );
        }
        else if (size1 < size3) {
            System.out.println(Monitor3.model + " with a display size of " + size3 + " mm "  + " has a bigger display size than " + Monitor1.model + " with a display size of " + size1 + " mm " );
        }
        else {
            System.out.println(Monitor1.model + " and " + Monitor3.model + " have the same display size " + " with a size of " + size3 + " mm " );
        }
    }

    public static void compareSharpness(Display Monitor1, Display Monitor2, Display Monitor3) {
        if (Monitor1.ppi > Monitor2.ppi) {
            System.out.println(Monitor1.model + " with a sharpness of " + Monitor1.ppi + " is sharper than " + Monitor2.model + " with a sharpness of " + Monitor2.ppi);
        }
        else if (Monitor2.ppi > Monitor1.ppi) {
            System.out.println(Monitor2.model + " with a sharpness of " + Monitor2.ppi + " is sharper than " + Monitor1.model  + " with a sharpness of " + Monitor1.ppi);
        }
        else {
            System.out.println(Monitor1.model + " and " + Monitor2.model + " have the same sharpness of " + Monitor1.ppi);
        }

        if (Monitor2.ppi > Monitor3.ppi) {
            System.out.println(Monitor2.model + " with a sharpness of " + Monitor2.ppi + " is sharper than " + Monitor3.model  + " with a sharpness of " + Monitor3.ppi);
        }
        else if (Monitor3.ppi > Monitor2.ppi) {
            System.out.println(Monitor3.model  + " with a sharpness of " + Monitor3.ppi + " is sharper than " + Monitor2.model + " with a sharpness of " +  Monitor2.ppi);
        }
        else {
            System.out.println(Monitor2.model + " and " + Monitor3.model + " have the same sharpness of " + Monitor2.ppi);
        }

        if (Monitor1.ppi > Monitor3.ppi) {
            System.out.println(Monitor1.model + " with a sharpness of " + Monitor1.ppi + " is sharper than " + Monitor3.model  + " with a sharpness of " +  Monitor3.ppi);
        }
        else if (Monitor2.ppi > Monitor1.ppi) {
            System.out.println(Monitor3.model  + " with a sharpness of " + Monitor3.ppi + " is sharper than " + Monitor1.model  + " with a sharpness of " + Monitor1.ppi);
        }
        else {
            System.out.println(Monitor1.model + " and " + Monitor3.model + " have the same sharpness of " + Monitor3.ppi);
        }
    }

    public static void compareWithMonitors(int size1, int size2, int size3, Display Monitor1, Display Monitor2, Display Monitor3) {
        if (size1 > size2) {
            if (Monitor1.ppi > Monitor2.ppi) {
                System.out.println(Monitor1.model + " with a display size of " + size1 + " mm and a sharpness of " + Monitor1.ppi +
                        " is bigger and sharper than " + Monitor2.model + " with a display size of " + size2 + " mm and a sharpness of " + Monitor2.ppi);
            } else if (Monitor1.ppi < Monitor2.ppi) {
                System.out.println(Monitor2.model + " with a display size of " + size2 + " mm and a sharpness of " + Monitor2.ppi +
                        " is smaller but sharper than " + Monitor1.model + " with a display size of " + size1 + " mm and a sharpness of " + Monitor1.ppi);
            } else {
                System.out.println(Monitor1.model + " with a display size of " + size1 + " mm and a sharpness of " + Monitor1.ppi +
                        " is bigger and has the same sharpness as " + Monitor2.model + " with a display size of " + size2 + " mm and a sharpness of " + Monitor2.ppi);
            }
        } else if (size1 < size2) {
            if (Monitor1.ppi > Monitor2.ppi) {
                System.out.println(Monitor1.model + " with a display size of " + size1 + " mm and a sharpness of " + Monitor1.ppi +
                        " is smaller but sharper than " + Monitor2.model + " with a display size of " + size2 + " mm and a sharpness of " + Monitor2.ppi);
            } else if (Monitor1.ppi < Monitor2.ppi) {
                System.out.println(Monitor2.model + " with a display size of " + size2 + " mm and a sharpness of " + Monitor2.ppi +
                        " is bigger and sharper than " + Monitor1.model + " with a display size of " + size1 + " mm and a sharpness of " + Monitor1.ppi);
            } else {
                System.out.println(Monitor2.model + " with a display size of " + size2 + " mm and a sharpness of " + Monitor2.ppi +
                        " is bigger but has the same sharpness as " + Monitor1.model + " with a display size of " + size1 + " mm and a sharpness of " + Monitor1.ppi);
            }
        } else {
            if (Monitor1.ppi > Monitor2.ppi) {
                System.out.println(Monitor1.model + " with a display size of " + size1 + " mm and a sharpness of " + Monitor1.ppi +
                        " has the same size but is sharper than " + Monitor2.model + " with a sharpness of " + Monitor2.ppi);
            } else if (Monitor1.ppi < Monitor2.ppi) {
                System.out.println(Monitor2.model + " with a display size of " + size2 + " mm and a sharpness of " + Monitor2.ppi +
                        " has the same size but is sharper than " + Monitor1.model + " with a sharpness of " + Monitor1.ppi);
            } else {
                System.out.println(Monitor1.model + " and " + Monitor2.model + " have the same size of " + size1 + " mm and the same sharpness of " + Monitor1.ppi);
            }
        }

        if (size2 > size3) {
            if (Monitor2.ppi > Monitor3.ppi) {
                System.out.println(Monitor2.model + " with a display size of " + size2 + " mm and a sharpness of " + Monitor2.ppi +
                        " is bigger and sharper than " + Monitor3.model + " with a display size of " + size3 + " mm and a sharpness of " + Monitor3.ppi);
            } else if (Monitor2.ppi < Monitor3.ppi) {
                System.out.println(Monitor3.model + " with a display size of " + size3 + " mm and a sharpness of " + Monitor3.ppi +
                        " is smaller but sharper than " + Monitor2.model + " with a display size of " + size2 + " mm and a sharpness of " + Monitor2.ppi);
            } else {
                System.out.println(Monitor2.model + " with a display size of " + size2 + " mm and a sharpness of " + Monitor2.ppi +
                        " is bigger and has the same sharpness as " + Monitor3.model + " with a display size of " + size3 + " mm and a sharpness of " + Monitor3.ppi);
            }
        } else if (size2 < size3) {
            if (Monitor2.ppi > Monitor3.ppi) {
                System.out.println(Monitor2.model + " with a display size of " + size2 + " mm and a sharpness of " + Monitor2.ppi +
                        " is smaller but sharper than " + Monitor3.model + " with a display size of " + size3 + " mm and a sharpness of " + Monitor3.ppi);
            } else if (Monitor2.ppi < Monitor3.ppi) {
                System.out.println(Monitor3.model + " with a display size of " + size3 + " mm and a sharpness of " + Monitor3.ppi +
                        " is bigger and sharper than " + Monitor2.model + " with a display size of " + size2 + " mm and a sharpness of " + Monitor2.ppi);
            } else {
                System.out.println(Monitor3.model + " with a display size of " + size3 + " mm and a sharpness of " + Monitor3.ppi +
                        " is bigger but has the same sharpness as " + Monitor2.model + " with a display size of " + size2 + " mm and a sharpness of " + Monitor2.ppi);
            }
        } else {
            if (Monitor2.ppi > Monitor3.ppi) {
                System.out.println(Monitor2.model + " with a display size of " + size2 + " mm and a sharpness of " + Monitor2.ppi +
                        " has the same size but is sharper than " + Monitor3.model + " with a sharpness of " + Monitor3.ppi);
            } else if (Monitor2.ppi < Monitor3.ppi) {
                System.out.println(Monitor3.model + " with a display size of " + size3 + " mm and a sharpness of " + Monitor3.ppi +
                        " has the same size but is sharper than " + Monitor2.model + " with a sharpness of " + Monitor2.ppi);
            } else {
                System.out.println(Monitor2.model + " and " + Monitor3.model + " have the same size of " + size2 + " mm and the same sharpness of " + Monitor2.ppi);
            }
        }

        if (size1 > size3) {
            if (Monitor1.ppi > Monitor3.ppi) {
                System.out.println(Monitor1.model + " with a display size of " + size1 + " mm and a sharpness of " + Monitor1.ppi +
                        " is bigger and sharper than " + Monitor3.model + " with a display size of " + size3 + " mm and a sharpness of " + Monitor3.ppi);
            } else if (Monitor1.ppi < Monitor3.ppi) {
                System.out.println(Monitor3.model + " with a display size of " + size3 + " mm and a sharpness of " + Monitor3.ppi +
                        " is smaller but sharper than " + Monitor1.model + " with a display size of " + size1 + " mm and a sharpness of " + Monitor1.ppi);
            } else {
                System.out.println(Monitor1.model + " with a display size of " + size1 + " mm and a sharpness of " + Monitor1.ppi +
                        " is bigger and has the same sharpness as " + Monitor3.model + " with a display size of " + size3 + " mm and a sharpness of " + Monitor3.ppi);
            }
        } else if (size1 < size3) {
            if (Monitor1.ppi > Monitor3.ppi) {
                System.out.println(Monitor1.model + " with a display size of " + size1 + " mm and a sharpness of " + Monitor1.ppi +
                        " is smaller but sharper than " + Monitor3.model + " with a display size of " + size3 + " mm and a sharpness of " + Monitor3.ppi);
            } else if (Monitor1.ppi < Monitor3.ppi) {
                System.out.println(Monitor3.model + " with a display size of " + size3 + " mm and a sharpness of " + Monitor3.ppi +
                        " is bigger and sharper than " + Monitor1.model + " with a display size of " + size1 + " mm and a sharpness of " + Monitor1.ppi);
            } else {
                System.out.println(Monitor3.model + " with a display size of " + size3 + " mm and a sharpness of " + Monitor3.ppi +
                        " is bigger but has the same sharpness as " + Monitor1.model + " with a display size of " + size1 + " mm and a sharpness of " + Monitor1.ppi);
            }
        } else {
            if (Monitor1.ppi > Monitor3.ppi) {
                System.out.println(Monitor1.model + " with a display size of " + size1 + " mm and a sharpness of " + Monitor1.ppi +
                        " has the same size but is sharper than " + Monitor3.model + " with a sharpness of " + Monitor3.ppi);
            } else if (Monitor1.ppi < Monitor3.ppi) {
                System.out.println(Monitor3.model + " with a display size of " + size3 + " mm and a sharpness of " + Monitor3.ppi +
                        " has the same size but is sharper than " + Monitor1.model + " with a sharpness of " + Monitor1.ppi);
            } else {
                System.out.println(Monitor1.model + " and " + Monitor3.model + " have the same size of " + size1 + " mm and the same sharpness of " + Monitor1.ppi);
            }
        }
    }
}

