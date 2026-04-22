package im.session.model;

import com.bapis.bilibili.app.im.v1.KMsgSummary;
import com.bapis.bilibili.app.im.v1.KMsgSummary$;
import com.bapis.bilibili.app.im.v1.KSessionId;
import com.bapis.bilibili.app.im.v1.KSessionIdSerializer;
import com.bapis.bilibili.app.im.v1.KSessionOperation;
import com.bapis.bilibili.app.im.v1.KSessionOperation$;
import com.bapis.bilibili.app.im.v1.KUnread;
import com.bapis.bilibili.app.im.v1.KUnread$;
import com.bilibili.lib.brouter.uri.Uri;
import com.tencent.smtt.sdk.TbsListener;
import im.session.service.Summary;
import im.session.service.Summary$$serializer;
import io.ktor.client.utils.CIOKt;
import java.util.Map;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.protobuf.ProtoNumber;
import kotlinx.serialization.protobuf.ProtoPacked;

/* compiled from: IMSessionCard.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"im/session/model/IMSessionCard.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lim/session/model/IMSessionCard;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class IMSessionCard$$serializer implements GeneratedSerializer<IMSessionCard> {
    public static final IMSessionCard$$serializer INSTANCE = new IMSessionCard$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("im.session.model.IMSessionCard", INSTANCE, 13);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.session.model.IMSessionCard$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.addElement("sessionInfo", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.session.model.IMSessionCard$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.addElement("unread", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.session.model.IMSessionCard$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.addElement("msgSummary", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.session.model.IMSessionCard$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.addElement("timestamp", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.session.model.IMSessionCard$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.addElement("isPinned", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.session.model.IMSessionCard$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.addElement("sequenceNumber", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.session.model.IMSessionCard$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.addElement("isMuted", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.session.model.IMSessionCard$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.addElement("chatURL", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.session.model.IMSessionCard$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.addElement("operation", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.session.model.IMSessionCard$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.addElement("traceParams", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.session.model.IMSessionCard$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoPacked() { // from class: im.session.model.IMSessionCard$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoPacked$0
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
        pluginGeneratedSerialDescriptor.addElement("clientSummary", true);
        pluginGeneratedSerialDescriptor.pushAnnotation(new ProtoNumber() { // from class: im.session.model.IMSessionCard$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0
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
        pluginGeneratedSerialDescriptor.addElement("urlWithParam", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private IMSessionCard$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = IMSessionCard.$childSerializers;
        return new KSerializer[]{KSessionIdSerializer.INSTANCE, BuiltinSerializersKt.getNullable(IMSessionInfo$$serializer.INSTANCE), KUnread$.serializer.INSTANCE, BuiltinSerializersKt.getNullable(KMsgSummary$.serializer.INSTANCE), lazyArr[4].getValue(), BooleanSerializer.INSTANCE, LongSerializer.INSTANCE, BooleanSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(KSessionOperation$.serializer.INSTANCE), lazyArr[10].getValue(), BuiltinSerializersKt.getNullable(Summary$$serializer.INSTANCE), lazyArr[12].getValue()};
    }

    /* renamed from: deserialize */
    public final IMSessionCard m3326deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        boolean z;
        Uri uri;
        Summary summary;
        Map map;
        Instant instant;
        KMsgSummary kMsgSummary;
        boolean z2;
        String str;
        long j;
        KUnread kUnread;
        int i2;
        KSessionOperation kSessionOperation;
        KSessionId kSessionId;
        IMSessionInfo iMSessionInfo;
        boolean z3;
        boolean z4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = IMSessionCard.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 5);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 6);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 7);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 8);
            summary = (Summary) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, Summary$$serializer.INSTANCE, (Object) null);
            uri = (Uri) beginStructure.decodeSerializableElement(serialDescriptor, 12, (DeserializationStrategy) lazyArr[12].getValue(), (Object) null);
            iMSessionInfo = (IMSessionInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, IMSessionInfo$$serializer.INSTANCE, (Object) null);
            kSessionOperation = (KSessionOperation) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, KSessionOperation$.serializer.INSTANCE, (Object) null);
            z2 = decodeBooleanElement2;
            str = decodeStringElement;
            kMsgSummary = (KMsgSummary) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, KMsgSummary$.serializer.INSTANCE, (Object) null);
            map = (Map) beginStructure.decodeSerializableElement(serialDescriptor, 10, (DeserializationStrategy) lazyArr[10].getValue(), (Object) null);
            kUnread = (KUnread) beginStructure.decodeSerializableElement(serialDescriptor, 2, KUnread$.serializer.INSTANCE, (Object) null);
            instant = (Instant) beginStructure.decodeSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), (Object) null);
            i2 = 8191;
            j = decodeLongElement;
            kSessionId = (KSessionId) beginStructure.decodeSerializableElement(serialDescriptor, 0, KSessionIdSerializer.INSTANCE, (Object) null);
            z = decodeBooleanElement;
        } else {
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = true;
            Uri uri2 = null;
            Summary summary2 = null;
            Map map2 = null;
            Instant instant2 = null;
            KMsgSummary kMsgSummary2 = null;
            KUnread kUnread2 = null;
            KSessionOperation kSessionOperation2 = null;
            KSessionId kSessionId2 = null;
            String str2 = null;
            long j2 = 0;
            IMSessionInfo iMSessionInfo2 = null;
            int i3 = 0;
            while (z7) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z3 = z5;
                        z7 = false;
                        z5 = z3;
                        break;
                    case 0:
                        z3 = z5;
                        kSessionId2 = (KSessionId) beginStructure.decodeSerializableElement(serialDescriptor, 0, KSessionIdSerializer.INSTANCE, kSessionId2);
                        i3 |= 1;
                        z5 = z3;
                        break;
                    case 1:
                        z3 = z5;
                        iMSessionInfo2 = (IMSessionInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, IMSessionInfo$$serializer.INSTANCE, iMSessionInfo2);
                        i3 |= 2;
                        z5 = z3;
                        break;
                    case 2:
                        z3 = z5;
                        kUnread2 = (KUnread) beginStructure.decodeSerializableElement(serialDescriptor, 2, KUnread$.serializer.INSTANCE, kUnread2);
                        i3 |= 4;
                        z5 = z3;
                        break;
                    case 3:
                        z3 = z5;
                        kMsgSummary2 = (KMsgSummary) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, KMsgSummary$.serializer.INSTANCE, kMsgSummary2);
                        i3 |= 8;
                        z5 = z3;
                        break;
                    case 4:
                        z3 = z5;
                        instant2 = (Instant) beginStructure.decodeSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), instant2);
                        i3 |= 16;
                        z5 = z3;
                        break;
                    case 5:
                        i3 |= 32;
                        z5 = z5;
                        z6 = beginStructure.decodeBooleanElement(serialDescriptor, 5);
                        break;
                    case 6:
                        z4 = z5;
                        j2 = beginStructure.decodeLongElement(serialDescriptor, 6);
                        i3 |= 64;
                        z5 = z4;
                        break;
                    case 7:
                        z4 = beginStructure.decodeBooleanElement(serialDescriptor, 7);
                        i3 |= 128;
                        z5 = z4;
                        break;
                    case 8:
                        str2 = beginStructure.decodeStringElement(serialDescriptor, 8);
                        i3 |= 256;
                        z5 = z5;
                        continue;
                    case 9:
                        z4 = z5;
                        kSessionOperation2 = (KSessionOperation) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, KSessionOperation$.serializer.INSTANCE, kSessionOperation2);
                        i3 |= 512;
                        z5 = z4;
                        break;
                    case 10:
                        z3 = z5;
                        map2 = (Map) beginStructure.decodeSerializableElement(serialDescriptor, 10, (DeserializationStrategy) lazyArr[10].getValue(), map2);
                        i3 |= 1024;
                        z5 = z3;
                        break;
                    case 11:
                        z3 = z5;
                        summary2 = (Summary) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, Summary$$serializer.INSTANCE, summary2);
                        i3 |= 2048;
                        z5 = z3;
                        break;
                    case 12:
                        uri2 = (Uri) beginStructure.decodeSerializableElement(serialDescriptor, 12, (DeserializationStrategy) lazyArr[12].getValue(), uri2);
                        i3 |= CIOKt.DEFAULT_HTTP_BUFFER_SIZE;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            z = z6;
            uri = uri2;
            summary = summary2;
            map = map2;
            instant = instant2;
            kMsgSummary = kMsgSummary2;
            z2 = z5;
            str = str2;
            j = j2;
            kUnread = kUnread2;
            i2 = i3;
            kSessionOperation = kSessionOperation2;
            kSessionId = kSessionId2;
            iMSessionInfo = iMSessionInfo2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new IMSessionCard(i2, kSessionId, iMSessionInfo, kUnread, kMsgSummary, instant, z, j, z2, str, kSessionOperation, map, summary, uri, null);
    }

    public final void serialize(Encoder encoder, IMSessionCard value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        IMSessionCard.write$Self$session_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}