package kntr.app.tribee.consume.page.mine.bottomsheet;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
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
import com.bapis.bilibili.app.dynamic.v2.KFootHoverToast;
import com.bilibili.compose.theme.BiliTheme;
import com.bilibili.compose.theme.ThemeDayNight;
import com.bilibili.lib.brouter.uri.Uri;
import kntr.app.tribee.consume.TribeeExtensionsKt;
import kntr.app.tribee.consume.viewmodel.track.TrackerKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.imageloader.BiliImageKt;
import kntr.base.imageloader.ImageRequest;
import kntr.base.router.Router;
import kntr.common.bilitheme.compose.bottomsheet.BottomSheetScope;
import kntr.common.bilitheme.compose.bottomsheet.ComposeBottomsheetKt;
import kntr.common.router.RouterKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RevisitGuideBottomSheet.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"RevisitGuideBottomSheet", "", "guide", "Lcom/bapis/bilibili/app/dynamic/v2/KFootHoverToast;", "modifier", "Landroidx/compose/ui/Modifier;", "onDismiss", "Lkotlin/Function0;", "(Lcom/bapis/bilibili/app/dynamic/v2/KFootHoverToast;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "consume_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class RevisitGuideBottomSheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RevisitGuideBottomSheet$lambda$4(KFootHoverToast kFootHoverToast, Modifier modifier, Function0 function0, int i, int i2, Composer composer, int i3) {
        RevisitGuideBottomSheet(kFootHoverToast, modifier, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v9 */
    public static final void RevisitGuideBottomSheet(final KFootHoverToast guide, Modifier modifier, Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 onDismiss;
        Modifier modifier3;
        final Modifier modifier4;
        final Function0 onDismiss2;
        Intrinsics.checkNotNullParameter(guide, "guide");
        Composer $composer2 = $composer.startRestartGroup(284895326);
        ComposerKt.sourceInformation($composer2, "C(RevisitGuideBottomSheet)N(guide,modifier,onDismiss)36@1586L2,38@1620L44,38@1598L66,41@1694L7,43@1763L6,44@1795L81,49@1922L3288,42@1706L3504:RevisitGuideBottomSheet.kt#63y5ux");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(guide) ? 4 : 2;
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
            onDismiss = function0;
        } else if (($changed & 384) == 0) {
            onDismiss = function0;
            $dirty |= $composer2.changedInstance(onDismiss) ? 256 : 128;
        } else {
            onDismiss = function0;
        }
        if (!$composer2.shouldExecute(($dirty & 147) != 146, $dirty & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1093494816, "CC(remember):RevisitGuideBottomSheet.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.consume.page.mine.bottomsheet.RevisitGuideBottomSheetKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onDismiss2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onDismiss2 = onDismiss;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(284895326, $dirty, -1, "kntr.app.tribee.consume.page.mine.bottomsheet.RevisitGuideBottomSheet (RevisitGuideBottomSheet.kt:37)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1093493686, "CC(remember):RevisitGuideBottomSheet.kt#9igjgp");
            Object it$iv2 = $composer2.rememberedValue();
            if (it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = (Function2) new RevisitGuideBottomSheetKt$RevisitGuideBottomSheet$2$1(null);
                $composer2.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            EffectsKt.LaunchedEffect(guide, (Function2) it$iv2, $composer2, $dirty & 14);
            CompositionLocal this_$iv = RouterKt.getLocalRouter();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(this_$iv);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Router router = (Router) consume;
            long j = BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU();
            ComposerKt.sourceInformationMarkerStart($composer2, -1093488049, "CC(remember):RevisitGuideBottomSheet.kt#9igjgp");
            boolean invalid$iv = ($dirty & 896) == 256;
            Object it$iv3 = $composer2.rememberedValue();
            if (invalid$iv || it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.app.tribee.consume.page.mine.bottomsheet.RevisitGuideBottomSheetKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit RevisitGuideBottomSheet$lambda$2$0;
                        RevisitGuideBottomSheet$lambda$2$0 = RevisitGuideBottomSheetKt.RevisitGuideBottomSheet$lambda$2$0(onDismiss2);
                        return RevisitGuideBottomSheet$lambda$2$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposeBottomsheetKt.m1831BottomSheetContainerlVb_Clg((Function0) it$iv3, null, j, true, false, false, null, ComposableLambdaKt.rememberComposableLambda(693280045, true, new Function3() { // from class: kntr.app.tribee.consume.page.mine.bottomsheet.RevisitGuideBottomSheetKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit RevisitGuideBottomSheet$lambda$3;
                    RevisitGuideBottomSheet$lambda$3 = RevisitGuideBottomSheetKt.RevisitGuideBottomSheet$lambda$3(modifier4, guide, router, onDismiss2, (BottomSheetScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return RevisitGuideBottomSheet$lambda$3;
                }
            }, $composer2, 54), $composer2, 12585984, ConstantsKt.UGC_UPDATE_CALENDAR_CARD_COVER_WIDTH);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            onDismiss = onDismiss2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function0 function02 = onDismiss;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.consume.page.mine.bottomsheet.RevisitGuideBottomSheetKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit RevisitGuideBottomSheet$lambda$4;
                    RevisitGuideBottomSheet$lambda$4 = RevisitGuideBottomSheetKt.RevisitGuideBottomSheet$lambda$4(guide, modifier5, function02, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RevisitGuideBottomSheet$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RevisitGuideBottomSheet$lambda$2$0(Function0 $onDismiss) {
        TrackerKt.tribeeRevisitGuideClick("cancel");
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0452, code lost:
        if (r13 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit RevisitGuideBottomSheet$lambda$3(Modifier $modifier, final KFootHoverToast $guide, final Router $router, final Function0 $onDismiss, BottomSheetScope $this$BottomSheetContainer, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        String $this$asRequest$iv;
        Function0 factory$iv$iv$iv2;
        Intrinsics.checkNotNullParameter($this$BottomSheetContainer, "$this$BottomSheetContainer");
        ComposerKt.sourceInformation($composer, "C50@1932L3272:RevisitGuideBottomSheet.kt#63y5ux");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(693280045, $changed, -1, "kntr.app.tribee.consume.page.mine.bottomsheet.RevisitGuideBottomSheet.<anonymous> (RevisitGuideBottomSheet.kt:50)");
            }
            Modifier modifier$iv$iv = PaddingKt.padding-VpY3zN4$default($modifier, Dp.constructor-impl(20), 0.0f, 2, (Object) null);
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i2 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -1646321941, "C56@2165L9,57@2215L6,54@2089L226,63@2408L9,64@2457L6,61@2329L216,68@2559L821,90@3394L1800:RevisitGuideBottomSheet.kt#63y5ux");
            TextKt.Text-Nvy7gAk($guide.getTitle(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, Dp.constructor-impl(20), 0.0f, Dp.constructor-impl(6), 5, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16b(), $composer, 48, 0, 131064);
            TextKt.Text-Nvy7gAk($guide.getSubtitle(), PaddingKt.padding-qDBjuR0$default(Modifier.Companion, 0.0f, 0.0f, 0.0f, Dp.constructor-impl(18), 7, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText3-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT14(), $composer, 48, 0, 131064);
            if (ThemeDayNight.Companion.getCurrentTheme().getValue() == ThemeDayNight.Night) {
                $this$asRequest$iv = $guide.getPicUrlDark();
            } else {
                $this$asRequest$iv = $guide.getPicUrlLight();
            }
            ImageRequest $this$RevisitGuideBottomSheet_u24lambda_u243_u240_u240 = new ImageRequest($this$asRequest$iv);
            $this$RevisitGuideBottomSheet_u24lambda_u243_u240_u240.contentScale(ContentScale.Companion.getCrop());
            BiliImageKt.BiliImage($this$RevisitGuideBottomSheet_u24lambda_u243_u240_u240.build(), SizeKt.size-VpY3zN4(Modifier.Companion, Dp.constructor-impl(297), Dp.constructor-impl(188)), null, null, null, null, null, null, ComposableSingletons$RevisitGuideBottomSheetKt.INSTANCE.getLambda$208110568$consume_debug(), $composer, 100663344, 252);
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(10));
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            int $changed$iv$iv2 = (54 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((54 >> 6) & 112) | 6;
            RowScope $this$RevisitGuideBottomSheet_u24lambda_u243_u240_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -2121777420, "C96@3639L9,97@3692L6,104@3995L6,107@4175L224,94@3552L866,116@4526L9,117@4579L6,123@4843L6,126@5024L137,114@4436L744:RevisitGuideBottomSheet.kt#63y5ux");
            String jumpText = $guide.getJumpText();
            TextStyle t16 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16();
            long j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU();
            int i5 = TextAlign.Companion.getCenter-e0LSkKk();
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(BorderKt.border-xT4_qwU(RowScope.-CC.weight$default($this$RevisitGuideBottomSheet_u24lambda_u243_u240_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), Dp.constructor-impl((float) 0.5d), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_bold-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(22))), 0.0f, Dp.constructor-impl(11), 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -68425901, "CC(remember):RevisitGuideBottomSheet.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($guide) | $composer.changedInstance($router) | $composer.changed($onDismiss);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function0() { // from class: kntr.app.tribee.consume.page.mine.bottomsheet.RevisitGuideBottomSheetKt$$ExternalSyntheticLambda4
                public final Object invoke() {
                    Unit RevisitGuideBottomSheet$lambda$3$0$1$0$0;
                    RevisitGuideBottomSheet$lambda$3$0$1$0$0 = RevisitGuideBottomSheetKt.RevisitGuideBottomSheet$lambda$3$0$1$0$0($guide, $onDismiss, $router);
                    return RevisitGuideBottomSheet$lambda$3$0$1$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer);
            TextKt.Text-Nvy7gAk(jumpText, ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(i5), 0L, 0, false, 0, 0, (Function1) null, t16, $composer, 0, 0, 130040);
            String confirmText = $guide.getConfirmText();
            TextStyle t162 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16();
            long j2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText_white-0d7_KjU();
            int i6 = TextAlign.Companion.getCenter-e0LSkKk();
            Modifier modifier2 = PaddingKt.padding-VpY3zN4$default(BackgroundKt.background-bw27NRU(RowScope.-CC.weight$default($this$RevisitGuideBottomSheet_u24lambda_u243_u240_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(22))), 0.0f, Dp.constructor-impl(11), 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -68398820, "CC(remember):RevisitGuideBottomSheet.kt#9igjgp");
            boolean invalid$iv2 = $composer.changed($onDismiss);
            Object it$iv2 = $composer.rememberedValue();
            if (invalid$iv2 || it$iv2 == Composer.Companion.getEmpty()) {
                Object value$iv2 = new Function0() { // from class: kntr.app.tribee.consume.page.mine.bottomsheet.RevisitGuideBottomSheetKt$$ExternalSyntheticLambda5
                    public final Object invoke() {
                        Unit RevisitGuideBottomSheet$lambda$3$0$1$1$0;
                        RevisitGuideBottomSheet$lambda$3$0$1$1$0 = RevisitGuideBottomSheetKt.RevisitGuideBottomSheet$lambda$3$0$1$1$0($onDismiss);
                        return RevisitGuideBottomSheet$lambda$3$0$1$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv2 = value$iv2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            TextKt.Text-Nvy7gAk(confirmText, ClickableKt.clickable-oSLSa3U$default(modifier2, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv2, 15, (Object) null), j2, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(i6), 0L, 0, false, 0, 0, (Function1) null, t162, $composer, 0, 0, 130040);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
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
    public static final Unit RevisitGuideBottomSheet$lambda$3$0$1$0$0(KFootHoverToast $guide, Function0 $onDismiss, Router $router) {
        TrackerKt.tribeeRevisitGuideClick("go");
        Uri it = TribeeExtensionsKt.toUriOrNull($guide.getJumpUrl());
        if (it != null) {
            $router.launch(it);
        }
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RevisitGuideBottomSheet$lambda$3$0$1$1$0(Function0 $onDismiss) {
        TrackerKt.tribeeRevisitGuideClick("OK");
        $onDismiss.invoke();
        return Unit.INSTANCE;
    }
}