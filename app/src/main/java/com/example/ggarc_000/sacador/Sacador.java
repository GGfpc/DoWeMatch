package com.example.ggarc_000.sacador;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class Sacador extends ActionBarActivity {



    private ArrayList<Pergunta> perguntas = new ArrayList<Pergunta>();
    private static int perguntaCount;
    private static int perguntasCertas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sacador);

        Pergunta p1 = new Pergunta("Tem franja?", true);
        Pergunta p2 = new Pergunta("Gosta do Anselmo?", false);
        Pergunta p3 = new Pergunta("Tem dinheiro?", true);
        Pergunta p4 = new Pergunta("Quer conhecer os meus pais?", false);
        Pergunta p5 = new Pergunta("Tomou banho hoje?", true);

        perguntas.add(p1);
        perguntas.add(p2);
        perguntas.add(p3);
        perguntas.add(p4);
        perguntas.add(p5);

        perguntaCount = 0;
        perguntasCertas = 0;

    }

    @Override
    protected void onStart() {
        super.onStart();

        TextView textoPergunta = (TextView) findViewById(R.id.perguntaCaixaPerguntas);
        textoPergunta.setText(perguntas.get(0).getPergunta());
        textoPergunta.setKeyListener(null);

        TextView numPergunta = (TextView) findViewById(R.id.numPerguntaCaixa);
        String texto = (perguntaCount + 1) + "/" +  (perguntas.size());
        numPergunta.setText(texto);
        numPergunta.setKeyListener(null);
    }

    public void yesButtonOnClick(View view) {

        if (perguntas.get(perguntaCount).checkCorrecta(true)) {
            perguntasCertas++;
        }
        nextPergunta();


    }

    public void noButtonOnClick(View view) {

        if (perguntas.get(perguntaCount).checkCorrecta(false)) {
            perguntasCertas++;
        }

        nextPergunta();


    }

    public void nextPergunta() {

        perguntaCount++;

        if (perguntaCount < perguntas.size()) {

            TextView textoPergunta = (TextView) findViewById(R.id.perguntaCaixaPerguntas);
            textoPergunta.setText(perguntas.get(perguntaCount).getPergunta());
            textoPergunta.setKeyListener(null);

            TextView numPergunta = (TextView) findViewById(R.id.numPerguntaCaixa);
            String texto = (perguntaCount + 1) + "/" +  (perguntas.size());
            numPergunta.setText(texto);
        }

        else {


            Intent intent = new Intent(this, Final.class);
            startActivity(intent);


        }

    }


    public static int getPerguntasCertas() {
        return perguntasCertas;
    }

    public static int getPerguntaCount() {
        return perguntaCount;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sacador, menu);
        return true;
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
