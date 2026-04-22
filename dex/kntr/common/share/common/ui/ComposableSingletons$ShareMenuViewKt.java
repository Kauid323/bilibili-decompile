package kntr.common.share.common.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.share.common.ui.ShareChannelList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareMenuView.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$ShareMenuViewKt {
    public static final ComposableSingletons$ShareMenuViewKt INSTANCE = new ComposableSingletons$ShareMenuViewKt();

    /* renamed from: lambda$-2108017961  reason: not valid java name */
    private static Function5<ShareChannelList.Item, Modifier, Function1<? super ShareChannelList.Item, Unit>, Composer, Integer, Unit> f59lambda$2108017961 = ComposableLambdaKt.composableLambdaInstance(-2108017961, false, new Function5() { // from class: kntr.common.share.common.ui.ComposableSingletons$ShareMenuViewKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            Unit lambda__2108017961$lambda$0;
            lambda__2108017961$lambda$0 = ComposableSingletons$ShareMenuViewKt.lambda__2108017961$lambda$0((ShareChannelList.Item) obj, (Modifier) obj2, (Function1) obj3, (Composer) obj4, ((Integer) obj5).intValue());
            return lambda__2108017961$lambda$0;
        }
    });

    /* renamed from: getLambda$-2108017961$common_ui_debug  reason: not valid java name */
    public final Function5<ShareChannelList.Item, Modifier, Function1<? super ShareChannelList.Item, Unit>, Composer, Integer, Unit> m2362getLambda$2108017961$common_ui_debug() {
        return f59lambda$2108017961;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__2108017961$lambda$0(ShareChannelList.Item item, Modifier itemModifier, Function1 onItemClick, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(itemModifier, "itemModifier");
        Intrinsics.checkNotNullParameter(onItemClick, "onItemClick");
        ComposerKt.sourceInformation($composer, "CN(item,itemModifier,onItemClick)30@1093L74:ShareMenuView.kt#y4rqem");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2108017961, $changed, -1, "kntr.common.share.common.ui.ComposableSingletons$ShareMenuViewKt.lambda$-2108017961.<anonymous> (ShareMenuView.kt:30)");
        }
        ShareMenuItemKt.ShareMenuItem(item, itemModifier, null, onItemClick, $composer, ($changed & 14) | ($changed & 112) | (($changed << 3) & 7168), 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}