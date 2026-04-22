package video.biz.offline.base.infra.storage.diskfile;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.uuid.Uuid;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.infra.storage.diskfile.model.DramaGroupModel;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileDataStorage.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0015\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J9\u0010\u001c\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\nHÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006#"}, d2 = {"Lvideo/biz/offline/base/infra/storage/diskfile/FileDataContent;", "", "videos", "", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "dramas", "", "", "Lvideo/biz/offline/base/infra/storage/diskfile/model/DramaGroupModel;", "id", "", "<init>", "(Ljava/util/List;Ljava/util/Map;Ljava/lang/String;)V", "getVideos", "()Ljava/util/List;", "setVideos", "(Ljava/util/List;)V", "getDramas", "()Ljava/util/Map;", "setDramas", "(Ljava/util/Map;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class FileDataContent {
    private Map<Long, DramaGroupModel> dramas;
    private String id;
    private List<OfflineVideoEntity> videos;

    public FileDataContent() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FileDataContent copy$default(FileDataContent fileDataContent, List list, Map map, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = fileDataContent.videos;
        }
        if ((i & 2) != 0) {
            map = fileDataContent.dramas;
        }
        if ((i & 4) != 0) {
            str = fileDataContent.id;
        }
        return fileDataContent.copy(list, map, str);
    }

    public final List<OfflineVideoEntity> component1() {
        return this.videos;
    }

    public final Map<Long, DramaGroupModel> component2() {
        return this.dramas;
    }

    public final String component3() {
        return this.id;
    }

    public final FileDataContent copy(List<OfflineVideoEntity> list, Map<Long, DramaGroupModel> map, String str) {
        Intrinsics.checkNotNullParameter(list, "videos");
        Intrinsics.checkNotNullParameter(map, "dramas");
        Intrinsics.checkNotNullParameter(str, "id");
        return new FileDataContent(list, map, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FileDataContent) {
            FileDataContent fileDataContent = (FileDataContent) obj;
            return Intrinsics.areEqual(this.videos, fileDataContent.videos) && Intrinsics.areEqual(this.dramas, fileDataContent.dramas) && Intrinsics.areEqual(this.id, fileDataContent.id);
        }
        return false;
    }

    public int hashCode() {
        return (((this.videos.hashCode() * 31) + this.dramas.hashCode()) * 31) + this.id.hashCode();
    }

    public String toString() {
        List<OfflineVideoEntity> list = this.videos;
        Map<Long, DramaGroupModel> map = this.dramas;
        return "FileDataContent(videos=" + list + ", dramas=" + map + ", id=" + this.id + ")";
    }

    public FileDataContent(List<OfflineVideoEntity> list, Map<Long, DramaGroupModel> map, String id) {
        Intrinsics.checkNotNullParameter(list, "videos");
        Intrinsics.checkNotNullParameter(map, "dramas");
        Intrinsics.checkNotNullParameter(id, "id");
        this.videos = list;
        this.dramas = map;
        this.id = id;
    }

    public /* synthetic */ FileDataContent(List list, Map map, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? MapsKt.emptyMap() : map, (i & 4) != 0 ? Uuid.Companion.random().toString() : str);
    }

    public final List<OfflineVideoEntity> getVideos() {
        return this.videos;
    }

    public final void setVideos(List<OfflineVideoEntity> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.videos = list;
    }

    public final Map<Long, DramaGroupModel> getDramas() {
        return this.dramas;
    }

    public final void setDramas(Map<Long, DramaGroupModel> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.dramas = map;
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.id = str;
    }
}