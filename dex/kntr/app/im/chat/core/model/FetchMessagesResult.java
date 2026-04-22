package kntr.app.im.chat.core.model;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlin.sequences.SequencesKt;

/* compiled from: FetchMessagesData.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001:\u0001$B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J7\u0010\u001d\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lkntr/app/im/chat/core/model/FetchMessagesResult;", RoomRecommendViewModel.EMPTY_CURSOR, "messages", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/Message;", "range", "Lkotlin/ranges/LongRange;", "loadFrom", "Lkntr/app/im/chat/core/model/FetchMessagesResult$LoadFrom;", "beginSequenceNumber", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/util/List;Lkotlin/ranges/LongRange;Lkntr/app/im/chat/core/model/FetchMessagesResult$LoadFrom;J)V", "getMessages", "()Ljava/util/List;", "getRange", "()Lkotlin/ranges/LongRange;", "getLoadFrom", "()Lkntr/app/im/chat/core/model/FetchMessagesResult$LoadFrom;", "getBeginSequenceNumber", "()J", "hasNewMessage", RoomRecommendViewModel.EMPTY_CURSOR, "getHasNewMessage", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "LoadFrom", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FetchMessagesResult {
    public static final int $stable = 8;
    private final long beginSequenceNumber;
    private final LoadFrom loadFrom;
    private final List<Message> messages;
    private final LongRange range;

    /* compiled from: FetchMessagesData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lkntr/app/im/chat/core/model/FetchMessagesResult$LoadFrom;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Ljava/lang/String;I)V", "Database", "Network", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public enum LoadFrom {
        Database,
        Network;
        
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<LoadFrom> getEntries() {
            return $ENTRIES;
        }
    }

    public static /* synthetic */ FetchMessagesResult copy$default(FetchMessagesResult fetchMessagesResult, List list, LongRange longRange, LoadFrom loadFrom, long j2, int i, Object obj) {
        List<Message> list2 = list;
        if ((i & 1) != 0) {
            list2 = fetchMessagesResult.messages;
        }
        if ((i & 2) != 0) {
            longRange = fetchMessagesResult.range;
        }
        LongRange longRange2 = longRange;
        if ((i & 4) != 0) {
            loadFrom = fetchMessagesResult.loadFrom;
        }
        LoadFrom loadFrom2 = loadFrom;
        if ((i & 8) != 0) {
            j2 = fetchMessagesResult.beginSequenceNumber;
        }
        return fetchMessagesResult.copy(list2, longRange2, loadFrom2, j2);
    }

    public final List<Message> component1() {
        return this.messages;
    }

    public final LongRange component2() {
        return this.range;
    }

    public final LoadFrom component3() {
        return this.loadFrom;
    }

    public final long component4() {
        return this.beginSequenceNumber;
    }

    public final FetchMessagesResult copy(List<? extends Message> list, LongRange longRange, LoadFrom loadFrom, long j2) {
        Intrinsics.checkNotNullParameter(list, "messages");
        Intrinsics.checkNotNullParameter(longRange, "range");
        Intrinsics.checkNotNullParameter(loadFrom, "loadFrom");
        return new FetchMessagesResult(list, longRange, loadFrom, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FetchMessagesResult) {
            FetchMessagesResult fetchMessagesResult = (FetchMessagesResult) obj;
            return Intrinsics.areEqual(this.messages, fetchMessagesResult.messages) && Intrinsics.areEqual(this.range, fetchMessagesResult.range) && this.loadFrom == fetchMessagesResult.loadFrom && this.beginSequenceNumber == fetchMessagesResult.beginSequenceNumber;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.messages.hashCode() * 31) + this.range.hashCode()) * 31) + this.loadFrom.hashCode()) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.beginSequenceNumber);
    }

    public String toString() {
        List<Message> list = this.messages;
        LongRange longRange = this.range;
        LoadFrom loadFrom = this.loadFrom;
        return "FetchMessagesResult(messages=" + list + ", range=" + longRange + ", loadFrom=" + loadFrom + ", beginSequenceNumber=" + this.beginSequenceNumber + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FetchMessagesResult(List<? extends Message> list, LongRange range, LoadFrom loadFrom, long beginSequenceNumber) {
        Intrinsics.checkNotNullParameter(list, "messages");
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(loadFrom, "loadFrom");
        this.messages = list;
        this.range = range;
        this.loadFrom = loadFrom;
        this.beginSequenceNumber = beginSequenceNumber;
    }

    public final List<Message> getMessages() {
        return this.messages;
    }

    public final LongRange getRange() {
        return this.range;
    }

    public final LoadFrom getLoadFrom() {
        return this.loadFrom;
    }

    public final long getBeginSequenceNumber() {
        return this.beginSequenceNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _get_hasNewMessage_$lambda$0(FetchMessagesResult this$0, Message it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getMsgId().getSequenceNumber() != this$0.beginSequenceNumber;
    }

    public final boolean getHasNewMessage() {
        return SequencesKt.any(SequencesKt.filter(CollectionsKt.asSequence(this.messages), new Function1() { // from class: kntr.app.im.chat.core.model.FetchMessagesResult$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                boolean _get_hasNewMessage_$lambda$0;
                _get_hasNewMessage_$lambda$0 = FetchMessagesResult._get_hasNewMessage_$lambda$0(FetchMessagesResult.this, (Message) obj);
                return Boolean.valueOf(_get_hasNewMessage_$lambda$0);
            }
        }));
    }
}