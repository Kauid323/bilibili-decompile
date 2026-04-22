package tv.danmaku.bili.bilow.lb;

import com.bilibili.lib.dd.DeviceDecision;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.FlowCollector;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.bilow.domain.MultiDomain;
import tv.danmaku.bili.bilow.domain.RuleConfig;
import tv.danmaku.bili.bilow.lb.internal.LbBucketsKt;
import tv.danmaku.bili.bilow.lb.internal.LbConfig;
import tv.danmaku.bili.bilow.lb.internal.LbRuleKt;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;

/* compiled from: Lbs.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\bJ*\u0010\u000e\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\bH\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/bilow/lb/Lbs;", "", "<init>", "()V", "enable", "", "deviceRule", "", "", "regex", "Ljava/util/regex/Pattern;", "maybeChangeHost", ReportEvent.Tag.HOST, "isLbHost", "isTargetHost", "parseRegex", "toMultiDomainRules", "Ltv/danmaku/bili/bilow/domain/RuleConfig;", "rule", "isEnabled", "billow-biz_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class Lbs {
    private static List<String> deviceRule;
    private static final Pattern regex;
    public static final Lbs INSTANCE = new Lbs();
    private static final boolean enable = INSTANCE.isEnabled();

    private Lbs() {
    }

    static {
        Lbs lbs = INSTANCE;
        String targetDomain = LbConfig.INSTANCE.getTargetDomain();
        if (targetDomain == null) {
            targetDomain = "";
        }
        regex = lbs.parseRegex(targetDomain);
        if (enable) {
            BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new AnonymousClass1(null), 2, (Object) null);
        }
    }

    /* compiled from: Lbs.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    @DebugMetadata(c = "tv.danmaku.bili.bilow.lb.Lbs$1", f = "Lbs.kt", i = {}, l = {BR.backgroundTranslucentEnable}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: tv.danmaku.bili.bilow.lb.Lbs$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (DeviceDecision.INSTANCE.getDDAsync(LbConfig.INSTANCE.getBalanceRulesDDKEY(), LbConfig.BALANCE_RULES).collect(new FlowCollector() { // from class: tv.danmaku.bili.bilow.lb.Lbs.1.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((String) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(String it, Continuation<? super Unit> continuation) {
                            Intrinsics.checkNotNull(it);
                            List rules = LbRuleKt.parseBalanceRules(it);
                            List newDevice = LbBucketsKt.getDeviceRule(rules);
                            Lbs lbs = Lbs.INSTANCE;
                            Lbs.deviceRule = newDevice;
                            List it2 = Lbs.deviceRule;
                            if (it2 != null) {
                                MultiDomain.INSTANCE.updateRules(Lbs.INSTANCE.toMultiDomainRules(it2));
                            }
                            BLog.i("net.Lbs", "update deviceRule " + Lbs.deviceRule);
                            return Unit.INSTANCE;
                        }
                    }, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public final String maybeChangeHost(String host) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        if (!enable) {
            return host;
        }
        try {
            List dr = deviceRule;
            if (isTargetHost(regex, deviceRule, host) && dr != null) {
                String str = (String) CollectionsKt.firstOrNull(dr);
                if (str != null) {
                    return str;
                }
            }
            return host;
        } catch (Exception e) {
            return host;
        }
    }

    public final boolean isLbHost(String host) {
        Intrinsics.checkNotNullParameter(host, ReportEvent.Tag.HOST);
        if (enable) {
            return isTargetHost(regex, deviceRule, host);
        }
        return false;
    }

    private final boolean isTargetHost(Pattern regex2, List<String> list, String host) {
        Matcher matcher;
        if (regex2 == null || (matcher = regex2.matcher(host)) == null) {
            List<String> list2 = list;
            if (list2 == null || list2.isEmpty()) {
                return false;
            }
            return list.contains(host);
        }
        return matcher.matches();
    }

    private final Pattern parseRegex(String regex2) {
        String str = regex2;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        try {
            return Pattern.compile(regex2);
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<RuleConfig> toMultiDomainRules(List<String> list) {
        return CollectionsKt.listOf(new RuleConfig(1.0f, list));
    }

    private final boolean isEnabled() {
        Boolean enable2 = LbConfig.INSTANCE.getEnable();
        if (enable2 != null) {
            return enable2.booleanValue();
        }
        return true;
    }
}