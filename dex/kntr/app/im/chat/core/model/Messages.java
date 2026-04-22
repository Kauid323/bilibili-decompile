package kntr.app.im.chat.core.model;

import com.bilibili.blens.Lens;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Message.kt */
@Lens
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB7\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0000H\u0086\u0002J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lkntr/app/im/chat/core/model/Messages;", RoomRecommendViewModel.EMPTY_CURSOR, "entityMessages", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/im/chat/core/model/EntityMessage;", "ghostMessages", "Lkntr/app/im/chat/core/model/GhostMessage;", "sendingMessages", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getEntityMessages", "()Ljava/util/List;", "getGhostMessages", "getSendingMessages", "lastSequence", "Lkntr/app/im/chat/core/model/MessageSequence;", "getLastSequence", "()Lkntr/app/im/chat/core/model/MessageSequence;", "plus", "other", "getMessagesForDisplay", "component1", "component2", "component3", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", RoomRecommendViewModel.EMPTY_CURSOR, "toString", RoomRecommendViewModel.EMPTY_CURSOR, "Companion", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Messages {
    private final List<EntityMessage> entityMessages;
    private final List<GhostMessage> ghostMessages;
    private final MessageSequence lastSequence;
    private final List<EntityMessage> sendingMessages;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public Messages() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Messages copy$default(Messages messages, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            list = messages.entityMessages;
        }
        if ((i & 2) != 0) {
            list2 = messages.ghostMessages;
        }
        if ((i & 4) != 0) {
            list3 = messages.sendingMessages;
        }
        return messages.copy(list, list2, list3);
    }

    public final List<EntityMessage> component1() {
        return this.entityMessages;
    }

    public final List<GhostMessage> component2() {
        return this.ghostMessages;
    }

    public final List<EntityMessage> component3() {
        return this.sendingMessages;
    }

    public final Messages copy(List<EntityMessage> list, List<GhostMessage> list2, List<EntityMessage> list3) {
        Intrinsics.checkNotNullParameter(list, "entityMessages");
        Intrinsics.checkNotNullParameter(list2, "ghostMessages");
        Intrinsics.checkNotNullParameter(list3, "sendingMessages");
        return new Messages(list, list2, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Messages) {
            Messages messages = (Messages) obj;
            return Intrinsics.areEqual(this.entityMessages, messages.entityMessages) && Intrinsics.areEqual(this.ghostMessages, messages.ghostMessages) && Intrinsics.areEqual(this.sendingMessages, messages.sendingMessages);
        }
        return false;
    }

    public int hashCode() {
        return (((this.entityMessages.hashCode() * 31) + this.ghostMessages.hashCode()) * 31) + this.sendingMessages.hashCode();
    }

    public String toString() {
        List<EntityMessage> list = this.entityMessages;
        List<GhostMessage> list2 = this.ghostMessages;
        return "Messages(entityMessages=" + list + ", ghostMessages=" + list2 + ", sendingMessages=" + this.sendingMessages + ")";
    }

    public Messages(List<EntityMessage> list, List<GhostMessage> list2, List<EntityMessage> list3) {
        MessageSequence empty;
        MessageId msgId;
        Intrinsics.checkNotNullParameter(list, "entityMessages");
        Intrinsics.checkNotNullParameter(list2, "ghostMessages");
        Intrinsics.checkNotNullParameter(list3, "sendingMessages");
        this.entityMessages = list;
        this.ghostMessages = list2;
        this.sendingMessages = list3;
        EntityMessage entityMessage = (EntityMessage) CollectionsKt.lastOrNull(this.entityMessages);
        this.lastSequence = (entityMessage == null || (msgId = entityMessage.getMsgId()) == null || (empty = msgId.getSequence()) == null) ? MessageSequence.Companion.getEmpty() : empty;
    }

    public /* synthetic */ Messages(List list, List list2, List list3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.emptyList() : list, (i & 2) != 0 ? CollectionsKt.emptyList() : list2, (i & 4) != 0 ? CollectionsKt.emptyList() : list3);
    }

    public final List<EntityMessage> getEntityMessages() {
        return this.entityMessages;
    }

    public final List<GhostMessage> getGhostMessages() {
        return this.ghostMessages;
    }

    public final List<EntityMessage> getSendingMessages() {
        return this.sendingMessages;
    }

    /* compiled from: Message.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lkntr/app/im/chat/core/model/Messages$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final MessageSequence getLastSequence() {
        return this.lastSequence;
    }

    public final Messages plus(Messages other) {
        Intrinsics.checkNotNullParameter(other, "other");
        Iterable $this$sortedBy$iv = CollectionsKt.plus(this.entityMessages, other.entityMessages);
        List sortedWith = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: kntr.app.im.chat.core.model.Messages$plus$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                EntityMessage it = (EntityMessage) t;
                EntityMessage it2 = (EntityMessage) t2;
                return ComparisonsKt.compareValues(Long.valueOf(it.getMsgId().getSequenceNumber()), Long.valueOf(it2.getMsgId().getSequenceNumber()));
            }
        });
        Iterable $this$sortedBy$iv2 = CollectionsKt.plus(this.ghostMessages, other.ghostMessages);
        List sortedWith2 = CollectionsKt.sortedWith($this$sortedBy$iv2, new Comparator() { // from class: kntr.app.im.chat.core.model.Messages$plus$$inlined$sortedBy$2
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                GhostMessage it = (GhostMessage) t;
                GhostMessage it2 = (GhostMessage) t2;
                return ComparisonsKt.compareValues(Long.valueOf(it.getMsgId().getSequenceNumber()), Long.valueOf(it2.getMsgId().getSequenceNumber()));
            }
        });
        Iterable $this$sortedBy$iv3 = CollectionsKt.plus(this.sendingMessages, other.sendingMessages);
        return new Messages(sortedWith, sortedWith2, CollectionsKt.sortedWith($this$sortedBy$iv3, new Comparator() { // from class: kntr.app.im.chat.core.model.Messages$plus$$inlined$sortedBy$3
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                EntityMessage it = (EntityMessage) t;
                EntityMessage it2 = (EntityMessage) t2;
                return ComparisonsKt.compareValues(Long.valueOf(it.getMsgId().getSequenceNumber()), Long.valueOf(it2.getMsgId().getSequenceNumber()));
            }
        }));
    }

    public final List<EntityMessage> getMessagesForDisplay() {
        List<EntityMessage> list;
        EntityMessage copy;
        Iterable $this$map$iv = this.sendingMessages;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(((EntityMessage) item$iv$iv).getToken());
        }
        Set sending = CollectionsKt.toSet((List) destination$iv$iv);
        Iterable $this$filter$iv = CollectionsKt.asReversed(this.entityMessages);
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (!sending.contains(((EntityMessage) element$iv$iv).getToken())) {
                destination$iv$iv2.add(element$iv$iv);
            }
        }
        List filteredDbMessages = (List) destination$iv$iv2;
        EntityMessage last = (EntityMessage) CollectionsKt.firstOrNull(filteredDbMessages);
        if (last != null) {
            Iterable $this$map$iv2 = this.sendingMessages;
            Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv2 : $this$map$iv2) {
                EntityMessage it = (EntityMessage) item$iv$iv2;
                copy = it.copy((r30 & 1) != 0 ? it.entityKey : 0L, (r30 & 2) != 0 ? it.msgId : MessageId.copy$default(it.getMsgId(), null, 0L, MessageSequence.copy$default(last.getMsgId().getSequence(), 0L, last.getMsgId().getSequence().getSubSequenceNumber() + it.getMsgId().getSequence().getSubSequenceNumber(), 1, null), 3, null), (r30 & 4) != 0 ? it.msgType : null, (r30 & 8) != 0 ? it.msgFrame : null, (r30 & 16) != 0 ? it.timestamp : null, (r30 & 32) != 0 ? it.token : null, (r30 & 64) != 0 ? it.isHidden : false, (r30 & 128) != 0 ? it.sendStatus : null, (r30 & 256) != 0 ? it.createTime : null, (r30 & 512) != 0 ? it.updateTime : null, (r30 & 1024) != 0 ? it.isRealtimeMessage : false, (r30 & 2048) != 0 ? it.isTemporaryMsg : false, (r30 & 4096) != 0 ? it.traceParams : null);
                destination$iv$iv3.add(copy);
            }
            list = (List) destination$iv$iv3;
        } else {
            list = this.sendingMessages;
        }
        Iterable $this$sortedBy$iv = CollectionsKt.plus(CollectionsKt.asReversed(filteredDbMessages), list);
        return CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: kntr.app.im.chat.core.model.Messages$getMessagesForDisplay$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                EntityMessage it2 = (EntityMessage) t;
                EntityMessage it3 = (EntityMessage) t2;
                return ComparisonsKt.compareValues(it2.getMsgId().getSequence(), it3.getMsgId().getSequence());
            }
        });
    }
}