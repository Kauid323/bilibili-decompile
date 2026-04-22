package kntr.watch.later.watchlater.data;

import com.bapis.bilibili.app.dynamic.v2.AdditionalButton;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.api.TranslateInfo;
import kntr.watch.later.watchlater.api.TranslateInfo$$serializer;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: WatchLaterResponse.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"kntr/watch/later/watchlater/data/WatchLaterItem.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lkntr/watch/later/watchlater/data/WatchLaterItem;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "watch_later_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public final /* synthetic */ class WatchLaterItem$$serializer implements GeneratedSerializer<WatchLaterItem> {
    public static final int $stable;
    public static final WatchLaterItem$$serializer INSTANCE = new WatchLaterItem$$serializer();
    private static final SerialDescriptor descriptor;

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("kntr.watch.later.watchlater.data.WatchLaterItem", INSTANCE, 21);
        pluginGeneratedSerialDescriptor.addElement("card_type", true);
        pluginGeneratedSerialDescriptor.addElement("aid", true);
        pluginGeneratedSerialDescriptor.addElement("title", true);
        pluginGeneratedSerialDescriptor.addElement("intro", true);
        pluginGeneratedSerialDescriptor.addElement("pic", true);
        pluginGeneratedSerialDescriptor.addElement("duration", true);
        pluginGeneratedSerialDescriptor.addElement("progress", true);
        pluginGeneratedSerialDescriptor.addElement("uri", true);
        pluginGeneratedSerialDescriptor.addElement("arc_state", true);
        pluginGeneratedSerialDescriptor.addElement("pgc_label", true);
        pluginGeneratedSerialDescriptor.addElement("show_up", true);
        pluginGeneratedSerialDescriptor.addElement("forbid_fav", true);
        pluginGeneratedSerialDescriptor.addElement("owner", true);
        pluginGeneratedSerialDescriptor.addElement("left_icon_type", true);
        pluginGeneratedSerialDescriptor.addElement("left_text", true);
        pluginGeneratedSerialDescriptor.addElement("right_icon_type", true);
        pluginGeneratedSerialDescriptor.addElement("right_text", true);
        pluginGeneratedSerialDescriptor.addElement("translate_info", true);
        pluginGeneratedSerialDescriptor.addElement("isChecked", true);
        pluginGeneratedSerialDescriptor.addElement("itemId", true);
        pluginGeneratedSerialDescriptor.addElement("onTranslateStateChagne", true);
        descriptor = pluginGeneratedSerialDescriptor;
        $stable = 8;
    }

    private WatchLaterItem$$serializer() {
    }

    public final KSerializer<?>[] childSerializers() {
        Lazy[] lazyArr;
        lazyArr = WatchLaterItem.$childSerializers;
        return new KSerializer[]{IntSerializer.INSTANCE, LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), LongSerializer.INSTANCE, LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(Owner$$serializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(TranslateInfo$$serializer.INSTANCE), BooleanSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable((KSerializer) lazyArr[20].getValue())};
    }

    public final WatchLaterItem deserialize(Decoder decoder) {
        Lazy[] lazyArr;
        String str;
        String str2;
        TranslateInfo translateInfo;
        String str3;
        String str4;
        String str5;
        int i;
        String str6;
        String str7;
        Function0 function0;
        boolean z;
        int i2;
        long j;
        String str8;
        int i3;
        boolean z2;
        boolean z3;
        long j2;
        long j3;
        int i4;
        int i5;
        Owner owner;
        Lazy[] lazyArr2;
        Function0 function02;
        int i6;
        int i7;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        lazyArr = WatchLaterItem.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 0);
            long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 1);
            long decodeLongElement2 = beginStructure.decodeLongElement(serialDescriptor, 5);
            long decodeLongElement3 = beginStructure.decodeLongElement(serialDescriptor, 6);
            int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 8);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 10);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 11);
            Owner owner2 = (Owner) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, Owner$$serializer.INSTANCE, (Object) null);
            int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 13);
            String str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, (Object) null);
            int decodeIntElement4 = beginStructure.decodeIntElement(serialDescriptor, 15);
            String str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, (Object) null);
            TranslateInfo translateInfo2 = (TranslateInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, TranslateInfo$$serializer.INSTANCE, (Object) null);
            boolean decodeBooleanElement3 = beginStructure.decodeBooleanElement(serialDescriptor, 18);
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 19);
            function0 = (Function0) beginStructure.decodeNullableSerializableElement(serialDescriptor, 20, (DeserializationStrategy) lazyArr[20].getValue(), (Object) null);
            z = decodeBooleanElement3;
            str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, (Object) null);
            i2 = decodeIntElement2;
            str8 = decodeStringElement;
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, (Object) null);
            translateInfo = translateInfo2;
            str6 = str10;
            j = decodeLongElement;
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, (Object) null);
            i = decodeIntElement4;
            str7 = str9;
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, (Object) null);
            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, (Object) null);
            i5 = 2097151;
            z2 = decodeBooleanElement;
            z3 = decodeBooleanElement2;
            i3 = decodeIntElement;
            j3 = decodeLongElement3;
            i4 = decodeIntElement3;
            owner = owner2;
            j2 = decodeLongElement2;
        } else {
            Function0 function03 = null;
            int i8 = 0;
            boolean z4 = false;
            int i9 = 0;
            int i10 = 0;
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = true;
            Owner owner3 = null;
            String str11 = null;
            TranslateInfo translateInfo3 = null;
            String str12 = null;
            String str13 = null;
            String str14 = null;
            String str15 = null;
            String str16 = null;
            String str17 = null;
            long j4 = 0;
            long j5 = 0;
            long j6 = 0;
            int i11 = 0;
            int i12 = 0;
            String str18 = null;
            while (z7) {
                int i13 = i11;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        lazyArr2 = lazyArr;
                        function02 = function03;
                        z7 = false;
                        function03 = function02;
                        break;
                    case 0:
                        lazyArr2 = lazyArr;
                        function02 = function03;
                        i10 = beginStructure.decodeIntElement(serialDescriptor, 0);
                        i8 |= 1;
                        function03 = function02;
                        break;
                    case 1:
                        lazyArr2 = lazyArr;
                        function02 = function03;
                        j4 = beginStructure.decodeLongElement(serialDescriptor, 1);
                        i8 |= 2;
                        function03 = function02;
                        break;
                    case 2:
                        lazyArr2 = lazyArr;
                        function02 = function03;
                        str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str18);
                        i8 |= 4;
                        function03 = function02;
                        break;
                    case 3:
                        lazyArr2 = lazyArr;
                        function02 = function03;
                        str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str14);
                        i8 |= 8;
                        function03 = function02;
                        break;
                    case 4:
                        lazyArr2 = lazyArr;
                        function02 = function03;
                        str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str13);
                        i8 |= 16;
                        function03 = function02;
                        break;
                    case 5:
                        lazyArr2 = lazyArr;
                        function02 = function03;
                        j5 = beginStructure.decodeLongElement(serialDescriptor, 5);
                        i8 |= 32;
                        function03 = function02;
                        break;
                    case 6:
                        lazyArr2 = lazyArr;
                        function02 = function03;
                        j6 = beginStructure.decodeLongElement(serialDescriptor, 6);
                        i8 |= 64;
                        function03 = function02;
                        break;
                    case AdditionalButton.CLICK_TYPE_FIELD_NUMBER /* 7 */:
                        lazyArr2 = lazyArr;
                        function02 = function03;
                        str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str11);
                        i8 |= 128;
                        function03 = function02;
                        break;
                    case 8:
                        lazyArr2 = lazyArr;
                        function02 = function03;
                        i9 = beginStructure.decodeIntElement(serialDescriptor, 8);
                        i8 |= 256;
                        function03 = function02;
                        break;
                    case ConstantsKt.SPACER_9 /* 9 */:
                        lazyArr2 = lazyArr;
                        function02 = function03;
                        str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str12);
                        i8 |= 512;
                        function03 = function02;
                        break;
                    case 10:
                        lazyArr2 = lazyArr;
                        function02 = function03;
                        z5 = beginStructure.decodeBooleanElement(serialDescriptor, 10);
                        i8 |= 1024;
                        function03 = function02;
                        break;
                    case MediaAttrUtils.TYPE_MENU /* 11 */:
                        lazyArr2 = lazyArr;
                        function02 = function03;
                        z6 = beginStructure.decodeBooleanElement(serialDescriptor, 11);
                        i8 |= 2048;
                        function03 = function02;
                        break;
                    case 12:
                        lazyArr2 = lazyArr;
                        function02 = function03;
                        owner3 = (Owner) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, Owner$$serializer.INSTANCE, owner3);
                        i8 |= 4096;
                        function03 = function02;
                        break;
                    case 13:
                        lazyArr2 = lazyArr;
                        i8 |= 8192;
                        function03 = function03;
                        i11 = beginStructure.decodeIntElement(serialDescriptor, 13);
                        continue;
                        lazyArr = lazyArr2;
                    case ConstantsKt.SPACER_14 /* 14 */:
                        lazyArr2 = lazyArr;
                        function02 = function03;
                        str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str16);
                        i8 |= 16384;
                        function03 = function02;
                        break;
                    case 15:
                        lazyArr2 = lazyArr;
                        function02 = function03;
                        i12 = beginStructure.decodeIntElement(serialDescriptor, 15);
                        i8 |= 32768;
                        function03 = function02;
                        break;
                    case 16:
                        lazyArr2 = lazyArr;
                        function02 = function03;
                        str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, str15);
                        i6 = 65536;
                        i8 |= i6;
                        function03 = function02;
                        break;
                    case 17:
                        lazyArr2 = lazyArr;
                        function02 = function03;
                        translateInfo3 = (TranslateInfo) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, TranslateInfo$$serializer.INSTANCE, translateInfo3);
                        i6 = 131072;
                        i8 |= i6;
                        function03 = function02;
                        break;
                    case 18:
                        lazyArr2 = lazyArr;
                        z4 = beginStructure.decodeBooleanElement(serialDescriptor, 18);
                        i8 |= 262144;
                        break;
                    case 19:
                        lazyArr2 = lazyArr;
                        str17 = beginStructure.decodeStringElement(serialDescriptor, 19);
                        i7 = 524288;
                        i8 |= i7;
                        break;
                    case 20:
                        lazyArr2 = lazyArr;
                        function03 = (Function0) beginStructure.decodeNullableSerializableElement(serialDescriptor, 20, (DeserializationStrategy) lazyArr[20].getValue(), function03);
                        i7 = 1048576;
                        i8 |= i7;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
                i11 = i13;
                lazyArr = lazyArr2;
            }
            str = str18;
            str2 = str11;
            translateInfo = translateInfo3;
            str3 = str12;
            str4 = str13;
            str5 = str14;
            i = i12;
            str6 = str15;
            str7 = str16;
            function0 = function03;
            z = z4;
            i2 = i9;
            j = j4;
            str8 = str17;
            i3 = i10;
            z2 = z5;
            z3 = z6;
            j2 = j5;
            j3 = j6;
            i4 = i11;
            i5 = i8;
            owner = owner3;
        }
        beginStructure.endStructure(serialDescriptor);
        return new WatchLaterItem(i5, i3, j, str, str5, str4, j2, j3, str2, i2, str3, z2, z3, owner, i4, str7, i, str6, translateInfo, z, str8, function0, null);
    }

    public final void serialize(Encoder encoder, WatchLaterItem value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        WatchLaterItem.write$Self$watch_later_debug(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public /* bridge */ KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}