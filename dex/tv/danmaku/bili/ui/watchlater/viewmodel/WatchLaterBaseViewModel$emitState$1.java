package tv.danmaku.bili.ui.watchlater.viewmodel;

import com.bapis.bilibili.app.dynamic.v2.DynModuleType;
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
import kotlinx.coroutines.flow.MutableStateFlow;
import tv.danmaku.bili.ui.watchlater.data.WLState;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WatchLaterBaseViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.watchlater.viewmodel.WatchLaterBaseViewModel$emitState$1", f = "WatchLaterBaseViewModel.kt", i = {}, l = {DynModuleType.module_opus_collection_VALUE, DynModuleType.module_onetime_notice_VALUE}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class WatchLaterBaseViewModel$emitState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super S>, Object> $builder;
    int label;
    final /* synthetic */ WatchLaterBaseViewModel<S> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchLaterBaseViewModel$emitState$1(Function1<? super Continuation<? super S>, ? extends Object> function1, WatchLaterBaseViewModel<S> watchLaterBaseViewModel, Continuation<? super WatchLaterBaseViewModel$emitState$1> continuation) {
        super(2, continuation);
        this.$builder = function1;
        this.this$0 = watchLaterBaseViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchLaterBaseViewModel$emitState$1(this.$builder, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object $result2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function1<Continuation<? super S>, Object> function1 = this.$builder;
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
        WLState it = (WLState) $result;
        if (it != null) {
            MutableStateFlow mutableStateFlow = this.this$0.get_state();
            this.label = 2;
            if (mutableStateFlow.emit(it, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            $result = $result2;
        }
        return Unit.INSTANCE;
    }
}