package kntr.base.dd.impl.internal.container;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecisionUpdater;
import kntr.base.dd.impl.IDDConstArgs;
import kntr.base.dd.impl.internal.decide.IDDResult;
import kntr.base.dd.internal.IDeviceDecisionDefault;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DDContainer.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0003H\u0002\u001a\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0000\u001a\u0017\u0010\n\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\f0\u000bH\u0000¢\u0006\u0002\u0010\r\u001a\u0014\u0010\u000e\u001a\u00020\t*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0013*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\" \u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013*\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016*\f\b\u0000\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u0017"}, d2 = {"UpdateResult", "Lkntr/base/dd/IDeviceDecisionUpdater$Result;", "toBoolean", "", "Lkntr/base/dd/impl/internal/decide/IDDResult;", "defaultValue", "createUpdateError", "Lkntr/base/dd/IDeviceDecisionUpdater$Result$Error;", "msg", "", "asUpdaterResult", "Lkotlin/Result;", "", "(Ljava/lang/Object;)Lkntr/base/dd/IDeviceDecisionUpdater$Result;", "getHost", "Lkntr/base/dd/impl/IDDConstArgs;", "defaultConfig", "Lkntr/base/dd/internal/IDeviceDecisionDefault;", "getObservableNames", "", "observablePropName", "getObservablePropName", "(Lkntr/base/dd/internal/IDeviceDecisionDefault;)Ljava/util/List;", "impl_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class DDContainerKt {
    public static final boolean toBoolean(IDDResult $this$toBoolean, boolean defaultValue) {
        Boolean hit = $this$toBoolean.getHit();
        if (Intrinsics.areEqual(hit, true)) {
            String it = $this$toBoolean.getValue();
            return it == null || Intrinsics.areEqual(it, "__true__") || Intrinsics.areEqual(it, "true");
        } else if (Intrinsics.areEqual(hit, false)) {
            return false;
        } else {
            if (hit == null) {
                return defaultValue;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final IDeviceDecisionUpdater.Result.Error createUpdateError(String msg) {
        return new IDeviceDecisionUpdater.Result.Error(msg == null ? "" : msg);
    }

    public static final IDeviceDecisionUpdater.Result asUpdaterResult(Object $this$asUpdaterResult) {
        Throwable it = Result.m2639exceptionOrNullimpl($this$asUpdaterResult);
        if (it == null) {
            Unit unit = (Unit) $this$asUpdaterResult;
            return IDeviceDecisionUpdater.Result.Success.INSTANCE;
        }
        return createUpdateError(it.getMessage());
    }

    public static final String getHost(IDDConstArgs $this$getHost, IDeviceDecisionDefault defaultConfig) {
        String str = defaultConfig.get(IDeviceDecisionDefault.Key.DDFawkesHost);
        if (str == null) {
            str = $this$getHost.getHost();
        }
        if (str != null) {
            String it = str;
            if (StringsKt.isBlank(it)) {
                str = null;
            }
            if (str != null) {
                return str;
            }
        }
        return "https://i0.hdslb.com/bfs/fawkes/dd";
    }

    public static final List<String> getObservableNames(IDDConstArgs $this$getObservableNames, IDeviceDecisionDefault defaultConfig) {
        List<String> observablePropName = getObservablePropName(defaultConfig);
        return observablePropName == null ? $this$getObservableNames.getObservableNames() : observablePropName;
    }

    private static final List<String> getObservablePropName(IDeviceDecisionDefault $this$observablePropName) {
        List it;
        String str = $this$observablePropName.get(IDeviceDecisionDefault.Key.ObservablePropName);
        if (str == null || (it = StringsKt.split$default(str, new String[]{","}, false, 0, 6, (Object) null)) == null || it.isEmpty()) {
            return null;
        }
        return it;
    }
}