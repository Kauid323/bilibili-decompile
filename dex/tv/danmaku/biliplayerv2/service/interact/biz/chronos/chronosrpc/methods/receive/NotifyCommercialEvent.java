package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.receive;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.common.chronoscommon.message.RequestDefine;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.ui.offline.DownloadedPageActivity;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: NotifyCommercialEvent.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00052\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/NotifyCommercialEvent;", "", "<init>", "()V", "Request", "Companion", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class NotifyCommercialEvent {
    public static final Companion Companion = new Companion(null);
    public static final String IDENTIFIER_GOODS_LIKE = "GOODS_LIKE";
    public static final String STORY_COMMERCIAL_DANMAKU = "STORY_COMMERCIAL_DANMAKU";

    /* compiled from: NotifyCommercialEvent.kt */
    @RequestDefine(method = "NotifyCommercialEvent")
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR \u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\t¨\u0006\u0013"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/NotifyCommercialEvent$Request;", "", "<init>", "()V", "workId", "", "getWorkId", "()Ljava/lang/String;", "setWorkId", "(Ljava/lang/String;)V", "videoId", "getVideoId", "setVideoId", "identifier", "getIdentifier", "setIdentifier", "extra", "getExtra", "setExtra", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Request {
        @JSONField(name = "extra")
        private String extra;
        @JSONField(name = "identifier")
        private String identifier;
        @JSONField(name = DownloadedPageActivity.KEY_VIDEO_ID)
        private String videoId;
        @JSONField(name = "work_id")
        private String workId;

        public final String getWorkId() {
            return this.workId;
        }

        public final void setWorkId(String str) {
            this.workId = str;
        }

        public final String getVideoId() {
            return this.videoId;
        }

        public final void setVideoId(String str) {
            this.videoId = str;
        }

        public final String getIdentifier() {
            return this.identifier;
        }

        public final void setIdentifier(String str) {
            this.identifier = str;
        }

        public final String getExtra() {
            return this.extra;
        }

        public final void setExtra(String str) {
            this.extra = str;
        }
    }

    /* compiled from: NotifyCommercialEvent.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/receive/NotifyCommercialEvent$Companion;", "", "<init>", "()V", "IDENTIFIER_GOODS_LIKE", "", NotifyCommercialEvent.STORY_COMMERCIAL_DANMAKU, "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}