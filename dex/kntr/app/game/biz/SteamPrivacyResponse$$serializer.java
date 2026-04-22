package kntr.app.game.biz;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: SteamPrivacyConfig.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/game/biz/SteamPrivacyResponse.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/game/biz/SteamPrivacyResponse;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class SteamPrivacyResponse$$serializer implements GeneratedSerializer<SteamPrivacyResponse> {
    public static final int $stable;
    public static final SteamPrivacyResponse$$serializer INSTANCE = new SteamPrivacyResponse$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.game.biz.SteamPrivacyResponse", INSTANCE, 24);
        pluginGeneratedSerialDescriptor.addElement("uid", true);
        pluginGeneratedSerialDescriptor.addElement("steam_id", true);
        pluginGeneratedSerialDescriptor.addElement("bind_status", false);
        pluginGeneratedSerialDescriptor.addElement("bind_status_desc", true);
        pluginGeneratedSerialDescriptor.addElement("bind_time", true);
        pluginGeneratedSerialDescriptor.addElement("un_bind_time", true);
        pluginGeneratedSerialDescriptor.addElement("privacy_profile", true);
        pluginGeneratedSerialDescriptor.addElement("privacy_profile_desc", true);
        pluginGeneratedSerialDescriptor.addElement("privacy_inventory", true);
        pluginGeneratedSerialDescriptor.addElement("privacy_inventory_desc", true);
        pluginGeneratedSerialDescriptor.addElement("privacy_inventory_gifts", true);
        pluginGeneratedSerialDescriptor.addElement("privacy_inventory_gifts_desc", true);
        pluginGeneratedSerialDescriptor.addElement("privacy_owned_games", true);
        pluginGeneratedSerialDescriptor.addElement("privacy_owned_games_desc", true);
        pluginGeneratedSerialDescriptor.addElement("privacy_playtime", true);
        pluginGeneratedSerialDescriptor.addElement("privacy_playtime_desc", true);
        pluginGeneratedSerialDescriptor.addElement("privacy_friends_list", true);
        pluginGeneratedSerialDescriptor.addElement("privacy_friends_list_desc", true);
        pluginGeneratedSerialDescriptor.addElement("show_friend_code", true);
        pluginGeneratedSerialDescriptor.addElement("friend_code_meta_config_enabled", true);
        pluginGeneratedSerialDescriptor.addElement("community_public_image_url", true);
        pluginGeneratedSerialDescriptor.addElement("privacy_help_message", true);
        pluginGeneratedSerialDescriptor.addElement("privacy_step_instructions", true);
        pluginGeneratedSerialDescriptor.addElement("privacy_warning_message", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private SteamPrivacyResponse$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final SteamPrivacyResponse deserialize(Decoder decoder) {
        Long l;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Integer num;
        String str8;
        Integer num2;
        String str9;
        int i;
        Integer num3;
        String str10;
        Boolean bool;
        Boolean bool2;
        String str11;
        int i2;
        String str12;
        Integer num4;
        String str13;
        Integer num5;
        Integer num6;
        String str14;
        String str15;
        Integer num7;
        int i3;
        int i4;
        String str16;
        Integer num8;
        String str17;
        String str18;
        String str19;
        Integer num9;
        String str20;
        Integer num10;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 2);
            String str21 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, (Object) null);
            Integer num11 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, IntSerializer.INSTANCE, (Object) null);
            String str22 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, (Object) null);
            Integer num12 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, IntSerializer.INSTANCE, (Object) null);
            String str23 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, (Object) null);
            Integer num13 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, IntSerializer.INSTANCE, (Object) null);
            String str24 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, (Object) null);
            Boolean bool3 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, BooleanSerializer.INSTANCE, (Object) null);
            Boolean bool4 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 19, BooleanSerializer.INSTANCE, (Object) null);
            String str25 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 20, StringSerializer.INSTANCE, (Object) null);
            String str26 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 21, StringSerializer.INSTANCE, (Object) null);
            String str27 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 22, StringSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 23, StringSerializer.INSTANCE, (Object) null);
            str10 = str25;
            bool2 = bool4;
            bool = bool3;
            str11 = str24;
            num6 = num13;
            str14 = str23;
            num4 = num12;
            str12 = str22;
            num3 = num11;
            str9 = str21;
            str4 = str26;
            str3 = str27;
            l = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, LongSerializer.INSTANCE, (Object) null);
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, IntSerializer.INSTANCE, (Object) null);
            str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            num5 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, IntSerializer.INSTANCE, (Object) null);
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            i = decodeIntElement;
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, (Object) null);
            i2 = 16777215;
            num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, (Object) null);
            str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, (Object) null);
        } else {
            boolean z = true;
            int i5 = 0;
            String str28 = null;
            Integer num14 = null;
            String str29 = null;
            String str30 = null;
            Boolean bool5 = null;
            String str31 = null;
            Boolean bool6 = null;
            String str32 = null;
            Integer num15 = null;
            Integer num16 = null;
            String str33 = null;
            String str34 = null;
            Long l2 = null;
            String str35 = null;
            String str36 = null;
            String str37 = null;
            String str38 = null;
            Integer num17 = null;
            String str39 = null;
            Integer num18 = null;
            String str40 = null;
            Integer num19 = null;
            String str41 = null;
            int i6 = 0;
            while (z) {
                String str42 = str33;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        str16 = str29;
                        num8 = num16;
                        str17 = str42;
                        z = false;
                        str28 = str28;
                        str33 = str17;
                        num16 = num8;
                        str29 = str16;
                        break;
                    case 0:
                        str16 = str29;
                        num8 = num16;
                        str17 = str42;
                        l2 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, LongSerializer.INSTANCE, l2);
                        i6 |= 1;
                        str28 = str28;
                        num14 = num14;
                        str33 = str17;
                        num16 = num8;
                        str29 = str16;
                        break;
                    case 1:
                        str18 = str42;
                        str35 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str35);
                        i6 |= 2;
                        num16 = num16;
                        str29 = str29;
                        str28 = str28;
                        num14 = num14;
                        str36 = str36;
                        str33 = str18;
                        break;
                    case 2:
                        str19 = str28;
                        num9 = num14;
                        str20 = str29;
                        num10 = num16;
                        str18 = str42;
                        i5 = beginStructure.decodeIntElement(serialDescriptor, 2);
                        i6 |= 4;
                        num16 = num10;
                        str29 = str20;
                        str28 = str19;
                        num14 = num9;
                        str33 = str18;
                        break;
                    case 3:
                        str18 = str42;
                        str36 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str36);
                        i6 |= 8;
                        num16 = num16;
                        str29 = str29;
                        str28 = str28;
                        num14 = num14;
                        str37 = str37;
                        str33 = str18;
                        break;
                    case 4:
                        str18 = str42;
                        str37 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str37);
                        i6 |= 16;
                        num16 = num16;
                        str29 = str29;
                        str28 = str28;
                        num14 = num14;
                        str38 = str38;
                        str33 = str18;
                        break;
                    case 5:
                        str18 = str42;
                        str38 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str38);
                        i6 |= 32;
                        num16 = num16;
                        str29 = str29;
                        str28 = str28;
                        num14 = num14;
                        num17 = num17;
                        str33 = str18;
                        break;
                    case 6:
                        str18 = str42;
                        num17 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, IntSerializer.INSTANCE, num17);
                        i6 |= 64;
                        num16 = num16;
                        str29 = str29;
                        str28 = str28;
                        num14 = num14;
                        str39 = str39;
                        str33 = str18;
                        break;
                    case 7:
                        str18 = str42;
                        str39 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str39);
                        i6 |= 128;
                        num16 = num16;
                        str29 = str29;
                        str28 = str28;
                        num14 = num14;
                        num18 = num18;
                        str33 = str18;
                        break;
                    case 8:
                        str18 = str42;
                        num18 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, IntSerializer.INSTANCE, num18);
                        i6 |= 256;
                        num16 = num16;
                        str29 = str29;
                        str28 = str28;
                        num14 = num14;
                        str40 = str40;
                        str33 = str18;
                        break;
                    case 9:
                        str18 = str42;
                        str40 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str40);
                        i6 |= 512;
                        num16 = num16;
                        str29 = str29;
                        str28 = str28;
                        num14 = num14;
                        num19 = num19;
                        str33 = str18;
                        break;
                    case 10:
                        str19 = str28;
                        num9 = num14;
                        str20 = str29;
                        num10 = num16;
                        str18 = str42;
                        num19 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, IntSerializer.INSTANCE, num19);
                        i6 |= 1024;
                        num16 = num10;
                        str29 = str20;
                        str28 = str19;
                        num14 = num9;
                        str33 = str18;
                        break;
                    case AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER /* 11 */:
                        i6 |= 2048;
                        str33 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str42);
                        num16 = num16;
                        str29 = str29;
                        str28 = str28;
                        num14 = num14;
                        break;
                    case AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER /* 12 */:
                        num16 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, IntSerializer.INSTANCE, num16);
                        i6 |= 4096;
                        str29 = str29;
                        str28 = str28;
                        str33 = str42;
                        break;
                    case AdditionVote2.BIZ_TYPE_FIELD_NUMBER /* 13 */:
                        str15 = str29;
                        num7 = num16;
                        str28 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str28);
                        i6 |= 8192;
                        str29 = str15;
                        str33 = str42;
                        num16 = num7;
                        break;
                    case AdditionVote2.TOTAL_FIELD_NUMBER /* 14 */:
                        str15 = str29;
                        num7 = num16;
                        num14 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, IntSerializer.INSTANCE, num14);
                        i6 |= 16384;
                        str29 = str15;
                        str33 = str42;
                        num16 = num7;
                        break;
                    case AdditionVote2.CARD_TYPE_FIELD_NUMBER /* 15 */:
                        str15 = str29;
                        num7 = num16;
                        str41 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, str41);
                        i3 = 32768;
                        i6 |= i3;
                        str29 = str15;
                        str33 = str42;
                        num16 = num7;
                        break;
                    case AdditionVote2.TIPS_FIELD_NUMBER /* 16 */:
                        str15 = str29;
                        num7 = num16;
                        num15 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, IntSerializer.INSTANCE, num15);
                        i3 = 65536;
                        i6 |= i3;
                        str29 = str15;
                        str33 = str42;
                        num16 = num7;
                        break;
                    case AdditionVote2.URI_FIELD_NUMBER /* 17 */:
                        str15 = str29;
                        num7 = num16;
                        str32 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, str32);
                        i3 = 131072;
                        i6 |= i3;
                        str29 = str15;
                        str33 = str42;
                        num16 = num7;
                        break;
                    case AdditionVote2.IS_VOTED_FIELD_NUMBER /* 18 */:
                        str15 = str29;
                        num7 = num16;
                        bool5 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, BooleanSerializer.INSTANCE, bool5);
                        i3 = 262144;
                        i6 |= i3;
                        str29 = str15;
                        str33 = str42;
                        num16 = num7;
                        break;
                    case AdditionVote2.CHOICE_CNT_FIELD_NUMBER /* 19 */:
                        num7 = num16;
                        str15 = str29;
                        bool6 = (Boolean) beginStructure.decodeNullableSerializableElement(serialDescriptor, 19, BooleanSerializer.INSTANCE, bool6);
                        i3 = 524288;
                        i6 |= i3;
                        str29 = str15;
                        str33 = str42;
                        num16 = num7;
                        break;
                    case AdditionVote2.DEFAULE_SELECT_SHARE_FIELD_NUMBER /* 20 */:
                        num7 = num16;
                        str30 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 20, StringSerializer.INSTANCE, str30);
                        i4 = 1048576;
                        i6 |= i4;
                        str33 = str42;
                        num16 = num7;
                        break;
                    case AdditionVote2.ONLY_FANS_VOTE_FIELD_NUMBER /* 21 */:
                        num7 = num16;
                        str29 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 21, StringSerializer.INSTANCE, str29);
                        i4 = 2097152;
                        i6 |= i4;
                        str33 = str42;
                        num16 = num7;
                        break;
                    case AdditionVote2.VOTE_OWNER_MID_FIELD_NUMBER /* 22 */:
                        num7 = num16;
                        str34 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 22, StringSerializer.INSTANCE, str34);
                        i4 = 4194304;
                        i6 |= i4;
                        str33 = str42;
                        num16 = num7;
                        break;
                    case 23:
                        num7 = num16;
                        str31 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 23, StringSerializer.INSTANCE, str31);
                        i4 = 8388608;
                        i6 |= i4;
                        str33 = str42;
                        num16 = num7;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            String str43 = str36;
            l = l2;
            str = str31;
            str2 = str35;
            str3 = str34;
            str4 = str29;
            str5 = str43;
            str6 = str37;
            str7 = str38;
            num = num17;
            str8 = str40;
            num2 = num19;
            str9 = str33;
            i = i5;
            num3 = num16;
            str10 = str30;
            bool = bool5;
            bool2 = bool6;
            str11 = str32;
            i2 = i6;
            str12 = str28;
            num4 = num14;
            str13 = str39;
            num5 = num18;
            num6 = num15;
            str14 = str41;
        }
        beginStructure.endStructure(serialDescriptor);
        return new SteamPrivacyResponse(i2, l, str2, i, str5, str6, str7, num, str13, num5, str8, num2, str9, num3, str12, num4, str14, num6, str11, bool, bool2, str10, str4, str3, str, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, SteamPrivacyResponse value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        SteamPrivacyResponse.write$Self$gamebiz_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}