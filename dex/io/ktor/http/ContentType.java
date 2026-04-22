package io.ktor.http;

import io.ktor.http.ContentDisposition;
import io.ktor.http.HeaderValueWithParameters;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ContentTypes.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 $2\u00020\u0001:\t$%&'()*+,B1\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nB)\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010 \u001a\u0004\b#\u0010\"¨\u0006-"}, d2 = {"Lio/ktor/http/ContentType;", "Lio/ktor/http/HeaderValueWithParameters;", "", "contentType", "contentSubtype", "existingContent", "", "Lio/ktor/http/HeaderValueParam;", "parameters", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", ContentDisposition.Parameters.Name, "value", "withParameter", "(Ljava/lang/String;Ljava/lang/String;)Lio/ktor/http/ContentType;", "", "hasParameter", "(Ljava/lang/String;Ljava/lang/String;)Z", "withoutParameters", "()Lio/ktor/http/ContentType;", "pattern", "match", "(Lio/ktor/http/ContentType;)Z", "(Ljava/lang/String;)Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljava/lang/String;", "getContentType", "()Ljava/lang/String;", "getContentSubtype", "Companion", "Application", "Audio", "Image", "Message", "MultiPart", "Text", "Video", "Font", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ContentType extends HeaderValueWithParameters {
    private final String contentSubtype;
    private final String contentType;
    public static final Companion Companion = new Companion(null);
    private static final ContentType Any = new ContentType("*", "*", null, 4, null);

    /* synthetic */ ContentType(String str, String str2, String str3, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i2 & 8) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final String getContentSubtype() {
        return this.contentSubtype;
    }

    private ContentType(String contentType, String contentSubtype, String existingContent, List<HeaderValueParam> list) {
        super(existingContent, list);
        this.contentType = contentType;
        this.contentSubtype = contentSubtype;
    }

    public /* synthetic */ ContentType(String str, String str2, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContentType(String contentType, String contentSubtype, List<HeaderValueParam> list) {
        this(contentType, contentSubtype, contentType + '/' + contentSubtype, list);
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(contentSubtype, "contentSubtype");
        Intrinsics.checkNotNullParameter(list, "parameters");
    }

    public final ContentType withParameter(String name, String value) {
        Intrinsics.checkNotNullParameter(name, ContentDisposition.Parameters.Name);
        Intrinsics.checkNotNullParameter(value, "value");
        return hasParameter(name, value) ? this : new ContentType(this.contentType, this.contentSubtype, getContent(), CollectionsKt.plus(getParameters(), new HeaderValueParam(name, value)));
    }

    private final boolean hasParameter(String name, String value) {
        HeaderValueParam it;
        switch (getParameters().size()) {
            case 0:
                return false;
            case 1:
                HeaderValueParam it2 = getParameters().get(0);
                return StringsKt.equals(it2.getName(), name, true) && StringsKt.equals(it2.getValue(), value, true);
            default:
                Iterable $this$any$iv = getParameters();
                if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
                    return false;
                }
                for (Object element$iv : $this$any$iv) {
                    HeaderValueParam it3 = (HeaderValueParam) element$iv;
                    if (StringsKt.equals(it3.getName(), name, true) && StringsKt.equals(it3.getValue(), value, true)) {
                        it = 1;
                        continue;
                    } else {
                        it = null;
                        continue;
                    }
                    if (it != null) {
                        return true;
                    }
                }
                return false;
        }
    }

    public final ContentType withoutParameters() {
        return getParameters().isEmpty() ? this : new ContentType(this.contentType, this.contentSubtype, null, 4, null);
    }

    public final boolean match(ContentType pattern) {
        boolean equals;
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        if (Intrinsics.areEqual(pattern.contentType, "*") || StringsKt.equals(pattern.contentType, this.contentType, true)) {
            if (Intrinsics.areEqual(pattern.contentSubtype, "*") || StringsKt.equals(pattern.contentSubtype, this.contentSubtype, true)) {
                for (HeaderValueParam headerValueParam : pattern.getParameters()) {
                    String patternName = headerValueParam.component1();
                    String patternValue = headerValueParam.component2();
                    if (Intrinsics.areEqual(patternName, "*")) {
                        if (Intrinsics.areEqual(patternValue, "*")) {
                            equals = true;
                        } else {
                            Iterable $this$any$iv = getParameters();
                            if (!($this$any$iv instanceof Collection) || !((Collection) $this$any$iv).isEmpty()) {
                                Iterator<T> it = $this$any$iv.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        Object element$iv = it.next();
                                        HeaderValueParam p = (HeaderValueParam) element$iv;
                                        if (StringsKt.equals(p.getValue(), patternValue, true)) {
                                            equals = true;
                                            break;
                                        }
                                    } else {
                                        equals = false;
                                        break;
                                    }
                                }
                            } else {
                                equals = false;
                            }
                        }
                    } else {
                        String value = parameter(patternName);
                        if (Intrinsics.areEqual(patternValue, "*")) {
                            equals = value != null;
                        } else {
                            equals = StringsKt.equals(value, patternValue, true);
                        }
                    }
                    boolean matches = equals;
                    if (!matches) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public final boolean match(String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        return match(Companion.parse(pattern));
    }

    public boolean equals(Object other) {
        return (other instanceof ContentType) && StringsKt.equals(this.contentType, ((ContentType) other).contentType, true) && StringsKt.equals(this.contentSubtype, ((ContentType) other).contentSubtype, true) && Intrinsics.areEqual(getParameters(), ((ContentType) other).getParameters());
    }

    public int hashCode() {
        String lowerCase = this.contentType.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        int result = lowerCase.hashCode();
        String lowerCase2 = this.contentSubtype.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        return result + (result * 31) + lowerCase2.hashCode() + (getParameters().hashCode() * 31);
    }

    /* compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/http/ContentType$Companion;", "", "<init>", "()V", "", "value", "Lio/ktor/http/ContentType;", "parse", "(Ljava/lang/String;)Lio/ktor/http/ContentType;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ContentType parse(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (StringsKt.isBlank(value)) {
                return getAny();
            }
            HeaderValueWithParameters.Companion companion = HeaderValueWithParameters.Companion;
            HeaderValue headerValue$iv = (HeaderValue) CollectionsKt.last(HttpHeaderValueParserKt.parseHeaderValue(value));
            String parts = headerValue$iv.getValue();
            List parameters = headerValue$iv.getParams();
            int slash = StringsKt.indexOf$default(parts, '/', 0, false, 6, (Object) null);
            if (slash == -1) {
                if (Intrinsics.areEqual(StringsKt.trim(parts).toString(), "*")) {
                    return ContentType.Companion.getAny();
                }
                throw new BadContentTypeFormatException(value);
            }
            String substring = parts.substring(0, slash);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            String type = StringsKt.trim(substring).toString();
            if (type.length() == 0) {
                throw new BadContentTypeFormatException(value);
            }
            String substring2 = parts.substring(slash + 1);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            String subtype = StringsKt.trim(substring2).toString();
            if (StringsKt.contains$default(type, ' ', false, 2, (Object) null) || StringsKt.contains$default(subtype, ' ', false, 2, (Object) null)) {
                throw new BadContentTypeFormatException(value);
            }
            if ((subtype.length() == 0) || StringsKt.contains$default(subtype, '/', false, 2, (Object) null)) {
                throw new BadContentTypeFormatException(value);
            }
            return new ContentType(type, subtype, parameters);
        }

        public final ContentType getAny() {
            return ContentType.Any;
        }
    }

    /* compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b/\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0013\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\bR\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\bR\u0017\u0010\u0017\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\bR\u0017\u0010\u0019\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u001a\u0010\bR\u0017\u0010\u001b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\bR\u0017\u0010\u001d\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001e\u0010\bR\u0017\u0010\u001f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b \u0010\bR\u0017\u0010!\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b!\u0010\u0006\u001a\u0004\b\"\u0010\bR\u0017\u0010#\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b#\u0010\u0006\u001a\u0004\b$\u0010\bR\u0017\u0010%\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b%\u0010\u0006\u001a\u0004\b&\u0010\bR\u0017\u0010'\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b'\u0010\u0006\u001a\u0004\b(\u0010\bR\u0017\u0010)\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b)\u0010\u0006\u001a\u0004\b*\u0010\bR\u0017\u0010+\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b+\u0010\u0006\u001a\u0004\b,\u0010\bR\u0017\u0010-\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b-\u0010\u0006\u001a\u0004\b.\u0010\bR\u0017\u0010/\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b/\u0010\u0006\u001a\u0004\b0\u0010\bR\u0017\u00101\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b1\u0010\u0006\u001a\u0004\b2\u0010\b¨\u00063"}, d2 = {"Lio/ktor/http/ContentType$Application;", "", "<init>", "()V", "Lio/ktor/http/ContentType;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Atom", "getAtom", "Cbor", "getCbor", "Json", "getJson", "HalJson", "getHalJson", "JavaScript", "getJavaScript", "OctetStream", "getOctetStream", "Rss", "getRss", "Soap", "getSoap", "Xml", "getXml", "Xml_Dtd", "getXml_Dtd", "Zip", "getZip", "GZip", "getGZip", "FormUrlEncoded", "getFormUrlEncoded", "Pdf", "getPdf", "Xlsx", "getXlsx", "Docx", "getDocx", "Pptx", "getPptx", "ProtoBuf", "getProtoBuf", "Wasm", "getWasm", "ProblemJson", "getProblemJson", "ProblemXml", "getProblemXml", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Application {
        public static final Application INSTANCE = new Application();
        private static final ContentType Any = new ContentType("application", "*", null, 4, null);
        private static final ContentType Atom = new ContentType("application", "atom+xml", null, 4, null);
        private static final ContentType Cbor = new ContentType("application", "cbor", null, 4, null);
        private static final ContentType Json = new ContentType("application", "json", null, 4, null);
        private static final ContentType HalJson = new ContentType("application", "hal+json", null, 4, null);
        private static final ContentType JavaScript = new ContentType("application", "javascript", null, 4, null);
        private static final ContentType OctetStream = new ContentType("application", "octet-stream", null, 4, null);
        private static final ContentType Rss = new ContentType("application", "rss+xml", null, 4, null);
        private static final ContentType Soap = new ContentType("application", "soap+xml", null, 4, null);
        private static final ContentType Xml = new ContentType("application", "xml", null, 4, null);
        private static final ContentType Xml_Dtd = new ContentType("application", "xml-dtd", null, 4, null);
        private static final ContentType Zip = new ContentType("application", "zip", null, 4, null);
        private static final ContentType GZip = new ContentType("application", "gzip", null, 4, null);
        private static final ContentType FormUrlEncoded = new ContentType("application", "x-www-form-urlencoded", null, 4, null);
        private static final ContentType Pdf = new ContentType("application", "pdf", null, 4, null);
        private static final ContentType Xlsx = new ContentType("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet", null, 4, null);
        private static final ContentType Docx = new ContentType("application", "vnd.openxmlformats-officedocument.wordprocessingml.document", null, 4, null);
        private static final ContentType Pptx = new ContentType("application", "vnd.openxmlformats-officedocument.presentationml.presentation", null, 4, null);
        private static final ContentType ProtoBuf = new ContentType("application", "protobuf", null, 4, null);
        private static final ContentType Wasm = new ContentType("application", "wasm", null, 4, null);
        private static final ContentType ProblemJson = new ContentType("application", "problem+json", null, 4, null);
        private static final ContentType ProblemXml = new ContentType("application", "problem+xml", null, 4, null);

        private Application() {
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getAtom() {
            return Atom;
        }

        public final ContentType getCbor() {
            return Cbor;
        }

        public final ContentType getJson() {
            return Json;
        }

        public final ContentType getHalJson() {
            return HalJson;
        }

        public final ContentType getJavaScript() {
            return JavaScript;
        }

        public final ContentType getOctetStream() {
            return OctetStream;
        }

        public final ContentType getRss() {
            return Rss;
        }

        public final ContentType getSoap() {
            return Soap;
        }

        public final ContentType getXml() {
            return Xml;
        }

        public final ContentType getXml_Dtd() {
            return Xml_Dtd;
        }

        public final ContentType getZip() {
            return Zip;
        }

        public final ContentType getGZip() {
            return GZip;
        }

        public final ContentType getFormUrlEncoded() {
            return FormUrlEncoded;
        }

        public final ContentType getPdf() {
            return Pdf;
        }

        public final ContentType getXlsx() {
            return Xlsx;
        }

        public final ContentType getDocx() {
            return Docx;
        }

        public final ContentType getPptx() {
            return Pptx;
        }

        public final ContentType getProtoBuf() {
            return ProtoBuf;
        }

        public final ContentType getWasm() {
            return Wasm;
        }

        public final ContentType getProblemJson() {
            return ProblemJson;
        }

        public final ContentType getProblemXml() {
            return ProblemXml;
        }
    }

    /* compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lio/ktor/http/ContentType$Audio;", "", "<init>", "()V", "Lio/ktor/http/ContentType;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "MP4", "getMP4", "MPEG", "getMPEG", "OGG", "getOGG", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Audio {
        public static final Audio INSTANCE = new Audio();
        private static final ContentType Any = new ContentType("audio", "*", null, 4, null);
        private static final ContentType MP4 = new ContentType("audio", "mp4", null, 4, null);
        private static final ContentType MPEG = new ContentType("audio", "mpeg", null, 4, null);
        private static final ContentType OGG = new ContentType("audio", "ogg", null, 4, null);

        private Audio() {
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getMP4() {
            return MP4;
        }

        public final ContentType getMPEG() {
            return MPEG;
        }

        public final ContentType getOGG() {
            return OGG;
        }
    }

    /* compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Lio/ktor/http/ContentType$Image;", "", "<init>", "()V", "Lio/ktor/http/ContentType;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "GIF", "getGIF", "JPEG", "getJPEG", "PNG", "getPNG", "SVG", "getSVG", "XIcon", "getXIcon", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Image {
        public static final Image INSTANCE = new Image();
        private static final ContentType Any = new ContentType("image", "*", null, 4, null);
        private static final ContentType GIF = new ContentType("image", "gif", null, 4, null);
        private static final ContentType JPEG = new ContentType("image", "jpeg", null, 4, null);
        private static final ContentType PNG = new ContentType("image", "png", null, 4, null);
        private static final ContentType SVG = new ContentType("image", "svg+xml", null, 4, null);
        private static final ContentType XIcon = new ContentType("image", "x-icon", null, 4, null);

        private Image() {
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getGIF() {
            return GIF;
        }

        public final ContentType getJPEG() {
            return JPEG;
        }

        public final ContentType getPNG() {
            return PNG;
        }

        public final ContentType getSVG() {
            return SVG;
        }

        public final ContentType getXIcon() {
            return XIcon;
        }
    }

    /* compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lio/ktor/http/ContentType$Message;", "", "<init>", "()V", "Lio/ktor/http/ContentType;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Http", "getHttp", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Message {
        public static final Message INSTANCE = new Message();
        private static final ContentType Any = new ContentType("message", "*", null, 4, null);
        private static final ContentType Http = new ContentType("message", "http", null, 4, null);

        private Message() {
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getHttp() {
            return Http;
        }
    }

    /* compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0013\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\bR\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\b¨\u0006\u0017"}, d2 = {"Lio/ktor/http/ContentType$MultiPart;", "", "<init>", "()V", "Lio/ktor/http/ContentType;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Mixed", "getMixed", "Alternative", "getAlternative", "Related", "getRelated", "FormData", "getFormData", "Signed", "getSigned", "Encrypted", "getEncrypted", "ByteRanges", "getByteRanges", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class MultiPart {
        public static final MultiPart INSTANCE = new MultiPart();
        private static final ContentType Any = new ContentType("multipart", "*", null, 4, null);
        private static final ContentType Mixed = new ContentType("multipart", "mixed", null, 4, null);
        private static final ContentType Alternative = new ContentType("multipart", "alternative", null, 4, null);
        private static final ContentType Related = new ContentType("multipart", "related", null, 4, null);
        private static final ContentType FormData = new ContentType("multipart", "form-data", null, 4, null);
        private static final ContentType Signed = new ContentType("multipart", "signed", null, 4, null);
        private static final ContentType Encrypted = new ContentType("multipart", "encrypted", null, 4, null);
        private static final ContentType ByteRanges = new ContentType("multipart", "byteranges", null, 4, null);

        private MultiPart() {
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getMixed() {
            return Mixed;
        }

        public final ContentType getAlternative() {
            return Alternative;
        }

        public final ContentType getRelated() {
            return Related;
        }

        public final ContentType getFormData() {
            return FormData;
        }

        public final ContentType getSigned() {
            return Signed;
        }

        public final ContentType getEncrypted() {
            return Encrypted;
        }

        public final ContentType getByteRanges() {
            return ByteRanges;
        }
    }

    /* compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0013\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\bR\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\bR\u0017\u0010\u0017\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\b¨\u0006\u0019"}, d2 = {"Lio/ktor/http/ContentType$Text;", "", "<init>", "()V", "Lio/ktor/http/ContentType;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Plain", "getPlain", "CSS", "getCSS", "CSV", "getCSV", "Html", "getHtml", "JavaScript", "getJavaScript", "VCard", "getVCard", "Xml", "getXml", "EventStream", "getEventStream", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Text {
        public static final Text INSTANCE = new Text();
        private static final ContentType Any = new ContentType("text", "*", null, 4, null);
        private static final ContentType Plain = new ContentType("text", "plain", null, 4, null);
        private static final ContentType CSS = new ContentType("text", "css", null, 4, null);
        private static final ContentType CSV = new ContentType("text", "csv", null, 4, null);
        private static final ContentType Html = new ContentType("text", "html", null, 4, null);
        private static final ContentType JavaScript = new ContentType("text", "javascript", null, 4, null);
        private static final ContentType VCard = new ContentType("text", "vcard", null, 4, null);
        private static final ContentType Xml = new ContentType("text", "xml", null, 4, null);
        private static final ContentType EventStream = new ContentType("text", "event-stream", null, 4, null);

        private Text() {
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getPlain() {
            return Plain;
        }

        public final ContentType getCSS() {
            return CSS;
        }

        public final ContentType getCSV() {
            return CSV;
        }

        public final ContentType getHtml() {
            return Html;
        }

        public final ContentType getJavaScript() {
            return JavaScript;
        }

        public final ContentType getVCard() {
            return VCard;
        }

        public final ContentType getXml() {
            return Xml;
        }

        public final ContentType getEventStream() {
            return EventStream;
        }
    }

    /* compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\b¨\u0006\u0011"}, d2 = {"Lio/ktor/http/ContentType$Video;", "", "<init>", "()V", "Lio/ktor/http/ContentType;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "MPEG", "getMPEG", "MP4", "getMP4", "OGG", "getOGG", "QuickTime", "getQuickTime", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Video {
        public static final Video INSTANCE = new Video();
        private static final ContentType Any = new ContentType("video", "*", null, 4, null);
        private static final ContentType MPEG = new ContentType("video", "mpeg", null, 4, null);
        private static final ContentType MP4 = new ContentType("video", "mp4", null, 4, null);
        private static final ContentType OGG = new ContentType("video", "ogg", null, 4, null);
        private static final ContentType QuickTime = new ContentType("video", "quicktime", null, 4, null);

        private Video() {
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getMPEG() {
            return MPEG;
        }

        public final ContentType getMP4() {
            return MP4;
        }

        public final ContentType getOGG() {
            return OGG;
        }

        public final ContentType getQuickTime() {
            return QuickTime;
        }
    }

    /* compiled from: ContentTypes.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0013\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lio/ktor/http/ContentType$Font;", "", "<init>", "()V", "Lio/ktor/http/ContentType;", "Any", "Lio/ktor/http/ContentType;", "getAny", "()Lio/ktor/http/ContentType;", "Collection", "getCollection", "Otf", "getOtf", "Sfnt", "getSfnt", "Ttf", "getTtf", "Woff", "getWoff", "Woff2", "getWoff2", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class Font {
        public static final Font INSTANCE = new Font();
        private static final ContentType Any = new ContentType("font", "*", null, 4, null);
        private static final ContentType Collection = new ContentType("font", "collection", null, 4, null);
        private static final ContentType Otf = new ContentType("font", "otf", null, 4, null);
        private static final ContentType Sfnt = new ContentType("font", "sfnt", null, 4, null);
        private static final ContentType Ttf = new ContentType("font", "ttf", null, 4, null);
        private static final ContentType Woff = new ContentType("font", "woff", null, 4, null);
        private static final ContentType Woff2 = new ContentType("font", "woff2", null, 4, null);

        private Font() {
        }

        public final ContentType getAny() {
            return Any;
        }

        public final ContentType getCollection() {
            return Collection;
        }

        public final ContentType getOtf() {
            return Otf;
        }

        public final ContentType getSfnt() {
            return Sfnt;
        }

        public final ContentType getTtf() {
            return Ttf;
        }

        public final ContentType getWoff() {
            return Woff;
        }

        public final ContentType getWoff2() {
            return Woff2;
        }
    }
}