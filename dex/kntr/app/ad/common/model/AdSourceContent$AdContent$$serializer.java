package kntr.app.ad.common.model;

import kntr.app.ad.common.model.AdSourceContent;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
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

/* compiled from: AdSourceContent.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/ad/common/model/AdSourceContent.AdContent.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/ad/common/model/AdSourceContent$AdContent;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "dto_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class AdSourceContent$AdContent$$serializer implements GeneratedSerializer<AdSourceContent.AdContent> {
    public static final AdSourceContent$AdContent$$serializer INSTANCE = new AdSourceContent$AdContent$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.common.model.AdSourceContent.AdContent", INSTANCE, 6);
        pluginGeneratedSerialDescriptor.addElement(ReportBuildInParam.CREATIVE_ID, true);
        pluginGeneratedSerialDescriptor.addElement(ReportBuildInParam.CREATIVE_TYPE, true);
        pluginGeneratedSerialDescriptor.addElement("ad_cb", true);
        pluginGeneratedSerialDescriptor.addElement(ReportBuildInParam.IS_AD, true);
        pluginGeneratedSerialDescriptor.addElement(ReportBuildInParam.CM_MARK, true);
        pluginGeneratedSerialDescriptor.addElement("extra", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdSourceContent$AdContent$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LongSerializer.INSTANCE, LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BooleanSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(AdInfoExtra$$serializer.INSTANCE)};
    }

    public final AdSourceContent.AdContent deserialize(Decoder decoder) {
        int i;
        int i2;
        AdInfoExtra adInfoExtra;
        boolean z;
        String str;
        long j2;
        long j3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 0);
            long decodeLongElement2 = beginStructure.decodeLongElement(serialDescriptor, 1);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 3);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 4);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            adInfoExtra = (AdInfoExtra) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, AdInfoExtra$$serializer.INSTANCE, (Object) null);
            z = decodeBooleanElement;
            i2 = decodeIntElement;
            j2 = decodeLongElement2;
            j3 = decodeLongElement;
            i = 63;
        } else {
            boolean z2 = true;
            boolean z3 = false;
            String str2 = null;
            AdInfoExtra adInfoExtra2 = null;
            long j4 = 0;
            int i3 = 0;
            long j5 = 0;
            i = 0;
            while (z2) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z2 = false;
                        continue;
                    case 0:
                        j4 = beginStructure.decodeLongElement(serialDescriptor, 0);
                        i |= 1;
                        continue;
                    case 1:
                        j5 = beginStructure.decodeLongElement(serialDescriptor, 1);
                        i |= 2;
                        break;
                    case 2:
                        str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str2);
                        i |= 4;
                        break;
                    case 3:
                        z3 = beginStructure.decodeBooleanElement(serialDescriptor, 3);
                        i |= 8;
                        break;
                    case 4:
                        i3 = beginStructure.decodeIntElement(serialDescriptor, 4);
                        i |= 16;
                        break;
                    case 5:
                        adInfoExtra2 = (AdInfoExtra) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, AdInfoExtra$$serializer.INSTANCE, adInfoExtra2);
                        i |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i2 = i3;
            adInfoExtra = adInfoExtra2;
            long j6 = j4;
            z = z3;
            str = str2;
            j2 = j5;
            j3 = j6;
        }
        beginStructure.endStructure(serialDescriptor);
        return new AdSourceContent.AdContent(i, j3, j2, str, z, i2, adInfoExtra, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, AdSourceContent.AdContent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        AdSourceContent.AdContent.write$Self$dto_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}