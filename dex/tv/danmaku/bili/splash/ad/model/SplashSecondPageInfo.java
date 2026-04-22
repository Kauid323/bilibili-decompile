package tv.danmaku.bili.splash.ad.model;

import BottomSheetItemData$;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: SplashSecondPageInfo.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001e\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\t\u0010#\u001a\u00020\fHÆ\u0003J\t\u0010$\u001a\u00020\fHÆ\u0003JW\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fHÆ\u0001J\u0013\u0010&\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\t\u0010)\u001a\u00020\fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u001e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001b¨\u0006*"}, d2 = {"Ltv/danmaku/bili/splash/ad/model/SplashSecondPageInfo;", "", "interactStyle", "", "openSound", "", "showSoundButton", "secondSlideDistance", "secondPageButtons", "", "Ltv/danmaku/bili/splash/ad/model/SplashGuideButton;", "secondVideoUrl", "", "secondVideoHash", "<init>", "(IZZILjava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getInteractStyle", "()I", "getOpenSound", "()Z", "getShowSoundButton", "getSecondSlideDistance", "getSecondPageButtons", "()Ljava/util/List;", "getSecondVideoUrl", "()Ljava/lang/String;", "setSecondVideoUrl", "(Ljava/lang/String;)V", "getSecondVideoHash", "setSecondVideoHash", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashSecondPageInfo {
    public static final int $stable = 8;
    @SerializedName("second_interact_style")
    private final int interactStyle;
    @SerializedName("second_sound_switch")
    private final boolean openSound;
    @SerializedName("buttons")
    private final List<SplashGuideButton> secondPageButtons;
    @SerializedName("second_slide_distance")
    private final int secondSlideDistance;
    @SerializedName("second_video_hash")
    private String secondVideoHash;
    @SerializedName("second_video_url")
    private String secondVideoUrl;
    @SerializedName("second_show_sound_switch")
    private final boolean showSoundButton;

    public SplashSecondPageInfo() {
        this(0, false, false, 0, null, null, null, BR.countdownTrackEnabled, null);
    }

    public static /* synthetic */ SplashSecondPageInfo copy$default(SplashSecondPageInfo splashSecondPageInfo, int i, boolean z, boolean z2, int i2, List list, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = splashSecondPageInfo.interactStyle;
        }
        if ((i3 & 2) != 0) {
            z = splashSecondPageInfo.openSound;
        }
        boolean z3 = z;
        if ((i3 & 4) != 0) {
            z2 = splashSecondPageInfo.showSoundButton;
        }
        boolean z4 = z2;
        if ((i3 & 8) != 0) {
            i2 = splashSecondPageInfo.secondSlideDistance;
        }
        int i4 = i2;
        List<SplashGuideButton> list2 = list;
        if ((i3 & 16) != 0) {
            list2 = splashSecondPageInfo.secondPageButtons;
        }
        List list3 = list2;
        if ((i3 & 32) != 0) {
            str = splashSecondPageInfo.secondVideoUrl;
        }
        String str3 = str;
        if ((i3 & 64) != 0) {
            str2 = splashSecondPageInfo.secondVideoHash;
        }
        return splashSecondPageInfo.copy(i, z3, z4, i4, list3, str3, str2);
    }

    public final int component1() {
        return this.interactStyle;
    }

    public final boolean component2() {
        return this.openSound;
    }

    public final boolean component3() {
        return this.showSoundButton;
    }

    public final int component4() {
        return this.secondSlideDistance;
    }

    public final List<SplashGuideButton> component5() {
        return this.secondPageButtons;
    }

    public final String component6() {
        return this.secondVideoUrl;
    }

    public final String component7() {
        return this.secondVideoHash;
    }

    public final SplashSecondPageInfo copy(int i, boolean z, boolean z2, int i2, List<SplashGuideButton> list, String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "secondVideoUrl");
        Intrinsics.checkNotNullParameter(str2, "secondVideoHash");
        return new SplashSecondPageInfo(i, z, z2, i2, list, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SplashSecondPageInfo) {
            SplashSecondPageInfo splashSecondPageInfo = (SplashSecondPageInfo) obj;
            return this.interactStyle == splashSecondPageInfo.interactStyle && this.openSound == splashSecondPageInfo.openSound && this.showSoundButton == splashSecondPageInfo.showSoundButton && this.secondSlideDistance == splashSecondPageInfo.secondSlideDistance && Intrinsics.areEqual(this.secondPageButtons, splashSecondPageInfo.secondPageButtons) && Intrinsics.areEqual(this.secondVideoUrl, splashSecondPageInfo.secondVideoUrl) && Intrinsics.areEqual(this.secondVideoHash, splashSecondPageInfo.secondVideoHash);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.interactStyle * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.openSound)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showSoundButton)) * 31) + this.secondSlideDistance) * 31) + (this.secondPageButtons == null ? 0 : this.secondPageButtons.hashCode())) * 31) + this.secondVideoUrl.hashCode()) * 31) + this.secondVideoHash.hashCode();
    }

    public String toString() {
        int i = this.interactStyle;
        boolean z = this.openSound;
        boolean z2 = this.showSoundButton;
        int i2 = this.secondSlideDistance;
        List<SplashGuideButton> list = this.secondPageButtons;
        String str = this.secondVideoUrl;
        return "SplashSecondPageInfo(interactStyle=" + i + ", openSound=" + z + ", showSoundButton=" + z2 + ", secondSlideDistance=" + i2 + ", secondPageButtons=" + list + ", secondVideoUrl=" + str + ", secondVideoHash=" + this.secondVideoHash + ")";
    }

    public SplashSecondPageInfo(int interactStyle, boolean openSound, boolean showSoundButton, int secondSlideDistance, List<SplashGuideButton> list, String secondVideoUrl, String secondVideoHash) {
        Intrinsics.checkNotNullParameter(secondVideoUrl, "secondVideoUrl");
        Intrinsics.checkNotNullParameter(secondVideoHash, "secondVideoHash");
        this.interactStyle = interactStyle;
        this.openSound = openSound;
        this.showSoundButton = showSoundButton;
        this.secondSlideDistance = secondSlideDistance;
        this.secondPageButtons = list;
        this.secondVideoUrl = secondVideoUrl;
        this.secondVideoHash = secondVideoHash;
    }

    public /* synthetic */ SplashSecondPageInfo(int i, boolean z, boolean z2, int i2, List list, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? false : z, (i3 & 4) != 0 ? true : z2, (i3 & 8) == 0 ? i2 : 0, (i3 & 16) != 0 ? null : list, (i3 & 32) != 0 ? "" : str, (i3 & 64) != 0 ? "" : str2);
    }

    public final int getInteractStyle() {
        return this.interactStyle;
    }

    public final boolean getOpenSound() {
        return this.openSound;
    }

    public final boolean getShowSoundButton() {
        return this.showSoundButton;
    }

    public final int getSecondSlideDistance() {
        return this.secondSlideDistance;
    }

    public final List<SplashGuideButton> getSecondPageButtons() {
        return this.secondPageButtons;
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