package kntr.base.neuron.internal.model.pb;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import java.lang.annotation.Annotation;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kntr.watch.later.watchlater.utils.WatchLaterReporterKt;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: info_raw.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/base/neuron/internal/model/pb/KAppPlayerInfo.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/base/neuron/internal/model/pb/KAppPlayerInfo;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "neuron_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class KAppPlayerInfo$$serializer implements GeneratedSerializer<KAppPlayerInfo> {
    public static final KAppPlayerInfo$$serializer INSTANCE = new KAppPlayerInfo$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.base.neuron.internal.model.pb.KAppPlayerInfo", INSTANCE, 18);
        pluginGeneratedSerialDescriptor.addElement("playFromSpmid", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(1));
        pluginGeneratedSerialDescriptor.addElement("seasonId", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(2));
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(3));
        pluginGeneratedSerialDescriptor.addElement("subType", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(4));
        pluginGeneratedSerialDescriptor.addElement("epId", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(5));
        pluginGeneratedSerialDescriptor.addElement("progress", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(6));
        pluginGeneratedSerialDescriptor.addElement(WatchLaterReporterKt.KEY_AVID, true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(7));
        pluginGeneratedSerialDescriptor.addElement("cid", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(8));
        pluginGeneratedSerialDescriptor.addElement("networkType", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(9));
        pluginGeneratedSerialDescriptor.addElement("danmaku", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(10));
        pluginGeneratedSerialDescriptor.addElement("status", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(11));
        pluginGeneratedSerialDescriptor.addElement("playMethod", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(12));
        pluginGeneratedSerialDescriptor.addElement("playType", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(13));
        pluginGeneratedSerialDescriptor.addElement("playerSessionId", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(14));
        pluginGeneratedSerialDescriptor.addElement("speed", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(15));
        pluginGeneratedSerialDescriptor.addElement("playerClarity", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(16));
        pluginGeneratedSerialDescriptor.addElement("isAutoplay", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(17));
        pluginGeneratedSerialDescriptor.addElement("videoFormat", true);
        pluginGeneratedSerialDescriptor.pushAnnotation((Annotation) new KAppRuntimeInfo$$serializer$annotationImpl$kotlinx_serialization_protobuf_ProtoNumber$0(18));
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private KAppPlayerInfo$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE};
    }

    public final KAppPlayerInfo deserialize(Decoder decoder) {
        int i;
        String str;
        int i2;
        String str2;
        int i3;
        String str3;
        int i4;
        int i5;
        int i6;
        int i7;
        String str4;
        String str5;
        String str6;
        String str7;
        int i8;
        int i9;
        int i10;
        String str8;
        String str9;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i11 = 8;
        char c = 2;
        int i12 = 0;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 2);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 3);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 4);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 5);
            String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 6);
            String decodeStringElement6 = beginStructure.decodeStringElement(serialDescriptor, 7);
            int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 8);
            int decodeIntElement4 = beginStructure.decodeIntElement(serialDescriptor, 9);
            int decodeIntElement5 = beginStructure.decodeIntElement(serialDescriptor, 10);
            int decodeIntElement6 = beginStructure.decodeIntElement(serialDescriptor, 11);
            int decodeIntElement7 = beginStructure.decodeIntElement(serialDescriptor, 12);
            String decodeStringElement7 = beginStructure.decodeStringElement(serialDescriptor, 13);
            String decodeStringElement8 = beginStructure.decodeStringElement(serialDescriptor, 14);
            String decodeStringElement9 = beginStructure.decodeStringElement(serialDescriptor, 15);
            int decodeIntElement8 = beginStructure.decodeIntElement(serialDescriptor, 16);
            i9 = beginStructure.decodeIntElement(serialDescriptor, 17);
            i5 = decodeIntElement6;
            i10 = decodeIntElement7;
            i = 262143;
            i8 = decodeIntElement8;
            str7 = decodeStringElement9;
            str9 = decodeStringElement8;
            str8 = decodeStringElement7;
            i2 = decodeIntElement3;
            i6 = decodeIntElement5;
            i7 = decodeIntElement4;
            str4 = decodeStringElement6;
            str5 = decodeStringElement5;
            str6 = decodeStringElement4;
            str = decodeStringElement;
            str2 = decodeStringElement3;
            i3 = decodeIntElement;
            str3 = decodeStringElement2;
            i4 = decodeIntElement2;
        } else {
            String str10 = null;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            String str14 = null;
            String str15 = null;
            String str16 = null;
            String str17 = null;
            String str18 = null;
            boolean z = true;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i11 = 8;
                        c = 2;
                        break;
                    case 0:
                        str13 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i12 |= 1;
                        i11 = 8;
                        c = 2;
                        break;
                    case 1:
                        str15 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i12 |= 2;
                        i11 = 8;
                        c = 2;
                        continue;
                    case 2:
                        i16 = beginStructure.decodeIntElement(serialDescriptor, 2);
                        i12 |= 4;
                        c = 2;
                        i11 = 8;
                        break;
                    case 3:
                        i17 = beginStructure.decodeIntElement(serialDescriptor, 3);
                        i12 |= 8;
                        c = 2;
                        break;
                    case 4:
                        str14 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i12 |= 16;
                        c = 2;
                        break;
                    case 5:
                        str18 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i12 |= 32;
                        c = 2;
                        break;
                    case 6:
                        str17 = beginStructure.decodeStringElement(serialDescriptor, 6);
                        i12 |= 64;
                        c = 2;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        str16 = beginStructure.decodeStringElement(serialDescriptor, 7);
                        i12 |= 128;
                        c = 2;
                        break;
                    case 8:
                        i15 = beginStructure.decodeIntElement(serialDescriptor, i11);
                        i12 |= 256;
                        c = 2;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        i20 = beginStructure.decodeIntElement(serialDescriptor, 9);
                        i12 |= 512;
                        c = 2;
                        break;
                    case 10:
                        i19 = beginStructure.decodeIntElement(serialDescriptor, 10);
                        i12 |= 1024;
                        c = 2;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        i18 = beginStructure.decodeIntElement(serialDescriptor, 11);
                        i12 |= 2048;
                        c = 2;
                        break;
                    case 12:
                        i21 = beginStructure.decodeIntElement(serialDescriptor, 12);
                        i12 |= 4096;
                        c = 2;
                        break;
                    case 13:
                        i12 |= 8192;
                        str10 = beginStructure.decodeStringElement(serialDescriptor, 13);
                        c = 2;
                        break;
                    case ConstantsKt.SPACER_14 /* 14 */:
                        i12 |= 16384;
                        str11 = beginStructure.decodeStringElement(serialDescriptor, 14);
                        c = 2;
                        break;
                    case 15:
                        str12 = beginStructure.decodeStringElement(serialDescriptor, 15);
                        i12 |= 32768;
                        c = 2;
                        break;
                    case 16:
                        i13 = beginStructure.decodeIntElement(serialDescriptor, 16);
                        i12 |= 65536;
                        c = 2;
                        break;
                    case 17:
                        i14 = beginStructure.decodeIntElement(serialDescriptor, 17);
                        i12 |= 131072;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i12;
            str = str13;
            i2 = i15;
            str2 = str14;
            i3 = i16;
            str3 = str15;
            i4 = i17;
            i5 = i18;
            i6 = i19;
            i7 = i20;
            str4 = str16;
            str5 = str17;
            str6 = str18;
            str7 = str12;
            i8 = i13;
            i9 = i14;
            i10 = i21;
            str8 = str10;
            str9 = str11;
        }
        beginStructure.endStructure(serialDescriptor);
        return new KAppPlayerInfo(i, str, str3, i3, i4, str2, str6, str5, str4, i2, i7, i6, i5, i10, str8, str9, str7, i8, i9, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, KAppPlayerInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        KAppPlayerInfo.write$Self$neuron_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}