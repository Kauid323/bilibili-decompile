package tv.danmaku.bili.bilow.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;

/* compiled from: MultiDomain.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0007J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0007J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u0006H\u0007J\u0018\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00192\u0006\u0010\u0016\u001a\u00020\u0006H\u0007J\u0018\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0007J\u0016\u0010\u001c\u001a\u00020\u00132\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0019H\u0007R*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000f*\u0004\u0018\u00010\u000e0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u000f*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Ltv/danmaku/bili/bilow/domain/MultiDomain;", "", "<init>", "()V", "rules", "Ljava/util/HashMap;", "", "Ltv/danmaku/bili/bilow/domain/Rule;", "Lkotlin/collections/HashMap;", "rdm", "Ljava/util/Random;", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "r", "Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;", "kotlin.jvm.PlatformType", "w", "Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;", "initRules", "", "isEnabled", "", "rawHost", "alternative", "domains", "", "setAlternative", ReportEvent.Tag.HOST, "updateRules", "config", "Ltv/danmaku/bili/bilow/domain/RuleConfig;", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MultiDomain {
    public static final MultiDomain INSTANCE = new MultiDomain();
    private static final HashMap<String, Rule> rules = new HashMap<>();
    private static final Random rdm = new Random();
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static final ReentrantReadWriteLock.ReadLock r = lock.readLock();
    private static final ReentrantReadWriteLock.WriteLock w = lock.writeLock();

    private MultiDomain() {
    }

    static {
        INSTANCE.initRules();
    }

    public final void initRules() {
        List config;
        String multiDomainRules = Config.INSTANCE.getMultiDomainRules();
        if (multiDomainRules == null) {
            multiDomainRules = "[]";
        }
        config = MultiDomainKt.parse(multiDomainRules);
        if (config == null) {
            config = CollectionsKt.emptyList();
        }
        updateRules(config);
    }

    public final boolean isEnabled(String rawHost) {
        Intrinsics.checkNotNullParameter(rawHost, "rawHost");
        ReentrantReadWriteLock.ReadLock readLock = r;
        Intrinsics.checkNotNullExpressionValue(readLock, "r");
        ReentrantReadWriteLock.ReadLock readLock2 = readLock;
        readLock2.lock();
        try {
            Rule it = rules.get(rawHost);
            boolean z = false;
            if (it != null) {
                if (rdm.nextFloat() < it.getSample()) {
                    z = true;
                }
            }
            return z;
        } finally {
            readLock2.unlock();
        }
    }

    public final String alternative(String rawHost) {
        Intrinsics.checkNotNullParameter(rawHost, "rawHost");
        ReentrantReadWriteLock.ReadLock readLock = r;
        Intrinsics.checkNotNullExpressionValue(readLock, "r");
        ReentrantReadWriteLock.ReadLock readLock2 = readLock;
        readLock2.lock();
        try {
            Rule rule = rules.get(rawHost);
            return rule != null ? rule.getAlt() : null;
        } finally {
            readLock2.unlock();
        }
    }

    public final List<String> domains(String rawHost) {
        Intrinsics.checkNotNullParameter(rawHost, "rawHost");
        ReentrantReadWriteLock.ReadLock readLock = r;
        Intrinsics.checkNotNullExpressionValue(readLock, "r");
        ReentrantReadWriteLock.ReadLock readLock2 = readLock;
        readLock2.lock();
        try {
            Rule rule = rules.get(rawHost);
            return rule != null ? rule.getDomains() : null;
        } finally {
            readLock2.unlock();
        }
    }

    public final void setAlternative(String rawHost, String host) {
        Intrinsics.checkNotNullParameter(rawHost, "rawHost");
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        ReentrantReadWriteLock.WriteLock writeLock = w;
        Intrinsics.checkNotNullExpressionValue(writeLock, "w");
        ReentrantReadWriteLock.WriteLock writeLock2 = writeLock;
        writeLock2.lock();
        try {
            Rule it = rules.get(rawHost);
            if (it != null) {
                it.setAlt(host);
                Unit unit = Unit.INSTANCE;
            }
        } finally {
            writeLock2.unlock();
        }
    }

    public final void updateRules(List<RuleConfig> list) {
        Intrinsics.checkNotNullParameter(list, "config");
        ReentrantReadWriteLock.WriteLock writeLock = w;
        Intrinsics.checkNotNullExpressionValue(writeLock, "w");
        ReentrantReadWriteLock.WriteLock writeLock2 = writeLock;
        writeLock2.lock();
        try {
            List<RuleConfig> $this$forEach$iv = list;
            for (Object element$iv : $this$forEach$iv) {
                RuleConfig it = (RuleConfig) element$iv;
                String host = it.getDomains().get(0);
                rules.put(host, new Rule(it.getSample(), it.getDomains(), null, 4, null));
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            writeLock2.unlock();
        }
    }
}