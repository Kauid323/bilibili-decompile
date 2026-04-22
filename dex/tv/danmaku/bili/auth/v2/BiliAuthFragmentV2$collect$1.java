package tv.danmaku.bili.auth.v2;

import android.view.View;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.bili.BR;

/* JADX WARN: Incorrect field signature: TT; */
/* compiled from: BiliAuthFragmentV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$collect$1", f = "BiliAuthFragmentV2.kt", i = {}, l = {302}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BiliAuthFragmentV2$collect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<E> $flow;
    final /* synthetic */ Function3<T, E, Continuation<? super Unit>, Object> $observer;
    final /* synthetic */ View $this_collect;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (Lkotlinx/coroutines/flow/Flow<+TE;>;Lkotlin/jvm/functions/Function3<-TT;-TE;-Lkotlin/coroutines/Continuation<-Lkotlin/Unit;>;+Ljava/lang/Object;>;TT;Lkotlin/coroutines/Continuation<-Ltv/danmaku/bili/auth/v2/BiliAuthFragmentV2$collect$1;>;)V */
    public BiliAuthFragmentV2$collect$1(Flow flow, Function3 function3, View view, Continuation continuation) {
        super(2, continuation);
        this.$flow = flow;
        this.$observer = function3;
        this.$this_collect = view;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BiliAuthFragmentV2$collect$1(this.$flow, this.$observer, this.$this_collect, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Flow<E> flow = this.$flow;
                final Function3<T, E, Continuation<? super Unit>, Object> function3 = this.$observer;
                final View view = this.$this_collect;
                this.label = 1;
                if (flow.collect(new FlowCollector() { // from class: tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$collect$1.1
                    public final Object emit(E e, Continuation<? super Unit> continuation) {
                        Object invoke = function3.invoke(view, e, continuation);
                        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
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