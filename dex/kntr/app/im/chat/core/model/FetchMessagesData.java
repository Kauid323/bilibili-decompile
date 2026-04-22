package kntr.app.im.chat.core.model;

import BottomSheetItemData$;
import com.bilibili.blens.Lens;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlinx.datetime.Instant;

/* compiled from: FetchMessagesData.kt */
@Lens
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b*\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 D2\u00020\u0001:\u0001DB«\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0018\u0010\u0019J\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u00105\u001a\u00020\u000bHÆ\u0003J\t\u00106\u001a\u00020\rHÆ\u0003J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J\u000f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fHÆ\u0003J\u000f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\rHÆ\u0003J\u00ad\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010>\u001a\u00020\u00032\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020AHÖ\u0001J\t\u0010B\u001a\u00020CHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010'R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010'R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%¨\u0006E"}, d2 = {"Lkntr/app/im/chat/core/model/FetchMessagesData;", RoomRecommendViewModel.EMPTY_CURSOR, "databaseReady", RoomRecommendViewModel.EMPTY_CURSOR, "loadingLater", "pendingLoadLater", "loadingEarlier", "pendingLoadEarlier", "currentRange", "Lkotlin/ranges/LongRange;", "messages", "Lkntr/app/im/chat/core/model/Messages;", "baselineTime", "Lkotlinx/datetime/Instant;", "tempMessages", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/EntityMessage;", "updateMsgIds", "Lkntr/app/im/chat/core/model/MessageId;", "markFailedMessage", "performAck", "error", RoomRecommendViewModel.EMPTY_CURSOR, "errorTime", "<init>", "(ZZZZZLkotlin/ranges/LongRange;Lkntr/app/im/chat/core/model/Messages;Lkotlinx/datetime/Instant;Ljava/util/List;Ljava/util/List;Ljava/util/List;ZLjava/lang/Throwable;Lkotlinx/datetime/Instant;)V", "getDatabaseReady", "()Z", "getLoadingLater", "getPendingLoadLater", "getLoadingEarlier", "getPendingLoadEarlier", "getCurrentRange", "()Lkotlin/ranges/LongRange;", "getMessages", "()Lkntr/app/im/chat/core/model/Messages;", "getBaselineTime", "()Lkotlinx/datetime/Instant;", "getTempMessages", "()Ljava/util/List;", "getUpdateMsgIds", "getMarkFailedMessage", "getPerformAck", "getError", "()Ljava/lang/Throwable;", "getErrorTime", "getTempMessageInRange", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FetchMessagesData {
    private final Instant baselineTime;
    private final LongRange currentRange;
    private final boolean databaseReady;
    private final Throwable error;
    private final Instant errorTime;
    private final boolean loadingEarlier;
    private final boolean loadingLater;
    private final List<EntityMessage> markFailedMessage;
    private final Messages messages;
    private final boolean pendingLoadEarlier;
    private final boolean pendingLoadLater;
    private final boolean performAck;
    private final List<EntityMessage> tempMessages;
    private final List<MessageId> updateMsgIds;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public FetchMessagesData() {
        this(false, false, false, false, false, null, null, null, null, null, null, false, null, null, 16383, null);
    }

    public final boolean component1() {
        return this.databaseReady;
    }

    public final List<MessageId> component10() {
        return this.updateMsgIds;
    }

    public final List<EntityMessage> component11() {
        return this.markFailedMessage;
    }

    public final boolean component12() {
        return this.performAck;
    }

    public final Throwable component13() {
        return this.error;
    }

    public final Instant component14() {
        return this.errorTime;
    }

    public final boolean component2() {
        return this.loadingLater;
    }

    public final boolean component3() {
        return this.pendingLoadLater;
    }

    public final boolean component4() {
        return this.loadingEarlier;
    }

    public final boolean component5() {
        return this.pendingLoadEarlier;
    }

    public final LongRange component6() {
        return this.currentRange;
    }

    public final Messages component7() {
        return this.messages;
    }

    public final Instant component8() {
        return this.baselineTime;
    }

    public final List<EntityMessage> component9() {
        return this.tempMessages;
    }

    public final FetchMessagesData copy(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, LongRange longRange, Messages messages, Instant instant, List<EntityMessage> list, List<MessageId> list2, List<EntityMessage> list3, boolean z6, Throwable th, Instant instant2) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        Intrinsics.checkNotNullParameter(instant, "baselineTime");
        Intrinsics.checkNotNullParameter(list, "tempMessages");
        Intrinsics.checkNotNullParameter(list2, "updateMsgIds");
        Intrinsics.checkNotNullParameter(list3, "markFailedMessage");
        return new FetchMessagesData(z, z2, z3, z4, z5, longRange, messages, instant, list, list2, list3, z6, th, instant2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FetchMessagesData) {
            FetchMessagesData fetchMessagesData = (FetchMessagesData) obj;
            return this.databaseReady == fetchMessagesData.databaseReady && this.loadingLater == fetchMessagesData.loadingLater && this.pendingLoadLater == fetchMessagesData.pendingLoadLater && this.loadingEarlier == fetchMessagesData.loadingEarlier && this.pendingLoadEarlier == fetchMessagesData.pendingLoadEarlier && Intrinsics.areEqual(this.currentRange, fetchMessagesData.currentRange) && Intrinsics.areEqual(this.messages, fetchMessagesData.messages) && Intrinsics.areEqual(this.baselineTime, fetchMessagesData.baselineTime) && Intrinsics.areEqual(this.tempMessages, fetchMessagesData.tempMessages) && Intrinsics.areEqual(this.updateMsgIds, fetchMessagesData.updateMsgIds) && Intrinsics.areEqual(this.markFailedMessage, fetchMessagesData.markFailedMessage) && this.performAck == fetchMessagesData.performAck && Intrinsics.areEqual(this.error, fetchMessagesData.error) && Intrinsics.areEqual(this.errorTime, fetchMessagesData.errorTime);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((BottomSheetItemData$.ExternalSyntheticBackport0.m(this.databaseReady) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.loadingLater)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.pendingLoadLater)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.loadingEarlier)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.pendingLoadEarlier)) * 31) + (this.currentRange == null ? 0 : this.currentRange.hashCode())) * 31) + this.messages.hashCode()) * 31) + this.baselineTime.hashCode()) * 31) + this.tempMessages.hashCode()) * 31) + this.updateMsgIds.hashCode()) * 31) + this.markFailedMessage.hashCode()) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.performAck)) * 31) + (this.error == null ? 0 : this.error.hashCode())) * 31) + (this.errorTime != null ? this.errorTime.hashCode() : 0);
    }

    public String toString() {
        boolean z = this.databaseReady;
        boolean z2 = this.loadingLater;
        boolean z3 = this.pendingLoadLater;
        boolean z4 = this.loadingEarlier;
        boolean z5 = this.pendingLoadEarlier;
        LongRange longRange = this.currentRange;
        Messages messages = this.messages;
        Instant instant = this.baselineTime;
        List<EntityMessage> list = this.tempMessages;
        List<MessageId> list2 = this.updateMsgIds;
        List<EntityMessage> list3 = this.markFailedMessage;
        boolean z6 = this.performAck;
        Throwable th = this.error;
        return "FetchMessagesData(databaseReady=" + z + ", loadingLater=" + z2 + ", pendingLoadLater=" + z3 + ", loadingEarlier=" + z4 + ", pendingLoadEarlier=" + z5 + ", currentRange=" + longRange + ", messages=" + messages + ", baselineTime=" + instant + ", tempMessages=" + list + ", updateMsgIds=" + list2 + ", markFailedMessage=" + list3 + ", performAck=" + z6 + ", error=" + th + ", errorTime=" + this.errorTime + ")";
    }

    public FetchMessagesData(boolean databaseReady, boolean loadingLater, boolean pendingLoadLater, boolean loadingEarlier, boolean pendingLoadEarlier, LongRange currentRange, Messages messages, Instant baselineTime, List<EntityMessage> list, List<MessageId> list2, List<EntityMessage> list3, boolean performAck, Throwable error, Instant errorTime) {
        Intrinsics.checkNotNullParameter(messages, "messages");
        Intrinsics.checkNotNullParameter(baselineTime, "baselineTime");
        Intrinsics.checkNotNullParameter(list, "tempMessages");
        Intrinsics.checkNotNullParameter(list2, "updateMsgIds");
        Intrinsics.checkNotNullParameter(list3, "markFailedMessage");
        this.databaseReady = databaseReady;
        this.loadingLater = loadingLater;
        this.pendingLoadLater = pendingLoadLater;
        this.loadingEarlier = loadingEarlier;
        this.pendingLoadEarlier = pendingLoadEarlier;
        this.currentRange = currentRange;
        this.messages = messages;
        this.baselineTime = baselineTime;
        this.tempMessages = list;
        this.updateMsgIds = list2;
        this.markFailedMessage = list3;
        this.performAck = performAck;
        this.error = error;
        this.errorTime = errorTime;
    }

    public /* synthetic */ FetchMessagesData(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, LongRange longRange, Messages messages, Instant instant, List list, List list2, List list3, boolean z6, Throwable th, Instant instant2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? false : z4, (i & 16) != 0 ? false : z5, (i & 32) != 0 ? null : longRange, (i & 64) != 0 ? new Messages(null, null, null, 7, null) : messages, (i & 128) != 0 ? Instant.Companion.getDISTANT_PAST() : instant, (i & 256) != 0 ? CollectionsKt.emptyList() : list, (i & 512) != 0 ? CollectionsKt.emptyList() : list2, (i & 1024) != 0 ? CollectionsKt.emptyList() : list3, (i & 2048) == 0 ? z6 : false, (i & 4096) != 0 ? null : th, (i & 8192) == 0 ? instant2 : null);
    }

    public final boolean getDatabaseReady() {
        return this.databaseReady;
    }

    public final boolean getLoadingLater() {
        return this.loadingLater;
    }

    public final boolean getPendingLoadLater() {
        return this.pendingLoadLater;
    }

    public final boolean getLoadingEarlier() {
        return this.loadingEarlier;
    }

    public final boolean getPendingLoadEarlier() {
        return this.pendingLoadEarlier;
    }

    public final LongRange getCurrentRange() {
        return this.currentRange;
    }

    public final Messages getMessages() {
        return this.messages;
    }

    public final Instant getBaselineTime() {
        return this.baselineTime;
    }

    public final List<EntityMessage> getTempMessages() {
        return this.tempMessages;
    }

    public final List<MessageId> getUpdateMsgIds() {
        return this.updateMsgIds;
    }

    public final List<EntityMessage> getMarkFailedMessage() {
        return this.markFailedMessage;
    }

    public final boolean getPerformAck() {
        return this.performAck;
    }

    public final Throwable getError() {
        return this.error;
    }

    public final Instant getErrorTime() {
        return this.errorTime;
    }

    /* compiled from: FetchMessagesData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/im/chat/core/model/FetchMessagesData$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final List<EntityMessage> getTempMessageInRange() {
        LongRange range = this.currentRange;
        if (range == null) {
            return CollectionsKt.emptyList();
        }
        Iterable $this$filter$iv = this.tempMessages;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            EntityMessage it = (EntityMessage) element$iv$iv;
            long first = range.getFirst();
            long last = range.getLast();
            long sequenceNumber = it.getMsgId().getSequenceNumber();
            boolean z = false;
            if (first <= sequenceNumber && sequenceNumber <= last) {
                z = true;
            }
            if (z) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }
}