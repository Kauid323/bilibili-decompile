package kntr.app.upper.entrance.bubble;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upper.entrance.utils.LogUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: UperCenterPlusBubbleManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.upper.entrance.bubble.UperCenterPlusBubbleManager$isAbChild$1", f = "UperCenterPlusBubbleManager.kt", i = {}, l = {89}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class UperCenterPlusBubbleManager$isAbChild$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $abExtra;
    final /* synthetic */ Function1<Boolean, Unit> $callback;
    final /* synthetic */ String $mid;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UperCenterPlusBubbleManager$isAbChild$1(String str, String str2, Function1<? super Boolean, Unit> function1, Continuation<? super UperCenterPlusBubbleManager$isAbChild$1> continuation) {
        super(2, continuation);
        this.$mid = str;
        this.$abExtra = str2;
        this.$callback = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UperCenterPlusBubbleManager$isAbChild$1(this.$mid, this.$abExtra, this.$callback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object checkAb;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                checkAb = UperCenterPlusBubbleManager.INSTANCE.checkAb(this.$mid, this.$abExtra, (Continuation) this);
                if (checkAb == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                checkAb = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean result = ((Boolean) checkAb).booleanValue();
        LogUtils.INSTANCE.i("UperCenterPlusBubble", "result=" + result);
        this.$callback.invoke(Boxing.boxBoolean(result));
        return Unit.INSTANCE;
    }
}