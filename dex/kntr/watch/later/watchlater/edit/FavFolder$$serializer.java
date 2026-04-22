package kntr.watch.later.watchlater.edit;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.edit.FavFolder;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: FavFolder.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/watch/later/watchlater/edit/FavFolder.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/watch/later/watchlater/edit/FavFolder;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class FavFolder$$serializer implements GeneratedSerializer<FavFolder> {
    public static final int $stable;
    public static final FavFolder$$serializer INSTANCE = new FavFolder$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.watch.later.watchlater.edit.FavFolder", INSTANCE, 17);
        pluginGeneratedSerialDescriptor.addElement("id", true);
        pluginGeneratedSerialDescriptor.addElement("title", true);
        pluginGeneratedSerialDescriptor.addElement("cover", true);
        pluginGeneratedSerialDescriptor.addElement("intro", true);
        pluginGeneratedSerialDescriptor.addElement("cover_type", true);
        pluginGeneratedSerialDescriptor.addElement("state", true);
        pluginGeneratedSerialDescriptor.addElement("media_count", true);
        pluginGeneratedSerialDescriptor.addElement("fav_state", true);
        pluginGeneratedSerialDescriptor.addElement("upper", true);
        pluginGeneratedSerialDescriptor.addElement("ogv", true);
        pluginGeneratedSerialDescriptor.addElement("attr", true);
        pluginGeneratedSerialDescriptor.addElement("view_count", true);
        pluginGeneratedSerialDescriptor.addElement("vt", true);
        pluginGeneratedSerialDescriptor.addElement("view_text_1", true);
        pluginGeneratedSerialDescriptor.addElement("play_switch", true);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement("link", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private FavFolder$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(FavFolder$Upper$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(FavFolder$OGV$$serializer.INSTANCE), IntSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    public final FavFolder deserialize(Decoder decoder) {
        String str;
        String str2;
        FavFolder.OGV ogv;
        String str3;
        int i;
        int i2;
        String str4;
        FavFolder.Upper upper;
        int i3;
        int i4;
        long j;
        long j2;
        int i5;
        String str5;
        int i6;
        long j3;
        int i7;
        int i8;
        char c;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i9 = 10;
        int i10 = 9;
        char c2 = '\b';
        if (beginStructure.decodeSequentially()) {
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 0);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 4);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 5);
            int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 6);
            int decodeIntElement4 = beginStructure.decodeIntElement(serialDescriptor, 7);
            int decodeIntElement5 = beginStructure.decodeIntElement(serialDescriptor, 10);
            long decodeLongElement2 = beginStructure.decodeLongElement(serialDescriptor, 11);
            long decodeLongElement3 = beginStructure.decodeLongElement(serialDescriptor, 12);
            String str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, (Object) null);
            int decodeIntElement6 = beginStructure.decodeIntElement(serialDescriptor, 14);
            int decodeIntElement7 = beginStructure.decodeIntElement(serialDescriptor, 15);
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, (Object) null);
            i7 = decodeIntElement7;
            i6 = decodeIntElement6;
            i3 = decodeIntElement5;
            ogv = (FavFolder.OGV) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, FavFolder$OGV$$serializer.INSTANCE, (Object) null);
            j = decodeLongElement2;
            str4 = str6;
            j3 = decodeLongElement3;
            j2 = decodeLongElement;
            i8 = decodeIntElement4;
            i4 = decodeIntElement3;
            upper = (FavFolder.Upper) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, FavFolder$Upper$$serializer.INSTANCE, (Object) null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, (Object) null);
            i2 = decodeIntElement2;
            i5 = 131071;
            i = decodeIntElement;
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
        } else {
            boolean z = true;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            String str7 = null;
            FavFolder.OGV ogv2 = null;
            String str8 = null;
            String str9 = null;
            String str10 = null;
            FavFolder.Upper upper2 = null;
            long j4 = 0;
            long j5 = 0;
            long j6 = 0;
            int i16 = 0;
            int i17 = 0;
            String str11 = null;
            int i18 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i9 = 10;
                        i10 = 9;
                        c2 = '\b';
                        break;
                    case 0:
                        j6 = beginStructure.decodeLongElement(serialDescriptor, 0);
                        i18 |= 1;
                        i9 = 10;
                        i10 = 9;
                        c2 = '\b';
                        break;
                    case 1:
                        str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str11);
                        i18 |= 2;
                        i9 = 10;
                        i10 = 9;
                        c2 = '\b';
                        break;
                    case 2:
                        str7 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str7);
                        i18 |= 4;
                        i9 = 10;
                        i10 = 9;
                        c2 = '\b';
                        break;
                    case 3:
                        str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str8);
                        i18 |= 8;
                        i9 = 10;
                        i10 = 9;
                        c2 = '\b';
                        break;
                    case 4:
                        i18 |= 16;
                        c2 = c2;
                        i16 = beginStructure.decodeIntElement(serialDescriptor, 4);
                        i9 = 10;
                        i10 = 9;
                        break;
                    case 5:
                        i18 |= 32;
                        c2 = c2;
                        i17 = beginStructure.decodeIntElement(serialDescriptor, 5);
                        i9 = 10;
                        i10 = 9;
                        break;
                    case 6:
                        c = c2;
                        i15 = beginStructure.decodeIntElement(serialDescriptor, 6);
                        i18 |= 64;
                        c2 = c;
                        i9 = 10;
                        i10 = 9;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        i14 = beginStructure.decodeIntElement(serialDescriptor, 7);
                        i18 |= 128;
                        c2 = c2;
                        i9 = 10;
                        i10 = 9;
                        break;
                    case 8:
                        c = '\b';
                        upper2 = (FavFolder.Upper) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, FavFolder$Upper$$serializer.INSTANCE, upper2);
                        i18 |= 256;
                        c2 = c;
                        i9 = 10;
                        i10 = 9;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        ogv2 = (FavFolder.OGV) beginStructure.decodeNullableSerializableElement(serialDescriptor, i10, FavFolder$OGV$$serializer.INSTANCE, ogv2);
                        i18 |= 512;
                        i9 = 10;
                        c2 = '\b';
                        break;
                    case 10:
                        i13 = beginStructure.decodeIntElement(serialDescriptor, i9);
                        i18 |= 1024;
                        c2 = '\b';
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        j4 = beginStructure.decodeLongElement(serialDescriptor, 11);
                        i18 |= 2048;
                        c2 = '\b';
                        break;
                    case 12:
                        j5 = beginStructure.decodeLongElement(serialDescriptor, 12);
                        i18 |= 4096;
                        c2 = '\b';
                        break;
                    case 13:
                        str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str10);
                        i18 |= 8192;
                        c2 = '\b';
                        break;
                    case ConstantsKt.SPACER_14 /* 14 */:
                        i12 = beginStructure.decodeIntElement(serialDescriptor, 14);
                        i18 |= 16384;
                        c2 = '\b';
                        break;
                    case 15:
                        i11 = beginStructure.decodeIntElement(serialDescriptor, 15);
                        i18 |= 32768;
                        c2 = '\b';
                        break;
                    case 16:
                        str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, str9);
                        i18 |= 65536;
                        c2 = '\b';
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str7;
            str2 = str11;
            ogv = ogv2;
            str3 = str8;
            i = i16;
            i2 = i17;
            str4 = str10;
            upper = upper2;
            i3 = i13;
            i4 = i15;
            j = j4;
            j2 = j6;
            i5 = i18;
            str5 = str9;
            i6 = i12;
            j3 = j5;
            int i19 = i14;
            i7 = i11;
            i8 = i19;
        }
        beginStructure.endStructure(serialDescriptor);
        return new FavFolder(i5, j2, str2, str, str3, i, i2, i4, i8, upper, ogv, i3, j, j3, str4, i6, i7, str5, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, FavFolder value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        FavFolder.write$Self$watch_later_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}