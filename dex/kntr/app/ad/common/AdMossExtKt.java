package kntr.app.ad.common;

import com.bapis.bilibili.ad.v1.KAdAutoPlayVideoDto;
import com.bapis.bilibili.ad.v1.KAdBusinessMarkDto;
import com.bapis.bilibili.ad.v1.KAdButtonDto;
import com.bapis.bilibili.ad.v1.KAdCardCalenderInfo;
import com.bapis.bilibili.ad.v1.KAdCardDto;
import com.bapis.bilibili.ad.v1.KAdContentExtraDto;
import com.bapis.bilibili.ad.v1.KAdCoverDto;
import com.bapis.bilibili.ad.v1.KAdFeedbackPanelDto;
import com.bapis.bilibili.ad.v1.KAdFeedbackPanelModuleDto;
import com.bapis.bilibili.ad.v1.KAdGoodDto;
import com.bapis.bilibili.ad.v1.KAdSecondFeedbackPanelDto;
import com.bapis.bilibili.ad.v1.KAdShareInfoDto;
import com.bapis.bilibili.ad.v1.KAdverDto;
import com.bapis.bilibili.ad.v1.KAndroidGamePageRes;
import com.bapis.bilibili.ad.v1.KAndroidTag;
import com.bapis.bilibili.ad.v1.KAppDownloadStyle;
import com.bapis.bilibili.ad.v1.KAppPackageDto;
import com.bapis.bilibili.ad.v1.KBulletin;
import com.bapis.bilibili.ad.v1.KComment;
import com.bapis.bilibili.ad.v1.KCustomPlayUrl;
import com.bapis.bilibili.ad.v1.KFeedsRcmdReasonStyle;
import com.bapis.bilibili.ad.v1.KForwardReply;
import com.bapis.bilibili.ad.v1.KGameInfo;
import com.bapis.bilibili.ad.v1.KGameRank;
import com.bapis.bilibili.ad.v1.KGift;
import com.bapis.bilibili.ad.v1.KLeftCoverBadgeNewStyle;
import com.bapis.bilibili.ad.v1.KLiveBookInfoDto;
import com.bapis.bilibili.ad.v1.KModule1;
import com.bapis.bilibili.ad.v1.KModule10;
import com.bapis.bilibili.ad.v1.KModule11;
import com.bapis.bilibili.ad.v1.KModule12;
import com.bapis.bilibili.ad.v1.KModule13;
import com.bapis.bilibili.ad.v1.KModule14;
import com.bapis.bilibili.ad.v1.KModule3;
import com.bapis.bilibili.ad.v1.KModule4;
import com.bapis.bilibili.ad.v1.KModule5;
import com.bapis.bilibili.ad.v1.KModule6;
import com.bapis.bilibili.ad.v1.KModule7;
import com.bapis.bilibili.ad.v1.KModule8;
import com.bapis.bilibili.ad.v1.KModule9;
import com.bapis.bilibili.ad.v1.KNotClickableArea;
import com.bapis.bilibili.ad.v1.KQualityInfo;
import com.bapis.bilibili.ad.v1.KQualityParmas;
import com.bapis.bilibili.ad.v1.KReward;
import com.bapis.bilibili.ad.v1.KScreenShots;
import com.bapis.bilibili.ad.v1.KStoryAnchor;
import com.bapis.bilibili.ad.v1.KStoryCartIcon;
import com.bapis.bilibili.ad.v1.KSubCardModule;
import com.bapis.bilibili.ad.v1.KTagInfo;
import com.bapis.bilibili.ad.v1.KText;
import com.bapis.bilibili.ad.v1.KWxProgramInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kntr.app.ad.common.model.AdAndroidGameInfo;
import kntr.app.ad.common.model.AdAppDownloadStyle;
import kntr.app.ad.common.model.AdBulletin;
import kntr.app.ad.common.model.AdButton;
import kntr.app.ad.common.model.AdCalendarInfo;
import kntr.app.ad.common.model.AdChronosEffect;
import kntr.app.ad.common.model.AdComboClickParams;
import kntr.app.ad.common.model.AdCover;
import kntr.app.ad.common.model.AdCoverBadge;
import kntr.app.ad.common.model.AdCoverTopLeftBadge;
import kntr.app.ad.common.model.AdCustomPlayUrl;
import kntr.app.ad.common.model.AdEasterEggParams;
import kntr.app.ad.common.model.AdFeedbackPanel;
import kntr.app.ad.common.model.AdFlySubCardModule;
import kntr.app.ad.common.model.AdFormInfo;
import kntr.app.ad.common.model.AdForwardReply;
import kntr.app.ad.common.model.AdGameApkInfoModule;
import kntr.app.ad.common.model.AdGameBookAwardModule;
import kntr.app.ad.common.model.AdGameCommentModule;
import kntr.app.ad.common.model.AdGameDescModule;
import kntr.app.ad.common.model.AdGameDevIntroModule;
import kntr.app.ad.common.model.AdGameGiftModule;
import kntr.app.ad.common.model.AdGameGlanceModule;
import kntr.app.ad.common.model.AdGameGradeModule;
import kntr.app.ad.common.model.AdGameInfo;
import kntr.app.ad.common.model.AdGameLatestUpdateModule;
import kntr.app.ad.common.model.AdGameQualityInfo;
import kntr.app.ad.common.model.AdGameQualityModule;
import kntr.app.ad.common.model.AdGameRank;
import kntr.app.ad.common.model.AdGameScreenShotModule;
import kntr.app.ad.common.model.AdGameSummaryModule;
import kntr.app.ad.common.model.AdGameTagModule;
import kntr.app.ad.common.model.AdGift;
import kntr.app.ad.common.model.AdGood;
import kntr.app.ad.common.model.AdHeartBox;
import kntr.app.ad.common.model.AdIMaxLandingPage;
import kntr.app.ad.common.model.AdInfoCard;
import kntr.app.ad.common.model.AdInfoExtra;
import kntr.app.ad.common.model.AdJkCart;
import kntr.app.ad.common.model.AdLiveBookInfo;
import kntr.app.ad.common.model.AdLotteryCard;
import kntr.app.ad.common.model.AdPasteboardInfo;
import kntr.app.ad.common.model.AdPrice;
import kntr.app.ad.common.model.AdProductCarouselData;
import kntr.app.ad.common.model.AdQualityInfo;
import kntr.app.ad.common.model.AdRcmdReasonStyle;
import kntr.app.ad.common.model.AdShareInfo;
import kntr.app.ad.common.model.AdShopWindow;
import kntr.app.ad.common.model.AdStoryCartIcon;
import kntr.app.ad.common.model.AdStoryGoods;
import kntr.app.ad.common.model.AdStoryStyleSelection;
import kntr.app.ad.common.model.AdSubCardModule;
import kntr.app.ad.common.model.AdTagStyle;
import kntr.app.ad.common.model.AdTextBean;
import kntr.app.ad.common.model.AdThumbsUpSubCardModule;
import kntr.app.ad.common.model.AdTreasureHuntBall;
import kntr.app.ad.common.model.AdVer;
import kntr.app.ad.common.model.AdVideo;
import kntr.app.ad.common.model.AdVideoEndPage;
import kntr.app.ad.common.model.AdWhiteApk;
import kntr.app.ad.common.model.AdWxProgramInfo;
import kntr.app.ad.common.model.AdXYZ;
import kntr.app.ad.common.utils.StringExtKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AdMossExt.kt */
@Metadata(d1 = {"\u0000è\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0000\u001a\u00020\u0003*\u00020\u0004H\u0002\u001a\f\u0010\u0000\u001a\u00020\u0005*\u00020\u0006H\u0002\u001a\f\u0010\u0000\u001a\u00020\u0007*\u00020\bH\u0002\u001a\f\u0010\u0000\u001a\u00020\t*\u00020\nH\u0002\u001a\f\u0010\u0000\u001a\u00020\u000b*\u00020\fH\u0002\u001a\f\u0010\u0000\u001a\u00020\r*\u00020\u000eH\u0002\u001a\f\u0010\u0000\u001a\u00020\u000f*\u00020\u0010H\u0002\u001a\f\u0010\u0000\u001a\u00020\u0011*\u00020\u0012H\u0002\u001a\f\u0010\u0000\u001a\u00020\u0013*\u00020\u0014H\u0002\u001a\f\u0010\u0000\u001a\u00020\u0013*\u00020\u0015H\u0002\u001a\f\u0010\u0000\u001a\u00020\u0016*\u00020\u0017H\u0002\u001a\f\u0010\u0000\u001a\u00020\u0018*\u00020\u0019H\u0002\u001a\f\u0010\u0000\u001a\u00020\u001a*\u00020\u001bH\u0002\u001a\f\u0010\u0000\u001a\u00020\u001c*\u00020\u001dH\u0002\u001a\f\u0010\u0000\u001a\u00020\u001e*\u00020\u001fH\u0002\u001a\f\u0010\u0000\u001a\u00020 *\u00020!H\u0002\u001a\f\u0010\u0000\u001a\u00020\"*\u00020#H\u0002\u001a\f\u0010\u0000\u001a\u00020$*\u00020%H\u0002\u001a\f\u0010\u0000\u001a\u00020&*\u00020'H\u0002\u001a\f\u0010\u0000\u001a\u00020(*\u00020)H\u0002\u001a\f\u0010\u0000\u001a\u00020**\u00020+H\u0002\u001a\f\u0010\u0000\u001a\u00020,*\u00020-H\u0002\u001a\f\u0010\u0000\u001a\u00020.*\u00020/H\u0002\u001a\f\u0010\u0000\u001a\u000200*\u000201H\u0002\u001a\f\u0010\u0000\u001a\u000202*\u000203H\u0002\u001a\f\u0010\u0000\u001a\u000204*\u000205H\u0002\u001a\f\u0010\u0000\u001a\u000206*\u000207H\u0002\u001a\f\u0010\u0000\u001a\u000208*\u000209H\u0002¨\u0006:"}, d2 = {"transform", "Lkntr/app/ad/common/model/AdInfoExtra;", "Lcom/bapis/bilibili/ad/v1/KAdContentExtraDto;", "Lkntr/app/ad/common/model/AdInfoCard;", "Lcom/bapis/bilibili/ad/v1/KAdCardDto;", "Lkntr/app/ad/common/model/AdCalendarInfo;", "Lcom/bapis/bilibili/ad/v1/KAdCardCalenderInfo;", "Lkntr/app/ad/common/model/AdButton;", "Lcom/bapis/bilibili/ad/v1/KAdButtonDto;", "Lkntr/app/ad/common/model/AdWhiteApk;", "Lcom/bapis/bilibili/ad/v1/KAppPackageDto;", "Lkntr/app/ad/common/model/AdLiveBookInfo;", "Lcom/bapis/bilibili/ad/v1/KLiveBookInfoDto;", "Lkntr/app/ad/common/model/AdShareInfo;", "Lcom/bapis/bilibili/ad/v1/KAdShareInfoDto;", "Lkntr/app/ad/common/model/AdCover;", "Lcom/bapis/bilibili/ad/v1/KAdCoverDto;", "Lkntr/app/ad/common/model/AdGood;", "Lcom/bapis/bilibili/ad/v1/KAdGoodDto;", "Lkntr/app/ad/common/model/AdTagStyle;", "Lcom/bapis/bilibili/ad/v1/KAdBusinessMarkDto;", "Lcom/bapis/bilibili/ad/v1/KTagInfo;", "Lkntr/app/ad/common/model/AdVideo;", "Lcom/bapis/bilibili/ad/v1/KAdAutoPlayVideoDto;", "Lkntr/app/ad/common/model/AdFeedbackPanel;", "Lcom/bapis/bilibili/ad/v1/KAdFeedbackPanelDto;", "Lkntr/app/ad/common/model/AdQualityInfo;", "Lcom/bapis/bilibili/ad/v1/KQualityInfo;", "Lkntr/app/ad/common/model/AdVer;", "Lcom/bapis/bilibili/ad/v1/KAdverDto;", "Lkntr/app/ad/common/model/AdSubCardModule;", "Lcom/bapis/bilibili/ad/v1/KSubCardModule;", "Lkntr/app/ad/common/model/AdBulletin;", "Lcom/bapis/bilibili/ad/v1/KBulletin;", "Lkntr/app/ad/common/model/AdGift;", "Lcom/bapis/bilibili/ad/v1/KGift;", "Lkntr/app/ad/common/model/AdWxProgramInfo;", "Lcom/bapis/bilibili/ad/v1/KWxProgramInfo;", "Lkntr/app/ad/common/model/AdRcmdReasonStyle;", "Lcom/bapis/bilibili/ad/v1/KFeedsRcmdReasonStyle;", "Lkntr/app/ad/common/model/AdXYZ;", "Lcom/bapis/bilibili/ad/v1/KNotClickableArea;", "Lkntr/app/ad/common/model/AdForwardReply;", "Lcom/bapis/bilibili/ad/v1/KForwardReply;", "Lkntr/app/ad/common/model/AdStoryGoods;", "Lcom/bapis/bilibili/ad/v1/KStoryAnchor;", "Lkntr/app/ad/common/model/AdCoverTopLeftBadge;", "Lcom/bapis/bilibili/ad/v1/KLeftCoverBadgeNewStyle;", "Lkntr/app/ad/common/model/AdGameInfo;", "Lcom/bapis/bilibili/ad/v1/KGameInfo;", "Lkntr/app/ad/common/model/AdGameRank;", "Lcom/bapis/bilibili/ad/v1/KGameRank;", "Lkntr/app/ad/common/model/AdAppDownloadStyle;", "Lcom/bapis/bilibili/ad/v1/KAppDownloadStyle;", "Lkntr/app/ad/common/model/AdAndroidGameInfo;", "Lcom/bapis/bilibili/ad/v1/KAndroidGamePageRes;", "Lkntr/app/ad/common/model/AdTextBean;", "Lcom/bapis/bilibili/ad/v1/KText;", "dto_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AdMossExtKt {
    public static final AdInfoExtra transform(KAdContentExtraDto $this$transform) {
        Intrinsics.checkNotNullParameter($this$transform, "<this>");
        boolean useAdWebV2 = $this$transform.getUseAdWebV2();
        List showUrls = $this$transform.getShowUrls();
        List clickUrls = $this$transform.getClickUrls();
        List danmuListShowUrls = $this$transform.getDanmuListShowUrls();
        List danmuListClickUrls = $this$transform.getDanmuListClickUrls();
        List danmuDetailShowUrls = $this$transform.getDanmuDetailShowUrls();
        List danmuTrolleyAddUrls = $this$transform.getDanmuTrolleyAddUrls();
        Iterable $this$map$iv = $this$transform.getDownloadWhitelist();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KAppPackageDto it = (KAppPackageDto) item$iv$iv;
            destination$iv$iv.add(transform(it));
        }
        ArrayList arrayList = (List) destination$iv$iv;
        List openWhitelist = $this$transform.getOpenWhitelist();
        KAdCardDto card = $this$transform.getCard();
        AdInfoCard transform = card != null ? transform(card) : null;
        int reportTime = $this$transform.getReportTime();
        int salesType = $this$transform.getSalesType();
        boolean specialIndustry = $this$transform.getSpecialIndustry();
        String specialIndustryTips = $this$transform.getSpecialIndustryTips();
        int specialIndustryStyle = $this$transform.getSpecialIndustryStyle();
        boolean enableH5Alert = $this$transform.getEnableH5Alert();
        String externalLinkWarning = $this$transform.getExternalLinkWarning();
        int preloadLandingpage = $this$transform.getPreloadLandingpage();
        int enableH5PreLoad = $this$transform.getEnableH5PreLoad();
        String h5PreLoadUrl = $this$transform.getH5PreLoadUrl();
        int enableAutoCallup = $this$transform.getEnableAutoCallup();
        boolean enableDownloadDialog = $this$transform.getEnableDownloadDialog();
        boolean enableShare = $this$transform.getEnableShare();
        KAdShareInfoDto shareInfo = $this$transform.getShareInfo();
        AdShareInfo transform2 = shareInfo != null ? transform(shareInfo) : null;
        int upzoneEntranceType = $this$transform.getUpzoneEntranceType();
        int upzoneEntranceReportId = $this$transform.getUpzoneEntranceReportId();
        String trackId = $this$transform.getTrackId();
        long upMid = $this$transform.getUpMid();
        long shopId = $this$transform.getShopId();
        int enableStoreDirectLaunch = $this$transform.getEnableStoreDirectLaunch();
        long productId = $this$transform.getProductId();
        boolean enableDoubleJump = $this$transform.getEnableDoubleJump();
        List show1sUrls = $this$transform.getShow1sUrls();
        String fromTrackId = $this$transform.getFromTrackId();
        int landingpageDownloadStyle = $this$transform.getLandingpageDownloadStyle();
        int downloadUrlType = $this$transform.getDownloadUrlType();
        boolean storeCallupCard = $this$transform.getStoreCallupCard();
        int macroReplacePriority = $this$transform.getMacroReplacePriority();
        int feedbackPanelStyle = $this$transform.getFeedbackPanelStyle();
        String cmFromTrackId = $this$transform.getCmFromTrackId();
        String abtest = $this$transform.getAbtest();
        long liveBookingId = $this$transform.getLiveBookingId();
        String storeDplinkXiaomi = $this$transform.getStoreDplinkXiaomi();
        long lotteryId = $this$transform.getLotteryId();
        boolean enableOpenapkDialog = $this$transform.getEnableOpenapkDialog();
        Iterable $this$map$iv2 = $this$transform.getLiveBookingInfos();
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        Iterable $this$mapTo$iv$iv = $this$map$iv2;
        for (Object item$iv$iv2 : $this$mapTo$iv$iv) {
            KLiveBookInfoDto it2 = (KLiveBookInfoDto) item$iv$iv2;
            destination$iv$iv2.add(transform(it2));
            $this$mapTo$iv$iv = $this$mapTo$iv$iv;
        }
        return new AdInfoExtra(useAdWebV2, showUrls, clickUrls, danmuListShowUrls, danmuListClickUrls, danmuDetailShowUrls, danmuTrolleyAddUrls, arrayList, openWhitelist, transform, reportTime, salesType, specialIndustry, specialIndustryTips, specialIndustryStyle, enableH5Alert, externalLinkWarning, preloadLandingpage, enableH5PreLoad, h5PreLoadUrl, enableAutoCallup, enableDownloadDialog, enableShare, transform2, upzoneEntranceType, upzoneEntranceReportId, trackId, null, upMid, shopId, enableStoreDirectLaunch, productId, enableDoubleJump, show1sUrls, fromTrackId, landingpageDownloadStyle, downloadUrlType, storeCallupCard, null, macroReplacePriority, feedbackPanelStyle, 0, false, cmFromTrackId, 0, null, null, abtest, null, liveBookingId, storeDplinkXiaomi, 0, 0, false, lotteryId, enableOpenapkDialog, (List) destination$iv$iv2, $this$transform.getUserCancelJumpType(), $this$transform.getUserCancelJumpUrl(), null, $this$transform.getAppExpParams(), 134217728, 137983552, null);
    }

    private static final AdInfoCard transform(KAdCardDto $this$transform) {
        int cardType = $this$transform.getCardType();
        String title = $this$transform.getTitle();
        String jumpUrl = $this$transform.getJumpUrl();
        String callupUrl = $this$transform.getCallupUrl();
        String desc = $this$transform.getDesc();
        String oriPrice = $this$transform.getOriPrice();
        String valueOf = String.valueOf($this$transform.getCurPrice());
        String extraDesc = $this$transform.getExtraDesc();
        String valueOf2 = String.valueOf($this$transform.getRank());
        String valueOf3 = String.valueOf($this$transform.getHotScore());
        Iterable $this$map$iv = $this$transform.getCovers();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KAdCoverDto it = (KAdCoverDto) item$iv$iv;
            destination$iv$iv.add(transform(it));
        }
        ArrayList arrayList = (List) destination$iv$iv;
        KAdButtonDto button = $this$transform.getButton();
        AdButton transform = button != null ? transform(button) : null;
        String longDesc = $this$transform.getLongDesc();
        String adverLogo = $this$transform.getAdverLogo();
        String adverName = $this$transform.getAdverName();
        String adverPageUrl = $this$transform.getAdverPageUrl();
        List videoBarrage = $this$transform.getVideoBarrage();
        String adTag = $this$transform.getAdTag();
        String shortTitle = $this$transform.getShortTitle();
        String danmuTitle = $this$transform.getDanmuTitle();
        int danmuLife = $this$transform.getDanmuLife();
        int danmuBegin = $this$transform.getDanmuBegin();
        int danmuHeight = $this$transform.getDanmuHeight();
        String danmuColor = $this$transform.getDanmuColor();
        int foldTime = $this$transform.getFoldTime();
        KAdGoodDto good = $this$transform.getGood();
        AdGood transform2 = good != null ? transform(good) : null;
        KAdBusinessMarkDto adTagStyle = $this$transform.getAdTagStyle();
        AdTagStyle transform3 = adTagStyle != null ? transform(adTagStyle) : null;
        KAdBusinessMarkDto adTagStyleFullScreen = $this$transform.getAdTagStyleFullScreen();
        AdTagStyle transform4 = adTagStyleFullScreen != null ? transform(adTagStyleFullScreen) : null;
        KAdAutoPlayVideoDto video = $this$transform.getVideo();
        AdVideo transform5 = video != null ? transform(video) : null;
        String danmuH5url = $this$transform.getDanmuH5url();
        KAdFeedbackPanelDto feedbackPanel = $this$transform.getFeedbackPanel();
        AdFeedbackPanel transform6 = feedbackPanel != null ? transform(feedbackPanel) : null;
        String danmuIcon = $this$transform.getDanmuIcon();
        int danmuWidth = $this$transform.getDanmuWidth();
        String priceDesc = $this$transform.getPriceDesc();
        String goodsCurPrice = $this$transform.getGoodsCurPrice();
        String priceSymbol = $this$transform.getPriceSymbol();
        String goodsOriPrice = $this$transform.getGoodsOriPrice();
        String duration = $this$transform.getDuration();
        Iterable $this$map$iv2 = $this$transform.getQualityInfos();
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            KQualityInfo it2 = (KQualityInfo) item$iv$iv2;
            destination$iv$iv2.add(transform(it2));
            $this$map$iv2 = $this$map$iv2;
        }
        ArrayList arrayList2 = (List) destination$iv$iv2;
        KAdverDto adver = $this$transform.getAdver();
        AdVer transform7 = adver != null ? transform(adver) : null;
        String dynamicText = $this$transform.getDynamicText();
        int gradeLevel = $this$transform.getGradeLevel();
        int underPlayerInteractionStyle = $this$transform.getUnderPlayerInteractionStyle();
        int jumpInteractionStyle = $this$transform.getJumpInteractionStyle();
        String imaxLandingPageV2 = $this$transform.getImaxLandingPageV2();
        KSubCardModule subcardModule = $this$transform.getSubcardModule();
        AdSubCardModule transform8 = subcardModule != null ? transform(subcardModule) : null;
        String gameRating = $this$transform.getGameRating();
        List gameTags = $this$transform.getGameTags();
        KBulletin bulletin = $this$transform.getBulletin();
        AdBulletin transform9 = bulletin != null ? transform(bulletin) : null;
        KGift gift = $this$transform.getGift();
        AdGift transform10 = gift != null ? transform(gift) : null;
        int starLevel = $this$transform.getStarLevel();
        int oriMarkHidden = $this$transform.getOriMarkHidden();
        KWxProgramInfo wxProgramInfo = $this$transform.getWxProgramInfo();
        AdWxProgramInfo transform11 = wxProgramInfo != null ? transform(wxProgramInfo) : null;
        KAndroidGamePageRes androidGamePageRes = $this$transform.getAndroidGamePageRes();
        AdAndroidGameInfo transform12 = androidGamePageRes != null ? transform(androidGamePageRes) : null;
        boolean useMultiCover = $this$transform.getUseMultiCover();
        String productSource = $this$transform.getProductSource();
        KAdAutoPlayVideoDto video2 = $this$transform.getVideo();
        AdVideo transform13 = video2 != null ? transform(video2) : null;
        List labels = $this$transform.getLabels();
        KFeedsRcmdReasonStyle rcmdReasonStyle = $this$transform.getRcmdReasonStyle();
        AdRcmdReasonStyle transform14 = rcmdReasonStyle != null ? transform(rcmdReasonStyle) : null;
        KNotClickableArea notClickableArea = $this$transform.getNotClickableArea();
        AdXYZ transform15 = notClickableArea != null ? transform(notClickableArea) : null;
        KForwardReply forwardReply = $this$transform.getForwardReply();
        AdForwardReply transform16 = forwardReply != null ? transform(forwardReply) : null;
        KStoryAnchor storyAnchor = $this$transform.getStoryAnchor();
        AdStoryGoods transform17 = storyAnchor != null ? transform(storyAnchor) : null;
        String volumeDesc = $this$transform.getVolumeDesc();
        String couponDesc = $this$transform.getCouponDesc();
        String couponPrice = $this$transform.getCouponPrice();
        long goodsItemId = $this$transform.getGoodsItemId();
        String avContent = $this$transform.getAvContent();
        int animInEnable = $this$transform.getAnimInEnable();
        int cardStyle = $this$transform.getCardStyle();
        int underframeCardStyle = $this$transform.getUnderframeCardStyle();
        int gradeDenominator = $this$transform.getGradeDenominator();
        KLeftCoverBadgeNewStyle leftCoverBadgeNewStyle = $this$transform.getLeftCoverBadgeNewStyle();
        AdCoverTopLeftBadge transform18 = leftCoverBadgeNewStyle != null ? transform(leftCoverBadgeNewStyle) : null;
        KGameInfo gameInfo = $this$transform.getGameInfo();
        AdGameInfo transform19 = gameInfo != null ? transform(gameInfo) : null;
        KGameRank gameRank = $this$transform.getGameRank();
        AdGameRank transform20 = gameRank != null ? transform(gameRank) : null;
        String lotteryText = $this$transform.getLotteryText();
        String warmUpText = $this$transform.getWarmUpText();
        int livePageType = $this$transform.getLivePageType();
        String extraParams = $this$transform.getExtraParams();
        KAdCardCalenderInfo calenderInfo = $this$transform.getCalenderInfo();
        AdCalendarInfo transform21 = calenderInfo != null ? transform(calenderInfo) : null;
        int halfPanelInteractionStyle = $this$transform.getHalfPanelInteractionStyle();
        int halfPanelContentType = $this$transform.getHalfPanelContentType();
        int playpageCardStyle = $this$transform.getPlaypageCardStyle();
        KAppDownloadStyle appDownloadStyle = $this$transform.getAppDownloadStyle();
        AdAppDownloadStyle transform22 = appDownloadStyle != null ? transform(appDownloadStyle) : null;
        Iterable $this$map$iv3 = $this$transform.getDescList();
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
        for (Object item$iv$iv3 : $this$map$iv3) {
            KText it3 = (KText) item$iv$iv3;
            destination$iv$iv3.add(transform(it3));
            $this$map$iv3 = $this$map$iv3;
        }
        return new AdInfoCard(0, 0, cardType, title, jumpUrl, (String) null, callupUrl, desc, 0, oriPrice, valueOf, extraDesc, valueOf2, valueOf3, (List) arrayList, transform, longDesc, adverLogo, adverName, adverPageUrl, videoBarrage, adTag, shortTitle, danmuTitle, danmuLife, danmuBegin, danmuHeight, danmuColor, foldTime, transform2, transform3, transform4, transform5, danmuH5url, transform6, danmuIcon, danmuWidth, (AdIMaxLandingPage) null, priceDesc, goodsCurPrice, priceSymbol, goodsOriPrice, (String) null, (String) null, 0, (String) null, (String) null, false, duration, (List) arrayList2, transform7, dynamicText, (List) null, gradeLevel, (String) null, false, (String) null, (String) null, false, (String) null, underPlayerInteractionStyle, jumpInteractionStyle, (AdCoverBadge) null, imaxLandingPageV2, transform8, (AdFlySubCardModule) null, (AdThumbsUpSubCardModule) null, (AdTreasureHuntBall) null, gameRating, (List) null, gameTags, 0L, (String) null, (String) null, transform9, transform10, starLevel, oriMarkHidden, transform11, transform12, useMultiCover, productSource, transform13, labels, (AdShopWindow) null, transform14, (AdVideo) null, transform15, (List) null, transform16, (AdStoryGoods) null, transform17, (String) null, 0, 0, volumeDesc, (List) null, couponDesc, couponPrice, goodsItemId, (AdEasterEggParams) null, avContent, 0L, 0, 0, (AdFormInfo) null, (AdPasteboardInfo) null, animInEnable, (String) null, (String) null, (List) null, 0, cardStyle, underframeCardStyle, gradeDenominator, transform18, transform19, transform20, 0, (String) null, 0, 0, lotteryText, warmUpText, livePageType, extraParams, 0, transform21, false, 0.0f, 0L, 0, halfPanelInteractionStyle, halfPanelContentType, 0, false, (AdLotteryCard) null, (AdComboClickParams) null, (String) null, 0, 0, (String) null, (AdChronosEffect) null, (AdProductCarouselData) null, playpageCardStyle, transform22, (AdHeartBox) null, (AdStoryStyleSelection) null, (List) ((List) destination$iv$iv3), false, 291, 1339096096, 1968178094, 1136719825, 2949071, (DefaultConstructorMarker) null);
    }

    private static final AdCalendarInfo transform(KAdCardCalenderInfo $this$transform) {
        return new AdCalendarInfo($this$transform.getTitle(), Long.valueOf($this$transform.getStartTime()), Long.valueOf($this$transform.getEndTime()), $this$transform.getCalenderId(), $this$transform.getComment(), (String) null, $this$transform.getCalendarIdStr(), 32, (DefaultConstructorMarker) null);
    }

    private static final AdButton transform(KAdButtonDto $this$transform) {
        return new AdButton($this$transform.getText(), $this$transform.getType(), $this$transform.getJumpUrl(), $this$transform.getCallupUrl(), $this$transform.getReportUrls(), $this$transform.getDlsucCallupUrl(), 0L, $this$transform.getGameId(), $this$transform.getGameMonitorParam(), 0, false, 0, 0L, (String) null, (String) null, $this$transform.getShowGameCustomText(), 0, $this$transform.getGameChannelId(), $this$transform.getGameChannelExtra(), $this$transform.getGameSourcefrom(), (AdSubCardModule) null, $this$transform.getDlsucCallupText(), 1146432, (DefaultConstructorMarker) null);
    }

    private static final AdWhiteApk transform(KAppPackageDto $this$transform) {
        return new AdWhiteApk($this$transform.getSize(), $this$transform.getDisplayName(), $this$transform.getApkName(), $this$transform.getUrl(), $this$transform.getBiliUrl(), $this$transform.getMd5(), $this$transform.getIcon(), $this$transform.getDevName(), $this$transform.getAuthUrl(), $this$transform.getVersion(), $this$transform.getUpdateTime(), $this$transform.getAuthName(), $this$transform.getPrivacyUrl(), $this$transform.getPrivacyName());
    }

    private static final AdLiveBookInfo transform(KLiveBookInfoDto $this$transform) {
        long liveBookingId = $this$transform.getLiveBookingId();
        KAdCardCalenderInfo calenderInfo = $this$transform.getCalenderInfo();
        return new AdLiveBookInfo(liveBookingId, calenderInfo != null ? transform(calenderInfo) : null, $this$transform.getLivePageType());
    }

    private static final AdShareInfo transform(KAdShareInfoDto $this$transform) {
        return new AdShareInfo($this$transform.getTitle(), $this$transform.getSubtitle(), $this$transform.getImageUrl());
    }

    private static final AdCover transform(KAdCoverDto $this$transform) {
        return new AdCover($this$transform.getUrl(), $this$transform.getNightUrl(), $this$transform.getJumpUrl(), $this$transform.getReportUrls(), $this$transform.getLoop(), $this$transform.getImageHeight(), $this$transform.getImageWidth(), (String) null, (String) null, false, 896, (DefaultConstructorMarker) null);
    }

    private static final AdGood transform(KAdGoodDto $this$transform) {
        return new AdGood($this$transform.getItemId(), $this$transform.getSkuId(), $this$transform.getShopId(), $this$transform.getSkuNum());
    }

    private static final AdTagStyle transform(KAdBusinessMarkDto $this$transform) {
        return new AdTagStyle($this$transform.getType(), $this$transform.getText(), $this$transform.getBgColor(), $this$transform.getBorderColor(), $this$transform.getTextColor(), $this$transform.getBgColorNight(), $this$transform.getBorderColorNight(), $this$transform.getTextColorNight(), $this$transform.getImgUrl(), $this$transform.getImgHeight(), $this$transform.getImgWidth());
    }

    private static final AdTagStyle transform(KTagInfo $this$transform) {
        return new AdTagStyle(StringExtKt.toIntOrZero($this$transform.getType()), $this$transform.getText(), $this$transform.getBgColor(), $this$transform.getBorderColor(), $this$transform.getTextColor(), $this$transform.getBgColorNight(), $this$transform.getBorderColorNight(), $this$transform.getTextColorNight(), (String) null, 0, 0, 1792, (DefaultConstructorMarker) null);
    }

    private static final AdVideo transform(KAdAutoPlayVideoDto $this$transform) {
        String valueOf = String.valueOf($this$transform.getAvid());
        String valueOf2 = String.valueOf($this$transform.getCid());
        String valueOf3 = String.valueOf($this$transform.getPage());
        String from = $this$transform.getFrom();
        String url = $this$transform.getUrl();
        String cover = $this$transform.getCover();
        Boolean valueOf4 = Boolean.valueOf($this$transform.getAutoPlay());
        Boolean valueOf5 = Boolean.valueOf($this$transform.getBtnDycColor());
        String valueOf6 = String.valueOf($this$transform.getBtnDycTime());
        String valueOf7 = String.valueOf($this$transform.getBizId());
        List process0Urls = $this$transform.getProcess0Urls();
        List play3sUrls = $this$transform.getPlay3sUrls();
        List play5sUrls = $this$transform.getPlay5sUrls();
        List play10sUrls = $this$transform.getPlay10sUrls();
        List play15sUrls = $this$transform.getPlay15sUrls();
        Iterable $this$map$iv = $this$transform.getCustomPlayUrls();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        Iterable $this$mapTo$iv$iv = $this$map$iv;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            KCustomPlayUrl it = (KCustomPlayUrl) item$iv$iv;
            destination$iv$iv.add(new AdCustomPlayUrl(it.getPlayTime(), it.getUrls()));
            $this$map$iv = $this$map$iv;
            $this$mapTo$iv$iv = $this$mapTo$iv$iv;
            play5sUrls = play5sUrls;
        }
        return new AdVideo(valueOf, valueOf2, valueOf3, from, url, cover, valueOf4, valueOf5, valueOf6, valueOf7, process0Urls, play3sUrls, play5sUrls, play10sUrls, play15sUrls, (List) null, (List) null, (List) null, (List) null, 0, 0, 0, 0, (AdVideoEndPage) null, (String) null, 0, 0, 0, 0, (List) destination$iv$iv, 536838144, (DefaultConstructorMarker) null);
    }

    private static final AdFeedbackPanel transform(KAdFeedbackPanelDto $this$transform) {
        String panelTypeText = $this$transform.getPanelTypeText();
        String toast = $this$transform.getToast();
        String closeRecTips = $this$transform.getCloseRecTips();
        String openRecTips = $this$transform.getOpenRecTips();
        Iterable $this$map$iv = $this$transform.getFeedbackPanelDetail();
        boolean z = false;
        int i = 10;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        Iterable $this$mapTo$iv$iv = $this$map$iv;
        for (Object item$iv$iv : $this$mapTo$iv$iv) {
            KAdFeedbackPanelModuleDto panel = (KAdFeedbackPanelModuleDto) item$iv$iv;
            int moduleId = panel.getModuleId();
            String iconUrl = panel.getIconUrl();
            int jumpType = panel.getJumpType();
            String jumpUrl = panel.getJumpUrl();
            String text = panel.getText();
            String subText = panel.getSubText();
            Iterable secondaryPanel = panel.getSecondaryPanel();
            Iterable $this$map$iv2 = $this$map$iv;
            boolean z2 = z;
            int $i$f$map = CollectionsKt.collectionSizeOrDefault(secondaryPanel, i);
            Collection destination$iv$iv2 = new ArrayList($i$f$map);
            Iterable $this$mapTo$iv$iv2 = secondaryPanel;
            for (Object item$iv$iv2 : $this$mapTo$iv$iv2) {
                KAdSecondFeedbackPanelDto secondaryPanel2 = (KAdSecondFeedbackPanelDto) item$iv$iv2;
                destination$iv$iv2.add(new AdFeedbackPanel.SecondaryPanel(secondaryPanel2.getReasonId(), secondaryPanel2.getText()));
                $this$mapTo$iv$iv2 = $this$mapTo$iv$iv2;
                $this$mapTo$iv$iv = $this$mapTo$iv$iv;
            }
            destination$iv$iv.add(new AdFeedbackPanel.Panel(moduleId, iconUrl, jumpType, jumpUrl, text, subText, (List) destination$iv$iv2));
            $this$map$iv = $this$map$iv2;
            z = z2;
            i = 10;
        }
        return new AdFeedbackPanel(panelTypeText, toast, closeRecTips, openRecTips, (List) destination$iv$iv);
    }

    private static final AdQualityInfo transform(KQualityInfo $this$transform) {
        return new AdQualityInfo($this$transform.getIcon(), $this$transform.getText(), $this$transform.isBg(), $this$transform.getBgColor(), $this$transform.getBgColorNight(), $this$transform.getTextColor(), $this$transform.getTextColorNight(), $this$transform.getUserFaces(), $this$transform.getIconNight(), $this$transform.getBorderColor(), $this$transform.getBorderColorNight(), $this$transform.getBgStyle());
    }

    private static final AdVer transform(KAdverDto $this$transform) {
        return new AdVer($this$transform.getAdverDesc(), $this$transform.getAdverId(), $this$transform.getAdverLogo(), $this$transform.getAdverName(), $this$transform.getAdverPageUrl(), $this$transform.getAdverType());
    }

    private static final AdSubCardModule transform(KSubCardModule $this$transform) {
        String subcardType = $this$transform.getSubcardType();
        String icon = $this$transform.getIcon();
        String nightIcon = $this$transform.getNightIcon();
        String avatar = $this$transform.getAvatar();
        String title = $this$transform.getTitle();
        String desc = $this$transform.getDesc();
        Iterable $this$map$iv = $this$transform.getTagInfos();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KTagInfo it = (KTagInfo) item$iv$iv;
            destination$iv$iv.add(transform(it));
        }
        return new AdSubCardModule(null, subcardType, icon, nightIcon, avatar, title, desc, (List) destination$iv$iv, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0L, null, null, null, null, null, null, 0L, null, null, -255, null);
    }

    private static final AdBulletin transform(KBulletin $this$transform) {
        return new AdBulletin($this$transform.getTagText(), $this$transform.getText());
    }

    private static final AdGift transform(KGift $this$transform) {
        return new AdGift($this$transform.getIcon(), $this$transform.getNightIcon(), $this$transform.getText(), $this$transform.getUrl());
    }

    private static final AdWxProgramInfo transform(KWxProgramInfo $this$transform) {
        return new AdWxProgramInfo($this$transform.getOrgId(), $this$transform.getName(), $this$transform.getPath());
    }

    private static final AdRcmdReasonStyle transform(KFeedsRcmdReasonStyle $this$transform) {
        return new AdRcmdReasonStyle($this$transform.getText(), $this$transform.getTextColor(), $this$transform.getTextColorNight(), $this$transform.getBorderColor(), $this$transform.getBorderColorNight(), $this$transform.getBgColor(), $this$transform.getBgColorNight(), (String) null, (String) null, 0, 0, 0, (String) null, 0, $this$transform.getBgStyle(), (String) null, (String) null, (String) null, (String) null, 507776, (DefaultConstructorMarker) null);
    }

    private static final AdXYZ transform(KNotClickableArea $this$transform) {
        return new AdXYZ($this$transform.getX(), $this$transform.getY(), $this$transform.getZ());
    }

    private static final AdForwardReply transform(KForwardReply $this$transform) {
        return new AdForwardReply(Long.valueOf($this$transform.getCommentId()), $this$transform.getMessage(), $this$transform.getHighlightText(), $this$transform.getHighlightPrefixIcon(), $this$transform.getCallupUrl(), $this$transform.getJumpUrl(), $this$transform.getJumpType(), $this$transform.getAuthorName(), $this$transform.getAuthorIcon());
    }

    private static final AdStoryGoods transform(KStoryAnchor $this$transform) {
        int type = $this$transform.getType();
        String title = $this$transform.getTitle();
        String desc = $this$transform.getDesc();
        KStoryCartIcon it = $this$transform.getStoryCartIcon();
        return new AdStoryGoods(type, title, desc, (String) null, (AdPrice) null, (List) null, (AdButton) null, 0L, it != null ? new AdStoryCartIcon(it.getIconUrl(), it.getIconText(), it.getIconTitle()) : null, (AdJkCart) null, 760, (DefaultConstructorMarker) null);
    }

    private static final AdCoverTopLeftBadge transform(KLeftCoverBadgeNewStyle $this$transform) {
        return new AdCoverTopLeftBadge($this$transform.getIconUrl(), $this$transform.getIconNightUrl(), $this$transform.getIconWidth(), $this$transform.getIconHeight());
    }

    private static final AdGameInfo transform(KGameInfo $this$transform) {
        return new AdGameInfo($this$transform.getGameLogo(), $this$transform.getGameName(), $this$transform.getGameDesc(), (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 504, (DefaultConstructorMarker) null);
    }

    private static final AdGameRank transform(KGameRank $this$transform) {
        return new AdGameRank($this$transform.getIconUrl(), $this$transform.getNightIconUrl(), $this$transform.getBkgDayColor(), $this$transform.getBkgNightColor(), $this$transform.getFontDayColor(), $this$transform.getFontNightColor(), $this$transform.getRankContent(), $this$transform.getRankLink());
    }

    private static final AdAppDownloadStyle transform(KAppDownloadStyle $this$transform) {
        return new AdAppDownloadStyle($this$transform.getStyle(), $this$transform.getTags(), $this$transform.getGuideText(), $this$transform.getHeadImgs(), $this$transform.getDetailImgs(), $this$transform.getDetailImgLayout(), $this$transform.getDetailText());
    }

    private static final AdAndroidGameInfo transform(KAndroidGamePageRes $this$transform) {
        AdGameGlanceModule adGameGlanceModule;
        AdGameQualityModule adGameQualityModule;
        AdGameScreenShotModule adGameScreenShotModule;
        AdGameDevIntroModule adGameDevIntroModule;
        AdGameLatestUpdateModule adGameLatestUpdateModule;
        AdGameGradeModule adGameGradeModule;
        AdGameScreenShotModule adGameScreenShotModule2;
        AdGameTagModule adGameTagModule;
        AdGameGradeModule adGameGradeModule2;
        AdGameCommentModule adGameCommentModule;
        AdGameBookAwardModule adGameBookAwardModule;
        List moduleSeq = $this$transform.getModuleSeq();
        String backgroundColor = $this$transform.getBackgroundColor();
        KModule1 module = $this$transform.getModule1();
        if (module != null) {
            String gameName = module.getGameName();
            String gameIcon = module.getGameIcon();
            String developerInputName = module.getDeveloperInputName();
            Iterable $this$map$iv = module.getTagList();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                KAndroidTag it = (KAndroidTag) item$iv$iv;
                destination$iv$iv.add(new AdGameGlanceModule.Tag(it.getType(), it.getText()));
                module = module;
            }
            adGameGlanceModule = new AdGameGlanceModule(true, gameName, gameIcon, developerInputName, (List) destination$iv$iv);
        } else {
            adGameGlanceModule = null;
        }
        KModule3 module2 = $this$transform.getModule3();
        if (module2 != null) {
            boolean display = module2.getDisplay();
            Iterable $this$map$iv2 = module2.getQualityParams();
            boolean z = false;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv2 : $this$map$iv2) {
                KQualityParmas it2 = (KQualityParmas) item$iv$iv2;
                destination$iv$iv2.add(new AdGameQualityInfo((float) it2.getGrade(), it2.getFirstLine(), it2.getSecondLine(), it2.getRankIcon(), it2.getQualityType()));
                $this$map$iv2 = $this$map$iv2;
                z = z;
            }
            adGameQualityModule = new AdGameQualityModule(display, (List) destination$iv$iv2);
        } else {
            adGameQualityModule = null;
        }
        KModule4 module3 = $this$transform.getModule4();
        AdGameGiftModule adGameGiftModule = module3 != null ? new AdGameGiftModule(module3.getDisplay(), module3.getGiftNum(), module3.getGiftName(), module3.getGiftIconNum(), module3.getIconUrls(), module3.getGiftInfoIds()) : null;
        KModule5 module4 = $this$transform.getModule5();
        AdGameSummaryModule adGameSummaryModule = module4 != null ? new AdGameSummaryModule(module4.getDisplay(), module4.getGameSummary()) : null;
        KModule6 module5 = $this$transform.getModule6();
        AdGameDescModule adGameDescModule = module5 != null ? new AdGameDescModule(module5.getDisplay(), module5.getGameDesc()) : null;
        KModule7 module6 = $this$transform.getModule7();
        if (module6 != null) {
            boolean z2 = false;
            boolean display2 = module6.getDisplay();
            Iterable $this$map$iv3 = module6.getScreenShots();
            boolean z3 = false;
            Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
            Iterable $this$mapTo$iv$iv = $this$map$iv3;
            for (Object item$iv$iv3 : $this$mapTo$iv$iv) {
                KScreenShots it3 = (KScreenShots) item$iv$iv3;
                destination$iv$iv3.add(new AdGameScreenShotModule.ScreenShot(it3.getUrl(), Integer.valueOf(it3.getHeight()), Integer.valueOf(it3.getWidth()), Integer.valueOf(it3.getSeq())));
                module6 = module6;
                z2 = z2;
                $this$map$iv3 = $this$map$iv3;
                z3 = z3;
                $this$mapTo$iv$iv = $this$mapTo$iv$iv;
            }
            Iterable $this$sortedBy$iv = (List) destination$iv$iv3;
            adGameScreenShotModule = new AdGameScreenShotModule(display2, CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: kntr.app.ad.common.AdMossExtKt$transform$lambda$14$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    AdGameScreenShotModule.ScreenShot it4 = (AdGameScreenShotModule.ScreenShot) t;
                    AdGameScreenShotModule.ScreenShot it5 = (AdGameScreenShotModule.ScreenShot) t2;
                    return ComparisonsKt.compareValues(it4.getSeq(), it5.getSeq());
                }
            }));
        } else {
            adGameScreenShotModule = null;
        }
        KModule8 module7 = $this$transform.getModule8();
        AdGameTagModule adGameTagModule2 = module7 != null ? new AdGameTagModule(module7.getDisplay(), module7.getTagList()) : null;
        KModule9 module8 = $this$transform.getModule9();
        AdGameDevIntroModule adGameDevIntroModule2 = module8 != null ? new AdGameDevIntroModule(module8.getDisplay(), module8.getDevIntroduction()) : null;
        KModule10 module9 = $this$transform.getModule10();
        AdGameLatestUpdateModule adGameLatestUpdateModule2 = module9 != null ? new AdGameLatestUpdateModule(module9.getDisplay(), module9.getLatestUpdate()) : null;
        KModule11 module10 = $this$transform.getModule11();
        if (module10 != null) {
            adGameDevIntroModule = adGameDevIntroModule2;
            adGameLatestUpdateModule = adGameLatestUpdateModule2;
            adGameGradeModule = new AdGameGradeModule(module10.getDisplay(), module10.getStarNumberList(), module10.getCommentStr(), (float) module10.getGrade());
        } else {
            adGameDevIntroModule = adGameDevIntroModule2;
            adGameLatestUpdateModule = adGameLatestUpdateModule2;
            adGameGradeModule = null;
        }
        KModule12 module11 = $this$transform.getModule12();
        if (module11 != null) {
            boolean display3 = module11.getDisplay();
            String commentNum = module11.getCommentNum();
            boolean showAllComment = module11.getShowAllComment();
            Iterable commentList = module11.getCommentList();
            adGameGradeModule2 = adGameGradeModule;
            Collection destination$iv$iv4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(commentList, 10));
            Iterable $this$mapTo$iv$iv2 = commentList;
            boolean z4 = false;
            for (Object item$iv$iv4 : $this$mapTo$iv$iv2) {
                KComment it4 = (KComment) item$iv$iv4;
                Long valueOf = Long.valueOf(it4.getGameBaseId());
                String userName = it4.getUserName();
                String userFace = it4.getUserFace();
                int userLevel = it4.getUserLevel();
                String commentNo = it4.getCommentNo();
                int grade = it4.getGrade();
                String content = it4.getContent();
                boolean z5 = z4;
                int $i$f$mapTo = it4.getUpCount();
                destination$iv$iv4.add(new AdGameCommentModule.Comment(valueOf, userName, userFace, userLevel, commentNo, grade, content, $i$f$mapTo));
                $this$mapTo$iv$iv2 = $this$mapTo$iv$iv2;
                z4 = z5;
                adGameScreenShotModule = adGameScreenShotModule;
                adGameTagModule2 = adGameTagModule2;
            }
            adGameScreenShotModule2 = adGameScreenShotModule;
            adGameTagModule = adGameTagModule2;
            adGameCommentModule = new AdGameCommentModule(display3, commentNum, showAllComment, (List) destination$iv$iv4);
        } else {
            adGameScreenShotModule2 = adGameScreenShotModule;
            adGameTagModule = adGameTagModule2;
            adGameGradeModule2 = adGameGradeModule;
            adGameCommentModule = null;
        }
        KModule13 module12 = $this$transform.getModule13();
        AdGameApkInfoModule adGameApkInfoModule = module12 != null ? new AdGameApkInfoModule(true, module12.getPkgSize(), module12.getAndroidPkgName(), module12.getCustomerService(), module12.getWebsite(), module12.getAuthority(), module12.getPrivacy(), module12.getDeveloperName(), module12.getUpdateTime(), module12.getGameVersion()) : null;
        KModule14 module13 = $this$transform.getModule14();
        if (module13 != null) {
            boolean display4 = module13.getDisplay();
            Iterable $this$map$iv4 = module13.getRewardList();
            Collection destination$iv$iv5 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv4, 10));
            for (Object item$iv$iv5 : $this$map$iv4) {
                KReward it5 = (KReward) item$iv$iv5;
                destination$iv$iv5.add(new AdGameBookAwardModule.BookAwardInfo(it5.getLevel(), it5.getTitle(), it5.getContent(), it5.getPic(), it5.getReach()));
                module13 = module13;
            }
            Iterable $this$sortedBy$iv2 = (List) destination$iv$iv5;
            adGameBookAwardModule = new AdGameBookAwardModule(display4, CollectionsKt.sortedWith($this$sortedBy$iv2, new Comparator() { // from class: kntr.app.ad.common.AdMossExtKt$transform$lambda$21$$inlined$sortedBy$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    AdGameBookAwardModule.BookAwardInfo it6 = (AdGameBookAwardModule.BookAwardInfo) t;
                    AdGameBookAwardModule.BookAwardInfo it7 = (AdGameBookAwardModule.BookAwardInfo) t2;
                    return ComparisonsKt.compareValues(Integer.valueOf(it6.getLevel()), Integer.valueOf(it7.getLevel()));
                }
            }));
        } else {
            adGameBookAwardModule = null;
        }
        return new AdAndroidGameInfo(moduleSeq, backgroundColor, adGameGlanceModule, adGameQualityModule, adGameGiftModule, adGameSummaryModule, adGameDescModule, adGameScreenShotModule2, adGameTagModule, adGameDevIntroModule, adGameLatestUpdateModule, adGameGradeModule2, adGameCommentModule, adGameApkInfoModule, adGameBookAwardModule);
    }

    private static final AdTextBean transform(KText $this$transform) {
        return new AdTextBean($this$transform.getText(), $this$transform.getDayColor(), $this$transform.getNightColor(), $this$transform.getFontSize(), $this$transform.getTextDecoration(), 0.0f, (String) null, 0.0f, 0.0f, 480, (DefaultConstructorMarker) null);
    }
}