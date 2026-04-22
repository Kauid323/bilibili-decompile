package tv.danmaku.bili.inner;

import com.bilibili.pvtracker.PageViewTracker;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.service.IAccountRedirect;

/* compiled from: InnerLoginFragment.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.inner.InnerLoginFragment$onCreateView$1$2", f = "InnerLoginFragment.kt", i = {}, l = {BR.favorite}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class InnerLoginFragment$onCreateView$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ InnerLoginFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InnerLoginFragment$onCreateView$1$2(InnerLoginFragment innerLoginFragment, Continuation<? super InnerLoginFragment$onCreateView$1$2> continuation) {
        super(2, continuation);
        this.this$0 = innerLoginFragment;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InnerLoginFragment$onCreateView$1$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                SharedFlow<IAccountRedirect> redirect = this.this$0.getViewModel().getRedirect();
                final InnerLoginFragment innerLoginFragment = this.this$0;
                this.label = 1;
                if (redirect.collect(new FlowCollector() { // from class: tv.danmaku.bili.inner.InnerLoginFragment$onCreateView$1$2.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((IAccountRedirect) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(IAccountRedirect redirect2, Continuation<? super Unit> continuation) {
                        if (redirect2 != null) {
                            InnerLoginFragment.this.routeTo(redirect2);
                        }
                        PageViewTracker.getInstance().setExtra(InnerLoginFragment.this, InnerLoginFragment.this.getPvEventId(), InnerLoginFragment.this.getPvExtra());
                        return Unit.INSTANCE;
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
        throw new KotlinNothingValueException();
    }
}