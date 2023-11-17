package daniel.Cabrera.MemoryCards;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ArrayList<CardSpace> cardList;
    private int tries;
    private CardSpace firstClicked;
    private CardSpace secondClicked;
    private boolean canClick = true;
    private TextView TriesText;
    private LinearLayout TriesLinearLayout;
    private Button playBtn;
    private Button restartBtn;
    private ImageView ivStartLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TriesText = findViewById(R.id.txtTries);
        onClickPlay();
    }

    private void initCards()
    {
        cardList = new ArrayList<CardSpace>();
        cardList.add(new CardSpace(findViewById(R.id.card0)));
        cardList.add(new CardSpace(findViewById(R.id.card1)));
        cardList.add(new CardSpace(findViewById(R.id.card2)));
        cardList.add(new CardSpace(findViewById(R.id.card3)));
        cardList.add(new CardSpace(findViewById(R.id.card4)));
        cardList.add(new CardSpace(findViewById(R.id.card5)));
        cardList.add(new CardSpace(findViewById(R.id.card6)));
        cardList.add(new CardSpace(findViewById(R.id.card7)));
        cardList.add(new CardSpace(findViewById(R.id.card8)));
        cardList.add(new CardSpace(findViewById(R.id.card9)));
        cardList.add(new CardSpace(findViewById(R.id.card10)));
        cardList.add(new CardSpace(findViewById(R.id.card11)));
        for(CardSpace c: cardList)
        {
            c.img.setOnClickListener(v -> clickCard(v));
        }
    }
    private void reset()
    {
        for(CardSpace c: cardList)
        {
            c.unflip();
        }
        shuffleCards();
        tries = 0;
        updatetriesText();
        firstClicked = null;
        secondClicked = null;
    }
    private void clickCard(View clickedImg)
    {
        if(canClick)
        {
            CardSpace clicked = getCardObj((ImageView) clickedImg);
            if(!clicked.flipped)
            {
                clicked.flip();
                if(firstClicked == null && secondClicked == null)
                {
                    firstClicked = clicked;
                }
                else if(firstClicked != null && secondClicked == null)
                {
                    secondClicked = clicked;
                    canClick = false;
                    new CountDownTimer(750, 375)
                    {
                        public void onTick(long l) {
                            if(firstClicked.type == secondClicked.type)
                            {
                                TriesText.setText("Correct!");
                            }
                            else
                            {
                                TriesText.setText("Incorrect.");
                            }
                        }
                        public void onFinish() {
                            if(firstClicked.type != secondClicked.type)
                            {
                                firstClicked.unflip();
                                secondClicked.unflip();
                            }
                            firstClicked = null;
                            secondClicked = null;
                            tries++;
                            updatetriesText();
                            checkIfAllFlipped();
                            canClick = true;
                        }
                    }.start();
                }
            }
        }
    }
    private CardSpace getCardObj(ImageView imageView)
    {
        CardSpace res = null;
        for(CardSpace c: cardList)
        {
            if(c.compareImgView(imageView))
            {
                res = c;
                break;
            }
        }
        return res;
    }
    private void shuffleCards()
    {
        int[] typeCounts = new int[6];
        ArrayList<Integer> typeGen = new ArrayList<Integer>();
        Random rng = new Random();
        boolean validFound = false;
        int currentType = 0;
        for(int i = 0; i < 12; i++)
        {
            while(!validFound)
            {
                currentType = rng.nextInt(6);
                if(typeCounts[currentType] < 2)
                {
                    typeGen.add(currentType);
                    typeCounts[currentType]++;
                    validFound = true;
                }
            }
            validFound = false;
        }
        for(int i = 0; i < cardList.size(); i++)
        {
            cardList.get(i).type = CardType.values()[typeGen.get(i)];
        }

    }
    private void updatetriesText()
    {
        String text = "";
        switch(tries)
        {
            case 1:
                text = "1";
                break;
            default:
                text = String.format("%d", tries);
        }
        TriesText.setText(text);
    }
    private void checkIfAllFlipped()
    {
        boolean allFlipped = true;
        for(CardSpace c: cardList)
        {
            if(!c.flipped)
            {
                allFlipped = false;
                break;
            }
        }
        if(allFlipped)
        {
            Intent intent = new Intent(this,PlayAgain.class);
            intent.putExtra("total",tries);
            startActivity(intent);
            reset();
        }
    }

    public void onClickPlay(){
        playBtn = findViewById(R.id.playBtn);
        restartBtn = findViewById(R.id.restartBtn);
        TriesLinearLayout = findViewById(R.id.TriesLinearLayout);
        ivStartLogo = findViewById(R.id.ivStartLogo);
        playBtn.setVisibility(View.VISIBLE);
        restartBtn.setVisibility(View.GONE);
        TriesLinearLayout.setVisibility(View.GONE);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initCards();
                reset();
                onClickRestart();
                TriesLinearLayout.setVisibility(View.VISIBLE);
                ivStartLogo.setVisibility(View.GONE);
            }
        });
    }

    public void onClickRestart(){
        playBtn = findViewById(R.id.playBtn);
        restartBtn = findViewById(R.id.restartBtn);
        playBtn.setVisibility(View.GONE);
        restartBtn.setVisibility(View.VISIBLE);
        restartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
    }

}