package tv.danmaku.bili.ui.offline.api;

import com.alibaba.fastjson.annotation.JSONField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.ui.rank.router.RankRouter;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: MultitypePlaylist.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0002\n\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/offline/api/MultitypePlaylist;", "", "<init>", "()V", "info", "Ltv/danmaku/bili/ui/offline/api/MultitypePlaylist$Info;", "getInfo", "()Ltv/danmaku/bili/ui/offline/api/MultitypePlaylist$Info;", "setInfo", "(Ltv/danmaku/bili/ui/offline/api/MultitypePlaylist$Info;)V", "Info", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class MultitypePlaylist {
    public static final int STATE_DISLIKE = 2;
    public static final int STATE_LIKE = 1;
    public static final int STATE_NONE = 0;
    private Info info;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public final Info getInfo() {
        return this.info;
    }

    public final void setInfo(Info info) {
        this.info = info;
    }

    /* compiled from: MultitypePlaylist.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001e\u0010\u0019\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001e\u0010%\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\u001a\u0010(\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\u001c\u0010+\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0013\"\u0004\b-\u0010\u0015R\u001a\u0010.\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR\u001c\u00101\u001a\u0004\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u00107\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\tR\u001a\u0010:\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0007\"\u0004\b<\u0010\tR$\u0010?\u001a\u00020>2\u0006\u0010=\u001a\u00020>8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b?\u0010@\"\u0004\bA\u0010B¨\u0006F"}, d2 = {"Ltv/danmaku/bili/ui/offline/api/MultitypePlaylist$Info;", "", "<init>", "()V", "attr", "", "getAttr", "()I", "setAttr", "(I)V", "socializeInfo", "Ltv/danmaku/bili/ui/offline/api/SocializeInfo;", "getSocializeInfo", "()Ltv/danmaku/bili/ui/offline/api/SocializeInfo;", "setSocializeInfo", "(Ltv/danmaku/bili/ui/offline/api/SocializeInfo;)V", RankRouter.BundleKey.VIDEO_DETAIL_COVER, "", "getCover", "()Ljava/lang/String;", "setCover", "(Ljava/lang/String;)V", "cover_type", "getCover_type", "setCover_type", "favState", "getFavState", "setFavState", "id", "", "getId", "()J", "setId", "(J)V", "likeState", "getLikeState", "setLikeState", "mediaCount", "getMediaCount", "setMediaCount", RankRouter.BundleKey.AUTHOR_SPACE_MID, "getMid", "setMid", RankRouter.BundleKey.ACTION_PARAM_TITLE, "getTitle", "setTitle", "type", "getType", "setType", "upper", "Ltv/danmaku/bili/ui/offline/api/Upper;", "getUpper", "()Ltv/danmaku/bili/ui/offline/api/Upper;", "setUpper", "(Ltv/danmaku/bili/ui/offline/api/Upper;)V", "functions", "getFunctions", "setFunctions", "pageType", "getPageType", "setPageType", "like", "", "isLike", "()Z", "setLike", "(Z)V", "remove", "", "count", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Info {
        public static final int $stable = 8;
        private int attr;
        private String cover;
        private int cover_type;
        @JSONField(name = "fav_state")
        private int favState;
        @JSONField(name = "functions")
        private int functions;
        private long id;
        @JSONField(name = "like_state")
        private int likeState;
        @JSONField(name = "media_count")
        private int mediaCount;
        private long mid;
        private int pageType;
        @JSONField(name = "cnt_info")
        private SocializeInfo socializeInfo;
        private String title;
        private int type;
        private Upper upper;

        public final int getAttr() {
            return this.attr;
        }

        public final void setAttr(int i) {
            this.attr = i;
        }

        public final SocializeInfo getSocializeInfo() {
            return this.socializeInfo;
        }

        public final void setSocializeInfo(SocializeInfo socializeInfo) {
            this.socializeInfo = socializeInfo;
        }

        public final String getCover() {
            return this.cover;
        }

        public final void setCover(String str) {
            this.cover = str;
        }

        public final int getCover_type() {
            return this.cover_type;
        }

        public final void setCover_type(int i) {
            this.cover_type = i;
        }

        public final int getFavState() {
            return this.favState;
        }

        public final void setFavState(int i) {
            this.favState = i;
        }

        public final long getId() {
            return this.id;
        }

        public final void setId(long j) {
            this.id = j;
        }

        public final int getLikeState() {
            return this.likeState;
        }

        public final void setLikeState(int i) {
            this.likeState = i;
        }

        public final int getMediaCount() {
            return this.mediaCount;
        }

        public final void setMediaCount(int i) {
            this.mediaCount = i;
        }

        public final long getMid() {
            return this.mid;
        }

        public final void setMid(long j) {
            this.mid = j;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final int getType() {
            return this.type;
        }

        public final void setType(int i) {
            this.type = i;
        }

        public final Upper getUpper() {
            return this.upper;
        }

        public final void setUpper(Upper upper) {
            this.upper = upper;
        }

        public final int getFunctions() {
            return this.functions;
        }

        public final void setFunctions(int i) {
            this.functions = i;
        }

        public final int getPageType() {
            return this.pageType;
        }

        public final void setPageType(int i) {
            this.pageType = i;
        }

        public final boolean isLike() {
            return this.likeState == 1;
        }

        public final void setLike(boolean like) {
            this.likeState = like ? 1 : 0;
        }

        public final void remove(int count) {
            this.mediaCount -= count;
        }
    }

    /* compiled from: MultitypePlaylist.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Ltv/danmaku/bili/ui/offline/api/MultitypePlaylist$Companion;", "", "<init>", "()V", "STATE_NONE", "", "STATE_LIKE", "STATE_DISLIKE", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}