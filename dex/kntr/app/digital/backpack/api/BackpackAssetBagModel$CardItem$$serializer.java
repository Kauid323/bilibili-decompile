package kntr.app.digital.backpack.api;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.digital.backpack.api.BackpackAssetBagModel;
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

/* compiled from: BackpackAssetBagModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/digital/backpack/api/BackpackAssetBagModel.CardItem.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/digital/backpack/api/BackpackAssetBagModel$CardItem;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class BackpackAssetBagModel$CardItem$$serializer implements GeneratedSerializer<BackpackAssetBagModel.CardItem> {
    public static final int $stable;
    public static final BackpackAssetBagModel$CardItem$$serializer INSTANCE = new BackpackAssetBagModel$CardItem$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.digital.backpack.api.BackpackAssetBagModel.CardItem", INSTANCE, 13);
        pluginGeneratedSerialDescriptor.addElement("card_type_id", true);
        pluginGeneratedSerialDescriptor.addElement("card_name", true);
        pluginGeneratedSerialDescriptor.addElement("card_img", true);
        pluginGeneratedSerialDescriptor.addElement(ReportBuildInParam.CARD_TYPE, true);
        pluginGeneratedSerialDescriptor.addElement("card_sub_type", true);
        pluginGeneratedSerialDescriptor.addElement("badge_url", true);
        pluginGeneratedSerialDescriptor.addElement("owned_count", true);
        pluginGeneratedSerialDescriptor.addElement("holding_rate", true);
        pluginGeneratedSerialDescriptor.addElement("card_scarcity", true);
        pluginGeneratedSerialDescriptor.addElement("is_limited_card", true);
        pluginGeneratedSerialDescriptor.addElement("anchor_id", true);
        pluginGeneratedSerialDescriptor.addElement("tag", true);
        pluginGeneratedSerialDescriptor.addElement("stock_info", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private BackpackAssetBagModel$CardItem$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LongSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(BackpackAssetBagModel$Tag$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BackpackAssetBagModel$StockInfo$$serializer.INSTANCE)};
    }

    public final BackpackAssetBagModel.CardItem deserialize(Decoder decoder) {
        int i;
        BackpackAssetBagModel.StockInfo stockInfo;
        long j2;
        String str;
        int i2;
        int i3;
        String str2;
        String str3;
        String str4;
        int i4;
        BackpackAssetBagModel.Tag tag;
        String str5;
        int i5;
        int i6;
        char c;
        char c2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i7 = 10;
        char c3 = 3;
        String str6 = null;
        if (beginStructure.decodeSequentially()) {
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 0);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 1);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 2);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 3);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 4);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 5);
            int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 6);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 7);
            int decodeIntElement4 = beginStructure.decodeIntElement(serialDescriptor, 8);
            int decodeIntElement5 = beginStructure.decodeIntElement(serialDescriptor, 9);
            String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 10);
            tag = (BackpackAssetBagModel.Tag) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, BackpackAssetBagModel$Tag$$serializer.INSTANCE, (Object) null);
            stockInfo = (BackpackAssetBagModel.StockInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, BackpackAssetBagModel$StockInfo$$serializer.INSTANCE, (Object) null);
            i = 8191;
            str4 = decodeStringElement5;
            i6 = decodeIntElement5;
            str5 = decodeStringElement4;
            i2 = decodeIntElement3;
            str = decodeStringElement3;
            i5 = decodeIntElement;
            i3 = decodeIntElement4;
            i4 = decodeIntElement2;
            str2 = decodeStringElement2;
            j2 = decodeLongElement;
            str3 = decodeStringElement;
        } else {
            long j3 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            String str7 = null;
            BackpackAssetBagModel.Tag tag2 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            boolean z = true;
            BackpackAssetBagModel.StockInfo stockInfo2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        c = c3;
                        c2 = 2;
                        z = false;
                        c3 = c;
                        i7 = 10;
                        break;
                    case 0:
                        c = c3;
                        c2 = 2;
                        j3 = beginStructure.decodeLongElement(serialDescriptor, 0);
                        i8 |= 1;
                        c3 = c;
                        i7 = 10;
                        break;
                    case 1:
                        i8 |= 2;
                        c3 = c3;
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        break;
                    case 2:
                        i8 |= 4;
                        c3 = c3;
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        break;
                    case 3:
                        i11 = beginStructure.decodeIntElement(serialDescriptor, 3);
                        i8 |= 8;
                        c3 = 3;
                        break;
                    case 4:
                        i13 = beginStructure.decodeIntElement(serialDescriptor, 4);
                        i8 |= 16;
                        c3 = 3;
                        break;
                    case 5:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i8 |= 32;
                        c3 = 3;
                        break;
                    case 6:
                        i10 = beginStructure.decodeIntElement(serialDescriptor, 6);
                        i8 |= 64;
                        c3 = 3;
                        break;
                    case 7:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 7);
                        i8 |= 128;
                        c3 = 3;
                        break;
                    case 8:
                        i12 = beginStructure.decodeIntElement(serialDescriptor, 8);
                        i8 |= 256;
                        c3 = 3;
                        break;
                    case 9:
                        i9 = beginStructure.decodeIntElement(serialDescriptor, 9);
                        i8 |= 512;
                        c3 = 3;
                        break;
                    case 10:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, i7);
                        i8 |= 1024;
                        c3 = 3;
                        break;
                    case AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER /* 11 */:
                        tag2 = (BackpackAssetBagModel.Tag) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, BackpackAssetBagModel$Tag$$serializer.INSTANCE, tag2);
                        i8 |= 2048;
                        c3 = 3;
                        break;
                    case AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER /* 12 */:
                        stockInfo2 = (BackpackAssetBagModel.StockInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, BackpackAssetBagModel$StockInfo$$serializer.INSTANCE, stockInfo2);
                        i8 |= 4096;
                        c3 = 3;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i8;
            stockInfo = stockInfo2;
            j2 = j3;
            str = str8;
            i2 = i10;
            i3 = i12;
            str2 = str7;
            str3 = str6;
            str4 = str10;
            i4 = i13;
            tag = tag2;
            int i14 = i9;
            str5 = str9;
            i5 = i11;
            i6 = i14;
        }
        beginStructure.endStructure(serialDescriptor);
        return new BackpackAssetBagModel.CardItem(i, j2, str3, str2, i5, i4, str, i2, str5, i3, i6, str4, tag, stockInfo, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, BackpackAssetBagModel.CardItem value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        BackpackAssetBagModel.CardItem.write$Self$backpack_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}