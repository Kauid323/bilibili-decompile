package usercenter;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.AlertDialogKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardElevation;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
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
import androidx.compose.ui.window.DialogProperties;
import bili.resource.profile.ProfileRes;
import bili.resource.profile.String0_commonMainKt;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.bilibili.compose.theme.BiliTheme;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.service.interact.biz.model.comment.AbsoluteCommentItem;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* compiled from: RecommendHandleDialog.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u001aO\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00010\nH\u0007¢\u0006\u0002\u0010\u000b\u001a+\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\bH\u0003¢\u0006\u0002\u0010\u0011¨\u0006\u0012²\u0006\f\u0010\u0013\u001a\u0004\u0018\u00010\u0006X\u008a\u008e\u0002"}, d2 = {"RecommendAliasDialog", "", "modifier", "Landroidx/compose/ui/Modifier;", "suggestions", "", "", "onDismiss", "Lkotlin/Function0;", "onConfirm", "Lkotlin/Function1;", "(Landroidx/compose/ui/Modifier;Ljava/util/List;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Selection", "text", "selected", "", "onClick", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "usercenter_debug", "selectedNickname"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class RecommendHandleDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendAliasDialog$lambda$6(Modifier modifier, List list, Function0 function0, Function1 function1, int i, int i2, Composer composer, int i3) {
        RecommendAliasDialog(modifier, list, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Selection$lambda$2(String str, boolean z, Function0 function0, int i, Composer composer, int i2) {
        Selection(str, z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendAliasDialog$lambda$1$0(String str) {
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r13v6 */
    public static final void RecommendAliasDialog(Modifier modifier, List<String> list, Function0<Unit> function0, Function1<? super String, Unit> function1, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        List list2;
        Function0 function02;
        Function1 onConfirm;
        Modifier modifier3;
        Function0 onDismiss;
        List suggestions;
        Function0 onDismiss2;
        final Function1 onConfirm2;
        Composer $composer2 = $composer.startRestartGroup(1035329726);
        ComposerKt.sourceInformation($composer2, "C(RecommendAliasDialog)N(modifier,suggestions,onDismiss,onConfirm)45@1930L2,46@1969L8,48@2011L42,59@2356L3232,50@2059L3529:RecommendHandleDialog.kt#xobjkw");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
            modifier2 = modifier;
        } else if (($changed & 6) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 4 : 2;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty |= 48;
            list2 = list;
        } else if (($changed & 48) == 0) {
            list2 = list;
            $dirty |= $composer2.changedInstance(list2) ? 32 : 16;
        } else {
            list2 = list;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            function02 = function0;
        } else if (($changed & 384) == 0) {
            function02 = function0;
            $dirty |= $composer2.changedInstance(function02) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        } else {
            function02 = function0;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty |= 3072;
            onConfirm = function1;
        } else if (($changed & 3072) == 0) {
            onConfirm = function1;
            $dirty |= $composer2.changedInstance(onConfirm) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        } else {
            onConfirm = function1;
        }
        if ($composer2.shouldExecute(($dirty & 1171) != 1170, $dirty & 1)) {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            final List suggestions2 = i3 != 0 ? CollectionsKt.emptyList() : list2;
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1480541696, "CC(remember):RecommendHandleDialog.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: usercenter.RecommendHandleDialogKt$$ExternalSyntheticLambda4
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
                onDismiss2 = function02;
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -1480540442, "CC(remember):RecommendHandleDialog.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function1() { // from class: usercenter.RecommendHandleDialogKt$$ExternalSyntheticLambda5
                        public final Object invoke(Object obj) {
                            Unit RecommendAliasDialog$lambda$1$0;
                            RecommendAliasDialog$lambda$1$0 = RecommendHandleDialogKt.RecommendAliasDialog$lambda$1$0((String) obj);
                            return RecommendAliasDialog$lambda$1$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function1 onConfirm3 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onConfirm2 = onConfirm3;
            } else {
                onConfirm2 = onConfirm;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1035329726, $dirty, -1, "usercenter.RecommendAliasDialog (RecommendHandleDialog.kt:47)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, -1480539064, "CC(remember):RecommendHandleDialog.kt#9igjgp");
            Object it$iv3 = $composer2.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            final MutableState selectedNickname$delegate = (MutableState) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            Function1 onConfirm4 = onConfirm2;
            AlertDialogKt.BasicAlertDialog(onDismiss2, modifier4, new DialogProperties(false, false, false), ComposableLambdaKt.rememberComposableLambda(594964088, true, new Function2() { // from class: usercenter.RecommendHandleDialogKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit RecommendAliasDialog$lambda$5;
                    RecommendAliasDialog$lambda$5 = RecommendHandleDialogKt.RecommendAliasDialog$lambda$5(suggestions2, selectedNickname$delegate, onConfirm2, (Composer) obj, ((Integer) obj2).intValue());
                    return RecommendAliasDialog$lambda$5;
                }
            }, $composer2, 54), $composer2, (($dirty >> 6) & 14) | 3456 | (($dirty << 3) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            suggestions = suggestions2;
            onConfirm = onConfirm4;
            onDismiss = onDismiss2;
        } else {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onDismiss = function02;
            suggestions = list2;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final List list3 = suggestions;
            final Function0 function03 = onDismiss;
            final Function1 function12 = onConfirm;
            endRestartGroup.updateScope(new Function2() { // from class: usercenter.RecommendHandleDialogKt$$ExternalSyntheticLambda7
                public final Object invoke(Object obj, Object obj2) {
                    Unit RecommendAliasDialog$lambda$6;
                    RecommendAliasDialog$lambda$6 = RecommendHandleDialogKt.RecommendAliasDialog$lambda$6(modifier5, list3, function03, function12, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return RecommendAliasDialog$lambda$6;
                }
            });
        }
    }

    private static final String RecommendAliasDialog$lambda$3(MutableState<String> mutableState) {
        State $this$getValue$iv = (State) mutableState;
        return (String) $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendAliasDialog$lambda$5(final List $suggestions, final MutableState $selectedNickname$delegate, final Function1 $onConfirm, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C63@2482L3100,60@2366L3216:RecommendHandleDialog.kt#xobjkw");
        if ($composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(594964088, $changed, -1, "usercenter.RecommendAliasDialog.<anonymous> (RecommendHandleDialog.kt:60)");
            }
            CardKt.Card(SizeKt.fillMaxWidth(Modifier.Companion, 0.75f), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16)), (CardColors) null, (CardElevation) null, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(1648427590, true, new Function3() { // from class: usercenter.RecommendHandleDialogKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit RecommendAliasDialog$lambda$5$0;
                    RecommendAliasDialog$lambda$5$0 = RecommendHandleDialogKt.RecommendAliasDialog$lambda$5$0($suggestions, $selectedNickname$delegate, $onConfirm, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return RecommendAliasDialog$lambda$5$0;
                }
            }, $composer, 54), $composer, 196614, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x05a2, code lost:
        if (r8 == androidx.compose.runtime.Composer.Companion.getEmpty()) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x056e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x059a  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x05a6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x061b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Unit RecommendAliasDialog$lambda$5$0(List $suggestions, final MutableState $selectedNickname$delegate, final Function1 $onConfirm, ColumnScope $this$Card, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv3;
        Function0 value$iv;
        boolean invalid$iv;
        Intrinsics.checkNotNullParameter($this$Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C64@2496L3076:RecommendHandleDialog.kt#xobjkw");
        if ($composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1648427590, $changed, -1, "usercenter.RecommendAliasDialog.<anonymous>.<anonymous> (RecommendHandleDialog.kt:64)");
            }
            Modifier modifier$iv = SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
            Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
            MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer, ((6 >> 3) & 14) | ((6 >> 3) & 112));
            int $changed$iv$iv = (6 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer, modifier$iv);
            Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv = factory$iv$iv$iv4;
                $composer.createNode(factory$iv$iv$iv);
            } else {
                factory$iv$iv$iv = factory$iv$iv$iv4;
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
            int i2 = ((6 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -93615633, "C70@2747L9,71@2801L6,68@2610L456,80@3108L685,101@3962L6,99@3834L166,105@4048L1510:RecommendHandleDialog.kt#xobjkw");
            TextKt.Text-Nvy7gAk(ProfileRes.INSTANCE.getString(String0_commonMainKt.getProfile_global_string_71(ProfileRes.INSTANCE.getString())), PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl(20), Dp.constructor-impl(24)), BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16b(), $composer, 48, 0, 130040);
            Alignment.Horizontal horizontalAlignment$iv2 = Alignment.Companion.getStart();
            Arrangement.Vertical vertical = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(24));
            Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(Modifier.Companion, Dp.constructor-impl(20), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 2, (Object) null), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, Dp.constructor-impl(24), 7, (Object) null);
            Arrangement.Vertical verticalArrangement$iv2 = vertical;
            int $changed$iv = 438;
            ComposerKt.sourceInformationMarkerStart($composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = ColumnKt.columnMeasurePolicy(verticalArrangement$iv2, horizontalAlignment$iv2, $composer, ((AbsoluteCommentItem.BILI_PLAYER_HEIGHT >> 3) & 14) | ((AbsoluteCommentItem.BILI_PLAYER_HEIGHT >> 3) & 112));
            int $changed$iv$iv2 = (AbsoluteCommentItem.BILI_PLAYER_HEIGHT << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv2 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer, modifier$iv2);
            Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer.createNode(factory$iv$iv$iv2);
            } else {
                factory$iv$iv$iv2 = factory$iv$iv$iv5;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            boolean z = false;
            ComposerKt.sourceInformationMarkerStart($composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScope columnScope2 = ColumnScopeInstance.INSTANCE;
            int i4 = ((AbsoluteCommentItem.BILI_PLAYER_HEIGHT >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, 1748504623, "C:RecommendHandleDialog.kt#xobjkw");
            $composer.startReplaceGroup(1303329736);
            ComposerKt.sourceInformation($composer, "*92@3670L83,89@3519L234");
            List $this$forEach$iv = $suggestions;
            boolean z2 = false;
            Iterator it = $this$forEach$iv.iterator();
            while (true) {
                Iterable $this$forEach$iv2 = $this$forEach$iv;
                if (!it.hasNext()) {
                    break;
                }
                Object element$iv = it.next();
                boolean z3 = z2;
                final String nickname = (String) element$iv;
                CompositionLocalMap localMap$iv$iv3 = localMap$iv$iv2;
                boolean areEqual = Intrinsics.areEqual(RecommendAliasDialog$lambda$3($selectedNickname$delegate), nickname);
                boolean z4 = z;
                ComposerKt.sourceInformationMarkerStart($composer, -1308813315, "CC(remember):RecommendHandleDialog.kt#9igjgp");
                boolean invalid$iv2 = $composer.changed(nickname);
                int $changed$iv2 = $changed$iv;
                Object it$iv = $composer.rememberedValue();
                if (!invalid$iv2 && it$iv != Composer.Companion.getEmpty()) {
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    Selection(nickname, areEqual, (Function0) it$iv, $composer, 0);
                    $this$forEach$iv = $this$forEach$iv2;
                    z2 = z3;
                    localMap$iv$iv2 = localMap$iv$iv3;
                    z = z4;
                    $changed$iv = $changed$iv2;
                }
                Object value$iv2 = new Function0() { // from class: usercenter.RecommendHandleDialogKt$$ExternalSyntheticLambda8
                    public final Object invoke() {
                        Unit RecommendAliasDialog$lambda$5$0$0$0$0$0$0;
                        RecommendAliasDialog$lambda$5$0$0$0$0$0$0 = RecommendHandleDialogKt.RecommendAliasDialog$lambda$5$0$0$0$0$0$0(nickname, $selectedNickname$delegate);
                        return RecommendAliasDialog$lambda$5$0$0$0$0$0$0;
                    }
                };
                $composer.updateRememberedValue(value$iv2);
                it$iv = value$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                Selection(nickname, areEqual, (Function0) it$iv, $composer, 0);
                $this$forEach$iv = $this$forEach$iv2;
                z2 = z3;
                localMap$iv$iv2 = localMap$iv$iv3;
                z = z4;
                $changed$iv = $changed$iv2;
            }
            $composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            DividerKt.HorizontalDivider-9IZ8Weo(SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl((float) 0.5d)), (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getLine_regular-0d7_KjU(), $composer, 6, 2);
            Modifier modifier$iv3 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl(44));
            Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.getSpaceEvenly();
            ComposerKt.sourceInformationMarkerStart($composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getTop();
            MeasurePolicy measurePolicy$iv3 = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer, ((54 >> 3) & 14) | ((54 >> 3) & 112));
            int $changed$iv$iv3 = (54 << 3) & 112;
            ComposerKt.sourceInformationMarkerStart($composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer, 0));
            CompositionLocalMap localMap$iv$iv4 = $composer.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer, modifier$iv3);
            Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
            int $i$f$Row = $changed$iv$iv3 << 6;
            int $changed$iv$iv$iv3 = ($i$f$Row & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer.createNode(factory$iv$iv$iv3);
            } else {
                factory$iv$iv$iv3 = factory$iv$iv$iv6;
                $composer.useNode();
            }
            Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer);
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv4, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
            int i5 = ($changed$iv$iv$iv3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            int i6 = ((54 >> 6) & 112) | 6;
            RowScope $this$RecommendAliasDialog_u24lambda_u245_u240_u240_u241 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart($composer, -281828392, "C111@4307L19,110@4261L445,123@4805L31,126@4976L564,122@4759L781:RecommendHandleDialog.kt#xobjkw");
            ComposerKt.sourceInformationMarkerStart($composer, 1653476959, "CC(remember):RecommendHandleDialog.kt#9igjgp");
            boolean invalid$iv3 = $composer.changed($onConfirm);
            Object it$iv2 = $composer.rememberedValue();
            if (!invalid$iv3 && it$iv2 != Composer.Companion.getEmpty()) {
                value$iv = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ButtonKt.TextButton(value$iv, RowScope.-CC.weight$default($this$RecommendAliasDialog_u24lambda_u245_u240_u240_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$RecommendHandleDialogKt.INSTANCE.getLambda$35851535$usercenter_debug(), $composer, 805306368, 508);
                boolean z5 = RecommendAliasDialog$lambda$3($selectedNickname$delegate) == null;
                Modifier weight$default = RowScope.-CC.weight$default($this$RecommendAliasDialog_u24lambda_u245_u240_u240_u241, Modifier.Companion, 1.0f, false, 2, (Object) null);
                ComposerKt.sourceInformationMarkerStart($composer, 1653492907, "CC(remember):RecommendHandleDialog.kt#9igjgp");
                invalid$iv = $composer.changed($onConfirm);
                Object it$iv3 = $composer.rememberedValue();
                if (invalid$iv) {
                }
                Object value$iv3 = new Function0() { // from class: usercenter.RecommendHandleDialogKt$$ExternalSyntheticLambda10
                    public final Object invoke() {
                        Unit RecommendAliasDialog$lambda$5$0$0$1$1$0;
                        RecommendAliasDialog$lambda$5$0$0$1$1$0 = RecommendHandleDialogKt.RecommendAliasDialog$lambda$5$0$0$1$1$0($onConfirm, $selectedNickname$delegate);
                        return RecommendAliasDialog$lambda$5$0$0$1$1$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer);
                ButtonKt.TextButton((Function0) it$iv3, weight$default, z5, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(328541048, true, new Function3() { // from class: usercenter.RecommendHandleDialogKt$$ExternalSyntheticLambda0
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit RecommendAliasDialog$lambda$5$0$0$1$2;
                        RecommendAliasDialog$lambda$5$0$0$1$2 = RecommendHandleDialogKt.RecommendAliasDialog$lambda$5$0$0$1$2($selectedNickname$delegate, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        return RecommendAliasDialog$lambda$5$0$0$1$2;
                    }
                }, $composer, 54), $composer, 805306368, 504);
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
            value$iv = new Function0() { // from class: usercenter.RecommendHandleDialogKt$$ExternalSyntheticLambda9
                public final Object invoke() {
                    Unit RecommendAliasDialog$lambda$5$0$0$1$0$0;
                    RecommendAliasDialog$lambda$5$0$0$1$0$0 = RecommendHandleDialogKt.RecommendAliasDialog$lambda$5$0$0$1$0$0($onConfirm);
                    return RecommendAliasDialog$lambda$5$0$0$1$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton(value$iv, RowScope.-CC.weight$default($this$RecommendAliasDialog_u24lambda_u245_u240_u240_u241, Modifier.Companion, 1.0f, false, 2, (Object) null), false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableSingletons$RecommendHandleDialogKt.INSTANCE.getLambda$35851535$usercenter_debug(), $composer, 805306368, 508);
            if (RecommendAliasDialog$lambda$3($selectedNickname$delegate) == null) {
            }
            Modifier weight$default2 = RowScope.-CC.weight$default($this$RecommendAliasDialog_u24lambda_u245_u240_u240_u241, Modifier.Companion, 1.0f, false, 2, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer, 1653492907, "CC(remember):RecommendHandleDialog.kt#9igjgp");
            invalid$iv = $composer.changed($onConfirm);
            Object it$iv32 = $composer.rememberedValue();
            if (invalid$iv) {
            }
            Object value$iv32 = new Function0() { // from class: usercenter.RecommendHandleDialogKt$$ExternalSyntheticLambda10
                public final Object invoke() {
                    Unit RecommendAliasDialog$lambda$5$0$0$1$1$0;
                    RecommendAliasDialog$lambda$5$0$0$1$1$0 = RecommendHandleDialogKt.RecommendAliasDialog$lambda$5$0$0$1$1$0($onConfirm, $selectedNickname$delegate);
                    return RecommendAliasDialog$lambda$5$0$0$1$1$0;
                }
            };
            $composer.updateRememberedValue(value$iv32);
            it$iv32 = value$iv32;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ButtonKt.TextButton((Function0) it$iv32, weight$default2, z5, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, ComposableLambdaKt.rememberComposableLambda(328541048, true, new Function3() { // from class: usercenter.RecommendHandleDialogKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    Unit RecommendAliasDialog$lambda$5$0$0$1$2;
                    RecommendAliasDialog$lambda$5$0$0$1$2 = RecommendHandleDialogKt.RecommendAliasDialog$lambda$5$0$0$1$2($selectedNickname$delegate, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    return RecommendAliasDialog$lambda$5$0$0$1$2;
                }
            }, $composer, 54), $composer, 805306368, 504);
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
            }
        } else {
            $composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendAliasDialog$lambda$5$0$0$0$0$0$0(String $nickname, MutableState $selectedNickname$delegate) {
        $selectedNickname$delegate.setValue($nickname);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendAliasDialog$lambda$5$0$0$1$0$0(Function1 $onConfirm) {
        $onConfirm.invoke((Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendAliasDialog$lambda$5$0$0$1$1$0(Function1 $onConfirm, MutableState $selectedNickname$delegate) {
        $onConfirm.invoke(RecommendAliasDialog$lambda$3($selectedNickname$delegate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecommendAliasDialog$lambda$5$0$0$1$2(MutableState $selectedNickname$delegate, RowScope $this$TextButton, Composer $composer, int $changed) {
        long j;
        Intrinsics.checkNotNullParameter($this$TextButton, "$this$TextButton");
        ComposerKt.sourceInformation($composer, "C129@5155L9,127@5002L516:RecommendHandleDialog.kt#xobjkw");
        if (!$composer.shouldExecute(($changed & 17) != 16, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(328541048, $changed, -1, "usercenter.RecommendAliasDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RecommendHandleDialog.kt:127)");
            }
            String string = ProfileRes.INSTANCE.getString(String0_commonMainKt.getProfile_global_string_18(ProfileRes.INSTANCE.getString()));
            TextStyle t16 = BiliTheme.INSTANCE.getTextStyle($composer, BiliTheme.$stable).getT16();
            if (RecommendAliasDialog$lambda$3($selectedNickname$delegate) != null) {
                $composer.startReplaceGroup(-663813881);
                ComposerKt.sourceInformation($composer, "132@5316L6");
                long j2 = BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                $composer.endReplaceGroup();
                j = j2;
            } else {
                $composer.startReplaceGroup(-663709132);
                ComposerKt.sourceInformation($composer, "134@5421L6");
                long j3 = Color.copy-wmQWz5c$default(BiliTheme.INSTANCE.getColors($composer, BiliTheme.$stable).getBrand_pink-0d7_KjU(), 0.4f, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 14, (Object) null);
                $composer.endReplaceGroup();
                j = j3;
            }
            TextKt.Text-Nvy7gAk(string, (Modifier) null, j, (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, t16, $composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void Selection(final String text, final boolean selected, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Composer $composer2;
        Function0 factory$iv$iv$iv;
        long j;
        Function0 factory$iv$iv$iv2;
        Composer $composer3 = $composer.startRestartGroup(-1441050029);
        ComposerKt.sourceInformation($composer3, "C(Selection)N(text,selected,onClick)157@5952L13,150@5701L1273:RecommendHandleDialog.kt#xobjkw");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(text) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(selected) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1441050029, $dirty2, -1, "usercenter.Selection (RecommendHandleDialog.kt:149)");
            }
            Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
            Arrangement.Horizontal horizontal = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(8));
            Modifier modifier = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, 1, (Object) null), Dp.constructor-impl(22));
            ComposerKt.sourceInformationMarkerStart($composer3, -1869597664, "CC(remember):RecommendHandleDialog.kt#9igjgp");
            boolean invalid$iv = ($dirty2 & 896) == 256;
            Object it$iv = $composer3.rememberedValue();
            if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: usercenter.RecommendHandleDialogKt$$ExternalSyntheticLambda2
                    public final Object invoke() {
                        Unit Selection$lambda$0$0;
                        Selection$lambda$0$0 = RecommendHandleDialogKt.Selection$lambda$0$0(function0);
                        return Selection$lambda$0$0;
                    }
                };
                $composer3.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
            Arrangement.Horizontal horizontalArrangement$iv = horizontal;
            ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((432 >> 3) & 14) | ((432 >> 3) & 112));
            int $changed$iv$iv = (432 << 3) & 112;
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
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
            Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
            Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
            int i = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScope rowScope = RowScopeInstance.INSTANCE;
            int i2 = ((432 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -1838463429, "C168@6379L6,159@5983L846,185@6900L9,186@6945L6,183@6839L129:RecommendHandleDialog.kt#xobjkw");
            Modifier modifier2 = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(22));
            if (selected) {
                $composer3.startReplaceGroup(-59300423);
                ComposerKt.sourceInformation($composer3, "164@6158L6");
                j = BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU();
                $composer3.endReplaceGroup();
            } else {
                $composer3.startReplaceGroup(-59299718);
                $composer3.endReplaceGroup();
                j = Color.Companion.getTransparent-0d7_KjU();
            }
            Modifier modifier$iv2 = BorderKt.border-xT4_qwU(BackgroundKt.background-bw27NRU(modifier2, j, RoundedCornerShapeKt.getCircleShape()), selected ? Dp.constructor-impl(0) : Dp.constructor-impl(1), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getLine_bold-0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
            Alignment contentAlignment$iv = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv2 = (48 << 3) & 112;
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
            int i3 = ($changed$iv$iv$iv2 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i4 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, 506796417, "C:RecommendHandleDialog.kt#xobjkw");
            if (selected) {
                $composer3.startReplaceGroup(506826734);
                ComposerKt.sourceInformation($composer3, "175@6619L18,177@6729L6,174@6570L235");
                IconKt.Icon-ww6aTOc(BiliIconfont.INSTANCE.getCheckmark_line_800($composer3, 6), (String) null, SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getWh0-0d7_KjU(), $composer3, Painter.$stable | 432, 0);
            } else {
                $composer3.startReplaceGroup(500301017);
            }
            $composer3.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer2 = $composer3;
            TextKt.Text-Nvy7gAk(text, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT14(), $composer3, $dirty2 & 14, 0, 131066);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2 = $composer3;
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: usercenter.RecommendHandleDialogKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit Selection$lambda$2;
                    Selection$lambda$2 = RecommendHandleDialogKt.Selection$lambda$2(text, selected, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return Selection$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Selection$lambda$0$0(Function0 $onClick) {
        $onClick.invoke();
        return Unit.INSTANCE;
    }
}