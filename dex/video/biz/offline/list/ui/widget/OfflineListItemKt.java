package video.biz.offline.list.ui.widget;

import ComposableSingletons$CustomBottomSheetKt$;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
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
import com.bilibili.compose.common.swipe.SwipeActionContentScope;
import com.bilibili.compose.common.swipe.SwipeActionKt;
import com.bilibili.compose.common.swipe.SwipeActionSideState;
import com.bilibili.compose.common.swipe.SwipeActionSideStateKt;
import com.bilibili.compose.common.swipe.SwipeActionState;
import com.bilibili.compose.common.swipe.SwipeCancellingToken;
import com.bilibili.compose.common.swipe.TouchSlopConfiguration;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;
import video.biz.offline.list.logic.model.OfflinePageOperation;

/* compiled from: OfflineListItem.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aJ\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\bH\u0001¢\u0006\u0002\u0010\t\u001ax\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00152\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\b\bH\u0001¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"OfflineListItemLongClick", "", "modifier", "Landroidx/compose/ui/Modifier;", "onclick", "Lkotlin/Function0;", "onLongClick", "content", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "OfflineListItemSwipe", "key", "", "swipeCancellingToken", "Lcom/bilibili/compose/common/swipe/SwipeCancellingToken;", "supportOperations", "", "Lvideo/biz/offline/list/logic/model/OfflinePageOperation;", "isEdit", "", "operationHandler", "Lkotlin/Function1;", "(Ljava/lang/Object;Lcom/bilibili/compose/common/swipe/SwipeCancellingToken;Ljava/util/List;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineListItemKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineListItemLongClick$lambda$3(Modifier modifier, Function0 function0, Function0 function02, Function2 function2, int i, int i2, Composer composer, int i3) {
        OfflineListItemLongClick(modifier, function0, function02, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineListItemSwipe$lambda$2(Object obj, SwipeCancellingToken swipeCancellingToken, List list, boolean z, Modifier modifier, Function0 function0, Function1 function1, Function2 function2, int i, int i2, Composer composer, int i3) {
        OfflineListItemSwipe(obj, swipeCancellingToken, list, z, modifier, function0, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r6v13 */
    public static final void OfflineListItemLongClick(Modifier modifier, Function0<Unit> function0, Function0<Unit> function02, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 function03;
        Function0 onLongClick;
        Modifier modifier3;
        Function0 onclick;
        Modifier modifier4;
        Function0 onclick2;
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(-1287562241);
        ComposerKt.sourceInformation($composer2, "C(OfflineListItemLongClick)N(modifier,onclick,onLongClick,content)30@1106L2,31@1140L2,34@1189L188:OfflineListItem.kt#uys4uf");
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
            function03 = function0;
        } else if (($changed & 48) == 0) {
            function03 = function0;
            $dirty |= $composer2.changedInstance(function03) ? 32 : 16;
        } else {
            function03 = function0;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty |= 384;
            onLongClick = function02;
        } else if (($changed & 384) == 0) {
            onLongClick = function02;
            $dirty |= $composer2.changedInstance(onLongClick) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        } else {
            onLongClick = function02;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        }
        int $dirty2 = $dirty;
        if (!$composer2.shouldExecute(($dirty2 & 1171) != 1170, $dirty2 & 1)) {
            $composer2.skipToGroupEnd();
            modifier3 = modifier2;
            onclick = function03;
        } else {
            if (i2 != 0) {
                modifier4 = (Modifier) Modifier.Companion;
            } else {
                modifier4 = modifier2;
            }
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -396729439, "CC(remember):OfflineListItem.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineListItemKt$$ExternalSyntheticLambda4
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                onclick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onclick2 = function03;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, -396728351, "CC(remember):OfflineListItem.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineListItemKt$$ExternalSyntheticLambda5
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv2);
                    it$iv2 = value$iv2;
                }
                Function0 onLongClick2 = it$iv2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onLongClick = onLongClick2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1287562241, $dirty2, -1, "video.biz.offline.list.ui.widget.OfflineListItemLongClick (OfflineListItem.kt:33)");
            }
            Modifier modifier$iv = ClickableKt.combinedClickable-hoGz1lA$default(modifier4, false, (String) null, (Role) null, (String) null, onLongClick, (Function0) null, false, (MutableInteractionSource) null, onclick2, 239, (Object) null);
            ComposerKt.sourceInformationMarkerStart($composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
            MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
            int $changed$iv$iv = (0 << 3) & 112;
            modifier3 = modifier4;
            onclick = onclick2;
            ComposerKt.sourceInformationMarkerStart($composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int compositeKeyHash$iv$iv = ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(ComposablesKt.getCurrentCompositeKeyHashCode($composer2, 0));
            CompositionLocalMap localMap$iv$iv = $composer2.getCurrentCompositionLocalMap();
            Modifier materialized$iv$iv = ComposedModifierKt.materializeModifier($composer2, modifier$iv);
            Function0 factory$iv$iv$iv2 = ComposeUiNode.Companion.getConstructor();
            int $changed$iv$iv$iv = (($changed$iv$iv << 6) & 896) | 6;
            Function0 onLongClick3 = onLongClick;
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
            int i5 = ($changed$iv$iv$iv >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i6 = ((0 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer2, 539723061, "C41@1362L9:OfflineListItem.kt#uys4uf");
            function2.invoke($composer2, Integer.valueOf(($dirty2 >> 9) & 14));
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            $composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onLongClick = onLongClick3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function0 function04 = onclick;
            final Function0 function05 = onLongClick;
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.OfflineListItemKt$$ExternalSyntheticLambda6
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineListItemLongClick$lambda$3;
                    OfflineListItemLongClick$lambda$3 = OfflineListItemKt.OfflineListItemLongClick$lambda$3(modifier5, function04, function05, function2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineListItemLongClick$lambda$3;
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10 */
    public static final void OfflineListItemSwipe(final Object key, final SwipeCancellingToken swipeCancellingToken, final List<? extends OfflinePageOperation> list, final boolean isEdit, Modifier modifier, Function0<Unit> function0, Function1<? super OfflinePageOperation, Unit> function1, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Function0 function02;
        Function1 operationHandler;
        Modifier modifier3;
        Function0 onclick;
        final Function0 onclick2;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(swipeCancellingToken, "swipeCancellingToken");
        Intrinsics.checkNotNullParameter(list, "supportOperations");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(-1169527897);
        ComposerKt.sourceInformation($composer2, "C(OfflineListItemSwipe)N(key,swipeCancellingToken,supportOperations,isEdit,modifier,onclick,operationHandler,content)52@1623L2,57@1762L215,63@1999L49,68@2221L121,64@2053L289:OfflineListItem.kt#uys4uf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(key) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(swipeCancellingToken) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(list) ? IjkMediaPlayer.FFP_BUFFERING_END_REASON_UNKNOWN : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer2.changed(isEdit) ? IjkMediaMeta.FF_PROFILE_H264_INTRA : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID : 8192;
        } else {
            modifier2 = modifier;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty |= 196608;
            function02 = function0;
        } else if (($changed & 196608) == 0) {
            function02 = function0;
            $dirty |= $composer2.changedInstance(function02) ? 131072 : 65536;
        } else {
            function02 = function0;
        }
        int i4 = i & 64;
        if (i4 != 0) {
            $dirty |= 1572864;
        } else if ((1572864 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 1048576 : 524288;
        }
        if (($changed & 12582912) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 8388608 : 4194304;
        }
        if ($composer2.shouldExecute(($dirty & 4793491) != 4793490, $dirty & 1)) {
            final Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 1365129609, "CC(remember):OfflineListItem.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineListItemKt$$ExternalSyntheticLambda1
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onclick3 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onclick2 = onclick3;
            } else {
                onclick2 = function02;
            }
            operationHandler = i4 != 0 ? null : function1;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1169527897, $dirty, -1, "video.biz.offline.list.ui.widget.OfflineListItemSwipe (OfflineListItem.kt:55)");
            }
            int $dirty2 = $dirty;
            SwipeActionSideState tailContent = OfflineSwipeActionExtKt.rememberListSwipeContent(key, swipeCancellingToken, list, operationHandler, $composer2, ($dirty & 14) | ($dirty & 112) | ($dirty & 896) | (($dirty >> 9) & 7168), 0);
            SwipeActionState swipeState = SwipeActionSideStateKt.rememberSwipeActionState((SwipeActionSideState) null, tailContent, $composer2, 0, 1);
            modifier3 = modifier4;
            onclick = onclick2;
            SwipeActionKt.SwipeContent(swipeState, (Modifier) null, swipeCancellingToken, (list.isEmpty() || isEdit) ? false : true, (TouchSlopConfiguration) null, ComposableLambdaKt.rememberComposableLambda(2132676806, true, new Function4() { // from class: video.biz.offline.list.ui.widget.OfflineListItemKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit OfflineListItemSwipe$lambda$1;
                    OfflineListItemSwipe$lambda$1 = OfflineListItemKt.OfflineListItemSwipe$lambda$1(modifier4, onclick2, function2, (SwipeActionContentScope) obj, (SwipeCancellingToken) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return OfflineListItemSwipe$lambda$1;
                }
            }, $composer2, 54), $composer2, (($dirty2 << 3) & 896) | 196608, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
            operationHandler = function1;
            modifier3 = modifier2;
            onclick = function02;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            final Function0 function03 = onclick;
            final Function1 function12 = operationHandler;
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.OfflineListItemKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineListItemSwipe$lambda$2;
                    OfflineListItemSwipe$lambda$2 = OfflineListItemKt.OfflineListItemSwipe$lambda$2(key, swipeCancellingToken, list, isEdit, modifier5, function03, function12, function2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineListItemSwipe$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineListItemSwipe$lambda$1(Modifier $modifier, final Function0 $onclick, Function2 $content, SwipeActionContentScope $this$SwipeContent, SwipeCancellingToken it, Composer $composer, int $changed) {
        Function0 factory$iv$iv$iv;
        Intrinsics.checkNotNullParameter($this$SwipeContent, "$this$SwipeContent");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)70@2278L13,69@2231L105:OfflineListItem.kt#uys4uf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2132676806, $changed, -1, "video.biz.offline.list.ui.widget.OfflineListItemSwipe.<anonymous> (OfflineListItem.kt:69)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 803012211, "CC(remember):OfflineListItem.kt#9igjgp");
        boolean invalid$iv = $composer.changed($onclick);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineListItemKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit OfflineListItemSwipe$lambda$1$0$0;
                    OfflineListItemSwipe$lambda$1$0$0 = OfflineListItemKt.OfflineListItemSwipe$lambda$1$0$0($onclick);
                    return OfflineListItemSwipe$lambda$1$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier modifier$iv = ClickableKt.clickable-oSLSa3U$default($modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null);
        ComposerKt.sourceInformationMarkerStart($composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        Alignment contentAlignment$iv = Alignment.Companion.getTopStart();
        MeasurePolicy measurePolicy$iv = BoxKt.maybeCachedBoxMeasurePolicy(contentAlignment$iv, false);
        int $changed$iv$iv = (0 << 3) & 112;
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
        ComposerKt.sourceInformationMarkerStart($composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
        BoxScope boxScope = BoxScopeInstance.INSTANCE;
        int i2 = ((0 >> 6) & 112) | 6;
        ComposerKt.sourceInformationMarkerStart($composer, 1991713678, "C72@2317L9:OfflineListItem.kt#uys4uf");
        $content.invoke($composer, 0);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        $composer.endNode();
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineListItemSwipe$lambda$1$0$0(Function0 $onclick) {
        $onclick.invoke();
        return Unit.INSTANCE;
    }
}