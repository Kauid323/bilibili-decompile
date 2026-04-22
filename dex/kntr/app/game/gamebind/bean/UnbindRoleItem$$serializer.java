package kntr.app.game.gamebind.bean;

import com.bilibili.biligame.kntr.common.bean.KBiligame;
import com.bilibili.biligame.kntr.common.bean.KBiligame$;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: UnbindRoleItem.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/game/gamebind/bean/UnbindRoleItem.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/game/gamebind/bean/UnbindRoleItem;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class UnbindRoleItem$$serializer implements GeneratedSerializer<UnbindRoleItem> {
    public static final UnbindRoleItem$$serializer INSTANCE = new UnbindRoleItem$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.game.gamebind.bean.UnbindRoleItem", INSTANCE, 11);
        pluginGeneratedSerialDescriptor.addElement("game_base_id", false);
        pluginGeneratedSerialDescriptor.addElement("game_name", false);
        pluginGeneratedSerialDescriptor.addElement("icon", false);
        pluginGeneratedSerialDescriptor.addElement("distributor_channel_id", true);
        pluginGeneratedSerialDescriptor.addElement("distributor_channel_name", true);
        pluginGeneratedSerialDescriptor.addElement("background_color", true);
        pluginGeneratedSerialDescriptor.addElement("background_image", true);
        pluginGeneratedSerialDescriptor.addElement("bind_method_type", true);
        pluginGeneratedSerialDescriptor.addElement("auth_status", true);
        pluginGeneratedSerialDescriptor.addElement("game_download", true);
        pluginGeneratedSerialDescriptor.addElement("role_image", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private UnbindRoleItem$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{IntSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(KBiligame$.serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final UnbindRoleItem deserialize(Decoder decoder) {
        int i;
        int i2;
        int i3;
        String str;
        String str2;
        String str3;
        String str4;
        int i4;
        String str5;
        int i5;
        KBiligame kBiligame;
        String str6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i6 = 10;
        int i7 = 0;
        if (beginStructure.decodeSequentially()) {
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 0);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 1);
            str2 = beginStructure.decodeStringElement(serialDescriptor, 2);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 3);
            int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 7);
            int decodeIntElement4 = beginStructure.decodeIntElement(serialDescriptor, 8);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, (Object) null);
            kBiligame = (KBiligame) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, KBiligame$.serializer.INSTANCE, (Object) null);
            i3 = decodeIntElement3;
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            i2 = decodeIntElement4;
            i = decodeIntElement;
            i5 = decodeIntElement2;
            i4 = 2047;
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            str6 = decodeStringElement;
        } else {
            boolean z = true;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            String str7 = null;
            String str8 = null;
            KBiligame kBiligame2 = null;
            String str9 = null;
            String str10 = null;
            String str11 = null;
            String str12 = null;
            int i11 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z = false;
                        i6 = 10;
                        break;
                    case 0:
                        i7 |= 1;
                        i8 = beginStructure.decodeIntElement(serialDescriptor, 0);
                        i6 = 10;
                        break;
                    case 1:
                        str11 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i7 |= 2;
                        i6 = 10;
                        break;
                    case 2:
                        str12 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i7 |= 4;
                        i6 = 10;
                        break;
                    case 3:
                        i9 = beginStructure.decodeIntElement(serialDescriptor, 3);
                        i7 |= 8;
                        i6 = 10;
                        break;
                    case 4:
                        str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str10);
                        i7 |= 16;
                        i6 = 10;
                        break;
                    case 5:
                        str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str9);
                        i7 |= 32;
                        i6 = 10;
                        break;
                    case 6:
                        str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str8);
                        i7 |= 64;
                        i6 = 10;
                        continue;
                    case 7:
                        i11 = beginStructure.decodeIntElement(serialDescriptor, 7);
                        i7 |= 128;
                        break;
                    case 8:
                        i10 = beginStructure.decodeIntElement(serialDescriptor, 8);
                        i7 |= 256;
                        break;
                    case 9:
                        kBiligame2 = (KBiligame) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, KBiligame$.serializer.INSTANCE, kBiligame2);
                        i7 |= 512;
                        break;
                    case 10:
                        str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i6, StringSerializer.INSTANCE, str7);
                        i7 |= 1024;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i8;
            i2 = i10;
            i3 = i11;
            str = str9;
            str2 = str12;
            str3 = str7;
            int i12 = i9;
            str4 = str8;
            i4 = i7;
            str5 = str10;
            i5 = i12;
            String str13 = str11;
            kBiligame = kBiligame2;
            str6 = str13;
        }
        beginStructure.endStructure(serialDescriptor);
        return new UnbindRoleItem(i4, i, str6, str2, i5, str5, str, str4, i3, i2, kBiligame, str3, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, UnbindRoleItem value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        UnbindRoleItem.write$Self$game_bind_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}