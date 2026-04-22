package kntr.app.game.base.viewmodel;

import com.freeletics.flowredux.dsl.ChangedState;
import com.freeletics.flowredux.dsl.State;
import kntr.app.game.base.viewmodel.PageState;
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
/* JADX INFO: Add missing generic type declarations: [Data] */
/* compiled from: BaseViewModel.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u00032\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u00060\u0005H\n"}, d2 = {"<anonymous>", "Lcom/freeletics/flowredux/dsl/ChangedState;", "Lkntr/app/game/base/viewmodel/PageState;", "Data", "state", "Lcom/freeletics/flowredux/dsl/State;", "Lkntr/app/game/base/viewmodel/PageState$Content;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.game.base.viewmodel.BaseViewModel$machine$1$4$4$1", f = "BaseViewModel.kt", i = {0}, l = {69}, m = "invokeSuspend", n = {"state"}, s = {"L$0"}, v = 1)
public final class BaseViewModel$machine$1$4$4$1<Data> extends SuspendLambda implements Function2<State<PageState.Content<Data>>, Continuation<? super ChangedState<? extends PageState>>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BaseViewModel<Data> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewModel$machine$1$4$4$1(BaseViewModel<Data> baseViewModel, Continuation<? super BaseViewModel$machine$1$4$4$1> continuation) {
        super(2, continuation);
        this.this$0 = baseViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> baseViewModel$machine$1$4$4$1 = new BaseViewModel$machine$1$4$4$1<>(this.this$0, continuation);
        baseViewModel$machine$1$4$4$1.L$0 = obj;
        return baseViewModel$machine$1$4$4$1;
    }

    public final Object invoke(State<PageState.Content<Data>> state, Continuation<? super ChangedState<? extends PageState>> continuation) {
        return create(state, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((State) ((State) obj), (Continuation) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object $result) {
        Object loadData$default;
        final State state = (State) this.L$0;
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
            Object newData = loadData$default;
            if (newData != null && !this.this$0.checkEmpty(newData)) {
                this.this$0.onDataSuccess();
                final Object data = this.this$0.mergeData(((PageState.Content) state.getSnapshot()).getData(), newData);
                return state.override(new Function1() { // from class: kntr.app.game.base.viewmodel.BaseViewModel$machine$1$4$4$1$$ExternalSyntheticLambda1
                    public final Object invoke(Object obj) {
                        PageState.Content invokeSuspend$lambda$1;
                        invokeSuspend$lambda$1 = BaseViewModel$machine$1$4$4$1.invokeSuspend$lambda$1(data, (PageState.Content) obj);
                        return invokeSuspend$lambda$1;
                    }
                });
            }
            return state.override(new Function1() { // from class: kntr.app.game.base.viewmodel.BaseViewModel$machine$1$4$4$1$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    PageState.Content invokeSuspend$lambda$0;
                    invokeSuspend$lambda$0 = BaseViewModel$machine$1$4$4$1.invokeSuspend$lambda$0(state, (PageState.Content) obj);
                    return invokeSuspend$lambda$0;
                }
            });
        } catch (Throwable th) {
            return state.override(new Function1() { // from class: kntr.app.game.base.viewmodel.BaseViewModel$machine$1$4$4$1$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    PageState.Content invokeSuspend$lambda$2;
                    invokeSuspend$lambda$2 = BaseViewModel$machine$1$4$4$1.invokeSuspend$lambda$2(state, (PageState.Content) obj);
                    return invokeSuspend$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PageState.Content invokeSuspend$lambda$0(State $state, PageState.Content $this$override) {
        return new PageState.Content(((PageState.Content) $state.getSnapshot()).getData(), PageLoadMoreState.Companion.getNoMore(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PageState.Content invokeSuspend$lambda$1(Object $data, PageState.Content $this$override) {
        return new PageState.Content($data, null, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PageState.Content invokeSuspend$lambda$2(State $state, PageState.Content $this$override) {
        return new PageState.Content(((PageState.Content) $state.getSnapshot()).getData(), PageLoadMoreState.Companion.getError(), null, 4, null);
    }
}