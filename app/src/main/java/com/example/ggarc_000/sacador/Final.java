package com.example.ggarc_000.sacador;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;


public class Final extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        double perc = (double) Sacador.getPerguntasCertas() / (double) Sacador.getPerguntaCount();

        TextView texto = (TextView) findViewById(R.id.percentagemCerta);
        texto.setText((perc) * 100 + "% Pitavel");
        texto.setKeyListener(null);



    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_final, menu);
        Intent intent = getIntent();

        return true;
    }

    public void deNovoOnClick(View view){

        Intent intent = new Intent(this, Splash.class);
        startActivity(intent);
        finish();



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
