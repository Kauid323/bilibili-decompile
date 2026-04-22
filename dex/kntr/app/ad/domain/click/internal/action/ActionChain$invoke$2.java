package kntr.app.ad.domain.click.internal.action;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import kntr.app.ad.domain.click.ClickArg;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ActionChain.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.ad.domain.click.internal.action.ActionChain$invoke$2", f = "ActionChain.kt", i = {}, l = {AdditionVote2.URI_FIELD_NUMBER}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ActionChain$invoke$2 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    final /* synthetic */ int $index;
    final /* synthetic */ ClickArg $request;
    int label;
    final /* synthetic */ ActionChain this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionChain$invoke$2(ActionChain actionChain, int i, ClickArg clickArg, Continuation<? super ActionChain$invoke$2> continuation) {
        super(1, continuation);
        this.this$0 = actionChain;
        this.$index = i;
        this.$request = clickArg;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ActionChain$invoke$2(this.this$0, this.$index, this.$request, continuation);
    }

    public final Object invoke(Continuation<? super Boolean> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object invoke;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                invoke = this.this$0.invoke(this.$index + 1, this.$request, (Continuation) this);
                return invoke == coroutine_suspended ? coroutine_suspended : invoke;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}