package tv.danmaku.bili.push.pushsetting.reporter;

import android.os.Build;
import com.bilibili.lib.coroutineextension.BiliCallExtKt;
import com.bilibili.okretro.ServiceGenerator;
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
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.pushsetting.model.PushDialogType;
import tv.danmaku.bili.push.pushsetting.service.PushSettingService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PushSettingReporter.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.pushsetting.reporter.PushSettingReporterKt$reportPushRequestDialogExposeSuccess$3", f = "PushSettingReporter.kt", i = {}, l = {100, 103}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class PushSettingReporterKt$reportPushRequestDialogExposeSuccess$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $action;
    final /* synthetic */ String $fromModule;
    final /* synthetic */ PushDialogType $type;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PushSettingReporterKt$reportPushRequestDialogExposeSuccess$3(Function1<? super Continuation<? super Unit>, ? extends Object> function1, PushDialogType pushDialogType, String str, Continuation<? super PushSettingReporterKt$reportPushRequestDialogExposeSuccess$3> continuation) {
        super(2, continuation);
        this.$action = function1;
        this.$type = pushDialogType;
        this.$fromModule = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PushSettingReporterKt$reportPushRequestDialogExposeSuccess$3(this.$action, this.$type, this.$fromModule, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x006b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                Function1<Continuation<? super Unit>, Object> function1 = this.$action;
                this.label = 1;
                if (function1.invoke(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                BLog.i("[Push]PushSettingReporter", "report " + this.$type + " dialog expose");
                this.label = 2;
                if (BiliCallExtKt.getResult(((PushSettingService) ServiceGenerator.createService(PushSettingService.class)).reportDialogExpose(this.$fromModule, Build.VERSION.RELEASE, this.$type.getValue()), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                BLog.i("[Push]PushSettingReporter", "report " + this.$type + " dialog expose");
                this.label = 2;
                if (BiliCallExtKt.getResult(((PushSettingService) ServiceGenerator.createService(PushSettingService.class)).reportDialogExpose(this.$fromModule, Build.VERSION.RELEASE, this.$type.getValue()), (Continuation) this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}