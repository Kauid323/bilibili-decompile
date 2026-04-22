package tv.danmaku.bili.ui.favorites.viewmodel;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseFavoritesViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.favorites.viewmodel.BaseFavoritesViewModel$sendEffect$1", f = "BaseFavoritesViewModel.kt", i = {}, l = {BR.bannerControl, BR.bannerItemDataList}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class BaseFavoritesViewModel$sendEffect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super UIEffect>, Object> $builder;
    int label;
    final /* synthetic */ BaseFavoritesViewModel<UserAction, UIState, UIEffect> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseFavoritesViewModel$sendEffect$1(Function1<? super Continuation<? super UIEffect>, ? extends Object> function1, BaseFavoritesViewModel<UserAction, UIState, UIEffect> baseFavoritesViewModel, Continuation<? super BaseFavoritesViewModel$sendEffect$1> continuation) {
        super(2, continuation);
        this.$builder = function1;
        this.this$0 = baseFavoritesViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseFavoritesViewModel$sendEffect$1(this.$builder, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object $result2;
        MutableSharedFlow mutableSharedFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function1<Continuation<? super UIEffect>, Object> function1 = this.$builder;
                this.label = 1;
                Object invoke = function1.invoke(this);
                if (invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result2 = $result;
                $result = invoke;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                $result2 = $result;
                break;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        IUIEvent it = (IUIEvent) $result;
        if (it != null) {
            mutableSharedFlow = this.this$0.get_eventFlow();
            this.label = 2;
            if (mutableSharedFlow.emit(it, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            $result = $result2;
        }
        return Unit.INSTANCE;
    }
}