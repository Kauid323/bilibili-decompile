package kntr.base.router;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.router.Interceptor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Interceptor.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0086\b¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"context", "T", "", "Lkntr/base/router/Interceptor$Chain;", "(Lkntr/base/router/Interceptor$Chain;)Ljava/lang/Object;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class InterceptorKt {
    public static final /* synthetic */ <T> T context(Interceptor.Chain $this$context) {
        Intrinsics.checkNotNullParameter($this$context, "<this>");
        Intrinsics.reifiedOperationMarker(6, "T");
        T t = (T) $this$context.contextUnsafe(null);
        Intrinsics.reifiedOperationMarker(2, "T");
        return t;
    }
}