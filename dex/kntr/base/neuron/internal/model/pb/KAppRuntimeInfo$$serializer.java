package kntr.base.neuron.internal.model.pb;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import java.lang.annotation.Annotation;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.common.upper.trace.config.AppKey;
import kntr.common.upper.trace.config.CommonProjectType;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: info_raw.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/base/neuron/internal/model/pb/KAppRuntimeInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/base/neuron/internal/model/pb/KAppRuntimeInfo;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class KAppRuntimeInfo$$serializer implements GeneratedSerializer<KAppRuntimeInfo> {
    public static final KAppRuntimeInfo$$serializer INSTANCE = new KAppRuntimeInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.base.neuron.internal.model.pb.KAppRuntimeInfo", INSTANCE, 9);
        pluginGeneratedSerialDescriptor.addElement(CommonProjectType.NETWORK, true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(1));
        pluginGeneratedSerialDescriptor.addElement("oid", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(2));
        pluginGeneratedSerialDescriptor.addElement("longitude", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(3));
        pluginGeneratedSerialDescriptor.addElement("latitude", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(4));
        pluginGeneratedSerialDescriptor.addElement(AppKey.VERSION, true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(5));
        pluginGeneratedSerialDescriptor.addElement("versionCode", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(6));
        pluginGeneratedSerialDescriptor.addElement("logver", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(7));
        pluginGeneratedSerialDescriptor.addElement("abtest", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(8));
        pluginGeneratedSerialDescriptor.addElement("ffVersion", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(9));
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private KAppRuntimeInfo$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{KRuntimeNetWorkSerializer.INSTANCE, StringSerializer.INSTANCE, DoubleSerializer.INSTANCE, DoubleSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE};
    }

    public final KAppRuntimeInfo deserialize(Decoder decoder) {
        String str;
        String str2;
        String str3;
        String str4;
        int i;
        KRuntimeNetWork kRuntimeNetWork;
        String str5;
        double d;
        String str6;
        double d2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 7;
        KRuntimeNetWork kRuntimeNetWork2 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 1);
            double decodeDoubleElement = beginStructure.decodeDoubleElement(serialDescriptor, 2);
            double decodeDoubleElement2 = beginStructure.decodeDoubleElement(serialDescriptor, 3);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 4);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 5);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 6);
            str2 = beginStructure.decodeStringElement(serialDescriptor, 7);
            str6 = decodeStringElement4;
            str5 = decodeStringElement3;
            str4 = decodeStringElement2;
            str3 = beginStructure.decodeStringElement(serialDescriptor, 8);
            str = decodeStringElement;
            d = decodeDoubleElement;
            d2 = decodeDoubleElement2;
            kRuntimeNetWork = (KRuntimeNetWork) beginStructure.decodeSerializableElement(serialDescriptor, 0, KRuntimeNetWorkSerializer.INSTANCE, (Object) null);
            i = 511;
        } else {
            double d3 = 0.0d;
            boolean z = true;
            int i3 = 0;
            str = null;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            double d4 = 0.0d;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 7;
                    case 0:
                        kRuntimeNetWork2 = (KRuntimeNetWork) beginStructure.decodeSerializableElement(serialDescriptor, 0, KRuntimeNetWorkSerializer.INSTANCE, kRuntimeNetWork2);
                        i3 |= 1;
                        i2 = 7;
                    case 1:
                        str = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i3 |= 2;
                    case 2:
                        d3 = beginStructure.decodeDoubleElement(serialDescriptor, 2);
                        i3 |= 4;
                    case 3:
                        d4 = beginStructure.decodeDoubleElement(serialDescriptor, 3);
                        i3 |= 8;
                    case 4:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i3 |= 16;
                    case 5:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i3 |= 32;
                    case 6:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 6);
                        i3 |= 64;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, i2);
                        i3 |= 128;
                    case 8:
                        str11 = beginStructure.decodeStringElement(serialDescriptor, 8);
                        i3 |= 256;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str2 = str10;
            str3 = str11;
            str4 = str7;
            double d5 = d3;
            i = i3;
            kRuntimeNetWork = kRuntimeNetWork2;
            double d6 = d4;
            str5 = str8;
            d = d5;
            str6 = str9;
            d2 = d6;
        }
        beginStructure.endStructure(serialDescriptor);
        return new KAppRuntimeInfo(i, kRuntimeNetWork, str, d, d2, str4, str5, str6, str2, str3, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, KAppRuntimeInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        KAppRuntimeInfo.write$Self$neuron_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}