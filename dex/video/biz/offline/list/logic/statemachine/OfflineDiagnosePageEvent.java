package video.biz.offline.list.logic.statemachine;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineDiagnosePageStore.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnosePageEvent;", "", "FetchAllVideos", "VideosLoadFailed", "VideosLoaded", "NavToDiagnoseResultBy", "Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnosePageEvent$FetchAllVideos;", "Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnosePageEvent$NavToDiagnoseResultBy;", "Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnosePageEvent$VideosLoadFailed;", "Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnosePageEvent$VideosLoaded;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface OfflineDiagnosePageEvent {

    /* compiled from: OfflineDiagnosePageStore.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnosePageEvent$FetchAllVideos;", "Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnosePageEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class FetchAllVideos implements OfflineDiagnosePageEvent {
        public static final int $stable = 0;
        public static final FetchAllVideos INSTANCE = new FetchAllVideos();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof FetchAllVideos) {
                FetchAllVideos fetchAllVideos = (FetchAllVideos) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1938074962;
        }

        public String toString() {
            return "FetchAllVideos";
        }

        private FetchAllVideos() {
        }
    }

    /* compiled from: OfflineDiagnosePageStore.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnosePageEvent$VideosLoadFailed;", "Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnosePageEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class VideosLoadFailed implements OfflineDiagnosePageEvent {
        public static final int $stable = 0;
        public static final VideosLoadFailed INSTANCE = new VideosLoadFailed();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof VideosLoadFailed) {
                VideosLoadFailed videosLoadFailed = (VideosLoadFailed) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1649774578;
        }

        public String toString() {
            return "VideosLoadFailed";
        }

        private VideosLoadFailed() {
        }
    }

    /* compiled from: OfflineDiagnosePageStore.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnosePageEvent$VideosLoaded;", "Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnosePageEvent;", "videos", "", "Lvideo/biz/offline/list/logic/statemachine/OfflineVideoEntityWithTag;", "<init>", "(Ljava/util/List;)V", "getVideos", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class VideosLoaded implements OfflineDiagnosePageEvent {
        public static final int $stable = 8;
        private final List<OfflineVideoEntityWithTag> videos;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VideosLoaded copy$default(VideosLoaded videosLoaded, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = videosLoaded.videos;
            }
            return videosLoaded.copy(list);
        }

        public final List<OfflineVideoEntityWithTag> component1() {
            return this.videos;
        }

        public final VideosLoaded copy(List<OfflineVideoEntityWithTag> list) {
            Intrinsics.checkNotNullParameter(list, "videos");
            return new VideosLoaded(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof VideosLoaded) && Intrinsics.areEqual(this.videos, ((VideosLoaded) obj).videos);
        }

        public int hashCode() {
            return this.videos.hashCode();
        }

        public String toString() {
            return "VideosLoaded(videos=" + this.videos + ")";
        }

        public VideosLoaded(List<OfflineVideoEntityWithTag> list) {
            Intrinsics.checkNotNullParameter(list, "videos");
            this.videos = list;
        }

        public final List<OfflineVideoEntityWithTag> getVideos() {
            return this.videos;
        }
    }

    /* compiled from: OfflineDiagnosePageStore.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnosePageEvent$NavToDiagnoseResultBy;", "Lvideo/biz/offline/list/logic/statemachine/OfflineDiagnosePageEvent;", "videoId", "", "cid", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getVideoId", "()Ljava/lang/String;", "getCid", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class NavToDiagnoseResultBy implements OfflineDiagnosePageEvent {
        public static final int $stable = 0;
        private final String cid;
        private final String videoId;

        public static /* synthetic */ NavToDiagnoseResultBy copy$default(NavToDiagnoseResultBy navToDiagnoseResultBy, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = navToDiagnoseResultBy.videoId;
            }
            if ((i & 2) != 0) {
                str2 = navToDiagnoseResultBy.cid;
            }
            return navToDiagnoseResultBy.copy(str, str2);
        }

        public final String component1() {
            return this.videoId;
        }

        public final String component2() {
            return this.cid;
        }

        public final NavToDiagnoseResultBy copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "videoId");
            Intrinsics.checkNotNullParameter(str2, "cid");
            return new NavToDiagnoseResultBy(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NavToDiagnoseResultBy) {
                NavToDiagnoseResultBy navToDiagnoseResultBy = (NavToDiagnoseResultBy) obj;
                return Intrinsics.areEqual(this.videoId, navToDiagnoseResultBy.videoId) && Intrinsics.areEqual(this.cid, navToDiagnoseResultBy.cid);
            }
            return false;
        }

        public int hashCode() {
            return (this.videoId.hashCode() * 31) + this.cid.hashCode();
        }

        public String toString() {
            String str = this.videoId;
            return "NavToDiagnoseResultBy(videoId=" + str + ", cid=" + this.cid + ")";
        }

        public NavToDiagnoseResultBy(String videoId, String cid) {
            Intrinsics.checkNotNullParameter(videoId, "videoId");
            Intrinsics.checkNotNullParameter(cid, "cid");
            this.videoId = videoId;
            this.cid = cid;
        }

        public final String getVideoId() {
            return this.videoId;
        }

        public final String getCid() {
            return this.cid;
        }
    }
}