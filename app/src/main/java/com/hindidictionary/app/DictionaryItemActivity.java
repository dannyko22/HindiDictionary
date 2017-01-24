package com.hindidictionary.app;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class DictionaryItemActivity extends ActionBarActivity {

    String hindiChars;
    String englishChars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dictionary_item_activity);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        // Set the strings in the class declaration.
        Intent intent = getIntent();


        hindiChars = intent.getStringExtra("hindiWords");
        hindiChars = "• " + hindiChars;
        hindiChars = hindiChars.replaceAll(";","\n•");

        TextView textViewHindiChars = (TextView) findViewById(R.id.hindiTextView);
        Button hindiButton = (Button) findViewById(R.id.hindiButton);

        textViewHindiChars.setText(hindiChars);

        englishChars = intent.getStringExtra("englishWords");
        englishChars = "• " + englishChars;
        englishChars = englishChars.replaceAll(";","\n•");

        TextView textViewEnglishChars = (TextView) findViewById(R.id.englishTextView);
        textViewEnglishChars.setText(englishChars);
    }

    public void copyEnglish(View v)
    {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("english", englishChars);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(getApplicationContext(), "English copied to Clipboard",
                Toast.LENGTH_LONG).show();
    }

    public void copyHindi(View v)
    {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("hindi", hindiChars);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(getApplicationContext(), "Hindi copied to Clipboard",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.dictionary_item, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
