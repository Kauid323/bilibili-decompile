package kntr.app.deepsearch.history.di;

import dagger.BindsInstance;
import dagger.Subcomponent;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.deepsearch.history.DSHistoryViewModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DSHistoryComponent.kt */
@DSHistoryScope
@Subcomponent(modules = {DSHistoryServiceModule.class})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lkntr/app/deepsearch/history/di/DSHistoryComponent;", RoomRecommendViewModel.EMPTY_CURSOR, "viewModel", "Lkntr/app/deepsearch/history/DSHistoryViewModel;", "Builder", "history_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DSHistoryComponent {

    /* compiled from: DSHistoryComponent.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/app/deepsearch/history/di/DSHistoryComponent$Builder;", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.BUILD, "Lkntr/app/deepsearch/history/di/DSHistoryComponent;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "history_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Subcomponent.Factory
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface Builder {
        DSHistoryComponent build(@BindsInstance @DSHistoryCoroutineScope CoroutineScope coroutineScope, @BindsInstance String str);
    }

    DSHistoryViewModel viewModel();
}