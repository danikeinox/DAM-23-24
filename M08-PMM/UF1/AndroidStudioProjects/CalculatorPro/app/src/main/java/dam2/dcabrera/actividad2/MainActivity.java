package dam2.dcabrera.actividad2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.view.GestureDetectorCompat;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView txViewResult;
    private Button btSuma;
    private Button btResta;
    private Button btClear;
    private Button btOperation;
    private Button btComa;
    private String txtOperation;
    private double tempDisplay;
    private double display;
    private long lastdisplay;
    private Button btDigit;
    private String txtDigit;
    private boolean isDouble;
    private String fullValue;
    private long integerPart;
    private double decimalPart;
    private double resultado;
    private GestureDetectorCompat mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txViewResult = findViewById(R.id.txtViewResult);
        btSuma = findViewById(R.id.btSuma);
        btClear = findViewById(R.id.btClear);
        btResta = findViewById(R.id.btResta);
        btComa = findViewById(R.id.btComa);
        isDouble = false;
        integerPart = 0;
        decimalPart = 0;

        mDetector = new GestureDetectorCompat(this, new MyGestureListener());

        txViewResult.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mDetector.onTouchEvent(event);
                return true;
            }
        });
    }

    public void dgClick(View view) {
        if (txViewResult.getText().toString().equals("Error")) {
            txViewResult.setText("0");
        }

        btDigit = (Button) findViewById(view.getId());
        txtDigit = btDigit.getText().toString();
        String currentText = txViewResult.getText().toString();
        String cleanedText = currentText.replace(".", "").replace(",", "");

        if (isDouble) {
            cleanedText += txtDigit;
        } else {
            String newValueString = cleanedText + txtDigit;

            try {
                long longValue = Long.parseLong(newValueString);

                if (longValue >= Long.MAX_VALUE || longValue <= Long.MIN_VALUE) {
                    txViewResult.setText("Error");
                    return;
                }
            } catch (NumberFormatException e) {
                txViewResult.setText("Error");
                return;
            }

            cleanedText = newValueString;
        }

        fullValue = cleanedText;
        double newValue = Double.parseDouble(cleanedText);

        display = newValue;
        String formattedNumber = formatNumber(display);
        txViewResult.setText(formattedNumber);
    }


    public void changeSign(View view) {
        if (txViewResult.getText().toString().equals("Error")) {
            txViewResult.setText("0");
            return;
        }

        display = Double.parseDouble(txViewResult.getText().toString().replace(".", "").replace(",", ""));

        display = -display;
        txViewResult.setText(formatNumber(display));
    }


    public void operation(View view) {
        if (txViewResult.getText().toString().equals("Error")) {
            txViewResult.setText("0");
            return;
        }
        btOperation = (Button) findViewById(view.getId());
        display = Double.parseDouble(txViewResult.getText().toString().replace(".", "").replace(",", ""));
        tempDisplay = (int) display;
        display = 0;
        txViewResult.setText(formatNumber(display));
        txtOperation = btOperation.getText().toString();
    }


    public void resClick(View view) {
        if (txViewResult.getText().toString().equals("Error")) {
            txViewResult.setText("0");
            return;
        }
        if (txtOperation.equals("C")) {
            tempDisplay = 0;
            integerPart = 0;
            decimalPart = 0;
            display = 0;
            isDouble = false;
            txtOperation = "";
            txViewResult.setText(formatNumber(display));
        } else {
            display = Double.parseDouble(txViewResult.getText().toString().replace(".", ""));
            resultado = 0;
            try {
                switch (txtOperation) {
                    case "+":
                        resultado = tempDisplay + display;
                        break;
                    case "-":
                        resultado = tempDisplay - display;
                        break;
                    case "x":
                        resultado = tempDisplay * display;
                        break;
                    case "÷":
                        if (display != 0) {
                            resultado = tempDisplay / display;
                        } else {
                            txViewResult.setText("Error");
                            return;
                        }
                        break;
                    case "%":
                        resultado = (tempDisplay / 100) * display;
                        break;
                }
            } catch (Exception e) {
                txViewResult.setText("Error");
                display = 0;
                isDouble = false;
                decimalPart = 0;
                return;
            }
            isDouble = (resultado != (int) resultado);
            txViewResult.setText(formatNumber(resultado));
        }
    }


    public void onComaClick(View view) {
        if (txViewResult.getText().toString().equals("Error")) {
            return;
        }

        if (!isDouble) {
            isDouble = true;
            integerPart = (long) display;
            decimalPart = display - integerPart;
            txViewResult.setText(txViewResult.getText() + ",");
        }
    }

    private String formatNumber(double number) {
        NumberFormat numberFormat = NumberFormat.getInstance(new Locale("es", "ES"));
        numberFormat.setGroupingUsed(true);
        numberFormat.setMaximumFractionDigits(isDouble ? 2 : 0);
        return numberFormat.format(number);
    }

    // Clase de borrado al deslizar el TextView hacia la izquierda y la derecha, con ayuda de ChatGPT
    private class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float deltaX = e2.getX() - e1.getX();
            if (Math.abs(deltaX) > Math.abs(velocityY)) {
                if (deltaX > 0) {
                    // Borrar el último dígito a la derecha
                    String currentText = txViewResult.getText().toString();
                    if (!currentText.isEmpty()) {
                        currentText = currentText.substring(0, currentText.length() - 1);
                        txViewResult.setText(currentText.isEmpty() ? "0" : currentText);
                    }
                } else {
                    // Borrar el último dígito a la izquierda
                    String currentText = txViewResult.getText().toString();
                    if (!currentText.isEmpty()) {
                        currentText = currentText.substring(0, currentText.length() - 1);
                        txViewResult.setText(currentText.isEmpty() ? "0" : currentText);
                    }
                }
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}
