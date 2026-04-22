package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PlatformLocale.android.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lkntr/base/localization/AndroidLocaleProviderAPI23;", "Lkntr/base/localization/PlatformLocaleProvider;", "<init>", "()V", "current", "Lkntr/base/localization/LocaleList;", "getCurrent", "()Lkntr/base/localization/LocaleList;", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
final class AndroidLocaleProviderAPI23 implements PlatformLocaleProvider {
    public static final AndroidLocaleProviderAPI23 INSTANCE = new AndroidLocaleProviderAPI23();

    private AndroidLocaleProviderAPI23() {
    }

    @Override // kntr.base.localization.PlatformLocaleProvider
    public LocaleList getCurrent() {
        String languageTag = java.util.Locale.getDefault().toLanguageTag();
        Intrinsics.checkNotNullExpressionValue(languageTag, "toLanguageTag(...)");
        return new LocaleList(languageTag);
    }
}