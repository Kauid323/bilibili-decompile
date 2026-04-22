package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.common.chronoscommon.message.RequestDefine;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.Map;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: PlaybackStatusChange.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/PlaybackStatusChange;", "", "<init>", "()V", "Request", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class PlaybackStatusChange {

    /* compiled from: PlaybackStatusChange.kt */
    @RequestDefine(method = "OnPlaybackStatusChanged")
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001d\u001a\u00020\u0014H\u0016R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R,\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\t¨\u0006\u001e"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/PlaybackStatusChange$Request;", "", "<init>", "()V", "currentTime", "", "getCurrentTime", "()Ljava/lang/Long;", "setCurrentTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "playbackRate", "", "getPlaybackRate", "()Ljava/lang/Float;", "setPlaybackRate", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "error", "", "", "", "getError", "()Ljava/util/Map;", "setError", "(Ljava/util/Map;)V", "timestamp", "getTimestamp", "setTimestamp", "toString", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Request {
        @JSONField(name = "current_time")
        private Long currentTime;
        @JSONField(name = "error")
        private Map<String, Integer> error;
        @JSONField(name = "playback_rate")
        private Float playbackRate;
        @JSONField(name = "timestamp")
        private Long timestamp;

        public final Long getCurrentTime() {
            return this.currentTime;
        }

        public final void setCurrentTime(Long l) {
            this.currentTime = l;
        }

        public final Float getPlaybackRate() {
            return this.playbackRate;
        }

        public final void setPlaybackRate(Float f) {
            this.playbackRate = f;
        }

        public final Map<String, Integer> getError() {
            return EnhancedUnmodifiabilityKt.unmodifiable(this.error);
        }

        public final void setError(Map<String, Integer> map) {
            this.error = map;
        }

        public final Long getTimestamp() {
            return this.timestamp;
        }

        public final void setTimestamp(Long l) {
            this.timestamp = l;
        }

        public String toString() {
            Long l = this.currentTime;
            Float f = this.playbackRate;
            Map<String, Integer> map = this.error;
            return "Request(currentTime=" + l + ", playbackRate=" + f + ", error=" + map + ", timestamp=" + this.timestamp + ")";
        }
    }
}