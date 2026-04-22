package io.ktor.http;

import io.ktor.http.ContentDisposition;
import io.ktor.util.date.GMTDate;
import io.ktor.util.date.GMTDate$;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Cookie.kt */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\u00138\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"io/ktor/http/Cookie.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lio/ktor/http/Cookie;", "<init>", "()V", "", "Lkotlinx/serialization/KSerializer;", "childSerializers", "()[Lkotlinx/serialization/KSerializer;", "Lkotlinx/serialization/encoding/Decoder;", "decoder", "deserialize", "(Lkotlinx/serialization/encoding/Decoder;)Lio/ktor/http/Cookie;", "Lkotlinx/serialization/encoding/Encoder;", "encoder", "value", "", "serialize", "(Lkotlinx/serialization/encoding/Encoder;Lio/ktor/http/Cookie;)V", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
public /* synthetic */ class Cookie$$serializer implements GeneratedSerializer<Cookie> {
    public static final Cookie$$serializer INSTANCE = new Cookie$$serializer();
    private static final SerialDescriptor descriptor;

    private Cookie$$serializer() {
    }

    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("io.ktor.http.Cookie", INSTANCE, 10);
        pluginGeneratedSerialDescriptor.addElement(ContentDisposition.Parameters.Name, false);
        pluginGeneratedSerialDescriptor.addElement("value", false);
        pluginGeneratedSerialDescriptor.addElement("encoding", true);
        pluginGeneratedSerialDescriptor.addElement("maxAge", true);
        pluginGeneratedSerialDescriptor.addElement("expires", true);
        pluginGeneratedSerialDescriptor.addElement("domain", true);
        pluginGeneratedSerialDescriptor.addElement("path", true);
        pluginGeneratedSerialDescriptor.addElement("secure", true);
        pluginGeneratedSerialDescriptor.addElement("httpOnly", true);
        pluginGeneratedSerialDescriptor.addElement("extensions", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = Cookie.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, kSerializerArr[2], BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(GMTDate$.serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, kSerializerArr[9]};
    }

    /* renamed from: deserialize */
    public final Cookie m3522deserialize(Decoder decoder) {
        DeserializationStrategy[] deserializationStrategyArr;
        Integer num;
        boolean z;
        String str;
        boolean z2;
        GMTDate gMTDate;
        String str2;
        Map map;
        String str3;
        int i2;
        String str4;
        CookieEncoding cookieEncoding;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        deserializationStrategyArr = Cookie.$childSerializers;
        int i3 = 8;
        int i4 = 0;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            CookieEncoding cookieEncoding2 = (CookieEncoding) beginStructure.decodeSerializableElement(serialDescriptor, 2, deserializationStrategyArr[2], (Object) null);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 7);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(serialDescriptor, 8);
            map = (Map) beginStructure.decodeSerializableElement(serialDescriptor, 9, deserializationStrategyArr[9], (Object) null);
            z2 = decodeBooleanElement;
            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, (Object) null);
            z = decodeBooleanElement2;
            str = decodeStringElement2;
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, (Object) null);
            i2 = 1023;
            num = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, (Object) null);
            str2 = decodeStringElement;
            gMTDate = (GMTDate) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, GMTDate$.serializer.INSTANCE, (Object) null);
            cookieEncoding = cookieEncoding2;
        } else {
            boolean z3 = true;
            boolean z4 = false;
            Map map2 = null;
            String str5 = null;
            GMTDate gMTDate2 = null;
            String str6 = null;
            Integer num2 = null;
            CookieEncoding cookieEncoding3 = null;
            String str7 = null;
            String str8 = null;
            boolean z5 = false;
            while (z3) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z3 = false;
                        i3 = 8;
                        break;
                    case 0:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i4 |= 1;
                        i3 = 8;
                        break;
                    case 1:
                        str8 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i4 |= 2;
                        i3 = 8;
                        break;
                    case 2:
                        cookieEncoding3 = (CookieEncoding) beginStructure.decodeSerializableElement(serialDescriptor, 2, deserializationStrategyArr[2], cookieEncoding3);
                        i4 |= 4;
                        i3 = 8;
                        break;
                    case 3:
                        num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, num2);
                        i4 |= 8;
                        i3 = 8;
                        break;
                    case 4:
                        gMTDate2 = (GMTDate) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, GMTDate$.serializer.INSTANCE, gMTDate2);
                        i4 |= 16;
                        i3 = 8;
                        break;
                    case 5:
                        str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str6);
                        i4 |= 32;
                        i3 = 8;
                        break;
                    case 6:
                        str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str5);
                        i4 |= 64;
                        i3 = 8;
                        break;
                    case 7:
                        z4 = beginStructure.decodeBooleanElement(serialDescriptor, 7);
                        i4 |= 128;
                        break;
                    case 8:
                        z5 = beginStructure.decodeBooleanElement(serialDescriptor, i3);
                        i4 |= 256;
                        break;
                    case 9:
                        map2 = (Map) beginStructure.decodeSerializableElement(serialDescriptor, 9, deserializationStrategyArr[9], map2);
                        i4 |= 512;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            num = num2;
            z = z5;
            str = str8;
            z2 = z4;
            gMTDate = gMTDate2;
            str2 = str7;
            map = map2;
            int i5 = i4;
            str3 = str5;
            i2 = i5;
            CookieEncoding cookieEncoding4 = cookieEncoding3;
            str4 = str6;
            cookieEncoding = cookieEncoding4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new Cookie(i2, str2, str, cookieEncoding, num, gMTDate, str4, str3, z2, z, map, (SerializationConstructorMarker) null);
    }

    public final void serialize(Encoder encoder, Cookie value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        Cookie.write$Self$ktor_http(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}