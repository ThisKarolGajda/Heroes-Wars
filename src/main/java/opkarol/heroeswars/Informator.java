package opkarol.heroeswars;

public class Informator {

    private static boolean debugModeActive = false; //TODO Change to auto-updating value from config.

    public static boolean isDebugModeActive() {
        return debugModeActive;
    }

    public static void setDebugModeActive(boolean debugModeActive2) {
        debugModeActive = debugModeActive2;
    }
}

