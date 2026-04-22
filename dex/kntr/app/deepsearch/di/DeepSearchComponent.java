package kntr.app.deepsearch.di;

import dagger.BindsInstance;
import dagger.Subcomponent;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.deepsearch.DeepSearchViewModel;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DeepSearchComponent.kt */
@DeepSearchScope
@Subcomponent(modules = {DeepSearchServiceModule.class})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lkntr/app/deepsearch/di/DeepSearchComponent;", RoomRecommendViewModel.EMPTY_CURSOR, "viewModel", "Lkntr/app/deepsearch/DeepSearchViewModel;", "Builder", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface DeepSearchComponent {

    /* compiled from: DeepSearchComponent.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\u0007H&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/app/deepsearch/di/DeepSearchComponent$Builder;", RoomRecommendViewModel.EMPTY_CURSOR, ReportBuildInParam.BUILD, "Lkntr/app/deepsearch/di/DeepSearchComponent;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sessionId", RoomRecommendViewModel.EMPTY_CURSOR, "sessionQuery", "sessionTitle", "biz_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Subcomponent.Factory
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface Builder {
        DeepSearchComponent build(@BindsInstance @DeepSearchCoroutineScope CoroutineScope coroutineScope, @BindsInstance @SessionId String str, @BindsInstance @SessionQuery String str2, @BindsInstance @SessionTitle String str3);
    }

    DeepSearchViewModel viewModel();
}