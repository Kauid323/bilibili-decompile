package kntr.common.router;

import com.bilibili.lib.brouter.uri.Builder;
import com.bilibili.lib.brouter.uri.Uri;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Uris.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001c\u0010\u0003\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u001a2\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00022\u001e\u0010\b\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\n0\t¨\u0006\u000b"}, d2 = {"toUri", "Lcom/bilibili/lib/brouter/uri/Uri;", "", "appendQueryDroppingNull", "Lcom/bilibili/lib/brouter/uri/Builder;", "key", "value", "updateQueryParameter", "function", "Lkotlin/Function1;", "", "router_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class UrisKt {
    public static final Uri toUri(String $this$toUri) {
        Intrinsics.checkNotNullParameter($this$toUri, "<this>");
        return Uri.Companion.parse($this$toUri);
    }

    public static final Builder appendQueryDroppingNull(Builder $this$appendQueryDroppingNull, String key, String value) {
        Intrinsics.checkNotNullParameter($this$appendQueryDroppingNull, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        if (value == null) {
            return $this$appendQueryDroppingNull;
        }
        return $this$appendQueryDroppingNull.appendQueryParameter(key, value);
    }

    public static final Uri updateQueryParameter(Uri $this$updateQueryParameter, String key, Function1<? super List<String>, ? extends List<String>> function1) {
        Uri uri = $this$updateQueryParameter;
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(function1, "function");
        if (!$this$updateQueryParameter.isHierarchical()) {
            return uri;
        }
        List original = $this$updateQueryParameter.getQueryParameters(key);
        Iterable iterable = (List) function1.invoke(original);
        if (Intrinsics.areEqual(iterable, original)) {
            return uri;
        }
        Iterable names = $this$updateQueryParameter.getQueryParameterNames();
        Builder builder = $this$updateQueryParameter.buildUpon().clearQuery();
        Iterable $this$forEach$iv = iterable;
        for (Object element$iv : $this$forEach$iv) {
            String it = (String) element$iv;
            builder.appendQueryParameter(key, it);
        }
        Iterable $this$forEach$iv2 = names;
        for (Object element$iv2 : $this$forEach$iv2) {
            String name = (String) element$iv2;
            if (!Intrinsics.areEqual(name, key)) {
                Iterable $this$forEach$iv3 = uri.getQueryParameters(name);
                for (Object element$iv3 : $this$forEach$iv3) {
                    String it2 = (String) element$iv3;
                    builder.appendQueryParameter(name, it2);
                }
            }
            uri = $this$updateQueryParameter;
        }
        return builder.build();
    }
}