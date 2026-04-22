package tv.danmaku.bili.push.pushsetting.manager;

import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.pushsetting.model.PushCallBackInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushGuidanceManager.kt */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.pushsetting.manager.PushGuidanceManagerKt$requestShowGuidance$2", f = "PushGuidanceManager.kt", i = {}, l = {BR.danmakuOpen}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PushGuidanceManagerKt$requestShowGuidance$2 extends SuspendLambda implements Function1<Continuation<? super Boolean>, Object> {
    final /* synthetic */ AppCompatActivity $activity;
    final /* synthetic */ PushCallBackInfo $data;
    final /* synthetic */ String $showFrom;
    final /* synthetic */ String $spmid;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushGuidanceManagerKt$requestShowGuidance$2(AppCompatActivity appCompatActivity, String str, String str2, PushCallBackInfo pushCallBackInfo, Continuation<? super PushGuidanceManagerKt$requestShowGuidance$2> continuation) {
        super(1, continuation);
        this.$activity = appCompatActivity;
        this.$showFrom = str;
        this.$spmid = str2;
        this.$data = pushCallBackInfo;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new PushGuidanceManagerKt$requestShowGuidance$2(this.$activity, this.$showFrom, this.$spmid, this.$data, continuation);
    }

    public final Object invoke(Continuation<? super Boolean> continuation) {
        return create(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object showSettingDialog;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                showSettingDialog = PushGuidanceManagerKt.showSettingDialog(this.$activity, this.$showFrom, this.$spmid, this.$data, (Continuation) this);
                if (showSettingDialog == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return showSettingDialog;
            case 1:
                ResultKt.throwOnFailure($result);
                return $result;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}