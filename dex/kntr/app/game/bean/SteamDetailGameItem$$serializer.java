package kntr.app.game.bean;

import kntr.app.game.base.ui.widget.gameaction.state.GameActionStateKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: SteamDetailBean.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/game/bean/SteamDetailGameItem.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/game/bean/SteamDetailGameItem;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class SteamDetailGameItem$$serializer implements GeneratedSerializer<SteamDetailGameItem> {
    public static final int $stable;
    public static final SteamDetailGameItem$$serializer INSTANCE = new SteamDetailGameItem$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.game.bean.SteamDetailGameItem", INSTANCE, 11);
        pluginGeneratedSerialDescriptor.addElement("app_id", true);
        pluginGeneratedSerialDescriptor.addElement("app_name", true);
        pluginGeneratedSerialDescriptor.addElement("app_icon", true);
        pluginGeneratedSerialDescriptor.addElement("app_price", true);
        pluginGeneratedSerialDescriptor.addElement("app_achievements_count", true);
        pluginGeneratedSerialDescriptor.addElement("owned_achievements_count", true);
        pluginGeneratedSerialDescriptor.addElement("playtime_forever", true);
        pluginGeneratedSerialDescriptor.addElement("playtime_forever_hours", true);
        pluginGeneratedSerialDescriptor.addElement("playtime_last2weeks", true);
        pluginGeneratedSerialDescriptor.addElement("playtime_last2weeks_hours", true);
        pluginGeneratedSerialDescriptor.addElement("more_than_percent", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private SteamDetailGameItem$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, StringSerializer.INSTANCE, DoubleSerializer.INSTANCE, StringSerializer.INSTANCE, DoubleSerializer.INSTANCE, IntSerializer.INSTANCE};
    }

    public final SteamDetailGameItem deserialize(Decoder decoder) {
        double d;
        String str;
        int i;
        int i2;
        String str2;
        String str3;
        double d2;
        String str4;
        String str5;
        int i3;
        int i4;
        int i5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i6 = 0;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 2);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 3);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 4);
            int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 5);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 6);
            double decodeDoubleElement = beginStructure.decodeDoubleElement(serialDescriptor, 7);
            String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 8);
            double decodeDoubleElement2 = beginStructure.decodeDoubleElement(serialDescriptor, 9);
            i = beginStructure.decodeIntElement(serialDescriptor, 10);
            str2 = decodeStringElement5;
            str4 = decodeStringElement4;
            i3 = decodeIntElement3;
            i4 = decodeIntElement;
            i5 = decodeIntElement2;
            str5 = decodeStringElement3;
            d2 = decodeDoubleElement;
            d = decodeDoubleElement2;
            str = decodeStringElement;
            i2 = 2047;
            str3 = decodeStringElement2;
        } else {
            String str6 = null;
            String str7 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            boolean z = true;
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            double d3 = 0.0d;
            d = 0.0d;
            int i10 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z = false;
                        continue;
                    case 0:
                        i6 |= 1;
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        continue;
                    case 1:
                        str10 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i6 |= 2;
                        continue;
                    case 2:
                        str9 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i6 |= 4;
                        break;
                    case 3:
                        i8 = beginStructure.decodeIntElement(serialDescriptor, 3);
                        i6 |= 8;
                        break;
                    case 4:
                        i9 = beginStructure.decodeIntElement(serialDescriptor, 4);
                        i6 |= 16;
                        break;
                    case 5:
                        i7 = beginStructure.decodeIntElement(serialDescriptor, 5);
                        i6 |= 32;
                        break;
                    case 6:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 6);
                        i6 |= 64;
                        break;
                    case 7:
                        d3 = beginStructure.decodeDoubleElement(serialDescriptor, 7);
                        i6 |= 128;
                        break;
                    case 8:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 8);
                        i6 |= 256;
                        break;
                    case 9:
                        d = beginStructure.decodeDoubleElement(serialDescriptor, 9);
                        i6 |= 512;
                        break;
                    case 10:
                        i10 = beginStructure.decodeIntElement(serialDescriptor, 10);
                        i6 |= 1024;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str6;
            i = i10;
            i2 = i6;
            str2 = str7;
            str3 = str10;
            d2 = d3;
            String str11 = str9;
            str4 = str8;
            str5 = str11;
            int i11 = i9;
            i3 = i7;
            i4 = i8;
            i5 = i11;
        }
        beginStructure.endStructure(serialDescriptor);
        return new SteamDetailGameItem(i2, str, str3, str5, i4, i5, i3, str4, d2, str2, d, i, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, SteamDetailGameItem value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        SteamDetailGameItem.write$Self$gamebiz_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}