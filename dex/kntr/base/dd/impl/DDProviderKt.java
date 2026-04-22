package kntr.base.dd.impl;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecision;
import kntr.base.dd.IDeviceDecisionProperty;
import kntr.base.dd.IDeviceDecisionUpdater;
import kntr.base.dd.IDeviceDecisionUtils;
import kntr.base.dd.impl.internal.common.DDConst;
import kntr.base.dd.impl.internal.container.DDContainer;
import kntr.base.dd.internal.IDeviceDecisionDebugger;
import kntr.base.dd.internal.IDeviceDecisionDefault;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DDProvider.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0007\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0001H\u0007\u001a\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0001H\u0007\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0001H\u0007\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\u0001H\u0007¨\u0006\u0011"}, d2 = {"provideContainer", "Lkntr/base/dd/impl/IDDContainer;", "defaultArgs", "Lkntr/base/dd/impl/IDDConstArgs;", "defaultConfig", "Lkntr/base/dd/internal/IDeviceDecisionDefault;", "provideDD", "Lkntr/base/dd/IDeviceDecision;", "container", "provideDDUpdater", "Lkntr/base/dd/IDeviceDecisionUpdater;", "provideDDProperty", "Lkntr/base/dd/IDeviceDecisionProperty;", "provideDDUtils", "Lkntr/base/dd/IDeviceDecisionUtils;", "provideDDDebugger", "Lkntr/base/dd/internal/IDeviceDecisionDebugger;", "impl_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DDProviderKt {
    public static final IDDContainer provideContainer(IDDConstArgs defaultArgs, IDeviceDecisionDefault defaultConfig) {
        Intrinsics.checkNotNullParameter(defaultArgs, "defaultArgs");
        Intrinsics.checkNotNullParameter(defaultConfig, "defaultConfig");
        DDConst dDConst = DDConst.INSTANCE;
        String processName = defaultArgs.getProcessName();
        if (processName == null) {
            processName = "";
        }
        dDConst.setProcessName(processName);
        DDContainer it = new DDContainer(defaultArgs, defaultConfig);
        it.start();
        return it;
    }

    public static final IDeviceDecision provideDD(IDDContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return container;
    }

    public static final IDeviceDecisionUpdater provideDDUpdater(IDDContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return container;
    }

    public static final IDeviceDecisionProperty provideDDProperty(IDDContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return container.getProperty();
    }

    public static final IDeviceDecisionUtils provideDDUtils(IDDContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return container;
    }

    public static final IDeviceDecisionDebugger provideDDDebugger(IDDContainer container) {
        Intrinsics.checkNotNullParameter(container, "container");
        return container.getDebugger();
    }
}