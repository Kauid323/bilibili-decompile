package im.setting.service;

import im.setting.UtilsKt;
import im.setting.model.IMSettingPageData;
import im.setting.model.SettingItem;
import kotlin.Metadata;

/* compiled from: SettingNotifyService.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lim/setting/service/SettingNotifyService;", "", "notify", "", UtilsKt.DATA_KEY, "Lim/setting/model/IMSettingPageData;", "item", "Lim/setting/model/SettingItem$Setting;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface SettingNotifyService {
    void notify(IMSettingPageData iMSettingPageData, SettingItem.Setting setting);
}