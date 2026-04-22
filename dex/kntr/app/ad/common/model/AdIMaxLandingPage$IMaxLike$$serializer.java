package kntr.app.ad.common.model;

import kntr.app.ad.common.model.AdIMaxLandingPage;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: AdIMaxLandingPage.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/ad/common/model/AdIMaxLandingPage.IMaxLike.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/ad/common/model/AdIMaxLandingPage$IMaxLike;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AdIMaxLandingPage$IMaxLike$$serializer implements GeneratedSerializer<AdIMaxLandingPage.IMaxLike> {
    public static final AdIMaxLandingPage$IMaxLike$$serializer INSTANCE = new AdIMaxLandingPage$IMaxLike$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.common.model.AdIMaxLandingPage.IMaxLike", INSTANCE, 5);
        pluginGeneratedSerialDescriptor.addElement("avid", true);
        pluginGeneratedSerialDescriptor.addElement("likeNumber", true);
        pluginGeneratedSerialDescriptor.addElement("dislikeNumber", true);
        pluginGeneratedSerialDescriptor.addElement("hasLike", true);
        pluginGeneratedSerialDescriptor.addElement("hasDislike", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdIMaxLandingPage$IMaxLike$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LongSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE};
    }

    public final AdIMaxLandingPage.IMaxLike deserialize(Decoder decoder) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        long j2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 0);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 1);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 2);
            i4 = decodeIntElement;
            i = beginStructure.decodeIntElement(serialDescriptor, 3);
            i2 = beginStructure.decodeIntElement(serialDescriptor, 4);
            i5 = decodeIntElement2;
            i3 = 31;
            j2 = decodeLongElement;
        } else {
            boolean z = true;
            int i6 = 0;
            int i7 = 0;
            int i8 = 0;
            long j3 = 0;
            int i9 = 0;
            int i10 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z = false;
                        continue;
                    case 0:
                        j3 = beginStructure.decodeLongElement(serialDescriptor, 0);
                        i8 |= 1;
                        continue;
                    case 1:
                        i6 = beginStructure.decodeIntElement(serialDescriptor, 1);
                        i8 |= 2;
                        break;
                    case 2:
                        i7 = beginStructure.decodeIntElement(serialDescriptor, 2);
                        i8 |= 4;
                        break;
                    case 3:
                        i9 = beginStructure.decodeIntElement(serialDescriptor, 3);
                        i8 |= 8;
                        break;
                    case 4:
                        i10 = beginStructure.decodeIntElement(serialDescriptor, 4);
                        i8 |= 16;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i9;
            i2 = i10;
            i3 = i8;
            long j4 = j3;
            i4 = i6;
            i5 = i7;
            j2 = j4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AdIMaxLandingPage.IMaxLike(i3, j2, i4, i5, i, i2, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, AdIMaxLandingPage.IMaxLike value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AdIMaxLandingPage.IMaxLike.write$Self$dto_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}