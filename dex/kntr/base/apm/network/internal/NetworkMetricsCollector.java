package kntr.base.apm.network.internal;

import ComposableSingletons$CustomBottomSheetKt$;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.neuron.IPlatformNeuron;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.atomicfu.AtomicRef;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* compiled from: NetworkMetricsCollector.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u000eJ\u0013\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001a\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkntr/base/apm/network/internal/NetworkMetricsCollector;", "", "<init>", "()V", "jobRef", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "start", "", "neuron", "Lkntr/base/neuron/IPlatformNeuron;", "handler", "Lkotlin/Function1;", "Lkntr/base/apm/network/internal/NetworkMetricsCollector$Model;", "stop", "Lkotlin/Result;", "stop-d1pmJ48", "()Ljava/lang/Object;", "onEvent", "event", "Lkntr/base/neuron/IPlatformNeuron$Event;", "resolveGroupName", "", "url", "default", "Model", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class NetworkMetricsCollector {
    private final AtomicRef<Job> jobRef = AtomicFU.atomic((Object) null);
    private final CoroutineScope scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());

    /* compiled from: NetworkMetricsCollector.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lkntr/base/apm/network/internal/NetworkMetricsCollector$Model;", "", "requestSize", "", "receiveSize", "groupName", "", "<init>", "(JJLjava/lang/String;)V", "getRequestSize", "()J", "getReceiveSize", "getGroupName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Model {
        private final String groupName;
        private final long receiveSize;
        private final long requestSize;

        public Model() {
            this(0L, 0L, null, 7, null);
        }

        public static /* synthetic */ Model copy$default(Model model, long j, long j2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                j = model.requestSize;
            }
            long j3 = j;
            if ((i & 2) != 0) {
                j2 = model.receiveSize;
            }
            long j4 = j2;
            if ((i & 4) != 0) {
                str = model.groupName;
            }
            return model.copy(j3, j4, str);
        }

        public final long component1() {
            return this.requestSize;
        }

        public final long component2() {
            return this.receiveSize;
        }

        public final String component3() {
            return this.groupName;
        }

        public final Model copy(long j, long j2, String str) {
            Intrinsics.checkNotNullParameter(str, "groupName");
            return new Model(j, j2, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Model) {
                Model model = (Model) obj;
                return this.requestSize == model.requestSize && this.receiveSize == model.receiveSize && Intrinsics.areEqual(this.groupName, model.groupName);
            }
            return false;
        }

        public int hashCode() {
            return (((ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.requestSize) * 31) + ComposableSingletons$CustomBottomSheetKt$.ExternalSyntheticBackport0.m(this.receiveSize)) * 31) + this.groupName.hashCode();
        }

        public String toString() {
            long j = this.requestSize;
            long j2 = this.receiveSize;
            return "Model(requestSize=" + j + ", receiveSize=" + j2 + ", groupName=" + this.groupName + ")";
        }

        public Model(long requestSize, long receiveSize, String groupName) {
            Intrinsics.checkNotNullParameter(groupName, "groupName");
            this.requestSize = requestSize;
            this.receiveSize = receiveSize;
            this.groupName = groupName;
        }

        public /* synthetic */ Model(long j, long j2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? 0L : j, (i & 2) == 0 ? j2 : 0L, (i & 4) != 0 ? "" : str);
        }

        public final long getRequestSize() {
            return this.requestSize;
        }

        public final long getReceiveSize() {
            return this.receiveSize;
        }

        public final String getGroupName() {
            return this.groupName;
        }
    }

    public final void start(IPlatformNeuron neuron, Function1<? super Model, Unit> function1) {
        Intrinsics.checkNotNullParameter(neuron, "neuron");
        Intrinsics.checkNotNullParameter(function1, "handler");
        if (this.jobRef.getValue() != null) {
            return;
        }
        this.jobRef.setValue(BuildersKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new NetworkMetricsCollector$start$1(neuron, this, function1, null), 3, (Object) null));
    }

    /* renamed from: stop-d1pmJ48  reason: not valid java name */
    public final Object m1347stopd1pmJ48() {
        Object m2636constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            NetworkMetricsCollector $this$stop_d1pmJ48_u24lambda_u240 = this;
            Job job = (Job) $this$stop_d1pmJ48_u24lambda_u240.jobRef.getAndSet((Object) null);
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            CoroutineScopeKt.cancel$default($this$stop_d1pmJ48_u24lambda_u240.scope, (CancellationException) null, 1, (Object) null);
            m2636constructorimpl = Result.m2636constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        Throwable it = Result.m2639exceptionOrNullimpl(m2636constructorimpl);
        if (it != null && !(it instanceof CancellationException)) {
            UtilsKt.logE("collector", "stop", it);
        }
        return m2636constructorimpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Model onEvent(IPlatformNeuron.Event event) {
        Long longOrNull;
        Long longOrNull2;
        if (Intrinsics.areEqual(event.getEventId(), "infra.net") || Intrinsics.areEqual(event.getEventId(), "infra.webimage")) {
            String defaultGroup = Intrinsics.areEqual(event.getEventId(), "infra.webimage") ? "image" : "other";
            String resolveGroupName = resolveGroupName(event.getExtends().get("command"), defaultGroup);
            String str = event.getExtends().get("req_size");
            long longValue = (str == null || (longOrNull2 = StringsKt.toLongOrNull(str)) == null) ? 0L : longOrNull2.longValue();
            String str2 = event.getExtends().get("recv_size");
            return new Model(longValue, (str2 == null || (longOrNull = StringsKt.toLongOrNull(str2)) == null) ? 0L : longOrNull.longValue(), resolveGroupName);
        }
        return null;
    }

    private final String resolveGroupName(String url, String str) {
        String str2 = url;
        boolean z = false;
        if (str2 == null || StringsKt.isBlank(str2)) {
            return str;
        }
        String lastSegment = StringsKt.substringAfterLast$default(url, '/', (String) null, 2, (Object) null);
        String ext = StringsKt.substringAfterLast(lastSegment, '.', "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(ext, "toLowerCase(...)");
        if (!StringsKt.isBlank(ext) && ext.length() <= 16) {
            z = true;
        }
        String str3 = z ? ext : null;
        return str3 == null ? str : str3;
    }
}