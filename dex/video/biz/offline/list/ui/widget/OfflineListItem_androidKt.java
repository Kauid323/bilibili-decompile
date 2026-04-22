package video.biz.offline.list.ui.widget;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import com.bilibili.compose.common.swipe.SwipeCancellingToken;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.videoplayer.core.media.ijk.IjkFnHelper;
import video.biz.offline.list.logic.model.OfflinePageOperation;

/* compiled from: OfflineListItem.android.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0086\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000e2\u0014\b\u0002\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00112\u0011\u0010\u0012\u001a\r\u0012\u0004\u0012\u00020\u00010\u000e¢\u0006\u0002\b\u0013H\u0001¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"OfflineListItem", "", "key", "", "swipeCancellingToken", "Lcom/bilibili/compose/common/swipe/SwipeCancellingToken;", "supportOperations", "", "Lvideo/biz/offline/list/logic/model/OfflinePageOperation;", "isEdit", "", "modifier", "Landroidx/compose/ui/Modifier;", "onclick", "Lkotlin/Function0;", "onLongClick", "operationHandler", "Lkotlin/Function1;", "content", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lcom/bilibili/compose/common/swipe/SwipeCancellingToken;Ljava/util/List;ZLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineListItem_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineListItem$lambda$4(Object obj, SwipeCancellingToken swipeCancellingToken, List list, boolean z, Modifier modifier, Function0 function0, Function0 function02, Function1 function1, Function2 function2, int i, int i2, Composer composer, int i3) {
        OfflineListItem(obj, swipeCancellingToken, list, z, modifier, function0, function02, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r5v9 */
    public static final void OfflineListItem(final Object key, final SwipeCancellingToken swipeCancellingToken, final List<? extends OfflinePageOperation> list, final boolean isEdit, Modifier modifier, Function0<Unit> function0, Function0<Unit> function02, Function1<? super OfflinePageOperation, Unit> function1, final Function2<? super Composer, ? super Integer, Unit> function2, Composer $composer, final int $changed, final int i) {
        Function0 function03;
        Function0 function04;
        Modifier modifier2;
        Function1 operationHandler;
        Function0 onclick;
        Function0 onLongClick;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(swipeCancellingToken, "swipeCancellingToken");
        Intrinsics.checkNotNullParameter(list, "supportOperations");
        Intrinsics.checkNotNullParameter(function2, "content");
        Composer $composer2 = $composer.startRestartGroup(-915977248);
        ComposerKt.sourceInformation($composer2, "C(OfflineListItem)N(key,swipeCancellingToken,supportOperations,isEdit,modifier,onclick,onLongClick,operationHandler,content)27@816L2,27@850L2,27@909L2,23@730L25,19@607L148:OfflineListItem.android.kt#uys4uf");
        int $dirty = $changed;
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
        } else if (($changed & 24576) == 0) {
            $dirty |= $composer2.changed(modifier) ? IjkFnHelper.PLAY_URL_FLAG_HDR_VIVID : 8192;
        }
        int i3 = i & 32;
        if (i3 != 0) {
            $dirty |= 196608;
            function03 = function0;
        } else if ((196608 & $changed) == 0) {
            function03 = function0;
            $dirty |= $composer2.changedInstance(function03) ? 131072 : 65536;
        } else {
            function03 = function0;
        }
        int i4 = i & 64;
        if (i4 != 0) {
            $dirty |= 1572864;
            function04 = function02;
        } else if ((1572864 & $changed) == 0) {
            function04 = function02;
            $dirty |= $composer2.changedInstance(function04) ? 1048576 : 524288;
        } else {
            function04 = function02;
        }
        if ((100663296 & $changed) == 0) {
            $dirty |= $composer2.changedInstance(function2) ? 67108864 : 33554432;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute((34152449 & $dirty2) != 34152448, $dirty2 & 1)) {
            Modifier modifier3 = i2 != 0 ? (Modifier) Modifier.Companion : modifier;
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 214177666, "CC(remember):OfflineListItem.android.kt#9igjgp");
                Object it$iv = $composer2.rememberedValue();
                if (it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineListItem_androidKt$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            Unit unit;
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                Function0 onclick2 = it$iv;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                onclick = onclick2;
            } else {
                onclick = function03;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 214178754, "CC(remember):OfflineListItem.android.kt#9igjgp");
                Object it$iv2 = $composer2.rememberedValue();
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    Object value$iv2 = new Function0() { // from class: video.biz.offline.list.ui.widget.OfflineListItem_androidKt$$ExternalSyntheticLambda1
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
            } else {
                onLongClick = function04;
            }
            if ((i & 128) != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 214180642, "CC(remember):OfflineListItem.android.kt#9igjgp");
                Object it$iv3 = $composer2.rememberedValue();
                if (it$iv3 == Composer.Companion.getEmpty()) {
                    Object value$iv3 = new Function1() { // from class: video.biz.offline.list.ui.widget.OfflineListItem_androidKt$$ExternalSyntheticLambda2
                        public final Object invoke(Object obj) {
                            Unit OfflineListItem$lambda$2$0;
                            OfflineListItem$lambda$2$0 = OfflineListItem_androidKt.OfflineListItem$lambda$2$0((OfflinePageOperation) obj);
                            return OfflineListItem$lambda$2$0;
                        }
                    };
                    $composer2.updateRememberedValue(value$iv3);
                    it$iv3 = value$iv3;
                }
                Function1 operationHandler2 = it$iv3;
                ComposerKt.sourceInformationMarkerEnd($composer2);
                operationHandler = operationHandler2;
            } else {
                operationHandler = function1;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-915977248, $dirty2, -1, "video.biz.offline.list.ui.widget.OfflineListItem (OfflineListItem.android.kt:18)");
            }
            OfflineListItemKt.OfflineListItemLongClick(modifier3, onclick, onLongClick, ComposableLambdaKt.rememberComposableLambda(-2076640360, true, new Function2() { // from class: video.biz.offline.list.ui.widget.OfflineListItem_androidKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineListItem$lambda$3;
                    OfflineListItem$lambda$3 = OfflineListItem_androidKt.OfflineListItem$lambda$3(function2, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineListItem$lambda$3;
                }
            }, $composer2, 54), $composer2, (($dirty2 >> 12) & 14) | 3072 | (($dirty2 >> 12) & 112) | (($dirty2 >> 12) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            $composer2.skipToGroupEnd();
            modifier2 = modifier;
            operationHandler = function1;
            onclick = function03;
            onLongClick = function04;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            final Function0 function05 = onclick;
            final Function0 function06 = onLongClick;
            final Function1 function12 = operationHandler;
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.OfflineListItem_androidKt$$ExternalSyntheticLambda4
                public final Object invoke(Object obj, Object obj2) {
                    Unit OfflineListItem$lambda$4;
                    OfflineListItem$lambda$4 = OfflineListItem_androidKt.OfflineListItem$lambda$4(key, swipeCancellingToken, list, isEdit, modifier4, function05, function06, function12, function2, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                    return OfflineListItem$lambda$4;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineListItem$lambda$3(Function2 $content, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C24@740L9:OfflineListItem.android.kt#uys4uf");
        if (!$composer.shouldExecute(($changed & 3) != 2, $changed & 1)) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2076640360, $changed, -1, "video.biz.offline.list.ui.widget.OfflineListItem.<anonymous> (OfflineListItem.android.kt:24)");
            }
            $content.invoke($composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflineListItem$lambda$2$0(OfflinePageOperation it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }
}