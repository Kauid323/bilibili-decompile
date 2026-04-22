package kntr.app.digital.preview.usage;

import com.bilibili.ogv.bpf.serialization.BooleanAsIntSerializer;
import java.lang.annotation.Annotation;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: UsageMenuData.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/digital/preview/usage/HeaderChanged.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/digital/preview/usage/HeaderChanged;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class HeaderChanged$$serializer implements GeneratedSerializer<HeaderChanged> {
    public static final int $stable;
    public static final HeaderChanged$$serializer INSTANCE = new HeaderChanged$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("change_header", INSTANCE, 5);
        pluginGeneratedSerialDescriptor.addElement("title", true);
        pluginGeneratedSerialDescriptor.addElement("can_set", true);
        pluginGeneratedSerialDescriptor.addElement("click_toast", true);
        pluginGeneratedSerialDescriptor.addElement("tips", true);
        pluginGeneratedSerialDescriptor.addElement("data", false);
        pluginGeneratedSerialDescriptor.pushClassAnnotation((Annotation) new UsageMenuItem$Companion$annotationImpl$kotlinx_serialization_json_JsonClassDiscriminator$0("action_type"));
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private HeaderChanged$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, BooleanAsIntSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(Badge$$serializer.INSTANCE), ChangeHeaderAction$$serializer.INSTANCE};
    }

    public final HeaderChanged deserialize(Decoder decoder) {
        boolean z;
        int i;
        String str;
        String str2;
        Badge badge;
        ChangeHeaderAction changeHeaderAction;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            boolean booleanValue = ((Boolean) beginStructure.decodeSerializableElement(serialDescriptor, 1, BooleanAsIntSerializer.INSTANCE, false)).booleanValue();
            str2 = beginStructure.decodeStringElement(serialDescriptor, 2);
            Badge badge2 = (Badge) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, Badge$$serializer.INSTANCE, (Object) null);
            str = decodeStringElement;
            i = 31;
            changeHeaderAction = (ChangeHeaderAction) beginStructure.decodeSerializableElement(serialDescriptor, 4, ChangeHeaderAction$$serializer.INSTANCE, (Object) null);
            z = booleanValue;
            badge = badge2;
        } else {
            boolean z2 = true;
            boolean z3 = false;
            String str3 = null;
            String str4 = null;
            Badge badge3 = null;
            ChangeHeaderAction changeHeaderAction2 = null;
            int i2 = 0;
            while (z2) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z2 = false;
                        break;
                    case 0:
                        str3 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i2 |= 1;
                        break;
                    case 1:
                        z3 = ((Boolean) beginStructure.decodeSerializableElement(serialDescriptor, 1, BooleanAsIntSerializer.INSTANCE, Boolean.valueOf(z3))).booleanValue();
                        i2 |= 2;
                        break;
                    case 2:
                        str4 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i2 |= 4;
                        break;
                    case 3:
                        badge3 = (Badge) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, Badge$$serializer.INSTANCE, badge3);
                        i2 |= 8;
                        break;
                    case 4:
                        changeHeaderAction2 = (ChangeHeaderAction) beginStructure.decodeSerializableElement(serialDescriptor, 4, ChangeHeaderAction$$serializer.INSTANCE, changeHeaderAction2);
                        i2 |= 16;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            z = z3;
            i = i2;
            str = str3;
            str2 = str4;
            badge = badge3;
            changeHeaderAction = changeHeaderAction2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new HeaderChanged(i, str, z, str2, badge, changeHeaderAction, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, HeaderChanged value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        HeaderChanged.write$Self$preview_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}