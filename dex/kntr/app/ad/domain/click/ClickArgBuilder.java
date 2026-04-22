package kntr.app.ad.domain.click;

import java.util.List;
import kntr.app.ad.common.model.AdWhiteApk;
import kntr.app.ad.common.model.AdWxProgramInfo;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: ClickArg.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010W\u001a\u00020XH\u0007R&\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\u0003\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R&\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R$\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001c\u0010\u0003\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R$\u0010%\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b&\u0010\u0003\u001a\u0004\b'\u0010\u001e\"\u0004\b(\u0010 R.\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b+\u0010\u0003\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R.\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u000101\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b2\u0010\u0003\u001a\u0004\b3\u0010-\"\u0004\b4\u0010/R&\u00105\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b6\u0010\u0003\u001a\u0004\b7\u0010\u000f\"\u0004\b8\u0010\u0011R$\u00109\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b:\u0010\u0003\u001a\u0004\b;\u0010\u001e\"\u0004\b<\u0010 R\u001a\u0010=\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u001e\"\u0004\b?\u0010 R.\u0010@\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010*8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bA\u0010\u0003\u001a\u0004\bB\u0010-\"\u0004\bC\u0010/R&\u0010D\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bE\u0010\u0003\u001a\u0004\bF\u0010\u000f\"\u0004\bG\u0010\u0011R$\u0010H\u001a\u00020I8\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bJ\u0010\u0003\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001c\u0010O\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u000f\"\u0004\bQ\u0010\u0011R\u001a\u0010R\u001a\u00020IX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010L\"\u0004\bT\u0010NR\u001a\u0010U\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u001e\"\u0004\bV\u0010 ¨\u0006Y"}, d2 = {"Lkntr/app/ad/domain/click/ClickArgBuilder;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "wxInfo", "Lkntr/app/ad/common/model/AdWxProgramInfo;", "getWxInfo$annotations", "getWxInfo", "()Lkntr/app/ad/common/model/AdWxProgramInfo;", "setWxInfo", "(Lkntr/app/ad/common/model/AdWxProgramInfo;)V", "callUpUrl", RoomRecommendViewModel.EMPTY_CURSOR, "getCallUpUrl$annotations", "getCallUpUrl", "()Ljava/lang/String;", "setCallUpUrl", "(Ljava/lang/String;)V", "jumpUrl", "getJumpUrl$annotations", "getJumpUrl", "setJumpUrl", "cancelUrl", "getCancelUrl$annotations", "getCancelUrl", "setCancelUrl", "enableCallUpCancelToJumpUrl", RoomRecommendViewModel.EMPTY_CURSOR, "getEnableCallUpCancelToJumpUrl$annotations", "getEnableCallUpCancelToJumpUrl", "()Z", "setEnableCallUpCancelToJumpUrl", "(Z)V", "enableDoubleJump", "getEnableDoubleJump$annotations", "getEnableDoubleJump", "setEnableDoubleJump", "useAdWeb", "getUseAdWeb$annotations", "getUseAdWeb", "setUseAdWeb", "openWhiteList", RoomRecommendViewModel.EMPTY_CURSOR, "getOpenWhiteList$annotations", "getOpenWhiteList", "()Ljava/util/List;", "setOpenWhiteList", "(Ljava/util/List;)V", "downloadWhiteList", "Lkntr/app/ad/common/model/AdWhiteApk;", "getDownloadWhiteList$annotations", "getDownloadWhiteList", "setDownloadWhiteList", "dlSucCallUpUrl", "getDlSucCallUpUrl$annotations", "getDlSucCallUpUrl", "setDlSucCallUpUrl", "enableAppStore", "getEnableAppStore$annotations", "getEnableAppStore", "setEnableAppStore", "enableAppDownload", "getEnableAppDownload", "setEnableAppDownload", "clickUrls", "getClickUrls$annotations", "getClickUrls", "setClickUrls", "universalApp", "getUniversalApp$annotations", "getUniversalApp", "setUniversalApp", "appStorePriority", RoomRecommendViewModel.EMPTY_CURSOR, "getAppStorePriority$annotations", "getAppStorePriority", "()I", "setAppStorePriority", "(I)V", "storeLink", "getStoreLink", "setStoreLink", "downloadUrlType", "getDownloadUrlType", "setDownloadUrlType", "isFirstJump", "setFirstJump", ReportBuildInParam.BUILD, "Lkntr/app/ad/domain/click/ClickArg;", "click_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ClickArgBuilder {
    private String callUpUrl;
    private List<String> clickUrls;
    private String dlSucCallUpUrl;
    private int downloadUrlType;
    private List<AdWhiteApk> downloadWhiteList;
    private boolean enableAppDownload;
    private boolean enableAppStore;
    private boolean enableCallUpCancelToJumpUrl;
    private boolean enableDoubleJump;
    private boolean isFirstJump;
    private List<String> openWhiteList;
    private String storeLink;
    private String universalApp;
    private boolean useAdWeb;
    private AdWxProgramInfo wxInfo;
    private String jumpUrl;
    private String cancelUrl = this.jumpUrl;
    private int appStorePriority = -1;

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

    public final AdWxProgramInfo getWxInfo() {
        return this.wxInfo;
    }

    public final void setWxInfo(AdWxProgramInfo adWxProgramInfo) {
        this.wxInfo = adWxProgramInfo;
    }

    public final String getCallUpUrl() {
        return this.callUpUrl;
    }

    public final void setCallUpUrl(String str) {
        this.callUpUrl = str;
    }

    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    public final void setJumpUrl(String str) {
        this.jumpUrl = str;
    }

    public final String getCancelUrl() {
        return this.cancelUrl;
    }

    public final void setCancelUrl(String str) {
        this.cancelUrl = str;
    }

    public final boolean getEnableCallUpCancelToJumpUrl() {
        return this.enableCallUpCancelToJumpUrl;
    }

    public final void setEnableCallUpCancelToJumpUrl(boolean z) {
        this.enableCallUpCancelToJumpUrl = z;
    }

    public final boolean getEnableDoubleJump() {
        return this.enableDoubleJump;
    }

    public final void setEnableDoubleJump(boolean z) {
        this.enableDoubleJump = z;
    }

    public final boolean getUseAdWeb() {
        return this.useAdWeb;
    }

    public final void setUseAdWeb(boolean z) {
        this.useAdWeb = z;
    }

    public final List<String> getOpenWhiteList() {
        return this.openWhiteList;
    }

    public final void setOpenWhiteList(List<String> list) {
        this.openWhiteList = list;
    }

    public final List<AdWhiteApk> getDownloadWhiteList() {
        return this.downloadWhiteList;
    }

    public final void setDownloadWhiteList(List<AdWhiteApk> list) {
        this.downloadWhiteList = list;
    }

    public final String getDlSucCallUpUrl() {
        return this.dlSucCallUpUrl;
    }

    public final void setDlSucCallUpUrl(String str) {
        this.dlSucCallUpUrl = str;
    }

    public final boolean getEnableAppStore() {
        return this.enableAppStore;
    }

    public final void setEnableAppStore(boolean z) {
        this.enableAppStore = z;
    }

    public final boolean getEnableAppDownload() {
        return this.enableAppDownload;
    }

    public final void setEnableAppDownload(boolean z) {
        this.enableAppDownload = z;
    }

    public final List<String> getClickUrls() {
        return this.clickUrls;
    }

    public final void setClickUrls(List<String> list) {
        this.clickUrls = list;
    }

    public final String getUniversalApp() {
        return this.universalApp;
    }

    public final void setUniversalApp(String str) {
        this.universalApp = str;
    }

    public final int getAppStorePriority() {
        return this.appStorePriority;
    }

    public final void setAppStorePriority(int i) {
        this.appStorePriority = i;
    }

    public final String getStoreLink() {
        return this.storeLink;
    }

    public final void setStoreLink(String str) {
        this.storeLink = str;
    }

    public final int getDownloadUrlType() {
        return this.downloadUrlType;
    }

    public final void setDownloadUrlType(int i) {
        this.downloadUrlType = i;
    }

    public final boolean isFirstJump() {
        return this.isFirstJump;
    }

    public final void setFirstJump(boolean z) {
        this.isFirstJump = z;
    }

    public final ClickArg build() {
        return new ClickArg(this.wxInfo, this.callUpUrl, this.jumpUrl, this.cancelUrl, this.enableCallUpCancelToJumpUrl, this.enableDoubleJump, this.useAdWeb, this.openWhiteList, this.downloadWhiteList, this.dlSucCallUpUrl, this.enableAppStore, this.enableAppDownload, this.clickUrls, this.universalApp, this.appStorePriority, this.storeLink, this.downloadUrlType, this.isFirstJump);
    }
}