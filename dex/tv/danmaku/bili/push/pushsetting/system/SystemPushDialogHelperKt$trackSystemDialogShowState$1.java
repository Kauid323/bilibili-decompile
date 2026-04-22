package tv.danmaku.bili.push.pushsetting.system;

import androidx.lifecycle.Lifecycle;
import com.bilibili.lib.neuron.api.Neurons;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SystemPushDialogHelper.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.pushsetting.system.SystemPushDialogHelperKt$trackSystemDialogShowState$1", f = "SystemPushDialogHelper.kt", i = {}, l = {BR.drawerOpen}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SystemPushDialogHelperKt$trackSystemDialogShowState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Lifecycle $lifecycle;
    final /* synthetic */ SystemPushDialogHelperKt$trackSystemDialogShowState$observer$1 $observer;
    final /* synthetic */ Ref.BooleanRef $success;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SystemPushDialogHelperKt$trackSystemDialogShowState$1(Lifecycle lifecycle, SystemPushDialogHelperKt$trackSystemDialogShowState$observer$1 systemPushDialogHelperKt$trackSystemDialogShowState$observer$1, Ref.BooleanRef booleanRef, Continuation<? super SystemPushDialogHelperKt$trackSystemDialogShowState$1> continuation) {
        super(2, continuation);
        this.$lifecycle = lifecycle;
        this.$observer = systemPushDialogHelperKt$trackSystemDialogShowState$observer$1;
        this.$success = booleanRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SystemPushDialogHelperKt$trackSystemDialogShowState$1(this.$lifecycle, this.$observer, this.$success, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (DelayKt.delay(1000L, (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$lifecycle.removeObserver(this.$observer);
        if (!this.$success.element) {
            Neurons.trackT$default(true, "notification.permission.request.error", MapsKt.mapOf(TuplesKt.to("system_dialog_show_state", "false")), 0, (Function0) null, 24, (Object) null);
        }
        return Unit.INSTANCE;
    }
}