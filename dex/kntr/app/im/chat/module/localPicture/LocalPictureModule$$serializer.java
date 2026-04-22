package kntr.app.im.chat.module.localPicture;

import kntr.app.game.base.ui.widget.gameaction.state.GameActionStateKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.photonic.Orientation;
import kntr.common.photonic.Resolution;
import kntr.common.photonic.Resolution$;
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
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: LocalPictureModule.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/im/chat/module/localPicture/LocalPictureModule.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/im/chat/module/localPicture/LocalPictureModule;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class LocalPictureModule$$serializer implements GeneratedSerializer<LocalPictureModule> {
    public static final int $stable;
    public static final LocalPictureModule$$serializer INSTANCE = new LocalPictureModule$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.im.chat.module.localPicture.LocalPictureModule", INSTANCE, 7);
        pluginGeneratedSerialDescriptor.addElement("assetId", false);
        pluginGeneratedSerialDescriptor.addElement("uploadProgress", true);
        pluginGeneratedSerialDescriptor.addElement("assetFqn", true);
        pluginGeneratedSerialDescriptor.addElement("resolution", true);
        pluginGeneratedSerialDescriptor.addElement("orientation", true);
        pluginGeneratedSerialDescriptor.addElement("useOriginImage", true);
        pluginGeneratedSerialDescriptor.addElement("mimeTypeStr", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private LocalPictureModule$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = LocalPictureModule.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, FloatSerializer.INSTANCE, StringSerializer.INSTANCE, Resolution$.serializer.INSTANCE, lazyArr[4].getValue(), BooleanSerializer.INSTANCE, StringSerializer.INSTANCE};
    }

    public final LocalPictureModule deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        boolean z;
        String str;
        Orientation orientation;
        int i;
        float f;
        String str2;
        Resolution resolution;
        String str3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = LocalPictureModule.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            float decodeFloatElement = beginStructure.decodeFloatElement(serialDescriptor, 1);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 2);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 5);
            orientation = (Orientation) beginStructure.decodeSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), (Object) null);
            str3 = decodeStringElement;
            str = beginStructure.decodeStringElement(serialDescriptor, 6);
            z = decodeBooleanElement;
            resolution = (Resolution) beginStructure.decodeSerializableElement(serialDescriptor, 3, Resolution$.serializer.INSTANCE, (Object) null);
            str2 = decodeStringElement2;
            f = decodeFloatElement;
            i = 127;
        } else {
            float f2 = 0.0f;
            boolean z2 = true;
            boolean z3 = false;
            Orientation orientation2 = null;
            String str4 = null;
            String str5 = null;
            String str6 = null;
            Resolution resolution2 = null;
            int i2 = 0;
            while (z2) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z2 = false;
                        continue;
                    case 0:
                        i2 |= 1;
                        str4 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        continue;
                    case 1:
                        i2 |= 2;
                        f2 = beginStructure.decodeFloatElement(serialDescriptor, 1);
                        continue;
                    case 2:
                        str5 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i2 |= 4;
                        continue;
                    case 3:
                        resolution2 = (Resolution) beginStructure.decodeSerializableElement(serialDescriptor, 3, Resolution$.serializer.INSTANCE, resolution2);
                        i2 |= 8;
                        break;
                    case 4:
                        orientation2 = (Orientation) beginStructure.decodeSerializableElement(serialDescriptor, 4, (DeserializationStrategy) lazyArr[4].getValue(), orientation2);
                        i2 |= 16;
                        break;
                    case 5:
                        z3 = beginStructure.decodeBooleanElement(serialDescriptor, 5);
                        i2 |= 32;
                        break;
                    case 6:
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 6);
                        i2 |= 64;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            z = z3;
            str = str6;
            String str7 = str5;
            orientation = orientation2;
            i = i2;
            f = f2;
            str2 = str7;
            String str8 = str4;
            resolution = resolution2;
            str3 = str8;
        }
        beginStructure.endStructure(serialDescriptor);
        return new LocalPictureModule(i, str3, f, str2, resolution, orientation, z, str, null);
    }

    public final void serialize(Encoder encoder, LocalPictureModule value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        LocalPictureModule.write$Self$biz_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}