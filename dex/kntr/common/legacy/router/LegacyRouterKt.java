package kntr.common.legacy.router;

import com.bilibili.lib.brouter.uri.Uri;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: legacyRouter.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0003H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0003H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"TRIPPING", "", "markTripping", "Lcom/bilibili/lib/brouter/uri/Uri;", "tripping", "", "legacy-router_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LegacyRouterKt {
    private static final String TRIPPING = "kntr_common_legacy_router_TRIPPING";

    public static final Uri markTripping(Uri $this$markTripping) {
        Intrinsics.checkNotNullParameter($this$markTripping, "<this>");
        return $this$markTripping.buildUpon().appendQueryParameter(TRIPPING, "1").build();
    }

    public static final boolean tripping(Uri $this$tripping) {
        Intrinsics.checkNotNullParameter($this$tripping, "<this>");
        return Intrinsics.areEqual($this$tripping.getQueryParameter(TRIPPING), "1");
    }
}