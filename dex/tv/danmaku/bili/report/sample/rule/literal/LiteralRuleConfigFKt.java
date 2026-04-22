package tv.danmaku.bili.report.sample.rule.literal;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;

/* compiled from: LiteralRuleConfigF.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a\u001a\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002¨\u0006\n"}, d2 = {"parseLiteralRuleF", "", "Ltv/danmaku/bili/report/sample/rule/literal/LiteralRuleF;", "config", "", "matchLiteralRuleF", "target", "rules", "parseConfig", "Ltv/danmaku/bili/report/sample/rule/literal/LiteralRuleConfigF;", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LiteralRuleConfigFKt {
    public static final List<LiteralRuleF> parseLiteralRuleF(String config) {
        Iterable parseConfig = parseConfig(config);
        if (parseConfig == null) {
            return null;
        }
        Iterable $this$map$iv = parseConfig;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            LiteralRuleConfigF it = (LiteralRuleConfigF) item$iv$iv;
            destination$iv$iv.add(new LiteralRuleF(it));
        }
        return (List) destination$iv$iv;
    }

    public static final LiteralRuleF matchLiteralRuleF(String target, List<LiteralRuleF> list) {
        Object element$iv;
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(list, "rules");
        List<LiteralRuleF> $this$firstOrNull$iv = list;
        Iterator<T> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                LiteralRuleF it2 = (LiteralRuleF) element$iv;
                if (it2.matches(target)) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        return (LiteralRuleF) element$iv;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x003d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x001b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final List<LiteralRuleConfigF> parseConfig(String config) {
        boolean z;
        try {
            Iterable list = JSON.parseArray(config, LiteralRuleConfigF.class);
            if (list == null) {
                return null;
            }
            Iterable $this$filterNot$iv = list;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filterNot$iv) {
                LiteralRuleConfigF it = (LiteralRuleConfigF) element$iv$iv;
                String literal = it.getLiteral();
                if (literal != null && !StringsKt.isBlank(literal)) {
                    z = false;
                    if (z) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                z = true;
                if (z) {
                }
            }
            return (List) destination$iv$iv;
        } catch (Exception e) {
            return null;
        }
    }
}