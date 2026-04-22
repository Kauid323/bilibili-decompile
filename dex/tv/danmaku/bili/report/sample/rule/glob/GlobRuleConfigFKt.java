package tv.danmaku.bili.report.sample.rule.glob;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.filechooser.FileUtils;

/* compiled from: GlobRuleConfigF.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a\u001a\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002\u001a\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¨\u0006\f"}, d2 = {"parseGlobRuleF", "", "Ltv/danmaku/bili/report/sample/rule/glob/GlobRuleF;", "config", "", "matchGlobRuleF", "target", "rules", "parseConfig", "Ltv/danmaku/bili/report/sample/rule/glob/GlobRuleConfigF;", "globToRegex", "glob", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GlobRuleConfigFKt {
    public static final List<GlobRuleF> parseGlobRuleF(String config) {
        Iterable parseConfig = parseConfig(config);
        if (parseConfig == null) {
            return null;
        }
        Iterable $this$map$iv = parseConfig;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            GlobRuleConfigF it = (GlobRuleConfigF) item$iv$iv;
            destination$iv$iv.add(new GlobRuleF(it));
        }
        return (List) destination$iv$iv;
    }

    public static final GlobRuleF matchGlobRuleF(String target, List<GlobRuleF> list) {
        Object element$iv;
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(list, "rules");
        List<GlobRuleF> $this$firstOrNull$iv = list;
        Iterator<T> it = $this$firstOrNull$iv.iterator();
        while (true) {
            if (it.hasNext()) {
                element$iv = it.next();
                GlobRuleF it2 = (GlobRuleF) element$iv;
                if (it2.matches(target)) {
                    break;
                }
            } else {
                element$iv = null;
                break;
            }
        }
        return (GlobRuleF) element$iv;
    }

    private static final List<GlobRuleConfigF> parseConfig(String config) {
        try {
            List<GlobRuleConfigF> parseArray = JSON.parseArray(config, GlobRuleConfigF.class);
            if (parseArray == null) {
                return null;
            }
            return parseArray;
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String globToRegex(String glob) {
        String out = "^";
        int length = glob.length();
        for (int i = 0; i < length; i++) {
            char c = glob.charAt(i);
            switch (c) {
                case '*':
                    out = out + ".*";
                    break;
                case BR.badgeText /* 46 */:
                    out = out + "\\.";
                    break;
                case BR.bgImg /* 63 */:
                    out = out + FileUtils.HIDDEN_PREFIX;
                    break;
                case BR.cardWidth /* 92 */:
                    out = out + "\\\\";
                    break;
                default:
                    out = out + c;
                    break;
            }
        }
        return out + "$";
    }
}