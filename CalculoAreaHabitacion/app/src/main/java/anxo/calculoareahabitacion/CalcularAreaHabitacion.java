package anxo.calculoareahabitacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class CalcularAreaHabitacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Pasar Celsius -Faren / Faren-Celsius*/
        final EditText grados = findViewById(R.id.grados);
        final Switch tipo = findViewById(R.id.switcher);
        final TextView resultado = findViewById(R.id.result);
        Button botonCalcular = findViewById(R.id.botonCalcular);
        botonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float grado = Float.parseFloat(grados.getText().toString());
                    //Off para Celsius-Faren  On para Faren Celsius
                if(!tipo.getShowText()){
                    resultado.setText((((grado*9)/5) + 32)+" ºF");
                }
                else {
                    resultado.setText(((grado - 32) * 5 / 9)+" ºC");
                }
            }
        });


        /* Calcular Area Habitación
            final EditText editAlto  = findViewById(R.id.editAlto);
            final EditText editAncho = findViewById(R.id.editAncho);
            final TextView resultado = findViewById(R.id.result);
            Button botonCalcular = findViewById(R.id.botonCalcular);
            botonCalcular.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try{
                        Integer alto  = Integer.parseInt(editAlto.getText().toString());
                        Integer ancho = Integer.parseInt(editAncho.getText().toString());
                        resultado.setText((ancho*alto)+" m2");
                    }catch(Exception e){
                        Toast.makeText(CalcularAreaHabitacion.this, "Alguno de los valores no es correcto", Toast.LENGTH_LONG).show();
                    }
                }
            });
        */
    }
}
