package tv.danmaku.biliplayerv2.service.interact.biz;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuParams;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IInteractLayerService.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/IDanmakuSettingsChangedObserver;", "", "onParamChanged", "", "name", "Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuConfig$DanmakuOptionName;", "params", "Ltv/danmaku/biliplayerv2/service/interact/core/model/DanmakuParams;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IDanmakuSettingsChangedObserver {
    void onParamChanged(DanmakuConfig.DanmakuOptionName danmakuOptionName, DanmakuParams danmakuParams);
}