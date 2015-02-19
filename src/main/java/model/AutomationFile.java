package model;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AutomationFile {
    private final TextFile textFile;
    private final SimpleDateFormat formatter;
    private List<ArchiveHeader> ArchiveHeaderList;

    public AutomationFile(File file) {
        formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.textFile = new TextFileSplitter(file);
        this.findAllArchiveHeaders();
    }
    
    private List<ArchiveHeader> findAllArchiveHeaders() {
        ArchiveHeaderList = new ArrayList<ArchiveHeader>();
        final List<Map<String, String>> mappedData = textFile.getMappedData();

        for(Map<String, String> map : mappedData) {
            ArchiveHeader AH = null;
            try {
                AH = mapToArchiveHeader(map);
            } catch (ParseException ex) {
                Logger.getLogger(AutomationFile.class.getName()).log(Level.SEVERE, null, ex);
            }
            ArchiveHeaderList.add(AH);
        }

        return ArchiveHeaderList;
    }
    
    private ArchiveHeader mapToArchiveHeader(Map<String, String> map) throws ParseException {
        String tempDate;
        
        final int AH_OH_IDNR = (!"".equals(map.get("AH_OH_IDNR"))) ? Integer.parseInt(map.get("AH_OH_IDNR")) : 0; 
        final int AH_CLIENT = (!"".equals(map.get("AH_CLIENT"))) ? Integer.parseInt(map.get("AH_CLIENT")) : 0; 
        final String AH_OTYPE = map.get("AH_OTYPE"); 
        final int AH_IDNR = (!"".equals(map.get("AH_IDNR"))) ? Integer.parseInt(map.get("AH_IDNR")) : 0; 
        final String AH_NAME = map.get("AH_NAME");
        Date AH_TIMESTAMP1 = null;
        Date AH_TIMESTAMP2 = null;
        Date AH_TIMESTAMP3 = null;
        Date AH_TIMESTAMP4 = null;
        try {
	   tempDate = formatter.format(formatter.parse(map.get("AH_TIMESTAMP1")));
	   if(tempDate.compareTo(map.get("AH_TIMESTAMP1")) !=  0)
		  	throw new Exception("MESSAGE ERREUR");
           else
               AH_TIMESTAMP1 = formatter.parse(map.get("AH_TIMESTAMP1"));
  	} catch (Exception e) {
  	}
        try {
	   tempDate = formatter.format(formatter.parse(map.get("AH_TIMESTAMP2")));
	   if(tempDate.compareTo(map.get("AH_TIMESTAMP2")) !=  0)
		  	throw new Exception("MESSAGE ERREUR");
           else
               AH_TIMESTAMP2 = formatter.parse(map.get("AH_TIMESTAMP2"));
  	} catch (Exception e) {
		   // --- Gestion mauvaise date
  	}
        try {
	   tempDate = formatter.format(formatter.parse(map.get("AH_TIMESTAMP3")));
	   if(tempDate.compareTo(map.get("AH_TIMESTAMP3")) !=  0)
		  	throw new Exception("MESSAGE ERREUR");
           else
               AH_TIMESTAMP3 = formatter.parse(map.get("AH_TIMESTAMP3"));
  	} catch (Exception e) {
		   // --- Gestion mauvaise date
  	}
        try {
	   tempDate = formatter.format(formatter.parse(map.get("AH_TIMESTAMP4")));
	   if(tempDate.compareTo(map.get("AH_TIMESTAMP4")) !=  0)
		  	throw new Exception("MESSAGE ERREUR");
           else
               AH_TIMESTAMP4 = formatter.parse(map.get("AH_TIMESTAMP4"));
  	} catch (Exception e) {
		   // --- Gestion mauvaise date
  	}
        final int AH_RUNTIME = (!"".equals(map.get("AH_RUNTIME"))) ? Integer.parseInt(map.get("AH_RUNTIME")) : 0; 
        final String AH_HOSTDST = map.get("AH_HOSTDST");
        final String AH_INFOTEXT = map.get("AH_INFOTEXT");
        final String AH_STATUS = map.get("AH_STATUS");
        final int AH_RETCODE = (!"".equals(map.get("AH_RETCODE"))) ? Integer.parseInt(map.get("AH_RETCODE")) : 0; 
        final int AH_PARENTACT = (!"".equals(map.get("AH_PARENTACT"))) ? Integer.parseInt(map.get("AH_PARENTACT")) : 0; 
        final String AH_ALIAS = map.get("AH_ALIAS");
        
        final ArchiveHeader AH = new ArchiveHeader(AH_OH_IDNR, AH_CLIENT, AH_OTYPE, AH_IDNR, AH_NAME, AH_TIMESTAMP1,
            AH_TIMESTAMP2, AH_TIMESTAMP3, AH_TIMESTAMP4, AH_RUNTIME, AH_HOSTDST, AH_INFOTEXT,
            AH_STATUS, AH_RETCODE, AH_PARENTACT, AH_ALIAS);
        
        return AH;
    }
    
    public List<ArchiveHeader> getArchiveHeaderList() {
        return ArchiveHeaderList;
    }
}
