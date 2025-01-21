package id.example.shashank.newsapp.ui;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.annotation.SuppressLint;
import android.graphics.Insets;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.Locale;

import id.example.shashank.newsapp.R;

public class TtsActivity extends AppCompatActivity {
    TextToSpeech txtToSpeech;
    FloatingActionButton btnSpeech;
    EditText textAudio;
    float speechRate = 1.0f;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tts);

        textAudio = findViewById(R.id.textAudio);
        btnSpeech = findViewById(R.id.btnSpeech);

        txtToSpeech = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                txtToSpeech.setLanguage(Locale.getDefault());
            }
        });

        btnSpeech.setOnClickListener(v -> {
            String text = txtToSpeech.getDefaultVoice().toString();
            txtToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        });
    }

    @Override
    protected void onDestroy() {
        if (txtToSpeech != null) {
            txtToSpeech.stop();
            txtToSpeech.shutdown();
        }
        super.onDestroy();
    }
}

