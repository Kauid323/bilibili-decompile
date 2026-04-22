package tv.danmaku.bili.ui.clipboard;

import com.alibaba.fastjson.annotation.JSONField;
import java.util.List;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: ClipboardChecker.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R(\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/clipboard/RegexData;", "", "<init>", "()V", "rules", "", "Ltv/danmaku/bili/ui/clipboard/RegexRule;", "getRules", "()Ljava/util/List;", "setRules", "(Ljava/util/List;)V", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RegexData {
    public static final int $stable = 8;
    @JSONField(name = "clipboard_rules")
    private List<RegexRule> rules;

    public final List<RegexRule> getRules() {
        return this.rules;
    }

    public final void setRules(List<RegexRule> list) {
        this.rules = list;
    }
}