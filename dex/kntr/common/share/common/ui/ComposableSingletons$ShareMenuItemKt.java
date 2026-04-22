package kntr.common.share.common.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.graphics.ImageBitmap;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ShareMenuItem.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ComposableSingletons$ShareMenuItemKt {
    public static final ComposableSingletons$ShareMenuItemKt INSTANCE = new ComposableSingletons$ShareMenuItemKt();

    /* renamed from: lambda$-927578050  reason: not valid java name */
    private static Function4<ImageBitmap, String, Composer, Integer, Unit> f58lambda$927578050 = ComposableLambdaKt.composableLambdaInstance(-927578050, false, new Function4() { // from class: kntr.common.share.common.ui.ComposableSingletons$ShareMenuItemKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda__927578050$lambda$0;
            lambda__927578050$lambda$0 = ComposableSingletons$ShareMenuItemKt.lambda__927578050$lambda$0((ImageBitmap) obj, (String) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda__927578050$lambda$0;
        }
    });

    /* renamed from: lambda$-720573138  reason: not valid java name */
    private static Function3<String, Composer, Integer, Unit> f57lambda$720573138 = ComposableLambdaKt.composableLambdaInstance(-720573138, false, new Function3() { // from class: kntr.common.share.common.ui.ComposableSingletons$ShareMenuItemKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda__720573138$lambda$0;
            lambda__720573138$lambda$0 = ComposableSingletons$ShareMenuItemKt.lambda__720573138$lambda$0((String) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda__720573138$lambda$0;
        }
    });
    private static Function3<String, Composer, Integer, Unit> lambda$1298894840 = ComposableLambdaKt.composableLambdaInstance(1298894840, false, new Function3() { // from class: kntr.common.share.common.ui.ComposableSingletons$ShareMenuItemKt$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_1298894840$lambda$0;
            lambda_1298894840$lambda$0 = ComposableSingletons$ShareMenuItemKt.lambda_1298894840$lambda$0((String) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_1298894840$lambda$0;
        }
    });

    /* renamed from: getLambda$-720573138$common_ui_debug  reason: not valid java name */
    public final Function3<String, Composer, Integer, Unit> m2359getLambda$720573138$common_ui_debug() {
        return f57lambda$720573138;
    }

    /* renamed from: getLambda$-927578050$common_ui_debug  reason: not valid java name */
    public final Function4<ImageBitmap, String, Composer, Integer, Unit> m2360getLambda$927578050$common_ui_debug() {
        return f58lambda$927578050;
    }

    public final Function3<String, Composer, Integer, Unit> getLambda$1298894840$common_ui_debug() {
        return lambda$1298894840;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__927578050$lambda$0(ImageBitmap bitmap, String iconUrl, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "CN(bitmap,iconUrl)38@1686L47:ShareMenuItem.kt#y4rqem");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-927578050, $changed, -1, "kntr.common.share.common.ui.ComposableSingletons$ShareMenuItemKt.lambda$-927578050.<anonymous> (ShareMenuItem.kt:38)");
        }
        ShareMenuItemKt.ShareMenuIcon(null, bitmap, iconUrl, null, $composer, (($changed << 3) & 112) | (($changed << 3) & 896), 9);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__720573138$lambda$0(String it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)41@1802L21:ShareMenuItem.kt#y4rqem");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(it) ? 4 : 2;
        }
        if (!$composer.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-720573138, $dirty, -1, "kntr.common.share.common.ui.ComposableSingletons$ShareMenuItemKt.lambda$-720573138.<anonymous> (ShareMenuItem.kt:41)");
            }
            ShareMenuItemKt.m2368ShareMenuItemNameYEplvsA(it, null, 0L, 0L, $composer, $dirty & 14, 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_1298894840$lambda$0(String it, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "CN(it)44@1897L23:ShareMenuItem.kt#y4rqem");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(it) ? 4 : 2;
        }
        int $dirty2 = $dirty;
        if (!$composer.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1298894840, $dirty2, -1, "kntr.common.share.common.ui.ComposableSingletons$ShareMenuItemKt.lambda$1298894840.<anonymous> (ShareMenuItem.kt:44)");
            }
            ShareMenuItemKt.m2367ShareMenuItemCornerQZjSdIA(it, null, 0.0f, 0L, 0L, $composer, $dirty2 & 14, 30);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}