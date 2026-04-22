package kntr.common.ouro.core.dsl;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.OuroNodeMutableStorage;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.node.OuroListItem;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroOrderedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroNodeDSL.kt */
@OuroNodeDslMarker
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\t2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0002\b\rR\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkntr/common/ouro/core/dsl/OrderedListBuilder;", "", "builder", "Lkntr/common/ouro/core/model/OuroNodeMutableStorage;", "orderedList", "Lkntr/common/ouro/core/model/node/OuroOrderedList;", "<init>", "(Lkntr/common/ouro/core/model/OuroNodeMutableStorage;Lkntr/common/ouro/core/model/node/OuroOrderedList;)V", "ListItem", "", "block", "Lkotlin/Function1;", "Lkntr/common/ouro/core/dsl/ListItemBuilder;", "Lkotlin/ExtensionFunctionType;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OrderedListBuilder {
    private final OuroNodeMutableStorage<?> builder;
    private final OuroOrderedList orderedList;

    public OrderedListBuilder(OuroNodeMutableStorage<?> ouroNodeMutableStorage, OuroOrderedList orderedList) {
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "builder");
        Intrinsics.checkNotNullParameter(orderedList, "orderedList");
        this.builder = ouroNodeMutableStorage;
        this.orderedList = orderedList;
    }

    public final void ListItem(Function1<? super ListItemBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        OuroListItem listItem = new OuroListItem((OuroMarks) null, (OuroMarks) null, 3, (DefaultConstructorMarker) null);
        OuroNodeMutableStorage $this$ListItem_u24lambda_u240 = this.builder;
        $this$ListItem_u24lambda_u240.addChild((OuroNode.Parent<OuroOrderedList>) this.orderedList, (OuroOrderedList) listItem);
        function1.invoke(new ListItemBuilder(this.builder, listItem));
    }
}