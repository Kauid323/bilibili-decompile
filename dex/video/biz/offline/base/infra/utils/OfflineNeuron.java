package video.biz.offline.base.infra.utils;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;
import video.base.neuron.IVBNeuron;
import video.biz.offline.base.model.error.DataErrorType;
import video.biz.offline.base.model.error.DownloadException;
import video.biz.offline.base.model.error.OfflineError;
import video.biz.offline.base.model.error.OfflineErrorType;

/* compiled from: Neuron.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lvideo/biz/offline/base/infra/utils/OfflineNeuron;", "", "<init>", "()V", "Companion", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineNeuron {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);

    /* compiled from: Neuron.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0005J\u001a\u0010\u0015\u001a\u00020\u00052\n\u0010\u0012\u001a\u00060\u0016j\u0002`\u00172\u0006\u0010\u0018\u001a\u00020\nJ\u0006\u0010\u0019\u001a\u00020\u0005J\u001a\u0010\u001a\u001a\u00020\u00052\n\u0010\u0012\u001a\u00060\u0016j\u0002`\u00172\u0006\u0010\u0018\u001a\u00020\n¨\u0006\u001b"}, d2 = {"Lvideo/biz/offline/base/infra/utils/OfflineNeuron$Companion;", "", "<init>", "()V", "trackT", "", "type", "Lvideo/biz/offline/base/infra/utils/OfflineTrackType;", "extra", "", "", "sampler", "", "(Lvideo/biz/offline/base/infra/utils/OfflineTrackType;Ljava/util/Map;Ljava/lang/Integer;)V", "dataStartTrackT", "dataSuccessTrackT", "times", "dataErrorTrackT", "error", "Lvideo/biz/offline/base/model/error/DataErrorType;", "downloadStartTrackT", "downloadErrorTrackT", "Ljava/lang/Exception;", "Lkotlin/Exception;", "key", "taskGroupStartTrack", "taskGroupErrorTrackT", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void trackT$default(Companion companion, OfflineTrackType offlineTrackType, Map map, Integer num, int i, Object obj) {
            if ((i & 2) != 0) {
                map = MapsKt.emptyMap();
            }
            if ((i & 4) != 0) {
                num = null;
            }
            companion.trackT(offlineTrackType, map, num);
        }

        public final void trackT(OfflineTrackType type, Map<String, String> map, Integer sampler) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(map, "extra");
            if (type.getInTrackSampler() || sampler != null) {
                Map extraMap = MapsKt.toMutableMap(map);
                extraMap.put(NeuronKt.TRACK_TYPE_KEY, type.getType());
                IVBNeuron.CC.trackT$default(video.base.neuron.NeuronKt.getVBNeuron(), NeuronKt.KMP_OFFLINE_INFO_EVENT, false, extraMap, sampler != null ? sampler.intValue() : 100, 2, null);
            }
        }

        public final void dataStartTrackT() {
            trackT$default(this, OfflineTrackType.DATAMIGRATE, MapsKt.mapOf(TuplesKt.to(NeuronKt.EXTRA_VALUE1, "1")), null, 4, null);
        }

        public final void dataSuccessTrackT(int times) {
            trackT$default(this, OfflineTrackType.DATAMIGRATE, MapsKt.mapOf(new Pair[]{TuplesKt.to(NeuronKt.EXTRA_VALUE1, "2"), TuplesKt.to(NeuronKt.EXTRA_VALUE2, String.valueOf(times))}), null, 4, null);
        }

        public final void dataErrorTrackT(DataErrorType error) {
            Intrinsics.checkNotNullParameter(error, "error");
            trackT$default(this, OfflineTrackType.DATAMIGRATE, MapsKt.mapOf(new Pair[]{TuplesKt.to(NeuronKt.EXTRA_VALUE1, "3"), TuplesKt.to(NeuronKt.EXTRA_VALUE2, String.valueOf(error.getCode())), TuplesKt.to(NeuronKt.EXTRA_VALUE3, error.getTrackMsg())}), null, 4, null);
        }

        public final void downloadStartTrackT() {
            trackT$default(this, OfflineTrackType.DOWNLOAD, MapsKt.mapOf(TuplesKt.to(NeuronKt.EXTRA_VALUE1, "1")), null, 4, null);
        }

        public final void downloadErrorTrackT(Exception error, String key) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(key, "key");
            OfflineErrorType errorType = OfflineErrorType.DOWNLOAD_ERROR;
            int errorCode = IjkMediaCodecInfo.RANK_MAX;
            String errorMsg = "未知错误类型";
            if (error instanceof DownloadException) {
                errorType = OfflineError.INSTANCE.getErrorType(((DownloadException) error).getCode());
                errorCode = OfflineError.INSTANCE.getErrorNumber(((DownloadException) error).getCode());
                String message = ((DownloadException) error).getMessage();
                if (message == null) {
                    message = "未知错误类型";
                }
                errorMsg = message;
            }
            trackT$default(this, OfflineTrackType.DOWNLOAD, MapsKt.mapOf(new Pair[]{TuplesKt.to(NeuronKt.EXTRA_VALUE1, String.valueOf(errorType.getValue())), TuplesKt.to(NeuronKt.EXTRA_VALUE2, String.valueOf(errorCode)), TuplesKt.to(NeuronKt.EXTRA_VALUE3, errorMsg), TuplesKt.to(NeuronKt.EXTRA_VALUE4, key)}), null, 4, null);
        }

        public final void taskGroupStartTrack() {
            trackT$default(this, OfflineTrackType.TASKGROUP, MapsKt.mapOf(TuplesKt.to(NeuronKt.EXTRA_VALUE1, "1")), null, 4, null);
        }

        public final void taskGroupErrorTrackT(Exception error, String key) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(key, "key");
            OfflineErrorType errorType = OfflineErrorType.DOWNLOAD_ERROR;
            int errorCode = IjkMediaCodecInfo.RANK_MAX;
            String errorMsg = "未知错误类型";
            if (error instanceof DownloadException) {
                errorType = OfflineError.INSTANCE.getErrorType(((DownloadException) error).getCode());
                errorCode = OfflineError.INSTANCE.getErrorNumber(((DownloadException) error).getCode());
                String message = ((DownloadException) error).getMessage();
                if (message == null) {
                    message = "未知错误类型";
                }
                errorMsg = message;
            }
            trackT$default(this, OfflineTrackType.TASKGROUP, MapsKt.mapOf(new Pair[]{TuplesKt.to(NeuronKt.EXTRA_VALUE1, String.valueOf(errorType.getValue())), TuplesKt.to(NeuronKt.EXTRA_VALUE2, String.valueOf(errorCode)), TuplesKt.to(NeuronKt.EXTRA_VALUE3, errorMsg), TuplesKt.to(NeuronKt.EXTRA_VALUE4, key)}), null, 4, null);
        }
    }
}