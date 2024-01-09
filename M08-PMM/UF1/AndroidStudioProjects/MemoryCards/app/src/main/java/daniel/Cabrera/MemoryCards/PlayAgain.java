package daniel.Cabrera.MemoryCards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayAgain extends AppCompatActivity {

    private TextView winText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_again);
        Button btnPlayAgain = findViewById(R.id.restartBtn);
        winText =  this.findViewById(R.id.winTextview);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int guesses = (int) bundle.getInt("total");
        String text = String.format("%d",guesses);
        winText.setText(text);
        btnPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}