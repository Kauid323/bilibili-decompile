package im.session.common;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import com.bilibili.compose.common.swipe.SwipeActionContentScope;
import com.bilibili.compose.common.swipe.SwipeActionItem;
import com.bilibili.compose.common.swipe.SwipeActionKt;
import com.bilibili.compose.common.swipe.SwipeActionSideState;
import com.bilibili.compose.common.swipe.SwipeActionSideStateKt;
import com.bilibili.compose.common.swipe.SwipeActionState;
import com.bilibili.compose.common.swipe.SwipeCancellingToken;
import com.bilibili.compose.common.swipe.TouchSlopConfiguration;
import com.bilibili.compose.theme.BiliColorsSourceKt;
import com.tencent.smtt.sdk.TbsListener;
import com.yalantis.ucrop.view.CropImageView;
import im.session.model.IMSessionCard;
import im.session.model.IMSessionCardOperation;
import im.session.model.IMSessionCardOperationType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: IMConversationSwipe.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b\u001a\u001d\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u000b\u001a\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r*\b\u0012\u0004\u0012\u00020\u000f0\rH\u0003\"\u001e\u0010\u0010\u001a\u00020\u0011*\u00020\u00128BX\u0083\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"IMConversationSwipe", "", "conversation", "Lim/session/model/IMSessionCard;", "swipeCancellingToken", "Lcom/bilibili/compose/common/swipe/SwipeCancellingToken;", "eventHandler", "Lim/session/common/IMSessionEventHandler;", "(Lim/session/model/IMSessionCard;Lcom/bilibili/compose/common/swipe/SwipeCancellingToken;Lim/session/common/IMSessionEventHandler;Landroidx/compose/runtime/Composer;I)V", "rememberConversationSwipeContent", "Lcom/bilibili/compose/common/swipe/SwipeActionSideState;", "(Lim/session/model/IMSessionCard;Lim/session/common/IMSessionEventHandler;Landroidx/compose/runtime/Composer;I)Lcom/bilibili/compose/common/swipe/SwipeActionSideState;", "mapToSwipeAction", "", "Lcom/bilibili/compose/common/swipe/SwipeActionItem;", "Lim/session/model/IMSessionCardOperation;", "bgColor", "Landroidx/compose/ui/graphics/Color;", "Lim/session/model/IMSessionCardOperationType;", "getBgColor$annotations", "(Lim/session/model/IMSessionCardOperationType;)V", "getBgColor", "(Lim/session/model/IMSessionCardOperationType;)J", "session-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMConversationSwipeKt {

    /* compiled from: IMConversationSwipe.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IMSessionCardOperationType.values().length];
            try {
                iArr[IMSessionCardOperationType.DELETE.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[IMSessionCardOperationType.UNBLOCK.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMConversationSwipe$lambda$1(IMSessionCard iMSessionCard, SwipeCancellingToken swipeCancellingToken, IMSessionEventHandler iMSessionEventHandler, int i2, Composer composer, int i3) {
        IMConversationSwipe(iMSessionCard, swipeCancellingToken, iMSessionEventHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    private static /* synthetic */ void getBgColor$annotations(IMSessionCardOperationType iMSessionCardOperationType) {
    }

    public static final void IMConversationSwipe(final IMSessionCard conversation, final SwipeCancellingToken swipeCancellingToken, final IMSessionEventHandler eventHandler, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(conversation, "conversation");
        Intrinsics.checkNotNullParameter(swipeCancellingToken, "swipeCancellingToken");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        Composer $composer2 = $composer.startRestartGroup(-1318515746);
        ComposerKt.sourceInformation($composer2, "C(IMConversationSwipe)N(conversation,swipeCancellingToken,eventHandler)37@1247L24,38@1294L60,39@1376L49,44@1597L434,40@1430L601:IMConversationSwipe.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(conversation) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changedInstance(swipeCancellingToken) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(eventHandler) ? 256 : 128;
        }
        int $dirty2 = $dirty;
        if ($composer2.shouldExecute(($dirty2 & 147) != 146, $dirty2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1318515746, $dirty2, -1, "im.session.common.IMConversationSwipe (IMConversationSwipe.kt:36)");
            }
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
            SwipeActionSideState tailContent = rememberConversationSwipeContent(conversation, eventHandler, $composer2, ($dirty2 & 14) | (($dirty2 >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            SwipeActionState swipeState = SwipeActionSideStateKt.rememberSwipeActionState((SwipeActionSideState) null, tailContent, $composer2, 0, 1);
            SwipeActionKt.SwipeContent(swipeState, (Modifier) null, swipeCancellingToken, !conversation.getCardOperations().isEmpty(), (TouchSlopConfiguration) null, ComposableLambdaKt.rememberComposableLambda(80934845, true, new Function4() { // from class: im.session.common.IMConversationSwipeKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    Unit IMConversationSwipe$lambda$0;
                    IMConversationSwipe$lambda$0 = IMConversationSwipeKt.IMConversationSwipe$lambda$0(IMSessionCard.this, eventHandler, scope, (SwipeActionContentScope) obj, (SwipeCancellingToken) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    return IMConversationSwipe$lambda$0;
                }
            }, $composer2, 54), $composer2, (($dirty2 << 3) & 896) | 196608, 18);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.IMConversationSwipeKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMConversationSwipe$lambda$1;
                    IMConversationSwipe$lambda$1 = IMConversationSwipeKt.IMConversationSwipe$lambda$1(IMSessionCard.this, swipeCancellingToken, eventHandler, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return IMConversationSwipe$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMConversationSwipe$lambda$0(final IMSessionCard $conversation, final IMSessionEventHandler $eventHandler, final CoroutineScope $scope, SwipeActionContentScope $this$SwipeContent, SwipeCancellingToken it, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$SwipeContent, "$this$SwipeContent");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation($composer, "CN(it)49@1770L244,45@1607L418:IMConversationSwipe.kt#yqxgzx");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(80934845, $changed, -1, "im.session.common.IMConversationSwipe.<anonymous> (IMConversationSwipe.kt:45)");
        }
        Modifier modifier = Modifier.Companion;
        ComposerKt.sourceInformationMarkerStart($composer, 468980497, "CC(remember):IMConversationSwipe.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance($scope) | $composer.changed($eventHandler) | $composer.changed($conversation);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function0() { // from class: im.session.common.IMConversationSwipeKt$$ExternalSyntheticLambda3
                public final Object invoke() {
                    Unit IMConversationSwipe$lambda$0$0$0;
                    IMConversationSwipe$lambda$0$0$0 = IMConversationSwipeKt.IMConversationSwipe$lambda$0$0$0($scope, $eventHandler, $conversation);
                    return IMConversationSwipe$lambda$0$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        IMConversationKt.IMConversationContent($conversation, $eventHandler, ClickableKt.clickable-oSLSa3U$default(modifier, false, (String) null, (Role) null, (MutableInteractionSource) null, (Function0) it$iv, 15, (Object) null), $composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMConversationSwipe$lambda$0$0$0(CoroutineScope $scope, IMSessionEventHandler $eventHandler, IMSessionCard $conversation) {
        BuildersKt.launch$default($scope, (CoroutineContext) null, (CoroutineStart) null, new IMConversationSwipeKt$IMConversationSwipe$1$1$1$1($eventHandler, $conversation, null), 3, (Object) null);
        return Unit.INSTANCE;
    }

    private static final SwipeActionSideState rememberConversationSwipeContent(IMSessionCard conversation, final IMSessionEventHandler eventHandler, Composer $composer, int $changed) {
        ComposerKt.sourceInformationMarkerStart($composer, -1724699479, "C(rememberConversationSwipeContent)N(conversation,eventHandler)70@2457L218,65@2280L395:IMConversationSwipe.kt#yqxgzx");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1724699479, $changed, -1, "im.session.common.rememberConversationSwipeContent (IMConversationSwipe.kt:63)");
        }
        final List actions = conversation.getCardOperations();
        List<SwipeActionItem> mapToSwipeAction = mapToSwipeAction(actions);
        float f2 = Dp.constructor-impl(74);
        ComposerKt.sourceInformationMarkerStart($composer, 421190019, "CC(remember):IMConversationSwipe.kt#9igjgp");
        boolean invalid$iv = $composer.changedInstance(actions) | (((($changed & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW) ^ 48) > 32 && $composer.changed(eventHandler)) || ($changed & 48) == 32);
        Object it$iv = $composer.rememberedValue();
        if (invalid$iv || it$iv == Composer.Companion.getEmpty()) {
            Object value$iv = new Function1() { // from class: im.session.common.IMConversationSwipeKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit rememberConversationSwipeContent$lambda$0$0;
                    rememberConversationSwipeContent$lambda$0$0 = IMConversationSwipeKt.rememberConversationSwipeContent$lambda$0$0(actions, eventHandler, (SwipeActionItem) obj);
                    return rememberConversationSwipeContent$lambda$0$0;
                }
            };
            $composer.updateRememberedValue(value$iv);
            it$iv = value$iv;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        SwipeActionSideState swipeActionSideState = SwipeActionSideStateKt.rememberSideSwipeActionState-1yyLQnY(conversation, mapToSwipeAction, f2, (float) CropImageView.DEFAULT_ASPECT_RATIO, false, (Function1) it$iv, $composer, ($changed & 14) | 24960, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return swipeActionSideState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit rememberConversationSwipeContent$lambda$0$0(List $actions, IMSessionEventHandler $eventHandler, SwipeActionItem swipeAction) {
        Object element$iv;
        boolean z;
        Intrinsics.checkNotNullParameter(swipeAction, "swipeAction");
        List $this$firstOrNull$iv = $actions;
        Iterator it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                IMSessionCardOperation it2 = (IMSessionCardOperation) element$iv;
                if (it2.getType().ordinal() == swipeAction.getId()) {
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
        IMSessionCardOperation action = (IMSessionCardOperation) element$iv;
        if (action != null) {
            $eventHandler.getActionHandler().invoke(action.getAction());
            return Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }

    private static final List<SwipeActionItem> mapToSwipeAction(List<IMSessionCardOperation> list) {
        Iterable $this$map$iv = CollectionsKt.reversed(list);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            IMSessionCardOperation it = (IMSessionCardOperation) item$iv$iv;
            destination$iv$iv.add(new SwipeActionItem(it.getType().ordinal(), it.getText(), getBgColor(it.getType()), Color.Companion.getWhite-0d7_KjU(), (DefaultConstructorMarker) null));
            $this$map$iv = $this$map$iv;
        }
        return (List) destination$iv$iv;
    }

    private static final long getBgColor(IMSessionCardOperationType $this$bgColor) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$bgColor.ordinal()]) {
            case 1:
                return ColorKt.Color(4294713637L);
            case 2:
                return BiliColorsSourceKt.getDayColors().getYe5-0d7_KjU();
            default:
                return ColorKt.Color(4290493377L);
        }
    }
}