package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.common.chronoscommon.message.RequestDefine;
import kotlin.Metadata;
import tv.danmaku.bili.ui.offline.DownloadedPageActivity;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: DanmakuLiked.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuLiked;", "", "<init>", "()V", "Request", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class DanmakuLiked {

    /* compiled from: DanmakuLiked.kt */
    @RequestDefine(method = "OnDanmakuLike")
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0017\"\u0004\b\u001d\u0010\u0019¨\u0006\u001e"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/DanmakuLiked$Request;", "", "<init>", "()V", "videoId", "", "getVideoId", "()Ljava/lang/String;", "setVideoId", "(Ljava/lang/String;)V", "danmakuId", "getDanmakuId", "setDanmakuId", "liked", "", "getLiked", "()Ljava/lang/Boolean;", "setLiked", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "likeCount", "", "getLikeCount", "()Ljava/lang/Integer;", "setLikeCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "replyCount", "getReplyCount", "setReplyCount", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Request {
        @JSONField(name = "danmaku_id")
        private String danmakuId;
        @JSONField(name = "like_count")
        private Integer likeCount;
        @JSONField(name = "liked")
        private Boolean liked;
        @JSONField(name = "reply_count")
        private Integer replyCount;
        @JSONField(name = DownloadedPageActivity.KEY_VIDEO_ID)
        private String videoId;

        public final String getVideoId() {
            return this.videoId;
        }

        public final void setVideoId(String str) {
            this.videoId = str;
        }

        public final String getDanmakuId() {
            return this.danmakuId;
        }

        public final void setDanmakuId(String str) {
            this.danmakuId = str;
        }

        public final Boolean getLiked() {
            return this.liked;
        }

        public final void setLiked(Boolean bool) {
            this.liked = bool;
        }

        public final Integer getLikeCount() {
            return this.likeCount;
        }

        public final void setLikeCount(Integer num) {
            this.likeCount = num;
        }

        public final Integer getReplyCount() {
            return this.replyCount;
        }

        public final void setReplyCount(Integer num) {
            this.replyCount = num;
        }
    }
}