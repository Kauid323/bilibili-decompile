package video.biz.offline.base.facade.viewmodel;

import com.bapis.bilibili.app.dynamic.v2.DynModuleType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflinePlayListViewModel.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.base.facade.viewmodel.OfflinePlayListViewModel", f = "OfflinePlayListViewModel.kt", i = {0, 1}, l = {DynModuleType.module_button_VALUE, 33}, m = "resolvePLModel", n = {"downloading", "downloading"}, s = {"Z$0", "Z$0"}, v = 1)
public final class OfflinePlayListViewModel$resolvePLModel$1 extends ContinuationImpl {
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OfflinePlayListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfflinePlayListViewModel$resolvePLModel$1(OfflinePlayListViewModel offlinePlayListViewModel, Continuation<? super OfflinePlayListViewModel$resolvePLModel$1> continuation) {
        super(continuation);
        this.this$0 = offlinePlayListViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        Object resolvePLModel;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        resolvePLModel = this.this$0.resolvePLModel(false, (Continuation) this);
        return resolvePLModel;
    }
}