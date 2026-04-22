package kntr.base.localization;

import android.os.Build;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformLocale.android.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u000b\u001a\u00020\u0003*\u00060\u0001j\u0002`\u0004H\u0000\u001a\b\u0010\f\u001a\u00020\rH\u0000\u001a\b\u0010\u000e\u001a\u00020\u000fH\u0002\"\u001c\u0010\u0002\u001a\u00020\u0003*\u00060\u0001j\u0002`\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u001c\u0010\u0007\u001a\u00020\u0003*\u00060\u0001j\u0002`\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\"\u001c\u0010\t\u001a\u00020\u0003*\u00060\u0001j\u0002`\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006\"\u000e\u0010\u0010\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u0011"}, d2 = {"PlatformLocale", "Ljava/util/Locale;", "language", "", "Lkntr/base/localization/PlatformLocale;", "getLanguage", "(Ljava/util/Locale;)Ljava/lang/String;", "script", "getScript", "region", "getRegion", "getLanguageTag", "createPlatformLocaleDelegate", "Lkntr/base/localization/PlatformLocaleDelegate;", "createAndroidLocaleProvider", "Lkntr/base/localization/PlatformLocaleProvider;", "TAG", "localization_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PlatformLocale_androidKt {
    private static final String TAG = "Locale";

    public static final String getLanguage(java.util.Locale $this$language) {
        Intrinsics.checkNotNullParameter($this$language, "<this>");
        String language = $this$language.getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        return language;
    }

    public static final String getScript(java.util.Locale $this$script) {
        Intrinsics.checkNotNullParameter($this$script, "<this>");
        String script = $this$script.getScript();
        Intrinsics.checkNotNullExpressionValue(script, "getScript(...)");
        return script;
    }

    public static final String getRegion(java.util.Locale $this$region) {
        Intrinsics.checkNotNullParameter($this$region, "<this>");
        String country = $this$region.getCountry();
        Intrinsics.checkNotNullExpressionValue(country, "getCountry(...)");
        return country;
    }

    public static final String getLanguageTag(java.util.Locale $this$getLanguageTag) {
        Intrinsics.checkNotNullParameter($this$getLanguageTag, "<this>");
        String languageTag = $this$getLanguageTag.toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(languageTag, "toLanguageTag(...)");
        return languageTag;
    }

    public static final PlatformLocaleDelegate createPlatformLocaleDelegate() {
        return new PlatformLocale_androidKt$createPlatformLocaleDelegate$1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlatformLocaleProvider createAndroidLocaleProvider() {
        if (Build.VERSION.SDK_INT >= 24) {
            return AndroidLocaleProviderAPI24.INSTANCE;
        }
        return AndroidLocaleProviderAPI23.INSTANCE;
    }
}