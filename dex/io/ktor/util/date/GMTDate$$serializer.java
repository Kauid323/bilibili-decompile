package io.ktor.util.date;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* compiled from: Date.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/ktor/util/date/GMTDate.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lio/ktor/util/date/GMTDate;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/ktor/util/date/GMTDate;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/ktor/util/date/GMTDate;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class GMTDate$$serializer implements GeneratedSerializer<GMTDate> {
    public static final GMTDate$$serializer INSTANCE = new GMTDate$$serializer();
    private static final SerialDescriptor descriptor;

    private GMTDate$$serializer() {
    }

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("io.ktor.util.date.GMTDate", INSTANCE, 9);
        pluginGeneratedSerialDescriptor.addElement("seconds", false);
        pluginGeneratedSerialDescriptor.addElement("minutes", false);
        pluginGeneratedSerialDescriptor.addElement("hours", false);
        pluginGeneratedSerialDescriptor.addElement("dayOfWeek", false);
        pluginGeneratedSerialDescriptor.addElement("dayOfMonth", false);
        pluginGeneratedSerialDescriptor.addElement("dayOfYear", false);
        pluginGeneratedSerialDescriptor.addElement("month", false);
        pluginGeneratedSerialDescriptor.addElement("year", false);
        pluginGeneratedSerialDescriptor.addElement("timestamp", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = GMTDate.$childSerializers;
        return new KSerializer[]{IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, kSerializerArr[3], IntSerializer.INSTANCE, IntSerializer.INSTANCE, kSerializerArr[6], IntSerializer.INSTANCE, LongSerializer.INSTANCE};
    }

    /* renamed from: deserialize */
    public final GMTDate m1803deserialize(Decoder decoder) {
        DeserializationStrategy[] deserializationStrategyArr;
        int i;
        long j;
        Month month;
        int i2;
        int i3;
        int i4;
        WeekDay weekDay;
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        deserializationStrategyArr = GMTDate.$childSerializers;
        int i7 = 7;
        int i8 = 0;
        if (beginStructure.decodeSequentially()) {
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 0);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 1);
            int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 2);
            int decodeIntElement4 = beginStructure.decodeIntElement(serialDescriptor, 4);
            int decodeIntElement5 = beginStructure.decodeIntElement(serialDescriptor, 5);
            int decodeIntElement6 = beginStructure.decodeIntElement(serialDescriptor, 7);
            month = (Month) beginStructure.decodeSerializableElement(serialDescriptor, 6, deserializationStrategyArr[6], (Object) null);
            i2 = decodeIntElement6;
            i5 = decodeIntElement5;
            i3 = decodeIntElement4;
            i = decodeIntElement3;
            weekDay = (WeekDay) beginStructure.decodeSerializableElement(serialDescriptor, 3, deserializationStrategyArr[3], (Object) null);
            i6 = decodeIntElement2;
            j = beginStructure.decodeLongElement(serialDescriptor, 8);
            i4 = decodeIntElement;
            i8 = 511;
        } else {
            boolean z = true;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            Month month2 = null;
            WeekDay weekDay2 = null;
            long j2 = 0;
            int i13 = 0;
            int i14 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i7 = 7;
                    case 0:
                        i8 |= 1;
                        i9 = beginStructure.decodeIntElement(serialDescriptor, 0);
                        i7 = 7;
                    case 1:
                        i12 = beginStructure.decodeIntElement(serialDescriptor, 1);
                        i8 |= 2;
                        i7 = 7;
                    case 2:
                        i11 = beginStructure.decodeIntElement(serialDescriptor, 2);
                        i8 |= 4;
                        i7 = 7;
                    case 3:
                        weekDay2 = (WeekDay) beginStructure.decodeSerializableElement(serialDescriptor, 3, deserializationStrategyArr[3], weekDay2);
                        i8 |= 8;
                        i7 = 7;
                    case 4:
                        i10 = beginStructure.decodeIntElement(serialDescriptor, 4);
                        i8 |= 16;
                    case 5:
                        i14 = beginStructure.decodeIntElement(serialDescriptor, 5);
                        i8 |= 32;
                    case 6:
                        month2 = (Month) beginStructure.decodeSerializableElement(serialDescriptor, 6, deserializationStrategyArr[6], month2);
                        i8 |= 64;
                    case 7:
                        i13 = beginStructure.decodeIntElement(serialDescriptor, i7);
                        i8 |= 128;
                    case 8:
                        j2 = beginStructure.decodeLongElement(serialDescriptor, 8);
                        i8 |= 256;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i11;
            j = j2;
            month = month2;
            i2 = i13;
            i3 = i10;
            i4 = i9;
            weekDay = weekDay2;
            int i15 = i12;
            i5 = i14;
            i6 = i15;
        }
        beginStructure.endStructure(serialDescriptor);
        return new GMTDate(i8, i4, i6, i, weekDay, i3, i5, month, i2, j, null);
    }

    public final void serialize(Encoder encoder, GMTDate value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        GMTDate.write$Self$ktor_utils(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}