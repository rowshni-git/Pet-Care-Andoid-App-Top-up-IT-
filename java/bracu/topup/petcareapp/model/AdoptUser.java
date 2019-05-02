package bracu.topup.petcareapp.model;



/**
 * Created by Usha on 3/28/2018.
 */

public class AdoptUser {
    private String apetname;
    private String apetage;
    private String apetgender;
    private String apetnumber;

    public AdoptUser(String apetname, String apetage, String apetgender, String apetnumber){
        this.apetname=apetname;
        this.apetage=apetage;
        this.apetgender=apetgender;
        this.apetnumber=apetnumber;

    }

    public String getApetname() {
        return apetname;
    }

    public void setApetname(String apetname) {
        this.apetname = apetname;
    }

    public String getApetage() {
        return apetage;
    }

    public void setApetage(String apetage) {
        this.apetage = apetage;
    }

    public String getApetgender() {
        return apetgender;
    }

    public void setApetgender(String apetgender) {
        this.apetgender = apetgender;
    }

    public String getApetnumber() {
        return apetnumber;
    }

    public void setApetnumber(String apetnumber) {
        this.apetnumber = apetnumber;
    }

    @Override
    public String toString(){
        return "Pet name: "+apetname+"\n"+"Pet age: "+apetage+"\n"+"Gender: "+apetgender+"\n"+"Phone: "+apetnumber;
    }
}
