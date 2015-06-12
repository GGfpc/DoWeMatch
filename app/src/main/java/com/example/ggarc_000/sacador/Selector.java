package com.example.ggarc_000.sacador;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;


public class Selector extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selector);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selector, menu);
        return true;
    }

    public void criarOnClick(View view){

        Intent intent = new Intent(this, AdicionarPerguntas.class);
        startActivity(intent);
    }

    public void defaultOnClick(View view){
        Sacador.resetPerguntas();

        Pergunta p1 = new Pergunta("Tem franja?", true);
        Pergunta p2 = new Pergunta("Gosta do Anselmo?", false);
        Pergunta p3 = new Pergunta("Tem dinheiro?", true);
        Pergunta p4 = new Pergunta("Quer conhecer os meus pais?", false);
        Pergunta p5 = new Pergunta("Tomou banho hoje?", true);

        Sacador.setPerguntas(p1);
        Sacador.setPerguntas(p2);
        Sacador.setPerguntas(p3);
        Sacador.setPerguntas(p4);
        Sacador.setPerguntas(p5);

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
