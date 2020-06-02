package ai.brace;

import ai.brace.models.BraceBook;
import ai.brace.models.BraceQuote;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TaskOne {

    public static void execute(){
        String relativeFilePath = "src/main/resources/a1.json";
        List<BraceQuote> bookQuotes;
        try{
            BraceBook book = TaskOne.getBraceBook(relativeFilePath);
            bookQuotes = Arrays.asList(book.getTextArray());
        } catch(ReadBraceBookException err) {
            System.out.println("Failed to read " + relativeFilePath);
            return;
        }

        Collections.sort(bookQuotes);
        for(BraceQuote quote:bookQuotes){
            System.out.println(quote.getTextData());
        }
    }

    private static BraceBook getBraceBook(String relativePath) throws ReadBraceBookException {
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

    //  TODO: Should store some data for debugging: relative path, error message that occured
    // (i believe stack is stored due to parent being Exception)
    private static class ReadBraceBookException extends Exception{}
}
