package anxo.mytodotasklist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Task> taskList = new ArrayList<Task>();
    private ArrayAdapter<Task> adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i = 1; i<= 10; i++){
            Task objTask = new Task();
            objTask.setTaskName("Task "+i);
            taskList.add(objTask);
        }
        ListView listView = findViewById(R.id.idListViewTasks);
        adapter = new ArrayAdapter<Task>(MainActivity.this,
                android.R.layout.simple_selectable_list_item,
                taskList );
        listView.setAdapter(adapter);

        registerForContextMenu(listView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.idMenuItemAdd) addTask();
        else if (item.getItemId() == R.id.idMenuItemCleanAll) cleanAllTasks();
        return super.onOptionsItemSelected(item);
    }

    private void addTask(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Añadir tarea");
        final EditText add = new EditText(MainActivity.this);
        add.setText("New task");
        builder.setView(add);
        builder.setPositiveButton("Añadir", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String newTaskName = add.getText().toString();
                Task newTask = new Task();
                newTask.setTaskName(newTaskName);
                taskList.add(newTask);
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }

    private void cleanAllTasks(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Confirmación");
        builder.setMessage("Desea eliminar todas las tareas?");
        builder.setPositiveButton("Sí", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                taskList.clear();
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        getMenuInflater().inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        ContextMenu.ContextMenuInfo menuInfo = item.getMenuInfo();
        int position = ((AdapterView.AdapterContextMenuInfo) menuInfo).position;
        if(item.getItemId() == R.id.idMenuItemModify){
            modifyTask(position);
        } else if (item.getItemId() == R.id.idMenuItemDelete){
            deleteTask(position);
        }
        return true;
    }

    private void modifyTask(int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Modificar Tarea");
        final EditText modif = new EditText(MainActivity.this);
        final Task currentTask = taskList.get(position);
        modif.setText(currentTask.getTaskName());
        builder.setView(modif);
        builder.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String newTaskName = modif.getText().toString();
                currentTask.setTaskName(newTaskName);
                adapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.create().show();
    }

    private void deleteTask(int position){
        taskList.remove(position);
        adapter.notifyDataSetChanged();
    }
}
