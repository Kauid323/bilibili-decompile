package kntr.app.tribee.consume.viewmodel;

import dagger.BindsInstance;
import dagger.Subcomponent;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TribeeHomeComponent.kt */
@Subcomponent(modules = {TribeeHomeViewModelModule.class})
@TribeeHomeScope
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeComponent;", "", "viewModel", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeViewModel;", "Builder", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface TribeeHomeComponent {

    /* compiled from: TribeeHomeComponent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\tH&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lkntr/app/tribee/consume/viewmodel/TribeeHomeComponent$Builder;", "", "build", "Lkntr/app/tribee/consume/viewmodel/TribeeHomeComponent;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "homeId", "", "inviteCodeFromRouter", "", "categoryIdFromRouter", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Subcomponent.Factory
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Builder {
        TribeeHomeComponent build(@BindsInstance @TribeeHomeCoroutineScope CoroutineScope coroutineScope, @BindsInstance long j, @BindsInstance @InviteCodeParam String str, @BindsInstance @CategoryIdParam String str2);
    }

    TribeeHomeViewModel viewModel();
}