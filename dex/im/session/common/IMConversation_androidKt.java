package im.session.common;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import com.bilibili.compose.common.swipe.SwipeCancellingToken;
import com.tencent.smtt.sdk.TbsListener;
import im.session.model.IMSessionCard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMConversation.android.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0001¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"IMConversation", "", "conversation", "Lim/session/model/IMSessionCard;", "swipeCancellingToken", "Lcom/bilibili/compose/common/swipe/SwipeCancellingToken;", "eventHandler", "Lim/session/common/IMSessionEventHandler;", "(Lim/session/model/IMSessionCard;Lcom/bilibili/compose/common/swipe/SwipeCancellingToken;Lim/session/common/IMSessionEventHandler;Landroidx/compose/runtime/Composer;I)V", "session-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMConversation_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IMConversation$lambda$0(IMSessionCard iMSessionCard, SwipeCancellingToken swipeCancellingToken, IMSessionEventHandler iMSessionEventHandler, int i2, Composer composer, int i3) {
        IMConversation(iMSessionCard, swipeCancellingToken, iMSessionEventHandler, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    public static final void IMConversation(final IMSessionCard conversation, final SwipeCancellingToken swipeCancellingToken, final IMSessionEventHandler eventHandler, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(conversation, "conversation");
        Intrinsics.checkNotNullParameter(swipeCancellingToken, "swipeCancellingToken");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        Composer $composer2 = $composer.startRestartGroup(-1054166075);
        ComposerKt.sourceInformation($composer2, "C(IMConversation)N(conversation,swipeCancellingToken,eventHandler)16@403L51:IMConversation.android.kt#yqxgzx");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(conversation) ? 4 : 2;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(eventHandler) ? 256 : 128;
        }
        if (!$composer2.shouldExecute(($dirty & 131) != 130, $dirty & 1)) {
            $composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1054166075, $dirty, -1, "im.session.common.IMConversation (IMConversation.android.kt:15)");
            }
            IMConversationKt.IMConversationLongClick(conversation, eventHandler, $composer2, ($dirty & 14) | (($dirty >> 3) & TbsListener.ErrorCode.DOWNLOAD_OVER_FLOW));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: im.session.common.IMConversation_androidKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2) {
                    Unit IMConversation$lambda$0;
                    IMConversation$lambda$0 = IMConversation_androidKt.IMConversation$lambda$0(IMSessionCard.this, swipeCancellingToken, eventHandler, $changed, (Composer) obj, ((Integer) obj2).intValue());
                    return IMConversation$lambda$0;
                }
            });
        }
    }
}