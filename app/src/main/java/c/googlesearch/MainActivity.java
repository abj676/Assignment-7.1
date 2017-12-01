package c.googlesearch;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button reset, search;
    EditText searchkey;
    String key, url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchkey=(EditText)findViewById(R.id.search_key);
        search=(Button)findViewById(R.id.search);
        reset=(Button)findViewById(R.id.reset);
        search.setOnClickListener(this);
        reset.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        key=searchkey.getText().toString();
        switch (view.getId()) {
            case R.id.search:
                if (key.isEmpty()) {
                    Toast.makeText(this, "Enter key words to search", Toast.LENGTH_SHORT).show();
                } else {
                    url = "https://www.google.co.in/search?q=" + key;
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                }
            case R.id.reset:
                searchkey.setText("");
        }
    }
}
