package helper;

import java.io.*;
import java.util.zip.*; 
import java.util.*;
import java.util.ArrayList;

public class ZipHelper {
    
    public List<File> unZip(String zipFile, String outputFolder) {
        List<File> files=new ArrayList<File>();
        byte[] buffer=new byte[1024];
        try{
            File folder=new File(outputFolder);
           if(!folder.exists()) {
               folder.mkdir();
           } 
           ZipInputStream zis= new ZipInputStream(new FileInputStream(zipFile));
           ZipEntry ze=zis.getNextEntry();
           while(ze!=null) {
               String fileName=ze.getName();
               File newFile=new File(outputFolder + File.separator+ fileName);
               files.add(newFile);
               new File(newFile.getParent()).mkdirs();
               FileOutputStream fos=new FileOutputStream(newFile);
               int len;
               while((len=zis.read(buffer))>0) {
                   fos.write(buffer, 0, len);
                   }
               fos.close();
               ze=zis.getNextEntry();
           }
           zis.closeEntry();
           zis.close();
           }
        catch(Exception ex) {
            files=null;
            
        }
        return files;
        
    }
    public void zip(List<File> fileList, String zipFile){
        byte[] buffer=new byte[1024];
        try{
            FileOutputStream fileOutputStream =new FileOutputStream(zipFile);
            ZipOutputStream zipOutputStream =new ZipOutputStream(fileOutputStream);
            for(File file : fileList) {
                ZipEntry zipEntry=new ZipEntry(file.getName());
                zipOutputStream.putNextEntry(zipEntry);
                FileInputStream fileInputStream=new FileInputStream(file);
                int len;
                while((len=fileInputStream.read(buffer))>0){
                 zipOutputStream.write(buffer, 0, len);   
            }
            fileInputStream.close();
            
        }
        zipOutputStream.closeEntry();
        zipOutputStream.close();
        
    }
    catch(IOException ex) {
    ex.printStackTrace();
}

    }}