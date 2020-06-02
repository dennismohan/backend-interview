package ai.brace;

import ai.brace.models.BraceBook;
import ai.brace.models.BraceQuote;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class TaskFour {

    public static void execute() {
        List<BraceBook> books;
        try {
            String[] fileList = {"a1.json", "a2.json"};
            books = TaskUtils.readBooksFromFiles(fileList);
        } catch (TaskUtils.ReadBraceBookException err) {
            System.out.println("Failed to read " + err.getMessage());
            return;
        }

        // sort in correct order to start merging
        Collections.sort(books);
        BraceBook mergedBook = books.get(0);
        // Start at index 1 because first book does not need to be merged
        for(int i = 1; i < books.size(); i++) {
            // What do we do if book is exactly the same age
            // something worth discussing, however for now treated as a standard merge
            mergedBook = mergeBooks(mergedBook, books.get(i));
        }


        // should probably be in its own function and cleaned up
        String mergedBraceBookJson = Main.gson.toJson(mergedBook);
        Path path = Paths.get(TaskUtils.BASE_PATH + "mergedOutput.json");
        byte[] strToBytes = mergedBraceBookJson.getBytes();

        try {
            Files.write(path, strToBytes);
        } catch (IOException e) {
            System.out.println("Failed to write merged json output to file: " + e);
        }
    }

    // Note: I have a lot to be unhappy about in this function. Ultimately though
    // Having it completed versus having it nice, elegant, and clean takes priority sometimes imo
    public static BraceBook mergeBooks(BraceBook oldBook, BraceBook newBook) {
        if(newBook.getVersion() != null) {
            oldBook.setVersion(newBook.getVersion());
        }
        if(newBook.getLastModified() != 0) {
            oldBook.setLastModified(newBook.getLastModified());
        }
        if(newBook.getTitle() != null) {
            oldBook.setTitle(newBook.getTitle());
        }
        if(newBook.getAuthor() != null) {
            oldBook.setAuthor(newBook.getAuthor());
        }
        if(newBook.getTranslator() != null) {
            oldBook.setTranslator(newBook.getTranslator());
        }
        if(newBook.getLanguage() != null) {
            oldBook.setLanguage(newBook.getLanguage());
        }

        // Quicky, and hacky way to merge quotes due to time!
        // Add all quotes to a map, this will remove any dupes
        // Run through old book first, this way if its not in new one itll still be there
        // Run through new book last so that newer values replace old ones
        // Pull all values from map and set them to the old book, which in turn is out "merge book"
        Map<Integer, BraceQuote> uniqueQuotes = new HashMap<Integer, BraceQuote>();
        // Redundant code that should really not be here... (time :( constraints)
        for(BraceQuote oldQuote:oldBook.getTextArray()) {
            uniqueQuotes.put(oldQuote.getId(), oldQuote);
        }
        for(BraceQuote newQuote:newBook.getTextArray()) {
            uniqueQuotes.put(newQuote.getId(), newQuote);
        }

        oldBook.setTextArray(new ArrayList<BraceQuote>(uniqueQuotes.values()));
        return oldBook;
    }
}
