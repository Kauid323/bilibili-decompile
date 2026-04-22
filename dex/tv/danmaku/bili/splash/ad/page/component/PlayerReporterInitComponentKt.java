package tv.danmaku.bili.splash.ad.page.component;

import android.media.MediaPlayer;
import com.bilibili.adcommon.data.IAdInfo;
import com.bilibili.adcommon.data.IAdReportInfo;
import com.bilibili.adcommon.data.model.Card;
import com.bilibili.adcommon.data.model.FeedExtra;
import com.bilibili.adcommon.data.model.VideoBean;
import com.bilibili.gripper.api.ad.core.GAdCoreKt;
import com.bilibili.gripper.api.ad.core.GAdPlayer;
import com.bilibili.gripper.api.ad.core.player.report.AdVideoInfo;
import com.bilibili.gripper.api.ad.core.player.report.IPlayerReportTracker;
import com.bilibili.gripper.api.ad.core.player.report.PlayerProgress;
import com.bilibili.gripper.api.ad.core.player.report.PlayerReportFrom;
import com.bilibili.gripper.api.ad.core.player.report.VideoExtKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.splash.ad.model.ExtSplashOrderKt;
import tv.danmaku.bili.splash.ad.model.SplashOrder;
import tv.danmaku.bili.splash.ad.page.BaseSplash;
import tv.danmaku.bili.splash.ad.player.SplashBannerPlayer;
import tv.danmaku.bili.splash.ad.player.SplashCardPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: PlayerReporterInitComponent.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0000\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0000\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\tH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\n\u001a\u00020\u000b*\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"TAG", "", "initPlayerReporter", "", "Ltv/danmaku/bili/splash/ad/page/BaseSplash;", "player", "Landroid/media/MediaPlayer;", "Ltv/danmaku/ijk/media/player/IjkMediaPlayer;", "Ltv/danmaku/bili/splash/ad/player/SplashBannerPlayer;", "Ltv/danmaku/bili/splash/ad/player/SplashCardPlayer;", "adVideoInfo", "Lcom/bilibili/gripper/api/ad/core/player/report/AdVideoInfo;", "Ltv/danmaku/bili/splash/ad/model/SplashOrder;", "getAdVideoInfo", "(Ltv/danmaku/bili/splash/ad/model/SplashOrder;)Lcom/bilibili/gripper/api/ad/core/player/report/AdVideoInfo;", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class PlayerReporterInitComponentKt {
    private static final String TAG = "[Splash]PlayerReporterInitComponent";

    public static final void initPlayerReporter(BaseSplash $this$initPlayerReporter, final MediaPlayer player) {
        IPlayerReportTracker $this$initPlayerReporter_u24lambda_u241;
        IAdReportInfo reportInfo;
        Intrinsics.checkNotNullParameter($this$initPlayerReporter, "<this>");
        Intrinsics.checkNotNullParameter(player, "player");
        ComponentHolder componentHolder$adsplash_debug = $this$initPlayerReporter.getComponentHolder$adsplash_debug();
        IAdInfo adInfo = ExtSplashOrderKt.adInfo($this$initPlayerReporter.getSplash$adsplash_debug());
        if (adInfo != null && (reportInfo = adInfo.getReportInfo()) != null) {
            $this$initPlayerReporter_u24lambda_u241 = GAdPlayer.-CC.getVideoReportTracker$default(GAdCoreKt.getGAdPlayer(), $this$initPlayerReporter.getLifecycle(), PlayerReportFrom.SPLASH, reportInfo, (Map) null, (String) null, getAdVideoInfo($this$initPlayerReporter.getSplash$adsplash_debug()), 24, (Object) null);
            if ($this$initPlayerReporter_u24lambda_u241 != null) {
                $this$initPlayerReporter_u24lambda_u241.progressProvider(new Function0() { // from class: tv.danmaku.bili.splash.ad.page.component.PlayerReporterInitComponentKt$$ExternalSyntheticLambda3
                    public final Object invoke() {
                        PlayerProgress initPlayerReporter$lambda$1$0;
                        initPlayerReporter$lambda$1$0 = PlayerReporterInitComponentKt.initPlayerReporter$lambda$1$0(player);
                        return initPlayerReporter$lambda$1$0;
                    }
                });
                componentHolder$adsplash_debug.setPlayerReporter($this$initPlayerReporter_u24lambda_u241);
            }
        }
        $this$initPlayerReporter_u24lambda_u241 = null;
        componentHolder$adsplash_debug.setPlayerReporter($this$initPlayerReporter_u24lambda_u241);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlayerProgress initPlayerReporter$lambda$1$0(MediaPlayer $player) {
        try {
            return new PlayerProgress($player.getCurrentPosition(), $player.getDuration());
        } catch (Exception e) {
            BLog.i(TAG, "initPlayerReporter, media, " + e.getMessage());
            return new PlayerProgress(0L, 0L);
        }
    }

    public static final void initPlayerReporter(BaseSplash $this$initPlayerReporter, final IjkMediaPlayer player) {
        IPlayerReportTracker $this$initPlayerReporter_u24lambda_u243;
        IAdReportInfo reportInfo;
        Intrinsics.checkNotNullParameter($this$initPlayerReporter, "<this>");
        Intrinsics.checkNotNullParameter(player, "player");
        ComponentHolder componentHolder$adsplash_debug = $this$initPlayerReporter.getComponentHolder$adsplash_debug();
        IAdInfo adInfo = ExtSplashOrderKt.adInfo($this$initPlayerReporter.getSplash$adsplash_debug());
        if (adInfo != null && (reportInfo = adInfo.getReportInfo()) != null) {
            $this$initPlayerReporter_u24lambda_u243 = GAdPlayer.-CC.getVideoReportTracker$default(GAdCoreKt.getGAdPlayer(), $this$initPlayerReporter.getLifecycle(), PlayerReportFrom.SPLASH, reportInfo, (Map) null, (String) null, getAdVideoInfo($this$initPlayerReporter.getSplash$adsplash_debug()), 24, (Object) null);
            if ($this$initPlayerReporter_u24lambda_u243 != null) {
                $this$initPlayerReporter_u24lambda_u243.progressProvider(new Function0() { // from class: tv.danmaku.bili.splash.ad.page.component.PlayerReporterInitComponentKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        PlayerProgress initPlayerReporter$lambda$3$0;
                        initPlayerReporter$lambda$3$0 = PlayerReporterInitComponentKt.initPlayerReporter$lambda$3$0(player);
                        return initPlayerReporter$lambda$3$0;
                    }
                });
                componentHolder$adsplash_debug.setPlayerReporter($this$initPlayerReporter_u24lambda_u243);
            }
        }
        $this$initPlayerReporter_u24lambda_u243 = null;
        componentHolder$adsplash_debug.setPlayerReporter($this$initPlayerReporter_u24lambda_u243);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlayerProgress initPlayerReporter$lambda$3$0(IjkMediaPlayer $player) {
        return new PlayerProgress($player.getCurrentPosition(), $player.getDuration());
    }

    public static final void initPlayerReporter(BaseSplash $this$initPlayerReporter, final SplashBannerPlayer player) {
        IPlayerReportTracker $this$initPlayerReporter_u24lambda_u245;
        IAdReportInfo reportInfo;
        Intrinsics.checkNotNullParameter($this$initPlayerReporter, "<this>");
        Intrinsics.checkNotNullParameter(player, "player");
        ComponentHolder componentHolder$adsplash_debug = $this$initPlayerReporter.getComponentHolder$adsplash_debug();
        IAdInfo adInfo = ExtSplashOrderKt.adInfo($this$initPlayerReporter.getSplash$adsplash_debug());
        if (adInfo != null && (reportInfo = adInfo.getReportInfo()) != null) {
            $this$initPlayerReporter_u24lambda_u245 = GAdPlayer.-CC.getVideoReportTracker$default(GAdCoreKt.getGAdPlayer(), $this$initPlayerReporter.getLifecycle(), PlayerReportFrom.SPLASH, reportInfo, (Map) null, (String) null, getAdVideoInfo($this$initPlayerReporter.getSplash$adsplash_debug()), 24, (Object) null);
            if ($this$initPlayerReporter_u24lambda_u245 != null) {
                $this$initPlayerReporter_u24lambda_u245.progressProvider(new Function0() { // from class: tv.danmaku.bili.splash.ad.page.component.PlayerReporterInitComponentKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        PlayerProgress initPlayerReporter$lambda$5$0;
                        initPlayerReporter$lambda$5$0 = PlayerReporterInitComponentKt.initPlayerReporter$lambda$5$0(SplashBannerPlayer.this);
                        return initPlayerReporter$lambda$5$0;
                    }
                });
                componentHolder$adsplash_debug.setPlayerReporter($this$initPlayerReporter_u24lambda_u245);
            }
        }
        $this$initPlayerReporter_u24lambda_u245 = null;
        componentHolder$adsplash_debug.setPlayerReporter($this$initPlayerReporter_u24lambda_u245);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlayerProgress initPlayerReporter$lambda$5$0(SplashBannerPlayer $player) {
        return new PlayerProgress($player.getCurrentPosition(), $player.getDuration());
    }

    public static final void initPlayerReporter(BaseSplash $this$initPlayerReporter, final SplashCardPlayer player) {
        IPlayerReportTracker $this$initPlayerReporter_u24lambda_u247;
        IAdReportInfo reportInfo;
        Intrinsics.checkNotNullParameter($this$initPlayerReporter, "<this>");
        Intrinsics.checkNotNullParameter(player, "player");
        ComponentHolder componentHolder$adsplash_debug = $this$initPlayerReporter.getComponentHolder$adsplash_debug();
        IAdInfo adInfo = ExtSplashOrderKt.adInfo($this$initPlayerReporter.getSplash$adsplash_debug());
        if (adInfo != null && (reportInfo = adInfo.getReportInfo()) != null) {
            $this$initPlayerReporter_u24lambda_u247 = GAdPlayer.-CC.getVideoReportTracker$default(GAdCoreKt.getGAdPlayer(), $this$initPlayerReporter.getLifecycle(), PlayerReportFrom.SPLASH, reportInfo, (Map) null, (String) null, getAdVideoInfo($this$initPlayerReporter.getSplash$adsplash_debug()), 24, (Object) null);
            if ($this$initPlayerReporter_u24lambda_u247 != null) {
                $this$initPlayerReporter_u24lambda_u247.progressProvider(new Function0() { // from class: tv.danmaku.bili.splash.ad.page.component.PlayerReporterInitComponentKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        PlayerProgress initPlayerReporter$lambda$7$0;
                        initPlayerReporter$lambda$7$0 = PlayerReporterInitComponentKt.initPlayerReporter$lambda$7$0(SplashCardPlayer.this);
                        return initPlayerReporter$lambda$7$0;
                    }
                });
                componentHolder$adsplash_debug.setPlayerReporter($this$initPlayerReporter_u24lambda_u247);
            }
        }
        $this$initPlayerReporter_u24lambda_u247 = null;
        componentHolder$adsplash_debug.setPlayerReporter($this$initPlayerReporter_u24lambda_u247);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlayerProgress initPlayerReporter$lambda$7$0(SplashCardPlayer $player) {
        return new PlayerProgress($player.getCurrentPosition(), $player.getDuration());
    }

    private static final AdVideoInfo getAdVideoInfo(SplashOrder $this$adVideoInfo) {
        VideoBean videoBean;
        IAdReportInfo reportInfo;
        FeedExtra extra;
        Card card;
        IAdInfo adInfo = ExtSplashOrderKt.adInfo($this$adVideoInfo);
        if (adInfo == null || (reportInfo = adInfo.getReportInfo()) == null || (extra = reportInfo.getExtra()) == null || (card = extra.card) == null) {
            videoBean = null;
        } else {
            videoBean = card.getVideo();
        }
        AdVideoInfo it = VideoExtKt.asAdVideoInfo(videoBean);
        String url = it.getUrl();
        AdVideoInfo adVideoInfo = url == null || StringsKt.isBlank(url) ? null : it;
        return adVideoInfo == null ? new AdVideoInfo($this$adVideoInfo.getVideoUrl(), 0L, 0L, 6, (DefaultConstructorMarker) null) : adVideoInfo;
    }
}