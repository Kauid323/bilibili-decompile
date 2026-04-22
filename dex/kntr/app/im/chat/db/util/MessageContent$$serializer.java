package kntr.app.im.chat.db.util;

import com.bapis.bilibili.app.im.v1.KEntityMsgType;
import com.bapis.bilibili.app.im.v1.KEntityMsgTypeSerializer;
import java.util.Map;
import kntr.app.game.base.ui.widget.gameaction.state.GameActionStateKt;
import kntr.app.im.chat.core.model.MsgFrame;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.Instant;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: EntityMessageExt.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/im/chat/db/util/MessageContent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/im/chat/db/util/MessageContent;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "db_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class MessageContent$$serializer implements GeneratedSerializer<MessageContent> {
    public static final MessageContent$$serializer INSTANCE = new MessageContent$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.im.chat.db.util.MessageContent", INSTANCE, 4);
        pluginGeneratedSerialDescriptor.addElement("msgType", false);
        pluginGeneratedSerialDescriptor.addElement("msgFrame", false);
        pluginGeneratedSerialDescriptor.addElement("timestamp", false);
        pluginGeneratedSerialDescriptor.addElement("traceParams", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private MessageContent$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = MessageContent.$childSerializers;
        return new KSerializer[]{KEntityMsgTypeSerializer.INSTANCE, lazyArr[1].getValue(), lazyArr[2].getValue(), lazyArr[3].getValue()};
    }

    public final MessageContent deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        int i;
        KEntityMsgType kEntityMsgType;
        MsgFrame msgFrame;
        Instant instant;
        Map map;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = MessageContent.$childSerializers;
        KEntityMsgType kEntityMsgType2 = null;
        if (beginStructure.decodeSequentially()) {
            kEntityMsgType = (KEntityMsgType) beginStructure.decodeSerializableElement(serialDescriptor, 0, KEntityMsgTypeSerializer.INSTANCE, (Object) null);
            MsgFrame msgFrame2 = (MsgFrame) beginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), (Object) null);
            instant = (Instant) beginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), (Object) null);
            map = (Map) beginStructure.decodeSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), (Object) null);
            i = 15;
            msgFrame = msgFrame2;
        } else {
            boolean z = true;
            int i2 = 0;
            MsgFrame msgFrame3 = null;
            Instant instant2 = null;
            Map map2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z = false;
                        break;
                    case 0:
                        kEntityMsgType2 = (KEntityMsgType) beginStructure.decodeSerializableElement(serialDescriptor, 0, KEntityMsgTypeSerializer.INSTANCE, kEntityMsgType2);
                        i2 |= 1;
                        break;
                    case 1:
                        msgFrame3 = (MsgFrame) beginStructure.decodeSerializableElement(serialDescriptor, 1, (DeserializationStrategy) lazyArr[1].getValue(), msgFrame3);
                        i2 |= 2;
                        break;
                    case 2:
                        instant2 = (Instant) beginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), instant2);
                        i2 |= 4;
                        break;
                    case 3:
                        map2 = (Map) beginStructure.decodeSerializableElement(serialDescriptor, 3, (DeserializationStrategy) lazyArr[3].getValue(), map2);
                        i2 |= 8;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i2;
            kEntityMsgType = kEntityMsgType2;
            msgFrame = msgFrame3;
            instant = instant2;
            map = map2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new MessageContent(i, kEntityMsgType, msgFrame, instant, map, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, MessageContent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        MessageContent.write$Self$db_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}