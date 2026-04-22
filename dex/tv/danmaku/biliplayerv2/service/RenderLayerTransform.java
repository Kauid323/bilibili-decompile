package tv.danmaku.biliplayerv2.service;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IRenderContainerService.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/RenderLayerTransform;", "", "scale", "", "rotate", "translationX", "", "translationY", "<init>", "(FFII)V", "getScale", "()F", "getRotate", "getTranslationX", "()I", "getTranslationY", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RenderLayerTransform {
    private final float rotate;
    private final float scale;
    private final int translationX;
    private final int translationY;

    public RenderLayerTransform() {
        this(DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 0, 0, 15, null);
    }

    public static /* synthetic */ RenderLayerTransform copy$default(RenderLayerTransform renderLayerTransform, float f, float f2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f = renderLayerTransform.scale;
        }
        if ((i3 & 2) != 0) {
            f2 = renderLayerTransform.rotate;
        }
        if ((i3 & 4) != 0) {
            i = renderLayerTransform.translationX;
        }
        if ((i3 & 8) != 0) {
            i2 = renderLayerTransform.translationY;
        }
        return renderLayerTransform.copy(f, f2, i, i2);
    }

    public final float component1() {
        return this.scale;
    }

    public final float component2() {
        return this.rotate;
    }

    public final int component3() {
        return this.translationX;
    }

    public final int component4() {
        return this.translationY;
    }

    public final RenderLayerTransform copy(float f, float f2, int i, int i2) {
        return new RenderLayerTransform(f, f2, i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RenderLayerTransform) {
            RenderLayerTransform renderLayerTransform = (RenderLayerTransform) obj;
            return Float.compare(this.scale, renderLayerTransform.scale) == 0 && Float.compare(this.rotate, renderLayerTransform.rotate) == 0 && this.translationX == renderLayerTransform.translationX && this.translationY == renderLayerTransform.translationY;
        }
        return false;
    }

    public int hashCode() {
        return (((((Float.floatToIntBits(this.scale) * 31) + Float.floatToIntBits(this.rotate)) * 31) + this.translationX) * 31) + this.translationY;
    }

    public String toString() {
        float f = this.scale;
        float f2 = this.rotate;
        int i = this.translationX;
        return "RenderLayerTransform(scale=" + f + ", rotate=" + f2 + ", translationX=" + i + ", translationY=" + this.translationY + ")";
    }

    public RenderLayerTransform(float scale, float rotate, int translationX, int translationY) {
        this.scale = scale;
        this.rotate = rotate;
        this.translationX = translationX;
        this.translationY = translationY;
    }

    public /* synthetic */ RenderLayerTransform(float f, float f2, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1.0f : f, (i3 & 2) != 0 ? DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN : f2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    public final float getScale() {
        return this.scale;
    }

    public final float getRotate() {
        return this.rotate;
    }

    public final int getTranslationX() {
        return this.translationX;
    }

    public final int getTranslationY() {
        return this.translationY;
    }
}