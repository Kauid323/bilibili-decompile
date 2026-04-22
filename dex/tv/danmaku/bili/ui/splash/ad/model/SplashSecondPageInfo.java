package tv.danmaku.bili.ui.splash.ad.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashSecondPageInfo.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR&\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%¨\u0006)"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/model/SplashSecondPageInfo;", "", "<init>", "()V", "interactStyle", "", "getInteractStyle", "()I", "setInteractStyle", "(I)V", "openSound", "", "getOpenSound", "()Z", "setOpenSound", "(Z)V", "showSoundButton", "getShowSoundButton", "setShowSoundButton", "secondSlideDistance", "getSecondSlideDistance", "setSecondSlideDistance", "secondPageButtons", "", "Ltv/danmaku/bili/ui/splash/ad/model/SplashGuideButton;", "getSecondPageButtons", "()Ljava/util/List;", "setSecondPageButtons", "(Ljava/util/List;)V", "localSecondPageButtonDegraded", "getLocalSecondPageButtonDegraded", "setLocalSecondPageButtonDegraded", "secondVideoUrl", "", "getSecondVideoUrl", "()Ljava/lang/String;", "setSecondVideoUrl", "(Ljava/lang/String;)V", "secondVideoHash", "getSecondVideoHash", "setSecondVideoHash", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashSecondPageInfo {
    public static final int $stable = 8;
    @JSONField(name = "second_interact_style")
    private int interactStyle;
    private boolean localSecondPageButtonDegraded;
    @JSONField(name = "second_sound_switch")
    private boolean openSound;
    @JSONField(name = "buttons")
    private List<SplashGuideButton> secondPageButtons;
    @JSONField(name = "second_slide_distance")
    private int secondSlideDistance;
    @JSONField(name = "second_show_sound_switch")
    private boolean showSoundButton = true;
    @JSONField(name = "second_video_url")
    private String secondVideoUrl = "";
    @JSONField(name = "second_video_hash")
    private String secondVideoHash = "";

    public final int getInteractStyle() {
        return this.interactStyle;
    }

    public final void setInteractStyle(int i) {
        this.interactStyle = i;
    }

    public final boolean getOpenSound() {
        return this.openSound;
    }

    public final void setOpenSound(boolean z) {
        this.openSound = z;
    }

    public final boolean getShowSoundButton() {
        return this.showSoundButton;
    }

    public final void setShowSoundButton(boolean z) {
        this.showSoundButton = z;
    }

    public final int getSecondSlideDistance() {
        return this.secondSlideDistance;
    }

    public final void setSecondSlideDistance(int i) {
        this.secondSlideDistance = i;
    }

    public final List<SplashGuideButton> getSecondPageButtons() {
        return EnhancedUnmodifiabilityKt.unmodifiable(this.secondPageButtons);
    }

    public final void setSecondPageButtons(List<SplashGuideButton> list) {
        this.secondPageButtons = list;
    }

    public final boolean getLocalSecondPageButtonDegraded() {
        return this.localSecondPageButtonDegraded;
    }

    public final void setLocalSecondPageButtonDegraded(boolean z) {
        this.localSecondPageButtonDegraded = z;
    }

    public final String getSecondVideoUrl() {
        return this.secondVideoUrl;
    }

    public final void setSecondVideoUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.secondVideoUrl = str;
    }

    public final String getSecondVideoHash() {
        return this.secondVideoHash;
    }

    public final void setSecondVideoHash(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.secondVideoHash = str;
    }
}