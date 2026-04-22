package tv.danmaku.bili.appwidget.upcard.utils;

import android.app.Application;
import android.net.Uri;
import com.bilibili.app.comm.rubick.api.JsbApiV3Kt;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.okretro.ServiceGenerator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.bili.BR;

/* compiled from: ReportUtil.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt$reportCnyTaskConsumed$1", f = "ReportUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class ReportUtilKt$reportCnyTaskConsumed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReportUtilKt$reportCnyTaskConsumed$1(Continuation<? super ReportUtilKt$reportCnyTaskConsumed$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ReportUtilKt$reportCnyTaskConsumed$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                String cnyTaskSchemeHost = DeviceDecision.INSTANCE.dd("cny_task_scheme_host", "https://www.bilibili.com");
                if (cnyTaskSchemeHost == null) {
                    return Unit.INSTANCE;
                }
                Uri url = Uri.parse(cnyTaskSchemeHost);
                Application fapp = FoundationAlias.getFapp();
                String scheme = url.getScheme();
                if (scheme == null) {
                    scheme = "";
                }
                String host = url.getHost();
                if (host == null) {
                    host = "";
                }
                if (Intrinsics.areEqual(JsbApiV3Kt.getWebKvStorageItem(fapp, scheme, host, (Integer) null, "cny_widget_task_status"), "1")) {
                    ((TaskProcessService) ServiceGenerator.createService(TaskProcessService.class)).notify(true).enqueue();
                    Application fapp2 = FoundationAlias.getFapp();
                    String scheme2 = url.getScheme();
                    if (scheme2 == null) {
                        scheme2 = "";
                    }
                    String host2 = url.getHost();
                    JsbApiV3Kt.setWebKvStorageItem(fapp2, scheme2, host2 != null ? host2 : "", (Integer) null, "cny_widget_task_status", "");
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}