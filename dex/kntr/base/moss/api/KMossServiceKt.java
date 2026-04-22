package kntr.base.moss.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.platform.IPlatformMoss;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KMossService.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\" \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\t"}, d2 = {"KProtoMessage", "", "kMossServiceImpl", "Lkotlin/Function0;", "Lkntr/base/moss/platform/IPlatformMoss;", "getKMossServiceImpl", "()Lkotlin/jvm/functions/Function0;", "setKMossServiceImpl", "(Lkotlin/jvm/functions/Function0;)V", "moss_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KMossServiceKt {
    public static Function0<? extends IPlatformMoss> kMossServiceImpl;

    public static final Function0<IPlatformMoss> getKMossServiceImpl() {
        Function0 function0 = kMossServiceImpl;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("kMossServiceImpl");
        return null;
    }

    public static final void setKMossServiceImpl(Function0<? extends IPlatformMoss> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        kMossServiceImpl = function0;
    }
}