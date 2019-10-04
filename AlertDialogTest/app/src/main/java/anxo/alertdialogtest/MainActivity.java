package anxo.alertdialogtest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.alertMessage);
        builder.setMessage(R.string.confirmacion);
        builder.setPositiveButton(getString(R.string.afirmativo), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });
        builder.setNegativeButton(getString(R.string.negativo), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                System.exit(0);
            }
        });
        builder.create().show();

        Button verificar = findViewById(R.id.buttonVerificar);
        verificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builderVerificar = new AlertDialog.Builder(MainActivity.this);
                builderVerificar.setTitle("Buenos Dias, Respuesta correcta");
                final int[] selected = {0};
                builderVerificar.setSingleChoiceItems(new String[]{"Buenas tarder","Buenas noches","Ahi va la ostia pachi"} , 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        selected[0] = i;
                    }
                });
                builderVerificar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(selected[0]==2) {
                            return;
                        }else{
                            System.exit(0);
                        }
                    }
                });
                builderVerificar.create().show();
            }
        });*/

        CustomDialog myCustomDialog = new CustomDialog(MainActivity.this);
        myCustomDialog.create();
        myCustomDialog.show();

    }
}
