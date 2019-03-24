package vaisahli.agrawal.smartmirror;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button Save;
    EditText note;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Save = findViewById(R.id.Save);
        note = findViewById(R.id.Task);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = note.getText().toString().trim();
                Intent next = new Intent(MainActivity.this,MirrorView.class);
                next.putExtra("message", message);

                startActivity(next);



            }
        });
    }
}
