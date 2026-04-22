package kntr.app.im.chat.module.notifyText;

import com.bapis.bilibili.app.im.v1.KMsgModule;
import com.bapis.bilibili.app.im.v1.KMsgModule$KHintTextModule$;
import kntr.app.game.base.ui.widget.gameaction.state.GameActionStateKt;
import kntr.app.im.chat.core.model.MessageSequence;
import kntr.app.im.chat.core.model.MessageSequence$$serializer;
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
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: HintTextModule.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/im/chat/module/notifyText/HintTextModule.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/im/chat/module/notifyText/HintTextModule;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class HintTextModule$$serializer implements GeneratedSerializer<HintTextModule> {
    public static final int $stable;
    public static final HintTextModule$$serializer INSTANCE = new HintTextModule$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.im.chat.module.notifyText.HintTextModule", INSTANCE, 3);
        pluginGeneratedSerialDescriptor.addElement("value", false);
        pluginGeneratedSerialDescriptor.addElement("relatedMessage", true);
        pluginGeneratedSerialDescriptor.addElement("relatedTimeStamp", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private HintTextModule$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = HintTextModule.$childSerializers;
        return new KSerializer[]{KMsgModule$KHintTextModule$.serializer.INSTANCE, BuiltinSerializersKt.getNullable(MessageSequence$$serializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[2].getValue())};
    }

    public final HintTextModule deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        int i;
        KMsgModule.KHintTextModule kHintTextModule;
        MessageSequence messageSequence;
        Instant instant;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = HintTextModule.$childSerializers;
        KMsgModule.KHintTextModule kHintTextModule2 = null;
        if (beginStructure.decodeSequentially()) {
            kHintTextModule = (KMsgModule.KHintTextModule) beginStructure.decodeSerializableElement(serialDescriptor, 0, KMsgModule$KHintTextModule$.serializer.INSTANCE, (Object) null);
            MessageSequence messageSequence2 = (MessageSequence) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MessageSequence$$serializer.INSTANCE, (Object) null);
            instant = (Instant) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), (Object) null);
            i = 7;
            messageSequence = messageSequence2;
        } else {
            boolean z = true;
            int i2 = 0;
            MessageSequence messageSequence3 = null;
            Instant instant2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z = false;
                        break;
                    case 0:
                        kHintTextModule2 = (KMsgModule.KHintTextModule) beginStructure.decodeSerializableElement(serialDescriptor, 0, KMsgModule$KHintTextModule$.serializer.INSTANCE, kHintTextModule2);
                        i2 |= 1;
                        break;
                    case 1:
                        messageSequence3 = (MessageSequence) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, MessageSequence$$serializer.INSTANCE, messageSequence3);
                        i2 |= 2;
                        break;
                    case 2:
                        instant2 = (Instant) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), instant2);
                        i2 |= 4;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i2;
            kHintTextModule = kHintTextModule2;
            messageSequence = messageSequence3;
            instant = instant2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new HintTextModule(i, kHintTextModule, messageSequence, instant, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, HintTextModule value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        HintTextModule.write$Self$biz_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}