package tv.danmaku.bili.push.pushsetting.manager;

import android.app.Activity;
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
/* compiled from: PushGuidanceManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.pushsetting.manager.PushGuidanceManagerKt$showPushGuidanceDialog$2", f = "PushGuidanceManager.kt", i = {}, l = {BR.btnTextColor}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PushGuidanceManagerKt$showPushGuidanceDialog$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $showFrom;
    final /* synthetic */ String $spmid;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushGuidanceManagerKt$showPushGuidanceDialog$2(Activity activity, String str, String str2, Continuation<? super PushGuidanceManagerKt$showPushGuidanceDialog$2> continuation) {
        super(2, continuation);
        this.$activity = activity;
        this.$showFrom = str;
        this.$spmid = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PushGuidanceManagerKt$showPushGuidanceDialog$2(this.$activity, this.$showFrom, this.$spmid, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object requestShowGuidance;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                requestShowGuidance = PushGuidanceManagerKt.requestShowGuidance(this.$activity, this.$showFrom, this.$spmid, (Continuation) this);
                if (requestShowGuidance == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        PushGuidanceManagerKt.mLoadingJob = null;
        return Unit.INSTANCE;
    }
}