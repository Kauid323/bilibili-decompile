package im.session.model;

import com.bapis.bilibili.app.im.v1.KUserLabel;
import com.bapis.bilibili.app.im.v1.KUserLabel$;
import com.tencent.smtt.sdk.TbsListener;
import im.base.model.AvatarHolder;
import im.base.model.NameRenderHolder;
import im.base.model.NameRenderSerializer;
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
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.protobuf.ProtoNumber;

/* compiled from: IMSessionInfo.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"im/session/model/IMSessionInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lim/session/model/IMSessionInfo;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class IMSessionInfo$$serializer implements GeneratedSerializer<IMSessionInfo> {
    public static final IMSessionInfo$$serializer INSTANCE = new IMSessionInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("im.session.model.IMSessionInfo", INSTANCE, 7);
        pluginGeneratedSerialDescriptor.addElement("sessionName", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.session.model.IMSessionInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.session.model.IMSessionInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.session.model.IMSessionInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.session.model.IMSessionInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.addElement("userLabel", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.session.model.IMSessionInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.addElement("isLive", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.session.model.IMSessionInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.addElement("sessionHandle", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.session.model.IMSessionInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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

    private IMSessionInfo$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = IMSessionInfo.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(NameRenderSerializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[2].getValue()), StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(KUserLabel$.serializer.INSTANCE), BooleanSerializer.INSTANCE, StringSerializer.INSTANCE};
    }

    /* renamed from: deserialize */
    public final IMSessionInfo m3330deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        String str;
        NameRenderHolder nameRenderHolder;
        AvatarHolder avatarHolder;
        String str2;
        int i2;
        KUserLabel kUserLabel;
        String str3;
        boolean z;
        boolean z2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = IMSessionInfo.$childSerializers;
        int i3 = 6;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 3);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 5);
            avatarHolder = (AvatarHolder) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), (Object) null);
            str = decodeStringElement;
            str3 = beginStructure.decodeStringElement(serialDescriptor, 6);
            z = decodeBooleanElement;
            str2 = decodeStringElement2;
            kUserLabel = (KUserLabel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, KUserLabel$.serializer.INSTANCE, (Object) null);
            i2 = 127;
            nameRenderHolder = (NameRenderHolder) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, NameRenderSerializer.INSTANCE, (Object) null);
        } else {
            boolean z3 = true;
            boolean z4 = false;
            str = null;
            nameRenderHolder = null;
            avatarHolder = null;
            str2 = null;
            String str4 = null;
            KUserLabel kUserLabel2 = null;
            i2 = 0;
            while (z3) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z2 = true;
                        z3 = false;
                        i3 = 6;
                    case 0:
                        z2 = true;
                        str = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i2 |= 1;
                        i3 = 6;
                    case 1:
                        z2 = true;
                        nameRenderHolder = (NameRenderHolder) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, NameRenderSerializer.INSTANCE, nameRenderHolder);
                        i2 |= 2;
                        i3 = 6;
                    case 2:
                        avatarHolder = (AvatarHolder) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), avatarHolder);
                        i2 |= 4;
                    case 3:
                        str2 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i2 |= 8;
                    case 4:
                        kUserLabel2 = (KUserLabel) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, KUserLabel$.serializer.INSTANCE, kUserLabel2);
                        i2 |= 16;
                    case 5:
                        z4 = beginStructure.decodeBooleanElement(serialDescriptor, 5);
                        i2 |= 32;
                    case 6:
                        str4 = beginStructure.decodeStringElement(serialDescriptor, i3);
                        i2 |= 64;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            kUserLabel = kUserLabel2;
            str3 = str4;
            z = z4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new IMSessionInfo(i2, str, nameRenderHolder, avatarHolder, str2, kUserLabel, z, str3, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, IMSessionInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        IMSessionInfo.write$Self$session_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}