package im.session.model;

import com.bapis.bilibili.app.im.v1.KQuickLinkBubble;
import com.bapis.bilibili.app.im.v1.KQuickLinkBubble$;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.protobuf.ProtoPacked;

/* compiled from: IMQuickLink.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"im/session/model/IMQuickLink.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lim/session/model/IMQuickLink;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class IMQuickLink$$serializer implements GeneratedSerializer<IMQuickLink> {
    public static final IMQuickLink$$serializer INSTANCE = new IMQuickLink$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("im.session.model.IMQuickLink", INSTANCE, 3);
        pluginGeneratedSerialDescriptor.addElement("items", false);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new IMQuickLink$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(1));
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoPacked() { // from class: im.session.model.IMQuickLink$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoPacked$0
            public final /* synthetic */ Class annotationType() {
                return ProtoPacked.class;
            }

            public final boolean equals(Object obj) {
                if (obj instanceof ProtoPacked) {
                    ProtoPacked protoPacked = (ProtoPacked) obj;
                    return true;
                }
                return false;
            }

            public final int hashCode() {
                return 0;
            }

            public final String toString() {
                return "@kotlinx.serialization.protobuf.ProtoPacked()";
            }
        });
        pluginGeneratedSerialDescriptor.addElement("bubble", false);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new IMQuickLink$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(2));
        pluginGeneratedSerialDescriptor.addElement("isLegacyStyle", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new IMQuickLink$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(3));
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private IMQuickLink$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = IMQuickLink.$childSerializers;
        return new KSerializer[]{lazyArr[0].getValue(), BuiltinSerializersKt.getNullable(KQuickLinkBubble$.serializer.INSTANCE), BooleanSerializer.INSTANCE};
    }

    /* renamed from: deserialize */
    public final IMQuickLink m3322deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        boolean z;
        int i2;
        List list;
        KQuickLinkBubble kQuickLinkBubble;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = IMQuickLink.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            KQuickLinkBubble kQuickLinkBubble2 = (KQuickLinkBubble) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, KQuickLinkBubble$.serializer.INSTANCE, (Object) null);
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), (Object) null);
            i2 = 7;
            z = beginStructure.decodeBooleanElement(serialDescriptor, 2);
            kQuickLinkBubble = kQuickLinkBubble2;
        } else {
            boolean z2 = true;
            boolean z3 = false;
            List list2 = null;
            KQuickLinkBubble kQuickLinkBubble3 = null;
            int i3 = 0;
            while (z2) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z2 = false;
                        break;
                    case 0:
                        list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), list2);
                        i3 |= 1;
                        break;
                    case 1:
                        kQuickLinkBubble3 = (KQuickLinkBubble) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, KQuickLinkBubble$.serializer.INSTANCE, kQuickLinkBubble3);
                        i3 |= 2;
                        break;
                    case 2:
                        z3 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                        i3 |= 4;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            z = z3;
            i2 = i3;
            list = list2;
            kQuickLinkBubble = kQuickLinkBubble3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new IMQuickLink(i2, list, kQuickLinkBubble, z, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, IMQuickLink value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        IMQuickLink.write$Self$session_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}