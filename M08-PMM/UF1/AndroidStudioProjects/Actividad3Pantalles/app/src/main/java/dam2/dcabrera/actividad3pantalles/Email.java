package dam2.dcabrera.actividad3pantalles;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Email extends AppCompatActivity {

    private TextView txEmailFrom;
    private EditText txEmailTo;
    private EditText txEmailContent;
    private TextView labelSentMessage;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email);

        txEmailFrom = findViewById(R.id.tx_fromEmail);
        txEmailTo = findViewById(R.id.tx_emailTo);
        txEmailContent = findViewById(R.id.tx_emailContent);
        labelSentMessage = findViewById(R.id.label_sentmessage);

        // Recuperar los datos del Bundle
        Bundle email = getIntent().getExtras();
        if (email != null) {
            String correo = email.getString("tx_correo");

            // Mostrar los datos en la vista
            txEmailFrom.setText(correo);
        }
    }
    public void sendEmail(View view) {
        String emailTo = txEmailTo.getText().toString();

        if (!emailTo.isEmpty()) {
            txEmailTo.setText("");
            txEmailContent.setText("");
            labelSentMessage.setText(getString(R.string.label_sentmessageSent));
        } else {
            labelSentMessage.setText(getString(R.string.label_sentmessageError));
        }
    }

}
