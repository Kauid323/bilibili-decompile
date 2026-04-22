package tv.danmaku.bili.freedata.internal.config;

import com.bilibili.lib.tf.TfResourceConfig;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: TfResourceConfig.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\"\u001c\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u001c\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0004\"\u001c\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0004\"\u001c\u0010\t\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0004\"\u001c\u0010\u000b\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0004¨\u0006\r"}, d2 = {"unicomCard", "Lcom/bilibili/lib/tf/TfResourceConfig;", "kotlin.jvm.PlatformType", "getUnicomCard", "()Lcom/bilibili/lib/tf/TfResourceConfig;", "unicomPackage", "getUnicomPackage", "mobileCard", "getMobileCard", "mobilePackage", "getMobilePackage", "telecomCard", "getTelecomCard", "network-ignet-ctr_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TfResourceConfigKt {
    private static final TfResourceConfig mobileCard;
    private static final TfResourceConfig mobilePackage;
    private static final TfResourceConfig telecomCard;
    private static final TfResourceConfig unicomCard;
    private static final TfResourceConfig unicomPackage;

    static {
        TfResourceConfig.Builder $this$unicomCard_u24lambda_u240 = TfResourceConfig.newBuilder();
        $this$unicomCard_u24lambda_u240.setVideo(true);
        $this$unicomCard_u24lambda_u240.setVideoUpload(true);
        $this$unicomCard_u24lambda_u240.setRtmp(true);
        $this$unicomCard_u24lambda_u240.setRtmpPush(true);
        $this$unicomCard_u24lambda_u240.setDanmaku(true);
        $this$unicomCard_u24lambda_u240.setDanmakuMask(true);
        $this$unicomCard_u24lambda_u240.setMusic(true);
        $this$unicomCard_u24lambda_u240.setFile(true);
        $this$unicomCard_u24lambda_u240.setImage(true);
        unicomCard = $this$unicomCard_u24lambda_u240.build();
        TfResourceConfig.Builder $this$unicomPackage_u24lambda_u240 = TfResourceConfig.newBuilder();
        $this$unicomPackage_u24lambda_u240.setVideo(true);
        $this$unicomPackage_u24lambda_u240.setVideoUpload(false);
        $this$unicomPackage_u24lambda_u240.setRtmp(true);
        $this$unicomPackage_u24lambda_u240.setRtmpPush(false);
        $this$unicomPackage_u24lambda_u240.setDanmaku(false);
        $this$unicomPackage_u24lambda_u240.setDanmakuMask(false);
        $this$unicomPackage_u24lambda_u240.setMusic(true);
        $this$unicomPackage_u24lambda_u240.setFile(false);
        $this$unicomPackage_u24lambda_u240.setImage(false);
        unicomPackage = $this$unicomPackage_u24lambda_u240.build();
        TfResourceConfig.Builder $this$mobileCard_u24lambda_u240 = TfResourceConfig.newBuilder();
        $this$mobileCard_u24lambda_u240.setVideo(true);
        $this$mobileCard_u24lambda_u240.setVideoUpload(true);
        $this$mobileCard_u24lambda_u240.setRtmp(true);
        $this$mobileCard_u24lambda_u240.setRtmpPush(true);
        $this$mobileCard_u24lambda_u240.setDanmaku(true);
        $this$mobileCard_u24lambda_u240.setDanmakuMask(true);
        $this$mobileCard_u24lambda_u240.setMusic(true);
        $this$mobileCard_u24lambda_u240.setFile(true);
        $this$mobileCard_u24lambda_u240.setImage(true);
        mobileCard = $this$mobileCard_u24lambda_u240.build();
        TfResourceConfig.Builder $this$mobilePackage_u24lambda_u240 = TfResourceConfig.newBuilder();
        $this$mobilePackage_u24lambda_u240.setVideo(true);
        $this$mobilePackage_u24lambda_u240.setVideoUpload(true);
        $this$mobilePackage_u24lambda_u240.setRtmp(true);
        $this$mobilePackage_u24lambda_u240.setRtmpPush(true);
        $this$mobilePackage_u24lambda_u240.setDanmaku(true);
        $this$mobilePackage_u24lambda_u240.setDanmakuMask(true);
        $this$mobilePackage_u24lambda_u240.setMusic(true);
        $this$mobilePackage_u24lambda_u240.setFile(true);
        $this$mobilePackage_u24lambda_u240.setImage(true);
        mobilePackage = $this$mobilePackage_u24lambda_u240.build();
        TfResourceConfig.Builder $this$telecomCard_u24lambda_u240 = TfResourceConfig.newBuilder();
        $this$telecomCard_u24lambda_u240.setVideo(true);
        $this$telecomCard_u24lambda_u240.setVideoUpload(true);
        $this$telecomCard_u24lambda_u240.setRtmp(true);
        $this$telecomCard_u24lambda_u240.setRtmpPush(true);
        $this$telecomCard_u24lambda_u240.setDanmaku(false);
        $this$telecomCard_u24lambda_u240.setDanmakuMask(false);
        $this$telecomCard_u24lambda_u240.setMusic(true);
        $this$telecomCard_u24lambda_u240.setFile(true);
        $this$telecomCard_u24lambda_u240.setImage(false);
        telecomCard = $this$telecomCard_u24lambda_u240.build();
    }

    public static final TfResourceConfig getUnicomCard() {
        return unicomCard;
    }

    public static final TfResourceConfig getUnicomPackage() {
        return unicomPackage;
    }

    public static final TfResourceConfig getMobileCard() {
        return mobileCard;
    }

    public static final TfResourceConfig getMobilePackage() {
        return mobilePackage;
    }

    public static final TfResourceConfig getTelecomCard() {
        return telecomCard;
    }
}