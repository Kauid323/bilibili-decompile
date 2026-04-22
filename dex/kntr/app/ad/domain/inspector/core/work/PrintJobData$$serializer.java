package kntr.app.ad.domain.inspector.core.work;

import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.ad.domain.inspector.core.serializer.StatusSerializer;
import kntr.app.ad.domain.inspector.model.Status;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: JobData.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/ad/domain/inspector/core/work/PrintJobData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/ad/domain/inspector/core/work/PrintJobData;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class PrintJobData$$serializer implements GeneratedSerializer<PrintJobData> {
    public static final int $stable;
    public static final PrintJobData$$serializer INSTANCE = new PrintJobData$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.domain.inspector.core.work.PrintJobData", INSTANCE, 8);
        pluginGeneratedSerialDescriptor.addElement(ReportBuildInParam.ID, false);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement(AdAlarmExtraKey.STATUS, true);
        pluginGeneratedSerialDescriptor.addElement("timestamp", true);
        pluginGeneratedSerialDescriptor.addElement("startTime", true);
        pluginGeneratedSerialDescriptor.addElement("endTime", true);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("msg", false);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private PrintJobData$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = PrintJobData.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, StatusSerializer.INSTANCE, LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), lazyArr[6].getValue(), StringSerializer.INSTANCE};
    }

    public final PrintJobData deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        PrintType printType;
        Long l;
        String str;
        String str2;
        String str3;
        long j2;
        int i;
        Long l2;
        Status status;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = PrintJobData.$childSerializers;
        int i2 = 7;
        int i3 = 5;
        String str4 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            str2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 3);
            printType = (PrintType) beginStructure.decodeSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), (Object) null);
            str = decodeStringElement;
            str3 = beginStructure.decodeStringElement(serialDescriptor, 7);
            l = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, LongSerializer.INSTANCE, (Object) null);
            status = (Status) beginStructure.decodeSerializableElement(serialDescriptor, 2, StatusSerializer.INSTANCE, (Object) null);
            j2 = decodeLongElement;
            l2 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LongSerializer.INSTANCE, (Object) null);
            i = 255;
        } else {
            boolean z = true;
            int i4 = 0;
            PrintType printType2 = null;
            Long l3 = null;
            Long l4 = null;
            String str5 = null;
            long j3 = 0;
            String str6 = null;
            Status status2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        z = false;
                        i2 = 7;
                        i3 = 5;
                        break;
                    case 0:
                        i4 |= 1;
                        str4 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i2 = 7;
                        i3 = 5;
                        break;
                    case 1:
                        str6 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i4 |= 2;
                        i2 = 7;
                        i3 = 5;
                        break;
                    case 2:
                        status2 = (Status) beginStructure.decodeSerializableElement(serialDescriptor, 2, StatusSerializer.INSTANCE, status2);
                        i4 |= 4;
                        i2 = 7;
                        i3 = 5;
                        break;
                    case 3:
                        j3 = beginStructure.decodeLongElement(serialDescriptor, 3);
                        i4 |= 8;
                        break;
                    case 4:
                        l4 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LongSerializer.INSTANCE, l4);
                        i4 |= 16;
                        break;
                    case 5:
                        l3 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, i3, LongSerializer.INSTANCE, l3);
                        i4 |= 32;
                        break;
                    case 6:
                        printType2 = (PrintType) beginStructure.decodeSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), printType2);
                        i4 |= 64;
                        break;
                    case 7:
                        str5 = beginStructure.decodeStringElement(serialDescriptor, i2);
                        i4 |= 128;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            printType = printType2;
            l = l3;
            str = str4;
            str2 = str6;
            str3 = str5;
            j2 = j3;
            i = i4;
            Status status3 = status2;
            l2 = l4;
            status = status3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new PrintJobData(i, str, str2, status, j2, l2, l, printType, str3, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, PrintJobData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        PrintJobData.write$Self$inspector_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}