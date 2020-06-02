/* 
    Note: I was tempted to use a generated pojo here, but felt it was to messy
    
    My thoughts:
        
*/

package ai.brace.models;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class BraceBook {
  //  private String version;
//  private UUID uuid;
//  private long lastModified;
//  private String title;
//  private String author;
//  private String translator;
//  private String language;
  private List<BraceQuote> textArray;

  BraceBook(){
      // default no-args constructor
  }

  public List<BraceQuote> getTextArray() {
    return textArray;
  }
}