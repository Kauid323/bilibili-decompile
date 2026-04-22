package tv.danmaku.bili.bilow.domain;

import com.alibaba.fastjson.JSON;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: MultiDomain.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0003¨\u0006\u0005"}, d2 = {"parse", "", "Ltv/danmaku/bili/bilow/domain/RuleConfig;", "config", "", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MultiDomainKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final List<RuleConfig> parse(String config) {
        try {
            Iterable list = JSON.parseArray(config, RuleConfig.class);
            if (list == null) {
                return null;
            }
            Iterable $this$filter$iv = list;
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                RuleConfig it = (RuleConfig) element$iv$iv;
                if (it.valid()) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            return (List) destination$iv$iv;
        } catch (Exception e) {
            return null;
        }
    }
}