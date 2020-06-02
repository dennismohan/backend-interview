package ai.brace;

import ai.brace.models.BraceBook;
import ai.brace.models.BraceQuote;

import java.util.ArrayList;
import java.util.List;

public class TaskTwo {
    public static void execute() {
        String basePath = "src/main/resources/";
        String[] fileList = {"a1.json", "a2.json"};
        List<BraceBook> books = new ArrayList<BraceBook>();
        try{
            for(String fileName:fileList){
                BraceBook book = TaskUtils.getBraceBook(basePath + fileName);
                books.add(book);
            }
        } catch(TaskUtils.ReadBraceBookException err) {
            System.out.println("Failed to read " + err.getMessage());
            return;
        }

        List<BraceQuote> allQuotes = TaskUtils.mergeBookQuotes(books);
        TaskUtils.sortAndPrint(allQuotes);
    }
}
