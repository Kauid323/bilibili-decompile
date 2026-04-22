package kntr.app.digital.preview.api;

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
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

/* compiled from: CardPreviewModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/digital/preview/api/CardPreviewModel.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/digital/preview/api/CardPreviewModel;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class CardPreviewModel$$serializer implements GeneratedSerializer<CardPreviewModel> {
    public static final int $stable;
    public static final CardPreviewModel$$serializer INSTANCE = new CardPreviewModel$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.digital.preview.api.CardPreviewModel", INSTANCE, 7);
        pluginGeneratedSerialDescriptor.addElement("result", true);
        pluginGeneratedSerialDescriptor.addElement("extra", false);
        pluginGeneratedSerialDescriptor.addElement("front_has_more", true);
        pluginGeneratedSerialDescriptor.addElement("back_has_more", true);
        pluginGeneratedSerialDescriptor.addElement("back_anchor_id", true);
        pluginGeneratedSerialDescriptor.addElement("front_anchor_id", true);
        pluginGeneratedSerialDescriptor.addElement("permanent_activity_status", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private CardPreviewModel$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = CardPreviewModel.$childSerializers;
        return new KSerializer[]{lazyArr[0].getValue(), JsonElementSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, IntSerializer.INSTANCE};
    }

    public final CardPreviewModel deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        String str;
        String str2;
        int i;
        boolean z;
        int i2;
        JsonElement jsonElement;
        boolean z2;
        List list;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = CardPreviewModel.$childSerializers;
        int i3 = 6;
        if (beginStructure.decodeSequentially()) {
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 2);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 4);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 5);
            list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), (Object) null);
            jsonElement = (JsonElement) beginStructure.decodeSerializableElement(serialDescriptor, 1, JsonElementSerializer.INSTANCE, (Object) null);
            i = beginStructure.decodeIntElement(serialDescriptor, 6);
            str2 = decodeStringElement2;
            z = decodeBooleanElement2;
            str = decodeStringElement;
            z2 = decodeBooleanElement;
            i2 = 127;
        } else {
            boolean z3 = true;
            int i4 = 0;
            boolean z4 = false;
            int i5 = 0;
            List list2 = null;
            str = null;
            str2 = null;
            JsonElement jsonElement2 = null;
            boolean z5 = false;
            while (z3) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z3 = false;
                        i3 = 6;
                        break;
                    case 0:
                        list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), list2);
                        i5 |= 1;
                        i3 = 6;
                        break;
                    case 1:
                        jsonElement2 = (JsonElement) beginStructure.decodeSerializableElement(serialDescriptor, 1, JsonElementSerializer.INSTANCE, jsonElement2);
                        i5 |= 2;
                        i3 = 6;
                        continue;
                    case 2:
                        z4 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                        i5 |= 4;
                        break;
                    case 3:
                        z5 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
                        i5 |= 8;
                        break;
                    case 4:
                        str = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i5 |= 16;
                        break;
                    case 5:
                        str2 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i5 |= 32;
                        break;
                    case 6:
                        i4 = beginStructure.decodeIntElement(serialDescriptor, i3);
                        i5 |= 64;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i4;
            z = z5;
            i2 = i5;
            jsonElement = jsonElement2;
            List list3 = list2;
            z2 = z4;
            list = list3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new CardPreviewModel(i2, list, jsonElement, z2, z, str, str2, i, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, CardPreviewModel value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        CardPreviewModel.write$Self$preview_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}