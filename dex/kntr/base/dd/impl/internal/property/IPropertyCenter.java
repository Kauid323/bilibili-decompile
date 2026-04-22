package kntr.base.dd.impl.internal.property;

import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.dd.IDeviceDecisionProperty;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: IPropertyCenter.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bH&J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lkntr/base/dd/impl/internal/property/IPropertyCenter;", "Lkntr/base/dd/IDeviceDecisionProperty;", "cacheableProps", "Lkotlinx/coroutines/flow/Flow;", "", "getCacheableProps", "()Lkotlinx/coroutines/flow/Flow;", "getAllPropNames", "", "isCacheableProp", "", "name", "impl_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface IPropertyCenter extends IDeviceDecisionProperty {
    List<String> getAllPropNames();

    Flow<String> getCacheableProps();

    boolean isCacheableProp(String str);
}