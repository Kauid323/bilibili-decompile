package kntr.app.tribee.operation.viewmodel;

import dagger.BindsInstance;
import dagger.Subcomponent;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TribeeOperationModule.kt */
@Subcomponent(modules = {TribeeOperationViewModelModule.class})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/TribeeOperationComponent;", "", "viewModel", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationViewModel;", "Builder", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@TribeeOperationScope
public interface TribeeOperationComponent {

    /* compiled from: TribeeOperationModule.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u0007H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/TribeeOperationComponent$Builder;", "", "build", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationComponent;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "inviteeMid", "", "fromTribeeId", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Subcomponent.Factory
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Builder {
        TribeeOperationComponent build(@BindsInstance @TribeeOperationCoroutineScope CoroutineScope coroutineScope, @BindsInstance @InviteeMid long j, @BindsInstance @FromTribeeId long j2);
    }

    TribeeOperationViewModel viewModel();
}