package kntr.app.game.bean;

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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: SteamGameBean.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/game/bean/AchievementItem.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/game/bean/AchievementItem;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AchievementItem$$serializer implements GeneratedSerializer<AchievementItem> {
    public static final int $stable;
    public static final AchievementItem$$serializer INSTANCE = new AchievementItem$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.game.bean.AchievementItem", INSTANCE, 8);
        pluginGeneratedSerialDescriptor.addElement("apiname", true);
        pluginGeneratedSerialDescriptor.addElement("name", true);
        pluginGeneratedSerialDescriptor.addElement("icon_url", true);
        pluginGeneratedSerialDescriptor.addElement("achieved", true);
        pluginGeneratedSerialDescriptor.addElement("is_rare", true);
        pluginGeneratedSerialDescriptor.addElement("achieve_percent_formatted", true);
        pluginGeneratedSerialDescriptor.addElement("unlock_time", true);
        pluginGeneratedSerialDescriptor.addElement("unlock_time_formatted", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private AchievementItem$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final AchievementItem deserialize(Decoder decoder) {
        String str;
        String str2;
        Long l;
        int i;
        String str3;
        boolean z;
        boolean z2;
        String str4;
        String str5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 2);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 3);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 4);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 5);
            i = 255;
            str4 = decodeStringElement;
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, (Object) null);
            l = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, LongSerializer.INSTANCE, (Object) null);
            str = decodeStringElement4;
            z = decodeBooleanElement;
            z2 = decodeBooleanElement2;
            str5 = decodeStringElement3;
            str3 = decodeStringElement2;
        } else {
            boolean z3 = true;
            boolean z4 = false;
            int i2 = 0;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            str = null;
            Long l2 = null;
            boolean z5 = false;
            while (z3) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z3 = false;
                        continue;
                    case 0:
                        i2 |= 1;
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        continue;
                    case 1:
                        i2 |= 2;
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        continue;
                    case 2:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i2 |= 4;
                        continue;
                    case 3:
                        z4 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
                        i2 |= 8;
                        break;
                    case 4:
                        z5 = beginStructure.decodeBooleanElement(serialDescriptor, 4);
                        i2 |= 16;
                        break;
                    case 5:
                        str = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i2 |= 32;
                        break;
                    case 6:
                        l2 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, LongSerializer.INSTANCE, l2);
                        i2 |= 64;
                        break;
                    case 7:
                        str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str6);
                        i2 |= 128;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str2 = str6;
            l = l2;
            i = i2;
            str3 = str8;
            z = z4;
            String str10 = str9;
            z2 = z5;
            str4 = str7;
            str5 = str10;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AchievementItem(i, str4, str3, str5, z, z2, str, l, str2, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, AchievementItem value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AchievementItem.write$Self$gamebiz_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}