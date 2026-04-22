package tv.danmaku.bili.ui.garb.api;

import BottomSheetItemData$;
import com.bilibili.bson.common.Bson;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: BiliDLCCardItem.kt */
@Bson
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003JK\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t2\b\b\u0002\u0010\n\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010¨\u0006\""}, d2 = {"Ltv/danmaku/bili/ui/garb/api/Animation;", "", "mute", "", "animationUrl", "", "animationBackupImage", "animationFirstFrame", "animationVideoUrls", "", "subtitlesUrl", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getMute", "()Z", "getAnimationUrl", "()Ljava/lang/String;", "getAnimationBackupImage", "getAnimationFirstFrame", "getAnimationVideoUrls", "()Ljava/util/List;", "getSubtitlesUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class Animation {
    public static final int $stable = 8;
    @SerializedName("animation_backup_image")
    private final String animationBackupImage;
    @SerializedName("animation_first_frame")
    private final String animationFirstFrame;
    @SerializedName("animation_url")
    private final String animationUrl;
    @SerializedName("animation_video_urls")
    private final List<String> animationVideoUrls;
    @SerializedName("is_mute")
    private final boolean mute;
    @SerializedName("subtitles_url")
    private final String subtitlesUrl;

    public static /* synthetic */ Animation copy$default(Animation animation, boolean z, String str, String str2, String str3, List list, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = animation.mute;
        }
        if ((i & 2) != 0) {
            str = animation.animationUrl;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = animation.animationBackupImage;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = animation.animationFirstFrame;
        }
        String str7 = str3;
        List<String> list2 = list;
        if ((i & 16) != 0) {
            list2 = animation.animationVideoUrls;
        }
        List list3 = list2;
        if ((i & 32) != 0) {
            str4 = animation.subtitlesUrl;
        }
        return animation.copy(z, str5, str6, str7, list3, str4);
    }

    public final boolean component1() {
        return this.mute;
    }

    public final String component2() {
        return this.animationUrl;
    }

    public final String component3() {
        return this.animationBackupImage;
    }

    public final String component4() {
        return this.animationFirstFrame;
    }

    public final List<String> component5() {
        return this.animationVideoUrls;
    }

    public final String component6() {
        return this.subtitlesUrl;
    }

    public final Animation copy(boolean z, String str, String str2, String str3, List<String> list, String str4) {
        Intrinsics.checkNotNullParameter(str, "animationUrl");
        Intrinsics.checkNotNullParameter(str2, "animationBackupImage");
        Intrinsics.checkNotNullParameter(str3, "animationFirstFrame");
        Intrinsics.checkNotNullParameter(list, "animationVideoUrls");
        Intrinsics.checkNotNullParameter(str4, "subtitlesUrl");
        return new Animation(z, str, str2, str3, list, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Animation) {
            Animation animation = (Animation) obj;
            return this.mute == animation.mute && Intrinsics.areEqual(this.animationUrl, animation.animationUrl) && Intrinsics.areEqual(this.animationBackupImage, animation.animationBackupImage) && Intrinsics.areEqual(this.animationFirstFrame, animation.animationFirstFrame) && Intrinsics.areEqual(this.animationVideoUrls, animation.animationVideoUrls) && Intrinsics.areEqual(this.subtitlesUrl, animation.subtitlesUrl);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.mute) * 31) + this.animationUrl.hashCode()) * 31) + this.animationBackupImage.hashCode()) * 31) + this.animationFirstFrame.hashCode()) * 31) + this.animationVideoUrls.hashCode()) * 31) + this.subtitlesUrl.hashCode();
    }

    public String toString() {
        boolean z = this.mute;
        String str = this.animationUrl;
        String str2 = this.animationBackupImage;
        String str3 = this.animationFirstFrame;
        List<String> list = this.animationVideoUrls;
        return "Animation(mute=" + z + ", animationUrl=" + str + ", animationBackupImage=" + str2 + ", animationFirstFrame=" + str3 + ", animationVideoUrls=" + list + ", subtitlesUrl=" + this.subtitlesUrl + ")";
    }

    public Animation(boolean mute, String animationUrl, String animationBackupImage, String animationFirstFrame, List<String> list, String subtitlesUrl) {
        Intrinsics.checkNotNullParameter(animationUrl, "animationUrl");
        Intrinsics.checkNotNullParameter(animationBackupImage, "animationBackupImage");
        Intrinsics.checkNotNullParameter(animationFirstFrame, "animationFirstFrame");
        Intrinsics.checkNotNullParameter(list, "animationVideoUrls");
        Intrinsics.checkNotNullParameter(subtitlesUrl, "subtitlesUrl");
        this.mute = mute;
        this.animationUrl = animationUrl;
        this.animationBackupImage = animationBackupImage;
        this.animationFirstFrame = animationFirstFrame;
        this.animationVideoUrls = list;
        this.subtitlesUrl = subtitlesUrl;
    }

    public final boolean getMute() {
        return this.mute;
    }

    public final String getAnimationUrl() {
        return this.animationUrl;
    }

    public final String getAnimationBackupImage() {
        return this.animationBackupImage;
    }

    public final String getAnimationFirstFrame() {
        return this.animationFirstFrame;
    }

    public final List<String> getAnimationVideoUrls() {
        return this.animationVideoUrls;
    }

    public final String getSubtitlesUrl() {
        return this.subtitlesUrl;
    }
}