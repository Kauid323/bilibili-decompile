package kntr.compose.avatar.model;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.compose.avatar.model.common.SizeSpec;
import kntr.compose.avatar.model.layers.LayerGroup;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: AvatarItem.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003J9\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lkntr/compose/avatar/model/AvatarItem;", "", "mid", "", "size", "Lkntr/compose/avatar/model/common/SizeSpec;", "groups", "", "Lkntr/compose/avatar/model/layers/LayerGroup;", "fallbackGroup", "<init>", "(JLkntr/compose/avatar/model/common/SizeSpec;Ljava/util/List;Lkntr/compose/avatar/model/layers/LayerGroup;)V", "getMid", "()J", "getSize", "()Lkntr/compose/avatar/model/common/SizeSpec;", "getGroups", "()Ljava/util/List;", "getFallbackGroup", "()Lkntr/compose/avatar/model/layers/LayerGroup;", "outSize", "", "getOutSize", "()F", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class AvatarItem {
    private final LayerGroup fallbackGroup;
    private final List<LayerGroup> groups;
    private final long mid;
    private final SizeSpec size;

    public AvatarItem() {
        this(0L, null, null, null, 15, null);
    }

    public static /* synthetic */ AvatarItem copy$default(AvatarItem avatarItem, long j, SizeSpec sizeSpec, List list, LayerGroup layerGroup, int i, Object obj) {
        if ((i & 1) != 0) {
            j = avatarItem.mid;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            sizeSpec = avatarItem.size;
        }
        SizeSpec sizeSpec2 = sizeSpec;
        List<LayerGroup> list2 = list;
        if ((i & 4) != 0) {
            list2 = avatarItem.groups;
        }
        List list3 = list2;
        if ((i & 8) != 0) {
            layerGroup = avatarItem.fallbackGroup;
        }
        return avatarItem.copy(j2, sizeSpec2, list3, layerGroup);
    }

    public final long component1() {
        return this.mid;
    }

    public final SizeSpec component2() {
        return this.size;
    }

    public final List<LayerGroup> component3() {
        return this.groups;
    }

    public final LayerGroup component4() {
        return this.fallbackGroup;
    }

    public final AvatarItem copy(long j, SizeSpec sizeSpec, List<LayerGroup> list, LayerGroup layerGroup) {
        Intrinsics.checkNotNullParameter(sizeSpec, "size");
        Intrinsics.checkNotNullParameter(list, "groups");
        return new AvatarItem(j, sizeSpec, list, layerGroup);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AvatarItem) {
            AvatarItem avatarItem = (AvatarItem) obj;
            return this.mid == avatarItem.mid && Intrinsics.areEqual(this.size, avatarItem.size) && Intrinsics.areEqual(this.groups, avatarItem.groups) && Intrinsics.areEqual(this.fallbackGroup, avatarItem.fallbackGroup);
        }
        return false;
    }

    public int hashCode() {
        return (((((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.mid) * 31) + this.size.hashCode()) * 31) + this.groups.hashCode()) * 31) + (this.fallbackGroup == null ? 0 : this.fallbackGroup.hashCode());
    }

    public String toString() {
        long j = this.mid;
        SizeSpec sizeSpec = this.size;
        List<LayerGroup> list = this.groups;
        return "AvatarItem(mid=" + j + ", size=" + sizeSpec + ", groups=" + list + ", fallbackGroup=" + this.fallbackGroup + ")";
    }

    public AvatarItem(long mid, SizeSpec size, List<LayerGroup> list, LayerGroup fallbackGroup) {
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(list, "groups");
        this.mid = mid;
        this.size = size;
        this.groups = list;
        this.fallbackGroup = fallbackGroup;
    }

    public /* synthetic */ AvatarItem(long j, SizeSpec sizeSpec, List list, LayerGroup layerGroup, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? -1L : j, (i & 2) != 0 ? new SizeSpec(0.0f, 0.0f, 3, null) : sizeSpec, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? null : layerGroup);
    }

    public final long getMid() {
        return this.mid;
    }

    public final SizeSpec getSize() {
        return this.size;
    }

    public final List<LayerGroup> getGroups() {
        return this.groups;
    }

    public final LayerGroup getFallbackGroup() {
        return this.fallbackGroup;
    }

    public final float getOutSize() {
        return RangesKt.coerceAtLeast(this.size.getWidth(), this.size.getHeight());
    }
}