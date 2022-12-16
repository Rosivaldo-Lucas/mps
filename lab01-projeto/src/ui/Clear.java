package ui;

import exception.ClearError;

public class Clear {

    public Clear() {
    }

    public static void clear() {

        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();  
            else
                new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            new ClearError().getMessage();
        }

    }
}
