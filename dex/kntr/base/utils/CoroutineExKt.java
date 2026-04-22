package kntr.base.utils;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: CoroutineEx.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\b\u0010\u0002\u001a\u00020\u0001H\u0007¨\u0006\u0003"}, d2 = {"createIOScope", "Lkotlinx/coroutines/CoroutineScope;", "createMainScope", "coroutine_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class CoroutineExKt {
    public static final CoroutineScope createIOScope() {
        return CoroutineScopeKt.CoroutineScope(CoroutineExJvmKt.getIoContext());
    }

    public static final CoroutineScope createMainScope() {
        return CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate());
    }
}