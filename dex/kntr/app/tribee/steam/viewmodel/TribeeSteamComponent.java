package kntr.app.tribee.steam.viewmodel;

import dagger.BindsInstance;
import dagger.Subcomponent;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TribeeSteamComponent.kt */
@TribeeSteamScope
@Subcomponent(modules = {TribeeSteamViewModelModule.class})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lkntr/app/tribee/steam/viewmodel/TribeeSteamComponent;", "", "viewModel", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamViewModel;", "Builder", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface TribeeSteamComponent {

    /* compiled from: TribeeSteamComponent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001JV\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\n2\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\nH&¨\u0006\u000eÀ\u0006\u0003"}, d2 = {"Lkntr/app/tribee/steam/viewmodel/TribeeSteamComponent$Builder;", "", "build", "Lkntr/app/tribee/steam/viewmodel/TribeeSteamComponent;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "shareScope", "hostId", "", "selectedGameId", "", "fromSpmid", "tribeeId", "signature", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Subcomponent.Factory
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Builder {
        TribeeSteamComponent build(@BindsInstance @TribeeSteamCoroutineScope CoroutineScope coroutineScope, @BindsInstance @TribeeSteamShareCoroutineScope CoroutineScope coroutineScope2, @BindsInstance long j, @BindsInstance @SelectedGameId String str, @BindsInstance @FromSpmid String str2, @BindsInstance @TribeeId String str3, @BindsInstance @Signature String str4);
    }

    TribeeSteamViewModel viewModel();
}