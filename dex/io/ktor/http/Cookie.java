package io.ktor.http;

import BottomSheetItemData$;
import io.ktor.http.ContentDisposition;
import io.ktor.util.date.GMTDate;
import io.ktor.util.date.GMTDate$;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Cookie.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\b\u0087\b\u0018\u0000 I2\u00020\u0001:\u0002JIB}\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013B\u0089\u0001\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u000f\u001a\u00020\r\u0012\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0012\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0019J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u0019J\u0010\u0010#\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b#\u0010$J\u0010\u0010%\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b%\u0010$J\u001e\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0010HÆ\u0003¢\u0006\u0004\b&\u0010'J\u008a\u0001\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\r2\u0016\b\u0002\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0010HÆ\u0001¢\u0006\u0004\b(\u0010)J\u001a\u0010+\u001a\u00020\r2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b+\u0010,J\u0010\u0010-\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b/\u0010\u0019J'\u00108\u001a\u0002052\u0006\u00100\u001a\u00020\u00002\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u000203H\u0001¢\u0006\u0004\b6\u00107R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u00109\u001a\u0004\b:\u0010\u0019R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u00109\u001a\u0004\b;\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010<\u001a\u0004\b=\u0010\u001cR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078G¢\u0006\f\n\u0004\b\b\u0010>\u001a\u0004\b?\u0010\u001eR\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010@\u001a\u0004\bA\u0010 R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u00109\u001a\u0004\bB\u0010\u0019R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\f\u00109\u001a\u0004\bC\u0010\u0019R\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010D\u001a\u0004\bE\u0010$R\u0017\u0010\u000f\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000f\u0010D\u001a\u0004\bF\u0010$R%\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010G\u001a\u0004\bH\u0010'¨\u0006K"}, d2 = {"Lio/ktor/http/Cookie;", "", "", ContentDisposition.Parameters.Name, "value", "Lio/ktor/http/CookieEncoding;", "encoding", "", "maxAge", "Lio/ktor/util/date/GMTDate;", "expires", "domain", "path", "", "secure", "httpOnly", "", "extensions", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/http/CookieEncoding;Ljava/lang/Integer;Lio/ktor/util/date/GMTDate;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Map;)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Lio/ktor/http/CookieEncoding;Ljava/lang/Integer;Lio/ktor/util/date/GMTDate;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "()Lio/ktor/http/CookieEncoding;", "component4", "()Ljava/lang/Integer;", "component5", "()Lio/ktor/util/date/GMTDate;", "component6", "component7", "component8", "()Z", "component9", "component10", "()Ljava/util/Map;", "copy", "(Ljava/lang/String;Ljava/lang/String;Lio/ktor/http/CookieEncoding;Ljava/lang/Integer;Lio/ktor/util/date/GMTDate;Ljava/lang/String;Ljava/lang/String;ZZLjava/util/Map;)Lio/ktor/http/Cookie;", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "", "write$Self$ktor_http", "(Lio/ktor/http/Cookie;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/lang/String;", "getName", "getValue", "Lio/ktor/http/CookieEncoding;", "getEncoding", "Ljava/lang/Integer;", "getMaxAgeInt", "Lio/ktor/util/date/GMTDate;", "getExpires", "getDomain", "getPath", "Z", "getSecure", "getHttpOnly", "Ljava/util/Map;", "getExtensions", "Companion", "$serializer", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
public final class Cookie {
    private final String domain;
    private final CookieEncoding encoding;
    private final GMTDate expires;
    private final Map<String, String> extensions;
    private final boolean httpOnly;
    private final Integer maxAge;
    private final String name;
    private final String path;
    private final boolean secure;
    private final String value;
    public static final Companion Companion = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, EnumsKt.createSimpleEnumSerializer("io.ktor.http.CookieEncoding", CookieEncoding.values()), null, null, null, null, null, null, new LinkedHashMapSerializer(StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE))};

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Cookie copy$default(Cookie cookie, String str, String str2, CookieEncoding cookieEncoding, Integer num, GMTDate gMTDate, String str3, String str4, boolean z, boolean z2, Map map, int i2, Object obj) {
        return cookie.copy((i2 & 1) != 0 ? cookie.name : str, (i2 & 2) != 0 ? cookie.value : str2, (i2 & 4) != 0 ? cookie.encoding : cookieEncoding, (i2 & 8) != 0 ? cookie.maxAge : num, (i2 & 16) != 0 ? cookie.expires : gMTDate, (i2 & 32) != 0 ? cookie.domain : str3, (i2 & 64) != 0 ? cookie.path : str4, (i2 & 128) != 0 ? cookie.secure : z, (i2 & 256) != 0 ? cookie.httpOnly : z2, (i2 & 512) != 0 ? cookie.extensions : map);
    }

    public final String component1() {
        return this.name;
    }

    public final Map<String, String> component10() {
        return this.extensions;
    }

    public final String component2() {
        return this.value;
    }

    public final CookieEncoding component3() {
        return this.encoding;
    }

    public final Integer component4() {
        return this.maxAge;
    }

    public final GMTDate component5() {
        return this.expires;
    }

    public final String component6() {
        return this.domain;
    }

    public final String component7() {
        return this.path;
    }

    public final boolean component8() {
        return this.secure;
    }

    public final boolean component9() {
        return this.httpOnly;
    }

    public final Cookie copy(String str, String str2, CookieEncoding cookieEncoding, Integer num, GMTDate gMTDate, String str3, String str4, boolean z, boolean z2, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(str2, "value");
        Intrinsics.checkNotNullParameter(cookieEncoding, "encoding");
        Intrinsics.checkNotNullParameter(map, "extensions");
        return new Cookie(str, str2, cookieEncoding, num, gMTDate, str3, str4, z, z2, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            return Intrinsics.areEqual(this.name, cookie.name) && Intrinsics.areEqual(this.value, cookie.value) && this.encoding == cookie.encoding && Intrinsics.areEqual(this.maxAge, cookie.maxAge) && Intrinsics.areEqual(this.expires, cookie.expires) && Intrinsics.areEqual(this.domain, cookie.domain) && Intrinsics.areEqual(this.path, cookie.path) && this.secure == cookie.secure && this.httpOnly == cookie.httpOnly && Intrinsics.areEqual(this.extensions, cookie.extensions);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((this.name.hashCode() * 31) + this.value.hashCode()) * 31) + this.encoding.hashCode()) * 31) + (this.maxAge == null ? 0 : this.maxAge.hashCode())) * 31) + (this.expires == null ? 0 : this.expires.hashCode())) * 31) + (this.domain == null ? 0 : this.domain.hashCode())) * 31) + (this.path != null ? this.path.hashCode() : 0)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.secure)) * 31) + BottomSheetItemData$.ExternalSyntheticBackport0.m(this.httpOnly)) * 31) + this.extensions.hashCode();
    }

    public String toString() {
        return "Cookie(name=" + this.name + ", value=" + this.value + ", encoding=" + this.encoding + ", maxAge=" + this.maxAge + ", expires=" + this.expires + ", domain=" + this.domain + ", path=" + this.path + ", secure=" + this.secure + ", httpOnly=" + this.httpOnly + ", extensions=" + this.extensions + ')';
    }

    /* compiled from: Cookie.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/ktor/http/Cookie$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/ktor/http/Cookie;", "serializer", "()Lkotlinx/serialization/KSerializer;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<Cookie> serializer() {
            return Cookie$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ Cookie(int seen0, String name, String value, CookieEncoding encoding, Integer maxAge, GMTDate expires, String domain, String path, boolean secure, boolean httpOnly, Map extensions, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (seen0 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(seen0, 3, Cookie$$serializer.INSTANCE.getDescriptor());
        }
        this.name = name;
        this.value = value;
        if ((seen0 & 4) == 0) {
            this.encoding = CookieEncoding.URI_ENCODING;
        } else {
            this.encoding = encoding;
        }
        if ((seen0 & 8) == 0) {
            this.maxAge = null;
        } else {
            this.maxAge = maxAge;
        }
        if ((seen0 & 16) == 0) {
            this.expires = null;
        } else {
            this.expires = expires;
        }
        if ((seen0 & 32) == 0) {
            this.domain = null;
        } else {
            this.domain = domain;
        }
        if ((seen0 & 64) == 0) {
            this.path = null;
        } else {
            this.path = path;
        }
        if ((seen0 & 128) == 0) {
            this.secure = false;
        } else {
            this.secure = secure;
        }
        if ((seen0 & 256) == 0) {
            this.httpOnly = false;
        } else {
            this.httpOnly = httpOnly;
        }
        if ((seen0 & 512) == 0) {
            this.extensions = MapsKt.emptyMap();
        } else {
            this.extensions = extensions;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$ktor_http(Cookie self, CompositeEncoder output, SerialDescriptor serialDesc) {
        SerializationStrategy[] serializationStrategyArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.name);
        output.encodeStringElement(serialDesc, 1, self.value);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.encoding != CookieEncoding.URI_ENCODING) {
            output.encodeSerializableElement(serialDesc, 2, serializationStrategyArr[2], self.encoding);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.maxAge != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.maxAge);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.expires != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, GMTDate$.serializer.INSTANCE, self.expires);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 5) || self.domain != null) {
            output.encodeNullableSerializableElement(serialDesc, 5, StringSerializer.INSTANCE, self.domain);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 6) || self.path != null) {
            output.encodeNullableSerializableElement(serialDesc, 6, StringSerializer.INSTANCE, self.path);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 7) || self.secure) {
            output.encodeBooleanElement(serialDesc, 7, self.secure);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 8) || self.httpOnly) {
            output.encodeBooleanElement(serialDesc, 8, self.httpOnly);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 9) || !Intrinsics.areEqual(self.extensions, MapsKt.emptyMap())) {
            output.encodeSerializableElement(serialDesc, 9, serializationStrategyArr[9], self.extensions);
        }
    }

    public Cookie(String name, String value, CookieEncoding encoding, Integer maxAge, GMTDate expires, String domain, String path, boolean secure, boolean httpOnly, Map<String, String> map) {
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        Intrinsics.checkNotNullParameter(map, "extensions");
        this.name = name;
        this.value = value;
        this.encoding = encoding;
        this.maxAge = maxAge;
        this.expires = expires;
        this.domain = domain;
        this.path = path;
        this.secure = secure;
        this.httpOnly = httpOnly;
        this.extensions = map;
    }

    public /* synthetic */ Cookie(String str, String str2, CookieEncoding cookieEncoding, Integer num, GMTDate gMTDate, String str3, String str4, boolean z, boolean z2, Map map, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? CookieEncoding.URI_ENCODING : cookieEncoding, (i2 & 8) != 0 ? null : num, (i2 & 16) != 0 ? null : gMTDate, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? null : str4, (i2 & 128) != 0 ? false : z, (i2 & 256) != 0 ? false : z2, (i2 & 512) != 0 ? MapsKt.emptyMap() : map);
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }

    public final CookieEncoding getEncoding() {
        return this.encoding;
    }

    public final Integer getMaxAgeInt() {
        return this.maxAge;
    }

    public final GMTDate getExpires() {
        return this.expires;
    }

    public final String getDomain() {
        return this.domain;
    }

    public final String getPath() {
        return this.path;
    }

    public final boolean getSecure() {
        return this.secure;
    }

    public final boolean getHttpOnly() {
        return this.httpOnly;
    }

    public final Map<String, String> getExtensions() {
        return this.extensions;
    }
}