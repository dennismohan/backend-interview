package ai.brace;

import java.io.Reader;
import java.nio.file.*;
import ai.brace.models.*;
import com.google.gson.Gson;

public class Main
{
    /* Note: Spent more time then wanted on environment issues
    *   IntelliJ had issues importing the build, after some debugging switched to vs code
    *   VS Code had issues, intellisense, debugging, etc... after some debugging switched back
    *   Further debugging in intellij and finally was able to find the issue under.
    *       Issue was the build configuration did not point to gradle properly.
    *
    *   Note: Spent roughly 1 hour fighting with local environment.
    *         At the end of the hour local environment issues were
    *         fixed, and I had json file deserialization into pojo.
    *  */

    public static Gson gson = new Gson();
    public static void main(String[] args)
    {
        /*
            TODO: Cleanup this driver function by:
                * Creating an interface
                * Creating a list of "Tasks"
                * Executing in order, the Tasks from the list
         */
        TaskOne.execute();
    }
}
