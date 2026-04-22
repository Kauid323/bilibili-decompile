package video.biz.offline.list.logic.utils;

import com.bapis.bilibili.app.dynamic.v2.DynModuleType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Utils.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.utils.UtilsKt", f = "Utils.kt", i = {0, 0}, l = {DynModuleType.module_button_VALUE}, m = "resolveEntityPLRoute", n = {"key", "downloading"}, s = {"L$0", "Z$0"}, v = 1)
public final class UtilsKt$resolveEntityPLRoute$1 extends ContinuationImpl {
    Object L$0;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UtilsKt$resolveEntityPLRoute$1(Continuation<? super UtilsKt$resolveEntityPLRoute$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return UtilsKt.resolveEntityPLRoute(null, false, (Continuation) this);
    }
}