package kntr.app.upper.entrance.ab;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppLaunchABManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upper.entrance.ab.AppLaunchABManager$abAsyncWithTimeout$1", f = "AppLaunchABManager.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class AppLaunchABManager$abAsyncWithTimeout$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ AppLaunchAB $ab;
    final /* synthetic */ String $abExtra;
    final /* synthetic */ Function1<String, Unit> $callback;
    final /* synthetic */ String $mid;
    final /* synthetic */ long $timeMillis;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AppLaunchABManager$abAsyncWithTimeout$1(AppLaunchAB appLaunchAB, String str, String str2, long j, Function1<? super String, Unit> function1, Continuation<? super AppLaunchABManager$abAsyncWithTimeout$1> continuation) {
        super(2, continuation);
        this.$ab = appLaunchAB;
        this.$mid = str;
        this.$abExtra = str2;
        this.$timeMillis = j;
        this.$callback = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppLaunchABManager$abAsyncWithTimeout$1(this.$ab, this.$mid, this.$abExtra, this.$timeMillis, this.$callback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object abAsyncWithTimeout$entrance_debug;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                abAsyncWithTimeout$entrance_debug = AppLaunchABManager.INSTANCE.abAsyncWithTimeout$entrance_debug(this.$ab, this.$mid, this.$abExtra, this.$timeMillis, (Continuation) this);
                if (abAsyncWithTimeout$entrance_debug == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                abAsyncWithTimeout$entrance_debug = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        String result = (String) abAsyncWithTimeout$entrance_debug;
        this.$callback.invoke(result);
        return Unit.INSTANCE;
    }
}