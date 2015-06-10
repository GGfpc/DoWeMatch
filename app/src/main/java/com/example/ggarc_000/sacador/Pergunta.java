package com.example.ggarc_000.sacador;

/**
 * Created by ggarc_000 on 08/06/2015.
 */
public class Pergunta {

    private String pergunta;
    private boolean resposta;

    Pergunta(String pergunta, boolean resposta){
        this.pergunta = pergunta;
        this.resposta = resposta;
    }

    public String getPergunta() {
        return pergunta;
    }

    public boolean getResposta(){
        return resposta;
    }

    public boolean checkCorrecta(boolean resposta){
        return resposta == this.resposta;
    }
}