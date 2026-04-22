package kntr.app.game.steam;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.game.gamebiz.generated.resources.Drawable0_commonMainKt;
import srcs.app.game.gamebiz.generated.resources.Res;

/* compiled from: SteamGamePage.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class ComposableSingletons$SteamGamePageKt {
    public static final ComposableSingletons$SteamGamePageKt INSTANCE = new ComposableSingletons$SteamGamePageKt();
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$820870790 = ComposableLambdaKt.composableLambdaInstance(820870790, false, new Function3() { // from class: kntr.app.game.steam.ComposableSingletons$SteamGamePageKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_820870790$lambda$0;
            lambda_820870790$lambda$0 = ComposableSingletons$SteamGamePageKt.lambda_820870790$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_820870790$lambda$0;
        }
    });
    private static Function3<LazyItemScope, Composer, Integer, Unit> lambda$17793067 = ComposableLambdaKt.composableLambdaInstance(17793067, false, new Function3() { // from class: kntr.app.game.steam.ComposableSingletons$SteamGamePageKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            Unit lambda_17793067$lambda$0;
            lambda_17793067$lambda$0 = ComposableSingletons$SteamGamePageKt.lambda_17793067$lambda$0((LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            return lambda_17793067$lambda$0;
        }
    });

    /* renamed from: lambda$-1625502454  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f32lambda$1625502454 = ComposableLambdaKt.composableLambdaInstance(-1625502454, false, new Function2() { // from class: kntr.app.game.steam.ComposableSingletons$SteamGamePageKt$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__1625502454$lambda$0;
            lambda__1625502454$lambda$0 = ComposableSingletons$SteamGamePageKt.lambda__1625502454$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__1625502454$lambda$0;
        }
    });

    /* renamed from: lambda$-801948828  reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f34lambda$801948828 = ComposableLambdaKt.composableLambdaInstance(-801948828, false, new Function2() { // from class: kntr.app.game.steam.ComposableSingletons$SteamGamePageKt$$ExternalSyntheticLambda3
        public final Object invoke(Object obj, Object obj2) {
            Unit lambda__801948828$lambda$0;
            lambda__801948828$lambda$0 = ComposableSingletons$SteamGamePageKt.lambda__801948828$lambda$0((Composer) obj, ((Integer) obj2).intValue());
            return lambda__801948828$lambda$0;
        }
    });

    /* renamed from: lambda$-785933734  reason: not valid java name */
    private static Function4<ImageFailScope, ImageException, Composer, Integer, Unit> f33lambda$785933734 = ComposableLambdaKt.composableLambdaInstance(-785933734, false, new Function4() { // from class: kntr.app.game.steam.ComposableSingletons$SteamGamePageKt$$ExternalSyntheticLambda4
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit lambda__785933734$lambda$0;
            lambda__785933734$lambda$0 = ComposableSingletons$SteamGamePageKt.lambda__785933734$lambda$0((ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            return lambda__785933734$lambda$0;
        }
    });

    /* renamed from: getLambda$-1625502454$gamebiz_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1262getLambda$1625502454$gamebiz_debug() {
        return f32lambda$1625502454;
    }

    /* renamed from: getLambda$-785933734$gamebiz_debug  reason: not valid java name */
    public final Function4<ImageFailScope, ImageException, Composer, Integer, Unit> m1263getLambda$785933734$gamebiz_debug() {
        return f33lambda$785933734;
    }

    /* renamed from: getLambda$-801948828$gamebiz_debug  reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m1264getLambda$801948828$gamebiz_debug() {
        return f34lambda$801948828;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$17793067$gamebiz_debug() {
        return lambda$17793067;
    }

    public final Function3<LazyItemScope, Composer, Integer, Unit> getLambda$820870790$gamebiz_debug() {
        return lambda$820870790;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_820870790$lambda$0(LazyItemScope $this$item, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C362@15393L651:SteamGamePage.kt#xy3gb6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(820870790, $changed, -1, "kntr.app.game.steam.ComposableSingletons$SteamGamePageKt.lambda$820870790.<anonymous> (SteamGamePage.kt:362)");
            }
            Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), 0.0f, Dp.constructor-impl(100), 0.0f, 0.0f, 13, (Object) null);
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (54 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv2;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((54 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1849584988, "C369@15767L243:SteamGamePage.kt#xy3gb6");
            TextKt.Text-Nvy7gAk("暂无成就/DLCs信息", (Modifier) null, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, (Object) null), (TextAutoSize) null, TextUnitKt.getSp(14), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 24966, 0, 262122);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda_17793067$lambda$0(LazyItemScope $this$item, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$item, "$this$item");
        ComposerKt.sourceInformation($composer, "C379@16161L41:SteamGamePage.kt#xy3gb6");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(17793067, $changed, -1, "kntr.app.game.steam.ComposableSingletons$SteamGamePageKt.lambda$17793067.<anonymous> (SteamGamePage.kt:379)");
            }
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(40)), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__1625502454$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C409@16924L19,408@16879L156:SteamGamePage.kt#xy3gb6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1625502454, $changed, -1, "kntr.app.game.steam.ComposableSingletons$SteamGamePageKt.lambda$-1625502454.<anonymous> (SteamGamePage.kt:408)");
            }
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getArrow_left_line_500($composer, 6), RoomRecommendViewModel.EMPTY_CURSOR, (Modifier) null, Color.Companion.getWhite-0d7_KjU(), $composer, Painter.$stable | 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__801948828$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1157@51061L88,1156@51024L244:SteamGamePage.kt#xy3gb6");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-801948828, $changed, -1, "kntr.app.game.steam.ComposableSingletons$SteamGamePageKt.lambda$-801948828.<anonymous> (SteamGamePage.kt:1156)");
            }
            ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getCover_steam_game(Res.drawable.INSTANCE), $composer, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(52)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable | 432, 120);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit lambda__785933734$lambda$0(ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)1164@51369L88,1163@51332L244:SteamGamePage.kt#xy3gb6");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-785933734, $changed, -1, "kntr.app.game.steam.ComposableSingletons$SteamGamePageKt.lambda$-785933734.<anonymous> (SteamGamePage.kt:1163)");
        }
        ImageKt.Image(ImageResourcesKt.painterResource(Drawable0_commonMainKt.getCover_steam_game(Res.drawable.INSTANCE), $composer, 0), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(52)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, $composer, Painter.$stable | 432, 120);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}