package tv.danmaku.biliplayerv2.service;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: IFunctionWidgetService.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012¨\u0006\u0019"}, d2 = {"Ltv/danmaku/biliplayerv2/service/FunctionWidgetInsetConfig;", "", "support", "", "contentLeftPadding", "", "contentTopPadding", "contentRightPadding", "contentBottomPadding", "<init>", "(ZIIII)V", "getSupport", "()Z", "setSupport", "(Z)V", "getContentLeftPadding", "()I", "setContentLeftPadding", "(I)V", "getContentTopPadding", "setContentTopPadding", "getContentRightPadding", "setContentRightPadding", "getContentBottomPadding", "setContentBottomPadding", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FunctionWidgetInsetConfig {
    private int contentBottomPadding;
    private int contentLeftPadding;
    private int contentRightPadding;
    private int contentTopPadding;
    private boolean support;

    public FunctionWidgetInsetConfig() {
        this(false, 0, 0, 0, 0, 31, null);
    }

    public FunctionWidgetInsetConfig(boolean support, int contentLeftPadding, int contentTopPadding, int contentRightPadding, int contentBottomPadding) {
        this.support = support;
        this.contentLeftPadding = contentLeftPadding;
        this.contentTopPadding = contentTopPadding;
        this.contentRightPadding = contentRightPadding;
        this.contentBottomPadding = contentBottomPadding;
    }

    public /* synthetic */ FunctionWidgetInsetConfig(boolean z, int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? false : z, (i5 & 2) != 0 ? 0 : i, (i5 & 4) != 0 ? 0 : i2, (i5 & 8) != 0 ? 0 : i3, (i5 & 16) != 0 ? 0 : i4);
    }

    public final boolean getSupport() {
        return this.support;
    }

    public final void setSupport(boolean z) {
        this.support = z;
    }

    public final int getContentLeftPadding() {
        return this.contentLeftPadding;
    }

    public final void setContentLeftPadding(int i) {
        this.contentLeftPadding = i;
    }

    public final int getContentTopPadding() {
        return this.contentTopPadding;
    }

    public final void setContentTopPadding(int i) {
        this.contentTopPadding = i;
    }

    public final int getContentRightPadding() {
        return this.contentRightPadding;
    }

    public final void setContentRightPadding(int i) {
        this.contentRightPadding = i;
    }

    public final int getContentBottomPadding() {
        return this.contentBottomPadding;
    }

    public final void setContentBottomPadding(int i) {
        this.contentBottomPadding = i;
    }
}