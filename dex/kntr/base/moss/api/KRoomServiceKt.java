package kntr.base.moss.api;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.platform.IPlatformRoomServiceBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KRoomService.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\" \u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"kRoomServiceBuilder", "Lkotlin/Function0;", "Lkntr/base/moss/platform/IPlatformRoomServiceBuilder;", "getKRoomServiceBuilder", "()Lkotlin/jvm/functions/Function0;", "setKRoomServiceBuilder", "(Lkotlin/jvm/functions/Function0;)V", "moss_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class KRoomServiceKt {
    public static Function0<? extends IPlatformRoomServiceBuilder> kRoomServiceBuilder;

    public static final Function0<IPlatformRoomServiceBuilder> getKRoomServiceBuilder() {
        Function0 function0 = kRoomServiceBuilder;
        if (function0 != null) {
            return function0;
        }
        Intrinsics.throwUninitializedPropertyAccessException("kRoomServiceBuilder");
        return null;
    }

    public static final void setKRoomServiceBuilder(Function0<? extends IPlatformRoomServiceBuilder> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        kRoomServiceBuilder = function0;
    }
}