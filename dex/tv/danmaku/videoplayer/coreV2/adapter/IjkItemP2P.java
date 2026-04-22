package tv.danmaku.videoplayer.coreV2.adapter;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IjkItemP2P.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/adapter/IjkItemP2P;", "", "p2pType", "", "upload", "", "<init>", "(IZ)V", "getP2pType", "()I", "setP2pType", "(I)V", "getUpload", "()Z", "setUpload", "(Z)V", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class IjkItemP2P {
    private int p2pType;
    private boolean upload;

    public IjkItemP2P(int p2pType, boolean upload) {
        this.p2pType = p2pType;
        this.upload = upload;
    }

    public final int getP2pType() {
        return this.p2pType;
    }

    public final boolean getUpload() {
        return this.upload;
    }

    public final void setP2pType(int i) {
        this.p2pType = i;
    }

    public final void setUpload(boolean z) {
        this.upload = z;
    }
}