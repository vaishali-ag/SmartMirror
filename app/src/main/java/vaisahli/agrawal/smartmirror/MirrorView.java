package vaisahli.agrawal.smartmirror;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MirrorView extends AppCompatActivity {

TextView CTime;
TextView note,day,date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mirror_view);

        //initialization
        CTime = findViewById(R.id.txt_weather);
        day=findViewById(R.id.day);
        date=findViewById(R.id.date);

        //to do list dispaly
        note = findViewById(R.id.txtNotes);
        Intent next = getIntent();
        String data = next.getStringExtra("message");
        note.setText(data);

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




    }
}
