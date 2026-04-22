package kntr.app.game.base.viewmodel;

import com.bilibili.biligame.kntr.common.api.BiligameApiException;
import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.game.base.viewmodel.PageState;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseViewModel.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/game/base/viewmodel/PageState;", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/game/base/viewmodel/PageState$Loading;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.base.viewmodel.BaseViewModel$machine$1$2$1", f = "BaseViewModel.kt", i = {0}, l = {40}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class BaseViewModel$machine$1$2$1 extends SuspendLambda implements Function2<State<PageState.Loading>, Continuation<? super ChangedState<? extends PageState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BaseViewModel<Data> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewModel$machine$1$2$1(BaseViewModel<Data> baseViewModel, Continuation<? super BaseViewModel$machine$1$2$1> continuation) {
        super(2, continuation);
        this.this$0 = baseViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> baseViewModel$machine$1$2$1 = new BaseViewModel$machine$1$2$1(this.this$0, continuation);
        baseViewModel$machine$1$2$1.L$0 = obj;
        return baseViewModel$machine$1$2$1;
    }

    public final Object invoke(State<PageState.Loading> state, Continuation<? super ChangedState<? extends PageState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object loadData$default;
        State state = (State) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.L$0 = state;
                    this.label = 1;
                    loadData$default = BaseViewModel.loadData$default(this.this$0, false, (Continuation) this, 1, null);
                    if (loadData$default == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    loadData$default = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            final Object data = loadData$default;
            if (data != null && !this.this$0.checkEmpty(data)) {
                this.this$0.onDataSuccess();
                return state.override(new Function1() { // from class: kntr.app.game.base.viewmodel.BaseViewModel$machine$1$2$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        PageState.Content invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = BaseViewModel$machine$1$2$1.invokeSuspend$lambda$1(data, (PageState.Loading) obj);
                        return invokeSuspend$lambda$1;
                    }
                });
            }
            return state.override(new Function1() { // from class: kntr.app.game.base.viewmodel.BaseViewModel$machine$1$2$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    PageState.Empty invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = BaseViewModel$machine$1$2$1.invokeSuspend$lambda$0((PageState.Loading) obj);
                    return invokeSuspend$lambda$0;
                }
            });
        } catch (Throwable th) {
            final int code = th instanceof BiligameApiException ? th.getCode() : -1;
            return state.override(new Function1() { // from class: kntr.app.game.base.viewmodel.BaseViewModel$machine$1$2$1$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    PageState.Error invokeSuspend$lambda$2;
                    invokeSuspend$lambda$2 = BaseViewModel$machine$1$2$1.invokeSuspend$lambda$2(code, th, (PageState.Loading) obj);
                    return invokeSuspend$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PageState.Empty invokeSuspend$lambda$0(PageState.Loading $this$override) {
        return PageState.Empty.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PageState.Content invokeSuspend$lambda$1(Object $data, PageState.Loading $this$override) {
        return new PageState.Content($data, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PageState.Error invokeSuspend$lambda$2(int $code, Throwable $e, PageState.Loading $this$override) {
        String message = $e.getMessage();
        if (message == null) {
            message = RoomRecommendViewModel.EMPTY_CURSOR;
        }
        return new PageState.Error($code, message);
    }
}