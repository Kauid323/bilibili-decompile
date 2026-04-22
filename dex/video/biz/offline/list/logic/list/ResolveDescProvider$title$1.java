package video.biz.offline.list.logic.list;

import com.bapis.bilibili.app.dynamic.v2.DynModuleType;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OfflineResolveDataProvider.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "video.biz.offline.list.logic.list.ResolveDescProvider", f = "OfflineResolveDataProvider.kt", i = {}, l = {DynModuleType.module_author_for_subscribe_VALUE}, m = RankRouter.BundleKey.ACTION_PARAM_TITLE, n = {}, s = {}, v = 1)
public final class ResolveDescProvider$title$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ResolveDescProvider this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ResolveDescProvider$title$1(ResolveDescProvider resolveDescProvider, Continuation<? super ResolveDescProvider$title$1> continuation) {
        super(continuation);
        this.this$0 = resolveDescProvider;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.title((Continuation) this);
    }
}