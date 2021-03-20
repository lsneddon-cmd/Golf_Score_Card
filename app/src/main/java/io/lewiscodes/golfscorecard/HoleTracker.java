package io.lewiscodes.golfscorecard;

public class HoleTracker {
    private final int holeNumber;
    private int strokes;

    public HoleTracker(int holeNumber) {
        this.holeNumber = holeNumber;
        this.strokes = 0;
    }

    public String getHoleName() {
        return "Hole " + String.valueOf(holeNumber);
    }

    public int getStrokes() {
        return strokes;
    }

    public void incrementStrokes() {
        strokes++;
    }

    public void decrementStrokes() {
        if (strokes > 0) strokes--;
    }
}
