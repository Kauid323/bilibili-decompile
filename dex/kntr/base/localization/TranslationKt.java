package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Translation.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u001c\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0002\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"allowAlwaysTranslate", "", "userEnabled", "currentLocale", "Lkntr/base/localization/Locale;", "TAG", "", "localization_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TranslationKt {
    private static final String TAG = "Localization";

    public static /* synthetic */ boolean allowAlwaysTranslate$default(boolean z, Locale locale, int i, Object obj) {
        if ((i & 1) != 0) {
            z = Translation.INSTANCE.getUserEnabled();
        }
        if ((i & 2) != 0) {
            locale = Localization.INSTANCE.getCurrent();
        }
        return allowAlwaysTranslate(z, locale);
    }

    private static final boolean allowAlwaysTranslate(boolean userEnabled, Locale currentLocale) {
        return userEnabled && !Intrinsics.areEqual(currentLocale, Localization.INSTANCE.getDEFAULT()) && LanguageConfig.INSTANCE.isSupportAiTranslate(currentLocale);
    }
}