package video.biz.offline.list.logic;

import com.bapis.bilibili.app.dynamic.v2.DynModuleType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineResolveResult.android.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.OfflineResolveResult_androidKt", f = "OfflineResolveResult.android.kt", i = {0, 0, 0}, l = {DynModuleType.module_title_VALUE}, m = "fileTree", n = {"videoEntity", "storagePath", "context"}, s = {"L$0", "L$1", "L$2"}, v = 1)
public final class OfflineResolveResult_androidKt$fileTree$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfflineResolveResult_androidKt$fileTree$1(Continuation<? super OfflineResolveResult_androidKt$fileTree$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return OfflineResolveResult_androidKt.fileTree(null, (Continuation) this);
    }
}