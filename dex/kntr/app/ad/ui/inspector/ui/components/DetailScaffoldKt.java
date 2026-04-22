package kntr.app.ad.ui.inspector.ui.components;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kntr.app.ad.ui.inspector.model.UserRole;
import kntr.app.ad.ui.inspector.ui.LocalUserRoleKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DetailScaffold.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\\\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u001e\b\u0002\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\t¢\u0006\u0002\b\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\b\tH\u0001¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"DetailScaffold", RoomRecommendViewModel.EMPTY_CURSOR, "title", RoomRecommendViewModel.EMPTY_CURSOR, "onBack", "Lkotlin/Function0;", "actions", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "content", "Landroidx/compose/foundation/layout/PaddingValues;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ad-inspector_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DetailScaffoldKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetailScaffold$lambda$1(String str, Function0 function0, Function3 function3, Function3 function32, int i, int i2, Composer composer, int i3) {
        DetailScaffold(str, function0, function3, function32, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void DetailScaffold(final String title, final Function0<Unit> function0, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function32, Composer $composer, final int $changed, final int i) {
        Function3 function33;
        Function3 actions;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(function0, "onBack");
        Intrinsics.checkNotNullParameter(function32, "content");
        Composer $composer2 = $composer.startRestartGroup(358388779);
        ComposerKt.sourceInformation($composer2, "C(DetailScaffold)N(title,onBack,actions,content)27@983L835,26@956L940:DetailScaffold.kt#pigpjk");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            function33 = function3;
        } else if (($changed & 384) == 0) {
            function33 = function3;
            $dirty |= $composer2.changedInstance(function33) ? 256 : 128;
        } else {
            function33 = function3;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function32) ? 2048 : 1024;
        }
        if (!$composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            actions = function33;
        } else {
            final Function3 actions2 = i2 != 0 ? ComposableSingletons$DetailScaffoldKt.INSTANCE.m392getLambda$698047502$ad_inspector_debug() : function33;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(358388779, $dirty, -1, "kntr.app.ad.ui.inspector.ui.components.DetailScaffold (DetailScaffold.kt:25)");
            }
            ScaffoldKt.Scaffold-TvnljyQ((Modifier) null, ComposableLambdaKt.rememberComposableLambda(1834344423, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.components.DetailScaffoldKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DetailScaffold$lambda$0;
                    DetailScaffold$lambda$0 = DetailScaffoldKt.DetailScaffold$lambda$0(actions2, title, function0, (Composer) obj, ((Integer) obj2).intValue());
                    return DetailScaffold$lambda$0;
                }
            }, $composer2, 54), (Function2) null, (Function2) null, (Function2) null, 0, ColorKt.Color(4294572795L), 0L, (WindowInsets) null, function32, $composer2, (($dirty << 18) & 1879048192) | 1572912, 445);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            actions = actions2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Function3 function34 = actions;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.inspector.ui.components.DetailScaffoldKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit DetailScaffold$lambda$1;
                    DetailScaffold$lambda$1 = DetailScaffoldKt.DetailScaffold$lambda$1(title, function0, function34, function32, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return DetailScaffold$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetailScaffold$lambda$0(final Function3 $actions, final String $title, final Function0 $onBack, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C31@1099L709,28@997L811:DetailScaffold.kt#pigpjk");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1834344423, $changed, -1, "kntr.app.ad.ui.inspector.ui.components.DetailScaffold.<anonymous> (DetailScaffold.kt:28)");
            }
            SurfaceKt.Surface-T9BRK9s((Modifier) null, (Shape) null, Color.Companion.getWhite-0d7_KjU(), 0L, 0.0f, Dp.constructor-impl((float) 0.5d), (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(348242156, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.components.DetailScaffoldKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit DetailScaffold$lambda$0$0;
                    DetailScaffold$lambda$0$0 = DetailScaffoldKt.DetailScaffold$lambda$0$0($actions, $title, $onBack, (Composer) obj, ((Integer) obj2).intValue());
                    return DetailScaffold$lambda$0$0;
                }
            }, $composer, 54), $composer, 12779904, 91);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetailScaffold$lambda$0$0(Function3 $actions, final String $title, final Function0 $onBack, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C33@1156L33,34@1228L186,44@1735L7,41@1526L249,32@1117L677:DetailScaffold.kt#pigpjk");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(348242156, $changed, -1, "kntr.app.ad.ui.inspector.ui.components.DetailScaffold.<anonymous>.<anonymous> (DetailScaffold.kt:32)");
            }
            Function2 rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(2087685032, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.components.DetailScaffoldKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit DetailScaffold$lambda$0$0$0;
                    DetailScaffold$lambda$0$0$0 = DetailScaffoldKt.DetailScaffold$lambda$0$0$0($title, (Composer) obj, ((Integer) obj2).intValue());
                    return DetailScaffold$lambda$0$0$0;
                }
            }, $composer, 54);
            Function2 rememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(151763174, true, new Function2() { // from class: kntr.app.ad.ui.inspector.ui.components.DetailScaffoldKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit DetailScaffold$lambda$0$0$1;
                    DetailScaffold$lambda$0$0$1 = DetailScaffoldKt.DetailScaffold$lambda$0$0$1($onBack, (Composer) obj, ((Integer) obj2).intValue());
                    return DetailScaffold$lambda$0$0$1;
                }
            }, $composer, 54);
            TopAppBarDefaults topAppBarDefaults = TopAppBarDefaults.INSTANCE;
            long j2 = Color.Companion.getWhite-0d7_KjU();
            long Color = ColorKt.Color(4279310375L);
            CompositionLocal this_$iv = LocalUserRoleKt.getLocalUserRole();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            AppBarKt.TopAppBar-gNPyAyM(rememberComposableLambda, (Modifier) null, rememberComposableLambda2, $actions, 0.0f, (WindowInsets) null, topAppBarDefaults.topAppBarColors-5tl4gsc(j2, 0L, 0L, Color, ((UserRole) consume).m353getColor0d7_KjU(), 0L, $composer, (TopAppBarDefaults.$stable << 18) | 3078, 38), (TopAppBarScrollBehavior) null, (PaddingValues) null, $composer, 390, 434);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetailScaffold$lambda$0$0$0(String $title, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C33@1158L29:DetailScaffold.kt#pigpjk");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2087685032, $changed, -1, "kntr.app.ad.ui.inspector.ui.components.DetailScaffold.<anonymous>.<anonymous>.<anonymous> (DetailScaffold.kt:33)");
            }
            TextKt.Text-Nvy7gAk($title, (Modifier) null, 0L, (TextAutoSize) null, TextUnitKt.getSp(20), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 24576, 0, 262126);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetailScaffold$lambda$0$0$1(Function0 $onBack, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C35@1254L138:DetailScaffold.kt#pigpjk");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(151763174, $changed, -1, "kntr.app.ad.ui.inspector.ui.components.DetailScaffold.<anonymous>.<anonymous>.<anonymous> (DetailScaffold.kt:35)");
            }
            IconButtonKt.IconButton($onBack, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableSingletons$DetailScaffoldKt.INSTANCE.m391getLambda$2095145208$ad_inspector_debug(), $composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}