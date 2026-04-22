package tv.danmaku.videoplayer.coreV2.adapter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IjkItemNotifyLiveP2PUrlChange.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/adapter/IjkItemNotifyLiveP2PUrlChange;", "", "newUrl", "", "extraInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getNewUrl", "()Ljava/lang/String;", "getExtraInfo", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class IjkItemNotifyLiveP2PUrlChange {
    private final String extraInfo;
    private final String newUrl;

    public IjkItemNotifyLiveP2PUrlChange(String newUrl, String extraInfo) {
        Intrinsics.checkNotNullParameter(newUrl, "newUrl");
        Intrinsics.checkNotNullParameter(extraInfo, "extraInfo");
        this.newUrl = newUrl;
        this.extraInfo = extraInfo;
    }

    public final String getExtraInfo() {
        return this.extraInfo;
    }

    public final String getNewUrl() {
        return this.newUrl;
    }
}