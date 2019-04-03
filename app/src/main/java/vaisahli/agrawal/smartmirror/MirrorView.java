package vaisahli.agrawal.smartmirror;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MirrorView extends AppCompatActivity {

TextView CTime;
TextView note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mirror_view);
        CTime = findViewById(R.id.txt_weather);
        //to do list dispaly
        note = findViewById(R.id.txtNotes);
        Intent next = getIntent();
        String data = next.getStringExtra("message");
        note.setText(data);



}
}
