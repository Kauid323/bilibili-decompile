package kntr.app.tribee.operation.viewmodel;

import dagger.Module;
import dagger.Provides;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TribeeOperationModule.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\f"}, d2 = {"Lkntr/app/tribee/operation/viewmodel/TribeeOperationViewModelModule;", "", "<init>", "()V", "provideViewModel", "Lkntr/app/tribee/operation/viewmodel/ITribeeOperationViewModel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "stateMachine", "Lkntr/app/tribee/operation/viewmodel/TribeeOperationStateMachine;", "fromTribeeId", "", "operation_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module(includes = {}, subcomponents = {})
public final class TribeeOperationViewModelModule {
    public static final int $stable = 0;
    public static final TribeeOperationViewModelModule INSTANCE = new TribeeOperationViewModelModule();

    private TribeeOperationViewModelModule() {
    }

    @Provides
    public final ITribeeOperationViewModel provideViewModel(@TribeeOperationCoroutineScope CoroutineScope scope, TribeeOperationStateMachine stateMachine, @FromTribeeId long fromTribeeId) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(stateMachine, "stateMachine");
        return new TribeeOperationViewModel(scope, fromTribeeId, stateMachine);
    }
}