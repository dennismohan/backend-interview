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
            BraceBook book = TaskUtils.getBraceBook(relativeFilePath);
            bookQuotes = Arrays.asList(book.getTextArray());
        } catch(TaskUtils.ReadBraceBookException err) {
            System.out.println("Failed to read " + relativeFilePath);
            return;
        }

        TaskUtils.sortAndPrint(bookQuotes);
    }
}
