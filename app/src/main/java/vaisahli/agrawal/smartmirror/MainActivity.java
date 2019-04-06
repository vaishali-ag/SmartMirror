package vaisahli.agrawal.smartmirror;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    Button Save;
    EditText note,location;
    Switch Time,StickeyNote,Weather,Notification,News,Calendar;
    RadioButton analog,digital;
    CheckBox day,event,date,call,msg;
    RadioGroup rGrup;
  //  private  DatabaseReference firebaseDatabase;



    Integer a=0,b=0,c=0,d=0,e=0,f=0;

   // FirebaseDatabase database = FirebaseDatabase.getInstance();
    //DatabaseReference myRef = database.getReference("message");
    String timeID;
    String analogId;
    String digitalId;
    String calendarId;
    String dayId;
    String dateId;
    String eventId;
    String newsId;
    String msgId;
    String callId;
    String nOtifyId;
    String todoId;
    String weathId;
    String noteId;
    Editable locId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        //initialization
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
        rGrup = findViewById(R.id.radiogrup);

        //Time switch disable
        Time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Time.isChecked()) {
                    a = 1;
                    analog.setEnabled(true);
                    digital.setEnabled(true);
                    timeID="1";


                }
                else
                {
                    analog.setEnabled(false);
                    digital.setEnabled(false);
                    timeID="0";
                }
                rGrup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if(checkedId==R.id.radioButton)
                        {
                            analogId="1";
                            digitalId="0";

                        }
                        else if (checkedId == R.id.radioButton2)
                        {
                            analogId="0";
                            digitalId="2";
                        }

                    }
                });
                if(analog.isChecked())
                {

                }
                if(digital.isChecked())
                {

                }
            }
        });

        //calendar switch disable
        Calendar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Calendar.isChecked())
                {b=1;
                    date.setEnabled(true);
                    day.setEnabled(true);
                    event.setEnabled(true);
                    calendarId="1";

                }
                else
                {
                    date.setEnabled(false);
                    day.setEnabled(false);
                    event.setEnabled(false);
                    calendarId="0";

                }
                if(date.isChecked())
                {
                    dateId="1";
                }
                else
                {
                    dateId="0";
                }
                if(day.isChecked())
                {
                    dayId="1";
                }
                else
                {
                    dayId="0";
                }
                if(event.isChecked())
                {
                    eventId="1";
                }
                else
                {
                    eventId="0";
                }
            }
        });
        //WEATHER DISABLE
        Weather.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (Weather.isChecked()) {
                    c = 1;
                    location.setEnabled(true);
                    weathId="1";
                }
                else
                {
                    location.setEnabled(false);
                    weathId="0";
            }
            locId=location.getText();


            }
        });
        //to do list
        StickeyNote.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(StickeyNote.isChecked()) {
                    d = 1;
                    note.setEnabled(true);
                    noteId="1";
                }
                else{
                    note.setEnabled(false);
                    noteId="0";
            }
            //todoId=location.getText();

            }
        });

        //notification
        Notification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(Notification.isChecked())
                {   e=1;
                    call.setEnabled(true);
                    msg.setEnabled(true);
                    nOtifyId="1";

                }
                else
                {   call.setEnabled(false);
                     msg.setEnabled(false);
                     nOtifyId="0";
                }
                if(call.isChecked())
                {
                    callId="1";
                }
                else
                {
                    callId="0";
                }
                if(msg.isChecked())
                {
                    msgId="1";
                }
                else
                {
                    msgId="0";
                }
            }
        });

        //news
        News.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(News.isChecked())
                newsId="1";
               else
                   newsId="0";
            }
        });


//button

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


    //            firebaseDatabase=FirebaseDatabase.getInstance().getReference("Mirror").child("" + timeID);






            }
        });
    }
}
