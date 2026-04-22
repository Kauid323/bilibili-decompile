package tv.danmaku.bili.moss.locale;

import com.bapis.bilibili.metadata.locale.Locale;
import com.bapis.bilibili.metadata.locale.LocaleIds;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.locale.Locales;

/* compiled from: LocaleMoss.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u000e\u0010\t\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bH\u0002¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/moss/locale/LocaleMoss;", "", "<init>", "()V", "local", "Lcom/bapis/bilibili/metadata/locale/Locale;", "Ltv/danmaku/bili/moss/locale/MossLocale;", "toLocaleIds", "Lcom/bapis/bilibili/metadata/locale/LocaleIds;", "locale", "Ljava/util/Locale;", "Ltv/danmaku/bili/moss/locale/JavaLocale;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LocaleMoss {
    public static final int $stable = 0;
    public static final LocaleMoss INSTANCE = new LocaleMoss();

    private LocaleMoss() {
    }

    public final Locale local() {
        Locale.Builder builder = Locale.newBuilder();
        try {
            java.util.Locale app = Locales.INSTANCE.getResourcesLocale();
            builder.setCLocale(toLocaleIds(app));
            java.util.Locale system = Locales.INSTANCE.getJvmLocale();
            builder.setSLocale(toLocaleIds(system));
        } catch (Exception e) {
            BLog.efmt(LocaleMossKt.TAG, "Exception when get locale " + e, new Object[0]);
        }
        Locale build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        return build;
    }

    private final LocaleIds toLocaleIds(java.util.Locale locale) {
        String country;
        LocaleIds.Builder $this$toLocaleIds_u24lambda_u240 = LocaleIds.newBuilder();
        String str = "";
        $this$toLocaleIds_u24lambda_u240.setLanguage((locale == null || (r3 = locale.getLanguage()) == null) ? "" : "");
        $this$toLocaleIds_u24lambda_u240.setScript((locale == null || (r3 = locale.getScript()) == null) ? "" : "");
        if (locale != null && (country = locale.getCountry()) != null) {
            str = country;
        }
        $this$toLocaleIds_u24lambda_u240.setRegion(str);
        LocaleIds build = $this$toLocaleIds_u24lambda_u240.build();
        Intrinsics.checkNotNullExpressionValue(build, "run(...)");
        return build;
    }
}