/* 
    Note: I was tempted to use a generated pojo here, but felt it was to messy
    
    My thoughts:
        
*/

package ai.brace.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BraceBook implements Comparable<BraceBook>{
  private String version;
  private UUID uuid;
  private long lastModified;
  private String title;
  private String author;
  private String translator;
  private String language;
  private List<BraceQuote> textArray;


  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public long getLastModified() {
    return lastModified;
  }

  public void setLastModified(long lastModified) {
    this.lastModified = lastModified;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getTranslator() {
    return translator;
  }

  public void setTranslator(String translator) {
    this.translator = translator;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public List<BraceQuote> getTextArray() {
    // Note sure how Gson treats missing list json
    // add some safety here so we dont blow up incase its missing
    if(textArray == null) return new ArrayList<BraceQuote>();
    return textArray;
  }

  public void setTextArray(List<BraceQuote> textArray) {
    this.textArray = textArray;
  }

  @Override
  public int compareTo(BraceBook o) {
    long diff = lastModified - o.getLastModified();
    // Note: This is not 100% correct as long can be larger then int.
    // Doing it for time reason, and should be handle correctly.
    // Could be done in multiple ways, eg if statement to just return -1, 0, 1 depending on the result
    return (int)diff;
  }
}