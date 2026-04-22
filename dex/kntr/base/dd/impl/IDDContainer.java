package kntr.base.dd.impl;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecision;
import kntr.base.dd.IDeviceDecisionProperty;
import kntr.base.dd.IDeviceDecisionUpdater;
import kntr.base.dd.IDeviceDecisionUtils;
import kntr.base.dd.internal.IDeviceDecisionDebugger;
import kotlin.Metadata;

/* compiled from: DDProvider.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/base/dd/impl/IDDContainer;", "Lkntr/base/dd/IDeviceDecision;", "Lkntr/base/dd/IDeviceDecisionUpdater;", "Lkntr/base/dd/IDeviceDecisionUtils;", "getProperty", "Lkntr/base/dd/IDeviceDecisionProperty;", "getDebugger", "Lkntr/base/dd/internal/IDeviceDecisionDebugger;", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IDDContainer extends IDeviceDecision, IDeviceDecisionUpdater, IDeviceDecisionUtils {
    IDeviceDecisionDebugger getDebugger();

    IDeviceDecisionProperty getProperty();
}