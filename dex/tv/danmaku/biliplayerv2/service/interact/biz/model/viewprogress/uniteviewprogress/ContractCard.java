package tv.danmaku.biliplayerv2.service.interact.biz.model.viewprogress.uniteviewprogress;

import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: VideoGuide.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u001a\u0010\u001c\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\r\"\u0004\b&\u0010\u000fR\u001a\u0010'\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018R\u001a\u0010)\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00061"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/ContractCard;", "", "<init>", "()V", "displayProgress", "", "getDisplayProgress", "()F", "setDisplayProgress", "(F)V", "displayAccuracy", "", "getDisplayAccuracy", "()J", "setDisplayAccuracy", "(J)V", "displayDuration", "getDisplayDuration", "setDisplayDuration", "showMode", "", "getShowMode", "()I", "setShowMode", "(I)V", "pageType", "getPageType", "setPageType", "isFollowDisplay", "setFollowDisplay", "text", "Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/ContractText;", "getText", "()Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/ContractText;", "setText", "(Ltv/danmaku/biliplayerv2/service/interact/biz/model/viewprogress/uniteviewprogress/ContractText;)V", "followDisplayEndDuration", "getFollowDisplayEndDuration", "setFollowDisplayEndDuration", "isPlayDisplay", "setPlayDisplay", "isInteractDisplay", "setInteractDisplay", "playDisplaySwitch", "", "getPlayDisplaySwitch", "()Z", "setPlayDisplaySwitch", "(Z)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ContractCard {
    private long displayAccuracy;
    private long displayDuration;
    private float displayProgress;
    private long followDisplayEndDuration;
    private int isFollowDisplay;
    private int isInteractDisplay;
    private int isPlayDisplay;
    private int pageType;
    private boolean playDisplaySwitch;
    private int showMode;
    private ContractText text;

    public final float getDisplayProgress() {
        return this.displayProgress;
    }

    public final void setDisplayProgress(float f) {
        this.displayProgress = f;
    }

    public final long getDisplayAccuracy() {
        return this.displayAccuracy;
    }

    public final void setDisplayAccuracy(long j) {
        this.displayAccuracy = j;
    }

    public final long getDisplayDuration() {
        return this.displayDuration;
    }

    public final void setDisplayDuration(long j) {
        this.displayDuration = j;
    }

    public final int getShowMode() {
        return this.showMode;
    }

    public final void setShowMode(int i) {
        this.showMode = i;
    }

    public final int getPageType() {
        return this.pageType;
    }

    public final void setPageType(int i) {
        this.pageType = i;
    }

    public final int isFollowDisplay() {
        return this.isFollowDisplay;
    }

    public final void setFollowDisplay(int i) {
        this.isFollowDisplay = i;
    }

    public final ContractText getText() {
        return this.text;
    }

    public final void setText(ContractText contractText) {
        this.text = contractText;
    }

    public final long getFollowDisplayEndDuration() {
        return this.followDisplayEndDuration;
    }

    public final void setFollowDisplayEndDuration(long j) {
        this.followDisplayEndDuration = j;
    }

    public final int isPlayDisplay() {
        return this.isPlayDisplay;
    }

    public final void setPlayDisplay(int i) {
        this.isPlayDisplay = i;
    }

    public final int isInteractDisplay() {
        return this.isInteractDisplay;
    }

    public final void setInteractDisplay(int i) {
        this.isInteractDisplay = i;
    }

    public final boolean getPlayDisplaySwitch() {
        return this.playDisplaySwitch;
    }

    public final void setPlayDisplaySwitch(boolean z) {
        this.playDisplaySwitch = z;
    }
}