package tv.danmaku.bili.push.pushsetting.system;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SystemPushDialogHelper.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Ltv/danmaku/bili/push/pushsetting/system/DialogInfoSnapshot;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.pushsetting.system.SystemPushDialogHelperKt$awaitSystemPushDialog$2", f = "SystemPushDialogHelper.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SystemPushDialogHelperKt$awaitSystemPushDialog$2 extends SuspendLambda implements Function2<DialogInfoSnapshot, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SystemPushDialogHelperKt$awaitSystemPushDialog$2(Continuation<? super SystemPushDialogHelperKt$awaitSystemPushDialog$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> systemPushDialogHelperKt$awaitSystemPushDialog$2 = new SystemPushDialogHelperKt$awaitSystemPushDialog$2(continuation);
        systemPushDialogHelperKt$awaitSystemPushDialog$2.L$0 = obj;
        return systemPushDialogHelperKt$awaitSystemPushDialog$2;
    }

    public final Object invoke(DialogInfoSnapshot dialogInfoSnapshot, Continuation<? super Boolean> continuation) {
        return create(dialogInfoSnapshot, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                DialogInfoSnapshot it = (DialogInfoSnapshot) this.L$0;
                return Boxing.boxBoolean(it == null);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}