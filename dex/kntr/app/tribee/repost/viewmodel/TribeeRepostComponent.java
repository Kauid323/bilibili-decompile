package kntr.app.tribee.repost.viewmodel;

import dagger.BindsInstance;
import dagger.Subcomponent;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TribeeRepostComponent.kt */
@Subcomponent(modules = {TribeeRepostViewModelModule.class})
@TribeeRepostScope
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0004J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lkntr/app/tribee/repost/viewmodel/TribeeRepostComponent;", "", "viewModel", "Lkntr/app/tribee/repost/viewmodel/TribeeRepostViewModel;", "Builder", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface TribeeRepostComponent {

    /* compiled from: TribeeRepostComponent.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\tH&¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lkntr/app/tribee/repost/viewmodel/TribeeRepostComponent$Builder;", "", "build", "Lkntr/app/tribee/repost/viewmodel/TribeeRepostComponent;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "originDynamicId", "", "fromSpmid", "", "repost_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @Subcomponent.Factory
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public interface Builder {
        TribeeRepostComponent build(@BindsInstance @TribeeRepostCoroutineScope CoroutineScope coroutineScope, @BindsInstance long j, @BindsInstance String str);
    }

    TribeeRepostViewModel viewModel();
}