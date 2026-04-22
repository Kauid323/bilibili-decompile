package kntr.app.tribee.publish;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.focus.FocusManager;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TribeePublishPage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.tribee.publish.TribeePublishPageKt$TribeePublishPage$2$1$7$1$2", f = "TribeePublishPage.kt", i = {}, l = {180}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TribeePublishPageKt$TribeePublishPage$2$1$7$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FocusManager $focusManager;
    final /* synthetic */ MutableState<Boolean> $showSettingPanel$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TribeePublishPageKt$TribeePublishPage$2$1$7$1$2(FocusManager focusManager, MutableState<Boolean> mutableState, Continuation<? super TribeePublishPageKt$TribeePublishPage$2$1$7$1$2> continuation) {
        super(2, continuation);
        this.$focusManager = focusManager;
        this.$showSettingPanel$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TribeePublishPageKt$TribeePublishPage$2$1$7$1$2(this.$focusManager, this.$showSettingPanel$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                FocusManager.-CC.clearFocus$default(this.$focusManager, false, 1, (Object) null);
                this.label = 1;
                if (DelayKt.delay(200L, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        TribeePublishPageKt.TribeePublishPage$lambda$5(this.$showSettingPanel$delegate, true);
        return Unit.INSTANCE;
    }
}