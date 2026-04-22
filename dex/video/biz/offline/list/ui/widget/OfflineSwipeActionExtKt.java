package video.biz.offline.list.ui.widget;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import bili.resource.playerbaseres.PlayerbaseresRes;
import bili.resource.playerbaseres.String0_commonMainKt;
import bili.resource.playerbaseres.String2_commonMainKt;
import com.bilibili.compose.common.swipe.SwipeActionItem;
import com.bilibili.compose.common.swipe.SwipeActionSideState;
import com.bilibili.compose.common.swipe.SwipeActionSideStateKt;
import com.bilibili.compose.common.swipe.SwipeCancellingToken;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.list.logic.model.OfflinePageOperation;

/* compiled from: OfflineSwipeActionExt.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005\u001aC\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a\u001d\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\f*\b\u0012\u0004\u0012\u00020\r0\fH\u0003¢\u0006\u0002\u0010\u0013\"\u001e\u0010\u0014\u001a\u00020\u0015*\u00020\r8CX\u0083\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u001e\u0010\u001a\u001a\u00020\u001b*\u00020\r8BX\u0083\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"cancelOnEditMode", "", "Lcom/bilibili/compose/common/swipe/SwipeCancellingToken;", "isEdit", "", "(Lcom/bilibili/compose/common/swipe/SwipeCancellingToken;ZLandroidx/compose/runtime/Composer;I)V", "rememberListSwipeContent", "Lcom/bilibili/compose/common/swipe/SwipeActionSideState;", "key", "", "swipeCancellingToken", "supportOperations", "", "Lvideo/biz/offline/list/logic/model/OfflinePageOperation;", "operationHandler", "Lkotlin/Function1;", "(Ljava/lang/Object;Lcom/bilibili/compose/common/swipe/SwipeCancellingToken;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Lcom/bilibili/compose/common/swipe/SwipeActionSideState;", "mapToSwipeAction", "Lcom/bilibili/compose/common/swipe/SwipeActionItem;", "(Ljava/util/List;Landroidx/compose/runtime/Composer;I)Ljava/util/List;", "content", "", "getContent$annotations", "(Lvideo/biz/offline/list/logic/model/OfflinePageOperation;Landroidx/compose/runtime/Composer;I)V", "getContent", "(Lvideo/biz/offline/list/logic/model/OfflinePageOperation;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "bgColor", "Landroidx/compose/ui/graphics/Color;", "getBgColor$annotations", "(Lvideo/biz/offline/list/logic/model/OfflinePageOperation;)V", "getBgColor", "(Lvideo/biz/offline/list/logic/model/OfflinePageOperation;)J", "ui_debug"}, k = 2, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineSwipeActionExtKt {

    /* compiled from: OfflineSwipeActionExt.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OfflinePageOperation.values().length];
            try {
                iArr[OfflinePageOperation.DELETE_TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[OfflinePageOperation.DANMAKU_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit cancelOnEditMode$lambda$1(SwipeCancellingToken swipeCancellingToken, boolean z, int i, Composer composer, int i2) {
        cancelOnEditMode(swipeCancellingToken, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static /* synthetic */ void getBgColor$annotations(OfflinePageOperation offlinePageOperation) {
    }

    private static /* synthetic */ void getContent$annotations(OfflinePageOperation offlinePageOperation, Composer composer, int i) {
    }

    public static final void cancelOnEditMode(final SwipeCancellingToken $this$cancelOnEditMode, final boolean isEdit, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter($this$cancelOnEditMode, "<this>");
        Composer $composer2 = $composer.startRestartGroup(-169182490);
        ComposerKt.sourceInformation($composer2, "C(cancelOnEditMode)N(isEdit)22@924L24:OfflineSwipeActionExt.kt#uys4uf");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance($this$cancelOnEditMode) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(isEdit) ? 32 : 16;
        }
        if ($composer2.shouldExecute(($dirty & 19) != 18, $dirty & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-169182490, $dirty, -1, "video.biz.offline.list.ui.widget.cancelOnEditMode (OfflineSwipeActionExt.kt:21)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart($composer2, 683736516, "CC(remember):Effects.kt#9igjgp");
            Object it$iv$iv = $composer2.rememberedValue();
            if (it$iv$iv == Composer.Companion.getEmpty()) {
                Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer2);
                $composer2.updateRememberedValue(value$iv$iv);
                it$iv$iv = value$iv$iv;
            }
            CoroutineScope scope = (CoroutineScope) it$iv$iv;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            if (isEdit) {
                $composer2.startReplaceGroup(-2118802340);
                ComposerKt.sourceInformation($composer2, "24@988L35");
                ComposerKt.sourceInformationMarkerStart($composer2, 624388905, "CC(remember):OfflineSwipeActionExt.kt#9igjgp");
                boolean invalid$iv = $composer2.changedInstance($this$cancelOnEditMode);
                Object it$iv = $composer2.rememberedValue();
                if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
                    Object value$iv = (Function2) new OfflineSwipeActionExtKt$cancelOnEditMode$1$1($this$cancelOnEditMode, null);
                    $composer2.updateRememberedValue(value$iv);
                    it$iv = value$iv;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                BuildersKt.launch$default(scope, (CoroutineContext) null, (CoroutineStart) null, (Function2) it$iv, 3, (Object) null);
            } else {
                $composer2.startReplaceGroup(-2119762596);
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
            endRestartGroup.updateScope(new Function2() { // from class: video.biz.offline.list.ui.widget.OfflineSwipeActionExtKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit cancelOnEditMode$lambda$1;
                    cancelOnEditMode$lambda$1 = OfflineSwipeActionExtKt.cancelOnEditMode$lambda$1($this$cancelOnEditMode, isEdit, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return cancelOnEditMode$lambda$1;
                }
            });
        }
    }

    public static final SwipeActionSideState rememberListSwipeContent(Object key, final SwipeCancellingToken swipeCancellingToken, final List<? extends OfflinePageOperation> list, Function1<? super OfflinePageOperation, Unit> function1, Composer $composer, int $changed, int i) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(swipeCancellingToken, "swipeCancellingToken");
        Intrinsics.checkNotNullParameter(list, "supportOperations");
        ComposerKt.sourceInformationMarkerStart($composer, -519996607, "C(rememberListSwipeContent)N(key,swipeCancellingToken,supportOperations,operationHandler)37@1294L24,40@1418L18,43@1508L292,38@1330L470:OfflineSwipeActionExt.kt#uys4uf");
        final Function1 operationHandler = (i & 8) != 0 ? null : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-519996607, $changed, -1, "video.biz.offline.list.ui.widget.rememberListSwipeContent (OfflineSwipeActionExt.kt:36)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart($composer, 683736516, "CC(remember):Effects.kt#9igjgp");
        Object it$iv$iv = $composer.rememberedValue();
        if (it$iv$iv == Composer.Companion.getEmpty()) {
            Object value$iv$iv = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer);
            $composer.updateRememberedValue(value$iv$iv);
            it$iv$iv = value$iv$iv;
        }
        final CoroutineScope scope = (CoroutineScope) it$iv$iv;
        ComposerKt.sourceInformationMarkerEnd($composer);
        ComposerKt.sourceInformationMarkerEnd($composer);
        List<SwipeActionItem> mapToSwipeAction = mapToSwipeAction(list, $composer, ($changed >> 6) & 14);
        float f = Dp.constructor-impl(74);
        ComposerKt.sourceInformationMarkerStart($composer, -1500517883, "CC(remember):OfflineSwipeActionExt.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance(list) | (((($changed & 7168) ^ 3072) > 2048 && $composer.changed(operationHandler)) || ($changed & 3072) == 2048) | $composer.changedInstance(scope) | $composer.changedInstance(swipeCancellingToken);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function1() { // from class: video.biz.offline.list.ui.widget.OfflineSwipeActionExtKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit rememberListSwipeContent$lambda$0$0;
                    rememberListSwipeContent$lambda$0$0 = OfflineSwipeActionExtKt.rememberListSwipeContent$lambda$0$0(list, operationHandler, scope, swipeCancellingToken, (SwipeActionItem) obj);
                    return rememberListSwipeContent$lambda$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        SwipeActionSideState swipeActionSideState = SwipeActionSideStateKt.rememberSideSwipeActionState-1yyLQnY(key, mapToSwipeAction, f, (float) DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN, false, (Function1) it$iv, $composer, ($changed & 14) | 24960, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return swipeActionSideState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberListSwipeContent$lambda$0$0(List $supportOperations, Function1 $operationHandler, CoroutineScope $scope, SwipeCancellingToken $swipeCancellingToken, SwipeActionItem swipeAction) {
        Object element$iv;
        boolean z;
        Intrinsics.checkNotNullParameter(swipeAction, "swipeAction");
        List $this$firstOrNull$iv = $supportOperations;
        Iterator it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                OfflinePageOperation it2 = (OfflinePageOperation) element$iv;
                if (it2.ordinal() == swipeAction.getId()) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        OfflinePageOperation action = (OfflinePageOperation) element$iv;
        if (action == null) {
            return Unit.INSTANCE;
        }
        if ($operationHandler != null) {
            $operationHandler.invoke(action);
        }
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new OfflineSwipeActionExtKt$rememberListSwipeContent$1$1$1($swipeCancellingToken, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    private static final List<SwipeActionItem> mapToSwipeAction(List<? extends OfflinePageOperation> list, Composer $composer, int $changed) {
        Composer composer = $composer;
        ComposerKt.sourceInformationMarkerStart(composer, 683553538, "C(mapToSwipeAction):OfflineSwipeActionExt.kt#uys4uf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(683553538, $changed, -1, "video.biz.offline.list.ui.widget.mapToSwipeAction (OfflineSwipeActionExt.kt:57)");
        }
        composer.startReplaceGroup(-235043039);
        ComposerKt.sourceInformation(composer, "*60@2012L7");
        Iterable $this$map$iv = CollectionsKt.reversed(list);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            OfflinePageOperation it = (OfflinePageOperation) item$iv$iv;
            destination$iv$iv.add(new SwipeActionItem(it.ordinal(), getContent(it, composer, 0), getBgColor(it), Color.Companion.getWhite-0d7_KjU(), (DefaultConstructorMarker) null));
            composer = $composer;
        }
        ArrayList arrayList = (List) destination$iv$iv;
        $composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return arrayList;
    }

    private static final String getContent(OfflinePageOperation $this$content, Composer $composer, int $changed) {
        String string;
        ComposerKt.sourceInformationMarkerStart($composer, -1115747830, "C(<get-content>):OfflineSwipeActionExt.kt#uys4uf");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1115747830, $changed, -1, "video.biz.offline.list.ui.widget.<get-content> (OfflineSwipeActionExt.kt:69)");
        }
        switch (WhenMappings.$EnumSwitchMapping$0[$this$content.ordinal()]) {
            case 1:
                string = PlayerbaseresRes.INSTANCE.getString(String0_commonMainKt.getPlayerbaseres_global_string_1369(PlayerbaseresRes.INSTANCE.getString()));
                break;
            case 2:
                string = PlayerbaseresRes.INSTANCE.getString(String2_commonMainKt.getPlayerbaseres_global_string_2182(PlayerbaseresRes.INSTANCE.getString()));
                break;
            default:
                string = "";
                break;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return string;
    }

    private static final long getBgColor(OfflinePageOperation $this$bgColor) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$bgColor.ordinal()]) {
            case 1:
                return ColorKt.Color(4294713637L);
            case 2:
                return ColorKt.Color(4283396095L);
            default:
                return ColorKt.Color(4290493377L);
        }
    }
}