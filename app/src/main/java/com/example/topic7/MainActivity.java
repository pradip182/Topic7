package com.example.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class MainActivity extends AppCompatActivity {

    Button btnadd;
    EditText etbri;
    EditText etmeani;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnadd=findViewById(R.id.btnadd);
        etbri=findViewById(R.id.etbri);
        etmeani=findViewById(R.id.etmeani);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    PrintStream printStream=new PrintStream(openFileOutput("words.txt",MODE_PRIVATE|MODE_APPEND));
                    printStream.println(etbri.getText().toString() +"->"+ etmeani.getText().toString());
                    Toast.makeText(MainActivity.this, "Saved to"+getFilesDir(), Toast.LENGTH_SHORT).show();
                }
                catch (IOException e)
                {
                    Log.d("Dictionaryapp", "Error: "+e.toString());
                    e.printStackTrace();
                }
            }
        });
    }
}