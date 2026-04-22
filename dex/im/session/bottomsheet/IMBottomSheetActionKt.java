package im.session.bottomsheet;

import com.bapis.bilibili.app.im.v1.KThreeDotItemType;
import com.bilibili.lib.brouter.uri.Uri;
import im.session.IMActionClickThreeDotItem;
import im.session.common.IMSessionPageState;
import im.session.log.LogTagKt;
import im.session.model.IMThreeDotItem;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMBottomSheetAction.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0080@¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"onBottomSheetAction", "", "Lim/session/model/IMThreeDotItem;", "pageState", "Lim/session/common/IMSessionPageState;", "(Lim/session/model/IMThreeDotItem;Lim/session/common/IMSessionPageState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "session-ui_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMBottomSheetActionKt {
    public static final Object onBottomSheetAction(IMThreeDotItem $this$onBottomSheetAction, IMSessionPageState pageState, Continuation<? super Unit> continuation) {
        pageState.getEventHandler().getActionHandler().invoke(new IMActionClickThreeDotItem($this$onBottomSheetAction));
        KThreeDotItemType type = $this$onBottomSheetAction.getType();
        if (Intrinsics.areEqual(type, KThreeDotItemType.THREE_DOT_ITEM_TYPE_READ_ALL.INSTANCE)) {
            pageState.showClearUnreadDialog();
        } else if (Intrinsics.areEqual(type, KThreeDotItemType.THREE_DOT_ITEM_TYPE_CLEAR_LIST.INSTANCE)) {
            pageState.showClearConversationDialog();
        } else if (Intrinsics.areEqual(type, KThreeDotItemType.THREE_DOT_ITEM_TYPE_UNKNOWN.INSTANCE) || (type instanceof KThreeDotItemType.UNRECOGNIZED)) {
            KLog_androidKt.getKLog().w(LogTagKt.SessionLogTag, "Unrecognized three dot item type: " + $this$onBottomSheetAction);
        } else {
            Object invoke = pageState.getEventHandler().getRouteHandler().invoke(Uri.Companion.parse($this$onBottomSheetAction.getUrl()), continuation);
            return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
        }
        return Unit.INSTANCE;
    }
}