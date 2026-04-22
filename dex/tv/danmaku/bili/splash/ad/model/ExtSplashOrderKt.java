package tv.danmaku.bili.splash.ad.model;

import com.bilibili.adcommon.data.AdReportInfo;
import com.bilibili.adcommon.data.IAdInfo;
import com.bilibili.adcommon.data.IClickInfo;
import com.bilibili.adcommon.data.model.FeedExtra;
import com.bilibili.app.comm.list.common.utils.ListDeviceInfoKt;
import com.bilibili.app.comm.realtime.RealTime;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.utils.BusinessSplashResHelperKt;
import tv.danmaku.bili.splash.ad.utils.SplashConfigKt;
import tv.danmaku.bili.ui.main2.mine.modularvip.MineVipServiceKt;

/* compiled from: ExtSplashOrder.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u001e\u001a\u0004\u0018\u00010\u001f*\u00020\u0002H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0003\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0003\"\u001a\u0010\u0007\u001a\u00020\u0001*\u0004\u0018\u00010\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0003\"\u0018\u0010\b\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0003\"\u0018\u0010\t\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0003\"\u0018\u0010\n\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0003\"\u0018\u0010\u000b\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0003\"\u0018\u0010\f\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0003\"\u0018\u0010\r\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0003\"\u0018\u0010\u000e\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0003\"\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0003\"\u0018\u0010\u0011\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0003\"\u0018\u0010\u0012\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0003\"\u0018\u0010\u0013\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0003\"\u0018\u0010\u0014\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0003\"\u0018\u0010\u0015\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0003\"\u0018\u0010\u0016\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0003\"\u0018\u0010\u0018\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0003\"\u0018\u0010\u0019\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0003\"\u0018\u0010\u001a\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0003\"\u0018\u0010\u001c\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0003\"\u0018\u0010\u001d\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0003¨\u0006 "}, d2 = {"isEncrypted", "", "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "(Ltv/danmaku/bili/splash/ad/model/SplashOrder;)Z", "isTopView", "hasTopViewLinkedCard", "getHasTopViewLinkedCard", "isEggSplash", "isVideo", "isOnlyVideoSplash", "isOnlyImageSplash", "isImageVideoMixCardType", "isBannerSplash", "isCardTypeSupport", "isInteractSupport", "needPrepare", "getNeedPrepare", "isSkipDefault", "isSkipSizeExp", "isFullScreen", "isTimeValid", "isSearchLinkage", "hasTopViewResInfo", "getHasTopViewResInfo", "isMainResourceReady", "isMiddlePageSplash", "hasSecondPageEggVideo", "getHasSecondPageEggVideo", "isTopViewTransitionType", "isSplashClickable", "adInfo", "Lcom/bilibili/adcommon/data/IAdInfo;", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ExtSplashOrderKt {
    public static final boolean isEncrypted(SplashOrder $this$isEncrypted) {
        Intrinsics.checkNotNullParameter($this$isEncrypted, "<this>");
        return $this$isEncrypted.getEncryption() == 1;
    }

    public static final boolean isTopView(SplashOrder $this$isTopView) {
        Intrinsics.checkNotNullParameter($this$isTopView, "<this>");
        return $this$isTopView.getType() == 4;
    }

    public static final boolean getHasTopViewLinkedCard(SplashOrder $this$hasTopViewLinkedCard) {
        Intrinsics.checkNotNullParameter($this$hasTopViewLinkedCard, "<this>");
        return isTopView($this$hasTopViewLinkedCard) && $this$hasTopViewLinkedCard.getTopViewLoc() == 1;
    }

    public static final boolean isEggSplash(SplashOrder $this$isEggSplash) {
        SplashEgg $this$_get_isEggSplash__u24lambda_u240;
        if ($this$isEggSplash == null || !isTopView($this$isEggSplash) || $this$isEggSplash.getTopViewType() != SplashTopViewType.EGG.getType()) {
            return false;
        }
        SplashEgg $this$_get_isEggSplash__u24lambda_u2402 = $this$isEggSplash.getSplashEgg();
        if ($this$_get_isEggSplash__u24lambda_u2402 != null) {
            String videoHash = $this$_get_isEggSplash__u24lambda_u2402.getVideoHash();
            if (!(videoHash == null || StringsKt.isBlank(videoHash))) {
                String videoUrl = $this$_get_isEggSplash__u24lambda_u2402.getVideoUrl();
                if (!(videoUrl == null || StringsKt.isBlank(videoUrl)) && $this$_get_isEggSplash__u24lambda_u2402.getDuration() > 0) {
                    $this$_get_isEggSplash__u24lambda_u240 = 1;
                }
            }
            $this$_get_isEggSplash__u24lambda_u240 = null;
        } else {
            $this$_get_isEggSplash__u24lambda_u240 = null;
        }
        return $this$_get_isEggSplash__u24lambda_u240 != null;
    }

    public static final boolean isVideo(SplashOrder $this$isVideo) {
        Intrinsics.checkNotNullParameter($this$isVideo, "<this>");
        return SplashCardTypeKt.isVideoSplashCardType($this$isVideo.getCardType());
    }

    public static final boolean isOnlyVideoSplash(SplashOrder $this$isOnlyVideoSplash) {
        Intrinsics.checkNotNullParameter($this$isOnlyVideoSplash, "<this>");
        return SplashCardTypeKt.isOnlyVideoSplash($this$isOnlyVideoSplash.getCardType()) && !ListDeviceInfoKt.isHdApp();
    }

    public static final boolean isOnlyImageSplash(SplashOrder $this$isOnlyImageSplash) {
        Intrinsics.checkNotNullParameter($this$isOnlyImageSplash, "<this>");
        return SplashCardTypeKt.isImageSplashCardType($this$isOnlyImageSplash.getCardType());
    }

    public static final boolean isImageVideoMixCardType(SplashOrder $this$isImageVideoMixCardType) {
        Intrinsics.checkNotNullParameter($this$isImageVideoMixCardType, "<this>");
        return SplashCardTypeKt.isImageWithVideoCardType($this$isImageVideoMixCardType.getCardType()) || (ListDeviceInfoKt.isHdApp() && isVideo($this$isImageVideoMixCardType));
    }

    public static final boolean isBannerSplash(SplashOrder $this$isBannerSplash) {
        Intrinsics.checkNotNullParameter($this$isBannerSplash, "<this>");
        return $this$isBannerSplash.getCardType() == 152;
    }

    public static final boolean isCardTypeSupport(SplashOrder $this$isCardTypeSupport) {
        Intrinsics.checkNotNullParameter($this$isCardTypeSupport, "<this>");
        return SplashCardTypeKt.isSupportedSplashCardType($this$isCardTypeSupport.getCardType());
    }

    public static final boolean isInteractSupport(SplashOrder $this$isInteractSupport) {
        Intrinsics.checkNotNullParameter($this$isInteractSupport, "<this>");
        return $this$isInteractSupport.getInteractType() == 1;
    }

    public static final boolean getNeedPrepare(SplashOrder $this$needPrepare) {
        Intrinsics.checkNotNullParameter($this$needPrepare, "<this>");
        return SplashConfigKt.getSplashPrepareEnable() && isVideo($this$needPrepare) && !$this$needPrepare.getRuntimeExtra().isHotSplash();
    }

    public static final boolean isSkipDefault(SplashOrder $this$isSkipDefault) {
        Intrinsics.checkNotNullParameter($this$isSkipDefault, "<this>");
        return $this$isSkipDefault.getMarkWithSkipStyle() == 0;
    }

    public static final boolean isSkipSizeExp(SplashOrder $this$isSkipSizeExp) {
        Intrinsics.checkNotNullParameter($this$isSkipSizeExp, "<this>");
        return $this$isSkipSizeExp.getMarkWithSkipStyle() == 1;
    }

    public static final boolean isFullScreen(SplashOrder $this$isFullScreen) {
        Intrinsics.checkNotNullParameter($this$isFullScreen, "<this>");
        return SplashCardTypeKt.isFullScreenCardType($this$isFullScreen.getCardType());
    }

    public static final boolean isTimeValid(SplashOrder $this$isTimeValid) {
        Intrinsics.checkNotNullParameter($this$isTimeValid, "<this>");
        if (isEncrypted($this$isTimeValid)) {
            long realTime = RealTime.getCredibleTime();
            if (realTime <= 0 && RealTime.needForceSyncTime()) {
                realTime = RealTime.forceUpdateSync();
            }
            return realTime <= $this$isTimeValid.getEndTime() && $this$isTimeValid.getBeginTime() <= realTime;
        }
        long currentTime = System.currentTimeMillis() / 1000;
        return currentTime <= $this$isTimeValid.getEndTime() && $this$isTimeValid.getBeginTime() <= currentTime;
    }

    public static final boolean isSearchLinkage(SplashOrder $this$isSearchLinkage) {
        Intrinsics.checkNotNullParameter($this$isSearchLinkage, "<this>");
        String keyword = $this$isSearchLinkage.getKeyword();
        return !(keyword == null || StringsKt.isBlank(keyword));
    }

    public static final boolean getHasTopViewResInfo(SplashOrder $this$hasTopViewResInfo) {
        Intrinsics.checkNotNullParameter($this$hasTopViewResInfo, "<this>");
        if ($this$hasTopViewResInfo.getExtra() == null) {
            return false;
        }
        JsonElement jsonElement = $this$hasTopViewResInfo.getExtra().get("topview_pic_url");
        String picUrl = jsonElement != null ? jsonElement.getAsString() : null;
        JsonElement jsonElement2 = $this$hasTopViewResInfo.getExtra().get("topview_video_url");
        String videoUrl = jsonElement2 != null ? jsonElement2.getAsString() : null;
        String str = picUrl;
        if (str == null || StringsKt.isBlank(str)) {
            String str2 = videoUrl;
            if (str2 == null || StringsKt.isBlank(str2)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isMainResourceReady(SplashOrder $this$isMainResourceReady) {
        Intrinsics.checkNotNullParameter($this$isMainResourceReady, "<this>");
        return isImageVideoMixCardType($this$isMainResourceReady) ? (BusinessSplashResHelperKt.fetchResourceFileByHash($this$isMainResourceReady.getImageHash()) == null || BusinessSplashResHelperKt.fetchResourceFileByHash($this$isMainResourceReady.getVideoHash()) == null) ? false : true : isOnlyVideoSplash($this$isMainResourceReady) ? BusinessSplashResHelperKt.fetchResourceFileByHash($this$isMainResourceReady.getVideoHash()) != null : isOnlyImageSplash($this$isMainResourceReady) && BusinessSplashResHelperKt.fetchResourceFileByHash($this$isMainResourceReady.getImageHash()) != null;
    }

    public static final boolean isMiddlePageSplash(SplashOrder $this$isMiddlePageSplash) {
        Intrinsics.checkNotNullParameter($this$isMiddlePageSplash, "<this>");
        return $this$isMiddlePageSplash.getCardType() == 39 && $this$isMiddlePageSplash.getMiddlePageInfo() != null && $this$isMiddlePageSplash.getSecondPageShowStyle() == 2;
    }

    public static final boolean getHasSecondPageEggVideo(SplashOrder $this$hasSecondPageEggVideo) {
        String secondVideoUrl;
        Intrinsics.checkNotNullParameter($this$hasSecondPageEggVideo, "<this>");
        if ($this$hasSecondPageEggVideo.getSecondPageShowStyle() == 3) {
            SplashSecondPageInfo secondPage = $this$hasSecondPageEggVideo.getSecondPage();
            return (secondPage != null && (secondVideoUrl = secondPage.getSecondVideoUrl()) != null && (StringsKt.isBlank(secondVideoUrl) ^ true)) && !StringsKt.isBlank($this$hasSecondPageEggVideo.getSecondPage().getSecondVideoHash());
        }
        return false;
    }

    public static final boolean isTopViewTransitionType(SplashOrder $this$isTopViewTransitionType) {
        Intrinsics.checkNotNullParameter($this$isTopViewTransitionType, "<this>");
        return $this$isTopViewTransitionType.getTopViewType() == SplashTopViewType.TRANSITION.getType();
    }

    public static final boolean isSplashClickable(SplashOrder $this$isSplashClickable) {
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter($this$isSplashClickable, "<this>");
        JsonObject extra = $this$isSplashClickable.getExtra();
        return (extra == null || (jsonElement = extra.get(MineVipServiceKt.VIP_REPORT_KEY_CLICK_AREA)) == null || jsonElement.getAsInt() != 1) ? false : true;
    }

    public static final IAdInfo adInfo(final SplashOrder $this$adInfo) {
        IAdInfo iAdInfo;
        Intrinsics.checkNotNullParameter($this$adInfo, "<this>");
        SplashExtra runtimeExtra = $this$adInfo.getRuntimeExtra();
        if ($this$adInfo.getRuntimeExtra().getAdInfoData() != null) {
            iAdInfo = $this$adInfo.getRuntimeExtra().getAdInfoData();
        } else {
            iAdInfo = new IAdInfo() { // from class: tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt$adInfo$1
                private FeedExtra adExtra;
                private AdReportInfo reportInfo;

                /* renamed from: getReportInfo */
                public AdReportInfo m1408getReportInfo() {
                    return new AdReportInfo.Builder(SplashOrder.this.isAdLoc()).isAd(SplashOrder.this.isAd()).adcb(SplashOrder.this.getAdCb()).srcId(SplashOrder.this.getSource()).adIndex(SplashOrder.this.getIndex()).ip(SplashOrder.this.getIp()).serverType(SplashOrder.this.getServerType()).resourceId(SplashOrder.this.getResourceId()).id(SplashOrder.this.getId()).cardIndex(SplashOrder.this.getCardIndex()).cardType((String) null).cmMark(SplashOrder.this.getCmMark()).requestId(SplashOrder.this.getRequestId()).creativeId(SplashOrder.this.getId()).creativeType(0L).extra(getAdExtra()).build();
                }

                private final FeedExtra getAdExtra() {
                    if (this.adExtra == null) {
                        try {
                            this.adExtra = (FeedExtra) new Gson().fromJson(SplashOrder.this.getExtra(), FeedExtra.class);
                        } catch (Exception e) {
                        }
                    }
                    return this.adExtra;
                }

                public IClickInfo getClickInfo() {
                    return getAdExtra();
                }
            };
        }
        runtimeExtra.setAdInfoData(iAdInfo);
        return $this$adInfo.getRuntimeExtra().getAdInfoData();
    }
}