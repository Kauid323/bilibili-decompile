package tv.danmaku.biliplayerv2.service.interact.biz;

import com.bapis.bilibili.community.service.dm.v1.PostPanelV2;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IInteractLayerService.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/PostPanelObserver;", "", "onPostPanelInactive", "", "progress", "", "inactivePostPanel", "Lcom/bapis/bilibili/community/service/dm/v1/PostPanelV2;", "onPostPanelActive", "activePostPanel", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface PostPanelObserver {
    void onPostPanelActive(int i, PostPanelV2 postPanelV2);

    void onPostPanelInactive(int i, PostPanelV2 postPanelV2);
}