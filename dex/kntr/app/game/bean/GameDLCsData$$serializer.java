package kntr.app.game.bean;

import java.util.List;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: SteamGameDLCBean.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/game/bean/GameDLCsData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/game/bean/GameDLCsData;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "gamebiz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class GameDLCsData$$serializer implements GeneratedSerializer<GameDLCsData> {
    public static final int $stable;
    public static final GameDLCsData$$serializer INSTANCE = new GameDLCsData$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.game.bean.GameDLCsData", INSTANCE, 4);
        pluginGeneratedSerialDescriptor.addElement("header", true);
        pluginGeneratedSerialDescriptor.addElement("total_count", true);
        pluginGeneratedSerialDescriptor.addElement("dlcs", true);
        pluginGeneratedSerialDescriptor.addElement("dlc_update_time", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private GameDLCsData$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = GameDLCsData.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(DLCHeader$$serializer.INSTANCE), IntSerializer.INSTANCE, lazyArr[2].getValue(), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE)};
    }

    public final GameDLCsData deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        int i;
        int i2;
        DLCHeader dLCHeader;
        List list;
        Long l;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = GameDLCsData.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            dLCHeader = (DLCHeader) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, DLCHeader$$serializer.INSTANCE, (Object) null);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 1);
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), (Object) null);
            i = 15;
            l = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, LongSerializer.INSTANCE, (Object) null);
            i2 = decodeIntElement;
        } else {
            boolean z = true;
            int i3 = 0;
            DLCHeader dLCHeader2 = null;
            List list2 = null;
            Long l2 = null;
            int i4 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z = false;
                        break;
                    case 0:
                        dLCHeader2 = (DLCHeader) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, DLCHeader$$serializer.INSTANCE, dLCHeader2);
                        i3 |= 1;
                        break;
                    case 1:
                        i4 = beginStructure.decodeIntElement(serialDescriptor, 1);
                        i3 |= 2;
                        break;
                    case 2:
                        list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 2, (DeserializationStrategy) lazyArr[2].getValue(), list2);
                        i3 |= 4;
                        break;
                    case 3:
                        l2 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, LongSerializer.INSTANCE, l2);
                        i3 |= 8;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i3;
            i2 = i4;
            dLCHeader = dLCHeader2;
            list = list2;
            l = l2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new GameDLCsData(i, dLCHeader, i2, list, l, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, GameDLCsData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        GameDLCsData.write$Self$gamebiz_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}