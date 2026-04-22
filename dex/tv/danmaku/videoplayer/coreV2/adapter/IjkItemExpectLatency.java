package tv.danmaku.videoplayer.coreV2.adapter;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IjkItemExpectLatency.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Ltv/danmaku/videoplayer/coreV2/adapter/IjkItemExpectLatency;", "", "latency", "", "enableSkipFrame", "enableJitterBuffer", "<init>", "(III)V", "getLatency", "()I", "setLatency", "(I)V", "getEnableSkipFrame", "setEnableSkipFrame", "getEnableJitterBuffer", "setEnableJitterBuffer", "playercore_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class IjkItemExpectLatency {
    private int enableJitterBuffer;
    private int enableSkipFrame;
    private int latency;

    public IjkItemExpectLatency(int latency, int enableSkipFrame, int enableJitterBuffer) {
        this.latency = latency;
        this.enableSkipFrame = enableSkipFrame;
        this.enableJitterBuffer = enableJitterBuffer;
    }

    public final int getEnableJitterBuffer() {
        return this.enableJitterBuffer;
    }

    public final int getEnableSkipFrame() {
        return this.enableSkipFrame;
    }

    public final int getLatency() {
        return this.latency;
    }

    public final void setEnableJitterBuffer(int i) {
        this.enableJitterBuffer = i;
    }

    public final void setEnableSkipFrame(int i) {
        this.enableSkipFrame = i;
    }

    public final void setLatency(int i) {
        this.latency = i;
    }
}