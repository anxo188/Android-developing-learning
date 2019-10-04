package anxo.alertdialogtest;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;

public class CustomDialog extends Dialog implements View.OnClickListener {
    Button buttonA = null;
    Button buttonB = null;
    Button buttonC = null;
    Button buttonD = null;

    public CustomDialog(@NonNull Context context){
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);
        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
        buttonC = findViewById(R.id.buttonC);
        buttonD = findViewById(R.id.buttonD);
        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonD.setOnClickListener(this);
    }

    @SuppressLint("ResourceAsColor")
    public void onClick(View view){
        if(view.getId() == buttonC.getId()){
            CustomDialog.this.dismiss();
        }else if( view instanceof Button) {
            ((Button) view).setTextColor(R.color.colorAccent);
        }
    }
}
