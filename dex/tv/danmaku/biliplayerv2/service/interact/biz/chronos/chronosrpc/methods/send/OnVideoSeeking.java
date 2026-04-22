package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.common.chronoscommon.message.RequestDefine;
import com.bilibili.ogv.needle.enhancedunmodifiability.EnhancedUnmodifiabilityKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OnVideoSeeking.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/OnVideoSeeking;", "", "<init>", "()V", "Request", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OnVideoSeeking {
    public static final Companion Companion = new Companion(null);
    public static final long TYPE_END = 3;
    public static final long TYPE_SEEKING = 2;
    public static final long TYPE_START = 1;

    /* compiled from: OnVideoSeeking.kt */
    @RequestDefine(method = "OnVideoSeeking")
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\"\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR,\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/OnVideoSeeking$Request;", "", "<init>", "()V", "previewTime", "", "getPreviewTime", "()Ljava/lang/Long;", "setPreviewTime", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "seekType", "getSeekType", "setSeekType", "timestamp", "getTimestamp", "setTimestamp", "error", "", "", "", "getError", "()Ljava/util/Map;", "setError", "(Ljava/util/Map;)V", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Request {
        @JSONField(name = "error")
        private Map<String, Integer> error;
        @JSONField(name = "preview_time")
        private Long previewTime;
        @JSONField(name = "seek_type")
        private Long seekType;
        @JSONField(name = "timestamp")
        private Long timestamp;

        public final Long getPreviewTime() {
            return this.previewTime;
        }

        public final void setPreviewTime(Long l) {
            this.previewTime = l;
        }

        public final Long getSeekType() {
            return this.seekType;
        }

        public final void setSeekType(Long l) {
            this.seekType = l;
        }

        public final Long getTimestamp() {
            return this.timestamp;
        }

        public final void setTimestamp(Long l) {
            this.timestamp = l;
        }

        public final Map<String, Integer> getError() {
            return EnhancedUnmodifiabilityKt.unmodifiable(this.error);
        }

        public final void setError(Map<String, Integer> map) {
            this.error = map;
        }
    }

    /* compiled from: OnVideoSeeking.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/OnVideoSeeking$Companion;", "", "<init>", "()V", "TYPE_START", "", "TYPE_SEEKING", "TYPE_END", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}