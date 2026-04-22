package io.ktor.http;

import io.ktor.http.Parameters;
import io.ktor.utils.io.charsets.CharsetJVMKt;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* compiled from: HttpUrlEncoded.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010&\n\u0002\b\u0002\u001a)\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\f\b\u0002\u0010\u0003\u001a\u00060\u0001j\u0002`\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a%\u0010\u000b\u001a\u00020\u0000*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\n0\t¢\u0006\u0004\b\u000b\u0010\f\u001a1\u0010\u0011\u001a\u00020\u0010*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\n0\t2\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0011\u0010\u000b\u001a\u00020\u0000*\u00020\u0006¢\u0006\u0004\b\u000b\u0010\u0013\u001a\u001d\u0010\u0011\u001a\u00020\u0010*\u00020\u00062\n\u0010\u000f\u001a\u00060\rj\u0002`\u000e¢\u0006\u0004\b\u0011\u0010\u0014\u001a\u001f\u0010\u0011\u001a\u00020\u0010*\u00020\u00152\n\u0010\u000f\u001a\u00060\rj\u0002`\u000eH\u0000¢\u0006\u0004\b\u0011\u0010\u0016\u001a7\u0010\u0011\u001a\u00020\u0010*\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00000\t0\u00180\u00172\n\u0010\u000f\u001a\u00060\rj\u0002`\u000eH\u0000¢\u0006\u0004\b\u0011\u0010\u0019¨\u0006\u001a"}, d2 = {"", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "defaultEncoding", "", "limit", "Lio/ktor/http/Parameters;", "parseUrlEncodedParameters", "(Ljava/lang/String;Ljava/nio/charset/Charset;I)Lio/ktor/http/Parameters;", "", "Lkotlin/Pair;", "formUrlEncode", "(Ljava/util/List;)Ljava/lang/String;", "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "out", "", "formUrlEncodeTo", "(Ljava/util/List;Ljava/lang/Appendable;)V", "(Lio/ktor/http/Parameters;)Ljava/lang/String;", "(Lio/ktor/http/Parameters;Ljava/lang/Appendable;)V", "Lio/ktor/http/ParametersBuilder;", "(Lio/ktor/http/ParametersBuilder;Ljava/lang/Appendable;)V", "", "", "(Ljava/util/Set;Ljava/lang/Appendable;)V", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class HttpUrlEncodedKt {
    public static /* synthetic */ Parameters parseUrlEncodedParameters$default(String str, Charset charset, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i3 & 2) != 0) {
            i2 = 1000;
        }
        return parseUrlEncodedParameters(str, charset, i2);
    }

    public static final Parameters parseUrlEncodedParameters(String $this$parseUrlEncodedParameters, Charset defaultEncoding, int limit) {
        Object element$iv;
        String encoding;
        Intrinsics.checkNotNullParameter($this$parseUrlEncodedParameters, "<this>");
        Intrinsics.checkNotNullParameter(defaultEncoding, "defaultEncoding");
        Iterable $this$map$iv = StringsKt.split$default($this$parseUrlEncodedParameters, new String[]{"&"}, false, limit, 2, (Object) null);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(TuplesKt.to(StringsKt.substringBefore$default(it, "=", (String) null, 2, (Object) null), StringsKt.substringAfter(it, "=", "")));
        }
        Iterable parameters = (List) destination$iv$iv;
        Iterable $this$firstOrNull$iv = parameters;
        Iterator it2 = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it2.hasNext()) {
                element$iv = it2.next();
                if (Intrinsics.areEqual(((Pair) element$iv).getFirst(), "_charset_")) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        Pair pair = (Pair) element$iv;
        if (pair == null || (encoding = (String) pair.getSecond()) == null) {
            encoding = CharsetJVMKt.getName(defaultEncoding);
        }
        Charset charset = CharsetJVMKt.forName(Charsets.INSTANCE, encoding);
        Parameters.Companion companion = Parameters.Companion;
        ParametersBuilder $this$parseUrlEncodedParameters_u24lambda_u243 = ParametersKt.ParametersBuilder$default(0, 1, null);
        Iterable $this$forEach$iv = parameters;
        for (Object element$iv2 : $this$forEach$iv) {
            Pair pair2 = (Pair) element$iv2;
            String key = (String) pair2.component1();
            String value = (String) pair2.component2();
            $this$parseUrlEncodedParameters_u24lambda_u243.append(CodecsKt.decodeURLQueryComponent$default(key, 0, 0, false, charset, 7, null), CodecsKt.decodeURLQueryComponent$default(value, 0, 0, false, charset, 7, null));
        }
        return $this$parseUrlEncodedParameters_u24lambda_u243.build();
    }

    public static final String formUrlEncode(List<Pair<String, String>> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        StringBuilder $this$formUrlEncode_u24lambda_u244 = new StringBuilder();
        formUrlEncodeTo(list, $this$formUrlEncode_u24lambda_u244);
        String sb = $this$formUrlEncode_u24lambda_u244.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "toString(...)");
        return sb;
    }

    public static final void formUrlEncodeTo(List<Pair<String, String>> list, Appendable out) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        CollectionsKt.joinTo$default(list, out, "&", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new Function1() { // from class: io.ktor.http.HttpUrlEncodedKt$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                CharSequence formUrlEncodeTo$lambda$5;
                formUrlEncodeTo$lambda$5 = HttpUrlEncodedKt.formUrlEncodeTo$lambda$5((Pair) obj);
                return formUrlEncodeTo$lambda$5;
            }
        }, 60, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence formUrlEncodeTo$lambda$5(Pair it) {
        Intrinsics.checkNotNullParameter(it, "it");
        String key = CodecsKt.encodeURLParameter((String) it.getFirst(), true);
        if (it.getSecond() == null) {
            return key;
        }
        String value = CodecsKt.encodeURLParameterValue(String.valueOf(it.getSecond()));
        return key + '=' + value;
    }

    public static final String formUrlEncode(Parameters $this$formUrlEncode) {
        Intrinsics.checkNotNullParameter($this$formUrlEncode, "<this>");
        Iterable $this$flatMap$iv = $this$formUrlEncode.entries();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            Map.Entry e2 = (Map.Entry) element$iv$iv;
            Iterable $this$map$iv = (Iterable) e2.getValue();
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                Iterable $this$flatMap$iv2 = $this$flatMap$iv;
                String it = (String) item$iv$iv;
                destination$iv$iv2.add(TuplesKt.to(e2.getKey(), it));
                $this$flatMap$iv = $this$flatMap$iv2;
            }
            Iterable $this$flatMap$iv3 = $this$flatMap$iv;
            Iterable list$iv$iv = (List) destination$iv$iv2;
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
            $this$flatMap$iv = $this$flatMap$iv3;
        }
        return formUrlEncode((List) destination$iv$iv);
    }

    public static final void formUrlEncodeTo(Parameters $this$formUrlEncodeTo, Appendable out) {
        Intrinsics.checkNotNullParameter($this$formUrlEncodeTo, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        formUrlEncodeTo($this$formUrlEncodeTo.entries(), out);
    }

    public static final void formUrlEncodeTo(ParametersBuilder $this$formUrlEncodeTo, Appendable out) {
        Intrinsics.checkNotNullParameter($this$formUrlEncodeTo, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        formUrlEncodeTo($this$formUrlEncodeTo.entries(), out);
    }

    public static final void formUrlEncodeTo(Set<? extends Map.Entry<String, ? extends List<String>>> set, Appendable out) {
        Iterable $this$map$iv;
        Intrinsics.checkNotNullParameter(set, "<this>");
        Intrinsics.checkNotNullParameter(out, "out");
        Set<? extends Map.Entry<String, ? extends List<String>>> $this$flatMap$iv = set;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            Map.Entry entry = (Map.Entry) element$iv$iv;
            String key = (String) entry.getKey();
            List value = (List) entry.getValue();
            if (value.isEmpty()) {
                $this$map$iv = CollectionsKt.listOf(TuplesKt.to(key, (Object) null));
            } else {
                List $this$map$iv2 = value;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
                for (Object item$iv$iv : $this$map$iv2) {
                    String it = (String) item$iv$iv;
                    destination$iv$iv2.add(TuplesKt.to(key, it));
                }
                $this$map$iv = (List) destination$iv$iv2;
            }
            Iterable list$iv$iv = $this$map$iv;
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        formUrlEncodeTo((List) destination$iv$iv, out);
    }
}