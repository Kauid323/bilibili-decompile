package tv.danmaku.bili.ui.freedata.tracer;

import com.bapis.bilibili.app.wall.v1.RuleInfo;
import com.bapis.bilibili.app.wall.v1.RulesInfo;
import com.bapis.bilibili.app.wall.v1.RulesReply;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.bilow.domain.MultiDomain;
import tv.danmaku.bili.bilow.domain.RuleConfig;

/* compiled from: TfMultiDomain.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a@\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062.\u0010\u0007\u001a*\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\n0\bj\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\n`\u000bH\u0003\u001a\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u0006H\u0003¨\u0006\u000e"}, d2 = {"updateMultiDomainRule", "", "rulesReply", "Lcom/bapis/bilibili/app/wall/v1/RulesReply;", "mergeDomainList", "info", "Lcom/bapis/bilibili/app/wall/v1/RuleInfo;", "map", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "isMultiDomainRule", "", "billow-biz_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class TfMultiDomainKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final void updateMultiDomainRule(RulesReply rulesReply) {
        Intrinsics.checkNotNullParameter(rulesReply, "rulesReply");
        HashMap map = new HashMap();
        for (Object element$iv : rulesReply.getRulesInfoMap().values()) {
            Iterable $this$forEach$iv = ((RulesInfo) element$iv).getRulesInfoList();
            Intrinsics.checkNotNullExpressionValue($this$forEach$iv, "getRulesInfoList(...)");
            for (Object element$iv2 : $this$forEach$iv) {
                RuleInfo it = (RuleInfo) element$iv2;
                Intrinsics.checkNotNull(it);
                mergeDomainList(it, map);
            }
        }
        Iterable $this$forEach$iv2 = map.entrySet();
        Intrinsics.checkNotNullExpressionValue($this$forEach$iv2, "<get-entries>(...)");
        Iterable $this$map$iv = $this$forEach$iv2;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Map.Entry it2 = (Map.Entry) item$iv$iv;
            Object value = it2.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-value>(...)");
            destination$iv$iv.add(new RuleConfig(0.0f, CollectionsKt.flatten(CollectionsKt.listOf(new List[]{CollectionsKt.listOf(it2.getKey()), value})), 1, null));
        }
        Iterable $this$filter$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (((RuleConfig) element$iv$iv).valid()) {
                destination$iv$iv2.add(element$iv$iv);
            }
        }
        List config = (List) destination$iv$iv2;
        MultiDomain.INSTANCE.updateRules(config);
    }

    private static final void mergeDomainList(RuleInfo info, HashMap<String, List<String>> hashMap) {
        if (isMultiDomainRule(info)) {
            String host = info.getA();
            List list = hashMap.get(host);
            if (list == null) {
                hashMap.put(host, info.getABackupList());
                return;
            }
            Iterable aBackupList = info.getABackupList();
            Intrinsics.checkNotNullExpressionValue(aBackupList, "getABackupList(...)");
            Iterable $this$forEach$iv = aBackupList;
            for (Object element$iv : $this$forEach$iv) {
                String it = (String) element$iv;
                if (!list.contains(it)) {
                    Intrinsics.checkNotNull(it);
                    list.add(it);
                }
            }
        }
    }

    private static final boolean isMultiDomainRule(RuleInfo info) {
        if (info.getTf()) {
            String a = info.getA();
            Intrinsics.checkNotNullExpressionValue(a, "getA(...)");
            if (a.length() > 0) {
                List aBackupList = info.getABackupList();
                Intrinsics.checkNotNullExpressionValue(aBackupList, "getABackupList(...)");
                return !aBackupList.isEmpty();
            }
            return false;
        }
        return false;
    }
}