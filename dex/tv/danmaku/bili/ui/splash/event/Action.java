package tv.danmaku.bili.ui.splash.event;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: EventSplashData.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010 \u001a\u00020\u0015H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0007\"\u0004\b\u0013\u0010\tR \u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR\u001e\u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\t¨\u0006!"}, d2 = {"Ltv/danmaku/bili/ui/splash/event/Action;", "", "<init>", "()V", "duration", "", "getDuration", "()I", "setDuration", "(I)V", "elements", "", "Ltv/danmaku/bili/ui/splash/event/Element;", "getElements", "()Ljava/util/List;", "setElements", "(Ljava/util/List;)V", "interactTime", "getInteractTime", "setInteractTime", "jumpUrl", "", "getJumpUrl", "()Ljava/lang/String;", "setJumpUrl", "(Ljava/lang/String;)V", "showCountdown", "getShowCountdown", "setShowCountdown", "videoSeekTo", "getVideoSeekTo", "setVideoSeekTo", "toString", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class Action {
    public static final int $stable = 8;
    @JSONField(name = "duration")
    private int duration;
    @JSONField(name = "elements")
    private List<Element> elements;
    @JSONField(name = "interact_time")
    private int interactTime;
    @JSONField(name = "jump_url")
    private String jumpUrl;
    @JSONField(name = "show_countdown")
    private int showCountdown;
    @JSONField(name = "video_seek_to")
    private int videoSeekTo;

    public final int getDuration() {
        return this.duration;
    }

    public final void setDuration(int i) {
        this.duration = i;
    }

    public final List<Element> getElements() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.elements);
    }

    public final void setElements(List<Element> list) {
        this.elements = list;
    }

    public final int getInteractTime() {
        return this.interactTime;
    }

    public final void setInteractTime(int i) {
        this.interactTime = i;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public final int getShowCountdown() {
        return this.showCountdown;
    }

    public final void setShowCountdown(int i) {
        this.showCountdown = i;
    }

    public final int getVideoSeekTo() {
        return this.videoSeekTo;
    }

    public final void setVideoSeekTo(int i) {
        this.videoSeekTo = i;
    }

    public String toString() {
        String obj = super.toString();
        String str = this.jumpUrl;
        return obj + "url:" + str + " seekTo:" + this.videoSeekTo;
    }
}