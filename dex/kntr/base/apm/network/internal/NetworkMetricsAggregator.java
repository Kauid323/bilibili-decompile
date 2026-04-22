package kntr.base.apm.network.internal;

import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.apm.network.INetworkMetricsAggregator;
import kntr.base.apm.network.internal.NetworkMetricsCollector;
import kntr.base.apm.network.internal.NetworkMetricsReportModel;
import kntr.base.appinfo.IPackageInfo;
import kntr.base.neuron.IPlatformNeuron;
import kntr.base.neuron.KNeuron;
import kntr.common.upper.trace.config.CommonProjectType;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicBoolean;
import kotlinx.atomicfu.AtomicFU;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;

/* compiled from: NetworkMetricsAggregator.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\u000e\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00060\u0011j\u0002`\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lkntr/base/apm/network/internal/NetworkMetricsAggregator;", "Lkntr/base/apm/network/INetworkMetricsAggregator;", "<init>", "()V", "localConfig", "Lkntr/base/apm/network/internal/LocalConfig;", "getLocalConfig", "()Lkntr/base/apm/network/internal/LocalConfig;", "started", "Lkotlinx/atomicfu/AtomicBoolean;", "timer", "Lkntr/base/apm/network/internal/RepeatingTimer;", "lifecycle", "Lkntr/base/apm/network/internal/AppLifecycle;", "collector", "Lkntr/base/apm/network/internal/NetworkMetricsCollector;", "updateLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/atomicfu/locks/ReentrantLock;", "model", "Lkntr/base/apm/network/internal/NetworkMetricsReportModel;", "groupModel", "Lkntr/base/apm/network/internal/NetworkMetricsReportModel$Group;", "enableSDK", "", "isFirstLaunch", "initializeSDK", "", "packageInfo", "Lkntr/base/appinfo/IPackageInfo;", "start", "terminate", "startCollect", "neuron", "Lkntr/base/neuron/IPlatformNeuron;", "process", "m", "Lkntr/base/apm/network/internal/NetworkMetricsCollector$Model;", "report", "cnt", "", "network_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class NetworkMetricsAggregator implements INetworkMetricsAggregator {
    private static boolean enableSDK;
    private static boolean isFirstLaunch;
    public static final NetworkMetricsAggregator INSTANCE = new NetworkMetricsAggregator();
    private static final LocalConfig localConfig = new LocalConfig();
    private static final AtomicBoolean started = AtomicFU.atomic(false);
    private static final RepeatingTimer timer = new RepeatingTimer();
    private static final AppLifecycle lifecycle = Utils_androidKt.getAppLifecycle();
    private static final NetworkMetricsCollector collector = new NetworkMetricsCollector();
    private static final ReentrantLock updateLock = new ReentrantLock();
    private static NetworkMetricsReportModel model = new NetworkMetricsReportModel(0, 0, 0, 0, false, 31, null);
    private static final NetworkMetricsReportModel.Group groupModel = new NetworkMetricsReportModel.Group();

    private NetworkMetricsAggregator() {
    }

    public final LocalConfig getLocalConfig() {
        return localConfig;
    }

    public final void initializeSDK(IPackageInfo packageInfo) {
        Intrinsics.checkNotNullParameter(packageInfo, "packageInfo");
        isFirstLaunch = packageInfo.isFirstLaunch();
        enableSDK = localConfig.getEnableSDK() || (isFirstLaunch && localConfig.getEnableFirstLaunchProperty());
        Map configs = MapsKt.mapOf(new Pair[]{TuplesKt.to("process", Utils_androidKt.getCurrentProcessName()), TuplesKt.to("isFirstLaunch", Boolean.valueOf(isFirstLaunch)), TuplesKt.to("enableSDK", Boolean.valueOf(localConfig.getEnableSDK())), TuplesKt.to("enableFirstLaunchProperty", Boolean.valueOf(localConfig.getEnableFirstLaunchProperty()))});
        UtilsKt.logI("main", "init configs = " + configs);
    }

    @Override // kntr.base.apm.network.INetworkMetricsAggregator
    public void start() {
        Flow state;
        if (started.getAndSet(true)) {
            UtilsKt.logE$default("main", "sdk already started.", null, 4, null);
        } else if (!enableSDK) {
            UtilsKt.logI("main", "sdk cannot start on<" + Utils_androidKt.getCurrentProcessName() + ">.");
        } else {
            AppLifecycle appLifecycle = lifecycle;
            if (appLifecycle != null && (state = appLifecycle.getState()) != null) {
                BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), (CoroutineContext) null, (CoroutineStart) null, new NetworkMetricsAggregator$start$1$1(state, null), 3, (Object) null);
            }
            timer.start(localConfig.getRepeatInterval() * 1000, localConfig.getRepeatCount(), new Function1() { // from class: kntr.base.apm.network.internal.NetworkMetricsAggregator$$ExternalSyntheticLambda1
                public final Object invoke(Object obj) {
                    Unit start$lambda$1;
                    start$lambda$1 = NetworkMetricsAggregator.start$lambda$1(((Integer) obj).intValue());
                    return start$lambda$1;
                }
            }, new Function0() { // from class: kntr.base.apm.network.internal.NetworkMetricsAggregator$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit start$lambda$2;
                    start$lambda$2 = NetworkMetricsAggregator.start$lambda$2();
                    return start$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit start$lambda$2() {
        INSTANCE.terminate();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit start$lambda$1(int it) {
        INSTANCE.report(it);
        return Unit.INSTANCE;
    }

    @Override // kntr.base.apm.network.INetworkMetricsAggregator
    public void terminate() {
        if (enableSDK) {
            UtilsKt.logI("main", "terminate on process<" + Utils_androidKt.getCurrentProcessName() + ">.");
            timer.m1348stopd1pmJ48();
            collector.m1347stopd1pmJ48();
            AppLifecycle appLifecycle = lifecycle;
            if (appLifecycle != null) {
                appLifecycle.close();
            }
        }
    }

    public final void startCollect(IPlatformNeuron neuron) {
        Intrinsics.checkNotNullParameter(neuron, "neuron");
        if (enableSDK) {
            UtilsKt.logI("main", "startCollect on process<" + Utils_androidKt.getCurrentProcessName() + ">.");
            collector.start(neuron, new Function1() { // from class: kntr.base.apm.network.internal.NetworkMetricsAggregator$$ExternalSyntheticLambda0
                public final Object invoke(Object obj) {
                    Unit startCollect$lambda$0;
                    startCollect$lambda$0 = NetworkMetricsAggregator.startCollect$lambda$0((NetworkMetricsCollector.Model) obj);
                    return startCollect$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit startCollect$lambda$0(NetworkMetricsCollector.Model it) {
        Intrinsics.checkNotNullParameter(it, "it");
        INSTANCE.process(it);
        return Unit.INSTANCE;
    }

    private final void process(NetworkMetricsCollector.Model m) {
        ReentrantLock $this$with$iv = updateLock;
        $this$with$iv.lock();
        try {
            NetworkMetricsReportModel networkMetricsReportModel = model;
            networkMetricsReportModel.setRequestCount(networkMetricsReportModel.getRequestCount() + 1);
            NetworkMetricsReportModel networkMetricsReportModel2 = model;
            networkMetricsReportModel2.setRequestSize(networkMetricsReportModel2.getRequestSize() + m.getRequestSize());
            NetworkMetricsReportModel networkMetricsReportModel3 = model;
            networkMetricsReportModel3.setReceiveSize(networkMetricsReportModel3.getReceiveSize() + m.getReceiveSize());
            groupModel.updateResource(new NetworkMetricsReportModel.ResourceItem(m.getGroupName(), 1L, m.getReceiveSize() + m.getRequestSize()));
            Unit unit = Unit.INSTANCE;
        } finally {
            $this$with$iv.unlock();
        }
    }

    private final void report(int cnt) {
        ReentrantLock $this$with$iv = updateLock;
        $this$with$iv.lock();
        try {
            if (enableSDK) {
                int currentTime = localConfig.getRepeatInterval() * cnt;
                if (localConfig.getReportTimes().contains(Integer.valueOf(currentTime))) {
                    model.setStartTime(currentTime);
                    model.setFirstLaunch(isFirstLaunch);
                    Map extraMap = model.asMap(groupModel);
                    UtilsKt.logI(CommonProjectType.REPORTER, "report " + extraMap);
                    KNeuron.INSTANCE.trackT(true, "infra.net_analysis", extraMap, new Function0() { // from class: kntr.base.apm.network.internal.NetworkMetricsAggregator$$ExternalSyntheticLambda3
                        public final Object invoke() {
                            boolean report$lambda$0$0;
                            report$lambda$0$0 = NetworkMetricsAggregator.report$lambda$0$0();
                            return Boolean.valueOf(report$lambda$0$0);
                        }
                    });
                }
                Unit unit = Unit.INSTANCE;
            }
        } finally {
            $this$with$iv.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean report$lambda$0$0() {
        return true;
    }
}