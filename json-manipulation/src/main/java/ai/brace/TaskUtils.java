package ai.brace;

import ai.brace.models.BraceBook;
import ai.brace.models.BraceQuote;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskUtils {
    public static BraceBook getBraceBook(String relativePath) throws ReadBraceBookException {
        BraceBook book;
        Path a1JsonPath = Paths.get(relativePath);
        Reader reader;
        try {
            reader = Files.newBufferedReader(a1JsonPath);
            book = Main.gson.fromJson(reader, BraceBook.class);

            reader.close();
        }catch(IOException err) {
            throw new ReadBraceBookException();
        }
        return book;
    }

    // Note: This function wont be easily testable without refactoring.
    public static void sortAndPrint(List<BraceQuote> quotes) {
        // This function could present a potential pitfall, and should be addressed in production ready code
        // currently sort will mutate the List being passed in, this is a bad practice.
        //
        // A potential solution is to clone the list being passed in,
        // however more data is needed to make a solid decision here;
        //      eg: amount of quotes coming in, is it 10-100 or 100k-1m
        Collections.sort(quotes);
        for(BraceQuote quote:quotes){
            System.out.println(quote.getTextData());
        }
    }

    public static List<BraceQuote> mergeBookQuotes(List<BraceBook> books) {
        List<BraceQuote> quotes = new ArrayList<BraceQuote>();
        for(BraceBook book:books) {
            quotes.addAll(book.getTextArray());
        }
        return quotes;
    }

    //  TODO: Should store some data for debugging: relative path, error message that occured
    // (i believe stack is stored due to parent being Exception)
    public static class ReadBraceBookException extends Exception{}
}
