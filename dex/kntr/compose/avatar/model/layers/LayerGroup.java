package kntr.compose.avatar.model.layers;

import BottomSheetItemData$;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayerGroup.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\nHÆ\u0003J9\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006 "}, d2 = {"Lkntr/compose/avatar/model/layers/LayerGroup;", "", "groupId", "", "layers", "", "Lkntr/compose/avatar/model/layers/Layer;", "groupMask", "Lkntr/compose/avatar/model/layers/MaskProperty;", "isCritical", "", "<init>", "(Ljava/lang/String;Ljava/util/List;Lkntr/compose/avatar/model/layers/MaskProperty;Z)V", "getGroupId", "()Ljava/lang/String;", "getLayers", "()Ljava/util/List;", "getGroupMask", "()Lkntr/compose/avatar/model/layers/MaskProperty;", "()Z", "logString", "getLogString", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class LayerGroup {
    private final String groupId;
    private final MaskProperty groupMask;
    private final boolean isCritical;
    private final List<Layer> layers;
    private final String logString;

    public LayerGroup() {
        this(null, null, null, false, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LayerGroup copy$default(LayerGroup layerGroup, String str, List list, MaskProperty maskProperty, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = layerGroup.groupId;
        }
        if ((i & 2) != 0) {
            list = layerGroup.layers;
        }
        if ((i & 4) != 0) {
            maskProperty = layerGroup.groupMask;
        }
        if ((i & 8) != 0) {
            z = layerGroup.isCritical;
        }
        return layerGroup.copy(str, list, maskProperty, z);
    }

    public final String component1() {
        return this.groupId;
    }

    public final List<Layer> component2() {
        return this.layers;
    }

    public final MaskProperty component3() {
        return this.groupMask;
    }

    public final boolean component4() {
        return this.isCritical;
    }

    public final LayerGroup copy(String str, List<Layer> list, MaskProperty maskProperty, boolean z) {
        Intrinsics.checkNotNullParameter(str, "groupId");
        Intrinsics.checkNotNullParameter(list, "layers");
        return new LayerGroup(str, list, maskProperty, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LayerGroup) {
            LayerGroup layerGroup = (LayerGroup) obj;
            return Intrinsics.areEqual(this.groupId, layerGroup.groupId) && Intrinsics.areEqual(this.layers, layerGroup.layers) && Intrinsics.areEqual(this.groupMask, layerGroup.groupMask) && this.isCritical == layerGroup.isCritical;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.groupId.hashCode() * 31) + this.layers.hashCode()) * 31) + (this.groupMask == null ? 0 : this.groupMask.hashCode())) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.isCritical);
    }

    public String toString() {
        String str = this.groupId;
        List<Layer> list = this.layers;
        MaskProperty maskProperty = this.groupMask;
        return "LayerGroup(groupId=" + str + ", layers=" + list + ", groupMask=" + maskProperty + ", isCritical=" + this.isCritical + ")";
    }

    public LayerGroup(String groupId, List<Layer> list, MaskProperty groupMask, boolean isCritical) {
        Intrinsics.checkNotNullParameter(groupId, "groupId");
        Intrinsics.checkNotNullParameter(list, "layers");
        this.groupId = groupId;
        this.layers = list;
        this.groupMask = groupMask;
        this.isCritical = isCritical;
        String str = this.groupId;
        boolean z = this.isCritical;
        this.logString = "id " + str + " critical group " + z + ", has mask " + (this.groupMask == null) + ", layer " + CollectionsKt.joinToString$default(this.layers, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: kntr.compose.avatar.model.layers.LayerGroup$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                CharSequence logString$lambda$0;
                logString$lambda$0 = LayerGroup.logString$lambda$0((Layer) obj);
                return logString$lambda$0;
            }
        }, 31, (Object) null);
    }

    public /* synthetic */ LayerGroup(String str, List list, MaskProperty maskProperty, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, (i & 4) != 0 ? null : maskProperty, (i & 8) != 0 ? false : z);
    }

    public final String getGroupId() {
        return this.groupId;
    }

    public final List<Layer> getLayers() {
        return this.layers;
    }

    public final MaskProperty getGroupMask() {
        return this.groupMask;
    }

    public final boolean isCritical() {
        return this.isCritical;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence logString$lambda$0(Layer it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getLogString();
    }

    public final String getLogString() {
        return this.logString;
    }
}