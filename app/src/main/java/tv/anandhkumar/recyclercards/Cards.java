package tv.anandhkumar.recyclercards;

public class Cards {

    private int mImageResource;
    private String mText;

    public Cards(int ImageResource,String Text){
        this.mImageResource=ImageResource;
        this.mText=Text;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public String getmText() {
        return mText;
    }
}
