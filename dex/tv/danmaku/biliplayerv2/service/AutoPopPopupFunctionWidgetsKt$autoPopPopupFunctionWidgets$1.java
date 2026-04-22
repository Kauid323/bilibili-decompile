package tv.danmaku.biliplayerv2.service;

import com.bapis.bilibili.app.dynamic.v2.DynModuleType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoPopPopupFunctionWidgets.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.biliplayerv2.service.AutoPopPopupFunctionWidgetsKt", f = "AutoPopPopupFunctionWidgets.kt", i = {0, 0}, l = {DynModuleType.module_copyright_VALUE}, m = "autoPopPopupFunctionWidgets", n = {"$this$autoPopPopupFunctionWidgets", "listener"}, s = {"L$0", "L$1"}, v = 1)
public final class AutoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$1(Continuation<? super AutoPopPopupFunctionWidgetsKt$autoPopPopupFunctionWidgets$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AutoPopPopupFunctionWidgetsKt.autoPopPopupFunctionWidgets(null, null, (Continuation) this);
    }
}