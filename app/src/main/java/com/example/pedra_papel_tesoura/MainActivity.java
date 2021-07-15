package com.example.pedra_papel_tesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

//Trabalho feito pelas alunas: Laura Neri Thomaz da Silva e Luiza Maria da Silva
public class MainActivity extends AppCompatActivity {
    private ImageView imgPedra;
    private ImageView imgPapel;
    private ImageView imgTesoura;
    private ImageView imgApp;
    private TextView  lblResultado;
    private TextView  resJogador;
    private TextView  resApp;
    int jogador;
    int app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgPedra = findViewById(R.id.imgPedra);
        imgPapel = findViewById(R.id.imgPapel);
        imgTesoura = findViewById(R.id.imgTesoura);
        imgApp = findViewById(R.id.imgApp);
        lblResultado = findViewById(R.id.lblResultado);
        resJogador = findViewById(R.id.resJogador);
        resApp = findViewById(R.id.resApp);
        EscutadorClickImagem eci = new EscutadorClickImagem();
        imgPedra.setOnClickListener( eci );
        imgPapel.setOnClickListener( eci );
        imgTesoura.setOnClickListener( eci );
    }
    // classe interna para tratar os cliques nas imagens
    private class EscutadorClickImagem implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // Variável para guardar a escolha do usuário:
            int escolhaUsuario = 0;

            // Precisamos identificar qual imagem o usuário clicou.
            // Devemos converter View (v) em ImageView, e depois utilizar o metodo getId().

            ImageView img = (ImageView) v;

            switch ( img.getId() ) {
                case R.id.imgPedra:
                    escolhaUsuario = 1;
                    break;
                case R.id.imgPapel:
                    escolhaUsuario = 2;
                    break;
                case R.id.imgTesoura:
                    escolhaUsuario = 3;
                    break;
            }
            // Vamos gerar aleatoriamente a escolha do app.
            // O método nextInt(n) gera um número aleatório entre 0 e (n-1).
            // Como queremos de 1 a 3, geramos de 0 a 2, e somamos 1.
            // OBS: Isso é Java básico!!!

            int escolhaApp = new Random().nextInt(3) + 1;

            // Precisamos colocar a imagem correta que reflete
            // A escolha do App:

            switch ( escolhaApp ) {
                case 1:
                    imgApp.setImageResource(R.drawable.pedra);
                    break;
                case 2:
                    imgApp.setImageResource(R.drawable.papel);
                    break;
                case 3:
                    imgApp.setImageResource(R.drawable.tesoura);
                    break;
            }
            // Vamos ver quem ganhou... e informar o resultado.
            if ( ( escolhaApp == 1 && escolhaUsuario == 3 ) ||
                    ( escolhaApp == 2 && escolhaUsuario == 1 ) ||
                    ( escolhaApp == 3 && escolhaUsuario == 2 ) )
            {
                lblResultado.setText("O app ganhou!!!!");
                app=app+1;
                resApp.setText(Integer.toString(app));

            }
            else
            {
                if ( (escolhaApp == 3 && escolhaUsuario == 1) ||
                        (escolhaApp == 1 && escolhaUsuario == 2) ||
                        (escolhaApp == 2 && escolhaUsuario == 3) )
                {
                    lblResultado.setText("Você ganhou!!");
                    jogador=jogador+1;
                    resJogador.setText(Integer.toString(jogador));
                }
                else
                {
                    lblResultado.setText("Deu empate!");
                }
            }
        }
    }
}