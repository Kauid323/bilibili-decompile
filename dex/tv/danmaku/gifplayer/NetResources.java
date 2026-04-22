package tv.danmaku.gifplayer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: Resources.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/gifplayer/NetResources;", "Ltv/danmaku/gifplayer/Resources;", "mUrl", "", "<init>", "(Ljava/lang/String;)V", "getPlayUrl", "type", "", "biligifplayer_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class NetResources implements Resources {
    private final String mUrl;

    public NetResources(String mUrl) {
        Intrinsics.checkNotNullParameter(mUrl, "mUrl");
        this.mUrl = mUrl;
    }

    @Override // tv.danmaku.gifplayer.Resources
    public String getPlayUrl() {
        return this.mUrl;
    }

    @Override // tv.danmaku.gifplayer.Resources
    public int type() {
        return 2;
    }
}