package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: PlatformLocale.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&¢\u0006\u0002\u0010\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/base/localization/PlatformLocaleDelegate;", "Lkntr/base/localization/PlatformLocaleProvider;", "parseLanguageTag", "Ljava/util/Locale;", "Lkntr/base/localization/PlatformLocale;", "languageTag", "", "(Ljava/lang/String;)Ljava/util/Locale;", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface PlatformLocaleDelegate extends PlatformLocaleProvider {
    java.util.Locale parseLanguageTag(String str);
}