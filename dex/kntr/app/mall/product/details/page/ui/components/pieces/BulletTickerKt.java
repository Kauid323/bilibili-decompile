package kntr.app.mall.product.details.page.ui.components.pieces;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import java.util.List;
import kntr.app.mall.product.details.page.api.model.BasicInfoFloor;
import kntr.app.mall.product.details.page.ui.scale.ProvideUiScaleKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BulletTicker.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u008e\u0002"}, d2 = {"BulletTicker", "", "Landroidx/compose/foundation/layout/BoxScope;", "topPadding", "Landroidx/compose/ui/unit/Dp;", "bulletScreenList", "", "Lkntr/app/mall/product/details/page/api/model/BasicInfoFloor$BulletScreen$BulletItem;", "scale", "", "modifier", "Landroidx/compose/ui/Modifier;", "BulletTicker-EUb7tLY", "(Landroidx/compose/foundation/layout/BoxScope;FLjava/util/List;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "product-details-page_debug", "index", ""}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class BulletTickerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BulletTicker_EUb7tLY$lambda$0(BoxScope boxScope, float f, List list, float f2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m544BulletTickerEUb7tLY(boxScope, f, list, f2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BulletTicker_EUb7tLY$lambda$7(BoxScope boxScope, float f, List list, float f2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m544BulletTickerEUb7tLY(boxScope, f, list, f2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* renamed from: BulletTicker-EUb7tLY  reason: not valid java name */
    public static final void m544BulletTickerEUb7tLY(final BoxScope $this$BulletTicker_u2dEUb7tLY, final float f, final List<BasicInfoFloor.BulletScreen.BulletItem> list, final float scale, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$BulletTicker_u2dEUb7tLY, "$this$BulletTicker");
        Intrinsics.checkNotNullParameter(list, "bulletScreenList");
        Composer $composer2 = $composer.startRestartGroup(-656186097);
        ComposerKt.sourceInformation($composer2, "C(BulletTicker)N(topPadding:c#ui.unit.Dp,bulletScreenList,scale,modifier)42@1685L51,43@1753L27,49@1883L740,49@1850L773,74@2638L909:BulletTicker.kt#v057zd");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$BulletTicker_u2dEUb7tLY) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(f) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(scale) ? 2048 : 1024;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 9363) != 9362, $dirty2 & 1)) {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-656186097, $dirty2, -1, "kntr.app.mall.product.details.page.ui.components.pieces.BulletTicker (BulletTicker.kt:39)");
            }
            if (!list.isEmpty()) {
                ComposerKt.sourceInformationMarkerStart($composer2, 765360802, "CC(remember):BulletTicker.kt#9igjgp");
                boolean invalid$iv = $composer2.changed(list);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = SnapshotIntStateKt.mutableIntStateOf(0);
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                MutableIntState index$delegate = (MutableIntState) it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, 765362954, "CC(remember):BulletTicker.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = AnimatableKt.Animatable$default(1.0f, 0.0f, 2, (Object) null);
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Animatable alpha = (Animatable) it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, 765367827, "CC(remember):BulletTicker.kt#9igjgp");
                boolean invalid$iv2 = $composer2.changedInstance(list) | $composer2.changedInstance(alpha) | $composer2.changed(index$delegate);
                Object value$iv3 = $composer2.rememberedValue();
                if (invalid$iv2 || value$iv3 == Composer.Companion.getEmpty()) {
                    value$iv3 = new BulletTickerKt$BulletTicker$2$1(list, 2000, 250, alpha, index$delegate, null);
                    $composer2.updateRememberedValue(value$iv3);
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                EffectsKt.LaunchedEffect(list, (Function2) value$iv3, $composer2, ($dirty2 >> 6) & 14);
                Modifier modifier$iv = PaddingKt.padding-qDBjuR0$default(BackgroundKt.background-bw27NRU(AlphaKt.alpha(SizeKt.height-3ABfNKs(OffsetKt.offset-VpY3zN4($this$BulletTicker_u2dEUb7tLY.align(modifier3, Alignment.Companion.getTopStart()), ProvideUiScaleKt.dpScaled(12, scale), Dp.constructor-impl(Dp.constructor-impl(f + ProvideUiScaleKt.dpScaled(44, scale)) + ProvideUiScaleKt.dpScaled(18, scale))), ProvideUiScaleKt.dpScaled(24, scale)), ((Number) alpha.getValue()).floatValue()), Color.copy-wmQWz5c$default(ColorKt.Color(4284177243L), 0.7f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape(50)), ProvideUiScaleKt.dpScaled(24, scale), 0.0f, ProvideUiScaleKt.dpScaled(8, scale), 0.0f, 10, (Object) null);
                Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                int $changed$iv$iv = (48 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
                Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startReusableNode();
                if ($composer2.getInserting()) {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
                    $composer2.createNode(factory$iv$iv$iv);
                } else {
                    factory$iv$iv$iv = factory$iv$iv$iv2;
                    $composer2.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                int i3 = ($changed$iv$iv$iv >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScope boxScope = BoxScopeInstance.INSTANCE;
                int i4 = ((48 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer2, 301445821, "C88@3224L317:BulletTicker.kt#v057zd");
                BasicInfoFloor.BulletScreen.BulletItem bulletItem = (BasicInfoFloor.BulletScreen.BulletItem) CollectionsKt.getOrNull(list, BulletTicker_EUb7tLY$lambda$2(index$delegate));
                String message = bulletItem != null ? bulletItem.getMessage() : null;
                if (message == null) {
                    message = "";
                }
                TextKt.Text-Nvy7gAk(message, (Modifier) null, Color.Companion.getWhite-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 1, 0, (Function1) null, ProvideUiScaleKt.scaled(new TextStyle(0L, TextUnitKt.getSp(12), FontWeight.Companion.getNormal(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777209, (DefaultConstructorMarker) null), scale), $composer2, 384, 24576, 114682);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
                if (endRestartGroup != null) {
                    final Modifier modifier4 = modifier3;
                    endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.BulletTickerKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj, Object obj2) {
                            Unit BulletTicker_EUb7tLY$lambda$0;
                            BulletTicker_EUb7tLY$lambda$0 = BulletTickerKt.BulletTicker_EUb7tLY$lambda$0($this$BulletTicker_u2dEUb7tLY, f, list, scale, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                            return BulletTicker_EUb7tLY$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup2 = $composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup2.updateScope(new Function2() { // from class: kntr.app.mall.product.details.page.ui.components.pieces.BulletTickerKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit BulletTicker_EUb7tLY$lambda$7;
                    BulletTicker_EUb7tLY$lambda$7 = BulletTickerKt.BulletTicker_EUb7tLY$lambda$7($this$BulletTicker_u2dEUb7tLY, f, list, scale, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return BulletTicker_EUb7tLY$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int BulletTicker_EUb7tLY$lambda$2(MutableIntState $index$delegate) {
        IntState $this$getValue$iv = (IntState) $index$delegate;
        return $this$getValue$iv.getIntValue();
    }
}