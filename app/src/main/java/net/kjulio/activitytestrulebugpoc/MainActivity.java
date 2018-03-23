package net.kjulio.activitytestrulebugpoc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String EXTRA_KEY = "extra_key";

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent data = new Intent().putExtra(EXTRA_KEY, editText.getText().toString());
                setResult(RESULT_OK, data);
                finish();
            }
        });
    }

    public static String extractExtraFromResultIntent(Intent data) {
        return data.getStringExtra(EXTRA_KEY);
    }

}
