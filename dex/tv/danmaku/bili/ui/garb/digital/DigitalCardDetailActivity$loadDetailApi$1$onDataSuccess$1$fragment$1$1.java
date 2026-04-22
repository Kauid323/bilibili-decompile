package tv.danmaku.bili.ui.garb.digital;

import com.bilibili.digital.card.DigitalPageFragment;
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
import kotlinx.coroutines.flow.MutableSharedFlow;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DigitalCardDetailActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.garb.digital.DigitalCardDetailActivity$loadDetailApi$1$onDataSuccess$1$fragment$1$1", f = "DigitalCardDetailActivity.kt", i = {}, l = {177}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class DigitalCardDetailActivity$loadDetailApi$1$onDataSuccess$1$fragment$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DigitalPageFragment $this_apply;
    int label;
    final /* synthetic */ DigitalCardDetailActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DigitalCardDetailActivity$loadDetailApi$1$onDataSuccess$1$fragment$1$1(DigitalPageFragment digitalPageFragment, DigitalCardDetailActivity digitalCardDetailActivity, Continuation<? super DigitalCardDetailActivity$loadDetailApi$1$onDataSuccess$1$fragment$1$1> continuation) {
        super(2, continuation);
        this.$this_apply = digitalPageFragment;
        this.this$0 = digitalCardDetailActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DigitalCardDetailActivity$loadDetailApi$1$onDataSuccess$1$fragment$1$1(this.$this_apply, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                MutableSharedFlow dismissRequestFlow = this.$this_apply.getDismissRequestFlow();
                final DigitalCardDetailActivity digitalCardDetailActivity = this.this$0;
                this.label = 1;
                if (dismissRequestFlow.collect(new FlowCollector() { // from class: tv.danmaku.bili.ui.garb.digital.DigitalCardDetailActivity$loadDetailApi$1$onDataSuccess$1$fragment$1$1.1
                    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                        return emit((Unit) value, (Continuation<? super Unit>) $completion);
                    }

                    public final Object emit(Unit it, Continuation<? super Unit> continuation) {
                        DigitalCardDetailActivity.this.setResult(-1);
                        DigitalCardDetailActivity.this.finish();
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