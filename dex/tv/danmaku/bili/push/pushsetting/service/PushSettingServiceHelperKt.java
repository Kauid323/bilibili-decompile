package tv.danmaku.bili.push.pushsetting.service;

import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.okretro.ServiceGenerator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.pushsetting.model.PushNotice;

/* compiled from: PushSettingServiceHelper.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u001a\u000e\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u000e\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0007\"\u000e\u0010\n\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"updatePushSetting", "", "notices", "", "Ltv/danmaku/bili/push/pushsetting/model/PushNotice;", "requestPushSetting", "types", "", "updateSinglePushSetting", "type", "TAG", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PushSettingServiceHelperKt {
    private static final String TAG = "[Push]PushSettingServiceHelper";

    public static final void updatePushSetting(List<PushNotice> list) {
        Object obj;
        String types = null;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    PushNotice it2 = (PushNotice) obj;
                    if (it2.isChecked()) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            PushNotice pushNotice = (PushNotice) obj;
            if (pushNotice != null) {
                types = pushNotice.getTypes();
            }
        }
        String str = types;
        if (str == null || str.length() == 0) {
            return;
        }
        requestPushSetting(types);
    }

    public static final void requestPushSetting(String types) {
        Intrinsics.checkNotNullParameter(types, "types");
        try {
            ((PushSettingService) ServiceGenerator.createService(PushSettingService.class)).updatePushSetting(types, 1).enqueue();
        } catch (Exception e) {
            BLog.i(TAG, "updatePushSetting, failed");
        }
    }

    public static final void updateSinglePushSetting(String type) {
        Intrinsics.checkNotNullParameter(type, "type");
        try {
            String accessKey = BiliAccounts.get(FoundationAlias.getFapp()).getAccessKey();
            ((PushSettingService) ServiceGenerator.createService(PushSettingService.class)).setSinglePushSetting(accessKey, type, "1").enqueue();
        } catch (Exception e) {
            BLog.i(TAG, "updateSinglePushSetting, failed");
        }
    }
}