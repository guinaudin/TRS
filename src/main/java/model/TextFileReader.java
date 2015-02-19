package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileReader {
    public static String getResourcePath(String fileName) {
       final File file = new File("");
       final String folderPath = file.getAbsolutePath() + File.separator + fileName;
       
       return folderPath;
   }

   public static File getResource(String fileName) {
       final String completeFileName = getResourcePath(fileName);
       //System.out.println("fileName : " + completeFileName);
       File file = new File(completeFileName);
       
       return file;
   }
   
   public static List<String> readFile(File file) throws FileNotFoundException, IOException {
        List<String> lines = new ArrayList<String>();

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferReader = new BufferedReader(fileReader);
        
        while(bufferReader.ready() == true) {
            lines.add(bufferReader.readLine());
        }

        bufferReader.close();
        fileReader.close();

        return lines;
    }
}