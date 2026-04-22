package tv.danmaku.bili.splash.ad.player.dataprovider;

import com.bilibili.lib.media.resolver2.IResolveParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.model.SplashVideoInfo;
import tv.danmaku.bili.splash.ad.utils.BusinessSplashResHelperKt;
import tv.danmaku.bili.ui.main2.userprotocol.UserProtocolHelper;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.video.resolver.UrlResolveParams;

/* compiled from: SplashPlayableParams.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/splash/ad/player/dataprovider/SplashPlayableParams;", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH, "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "<init>", "(Ltv/danmaku/bili/splash/ad/model/SplashOrder;)V", "getLogDescription", "", "id", "getDisplayParams", "Ltv/danmaku/biliplayerv2/service/Video$DisplayParams;", "getFeedbackParams", "Ltv/danmaku/biliplayerv2/service/Video$FeedbackParams;", "getReportCommonParams", "Ltv/danmaku/biliplayerv2/service/Video$ReportCommonParams;", "getResolveParams", "Lcom/bilibili/lib/media/resolver2/IResolveParams;", "adsplash_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashPlayableParams extends Video.PlayableParams {
    public static final int $stable = 8;
    private final SplashOrder splash;

    public SplashPlayableParams(SplashOrder splash) {
        Intrinsics.checkNotNullParameter(splash, UserProtocolHelper.UserDialogDismissWatcher.FROM_SPLASH);
        this.splash = splash;
        setFrom("downloaded");
        setFromAutoPlay(99);
        setSpmid(BusinessSplashDefineKt.SPLASH_SPMID);
        setFromSpmid(BusinessSplashDefineKt.SPLASH_SPMID);
    }

    public String getLogDescription() {
        return "[Splash]SplashPlayableParams";
    }

    public String id() {
        SplashVideoInfo splashStoryInfo = this.splash.getSplashStoryInfo();
        return String.valueOf(splashStoryInfo != null ? splashStoryInfo.getCid() : 0L);
    }

    public Video.DisplayParams getDisplayParams() {
        Video.DisplayParams params = new Video.DisplayParams();
        params.setFrom("downloaded");
        SplashVideoInfo splashStoryInfo = this.splash.getSplashStoryInfo();
        params.setAvid(splashStoryInfo != null ? splashStoryInfo.getAvid() : 0L);
        SplashVideoInfo splashStoryInfo2 = this.splash.getSplashStoryInfo();
        params.setCid(splashStoryInfo2 != null ? splashStoryInfo2.getCid() : 0L);
        return params;
    }

    public Video.FeedbackParams getFeedbackParams() {
        Video.FeedbackParams $this$getFeedbackParams_u24lambda_u240 = new Video.FeedbackParams();
        SplashVideoInfo splashStoryInfo = this.splash.getSplashStoryInfo();
        $this$getFeedbackParams_u24lambda_u240.setCId(splashStoryInfo != null ? splashStoryInfo.getCid() : 0L);
        SplashVideoInfo splashStoryInfo2 = this.splash.getSplashStoryInfo();
        $this$getFeedbackParams_u24lambda_u240.setAId(splashStoryInfo2 != null ? splashStoryInfo2.getAvid() : 0L);
        $this$getFeedbackParams_u24lambda_u240.setSpmid(BusinessSplashDefineKt.SPLASH_SPMID);
        $this$getFeedbackParams_u24lambda_u240.setFromSpmid(BusinessSplashDefineKt.SPLASH_SPMID);
        return $this$getFeedbackParams_u24lambda_u240;
    }

    public Video.ReportCommonParams getReportCommonParams() {
        Video.ReportCommonParams $this$getReportCommonParams_u24lambda_u240 = new Video.ReportCommonParams();
        SplashVideoInfo splashStoryInfo = this.splash.getSplashStoryInfo();
        $this$getReportCommonParams_u24lambda_u240.setCid(splashStoryInfo != null ? splashStoryInfo.getCid() : 0L);
        SplashVideoInfo splashStoryInfo2 = this.splash.getSplashStoryInfo();
        $this$getReportCommonParams_u24lambda_u240.setAvid(splashStoryInfo2 != null ? splashStoryInfo2.getAvid() : 0L);
        $this$getReportCommonParams_u24lambda_u240.setSpmid(BusinessSplashDefineKt.SPLASH_SPMID);
        $this$getReportCommonParams_u24lambda_u240.setFromSpmid(BusinessSplashDefineKt.SPLASH_SPMID);
        $this$getReportCommonParams_u24lambda_u240.setFromAutoPlay(99);
        return $this$getReportCommonParams_u24lambda_u240;
    }

    public IResolveParams getResolveParams() {
        IResolveParams urlResolveParams = new UrlResolveParams();
        urlResolveParams.setUrl(BusinessSplashResHelperKt.fetchResourceLocalUriPathByHash(this.splash.getVideoHash()));
        return urlResolveParams;
    }
}