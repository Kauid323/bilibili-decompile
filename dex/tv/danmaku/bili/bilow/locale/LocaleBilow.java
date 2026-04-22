package tv.danmaku.bili.bilow.locale;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.locale.Locales;

/* compiled from: LocaleBilow.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u0012\u0010\u0007\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/bilow/locale/LocaleBilow;", "", "<init>", "()V", "currentLocale", "", "systemLocale", "toLocaleString", "locale", "Ljava/util/Locale;", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LocaleBilow {
    public static final LocaleBilow INSTANCE = new LocaleBilow();

    private LocaleBilow() {
    }

    public final String currentLocale() {
        try {
            Locale app = Locales.INSTANCE.getResourcesLocale();
            return toLocaleString(app);
        } catch (Exception e) {
            BLog.efmt(LocaleBilowKt.TAG, "Exception when get current locale " + e, new Object[0]);
            return "";
        }
    }

    public final String systemLocale() {
        try {
            Locale system = Locales.INSTANCE.getJvmLocale();
            return toLocaleString(system);
        } catch (Exception e) {
            BLog.efmt(LocaleBilowKt.TAG, "Exception when get system locale " + e, new Object[0]);
            return "";
        }
    }

    private final String toLocaleString(Locale locale) {
        String script;
        String script2 = "";
        String language = (locale == null || (language = locale.getLanguage()) == null) ? "" : "";
        if (locale != null && (script = locale.getScript()) != null) {
            script2 = script;
        }
        String region = locale != null ? locale.getCountry() : null;
        return (!StringsKt.isBlank(script2) ? new StringBuilder().append(language).append("-").append(script2) : new StringBuilder().append(language)).append("_").append(region).toString();
    }
}