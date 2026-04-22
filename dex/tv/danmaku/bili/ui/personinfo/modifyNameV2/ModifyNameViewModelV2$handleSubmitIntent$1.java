package tv.danmaku.bili.ui.personinfo.modifyNameV2;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import tv.danmaku.bili.ui.personinfo.modifyNameV2.ModifyNameV2Event;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ModifyNameViewModelV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.personinfo.modifyNameV2.ModifyNameViewModelV2$handleSubmitIntent$1", f = "ModifyNameViewModelV2.kt", i = {}, l = {124, 128}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ModifyNameViewModelV2$handleSubmitIntent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ModifyNameViewModelV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModifyNameViewModelV2$handleSubmitIntent$1(ModifyNameViewModelV2 modifyNameViewModelV2, Continuation<? super ModifyNameViewModelV2$handleSubmitIntent$1> continuation) {
        super(2, continuation);
        this.this$0 = modifyNameViewModelV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ModifyNameViewModelV2$handleSubmitIntent$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        UnameMessageBean unameMessageBean;
        UnameMessageBean unameMessageBean2;
        MutableSharedFlow mutableSharedFlow;
        MutableSharedFlow mutableSharedFlow2;
        UnameMessageBean unameMessageBean3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                unameMessageBean = this.this$0.unameMsg;
                if (unameMessageBean.getAllow()) {
                    mutableSharedFlow2 = this.this$0._eventFlow;
                    unameMessageBean3 = this.this$0.unameMsg;
                    this.label = 1;
                    if (mutableSharedFlow2.emit(new ModifyNameV2Event.ShowChangeConformDialog(unameMessageBean3.getConfirmMessage()), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    unameMessageBean2 = this.this$0.unameMsg;
                    String it = unameMessageBean2.getUMsg();
                    if (it.length() == 0) {
                        it = null;
                    }
                    if (it != null) {
                        mutableSharedFlow = this.this$0._eventFlow;
                        ModifyNameV2Event.ShowToast showToast = new ModifyNameV2Event.ShowToast(it);
                        this.label = 2;
                        if (mutableSharedFlow.emit(showToast, this) != coroutine_suspended) {
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}