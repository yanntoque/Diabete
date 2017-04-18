package io.github.toqueyann.diabete;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import io.github.toqueyann.diabete.lesClasses.Malade;
import io.github.toqueyann.diabete.lesClasses.MaladesBDD;
import io.github.toqueyann.diabete.lesClasses.MapProtocoles;
import io.github.toqueyann.diabete.lesClasses.Protocole;

public class MainActivity extends AppCompatActivity implements Serializable{

    private static final int DISPLAYACTIVITY_REQUESTCODE = 1;

    private RadioButton rdb0;
    private TextView tv;
    private TextView tvNom;
    private TextView tvPrenom;

    private RadioButton rdb1;
    private Button btnAfficher;
    private Button btnAjouter;
    private Button btnSignaler;
    private EditText edtGlycemie;
    private EditText edtNomMalade;
    private EditText edtPrenomMalade;


    private final MapProtocoles m = new MapProtocoles();
    private final MaladesBDD mBDD =  new MaladesBDD(this);
    private Protocole p1 = new Protocole(1);
    private Protocole p2 = new Protocole(2);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // connexion à la bdd
        mBDD.open();
        // au démarrage on vide les tables
        mBDD.viderTable();




        m.initialiser();

        m.getProtocole(2);
        tv = (TextView) findViewById(R.id.tvInsuline);
        tvNom = (TextView) findViewById(R.id.textView3);
        tvPrenom = (TextView) findViewById(R.id.textView4);

        edtGlycemie = (EditText) findViewById(R.id.edtGlycemie);
        edtNomMalade = (EditText) findViewById(R.id.edtNom);
        edtPrenomMalade = (EditText) findViewById(R.id.edtPrenom);

        rdb0 = (RadioButton) findViewById(R.id.rdbProtocole1);
        rdb1 = (RadioButton) findViewById(R.id.rdbProtocole2);
        rdb0.setChecked(true);

        btnAfficher = (Button) findViewById(R.id.btnAfficher);
        btnAjouter = (Button) findViewById(R.id.btnAjouter);
        btnSignaler = (Button) findViewById(R.id.btnSignaler);

        btnAfficher.setOnClickListener(setOnClickListenerAfficher);
        btnAjouter.setOnClickListener(setOnClickListenerAjout);
        btnSignaler.setOnClickListener(setOnClickListenerSignaler);
    }


    private View.OnClickListener setOnClickListenerAfficher = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(edtGlycemie.getText().toString().isEmpty() == true)
            {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Attention");
                alertDialog.setMessage("Vous n'avez pas saisie le taux de glycémie du patient");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "D'accord",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
            else{}


            if (rdb0.isChecked()) {
                p1 = m.getProtocole(1);
                try {


                    double tauxGly = Double.parseDouble(edtGlycemie.getText().toString());
                    int doseInsuline = p1.insuline(tauxGly);
                    String res = String.valueOf(doseInsuline);

                    Log.i("exo", res);
                    tv.setText("Dose : " + doseInsuline);
                } catch (Exception e) {

                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Attention");
                    alertDialog.setMessage("Erreur lors de la saisie : " + "\n" + " - Lettre non acceptées " + "\n" + "- Virgule non acceptée");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "D'accord, je ne referai plus l'erreur",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }

            }

            if (rdb1.isChecked()) {
                p2 = m.getProtocole(2);
                try {


                    double tauxGly = Double.parseDouble(edtGlycemie.getText().toString());
                    int doseInsuline = p2.insuline(tauxGly);
                    String res = String.valueOf(doseInsuline);

                    Log.i("exo", res);
                    tv.setText("Dose : " + doseInsuline);
                } catch (Exception e) {

                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Attention");
                    alertDialog.setMessage("Erreur lors de la saisie : " + "\n" + " - Lettre non acceptées " + "\n" + "- Virgule non acceptée");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "D'accord, je ne referai plus l'erreur",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }

            }

             double txG = Double.parseDouble(edtGlycemie.getText().toString());

            // tx >= 2 on change la visibilté
            if (txG >= 2){


                // on affiche une pop-up afin de notifier l'infirmier
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Taux de glycémie supérieur ou égal à 2 ");
                alertDialog.setMessage("Le malade doit être ajouté aux malades à signaler");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "D'accord",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();

                // on affiche les élements graphiques nécessaires à l'ajout
                tvNom.setVisibility(View.VISIBLE);
                tvPrenom.setVisibility(View.VISIBLE);
                edtNomMalade.setVisibility(View.VISIBLE);
                edtPrenomMalade.setVisibility(View.VISIBLE);
                btnAjouter.setVisibility(View.VISIBLE);

            }else{
                tvNom.setVisibility(View.INVISIBLE);
                tvPrenom.setVisibility(View.INVISIBLE);
                edtNomMalade.setVisibility(View.INVISIBLE);
                edtPrenomMalade.setVisibility(View.INVISIBLE);
                btnAjouter.setVisibility(View.INVISIBLE);

            }


        }
    };

    private View.OnClickListener setOnClickListenerAjout = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // on récupère les infos du malade
            String mNom = edtNomMalade.getText().toString();
            String mPrenom = edtPrenomMalade.getText().toString();
            double mTxGlycemie = Double.parseDouble(edtGlycemie.getText().toString());

            // on instancie la un Malada
            Malade leMalade = new Malade(mNom, mPrenom, mTxGlycemie);


            // on ajoute le malade à la BDD contenant les personnes malades
            mBDD.ajoutMalade(leMalade);
            int nbMalades = mBDD.nombreMalades();
            // on convertit le nbMalade(INT) en String afin de l'afficher dans le Toast
            String nombreMalades = String.valueOf(nbMalades);

            // on affiche le nombre de malade grâce à un toast
            Toast.makeText(MainActivity.this, "La base de données contient : " + nombreMalades + " malades.", Toast.LENGTH_SHORT).show();

            // on se sert du log pour vérifier les malades sont correctement ajoutés à la bdd
            Log.i("D", nombreMalades);

        }
    };

    private View.OnClickListener setOnClickListenerSignaler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // on crée une arrayList de String
            ArrayList<String> lesMaladesSignales = new ArrayList<String>();

            // on crée une arrayList contenant tous les malades de la base de données
            ArrayList lstTousLesMaladesSignales = mBDD.getTousLesMalades();

            // on ajoute les malades de la bdd à l'arrayList String
            lesMaladesSignales.addAll(lstTousLesMaladesSignales);

            // on instancie un intent
            Intent it = new Intent(MainActivity.this, SickToReport.class);

            // on lui passe la variable à passer dans l'autre écran/activité
            it.putExtra("DATA", lesMaladesSignales);
            startActivityForResult(it, DISPLAYACTIVITY_REQUESTCODE);




/*
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"toqueyann@gmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, "Liste des malades a signaler");
            i.putExtra(Intent.EXTRA_TEXT   ,  lesMaladesSignales.toString());
            startActivity(Intent.createChooser(i, "Send mail..."));*/



        }
    };

    /*public void onDestroy(){
        mBDD.viderTable();
    }*/


}
