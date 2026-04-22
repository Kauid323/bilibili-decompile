package kntr.app.upper.entrance.ab;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppLaunchABManager.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upper.entrance.ab.AppLaunchABManager", f = "AppLaunchABManager.kt", i = {0, 0, 0}, l = {199}, m = "getAbInternal", n = {"ab", "mid", "abExtra"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class AppLaunchABManager$getAbInternal$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppLaunchABManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppLaunchABManager$getAbInternal$1(AppLaunchABManager appLaunchABManager, Continuation<? super AppLaunchABManager$getAbInternal$1> continuation) {
        super(continuation);
        this.this$0 = appLaunchABManager;
    }

    public final Object invokeSuspend(Object obj) {
        Object abInternal;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        abInternal = this.this$0.getAbInternal(null, null, null, (Continuation) this);
        return abInternal;
    }
}