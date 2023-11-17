package daniel.Cabrera.MemoryCards;

import android.widget.ImageView;

public class CardSpace {
    public ImageView img;
    public boolean flipped;
    public CardType type;

    public CardSpace(ImageView img)
    {
        this.img = img;
        this.flipped = false;
        this.type = CardType.UNASSIGNED;
    }

    public CardSpace(ImageView img, CardType type)
    {
        this.img = img;
        this.flipped = false;
        this.type = type;
    }

    public void flip()
    {
        this.flipped = true;
        showImage();
    }

    public void unflip()
    {
        this.flipped = false;
        this.img.setImageResource(R.drawable.card_bg);
    }

    public boolean compareImgView(ImageView imgView2)
    {
        return this.img.getId() == imgView2.getId();
    }

    private void showImage()
    {
        if(this.type == CardType.GINGERBREAD) this.img.setImageResource(R.drawable.card_1);
        else if(this.type == CardType.HONEYCOMB) this.img.setImageResource(R.drawable.card_2);
        else if(this.type == CardType.SANDWICH) this.img.setImageResource(R.drawable.card_3);
        else if(this.type == CardType.JELLYBEAN) this.img.setImageResource(R.drawable.card_4);
        else if(this.type == CardType.LOLLIPOP) this.img.setImageResource(R.drawable.card_5);
        else if(this.type == CardType.KITKAT) this.img.setImageResource(R.drawable.card_6);
    }
}