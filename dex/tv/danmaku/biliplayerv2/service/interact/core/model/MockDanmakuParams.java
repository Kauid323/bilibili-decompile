package tv.danmaku.biliplayerv2.service.interact.core.model;

import BottomSheetItemData$;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: MockDanmakuParams.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b?\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0005HÆ\u0003J¯\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010B\u001a\u00020\u00032\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020EHÖ\u0001J\t\u0010F\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0018\"\u0004\b(\u0010\u001aR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0018\"\u0004\b,\u0010\u001aR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0018\"\u0004\b.\u0010\u001aR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0018\"\u0004\b0\u0010\u001aR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0018\"\u0004\b2\u0010\u001a¨\u0006G"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/core/model/MockDanmakuParams;", "", "isMock", "", "danmakuSwitch", "", "danmakuRecommendSwitch", "blockBottom", "blockColorful", "blockRepeat", "blockScroll", "blockSpecial", "blockTop", "domain", "enableBlockList", "opacity", "scalingFactor", "seniorModeSwitch", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()Z", "setMock", "(Z)V", "getDanmakuSwitch", "()Ljava/lang/String;", "setDanmakuSwitch", "(Ljava/lang/String;)V", "getDanmakuRecommendSwitch", "setDanmakuRecommendSwitch", "getBlockBottom", "setBlockBottom", "getBlockColorful", "setBlockColorful", "getBlockRepeat", "setBlockRepeat", "getBlockScroll", "setBlockScroll", "getBlockSpecial", "setBlockSpecial", "getBlockTop", "setBlockTop", "getDomain", "setDomain", "getEnableBlockList", "setEnableBlockList", "getOpacity", "setOpacity", "getScalingFactor", "setScalingFactor", "getSeniorModeSwitch", "setSeniorModeSwitch", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "hashCode", "", "toString", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MockDanmakuParams {
    private String blockBottom;
    private String blockColorful;
    private String blockRepeat;
    private String blockScroll;
    private String blockSpecial;
    private String blockTop;
    private String danmakuRecommendSwitch;
    private String danmakuSwitch;
    private String domain;
    private String enableBlockList;
    private boolean isMock;
    private String opacity;
    private String scalingFactor;
    private String seniorModeSwitch;

    public MockDanmakuParams() {
        this(false, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    public final boolean component1() {
        return this.isMock;
    }

    public final String component10() {
        return this.domain;
    }

    public final String component11() {
        return this.enableBlockList;
    }

    public final String component12() {
        return this.opacity;
    }

    public final String component13() {
        return this.scalingFactor;
    }

    public final String component14() {
        return this.seniorModeSwitch;
    }

    public final String component2() {
        return this.danmakuSwitch;
    }

    public final String component3() {
        return this.danmakuRecommendSwitch;
    }

    public final String component4() {
        return this.blockBottom;
    }

    public final String component5() {
        return this.blockColorful;
    }

    public final String component6() {
        return this.blockRepeat;
    }

    public final String component7() {
        return this.blockScroll;
    }

    public final String component8() {
        return this.blockSpecial;
    }

    public final String component9() {
        return this.blockTop;
    }

    public final MockDanmakuParams copy(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        return new MockDanmakuParams(z, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MockDanmakuParams) {
            MockDanmakuParams mockDanmakuParams = (MockDanmakuParams) obj;
            return this.isMock == mockDanmakuParams.isMock && Intrinsics.areEqual(this.danmakuSwitch, mockDanmakuParams.danmakuSwitch) && Intrinsics.areEqual(this.danmakuRecommendSwitch, mockDanmakuParams.danmakuRecommendSwitch) && Intrinsics.areEqual(this.blockBottom, mockDanmakuParams.blockBottom) && Intrinsics.areEqual(this.blockColorful, mockDanmakuParams.blockColorful) && Intrinsics.areEqual(this.blockRepeat, mockDanmakuParams.blockRepeat) && Intrinsics.areEqual(this.blockScroll, mockDanmakuParams.blockScroll) && Intrinsics.areEqual(this.blockSpecial, mockDanmakuParams.blockSpecial) && Intrinsics.areEqual(this.blockTop, mockDanmakuParams.blockTop) && Intrinsics.areEqual(this.domain, mockDanmakuParams.domain) && Intrinsics.areEqual(this.enableBlockList, mockDanmakuParams.enableBlockList) && Intrinsics.areEqual(this.opacity, mockDanmakuParams.opacity) && Intrinsics.areEqual(this.scalingFactor, mockDanmakuParams.scalingFactor) && Intrinsics.areEqual(this.seniorModeSwitch, mockDanmakuParams.seniorModeSwitch);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isMock) * 31) + (this.danmakuSwitch == null ? 0 : this.danmakuSwitch.hashCode())) * 31) + (this.danmakuRecommendSwitch == null ? 0 : this.danmakuRecommendSwitch.hashCode())) * 31) + (this.blockBottom == null ? 0 : this.blockBottom.hashCode())) * 31) + (this.blockColorful == null ? 0 : this.blockColorful.hashCode())) * 31) + (this.blockRepeat == null ? 0 : this.blockRepeat.hashCode())) * 31) + (this.blockScroll == null ? 0 : this.blockScroll.hashCode())) * 31) + (this.blockSpecial == null ? 0 : this.blockSpecial.hashCode())) * 31) + (this.blockTop == null ? 0 : this.blockTop.hashCode())) * 31) + (this.domain == null ? 0 : this.domain.hashCode())) * 31) + (this.enableBlockList == null ? 0 : this.enableBlockList.hashCode())) * 31) + (this.opacity == null ? 0 : this.opacity.hashCode())) * 31) + (this.scalingFactor == null ? 0 : this.scalingFactor.hashCode())) * 31) + (this.seniorModeSwitch != null ? this.seniorModeSwitch.hashCode() : 0);
    }

    public String toString() {
        boolean z = this.isMock;
        String str = this.danmakuSwitch;
        String str2 = this.danmakuRecommendSwitch;
        String str3 = this.blockBottom;
        String str4 = this.blockColorful;
        String str5 = this.blockRepeat;
        String str6 = this.blockScroll;
        String str7 = this.blockSpecial;
        String str8 = this.blockTop;
        String str9 = this.domain;
        String str10 = this.enableBlockList;
        String str11 = this.opacity;
        String str12 = this.scalingFactor;
        return "MockDanmakuParams(isMock=" + z + ", danmakuSwitch=" + str + ", danmakuRecommendSwitch=" + str2 + ", blockBottom=" + str3 + ", blockColorful=" + str4 + ", blockRepeat=" + str5 + ", blockScroll=" + str6 + ", blockSpecial=" + str7 + ", blockTop=" + str8 + ", domain=" + str9 + ", enableBlockList=" + str10 + ", opacity=" + str11 + ", scalingFactor=" + str12 + ", seniorModeSwitch=" + this.seniorModeSwitch + ")";
    }

    public MockDanmakuParams(boolean isMock, String danmakuSwitch, String danmakuRecommendSwitch, String blockBottom, String blockColorful, String blockRepeat, String blockScroll, String blockSpecial, String blockTop, String domain, String enableBlockList, String opacity, String scalingFactor, String seniorModeSwitch) {
        this.isMock = isMock;
        this.danmakuSwitch = danmakuSwitch;
        this.danmakuRecommendSwitch = danmakuRecommendSwitch;
        this.blockBottom = blockBottom;
        this.blockColorful = blockColorful;
        this.blockRepeat = blockRepeat;
        this.blockScroll = blockScroll;
        this.blockSpecial = blockSpecial;
        this.blockTop = blockTop;
        this.domain = domain;
        this.enableBlockList = enableBlockList;
        this.opacity = opacity;
        this.scalingFactor = scalingFactor;
        this.seniorModeSwitch = seniorModeSwitch;
    }

    public /* synthetic */ MockDanmakuParams(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : str5, (i & 64) != 0 ? null : str6, (i & 128) != 0 ? null : str7, (i & IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN) != 0 ? null : str8, (i & 512) != 0 ? null : str9, (i & 1024) != 0 ? null : str10, (i & IjkMediaMeta.FF_PROFILE_H264_INTRA) != 0 ? null : str11, (i & 4096) != 0 ? null : str12, (i & 8192) == 0 ? str13 : null);
    }

    public final boolean isMock() {
        return this.isMock;
    }

    public final void setMock(boolean z) {
        this.isMock = z;
    }

    public final String getDanmakuSwitch() {
        return this.danmakuSwitch;
    }

    public final void setDanmakuSwitch(String str) {
        this.danmakuSwitch = str;
    }

    public final String getDanmakuRecommendSwitch() {
        return this.danmakuRecommendSwitch;
    }

    public final void setDanmakuRecommendSwitch(String str) {
        this.danmakuRecommendSwitch = str;
    }

    public final String getBlockBottom() {
        return this.blockBottom;
    }

    public final void setBlockBottom(String str) {
        this.blockBottom = str;
    }

    public final String getBlockColorful() {
        return this.blockColorful;
    }

    public final void setBlockColorful(String str) {
        this.blockColorful = str;
    }

    public final String getBlockRepeat() {
        return this.blockRepeat;
    }

    public final void setBlockRepeat(String str) {
        this.blockRepeat = str;
    }

    public final String getBlockScroll() {
        return this.blockScroll;
    }

    public final void setBlockScroll(String str) {
        this.blockScroll = str;
    }

    public final String getBlockSpecial() {
        return this.blockSpecial;
    }

    public final void setBlockSpecial(String str) {
        this.blockSpecial = str;
    }

    public final String getBlockTop() {
        return this.blockTop;
    }

    public final void setBlockTop(String str) {
        this.blockTop = str;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final void setDomain(String str) {
        this.domain = str;
    }

    public final String getEnableBlockList() {
        return this.enableBlockList;
    }

    public final void setEnableBlockList(String str) {
        this.enableBlockList = str;
    }

    public final String getOpacity() {
        return this.opacity;
    }

    public final void setOpacity(String str) {
        this.opacity = str;
    }

    public final String getScalingFactor() {
        return this.scalingFactor;
    }

    public final void setScalingFactor(String str) {
        this.scalingFactor = str;
    }

    public final String getSeniorModeSwitch() {
        return this.seniorModeSwitch;
    }

    public final void setSeniorModeSwitch(String str) {
        this.seniorModeSwitch = str;
    }
}