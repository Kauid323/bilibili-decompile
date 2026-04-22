package kntr.app.mall.mallDynamicPage.component.base;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.app.mall.mallDynamicPage.bean.Props;
import kntr.app.mall.mallDynamicPage.bean.Style;
import kntr.app.mall.mallDynamicPage.parser.ModifierCreatorKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: CheckBoxComponent.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u001a+\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001aK\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"CheckBoxComponent", RoomRecommendViewModel.EMPTY_CURSOR, "props", "Lkntr/app/mall/mallDynamicPage/bean/Props;", "style", "Lkntr/app/mall/mallDynamicPage/bean/Style;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/mall/mallDynamicPage/bean/Props;Lkntr/app/mall/mallDynamicPage/bean/Style;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "biliCheckboxColors", "Lkntr/app/mall/mallDynamicPage/component/base/BiliCheckboxColors;", "activeCheckedBackground", "Landroidx/compose/ui/graphics/Color;", "activeCheckedMarkColor", "activeUncheckedBackground", "inactiveCheckedBackground", "inactiveCheckedMarkColor", "inactiveUncheckedBackground", "biliCheckboxColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Lkntr/app/mall/mallDynamicPage/component/base/BiliCheckboxColors;", "mallDynamicPage_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CheckBoxComponentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckBoxComponent$lambda$1(Props props, Style style, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CheckBoxComponent(props, style, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void CheckBoxComponent(final Props props, final Style style, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Composer $composer2;
        Modifier modifier3;
        Modifier modifier4;
        Function0 factory$iv$iv$iv;
        Composer $composer$iv;
        Composer $composer$iv$iv$iv;
        Modifier modifier5;
        Modifier modifier6;
        Function0 factory$iv$iv$iv2;
        Boolean enabled;
        Boolean checked;
        Composer $composer3 = $composer.startRestartGroup(630081730);
        ComposerKt.sourceInformation($composer3, "C(CheckBoxComponent)N(props,style,modifier)27@994L21,27@981L1536:CheckBoxComponent.kt#ay1t0q");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(props) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(style) ? 32 : 16;
        }
        int i2 = i & 4;
        if (i2 != 0) {
            $dirty |= 384;
            modifier2 = modifier;
        } else if (($changed & 384) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if (!$composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(630081730, $dirty2, -1, "kntr.app.mall.mallDynamicPage.component.base.CheckBoxComponent (CheckBoxComponent.kt:24)");
            }
            boolean checkState = (props == null || (checked = props.getChecked()) == null) ? false : checked.booleanValue();
            boolean enabled2 = (props == null || (enabled = props.getEnabled()) == null) ? true : enabled.booleanValue();
            Modifier modifier$iv = ModifierCreatorKt.createModifier(Modifier.Companion, style, $composer3, ($dirty2 & 112) | 6).then(modifier4);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
            $composer2 = $composer3;
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 1280881322, "C28@1042L1469:CheckBoxComponent.kt#ay1t0q");
            Modifier modifier7 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(18));
            if (checkState) {
                $composer3.startReplaceGroup(1280989542);
                $composer3.endReplaceGroup();
                modifier5 = (Modifier) Modifier.Companion;
                $composer$iv = $composer3;
                $composer$iv$iv$iv = $composer3;
            } else {
                $composer3.startReplaceGroup(1281065833);
                ComposerKt.sourceInformation($composer3, "38@1390L20");
                $composer$iv = $composer3;
                $composer$iv$iv$iv = $composer3;
                modifier5 = BorderKt.border-xT4_qwU(Modifier.Companion, Dp.constructor-impl(1), m2054biliCheckboxColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 63).m2048getBackgroundWaAFU9c(false, enabled2), RoundedCornerShapeKt.getCircleShape());
                $composer3.endReplaceGroup();
            }
            Modifier then = modifier7.then(modifier5);
            if (checkState) {
                $composer3.startReplaceGroup(1281422302);
                ComposerKt.sourceInformation($composer3, "46@1747L20");
                modifier6 = BackgroundKt.background-bw27NRU(Modifier.Companion, m2054biliCheckboxColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 63).m2048getBackgroundWaAFU9c(true, enabled2), RoundedCornerShapeKt.getCircleShape());
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(1281837702);
                $composer3.endReplaceGroup();
                modifier6 = Modifier.Companion;
            }
            Modifier modifier$iv2 = then.then(modifier6);
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv2 = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer3.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i6 = ((0 >> 6) & 112) | 6;
            BoxScope $this$CheckBoxComponent_u24lambda_u240_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer3, -110063429, "C:CheckBoxComponent.kt#ay1t0q");
            if (checkState) {
                $composer3.startReplaceGroup(-110048054);
                ComposerKt.sourceInformation($composer3, "59@2246L18,62@2417L20,58@2197L290");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getCheckmark_line_900($composer3, 6), (String) null, $this$CheckBoxComponent_u24lambda_u240_u240.align(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(12)), Alignment.Companion.getCenter()), m2054biliCheckboxColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, $composer3, 0, 63).m2052getMarkColorvNxB06k(enabled2), $composer3, Painter.$stable | 48, 0);
            } else {
                $composer3.startReplaceGroup(-112220596);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer$iv$iv$iv.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer$iv);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier8 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.mall.mallDynamicPage.component.base.CheckBoxComponentKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit CheckBoxComponent$lambda$1;
                    CheckBoxComponent$lambda$1 = CheckBoxComponentKt.CheckBoxComponent$lambda$1(Props.this, style, modifier8, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CheckBoxComponent$lambda$1;
                }
            });
        }
    }

    /* renamed from: biliCheckboxColors-5tl4gsc  reason: not valid java name */
    public static final BiliCheckboxColors m2054biliCheckboxColors5tl4gsc(long j2, long j3, long j4, long j5, long j6, long j7, Composer $composer, int $changed, int i) {
        ComposerKt.sourceInformationMarkerStart($composer, 1019318328, "C(biliCheckboxColors)N(activeCheckedBackground:c#ui.graphics.Color,activeCheckedMarkColor:c#ui.graphics.Color,activeUncheckedBackground:c#ui.graphics.Color,inactiveCheckedBackground:c#ui.graphics.Color,inactiveCheckedMarkColor:c#ui.graphics.Color,inactiveUncheckedBackground:c#ui.graphics.Color)97@3418L6,98@3483L6,99@3551L6,102@3772L6:CheckBoxComponent.kt#ay1t0q");
        long j8 = (i & 1) != 0 ? BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU() : j2;
        long j9 = (i & 2) != 0 ? BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_white-0d7_KjU() : j3;
        long j10 = (i & 4) != 0 ? BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText4-0d7_KjU() : j4;
        long j11 = (i & 8) != 0 ? Color.copy-wmQWz5c$default(j8, 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j5;
        long j12 = (i & 16) != 0 ? Color.copy-wmQWz5c$default(j9, 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null) : j6;
        long j13 = (i & 32) != 0 ? BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_regular-0d7_KjU() : j7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1019318328, $changed, -1, "kntr.app.mall.mallDynamicPage.component.base.biliCheckboxColors (CheckBoxComponent.kt:103)");
        }
        BiliCheckboxColors biliCheckboxColors = new BiliCheckboxColors(j8, j9, j10, j11, j12, j13, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return biliCheckboxColors;
    }
}