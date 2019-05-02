package bracu.topup.petcareapp.model;

/**
 * Created by User-PC on 4/17/2018.
 */

public class Vetuser {

    private String vetname;
    private String vetspecial;

    private String vetnumber;
    private String vetchamber;

    public Vetuser(String vetname, String vetspecial, String vetnumber, String vetchamber){
        this.vetname=vetname;
        this.vetspecial=vetspecial;
        this.vetnumber=vetnumber;
        this.vetchamber=vetchamber;

    }


    public String getVetname() {
        return vetname;
    }

    public void setVetname(String vetname) {
        this.vetname = vetname;
    }

    public String getVetspecial() {
        return vetspecial;
    }

    public void setVetspecial(String vetspecial) {
        this.vetspecial = vetspecial;
    }

    public String getVetnumber() {
        return vetnumber;
    }

    public void setVetnumber(String vetnumber) {
        this.vetnumber = vetnumber;
    }

    public String getVetchamber() {
        return vetchamber;
    }

    public void setVetchamber(String vetchamber) {
        this.vetchamber = vetchamber;
    }

    @Override
    public String toString(){
        return "Vet name: "+vetname+"\n"+"Specialty: "+vetspecial+"\n"+"Number: "+vetnumber
                +"\n"+"Chamber: "+vetchamber;
    }
}
