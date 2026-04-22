package kntr.app.im.chat.ui.utils;

import ComposableSingletons$CustomBottomSheetKt$;
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
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import kntr.common.bilitheme.compose.bottomsheet.BottomSheetScope;
import kntr.common.bilitheme.compose.bottomsheet.ComposeBottomsheetKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChatPageController.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"rememberCommonPageController", "Lkntr/app/im/chat/ui/utils/ChatPageController;", "(Landroidx/compose/runtime/Composer;I)Lkntr/app/im/chat/ui/utils/ChatPageController;", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ChatPageControllerKt {
    public static final ChatPageController rememberCommonPageController(Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -996005808, "C(rememberCommonPageController)25@675L97,30@807L270:ChatPageController.kt#we9gw3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-996005808, $changed, -1, "kntr.app.im.chat.ui.utils.rememberCommonPageController (ChatPageController.kt:23)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 616128625, "CC(remember):ChatPageController.kt#9igjgp");
        Object it$iv = $composer.rememberedValue();
        if (it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        final MutableState bottomSheetContent = (MutableState) it$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerStart($composer, 616133022, "CC(remember):ChatPageController.kt#9igjgp");
        Object it$iv2 = $composer.rememberedValue();
        if (it$iv2 == Composer.Companion.getEmpty()) {
            Object value$iv2 = new ChatPageController() { // from class: kntr.app.im.chat.ui.utils.ChatPageControllerKt$rememberCommonPageController$pageController$1$1
                @Override // kntr.app.im.chat.ui.utils.ChatPageController
                public void showBottomSheet(Function3<? super BottomSheetScope, ? super Composer, ? super Integer, Unit> function3) {
                    Intrinsics.checkNotNullParameter(function3, "bottomSheetBuilder");
                    bottomSheetContent.setValue(function3);
                }
            };
            $composer.updateRememberedValue(value$iv2);
            it$iv2 = value$iv2;
        }
        ChatPageControllerKt$rememberCommonPageController$pageController$1$1 pageController = (ChatPageControllerKt$rememberCommonPageController$pageController$1$1) it$iv2;
        ComposerKt.sourceInformationMarkerEnd($composer);
        final Function3 bottomSheet = (Function3) bottomSheetContent.getValue();
        if (bottomSheet != null) {
            $composer.startReplaceGroup(1920596833);
            ComposerKt.sourceInformation($composer, "41@1217L63,40@1165L161");
            ComposerKt.sourceInformationMarkerStart($composer, 616145935, "CC(remember):ChatPageController.kt#9igjgp");
            Object it$iv3 = $composer.rememberedValue();
            if (it$iv3 == Composer.Companion.getEmpty()) {
                Object value$iv3 = new Function0() { // from class: kntr.app.im.chat.ui.utils.ChatPageControllerKt$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Unit rememberCommonPageController$lambda$2$0;
                        rememberCommonPageController$lambda$2$0 = ChatPageControllerKt.rememberCommonPageController$lambda$2$0(bottomSheetContent);
                        return rememberCommonPageController$lambda$2$0;
                    }
                };
                $composer.updateRememberedValue(value$iv3);
                it$iv3 = value$iv3;
            }
            Function0 onDismiss$iv = (Function0) it$iv3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, -1330546869, "CC(BottomSheetColumnContainer)N(onDismiss,modifier,content)154@5815L207,154@5771L251:ComposeBottomsheet.kt#18ljev");
            final Modifier modifier$iv = Modifier.Companion;
            ComposeBottomsheetKt.BottomSheetContainer-lVb_Clg(onDismiss$iv, (Function0) null, 0L, false, false, false, (PaddingValues) null, ComposableLambdaKt.rememberComposableLambda(1454232538, true, new Function3<BottomSheetScope, Composer, Integer, Unit>() { // from class: kntr.app.im.chat.ui.utils.ChatPageControllerKt$rememberCommonPageController$$inlined$BottomSheetColumnContainer$1
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                    invoke((BottomSheetScope) p1, (Composer) p2, ((Number) p3).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BottomSheetScope $this$BottomSheetContainer, Composer $composer2, int $changed2) {
                    Function0 factory$iv$iv$iv;
                    Intrinsics.checkNotNullParameter($this$BottomSheetContainer, "$this$BottomSheetContainer");
                    ComposerKt.sourceInformation($composer2, "C155@5825L191:ComposeBottomsheet.kt#18ljev");
                    int $dirty = $changed2;
                    if (($changed2 & 6) == 0) {
                        $dirty |= $composer2.changed($this$BottomSheetContainer) ? 4 : 2;
                    }
                    if (!$composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
                        $composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1454232538, $dirty, -1, "kntr.common.bilitheme.compose.bottomsheet.BottomSheetColumnContainer.<anonymous> (ComposeBottomsheet.kt:155)");
                    }
                    Modifier modifier$iv2 = ClipKt.clip(SizeKt.fillMaxWidth$default(modifier$iv, 0.0f, 1, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
                    Function3 function3 = bottomSheet;
                    ComposerKt.sourceInformationMarkerStart($composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    Arrangement.Vertical verticalArrangement$iv = Arrangement.INSTANCE.getTop();
                    Alignment.Horizontal horizontalAlignment$iv = Alignment.Companion.getStart();
                    MeasurePolicy measurePolicy$iv = ColumnKt.columnMeasurePolicy(verticalArrangement$iv, horizontalAlignment$iv, $composer2, ((0 >> 3) & 14) | ((0 >> 3) & 112));
                    int $changed$iv$iv = (0 << 3) & 112;
                    ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
                    CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
                    Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv2);
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
                    ComposerKt.sourceInformationMarkerStart($composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
                    int i2 = ((0 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer2, 639823158, "C160@5994L9:ComposeBottomsheet.kt#18ljev");
                    function3.invoke($this$BottomSheetContainer, $composer2, Integer.valueOf($dirty & 14));
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, $composer, 54), $composer, (6 & 14) | 12582912, 126);
            ComposerKt.sourceInformationMarkerEnd($composer);
        } else {
            $composer.startReplaceGroup(1919444594);
        }
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return pageController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberCommonPageController$lambda$2$0(MutableState $bottomSheetContent) {
        $bottomSheetContent.setValue((Object) null);
        return Unit.INSTANCE;
    }
}