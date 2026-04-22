package video.base.neuron;

import java.util.Map;
import kntr.base.neuron.KNeuron;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.base.neuron.IVBNeuron;

/* compiled from: Neuron.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\bf\u0018\u00002\u00020\u0001J:\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0016J.\u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tH\u0016J.\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tH\u0016J¼\u0001\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\tH\u0016¨\u0006!À\u0006\u0003"}, d2 = {"Lvideo/base/neuron/IVBNeuron;", "", "trackT", "", "eventId", "", "force", "", "extra", "", "sampler", "", "reportClick", "reportExposure", "reportPlayer", "playFromSpmid", "seasonId", "type", "subType", "epId", "progress", "avid", "cid", "networkType", "danmaku", "status", "playMethod", "playType", "playerSessionId", "speed", "playerClarity", "isAutoplay", "videoFormat", "base_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface IVBNeuron {
    void reportClick(boolean z, String str, Map<String, String> map);

    void reportExposure(boolean z, String str, Map<String, String> map);

    void reportPlayer(boolean z, String str, String str2, String str3, int i, int i2, String str4, String str5, String str6, String str7, int i3, int i4, int i5, int i6, int i7, String str8, String str9, String str10, int i8, int i9, Map<String, String> map);

    void trackT(String str, boolean z, Map<String, String> map, int i);

    /* compiled from: Neuron.kt */
    /* renamed from: video.base.neuron.IVBNeuron$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public final /* synthetic */ class CC {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void trackT$default(IVBNeuron iVBNeuron, String str, boolean z, Map map, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackT");
            }
            if ((i2 & 2) != 0) {
                z = true;
            }
            if ((i2 & 4) != 0) {
                map = MapsKt.emptyMap();
            }
            if ((i2 & 8) != 0) {
                i = 1;
            }
            iVBNeuron.trackT(str, z, map, i);
        }

        public static void $default$trackT(IVBNeuron _this, String eventId, boolean force, Map extra, final int sampler) {
            Intrinsics.checkNotNullParameter(eventId, "eventId");
            Intrinsics.checkNotNullParameter(extra, "extra");
            KNeuron.INSTANCE.trackT(force, eventId, extra, new Function0() { // from class: video.base.neuron.IVBNeuron$$ExternalSyntheticLambda0
                public final Object invoke() {
                    return Boolean.valueOf(IVBNeuron.CC.trackT$lambda$0(sampler));
                }
            });
        }

        public static boolean trackT$lambda$0(int $sampler) {
            return Random.Default.nextInt(0, 100) < $sampler;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reportClick$default(IVBNeuron iVBNeuron, boolean z, String str, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportClick");
            }
            if ((i & 4) != 0) {
                map = MapsKt.emptyMap();
            }
            iVBNeuron.reportClick(z, str, map);
        }

        public static void $default$reportClick(IVBNeuron _this, boolean force, String eventId, Map extra) {
            Intrinsics.checkNotNullParameter(eventId, "eventId");
            Intrinsics.checkNotNullParameter(extra, "extra");
            KNeuron.INSTANCE.reportClick(force, eventId + ".click", extra);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void reportExposure$default(IVBNeuron iVBNeuron, boolean z, String str, Map map, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportExposure");
            }
            if ((i & 4) != 0) {
                map = MapsKt.emptyMap();
            }
            iVBNeuron.reportExposure(z, str, map);
        }

        public static void $default$reportExposure(IVBNeuron _this, boolean force, String eventId, Map extra) {
            Intrinsics.checkNotNullParameter(eventId, "eventId");
            Intrinsics.checkNotNullParameter(extra, "extra");
            KNeuron.INSTANCE.reportExposure(force, eventId + ".show", extra);
        }

        public static void $default$reportPlayer(IVBNeuron _this, boolean force, String eventId, String playFromSpmid, String seasonId, int type, int subType, String epId, String progress, String avid, String cid, int networkType, int danmaku, int status, int playMethod, int playType, String playerSessionId, String speed, String playerClarity, int isAutoplay, int videoFormat, Map extra) {
            Intrinsics.checkNotNullParameter(eventId, "eventId");
            Intrinsics.checkNotNullParameter(playFromSpmid, "playFromSpmid");
            Intrinsics.checkNotNullParameter(seasonId, "seasonId");
            Intrinsics.checkNotNullParameter(epId, "epId");
            Intrinsics.checkNotNullParameter(progress, "progress");
            Intrinsics.checkNotNullParameter(avid, "avid");
            Intrinsics.checkNotNullParameter(cid, "cid");
            Intrinsics.checkNotNullParameter(playerSessionId, "playerSessionId");
            Intrinsics.checkNotNullParameter(speed, "speed");
            Intrinsics.checkNotNullParameter(playerClarity, "playerClarity");
            Intrinsics.checkNotNullParameter(extra, "extra");
            KNeuron.INSTANCE.reportPlayer(force, eventId + ".player", playFromSpmid, seasonId, type, subType, epId, progress, avid, cid, networkType, danmaku, status, playMethod, playType, playerSessionId, speed, playerClarity, isAutoplay, videoFormat, extra);
        }
    }

    /* compiled from: Neuron.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static void trackT(IVBNeuron $this, String eventId, boolean force, Map<String, String> map, int sampler) {
            Intrinsics.checkNotNullParameter(eventId, "eventId");
            Intrinsics.checkNotNullParameter(map, "extra");
            CC.$default$trackT($this, eventId, force, map, sampler);
        }

        @Deprecated
        public static void reportClick(IVBNeuron $this, boolean force, String eventId, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(eventId, "eventId");
            Intrinsics.checkNotNullParameter(map, "extra");
            CC.$default$reportClick($this, force, eventId, map);
        }

        @Deprecated
        public static void reportExposure(IVBNeuron $this, boolean force, String eventId, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(eventId, "eventId");
            Intrinsics.checkNotNullParameter(map, "extra");
            CC.$default$reportExposure($this, force, eventId, map);
        }

        @Deprecated
        public static void reportPlayer(IVBNeuron $this, boolean force, String eventId, String playFromSpmid, String seasonId, int type, int subType, String epId, String progress, String avid, String cid, int networkType, int danmaku, int status, int playMethod, int playType, String playerSessionId, String speed, String playerClarity, int isAutoplay, int videoFormat, Map<String, String> map) {
            Intrinsics.checkNotNullParameter(eventId, "eventId");
            Intrinsics.checkNotNullParameter(playFromSpmid, "playFromSpmid");
            Intrinsics.checkNotNullParameter(seasonId, "seasonId");
            Intrinsics.checkNotNullParameter(epId, "epId");
            Intrinsics.checkNotNullParameter(progress, "progress");
            Intrinsics.checkNotNullParameter(avid, "avid");
            Intrinsics.checkNotNullParameter(cid, "cid");
            Intrinsics.checkNotNullParameter(playerSessionId, "playerSessionId");
            Intrinsics.checkNotNullParameter(speed, "speed");
            Intrinsics.checkNotNullParameter(playerClarity, "playerClarity");
            Intrinsics.checkNotNullParameter(map, "extra");
            CC.$default$reportPlayer($this, force, eventId, playFromSpmid, seasonId, type, subType, epId, progress, avid, cid, networkType, danmaku, status, playMethod, playType, playerSessionId, speed, playerClarity, isAutoplay, videoFormat, map);
        }
    }
}