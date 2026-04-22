package kntr.app.upper.entrance.utils;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upper.entrance.utils.UnitSuffix;
import kntr.base.localization.Locale;
import kntr.base.localization.Localization;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpperNumberFormat.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0007\u001a\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0003H\u0002¨\u0006\u0006"}, d2 = {"formatNumber", "Lkotlin/Pair;", "", "", "innerFormatNumber", WatchLaterReporterKt.KEY_NUM, "entrance_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UpperNumberFormatKt {
    public static final Pair<String, String> formatNumber(long $this$formatNumber) {
        return innerFormatNumber($this$formatNumber);
    }

    private static final Pair<String, String> innerFormatNumber(long num) {
        Locale current = Localization.INSTANCE.getCurrent();
        if (Intrinsics.areEqual(current, Locale.Companion.getENGLISH())) {
            return new EnFormater().format(String.valueOf(num), UnitSuffix.EnUnit.INSTANCE);
        }
        if (Intrinsics.areEqual(current, Locale.Companion.getTRADITIONAL_CHINESE())) {
            return new ZhFormater().format(String.valueOf(num), UnitSuffix.ZhTraditionUnit.INSTANCE);
        }
        return new ZhFormater().format(String.valueOf(num), UnitSuffix.ZhUnit.INSTANCE);
    }
}