package tv.danmaku.bili.splash.ad.button.model;

import com.bilibili.adcommon.data.model.WxProgramInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.SplashGuideButton;

/* compiled from: ButtonClickData.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0081\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010&\u001a\u0004\u0018\u00010\u000eHÆ\u0003Jj\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010,\u001a\u00020\fHÖ\u0001J\t\u0010-\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006."}, d2 = {"Ltv/danmaku/bili/splash/ad/button/model/ButtonClickData;", "", "actionType", "Ltv/danmaku/bili/splash/ad/button/model/SplashActionType;", "splashButton", "Ltv/danmaku/bili/splash/ad/model/SplashGuideButton;", "jumpUrl", "", "schemeUrl", "priorityJumpUrl", "prioritySchemaUrl", "cardIndex", "", "wxProgramInfo", "Lcom/bilibili/adcommon/data/model/WxProgramInfo;", "<init>", "(Ltv/danmaku/bili/splash/ad/button/model/SplashActionType;Ltv/danmaku/bili/splash/ad/model/SplashGuideButton;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/bilibili/adcommon/data/model/WxProgramInfo;)V", "getActionType", "()Ltv/danmaku/bili/splash/ad/button/model/SplashActionType;", "getSplashButton", "()Ltv/danmaku/bili/splash/ad/model/SplashGuideButton;", "getJumpUrl", "()Ljava/lang/String;", "getSchemeUrl", "getPriorityJumpUrl", "getPrioritySchemaUrl", "getCardIndex", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getWxProgramInfo", "()Lcom/bilibili/adcommon/data/model/WxProgramInfo;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ltv/danmaku/bili/splash/ad/button/model/SplashActionType;Ltv/danmaku/bili/splash/ad/model/SplashGuideButton;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/bilibili/adcommon/data/model/WxProgramInfo;)Ltv/danmaku/bili/splash/ad/button/model/ButtonClickData;", "equals", "", "other", "hashCode", "toString", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ButtonClickData {
    public static final int $stable = 8;
    private final SplashActionType actionType;
    private final Integer cardIndex;
    private final String jumpUrl;
    private final String priorityJumpUrl;
    private final String prioritySchemaUrl;
    private final String schemeUrl;
    private final SplashGuideButton splashButton;
    private final WxProgramInfo wxProgramInfo;

    public final SplashActionType component1() {
        return this.actionType;
    }

    public final SplashGuideButton component2() {
        return this.splashButton;
    }

    public final String component3() {
        return this.jumpUrl;
    }

    public final String component4() {
        return this.schemeUrl;
    }

    public final String component5() {
        return this.priorityJumpUrl;
    }

    public final String component6() {
        return this.prioritySchemaUrl;
    }

    public final Integer component7() {
        return this.cardIndex;
    }

    public final WxProgramInfo component8() {
        return this.wxProgramInfo;
    }

    public final ButtonClickData copy(SplashActionType splashActionType, SplashGuideButton splashGuideButton, String str, String str2, String str3, String str4, Integer num, WxProgramInfo wxProgramInfo) {
        Intrinsics.checkNotNullParameter(splashActionType, "actionType");
        Intrinsics.checkNotNullParameter(splashGuideButton, "splashButton");
        return new ButtonClickData(splashActionType, splashGuideButton, str, str2, str3, str4, num, wxProgramInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ButtonClickData) {
            ButtonClickData buttonClickData = (ButtonClickData) obj;
            return this.actionType == buttonClickData.actionType && Intrinsics.areEqual(this.splashButton, buttonClickData.splashButton) && Intrinsics.areEqual(this.jumpUrl, buttonClickData.jumpUrl) && Intrinsics.areEqual(this.schemeUrl, buttonClickData.schemeUrl) && Intrinsics.areEqual(this.priorityJumpUrl, buttonClickData.priorityJumpUrl) && Intrinsics.areEqual(this.prioritySchemaUrl, buttonClickData.prioritySchemaUrl) && Intrinsics.areEqual(this.cardIndex, buttonClickData.cardIndex) && Intrinsics.areEqual(this.wxProgramInfo, buttonClickData.wxProgramInfo);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((this.actionType.hashCode() * 31) + this.splashButton.hashCode()) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.schemeUrl == null ? 0 : this.schemeUrl.hashCode())) * 31) + (this.priorityJumpUrl == null ? 0 : this.priorityJumpUrl.hashCode())) * 31) + (this.prioritySchemaUrl == null ? 0 : this.prioritySchemaUrl.hashCode())) * 31) + (this.cardIndex == null ? 0 : this.cardIndex.hashCode())) * 31) + (this.wxProgramInfo != null ? this.wxProgramInfo.hashCode() : 0);
    }

    public String toString() {
        SplashActionType splashActionType = this.actionType;
        SplashGuideButton splashGuideButton = this.splashButton;
        String str = this.jumpUrl;
        String str2 = this.schemeUrl;
        String str3 = this.priorityJumpUrl;
        String str4 = this.prioritySchemaUrl;
        Integer num = this.cardIndex;
        return "ButtonClickData(actionType=" + splashActionType + ", splashButton=" + splashGuideButton + ", jumpUrl=" + str + ", schemeUrl=" + str2 + ", priorityJumpUrl=" + str3 + ", prioritySchemaUrl=" + str4 + ", cardIndex=" + num + ", wxProgramInfo=" + this.wxProgramInfo + ")";
    }

    public ButtonClickData(SplashActionType actionType, SplashGuideButton splashButton, String jumpUrl, String schemeUrl, String priorityJumpUrl, String prioritySchemaUrl, Integer cardIndex, WxProgramInfo wxProgramInfo) {
        Intrinsics.checkNotNullParameter(actionType, "actionType");
        Intrinsics.checkNotNullParameter(splashButton, "splashButton");
        this.actionType = actionType;
        this.splashButton = splashButton;
        this.jumpUrl = jumpUrl;
        this.schemeUrl = schemeUrl;
        this.priorityJumpUrl = priorityJumpUrl;
        this.prioritySchemaUrl = prioritySchemaUrl;
        this.cardIndex = cardIndex;
        this.wxProgramInfo = wxProgramInfo;
    }

    public /* synthetic */ ButtonClickData(SplashActionType splashActionType, SplashGuideButton splashGuideButton, String str, String str2, String str3, String str4, Integer num, WxProgramInfo wxProgramInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(splashActionType, splashGuideButton, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? null : num, (i & BR.cover) != 0 ? null : wxProgramInfo);
    }

    public final SplashActionType getActionType() {
        return this.actionType;
    }

    public final SplashGuideButton getSplashButton() {
        return this.splashButton;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getSchemeUrl() {
        return this.schemeUrl;
    }

    public final String getPriorityJumpUrl() {
        return this.priorityJumpUrl;
    }

    public final String getPrioritySchemaUrl() {
        return this.prioritySchemaUrl;
    }

    public final Integer getCardIndex() {
        return this.cardIndex;
    }

    public final WxProgramInfo getWxProgramInfo() {
        return this.wxProgramInfo;
    }
}