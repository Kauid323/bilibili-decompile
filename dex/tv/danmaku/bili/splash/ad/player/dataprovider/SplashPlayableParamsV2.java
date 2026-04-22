package tv.danmaku.bili.splash.ad.player.dataprovider;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.biliplayerv2.service.Video;
import tv.danmaku.video.resolver.UrlResolveParams;

/* compiled from: SplashPlayableParamsV2.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Ltv/danmaku/bili/splash/ad/player/dataprovider/SplashPlayableParamsV2;", "Ltv/danmaku/biliplayerv2/service/Video$PlayableParams;", "cid", "", "avid", "localVideoUri", "", "<init>", "(JJLjava/lang/String;)V", "getCid", "()J", "getAvid", "getLocalVideoUri", "()Ljava/lang/String;", "id", "getDisplayParams", "Ltv/danmaku/biliplayerv2/service/Video$DisplayParams;", "getFeedbackParams", "Ltv/danmaku/biliplayerv2/service/Video$FeedbackParams;", "getReportCommonParams", "Ltv/danmaku/biliplayerv2/service/Video$ReportCommonParams;", "getResolveParams", "Ltv/danmaku/video/resolver/UrlResolveParams;", "getLogDescription", "splashwidget_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashPlayableParamsV2 extends Video.PlayableParams {
    public static final int $stable = 8;
    private final long avid;
    private final long cid;
    private final String localVideoUri;

    public SplashPlayableParamsV2(long cid, long avid, String localVideoUri) {
        Intrinsics.checkNotNullParameter(localVideoUri, "localVideoUri");
        this.cid = cid;
        this.avid = avid;
        this.localVideoUri = localVideoUri;
        setFrom("downloaded");
        setFromAutoPlay(99);
        setSpmid(BusinessSplashDefineKt.SPLASH_SPMID);
        setFromSpmid(BusinessSplashDefineKt.SPLASH_SPMID);
    }

    public final long getCid() {
        return this.cid;
    }

    public final long getAvid() {
        return this.avid;
    }

    public final String getLocalVideoUri() {
        return this.localVideoUri;
    }

    public String id() {
        return String.valueOf(this.cid);
    }

    public Video.DisplayParams getDisplayParams() {
        Video.DisplayParams $this$getDisplayParams_u24lambda_u240 = new Video.DisplayParams();
        $this$getDisplayParams_u24lambda_u240.setFrom("downloaded");
        $this$getDisplayParams_u24lambda_u240.setCid(this.cid);
        $this$getDisplayParams_u24lambda_u240.setAvid(this.avid);
        return $this$getDisplayParams_u24lambda_u240;
    }

    public Video.FeedbackParams getFeedbackParams() {
        Video.FeedbackParams $this$getFeedbackParams_u24lambda_u240 = new Video.FeedbackParams();
        $this$getFeedbackParams_u24lambda_u240.setCId(this.cid);
        $this$getFeedbackParams_u24lambda_u240.setAId(this.avid);
        $this$getFeedbackParams_u24lambda_u240.setSpmid(BusinessSplashDefineKt.SPLASH_SPMID);
        $this$getFeedbackParams_u24lambda_u240.setFromSpmid(BusinessSplashDefineKt.SPLASH_SPMID);
        return $this$getFeedbackParams_u24lambda_u240;
    }

    public Video.ReportCommonParams getReportCommonParams() {
        Video.ReportCommonParams $this$getReportCommonParams_u24lambda_u240 = new Video.ReportCommonParams();
        $this$getReportCommonParams_u24lambda_u240.setCid(this.cid);
        $this$getReportCommonParams_u24lambda_u240.setAvid(this.avid);
        $this$getReportCommonParams_u24lambda_u240.setSpmid(BusinessSplashDefineKt.SPLASH_SPMID);
        $this$getReportCommonParams_u24lambda_u240.setFromSpmid(BusinessSplashDefineKt.SPLASH_SPMID);
        $this$getReportCommonParams_u24lambda_u240.setFromAutoPlay(99);
        return $this$getReportCommonParams_u24lambda_u240;
    }

    public UrlResolveParams getResolveParams() {
        UrlResolveParams $this$getResolveParams_u24lambda_u240 = new UrlResolveParams();
        $this$getResolveParams_u24lambda_u240.setUrl(this.localVideoUri);
        return $this$getResolveParams_u24lambda_u240;
    }

    public String getLogDescription() {
        return "[Splash]SplashPlayableParamsV2";
    }
}