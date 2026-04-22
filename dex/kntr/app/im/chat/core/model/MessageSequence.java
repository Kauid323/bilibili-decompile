package kntr.app.im.chat.core.model;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.Comparator;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: Message.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002&'B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B+\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u0003J\u0011\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0000H\u0096\u0002J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J%\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00002\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0001¢\u0006\u0002\b%R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015¨\u0006("}, d2 = {"Lkntr/app/im/chat/core/model/MessageSequence;", RoomRecommendViewModel.EMPTY_CURSOR, "sequenceNumber", RoomRecommendViewModel.EMPTY_CURSOR, "subSequenceNumber", "<init>", "(JJ)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJJLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSequenceNumber", "()J", "getSubSequenceNumber", "nextSendSequence", "subDiff", "compareTo", "other", "isLocalSequence", RoomRecommendViewModel.EMPTY_CURSOR, "()Z", "component1", "component2", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "Companion", "$serializer", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class MessageSequence implements Comparable<MessageSequence> {
    public static final int $stable = 0;
    private static final Comparator<MessageSequence> Comparator;
    private final long sequenceNumber;
    private final long subSequenceNumber;
    public static final Companion Companion = new Companion(null);
    private static final MessageSequence empty = new MessageSequence(0, 0);

    public static /* synthetic */ MessageSequence copy$default(MessageSequence messageSequence, long j2, long j3, int i, Object obj) {
        if ((i & 1) != 0) {
            j2 = messageSequence.sequenceNumber;
        }
        if ((i & 2) != 0) {
            j3 = messageSequence.subSequenceNumber;
        }
        return messageSequence.copy(j2, j3);
    }

    public final long component1() {
        return this.sequenceNumber;
    }

    public final long component2() {
        return this.subSequenceNumber;
    }

    public final MessageSequence copy(long j2, long j3) {
        return new MessageSequence(j2, j3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MessageSequence) {
            MessageSequence messageSequence = (MessageSequence) obj;
            return this.sequenceNumber == messageSequence.sequenceNumber && this.subSequenceNumber == messageSequence.subSequenceNumber;
        }
        return false;
    }

    public int hashCode() {
        return (ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.sequenceNumber) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.subSequenceNumber);
    }

    public String toString() {
        long j2 = this.sequenceNumber;
        return "MessageSequence(sequenceNumber=" + j2 + ", subSequenceNumber=" + this.subSequenceNumber + ")";
    }

    public /* synthetic */ MessageSequence(int seen0, long sequenceNumber, long subSequenceNumber, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (seen0 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 1, MessageSequence$$serializer.INSTANCE.getDescriptor());
        }
        this.sequenceNumber = sequenceNumber;
        if ((seen0 & 2) == 0) {
            this.subSequenceNumber = 0L;
        } else {
            this.subSequenceNumber = subSequenceNumber;
        }
    }

    public MessageSequence(long sequenceNumber, long subSequenceNumber) {
        this.sequenceNumber = sequenceNumber;
        this.subSequenceNumber = subSequenceNumber;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_debug(MessageSequence self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.sequenceNumber);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.subSequenceNumber != 0) {
            output.encodeLongElement(serialDesc, 1, self.subSequenceNumber);
        }
    }

    public /* synthetic */ MessageSequence(long j2, long j3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j2, (i & 2) != 0 ? 0L : j3);
    }

    public final long getSequenceNumber() {
        return this.sequenceNumber;
    }

    public final long getSubSequenceNumber() {
        return this.subSequenceNumber;
    }

    /* compiled from: Message.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R!\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\tj\b\u0012\u0004\u0012\u00020\u0005`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lkntr/app/im/chat/core/model/MessageSequence$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "empty", "Lkntr/app/im/chat/core/model/MessageSequence;", "getEmpty", "()Lkntr/app/im/chat/core/model/MessageSequence;", "Comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "getComparator", "()Ljava/util/Comparator;", "serializer", "Lkotlinx/serialization/KSerializer;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<MessageSequence> serializer() {
            return MessageSequence$$serializer.INSTANCE;
        }

        public final MessageSequence getEmpty() {
            return MessageSequence.empty;
        }

        public final Comparator<MessageSequence> getComparator() {
            return MessageSequence.Comparator;
        }
    }

    static {
        final Comparator comparator = new Comparator() { // from class: kntr.app.im.chat.core.model.MessageSequence$special$$inlined$compareBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                MessageSequence it = (MessageSequence) t;
                MessageSequence it2 = (MessageSequence) t2;
                return ComparisonsKt.compareValues(Long.valueOf(it.getSequenceNumber()), Long.valueOf(it2.getSequenceNumber()));
            }
        };
        Comparator = new Comparator() { // from class: kntr.app.im.chat.core.model.MessageSequence$special$$inlined$thenBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int previousCompare = comparator.compare(t, t2);
                if (previousCompare != 0) {
                    return previousCompare;
                }
                MessageSequence it = (MessageSequence) t;
                MessageSequence it2 = (MessageSequence) t2;
                return ComparisonsKt.compareValues(Long.valueOf(it.getSubSequenceNumber()), Long.valueOf(it2.getSubSequenceNumber()));
            }
        };
    }

    public static /* synthetic */ MessageSequence nextSendSequence$default(MessageSequence messageSequence, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j2 = 1;
        }
        return messageSequence.nextSendSequence(j2);
    }

    public final MessageSequence nextSendSequence(long subDiff) {
        return new MessageSequence(this.sequenceNumber, this.subSequenceNumber + subDiff);
    }

    @Override // java.lang.Comparable
    public int compareTo(MessageSequence other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return Comparator.compare(this, other);
    }

    public final boolean isLocalSequence() {
        return this.subSequenceNumber > 0;
    }
}