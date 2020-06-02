/* 
    Note: I was tempted to use a generated pojo here, but felt it was to messy
    
    My thoughts:
        
*/

package ai.brace.models;

import java.util.UUID;

public class BraceBook {
  //  private String version;
//  private UUID uuid;
//  private long lastModified;
//  private String title;
//  private String author;
//  private String translator;
//  private String language;
  private BraceQuote[] textArray;

  BraceBook(){
      // default no-args constructor
  }

  public BraceQuote[] getTextArray() {
    return textArray;
  }
}