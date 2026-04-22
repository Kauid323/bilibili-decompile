package tv.danmaku.video.bilicardplayer.utils;

import com.bilibili.lib.dd.DeviceDecision;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ConfigUtils.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007¨\u0006\r"}, d2 = {"Ltv/danmaku/video/bilicardplayer/utils/ConfigUtils;", "", "<init>", "()V", "liveStartExpectLatency", "", "getLiveStartExpectLatency", "()I", "liveStartExpectLatency$delegate", "Lkotlin/Lazy;", "liveExpectLatency", "getLiveExpectLatency", "liveExpectLatency$delegate", "bilicardplayer_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ConfigUtils {
    public static final ConfigUtils INSTANCE = new ConfigUtils();
    private static final Lazy liveStartExpectLatency$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.video.bilicardplayer.utils.ConfigUtils$$ExternalSyntheticLambda0
        public final Object invoke() {
            int liveStartExpectLatency_delegate$lambda$0;
            liveStartExpectLatency_delegate$lambda$0 = ConfigUtils.liveStartExpectLatency_delegate$lambda$0();
            return Integer.valueOf(liveStartExpectLatency_delegate$lambda$0);
        }
    });
    private static final Lazy liveExpectLatency$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.video.bilicardplayer.utils.ConfigUtils$$ExternalSyntheticLambda1
        public final Object invoke() {
            int liveExpectLatency_delegate$lambda$0;
            liveExpectLatency_delegate$lambda$0 = ConfigUtils.liveExpectLatency_delegate$lambda$0();
            return Integer.valueOf(liveExpectLatency_delegate$lambda$0);
        }
    });

    private ConfigUtils() {
    }

    public final int getLiveStartExpectLatency() {
        return ((Number) liveStartExpectLatency$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int liveStartExpectLatency_delegate$lambda$0() {
        String value = DeviceDecision.INSTANCE.dd("dd.player.inline.live.room.start.latency", (String) null);
        if (value == null) {
            return 0;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public final int getLiveExpectLatency() {
        return ((Number) liveExpectLatency$delegate.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int liveExpectLatency_delegate$lambda$0() {
        String value = DeviceDecision.INSTANCE.dd("dd.player.inline.live.room.latency", (String) null);
        if (value == null) {
            return 3000;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 3000;
        }
    }
}