package tv.danmaku.bili.httpdns.internal.host;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;

/* compiled from: Parse.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u001a\u001a\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"DELIMITERS", "", "parse", "", "config", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ParseKt {
    private static final String DELIMITERS = "|";

    public static final List<String> parse(String config) {
        String str = config;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        Intrinsics.checkNotNull(config);
        Iterable $this$map$iv = StringsKt.split$default(config, new String[]{DELIMITERS}, false, 0, 6, (Object) null);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            String it = (String) item$iv$iv;
            destination$iv$iv.add(StringsKt.trim(it).toString());
        }
        return (List) destination$iv$iv;
    }
}