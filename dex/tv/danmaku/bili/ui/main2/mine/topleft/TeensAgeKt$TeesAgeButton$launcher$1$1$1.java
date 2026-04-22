package tv.danmaku.bili.ui.main2.mine.topleft;

import androidx.compose.runtime.MutableIntState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TeensAge.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.topleft.TeensAgeKt$TeesAgeButton$launcher$1$1$1", f = "TeensAge.kt", i = {}, l = {BR.bgDrawable}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class TeensAgeKt$TeesAgeButton$launcher$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Integer $age;
    final /* synthetic */ MutableIntState $ageState;
    final /* synthetic */ Function2<Integer, Continuation<? super Unit>, Object> $onSuccess;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TeensAgeKt$TeesAgeButton$launcher$1$1$1(Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> function2, Integer num, MutableIntState mutableIntState, Continuation<? super TeensAgeKt$TeesAgeButton$launcher$1$1$1> continuation) {
        super(2, continuation);
        this.$onSuccess = function2;
        this.$age = num;
        this.$ageState = mutableIntState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TeensAgeKt$TeesAgeButton$launcher$1$1$1(this.$onSuccess, this.$age, this.$ageState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function2<Integer, Continuation<? super Unit>, Object> function2 = this.$onSuccess;
                Integer num = this.$age;
                this.label = 1;
                if (function2.invoke(num, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$ageState.setIntValue(this.$age.intValue());
        return Unit.INSTANCE;
    }
}