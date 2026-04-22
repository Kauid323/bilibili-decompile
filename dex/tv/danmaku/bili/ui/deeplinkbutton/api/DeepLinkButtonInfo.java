package tv.danmaku.bili.ui.deeplinkbutton.api;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.GarbJsBridgeCallHandlerKt;

/* compiled from: DeepLinkButtonInfo.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001a\u0010#\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001f¨\u0006&"}, d2 = {"Ltv/danmaku/bili/ui/deeplinkbutton/api/DeepLinkButtonInfo;", "", "<init>", "()V", "btnChannel", "", "getBtnChannel", "()Ljava/lang/String;", "setBtnChannel", "(Ljava/lang/String;)V", "backName", "getBackName", "setBackName", "backUrl", "getBackUrl", "setBackUrl", GarbJsBridgeCallHandlerKt.PURE_THEME, "getColor", "setColor", "isNoCloseIcon", "", "()Z", "setNoCloseIcon", "(Z)V", "isPagesPassed", "setPagesPassed", "btnSize", "", "getBtnSize", "()I", "setBtnSize", "(I)V", "viewLandDistanceY", "getViewLandDistanceY", "setViewLandDistanceY", "viewPortDistanceY", "getViewPortDistanceY", "setViewPortDistanceY", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DeepLinkButtonInfo {
    public static final int $stable = 8;
    @JSONField(name = "back_name")
    private String backName;
    @JSONField(name = "back_url")
    private String backUrl;
    @JSONField(name = "btn_channel")
    private String btnChannel;
    @JSONField(name = "btn_size")
    private int btnSize = 1;
    @JSONField(name = GarbJsBridgeCallHandlerKt.PURE_THEME)
    private String color;
    @JSONField(name = "no_close")
    private boolean isNoCloseIcon;
    @JSONField(name = "passed")
    private boolean isPagesPassed;
    private int viewLandDistanceY;
    private int viewPortDistanceY;

    public final String getBtnChannel() {
        return this.btnChannel;
    }

    public final void setBtnChannel(String str) {
        this.btnChannel = str;
    }

    public final String getBackName() {
        return this.backName;
    }

    public final void setBackName(String str) {
        this.backName = str;
    }

    public final String getBackUrl() {
        return this.backUrl;
    }

    public final void setBackUrl(String str) {
        this.backUrl = str;
    }

    public final String getColor() {
        return this.color;
    }

    public final void setColor(String str) {
        this.color = str;
    }

    public final boolean isNoCloseIcon() {
        return this.isNoCloseIcon;
    }

    public final void setNoCloseIcon(boolean z) {
        this.isNoCloseIcon = z;
    }

    public final boolean isPagesPassed() {
        return this.isPagesPassed;
    }

    public final void setPagesPassed(boolean z) {
        this.isPagesPassed = z;
    }

    public final int getBtnSize() {
        return this.btnSize;
    }

    public final void setBtnSize(int i) {
        this.btnSize = i;
    }

    public final int getViewLandDistanceY() {
        return this.viewLandDistanceY;
    }

    public final void setViewLandDistanceY(int i) {
        this.viewLandDistanceY = i;
    }

    public final int getViewPortDistanceY() {
        return this.viewPortDistanceY;
    }

    public final void setViewPortDistanceY(int i) {
        this.viewPortDistanceY = i;
    }
}