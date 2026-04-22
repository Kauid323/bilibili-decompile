package video.biz.offline.base.facade.utils;

import com.bapis.bilibili.app.dynamic.v2.DynModuleType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FacadeExt.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.facade.utils.FacadeExtKt", f = "FacadeExt.kt", i = {0, 1, 2, 3, 3, 4, 4, 5, 5, 6, 6}, l = {30, DynModuleType.module_copyright_VALUE, DynModuleType.module_onetime_notice_VALUE, DynModuleType.module_manga_collection_VALUE, PlayerToastConfig.QUEUE_INSERT, 50, 56}, m = "autoResumeOrPause", n = {"state", "state", "state", "state", "netWorkState", "state", "netWorkState", "state", "netWorkState", "state", "netWorkState"}, s = {"L$0", "L$0", "L$0", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$0", "L$1"}, v = 1)
public final class FacadeExtKt$autoResumeOrPause$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FacadeExtKt$autoResumeOrPause$1(Continuation<? super FacadeExtKt$autoResumeOrPause$1> continuation) {
        super(continuation);
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FacadeExtKt.autoResumeOrPause((Continuation) this);
    }
}