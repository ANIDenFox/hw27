import java.util.Random;

class TypingSpeedModel {
    private String currentText;
    private String[] texts = {
            "beneath the canopy of stars with the faint glow of fireflies dancing around me i lie on the grass lost in wonder at the vastness of the universe and the beauty of the night",
            "amidst the bustling city streets i find solace in the quiet corners of hidden cafes where the aroma of freshly brewed coffee mingles with the soft hum of conversation creating a sanctuary away from the chaos",
            "as the first rays of dawn peek over the horizon painting the sky in a kaleidoscope of colors i stand atop a mountain peak feeling a sense of accomplishment surge through me knowing that every step of the challenging journey was worth it for this breathtaking view"
    };
    private Random random = new Random();
    private long startTime;
    private boolean testStarted;

    public String getCurrentText() {
        return currentText;
    }

    public void startTest() {
        currentText = texts[random.nextInt(texts.length)];
        startTime = System.currentTimeMillis();
        testStarted = true;
    }

    public void endTest() {
        testStarted = false;
    }

    public boolean isTestStarted() {
        return testStarted;
    }

    public int calculateErrors(String userInput) {
        int errors = 0;
        for (int i = 0; i < userInput.length() && i < currentText.length(); i++) {
            if (userInput.charAt(i) != currentText.charAt(i)) {
                errors++;
            }
        }
        return errors;
    }

    public double calculateWPM(String userInput) {
        long elapsedTime = System.currentTimeMillis() - startTime;
        int wordsTyped = userInput.trim().split("\\s+").length;
        double minutes = elapsedTime / 60000.0;
        return wordsTyped / minutes;
    }
}