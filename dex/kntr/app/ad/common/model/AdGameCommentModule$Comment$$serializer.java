package kntr.app.ad.common.model;

import kntr.app.ad.common.model.AdGameCommentModule;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdAndroidGameInfo.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/ad/common/model/AdGameCommentModule.Comment.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/ad/common/model/AdGameCommentModule$Comment;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AdGameCommentModule$Comment$$serializer implements GeneratedSerializer<AdGameCommentModule.Comment> {
    public static final AdGameCommentModule$Comment$$serializer INSTANCE = new AdGameCommentModule$Comment$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.common.model.AdGameCommentModule.Comment", INSTANCE, 8);
        pluginGeneratedSerialDescriptor.addElement("gameBaseId", true);
        pluginGeneratedSerialDescriptor.addElement("userName", true);
        pluginGeneratedSerialDescriptor.addElement("userFace", true);
        pluginGeneratedSerialDescriptor.addElement("userLevel", true);
        pluginGeneratedSerialDescriptor.addElement("commentNo", true);
        pluginGeneratedSerialDescriptor.addElement("grade", true);
        pluginGeneratedSerialDescriptor.addElement("content", true);
        pluginGeneratedSerialDescriptor.addElement("upCount", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdGameCommentModule$Comment$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), LongSerializer.INSTANCE};
    }

    public final AdGameCommentModule.Comment deserialize(Decoder decoder) {
        String str;
        int i;
        long j2;
        String str2;
        String str3;
        int i2;
        Long l;
        String str4;
        int i3;
        char c;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i4 = 7;
        int i5 = 6;
        int i6 = 5;
        if (beginStructure.decodeSequentially()) {
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 3);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 5);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, (Object) null);
            i = decodeIntElement2;
            i2 = decodeIntElement;
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            j2 = beginStructure.decodeLongElement(serialDescriptor, 7);
            l = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, LongSerializer.INSTANCE, (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            i3 = 255;
        } else {
            boolean z = true;
            int i7 = 0;
            String str5 = null;
            String str6 = null;
            String str7 = null;
            Long l2 = null;
            long j3 = 0;
            int i8 = 0;
            String str8 = null;
            int i9 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z = false;
                        i4 = 7;
                        i5 = 6;
                        i6 = 5;
                    case 0:
                        i7 |= 1;
                        l2 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, LongSerializer.INSTANCE, l2);
                        i4 = 7;
                        i5 = 6;
                        i6 = 5;
                    case 1:
                        str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str8);
                        i7 |= 2;
                        i4 = 7;
                        i5 = 6;
                    case 2:
                        str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str7);
                        i7 |= 4;
                        i4 = 7;
                        i5 = 6;
                    case 3:
                        c = 4;
                        i8 = beginStructure.decodeIntElement(serialDescriptor, 3);
                        i7 |= 8;
                        i4 = 7;
                    case 4:
                        c = 4;
                        str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str6);
                        i7 |= 16;
                        i4 = 7;
                    case 5:
                        i9 = beginStructure.decodeIntElement(serialDescriptor, i6);
                        i7 |= 32;
                    case 6:
                        str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i5, StringSerializer.INSTANCE, str5);
                        i7 |= 64;
                    case 7:
                        j3 = beginStructure.decodeLongElement(serialDescriptor, i4);
                        i7 |= 128;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            Long l3 = l2;
            str = str5;
            i = i9;
            j2 = j3;
            str2 = str6;
            str3 = str8;
            i2 = i8;
            l = l3;
            str4 = str7;
            i3 = i7;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AdGameCommentModule.Comment(i3, l, str3, str4, i2, str2, i, str, j2, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, AdGameCommentModule.Comment value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AdGameCommentModule.Comment.write$Self$dto_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}