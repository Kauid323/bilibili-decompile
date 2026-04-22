package video.biz.offline.list.logic.statemachine;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: OfflineDiagnosePageStore.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lvideo/biz/offline/list/logic/statemachine/OfflineVideoEntityWithTag;", "", "offlineVideoEntity", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "tag", "Lvideo/biz/offline/list/logic/statemachine/Tag;", "<init>", "(Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;Lvideo/biz/offline/list/logic/statemachine/Tag;)V", "getOfflineVideoEntity", "()Lvideo/biz/offline/base/model/entity/OfflineVideoEntity;", "getTag", "()Lvideo/biz/offline/list/logic/statemachine/Tag;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "logic_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineVideoEntityWithTag {
    public static final int $stable = OfflineVideoEntity.$stable;
    private final OfflineVideoEntity offlineVideoEntity;
    private final Tag tag;

    public static /* synthetic */ OfflineVideoEntityWithTag copy$default(OfflineVideoEntityWithTag offlineVideoEntityWithTag, OfflineVideoEntity offlineVideoEntity, Tag tag, int i, Object obj) {
        if ((i & 1) != 0) {
            offlineVideoEntity = offlineVideoEntityWithTag.offlineVideoEntity;
        }
        if ((i & 2) != 0) {
            tag = offlineVideoEntityWithTag.tag;
        }
        return offlineVideoEntityWithTag.copy(offlineVideoEntity, tag);
    }

    public final OfflineVideoEntity component1() {
        return this.offlineVideoEntity;
    }

    public final Tag component2() {
        return this.tag;
    }

    public final OfflineVideoEntityWithTag copy(OfflineVideoEntity offlineVideoEntity, Tag tag) {
        Intrinsics.checkNotNullParameter(offlineVideoEntity, "offlineVideoEntity");
        Intrinsics.checkNotNullParameter(tag, "tag");
        return new OfflineVideoEntityWithTag(offlineVideoEntity, tag);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OfflineVideoEntityWithTag) {
            OfflineVideoEntityWithTag offlineVideoEntityWithTag = (OfflineVideoEntityWithTag) obj;
            return Intrinsics.areEqual(this.offlineVideoEntity, offlineVideoEntityWithTag.offlineVideoEntity) && Intrinsics.areEqual(this.tag, offlineVideoEntityWithTag.tag);
        }
        return false;
    }

    public int hashCode() {
        return (this.offlineVideoEntity.hashCode() * 31) + this.tag.hashCode();
    }

    public String toString() {
        OfflineVideoEntity offlineVideoEntity = this.offlineVideoEntity;
        return "OfflineVideoEntityWithTag(offlineVideoEntity=" + offlineVideoEntity + ", tag=" + this.tag + ")";
    }

    public OfflineVideoEntityWithTag(OfflineVideoEntity offlineVideoEntity, Tag tag) {
        Intrinsics.checkNotNullParameter(offlineVideoEntity, "offlineVideoEntity");
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.offlineVideoEntity = offlineVideoEntity;
        this.tag = tag;
    }

    public final OfflineVideoEntity getOfflineVideoEntity() {
        return this.offlineVideoEntity;
    }

    public final Tag getTag() {
        return this.tag;
    }
}