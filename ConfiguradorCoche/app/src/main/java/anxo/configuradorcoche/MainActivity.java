package anxo.configuradorcoche;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Coche coche;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Crear coche
        this.coche = new  Coche();

        //Botones
        final Button tipo = findViewById(R.id.tipo);
        final Button carroceria = findViewById(R.id.carroceria);
        final Button extras = findViewById(R.id.extras);
        final Button observ = findViewById(R.id.observ);

        //Listeners
        tipo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.cambiaTipo();
            }
        });

        carroceria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.cambiaCarroceria();
            }
        });

        extras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.cambiaExtras();
            }
        });

        observ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.cambiaObservaciones();
            }
        });

        //Prepara la vista
        this.muestraModelo();
    }



    private void muestraModelo(){
        final TextView modelo = this.findViewById(R.id.modelo);
        modelo.setText(this.coche.toString());
    }

    private void cambiaTipo(){
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);

        dlg.setItems(
                new String[]{"Berlina", "SUV"},
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.coche.setSuv(( which == 1));
                        MainActivity.this.coche.setBerlina(( which == 0));
                        MainActivity.this.muestraModelo();
                    }
                }
        );

        dlg.show();
    }

    private void cambiaCarroceria(){
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        int seleccionado = 0 ;
        if(this.coche.isFamiliar()){
            seleccionado=1;
        }
        dlg.setSingleChoiceItems(
                new String[]{"Normal", "Familiar"},
                seleccionado,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.this.coche.setFamiliar( ( which == 1 ));
                        MainActivity.this.muestraModelo();
                    }
                }
        );
        dlg.setPositiveButton("Aceptar",null);
        dlg.show();
    }

    private void cambiaExtras(){
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);

        dlg.setMultiChoiceItems(
                new String[]{"A/C", "Navegador"},
                new boolean[]{
                        this.coche.hasAlc(),
                        this.coche.hasNav()
                },
                new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if( which == 0 ){
                            MainActivity.this.coche.setAlc(isChecked);
                        }
                        else if( which == 1){
                            MainActivity.this.coche.setNavegador(isChecked);
                        }
                        MainActivity.this.muestraModelo();
                    }
                }

        );

        dlg.setPositiveButton("Confirmar",null);
        dlg.show();

    }

    private void cambiaObservaciones(){
        final EditText observaciones = new EditText(this);

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);

        dlg.setMessage("Observaciones");
        dlg.setView(observaciones);
        dlg.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.coche.setObservaciones(
                        observaciones.getText().toString()
                );
                MainActivity.this.muestraModelo();
            }
        });

        dlg.show();
    }
}
