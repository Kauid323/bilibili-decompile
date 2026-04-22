package kntr.app.tribee.publish.internal;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
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
import com.bapis.bilibili.dynamic.common.KTribeeCategory;
import com.bapis.bilibili.dynamic.interfaces.feed.v1.KTribeePublishConfig;
import com.bilibili.compose.theme.BiliTheme;
import java.util.List;
import kntr.app.tribee.publish.TribeeInfo;
import kntr.app.tribee.publish.TribeePublishAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: TribeeTail.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ao\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2&\u0010\f\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\rj\u0002`\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0001¢\u0006\u0002\u0010\u0014\u001aU\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2&\u0010\f\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\rj\u0002`\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u0003¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"TribeeTail", "", "tribeeInfo", "Lkntr/app/tribee/publish/TribeeInfo;", "contentLength", "", "limitInfo", "Lcom/bapis/bilibili/dynamic/interfaces/feed/v1/KTribeePublishConfig;", "selectedCategory", "Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;", "categories", "", "onAction", "Lkotlin/Function2;", "Lkntr/app/tribee/publish/TribeePublishAction;", "Lkotlin/coroutines/Continuation;", "", "Lkntr/app/tribee/publish/TribeeActionHandler;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkntr/app/tribee/publish/TribeeInfo;ILcom/bapis/bilibili/dynamic/interfaces/feed/v1/KTribeePublishConfig;Lcom/bapis/bilibili/dynamic/common/KTribeeCategory;Ljava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "TribeeCategories", "(Lkntr/app/tribee/publish/TribeeInfo;Ljava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeTailKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeCategories$lambda$1(TribeeInfo tribeeInfo, List list, Function2 function2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TribeeCategories(tribeeInfo, list, function2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeTail$lambda$1(TribeeInfo tribeeInfo, int i, KTribeePublishConfig kTribeePublishConfig, KTribeeCategory kTribeeCategory, List list, Function2 function2, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        TribeeTail(tribeeInfo, i, kTribeePublishConfig, kTribeeCategory, list, function2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: SSATransform
        java.lang.IndexOutOfBoundsException: bitIndex < 0: -93
        	at java.util.BitSet.get(BitSet.java:623)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.fillBasicBlockInfo(LiveVarAnalysis.java:65)
        	at jadx.core.dex.visitors.ssa.LiveVarAnalysis.runAnalysis(LiveVarAnalysis.java:36)
        	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:55)
        	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:41)
        */
    public static final void TribeeTail(kntr.app.tribee.publish.TribeeInfo r160, int r161, com.bapis.bilibili.dynamic.interfaces.feed.v1.KTribeePublishConfig r162, com.bapis.bilibili.dynamic.common.KTribeeCategory r163, java.util.List<com.bapis.bilibili.dynamic.common.KTribeeCategory> r164, kotlin.jvm.functions.Function2<? super kntr.app.tribee.publish.TribeePublishAction, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r165, androidx.compose.ui.Modifier r166, androidx.compose.runtime.Composer r167, int r168, int r169) {
        /*
            Method dump skipped, instructions count: 2969
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kntr.app.tribee.publish.internal.TribeeTailKt.TribeeTail(kntr.app.tribee.publish.TribeeInfo, int, com.bapis.bilibili.dynamic.interfaces.feed.v1.KTribeePublishConfig, com.bapis.bilibili.dynamic.common.KTribeeCategory, java.util.List, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeTail$lambda$0$0$0$0$0$0(CoroutineScope $scope, Function2 $onAction) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeeTailKt$TribeeTail$1$1$1$1$1$1$1($onAction, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x03b6, code lost:
        if (r15 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L55;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void TribeeCategories(final TribeeInfo tribeeInfo, final List<KTribeeCategory> list, final Function2<? super TribeePublishAction, ? super Continuation<? super Unit>, ? extends Object> function2, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer2 = $composer.startRestartGroup(801032026);
        ComposerKt.sourceInformation($composer2, "C(TribeeCategories)N(tribeeInfo,categories,onAction,modifier)191@7610L3877:TribeeTail.kt#1zy72f");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(tribeeInfo) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(list) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(801032026, $dirty2, -1, "kntr.app.tribee.publish.internal.TribeeCategories (TribeeTail.kt:190)");
            }
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(12));
            int $changed$iv = (($dirty2 >> 9) & 14) | 432;
            Modifier modifier$iv = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer2, (($changed$iv >> 3) & 14) | (($changed$iv >> 3) & 112));
            int $changed$iv$iv = ($changed$iv << 3) & 112;
            modifier3 = modifier4;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv3 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv3;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = (($changed$iv >> 6) & 112) | 6;
            RowScope $this$TribeeCategories_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1271738419, "C198@7852L9,199@7897L6,196@7777L143,202@7942L24,204@7976L3505:TribeeTail.kt#1zy72f");
            TextKt.Text-Nvy7gAk("分区", (Modifier) null, BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer2, BiliTheme.$stable).getT12(), $composer2, 6, 0, 131066);
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object value$iv$iv = $composer2.rememberedValue();
            if (value$iv$iv == Composer.Companion.getEmpty()) {
                value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
            }
            final CoroutineScope scope = (CoroutineScope) value$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Modifier modifier$iv2 = RowScope.-CC.weight$default($this$TribeeCategories_u24lambda_u240, SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (0 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer2.startReusableNode();
            if ($composer2.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv4;
                $composer2.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer2);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            int i6 = ((0 >> 6) & 112) | 6;
            BoxScope $this$TribeeCategories_u24lambda_u240_u240 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer2, -1440395925, "C216@8374L2294,210@8123L2545,277@11164L6,278@11255L6,279@11335L6,266@10681L790:TribeeTail.kt#1zy72f");
            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null);
            PaddingValues paddingValues = PaddingKt.PaddingValues-a9UjIt4$default(0.0f, 0.0f, Dp.constructor-impl(12), 0.0f, 11, (Object) null);
            Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(12));
            ComposerKt.sourceInformationMarkerStart($composer2, 784826586, "CC(remember):TribeeTail.kt#9igjgp");
            boolean invalid$iv = $composer2.changedInstance(list) | $composer2.changedInstance(scope) | $composer2.changedInstance(function2) | $composer2.changedInstance(tribeeInfo);
            Object it$iv = $composer2.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv = new Function1() { // from class: kntr.app.tribee.publish.internal.TribeeTailKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit TribeeCategories$lambda$0$0$0$0;
                    TribeeCategories$lambda$0$0$0$0 = TribeeTailKt.TribeeCategories$lambda$0$0$0$0(list, scope, function2, tribeeInfo, (LazyListScope) obj);
                    return TribeeCategories$lambda$0$0$0$0;
                }
            };
            $composer2.updateRememberedValue(value$iv);
            it$iv = value$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            LazyDslKt.LazyRow(fillMaxHeight$default, (LazyListState) null, paddingValues, false, horizontal, (Alignment.Vertical) null, (FlingBehavior) null, false, (OverscrollEffect) null, (Function1) it$iv, $composer2, 24966, 490);
            BoxKt.Box(BackgroundKt.background$default(SizeKt.width-3ABfNKs(SizeKt.fillMaxHeight$default($this$TribeeCategories_u24lambda_u240_u240.align(Modifier.Companion, Alignment.Companion.getCenterEnd()), 0.0f, 1, (Object) null), Dp.constructor-impl(24)), Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.box-impl(Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1-0d7_KjU(), 0.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null))), TuplesKt.to(Float.valueOf(0.7f), Color.box-impl(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1_float-0d7_KjU())), TuplesKt.to(Float.valueOf(1.0f), Color.box-impl(BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBg1_float-0d7_KjU()))}, 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null), $composer2, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
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
            modifier3 = modifier2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.publish.internal.TribeeTailKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeCategories$lambda$1;
                    TribeeCategories$lambda$1 = TribeeTailKt.TribeeCategories$lambda$1(TribeeInfo.this, list, function2, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeCategories$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeCategories$lambda$0$0$0$0(final List $categories, final CoroutineScope $scope, final Function2 $onAction, final TribeeInfo $tribeeInfo, LazyListScope $this$LazyRow) {
        Intrinsics.checkNotNullParameter($this$LazyRow, "$this$LazyRow");
        LazyListScope.-CC.items$default($this$LazyRow, $categories.size(), (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-2029961832, true, new Function4() { // from class: kntr.app.tribee.publish.internal.TribeeTailKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                Unit TribeeCategories$lambda$0$0$0$0$0;
                TribeeCategories$lambda$0$0$0$0$0 = TribeeTailKt.TribeeCategories$lambda$0$0$0$0$0($categories, $scope, $onAction, $tribeeInfo, (LazyItemScope) obj, ((Integer) obj2).intValue(), (Composer) obj3, ((Integer) obj4).intValue());
                return TribeeCategories$lambda$0$0$0$0$0;
            }
        }), 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0252, code lost:
        if (r10 != androidx.compose.runtime.Composer.Companion.getEmpty()) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit TribeeCategories$lambda$0$0$0$0$0(List $categories, final CoroutineScope $scope, final Function2 $onAction, final TribeeInfo $tribeeInfo, LazyItemScope $this$items, int index, Composer $composer, int $changed) {
        String str;
        Unit unit;
        KTribeeCategory category;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$items, "$this$items");
        ComposerKt.sourceInformation($composer, "CN(index)220@8521L411,220@8500L432,237@9231L6,231@8954L1682:TribeeTail.kt#1zy72f");
        int $dirty = $changed;
        if (($changed & 48) == 0) {
            $dirty |= $composer.changed(index) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if ($composer.shouldExecute(($dirty2 & 145) != 144, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2029961832, $dirty2, -1, "kntr.app.tribee.publish.internal.TribeeCategories.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TribeeTail.kt:218)");
            }
            KTribeeCategory category2 = (KTribeeCategory) $categories.get(index);
            Unit unit2 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -878164365, "CC(remember):TribeeTail.kt#9igjgp");
            boolean invalid$iv = $composer.changedInstance($scope) | $composer.changedInstance($onAction) | $composer.changedInstance($tribeeInfo) | $composer.changedInstance(category2);
            Object value$iv = $composer.rememberedValue();
            if (invalid$iv || value$iv == Composer.Companion.getEmpty()) {
                str = "CC(remember):TribeeTail.kt#9igjgp";
                unit = unit2;
                category = category2;
                value$iv = new TribeeTailKt$TribeeCategories$1$1$1$1$1$1$1($scope, $onAction, $tribeeInfo, category2, null);
                $composer.updateRememberedValue(value$iv);
            } else {
                str = "CC(remember):TribeeTail.kt#9igjgp";
                unit = unit2;
                category = category2;
            }
            ComposerKt.sourceInformationMarkerEnd($composer);
            EffectsKt.LaunchedEffect(unit, (Function2) value$iv, $composer, 6);
            Modifier modifier$iv = BackgroundKt.background-bw27NRU(SizeKt.wrapContentWidth$default(SizeKt.fillMaxHeight$default(Modifier.Companion, 0.0f, 1, (Object) null), (Alignment.Horizontal) null, false, 3, (Object) null), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBg2_float-0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getStart();
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((384 >> 3) & 14) | ((384 >> 3) & 112));
            int $changed$iv$iv = (384 << 3) & 112;
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
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i2 = ((384 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -164987858, "C244@9563L9,245@9624L6,249@9830L757,242@9461L1153:TribeeTail.kt#1zy72f");
            String name = category.getName();
            TextStyle t12 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT12();
            long j = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText2-0d7_KjU();
            Modifier modifier = PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(12), 0.0f, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, -2083520759, str);
            final KTribeeCategory category3 = category;
            boolean invalid$iv2 = $composer.changedInstance($scope) | $composer.changedInstance($onAction) | $composer.changedInstance(category3) | $composer.changedInstance($tribeeInfo);
            Object it$iv = $composer.rememberedValue();
            if (invalid$iv2) {
            }
            Object value$iv2 = new Function0() { // from class: kntr.app.tribee.publish.internal.TribeeTailKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit TribeeCategories$lambda$0$0$0$0$0$1$0$0;
                    TribeeCategories$lambda$0$0$0$0$0$1$0$0 = TribeeTailKt.TribeeCategories$lambda$0$0$0$0$0$1$0$0($scope, $onAction, category3, $tribeeInfo);
                    return TribeeCategories$lambda$0$0$0$0$0$1$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv = value$iv2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            TextKt.Text-Nvy7gAk(name, ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t12, $composer, 0, 0, 131064);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeCategories$lambda$0$0$0$0$0$1$0$0(CoroutineScope $scope, Function2 $onAction, KTribeeCategory $category, TribeeInfo $tribeeInfo) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeeTailKt$TribeeCategories$1$1$1$1$1$2$1$1$1($onAction, $category, $tribeeInfo, null), 3, (Object) null);
        return Unit.INSTANCE;
    }
}