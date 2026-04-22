package io.ktor.http;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: URLBuilder.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a)\u0010\u0005\u001a\u00028\u0000\"\f\b\u0000\u0010\u0002*\u00060\u0000j\u0002`\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a'\u0010\u000b\u001a\u00020\n*\u00060\u0000j\u0002`\u00012\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\f\u001a'\u0010\u000e\u001a\u00020\n*\u00060\u0000j\u0002`\u00012\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\f\u001a\u001f\u0010\u000f\u001a\u00020\n*\u00060\u0000j\u0002`\u00012\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0011\u0010\u0011\u001a\u00020\u0003*\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012\u001a)\u0010\u0017\u001a\u00020\u0003*\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018\u001a/\u0010\u0017\u001a\u00020\u0003*\u00020\u00032\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0019\"\u00020\u00072\b\b\u0002\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u001b\u001a%\u0010\u001c\u001a\u00020\n*\u00020\u00032\u0012\u0010\u001c\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0019\"\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001f\u0010\u001e\u001a\u00020\u0003*\u00020\u00032\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013¢\u0006\u0004\b\u001e\u0010\u001f\u001a%\u0010\u001e\u001a\u00020\u0003*\u00020\u00032\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0019\"\u00020\u0007¢\u0006\u0004\b\u001e\u0010 \u001a\u0019\u0010!\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0002¢\u0006\u0004\b!\u0010\"\u001a\\\u0010)\u001a\u00020\n*\u00020\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00072\u0019\b\u0002\u0010(\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0&¢\u0006\u0002\b'¢\u0006\u0004\b)\u0010*\u001a'\u0010+\u001a\u00020\u0003*\u00020\u00032\u0012\u0010\u001a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0019\"\u00020\u0007H\u0007¢\u0006\u0004\b+\u0010 \u001a!\u0010+\u001a\u00020\u0003*\u00020\u00032\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013H\u0007¢\u0006\u0004\b+\u0010\u001f\"\u0014\u0010,\u001a\u00020$8\u0006X\u0086T¢\u0006\u0006\n\u0004\b,\u0010-\"\u0018\u00100\u001a\u00020\u0007*\u00020\u00038@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/\"\u0015\u00102\u001a\u00020\u0007*\u00020\u00038F¢\u0006\u0006\u001a\u0004\b1\u0010/\"(\u0010\r\u001a\u00020\u0007*\u00020\u00032\u0006\u00103\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b4\u0010/\"\u0004\b5\u00106¨\u00067"}, d2 = {"Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "A", "Lio/ktor/http/URLBuilder;", "out", "appendTo", "(Lio/ktor/http/URLBuilder;Ljava/lang/Appendable;)Ljava/lang/Appendable;", "", "encodedUser", "host", "", "appendMailto", "(Ljava/lang/Appendable;Ljava/lang/String;Ljava/lang/String;)V", "encodedPath", "appendFile", "appendAbout", "(Ljava/lang/Appendable;Ljava/lang/String;)V", "clone", "(Lio/ktor/http/URLBuilder;)Lio/ktor/http/URLBuilder;", "", "segments", "", "encodeSlash", "appendPathSegments", "(Lio/ktor/http/URLBuilder;Ljava/util/List;Z)Lio/ktor/http/URLBuilder;", "", "components", "(Lio/ktor/http/URLBuilder;[Ljava/lang/String;Z)Lio/ktor/http/URLBuilder;", "path", "(Lio/ktor/http/URLBuilder;[Ljava/lang/String;)V", "appendEncodedPathSegments", "(Lio/ktor/http/URLBuilder;Ljava/util/List;)Lio/ktor/http/URLBuilder;", "(Lio/ktor/http/URLBuilder;[Ljava/lang/String;)Lio/ktor/http/URLBuilder;", "joinPath", "(Ljava/util/List;)Ljava/lang/String;", "scheme", "", "port", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "block", "set", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "pathComponents", "DEFAULT_PORT", "I", "getEncodedUserAndPassword", "(Lio/ktor/http/URLBuilder;)Ljava/lang/String;", "encodedUserAndPassword", "getAuthority", "authority", "value", "getEncodedPath", "setEncodedPath", "(Lio/ktor/http/URLBuilder;Ljava/lang/String;)V", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class URLBuilderKt {
    public static final int DEFAULT_PORT = 0;

    public static final <A extends Appendable> A appendTo(URLBuilder $this$appendTo, A a) {
        a.append($this$appendTo.getProtocol().getName());
        String name = $this$appendTo.getProtocol().getName();
        switch (name.hashCode()) {
            case -1081572750:
                if (name.equals("mailto")) {
                    appendMailto(a, getEncodedUserAndPassword($this$appendTo), $this$appendTo.getHost());
                    return a;
                }
                break;
            case 3143036:
                if (name.equals("file")) {
                    appendFile(a, $this$appendTo.getHost(), getEncodedPath($this$appendTo));
                    return a;
                }
                break;
            case 92611469:
                if (name.equals("about")) {
                    appendAbout(a, $this$appendTo.getHost());
                    return a;
                }
                break;
        }
        a.append("://");
        a.append(getAuthority($this$appendTo));
        URLUtilsKt.appendUrlFullPath(a, getEncodedPath($this$appendTo), $this$appendTo.getEncodedParameters(), $this$appendTo.getTrailingQuery());
        if ($this$appendTo.getEncodedFragment().length() > 0) {
            a.append('#');
            a.append($this$appendTo.getEncodedFragment());
        }
        return a;
    }

    private static final void appendMailto(Appendable $this$appendMailto, String encodedUser, String host2) {
        $this$appendMailto.append(":");
        $this$appendMailto.append(encodedUser);
        $this$appendMailto.append(host2);
    }

    private static final void appendFile(Appendable $this$appendFile, String host2, String encodedPath) {
        $this$appendFile.append("://");
        $this$appendFile.append(host2);
        if (!StringsKt.startsWith$default(encodedPath, '/', false, 2, (Object) null)) {
            $this$appendFile.append('/');
        }
        $this$appendFile.append(encodedPath);
    }

    private static final void appendAbout(Appendable $this$appendAbout, String host2) {
        $this$appendAbout.append(":");
        $this$appendAbout.append(host2);
    }

    public static final URLBuilder clone(URLBuilder $this$clone) {
        Intrinsics.checkNotNullParameter($this$clone, "<this>");
        return URLUtilsKt.takeFrom(new URLBuilder(null, null, 0, null, null, null, null, null, false, 511, null), $this$clone);
    }

    public static final String getEncodedUserAndPassword(URLBuilder $this$encodedUserAndPassword) {
        Intrinsics.checkNotNullParameter($this$encodedUserAndPassword, "<this>");
        StringBuilder $this$_get_encodedUserAndPassword__u24lambda_u240 = new StringBuilder();
        URLUtilsKt.appendUserAndPassword($this$_get_encodedUserAndPassword__u24lambda_u240, $this$encodedUserAndPassword.getEncodedUser(), $this$encodedUserAndPassword.getEncodedPassword());
        String sb = $this$_get_encodedUserAndPassword__u24lambda_u240.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public static /* synthetic */ URLBuilder appendPathSegments$default(URLBuilder uRLBuilder, List list, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return appendPathSegments(uRLBuilder, list, z);
    }

    public static final URLBuilder appendPathSegments(URLBuilder $this$appendPathSegments, List<String> list, boolean encodeSlash) {
        Collection destination$iv$iv;
        Intrinsics.checkNotNullParameter($this$appendPathSegments, "<this>");
        Intrinsics.checkNotNullParameter(list, "segments");
        if (encodeSlash) {
            destination$iv$iv = list;
        } else {
            List<String> $this$flatMap$iv = list;
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv : $this$flatMap$iv) {
                String it = (String) element$iv$iv;
                Iterable list$iv$iv = StringsKt.split$default(it, new char[]{'/'}, false, 0, 6, (Object) null);
                CollectionsKt.addAll(destination$iv$iv2, list$iv$iv);
            }
            destination$iv$iv = (List) destination$iv$iv2;
        }
        Collection pathSegments = destination$iv$iv;
        Collection $this$map$iv = pathSegments;
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it2 = (String) item$iv$iv;
            destination$iv$iv3.add(CodecsKt.encodeURLPathPart(it2));
        }
        List encodedSegments = (List) destination$iv$iv3;
        appendEncodedPathSegments($this$appendPathSegments, encodedSegments);
        return $this$appendPathSegments;
    }

    public static /* synthetic */ URLBuilder appendPathSegments$default(URLBuilder uRLBuilder, String[] strArr, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return appendPathSegments(uRLBuilder, strArr, z);
    }

    public static final URLBuilder appendPathSegments(URLBuilder $this$appendPathSegments, String[] components, boolean encodeSlash) {
        Intrinsics.checkNotNullParameter($this$appendPathSegments, "<this>");
        Intrinsics.checkNotNullParameter(components, "components");
        return appendPathSegments($this$appendPathSegments, ArraysKt.toList(components), encodeSlash);
    }

    public static final void path(URLBuilder $this$path, String... path) {
        Intrinsics.checkNotNullParameter($this$path, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        Collection destination$iv$iv = new ArrayList(path.length);
        for (String str : path) {
            String it = CodecsKt.encodeURLPath$default(str, false, false, 3, null);
            destination$iv$iv.add(it);
        }
        $this$path.setEncodedPathSegments((List) destination$iv$iv);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x008f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final URLBuilder appendEncodedPathSegments(URLBuilder $this$appendEncodedPathSegments, List<String> list) {
        boolean endsWithSlash;
        List<String> plus;
        Intrinsics.checkNotNullParameter($this$appendEncodedPathSegments, "<this>");
        Intrinsics.checkNotNullParameter(list, "segments");
        boolean startWithSlash = false;
        if ($this$appendEncodedPathSegments.getEncodedPathSegments().size() > 1) {
            if ((((CharSequence) CollectionsKt.last($this$appendEncodedPathSegments.getEncodedPathSegments())).length() == 0) && !list.isEmpty()) {
                endsWithSlash = true;
                if (list.size() > 1) {
                    if ((((CharSequence) CollectionsKt.first(list)).length() == 0) && !$this$appendEncodedPathSegments.getEncodedPathSegments().isEmpty()) {
                        startWithSlash = true;
                    }
                }
                if (!endsWithSlash && startWithSlash) {
                    plus = CollectionsKt.plus(CollectionsKt.dropLast($this$appendEncodedPathSegments.getEncodedPathSegments(), 1), CollectionsKt.drop(list, 1));
                } else if (endsWithSlash) {
                    plus = startWithSlash ? CollectionsKt.plus($this$appendEncodedPathSegments.getEncodedPathSegments(), CollectionsKt.drop(list, 1)) : CollectionsKt.plus($this$appendEncodedPathSegments.getEncodedPathSegments(), list);
                } else {
                    plus = CollectionsKt.plus(CollectionsKt.dropLast($this$appendEncodedPathSegments.getEncodedPathSegments(), 1), list);
                }
                $this$appendEncodedPathSegments.setEncodedPathSegments(plus);
                return $this$appendEncodedPathSegments;
            }
        }
        endsWithSlash = false;
        if (list.size() > 1) {
        }
        if (!endsWithSlash) {
        }
        if (endsWithSlash) {
        }
        $this$appendEncodedPathSegments.setEncodedPathSegments(plus);
        return $this$appendEncodedPathSegments;
    }

    public static final URLBuilder appendEncodedPathSegments(URLBuilder $this$appendEncodedPathSegments, String... components) {
        Intrinsics.checkNotNullParameter($this$appendEncodedPathSegments, "<this>");
        Intrinsics.checkNotNullParameter(components, "components");
        return appendEncodedPathSegments($this$appendEncodedPathSegments, ArraysKt.toList(components));
    }

    public static final String getAuthority(URLBuilder $this$authority) {
        Intrinsics.checkNotNullParameter($this$authority, "<this>");
        StringBuilder $this$_get_authority__u24lambda_u244 = new StringBuilder();
        $this$_get_authority__u24lambda_u244.append(getEncodedUserAndPassword($this$authority));
        $this$_get_authority__u24lambda_u244.append($this$authority.getHost());
        if ($this$authority.getPort() != 0 && $this$authority.getPort() != $this$authority.getProtocol().getDefaultPort()) {
            $this$_get_authority__u24lambda_u244.append(":");
            $this$_get_authority__u24lambda_u244.append(String.valueOf($this$authority.getPort()));
        }
        String sb = $this$_get_authority__u24lambda_u244.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public static final String getEncodedPath(URLBuilder $this$encodedPath) {
        Intrinsics.checkNotNullParameter($this$encodedPath, "<this>");
        return joinPath($this$encodedPath.getEncodedPathSegments());
    }

    public static final void setEncodedPath(URLBuilder $this$encodedPath, String value) {
        List<String> root_path;
        Intrinsics.checkNotNullParameter($this$encodedPath, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        if (StringsKt.isBlank(value)) {
            root_path = CollectionsKt.emptyList();
        } else {
            root_path = Intrinsics.areEqual(value, "/") ? URLParserKt.getROOT_PATH() : CollectionsKt.toMutableList(StringsKt.split$default(value, new char[]{'/'}, false, 0, 6, (Object) null));
        }
        $this$encodedPath.setEncodedPathSegments(root_path);
    }

    private static final String joinPath(List<String> list) {
        if (list.isEmpty()) {
            return "";
        }
        if (list.size() == 1) {
            return ((CharSequence) CollectionsKt.first(list)).length() == 0 ? "/" : (String) CollectionsKt.first(list);
        }
        return CollectionsKt.joinToString$default(list, "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public static /* synthetic */ void set$default(URLBuilder uRLBuilder, String str, String str2, Integer num, String str3, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            num = null;
        }
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        if ((i2 & 16) != 0) {
            function1 = new Function1() { // from class: io.ktor.http.URLBuilderKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj2) {
                    Unit unit;
                    unit = URLBuilderKt.set$lambda$5((URLBuilder) obj2);
                    return unit;
                }
            };
        }
        set(uRLBuilder, str, str2, num, str3, function1);
    }

    public static final Unit set$lambda$5(URLBuilder uRLBuilder) {
        Intrinsics.checkNotNullParameter(uRLBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final void set(URLBuilder $this$set, String scheme, String host2, Integer port, String path, Function1<? super URLBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$set, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (scheme != null) {
            $this$set.setProtocol(URLProtocol.Companion.createOrDefault(scheme));
        }
        if (host2 != null) {
            $this$set.setHost(host2);
        }
        if (port != null) {
            $this$set.setPort(port.intValue());
        }
        if (path != null) {
            setEncodedPath($this$set, path);
        }
        function1.invoke($this$set);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Please use appendPathSegments method", replaceWith = @ReplaceWith(expression = "this.appendPathSegments(components", imports = {}))
    public static final URLBuilder pathComponents(URLBuilder $this$pathComponents, String... components) {
        Intrinsics.checkNotNullParameter($this$pathComponents, "<this>");
        Intrinsics.checkNotNullParameter(components, "components");
        return appendPathSegments$default($this$pathComponents, ArraysKt.toList(components), false, 2, (Object) null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Please use appendPathSegments method", replaceWith = @ReplaceWith(expression = "this.appendPathSegments(components", imports = {}))
    public static final URLBuilder pathComponents(URLBuilder $this$pathComponents, List<String> list) {
        Intrinsics.checkNotNullParameter($this$pathComponents, "<this>");
        Intrinsics.checkNotNullParameter(list, "components");
        return appendPathSegments$default($this$pathComponents, (List) list, false, 2, (Object) null);
    }
}