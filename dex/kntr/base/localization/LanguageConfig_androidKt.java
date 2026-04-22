package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LanguageConfig.android.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"supportAiTranslate", "", "Lkntr/base/localization/Locale;", "getSupportAiTranslate", "(Lkntr/base/localization/Locale;)Z", "localization_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LanguageConfig_androidKt {
    public static final boolean getSupportAiTranslate(Locale $this$supportAiTranslate) {
        Intrinsics.checkNotNullParameter($this$supportAiTranslate, "<this>");
        return LanguageConfig.INSTANCE.isSupportAiTranslate($this$supportAiTranslate);
    }
}