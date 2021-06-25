package org.telegram.stickersimportexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String CREATE_STICKER_PACK_ACTION = "org.telegram.messenger.CREATE_STICKER_PACK";
    private static final String CREATE_STICKER_PACK_EMOJIS_EXTRA = "STICKER_EMOJIS";
    private static final String CREATE_STICKER_PACK_IMPORTER_EXTRA = "IMPORTER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        if (button != null) {
            button.setOnClickListener(v -> {
                ArrayList<Uri> uris = new ArrayList<>();
                uris.add(getRawUri("sticker1"));
                uris.add(getRawUri("sticker2"));
                uris.add(getRawUri("sticker3"));
                uris.add(getRawUri("sticker4"));
                uris.add(getRawUri("sticker5"));
                uris.add(getRawUri("sticker6"));
                uris.add(getRawUri("sticker7"));
                uris.add(getRawUri("sticker8"));
                uris.add(getRawUri("sticker9"));

                ArrayList<String> emojis = new ArrayList<>();
                emojis.add("☺️");
                emojis.add("\uD83D\uDE22");
                emojis.add("\uD83E\uDD73");
                emojis.add("\uD83E\uDD2A");
                emojis.add("\uD83D\uDE18️");
                emojis.add("\uD83D\uDE18️");
                emojis.add("\uD83E\uDD2A");
                emojis.add("\uD83E\uDD73");
                emojis.add("☺️");

                doImport(uris, emojis);
            });
        }

        button = findViewById(R.id.button2);
        if (button != null) {
            button.setOnClickListener(v -> {
                ArrayList<Uri> uris = new ArrayList<>();
                uris.add(getRawUri("a_sticker1"));
                uris.add(getRawUri("a_sticker2"));
                uris.add(getRawUri("a_sticker3"));
                uris.add(getRawUri("a_sticker4"));
                uris.add(getRawUri("a_sticker5"));
                uris.add(getRawUri("a_sticker6"));
                uris.add(getRawUri("a_sticker7"));
                uris.add(getRawUri("a_sticker8"));
                uris.add(getRawUri("a_sticker9"));

                ArrayList<String> emojis = new ArrayList<>();
                emojis.add("☺️");
                emojis.add("\uD83D\uDE22");
                emojis.add("\uD83E\uDD73");
                emojis.add("\uD83E\uDD2A");
                emojis.add("\uD83D\uDE18️");
                emojis.add("\uD83D\uDE18️");
                emojis.add("\uD83E\uDD2A");
                emojis.add("\uD83E\uDD73");
                emojis.add("☺️");

                doImport(uris, emojis);
            });
        }
    }

    private void doImport(ArrayList<Uri> stickers, ArrayList<String> emojis) {
        Intent intent = new Intent(CREATE_STICKER_PACK_ACTION);
        intent.putExtra(Intent.EXTRA_STREAM, stickers);
        intent.putExtra(CREATE_STICKER_PACK_IMPORTER_EXTRA, getPackageName());
        intent.putExtra(CREATE_STICKER_PACK_EMOJIS_EXTRA, emojis);
        intent.setType("image/*");
        try {
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
            //no activity to handle intent
        }
    }

    private Uri getRawUri(String filename) {
        return Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getPackageName() + "/raw/" + filename);
    }
}