package tv.danmaku.app;

import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.bilibili.commons.StringUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class AppConfig {
    public static final Pattern BILI_HOST_PATTERN;
    @Deprecated
    public static final String BILI_HTTP_UA_CHROME = "Mozilla/5.0 (Linux; Android " + Build.VERSION.RELEASE + "; " + Build.MODEL + " Build/" + Build.ID + ") AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Mobile Safari/537.36";
    public static final String HOST_ABILISEARCH = "bilibili.tv";
    public static final String HOST_ACTIVITY_CENTER = "activity_center";
    public static final String HOST_AUTHOR = "author";
    public static final String HOST_BANGUMI = "bangumi";
    public static final String HOST_GAME = "game";
    public static final String HOST_GAME_CENTER = "game_center";
    public static final String HOST_GROUP = "group";
    public static final String HOST_LIVE = "live";
    public static final String HOST_PLAY_LIST = "music";
    public static final String HOST_RANK = "rank";
    public static final String HOST_SEARCH = "search";
    public static final String HOST_SPLIST = "splist";
    public static final String HOST_STORY = "story";
    public static final String HOST_TAG = "tag";
    public static final String HOST_TOPIC_CENTER = "topic_center";
    public static final String HOST_TRANSLUCENT_STORY = "story_translucent";
    public static final String HOST_UNICOM = "unicom";
    public static final String HOST_VIDEO = "video";
    public static final String HOST_VIDEO_SHORTCUT = "videoshortcut";
    @Deprecated
    public static final String SCHEME_ABILIAV = "abiliav";
    public static final String SCHEME_BBQ = "qing";
    public static final String SCHEME_BILIBILI = "bilibili";
    public static final String SCHEME_HTTP = "http";
    public static final String SCHEME_HTTPS = "https";
    public static final String SYSTEM_HTTP_UA;

    static {
        String agent = System.getProperty("http.agent");
        if (agent == null) {
            String ver = System.getProperty("java.vm.version");
            if (StringUtils.isEmpty(ver)) {
                ver = "1.6.0";
            }
            agent = "Dalvik/" + ver + " (Linux; U; Android " + Build.VERSION.RELEASE + "; " + Build.MODEL + " Build/" + Build.ID + ")";
        }
        SYSTEM_HTTP_UA = agent;
        BILI_HOST_PATTERN = Pattern.compile("^(?:[\\w-]*\\.)*((?:bilibili\\.(?:com|tv|cn|co))|acgvideo\\.com|acg\\.tv|hdslb\\.com|biligame\\.com|bilibiliyoo\\.com|im9\\.com|b23\\.tv|(bili2233|bili23|bili33|bili22)\\.cn|biliapi\\.net|dreamcast\\.hk)$", 2);
    }

    public static boolean isBiliDomain(Uri uri) {
        if ("bilibili".equals(uri.getScheme())) {
            return true;
        }
        String host = uri.getHost();
        if (TextUtils.isEmpty(host)) {
            return false;
        }
        Matcher m = BILI_HOST_PATTERN.matcher(host);
        return m.find();
    }
}