package im.contact.model;

import com.tencent.smtt.sdk.TbsListener;
import faceverify.w;
import im.base.model.AvatarHolder;
import im.base.model.NameRenderHolder;
import im.base.model.NameRenderSerializer;
import io.ktor.http.ContentDisposition;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.protobuf.ProtoNumber;

/* compiled from: IMContactItem.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"im/contact/model/IMContactItem.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lim/contact/model/IMContactItem;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "contact_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class IMContactItem$$serializer implements GeneratedSerializer<IMContactItem> {
    public static final IMContactItem$$serializer INSTANCE = new IMContactItem$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("im.contact.model.IMContactItem", INSTANCE, 10);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.contact.model.IMContactItem$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.addElement(ContentDisposition.Parameters.Name, true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.contact.model.IMContactItem$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.addElement("avatar", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.contact.model.IMContactItem$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.addElement("vipInfo", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.contact.model.IMContactItem$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.addElement("url", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.contact.model.IMContactItem$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.addElement("nameRender", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.contact.model.IMContactItem$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.addElement("isSpecialFollow", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.contact.model.IMContactItem$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.addElement(w.BLOB_ELEM_TYPE_FACE, true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.contact.model.IMContactItem$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.addElement("officialType", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.contact.model.IMContactItem$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.addElement("identifier", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private IMContactItem$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = IMContactItem.$childSerializers;
        return new KSerializer[]{LongSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable((KSerializer) lazyArr[2].getValue()), StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(NameRenderSerializer.INSTANCE), BooleanSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE};
    }

    /* renamed from: deserialize */
    public final IMContactItem m3158deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        NameRenderHolder nameRenderHolder;
        int i2;
        int i3;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean z;
        AvatarHolder avatarHolder;
        long j;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = IMContactItem.$childSerializers;
        int i4 = 9;
        int i5 = 7;
        int i6 = 0;
        if (beginStructure.decodeSequentially()) {
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 0);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 1);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 3);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 4);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 6);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 7);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 8);
            avatarHolder = (AvatarHolder) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), (Object) null);
            str = decodeStringElement;
            str5 = beginStructure.decodeStringElement(serialDescriptor, 9);
            str4 = decodeStringElement4;
            z = decodeBooleanElement;
            nameRenderHolder = (NameRenderHolder) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, NameRenderSerializer.INSTANCE, (Object) null);
            i3 = decodeIntElement;
            str2 = decodeStringElement2;
            str3 = decodeStringElement3;
            i2 = 1023;
            j = decodeLongElement;
        } else {
            boolean z2 = true;
            boolean z3 = false;
            NameRenderHolder nameRenderHolder2 = null;
            AvatarHolder avatarHolder2 = null;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            long j2 = 0;
            String str10 = null;
            int i7 = 0;
            while (z2) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z2 = false;
                        i4 = 9;
                        i5 = 7;
                        break;
                    case 0:
                        j2 = beginStructure.decodeLongElement(serialDescriptor, 0);
                        i6 |= 1;
                        i4 = 9;
                        i5 = 7;
                        break;
                    case 1:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i6 |= 2;
                        i4 = 9;
                        i5 = 7;
                        break;
                    case 2:
                        avatarHolder2 = (AvatarHolder) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), avatarHolder2);
                        i6 |= 4;
                        i4 = 9;
                        i5 = 7;
                        break;
                    case 3:
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i6 |= 8;
                        break;
                    case 4:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i6 |= 16;
                        break;
                    case 5:
                        nameRenderHolder2 = (NameRenderHolder) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, NameRenderSerializer.INSTANCE, nameRenderHolder2);
                        i6 |= 32;
                        break;
                    case 6:
                        z3 = beginStructure.decodeBooleanElement(serialDescriptor, 6);
                        i6 |= 64;
                        break;
                    case 7:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, i5);
                        i6 |= 128;
                        break;
                    case 8:
                        i7 = beginStructure.decodeIntElement(serialDescriptor, 8);
                        i6 |= 256;
                        break;
                    case 9:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, i4);
                        i6 |= 512;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            nameRenderHolder = nameRenderHolder2;
            i2 = i6;
            i3 = i7;
            str = str10;
            str2 = str6;
            str3 = str7;
            str4 = str8;
            str5 = str9;
            z = z3;
            avatarHolder = avatarHolder2;
            j = j2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new IMContactItem(i2, j, str, avatarHolder, str2, str3, nameRenderHolder, z, str4, i3, str5, null);
    }

    public final void serialize(Encoder encoder, IMContactItem value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        IMContactItem.write$Self$contact_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}