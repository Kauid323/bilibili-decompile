package im.session.common;

import im.session.IMState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IMSessionPageState.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "im.session.common.IMSessionPageStateKt$configListState$2$1", f = "IMSessionPageState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class IMSessionPageStateKt$configListState$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IMSessionPageState $this_configListState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMSessionPageStateKt$configListState$2$1(IMSessionPageState iMSessionPageState, Continuation<? super IMSessionPageStateKt$configListState$2$1> continuation) {
        super(2, continuation);
        this.$this_configListState = iMSessionPageState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new IMSessionPageStateKt$configListState$2$1(this.$this_configListState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$this_configListState.getLastPageSize$session_ui_debug() != ((IMState) this.$this_configListState.getPage().getValue()).getData().getSessions().size()) {
                    this.$this_configListState.setLastPageSize$session_ui_debug(((IMState) this.$this_configListState.getPage().getValue()).getData().getSessions().size());
                } else {
                    this.$this_configListState.getColumnState().requestScrollToItem(this.$this_configListState.getItemIndex$session_ui_debug().getIntValue(), this.$this_configListState.getItemOffset$session_ui_debug().getIntValue());
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}