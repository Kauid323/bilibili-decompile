package kntr.app.im.chat.db.util;

import com.bapis.bilibili.app.im.v1.KEntityMsgType;
import com.bapis.bilibili.app.im.v1.KEntityMsgTypeSerializer;
import im.base.serializer.InstantSecondsLongSerializer;
import java.lang.annotation.Annotation;
import java.util.Map;
import kntr.app.im.chat.core.model.MsgFrame;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.datetime.Instant;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: EntityMessageExt.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 /2\u00020\u0001:\u0002./B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fBO\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u000b\u0010\u0011J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u0015\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J=\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u000eHÖ\u0001J\t\u0010%\u001a\u00020\nHÖ\u0001J%\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0001¢\u0006\u0002\b-R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u00060"}, d2 = {"Lkntr/app/im/chat/db/util/MessageContent;", RoomRecommendViewModel.EMPTY_CURSOR, "msgType", "Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;", "msgFrame", "Lkntr/app/im/chat/core/model/MsgFrame;", "timestamp", "Lkotlinx/datetime/Instant;", "traceParams", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;Lkntr/app/im/chat/core/model/MsgFrame;Lkotlinx/datetime/Instant;Ljava/util/Map;)V", "seen0", RoomRecommendViewModel.EMPTY_CURSOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILcom/bapis/bilibili/app/im/v1/KEntityMsgType;Lkntr/app/im/chat/core/model/MsgFrame;Lkotlinx/datetime/Instant;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMsgType", "()Lcom/bapis/bilibili/app/im/v1/KEntityMsgType;", "getMsgFrame", "()Lkntr/app/im/chat/core/model/MsgFrame;", "getTimestamp$annotations", "()V", "getTimestamp", "()Lkotlinx/datetime/Instant;", "getTraceParams", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", RoomRecommendViewModel.EMPTY_CURSOR, "other", "hashCode", "toString", "write$Self", RoomRecommendViewModel.EMPTY_CURSOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$db_debug", "$serializer", "Companion", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
public final class MessageContent {
    private final MsgFrame msgFrame;
    private final KEntityMsgType msgType;
    private final Instant timestamp;
    private final Map<String, String> traceParams;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<KSerializer<Object>>[] $childSerializers = {null, LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.im.chat.db.util.MessageContent$$ExternalSyntheticLambda0
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_;
            _childSerializers$_anonymous_ = MessageContent._childSerializers$_anonymous_();
            return _childSerializers$_anonymous_;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.im.chat.db.util.MessageContent$$ExternalSyntheticLambda1
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$0;
            _childSerializers$_anonymous_$0 = MessageContent._childSerializers$_anonymous_$0();
            return _childSerializers$_anonymous_$0;
        }
    }), LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kntr.app.im.chat.db.util.MessageContent$$ExternalSyntheticLambda2
        public final Object invoke() {
            KSerializer _childSerializers$_anonymous_$1;
            _childSerializers$_anonymous_$1 = MessageContent._childSerializers$_anonymous_$1();
            return _childSerializers$_anonymous_$1;
        }
    })};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageContent copy$default(MessageContent messageContent, KEntityMsgType kEntityMsgType, MsgFrame msgFrame, Instant instant, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            kEntityMsgType = messageContent.msgType;
        }
        if ((i & 2) != 0) {
            msgFrame = messageContent.msgFrame;
        }
        if ((i & 4) != 0) {
            instant = messageContent.timestamp;
        }
        if ((i & 8) != 0) {
            map = messageContent.traceParams;
        }
        return messageContent.copy(kEntityMsgType, msgFrame, instant, map);
    }

    @Serializable(with = InstantSecondsLongSerializer.class)
    public static /* synthetic */ void getTimestamp$annotations() {
    }

    public final KEntityMsgType component1() {
        return this.msgType;
    }

    public final MsgFrame component2() {
        return this.msgFrame;
    }

    public final Instant component3() {
        return this.timestamp;
    }

    public final Map<String, String> component4() {
        return this.traceParams;
    }

    public final MessageContent copy(KEntityMsgType kEntityMsgType, MsgFrame msgFrame, Instant instant, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(kEntityMsgType, "msgType");
        Intrinsics.checkNotNullParameter(msgFrame, "msgFrame");
        Intrinsics.checkNotNullParameter(instant, "timestamp");
        Intrinsics.checkNotNullParameter(map, "traceParams");
        return new MessageContent(kEntityMsgType, msgFrame, instant, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MessageContent) {
            MessageContent messageContent = (MessageContent) obj;
            return Intrinsics.areEqual(this.msgType, messageContent.msgType) && Intrinsics.areEqual(this.msgFrame, messageContent.msgFrame) && Intrinsics.areEqual(this.timestamp, messageContent.timestamp) && Intrinsics.areEqual(this.traceParams, messageContent.traceParams);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.msgType.hashCode() * 31) + this.msgFrame.hashCode()) * 31) + this.timestamp.hashCode()) * 31) + this.traceParams.hashCode();
    }

    public String toString() {
        KEntityMsgType kEntityMsgType = this.msgType;
        MsgFrame msgFrame = this.msgFrame;
        Instant instant = this.timestamp;
        return "MessageContent(msgType=" + kEntityMsgType + ", msgFrame=" + msgFrame + ", timestamp=" + instant + ", traceParams=" + this.traceParams + ")";
    }

    /* compiled from: EntityMessageExt.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lkntr/app/im/chat/db/util/MessageContent$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lkntr/app/im/chat/db/util/MessageContent;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final KSerializer<MessageContent> serializer() {
            return MessageContent$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ MessageContent(int seen0, KEntityMsgType msgType, MsgFrame msgFrame, Instant timestamp, Map traceParams, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (seen0 & 7)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 7, MessageContent$$serializer.INSTANCE.getDescriptor());
        }
        this.msgType = msgType;
        this.msgFrame = msgFrame;
        this.timestamp = timestamp;
        if ((seen0 & 8) == 0) {
            this.traceParams = MapsKt.emptyMap();
        } else {
            this.traceParams = traceParams;
        }
    }

    public MessageContent(KEntityMsgType msgType, MsgFrame msgFrame, Instant timestamp, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(msgType, "msgType");
        Intrinsics.checkNotNullParameter(msgFrame, "msgFrame");
        Intrinsics.checkNotNullParameter(timestamp, "timestamp");
        Intrinsics.checkNotNullParameter(map, "traceParams");
        this.msgType = msgType;
        this.msgFrame = msgFrame;
        this.timestamp = timestamp;
        this.traceParams = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new PolymorphicSerializer(Reflection.getOrCreateKotlinClass(MsgFrame.class), new Annotation[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new InstantSecondsLongSerializer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$1() {
        return new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE);
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$db_debug(MessageContent self, CompositeEncoder output, SerialDescriptor serialDesc) {
        Lazy<KSerializer<Object>>[] lazyArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, KEntityMsgTypeSerializer.INSTANCE, self.msgType);
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) lazyArr[1].getValue(), self.msgFrame);
        output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy) lazyArr[2].getValue(), self.timestamp);
        if (output.shouldEncodeElementDefault(serialDesc, 3) || !Intrinsics.areEqual(self.traceParams, MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy) lazyArr[3].getValue(), self.traceParams);
        }
    }

    public /* synthetic */ MessageContent(KEntityMsgType kEntityMsgType, MsgFrame msgFrame, Instant instant, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kEntityMsgType, msgFrame, instant, (i & 8) != 0 ? MapsKt.emptyMap() : map);
    }

    public final KEntityMsgType getMsgType() {
        return this.msgType;
    }

    public final MsgFrame getMsgFrame() {
        return this.msgFrame;
    }

    public final Instant getTimestamp() {
        return this.timestamp;
    }

    public final Map<String, String> getTraceParams() {
        return this.traceParams;
    }
}