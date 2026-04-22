package tv.danmaku.bili.core.test;

import androidx.compose.runtime.MutableState;
import androidx.fragment.app.FragmentManager;
import com.bilibili.app.comm.list.widget.dialog.AgeSelectorDialogKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CommonTestPage.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.core.test.伪装成系统青少年开关$ContentImpl$1$3$1$1", f = "CommonTestPage.kt", i = {}, l = {BR.followedCountText}, m = "invokeSuspend", n = {}, s = {}, v = 1)
/* renamed from: tv.danmaku.bili.core.test.伪装成系统青少年开关$ContentImpl$1$3$1$1  reason: invalid class name */
public final class $ContentImpl$1$3$1$1 extends SuspendLambda implements Function1<Continuation<? super Integer>, Object> {
    final /* synthetic */ MutableState<Integer> $currentAge;
    final /* synthetic */ FragmentManager $fragmentManager;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public $ContentImpl$1$3$1$1(FragmentManager fragmentManager, MutableState<Integer> mutableState, Continuation<? super $ContentImpl$1$3$1$1> continuation) {
        super(1, continuation);
        this.$fragmentManager = fragmentManager;
        this.$currentAge = mutableState;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new $ContentImpl$1$3$1$1(this.$fragmentManager, this.$currentAge, continuation);
    }

    public final Object invoke(Continuation<? super Integer> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object $result2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                FragmentManager $this$invokeSuspend_u24lambda_u240 = this.$fragmentManager;
                if ($this$invokeSuspend_u24lambda_u240 != null) {
                    int intValue = ((Number) this.$currentAge.getValue()).intValue();
                    this.label = 1;
                    Object chooseAge = AgeSelectorDialogKt.chooseAge($this$invokeSuspend_u24lambda_u240, intValue, this);
                    if (chooseAge == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    $result2 = $result;
                    $result = chooseAge;
                    break;
                } else {
                    return null;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                $result2 = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return (Integer) $result;
    }
}