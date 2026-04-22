package tv.danmaku.bili.splash.ad.test;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.FlowLayoutKt;
import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.TextKt;
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
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.theme.BiliColors;
import com.bilibili.compose.theme.BiliThemeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: SplashTestPage.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0001¢\u0006\u0002\u0010\u0005\u001a\u0017\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0003¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"SplashTestPage", "", "list", "", "Ltv/danmaku/bili/splash/ad/test/SplashTestItem;", "(Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "SplashTestItemView", "item", "(Ltv/danmaku/bili/splash/ad/test/SplashTestItem;Landroidx/compose/runtime/Composer;II)V", "adsplash_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SplashTestPageKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SplashTestItemView$lambda$1(SplashTestItem splashTestItem, int i, int i2, Composer composer, int i3) {
        SplashTestItemView(splashTestItem, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SplashTestPage$lambda$1(List list, int i, Composer composer, int i2) {
        SplashTestPage(list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void SplashTestPage(final List<SplashTestItem> list, Composer $composer, final int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(list, "list");
        Composer $composer2 = $composer.startRestartGroup(1431122661);
        ComposerKt.sourceInformation($composer2, "C(SplashTestPage)N(list)26@1027L7,23@931L495:SplashTestPage.kt#t67a6t");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 4 : 2;
        }
        if ($composer2.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1431122661, $dirty, -1, "tv.danmaku.bili.splash.ad.test.SplashTestPage (SplashTestPage.kt:21)");
            }
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null);
            CompositionLocal this_$iv = BiliThemeKt.getLocalColors();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv = WindowInsetsPadding_androidKt.statusBarsPadding(BackgroundKt.background-bw27NRU$default(fillMaxSize$default, ((BiliColors) consume).getBg2-0d7_KjU(), (Shape) null, 2, (Object) null));
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & BR.containerVisible;
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
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i2 = ((0 >> 6) & BR.containerVisible) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 1964274393, "C35@1329L91,29@1089L331:SplashTestPage.kt#t67a6t");
            FlowLayoutKt.FlowRow(PaddingKt.padding-3ABfNKs(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8)), Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8)), (Alignment.Vertical) null, 0, 0, ComposableLambdaKt.rememberComposableLambda(1066247322, true, new Function3() { // from class: tv.danmaku.bili.splash.ad.test.SplashTestPageKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit SplashTestPage$lambda$0$0;
                    SplashTestPage$lambda$0$0 = SplashTestPageKt.SplashTestPage$lambda$0$0(list, (FlowRowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return SplashTestPage$lambda$0$0;
                }
            }, $composer2, 54), $composer2, 1573302, 56);
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
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.splash.ad.test.SplashTestPageKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit SplashTestPage$lambda$1;
                    SplashTestPage$lambda$1 = SplashTestPageKt.SplashTestPage$lambda$1(list, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return SplashTestPage$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SplashTestPage$lambda$0$0(List $list, FlowRowScope $this$FlowRow, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$FlowRow, "$this$FlowRow");
        ComposerKt.sourceInformation($composer, "C*37@1374L22:SplashTestPage.kt#t67a6t");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1066247322, $changed, -1, "tv.danmaku.bili.splash.ad.test.SplashTestPage.<anonymous>.<anonymous> (SplashTestPage.kt:36)");
            }
            List $this$forEach$iv = $list;
            for (Object element$iv : $this$forEach$iv) {
                SplashTestItem it = (SplashTestItem) element$iv;
                SplashTestItemView(it, $composer, 0, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x015b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void SplashTestItemView(SplashTestItem item, Composer $composer, final int $changed, final int i) {
        final SplashTestItem item2;
        Composer $composer2;
        final SplashTestItem item3;
        boolean invalid$iv;
        Object it$iv;
        int i2;
        Composer $composer3 = $composer.startRestartGroup(416960640);
        ComposerKt.sourceInformation($composer3, "C(SplashTestItemView)N(item)49@1591L7,52@1695L7,55@1794L52,47@1530L350:SplashTestPage.kt#t67a6t");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            if ((i & 1) == 0) {
                item2 = item;
                if ($composer3.changed(item2)) {
                    i2 = 4;
                    $dirty |= i2;
                }
            } else {
                item2 = item;
            }
            i2 = 2;
            $dirty |= i2;
        } else {
            item2 = item;
        }
        if ($composer3.shouldExecute(($dirty & 3) != 2, $dirty & 1)) {
            $composer3.startDefaults();
            if (($changed & 1) != 0 && !$composer3.getDefaultsInvalid()) {
                $composer3.skipToGroupEnd();
                if ((i & 1) != 0) {
                    $dirty &= -15;
                }
            } else if ((i & 1) != 0) {
                item3 = new SplashTestItem(0, null, null, 7, null);
                $dirty &= -15;
                $composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(416960640, $dirty, -1, "tv.danmaku.bili.splash.ad.test.SplashTestItemView (SplashTestPage.kt:46)");
                }
                String title = item3.getTitle();
                CompositionLocal this_$iv = BiliThemeKt.getLocalColors();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume = $composer3.consume(this_$iv);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                long j = ((BiliColors) consume).getText1-0d7_KjU();
                CompositionLocal this_$iv2 = BiliThemeKt.getLocalColors();
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object consume2 = $composer3.consume(this_$iv2);
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier = BackgroundKt.background-bw27NRU(Modifier.Companion, ((BiliColors) consume2).getBg1-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
                ComposerKt.sourceInformationMarkerStart($composer3, 1267227252, "CC(remember):SplashTestPage.kt#9igjgp");
                invalid$iv = ((($dirty & 14) ^ 6) > 4 && $composer3.changed(item3)) || ($dirty & 6) == 4;
                it$iv = $composer3.rememberedValue();
                if (!invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: tv.danmaku.bili.splash.ad.test.SplashTestPageKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit SplashTestItemView$lambda$0$0;
                            SplashTestItemView$lambda$0$0 = SplashTestPageKt.SplashTestItemView$lambda$0$0(SplashTestItem.this);
                            return SplashTestItemView$lambda$0$0;
                        }
                    };
                    $composer3.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer2 = $composer3;
                SplashTestItem item4 = item3;
                TextKt.Text--4IGK_g(title, PaddingKt.padding-3ABfNKs(ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), Dp.constructor-impl(16)), j, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer2, 0, 0, 131064);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                item2 = item4;
            }
            item3 = item2;
            $composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            String title2 = item3.getTitle();
            CompositionLocal this_$iv3 = BiliThemeKt.getLocalColors();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume3 = $composer3.consume(this_$iv3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            long j2 = ((BiliColors) consume3).getText1-0d7_KjU();
            CompositionLocal this_$iv22 = BiliThemeKt.getLocalColors();
            ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume22 = $composer3.consume(this_$iv22);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier2 = BackgroundKt.background-bw27NRU(Modifier.Companion, ((BiliColors) consume22).getBg1-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
            ComposerKt.sourceInformationMarkerStart($composer3, 1267227252, "CC(remember):SplashTestPage.kt#9igjgp");
            if ((($dirty & 14) ^ 6) > 4) {
                invalid$iv = ((($dirty & 14) ^ 6) > 4 && $composer3.changed(item3)) || ($dirty & 6) == 4;
                it$iv = $composer3.rememberedValue();
                if (!invalid$iv) {
                }
                Object value$iv2 = new Function0() { // from class: tv.danmaku.bili.splash.ad.test.SplashTestPageKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit SplashTestItemView$lambda$0$0;
                        SplashTestItemView$lambda$0$0 = SplashTestPageKt.SplashTestItemView$lambda$0$0(SplashTestItem.this);
                        return SplashTestItemView$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv2);
                it$iv = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                $composer2 = $composer3;
                SplashTestItem item42 = item3;
                TextKt.Text--4IGK_g(title2, PaddingKt.padding-3ABfNKs(ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), Dp.constructor-impl(16)), j2, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer2, 0, 0, 131064);
                if (ComposerKt.isTraceInProgress()) {
                }
                item2 = item42;
            }
            invalid$iv = ((($dirty & 14) ^ 6) > 4 && $composer3.changed(item3)) || ($dirty & 6) == 4;
            it$iv = $composer3.rememberedValue();
            if (!invalid$iv) {
            }
            Object value$iv22 = new Function0() { // from class: tv.danmaku.bili.splash.ad.test.SplashTestPageKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit SplashTestItemView$lambda$0$0;
                    SplashTestItemView$lambda$0$0 = SplashTestPageKt.SplashTestItemView$lambda$0$0(SplashTestItem.this);
                    return SplashTestItemView$lambda$0$0;
                }
            };
            $composer3.updateRememberedValue(value$iv22);
            it$iv = value$iv22;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            SplashTestItem item422 = item3;
            TextKt.Text--4IGK_g(title2, PaddingKt.padding-3ABfNKs(ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), Dp.constructor-impl(16)), j2, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer2, 0, 0, 131064);
            if (ComposerKt.isTraceInProgress()) {
            }
            item2 = item422;
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: tv.danmaku.bili.splash.ad.test.SplashTestPageKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit SplashTestItemView$lambda$1;
                    SplashTestItemView$lambda$1 = SplashTestPageKt.SplashTestItemView$lambda$1(SplashTestItem.this, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return SplashTestItemView$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SplashTestItemView$lambda$0$0(SplashTestItem $item) {
        $item.getAction().invoke();
        return Unit.INSTANCE;
    }
}