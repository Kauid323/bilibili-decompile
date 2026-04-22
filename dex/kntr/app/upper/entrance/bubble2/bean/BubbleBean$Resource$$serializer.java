package kntr.app.upper.entrance.bubble2.bean;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.app.upper.entrance.bubble2.bean.BubbleBean;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
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
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: BubbleBean.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/app/upper/entrance/bubble2/bean/BubbleBean.Resource.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/app/upper/entrance/bubble2/bean/BubbleBean$Resource;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "entrance_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class BubbleBean$Resource$$serializer implements GeneratedSerializer<BubbleBean.Resource> {
    public static final BubbleBean$Resource$$serializer INSTANCE = new BubbleBean$Resource$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.app.upper.entrance.bubble2.bean.BubbleBean.Resource", INSTANCE, 18);
        pluginGeneratedSerialDescriptor.addElement("strategy_id", true);
        pluginGeneratedSerialDescriptor.addElement("strategy_name", true);
        pluginGeneratedSerialDescriptor.addElement("crowd_id", true);
        pluginGeneratedSerialDescriptor.addElement("experiment_id", true);
        pluginGeneratedSerialDescriptor.addElement("start_time", true);
        pluginGeneratedSerialDescriptor.addElement("end_time", true);
        pluginGeneratedSerialDescriptor.addElement("weight", true);
        pluginGeneratedSerialDescriptor.addElement("pool", true);
        pluginGeneratedSerialDescriptor.addElement("location", true);
        pluginGeneratedSerialDescriptor.addElement("resource_id", true);
        pluginGeneratedSerialDescriptor.addElement("operate_topic_id", true);
        pluginGeneratedSerialDescriptor.addElement("bubble", true);
        pluginGeneratedSerialDescriptor.addElement("status", true);
        pluginGeneratedSerialDescriptor.addElement("creator", true);
        pluginGeneratedSerialDescriptor.addElement("resource_name", true);
        pluginGeneratedSerialDescriptor.addElement("interest_score", true);
        pluginGeneratedSerialDescriptor.addElement("hot_score", true);
        pluginGeneratedSerialDescriptor.addElement("is_force", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private BubbleBean$Resource$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), LongSerializer.INSTANCE, LongSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BubbleBean$Bubble$$serializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), FloatSerializer.INSTANCE, FloatSerializer.INSTANCE, IntSerializer.INSTANCE};
    }

    public final BubbleBean.Resource deserialize(Decoder decoder) {
        float f;
        String str;
        String str2;
        String str3;
        int i;
        String str4;
        String str5;
        BubbleBean.Bubble bubble;
        String str6;
        int i2;
        float f2;
        int i3;
        int i4;
        long j;
        int i5;
        String str7;
        String str8;
        int i6;
        long j2;
        int i7;
        int i8;
        char c;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            String str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, (Object) null);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 4);
            long decodeLongElement2 = beginStructure.decodeLongElement(serialDescriptor, 5);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 6);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 7);
            int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 8);
            BubbleBean.Bubble bubble2 = (BubbleBean.Bubble) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, BubbleBean$Bubble$$serializer.INSTANCE, (Object) null);
            int decodeIntElement4 = beginStructure.decodeIntElement(serialDescriptor, 12);
            String str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, (Object) null);
            String str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, (Object) null);
            float decodeFloatElement = beginStructure.decodeFloatElement(serialDescriptor, 15);
            float decodeFloatElement2 = beginStructure.decodeFloatElement(serialDescriptor, 16);
            i6 = beginStructure.decodeIntElement(serialDescriptor, 17);
            f = decodeFloatElement;
            f2 = decodeFloatElement2;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, (Object) null);
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, (Object) null);
            i4 = decodeIntElement4;
            i5 = 262143;
            str4 = str11;
            str5 = str10;
            bubble = bubble2;
            j2 = decodeLongElement;
            i = decodeIntElement3;
            i2 = decodeIntElement;
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            i3 = decodeIntElement2;
            str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            str8 = str9;
            j = decodeLongElement2;
        } else {
            float f3 = 0.0f;
            float f4 = 0.0f;
            boolean z = true;
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            String str12 = null;
            String str13 = null;
            String str14 = null;
            String str15 = null;
            String str16 = null;
            BubbleBean.Bubble bubble3 = null;
            String str17 = null;
            String str18 = null;
            long j3 = 0;
            long j4 = 0;
            int i13 = 0;
            String str19 = null;
            int i14 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                    case 0:
                        i7 = i9;
                        str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str18);
                        i10 |= 1;
                        i9 = i7;
                    case 1:
                        i7 = i9;
                        str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str19);
                        i10 |= 2;
                        i9 = i7;
                    case 2:
                        i7 = i9;
                        str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str14);
                        i10 |= 4;
                        i9 = i7;
                    case 3:
                        i7 = i9;
                        str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str13);
                        i10 |= 8;
                        i9 = i7;
                    case 4:
                        i8 = i9;
                        c = '\t';
                        j4 = beginStructure.decodeLongElement(serialDescriptor, 4);
                        i10 |= 16;
                        i9 = i8;
                    case 5:
                        i8 = i9;
                        c = '\t';
                        j3 = beginStructure.decodeLongElement(serialDescriptor, 5);
                        i10 |= 32;
                        i9 = i8;
                    case 6:
                        i8 = i9;
                        c = '\t';
                        i13 = beginStructure.decodeIntElement(serialDescriptor, 6);
                        i10 |= 64;
                        i9 = i8;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        i8 = i9;
                        c = '\t';
                        i11 = beginStructure.decodeIntElement(serialDescriptor, 7);
                        i10 |= 128;
                        i9 = i8;
                    case 8:
                        i8 = i9;
                        c = '\t';
                        i14 = beginStructure.decodeIntElement(serialDescriptor, 8);
                        i10 |= 256;
                        i9 = i8;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        i8 = i9;
                        c = '\t';
                        str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str17);
                        i10 |= 512;
                        i9 = i8;
                    case 10:
                        str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, str12);
                        i10 |= 1024;
                        i9 = i9;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        i7 = i9;
                        bubble3 = (BubbleBean.Bubble) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, BubbleBean$Bubble$$serializer.INSTANCE, bubble3);
                        i10 |= 2048;
                        i9 = i7;
                    case 12:
                        i7 = i9;
                        i12 = beginStructure.decodeIntElement(serialDescriptor, 12);
                        i10 |= 4096;
                        i9 = i7;
                    case 13:
                        i7 = i9;
                        str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str16);
                        i10 |= 8192;
                        i9 = i7;
                    case ConstantsKt.SPACER_14 /* 14 */:
                        i7 = i9;
                        str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str15);
                        i10 |= 16384;
                        i9 = i7;
                    case 15:
                        i10 |= 32768;
                        f3 = beginStructure.decodeFloatElement(serialDescriptor, 15);
                    case 16:
                        f4 = beginStructure.decodeFloatElement(serialDescriptor, 16);
                        i10 |= 65536;
                    case 17:
                        i9 = beginStructure.decodeIntElement(serialDescriptor, 17);
                        i10 |= 131072;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            String str20 = str18;
            f = f3;
            str = str12;
            str2 = str13;
            str3 = str14;
            i = i14;
            str4 = str15;
            str5 = str16;
            bubble = bubble3;
            str6 = str17;
            i2 = i13;
            f2 = f4;
            i3 = i11;
            i4 = i12;
            j = j3;
            i5 = i10;
            str7 = str19;
            str8 = str20;
            i6 = i9;
            j2 = j4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new BubbleBean.Resource(i5, str8, str7, str3, str2, j2, j, i2, i3, i, str6, str, bubble, i4, str5, str4, f, f2, i6, null);
    }

    public final void serialize(Encoder encoder, BubbleBean.Resource value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        BubbleBean.Resource.write$Self$entrance_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}