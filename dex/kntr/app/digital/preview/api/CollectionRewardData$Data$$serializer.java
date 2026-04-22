package kntr.app.digital.preview.api;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import java.util.List;
import kntr.app.digital.preview.api.CollectionRewardData;
import kntr.app.game.base.ui.widget.gameaction.state.GameActionStateKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: CardPreviewModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/digital/preview/api/CollectionRewardData.Data.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/digital/preview/api/CollectionRewardData$Data;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class CollectionRewardData$Data$$serializer implements GeneratedSerializer<CollectionRewardData.Data> {
    public static final int $stable;
    public static final CollectionRewardData$Data$$serializer INSTANCE = new CollectionRewardData$Data$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.digital.preview.api.CollectionRewardData.Data", INSTANCE, 15);
        pluginGeneratedSerialDescriptor.addElement("unique_id", true);
        pluginGeneratedSerialDescriptor.addElement("collect_id", true);
        pluginGeneratedSerialDescriptor.addElement("highlighted", true);
        pluginGeneratedSerialDescriptor.addElement("redeem_item_type", true);
        pluginGeneratedSerialDescriptor.addElement("redeem_item_id", true);
        pluginGeneratedSerialDescriptor.addElement("redeem_item_name", true);
        pluginGeneratedSerialDescriptor.addElement("redeem_item_image", true);
        pluginGeneratedSerialDescriptor.addElement("redeem_item_video", true);
        pluginGeneratedSerialDescriptor.addElement("card_video_download", true);
        pluginGeneratedSerialDescriptor.addElement("desc_tag", true);
        pluginGeneratedSerialDescriptor.addElement("top_text", true);
        pluginGeneratedSerialDescriptor.addElement("actions", true);
        pluginGeneratedSerialDescriptor.addElement("modules", true);
        pluginGeneratedSerialDescriptor.addElement("holding_rate", true);
        pluginGeneratedSerialDescriptor.addElement("holding_rate_url", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private CollectionRewardData$Data$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = CollectionRewardData.Data.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, LongSerializer.INSTANCE, BooleanSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable((KSerializer) lazyArr[7].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DescTag$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(TopText$$serializer.INSTANCE), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[11].getValue()), BuiltinSerializersKt.getNullable((KSerializer) lazyArr[12].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final CollectionRewardData.Data deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        boolean z;
        String str;
        String str2;
        List list;
        TopText topText;
        List list2;
        DescTag descTag;
        String str3;
        String str4;
        String str5;
        String str6;
        int i;
        long j2;
        String str7;
        List list3;
        int i2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = CollectionRewardData.Data.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 1);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 2);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 3);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 4);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 5);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 6);
            List list4 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, (DeserializationStrategy) lazyArr[11].getValue(), (Object) null);
            String str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, (Object) null);
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, (DeserializationStrategy) lazyArr[12].getValue(), (Object) null);
            str7 = decodeStringElement;
            list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, (DeserializationStrategy) lazyArr[7].getValue(), (Object) null);
            descTag = (DescTag) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, DescTag$$serializer.INSTANCE, (Object) null);
            i = decodeIntElement;
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, (Object) null);
            str4 = decodeStringElement2;
            topText = (TopText) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, TopText$$serializer.INSTANCE, (Object) null);
            str2 = str8;
            list2 = list4;
            j2 = decodeLongElement;
            z = decodeBooleanElement;
            i2 = 32767;
            str6 = decodeStringElement4;
            str5 = decodeStringElement3;
        } else {
            boolean z2 = false;
            int i3 = 0;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            List list5 = null;
            TopText topText2 = null;
            List list6 = null;
            DescTag descTag2 = null;
            String str12 = null;
            boolean z3 = true;
            long j3 = 0;
            List list7 = null;
            String str13 = null;
            String str14 = null;
            String str15 = null;
            int i4 = 0;
            while (z3) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z3 = false;
                        break;
                    case 0:
                        i4 |= 1;
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        break;
                    case 1:
                        j3 = beginStructure.decodeLongElement(serialDescriptor, 1);
                        i4 |= 2;
                        break;
                    case 2:
                        i4 |= 4;
                        z2 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                        break;
                    case 3:
                        i3 = beginStructure.decodeIntElement(serialDescriptor, 3);
                        i4 |= 8;
                        break;
                    case 4:
                        str14 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i4 |= 16;
                        break;
                    case 5:
                        str15 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i4 |= 32;
                        break;
                    case 6:
                        str12 = beginStructure.decodeStringElement(serialDescriptor, 6);
                        i4 |= 64;
                        break;
                    case 7:
                        list7 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, (DeserializationStrategy) lazyArr[7].getValue(), list7);
                        i4 |= 128;
                        break;
                    case 8:
                        str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str13);
                        i4 |= 256;
                        continue;
                    case 9:
                        descTag2 = (DescTag) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, DescTag$$serializer.INSTANCE, descTag2);
                        i4 |= 512;
                        break;
                    case 10:
                        topText2 = (TopText) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, TopText$$serializer.INSTANCE, topText2);
                        i4 |= 1024;
                        break;
                    case AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER /* 11 */:
                        list6 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, (DeserializationStrategy) lazyArr[11].getValue(), list6);
                        i4 |= 2048;
                        break;
                    case AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER /* 12 */:
                        list5 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, (DeserializationStrategy) lazyArr[12].getValue(), list5);
                        i4 |= 4096;
                        break;
                    case AdditionVote2.BIZ_TYPE_FIELD_NUMBER /* 13 */:
                        str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str11);
                        i4 |= 8192;
                        break;
                    case AdditionVote2.TOTAL_FIELD_NUMBER /* 14 */:
                        str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str10);
                        i4 |= 16384;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            z = z2;
            str = str10;
            str2 = str11;
            list = list5;
            topText = topText2;
            list2 = list6;
            descTag = descTag2;
            str3 = str13;
            str4 = str14;
            str5 = str15;
            str6 = str12;
            i = i3;
            j2 = j3;
            str7 = str9;
            list3 = list7;
            i2 = i4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new CollectionRewardData.Data(i2, str7, j2, z, i, str4, str5, str6, list3, str3, descTag, topText, list2, list, str2, str, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, CollectionRewardData.Data value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        CollectionRewardData.Data.write$Self$preview_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}