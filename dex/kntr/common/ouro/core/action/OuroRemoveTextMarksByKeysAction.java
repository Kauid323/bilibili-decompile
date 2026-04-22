package kntr.common.ouro.core.action;

import java.util.Collection;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.OuroSelection;
import kntr.common.ouro.core.model.mark.OuroMark;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroTextMarkAction.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0010\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB1\b\u0016\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u001a\u0010\u0002\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00040\t\"\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0007\u0010\nB!\b\u0016\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\fJ\u0013\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u001b\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lkntr/common/ouro/core/action/OuroRemoveTextMarksByKeysAction;", "Lkntr/common/ouro/core/action/OuroTextMarkAction;", "keys", "", "Lkntr/common/ouro/core/model/mark/OuroMark$Key;", "selection", "Lkntr/common/ouro/core/model/OuroSelection;", "<init>", "(Ljava/util/Collection;Lkntr/common/ouro/core/model/OuroSelection;)V", "", "(Lkntr/common/ouro/core/model/OuroSelection;[Lkntr/common/ouro/core/model/mark/OuroMark$Key;)V", "key", "(Lkntr/common/ouro/core/model/mark/OuroMark$Key;Lkntr/common/ouro/core/model/OuroSelection;)V", "getKeys", "()Ljava/util/Collection;", "getSelection", "()Lkntr/common/ouro/core/model/OuroSelection;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroRemoveTextMarksByKeysAction implements OuroTextMarkAction {
    private final Collection<OuroMark.Key<?>> keys;
    private final OuroSelection selection;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OuroRemoveTextMarksByKeysAction copy$default(OuroRemoveTextMarksByKeysAction ouroRemoveTextMarksByKeysAction, Collection collection, OuroSelection ouroSelection, int i, Object obj) {
        if ((i & 1) != 0) {
            collection = ouroRemoveTextMarksByKeysAction.keys;
        }
        if ((i & 2) != 0) {
            ouroSelection = ouroRemoveTextMarksByKeysAction.selection;
        }
        return ouroRemoveTextMarksByKeysAction.copy(collection, ouroSelection);
    }

    public final Collection<OuroMark.Key<?>> component1() {
        return this.keys;
    }

    public final OuroSelection component2() {
        return this.selection;
    }

    public final OuroRemoveTextMarksByKeysAction copy(Collection<? extends OuroMark.Key<?>> collection, OuroSelection ouroSelection) {
        Intrinsics.checkNotNullParameter(collection, "keys");
        return new OuroRemoveTextMarksByKeysAction(collection, ouroSelection);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OuroRemoveTextMarksByKeysAction) {
            OuroRemoveTextMarksByKeysAction ouroRemoveTextMarksByKeysAction = (OuroRemoveTextMarksByKeysAction) obj;
            return Intrinsics.areEqual(this.keys, ouroRemoveTextMarksByKeysAction.keys) && Intrinsics.areEqual(this.selection, ouroRemoveTextMarksByKeysAction.selection);
        }
        return false;
    }

    public int hashCode() {
        return (this.keys.hashCode() * 31) + (this.selection == null ? 0 : this.selection.hashCode());
    }

    public String toString() {
        Collection<OuroMark.Key<?>> collection = this.keys;
        return "OuroRemoveTextMarksByKeysAction(keys=" + collection + ", selection=" + this.selection + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OuroRemoveTextMarksByKeysAction(Collection<? extends OuroMark.Key<?>> collection, OuroSelection selection) {
        Intrinsics.checkNotNullParameter(collection, "keys");
        this.keys = collection;
        this.selection = selection;
    }

    public /* synthetic */ OuroRemoveTextMarksByKeysAction(Collection collection, OuroSelection ouroSelection, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(collection, (i & 2) != 0 ? null : ouroSelection);
    }

    public final Collection<OuroMark.Key<?>> getKeys() {
        return this.keys;
    }

    public final OuroSelection getSelection() {
        return this.selection;
    }

    public /* synthetic */ OuroRemoveTextMarksByKeysAction(OuroSelection ouroSelection, OuroMark.Key[] keyArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : ouroSelection, keyArr);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OuroRemoveTextMarksByKeysAction(OuroSelection selection, OuroMark.Key<?>... keyArr) {
        this(ArraysKt.toList(keyArr), selection);
        Intrinsics.checkNotNullParameter(keyArr, "keys");
    }

    public /* synthetic */ OuroRemoveTextMarksByKeysAction(OuroMark.Key key, OuroSelection ouroSelection, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(key, (i & 2) != 0 ? null : ouroSelection);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OuroRemoveTextMarksByKeysAction(OuroMark.Key<?> key, OuroSelection selection) {
        this(CollectionsKt.listOf(key), selection);
        Intrinsics.checkNotNullParameter(key, "key");
    }
}