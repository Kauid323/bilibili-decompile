package kntr.app.ad.ui.search.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.color.ThemeColorsKt;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.BiliThemeKt;
import com.bilibili.compose.theme.GarbInfo;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageException;
import kntr.base.imageloader.ImageFailScope;
import kntr.base.imageloader.ImageRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.compose.resources.ImageResourcesKt;
import srcs.app.ad.ui.uikit.generated.resources.Drawable0_commonMainKt;
import srcs.app.ad.ui.uikit.generated.resources.Res;

/* compiled from: AdSearchCover.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a-\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"AdSearchCover", RoomRecommendViewModel.EMPTY_CURSOR, "url", RoomRecommendViewModel.EMPTY_CURSOR, "modifier", "Landroidx/compose/ui/Modifier;", "failPlaceholderIconSize", "Landroidx/compose/ui/unit/Dp;", "AdSearchCover-6a0pyJM", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;FLandroidx/compose/runtime/Composer;II)V", "ad-search_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AdSearchCoverKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdSearchCover_6a0pyJM$lambda$1(String str, Modifier modifier, float f, int i, int i2, Composer composer, int i3) {
        m477AdSearchCover6a0pyJM(str, modifier, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* renamed from: AdSearchCover-6a0pyJM  reason: not valid java name */
    public static final void m477AdSearchCover6a0pyJM(final String url, Modifier modifier, float f, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        float f2;
        float f3;
        Modifier modifier3;
        Modifier modifier4;
        final float f4;
        Composer $composer2 = $composer.startRestartGroup(-1640987565);
        ComposerKt.sourceInformation($composer2, "C(AdSearchCover)N(url,modifier,failPlaceholderIconSize:c#ui.unit.Dp)36@1337L972,30@1132L1184:AdSearchCover.kt#a5u0h9");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(url) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
            modifier2 = modifier;
        } else if (($changed & 48) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 4;
        if (i3 != 0) {
            $dirty |= 384;
            f2 = f;
        } else if (($changed & 384) == 0) {
            f2 = f;
            $dirty |= $composer2.changed(f2) ? 256 : 128;
        } else {
            f2 = f;
        }
        if (!$composer2.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            f3 = f2;
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 == 0) {
                f4 = f2;
            } else {
                f4 = Dp.constructor-impl(50);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1640987565, $dirty, -1, "kntr.app.ad.ui.search.components.AdSearchCover (AdSearchCover.kt:29)");
            }
            BiliImageKt.BiliImage(new ImageRequest(url == null ? RoomRecommendViewModel.EMPTY_CURSOR : url).contentScale(ContentScale.Companion.getFillBounds()).build(), modifier4, (String) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function2) null, ComposableLambdaKt.rememberComposableLambda(748963268, true, new Function4() { // from class: kntr.app.ad.ui.search.components.AdSearchCoverKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit AdSearchCover_6a0pyJM$lambda$0;
                    AdSearchCover_6a0pyJM$lambda$0 = AdSearchCoverKt.AdSearchCover_6a0pyJM$lambda$0(f4, (ImageFailScope) obj, (ImageException) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return AdSearchCover_6a0pyJM$lambda$0;
                }
            }, $composer2, 54), $composer2, ($dirty & 112) | 100663296, 252);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            f3 = f4;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final float f5 = f3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.ad.ui.search.components.AdSearchCoverKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit AdSearchCover_6a0pyJM$lambda$1;
                    AdSearchCover_6a0pyJM$lambda$1 = AdSearchCoverKt.AdSearchCover_6a0pyJM$lambda$1(url, modifier5, f5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return AdSearchCover_6a0pyJM$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AdSearchCover_6a0pyJM$lambda$0(float f, ImageFailScope $this$BiliImage, ImageException it, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        long Color;
        Intrinsics.checkNotNullParameter($this$BiliImage, "$this$BiliImage");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)41@1497L6,37@1351L948:AdSearchCover.kt#a5u0h9");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(748963268, $changed, -1, "kntr.app.ad.ui.search.components.AdSearchCover.<anonymous> (AdSearchCover.kt:37)");
        }
        Modifier modifier$iv = BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getGa2-0d7_KjU(), (Shape) null, 2, (Object) null);
        Alignment contentAlignment$iv = Alignment.Companion.getCenter();
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
        int $changed$iv$iv = (48 << 3) & 112;
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
        int i2 = ((48 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, 856191379, "C45@1632L47,50@1918L7,44@1595L690:AdSearchCover.kt#a5u0h9");
        Painter painterResource = ImageResourcesKt.painterResource(Drawable0_commonMainKt.getIc_tv_placeholder(Res.drawable.INSTANCE), $composer, 0);
        Modifier modifier = SizeKt.size-3ABfNKs(Modifier.Companion, f);
        ColorFilter.Companion companion = ColorFilter.Companion;
        CompositionLocal this_$iv = BiliThemeKt.getLocalTheme();
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object consume = $composer.consume(this_$iv);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ThemeColorsKt.isNightTheme((GarbInfo) consume)) {
            Color = ColorKt.Color(4282137660L);
        } else {
            Color = ColorKt.Color(4292138196L);
        }
        ImageKt.Image(painterResource, (String) null, modifier, (Alignment) null, ContentScale.Companion.getFillBounds(), 0.0f, ColorFilter.Companion.tint-xETnrds$default(companion, Color, 0, 2, (Object) null), $composer, Painter.$stable | 24624, 40);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}