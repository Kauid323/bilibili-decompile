package im.session.track;

import com.bapis.bilibili.app.im.v1.KMsgSummary;
import com.bapis.bilibili.app.im.v1.KQuickLinkBubble;
import com.bapis.bilibili.app.im.v1.KUnread;
import com.bapis.bilibili.app.im.v1.KUnreadStyle;
import com.freeletics.flowredux.dsl.BaseBuilderBlock;
import com.freeletics.flowredux.dsl.ExecutionPolicy;
import com.freeletics.flowredux.dsl.FlowReduxStoreBuilder;
import com.freeletics.flowredux.dsl.InStateBuilderBlock;
import com.tencent.tauth.AuthActivity;
import im.session.IMAction;
import im.session.IMActionAlertShow;
import im.session.IMActionClickQuickLinkItem;
import im.session.IMActionClickThreeDotItem;
import im.session.IMActionExposureQuickLinkItem;
import im.session.IMActionExposureSessionCard;
import im.session.IMActionExposureThreeDotItem;
import im.session.IMState;
import im.session.model.IMQuickLinkItem;
import im.session.model.IMSessionAlert;
import im.session.model.IMSessionBehaviorAlert;
import im.session.model.IMSessionCard;
import im.session.model.IMThreeDotItem;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kntr.base.neuron.KNeuron;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: Tracker.kt */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u0010\u0010\b\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\tH\u0002\u001a\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u000bH\u0002\u001a\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\rH\u0002\u001a\u0018\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0003H\u0002\u001a \u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0017H\u0002\u001a\u0010\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001aH\u0002\u001a\u0010\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\u001a\u0010\u0010\u001e\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001dH\u0002\u001a\u0018\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150 *\u00020!H\u0002\u001a\u0018\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150 *\u00020\"H\u0002\u001a \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150#*\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0003H\u0002\u001a\u0018\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150 *\u00020\u001dH\u0002\u001a\u001e\u0010$\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130'H\u0002¨\u0006("}, d2 = {"bindTracker", "", "Lcom/freeletics/flowredux/dsl/FlowReduxStoreBuilder;", "Lim/session/IMState;", "Lim/session/IMAction;", "handleThreeDotItemExposure", AuthActivity.ACTION_KEY, "Lim/session/IMActionExposureThreeDotItem;", "handleThreeDotItemClicked", "Lim/session/IMActionClickThreeDotItem;", "handleQuickLinkExposure", "Lim/session/IMActionExposureQuickLinkItem;", "handleQuickLinkClicked", "Lim/session/IMActionClickQuickLinkItem;", "handleSessionExposure", "Lim/session/IMActionExposureSessionCard;", "state", "handleSessionClicked", "card", "Lim/session/model/IMSessionCard;", "paramAction", "", "handleAlertShow", "Lim/session/IMActionAlertShow;", "handleAlertDismissClick", "alert", "Lim/session/model/IMSessionAlert;", "handleQuickLinkBubbleClose", "bubble", "Lcom/bapis/bilibili/app/im/v1/KQuickLinkBubble;", "handleQuickLinkBubbleExposure", "trackExtraParam", "", "Lim/session/model/IMThreeDotItem;", "Lim/session/model/IMQuickLinkItem;", "", "findPositionInSortedSessionList", "", "allSessions", "", "session_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TrackerKt {
    public static final void bindTracker(FlowReduxStoreBuilder<IMState, IMAction> flowReduxStoreBuilder) {
        Intrinsics.checkNotNullParameter(flowReduxStoreBuilder, "<this>");
        Function1 block$iv = new Function1() { // from class: im.session.track.TrackerKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit bindTracker$lambda$0;
                bindTracker$lambda$0 = TrackerKt.bindTracker$lambda$0((InStateBuilderBlock) obj);
                return bindTracker$lambda$0;
            }
        };
        flowReduxStoreBuilder.inState(Reflection.getOrCreateKotlinClass(IMState.class), block$iv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit bindTracker$lambda$0(InStateBuilderBlock $this$inState) {
        Intrinsics.checkNotNullParameter($this$inState, "$this$inState");
        BaseBuilderBlock $this$iv = (BaseBuilderBlock) $this$inState;
        Function3 handler$iv = new TrackerKt$bindTracker$1$1(null);
        ExecutionPolicy executionPolicy$iv = ExecutionPolicy.CANCEL_PREVIOUS;
        $this$iv.onActionEffect(Reflection.getOrCreateKotlinClass(IMAction.class), executionPolicy$iv, handler$iv);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleThreeDotItemExposure(IMActionExposureThreeDotItem action) {
        KNeuron.INSTANCE.reportExposure(false, "im.notify-message.top-entry-list.entry.show", trackExtraParam(action.getItem()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleThreeDotItemClicked(IMActionClickThreeDotItem action) {
        KNeuron.INSTANCE.reportClick(false, "im.notify-message.top-entry-list.entry.click", trackExtraParam(action.getItem()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleQuickLinkExposure(IMActionExposureQuickLinkItem action) {
        KNeuron.INSTANCE.reportExposure(false, "im.notify-message.head-entry-list.entry.show", trackExtraParam(action.getItem()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleQuickLinkClicked(IMActionClickQuickLinkItem action) {
        KNeuron.INSTANCE.reportClick(false, "im.notify-message.head-entry-list.entry.click", trackExtraParam(action.getItem()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleSessionExposure(IMActionExposureSessionCard action, IMState state) {
        KNeuron.INSTANCE.reportExposure(false, "im.my-message.chat-feed.chat-card.show", trackExtraParam(action.getCard(), state));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleSessionClicked(IMSessionCard card, String paramAction, IMState state) {
        Map extra = trackExtraParam(card, state);
        extra.put(AuthActivity.ACTION_KEY, paramAction);
        KNeuron.INSTANCE.reportClick(false, "im.my-message.chat-feed.chat-card.click", extra);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleAlertShow(IMActionAlertShow action) {
        if (action.getAlert() instanceof IMSessionBehaviorAlert) {
            KNeuron.INSTANCE.reportExposure(false, "im.chat-single.msg-alertdialog.0.show", MapsKt.mapOf(TuplesKt.to("alert_type", ((IMSessionBehaviorAlert) action.getAlert()).getContent().getTypeStr())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleAlertDismissClick(IMSessionAlert alert) {
        if (alert instanceof IMSessionBehaviorAlert) {
            KNeuron.INSTANCE.reportClick(false, "im.chat-single.msg-alertdialog.0.click", MapsKt.mapOf(TuplesKt.to("alert_type", ((IMSessionBehaviorAlert) alert).getContent().getTypeStr())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleQuickLinkBubbleClose(KQuickLinkBubble bubble) {
        KNeuron.INSTANCE.reportClick(false, "im.my-message.msg-bubble.close.click", trackExtraParam(bubble));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleQuickLinkBubbleExposure(KQuickLinkBubble bubble) {
        KNeuron.INSTANCE.reportExposure(false, "im.my-message.msg-bubble.0.show", trackExtraParam(bubble));
    }

    private static final Map<String, String> trackExtraParam(IMThreeDotItem $this$trackExtraParam) {
        return MapsKt.mapOf(TuplesKt.to("entry_name", $this$trackExtraParam.getType().getName()));
    }

    private static final Map<String, String> trackExtraParam(IMQuickLinkItem $this$trackExtraParam) {
        Pair[] pairArr = new Pair[2];
        KUnread unread = $this$trackExtraParam.getUnread();
        pairArr[0] = TuplesKt.to("message_new_cnt", (unread == null || (r1 = unread.getNumberShow()) == null) ? "" : "");
        pairArr[1] = TuplesKt.to("entry_name", $this$trackExtraParam.getType().getName());
        return MapsKt.mapOf(pairArr);
    }

    private static final Map<String, String> trackExtraParam(IMSessionCard $this$trackExtraParam, IMState state) {
        Map extra = MapsKt.toMutableMap($this$trackExtraParam.getTraceParams());
        KUnreadStyle style = $this$trackExtraParam.getUnread().getStyle();
        if (style instanceof KUnreadStyle.UNREAD_STYLE_NUMBER) {
            extra.put("message_new_type", $this$trackExtraParam.getUnread().getNumberShow());
        } else if (style instanceof KUnreadStyle.UNREAD_STYLE_DOT) {
            extra.put("message_new_type", "redpoint");
        }
        KMsgSummary msgSummary$session_debug = $this$trackExtraParam.getMsgSummary$session_debug();
        String rawMsg = msgSummary$session_debug != null ? msgSummary$session_debug.getRawMsg() : null;
        if (rawMsg == null) {
            rawMsg = "";
        }
        extra.put("msg_key", rawMsg);
        List sessionList = state.getData().getSessions();
        int position = findPositionInSortedSessionList($this$trackExtraParam, sessionList);
        extra.put("index", String.valueOf(position));
        return extra;
    }

    private static final Map<String, String> trackExtraParam(KQuickLinkBubble $this$trackExtraParam) {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("entry_name", $this$trackExtraParam.getQuickLinkItem().getName()), TuplesKt.to("sender_uid", String.valueOf($this$trackExtraParam.getMid())), TuplesKt.to("sub_type", $this$trackExtraParam.getMsgType().getName())});
    }

    private static final int findPositionInSortedSessionList(final IMSessionCard card, List<IMSessionCard> list) {
        int pinnedEndIndex;
        List searchList;
        int index$iv = 0;
        Iterator<IMSessionCard> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                Object item$iv = it.next();
                IMSessionCard it2 = (IMSessionCard) item$iv;
                if (!it2.isPinned()) {
                    break;
                }
                index$iv++;
            } else {
                index$iv = -1;
                break;
            }
        }
        int firstNonPinnedIndex = index$iv;
        if (firstNonPinnedIndex == -1) {
            pinnedEndIndex = list.size();
        } else {
            pinnedEndIndex = firstNonPinnedIndex;
        }
        boolean isInPinnedGroup = card.isPinned();
        if (isInPinnedGroup) {
            searchList = list.subList(0, pinnedEndIndex);
        } else {
            searchList = list.subList(pinnedEndIndex, list.size());
        }
        int indexInGroup = CollectionsKt.binarySearch$default(searchList, 0, 0, new Function1() { // from class: im.session.track.TrackerKt$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                int findPositionInSortedSessionList$lambda$1;
                findPositionInSortedSessionList$lambda$1 = TrackerKt.findPositionInSortedSessionList$lambda$1(IMSessionCard.this, (IMSessionCard) obj);
                return Integer.valueOf(findPositionInSortedSessionList$lambda$1);
            }
        }, 3, (Object) null);
        if (indexInGroup >= 0) {
            return (isInPinnedGroup ? 0 : pinnedEndIndex) + indexInGroup + 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int findPositionInSortedSessionList$lambda$1(IMSessionCard $card, IMSessionCard it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Intrinsics.compare($card.getSequenceNumber$session_debug(), it.getSequenceNumber$session_debug());
    }
}