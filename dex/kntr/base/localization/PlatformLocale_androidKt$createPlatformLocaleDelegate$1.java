package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformLocale.android.kt */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0014\u0010\u0003\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016R\u0012\u0010\b\u001a\u00020\tX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"kntr/base/localization/PlatformLocale_androidKt$createPlatformLocaleDelegate$1", "Lkntr/base/localization/PlatformLocaleDelegate;", "Lkntr/base/localization/PlatformLocaleProvider;", "parseLanguageTag", "Ljava/util/Locale;", "Lkntr/base/localization/PlatformLocale;", "languageTag", "", "current", "Lkntr/base/localization/LocaleList;", "getCurrent", "()Lkntr/base/localization/LocaleList;", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PlatformLocale_androidKt$createPlatformLocaleDelegate$1 implements PlatformLocaleDelegate, PlatformLocaleProvider {
    private final /* synthetic */ PlatformLocaleProvider $$delegate_0;

    @Override // kntr.base.localization.PlatformLocaleProvider
    public LocaleList getCurrent() {
        return this.$$delegate_0.getCurrent();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlatformLocale_androidKt$createPlatformLocaleDelegate$1() {
        PlatformLocaleProvider createAndroidLocaleProvider;
        createAndroidLocaleProvider = PlatformLocale_androidKt.createAndroidLocaleProvider();
        this.$$delegate_0 = createAndroidLocaleProvider;
    }

    @Override // kntr.base.localization.PlatformLocaleDelegate
    public java.util.Locale parseLanguageTag(String languageTag) {
        Intrinsics.checkNotNullParameter(languageTag, "languageTag");
        java.util.Locale platformLocale = java.util.Locale.forLanguageTag(languageTag);
        if (Intrinsics.areEqual(platformLocale.toLanguageTag(), "und")) {
            KLog_androidKt.getKLog().e("Locale", "The language tag " + languageTag + " is not well-formed. Locale is resolved to Undetermined. Note that underscore '_' is not a valid subtag delimiter and must be replaced with '-'.");
        }
        Intrinsics.checkNotNull(platformLocale);
        return platformLocale;
    }
}