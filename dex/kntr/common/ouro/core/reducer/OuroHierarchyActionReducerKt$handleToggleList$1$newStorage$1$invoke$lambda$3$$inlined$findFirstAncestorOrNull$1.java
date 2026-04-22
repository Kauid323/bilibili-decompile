package kntr.common.ouro.core.reducer;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.ouro.core.model.node.OuroList;
import kntr.common.ouro.core.model.node.OuroNode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OuroNodeStorage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class OuroHierarchyActionReducerKt$handleToggleList$1$newStorage$1$invoke$lambda$3$$inlined$findFirstAncestorOrNull$1 implements Function1<OuroNode.Parent<?>, Boolean> {
    public static final OuroHierarchyActionReducerKt$handleToggleList$1$newStorage$1$invoke$lambda$3$$inlined$findFirstAncestorOrNull$1 INSTANCE = new OuroHierarchyActionReducerKt$handleToggleList$1$newStorage$1$invoke$lambda$3$$inlined$findFirstAncestorOrNull$1();

    public final Boolean invoke(OuroNode.Parent<?> parent) {
        Intrinsics.checkNotNullParameter(parent, "it");
        return Boolean.valueOf(parent instanceof OuroList);
    }
}