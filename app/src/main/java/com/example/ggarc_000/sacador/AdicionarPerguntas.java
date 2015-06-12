package com.example.ggarc_000.sacador;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class AdicionarPerguntas extends ActionBarActivity {

    private Map<TextView, ToggleButton> novasPerguntas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_perguntas);

        novasPerguntas = new HashMap<>();

        novasPerguntas.put((TextView) findViewById(R.id.pergunta1),(ToggleButton) findViewById(R.id.toggleButton1));
        novasPerguntas.put((TextView) findViewById(R.id.pergunta2),(ToggleButton) findViewById(R.id.toggleButton2));
        novasPerguntas.put((TextView) findViewById(R.id.pergunta3),(ToggleButton) findViewById(R.id.toggleButton3));
        novasPerguntas.put((TextView) findViewById(R.id.pergunta4),(ToggleButton) findViewById(R.id.toggleButton4));
        novasPerguntas.put((TextView) findViewById(R.id.pergunta5), (ToggleButton) findViewById(R.id.toggleButton5));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_adicionar_perguntas, menu);
        return true;
    }

    public void criaOnClick(View view){

        Sacador.resetPerguntas();

        for(Map.Entry<TextView, ToggleButton> pergunta : novasPerguntas.entrySet()){
            String textoPergunta = ((TextView) pergunta.getKey()).getText().toString();
            Boolean valorPergunta =  ((ToggleButton) pergunta.getValue()).isChecked();

            if(textoPergunta.length() > 0){
                    Pergunta p = new Pergunta(textoPergunta,valorPergunta);
                    Sacador.setPerguntas(p);
            }


        }

        Intent intent = new Intent(this, Sacador.class);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
