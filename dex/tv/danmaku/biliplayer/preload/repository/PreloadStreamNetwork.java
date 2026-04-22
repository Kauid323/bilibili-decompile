package tv.danmaku.biliplayer.preload.repository;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.videopage.common.performance.PerformanceConstants;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkNetworkUtils;

/* compiled from: PreloadElement.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u0011\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0006HÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Ltv/danmaku/biliplayer/preload/repository/PreloadStreamNetwork;", "", PerformanceConstants.EXTRA_KEY_NETWORK, "Ltv/danmaku/ijk/media/player/IjkNetworkUtils$NetWorkType;", "Ltv/danmaku/biliplayer/preload/repository/NetworkType;", "sceneIdentity", "", "resolverId", "streamUrl", "<init>", "(Ltv/danmaku/ijk/media/player/IjkNetworkUtils$NetWorkType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNetwork", "()Ltv/danmaku/ijk/media/player/IjkNetworkUtils$NetWorkType;", "getSceneIdentity", "()Ljava/lang/String;", "getResolverId", "getStreamUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "player-preload_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PreloadStreamNetwork {
    private final IjkNetworkUtils.NetWorkType network;
    private final String resolverId;
    private final String sceneIdentity;
    private final String streamUrl;

    public static /* synthetic */ PreloadStreamNetwork copy$default(PreloadStreamNetwork preloadStreamNetwork, IjkNetworkUtils.NetWorkType netWorkType, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            netWorkType = preloadStreamNetwork.network;
        }
        if ((i & 2) != 0) {
            str = preloadStreamNetwork.sceneIdentity;
        }
        if ((i & 4) != 0) {
            str2 = preloadStreamNetwork.resolverId;
        }
        if ((i & 8) != 0) {
            str3 = preloadStreamNetwork.streamUrl;
        }
        return preloadStreamNetwork.copy(netWorkType, str, str2, str3);
    }

    public final IjkNetworkUtils.NetWorkType component1() {
        return this.network;
    }

    public final String component2() {
        return this.sceneIdentity;
    }

    public final String component3() {
        return this.resolverId;
    }

    public final String component4() {
        return this.streamUrl;
    }

    public final PreloadStreamNetwork copy(IjkNetworkUtils.NetWorkType netWorkType, String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(netWorkType, PerformanceConstants.EXTRA_KEY_NETWORK);
        Intrinsics.checkNotNullParameter(str, "sceneIdentity");
        Intrinsics.checkNotNullParameter(str2, "resolverId");
        return new PreloadStreamNetwork(netWorkType, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PreloadStreamNetwork) {
            PreloadStreamNetwork preloadStreamNetwork = (PreloadStreamNetwork) obj;
            return this.network == preloadStreamNetwork.network && Intrinsics.areEqual(this.sceneIdentity, preloadStreamNetwork.sceneIdentity) && Intrinsics.areEqual(this.resolverId, preloadStreamNetwork.resolverId) && Intrinsics.areEqual(this.streamUrl, preloadStreamNetwork.streamUrl);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.network.hashCode() * 31) + this.sceneIdentity.hashCode()) * 31) + this.resolverId.hashCode()) * 31) + (this.streamUrl == null ? 0 : this.streamUrl.hashCode());
    }

    public String toString() {
        IjkNetworkUtils.NetWorkType netWorkType = this.network;
        String str = this.sceneIdentity;
        String str2 = this.resolverId;
        return "PreloadStreamNetwork(network=" + netWorkType + ", sceneIdentity=" + str + ", resolverId=" + str2 + ", streamUrl=" + this.streamUrl + ")";
    }

    public PreloadStreamNetwork(IjkNetworkUtils.NetWorkType network, String sceneIdentity, String resolverId, String streamUrl) {
        Intrinsics.checkNotNullParameter(network, PerformanceConstants.EXTRA_KEY_NETWORK);
        Intrinsics.checkNotNullParameter(sceneIdentity, "sceneIdentity");
        Intrinsics.checkNotNullParameter(resolverId, "resolverId");
        this.network = network;
        this.sceneIdentity = sceneIdentity;
        this.resolverId = resolverId;
        this.streamUrl = streamUrl;
    }

    public /* synthetic */ PreloadStreamNetwork(IjkNetworkUtils.NetWorkType netWorkType, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(netWorkType, str, str2, (i & 8) != 0 ? null : str3);
    }

    public final IjkNetworkUtils.NetWorkType getNetwork() {
        return this.network;
    }

    public final String getSceneIdentity() {
        return this.sceneIdentity;
    }

    public final String getResolverId() {
        return this.resolverId;
    }

    public final String getStreamUrl() {
        return this.streamUrl;
    }
}