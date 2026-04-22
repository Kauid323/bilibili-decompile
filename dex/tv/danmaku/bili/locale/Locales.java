package tv.danmaku.bili.locale;

import android.content.res.Resources;
import android.os.Build;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: Locales.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/locale/Locales;", "", "<init>", "()V", "getResourcesLocale", "Ljava/util/Locale;", "getJvmLocale", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class Locales {
    public static final Locales INSTANCE = new Locales();

    private Locales() {
    }

    public final Locale getResourcesLocale() {
        if (Build.VERSION.SDK_INT >= 24) {
            Locale locale = Resources.getSystem().getConfiguration().getLocales().get(0);
            Intrinsics.checkNotNull(locale);
            return locale;
        }
        Locale locale2 = Resources.getSystem().getConfiguration().locale;
        Intrinsics.checkNotNull(locale2);
        return locale2;
    }

    public final Locale getJvmLocale() {
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        return locale;
    }
}