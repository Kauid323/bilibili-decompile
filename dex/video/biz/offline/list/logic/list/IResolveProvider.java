package video.biz.offline.list.logic.list;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineResolveDataProvider.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lvideo/biz/offline/list/logic/list/IResolveProvider;", "", RankRouter.BundleKey.ACTION_PARAM_TITLE, "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "content", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IResolveProvider {
    Object content(Continuation<? super String> continuation);

    Object title(Continuation<? super String> continuation);
}