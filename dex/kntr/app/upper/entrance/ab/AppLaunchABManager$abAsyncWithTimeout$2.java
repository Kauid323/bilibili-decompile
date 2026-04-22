package kntr.app.upper.entrance.ab;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppLaunchABManager.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upper.entrance.ab.AppLaunchABManager", f = "AppLaunchABManager.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {162, 166}, m = "abAsyncWithTimeout$entrance_debug", n = {"ab", "mid", "abExtra", "timeMillis", "$i$a$-runCatching-AppLaunchABManager$abAsyncWithTimeout$3", "ab", "mid", "abExtra", "timeMillis", "$i$a$-runCatching-AppLaunchABManager$abAsyncWithTimeout$3"}, s = {"L$0", "L$1", "L$2", "J$0", "I$0", "L$0", "L$1", "L$2", "J$0", "I$0"}, v = 1)
public final class AppLaunchABManager$abAsyncWithTimeout$2 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppLaunchABManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppLaunchABManager$abAsyncWithTimeout$2(AppLaunchABManager appLaunchABManager, Continuation<? super AppLaunchABManager$abAsyncWithTimeout$2> continuation) {
        super(continuation);
        this.this$0 = appLaunchABManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.abAsyncWithTimeout$entrance_debug(null, null, null, 0L, (Continuation) this);
    }
}