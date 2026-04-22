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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AuthorizeParams.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/game/gamebind/bean/AuthorizeParams.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/game/gamebind/bean/AuthorizeParams;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "game-bind_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AuthorizeParams$$serializer implements GeneratedSerializer<AuthorizeParams> {
    public static final AuthorizeParams$$serializer INSTANCE = new AuthorizeParams$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.game.gamebind.bean.AuthorizeParams", INSTANCE, 10);
        pluginGeneratedSerialDescriptor.addElement("gameBaseId", false);
        pluginGeneratedSerialDescriptor.addElement("gameName", false);
        pluginGeneratedSerialDescriptor.addElement("icon", false);
        pluginGeneratedSerialDescriptor.addElement("distributorChannelId", false);
        pluginGeneratedSerialDescriptor.addElement("distributorChannelName", false);
        pluginGeneratedSerialDescriptor.addElement("authStatus", false);
        pluginGeneratedSerialDescriptor.addElement("onlyAuth", true);
        pluginGeneratedSerialDescriptor.addElement("bindMethodType", true);
        pluginGeneratedSerialDescriptor.addElement("gameInfo", true);
        pluginGeneratedSerialDescriptor.addElement("fromRoleList", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AuthorizeParams$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, BooleanSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(KBiligame$.serializer.INSTANCE), BooleanSerializer.INSTANCE};
    }

    public final AuthorizeParams deserialize(Decoder decoder) {
        int i;
        boolean z;
        String str;
        KBiligame kBiligame;
        int i2;
        String str2;
        int i3;
        String str3;
        boolean z2;
        String str4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i4 = 9;
        int i5 = 0;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 2);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 3);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 4);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 5);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 6);
            int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 7);
            i5 = 1023;
            str2 = decodeStringElement;
            z = beginStructure.decodeBooleanElement(serialDescriptor, 9);
            i2 = decodeIntElement3;
            z2 = decodeBooleanElement;
            i3 = decodeIntElement2;
            i = decodeIntElement;
            kBiligame = (KBiligame) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, KBiligame$.serializer.INSTANCE, (Object) null);
            str = decodeStringElement4;
            str3 = decodeStringElement3;
            str4 = decodeStringElement2;
        } else {
            boolean z3 = true;
            boolean z4 = false;
            boolean z5 = false;
            int i6 = 0;
            i = 0;
            KBiligame kBiligame2 = null;
            String str5 = null;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            int i7 = 0;
            while (z3) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z3 = false;
                        i4 = 9;
                        break;
                    case 0:
                        str5 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i5 |= 1;
                        i4 = 9;
                        break;
                    case 1:
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i5 |= 2;
                        i4 = 9;
                        break;
                    case 2:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i5 |= 4;
                        break;
                    case 3:
                        i = beginStructure.decodeIntElement(serialDescriptor, 3);
                        i5 |= 8;
                        break;
                    case 4:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i5 |= 16;
                        break;
                    case 5:
                        i6 = beginStructure.decodeIntElement(serialDescriptor, 5);
                        i5 |= 32;
                        break;
                    case 6:
                        z5 = beginStructure.decodeBooleanElement(serialDescriptor, 6);
                        i5 |= 64;
                        break;
                    case 7:
                        i7 = beginStructure.decodeIntElement(serialDescriptor, 7);
                        i5 |= 128;
                        break;
                    case 8:
                        kBiligame2 = (KBiligame) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, KBiligame$.serializer.INSTANCE, kBiligame2);
                        i5 |= 256;
                        break;
                    case 9:
                        z4 = beginStructure.decodeBooleanElement(serialDescriptor, i4);
                        i5 |= 512;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            z = z4;
            str = str8;
            kBiligame = kBiligame2;
            String str9 = str7;
            i2 = i7;
            str2 = str5;
            i3 = i6;
            str3 = str9;
            String str10 = str6;
            z2 = z5;
            str4 = str10;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AuthorizeParams(i5, str2, str4, str3, i, str, i3, z2, i2, kBiligame, z, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, AuthorizeParams value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AuthorizeParams.write$Self$game_bind_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}