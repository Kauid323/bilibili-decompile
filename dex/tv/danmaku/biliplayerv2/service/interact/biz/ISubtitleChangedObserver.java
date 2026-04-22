package tv.danmaku.biliplayerv2.service.interact.biz;

import com.bapis.bilibili.community.service.dm.v1.SubtitleItem;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IInteractLayerService.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/ISubtitleChangedObserver;", "", "onSubtitleChanged", "", "mainSubtitle", "Lcom/bapis/bilibili/community/service/dm/v1/SubtitleItem;", "viceSubtitle", "onSubtitleDrawRectChanged", "bottomFix", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface ISubtitleChangedObserver {
    void onSubtitleChanged(SubtitleItem subtitleItem, SubtitleItem subtitleItem2);

    void onSubtitleDrawRectChanged(int i);
}