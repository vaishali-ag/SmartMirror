package vaisahli.agrawal.smartmirror;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button Save;
    EditText note,location;
    Switch Time,StickeyNote,Weather,Notification,News,Calendar;
    RadioButton analog,digital;
    CheckBox day,event,date,call,msg;


    Integer a=0,b=0,c=0,d=0,e=0,f=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Save = findViewById(R.id.Save);
        note = findViewById(R.id.Task);
        Time = findViewById(R.id.Time);
        Calendar = findViewById(R.id.Cal);
        StickeyNote = findViewById(R.id.Stickey_note);
        Weather = findViewById(R.id.Weather);
        News = findViewById(R.id.News);
        Notification = findViewById(R.id.Notification);
        location = findViewById(R.id.location);
        analog = findViewById(R.id.radioButton);
        digital = findViewById(R.id.radioButton2);
        date = findViewById(R.id.Date);
        day=findViewById(R.id.Day);
        event = findViewById(R.id.Event);
        call = findViewById(R.id.Call);
        msg = findViewById(R.id.Msg);

        //Time switch disable
        Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Time.isChecked())
                    a=1;
                else
                {
                    analog.setEnabled(false);
                    digital.setEnabled(false);
                }
            }
        });

        //calendar switch disable
        Calendar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Calendar.isChecked())
                    b=1;
                else
                {
                    date.setEnabled(false);
                    day.setEnabled(false);
                    event.setEnabled(false);

                }
            }
        });
        //WEATHER DISABLE
        Weather.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Weather.isChecked())
                    c = 1;
                else
                {                    location.setEnabled(false);
            }


            }
        });
        //to do list
        StickeyNote.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(StickeyNote.isChecked())
                    d=1;
                else
                    note.setEnabled(false);
            }
        });

        //notification
        Notification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(Notification.isChecked())
                    e=1;
                else
                    Notification.setEnabled(false);
            }
        });

        //news
        News.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            }
        });


        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = note.getText().toString().trim();
                Intent next = new Intent(MainActivity.this,MirrorView.class);

                next.putExtra("message", message);
                if(Time.isChecked()||Calendar.isChecked()|| StickeyNote.isChecked()||Weather.isChecked()||News.isChecked()||Notification.isChecked())
                {
                    startActivity(next);

                }
                else
                {
                    Toast.makeText(MainActivity.this, "please select option", Toast.LENGTH_SHORT).show();
                }







            }
        });
    }
}
