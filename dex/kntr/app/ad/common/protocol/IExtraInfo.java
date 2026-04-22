package kntr.app.ad.common.protocol;

import java.util.List;
import kntr.app.ad.common.model.AdCommentToast;
import kntr.app.ad.common.model.AdLiveBookInfo;
import kntr.app.ad.common.model.AdShareInfo;
import kntr.app.ad.common.model.AdTouchReport;
import kntr.app.ad.common.protocol.IClickable;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: IExtraInfo.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u001c\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u001c\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\nR\u001c\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u001c\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\nR\u0012\u0010\u0015\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0019\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0018R\u0012\u0010\u001b\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0012\u0010\"\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0018R\u0012\u0010$\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u001eR\u0014\u0010&\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010!R\u0012\u0010(\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0018R\u0012\u0010*\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u0018R\u0014\u0010,\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010!R\u0012\u0010.\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u0018R\u0012\u00100\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u001eR\u0014\u00102\u001a\u0004\u0018\u000103X¦\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0012\u00106\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u0018R\u0012\u00108\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u0018R\u0014\u0010:\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b;\u0010!R\u0014\u0010<\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b=\u0010!R\u0012\u0010>\u001a\u00020?X¦\u0004¢\u0006\u0006\u001a\u0004\b@\u0010AR\u0012\u0010B\u001a\u00020?X¦\u0004¢\u0006\u0006\u001a\u0004\bC\u0010AR\u0012\u0010D\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\u0018R\u0012\u0010F\u001a\u00020?X¦\u0004¢\u0006\u0006\u001a\u0004\bG\u0010AR\u001c\u0010H\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\nR\u0014\u0010J\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\bK\u0010!R\u0014\u0010L\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\bM\u0010!R\u0014\u0010N\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\bO\u0010!R\u0012\u0010P\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010\u0018R\u0012\u0010R\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\bS\u0010\u0018R\u0012\u0010T\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\bU\u0010\u0018R\u0012\u0010V\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\bV\u0010\u001eR\u0012\u0010W\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\bX\u0010\u0018R\u0014\u0010Y\u001a\u0004\u0018\u00010ZX¦\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0014\u0010]\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b^\u0010!R\u0014\u0010_\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b`\u0010!R\u0014\u0010a\u001a\u0004\u0018\u00010bX¦\u0004¢\u0006\u0006\u001a\u0004\bc\u0010dR\u0012\u0010e\u001a\u00020?X¦\u0004¢\u0006\u0006\u001a\u0004\bf\u0010AR\u0012\u0010g\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\bh\u0010\u0018R\u0012\u0010i\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\bi\u0010\u0018R\u0012\u0010j\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\bk\u0010\u001eR\u0012\u0010l\u001a\u00020?X¦\u0004¢\u0006\u0006\u001a\u0004\bm\u0010AR\u001c\u0010n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010o\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\bp\u0010\nR\u0012\u0010q\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\br\u0010\u0018R\u0014\u0010s\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\bt\u0010!R\u0014\u0010u\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\bv\u0010!R\u0014\u0010w\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\bx\u0010!¨\u0006yÀ\u0006\u0003"}, d2 = {"Lkntr/app/ad/common/protocol/IExtraInfo;", "Lkntr/app/ad/common/protocol/IClickable;", "card", "Lkntr/app/ad/common/protocol/IRenderable;", "getCard", "()Lkntr/app/ad/common/protocol/IRenderable;", "showUrls", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "getShowUrls", "()Ljava/util/List;", "clickUrls", "getClickUrls", "dmListShowUrls", "getDmListShowUrls", "dmListClickUrls", "getDmListClickUrls", "dmDetailShowUrls", "getDmDetailShowUrls", "dmTrolleyAddUrls", "getDmTrolleyAddUrls", "reportTime", RoomRecommendViewModel.EMPTY_CURSOR, "getReportTime", "()I", "salesType", "getSalesType", "specialIndustry", RoomRecommendViewModel.EMPTY_CURSOR, "getSpecialIndustry", "()Z", "specialIndustryTips", "getSpecialIndustryTips", "()Ljava/lang/String;", "specialIndustryStyle", "getSpecialIndustryStyle", "enableH5Alert", "getEnableH5Alert", "externalLinkWarning", "getExternalLinkWarning", "preloadLandingPage", "getPreloadLandingPage", "enableH5PreLoad", "getEnableH5PreLoad", "h5PreLoadUrl", "getH5PreLoadUrl", "enableAutoCallUp", "getEnableAutoCallUp", "enableShare", "getEnableShare", "shareInfo", "Lkntr/app/ad/common/model/AdShareInfo;", "getShareInfo", "()Lkntr/app/ad/common/model/AdShareInfo;", "upZoneEntranceType", "getUpZoneEntranceType", "upZoneEntranceReportId", "getUpZoneEntranceReportId", "trackId", "getTrackId", "liveTrackId", "getLiveTrackId", "upMid", RoomRecommendViewModel.EMPTY_CURSOR, "getUpMid", "()J", "shopId", "getShopId", "storeDirectLaunch", "getStoreDirectLaunch", "productId", "getProductId", "show1sUrls", "getShow1sUrls", "fromTrackId", "getFromTrackId", "cmFromTrackId", "getCmFromTrackId", "tabUrl", "getTabUrl", "macroReplacePriority", "getMacroReplacePriority", "feedbackPanelStyle", "getFeedbackPanelStyle", "adContentType", "getAdContentType", "isDanmukuOpened", "commentToastOpen", "getCommentToastOpen", "commentToast", "Lkntr/app/ad/common/model/AdCommentToast;", "getCommentToast", "()Lkntr/app/ad/common/model/AdCommentToast;", "ocpxTargetType", "getOcpxTargetType", "abtest", "getAbtest", "splashTouch", "Lkntr/app/ad/common/model/AdTouchReport;", "getSplashTouch", "()Lkntr/app/ad/common/model/AdTouchReport;", "liveBookingId", "getLiveBookingId", "topLiveStayTimeSeconds", "getTopLiveStayTimeSeconds", "isMallPreloadSupported", "topAvatarShow", "getTopAvatarShow", "lotteryId", "getLotteryId", "liveBookingInfos", "Lkntr/app/ad/common/model/AdLiveBookInfo;", "getLiveBookingInfos", "userCancelJumpType", "getUserCancelJumpType", "userCancelJumpUrl", "getUserCancelJumpUrl", "disableComponentClickUrl", "getDisableComponentClickUrl", "appExpParams", "getAppExpParams", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface IExtraInfo extends IClickable {
    String getAbtest();

    int getAdContentType();

    String getAppExpParams();

    IRenderable getCard();

    List<String> getClickUrls();

    String getCmFromTrackId();

    AdCommentToast getCommentToast();

    int getCommentToastOpen();

    String getDisableComponentClickUrl();

    List<String> getDmDetailShowUrls();

    List<String> getDmListClickUrls();

    List<String> getDmListShowUrls();

    List<String> getDmTrolleyAddUrls();

    int getEnableAutoCallUp();

    boolean getEnableH5Alert();

    int getEnableH5PreLoad();

    boolean getEnableShare();

    String getExternalLinkWarning();

    int getFeedbackPanelStyle();

    String getFromTrackId();

    String getH5PreLoadUrl();

    long getLiveBookingId();

    List<AdLiveBookInfo> getLiveBookingInfos();

    String getLiveTrackId();

    long getLotteryId();

    int getMacroReplacePriority();

    String getOcpxTargetType();

    int getPreloadLandingPage();

    long getProductId();

    int getReportTime();

    int getSalesType();

    AdShareInfo getShareInfo();

    long getShopId();

    List<String> getShow1sUrls();

    List<String> getShowUrls();

    boolean getSpecialIndustry();

    int getSpecialIndustryStyle();

    String getSpecialIndustryTips();

    AdTouchReport getSplashTouch();

    int getStoreDirectLaunch();

    String getTabUrl();

    boolean getTopAvatarShow();

    int getTopLiveStayTimeSeconds();

    String getTrackId();

    long getUpMid();

    int getUpZoneEntranceReportId();

    int getUpZoneEntranceType();

    int getUserCancelJumpType();

    String getUserCancelJumpUrl();

    boolean isDanmukuOpened();

    int isMallPreloadSupported();

    /* compiled from: IExtraInfo.kt */
    /* renamed from: kntr.app.ad.common.protocol.IExtraInfo$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public final /* synthetic */ class CC {
    }

    /* compiled from: IExtraInfo.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static boolean getEnableOpenApkDialog(IExtraInfo $this) {
            return IClickable.CC.$default$getEnableOpenApkDialog($this);
        }
    }
}