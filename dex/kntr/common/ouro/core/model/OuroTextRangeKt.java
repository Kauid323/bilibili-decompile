package kntr.common.ouro.core.model;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.OuroNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroTextRange.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aL\u0010\t\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u000b\u001a\u00020\f24\u0010\r\u001a0\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0001j\u0002`\u000e¢\u0006\u0002\b\b*^\u0010\u0000\",\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0001¢\u0006\u0002\b\b2,\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0001¢\u0006\u0002\b\b¨\u0006\u000f"}, d2 = {"DisplayLengthTransform", "Lkotlin/Function2;", "Lkntr/common/ouro/core/model/OuroNodeStorage;", "Lkntr/common/ouro/core/model/node/OuroNode$Selectable;", "Lkotlin/ParameterName;", "name", "node", "", "Lkotlin/ExtensionFunctionType;", "getTextRange", "Lkntr/common/ouro/core/model/OuroTextRange;", "selection", "Lkntr/common/ouro/core/model/OuroSelection;", "displayLengthTransform", "Lkntr/common/ouro/core/model/DisplayLengthTransform;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroTextRangeKt {
    public static final OuroTextRange getTextRange(OuroNodeStorage<?> ouroNodeStorage, OuroSelection selection, Function2<? super OuroNodeStorage<?>, ? super OuroNode.Selectable, Integer> function2) {
        int end;
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(selection, "selection");
        Intrinsics.checkNotNullParameter(function2, "displayLengthTransform");
        List selectableList = ouroNodeStorage.getAllSelectables();
        int start = getTextRange$calcOffset(selectableList, function2, ouroNodeStorage, selection.getAnchor().getIndex(), selection.getAnchor().getOffset());
        if (selection.isCollapsed()) {
            end = start;
        } else {
            end = getTextRange$calcOffset(selectableList, function2, ouroNodeStorage, selection.getFocus().getIndex(), selection.getFocus().getOffset());
        }
        return new OuroTextRange(start, end);
    }

    private static final int getTextRange$calcOffset(List<? extends OuroNode.Selectable> list, Function2<? super OuroNodeStorage<?>, ? super OuroNode.Selectable, Integer> function2, OuroNodeStorage<?> ouroNodeStorage, int index, int offset) {
        int i = 0;
        for (OuroNode.Selectable it : list.subList(0, index)) {
            i += ((Number) function2.invoke(ouroNodeStorage, it)).intValue();
        }
        return i + offset;
    }
}