package anxo.kutrekalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText op1 = this.findViewById(R.id.editOp1);
        final EditText op2 = this.findViewById(R.id.editOp2);
        final TextView resultado = this.findViewById(R.id.textResult);

        op1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String strop1 = s.toString();
                String strop2 = op2.getText().toString();
                int operando1 = 0;
                int operando2 = 0;
                try{
                    operando1 = Integer.parseInt(strop1);
                }catch (NumberFormatException e){
                    Log.e(TAG, String.format("Error convirtiendo operando 1: %s  ", strop1));
                }
                try{
                    operando2 = Integer.parseInt(strop2);
                }catch (NumberFormatException e){
                    Log.e(TAG, String.format("Error convirtiendo operando 2: %s  ",strop2));
                    resultado.setText("Error");
                }
                try{
                    resultado.setText(Integer.toString(operando1+operando2));
                }catch (Exception e){
                    Log.e(TAG,"Error inesperado");
                }
            }
        });

        op2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
               /* try{
                    resultado.setText((Integer.parseInt(op1.getText().toString()) + Integer.parseInt(s.toString())));
                }catch (NumberFormatException e){
                    resultado.setText((0 + Integer.parseInt(s.toString())));
                }*/
            }
        });




    }
}
