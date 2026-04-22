package video.biz.offline.base.facade.utils;

import com.bapis.bilibili.app.dynamic.v2.DynModuleType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IndexUtils.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.facade.utils.IndexUtilsKt", f = "IndexUtils.kt", i = {0, 0, 0, 1, 1, 1}, l = {DynModuleType.module_notice_VALUE, 33}, m = "updateLocalIndexFile", n = {"index", "entity", "indexFilePath", "index", "entity", "indexFilePath"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"}, v = 1)
public final class IndexUtilsKt$updateLocalIndexFile$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IndexUtilsKt$updateLocalIndexFile$1(Continuation<? super IndexUtilsKt$updateLocalIndexFile$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return IndexUtilsKt.updateLocalIndexFile(null, null, (Continuation) this);
    }
}