package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TextFileSplitter implements TextFile {
    public final static char SEPARATOR = ',';
    private List<Map<String, String>> mappedData;

    private File file;
    private List<String> lines;
    private List<String[]> data;
    private String[] titles;

    public TextFileSplitter(File file) {
        this.file = file;

        try {
            // Init
            init();
        } catch (IOException ex) {
            Logger.getLogger(TextFileSplitter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void init() throws IOException {
        lines = TextFileReader.readFile(file);

        data = new ArrayList<String[]>(lines.size());
        String regex = new Character(SEPARATOR).toString();
        boolean first = true;
        for(String line : lines) {
            // Suppression des espaces de fin de ligne
            line = line.trim();

            // On saute les lignes vides
            if (line.length() == 0) {
                continue;
            }

            String[] oneData = line.split(regex);
            
            /*for(int i = 0; i < oneData.length; i++) {
                System.out.print(oneData[i] + " : ");
            }*/
            //System.out.println();

            if(first) {
                titles = oneData;
                first = false;
            } else {
                data.add(oneData);
            }
        }
        
        // On mappe les lignes trouvées
        this.mapData();
    }
    
    private void mapData() {
        mappedData = new ArrayList<Map<String, String>>(data.size());

        for (String[] oneData : data) {
            final Map<String, String> map = new HashMap<String, String>();
            for (int i = 0; i < titles.length; i++) {
                final String key = titles[i];
                final String value = oneData[i];
                map.put(key, value);
            }

            mappedData.add(map);
        }
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public List<String[]> getData() {
        return data;
    }

    @Override
    public String[] getTitles() {
        return titles;
    }

    @Override
    public List<Map<String, String>> getMappedData() {
        return mappedData;
    }
}
