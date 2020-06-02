package ai.brace;

import java.io.Reader;
import java.nio.file.*;
import ai.brace.models.*;
import com.google.gson.Gson;

public class Main
{
    /* Note: Spent more time then wanted on environment issues :(
    *   IntelliJ had issues at first, after some debugging switched to vs code
    *   VS Code had issues... after some debugging switched back
    *   Further debugging in intellij and finally was able to find the issue under.
    *       Issue was the build configuration did not point to gradle properly.
    *  */
    public static void main(String[] args)
    {
        Gson gson = new Gson();
        Path a1JsonPath = Paths.get("src/main/resources/a1.json");
        try{
            Reader reader = Files.newBufferedReader(a1JsonPath);
            BraceBook book = gson.fromJson(reader,BraceBook.class);
            System.out.println(book);

            // close reader
            reader.close();
        } catch(Exception err) {
            System.out.println("Error: " + err);
        }
    }
}
