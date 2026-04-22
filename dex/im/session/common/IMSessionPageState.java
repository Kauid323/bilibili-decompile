package im.session.common;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import com.bapis.bilibili.app.im.v1.KAutoReplyToast;
import com.bapis.bilibili.app.im.v1.KSessionPageType;
import com.bilibili.lib.brouter.uri.Uri;
import im.session.IMActionDismissBehaviorAlert;
import im.session.IMActionRequestInitial;
import im.session.IMActionRetryRequestNext;
import im.session.IMState;
import im.session.bottomsheet.BottomSheetHolder;
import im.session.bottomsheet.PageMoreMenu;
import im.session.bottomsheet.SessionContextMenu;
import im.session.model.IMSessionAlert;
import im.session.model.IMSessionCard;
import im.session.model.IMThreeDotItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IMSessionPageState.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0006\u0010$\u001a\u00020%J\u0014\u0010&\u001a\u00020%2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(J\u0006\u0010/\u001a\u00020%J\u0006\u00102\u001a\u00020%J\u000e\u00103\u001a\u00020%H\u0086@¢\u0006\u0002\u00104J\u0006\u00105\u001a\u00020%J\u0006\u00106\u001a\u00020%J\u0006\u00107\u001a\u00020%J\u0016\u00108\u001a\u00020%2\u0006\u00109\u001a\u00020:H\u0086@¢\u0006\u0002\u0010;R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR/\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020,0+¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020,0+¢\u0006\b\n\u0000\u001a\u0004\b1\u0010.R\u000e\u0010<\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010=\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0011\u0010@\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\bA\u0010?R\u0014\u0010B\u001a\u00020CX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0014\u0010F\u001a\u00020CX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010ER\u001a\u0010H\u001a\u00020IX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u0011\u0010N\u001a\u00020O¢\u0006\b\n\u0000\u001a\u0004\bP\u0010Q¨\u0006R"}, d2 = {"Lim/session/common/IMSessionPageState;", "", "pageType", "Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "page", "Landroidx/compose/runtime/State;", "Lim/session/IMState;", "autoReplyBubble", "Lcom/bapis/bilibili/app/im/v1/KAutoReplyToast;", "alert", "Lim/session/model/IMSessionAlert;", "clickHandler", "Lim/session/common/IMSessionRouteHandler;", "actionHandler", "Lim/session/common/IMSessionActionHandler;", "<init>", "(Lcom/bapis/bilibili/app/im/v1/KSessionPageType;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;Lim/session/common/IMSessionRouteHandler;Lim/session/common/IMSessionActionHandler;)V", "getPageType", "()Lcom/bapis/bilibili/app/im/v1/KSessionPageType;", "getPage", "()Landroidx/compose/runtime/State;", "getAutoReplyBubble", "getAlert", "eventHandler", "Lim/session/common/IMSessionEventHandler;", "getEventHandler", "()Lim/session/common/IMSessionEventHandler;", "<set-?>", "Lim/session/bottomsheet/BottomSheetHolder;", "longClickedCard", "getLongClickedCard", "()Lim/session/bottomsheet/BottomSheetHolder;", "setLongClickedCard", "(Lim/session/bottomsheet/BottomSheetHolder;)V", "longClickedCard$delegate", "Landroidx/compose/runtime/MutableState;", "dismissBottomSheet", "", "showMoreActionMenu", "actions", "", "Lim/session/model/IMThreeDotItem;", "clearUnreadState", "Landroidx/compose/runtime/MutableState;", "", "getClearUnreadState", "()Landroidx/compose/runtime/MutableState;", "showClearUnreadDialog", "clearConversationState", "getClearConversationState", "showClearConversationDialog", "confirmAntiHarassmentDialog", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dismissAlert", "refresh", "refreshTail", "route", "url", "Lcom/bilibili/lib/brouter/uri/Uri;", "(Lcom/bilibili/lib/brouter/uri/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isHomePage", "showQuickLink", "getShowQuickLink", "()Z", "showFilter", "getShowFilter", "itemIndex", "Landroidx/compose/runtime/MutableIntState;", "getItemIndex$session_ui_debug", "()Landroidx/compose/runtime/MutableIntState;", "itemOffset", "getItemOffset$session_ui_debug", "lastPageSize", "", "getLastPageSize$session_ui_debug", "()I", "setLastPageSize$session_ui_debug", "(I)V", "columnState", "Landroidx/compose/foundation/lazy/LazyListState;", "getColumnState", "()Landroidx/compose/foundation/lazy/LazyListState;", "session-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IMSessionPageState {
    public static final int $stable = 0;
    private final State<IMSessionAlert> alert;
    private final State<KAutoReplyToast> autoReplyBubble;
    private final MutableState<Boolean> clearConversationState;
    private final MutableState<Boolean> clearUnreadState;
    private final LazyListState columnState;
    private final IMSessionEventHandler eventHandler;
    private final boolean isHomePage;
    private final MutableIntState itemIndex;
    private final MutableIntState itemOffset;
    private int lastPageSize;
    private final MutableState longClickedCard$delegate;
    private final State<IMState> page;
    private final KSessionPageType pageType;

    /* JADX WARN: Multi-variable type inference failed */
    public IMSessionPageState(KSessionPageType pageType, State<IMState> state, State<KAutoReplyToast> state2, State<? extends IMSessionAlert> state3, IMSessionRouteHandler clickHandler, IMSessionActionHandler actionHandler) {
        Intrinsics.checkNotNullParameter(pageType, "pageType");
        Intrinsics.checkNotNullParameter(state, "page");
        Intrinsics.checkNotNullParameter(state2, "autoReplyBubble");
        Intrinsics.checkNotNullParameter(state3, "alert");
        Intrinsics.checkNotNullParameter(clickHandler, "clickHandler");
        Intrinsics.checkNotNullParameter(actionHandler, "actionHandler");
        this.pageType = pageType;
        this.page = state;
        this.autoReplyBubble = state2;
        this.alert = state3;
        this.eventHandler = new IMSessionEventHandler(clickHandler, new IMSessionCardLongClickHandler() { // from class: im.session.common.IMSessionPageState$$ExternalSyntheticLambda0
            @Override // im.session.common.IMSessionCardLongClickHandler
            public final void invoke(IMSessionCard iMSessionCard) {
                IMSessionPageState.eventHandler$lambda$0(IMSessionPageState.this, iMSessionCard);
            }
        }, actionHandler);
        this.longClickedCard$delegate = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.clearUnreadState = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.clearConversationState = SnapshotStateKt.mutableStateOf$default(false, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.isHomePage = Intrinsics.areEqual(this.pageType, KSessionPageType.SESSION_PAGE_TYPE_HOME.INSTANCE);
        this.itemIndex = SnapshotIntStateKt.mutableIntStateOf(0);
        this.itemOffset = SnapshotIntStateKt.mutableIntStateOf(0);
        this.columnState = new LazyListState(this.itemIndex.getIntValue(), this.itemOffset.getIntValue());
    }

    public final KSessionPageType getPageType() {
        return this.pageType;
    }

    public final State<IMState> getPage() {
        return this.page;
    }

    public final State<KAutoReplyToast> getAutoReplyBubble() {
        return this.autoReplyBubble;
    }

    public final State<IMSessionAlert> getAlert() {
        return this.alert;
    }

    public final IMSessionEventHandler getEventHandler() {
        return this.eventHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void eventHandler$lambda$0(IMSessionPageState this$0, IMSessionCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (!card.getCardOperations().isEmpty()) {
            this$0.setLongClickedCard(new SessionContextMenu(card));
        }
    }

    public final BottomSheetHolder getLongClickedCard() {
        State $this$getValue$iv = this.longClickedCard$delegate;
        return (BottomSheetHolder) $this$getValue$iv.getValue();
    }

    public final void setLongClickedCard(BottomSheetHolder bottomSheetHolder) {
        MutableState $this$setValue$iv = this.longClickedCard$delegate;
        $this$setValue$iv.setValue(bottomSheetHolder);
    }

    public final void dismissBottomSheet() {
        setLongClickedCard(null);
    }

    public final void showMoreActionMenu(List<IMThreeDotItem> list) {
        Intrinsics.checkNotNullParameter(list, "actions");
        setLongClickedCard(new PageMoreMenu(list));
    }

    public final MutableState<Boolean> getClearUnreadState() {
        return this.clearUnreadState;
    }

    public final void showClearUnreadDialog() {
        this.clearUnreadState.setValue(true);
    }

    public final MutableState<Boolean> getClearConversationState() {
        return this.clearConversationState;
    }

    public final void showClearConversationDialog() {
        this.clearConversationState.setValue(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object confirmAntiHarassmentDialog(Continuation<? super Unit> continuation) {
        IMSessionPageState$confirmAntiHarassmentDialog$1 iMSessionPageState$confirmAntiHarassmentDialog$1;
        if (continuation instanceof IMSessionPageState$confirmAntiHarassmentDialog$1) {
            iMSessionPageState$confirmAntiHarassmentDialog$1 = (IMSessionPageState$confirmAntiHarassmentDialog$1) continuation;
            if ((iMSessionPageState$confirmAntiHarassmentDialog$1.label & Integer.MIN_VALUE) != 0) {
                iMSessionPageState$confirmAntiHarassmentDialog$1.label -= Integer.MIN_VALUE;
                Object $result = iMSessionPageState$confirmAntiHarassmentDialog$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMSessionPageState$confirmAntiHarassmentDialog$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        IMSessionRouteHandler routeHandler = this.eventHandler.getRouteHandler();
                        iMSessionPageState$confirmAntiHarassmentDialog$1.label = 1;
                        if (IMSessionPageStateKt.invoke(routeHandler, "bilibili://im/setting/anti_harassment", iMSessionPageState$confirmAntiHarassmentDialog$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                this.eventHandler.getActionHandler().invoke(IMActionDismissBehaviorAlert.INSTANCE);
                return Unit.INSTANCE;
            }
        }
        iMSessionPageState$confirmAntiHarassmentDialog$1 = new IMSessionPageState$confirmAntiHarassmentDialog$1(this, continuation);
        Object $result2 = iMSessionPageState$confirmAntiHarassmentDialog$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMSessionPageState$confirmAntiHarassmentDialog$1.label) {
        }
        this.eventHandler.getActionHandler().invoke(IMActionDismissBehaviorAlert.INSTANCE);
        return Unit.INSTANCE;
    }

    public final void dismissAlert() {
        this.eventHandler.getActionHandler().invoke(IMActionDismissBehaviorAlert.INSTANCE);
    }

    public final void refresh() {
        this.eventHandler.getActionHandler().invoke(IMActionRequestInitial.INSTANCE);
    }

    public final void refreshTail() {
        this.eventHandler.getActionHandler().invoke(IMActionRetryRequestNext.INSTANCE);
    }

    public final Object route(Uri url, Continuation<? super Unit> continuation) {
        Object invoke = this.eventHandler.getRouteHandler().invoke(url, continuation);
        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }

    public final boolean getShowQuickLink() {
        return this.isHomePage;
    }

    public final boolean getShowFilter() {
        return this.isHomePage;
    }

    public final MutableIntState getItemIndex$session_ui_debug() {
        return this.itemIndex;
    }

    public final MutableIntState getItemOffset$session_ui_debug() {
        return this.itemOffset;
    }

    public final int getLastPageSize$session_ui_debug() {
        return this.lastPageSize;
    }

    public final void setLastPageSize$session_ui_debug(int i2) {
        this.lastPageSize = i2;
    }

    public final LazyListState getColumnState() {
        return this.columnState;
    }
}