package tv.danmaku.bili.update.api.updater;

import tv.danmaku.bili.update.model.BiliUpgradeInfo;

public interface IUpdater {
    void onError(String str);

    void onUpdate(BiliUpgradeInfo biliUpgradeInfo, boolean z);
}