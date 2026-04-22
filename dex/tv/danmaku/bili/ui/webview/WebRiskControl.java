package tv.danmaku.bili.ui.webview;

import android.net.Uri;
import com.bilibili.app.jsbcontroller.JsbControllerManager;
import com.bilibili.lib.dd.DeviceDecision;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: WebRiskControl.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/webview/WebRiskControl;", "", "<init>", "()V", "check", "", "url", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class WebRiskControl {
    public static final int $stable = 0;
    public static final WebRiskControl INSTANCE = new WebRiskControl();

    private WebRiskControl() {
    }

    public final boolean check(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            Result.Companion companion = Result.Companion;
            WebRiskControl webRiskControl = this;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (!DeviceDecision.INSTANCE.getBoolean("dd.browser.block_unkonwn_url_jump", true)) {
            Result.constructor-impl(Unit.INSTANCE);
            return true;
        }
        return JsbControllerManager.isSupportQrcode(Uri.parse(url));
    }
}