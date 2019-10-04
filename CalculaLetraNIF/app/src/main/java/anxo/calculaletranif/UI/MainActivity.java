package anxo.calculaletranif.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import anxo.calculaletranif.Core.CalculoLetraNif;
import anxo.calculaletranif.R;

public class MainActivity extends AppCompatActivity {
    public static String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edDNI = this.findViewById(R.id.edDNI);
        final Button btCalcula =  this.findViewById(R.id.btCalcula);


        btCalcula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculaLetraNif( edDNI.getText().toString());

            }
        });

        edDNI.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                MainActivity.this.calculaLetraNif(s.toString());
            }
        });
    }

    private void calculaLetraNif(String strDni){
        final TextView letraDNI = this.findViewById(R.id.resLetra);
        int dni = -1;
        try{
            dni = Integer.parseInt(strDni);
            letraDNI.setText(Character.toString(CalculoLetraNif.obtainLetraNif(dni)));
        }
        catch ( NumberFormatException e){
            Toast.makeText(MainActivity.this, "Error con el nif introducido",Toast.LENGTH_SHORT).show();
            Log.e(TAG, "Error al convertir dni: '" + strDni + "'");
        }

    }
}
