package vaisahli.agrawal.smartmirror;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button Save;
    EditText note;
    Switch Time,StickeyNote,Weather,Notification,News;
    Integer a=0,b=0,c=0,d=0,e=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Save = findViewById(R.id.Save);
        note = findViewById(R.id.Task);
        Time = findViewById(R.id.Time);
        StickeyNote = findViewById(R.id.Stickey_note);
        Weather = findViewById(R.id.Weather);
        News = findViewById(R.id.News);
        Notification = findViewById(R.id.Notification);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = note.getText().toString().trim();
                Intent next = new Intent(MainActivity.this,MirrorView.class);
                next.putExtra("message", message);
                if(Time.isChecked()||StickeyNote.isChecked()||Weather.isChecked()||News.isChecked()||Notification.isChecked())
                {
                    if(Time.isChecked()) {
                        a = 1;
                       // next.putExtra("a",a);
                    }
                    if(StickeyNote.isChecked())
                        b=1;
                    if(Weather.isChecked())
                        c=1;
                    if(News.isChecked())
                        d=1;
                    if(Notification.isChecked())
                        e=1;
                    startActivity(next);


                }
                else
                {
                    Toast.makeText(MainActivity.this, "select option", Toast.LENGTH_SHORT).show();
                }







            }
        });
    }
}
