package tv.danmaku.bili.auth.v2;

import android.widget.TextView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import tv.danmaku.bili.BR;

/* compiled from: BiliAuthFragmentV2.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Landroid/widget/TextView;", "it", ""}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.auth.v2.BiliAuthFragmentV2$setContent$1", f = "BiliAuthFragmentV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class BiliAuthFragmentV2$setContent$1 extends SuspendLambda implements Function3<TextView, String, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BiliAuthFragmentV2$setContent$1(Continuation<? super BiliAuthFragmentV2$setContent$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(TextView textView, String str, Continuation<? super Unit> continuation) {
        BiliAuthFragmentV2$setContent$1 biliAuthFragmentV2$setContent$1 = new BiliAuthFragmentV2$setContent$1(continuation);
        biliAuthFragmentV2$setContent$1.L$0 = textView;
        biliAuthFragmentV2$setContent$1.L$1 = str;
        return biliAuthFragmentV2$setContent$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                TextView $this$collect = (TextView) this.L$0;
                String it = (String) this.L$1;
                $this$collect.setText(it);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}