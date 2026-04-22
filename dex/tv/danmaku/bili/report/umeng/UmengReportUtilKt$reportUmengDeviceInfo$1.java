package tv.danmaku.bili.report.umeng;

import com.bilibili.lib.arch.lifecycle.Resource;
import com.bilibili.lib.arch.lifecycle.Status;
import com.bilibili.lib.coroutineextension.BiliCallExtKt;
import com.bilibili.okretro.ServiceGenerator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UmengReportUtil.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.report.umeng.UmengReportUtilKt$reportUmengDeviceInfo$1", f = "UmengReportUtil.kt", i = {}, l = {BR.avatarPendantUrl}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class UmengReportUtilKt$reportUmengDeviceInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UmengReportUtilKt$reportUmengDeviceInfo$1(Continuation<? super UmengReportUtilKt$reportUmengDeviceInfo$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new UmengReportUtilKt$reportUmengDeviceInfo$1(continuation);
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
                Object result = BiliCallExtKt.getResult(((UmengReportService) ServiceGenerator.createService(UmengReportService.class)).reportDeviceInfo(), (Continuation) this);
                if (result != coroutine_suspended) {
                    $result = result;
                    break;
                } else {
                    return coroutine_suspended;
                }
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        boolean success = ((Resource) $result).getStatus() == Status.SUCCESS;
        BLog.i("UmengReportUtil", "reportUmengDeviceInfo, success = " + (success));
        if (success) {
            UmengReportUtilKt.setHasReportUmengDeviceInfo(true);
        }
        return Unit.INSTANCE;
    }
}