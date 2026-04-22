package im.session.bottomsheet;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.iconfont.BiliIconfont;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tauth.AuthActivity;
import com.yalantis.ucrop.view.CropImageView;
import im.session.common.IMSessionActionHandler;
import im.session.model.IMSessionCardOperation;
import im.session.model.IMSessionCardOperationType;
import java.util.List;
import kntr.common.bilitheme.compose.bottomsheet.BottomSheetScope;
import kntr.common.bilitheme.compose.bottomsheet.ComposeBottomsheetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: IMConversationBottomSheet.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a1\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\u0010\t\u001a!\u0010\n\u001a\u00020\u0001*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0001¢\u0006\u0002\u0010\r\" \u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u00048AX\u0080\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"IMConversationBottomSheet", "", "operations", "", "Lim/session/model/IMSessionCardOperation;", "onDismiss", "Lkotlin/Function0;", "onAction", "Lim/session/common/IMSessionActionHandler;", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;Lim/session/common/IMSessionActionHandler;Landroidx/compose/runtime/Composer;I)V", "IMConversationActionItem", "Lkntr/common/bilitheme/compose/bottomsheet/BottomSheetScope;", AuthActivity.ACTION_KEY, "(Lkntr/common/bilitheme/compose/bottomsheet/BottomSheetScope;Lim/session/model/IMSessionCardOperation;Lim/session/common/IMSessionActionHandler;Landroidx/compose/runtime/Composer;I)V", "icon", "Landroidx/compose/ui/graphics/painter/Painter;", "getIcon$annotations", "(Lim/session/model/IMSessionCardOperation;Landroidx/compose/runtime/Composer;I)V", "getIcon", "(Lim/session/model/IMSessionCardOperation;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "session-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMConversationBottomSheetKt {

    /* compiled from: IMConversationBottomSheet.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IMSessionCardOperationType.values().length];
            try {
                iArr[IMSessionCardOperationType.PIN.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[IMSessionCardOperationType.UNPIN.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[IMSessionCardOperationType.DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[IMSessionCardOperationType.CLEAR_UNREAD.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[IMSessionCardOperationType.UNBLOCK.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMConversationActionItem$lambda$1(BottomSheetScope bottomSheetScope, IMSessionCardOperation iMSessionCardOperation, IMSessionActionHandler iMSessionActionHandler, int i2, Composer composer, int i3) {
        IMConversationActionItem(bottomSheetScope, iMSessionCardOperation, iMSessionActionHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMConversationBottomSheet$lambda$1(List list, Function0 function0, IMSessionActionHandler iMSessionActionHandler, int i2, Composer composer, int i3) {
        IMConversationBottomSheet(list, function0, iMSessionActionHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static /* synthetic */ void getIcon$annotations(IMSessionCardOperation iMSessionCardOperation, Composer composer, int i2) {
    }

    public static final void IMConversationBottomSheet(final List<IMSessionCardOperation> list, final Function0<Unit> function0, final IMSessionActionHandler onAction, Composer $composer, final int $changed) {
        Composer $composer2;
        Intrinsics.checkNotNullParameter(list, "operations");
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        Composer $composer3 = $composer.startRestartGroup(103937244);
        ComposerKt.sourceInformation($composer3, "C(IMConversationBottomSheet)N(operations,onDismiss,onAction)23@895L155:IMConversationBottomSheet.kt#dcxxbm");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changedInstance(list) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= ($changed & 512) == 0 ? $composer3.changed(onAction) : $composer3.changedInstance(onAction) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if ($composer3.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(103937244, $dirty2, -1, "im.session.bottomsheet.IMConversationBottomSheet (IMConversationBottomSheet.kt:22)");
            }
            int $changed$iv = ($dirty2 >> 3) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -1330546869, "CC(BottomSheetColumnContainer)N(onDismiss,modifier,content)154@5815L207,154@5771L251:ComposeBottomsheet.kt#18ljev");
            final Modifier modifier$iv = Modifier.Companion;
            $composer2 = $composer3;
            ComposeBottomsheetKt.BottomSheetContainer-lVb_Clg(function0, (Function0) null, 0L, false, false, false, (PaddingValues) null, ComposableLambdaKt.rememberComposableLambda(1454232538, true, new Function3<BottomSheetScope, Composer, Integer, Unit>() { // from class: im.session.bottomsheet.IMConversationBottomSheetKt$IMConversationBottomSheet$$inlined$BottomSheetColumnContainer$1
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                    invoke((BottomSheetScope) p1, (Composer) p2, ((Number) p3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BottomSheetScope $this$BottomSheetContainer, Composer $composer4, int $changed2) {
                    Function0 factory$iv$iv$iv;
                    IMConversationBottomSheetKt$IMConversationBottomSheet$$inlined$BottomSheetColumnContainer$1 iMConversationBottomSheetKt$IMConversationBottomSheet$$inlined$BottomSheetColumnContainer$1 = this;
                    Intrinsics.checkNotNullParameter($this$BottomSheetContainer, "$this$BottomSheetContainer");
                    ComposerKt.sourceInformation($composer4, "C155@5825L191:ComposeBottomsheet.kt#18ljev");
                    int $dirty3 = $changed2;
                    if (($changed2 & 6) == 0) {
                        $dirty3 |= $composer4.changed($this$BottomSheetContainer) ? 4 : 2;
                    }
                    if ($composer4.shouldExecute(($dirty3 & 19) != 18, $dirty3 & 1)) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1454232538, $dirty3, -1, "kntr.common.bilitheme.compose.bottomsheet.BottomSheetColumnContainer.<anonymous> (ComposeBottomsheet.kt:155)");
                        }
                        Modifier modifier$iv2 = ClipKt.clip(SizeKt.fillMaxWidth$default(modifier$iv, (float) CropImageView.DEFAULT_ASPECT_RATIO, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
                        ComposerKt.sourceInformationMarkerStart($composer4, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                        Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                        Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                        MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer4, ((0 >> 3) & 14) | ((0 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
                        int $changed$iv$iv = (0 << 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW;
                        ComposerKt.sourceInformationMarkerStart($composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer4, 0));
                        CompositionLocalMap localMap$iv$iv = $composer4.getCurrentCompositionLocalMap();
                        Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer4, modifier$iv2);
                        Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
                        int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
                        if (!($composer4.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        $composer4.startReusableNode();
                        if ($composer4.getInserting()) {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer4.createNode(factory$iv$iv$iv);
                        } else {
                            factory$iv$iv$iv = factory$iv$iv$iv2;
                            $composer4.useNode();
                        }
                        Composer $this$Layout_u24lambda_u240$iv$iv = Updater.constructor-impl($composer4);
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, measurePolicy$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, localMap$iv$iv, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        Updater.init-impl($this$Layout_u24lambda_u240$iv$iv, Integer.valueOf(compositeKeyHash$iv$iv), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        Updater.reconcile-impl($this$Layout_u24lambda_u240$iv$iv, ComposeUiNode.Companion.getApplyOnDeactivatedNodeAssertion());
                        Updater.set-impl($this$Layout_u24lambda_u240$iv$iv, materialized$iv$iv, ComposeUiNode.Companion.getSetModifier());
                        int i2 = ($changed$iv$iv$iv >> 6) & 14;
                        ComposerKt.sourceInformationMarkerStart($composer4, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                        ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                        int i3 = ((0 >> 6) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) | 6;
                        ComposerKt.sourceInformationMarkerStart($composer4, 639823158, "C160@5994L9:ComposeBottomsheet.kt#18ljev");
                        int $changed3 = $dirty3 & 14;
                        $composer4.startReplaceGroup(490571150);
                        ComposerKt.sourceInformation($composer4, "C:IMConversationBottomSheet.kt#dcxxbm");
                        $composer4.startReplaceGroup(1401298538);
                        ComposerKt.sourceInformation($composer4, "*25@989L45");
                        Iterable $this$forEach$iv = list;
                        for (Object element$iv : $this$forEach$iv) {
                            Iterable $this$forEach$iv2 = $this$forEach$iv;
                            IMSessionCardOperation operation = (IMSessionCardOperation) element$iv;
                            IMConversationBottomSheetKt.IMConversationActionItem($this$BottomSheetContainer, operation, onAction, $composer4, $changed3 & 14);
                            iMConversationBottomSheetKt$IMConversationBottomSheet$$inlined$BottomSheetColumnContainer$1 = this;
                            $this$forEach$iv = $this$forEach$iv2;
                            localMap$iv$iv = localMap$iv$iv;
                        }
                        $composer4.endReplaceGroup();
                        $composer4.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        $composer4.endNode();
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        ComposerKt.sourceInformationMarkerEnd($composer4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer4.skipToGroupEnd();
                }
            }, $composer3, 54), $composer3, ($changed$iv & 14) | 12582912, (int) TbsListener.ErrorCode.PV_UPLOAD_ERROR);
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
            endRestartGroup.updateScope(new Function2() { // from class: im.session.bottomsheet.IMConversationBottomSheetKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMConversationBottomSheet$lambda$1;
                    IMConversationBottomSheet$lambda$1 = IMConversationBottomSheetKt.IMConversationBottomSheet$lambda$1(list, function0, onAction, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return IMConversationBottomSheet$lambda$1;
                }
            });
        }
    }

    public static final void IMConversationActionItem(final BottomSheetScope $this$IMConversationActionItem, final IMSessionCardOperation action, final IMSessionActionHandler onAction, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter($this$IMConversationActionItem, "<this>");
        Intrinsics.checkNotNullParameter(action, AuthActivity.ACTION_KEY);
        Intrinsics.checkNotNullParameter(onAction, "onAction");
        Composer $composer2 = $composer.startRestartGroup(-1851154766);
        ComposerKt.sourceInformation($composer2, "C(IMConversationActionItem)N(action,onAction)35@1222L4,36@1243L24:IMConversationBottomSheet.kt#dcxxbm");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed($this$IMConversationActionItem) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(action) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= ($changed & 512) == 0 ? $composer2.changed(onAction) : $composer2.changedInstance(onAction) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1851154766, $dirty2, -1, "im.session.bottomsheet.IMConversationActionItem (IMConversationBottomSheet.kt:34)");
            }
            Painter icon = getIcon(action, $composer2, ($dirty2 >> 3) & 14);
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            final CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (icon != null) {
                $composer2.startReplaceGroup(-371330064);
                ComposerKt.sourceInformation($composer2, "42@1439L154,38@1300L304");
                String text = action.getText();
                Modifier modifier = Modifier.Companion;
                ComposerKt.sourceInformationMarkerStart($composer2, -843257780, "CC(remember):IMConversationBottomSheet.kt#9igjgp");
                boolean invalid$iv = (($dirty2 & 896) == 256 || (($dirty2 & 512) != 0 && $composer2.changedInstance(onAction))) | $composer2.changedInstance(action) | $composer2.changedInstance(scope) | (($dirty2 & 14) == 4);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: im.session.bottomsheet.IMConversationBottomSheetKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit IMConversationActionItem$lambda$0$0;
                            IMConversationActionItem$lambda$0$0 = IMConversationBottomSheetKt.IMConversationActionItem$lambda$0$0(IMSessionActionHandler.this, action, scope, $this$IMConversationActionItem);
                            return IMConversationActionItem$lambda$0$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposeBottomsheetKt.BottomSheetColumnItem(text, icon, ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), $composer2, Painter.$stable << 3, 0);
            } else {
                $composer2.startReplaceGroup(-372620656);
            }
            $composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.bottomsheet.IMConversationBottomSheetKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMConversationActionItem$lambda$1;
                    IMConversationActionItem$lambda$1 = IMConversationBottomSheetKt.IMConversationActionItem$lambda$1($this$IMConversationActionItem, action, onAction, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return IMConversationActionItem$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMConversationActionItem$lambda$0$0(IMSessionActionHandler $onAction, IMSessionCardOperation $action, CoroutineScope $scope, BottomSheetScope $this_IMConversationActionItem) {
        $onAction.invoke($action.getAction());
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new IMConversationBottomSheetKt$IMConversationActionItem$1$1$1($this_IMConversationActionItem, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    public static final Painter getIcon(IMSessionCardOperation $this$icon, Composer $composer, int $changed) {
        Painter arrow_to_top_up_line_500;
        Intrinsics.checkNotNullParameter($this$icon, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, 12285600, "C(<get-icon>):IMConversationBottomSheet.kt#dcxxbm");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(12285600, $changed, -1, "im.session.bottomsheet.<get-icon> (IMConversationBottomSheet.kt:56)");
        }
        switch (WhenMappings.$EnumSwitchMapping$0[$this$icon.getType().ordinal()]) {
            case 1:
                $composer.startReplaceGroup(-1078436744);
                ComposerKt.sourceInformation($composer, "57@1815L24");
                arrow_to_top_up_line_500 = BiliIconfont.INSTANCE.getArrow_to_top_up_line_500($composer, 6);
                $composer.endReplaceGroup();
                break;
            case 2:
                $composer.startReplaceGroup(-1078433991);
                ComposerKt.sourceInformation($composer, "58@1901L25");
                arrow_to_top_up_line_500 = BiliIconfont.INSTANCE.getArrow_to_top_off_line_500($composer, 6);
                $composer.endReplaceGroup();
                break;
            case 3:
                $composer.startReplaceGroup(-1078431179);
                ComposerKt.sourceInformation($composer, "59@1989L21");
                arrow_to_top_up_line_500 = BiliIconfont.INSTANCE.getTrash_delete_line_500($composer, 6);
                $composer.endReplaceGroup();
                break;
            case 4:
                $composer.startReplaceGroup(-1078428304);
                ComposerKt.sourceInformation($composer, "60@2079L16");
                arrow_to_top_up_line_500 = BiliIconfont.INSTANCE.getBrush_clear_line($composer, 6);
                $composer.endReplaceGroup();
                break;
            case 5:
                $composer.startReplaceGroup(-1078425728);
                ComposerKt.sourceInformation($composer, "61@2159L32");
                arrow_to_top_up_line_500 = BiliIconfont.INSTANCE.getEnvelope_historical_message_line($composer, 6);
                $composer.endReplaceGroup();
                break;
            default:
                $composer.startReplaceGroup(928592509);
                $composer.endReplaceGroup();
                arrow_to_top_up_line_500 = null;
                break;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return arrow_to_top_up_line_500;
    }
}