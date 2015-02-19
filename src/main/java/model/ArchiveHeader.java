package model;

import java.util.Date;

public class ArchiveHeader {
    private int AH_OH_IDNR;     //processed IDNR
    private int AH_CLIENT;      //number of the client
    private String AH_OTYPE;    //objecttype
    private int AH_IDNR;        //primary key of the archive header
    private String AH_NAME;     //name of the object
    private Date AH_TIMESTAMP1; //activation time
    private Date AH_TIMESTAMP2; //start time
    private Date AH_TIMESTAMP3; //end time (before post processing if available)
    private Date AH_TIMESTAMP4; //end time (including post processing time if available)
    private int AH_RUNTIME;     //Runtime in Seconds (0 ou 1)
    private String AH_HOSTDST;  //name of the host or hostgroup
    private String AH_INFOTEXT; //text from Exekutor
    private String AH_STATUS;   //state of the activity
    private int AH_RETCODE;     //return code
    private int AH_PARENTACT;   //AH_Idnr of activator parent
    private String AH_ALIAS;    //Alias Name for ProcessFlow task
    
    public ArchiveHeader(int AH_OH_IDNR, int AH_CLIENT, String AH_OTYPE, int AH_IDNR, String AH_NAME, Date AH_TIMESTAMP1,
            Date AH_TIMESTAMP2, Date AH_TIMESTAMP3, Date AH_TIMESTAMP4, int AH_RUNTIME, String AH_HOSTDST, String AH_INFOTEXT,
            String AH_STATUS, int AH_RETCODE, int AH_PARENTACT, String AH_ALIAS) {
        this.AH_OH_IDNR = AH_OH_IDNR;
        this.AH_CLIENT = AH_CLIENT;
        this.AH_OTYPE = AH_OTYPE;
        this.AH_IDNR = AH_IDNR;
        this.AH_NAME = AH_NAME;
        this.AH_TIMESTAMP1 = AH_TIMESTAMP1;
        this.AH_TIMESTAMP2 = AH_TIMESTAMP2;
        this.AH_TIMESTAMP3 = AH_TIMESTAMP3;
        this.AH_TIMESTAMP4 = AH_TIMESTAMP4;
        this.AH_RUNTIME = AH_RUNTIME;
        this.AH_HOSTDST = AH_HOSTDST;
        this.AH_INFOTEXT = AH_INFOTEXT;
        this.AH_STATUS = AH_STATUS;
        this.AH_RETCODE = AH_RETCODE;
        this.AH_PARENTACT = AH_PARENTACT;
        this.AH_ALIAS = AH_ALIAS;
    }

    public int getAH_OH_IDNR() {
        return AH_OH_IDNR;
    }

    public int getAH_CLIENT() {
        return AH_CLIENT;
    }

    public String getAH_OTYPE() {
        return AH_OTYPE;
    }

    public int getAH_IDNR() {
        return AH_IDNR;
    }

    public String getAH_NAME() {
        return AH_NAME;
    }

    public Date getAH_TIMESTAMP1() {
        return AH_TIMESTAMP1;
    }

    public Date getAH_TIMESTAMP2() {
        return AH_TIMESTAMP2;
    }

    public Date getAH_TIMESTAMP3() {
        return AH_TIMESTAMP3;
    }

    public Date getAH_TIMESTAMP4() {
        return AH_TIMESTAMP4;
    }

    public int getAH_RUNTIME() {
        return AH_RUNTIME;
    }

    public String getAH_HOSTDST() {
        return AH_HOSTDST;
    }

    public String getAH_INFOTEXT() {
        return AH_INFOTEXT;
    }

    public String getAH_STATUS() {
        return AH_STATUS;
    }

    public int getAH_RETCODE() {
        return AH_RETCODE;
    }

    public int getAH_PARENTACT() {
        return AH_PARENTACT;
    }

    public String getAH_ALIAS() {
        return AH_ALIAS;
    }
}
