package io.github.toqueyann.diabete;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SickToReport extends AppCompatActivity {

    private ListView lstVue;
    private Button btnSupprimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sick_to_report);

        this.lstVue = (ListView) findViewById(R.id.lstVue);
        btnSupprimer = (Button) findViewById(R.id.btnSupprimer);



        ArrayList<String> lesMaladesDisplay = (ArrayList<String>)getIntent().getSerializableExtra("DATA");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(SickToReport.this, android.R.layout.simple_list_item_single_choice, lesMaladesDisplay);

        lstVue.setAdapter(adapter);


       btnSupprimer.setOnClickListener(setOnClickListenerSupprimer);
    }


    private View.OnClickListener setOnClickListenerSupprimer = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ArrayList<String> lesMaladesDisplay = (ArrayList<String>)getIntent().getSerializableExtra("DATA");


            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"toqueyann@gmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, "Liste des malades a signaler");
            i.putExtra(Intent.EXTRA_TEXT   ,  lesMaladesDisplay.toString());
            startActivity(Intent.createChooser(i, "Send mail..."));
            System.exit(0);



        }
    };
}

