package kntr.app.digital.backpack.aggregate;

import dagger.BindsInstance;
import dagger.Subcomponent;
import kntr.app.digital.backpack.BackpackUIService;
import kntr.app.digital.backpack.api.BackpackAssetBagModel;
import kntr.app.digital.backpack.di.BusinessCoroutineScope;
import kntr.app.digital.backpack.di.BusinessScope;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BackpackBusinessComponent.kt */
@Subcomponent(modules = {BackpackModelBackedModule.class})
@BusinessScope
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/app/digital/backpack/aggregate/BackpackBusinessComponent;", RoomRecommendViewModel.EMPTY_CURSOR, "pageService", "Lkntr/app/digital/backpack/BackpackUIService;", "getPageService", "()Lkntr/app/digital/backpack/BackpackUIService;", "Factory", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface BackpackBusinessComponent {

    /* compiled from: BackpackBusinessComponent.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/app/digital/backpack/aggregate/BackpackBusinessComponent$Factory;", RoomRecommendViewModel.EMPTY_CURSOR, "create", "Lkntr/app/digital/backpack/aggregate/BackpackBusinessComponent;", "assetBagModel", "Lkntr/app/digital/backpack/api/BackpackAssetBagModel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "backpack_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Subcomponent.Factory
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface Factory {
        BackpackBusinessComponent create(@BindsInstance BackpackAssetBagModel backpackAssetBagModel, @BindsInstance @BusinessCoroutineScope CoroutineScope coroutineScope);
    }

    BackpackUIService getPageService();
}