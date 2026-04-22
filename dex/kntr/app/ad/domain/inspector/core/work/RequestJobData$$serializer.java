package kntr.app.ad.domain.inspector.core.work;

import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import kntr.app.ad.common.model.AdSlot;
import kntr.app.ad.domain.alarm.AdAlarmExtraKey;
import kntr.app.ad.domain.inspector.core.serializer.RequestTypeSerializer;
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
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/ad/domain/inspector/core/work/RequestJobData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/ad/domain/inspector/core/work/RequestJobData;", "<init>", "()V", "childSerializers", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", RoomRecommendViewModel.EMPTY_CURSOR, "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "inspector_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class RequestJobData$$serializer implements GeneratedSerializer<RequestJobData> {
    public static final int $stable;
    public static final RequestJobData$$serializer INSTANCE = new RequestJobData$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.ad.domain.inspector.core.work.RequestJobData", INSTANCE, 13);
        pluginGeneratedSerialDescriptor.addElement(ReportBuildInParam.ID, false);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement(AdAlarmExtraKey.STATUS, true);
        pluginGeneratedSerialDescriptor.addElement("timestamp", true);
        pluginGeneratedSerialDescriptor.addElement("startTime", true);
        pluginGeneratedSerialDescriptor.addElement("endTime", true);
        pluginGeneratedSerialDescriptor.addElement("slot", false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("jobType", false);
        pluginGeneratedSerialDescriptor.addElement("url", true);
        pluginGeneratedSerialDescriptor.addElement("requestJson", true);
        pluginGeneratedSerialDescriptor.addElement("responseJson", true);
        pluginGeneratedSerialDescriptor.addElement("desc", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private RequestJobData$$serializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = RequestJobData.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, StatusSerializer.INSTANCE, LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), lazyArr[6].getValue(), RequestTypeSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final RequestJobData deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        Long l;
        String str;
        String str2;
        AdSlot adSlot;
        RequestType requestType;
        Long l2;
        String str3;
        String str4;
        long j2;
        String str5;
        Status status;
        int i;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        char c;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = RequestJobData.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 3);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 8);
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, (Object) null);
            adSlot = (AdSlot) beginStructure.decodeSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, (Object) null);
            l2 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, LongSerializer.INSTANCE, (Object) null);
            l = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LongSerializer.INSTANCE, (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, (Object) null);
            j2 = decodeLongElement;
            str5 = decodeStringElement;
            status = (Status) beginStructure.decodeSerializableElement(serialDescriptor, 2, StatusSerializer.INSTANCE, (Object) null);
            i = 8191;
            requestType = (RequestType) beginStructure.decodeSerializableElement(serialDescriptor, 7, RequestTypeSerializer.INSTANCE, (Object) null);
            str4 = decodeStringElement3;
            str7 = decodeStringElement2;
        } else {
            boolean z = true;
            String str11 = null;
            String str12 = null;
            Long l3 = null;
            String str13 = null;
            String str14 = null;
            AdSlot adSlot2 = null;
            String str15 = null;
            RequestType requestType2 = null;
            Long l4 = null;
            String str16 = null;
            String str17 = null;
            long j3 = 0;
            int i2 = 0;
            Status status2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case GameActionStateKt.ACTION_UNDEFINE /* -1 */:
                        str8 = str11;
                        str9 = str12;
                        z = false;
                        str12 = str9;
                        str11 = str8;
                    case 0:
                        i2 |= 1;
                        str11 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        str12 = str12;
                    case 1:
                        str8 = str11;
                        i2 |= 2;
                        str12 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        str11 = str8;
                    case 2:
                        str8 = str11;
                        str9 = str12;
                        status2 = (Status) beginStructure.decodeSerializableElement(serialDescriptor, 2, StatusSerializer.INSTANCE, status2);
                        i2 |= 4;
                        str12 = str9;
                        str11 = str8;
                    case 3:
                        str8 = str11;
                        str9 = str12;
                        j3 = beginStructure.decodeLongElement(serialDescriptor, 3);
                        i2 |= 8;
                        str12 = str9;
                        str11 = str8;
                    case 4:
                        str8 = str11;
                        str9 = str12;
                        l3 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, LongSerializer.INSTANCE, l3);
                        i2 |= 16;
                        str12 = str9;
                        str11 = str8;
                    case 5:
                        str8 = str11;
                        str9 = str12;
                        l4 = (Long) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, LongSerializer.INSTANCE, l4);
                        i2 |= 32;
                        str12 = str9;
                        str11 = str8;
                    case 6:
                        str8 = str11;
                        str9 = str12;
                        adSlot2 = (AdSlot) beginStructure.decodeSerializableElement(serialDescriptor, 6, (DeserializationStrategy) lazyArr[6].getValue(), adSlot2);
                        i2 |= 64;
                        str12 = str9;
                        str11 = str8;
                    case 7:
                        str8 = str11;
                        str9 = str12;
                        requestType2 = (RequestType) beginStructure.decodeSerializableElement(serialDescriptor, 7, RequestTypeSerializer.INSTANCE, requestType2);
                        i2 |= 128;
                        str12 = str9;
                        str11 = str8;
                    case 8:
                        str10 = str11;
                        c = '\t';
                        str17 = beginStructure.decodeStringElement(serialDescriptor, 8);
                        i2 |= 256;
                        str11 = str10;
                    case 9:
                        str10 = str11;
                        c = '\t';
                        str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str14);
                        i2 |= 512;
                        str11 = str10;
                    case 10:
                        str8 = str11;
                        str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, str16);
                        i2 |= 1024;
                        str11 = str8;
                    case AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER /* 11 */:
                        str8 = str11;
                        str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str13);
                        i2 |= 2048;
                        str11 = str8;
                    case AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER /* 12 */:
                        str8 = str11;
                        str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str15);
                        i2 |= 4096;
                        str11 = str8;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            l = l3;
            str = str13;
            str2 = str14;
            adSlot = adSlot2;
            requestType = requestType2;
            l2 = l4;
            str3 = str16;
            str4 = str17;
            j2 = j3;
            str5 = str11;
            status = status2;
            i = i2;
            str6 = str15;
            str7 = str12;
        }
        beginStructure.endStructure(serialDescriptor);
        return new RequestJobData(i, str5, str7, status, j2, l, l2, adSlot, requestType, str4, str2, str3, str, str6, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, RequestJobData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        RequestJobData.write$Self$inspector_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}