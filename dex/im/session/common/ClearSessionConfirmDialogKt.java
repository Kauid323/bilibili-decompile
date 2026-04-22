package im.session.common;

import ComposableSingletons$CustomBottomSheetKt$;
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
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.TextAutoSize;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import bili.resource.common.Res;
import bili.resource.im.Res;
import bili.resource.im.String0_commonMainKt;
import com.bilibili.compose.theme.BiliTheme;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import kntr.common.dialog.DialogContent_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.compose.resources.StringResourcesKt;

/* compiled from: ClearSessionConfirmDialog.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a)\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a)\u0010\b\u001a\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0001¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"ClearSessionConfirmDialog", "", "show", "Landroidx/compose/runtime/MutableState;", "", "onConfirmed", "Lkotlin/Function0;", "(Landroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "ClearSessionConfirmDialogContent", "onCancel", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "session-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ClearSessionConfirmDialogKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClearSessionConfirmDialog$lambda$2(MutableState mutableState, Function0 function0, int i2, Composer composer, int i3) {
        ClearSessionConfirmDialog(mutableState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClearSessionConfirmDialogContent$lambda$0(Function0 function0, Function0 function02, int i2, Composer composer, int i3) {
        ClearSessionConfirmDialogContent(function0, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void ClearSessionConfirmDialog(final MutableState<Boolean> mutableState, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(mutableState, "show");
        Intrinsics.checkNotNullParameter(function0, "onConfirmed");
        Composer $composer2 = $composer.startRestartGroup(-373281322);
        ComposerKt.sourceInformation($composer2, "C(ClearSessionConfirmDialog)N(show,onConfirmed)22@765L83,27@951L71,27@853L169:ClearSessionConfirmDialog.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(mutableState) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 19) != 18, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-373281322, $dirty2, -1, "im.session.common.ClearSessionConfirmDialog (ClearSessionConfirmDialog.kt:20)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 2053906473, "CC(remember):ClearSessionConfirmDialog.kt#9igjgp");
            Object it$iv = $composer2.rememberedValue();
            if (it$iv == Composer.Companion.getEmpty()) {
                Object value$iv = new Function0() { // from class: im.session.common.ClearSessionConfirmDialogKt$$ExternalSyntheticLambda1
                    public final Object invoke() {
                        Unit ClearSessionConfirmDialog$lambda$0$0;
                        ClearSessionConfirmDialog$lambda$0$0 = ClearSessionConfirmDialogKt.ClearSessionConfirmDialog$lambda$0$0(mutableState);
                        return ClearSessionConfirmDialog$lambda$0$0;
                    }
                };
                $composer2.updateRememberedValue(value$iv);
                it$iv = value$iv;
            }
            final Function0 onCancel = (Function0) it$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            AndroidDialog_androidKt.Dialog(onCancel, new DialogProperties(false, false, false, 5, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(698855149, true, new Function2() { // from class: im.session.common.ClearSessionConfirmDialogKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ClearSessionConfirmDialog$lambda$1;
                    ClearSessionConfirmDialog$lambda$1 = ClearSessionConfirmDialogKt.ClearSessionConfirmDialog$lambda$1(onCancel, function0, (Composer) obj, ((Integer) obj2).intValue());
                    return ClearSessionConfirmDialog$lambda$1;
                }
            }, $composer2, 54), $composer2, 438, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.ClearSessionConfirmDialogKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit ClearSessionConfirmDialog$lambda$2;
                    ClearSessionConfirmDialog$lambda$2 = ClearSessionConfirmDialogKt.ClearSessionConfirmDialog$lambda$2(mutableState, function0, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ClearSessionConfirmDialog$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClearSessionConfirmDialog$lambda$0$0(MutableState $show) {
        $show.setValue(false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ClearSessionConfirmDialog$lambda$1(Function0 $onCancel, Function0 $onConfirmed, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C28@961L55:ClearSessionConfirmDialog.kt#yqxgzx");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(698855149, $changed, -1, "im.session.common.ClearSessionConfirmDialog.<anonymous> (ClearSessionConfirmDialog.kt:28)");
            }
            ClearSessionConfirmDialogContent($onCancel, $onConfirmed, $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void ClearSessionConfirmDialogContent(final Function0<Unit> function0, final Function0<Unit> function02, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(function0, "onCancel");
        Intrinsics.checkNotNullParameter(function02, "onConfirmed");
        Composer $composer2 = $composer.startRestartGroup(1051048128);
        ComposerKt.sourceInformation($composer2, "C(ClearSessionConfirmDialogContent)N(onCancel,onConfirmed)38@1185L48,39@1259L49,40@1335L57,41@1419L57,37@1148L410:ClearSessionConfirmDialog.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(function02) ? 32 : 16;
        }
        if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1051048128, $dirty, -1, "im.session.common.ClearSessionConfirmDialogContent (ClearSessionConfirmDialog.kt:36)");
            }
            final String titleString$iv = StringResourcesKt.stringResource(String0_commonMainKt.getIm_global_string_63(Res.string.INSTANCE), $composer2, 0);
            final String contentString$iv = StringResourcesKt.stringResource(String0_commonMainKt.getIm_global_string_613(Res.string.INSTANCE), $composer2, 0);
            final String negativeString$iv = StringResourcesKt.stringResource(bili.resource.common.String0_commonMainKt.getCommon_global_string_238(Res.string.INSTANCE), $composer2, 0);
            final String positiveString$iv = StringResourcesKt.stringResource(bili.resource.common.String0_commonMainKt.getCommon_global_string_194(Res.string.INSTANCE), $composer2, 0);
            int $changed$iv = (($dirty << 6) & 896) | (($dirty << 6) & 7168);
            ComposerKt.sourceInformationMarkerStart($composer2, -1894279827, "CC(DialogContent)N(titleString,contentString,onNegativeClick,onPositiveClick,modifier,negativeString,positiveString)150@4902L39,151@4973L40,154@5059L1495,194@6591L873,153@5023L2441:DialogContent.kt#j1m0ki");
            Modifier modifier$iv = Modifier.Companion;
            DialogContent_androidKt.DialogContent(ComposableLambdaKt.rememberComposableLambda(93781831, true, new Function2<Composer, Integer, Unit>() { // from class: im.session.common.ClearSessionConfirmDialogKt$ClearSessionConfirmDialogContent$$inlined$DialogContent$1
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    Function0 factory$iv$iv$iv;
                    Composer $composer$iv$iv$iv;
                    Composer $composer$iv;
                    String str;
                    String str2;
                    String str3;
                    Function0 function03;
                    Composer $composer$iv$iv;
                    Function0 factory$iv$iv$iv2;
                    Function0 factory$iv$iv$iv3;
                    ComposerKt.sourceInformation($composer3, "C155@5073L1471:DialogContent.kt#j1m0ki");
                    if (!$composer3.shouldExecute(($changed2 & 3) != 2, $changed2 & 1)) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(93781831, $changed2, -1, "kntr.common.dialog.DialogContent.<anonymous> (DialogContent.kt:155)");
                    }
                    Modifier modifier$iv2 = SizeKt.height-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl(44));
                    Alignment.Vertical verticalAlignment$iv = Alignment.Companion.getCenterVertically();
                    Arrangement.Horizontal horizontalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(16));
                    String str4 = negativeString$iv;
                    String str5 = positiveString$iv;
                    final Function0 function04 = function0;
                    Function0 function05 = function02;
                    ComposerKt.sourceInformationMarkerStart($composer3, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv = RowKt.rowMeasurePolicy(horizontalArrangement$iv, verticalAlignment$iv, $composer3, ((438 >> 3) & 14) | ((438 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
                    int $changed$iv$iv = (438 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                    Function0 factory$iv$iv$iv4 = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        factory$iv$iv$iv = factory$iv$iv$iv4;
                        $composer3.createNode(factory$iv$iv$iv);
                    } else {
                        factory$iv$iv$iv = factory$iv$iv$iv4;
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    int i2 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScope rowScope = RowScopeInstance.INSTANCE;
                    int i3 = ((438 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                    RowScope $this$invoke_u24lambda_u240 = rowScope;
                    ComposerKt.sourceInformationMarkerStart($composer3, 145669907, "C:DialogContent.kt#j1m0ki");
                    if (str4 != null) {
                        $composer3.startReplaceGroup(145677532);
                        ComposerKt.sourceInformation($composer3, "161@5359L531");
                        Modifier modifier$iv3 = ClickableKt.clickable-oSLSa3U$default(RowScope.-CC.weight$default($this$invoke_u24lambda_u240, SizeKt.fillMaxHeight$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), 1.0f, false, 2, (Object) null), false, (String) null, (Role) null, (MutableInteractionSource) null, new Function0<Unit>() { // from class: im.session.common.ClearSessionConfirmDialogKt$ClearSessionConfirmDialogContent$$inlined$DialogContent$1.1
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m3252invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m3252invoke() {
                                function04.invoke();
                            }
                        }, 15, (Object) null);
                        Alignment contentAlignment$iv = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicy$iv2 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
                        int $changed$iv$iv2 = (48 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv2 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                        CompositionLocalMap localMap$iv$iv2 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv2 = ComposedModifierKt.materializeModifier($composer3, modifier$iv3);
                        Function0 factory$iv$iv$iv5 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv2 = (($changed$iv$iv2 << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            factory$iv$iv$iv3 = factory$iv$iv$iv5;
                            $composer3.createNode(factory$iv$iv$iv3);
                        } else {
                            factory$iv$iv$iv3 = factory$iv$iv$iv5;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv2 = Updater.constructor-impl($composer3);
                        $composer$iv$iv$iv = $composer3;
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, measurePolicy$iv2, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, localMap$iv$iv2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv2, Integer.valueOf(compositeKeyHash$iv$iv2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv2, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv2, materialized$iv$iv2, ComposeUiNode.Companion.getSetModifier());
                        int i4 = ($changed$iv$iv$iv2 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int i5 = ((48 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1099396812, "C170@5768L6,171@5828L9,168@5665L203:DialogContent.kt#j1m0ki");
                        $composer$iv = $composer3;
                        function03 = function05;
                        $composer$iv$iv = $composer3;
                        str = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                        str3 = str5;
                        str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                        TextKt.Text-Nvy7gAk(str4, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16(), $composer3, 0, 0, 131066);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                    } else {
                        $composer$iv$iv$iv = $composer3;
                        $composer$iv = $composer3;
                        str = "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo";
                        str2 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
                        str3 = str5;
                        function03 = function05;
                        $composer$iv$iv = $composer3;
                        $composer3.startReplaceGroup(140364535);
                    }
                    $composer3.endReplaceGroup();
                    if (str3 != null) {
                        $composer3.startReplaceGroup(146289751);
                        ComposerKt.sourceInformation($composer3, "177@5976L536");
                        final Function0 function06 = function03;
                        Modifier modifier$iv4 = ClickableKt.clickable-oSLSa3U$default(RowScope.-CC.weight$default($this$invoke_u24lambda_u240, SizeKt.fillMaxHeight$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), 1.0f, false, 2, (Object) null), false, (String) null, (Role) null, (MutableInteractionSource) null, new Function0<Unit>() { // from class: im.session.common.ClearSessionConfirmDialogKt$ClearSessionConfirmDialogContent$$inlined$DialogContent$1.2
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m3253invoke();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: collision with other method in class */
                            public final void m3253invoke() {
                                function06.invoke();
                            }
                        }, 15, (Object) null);
                        Alignment contentAlignment$iv2 = Alignment.Companion.getCenter();
                        ComposerKt.sourceInformationMarkerStart($composer3, 1042775818, str);
                        MeasurePolicy measurePolicy$iv3 = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv2, false);
                        int $changed$iv$iv3 = (48 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, str2);
                        int compositeKeyHash$iv$iv3 = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                        CompositionLocalMap localMap$iv$iv3 = $composer3.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv3 = ComposedModifierKt.materializeModifier($composer3, modifier$iv4);
                        Function0 factory$iv$iv$iv6 = ComposeUiNode.Companion.getConstructor();
                        int $i$f$Box = $changed$iv$iv3 << 6;
                        int $changed$iv$iv$iv3 = ($i$f$Box & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer3.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer3.startReusableNode();
                        if ($composer3.getInserting()) {
                            factory$iv$iv$iv2 = factory$iv$iv$iv6;
                            $composer3.createNode(factory$iv$iv$iv2);
                        } else {
                            factory$iv$iv$iv2 = factory$iv$iv$iv6;
                            $composer3.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv3 = Updater.constructor-impl($composer3);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, measurePolicy$iv3, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, localMap$iv$iv3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv3, Integer.valueOf(compositeKeyHash$iv$iv3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv3, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv3, materialized$iv$iv3, ComposeUiNode.Companion.getSetModifier());
                        int i6 = ($changed$iv$iv$iv3 >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer3, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                        int i7 = ((48 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer3, -1196457072, "C186@6385L6,187@6450L9,184@6282L208:DialogContent.kt#j1m0ki");
                        TextKt.Text-Nvy7gAk(str3, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getBrand_pink-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16(), $composer3, 0, 0, 131066);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        $composer3.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                        ComposerKt.sourceInformationMarkerEnd($composer3);
                    } else {
                        $composer3.startReplaceGroup(140364535);
                    }
                    $composer3.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer$iv$iv$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd($composer$iv);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), modifier$iv, ComposableLambdaKt.rememberComposableLambda(1990761289, true, new Function2<Composer, Integer, Unit>() { // from class: im.session.common.ClearSessionConfirmDialogKt$ClearSessionConfirmDialogContent$$inlined$DialogContent$2
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                    invoke((Composer) p1, ((Number) p2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    Composer $composer4;
                    ComposerKt.sourceInformation($composer3, "C195@6601L857:DialogContent.kt#j1m0ki");
                    if (!$composer3.shouldExecute(($changed2 & 3) != 2, $changed2 & 1)) {
                        $composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1990761289, $changed2, -1, "kntr.common.dialog.DialogContent.<anonymous> (DialogContent.kt:195)");
                    }
                    Modifier modifier$iv2 = PaddingKt.padding-qDBjuR0$default(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), Dp.constructor-impl(20), (float) CropImageView.DEFAULT_ASPECT_RATIO, 2, (Object) null), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(18), (float) CropImageView.DEFAULT_ASPECT_RATIO, Dp.constructor-impl(24), 5, (Object) null);
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl(6));
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getCenterHorizontally();
                    String str = titleString$iv;
                    String str2 = contentString$iv;
                    ComposerKt.sourceInformationMarkerStart($composer3, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer3, ((438 >> 3) & 14) | ((438 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
                    int $changed$iv$iv = (438 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                    ComposerKt.sourceInformationMarkerStart($composer3, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer3, 0));
                    CompositionLocalMap localMap$iv$iv = $composer3.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer3, modifier$iv2);
                    Function0 factory$iv$iv$iv = ComposeUiNode.Companion.getConstructor();
                    int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                    if (!($composer3.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer3.startReusableNode();
                    if ($composer3.getInserting()) {
                        $composer3.createNode(factory$iv$iv$iv);
                    } else {
                        $composer3.useNode();
                    }
                    Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer3);
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                    Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                    int i2 = ($changed$iv$iv$iv >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer3, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    int i3 = ((438 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer3, -81923373, "C206@7027L6,207@7075L9,204@6951L199:DialogContent.kt#j1m0ki");
                    TextKt.Text-Nvy7gAk(str, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText1-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT16b(), $composer3, 0, 0, 130042);
                    if (StringsKt.isBlank(str2)) {
                        $composer4 = $composer3;
                        $composer4.startReplaceGroup(-88835165);
                    } else {
                        $composer3.startReplaceGroup(-81671065);
                        ComposerKt.sourceInformation($composer3, "214@7300L6,215@7352L9,212@7214L220");
                        $composer4 = $composer3;
                        TextKt.Text-Nvy7gAk(str2, (Modifier) null, BiliTheme.INSTANCE.getColors($composer3, BiliTheme.$stable).getText2-0d7_KjU(), (TextAutoSize) null, 0L, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, BiliTheme.INSTANCE.getTextStyle($composer3, BiliTheme.$stable).getT13(), $composer4, 0, 0, 130042);
                    }
                    $composer4.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer2, 54), $composer2, (($changed$iv >> 9) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 390, 0);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.ClearSessionConfirmDialogKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit ClearSessionConfirmDialogContent$lambda$0;
                    ClearSessionConfirmDialogContent$lambda$0 = ClearSessionConfirmDialogKt.ClearSessionConfirmDialogContent$lambda$0(function0, function02, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return ClearSessionConfirmDialogContent$lambda$0;
                }
            });
        }
    }
}