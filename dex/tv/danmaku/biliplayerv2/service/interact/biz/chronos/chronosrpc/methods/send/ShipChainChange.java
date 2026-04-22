package tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send;

import com.alibaba.fastjson.annotation.JSONField;
import com.bilibili.common.chronoscommon.message.RequestDefine;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ShipChainChange.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/ShipChainChange;", "", "<init>", "()V", "Request", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class ShipChainChange {

    /* compiled from: ShipChainChange.kt */
    @RequestDefine(method = "OnRelationshipChainChanged")
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u000e\"\u0004\b\u0014\u0010\u0010R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\tR\"\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u0019\u0010\u000e\"\u0004\b\u001a\u0010\u0010R\"\u0010\u001b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\tR\"\u0010\u001e\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u0010R\"\u0010!\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\"\u0010\u000e\"\u0004\b#\u0010\u0010R\"\u0010$\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b%\u0010\u000e\"\u0004\b&\u0010\u0010¨\u0006'"}, d2 = {"Ltv/danmaku/biliplayerv2/service/interact/biz/chronos/chronosrpc/methods/send/ShipChainChange$Request;", "", "<init>", "()V", "likeNum", "", "getLikeNum", "()Ljava/lang/Long;", "setLikeNum", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "likeState", "", "getLikeState", "()Ljava/lang/Boolean;", "setLikeState", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "dislikeState", "getDislikeState", "setDislikeState", "coinNum", "getCoinNum", "setCoinNum", "coinState", "getCoinState", "setCoinState", "fansNum", "getFansNum", "setFansNum", "followState", "getFollowState", "setFollowState", "favoriteState", "getFavoriteState", "setFavoriteState", "followSeasonState", "getFollowSeasonState", "setFollowSeasonState", "biliplayerv2_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Request {
        @JSONField(name = "coin_num")
        private Long coinNum;
        @JSONField(name = "coin_state")
        private Boolean coinState;
        @JSONField(name = "dislike_state")
        private Boolean dislikeState;
        @JSONField(name = "fans_num")
        private Long fansNum;
        @JSONField(name = "favorite_state")
        private Boolean favoriteState;
        @JSONField(name = "follow_season_state")
        private Boolean followSeasonState;
        @JSONField(name = "follow_state")
        private Boolean followState;
        @JSONField(name = "like_num")
        private Long likeNum;
        @JSONField(name = "like_state")
        private Boolean likeState;

        public final Long getLikeNum() {
            return this.likeNum;
        }

        public final void setLikeNum(Long l) {
            this.likeNum = l;
        }

        public final Boolean getLikeState() {
            return this.likeState;
        }

        public final void setLikeState(Boolean bool) {
            this.likeState = bool;
        }

        public final Boolean getDislikeState() {
            return this.dislikeState;
        }

        public final void setDislikeState(Boolean bool) {
            this.dislikeState = bool;
        }

        public final Long getCoinNum() {
            return this.coinNum;
        }

        public final void setCoinNum(Long l) {
            this.coinNum = l;
        }

        public final Boolean getCoinState() {
            return this.coinState;
        }

        public final void setCoinState(Boolean bool) {
            this.coinState = bool;
        }

        public final Long getFansNum() {
            return this.fansNum;
        }

        public final void setFansNum(Long l) {
            this.fansNum = l;
        }

        public final Boolean getFollowState() {
            return this.followState;
        }

        public final void setFollowState(Boolean bool) {
            this.followState = bool;
        }

        public final Boolean getFavoriteState() {
            return this.favoriteState;
        }

        public final void setFavoriteState(Boolean bool) {
            this.favoriteState = bool;
        }

        public final Boolean getFollowSeasonState() {
            return this.followSeasonState;
        }

        public final void setFollowSeasonState(Boolean bool) {
            this.followSeasonState = bool;
        }
    }
}