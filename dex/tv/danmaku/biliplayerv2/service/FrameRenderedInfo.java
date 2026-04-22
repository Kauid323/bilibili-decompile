package tv.danmaku.biliplayerv2.service;

import ComposableSingletons$CustomBottomSheetKt$;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IRenderContainerService.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/FrameRenderedInfo;", "", "textureId", "", "textureWidth", "textureHeight", "timeUs", "", "<init>", "(IIIJ)V", "getTextureId", "()I", "getTextureWidth", "getTextureHeight", "getTimeUs", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FrameRenderedInfo {
    private final int textureHeight;
    private final int textureId;
    private final int textureWidth;
    private final long timeUs;

    public static /* synthetic */ FrameRenderedInfo copy$default(FrameRenderedInfo frameRenderedInfo, int i, int i2, int i3, long j, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = frameRenderedInfo.textureId;
        }
        if ((i4 & 2) != 0) {
            i2 = frameRenderedInfo.textureWidth;
        }
        int i5 = i2;
        if ((i4 & 4) != 0) {
            i3 = frameRenderedInfo.textureHeight;
        }
        int i6 = i3;
        if ((i4 & 8) != 0) {
            j = frameRenderedInfo.timeUs;
        }
        return frameRenderedInfo.copy(i, i5, i6, j);
    }

    public final int component1() {
        return this.textureId;
    }

    public final int component2() {
        return this.textureWidth;
    }

    public final int component3() {
        return this.textureHeight;
    }

    public final long component4() {
        return this.timeUs;
    }

    public final FrameRenderedInfo copy(int i, int i2, int i3, long j) {
        return new FrameRenderedInfo(i, i2, i3, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FrameRenderedInfo) {
            FrameRenderedInfo frameRenderedInfo = (FrameRenderedInfo) obj;
            return this.textureId == frameRenderedInfo.textureId && this.textureWidth == frameRenderedInfo.textureWidth && this.textureHeight == frameRenderedInfo.textureHeight && this.timeUs == frameRenderedInfo.timeUs;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.textureId * 31) + this.textureWidth) * 31) + this.textureHeight) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.timeUs);
    }

    public String toString() {
        int i = this.textureId;
        int i2 = this.textureWidth;
        int i3 = this.textureHeight;
        return "FrameRenderedInfo(textureId=" + i + ", textureWidth=" + i2 + ", textureHeight=" + i3 + ", timeUs=" + this.timeUs + ")";
    }

    public FrameRenderedInfo(int textureId, int textureWidth, int textureHeight, long timeUs) {
        this.textureId = textureId;
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
        this.timeUs = timeUs;
    }

    public final int getTextureHeight() {
        return this.textureHeight;
    }

    public final int getTextureId() {
        return this.textureId;
    }

    public final int getTextureWidth() {
        return this.textureWidth;
    }

    public final long getTimeUs() {
        return this.timeUs;
    }
}