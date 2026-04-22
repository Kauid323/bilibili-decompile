package tv.danmaku.bili.push.pushsetting.system;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.pushsetting.manager.PushGuidanceManagerKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SystemPushDialogHelper.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.pushsetting.system.SystemPushDialogHelperKt$showSystemPushDialog$1", f = "SystemPushDialogHelper.kt", i = {}, l = {BR.danmakuNumIcon}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SystemPushDialogHelperKt$showSystemPushDialog$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SystemPushDialogHelperKt$showSystemPushDialog$1(Continuation<? super SystemPushDialogHelperKt$showSystemPushDialog$1> continuation) {
        super(1, continuation);
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new SystemPushDialogHelperKt$showSystemPushDialog$1(continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (PushGuidanceManagerKt.waitClearServerHistory((Continuation) this) == coroutine_suspended) {
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