package im.setting.service;

import im.setting.UtilsKt;
import im.setting.model.IMSettingPageData;
import im.setting.model.SettingItem;
import kntr.app.im.base.IMEventHub;
import kntr.app.im.base.SettingNotifyItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingNotifyService.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lim/setting/service/IMSettingNotifyServiceImpl;", "Lim/setting/service/SettingNotifyService;", "<init>", "()V", "notify", "", UtilsKt.DATA_KEY, "Lim/setting/model/IMSettingPageData;", "item", "Lim/setting/model/SettingItem$Setting;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSettingNotifyServiceImpl implements SettingNotifyService {
    public static final int $stable = 0;

    @Override // im.setting.service.SettingNotifyService
    public void notify(IMSettingPageData data, SettingItem.Setting item) {
        Intrinsics.checkNotNullParameter(data, UtilsKt.DATA_KEY);
        Intrinsics.checkNotNullParameter(item, "item");
        IMEventHub.INSTANCE.receiveSettingChanged(new SettingNotifyItem.IMSetting(item.getType(), item.getSetting()));
    }
}