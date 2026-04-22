package kntr.app.tribee.steam.viewmodel;

import dagger.Module;
import dagger.Provides;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TribeeSteamViewModelModule.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lkntr/app/tribee/steam/viewmodel/TribeeSteamViewModelModule;", "", "<init>", "()V", "provideViewModel", "Lkntr/app/tribee/steam/viewmodel/ITribeeSteamViewModel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "stateMachine", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamStateMachine;", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Module(includes = {}, subcomponents = {})
public final class TribeeSteamViewModelModule {
    public static final int $stable = 0;
    public static final TribeeSteamViewModelModule INSTANCE = new TribeeSteamViewModelModule();

    private TribeeSteamViewModelModule() {
    }

    @Provides
    public final ITribeeSteamViewModel provideViewModel(@TribeeSteamCoroutineScope CoroutineScope scope, TribeeSteamStateMachine stateMachine) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(stateMachine, "stateMachine");
        return new TribeeSteamViewModel(scope, stateMachine);
    }
}