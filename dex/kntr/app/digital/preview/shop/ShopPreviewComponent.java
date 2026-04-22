package kntr.app.digital.preview.shop;

import dagger.BindsInstance;
import dagger.Subcomponent;
import kntr.app.digital.preview.BusinessCoroutineScope;
import kntr.app.digital.preview.BusinessScope;
import kntr.app.digital.preview.ViewBlockchainInfoActionModule;
import kntr.app.digital.preview.action.HandleActionModule;
import kntr.app.digital.preview.api.CardPreviewModel;
import kntr.app.digital.preview.closing.ClosingActionModule;
import kntr.app.digital.preview.gift.GiftActionModule;
import kntr.app.digital.preview.report.BusinessReportParamsProvider;
import kntr.app.digital.preview.reshaping.ReshapingActionModule;
import kntr.app.digital.preview.router.RouterActionModule;
import kntr.app.digital.preview.share.ShareActionModule;
import kntr.app.digital.preview.smelting.SmeltingTutorialActionModule;
import kntr.app.digital.preview.splashsetting.SplashSettingActionModule;
import kntr.app.digital.preview.toast.ToastActionModule;
import kntr.app.digital.preview.usage.AppWidgetActionModule;
import kntr.app.digital.preview.usage.ChangeAvatarActionModule;
import kntr.app.digital.preview.usage.ChangeHeaderActionModule;
import kntr.app.digital.preview.usage.UsageActionModule;
import kntr.app.digital.preview.viewmore.ViewMoreActionModule;
import kntr.app.digital.preview.wallpaper.WallpaperActionModule;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ShopPreviewComponent.kt */
@BusinessScope
@Subcomponent(modules = {HandleActionModule.class, ClosingActionModule.class, ShopPreviewPageDataModule.class, ShareActionModule.class, ViewMoreActionModule.class, GiftActionModule.class, ViewBlockchainInfoActionModule.class, UsageActionModule.class, RouterActionModule.class, ChangeAvatarActionModule.class, ChangeHeaderActionModule.class, SplashSettingActionModule.class, AppWidgetActionModule.class, ToastActionModule.class, SmeltingTutorialActionModule.class, ReshapingActionModule.class, WallpaperActionModule.class, BusinessReportParamsProvider.class})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\ba\u0018\u00002\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lkntr/app/digital/preview/shop/ShopPreviewComponent;", RoomRecommendViewModel.EMPTY_CURSOR, "pageService", "Lkntr/app/digital/preview/shop/ShopPreviewUIService;", "getPageService", "()Lkntr/app/digital/preview/shop/ShopPreviewUIService;", "Factory", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface ShopPreviewComponent {

    /* compiled from: ShopPreviewComponent.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lkntr/app/digital/preview/shop/ShopPreviewComponent$Factory;", RoomRecommendViewModel.EMPTY_CURSOR, "create", "Lkntr/app/digital/preview/shop/ShopPreviewComponent;", "dlcDetailModel", "Lkntr/app/digital/preview/api/CardPreviewModel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    @Subcomponent.Factory
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public interface Factory {
        ShopPreviewComponent create(@BindsInstance CardPreviewModel cardPreviewModel, @BindsInstance @BusinessCoroutineScope CoroutineScope coroutineScope);
    }

    ShopPreviewUIService getPageService();
}