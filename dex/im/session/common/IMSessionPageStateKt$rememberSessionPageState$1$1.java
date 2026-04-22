package im.session.common;

import androidx.compose.runtime.MutableState;
import com.bapis.bilibili.app.im.v1.KAutoReplyToast;
import im.session.IMSessionViewModel;
import im.session.log.LogTagKt;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionPageState.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.common.IMSessionPageStateKt$rememberSessionPageState$1$1", f = "IMSessionPageState.kt", i = {}, l = {64}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMSessionPageStateKt$rememberSessionPageState$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<KAutoReplyToast> $autoReplyBubble;
    final /* synthetic */ IMSessionViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionPageStateKt$rememberSessionPageState$1$1(IMSessionViewModel iMSessionViewModel, MutableState<KAutoReplyToast> mutableState, Continuation<? super IMSessionPageStateKt$rememberSessionPageState$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = iMSessionViewModel;
        this.$autoReplyBubble = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IMSessionPageStateKt$rememberSessionPageState$1$1(this.$viewModel, this.$autoReplyBubble, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Flow<KAutoReplyToast> autoReplyBubble = this.$viewModel.getAutoReplyBubble();
                final MutableState<KAutoReplyToast> mutableState = this.$autoReplyBubble;
                this.label = 1;
                if (autoReplyBubble.collect(new FlowCollector() { // from class: im.session.common.IMSessionPageStateKt$rememberSessionPageState$1$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((KAutoReplyToast) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(KAutoReplyToast it, Continuation<? super Unit> continuation) {
                        KLog_androidKt.getKLog().i(LogTagKt.SessionLogTag("Compose-Page"), "setting bubble as " + it);
                        mutableState.setValue(it);
                        return Unit.INSTANCE;
                    }
                }, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}