package tv.danmaku.bili.ui.splash.brand.model;

import BottomSheetItemData$;
import ComposableSingletons$CustomBottomSheetKt$;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.brand.modelv2.BrandSplashSource;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: BrandSplash.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b3\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r¢\u0006\u0004\b\u0012\u0010\u0013J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00108\u001a\u00020\rHÆ\u0003J\t\u00109\u001a\u00020\rHÆ\u0003J\t\u0010:\u001a\u00020\rHÆ\u0003J\t\u0010;\u001a\u00020\rHÆ\u0003J\t\u0010<\u001a\u00020\rHÆ\u0003J\u0099\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\rHÆ\u0001J\u0013\u0010>\u001a\u00020\r2\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020AHÖ\u0001J\t\u0010B\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR \u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR \u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR \u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u000e\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010)\"\u0004\b,\u0010+R\u001a\u0010\u000f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010)\"\u0004\b-\u0010+R\u001a\u0010\u0010\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010)\"\u0004\b.\u0010+R\u001a\u0010\u0011\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010)\"\u0004\b/\u0010+¨\u0006C"}, d2 = {"Ltv/danmaku/bili/ui/splash/brand/model/BrandSplash;", "", "id", "", "thumb", "", "thumbHash", "thumbName", "logoUrl", "logoHash", "mode", "source", "showLogo", "", "isSelected", "isDisabled", "isCustomModeOn", "isToBeSet", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZZ)V", "getId", "()J", "setId", "(J)V", "getThumb", "()Ljava/lang/String;", "setThumb", "(Ljava/lang/String;)V", "getThumbHash", "setThumbHash", "getThumbName", "setThumbName", "getLogoUrl", "setLogoUrl", "getLogoHash", "setLogoHash", "getMode", "setMode", "getSource", "setSource", "getShowLogo", "()Z", "setShowLogo", "(Z)V", "setSelected", "setDisabled", "setCustomModeOn", "setToBeSet", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", "other", "hashCode", "", "toString", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BrandSplash {
    public static final int $stable = 8;
    @SerializedName("id")
    private long id;
    private boolean isCustomModeOn;
    private boolean isDisabled;
    private boolean isSelected;
    private boolean isToBeSet;
    @SerializedName("logo_hash")
    private String logoHash;
    @SerializedName("logo_url")
    private String logoUrl;
    @SerializedName("mode")
    private String mode;
    @SerializedName("show_logo")
    private boolean showLogo;
    @SerializedName("source")
    private String source;
    @SerializedName("thumb")
    private String thumb;
    @SerializedName("thumb_hash")
    private String thumbHash;
    @SerializedName("thumb_name")
    private String thumbName;

    public BrandSplash() {
        this(0L, null, null, null, null, null, null, null, false, false, false, false, false, 8191, null);
    }

    public final long component1() {
        return this.id;
    }

    public final boolean component10() {
        return this.isSelected;
    }

    public final boolean component11() {
        return this.isDisabled;
    }

    public final boolean component12() {
        return this.isCustomModeOn;
    }

    public final boolean component13() {
        return this.isToBeSet;
    }

    public final String component2() {
        return this.thumb;
    }

    public final String component3() {
        return this.thumbHash;
    }

    public final String component4() {
        return this.thumbName;
    }

    public final String component5() {
        return this.logoUrl;
    }

    public final String component6() {
        return this.logoHash;
    }

    public final String component7() {
        return this.mode;
    }

    public final String component8() {
        return this.source;
    }

    public final boolean component9() {
        return this.showLogo;
    }

    public final BrandSplash copy(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return new BrandSplash(j, str, str2, str3, str4, str5, str6, str7, z, z2, z3, z4, z5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BrandSplash) {
            BrandSplash brandSplash = (BrandSplash) obj;
            return this.id == brandSplash.id && Intrinsics.areEqual(this.thumb, brandSplash.thumb) && Intrinsics.areEqual(this.thumbHash, brandSplash.thumbHash) && Intrinsics.areEqual(this.thumbName, brandSplash.thumbName) && Intrinsics.areEqual(this.logoUrl, brandSplash.logoUrl) && Intrinsics.areEqual(this.logoHash, brandSplash.logoHash) && Intrinsics.areEqual(this.mode, brandSplash.mode) && Intrinsics.areEqual(this.source, brandSplash.source) && this.showLogo == brandSplash.showLogo && this.isSelected == brandSplash.isSelected && this.isDisabled == brandSplash.isDisabled && this.isCustomModeOn == brandSplash.isCustomModeOn && this.isToBeSet == brandSplash.isToBeSet;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.id) * 31) + (this.thumb == null ? 0 : this.thumb.hashCode())) * 31) + (this.thumbHash == null ? 0 : this.thumbHash.hashCode())) * 31) + (this.thumbName == null ? 0 : this.thumbName.hashCode())) * 31) + (this.logoUrl == null ? 0 : this.logoUrl.hashCode())) * 31) + (this.logoHash == null ? 0 : this.logoHash.hashCode())) * 31) + (this.mode == null ? 0 : this.mode.hashCode())) * 31) + (this.source != null ? this.source.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.showLogo)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isSelected)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isDisabled)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isCustomModeOn)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isToBeSet);
    }

    public String toString() {
        long j = this.id;
        String str = this.thumb;
        String str2 = this.thumbHash;
        String str3 = this.thumbName;
        String str4 = this.logoUrl;
        String str5 = this.logoHash;
        String str6 = this.mode;
        String str7 = this.source;
        boolean z = this.showLogo;
        boolean z2 = this.isSelected;
        boolean z3 = this.isDisabled;
        boolean z4 = this.isCustomModeOn;
        return "BrandSplash(id=" + j + ", thumb=" + str + ", thumbHash=" + str2 + ", thumbName=" + str3 + ", logoUrl=" + str4 + ", logoHash=" + str5 + ", mode=" + str6 + ", source=" + str7 + ", showLogo=" + z + ", isSelected=" + z2 + ", isDisabled=" + z3 + ", isCustomModeOn=" + z4 + ", isToBeSet=" + this.isToBeSet + ")";
    }

    public BrandSplash(long id, String thumb, String thumbHash, String thumbName, String logoUrl, String logoHash, String mode, String source, boolean showLogo, boolean isSelected, boolean isDisabled, boolean isCustomModeOn, boolean isToBeSet) {
        this.id = id;
        this.thumb = thumb;
        this.thumbHash = thumbHash;
        this.thumbName = thumbName;
        this.logoUrl = logoUrl;
        this.logoHash = logoHash;
        this.mode = mode;
        this.source = source;
        this.showLogo = showLogo;
        this.isSelected = isSelected;
        this.isDisabled = isDisabled;
        this.isCustomModeOn = isCustomModeOn;
        this.isToBeSet = isToBeSet;
    }

    public /* synthetic */ BrandSplash(long j, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4, (i & 32) == 0 ? str5 : "", (i & 64) != 0 ? "half" : str6, (i & 128) != 0 ? BrandSplashSource.BRAND.getValue() : str7, (i & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? true : z, (i & 512) != 0 ? false : z2, (i & 1024) != 0 ? false : z3, (i & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? false : z4, (i & 4096) == 0 ? z5 : false);
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final String getThumb() {
        return this.thumb;
    }

    public final void setThumb(String str) {
        this.thumb = str;
    }

    public final String getThumbHash() {
        return this.thumbHash;
    }

    public final void setThumbHash(String str) {
        this.thumbHash = str;
    }

    public final String getThumbName() {
        return this.thumbName;
    }

    public final void setThumbName(String str) {
        this.thumbName = str;
    }

    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final void setLogoUrl(String str) {
        this.logoUrl = str;
    }

    public final String getLogoHash() {
        return this.logoHash;
    }

    public final void setLogoHash(String str) {
        this.logoHash = str;
    }

    public final String getMode() {
        return this.mode;
    }

    public final void setMode(String str) {
        this.mode = str;
    }

    public final String getSource() {
        return this.source;
    }

    public final void setSource(String str) {
        this.source = str;
    }

    public final boolean getShowLogo() {
        return this.showLogo;
    }

    public final void setShowLogo(boolean z) {
        this.showLogo = z;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }

    public final boolean isDisabled() {
        return this.isDisabled;
    }

    public final void setDisabled(boolean z) {
        this.isDisabled = z;
    }

    public final boolean isCustomModeOn() {
        return this.isCustomModeOn;
    }

    public final void setCustomModeOn(boolean z) {
        this.isCustomModeOn = z;
    }

    public final boolean isToBeSet() {
        return this.isToBeSet;
    }

    public final void setToBeSet(boolean z) {
        this.isToBeSet = z;
    }
}