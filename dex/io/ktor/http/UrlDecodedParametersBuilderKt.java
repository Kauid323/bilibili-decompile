package io.ktor.http;

import io.ktor.util.StringValues;
import io.ktor.util.StringValuesBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UrlDecodedParametersBuilder.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\n\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\n\u0010\u000b\u001a\u001b\u0010\f\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/util/StringValuesBuilder;", "parameters", "Lio/ktor/http/Parameters;", "decodeParameters", "(Lio/ktor/util/StringValuesBuilder;)Lio/ktor/http/Parameters;", "Lio/ktor/util/StringValues;", "Lio/ktor/http/ParametersBuilder;", "encodeParameters", "(Lio/ktor/util/StringValues;)Lio/ktor/http/ParametersBuilder;", "", "appendAllDecoded", "(Lio/ktor/util/StringValuesBuilder;Lio/ktor/util/StringValuesBuilder;)V", "appendAllEncoded", "(Lio/ktor/util/StringValuesBuilder;Lio/ktor/util/StringValues;)V", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class UrlDecodedParametersBuilderKt {
    public static final /* synthetic */ void access$appendAllEncoded(StringValuesBuilder $receiver, StringValues parameters) {
        appendAllEncoded($receiver, parameters);
    }

    public static final Parameters decodeParameters(StringValuesBuilder parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        ParametersBuilder $this$decodeParameters_u24lambda_u240 = ParametersKt.ParametersBuilder$default(0, 1, null);
        appendAllDecoded($this$decodeParameters_u24lambda_u240, parameters);
        return $this$decodeParameters_u24lambda_u240.build();
    }

    public static final ParametersBuilder encodeParameters(StringValues parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        ParametersBuilder $this$encodeParameters_u24lambda_u241 = ParametersKt.ParametersBuilder$default(0, 1, null);
        appendAllEncoded($this$encodeParameters_u24lambda_u241, parameters);
        return $this$encodeParameters_u24lambda_u241;
    }

    private static final void appendAllDecoded(StringValuesBuilder $this$appendAllDecoded, StringValuesBuilder parameters) {
        Iterable $this$forEach$iv = parameters.names();
        for (Object element$iv : $this$forEach$iv) {
            String key = (String) element$iv;
            Iterable all = parameters.getAll(key);
            if (all == null) {
                all = CollectionsKt.emptyList();
            }
            Iterable values = all;
            String decodeURLQueryComponent$default = CodecsKt.decodeURLQueryComponent$default(key, 0, 0, false, null, 15, null);
            Iterable $this$map$iv = values;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                String it = (String) item$iv$iv;
                destination$iv$iv.add(CodecsKt.decodeURLQueryComponent$default(it, 0, 0, true, null, 11, null));
                $this$forEach$iv = $this$forEach$iv;
            }
            $this$appendAllDecoded.appendAll(decodeURLQueryComponent$default, (List) destination$iv$iv);
            $this$forEach$iv = $this$forEach$iv;
        }
    }

    public static final void appendAllEncoded(StringValuesBuilder $this$appendAllEncoded, StringValues parameters) {
        Iterable $this$forEach$iv = parameters.names();
        for (Object element$iv : $this$forEach$iv) {
            String key = (String) element$iv;
            List values = parameters.getAll(key);
            if (values == null) {
                values = CollectionsKt.emptyList();
            }
            String encodeURLParameter$default = CodecsKt.encodeURLParameter$default(key, false, 1, null);
            List $this$map$iv = values;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                String it = (String) item$iv$iv;
                destination$iv$iv.add(CodecsKt.encodeURLParameterValue(it));
                $this$forEach$iv = $this$forEach$iv;
            }
            $this$appendAllEncoded.appendAll(encodeURLParameter$default, (List) destination$iv$iv);
            $this$forEach$iv = $this$forEach$iv;
        }
    }
}