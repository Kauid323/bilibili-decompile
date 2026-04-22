package kntr.app.tribee.publish.internal;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import kntr.app.tribee.publish.TribeePublishAction;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import org.jetbrains.compose.resources.StringResourcesKt;
import srcs.app.tribee.publish.ui.generated.resources.Res;
import srcs.app.tribee.publish.ui.generated.resources.String0_commonMainKt;

/* compiled from: TribeeActions.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a{\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032&\u0010\n\u001a\"\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000bj\u0002`\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0001¢\u0006\u0002\u0010\u0012\u001a\u001f\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0003¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"TribeeActions", "", "syncToFollowing", "", "isSettingSelected", "onImageClick", "Lkotlin/Function0;", "onSettingClick", "showSetting", "showSyncToFollowing", "onAction", "Lkotlin/Function2;", "Lkntr/app/tribee/publish/TribeePublishAction;", "Lkotlin/coroutines/Continuation;", "", "Lkntr/app/tribee/publish/TribeeActionHandler;", "modifier", "Landroidx/compose/ui/Modifier;", "(ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZZLkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CheckMark", "checked", "(ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeActionsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CheckMark$lambda$0(boolean z, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CheckMark(z, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeActions$lambda$1(boolean z, boolean z2, Function0 function0, Function0 function02, boolean z3, boolean z4, Function2 function2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        TribeeActions(z, z2, function0, function02, z3, z4, function2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void TribeeActions(final boolean syncToFollowing, final boolean isSettingSelected, final Function0<Unit> function0, final Function0<Unit> function02, final boolean showSetting, final boolean showSyncToFollowing, final Function2<? super TribeePublishAction, ? super Continuation<? super Unit>, ? extends Object> function2, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Composer $composer2;
        Modifier modifier2;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Composer $composer3;
        Composer $composer4;
        Function0 factory$iv$iv$iv3;
        char c;
        Painter painter;
        long j;
        Intrinsics.checkNotNullParameter(function0, "onImageClick");
        Intrinsics.checkNotNullParameter(function02, "onSettingClick");
        Intrinsics.checkNotNullParameter(function2, "onAction");
        Composer $composer5 = $composer.startRestartGroup(1766544013);
        ComposerKt.sourceInformation($composer5, "C(TribeeActions)N(syncToFollowing,isSettingSelected,onImageClick,onSettingClick,showSetting,showSyncToFollowing,onAction,modifier)40@1560L2597:TribeeActions.kt#1zy72f");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer5.changed(syncToFollowing) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer5.changed(isSettingSelected) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer5.changedInstance(function0) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer5.changedInstance(function02) ? 2048 : 1024;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer5.changed(showSetting) ? 16384 : 8192;
        }
        if ((196608 & $changed) == 0) {
            $dirty |= $composer5.changed(showSyncToFollowing) ? 131072 : 65536;
        }
        if ((1572864 & $changed) == 0) {
            $dirty |= $composer5.changedInstance(function2) ? 1048576 : 524288;
        }
        int i2 = i & 128;
        if (i2 != 0) {
            $dirty |= 12582912;
        } else if ((12582912 & $changed) == 0) {
            $dirty |= $composer5.changed(modifier) ? 8388608 : 4194304;
        }
        int $dirty2 = $dirty;
        if ($composer5.shouldExecute((4793491 & $dirty2) != 4793490, $dirty2 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1766544013, $dirty2, -1, "kntr.app.tribee.publish.internal.TribeeActions (TribeeActions.kt:39)");
            }
            Modifier modifier$iv = PaddingKt.padding-VpY3zN4(modifier3, Dp.constructor-impl(12), Dp.constructor-impl(10));
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart($composer5, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer5, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
            Modifier modifier4 = modifier3;
            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
            CompositionLocalMap localMap$iv$iv = $composer5.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer5, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer5.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer5.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer5);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i4 = ((432 >> 6) & 112) | 6;
            RowScope $this$TribeeActions_u24lambda_u240 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer5, 103617925, "C45@1770L1261,79@3053L24:TribeeActions.kt#1zy72f");
            Modifier modifier$iv2 = RowScope.-CC.weight$default($this$TribeeActions_u24lambda_u240, Modifier.Companion, 1.0f, false, 2, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv2 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(20));
            Alignment.Vertical verticalAlignment$iv2 = Alignment.Companion.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart($composer5, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = RowKt.rowMeasurePolicy(horizontalArrangement$iv2, verticalAlignment$iv2, $composer5, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv2 = (432 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer5, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer5, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer5.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer5, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer5.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer5.startReusableNode();
            if ($composer5.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer5.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer5.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer5);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer5, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i6 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer5, 1612381009, "C51@2013L14,53@2145L6,50@1968L247:TribeeActions.kt#1zy72f");
            modifier2 = modifier4;
            $composer2 = $composer5;
            IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getImage_line_500($composer5, 6), (String) null, ClickableKt.clickable-oSLSa3U$default(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), false, (String) null, (Role) null, (MutableInteractionSource) null, function0, 15, (Object) null), BiliTheme.INSTANCE.getColors($composer5, BiliTheme.$stable).getText2-0d7_KjU(), $composer5, Painter.$stable | 48, 0);
            if (showSetting) {
                $composer5.startReplaceGroup(1612664069);
                ComposerKt.sourceInformation($composer5, "57@2263L744");
                if (isSettingSelected) {
                    $composer5.startReplaceGroup(1612726007);
                    ComposerKt.sourceInformation($composer5, "60@2389L17");
                    c = 6;
                    Painter keyboard_line_500 = BiliIconfont.INSTANCE.getKeyboard_line_500($composer5, 6);
                    $composer5.endReplaceGroup();
                    painter = keyboard_line_500;
                } else {
                    c = 6;
                    $composer5.startReplaceGroup(1612817364);
                    ComposerKt.sourceInformation($composer5, "62@2481L20");
                    Painter nut_setting_line_500 = BiliIconfont.INSTANCE.getNut_setting_line_500($composer5, 6);
                    $composer5.endReplaceGroup();
                    painter = nut_setting_line_500;
                }
                $composer3 = $composer5;
                Modifier modifier5 = ClickableKt.clickable-oSLSa3U$default(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24)), false, (String) null, (Role) null, (MutableInteractionSource) null, function02, 15, (Object) null);
                if (isSettingSelected) {
                    $composer3.startReplaceGroup(1613150490);
                    ComposerKt.sourceInformation($composer3, "70@2814L6");
                    long j2 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                    $composer3.endReplaceGroup();
                    j = j2;
                } else {
                    $composer3.startReplaceGroup(1613238623);
                    ComposerKt.sourceInformation($composer3, "72@2903L6");
                    long j3 = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU();
                    $composer3.endReplaceGroup();
                    j = j3;
                }
                IconKt.Icon-ww6aTOc(painter, (String) null, modifier5, j, $composer3, Painter.$stable | 48, 0);
            } else {
                $composer3 = $composer5;
                $composer3.startReplaceGroup(1610395117);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            $composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerStart($composer5, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer5, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer5.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer5);
                $composer5.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            if (showSyncToFollowing) {
                $composer4 = $composer5;
                $composer4.startReplaceGroup(104920730);
                ComposerKt.sourceInformation($composer4, "84@3222L444,82@3126L1015");
                Modifier modifier6 = PaddingKt.padding-VpY3zN4$default(Modifier.Companion, 0.0f, Dp.constructor-impl(4), 1, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer4, 419029037, "CC(remember):TribeeActions.kt#9igjgp");
                boolean invalid$iv = $composer2.changedInstance(scope) | (($dirty2 & 14) == 4) | $composer2.changedInstance(function2);
                Object it$iv = $composer4.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: kntr.app.tribee.publish.internal.TribeeActionsKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit TribeeActions$lambda$0$1$0;
                            TribeeActions$lambda$0$1$0 = TribeeActionsKt.TribeeActions$lambda$0$1$0(syncToFollowing, scope, function2);
                            return TribeeActions$lambda$0$1$0;
                        }
                    };
                    $composer4.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(modifier6, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
                Alignment.Vertical verticalAlignment$iv3 = Alignment.Companion.getCenterVertically();
                Arrangement.Horizontal horizontalArrangement$iv3 = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(4));
                ComposerKt.sourceInformationMarkerStart($composer4, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv3, verticalAlignment$iv3, $composer4, ((432 >> 3) & 14) | ((432 >> 3) & 112));
                int $changed$iv$iv3 = (432 << 3) & 112;
                ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                CompositionLocalMap localMap$iv$iv3 = $composer4.getCurrentCompositionLocalMap();
                Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer4, modifier$iv3);
                Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                int $changed$iv$iv$iv3 = (($changed$iv$iv3 << 6) & 896) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                if (!($composer4.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer4.createNode(factory$iv$iv$iv3);
                } else {
                    factory$iv$iv$iv3 = factory$iv$iv$iv6;
                    $composer4.useNode();
                }
                Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer4);
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                int i7 = ($changed$iv$iv$iv3 >> 6) & 14;
                ComposerKt.sourceInformationMarkerStart($composer4, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScope rowScope2 = RowScopeInstance.INSTANCE;
                int i8 = ((432 >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart($composer4, -91630900, "C97@3832L69,100@3952L51,101@4043L9,102@4096L6,99@3919L208:TribeeActions.kt#1zy72f");
                CheckMark(syncToFollowing, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), $composer4, ($dirty2 & 14) | 48, 0);
                TextKt.Text-Nvy7gAk(StringResourcesKt.stringResource(String0_commonMainKt.getTribee_sync_to_following(Res.string.INSTANCE), $composer4, 0), (Modifier) null, BiliTheme.INSTANCE.getColors($composer4, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer4, BiliTheme.$stable).getT12(), $composer4, 0, 0, 131066);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
            } else {
                $composer4 = $composer5;
                $composer4.startReplaceGroup(101787281);
            }
            $composer4.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer4);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            $composer5.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            ComposerKt.sourceInformationMarkerEnd($composer5);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer5;
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier7 = modifier2;
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.publish.internal.TribeeActionsKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TribeeActions$lambda$1;
                    TribeeActions$lambda$1 = TribeeActionsKt.TribeeActions$lambda$1(syncToFollowing, isSettingSelected, function0, function02, showSetting, showSyncToFollowing, function2, modifier7, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return TribeeActions$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TribeeActions$lambda$0$1$0(boolean $syncToFollowing, CoroutineScope $scope, Function2 $onAction) {
        if (!$syncToFollowing) {
            BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeeActionsKt$TribeeActions$1$2$1$1($onAction, null), 3, (Object) null);
        }
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new TribeeActionsKt$TribeeActions$1$2$1$2($onAction, $syncToFollowing, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    private static final void CheckMark(final boolean checked, final Modifier modifier, Composer $composer, final int $changed, final int i) {
        Composer $composer2 = $composer.startRestartGroup(1361767179);
        ComposerKt.sourceInformation($composer2, "C(CheckMark)N(checked,modifier):TribeeActions.kt#1zy72f");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(checked) ? 4 : 2;
        }
        int i2 = i & 2;
        if (i2 != 0) {
            $dirty |= 48;
        } else if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(modifier) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1361767179, $dirty2, -1, "kntr.app.tribee.publish.internal.CheckMark (TribeeActions.kt:113)");
            }
            if (checked) {
                $composer2.startReplaceGroup(-1854934531);
                ComposerKt.sourceInformation($composer2, "116@4325L18,120@4484L6,122@4595L6,115@4284L378");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getCheckmark_line_500($composer2, 6), (String) null, PaddingKt.padding-3ABfNKs(BackgroundKt.background-bw27NRU(PaddingKt.padding-3ABfNKs(modifier, Dp.constructor-impl(1)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getBrand_pink-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), Dp.constructor-impl(1)), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText_white-0d7_KjU(), $composer2, Painter.$stable | 48, 0);
                $composer2.endReplaceGroup();
            } else {
                $composer2.startReplaceGroup(-1854552704);
                ComposerKt.sourceInformation($composer2, "130@4838L6,126@4684L199");
                BoxKt.Box(BorderKt.border-xT4_qwU(PaddingKt.padding-3ABfNKs(modifier, Dp.constructor-impl(1)), Dp.constructor-impl(1), BiliTheme.INSTANCE.getColors($composer2, BiliTheme.$stable).getText4-0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), $composer2, 0);
                $composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: kntr.app.tribee.publish.internal.TribeeActionsKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit CheckMark$lambda$0;
                    CheckMark$lambda$0 = TribeeActionsKt.CheckMark$lambda$0(checked, modifier, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return CheckMark$lambda$0;
                }
            });
        }
    }
}