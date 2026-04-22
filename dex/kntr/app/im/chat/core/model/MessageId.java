package kntr.app.im.chat.core.model;

import ComposableSingletons$CustomBottomSheetKt$;
import com.bapis.bilibili.app.im.v1.KMsgId;
import im.base.model.SessionId;
import java.lang.annotation.Annotation;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: Message.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 02\u00020\u0001:\u000201B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\fB7\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\b\u0010\u0011J\u0006\u0010\u0018\u001a\u00020\u0019J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0007HÆ\u0003J'\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010#\u001a\u00020\u001d2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u000eHÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001J%\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0001¢\u0006\u0002\b/R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001e¨\u00062"}, d2 = {"Lkntr/app/im/chat/core/model/MessageId;", RoomRecommendViewModel.EMPTY_CURSOR, "sessionId", "Lim/base/model/SessionId;", "msgKey", RoomRecommendViewModel.EMPTY_CURSOR, "sequence", "Lkntr/app/im/chat/core/model/MessageSequence;", "<init>", "(Lim/base/model/SessionId;JLkntr/app/im/chat/core/model/MessageSequence;)V", "sequenceNumber", "subSequenceNumber", "(Lim/base/model/SessionId;JJJ)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILim/base/model/SessionId;JLkntr/app/im/chat/core/model/MessageSequence;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getSessionId", "()Lim/base/model/SessionId;", "getMsgKey", "()J", "getSequence", "()Lkntr/app/im/chat/core/model/MessageSequence;", "asKMsgId", "Lcom/bapis/bilibili/app/im/v1/KMsgId;", "getSequenceNumber", "getSubSequenceNumber", "isLocalMessage", RoomRecommendViewModel.EMPTY_CURSOR, "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", RoomRecommendViewModel.EMPTY_CURSOR, "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$core_debug", "Companion", "$serializer", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class MessageId {
    public static final int $stable = 0;
    private final long msgKey;
    private final MessageSequence sequence;
    private final SessionId sessionId;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.im.chat.core.model.MessageId$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = MessageId._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), null, null};
    private static final MessageId empty = new MessageId(SessionId.Unknown.INSTANCE, 0, MessageSequence.Companion.getEmpty());

    public static /* synthetic */ MessageId copy$default(MessageId messageId, SessionId sessionId, long j2, MessageSequence messageSequence, int i, Object obj) {
        if ((i & 1) != 0) {
            sessionId = messageId.sessionId;
        }
        if ((i & 2) != 0) {
            j2 = messageId.msgKey;
        }
        if ((i & 4) != 0) {
            messageSequence = messageId.sequence;
        }
        return messageId.copy(sessionId, j2, messageSequence);
    }

    public final SessionId component1() {
        return this.sessionId;
    }

    public final long component2() {
        return this.msgKey;
    }

    public final MessageSequence component3() {
        return this.sequence;
    }

    public final MessageId copy(SessionId sessionId, long j2, MessageSequence messageSequence) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(messageSequence, "sequence");
        return new MessageId(sessionId, j2, messageSequence);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MessageId) {
            MessageId messageId = (MessageId) obj;
            return Intrinsics.areEqual(this.sessionId, messageId.sessionId) && this.msgKey == messageId.msgKey && Intrinsics.areEqual(this.sequence, messageId.sequence);
        }
        return false;
    }

    public int hashCode() {
        return (((this.sessionId.hashCode() * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.msgKey)) * 31) + this.sequence.hashCode();
    }

    public String toString() {
        SessionId sessionId = this.sessionId;
        long j2 = this.msgKey;
        return "MessageId(sessionId=" + sessionId + ", msgKey=" + j2 + ", sequence=" + this.sequence + ")";
    }

    public /* synthetic */ MessageId(int seen0, SessionId sessionId, long msgKey, MessageSequence sequence, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (seen0 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 7, MessageId$$serializer.INSTANCE.getDescriptor());
        }
        this.sessionId = sessionId;
        this.msgKey = msgKey;
        this.sequence = sequence;
    }

    public MessageId(SessionId sessionId, long msgKey, MessageSequence sequence) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(sequence, "sequence");
        this.sessionId = sessionId;
        this.msgKey = msgKey;
        this.sequence = sequence;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(SessionId.class), new Annotation[0]);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$core_debug(MessageId self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy) $childSerializers[0].getValue(), self.sessionId);
        output.encodeLongElement(serialDesc, 1, self.msgKey);
        output.encodeSerializableElement(serialDesc, 2, MessageSequence$$serializer.INSTANCE, self.sequence);
    }

    public final SessionId getSessionId() {
        return this.sessionId;
    }

    public final long getMsgKey() {
        return this.msgKey;
    }

    public final MessageSequence getSequence() {
        return this.sequence;
    }

    /* compiled from: Message.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lkntr/app/im/chat/core/model/MessageId$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "empty", "Lkntr/app/im/chat/core/model/MessageId;", "getEmpty", "()Lkntr/app/im/chat/core/model/MessageId;", "serializer", "Lkotlinx/serialization/KSerializer;", "core_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<MessageId> serializer() {
            return MessageId$$serializer.INSTANCE;
        }

        public final MessageId getEmpty() {
            return MessageId.empty;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ MessageId(SessionId sessionId, long j2, long j3, long j4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(sessionId, j2, j3, r8);
        long j5;
        if ((i & 8) == 0) {
            j5 = j4;
        } else {
            j5 = 0;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MessageId(SessionId sessionId, long msgKey, long sequenceNumber, long subSequenceNumber) {
        this(sessionId, msgKey, new MessageSequence(sequenceNumber, subSequenceNumber));
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
    }

    public final KMsgId asKMsgId() {
        return new KMsgId(this.msgKey, getSequenceNumber(), 0L, 4, (DefaultConstructorMarker) null);
    }

    public final long getSequenceNumber() {
        return this.sequence.getSequenceNumber();
    }

    public final long getSubSequenceNumber() {
        return this.sequence.getSubSequenceNumber();
    }

    public final boolean isLocalMessage() {
        return this.sequence.isLocalSequence();
    }
}