package tv.danmaku.bili.fullscreen.state;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.sms.SnsPhoneBindingData;

/* compiled from: NetCodeState.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"snsPhoneBindingData", "Ltv/danmaku/bili/sms/SnsPhoneBindingData;", "Ltv/danmaku/bili/fullscreen/state/NetCodeState;", "getSnsPhoneBindingData", "(Ltv/danmaku/bili/fullscreen/state/NetCodeState;)Ltv/danmaku/bili/sms/SnsPhoneBindingData;", "NetCodeState", "bundle", "Landroid/os/Bundle;", "accountui_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NetCodeStateKt {
    public static final SnsPhoneBindingData getSnsPhoneBindingData(NetCodeState $this$snsPhoneBindingData) {
        Intrinsics.checkNotNullParameter($this$snsPhoneBindingData, "<this>");
        if ($this$snsPhoneBindingData instanceof BindingPage) {
            return new SnsPhoneBindingData(((BindingPage) $this$snsPhoneBindingData).getPlatform(), ((BindingPage) $this$snsPhoneBindingData).getAppId(), ((BindingPage) $this$snsPhoneBindingData).getOpenId());
        }
        return null;
    }

    public static /* synthetic */ NetCodeState NetCodeState$default(Bundle bundle, int i, Object obj) {
        if ((i & 1) != 0) {
            bundle = null;
        }
        return NetCodeState(bundle);
    }

    public static final NetCodeState NetCodeState(Bundle bundle) {
        String platform = bundle != null ? bundle.getString("binding_sns_platform") : null;
        String appId = bundle != null ? bundle.getString("binding_sns_app_id") : null;
        String openId = bundle != null ? bundle.getString("binding_open_id") : null;
        boolean z = false;
        if (platform != null && (StringsKt.isBlank(platform) ^ true)) {
            if (appId != null && (StringsKt.isBlank(appId) ^ true)) {
                if (openId != null && (!StringsKt.isBlank(openId))) {
                    z = true;
                }
                if (z) {
                    return new BindingPage(platform, appId, openId);
                }
            }
        }
        return NetCodeInit.INSTANCE;
    }
}