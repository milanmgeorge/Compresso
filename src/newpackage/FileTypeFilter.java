package newpackage;


import java.io.*;
import java.util.*;
import javax.swing.*;

public class FileTypeFilter implements FileFilter {
   
    private final String extension;
   private final String description;
   
   public FileTypeFilter(String extension, String description) {
      this.extension=extension;
      this.description=description;
   }
   
   public boolean accept(File file) {
       if(file.isDirectory()) {
           return true;
       }
       return file.getName().endsWith(extension);
   }
   public String getDescription(){
       return description+ String.format(" (*%s)", extension);
   }
}