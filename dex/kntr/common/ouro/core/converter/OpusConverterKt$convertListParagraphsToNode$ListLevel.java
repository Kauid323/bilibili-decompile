package kntr.common.ouro.core.converter;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.OuroList;
import kntr.common.ouro.core.model.node.OuroListItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OpusConverter.kt */
@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J.\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"kntr/common/ouro/core/converter/OpusConverterKt$convertListParagraphsToNode$ListLevel", "", "list", "Lkntr/common/ouro/core/model/node/OuroList;", "level", "", "currentListItem", "Lkntr/common/ouro/core/model/node/OuroListItem;", "<init>", "(Lkntr/common/ouro/core/model/node/OuroList;ILkntr/common/ouro/core/model/node/OuroListItem;)V", "getList", "()Lkntr/common/ouro/core/model/node/OuroList;", "getLevel", "()I", "getCurrentListItem", "()Lkntr/common/ouro/core/model/node/OuroListItem;", "component1", "component2", "component3", "copy", "(Lkntr/common/ouro/core/model/node/OuroList;ILkntr/common/ouro/core/model/node/OuroListItem;)Lkntr/common/ouro/core/converter/OpusConverterKt$convertListParagraphsToNode$ListLevel;", "equals", "", "other", "hashCode", "toString", "", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OpusConverterKt$convertListParagraphsToNode$ListLevel {
    private final OuroListItem currentListItem;
    private final int level;
    private final OuroList list;

    public static /* synthetic */ OpusConverterKt$convertListParagraphsToNode$ListLevel copy$default(OpusConverterKt$convertListParagraphsToNode$ListLevel opusConverterKt$convertListParagraphsToNode$ListLevel, OuroList ouroList, int i, OuroListItem ouroListItem, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            ouroList = opusConverterKt$convertListParagraphsToNode$ListLevel.list;
        }
        if ((i2 & 2) != 0) {
            i = opusConverterKt$convertListParagraphsToNode$ListLevel.level;
        }
        if ((i2 & 4) != 0) {
            ouroListItem = opusConverterKt$convertListParagraphsToNode$ListLevel.currentListItem;
        }
        return opusConverterKt$convertListParagraphsToNode$ListLevel.copy(ouroList, i, ouroListItem);
    }

    public final OuroList component1() {
        return this.list;
    }

    public final int component2() {
        return this.level;
    }

    public final OuroListItem component3() {
        return this.currentListItem;
    }

    public final OpusConverterKt$convertListParagraphsToNode$ListLevel copy(OuroList ouroList, int i, OuroListItem ouroListItem) {
        Intrinsics.checkNotNullParameter(ouroList, "list");
        return new OpusConverterKt$convertListParagraphsToNode$ListLevel(ouroList, i, ouroListItem);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OpusConverterKt$convertListParagraphsToNode$ListLevel) {
            OpusConverterKt$convertListParagraphsToNode$ListLevel opusConverterKt$convertListParagraphsToNode$ListLevel = (OpusConverterKt$convertListParagraphsToNode$ListLevel) obj;
            return Intrinsics.areEqual(this.list, opusConverterKt$convertListParagraphsToNode$ListLevel.list) && this.level == opusConverterKt$convertListParagraphsToNode$ListLevel.level && Intrinsics.areEqual(this.currentListItem, opusConverterKt$convertListParagraphsToNode$ListLevel.currentListItem);
        }
        return false;
    }

    public int hashCode() {
        return (((this.list.hashCode() * 31) + this.level) * 31) + (this.currentListItem == null ? 0 : this.currentListItem.hashCode());
    }

    public String toString() {
        OuroList ouroList = this.list;
        int i = this.level;
        return "ListLevel(list=" + ouroList + ", level=" + i + ", currentListItem=" + this.currentListItem + ")";
    }

    public OpusConverterKt$convertListParagraphsToNode$ListLevel(OuroList list, int level, OuroListItem currentListItem) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
        this.level = level;
        this.currentListItem = currentListItem;
    }

    public final OuroList getList() {
        return this.list;
    }

    public final int getLevel() {
        return this.level;
    }

    public final OuroListItem getCurrentListItem() {
        return this.currentListItem;
    }
}