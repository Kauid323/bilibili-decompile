package tv.danmaku.bili.fullscreen.service;

import androidx.activity.ComponentActivity;
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

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: ActivityProviderService.kt */
@Metadata(d1 = {"\u0000\b\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.fullscreen.service.ActivityUIHandler$handle$3", f = "ActivityProviderService.kt", i = {}, l = {BR.bannerControl}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ActivityUIHandler$handle$3<R> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super R>, Object> {
    final /* synthetic */ ComponentActivity $activity;
    final /* synthetic */ Function2<ComponentActivity, Continuation<? super R>, Object> $block;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityUIHandler$handle$3(Function2<? super ComponentActivity, ? super Continuation<? super R>, ? extends Object> function2, ComponentActivity componentActivity, Continuation<? super ActivityUIHandler$handle$3> continuation) {
        super(2, continuation);
        this.$block = function2;
        this.$activity = componentActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ActivityUIHandler$handle$3<>(this.$block, this.$activity, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((CoroutineScope) obj, (Continuation) ((Continuation) obj2));
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super R> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function2<ComponentActivity, Continuation<? super R>, Object> function2 = this.$block;
                ComponentActivity componentActivity = this.$activity;
                this.label = 1;
                Object invoke = function2.invoke(componentActivity, this);
                if (invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return invoke;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}