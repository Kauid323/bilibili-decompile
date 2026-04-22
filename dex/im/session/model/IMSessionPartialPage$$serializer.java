package im.session.model;

import com.bapis.bilibili.app.im.v1.KUpdateSessionParams;
import com.bapis.bilibili.app.im.v1.KUpdateSessionParams$;
import com.tencent.smtt.sdk.TbsListener;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.protobuf.ProtoNumber;
import kotlinx.serialization.protobuf.ProtoPacked;

/* compiled from: IMSessionPartialPage.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"im/session/model/IMSessionPartialPage.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lim/session/model/IMSessionPartialPage;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class IMSessionPartialPage$$serializer implements GeneratedSerializer<IMSessionPartialPage> {
    public static final IMSessionPartialPage$$serializer INSTANCE = new IMSessionPartialPage$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("im.session.model.IMSessionPartialPage", INSTANCE, 2);
        pluginGeneratedSerialDescriptor.addElement("items", false);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.session.model.IMSessionPartialPage$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
            public final /* synthetic */ Class annotationType() {
                return ProtoNumber.class;
            }

            public final boolean equals(Object obj) {
                return (obj instanceof ProtoNumber) && number() == ((ProtoNumber) obj).number();
            }

            public final int hashCode() {
                return ("number".hashCode() * TbsListener.ErrorCode.STARTDOWNLOAD_OUT_OF_MAXTIME) ^ r1;
            }

            public final /* synthetic */ int number() {
                return r1;
            }

            public final String toString() {
                return "@kotlinx.serialization.protobuf.ProtoNumber(number=" + r1 + ")";
            }
        });
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoPacked() { // from class: im.session.model.IMSessionPartialPage$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoPacked$0
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
        pluginGeneratedSerialDescriptor.addElement("updateSessionParams", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.session.model.IMSessionPartialPage$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
            public final /* synthetic */ Class annotationType() {
                return ProtoNumber.class;
            }

            public final boolean equals(Object obj) {
                return (obj instanceof ProtoNumber) && number() == ((ProtoNumber) obj).number();
            }

            public final int hashCode() {
                return ("number".hashCode() * TbsListener.ErrorCode.STARTDOWNLOAD_OUT_OF_MAXTIME) ^ r1;
            }

            public final /* synthetic */ int number() {
                return r1;
            }

            public final String toString() {
                return "@kotlinx.serialization.protobuf.ProtoNumber(number=" + r1 + ")";
            }
        });
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private IMSessionPartialPage$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = IMSessionPartialPage.$childSerializers;
        return new KSerializer[]{lazyArr[0].getValue(), BuiltinSerializersKt.getNullable(KUpdateSessionParams$.serializer.INSTANCE)};
    }

    /* renamed from: deserialize */
    public final IMSessionPartialPage m3333deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        List list;
        KUpdateSessionParams kUpdateSessionParams;
        int i2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = IMSessionPartialPage.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), (Object) null);
            kUpdateSessionParams = (KUpdateSessionParams) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, KUpdateSessionParams$.serializer.INSTANCE, (Object) null);
            i2 = 3;
        } else {
            boolean z = true;
            int i3 = 0;
            List list2 = null;
            KUpdateSessionParams kUpdateSessionParams2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        break;
                    case 0:
                        list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), list2);
                        i3 |= 1;
                        break;
                    case 1:
                        kUpdateSessionParams2 = (KUpdateSessionParams) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, KUpdateSessionParams$.serializer.INSTANCE, kUpdateSessionParams2);
                        i3 |= 2;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            list = list2;
            kUpdateSessionParams = kUpdateSessionParams2;
            i2 = i3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new IMSessionPartialPage(i2, list, kUpdateSessionParams, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, IMSessionPartialPage value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        IMSessionPartialPage.write$Self$session_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}