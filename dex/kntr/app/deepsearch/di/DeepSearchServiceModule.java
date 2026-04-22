package kntr.app.deepsearch.di;

import dagger.Binds;
import dagger.Module;
import kntr.app.deepsearch.base.model.biz.DeepSearchBroadcastService;
import kntr.app.deepsearch.base.model.biz.DeepSearchDataProcessService;
import kntr.app.deepsearch.base.model.biz.DeepSearchTimeoutService;
import kntr.app.deepsearch.base.model.biz.DeepSearchTransformListService;
import kntr.app.deepsearch.service.DeepSearchBroadcastServiceImp;
import kntr.app.deepsearch.service.DeepSearchDataProcessServiceImp;
import kntr.app.deepsearch.service.DeepSearchTimeoutServiceImp;
import kntr.app.deepsearch.service.DeepSearchTransformListServiceImp;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;

/* compiled from: DeepSearchComponent.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\bH'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u000eH'¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lkntr/app/deepsearch/di/DeepSearchServiceModule;", RoomRecommendViewModel.EMPTY_CURSOR, "transformListService", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTransformListService;", "imp", "Lkntr/app/deepsearch/service/DeepSearchTransformListServiceImp;", "cacheListService", "Lkntr/app/deepsearch/base/model/biz/DeepSearchDataProcessService;", "Lkntr/app/deepsearch/service/DeepSearchDataProcessServiceImp;", "deepSearchBroadcast", "Lkntr/app/deepsearch/base/model/biz/DeepSearchBroadcastService;", "Lkntr/app/deepsearch/service/DeepSearchBroadcastServiceImp;", "deepSearchTimeout", "Lkntr/app/deepsearch/base/model/biz/DeepSearchTimeoutService;", "Lkntr/app/deepsearch/service/DeepSearchTimeoutServiceImp;", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Module(includes = {}, subcomponents = {})
public interface DeepSearchServiceModule {
    @Binds
    DeepSearchDataProcessService cacheListService(DeepSearchDataProcessServiceImp deepSearchDataProcessServiceImp);

    @Binds
    DeepSearchBroadcastService deepSearchBroadcast(DeepSearchBroadcastServiceImp deepSearchBroadcastServiceImp);

    @Binds
    DeepSearchTimeoutService deepSearchTimeout(DeepSearchTimeoutServiceImp deepSearchTimeoutServiceImp);

    @Binds
    DeepSearchTransformListService transformListService(DeepSearchTransformListServiceImp deepSearchTransformListServiceImp);
}