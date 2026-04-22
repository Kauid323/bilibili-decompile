package im.setting.service;

import com.bapis.bilibili.app.im.v1.KSessionId;
import im.setting.UtilsKt;
import im.setting.model.IMSettingPageData;
import im.setting.model.SettingItem;
import javax.inject.Inject;
import kntr.app.im.base.IMEventHub;
import kntr.app.im.base.SettingNotifyItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingNotifyService.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lim/setting/service/ChatSettingNotifyServiceImpl;", "Lim/setting/service/SettingNotifyService;", "sessionID", "Lcom/bapis/bilibili/app/im/v1/KSessionId;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KSessionId;)V", "notify", "", UtilsKt.DATA_KEY, "Lim/setting/model/IMSettingPageData;", "item", "Lim/setting/model/SettingItem$Setting;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ChatSettingNotifyServiceImpl implements SettingNotifyService {
    public static final int $stable = 8;
    private final KSessionId sessionID;

    @Inject
    public ChatSettingNotifyServiceImpl(KSessionId sessionID) {
        Intrinsics.checkNotNullParameter(sessionID, "sessionID");
        this.sessionID = sessionID;
    }

    @Override // im.setting.service.SettingNotifyService
    public void notify(IMSettingPageData data, SettingItem.Setting item) {
        Intrinsics.checkNotNullParameter(data, UtilsKt.DATA_KEY);
        Intrinsics.checkNotNullParameter(item, "item");
        IMEventHub.INSTANCE.receiveSettingChanged(new SettingNotifyItem.ChatSetting(this.sessionID, item.getType(), item.getSetting()));
    }
}