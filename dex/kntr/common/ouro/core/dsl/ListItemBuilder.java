package kntr.common.ouro.core.dsl;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.OuroNodeMutableStorage;
import kntr.common.ouro.core.model.mark.OuroMarks;
import kntr.common.ouro.core.model.mark.OuroParagraphMark;
import kntr.common.ouro.core.model.node.OuroListItem;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroOrderedList;
import kntr.common.ouro.core.model.node.OuroText;
import kntr.common.ouro.core.model.node.OuroUnorderedList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroNodeDSL.kt */
@OuroNodeDslMarker
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0002\b\u0010J\u001f\u0010\u0011\u001a\u00020\t2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0002\b\u0010J\u001f\u0010\u0013\u001a\u00020\t2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\t0\u000e¢\u0006\u0002\b\u0010R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkntr/common/ouro/core/dsl/ListItemBuilder;", "", "builder", "Lkntr/common/ouro/core/model/OuroNodeMutableStorage;", "listItem", "Lkntr/common/ouro/core/model/node/OuroListItem;", "<init>", "(Lkntr/common/ouro/core/model/OuroNodeMutableStorage;Lkntr/common/ouro/core/model/node/OuroListItem;)V", "Text", "", "marks", "Lkntr/common/ouro/core/model/mark/OuroMarks;", "Lkntr/common/ouro/core/model/mark/OuroParagraphMark;", "block", "Lkotlin/Function1;", "Lkntr/common/ouro/core/dsl/ParagraphBuilder;", "Lkotlin/ExtensionFunctionType;", "OrderedList", "Lkntr/common/ouro/core/dsl/OrderedListBuilder;", "UnorderedList", "Lkntr/common/ouro/core/dsl/UnorderedListBuilder;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ListItemBuilder {
    private final OuroNodeMutableStorage<?> builder;
    private final OuroListItem listItem;

    public ListItemBuilder(OuroNodeMutableStorage<?> ouroNodeMutableStorage, OuroListItem listItem) {
        Intrinsics.checkNotNullParameter(ouroNodeMutableStorage, "builder");
        Intrinsics.checkNotNullParameter(listItem, "listItem");
        this.builder = ouroNodeMutableStorage;
        this.listItem = listItem;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void Text$default(ListItemBuilder listItemBuilder, OuroMarks ouroMarks, Function1 function1, int i, Object obj) {
        OuroMarks<OuroParagraphMark> ouroMarks2 = ouroMarks;
        if ((i & 1) != 0) {
            ouroMarks2 = OuroMarks.Empty.INSTANCE.getParagraphMarks();
        }
        listItemBuilder.Text(ouroMarks2, function1);
    }

    public final void Text(OuroMarks<OuroParagraphMark> ouroMarks, Function1<? super ParagraphBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(ouroMarks, "marks");
        Intrinsics.checkNotNullParameter(function1, "block");
        OuroText paragraph = new OuroText(ouroMarks);
        OuroNodeMutableStorage $this$Text_u24lambda_u240 = this.builder;
        $this$Text_u24lambda_u240.addChild((OuroNode.Parent<OuroListItem>) this.listItem, (OuroListItem) paragraph);
        function1.invoke(new ParagraphBuilder(this.builder, paragraph));
    }

    public final void OrderedList(Function1<? super OrderedListBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        OuroOrderedList nestedOrderedList = new OuroOrderedList(0, (OuroMarks) null, 3, (DefaultConstructorMarker) null);
        OuroNodeMutableStorage $this$OrderedList_u24lambda_u240 = this.builder;
        $this$OrderedList_u24lambda_u240.addChild((OuroNode.Parent<OuroListItem>) this.listItem, (OuroListItem) nestedOrderedList);
        function1.invoke(new OrderedListBuilder(this.builder, nestedOrderedList));
    }

    public final void UnorderedList(Function1<? super UnorderedListBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        OuroUnorderedList nestedUnorderedList = new OuroUnorderedList(0, (OuroMarks) null, 3, (DefaultConstructorMarker) null);
        OuroNodeMutableStorage $this$UnorderedList_u24lambda_u240 = this.builder;
        $this$UnorderedList_u24lambda_u240.addChild((OuroNode.Parent<OuroListItem>) this.listItem, (OuroListItem) nestedUnorderedList);
        function1.invoke(new UnorderedListBuilder(this.builder, nestedUnorderedList));
    }
}