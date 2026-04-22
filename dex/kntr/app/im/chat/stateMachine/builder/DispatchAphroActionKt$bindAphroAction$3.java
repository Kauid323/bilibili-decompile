package kntr.app.im.chat.stateMachine.builder;

import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.im.chat.core.model.ChatAction;
import kntr.app.im.chat.core.model.ChatPageData;
import kntr.app.im.chat.core.model.ChatPageDataLensKt;
import kntr.app.im.chat.core.model.InputBoxSelectState;
import kntr.common.photonic.aphro.core.AphroState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DispatchAphroAction.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/im/chat/core/model/ChatPageData;", "action", "Lkntr/app/im/chat/core/model/ChatAction$SwitchBottomSheetToGallery;", "state", "Lcom/freeletics/flowredux/dsl/State;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.im.chat.stateMachine.builder.DispatchAphroActionKt$bindAphroAction$3", f = "DispatchAphroAction.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DispatchAphroActionKt$bindAphroAction$3 extends SuspendLambda implements Function3<ChatAction.SwitchBottomSheetToGallery, State<ChatPageData>, Continuation<? super ChangedState<? extends ChatPageData>>, Object> {
    final /* synthetic */ Function1<ChatPageData, AphroState.Init> $getInitState;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DispatchAphroActionKt$bindAphroAction$3(Function1<? super ChatPageData, AphroState.Init> function1, Continuation<? super DispatchAphroActionKt$bindAphroAction$3> continuation) {
        super(3, continuation);
        this.$getInitState = function1;
    }

    public final Object invoke(ChatAction.SwitchBottomSheetToGallery switchBottomSheetToGallery, State<ChatPageData> state, Continuation<? super ChangedState<ChatPageData>> continuation) {
        DispatchAphroActionKt$bindAphroAction$3 dispatchAphroActionKt$bindAphroAction$3 = new DispatchAphroActionKt$bindAphroAction$3(this.$getInitState, continuation);
        dispatchAphroActionKt$bindAphroAction$3.L$0 = state;
        return dispatchAphroActionKt$bindAphroAction$3.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        State state = (State) this.L$0;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final Function1<ChatPageData, AphroState.Init> function1 = this.$getInitState;
                return state.mutate(new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.DispatchAphroActionKt$bindAphroAction$3$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj) {
                        ChatPageData invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = DispatchAphroActionKt$bindAphroAction$3.invokeSuspend$lambda$0(function1, (ChatPageData) obj);
                        return invokeSuspend$lambda$0;
                    }
                });
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ChatPageData invokeSuspend$lambda$0(final Function1 $getInitState, ChatPageData $this$mutate) {
        return (ChatPageData) CopyScopeKt.copy($this$mutate, new Function1() { // from class: kntr.app.im.chat.stateMachine.builder.DispatchAphroActionKt$bindAphroAction$3$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                Unit invokeSuspend$lambda$0$0;
                invokeSuspend$lambda$0$0 = DispatchAphroActionKt$bindAphroAction$3.invokeSuspend$lambda$0$0($getInitState, (CopyScope) obj);
                return invokeSuspend$lambda$0$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0$0(Function1 $getInitState, CopyScope $this$copy) {
        $this$copy.set(ChatPageDataLensKt.getInputBoxSelectState(ChatPageData.Companion), new InputBoxSelectState.Gallery((AphroState) $getInitState.invoke($this$copy.getCurrent())));
        return Unit.INSTANCE;
    }
}