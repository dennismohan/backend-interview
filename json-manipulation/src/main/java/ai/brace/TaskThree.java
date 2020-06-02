package ai.brace;

import ai.brace.models.BraceBook;
import ai.brace.models.BraceQuote;

import java.util.*;

public class TaskThree {

    // Note: Skipped out on the bonus stuff but made comments on how it can be handled.
    // Prioritizing tasks over it
    // Note 2: due to time constraints here, i did not actually make a new branch for Task 3 early enough! oops!
    public static void execute() {
        List<BraceBook> books;
        try {
            String[] fileList = {"a1.json", "a2.json"};
            books = TaskUtils.readBooksFromFiles(fileList);
        } catch (TaskUtils.ReadBraceBookException err) {
            System.out.println("Failed to read " + err.getMessage());
            return;
        }
        List<BraceQuote> quotes = TaskUtils.mergeBookQuotes(books);
        List<String> quoteWords = getAllWordsFromQuotes(quotes);
        Map<String, Integer> wordCount  = getWordCount(quoteWords);
        for(String key:wordCount.keySet()) {
            // This string concatenation could be done better, eg string buffer
            // Note: This task looks like its printing the words in a sorted order.
            // Not sure if thats part of the requirement, but wanted to clarify
            // that it would take a little more work here to achieve output that is
            // sorted in ascending order by word.
            System.out.println("(" + key + ") : " + wordCount.get(key));
        }
    }

    public static List<String> getAllWordsFromQuotes(List<BraceQuote> quotes) {
        List<String> allWords = new ArrayList<String>();
        // A more efficient, but less readable solution would be to iterate over all characters
        // and when we deem the word is complete, add it to the splitWords List.
        for(BraceQuote quote:quotes) {
            List<String> splitWords = Arrays.asList(quote.getTextData().split(" "));
            // implement a cleanup function here
            // function can switch to case insensitive, remove punctuation via regex, etc..
            allWords.addAll(splitWords);
        }
        return allWords;
    }
    public static Map<String, Integer> getWordCount(List<String> words) {
        Map<String, Integer> wordCount = new HashMap<>();
        for(String word:words) {
            if(!wordCount.containsKey(word)) {
                wordCount.put(word, 0);
            }
            Integer currentCount = wordCount.get(word);
            wordCount.put(word, currentCount+1);
        }
        return wordCount;
    }
}
