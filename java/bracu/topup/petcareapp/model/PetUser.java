package bracu.topup.petcareapp.model;

/**
 * Created by User-PC on 4/19/2018.
 */

public class PetUser {

    private String mypetname;
    private String mypetage;
    private String mypetgender;
    private String mypettype;

    public PetUser(String mypetname, String mypetage, String mypetgender, String mypettype){
        this.mypetname=mypetname;
        this.mypetage=mypetage;
        this.mypetgender=mypetgender;
        this.mypettype=mypettype;

    }

    public String getMypetname() {
        return mypetname;
    }

    public void setMypetname(String mypetname) {
        this.mypetname = mypetname;
    }

    public String getMypetage() {
        return mypetage;
    }

    public void setMypetage(String mypetage) {
        this.mypetage = mypetage;
    }

    public String getMypetgender() {
        return mypetgender;
    }

    public void setMypetgender(String mypetgender) {
        this.mypetgender = mypetgender;
    }

    public String getMypettype() {
        return mypettype;
    }

    public void setMypettype(String mypettype) {
        this.mypettype = mypettype;
    }



    @Override
    public String toString(){
        return "Pet name: "+mypetname+"\n"+"Pet age: "+mypetage+"\n"+"Gender: "+mypetgender+"\n"+"Phone: "+mypettype;
    }
}
