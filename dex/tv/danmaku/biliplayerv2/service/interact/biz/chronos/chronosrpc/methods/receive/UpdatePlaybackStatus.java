package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.common.chronoscommon.message.RequestDefine;
import com.bilibili.common.chronoscommon.message.ResponseDefine;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: UpdatePlaybackStatus.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdatePlaybackStatus;", "", "<init>", "()V", "Request", "Response", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class UpdatePlaybackStatus {

    /* compiled from: UpdatePlaybackStatus.kt */
    @RequestDefine(method = "UpdatePlaybackStatus")
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdatePlaybackStatus$Request;", "", "<init>", "()V", "currentTime", "", "getCurrentTime", "()Ljava/lang/Long;", "setCurrentTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "playbackRate", "", "getPlaybackRate", "()Ljava/lang/Float;", "setPlaybackRate", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "currentQn", "", "getCurrentQn", "()Ljava/lang/Integer;", "setCurrentQn", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Request {
        @JSONField(name = "current_qn")
        private Integer currentQn;
        @JSONField(name = "current_time")
        private Long currentTime;
        @JSONField(name = "playback_rate")
        private Float playbackRate;

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

        public final Integer getCurrentQn() {
            return this.currentQn;
        }

        public final void setCurrentQn(Integer num) {
            this.currentQn = num;
        }
    }

    /* compiled from: UpdatePlaybackStatus.kt */
    @ResponseDefine
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\"\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/UpdatePlaybackStatus$Response;", "", "<init>", "()V", "currentTime", "", "getCurrentTime", "()Ljava/lang/Long;", "setCurrentTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "playbackRate", "", "getPlaybackRate", "()Ljava/lang/Float;", "setPlaybackRate", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "timestamp", "getTimestamp", "setTimestamp", "currentQn", "", "getCurrentQn", "()Ljava/lang/Integer;", "setCurrentQn", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Response {
        @JSONField(name = "current_qn")
        private Integer currentQn;
        @JSONField(name = "current_time")
        private Long currentTime;
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

        public final Long getTimestamp() {
            return this.timestamp;
        }

        public final void setTimestamp(Long l) {
            this.timestamp = l;
        }

        public final Integer getCurrentQn() {
            return this.currentQn;
        }

        public final void setCurrentQn(Integer num) {
            this.currentQn = num;
        }
    }
}