package tv.danmaku.bili.ui.audio;

import android.net.Uri;
import android.text.TextUtils;

public final class AudioIntentHelper {
    public static final String ARGS_FROM = "from";
    public static final String ARGS_URI = "uri";
    public static final String FROM_ACTIVITY = "activity";
    public static final String FROM_SPACE = "personal_space";
    public static final String HOST = "music";

    public static boolean shouldIntercept(Uri uri) {
        return uri != null && TextUtils.equals("bilibili", uri.getScheme()) && TextUtils.equals("music", uri.getHost());
    }

    public static String appendFromIfCan(String rawUri, String from) {
        if (!TextUtils.isEmpty(rawUri) && !TextUtils.isEmpty(from)) {
            Uri uri = Uri.parse(rawUri);
            if (shouldIntercept(uri)) {
                return uri.buildUpon().appendQueryParameter("from", from).build().toString();
            }
        }
        return rawUri;
    }

    public static Uri appendFromIfCan(Uri uri, String from) {
        if (uri == null || TextUtils.isEmpty(from) || !shouldIntercept(uri)) {
            return uri;
        }
        return uri.buildUpon().appendQueryParameter("from", from).build();
    }
}