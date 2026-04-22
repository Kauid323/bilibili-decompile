package kntr.common.ouro.ui.utils;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.OuroNodeStorage;
import kntr.common.ouro.core.model.node.OuroLink;
import kntr.common.ouro.core.model.node.OuroNode;
import kntr.common.ouro.core.model.node.OuroTextElement;
import kntr.common.ouro.core.model.node.drawable.OuroBoxContainer;
import kntr.common.ouro.core.model.node.drawable.OuroInlineContent;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplayLengthTransform.android.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"B\u0010\u0000\u001a0\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0001j\u0002`\t¢\u0006\u0002\b\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\"?\u0010\f\u001a0\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0001j\u0002`\t¢\u0006\u0002\b\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"androidDisplayLengthTransform", "Lkotlin/Function2;", "Lkntr/common/ouro/core/model/OuroNodeStorage;", "Lkntr/common/ouro/core/model/node/OuroNode$Selectable;", "Lkotlin/ParameterName;", "name", "node", "", "Lkotlin/ExtensionFunctionType;", "Lkntr/common/ouro/core/model/DisplayLengthTransform;", "getAndroidDisplayLengthTransform", "()Lkotlin/jvm/functions/Function2;", "uiDisplayLengthTransform", "getUiDisplayLengthTransform", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DisplayLengthTransform_androidKt {
    private static final Function2<OuroNodeStorage<?>, OuroNode.Selectable, Integer> androidDisplayLengthTransform = new Function2() { // from class: kntr.common.ouro.ui.utils.DisplayLengthTransform_androidKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            int androidDisplayLengthTransform$lambda$0;
            androidDisplayLengthTransform$lambda$0 = DisplayLengthTransform_androidKt.androidDisplayLengthTransform$lambda$0((OuroNodeStorage) obj, (OuroNode.Selectable) obj2);
            return Integer.valueOf(androidDisplayLengthTransform$lambda$0);
        }
    };
    private static final Function2<OuroNodeStorage<?>, OuroNode.Selectable, Integer> uiDisplayLengthTransform = androidDisplayLengthTransform;

    public static final Function2<OuroNodeStorage<?>, OuroNode.Selectable, Integer> getAndroidDisplayLengthTransform() {
        return androidDisplayLengthTransform;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int androidDisplayLengthTransform$lambda$0(OuroNodeStorage ouroNodeStorage, OuroNode.Selectable it) {
        Iterable children;
        int i;
        Intrinsics.checkNotNullParameter(ouroNodeStorage, "<this>");
        Intrinsics.checkNotNullParameter(it, "it");
        if (it instanceof OuroTextElement.Plain) {
            return ((OuroTextElement.Plain) it).getMeta().length();
        }
        if (it instanceof OuroTextElement.HardBreak) {
            return Intrinsics.areEqual(it, CollectionsKt.lastOrNull(ouroNodeStorage.getAllSelectables())) ? 1 : 3;
        } else if (it instanceof OuroBoxContainer) {
            return 4;
        } else {
            if (it instanceof OuroInlineContent) {
                return 1;
            }
            if ((it instanceof OuroLink) && (children = ouroNodeStorage.getChildren((OuroNode.Parent) it)) != null) {
                Iterable $this$fold$iv = children;
                int accumulator$iv = 0;
                for (Object element$iv : $this$fold$iv) {
                    OuroNode node = (OuroNode) element$iv;
                    int acc = accumulator$iv;
                    if (node instanceof OuroNode.Selectable) {
                        i = ((Number) androidDisplayLengthTransform.invoke(ouroNodeStorage, node)).intValue() + acc;
                    } else {
                        i = acc;
                    }
                    accumulator$iv = i;
                }
                return accumulator$iv;
            }
            return 0;
        }
    }

    public static final Function2<OuroNodeStorage<?>, OuroNode.Selectable, Integer> getUiDisplayLengthTransform() {
        return uiDisplayLengthTransform;
    }
}