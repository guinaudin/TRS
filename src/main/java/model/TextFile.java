package model;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface TextFile {
    File getFile();
    List<String[] > getData();
    String[] getTitles();
    List<Map<String,String>> getMappedData();
}
