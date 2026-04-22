package tv.danmaku.gifplayer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: Resources.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Ltv/danmaku/gifplayer/StringResources;", "Ltv/danmaku/gifplayer/Resources;", "mUrl", "", "type", "", "<init>", "(Ljava/lang/String;I)V", "getPlayUrl", "biligifplayer_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class StringResources implements Resources {
    private final String mUrl;
    private final int type;

    public StringResources(String mUrl, int type) {
        Intrinsics.checkNotNullParameter(mUrl, "mUrl");
        this.mUrl = mUrl;
        this.type = type;
    }

    @Override // tv.danmaku.gifplayer.Resources
    public String getPlayUrl() {
        return this.mUrl;
    }

    @Override // tv.danmaku.gifplayer.Resources
    public int type() {
        return this.type;
    }
}