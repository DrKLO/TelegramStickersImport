## Stickers Import Sample for Telegram

This is a sample project for importing stickers to Telegram via the Android app.

Please read the full documentation here: https://core.telegram.org/import-stickers

>**WARNING:** Each time a user imports stickers, a **new sticker pack** is created on Telegram. **Do not use** the importing feature to share stickers *you* made with *other* users. If you want to share your stickers, simply upload them using [@stickers](https://t.me/stickers), then share the **link** of your pack. For example, here's a link to install some [Duck Stickers](https://t.me/addstickers/UtyaDuck).

### Supported file formats

1. **PNG** or **WEBP** for static sticker packs with a transparent layer which must fit into a 512x512 square (one of the sides must be 512px and the other 512px or less).
2. [**TGS**](https://core.telegram.org/animated_stickers) for animated stickers packs.

### How to use

Simply send an Android [Intent](https://developer.android.com/guide/components/intents-filters) with the action `org.telegram.messenger.CREATE_STICKER_PACK` and two extras:

1. `Intent.EXTRA_STREAM` containing URIs to the stickers.
2. `STICKER_EMOJIS` with relevant emojis for every sticker you importing.

Additionaly you can provide an `IMPORTER` extra for statistic purposes.

```
private static final String CREATE_STICKER_PACK_ACTION = "org.telegram.messenger.CREATE_STICKER_PACK";
private static final String CREATE_STICKER_PACK_EMOJIS_EXTRA = "STICKER_EMOJIS";
private static final String CREATE_STICKER_PACK_IMPORTER_EXTRA = "IMPORTER";

private void doImport(ArrayList<Uri> stickers, ArrayList<String> emojis) {
    Intent intent = new Intent(CREATE_STICKER_PACK_ACTION);
    intent.putExtra(Intent.EXTRA_STREAM, stickers);
    intent.putExtra(CREATE_STICKER_PACK_IMPORTER_EXTRA, getPackageName());
    intent.putExtra(CREATE_STICKER_PACK_EMOJIS_EXTRA, emojis);
    intent.setType("image/*");

    // Try to invoke the intent.
    try {
        startActivity(sendIntent);
    } catch (ActivityNotFoundException e) {
        // Define what your app should do if no activity can handle the intent.
    }
}
```
