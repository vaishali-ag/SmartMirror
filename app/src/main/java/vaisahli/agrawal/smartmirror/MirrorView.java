package vaisahli.agrawal.smartmirror;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.ArrayAdapter;
import android.widget.DigitalClock;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MirrorView extends AppCompatActivity {


    //private static final Object ArrayAdapter = ;
    TextView CTime;
    TextView note,day,date,weather;
    AnalogClock clock;
    DigitalClock digitalClock;

    private DatabaseReference firebaseDatabase;
    private  SaveInfo save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mirror_view);

        //initialization
        CTime = findViewById(R.id.txt_weather);
        day=findViewById(R.id.day);
        date=findViewById(R.id.date);
        weather=findViewById(R.id.txt_weather);
        note = findViewById(R.id.txtNotes);
        clock=findViewById(R.id.analogClock1);
        digitalClock=findViewById(R.id.digitalClock1);

        final Intent next = getIntent();

         firebaseDatabase=FirebaseDatabase.getInstance().getReference("mirror")
                 .child("time");
         firebaseDatabase.addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                 save=dataSnapshot.getValue(SaveInfo.class);


                 if(save.noteId=="1")
                 {
                     //to do list dispaly

                     String data = next.getStringExtra("message");
                     note.setText(data);
                     //note.setText(save.getTodo());
                 }
                 else {
                     note.setVisibility(View.INVISIBLE);
                 }
                 if(save.timeID=="1")
                 {
                     if (save.analogId=="1")
                     {
                         clock.setVisibility(View.VISIBLE);
                         digitalClock.setVisibility(View.INVISIBLE);

                     }
                     else
                     {digitalClock.setVisibility(View.VISIBLE);
                         clock.setVisibility(View.INVISIBLE);
                     }
                     if(save.digitalId=="1")
                     {
                         digitalClock.setVisibility(View.VISIBLE);
                     }
                     else
                     {
                         digitalClock.setVisibility(View.INVISIBLE);
                     }

                 }
                 else
                 {
                     clock.setVisibility(View.INVISIBLE);
                     digitalClock.setVisibility(View.INVISIBLE);


                 }
                 if(save.weathId=="1")
                 {
                     weather.setText(save.getWeathloc());

                 }
                 else
                 {
                     weather.setVisibility(View.INVISIBLE);
                 }
                 if(save.calendarId=="1")
                 {

                     if(save.dayId=="1" &&save.dateId=="1")
                     {
                         //day
                         SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
                         Date d = new Date();
                         String dayOfTheWeek = sdf.format(d);
                         day.setText(dayOfTheWeek);
                         //date
                         Calendar calendar = Calendar.getInstance();
                         SimpleDateFormat mdformat = new SimpleDateFormat("yyyy / MM / dd ");
                         String strDate =  mdformat.format(calendar.getTime());
                         date.setText(strDate);
                         //date.setVisibility(View.INVISIBLE);
                     }
                     if(save.dateId=="1" && save.dayId=="0")
                     {
                         //date
                         Calendar calendar = Calendar.getInstance();
                         SimpleDateFormat mdformat = new SimpleDateFormat("yyyy / MM / dd ");
                         String strDate =  mdformat.format(calendar.getTime());
                         date.setText(strDate);
                         day.setVisibility(View.INVISIBLE);


                     }
                     if(save.dateId=="0" && save.dayId=="1")
                     {
                         //date
                         SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
                         Date d = new Date();
                         String dayOfTheWeek = sdf.format(d);
                         day.setText(dayOfTheWeek);
                         date.setVisibility(View.INVISIBLE);


                     }

                 }
                 else
                 {
                     day.setVisibility(View.INVISIBLE);
                     date.setVisibility(View.INVISIBLE);
                 }


             }

             @Override
             public void onCancelled(@NonNull DatabaseError databaseError) {

             }
         });


        //to do list dispaly


       //String data = next.getStringExtra("message");
        //note.setText(data);







    }
}
