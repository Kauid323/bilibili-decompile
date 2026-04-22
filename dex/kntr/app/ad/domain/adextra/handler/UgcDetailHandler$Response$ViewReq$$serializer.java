package kntr.app.ad.domain.adextra.handler;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import kntr.app.ad.domain.adextra.handler.UgcDetailHandler;
import kntr.app.game.base.ui.widget.gameaction.state.GameActionStateKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: UgcDetailHandler.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/ad/domain/adextra/handler/UgcDetailHandler.Response.ViewReq.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/ad/domain/adextra/handler/UgcDetailHandler$Response$ViewReq;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class UgcDetailHandler$Response$ViewReq$$serializer implements GeneratedSerializer<UgcDetailHandler.Response.ViewReq> {
    public static final UgcDetailHandler$Response$ViewReq$$serializer INSTANCE = new UgcDetailHandler$Response$ViewReq$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.domain.adextra.handler.UgcDetailHandler.Response.ViewReq", INSTANCE, 13);
        pluginGeneratedSerialDescriptor.addElement("ocpxTargetType", true);
        pluginGeneratedSerialDescriptor.addElement("linkedCreativeId", true);
        pluginGeneratedSerialDescriptor.addElement("trackId", true);
        pluginGeneratedSerialDescriptor.addElement("sourceId", true);
        pluginGeneratedSerialDescriptor.addElement("requestId", true);
        pluginGeneratedSerialDescriptor.addElement("resourceId", true);
        pluginGeneratedSerialDescriptor.addElement("fromTrackId", true);
        pluginGeneratedSerialDescriptor.addElement("titleEncode", true);
        pluginGeneratedSerialDescriptor.addElement("titleMaterialId", true);
        pluginGeneratedSerialDescriptor.addElement("imageMaterialId", true);
        pluginGeneratedSerialDescriptor.addElement("tabClickFrom", true);
        pluginGeneratedSerialDescriptor.addElement("cardAdStyle", true);
        pluginGeneratedSerialDescriptor.addElement("cmBackhaulExtra", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private UgcDetailHandler$Response$ViewReq$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final UgcDetailHandler.Response.ViewReq deserialize(Decoder decoder) {
        String str;
        int i;
        String str2;
        Long l;
        String str3;
        String str4;
        Long l2;
        String str5;
        String str6;
        String str7;
        String str8;
        Long l3;
        String str9;
        String str10;
        Long l4;
        Long l5;
        String str11;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            Long l6 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LongSerializer.INSTANCE, (Object) null);
            String str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            String str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            Long l7 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, LongSerializer.INSTANCE, (Object) null);
            str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, (Object) null);
            String str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, (Object) null);
            str4 = str14;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
            i = 8191;
            l = l6;
            str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, (Object) null);
            str3 = str12;
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, (Object) null);
            l2 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, LongSerializer.INSTANCE, (Object) null);
            str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, (Object) null);
            str6 = str13;
            str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, (Object) null);
            l3 = l7;
        } else {
            String str15 = null;
            Long l8 = null;
            String str16 = null;
            String str17 = null;
            String str18 = null;
            String str19 = null;
            String str20 = null;
            Long l9 = null;
            String str21 = null;
            String str22 = null;
            String str23 = null;
            boolean z = true;
            int i2 = 0;
            String str24 = null;
            Long l10 = null;
            while (z) {
                String str25 = str15;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        l5 = l8;
                        str11 = str24;
                        z = false;
                        str15 = str25;
                        l8 = l5;
                        str24 = str11;
                        break;
                    case 0:
                        str11 = str24;
                        l5 = l8;
                        str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str25);
                        i2 |= 1;
                        l8 = l5;
                        str24 = str11;
                        break;
                    case 1:
                        l8 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LongSerializer.INSTANCE, l8);
                        i2 |= 2;
                        str24 = str24;
                        str15 = str25;
                        break;
                    case 2:
                        l4 = l8;
                        str24 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str24);
                        i2 |= 4;
                        str15 = str25;
                        l8 = l4;
                        break;
                    case 3:
                        l4 = l8;
                        l10 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, LongSerializer.INSTANCE, l10);
                        i2 |= 8;
                        str15 = str25;
                        l8 = l4;
                        break;
                    case 4:
                        l4 = l8;
                        str23 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str23);
                        i2 |= 16;
                        str15 = str25;
                        l8 = l4;
                        break;
                    case 5:
                        l4 = l8;
                        l9 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, LongSerializer.INSTANCE, l9);
                        i2 |= 32;
                        str15 = str25;
                        l8 = l4;
                        break;
                    case 6:
                        l4 = l8;
                        str22 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str22);
                        i2 |= 64;
                        str15 = str25;
                        l8 = l4;
                        break;
                    case 7:
                        l4 = l8;
                        str20 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str20);
                        i2 |= 128;
                        str15 = str25;
                        l8 = l4;
                        break;
                    case 8:
                        l4 = l8;
                        str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str19);
                        i2 |= 256;
                        str15 = str25;
                        l8 = l4;
                        break;
                    case 9:
                        l4 = l8;
                        str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str18);
                        i2 |= 512;
                        str15 = str25;
                        l8 = l4;
                        break;
                    case 10:
                        l4 = l8;
                        str21 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, str21);
                        i2 |= 1024;
                        str15 = str25;
                        l8 = l4;
                        break;
                    case AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER /* 11 */:
                        l4 = l8;
                        str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str17);
                        i2 |= 2048;
                        str15 = str25;
                        l8 = l4;
                        break;
                    case AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER /* 12 */:
                        l4 = l8;
                        str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str16);
                        i2 |= 4096;
                        str15 = str25;
                        l8 = l4;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            Long l11 = l8;
            String str26 = str24;
            str = str15;
            i = i2;
            str2 = str16;
            l = l11;
            str3 = str26;
            Long l12 = l10;
            str4 = str17;
            l2 = l12;
            String str27 = str22;
            str5 = str18;
            str6 = str23;
            str7 = str21;
            str8 = str19;
            l3 = l9;
            str9 = str20;
            str10 = str27;
        }
        beginStructure.endStructure(serialDescriptor);
        return new UgcDetailHandler.Response.ViewReq(i, str, l, str3, l2, str6, l3, str10, str9, str8, str5, str7, str4, str2, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, UgcDetailHandler.Response.ViewReq value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        UgcDetailHandler.Response.ViewReq.write$Self$adextra_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}