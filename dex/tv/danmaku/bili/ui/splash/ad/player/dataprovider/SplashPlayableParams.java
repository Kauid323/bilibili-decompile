package tv.danmaku.bili.ui.splash.ad.player.dataprovider;

import com.bilibili.lib.media.resolver2.IResolveParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.ui.splash.ad.config.SplashConstantKt;
import tv.danmaku.bili.ui.splash.ad.model.Splash;
import tv.danmaku.bili.ui.splash.ad.model.SplashVideoInfo;
import tv.danmaku.bili.ui.splash.ad.util.BusinessSplashResHelperKt;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.video.resolver.UrlResolveParams;

/* compiled from: SplashPlayableParams.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/splash/ad/player/dataprovider/SplashPlayableParams;", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "splash", "Ltv/danmaku/bili/ui/splash/ad/model/Splash;", "<init>", "(Ltv/danmaku/bili/ui/splash/ad/model/Splash;)V", "getLogDescription", "", "id", "getDisplayParams", "Ltv/danmaku/biliplayerv2/service/Video$DisplayParams;", "getFeedbackParams", "Ltv/danmaku/biliplayerv2/service/Video$FeedbackParams;", "getReportCommonParams", "Ltv/danmaku/biliplayerv2/service/Video$ReportCommonParams;", "getResolveParams", "Lcom/bilibili/lib/media/resolver2/IResolveParams;", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashPlayableParams extends Video.PlayableParams {
    public static final int $stable = 8;
    private final Splash splash;

    public SplashPlayableParams(Splash splash) {
        Intrinsics.checkNotNullParameter(splash, "splash");
        this.splash = splash;
        setFrom("downloaded");
        setFromAutoPlay(99);
        setSpmid(SplashConstantKt.SPLASH_SPMID);
        setFromSpmid(SplashConstantKt.SPLASH_SPMID);
    }

    @Override // tv.danmaku.biliplayerv2.service.Video.PlayableParams
    public String getLogDescription() {
        return "[Splash]SplashPlayableParams";
    }

    @Override // tv.danmaku.biliplayerv2.service.Video.PlayableParams
    public String id() {
        SplashVideoInfo splashVideoInfo = this.splash.splashStoryInfo;
        return String.valueOf(splashVideoInfo != null ? splashVideoInfo.getCid() : 0L);
    }

    @Override // tv.danmaku.biliplayerv2.service.Video.PlayableParams
    public Video.DisplayParams getDisplayParams() {
        Video.DisplayParams params = new Video.DisplayParams();
        params.setFrom("downloaded");
        SplashVideoInfo splashVideoInfo = this.splash.splashStoryInfo;
        params.setAvid(splashVideoInfo != null ? splashVideoInfo.getAvid() : 0L);
        SplashVideoInfo splashVideoInfo2 = this.splash.splashStoryInfo;
        params.setCid(splashVideoInfo2 != null ? splashVideoInfo2.getCid() : 0L);
        return params;
    }

    @Override // tv.danmaku.biliplayerv2.service.Video.PlayableParams
    public Video.FeedbackParams getFeedbackParams() {
        Video.FeedbackParams $this$getFeedbackParams_u24lambda_u240 = new Video.FeedbackParams();
        SplashVideoInfo splashVideoInfo = this.splash.splashStoryInfo;
        $this$getFeedbackParams_u24lambda_u240.setCId(splashVideoInfo != null ? splashVideoInfo.getCid() : 0L);
        SplashVideoInfo splashVideoInfo2 = this.splash.splashStoryInfo;
        $this$getFeedbackParams_u24lambda_u240.setAId(splashVideoInfo2 != null ? splashVideoInfo2.getAvid() : 0L);
        $this$getFeedbackParams_u24lambda_u240.setSpmid(SplashConstantKt.SPLASH_SPMID);
        $this$getFeedbackParams_u24lambda_u240.setFromSpmid(SplashConstantKt.SPLASH_SPMID);
        return $this$getFeedbackParams_u24lambda_u240;
    }

    @Override // tv.danmaku.biliplayerv2.service.Video.PlayableParams
    public Video.ReportCommonParams getReportCommonParams() {
        Video.ReportCommonParams $this$getReportCommonParams_u24lambda_u240 = new Video.ReportCommonParams();
        SplashVideoInfo splashVideoInfo = this.splash.splashStoryInfo;
        $this$getReportCommonParams_u24lambda_u240.setCid(splashVideoInfo != null ? splashVideoInfo.getCid() : 0L);
        SplashVideoInfo splashVideoInfo2 = this.splash.splashStoryInfo;
        $this$getReportCommonParams_u24lambda_u240.setAvid(splashVideoInfo2 != null ? splashVideoInfo2.getAvid() : 0L);
        $this$getReportCommonParams_u24lambda_u240.setSpmid(SplashConstantKt.SPLASH_SPMID);
        $this$getReportCommonParams_u24lambda_u240.setFromSpmid(SplashConstantKt.SPLASH_SPMID);
        $this$getReportCommonParams_u24lambda_u240.setFromAutoPlay(99);
        return $this$getReportCommonParams_u24lambda_u240;
    }

    @Override // tv.danmaku.biliplayerv2.service.Video.PlayableParams
    public IResolveParams getResolveParams() {
        UrlResolveParams $this$getResolveParams_u24lambda_u240 = new UrlResolveParams();
        $this$getResolveParams_u24lambda_u240.setUrl(BusinessSplashResHelperKt.md5ToFileUri(this.splash.videoHash));
        return $this$getResolveParams_u24lambda_u240;
    }
}