package im.direct.notification.interactive;

import com.bapis.bilibili.im.gateway.interfaces.v1.KCommonMsgCard;
import com.bapis.bilibili.im.gateway.interfaces.v1.KCursor;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgFeedFilter;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgItem;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgListLimit;
import com.bapis.bilibili.im.gateway.interfaces.v1.KMsgListRsp;
import com.bilibili.blens.Lens;
import com.bilibili.blens.dsl.CopyScope;
import com.bilibili.blens.dsl.CopyScopeKt;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import io.grpc.internal.AbstractStream;
import io.grpc.internal.GrpcUtil;
import io.ktor.client.utils.CIOKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: INState.kt */
@Lens
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 O2\u00020\u0001:\u0001OBU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*H\u0000¢\u0006\u0002\b+J\u0015\u0010,\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*H\u0000¢\u0006\u0002\b-J\u0015\u0010.\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*H\u0000¢\u0006\u0002\b/J$\u00100\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u00101\u001a\u00020\u0010H\u0002J\u0015\u00102\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0006H\u0000¢\u0006\u0002\b4J\u001d\u00105\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u00062\u0006\u00106\u001a\u000207H\u0000¢\u0006\u0002\b8J\u0015\u00109\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0006H\u0000¢\u0006\u0002\b:J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u0014\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÀ\u0003¢\u0006\u0002\b=J\u0010\u0010>\u001a\u0004\u0018\u00010\bHÀ\u0003¢\u0006\u0002\b?J\u000f\u0010@\u001a\b\u0012\u0004\u0012\u00020\n0\u0005HÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\fHÀ\u0003¢\u0006\u0002\bBJ\u0010\u0010C\u001a\u0004\u0018\u00010\u000eHÀ\u0003¢\u0006\u0002\bDJ\u0012\u0010E\u001a\u0004\u0018\u00010\u0010HÀ\u0003¢\u0006\u0004\bF\u0010\"Jh\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001¢\u0006\u0002\u0010HJ\u0013\u0010I\u001a\u0002072\b\u0010J\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010K\u001a\u00020LHÖ\u0001J\t\u0010M\u001a\u00020NHÖ\u0001R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0018R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u0004¢\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R \u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0014\u001a\u0004\b'\u0010\u0018¨\u0006P"}, d2 = {"Lim/direct/notification/interactive/INState;", "", "pageStatus", "Lim/direct/notification/interactive/INPageStatus;", "messageCards", "", "Lim/direct/notification/interactive/INMessageCard;", "limit", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgListLimit;", "filters", "Lim/direct/notification/interactive/INFilter;", "toast", "Lim/direct/notification/interactive/ToastMessage;", "cursor", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KCursor;", "requestID", "", "<init>", "(Lim/direct/notification/interactive/INPageStatus;Ljava/util/List;Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgListLimit;Ljava/util/List;Lim/direct/notification/interactive/ToastMessage;Lcom/bapis/bilibili/im/gateway/interfaces/v1/KCursor;Ljava/lang/Long;)V", "getPageStatus$annotations", "()V", "getPageStatus", "()Lim/direct/notification/interactive/INPageStatus;", "getMessageCards$interactive_debug", "()Ljava/util/List;", "getLimit$interactive_debug", "()Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgListLimit;", "getFilters$annotations", "getFilters", "getToast$interactive_debug", "()Lim/direct/notification/interactive/ToastMessage;", "getCursor$interactive_debug", "()Lcom/bapis/bilibili/im/gateway/interfaces/v1/KCursor;", "getRequestID$interactive_debug", "()Ljava/lang/Long;", "Ljava/lang/Long;", "cards", "Lim/direct/notification/interactive/INCard;", "getCards$annotations", "getCards", "refresh", "response", "Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgListRsp;", "refresh$interactive_debug", "refreshTab", "refreshTab$interactive_debug", "append", "append$interactive_debug", "modifyCards", "lastViewAt", "delete", "card", "delete$interactive_debug", "mute", "isMuted", "", "mute$interactive_debug", "requestFail", "requestFail$interactive_debug", "component1", "component2", "component2$interactive_debug", "component3", "component3$interactive_debug", "component4", "component5", "component5$interactive_debug", "component6", "component6$interactive_debug", "component7", "component7$interactive_debug", "copy", "(Lim/direct/notification/interactive/INPageStatus;Ljava/util/List;Lcom/bapis/bilibili/im/gateway/interfaces/v1/KMsgListLimit;Ljava/util/List;Lim/direct/notification/interactive/ToastMessage;Lcom/bapis/bilibili/im/gateway/interfaces/v1/KCursor;Ljava/lang/Long;)Lim/direct/notification/interactive/INState;", "equals", "other", "hashCode", "", "toString", "", "Companion", "interactive_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class INState {
    public static final Companion Companion = new Companion(null);
    private final KCursor cursor;
    private final List<INFilter> filters;
    private final KMsgListLimit limit;
    private final List<INMessageCard> messageCards;
    private final INPageStatus pageStatus;
    private final Long requestID;
    private final ToastMessage toast;

    public static /* synthetic */ INState copy$default(INState iNState, INPageStatus iNPageStatus, List list, KMsgListLimit kMsgListLimit, List list2, ToastMessage toastMessage, KCursor kCursor, Long l, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            iNPageStatus = iNState.pageStatus;
        }
        List<INMessageCard> list3 = list;
        if ((i2 & 2) != 0) {
            list3 = iNState.messageCards;
        }
        List list4 = list3;
        if ((i2 & 4) != 0) {
            kMsgListLimit = iNState.limit;
        }
        KMsgListLimit kMsgListLimit2 = kMsgListLimit;
        List<INFilter> list5 = list2;
        if ((i2 & 8) != 0) {
            list5 = iNState.filters;
        }
        List list6 = list5;
        if ((i2 & 16) != 0) {
            toastMessage = iNState.toast;
        }
        ToastMessage toastMessage2 = toastMessage;
        if ((i2 & 32) != 0) {
            kCursor = iNState.cursor;
        }
        KCursor kCursor2 = kCursor;
        if ((i2 & 64) != 0) {
            l = iNState.requestID;
        }
        return iNState.copy(iNPageStatus, list4, kMsgListLimit2, list6, toastMessage2, kCursor2, l);
    }

    public static /* synthetic */ void getCards$annotations() {
    }

    public static /* synthetic */ void getFilters$annotations() {
    }

    public static /* synthetic */ void getPageStatus$annotations() {
    }

    public final INPageStatus component1() {
        return this.pageStatus;
    }

    public final List<INMessageCard> component2$interactive_debug() {
        return this.messageCards;
    }

    public final KMsgListLimit component3$interactive_debug() {
        return this.limit;
    }

    public final List<INFilter> component4() {
        return this.filters;
    }

    public final ToastMessage component5$interactive_debug() {
        return this.toast;
    }

    public final KCursor component6$interactive_debug() {
        return this.cursor;
    }

    public final Long component7$interactive_debug() {
        return this.requestID;
    }

    public final INState copy(INPageStatus iNPageStatus, List<INMessageCard> list, KMsgListLimit kMsgListLimit, List<INFilter> list2, ToastMessage toastMessage, KCursor kCursor, Long l) {
        Intrinsics.checkNotNullParameter(iNPageStatus, "pageStatus");
        Intrinsics.checkNotNullParameter(list, "messageCards");
        Intrinsics.checkNotNullParameter(list2, "filters");
        return new INState(iNPageStatus, list, kMsgListLimit, list2, toastMessage, kCursor, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof INState) {
            INState iNState = (INState) obj;
            return Intrinsics.areEqual(this.pageStatus, iNState.pageStatus) && Intrinsics.areEqual(this.messageCards, iNState.messageCards) && Intrinsics.areEqual(this.limit, iNState.limit) && Intrinsics.areEqual(this.filters, iNState.filters) && Intrinsics.areEqual(this.toast, iNState.toast) && Intrinsics.areEqual(this.cursor, iNState.cursor) && Intrinsics.areEqual(this.requestID, iNState.requestID);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((this.pageStatus.hashCode() * 31) + this.messageCards.hashCode()) * 31) + (this.limit == null ? 0 : this.limit.hashCode())) * 31) + this.filters.hashCode()) * 31) + (this.toast == null ? 0 : this.toast.hashCode())) * 31) + (this.cursor == null ? 0 : this.cursor.hashCode())) * 31) + (this.requestID != null ? this.requestID.hashCode() : 0);
    }

    public String toString() {
        INPageStatus iNPageStatus = this.pageStatus;
        List<INMessageCard> list = this.messageCards;
        KMsgListLimit kMsgListLimit = this.limit;
        List<INFilter> list2 = this.filters;
        ToastMessage toastMessage = this.toast;
        KCursor kCursor = this.cursor;
        return "INState(pageStatus=" + iNPageStatus + ", messageCards=" + list + ", limit=" + kMsgListLimit + ", filters=" + list2 + ", toast=" + toastMessage + ", cursor=" + kCursor + ", requestID=" + this.requestID + ")";
    }

    public INState(INPageStatus pageStatus, List<INMessageCard> list, KMsgListLimit limit, List<INFilter> list2, ToastMessage toast, KCursor cursor, Long requestID) {
        Intrinsics.checkNotNullParameter(pageStatus, "pageStatus");
        Intrinsics.checkNotNullParameter(list, "messageCards");
        Intrinsics.checkNotNullParameter(list2, "filters");
        this.pageStatus = pageStatus;
        this.messageCards = list;
        this.limit = limit;
        this.filters = list2;
        this.toast = toast;
        this.cursor = cursor;
        this.requestID = requestID;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ INState(INPageStatus iNPageStatus, List list, KMsgListLimit kMsgListLimit, List list2, ToastMessage toastMessage, KCursor kCursor, Long l, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(iNPageStatus, list, kMsgListLimit, list2, r6, kCursor, l);
        ToastMessage toastMessage2;
        if ((i2 & 16) == 0) {
            toastMessage2 = toastMessage;
        } else {
            toastMessage2 = null;
        }
    }

    public final INPageStatus getPageStatus() {
        return this.pageStatus;
    }

    public final List<INMessageCard> getMessageCards$interactive_debug() {
        return this.messageCards;
    }

    public final KMsgListLimit getLimit$interactive_debug() {
        return this.limit;
    }

    public final List<INFilter> getFilters() {
        return this.filters;
    }

    public final ToastMessage getToast$interactive_debug() {
        return this.toast;
    }

    public final KCursor getCursor$interactive_debug() {
        return this.cursor;
    }

    public final Long getRequestID$interactive_debug() {
        return this.requestID;
    }

    /* compiled from: INState.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lim/direct/notification/interactive/INState$Companion;", "", "<init>", "()V", "interactive_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final List<INCard> getCards() {
        INMessageCard tempCard;
        INMessageCard copy;
        List result = new ArrayList();
        INMessageCard lastCard = null;
        boolean hasTeachCardBeenInserted = false;
        for (INMessageCard card : this.messageCards) {
            if (lastCard == null) {
                tempCard = card.copy((r36 & 1) != 0 ? card.message : null, (r36 & 2) != 0 ? card.type : null, (r36 & 4) != 0 ? card.f1973common : null, (r36 & 8) != 0 ? card.richTextContentByteArray : null, (r36 & 16) != 0 ? card.description : null, (r36 & 32) != 0 ? card.commentCtrl : null, (r36 & 64) != 0 ? card.likeCtrl : null, (r36 & 128) != 0 ? card.thankCtrl : null, (r36 & 256) != 0 ? card.minorOperations : null, (r36 & 512) != 0 ? card.isMuted : false, (r36 & 1024) != 0 ? card.isPinned : false, (r36 & 2048) != 0 ? card.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? card.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? card.hasUnreadMark : false, (r36 & 16384) != 0 ? card.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? card.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? card.isNeedTeach : false);
            } else if (lastCard.isPinned() ^ card.isPinned()) {
                result.add(new INEmptyCard(8));
                tempCard = card.copy((r36 & 1) != 0 ? card.message : null, (r36 & 2) != 0 ? card.type : null, (r36 & 4) != 0 ? card.f1973common : null, (r36 & 8) != 0 ? card.richTextContentByteArray : null, (r36 & 16) != 0 ? card.description : null, (r36 & 32) != 0 ? card.commentCtrl : null, (r36 & 64) != 0 ? card.likeCtrl : null, (r36 & 128) != 0 ? card.thankCtrl : null, (r36 & 256) != 0 ? card.minorOperations : null, (r36 & 512) != 0 ? card.isMuted : false, (r36 & 1024) != 0 ? card.isPinned : false, (r36 & 2048) != 0 ? card.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? card.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? card.hasUnreadMark : false, (r36 & 16384) != 0 ? card.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? card.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? card.isNeedTeach : false);
            } else {
                tempCard = card;
            }
            lastCard = card;
            if (!hasTeachCardBeenInserted && tempCard.isUnread()) {
                KMsgItem msgItem = card.getMessage().getMsgItem();
                if ((msgItem != null ? msgItem.getMsgCard() : null) instanceof KMsgItem.KReplyCard) {
                    if (INStateKt.isThisFirstTime$default("first_time_show_guide_tips", null, 2, null)) {
                        copy = r7.copy((r36 & 1) != 0 ? r7.message : null, (r36 & 2) != 0 ? r7.type : null, (r36 & 4) != 0 ? r7.f1973common : null, (r36 & 8) != 0 ? r7.richTextContentByteArray : null, (r36 & 16) != 0 ? r7.description : null, (r36 & 32) != 0 ? r7.commentCtrl : null, (r36 & 64) != 0 ? r7.likeCtrl : null, (r36 & 128) != 0 ? r7.thankCtrl : null, (r36 & 256) != 0 ? r7.minorOperations : null, (r36 & 512) != 0 ? r7.isMuted : false, (r36 & 1024) != 0 ? r7.isPinned : false, (r36 & 2048) != 0 ? r7.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? r7.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? r7.hasUnreadMark : false, (r36 & 16384) != 0 ? r7.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? r7.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? tempCard.isNeedTeach : true);
                        result.add(copy);
                        hasTeachCardBeenInserted = true;
                    } else {
                        result.add(tempCard);
                    }
                }
            }
            result.add(tempCard);
        }
        if (this.limit != null) {
            result.add(new INTipsCard(this.limit.getDesc()));
        }
        return CollectionsKt.toList(result);
    }

    public final INState refresh$interactive_debug(KMsgListRsp response) {
        Intrinsics.checkNotNullParameter(response, "response");
        List cards = modifyCards(INStateKt.access$cards(response, INStateKt.currentFilterType(this.filters), true), response.getLastViewAt());
        List filters = this.filters;
        if (filters.isEmpty()) {
            Iterable $this$mapIndexed$iv = response.getFilters();
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
            int index$iv$iv = 0;
            for (Object item$iv$iv : $this$mapIndexed$iv) {
                int index$iv$iv2 = index$iv$iv + 1;
                if (index$iv$iv < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                KMsgFeedFilter filter = (KMsgFeedFilter) item$iv$iv;
                destination$iv$iv.add(new INFilter(filter, index$iv$iv == 0));
                index$iv$iv = index$iv$iv2;
            }
            filters = (List) destination$iv$iv;
            if (filters.isEmpty()) {
                filters = CollectionsKt.listOf(new INFilter());
            }
        }
        return new INState(cards.isEmpty() ? INPageStatusEmpty.INSTANCE : INPageStatusSuccess.INSTANCE, cards, response.getLimit(), filters, null, response.getCursor(), null, 16, null);
    }

    public final INState refreshTab$interactive_debug(KMsgListRsp response) {
        Intrinsics.checkNotNullParameter(response, "response");
        List cards = modifyCards(INStateKt.access$cards(response, INStateKt.currentFilterType(this.filters), true), response.getLastViewAt());
        return new INState(cards.isEmpty() ? INPageStatusEmpty.INSTANCE : INPageStatusSuccess.INSTANCE, cards, response.getLimit(), this.filters, null, response.getCursor(), null, 16, null);
    }

    public final INState append$interactive_debug(KMsgListRsp response) {
        Intrinsics.checkNotNullParameter(response, "response");
        List cards = modifyCards(CollectionsKt.plus(this.messageCards, INStateKt.access$cards(response, INStateKt.currentFilterType(this.filters), false)), response.getLastViewAt());
        return new INState(cards.isEmpty() ? INPageStatusEmpty.INSTANCE : INPageStatusSuccess.INSTANCE, cards, response.getLimit(), this.filters, null, response.getCursor(), null, 16, null);
    }

    private final List<INMessageCard> modifyCards(List<INMessageCard> list, long lastViewAt) {
        Iterable $this$any$iv;
        Object element$iv;
        INMessageCard newCard;
        INMessageCard it;
        KCommonMsgCard common2;
        List<INMessageCard> $this$any$iv2 = list;
        if (!($this$any$iv2 instanceof Collection) || !$this$any$iv2.isEmpty()) {
            Iterator<T> it2 = $this$any$iv2.iterator();
            while (true) {
                if (it2.hasNext()) {
                    Object element$iv2 = it2.next();
                    INMessageCard it3 = (INMessageCard) element$iv2;
                    if (it3.getHasUnreadMark()) {
                        $this$any$iv = 1;
                        break;
                    }
                } else {
                    $this$any$iv = null;
                    break;
                }
            }
        } else {
            $this$any$iv = null;
        }
        INMessageCard iNMessageCard = (INMessageCard) CollectionsKt.firstOrNull(list);
        Long firstMsgTime = (iNMessageCard == null || (common2 = iNMessageCard.getCommon()) == null) ? null : Long.valueOf(common2.getMsgTime());
        List newCards = CollectionsKt.toMutableList(list);
        if (lastViewAt > 0 && $this$any$iv == null && firstMsgTime != null && lastViewAt < firstMsgTime.longValue()) {
            List<INMessageCard> $this$filter$iv = list;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                INMessageCard it4 = (INMessageCard) element$iv$iv;
                if (!it4.isPinned()) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            List $this$lastOrNull$iv = (List) destination$iv$iv;
            ListIterator iterator$iv = $this$lastOrNull$iv.listIterator($this$lastOrNull$iv.size());
            while (true) {
                if (iterator$iv.hasPrevious()) {
                    element$iv = iterator$iv.previous();
                    INMessageCard it5 = (INMessageCard) element$iv;
                    KCommonMsgCard common3 = it5.getCommon();
                    Long msgTime = common3 != null ? Long.valueOf(common3.getMsgTime()) : null;
                    if (msgTime == null || msgTime.longValue() <= lastViewAt) {
                        it = null;
                        continue;
                    } else {
                        it = 1;
                        continue;
                    }
                    if (it != null) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            INMessageCard card = (INMessageCard) element$iv;
            Integer index = card != null ? Integer.valueOf(list.indexOf(card)) : null;
            if (card != null && index != null && CollectionsKt.getIndices(list).contains(index.intValue())) {
                newCard = card.copy((r36 & 1) != 0 ? card.message : null, (r36 & 2) != 0 ? card.type : null, (r36 & 4) != 0 ? card.f1973common : null, (r36 & 8) != 0 ? card.richTextContentByteArray : null, (r36 & 16) != 0 ? card.description : null, (r36 & 32) != 0 ? card.commentCtrl : null, (r36 & 64) != 0 ? card.likeCtrl : null, (r36 & 128) != 0 ? card.thankCtrl : null, (r36 & 256) != 0 ? card.minorOperations : null, (r36 & 512) != 0 ? card.isMuted : false, (r36 & 1024) != 0 ? card.isPinned : false, (r36 & 2048) != 0 ? card.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? card.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? card.hasUnreadMark : true, (r36 & 16384) != 0 ? card.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? card.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? card.isNeedTeach : false);
                newCards.set(index.intValue(), newCard);
            }
        }
        return CollectionsKt.toList(newCards);
    }

    public final INState delete$interactive_debug(final INMessageCard card) {
        Intrinsics.checkNotNullParameter(card, "card");
        final List mutableCards = CollectionsKt.toMutableList(this.messageCards);
        CollectionsKt.removeAll(mutableCards, new Function1() { // from class: im.direct.notification.interactive.INState$$ExternalSyntheticLambda4
            public final Object invoke(Object obj) {
                boolean delete$lambda$0;
                delete$lambda$0 = INState.delete$lambda$0(INMessageCard.this, (INMessageCard) obj);
                return Boolean.valueOf(delete$lambda$0);
            }
        });
        return (INState) CopyScopeKt.copy(this, new Function1() { // from class: im.direct.notification.interactive.INState$$ExternalSyntheticLambda5
            public final Object invoke(Object obj) {
                Unit delete$lambda$1;
                delete$lambda$1 = INState.delete$lambda$1(mutableCards, (CopyScope) obj);
                return delete$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean delete$lambda$0(INMessageCard $card, INMessageCard it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.isSameWith$interactive_debug($card);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit delete$lambda$1(List $mutableCards, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(INStateLensKt.getMessageCards(Companion), CollectionsKt.toList($mutableCards));
        return Unit.INSTANCE;
    }

    public final INState mute$interactive_debug(INMessageCard card, boolean isMuted) {
        final INMessageCard newCard;
        INMessageCard iNMessageCard;
        Intrinsics.checkNotNullParameter(card, "card");
        List mutableCards = CollectionsKt.toMutableList(this.messageCards);
        KMsgItem msgItem = card.getMessage().getMsgItem();
        if ((msgItem != null ? msgItem.getMsgCard() : null) instanceof KMsgItem.KReplyCard) {
            List $this$map$iv = mutableCards;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                INMessageCard it = (INMessageCard) item$iv$iv;
                if (it.getSourceID$interactive_debug() == card.getSourceID$interactive_debug()) {
                    iNMessageCard = it.copy((r36 & 1) != 0 ? it.message : null, (r36 & 2) != 0 ? it.type : null, (r36 & 4) != 0 ? it.f1973common : null, (r36 & 8) != 0 ? it.richTextContentByteArray : null, (r36 & 16) != 0 ? it.description : null, (r36 & 32) != 0 ? it.commentCtrl : null, (r36 & 64) != 0 ? it.likeCtrl : null, (r36 & 128) != 0 ? it.thankCtrl : null, (r36 & 256) != 0 ? it.minorOperations : null, (r36 & 512) != 0 ? it.isMuted : isMuted, (r36 & 1024) != 0 ? it.isPinned : false, (r36 & 2048) != 0 ? it.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? it.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? it.hasUnreadMark : false, (r36 & 16384) != 0 ? it.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? it.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? it.isNeedTeach : false);
                } else {
                    iNMessageCard = it;
                }
                destination$iv$iv.add(iNMessageCard);
            }
            final List updatedCards = (List) destination$iv$iv;
            return (INState) CopyScopeKt.copy(this, new Function1() { // from class: im.direct.notification.interactive.INState$$ExternalSyntheticLambda2
                public final Object invoke(Object obj) {
                    Unit mute$lambda$1;
                    mute$lambda$1 = INState.mute$lambda$1(updatedCards, (CopyScope) obj);
                    return mute$lambda$1;
                }
            });
        }
        int index$iv = 0;
        Iterator it2 = mutableCards.iterator();
        while (true) {
            if (it2.hasNext()) {
                Object item$iv = it2.next();
                if (((INMessageCard) item$iv).isSameWith$interactive_debug(card)) {
                    break;
                }
                index$iv++;
            } else {
                index$iv = -1;
                break;
            }
        }
        final int index = index$iv;
        newCard = r5.copy((r36 & 1) != 0 ? r5.message : null, (r36 & 2) != 0 ? r5.type : null, (r36 & 4) != 0 ? r5.f1973common : null, (r36 & 8) != 0 ? r5.richTextContentByteArray : null, (r36 & 16) != 0 ? r5.description : null, (r36 & 32) != 0 ? r5.commentCtrl : null, (r36 & 64) != 0 ? r5.likeCtrl : null, (r36 & 128) != 0 ? r5.thankCtrl : null, (r36 & 256) != 0 ? r5.minorOperations : null, (r36 & 512) != 0 ? r5.isMuted : isMuted, (r36 & 1024) != 0 ? r5.isPinned : false, (r36 & 2048) != 0 ? r5.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? r5.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? r5.hasUnreadMark : false, (r36 & 16384) != 0 ? r5.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? r5.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? ((INMessageCard) mutableCards.get(index)).isNeedTeach : false);
        return (INState) CopyScopeKt.copy(this, new Function1() { // from class: im.direct.notification.interactive.INState$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                Unit mute$lambda$3;
                mute$lambda$3 = INState.mute$lambda$3(INMessageCard.this, index, (CopyScope) obj);
                return mute$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mute$lambda$1(List $updatedCards, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(INStateLensKt.getMessageCards(Companion), $updatedCards);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit mute$lambda$3(INMessageCard $newCard, final int $index, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(com.bilibili.blens.CollectionsKt.single(INStateLensKt.getMessageCards(Companion), new Function1() { // from class: im.direct.notification.interactive.INState$$ExternalSyntheticLambda6
            public final Object invoke(Object obj) {
                int mute$lambda$3$0;
                mute$lambda$3$0 = INState.mute$lambda$3$0($index, (List) obj);
                return Integer.valueOf(mute$lambda$3$0);
            }
        }), $newCard);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int mute$lambda$3$0(int $index, List $this$single) {
        Intrinsics.checkNotNullParameter($this$single, "$this$single");
        return $index;
    }

    public final INState requestFail$interactive_debug(INMessageCard card) {
        final INMessageCard newCard;
        Intrinsics.checkNotNullParameter(card, "card");
        List mutableCards = CollectionsKt.toMutableList(this.messageCards);
        int index$iv = 0;
        Iterator it = mutableCards.iterator();
        while (true) {
            if (it.hasNext()) {
                Object item$iv = it.next();
                INMessageCard it2 = (INMessageCard) item$iv;
                if (it2.isSameWith$interactive_debug(card)) {
                    break;
                }
                index$iv++;
            } else {
                index$iv = -1;
                break;
            }
        }
        final int index = index$iv;
        newCard = r5.copy((r36 & 1) != 0 ? r5.message : null, (r36 & 2) != 0 ? r5.type : null, (r36 & 4) != 0 ? r5.f1973common : null, (r36 & 8) != 0 ? r5.richTextContentByteArray : null, (r36 & 16) != 0 ? r5.description : null, (r36 & 32) != 0 ? r5.commentCtrl : null, (r36 & 64) != 0 ? r5.likeCtrl : null, (r36 & 128) != 0 ? r5.thankCtrl : null, (r36 & 256) != 0 ? r5.minorOperations : null, (r36 & 512) != 0 ? r5.isMuted : false, (r36 & 1024) != 0 ? r5.isPinned : false, (r36 & 2048) != 0 ? r5.isUnread : false, (r36 & CIOKt.DEFAULT_HTTP_BUFFER_SIZE) != 0 ? r5.hasTopSeparator : false, (r36 & GrpcUtil.DEFAULT_MAX_HEADER_LIST_SIZE) != 0 ? r5.hasUnreadMark : false, (r36 & 16384) != 0 ? r5.sourceID : 0L, (r36 & AbstractStream.TransportState.DEFAULT_ONREADY_THRESHOLD) != 0 ? r5.messageTips : null, (r36 & WXMediaMessage.THUMB_LENGTH_LIMIT) != 0 ? ((INMessageCard) mutableCards.get(index)).isNeedTeach : false);
        return (INState) CopyScopeKt.copy(this, new Function1() { // from class: im.direct.notification.interactive.INState$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit requestFail$lambda$1;
                requestFail$lambda$1 = INState.requestFail$lambda$1(INMessageCard.this, index, (CopyScope) obj);
                return requestFail$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit requestFail$lambda$1(INMessageCard $newCard, final int $index, CopyScope $this$copy) {
        Intrinsics.checkNotNullParameter($this$copy, "$this$copy");
        $this$copy.set(com.bilibili.blens.CollectionsKt.single(INStateLensKt.getMessageCards(Companion), new Function1() { // from class: im.direct.notification.interactive.INState$$ExternalSyntheticLambda1
            public final Object invoke(Object obj) {
                int requestFail$lambda$1$0;
                requestFail$lambda$1$0 = INState.requestFail$lambda$1$0($index, (List) obj);
                return Integer.valueOf(requestFail$lambda$1$0);
            }
        }), $newCard);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int requestFail$lambda$1$0(int $index, List $this$single) {
        Intrinsics.checkNotNullParameter($this$single, "$this$single");
        return $index;
    }
}