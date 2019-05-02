package bracu.topup.petcareapp.model;



/**
 * Created by Uttal on 2/28/2018.
 */

public class Selector {
    private int imageSrc;
    private String title;

    public Selector(int imageSrc, String title) {
        this.imageSrc = imageSrc;
        this.title = title;
    }

    public int getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(int imageSrc) {
        this.imageSrc = imageSrc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
