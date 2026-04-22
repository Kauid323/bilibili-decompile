package kntr.base.apm.network.internal;

import com.bilibili.lib.gripper.api.PreTrigger;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.apm.network.INetworkMetricsAggregator;
import kntr.base.appinfo.IPackageInfo;
import kntr.base.config.IPlatformConfig;
import kntr.base.net.comm.redirect.RedirectImpKt;
import kntr.base.neuron.IPlatformNeuron;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;

/* compiled from: Triggers.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001\u001a\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u0001\u001a\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0001¨\u0006\f"}, d2 = {"provideNetworkMetricsAggregator", "Lkntr/base/apm/network/INetworkMetricsAggregator;", "packageInfo", "Lkntr/base/appinfo/IPackageInfo;", "initNetworkMetricsAggregator", "", "metricsAggregator", "startNetworkMetricsAggregator", RedirectImpKt.REDIRECT_KV_CONFIG, "Lkntr/base/config/IPlatformConfig;", "neuron", "Lkntr/base/neuron/IPlatformNeuron;", "network_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TriggersKt {
    public static final INetworkMetricsAggregator provideNetworkMetricsAggregator(IPackageInfo packageInfo) {
        Intrinsics.checkNotNullParameter(packageInfo, "packageInfo");
        NetworkMetricsAggregator.INSTANCE.initializeSDK(packageInfo);
        return NetworkMetricsAggregator.INSTANCE;
    }

    @PreTrigger(awaitComplete = true, trigger = "OnCreate")
    public static final void initNetworkMetricsAggregator(INetworkMetricsAggregator metricsAggregator) {
        Intrinsics.checkNotNullParameter(metricsAggregator, "metricsAggregator");
        metricsAggregator.start();
    }

    @PreTrigger(awaitComplete = true, trigger = "OnPrivacyAllowed")
    public static final void startNetworkMetricsAggregator(IPlatformConfig config, IPlatformNeuron neuron) {
        Intrinsics.checkNotNullParameter(config, RedirectImpKt.REDIRECT_KV_CONFIG);
        Intrinsics.checkNotNullParameter(neuron, "neuron");
        NetworkMetricsAggregator.INSTANCE.startCollect(neuron);
        BuildersKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new TriggersKt$startNetworkMetricsAggregator$1(config, null), 3, (Object) null);
    }
}