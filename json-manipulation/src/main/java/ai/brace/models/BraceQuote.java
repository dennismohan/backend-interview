package ai.brace.models;

public class BraceQuote implements Comparable<BraceQuote>{
    private int id;
    private String textdata;
    BraceQuote() {
        // default no-args constructor
    }

    /* Thoughts:
        I did not want to waste to much time, so I used the IDE's generate getter feature.
        Ideally if I have extra time before deadline, i'll come back to clean this up and use lombok.
     */
    public int getId() {
        return id;
    }

    public String getTextData() {
        return textdata;
    }

    @Override
    public int compareTo(BraceQuote quote) {
        return id - quote.getId();
    }
}