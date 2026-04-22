package tv.danmaku.videoplayer.coreV2.transformer;

import android.content.Context;
import android.os.Bundle;
import com.bilibili.base.connectivity.ConnectivityMonitor;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blconfig.Contract;
import com.bilibili.lib.dd.DeviceDecision;
import com.bilibili.lib.media.resource.MediaResource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayerItem;
import tv.danmaku.ijk.media.player.P2P;
import tv.danmaku.videoplayer.core.media.ijk.IjkOptionsHelper;

/* compiled from: IjkMediaItemTransformer.kt */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a\b\u0010\b\u001a\u00020\tH\u0002\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"setDynamicQuality", "", "Ltv/danmaku/ijk/media/player/IjkMediaPlayerItem;", "mediaResource", "Lcom/bilibili/lib/media/resource/MediaResource;", "initP2P", "context", "Landroid/content/Context;", "isWifiActive", "", "TAG", "", "hitHdrRenderTypeDD", "playercore_debug"}, k = 2, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class IjkMediaItemTransformerKt {
    private static final String TAG = "IjkMediaItemTransformer";
    private static final boolean hitHdrRenderTypeDD = DeviceDecision.INSTANCE.getBoolean("dd_player_853_hdr_render_type", false);

    public static final /* synthetic */ boolean access$getHitHdrRenderTypeDD$p() {
        return hitHdrRenderTypeDD;
    }

    public static final /* synthetic */ boolean access$isWifiActive() {
        return isWifiActive();
    }

    public static final /* synthetic */ void access$setDynamicQuality(IjkMediaPlayerItem $receiver, MediaResource mediaResource) {
        setDynamicQuality($receiver, mediaResource);
    }

    public static final void setDynamicQuality(IjkMediaPlayerItem $this$setDynamicQuality, MediaResource mediaResource) {
        if (mediaResource.getDynamicQuality() == null) {
            return;
        }
        Map rules = mediaResource.getDynamicQualityRules();
        boolean z = false;
        if (rules != null && (rules.isEmpty() ^ true)) {
            Map streams = mediaResource.getDynamicQualityStreams();
            if (streams != null && (!streams.isEmpty())) {
                z = true;
            }
            if (z) {
                $this$setDynamicQuality.setQnCoverRules(rules);
                $this$setDynamicQuality.setQnCoverStreams(streams);
            }
        }
    }

    public static final void initP2P(Context context) {
        if (P2P.getInstance() == null) {
            Bundle config = new Bundle();
            for (String key : P2P.sP2POnlineConfig.keySet()) {
                Object obj = P2P.sP2POnlineConfig.get(key);
                if (obj instanceof Long) {
                    Contract config2 = ConfigManager.Companion.config();
                    Intrinsics.checkNotNull(key);
                    String str = (String) config2.get(key, String.valueOf(((Number) obj).longValue()));
                    config.putLong(key, str != null ? Long.parseLong(str) : ((Number) obj).longValue());
                } else if (obj instanceof Integer) {
                    Contract config3 = ConfigManager.Companion.config();
                    Intrinsics.checkNotNull(key);
                    String str2 = (String) config3.get(key, String.valueOf(((Number) obj).intValue()));
                    config.putInt(key, str2 != null ? Integer.parseInt(str2) : ((Number) obj).intValue());
                } else if (obj instanceof Boolean) {
                    Contract ab = ConfigManager.Companion.ab();
                    Intrinsics.checkNotNull(key);
                    Boolean bool = (Boolean) ab.get(key, obj);
                    if (bool == null) {
                        bool = (Boolean) obj;
                    }
                    config.putBoolean(key, bool.booleanValue());
                } else if (obj instanceof String) {
                    Contract config4 = ConfigManager.Companion.config();
                    Intrinsics.checkNotNull(key);
                    String str3 = (String) config4.get(key, obj);
                    if (str3 == null) {
                        str3 = (String) obj;
                    }
                    config.putString(key, str3);
                }
            }
            config.putString(P2P.KEY_EXT_P2P_BUVID, IjkOptionsHelper.getBuvid());
            config.putInt(P2P.KEY_EXT_P2P_DEVICE_TYPE, P2P.DEVICE_TYPE.DEVICE_ANDROID.ordinal());
            P2P.getInstance(context, config);
        }
    }

    public static final boolean isWifiActive() {
        int networkType = ConnectivityMonitor.getInstance().getNetwork();
        return networkType == 1 || networkType == 5 || networkType == 4;
    }
}