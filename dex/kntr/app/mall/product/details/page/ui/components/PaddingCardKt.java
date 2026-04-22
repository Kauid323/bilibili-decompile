package kntr.app.mall.product.details.page.ui.components;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import kntr.app.mall.product.details.page.utils.ThemesKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.net.comm.flowcontrol.internal.backoff.BackoffConfigKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: PaddingCard.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aU\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\u001e\b\u0002\u0010\t\u001a\u0018\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0002\b\f¢\u0006\u0002\b\rH\u0001¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"PaddingCard", "", "modifier", "Landroidx/compose/ui/Modifier;", "marginValues", "Landroidx/compose/foundation/layout/PaddingValues;", "contentPadding", "cardShape", "Landroidx/compose/ui/graphics/Shape;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class PaddingCardKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaddingCard$lambda$1(Modifier modifier, PaddingValues paddingValues, PaddingValues paddingValues2, Shape shape, Function3 function3, int i, int i2, Composer composer, int i3) {
        PaddingCard(modifier, paddingValues, paddingValues2, shape, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void PaddingCard(Modifier modifier, PaddingValues marginValues, PaddingValues contentPadding, Shape cardShape, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> function3, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        PaddingValues paddingValues;
        PaddingValues contentPadding2;
        Shape cardShape2;
        Function3 function32;
        PaddingValues contentPadding3;
        Function3 content;
        Modifier modifier3;
        Shape cardShape3;
        PaddingValues marginValues2;
        Modifier modifier4;
        PaddingValues marginValues3;
        int $dirty;
        final PaddingValues contentPadding4;
        Shape cardShape4;
        final Function3 content2;
        int i2;
        Composer $composer2 = $composer.startRestartGroup(-519647290);
        ComposerKt.sourceInformation($composer2, "C(PaddingCard)N(modifier,marginValues,contentPadding,cardShape,content)39@1244L18,40@1270L98,33@1080L288:PaddingCard.kt#o90vz8");
        int $dirty2 = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty2 |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty2 |= 48;
            paddingValues = marginValues;
        } else if (($changed & 48) == 0) {
            paddingValues = marginValues;
            $dirty2 |= $composer2.changed(paddingValues) ? 32 : 16;
        } else {
            paddingValues = marginValues;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty2 |= 384;
            contentPadding2 = contentPadding;
        } else if (($changed & 384) == 0) {
            contentPadding2 = contentPadding;
            $dirty2 |= $composer2.changed(contentPadding2) ? 256 : 128;
        } else {
            contentPadding2 = contentPadding;
        }
        if (($changed & 3072) == 0) {
            if ((i & 8) == 0) {
                cardShape2 = cardShape;
                if ($composer2.changed(cardShape2)) {
                    i2 = 2048;
                    $dirty2 |= i2;
                }
            } else {
                cardShape2 = cardShape;
            }
            i2 = 1024;
            $dirty2 |= i2;
        } else {
            cardShape2 = cardShape;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= 24576;
            function32 = function3;
        } else if (($changed & 24576) == 0) {
            function32 = function3;
            $dirty2 |= $composer2.changedInstance(function32) ? 16384 : 8192;
        } else {
            function32 = function3;
        }
        if (!$composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            contentPadding3 = contentPadding2;
            content = function32;
            modifier3 = modifier2;
            cardShape3 = cardShape2;
            marginValues2 = paddingValues;
        } else {
            $composer2.startDefaults();
            if (($changed & 1) != 0 && !$composer2.getDefaultsInvalid()) {
                $composer2.skipToGroupEnd();
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                }
                $dirty = $dirty2;
                modifier4 = modifier2;
                marginValues3 = paddingValues;
                contentPadding4 = contentPadding2;
                cardShape4 = cardShape2;
                content2 = function32;
            } else {
                if (i3 != 0) {
                    modifier4 = (Modifier) Modifier.Companion;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 == 0) {
                    marginValues3 = paddingValues;
                } else {
                    marginValues3 = PaddingKt.PaddingValues-a9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.constructor-impl(8), 7, (Object) null);
                }
                if (i5 != 0) {
                    contentPadding2 = PaddingKt.PaddingValues-YgX7TsA(Dp.constructor-impl(12), Dp.constructor-impl(16));
                }
                if ((i & 8) != 0) {
                    $dirty2 &= -7169;
                    cardShape2 = (Shape) RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12));
                }
                if (i6 != 0) {
                    $dirty = $dirty2;
                    content2 = ComposableSingletons$PaddingCardKt.INSTANCE.getLambda$1767857282$product_details_page_debug();
                    contentPadding4 = contentPadding2;
                    cardShape4 = cardShape2;
                } else {
                    $dirty = $dirty2;
                    contentPadding4 = contentPadding2;
                    cardShape4 = cardShape2;
                    content2 = function32;
                }
            }
            $composer2.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-519647290, $dirty, -1, "kntr.app.mall.product.details.page.ui.components.PaddingCard (PaddingCard.kt:32)");
            }
            SurfaceKt.Surface-T9BRK9s(PaddingKt.padding(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, (Object) null), marginValues3), cardShape4, ThemesKt.getPageCardColor($composer2, 0), 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(-850393909, true, new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.PaddingCardKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit PaddingCard$lambda$0;
                    PaddingCard$lambda$0 = PaddingCardKt.PaddingCard$lambda$0(contentPadding4, content2, (Composer) obj, ((Integer) obj2).intValue());
                    return PaddingCard$lambda$0;
                }
            }, $composer2, 54), $composer2, (($dirty >> 6) & 112) | 12582912, (int) BackoffConfigKt.MAX_DELAY_SECONDS);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contentPadding3 = contentPadding4;
            modifier3 = modifier4;
            marginValues2 = marginValues3;
            cardShape3 = cardShape4;
            content = content2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final PaddingValues paddingValues2 = marginValues2;
            final PaddingValues paddingValues3 = contentPadding3;
            final Shape shape = cardShape3;
            final Function3 function33 = content;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.PaddingCardKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit PaddingCard$lambda$1;
                    PaddingCard$lambda$1 = PaddingCardKt.PaddingCard$lambda$1(modifier5, paddingValues2, paddingValues3, shape, function33, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return PaddingCard$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PaddingCard$lambda$0(PaddingValues $contentPadding, Function3 $content, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        ComposerKt.sourceInformation($composer, "C41@1280L82:PaddingCard.kt#o90vz8");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-850393909, $changed, -1, "kntr.app.mall.product.details.page.ui.components.PaddingCard.<anonymous> (PaddingCard.kt:41)");
            }
            Modifier modifier$iv = PaddingKt.padding(Modifier.Companion, $contentPadding);
            ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
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
            BoxScope $this$PaddingCard_u24lambda_u240_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, 91937001, "C42@1343L9:PaddingCard.kt#o90vz8");
            $content.invoke($this$PaddingCard_u24lambda_u240_u240, $composer, Integer.valueOf((((0 >> 6) & 112) | 6) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}