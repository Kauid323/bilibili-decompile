package video.biz.offline.list.logic.statemachine;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: OfflineResloveStateMachine.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0005\u0007\b\t\n\u000b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineResolvePageEvent;", "", "Upload", "UploadSuccess", "UploadFailed", "VideosLoadFailed", "VideosLoaded", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolvePageEvent$Upload;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolvePageEvent$UploadFailed;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolvePageEvent$UploadSuccess;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolvePageEvent$VideosLoadFailed;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolvePageEvent$VideosLoaded;", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface OfflineResolvePageEvent {

    /* compiled from: OfflineResloveStateMachine.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineResolvePageEvent$Upload;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolvePageEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Upload implements OfflineResolvePageEvent {
        public static final int $stable = 0;
        public static final Upload INSTANCE = new Upload();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Upload) {
                Upload upload = (Upload) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -35552674;
        }

        public String toString() {
            return "Upload";
        }

        private Upload() {
        }
    }

    /* compiled from: OfflineResloveStateMachine.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineResolvePageEvent$UploadSuccess;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolvePageEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class UploadSuccess implements OfflineResolvePageEvent {
        public static final int $stable = 0;
        public static final UploadSuccess INSTANCE = new UploadSuccess();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UploadSuccess) {
                UploadSuccess uploadSuccess = (UploadSuccess) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1147441093;
        }

        public String toString() {
            return "UploadSuccess";
        }

        private UploadSuccess() {
        }
    }

    /* compiled from: OfflineResloveStateMachine.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineResolvePageEvent$UploadFailed;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolvePageEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class UploadFailed implements OfflineResolvePageEvent {
        public static final int $stable = 0;
        public static final UploadFailed INSTANCE = new UploadFailed();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UploadFailed) {
                UploadFailed uploadFailed = (UploadFailed) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 616383547;
        }

        public String toString() {
            return "UploadFailed";
        }

        private UploadFailed() {
        }
    }

    /* compiled from: OfflineResloveStateMachine.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineResolvePageEvent$VideosLoadFailed;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolvePageEvent;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class VideosLoadFailed implements OfflineResolvePageEvent {
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
            return 733605464;
        }

        public String toString() {
            return "VideosLoadFailed";
        }

        private VideosLoadFailed() {
        }
    }

    /* compiled from: OfflineResloveStateMachine.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineResolvePageEvent$VideosLoaded;", "Lvideo/biz/offline/list/logic/statemachine/OfflineResolvePageEvent;", "videos", "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "<init>", "(Ljava/util/List;)V", "getVideos", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class VideosLoaded implements OfflineResolvePageEvent {
        public static final int $stable = 8;
        private final List<OfflineVideoEntity> videos;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ VideosLoaded copy$default(VideosLoaded videosLoaded, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = videosLoaded.videos;
            }
            return videosLoaded.copy(list);
        }

        public final List<OfflineVideoEntity> component1() {
            return this.videos;
        }

        public final VideosLoaded copy(List<OfflineVideoEntity> list) {
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

        public VideosLoaded(List<OfflineVideoEntity> list) {
            Intrinsics.checkNotNullParameter(list, "videos");
            this.videos = list;
        }

        public final List<OfflineVideoEntity> getVideos() {
            return this.videos;
        }
    }
}