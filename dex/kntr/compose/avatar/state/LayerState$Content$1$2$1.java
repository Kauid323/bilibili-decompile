package kntr.compose.avatar.state;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.compose.avatar.internal.LayerScopeImpl;
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
/* compiled from: LayerState.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.compose.avatar.state.LayerState$Content$1$2$1", f = "LayerState.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class LayerState$Content$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LayerScopeImpl $this_with;
    int label;
    final /* synthetic */ LayerState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayerState$Content$1$2$1(LayerState layerState, LayerScopeImpl layerScopeImpl, Continuation<? super LayerState$Content$1$2$1> continuation) {
        super(2, continuation);
        this.this$0 = layerState;
        this.$this_with = layerScopeImpl;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LayerState$Content$1$2$1(this.this$0, this.$this_with, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.this$0.setOriginPosition$ui_debug(this.$this_with.mo2460normalizedRect3ABfNKs(this.this$0.getLayer().getGeneralSpec(), this.this$0.m2562getNormalSizeD9Ej5fM()));
                this.this$0.setDrawPosition(this.this$0.getOriginPosition());
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}