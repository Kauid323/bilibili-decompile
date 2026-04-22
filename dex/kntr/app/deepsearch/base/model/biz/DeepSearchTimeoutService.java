package kntr.app.deepsearch.base.model.biz;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* compiled from: DeepSearchService.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lkntr/app/deepsearch/base/model/biz/DeepSearchTimeoutService;", RoomRecommendViewModel.EMPTY_CURSOR, "greetTimeoutFlow", "Lkotlinx/coroutines/flow/Flow;", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTimeout;", "timeoutFlow", "greetLaunchTimeout", RoomRecommendViewModel.EMPTY_CURSOR, "greetCancelTimeout", "launchTimeout", "cancelTimeout", "configTimeoutInterval", "interval", RoomRecommendViewModel.EMPTY_CURSOR, "base_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DeepSearchTimeoutService {
    void cancelTimeout();

    void configTimeoutInterval(long j2);

    void greetCancelTimeout();

    void greetLaunchTimeout();

    Flow<DeepSearchTimeout> greetTimeoutFlow();

    void launchTimeout();

    Flow<DeepSearchTimeout> timeoutFlow();
}