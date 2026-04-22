package tv.danmaku.bili.widget.dialog.style;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BaseDialogContentStyle.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001a\u0010\"\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001a\u0010%\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\u001a\u0010(\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00061"}, d2 = {"Ltv/danmaku/bili/widget/dialog/style/BaseDialogContentStyle;", "", "<init>", "()V", "contentColor", "", "getContentColor", "()I", "setContentColor", "(I)V", "contentTipColor", "getContentTipColor", "setContentTipColor", "contentTextSize", "", "getContentTextSize", "()F", "setContentTextSize", "(F)V", "contentTipSize", "getContentTipSize", "setContentTipSize", "contentTextLineHeight", "getContentTextLineHeight", "setContentTextLineHeight", "contentTipLineHeight", "getContentTipLineHeight", "setContentTipLineHeight", "contentMarginTop", "getContentMarginTop", "setContentMarginTop", "contentTextMarginTop", "getContentTextMarginTop", "setContentTextMarginTop", "contentTipMarginTop", "getContentTipMarginTop", "setContentTipMarginTop", "contentGravity", "getContentGravity", "setContentGravity", "contentTipGravity", "getContentTipGravity", "setContentTipGravity", "singleLineForceCenter", "", "getSingleLineForceCenter", "()Z", "setSingleLineForceCenter", "(Z)V", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public class BaseDialogContentStyle {
    private int contentColor;
    private int contentTextMarginTop;
    private int contentTipColor;
    private float contentTextSize = 13.0f;
    private float contentTipSize = 13.0f;
    private int contentTextLineHeight = 17;
    private int contentTipLineHeight = 17;
    private int contentMarginTop = 6;
    private int contentTipMarginTop = 6;
    private int contentGravity = 17;
    private int contentTipGravity = 17;
    private boolean singleLineForceCenter = true;

    public final int getContentColor() {
        return this.contentColor;
    }

    public final void setContentColor(int i) {
        this.contentColor = i;
    }

    public final int getContentTipColor() {
        return this.contentTipColor;
    }

    public final void setContentTipColor(int i) {
        this.contentTipColor = i;
    }

    public final float getContentTextSize() {
        return this.contentTextSize;
    }

    public final void setContentTextSize(float f) {
        this.contentTextSize = f;
    }

    public final float getContentTipSize() {
        return this.contentTipSize;
    }

    public final void setContentTipSize(float f) {
        this.contentTipSize = f;
    }

    public final int getContentTextLineHeight() {
        return this.contentTextLineHeight;
    }

    public final void setContentTextLineHeight(int i) {
        this.contentTextLineHeight = i;
    }

    public final int getContentTipLineHeight() {
        return this.contentTipLineHeight;
    }

    public final void setContentTipLineHeight(int i) {
        this.contentTipLineHeight = i;
    }

    public final int getContentMarginTop() {
        return this.contentMarginTop;
    }

    public final void setContentMarginTop(int i) {
        this.contentMarginTop = i;
    }

    public final int getContentTextMarginTop() {
        return this.contentTextMarginTop;
    }

    public final void setContentTextMarginTop(int i) {
        this.contentTextMarginTop = i;
    }

    public final int getContentTipMarginTop() {
        return this.contentTipMarginTop;
    }

    public final void setContentTipMarginTop(int i) {
        this.contentTipMarginTop = i;
    }

    public final int getContentGravity() {
        return this.contentGravity;
    }

    public final void setContentGravity(int i) {
        this.contentGravity = i;
    }

    public final int getContentTipGravity() {
        return this.contentTipGravity;
    }

    public final void setContentTipGravity(int i) {
        this.contentTipGravity = i;
    }

    public final boolean getSingleLineForceCenter() {
        return this.singleLineForceCenter;
    }

    public final void setSingleLineForceCenter(boolean z) {
        this.singleLineForceCenter = z;
    }
}