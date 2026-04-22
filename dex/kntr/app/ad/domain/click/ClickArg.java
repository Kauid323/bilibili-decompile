package kntr.app.ad.domain.click;

import BottomSheetItemData$;
import java.util.List;
import kntr.app.ad.common.model.AdWhiteApk;
import kntr.app.ad.common.model.AdWxProgramInfo;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClickArg.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\bB\b\u0086\b\u0018\u00002\u00020\u0001BÍ\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0010\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\r\u0012\u0010\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\t\u0012\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\t¢\u0006\u0004\b\u001a\u0010\u001bJ\u000b\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010E\u001a\u00020\tHÆ\u0003J\t\u0010F\u001a\u00020\tHÆ\u0003J\t\u0010G\u001a\u00020\tHÆ\u0003J\u0013\u0010H\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\rHÆ\u0003J\u0013\u0010I\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\rHÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010K\u001a\u00020\tHÆ\u0003J\t\u0010L\u001a\u00020\tHÆ\u0003J\u0013\u0010M\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\rHÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010O\u001a\u00020\u0016HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010Q\u001a\u00020\u0016HÆ\u0003J\t\u0010R\u001a\u00020\tHÆ\u0003Jé\u0001\u0010S\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\r2\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0011\u001a\u00020\t2\b\b\u0002\u0010\u0012\u001a\u00020\t2\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\tHÆ\u0001J\u0013\u0010T\u001a\u00020\t2\b\u0010U\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010V\u001a\u00020\u0016HÖ\u0001J\t\u0010W\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b \u0010\u001d\u001a\u0004\b!\u0010\"R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\"R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b%\u0010\u001d\u001a\u0004\b&\u0010\"R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u001d\u001a\u0004\b(\u0010)R\u001c\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b*\u0010\u001d\u001a\u0004\b+\u0010)R\u001c\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u001d\u001a\u0004\b-\u0010)R&\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b.\u0010\u001d\u001a\u0004\b/\u00100R&\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\u001d\u001a\u0004\b2\u00100R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b3\u0010\u001d\u001a\u0004\b4\u0010\"R\u001c\u0010\u0011\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b5\u0010\u001d\u001a\u0004\b6\u0010)R\u0011\u0010\u0012\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b7\u0010)R&\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b8\u0010\u001d\u001a\u0004\b9\u00100R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b:\u0010\u001d\u001a\u0004\b;\u0010\"R\u001c\u0010\u0015\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b<\u0010\u001d\u001a\u0004\b=\u0010>R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\"R\u0011\u0010\u0018\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b@\u0010>R\u0011\u0010\u0019\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010)¨\u0006X"}, d2 = {"Lkntr/app/ad/domain/click/ClickArg;", RoomRecommendViewModel.EMPTY_CURSOR, "wxInfo", "Lkntr/app/ad/common/model/AdWxProgramInfo;", "callUpUrl", RoomRecommendViewModel.EMPTY_CURSOR, "jumpUrl", "cancelUrl", "enableCallUpCancelToJumpUrl", RoomRecommendViewModel.EMPTY_CURSOR, "enableDoubleJump", "useAdWeb", "openWhiteList", RoomRecommendViewModel.EMPTY_CURSOR, "downloadWhiteList", "Lkntr/app/ad/common/model/AdWhiteApk;", "dlSucCallUpUrl", "enableAppStore", "enableAppDownload", "clickUrls", "universalApp", "appStorePriority", RoomRecommendViewModel.EMPTY_CURSOR, "storeLink", "downloadUrlType", "isFirstJump", "<init>", "(Lkntr/app/ad/common/model/AdWxProgramInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZLjava/util/List;Ljava/util/List;Ljava/lang/String;ZZLjava/util/List;Ljava/lang/String;ILjava/lang/String;IZ)V", "getWxInfo$annotations", "()V", "getWxInfo", "()Lkntr/app/ad/common/model/AdWxProgramInfo;", "getCallUpUrl$annotations", "getCallUpUrl", "()Ljava/lang/String;", "getJumpUrl$annotations", "getJumpUrl", "getCancelUrl$annotations", "getCancelUrl", "getEnableCallUpCancelToJumpUrl$annotations", "getEnableCallUpCancelToJumpUrl", "()Z", "getEnableDoubleJump$annotations", "getEnableDoubleJump", "getUseAdWeb$annotations", "getUseAdWeb", "getOpenWhiteList$annotations", "getOpenWhiteList", "()Ljava/util/List;", "getDownloadWhiteList$annotations", "getDownloadWhiteList", "getDlSucCallUpUrl$annotations", "getDlSucCallUpUrl", "getEnableAppStore$annotations", "getEnableAppStore", "getEnableAppDownload", "getClickUrls$annotations", "getClickUrls", "getUniversalApp$annotations", "getUniversalApp", "getAppStorePriority$annotations", "getAppStorePriority", "()I", "getStoreLink", "getDownloadUrlType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "copy", "equals", "other", "hashCode", "toString", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ClickArg {
    private final int appStorePriority;
    private final String callUpUrl;
    private final String cancelUrl;
    private final List<String> clickUrls;
    private final String dlSucCallUpUrl;
    private final int downloadUrlType;
    private final List<AdWhiteApk> downloadWhiteList;
    private final boolean enableAppDownload;
    private final boolean enableAppStore;
    private final boolean enableCallUpCancelToJumpUrl;
    private final boolean enableDoubleJump;
    private final boolean isFirstJump;
    private final String jumpUrl;
    private final List<String> openWhiteList;
    private final String storeLink;
    private final String universalApp;
    private final boolean useAdWeb;
    private final AdWxProgramInfo wxInfo;

    public static /* synthetic */ void getAppStorePriority$annotations() {
    }

    public static /* synthetic */ void getCallUpUrl$annotations() {
    }

    public static /* synthetic */ void getCancelUrl$annotations() {
    }

    public static /* synthetic */ void getClickUrls$annotations() {
    }

    public static /* synthetic */ void getDlSucCallUpUrl$annotations() {
    }

    public static /* synthetic */ void getDownloadWhiteList$annotations() {
    }

    public static /* synthetic */ void getEnableAppStore$annotations() {
    }

    public static /* synthetic */ void getEnableCallUpCancelToJumpUrl$annotations() {
    }

    public static /* synthetic */ void getEnableDoubleJump$annotations() {
    }

    public static /* synthetic */ void getJumpUrl$annotations() {
    }

    public static /* synthetic */ void getOpenWhiteList$annotations() {
    }

    public static /* synthetic */ void getUniversalApp$annotations() {
    }

    public static /* synthetic */ void getUseAdWeb$annotations() {
    }

    public static /* synthetic */ void getWxInfo$annotations() {
    }

    public final AdWxProgramInfo component1() {
        return this.wxInfo;
    }

    public final String component10() {
        return this.dlSucCallUpUrl;
    }

    public final boolean component11() {
        return this.enableAppStore;
    }

    public final boolean component12() {
        return this.enableAppDownload;
    }

    public final List<String> component13() {
        return this.clickUrls;
    }

    public final String component14() {
        return this.universalApp;
    }

    public final int component15() {
        return this.appStorePriority;
    }

    public final String component16() {
        return this.storeLink;
    }

    public final int component17() {
        return this.downloadUrlType;
    }

    public final boolean component18() {
        return this.isFirstJump;
    }

    public final String component2() {
        return this.callUpUrl;
    }

    public final String component3() {
        return this.jumpUrl;
    }

    public final String component4() {
        return this.cancelUrl;
    }

    public final boolean component5() {
        return this.enableCallUpCancelToJumpUrl;
    }

    public final boolean component6() {
        return this.enableDoubleJump;
    }

    public final boolean component7() {
        return this.useAdWeb;
    }

    public final List<String> component8() {
        return this.openWhiteList;
    }

    public final List<AdWhiteApk> component9() {
        return this.downloadWhiteList;
    }

    public final ClickArg copy(AdWxProgramInfo adWxProgramInfo, String str, String str2, String str3, boolean z, boolean z2, boolean z3, List<String> list, List<AdWhiteApk> list2, String str4, boolean z4, boolean z5, List<String> list3, String str5, int i, String str6, int i2, boolean z6) {
        return new ClickArg(adWxProgramInfo, str, str2, str3, z, z2, z3, list, list2, str4, z4, z5, list3, str5, i, str6, i2, z6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ClickArg) {
            ClickArg clickArg = (ClickArg) obj;
            return Intrinsics.areEqual(this.wxInfo, clickArg.wxInfo) && Intrinsics.areEqual(this.callUpUrl, clickArg.callUpUrl) && Intrinsics.areEqual(this.jumpUrl, clickArg.jumpUrl) && Intrinsics.areEqual(this.cancelUrl, clickArg.cancelUrl) && this.enableCallUpCancelToJumpUrl == clickArg.enableCallUpCancelToJumpUrl && this.enableDoubleJump == clickArg.enableDoubleJump && this.useAdWeb == clickArg.useAdWeb && Intrinsics.areEqual(this.openWhiteList, clickArg.openWhiteList) && Intrinsics.areEqual(this.downloadWhiteList, clickArg.downloadWhiteList) && Intrinsics.areEqual(this.dlSucCallUpUrl, clickArg.dlSucCallUpUrl) && this.enableAppStore == clickArg.enableAppStore && this.enableAppDownload == clickArg.enableAppDownload && Intrinsics.areEqual(this.clickUrls, clickArg.clickUrls) && Intrinsics.areEqual(this.universalApp, clickArg.universalApp) && this.appStorePriority == clickArg.appStorePriority && Intrinsics.areEqual(this.storeLink, clickArg.storeLink) && this.downloadUrlType == clickArg.downloadUrlType && this.isFirstJump == clickArg.isFirstJump;
        }
        return false;
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((this.wxInfo == null ? 0 : this.wxInfo.hashCode()) * 31) + (this.callUpUrl == null ? 0 : this.callUpUrl.hashCode())) * 31) + (this.jumpUrl == null ? 0 : this.jumpUrl.hashCode())) * 31) + (this.cancelUrl == null ? 0 : this.cancelUrl.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.enableCallUpCancelToJumpUrl)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.enableDoubleJump)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.useAdWeb)) * 31) + (this.openWhiteList == null ? 0 : this.openWhiteList.hashCode())) * 31) + (this.downloadWhiteList == null ? 0 : this.downloadWhiteList.hashCode())) * 31) + (this.dlSucCallUpUrl == null ? 0 : this.dlSucCallUpUrl.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.enableAppStore)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.enableAppDownload)) * 31) + (this.clickUrls == null ? 0 : this.clickUrls.hashCode())) * 31) + (this.universalApp == null ? 0 : this.universalApp.hashCode())) * 31) + this.appStorePriority) * 31) + (this.storeLink != null ? this.storeLink.hashCode() : 0)) * 31) + this.downloadUrlType) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isFirstJump);
    }

    public String toString() {
        AdWxProgramInfo adWxProgramInfo = this.wxInfo;
        String str = this.callUpUrl;
        String str2 = this.jumpUrl;
        String str3 = this.cancelUrl;
        boolean z = this.enableCallUpCancelToJumpUrl;
        boolean z2 = this.enableDoubleJump;
        boolean z3 = this.useAdWeb;
        List<String> list = this.openWhiteList;
        List<AdWhiteApk> list2 = this.downloadWhiteList;
        String str4 = this.dlSucCallUpUrl;
        boolean z4 = this.enableAppStore;
        boolean z5 = this.enableAppDownload;
        List<String> list3 = this.clickUrls;
        String str5 = this.universalApp;
        int i = this.appStorePriority;
        String str6 = this.storeLink;
        int i2 = this.downloadUrlType;
        return "ClickArg(wxInfo=" + adWxProgramInfo + ", callUpUrl=" + str + ", jumpUrl=" + str2 + ", cancelUrl=" + str3 + ", enableCallUpCancelToJumpUrl=" + z + ", enableDoubleJump=" + z2 + ", useAdWeb=" + z3 + ", openWhiteList=" + list + ", downloadWhiteList=" + list2 + ", dlSucCallUpUrl=" + str4 + ", enableAppStore=" + z4 + ", enableAppDownload=" + z5 + ", clickUrls=" + list3 + ", universalApp=" + str5 + ", appStorePriority=" + i + ", storeLink=" + str6 + ", downloadUrlType=" + i2 + ", isFirstJump=" + this.isFirstJump + ")";
    }

    public ClickArg(AdWxProgramInfo wxInfo, String callUpUrl, String jumpUrl, String cancelUrl, boolean enableCallUpCancelToJumpUrl, boolean enableDoubleJump, boolean useAdWeb, List<String> list, List<AdWhiteApk> list2, String dlSucCallUpUrl, boolean enableAppStore, boolean enableAppDownload, List<String> list3, String universalApp, int appStorePriority, String storeLink, int downloadUrlType, boolean isFirstJump) {
        this.wxInfo = wxInfo;
        this.callUpUrl = callUpUrl;
        this.jumpUrl = jumpUrl;
        this.cancelUrl = cancelUrl;
        this.enableCallUpCancelToJumpUrl = enableCallUpCancelToJumpUrl;
        this.enableDoubleJump = enableDoubleJump;
        this.useAdWeb = useAdWeb;
        this.openWhiteList = list;
        this.downloadWhiteList = list2;
        this.dlSucCallUpUrl = dlSucCallUpUrl;
        this.enableAppStore = enableAppStore;
        this.enableAppDownload = enableAppDownload;
        this.clickUrls = list3;
        this.universalApp = universalApp;
        this.appStorePriority = appStorePriority;
        this.storeLink = storeLink;
        this.downloadUrlType = downloadUrlType;
        this.isFirstJump = isFirstJump;
    }

    public /* synthetic */ ClickArg(AdWxProgramInfo adWxProgramInfo, String str, String str2, String str3, boolean z, boolean z2, boolean z3, List list, List list2, String str4, boolean z4, boolean z5, List list3, String str5, int i, String str6, int i2, boolean z6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(adWxProgramInfo, str, str2, str3, z, z2, z3, list, list2, str4, z4, z5, list3, (i3 & 8192) != 0 ? null : str5, (i3 & 16384) != 0 ? -1 : i, (32768 & i3) != 0 ? null : str6, (65536 & i3) != 0 ? 0 : i2, (i3 & 131072) != 0 ? false : z6);
    }

    public final AdWxProgramInfo getWxInfo() {
        return this.wxInfo;
    }

    public final String getCallUpUrl() {
        return this.callUpUrl;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final String getCancelUrl() {
        return this.cancelUrl;
    }

    public final boolean getEnableCallUpCancelToJumpUrl() {
        return this.enableCallUpCancelToJumpUrl;
    }

    public final boolean getEnableDoubleJump() {
        return this.enableDoubleJump;
    }

    public final boolean getUseAdWeb() {
        return this.useAdWeb;
    }

    public final List<String> getOpenWhiteList() {
        return this.openWhiteList;
    }

    public final List<AdWhiteApk> getDownloadWhiteList() {
        return this.downloadWhiteList;
    }

    public final String getDlSucCallUpUrl() {
        return this.dlSucCallUpUrl;
    }

    public final boolean getEnableAppStore() {
        return this.enableAppStore;
    }

    public final boolean getEnableAppDownload() {
        return this.enableAppDownload;
    }

    public final List<String> getClickUrls() {
        return this.clickUrls;
    }

    public final String getUniversalApp() {
        return this.universalApp;
    }

    public final int getAppStorePriority() {
        return this.appStorePriority;
    }

    public final String getStoreLink() {
        return this.storeLink;
    }

    public final int getDownloadUrlType() {
        return this.downloadUrlType;
    }

    public final boolean isFirstJump() {
        return this.isFirstJump;
    }
}