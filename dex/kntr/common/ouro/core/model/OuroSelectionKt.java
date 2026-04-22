package kntr.common.ouro.core.model;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.OuroNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroSelection.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001aL\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0003\u001a\u00020\u000424\u0010\u0005\u001a0\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006j\u0002`\r¢\u0006\u0002\b\f¨\u0006\u000e"}, d2 = {"getSelection", "Lkntr/common/ouro/core/model/OuroSelection;", "Lkntr/common/ouro/core/model/OuroNodeStorage;", "textRange", "Lkntr/common/ouro/core/model/OuroTextRange;", "displayLengthTransform", "Lkotlin/Function2;", "Lkntr/common/ouro/core/model/node/OuroNode$Selectable;", "Lkotlin/ParameterName;", "name", "node", "", "Lkotlin/ExtensionFunctionType;", "Lkntr/common/ouro/core/model/DisplayLengthTransform;", "core_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroSelectionKt {
    public static final OuroSelection getSelection(OuroNodeStorage<?> ouroNodeStorage, OuroTextRange textRange, Function2<? super OuroNodeStorage<?>, ? super OuroNode.Selectable, Integer> function2) {
        DefaultConstructorMarker defaultConstructorMarker;
        int i;
        OuroPoint ouroPoint;
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(textRange, "textRange");
        Intrinsics.checkNotNullParameter(function2, "displayLengthTransform");
        List<OuroNode.Selectable> selectableList = ouroNodeStorage.getAllSelectables();
        int totalLength = 0;
        int i2 = 1;
        if (textRange.getStart() == textRange.getEnd()) {
            int i3 = 0;
            for (OuroNode.Selectable element : selectableList) {
                int index = i3;
                i3++;
                int length = ((Number) function2.invoke(ouroNodeStorage, element)).intValue();
                if (textRange.getStart() < totalLength + length) {
                    return new OuroSelection(new OuroPoint(index, textRange.getStart() - totalLength));
                }
                totalLength += length;
            }
            return new OuroSelection(new OuroPoint(selectableList.size(), 0, 2, null));
        }
        int min = textRange.getMin();
        int max = textRange.getMax();
        OuroPoint startPoint = null;
        OuroPoint endPoint = null;
        int i4 = 0;
        for (OuroNode.Selectable element2 : selectableList) {
            int index2 = i4;
            i4 += i2;
            int length2 = ((Number) function2.invoke(ouroNodeStorage, element2)).intValue();
            if (startPoint == null && min < totalLength + length2) {
                startPoint = new OuroPoint(index2, min - totalLength);
            }
            if (startPoint != null && endPoint == null && max <= totalLength + length2) {
                endPoint = new OuroPoint(index2, max - totalLength);
            }
            if (startPoint != null && endPoint != null) {
                return new OuroSelection(startPoint, endPoint, textRange.getStart() < textRange.getEnd());
            }
            totalLength += length2;
            i2 = 1;
        }
        if (startPoint == null) {
            defaultConstructorMarker = null;
            i = 2;
            ouroPoint = new OuroPoint(selectableList.size(), 0, 2, null);
        } else {
            defaultConstructorMarker = null;
            i = 2;
            ouroPoint = startPoint;
        }
        return new OuroSelection(ouroPoint, endPoint == null ? new OuroPoint(selectableList.size(), 0, i, defaultConstructorMarker) : endPoint, textRange.getStart() < textRange.getEnd());
    }
}