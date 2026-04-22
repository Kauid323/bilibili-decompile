package kntr.app.ad.domain.adextra.handler;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import kntr.app.ad.domain.adextra.handler.UgcCommentHandler;
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

/* compiled from: UgcCommentHandler.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/ad/domain/adextra/handler/UgcCommentHandler.Response.CommentReq.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/ad/domain/adextra/handler/UgcCommentHandler$Response$CommentReq;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "adextra_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class UgcCommentHandler$Response$CommentReq$$serializer implements GeneratedSerializer<UgcCommentHandler.Response.CommentReq> {
    public static final UgcCommentHandler$Response$CommentReq$$serializer INSTANCE = new UgcCommentHandler$Response$CommentReq$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.domain.adextra.handler.UgcCommentHandler.Response.CommentReq", INSTANCE, 12);
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
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private UgcCommentHandler$Response$CommentReq$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final UgcCommentHandler.Response.CommentReq deserialize(Decoder decoder) {
        String str;
        String str2;
        String str3;
        Long l;
        String str4;
        String str5;
        String str6;
        Long l2;
        String str7;
        String str8;
        Long l3;
        String str9;
        int i;
        Long l4;
        String str10;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, (Object) null);
            str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, (Object) null);
            str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, (Object) null);
            i = 4095;
            l = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, LongSerializer.INSTANCE, (Object) null);
            str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            l2 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, LongSerializer.INSTANCE, (Object) null);
            l3 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LongSerializer.INSTANCE, (Object) null);
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, (Object) null);
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
        } else {
            String str11 = null;
            Long l5 = null;
            String str12 = null;
            String str13 = null;
            String str14 = null;
            String str15 = null;
            Long l6 = null;
            String str16 = null;
            String str17 = null;
            String str18 = null;
            boolean z = true;
            Long l7 = null;
            int i2 = 0;
            String str19 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        l4 = l5;
                        z = false;
                        l5 = l4;
                        break;
                    case 0:
                        l4 = l5;
                        str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str11);
                        i2 |= 1;
                        l5 = l4;
                        break;
                    case 1:
                        str10 = str11;
                        l5 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, LongSerializer.INSTANCE, l5);
                        i2 |= 2;
                        str11 = str10;
                        break;
                    case 2:
                        str10 = str11;
                        str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str19);
                        i2 |= 4;
                        str11 = str10;
                        break;
                    case 3:
                        str10 = str11;
                        l7 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, LongSerializer.INSTANCE, l7);
                        i2 |= 8;
                        str11 = str10;
                        break;
                    case 4:
                        str10 = str11;
                        str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str18);
                        i2 |= 16;
                        str11 = str10;
                        break;
                    case 5:
                        str10 = str11;
                        l6 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, LongSerializer.INSTANCE, l6);
                        i2 |= 32;
                        str11 = str10;
                        break;
                    case 6:
                        str10 = str11;
                        str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str17);
                        i2 |= 64;
                        str11 = str10;
                        break;
                    case 7:
                        str10 = str11;
                        str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str15);
                        i2 |= 128;
                        str11 = str10;
                        break;
                    case 8:
                        str10 = str11;
                        str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str14);
                        i2 |= 256;
                        str11 = str10;
                        break;
                    case 9:
                        str10 = str11;
                        str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str13);
                        i2 |= 512;
                        str11 = str10;
                        break;
                    case 10:
                        str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, str16);
                        i2 |= 1024;
                        str11 = str11;
                        break;
                    case AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER /* 11 */:
                        str10 = str11;
                        str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str12);
                        i2 |= 2048;
                        str11 = str10;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str12;
            str2 = str14;
            str3 = str16;
            l = l7;
            str4 = str11;
            str5 = str17;
            str6 = str18;
            l2 = l6;
            str7 = str19;
            str8 = str15;
            l3 = l5;
            str9 = str13;
            i = i2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new UgcCommentHandler.Response.CommentReq(i, str4, l3, str7, l, str6, l2, str5, str8, str2, str9, str3, str, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, UgcCommentHandler.Response.CommentReq value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        UgcCommentHandler.Response.CommentReq.write$Self$adextra_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}