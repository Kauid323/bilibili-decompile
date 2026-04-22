package tv.danmaku.bili.bilow.lb.internal;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: LbRule.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0016\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"parseBalanceRules", "", "Ltv/danmaku/bili/bilow/lb/internal/LbRule;", "config", "", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LbRuleKt {
    /* JADX WARN: Type inference failed for: r3v1, types: [tv.danmaku.bili.bilow.lb.internal.LbRuleKt$parseBalanceRules$$inlined$parseJson$1] */
    public static final List<LbRule> parseBalanceRules(String config) {
        Intrinsics.checkNotNullParameter(config, "config");
        try {
            Gson $this$parseJson$iv = new Gson();
            return (List) $this$parseJson$iv.fromJson(config, new TypeToken<List<? extends LbRule>>() { // from class: tv.danmaku.bili.bilow.lb.internal.LbRuleKt$parseBalanceRules$$inlined$parseJson$1
            }.getType());
        } catch (Exception e) {
            return null;
        }
    }
}