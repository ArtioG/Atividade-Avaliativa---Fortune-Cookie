package com.example.fortunecookie;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView cookieImageView;
    private TextView fortuneTextView;
    private Button breakCookieButton;
    private boolean isCookieBroken = false;

    // Lista de frases
    private String[] fortunes = {
            "A sorte está ao seu lado!",
            "Acredite em si mesmo!",
            "Você terá uma surpresa agradável em breve.",
            "Grandes coisas estão por vir.",
            "Oportunidades aparecerão em seu caminho.",
            "Nunca desista."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referências dos elementos da UI
        cookieImageView = findViewById(R.id.cookieImageView);
        fortuneTextView = findViewById(R.id.fortuneTextView);
        breakCookieButton = findViewById(R.id.breakCookieButton);

        // Configuração do clique no botão
        breakCookieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isCookieBroken) {
                    // Quebra o biscoito (muda a imagem e exibe a frase)
                    breakCookie();
                } else {
                    // Reinicia o biscoito fechado
                    resetCookie();
                }
            }
        });
    }

    private void breakCookie() {
        // Troca a imagem para o biscoito aberto
        cookieImageView.setImageResource(R.drawable.cookie_opened);

        // Seleciona uma frase aleatória
        Random random = new Random();
        String randomFortune = fortunes[random.nextInt(fortunes.length)];

        // Exibe a frase de sorte
        fortuneTextView.setText(randomFortune);

        // Atualiza o estado
        isCookieBroken = true;
        breakCookieButton.setText("Quebrar Outro Biscoito");
    }

    private void resetCookie() {
        // Troca a imagem para o biscoito fechado
        cookieImageView.setImageResource(R.drawable.cookie_closed);

        // Limpa a frase de sorte
        fortuneTextView.setText("");

        // Atualiza o estado
        isCookieBroken = false;
        breakCookieButton.setText("Quebrar Biscoito");
    }
}