package sg.edu.rp.c347.taskmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.R.string.cancel;

public class AddActivity extends AppCompatActivity {
    TextView tvName, tvDes;
    EditText etName, etDes;
    Button btnAdd, btnCancel;
    Task data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Intent i = getIntent();
        data = (Task) i.getSerializableExtra("data");

        etName.setText(data.getName());
        etDes.setText(data.getDescription());

        tvName = (TextView) findViewById(R.id.tvName);
        etName = (EditText) findViewById(R.id.etName);
        etDes = (EditText) findViewById(R.id.etName);
        tvDes = (TextView) findViewById(R.id.tvDes);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnCancel = (Button) findViewById(R.id.btnCancel);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbh = new DBHelper(AddActivity.this);
                data.setDescription(etDes.getText().toString());
                dbh.insertTask(data);
                dbh.close();

                Intent i = new Intent();
                i.putExtra("updated", "updated");
                setResult(RESULT_OK, i);
                finish();

                Intent ii = new Intent(AddActivity.this,NotificationActivity.class);
                ii.putExtra(" "," ");
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("cancel", cancel);
                setResult(RESULT_OK, i);
                finish();
            }

        });
    }
}