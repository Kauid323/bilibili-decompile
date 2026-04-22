package kntr.base.dd.impl;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecision;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: DDProvider.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0007\u001a\u00020\u0004H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/base/dd/impl/IAppDDEnvProvider;", "", "appEnv", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/base/dd/IDeviceDecision$Version$Env;", "getAppEnv", "()Lkotlinx/coroutines/flow/Flow;", "currentAppEnv", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IAppDDEnvProvider {
    IDeviceDecision.Version.Env currentAppEnv();

    Flow<IDeviceDecision.Version.Env> getAppEnv();
}