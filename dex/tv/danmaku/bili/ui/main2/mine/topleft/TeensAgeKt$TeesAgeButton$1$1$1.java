package tv.danmaku.bili.ui.main2.mine.topleft;

import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.compose.runtime.MutableIntState;
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
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TeensAge.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.ui.main2.mine.topleft.TeensAgeKt$TeesAgeButton$1$1$1", f = "TeensAge.kt", i = {1}, l = {BR.btnTextColor, BR.buttonTextColor}, m = "invokeSuspend", n = {"age"}, s = {"L$0"}, v = 1)
public final class TeensAgeKt$TeesAgeButton$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableIntState $ageState;
    final /* synthetic */ boolean $checkPassword;
    final /* synthetic */ Function1<Continuation<? super Integer>, Object> $chooseAge;
    final /* synthetic */ ManagedActivityResultLauncher<Integer, Integer> $launcher;
    final /* synthetic */ Function2<Integer, Continuation<? super Unit>, Object> $onSuccess;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TeensAgeKt$TeesAgeButton$1$1$1(Function1<? super Continuation<? super Integer>, ? extends Object> function1, boolean z, ManagedActivityResultLauncher<Integer, Integer> managedActivityResultLauncher, Function2<? super Integer, ? super Continuation<? super Unit>, ? extends Object> function2, MutableIntState mutableIntState, Continuation<? super TeensAgeKt$TeesAgeButton$1$1$1> continuation) {
        super(2, continuation);
        this.$chooseAge = function1;
        this.$checkPassword = z;
        this.$launcher = managedActivityResultLauncher;
        this.$onSuccess = function2;
        this.$ageState = mutableIntState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TeensAgeKt$TeesAgeButton$1$1$1(this.$chooseAge, this.$checkPassword, this.$launcher, this.$onSuccess, this.$ageState, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object $result2;
        Integer age;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function1<Continuation<? super Integer>, Object> function1 = this.$chooseAge;
                this.label = 1;
                Object invoke = function1.invoke(this);
                if (invoke != coroutine_suspended) {
                    $result2 = $result;
                    $result = invoke;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                $result2 = $result;
                break;
            case 2:
                age = (Integer) this.L$0;
                ResultKt.throwOnFailure($result);
                this.$ageState.setIntValue(age.intValue());
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Integer age2 = (Integer) $result;
        if (age2 != null) {
            if (this.$checkPassword) {
                this.$launcher.launch(age2);
            } else {
                Function2<Integer, Continuation<? super Unit>, Object> function2 = this.$onSuccess;
                this.L$0 = age2;
                this.label = 2;
                if (function2.invoke(age2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                age = age2;
                $result = $result2;
                this.$ageState.setIntValue(age.intValue());
            }
        }
        return Unit.INSTANCE;
    }
}