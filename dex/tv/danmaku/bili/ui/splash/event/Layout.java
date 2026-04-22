package tv.danmaku.bili.ui.splash.event;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: EventSplashData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010+\u001a\u00020,R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\u001e\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001e\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001e\u0010\u001c\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001e\u0010\u001f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001e\u0010\"\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001e\u0010%\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\r\"\u0004\b'\u0010\u000fR\u001e\u0010(\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000f¨\u0006-"}, d2 = {"Ltv/danmaku/bili/ui/splash/event/Layout;", "", "<init>", "()V", "topPercent", "", "getTopPercent", "()F", "setTopPercent", "(F)V", "topPx", "", "getTopPx", "()I", "setTopPx", "(I)V", "leftPercent", "getLeftPercent", "setLeftPercent", "leftPx", "getLeftPx", "setLeftPx", "bottomPercent", "getBottomPercent", "setBottomPercent", "bottomPx", "getBottomPx", "setBottomPx", "heightPx", "getHeightPx", "setHeightPx", "heightPercent", "getHeightPercent", "setHeightPercent", "widthPercent", "getWidthPercent", "setWidthPercent", "widthPx", "getWidthPx", "setWidthPx", "layoutType", "getLayoutType", "setLayoutType", "isValid", "", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class Layout {
    public static final int $stable = 8;
    @JSONField(name = "bottom_percent")
    private float bottomPercent;
    @JSONField(name = "bottom_px")
    private int bottomPx;
    @JSONField(name = "height_percent")
    private float heightPercent;
    @JSONField(name = "height_px")
    private int heightPx;
    @JSONField(name = "layout_type")
    private int layoutType;
    @JSONField(name = "left_percent")
    private float leftPercent;
    @JSONField(name = "left_px")
    private int leftPx;
    @JSONField(name = "top_percent")
    private float topPercent;
    @JSONField(name = "top_px")
    private int topPx;
    @JSONField(name = "width_percent")
    private float widthPercent;
    @JSONField(name = "width_px")
    private int widthPx;

    public final float getTopPercent() {
        return this.topPercent;
    }

    public final void setTopPercent(float f) {
        this.topPercent = f;
    }

    public final int getTopPx() {
        return this.topPx;
    }

    public final void setTopPx(int i) {
        this.topPx = i;
    }

    public final float getLeftPercent() {
        return this.leftPercent;
    }

    public final void setLeftPercent(float f) {
        this.leftPercent = f;
    }

    public final int getLeftPx() {
        return this.leftPx;
    }

    public final void setLeftPx(int i) {
        this.leftPx = i;
    }

    public final float getBottomPercent() {
        return this.bottomPercent;
    }

    public final void setBottomPercent(float f) {
        this.bottomPercent = f;
    }

    public final int getBottomPx() {
        return this.bottomPx;
    }

    public final void setBottomPx(int i) {
        this.bottomPx = i;
    }

    public final int getHeightPx() {
        return this.heightPx;
    }

    public final void setHeightPx(int i) {
        this.heightPx = i;
    }

    public final float getHeightPercent() {
        return this.heightPercent;
    }

    public final void setHeightPercent(float f) {
        this.heightPercent = f;
    }

    public final float getWidthPercent() {
        return this.widthPercent;
    }

    public final void setWidthPercent(float f) {
        this.widthPercent = f;
    }

    public final int getWidthPx() {
        return this.widthPx;
    }

    public final void setWidthPx(int i) {
        this.widthPx = i;
    }

    public final int getLayoutType() {
        return this.layoutType;
    }

    public final void setLayoutType(int i) {
        this.layoutType = i;
    }

    public final boolean isValid() {
        if (this.widthPx == 0 || this.heightPx == 0) {
            if (!(this.widthPercent == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN)) {
                if (!(this.heightPercent == DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
}