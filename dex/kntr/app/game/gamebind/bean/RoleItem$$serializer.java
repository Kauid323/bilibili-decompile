package kntr.app.game.gamebind.bean;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import java.util.List;
import java.util.Map;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: RoleItem.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/game/gamebind/bean/RoleItem.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/game/gamebind/bean/RoleItem;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class RoleItem$$serializer implements GeneratedSerializer<RoleItem> {
    public static final RoleItem$$serializer INSTANCE = new RoleItem$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.game.gamebind.bean.RoleItem", INSTANCE, 18);
        pluginGeneratedSerialDescriptor.addElement("role_bind_id", true);
        pluginGeneratedSerialDescriptor.addElement("game_base_id", true);
        pluginGeneratedSerialDescriptor.addElement("icon", true);
        pluginGeneratedSerialDescriptor.addElement("game_name", true);
        pluginGeneratedSerialDescriptor.addElement("role_name", true);
        pluginGeneratedSerialDescriptor.addElement("section_name", true);
        pluginGeneratedSerialDescriptor.addElement("visible_status", true);
        pluginGeneratedSerialDescriptor.addElement("role_attributes", true);
        pluginGeneratedSerialDescriptor.addElement("background_color", true);
        pluginGeneratedSerialDescriptor.addElement("background_image", true);
        pluginGeneratedSerialDescriptor.addElement("role_image", true);
        pluginGeneratedSerialDescriptor.addElement("auth_status", true);
        pluginGeneratedSerialDescriptor.addElement("distributor_channel_name", true);
        pluginGeneratedSerialDescriptor.addElement("distributor_channel_id", true);
        pluginGeneratedSerialDescriptor.addElement("detail_url", true);
        pluginGeneratedSerialDescriptor.addElement("bind_method_type", true);
        pluginGeneratedSerialDescriptor.addElement("comment_display_game_name", true);
        pluginGeneratedSerialDescriptor.addElement("reportParams", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private RoleItem$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = RoleItem.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable((KSerializer) lazyArr[7].getValue()), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), lazyArr[17].getValue()};
    }

    public final RoleItem deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        int i;
        List list;
        String str;
        String str2;
        String str3;
        Map map;
        String str4;
        String str5;
        String str6;
        int i2;
        int i3;
        int i4;
        String str7;
        String str8;
        int i5;
        String str9;
        int i6;
        String str10;
        String str11;
        int i7;
        Map map2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = RoleItem.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 1);
            str5 = beginStructure.decodeStringElement(serialDescriptor, 2);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 3);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 6);
            String str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, (Object) null);
            String str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, (Object) null);
            i5 = beginStructure.decodeIntElement(serialDescriptor, 11);
            String str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, (Object) null);
            int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 13);
            int decodeIntElement4 = beginStructure.decodeIntElement(serialDescriptor, 15);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, (Object) null);
            str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, (Object) null);
            i2 = decodeIntElement2;
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, (Object) null);
            str2 = str14;
            str7 = str13;
            map = (Map) beginStructure.decodeSerializableElement(serialDescriptor, 17, (DeserializationStrategy) lazyArr[17].getValue(), (Object) null);
            i = 262143;
            str4 = decodeStringElement;
            str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            i6 = decodeIntElement;
            list = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, (DeserializationStrategy) lazyArr[7].getValue(), (Object) null);
            str6 = decodeStringElement2;
            str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            str9 = str12;
            i4 = decodeIntElement4;
            i3 = decodeIntElement3;
        } else {
            boolean z = true;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            String str15 = null;
            List list2 = null;
            String str16 = null;
            String str17 = null;
            Map map3 = null;
            String str18 = null;
            String str19 = null;
            String str20 = null;
            String str21 = null;
            String str22 = null;
            String str23 = null;
            String str24 = null;
            String str25 = null;
            int i13 = 0;
            while (z) {
                int i14 = i8;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        i7 = i13;
                        map2 = map3;
                        z = false;
                        map3 = map2;
                        i8 = i14;
                        break;
                    case 0:
                        i7 = i13;
                        map2 = map3;
                        str22 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i9 |= 1;
                        map3 = map2;
                        i8 = i14;
                        break;
                    case 1:
                        i7 = i13;
                        map2 = map3;
                        i10 = beginStructure.decodeIntElement(serialDescriptor, 1);
                        i9 |= 2;
                        map3 = map2;
                        i8 = i14;
                        break;
                    case 2:
                        i7 = i13;
                        map2 = map3;
                        str23 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i9 |= 4;
                        map3 = map2;
                        i8 = i14;
                        break;
                    case 3:
                        i7 = i13;
                        map2 = map3;
                        str24 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i9 |= 8;
                        map3 = map2;
                        i8 = i14;
                        break;
                    case 4:
                        i7 = i13;
                        map2 = map3;
                        str25 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str25);
                        i9 |= 16;
                        map3 = map2;
                        i8 = i14;
                        break;
                    case 5:
                        i7 = i13;
                        map2 = map3;
                        str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str17);
                        i9 |= 32;
                        map3 = map2;
                        i8 = i14;
                        break;
                    case 6:
                        i7 = i13;
                        map2 = map3;
                        i11 = beginStructure.decodeIntElement(serialDescriptor, 6);
                        i9 |= 64;
                        map3 = map2;
                        i8 = i14;
                        break;
                    case 7:
                        i7 = i13;
                        map2 = map3;
                        list2 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, (DeserializationStrategy) lazyArr[7].getValue(), list2);
                        i9 |= 128;
                        map3 = map2;
                        i8 = i14;
                        break;
                    case 8:
                        i7 = i13;
                        map2 = map3;
                        str20 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str20);
                        i9 |= 256;
                        map3 = map2;
                        i8 = i14;
                        break;
                    case 9:
                        i7 = i13;
                        map2 = map3;
                        str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str15);
                        i9 |= 512;
                        map3 = map2;
                        i8 = i14;
                        break;
                    case 10:
                        i7 = i13;
                        map2 = map3;
                        str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, str19);
                        i9 |= 1024;
                        map3 = map2;
                        i8 = i14;
                        break;
                    case AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER /* 11 */:
                        i7 = i13;
                        map2 = map3;
                        i12 = beginStructure.decodeIntElement(serialDescriptor, 11);
                        i9 |= 2048;
                        map3 = map2;
                        i8 = i14;
                        break;
                    case AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER /* 12 */:
                        i7 = i13;
                        map2 = map3;
                        str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str18);
                        i9 |= 4096;
                        map3 = map2;
                        i8 = i14;
                        break;
                    case AdditionVote2.BIZ_TYPE_FIELD_NUMBER /* 13 */:
                        i7 = i13;
                        i9 |= 8192;
                        i8 = beginStructure.decodeIntElement(serialDescriptor, 13);
                        map3 = map3;
                        break;
                    case AdditionVote2.TOTAL_FIELD_NUMBER /* 14 */:
                        i7 = i13;
                        map2 = map3;
                        str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str16);
                        i9 |= 16384;
                        map3 = map2;
                        i8 = i14;
                        break;
                    case AdditionVote2.CARD_TYPE_FIELD_NUMBER /* 15 */:
                        i9 |= 32768;
                        i13 = beginStructure.decodeIntElement(serialDescriptor, 15);
                        map3 = map3;
                        i8 = i14;
                        continue;
                    case AdditionVote2.TIPS_FIELD_NUMBER /* 16 */:
                        i7 = i13;
                        map2 = map3;
                        str21 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, str21);
                        i9 |= 65536;
                        map3 = map2;
                        i8 = i14;
                        break;
                    case AdditionVote2.URI_FIELD_NUMBER /* 17 */:
                        i7 = i13;
                        map3 = (Map) beginStructure.decodeSerializableElement(serialDescriptor, 17, (DeserializationStrategy) lazyArr[17].getValue(), map3);
                        i9 |= 131072;
                        i8 = i14;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
                i13 = i7;
            }
            int i15 = i13;
            Map map4 = map3;
            i = i9;
            list = list2;
            str = str16;
            str2 = str18;
            str3 = str20;
            map = map4;
            str4 = str22;
            str5 = str23;
            str6 = str24;
            i2 = i11;
            i3 = i8;
            i4 = i15;
            str7 = str19;
            str8 = str21;
            i5 = i12;
            str9 = str15;
            i6 = i10;
            String str26 = str25;
            str10 = str17;
            str11 = str26;
        }
        beginStructure.endStructure(serialDescriptor);
        return new RoleItem(i, str4, i6, str5, str6, str11, str10, i2, list, str3, str9, str7, i5, str2, i3, str, i4, str8, map, null);
    }

    public final void serialize(Encoder encoder, RoleItem value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        RoleItem.write$Self$game_bind_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}