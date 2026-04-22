package kntr.app.digital.preview.aggregate;

import androidx.lifecycle.Lifecycle;
import com.bapis.bilibili.app.dynamic.v2.AdditionVote2;
import dagger.Lazy;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import kntr.app.ad.domain.report.internal.ReportBuildInParam;
import kntr.app.digital.preview.CardPreviewPageModel;
import kntr.app.digital.preview.DialogService;
import kntr.app.digital.preview.RouterParams;
import kntr.app.digital.preview.SimpleCard;
import kntr.app.digital.preview.ViewBlockchainInfoActionModule_ProvideFactory;
import kntr.app.digital.preview.action.ActionModule;
import kntr.app.digital.preview.action.HandleAction;
import kntr.app.digital.preview.action.HandleActionModule_ProvideHandleActionFactory;
import kntr.app.digital.preview.aggregate.CardPreviewComponent;
import kntr.app.digital.preview.api.CardPreviewModel;
import kntr.app.digital.preview.api.GetCardList;
import kntr.app.digital.preview.button.DigitalButtonsService;
import kntr.app.digital.preview.card.DigitalCardDetailInfoUIService;
import kntr.app.digital.preview.card.DigitalCardListUIService;
import kntr.app.digital.preview.card.DigitalCardStateService;
import kntr.app.digital.preview.card.video.DigitalVideoCardVolumeService;
import kntr.app.digital.preview.card.video.DigitalVideoPlayService;
import kntr.app.digital.preview.card.video.DownloadCaptions;
import kntr.app.digital.preview.card.video.VideoUIService;
import kntr.app.digital.preview.card.web.DigitalWebCardService;
import kntr.app.digital.preview.card.web.FeatureDescDialogService;
import kntr.app.digital.preview.card.web.FeaturePanelService;
import kntr.app.digital.preview.card.web.GetWebCardDescInfo;
import kntr.app.digital.preview.card.web.WebCardUIService;
import kntr.app.digital.preview.cardlistmapper.CardItem;
import kntr.app.digital.preview.closing.ClosingActionModule_ProvideFactory;
import kntr.app.digital.preview.closing.DismissRequest;
import kntr.app.digital.preview.gift.DigitalGiftErrorDialogService;
import kntr.app.digital.preview.gift.GiftActionModule_ProvideFactory;
import kntr.app.digital.preview.gift.RequestGiftInfo;
import kntr.app.digital.preview.lock.LockStateService;
import kntr.app.digital.preview.lock.LockUIService;
import kntr.app.digital.preview.lock.ToggleLockCard;
import kntr.app.digital.preview.lock.UnlockCardDialogService;
import kntr.app.digital.preview.report.BusinessReportParamsProvider_ProvideCurrentCardItemFactory;
import kntr.app.digital.preview.report.BusinessReportParamsProvider_ProvideFactory;
import kntr.app.digital.preview.report.FillCommonReportParams;
import kntr.app.digital.preview.report.PageReportParamsProvider_ProvideFactory;
import kntr.app.digital.preview.report.ReportService;
import kntr.app.digital.preview.reshaping.ReshapingActionModule_ProvideFactory;
import kntr.app.digital.preview.router.RouterActionModule_ProvideFactory;
import kntr.app.digital.preview.share.ShareActionModule_ProvideFactory;
import kntr.app.digital.preview.share.ShareDialogService;
import kntr.app.digital.preview.shop.ShopPreviewComponent;
import kntr.app.digital.preview.shop.ShopPreviewPageDataModule;
import kntr.app.digital.preview.shop.ShopPreviewPageDataModule_ProvideDigitalCardListFactory;
import kntr.app.digital.preview.shop.ShopPreviewPageDataModule_ProvideInitialBackAnchorIdFactory;
import kntr.app.digital.preview.shop.ShopPreviewPageDataModule_ProvideInitialFrontAnchorIdFactory;
import kntr.app.digital.preview.shop.ShopPreviewPageDataModule_ProvideInitialRequestExtraParamsFactory;
import kntr.app.digital.preview.shop.ShopPreviewUIService;
import kntr.app.digital.preview.smelting.SmeltingTutorialActionModule_ProvideFactory;
import kntr.app.digital.preview.splashsetting.DLCSplashSettingNoticeDialogService;
import kntr.app.digital.preview.splashsetting.SplashSettingActionModule_ProvideFactory;
import kntr.app.digital.preview.splashsetting.SplashSettingInfo;
import kntr.app.digital.preview.toast.ToastActionModule_ProvideFactory;
import kntr.app.digital.preview.topmenu.DigitalTopBarUIService;
import kntr.app.digital.preview.usage.AppWidgetActionModule_ProvideFactory;
import kntr.app.digital.preview.usage.ChangeAvatarActionModule_ProvideFactory;
import kntr.app.digital.preview.usage.ChangeHeaderActionModule_ProvideFactory;
import kntr.app.digital.preview.usage.DigitalUsageMenuDialogService;
import kntr.app.digital.preview.usage.DigitalUsageRestrictionDialogService;
import kntr.app.digital.preview.usage.Usage;
import kntr.app.digital.preview.usage.UsageActionModule_ProvideFactory;
import kntr.app.digital.preview.viewmore.DigitalViewMoreService;
import kntr.app.digital.preview.viewmore.ViewMoreActionModule_ProvideFactory;
import kntr.app.digital.preview.wallpaper.SetHomeWallpaper;
import kntr.app.digital.preview.wallpaper.SetLockscreenWallpaper;
import kntr.app.digital.preview.wallpaper.WallpaperActionModule_ProvideFactory;
import kntr.app.digital.preview.wallpaper.WallpaperDownloadingDialogService;
import kntr.app.digital.preview.wallpaper.WallpaperSettingsDialogService;
import kntr.app.digital.preview.wallpaper.WallpaperUnavailableDialogService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.router.Router;
import kntr.common.komponent.KomponentScope;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DaggerCardPreviewComponent.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0001\u0018\u0000 \b2\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\t"}, d2 = {"Lkntr/app/digital/preview/aggregate/DaggerCardPreviewComponent;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "Factory", "ShopPreviewComponentFactory", "ShopPreviewComponentImpl", "CardPreviewComponentImpl", "Companion", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DaggerCardPreviewComponent {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);

    private DaggerCardPreviewComponent() {
    }

    /* compiled from: DaggerCardPreviewComponent.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¨\u0006\u0011"}, d2 = {"Lkntr/app/digital/preview/aggregate/DaggerCardPreviewComponent$Factory;", "Lkntr/app/digital/preview/aggregate/CardPreviewComponent$Factory;", "<init>", "()V", "create", "Lkntr/app/digital/preview/aggregate/CardPreviewComponent;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "params", "Lkntr/app/digital/preview/RouterParams;", "toaster", "Lkntr/common/trio/toast/Toaster;", "router", "Lkntr/base/router/Router;", "komponentScope", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    private static final class Factory implements CardPreviewComponent.Factory {
        @Override // kntr.app.digital.preview.aggregate.CardPreviewComponent.Factory
        public CardPreviewComponent create(Lifecycle lifecycle, RouterParams params, Toaster toaster, Router router, KomponentScope<? super Unit> komponentScope) {
            Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(toaster, "toaster");
            Intrinsics.checkNotNullParameter(router, "router");
            Intrinsics.checkNotNullParameter(komponentScope, "komponentScope");
            return new CardPreviewComponentImpl(lifecycle, params, toaster, router, komponentScope);
        }
    }

    /* compiled from: DaggerCardPreviewComponent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkntr/app/digital/preview/aggregate/DaggerCardPreviewComponent$ShopPreviewComponentFactory;", "Lkntr/app/digital/preview/shop/ShopPreviewComponent$Factory;", "cardPreviewComponentImpl", "Lkntr/app/digital/preview/aggregate/DaggerCardPreviewComponent$CardPreviewComponentImpl;", "<init>", "(Lkntr/app/digital/preview/aggregate/DaggerCardPreviewComponent$CardPreviewComponentImpl;)V", "create", "Lkntr/app/digital/preview/shop/ShopPreviewComponent;", "dlcDetailModel", "Lkntr/app/digital/preview/api/CardPreviewModel;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    private static final class ShopPreviewComponentFactory implements ShopPreviewComponent.Factory {
        private final CardPreviewComponentImpl cardPreviewComponentImpl;

        public ShopPreviewComponentFactory(CardPreviewComponentImpl cardPreviewComponentImpl) {
            Intrinsics.checkNotNullParameter(cardPreviewComponentImpl, "cardPreviewComponentImpl");
            this.cardPreviewComponentImpl = cardPreviewComponentImpl;
        }

        @Override // kntr.app.digital.preview.shop.ShopPreviewComponent.Factory
        public ShopPreviewComponent create(CardPreviewModel dlcDetailModel, CoroutineScope scope) {
            Intrinsics.checkNotNullParameter(dlcDetailModel, "dlcDetailModel");
            Intrinsics.checkNotNullParameter(scope, "scope");
            return new ShopPreviewComponentImpl(this.cardPreviewComponentImpl, dlcDetailModel, scope);
        }
    }

    /* compiled from: DaggerCardPreviewComponent.kt */
    @Metadata(d1 = {"\u0000È\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0002¹\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\f\u0010\u009c\u0001\u001a\u0007\u0012\u0002\b\u00030\u009d\u0001J\f\u0010\u009e\u0001\u001a\u0007\u0012\u0002\b\u00030\u009d\u0001J\f\u0010\u009f\u0001\u001a\u0007\u0012\u0002\b\u00030\u009d\u0001J\f\u0010 \u0001\u001a\u0007\u0012\u0002\b\u00030\u009d\u0001J\f\u0010¡\u0001\u001a\u0007\u0012\u0002\b\u00030\u009d\u0001J\f\u0010¢\u0001\u001a\u0007\u0012\u0002\b\u00030\u009d\u0001J\f\u0010£\u0001\u001a\u0007\u0012\u0002\b\u00030\u009d\u0001J\f\u0010¤\u0001\u001a\u0007\u0012\u0002\b\u00030\u009d\u0001J\b\u0010¥\u0001\u001a\u00030¦\u0001J\u000f\u0010§\u0001\u001a\n\u0012\u0005\u0012\u00030¦\u00010¨\u0001J\b\u0010©\u0001\u001a\u00030ª\u0001J\f\u0010«\u0001\u001a\u0007\u0012\u0002\b\u00030\u009d\u0001J\f\u0010¬\u0001\u001a\u0007\u0012\u0002\b\u00030\u009d\u0001J\f\u0010\u00ad\u0001\u001a\u0007\u0012\u0002\b\u00030\u009d\u0001J\f\u0010®\u0001\u001a\u0007\u0012\u0002\b\u00030\u009d\u0001J\f\u0010¯\u0001\u001a\u0007\u0012\u0002\b\u00030\u009d\u0001J\f\u0010°\u0001\u001a\u0007\u0012\u0002\b\u00030\u009d\u0001J\b\u0010±\u0001\u001a\u00030²\u0001J\b\u0010³\u0001\u001a\u00030´\u0001J\f\u0010µ\u0001\u001a\u0007\u0012\u0002\b\u00030\u009d\u0001J\u0013\u0010¶\u0001\u001a\u000e\u0012\t\u0012\u0007\u0012\u0002\b\u00030\u009d\u00010¨\u0001J\u001a\u0010·\u0001\u001a\u00030¸\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0011\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u00130\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018R \u0010!\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u0018R \u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R \u0010(\u001a\b\u0012\u0004\u0012\u00020%0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R \u0010+\u001a\b\u0012\u0004\u0012\u00020%0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0016\"\u0004\b-\u0010\u0018R \u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0016\"\u0004\b1\u0010\u0018R \u00102\u001a\b\u0012\u0004\u0012\u0002030\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0016\"\u0004\b5\u0010\u0018R \u00106\u001a\b\u0012\u0004\u0012\u0002070\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0016\"\u0004\b9\u0010\u0018R \u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0016\"\u0004\b=\u0010\u0018R \u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0016\"\u0004\bA\u0010\u0018R \u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0016\"\u0004\bE\u0010\u0018R \u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0016\"\u0004\bI\u0010\u0018R \u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u0016\"\u0004\bM\u0010\u0018R \u0010N\u001a\b\u0012\u0004\u0012\u00020O0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0016\"\u0004\bQ\u0010\u0018R \u0010R\u001a\b\u0012\u0004\u0012\u00020S0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0016\"\u0004\bU\u0010\u0018R \u0010V\u001a\b\u0012\u0004\u0012\u00020W0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0016\"\u0004\bY\u0010\u0018R \u0010Z\u001a\b\u0012\u0004\u0012\u00020[0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0016\"\u0004\b]\u0010\u0018R \u0010^\u001a\b\u0012\u0004\u0012\u00020_0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0016\"\u0004\ba\u0010\u0018R \u0010b\u001a\b\u0012\u0004\u0012\u00020c0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u0016\"\u0004\be\u0010\u0018R$\u0010f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010\u0016\"\u0004\bh\u0010\u0018R \u0010i\u001a\b\u0012\u0004\u0012\u00020j0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u0016\"\u0004\bl\u0010\u0018R \u0010m\u001a\b\u0012\u0004\u0012\u00020n0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u0016\"\u0004\bp\u0010\u0018R \u0010q\u001a\b\u0012\u0004\u0012\u00020r0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u0016\"\u0004\bt\u0010\u0018R \u0010u\u001a\b\u0012\u0004\u0012\u00020v0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010\u0016\"\u0004\bx\u0010\u0018R \u0010y\u001a\b\u0012\u0004\u0012\u00020z0\u0012X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\u0016\"\u0004\b|\u0010\u0018R!\u0010}\u001a\b\u0012\u0004\u0012\u00020~0\u0012X\u0086.¢\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010\u0016\"\u0005\b\u0080\u0001\u0010\u0018R$\u0010\u0081\u0001\u001a\t\u0012\u0005\u0012\u00030\u0082\u00010\u0012X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u0016\"\u0005\b\u0084\u0001\u0010\u0018R$\u0010\u0085\u0001\u001a\t\u0012\u0005\u0012\u00030\u0086\u00010\u0012X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010\u0016\"\u0005\b\u0088\u0001\u0010\u0018R$\u0010\u0089\u0001\u001a\t\u0012\u0005\u0012\u00030\u008a\u00010\u0012X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010\u0016\"\u0005\b\u008c\u0001\u0010\u0018R$\u0010\u008d\u0001\u001a\t\u0012\u0005\u0012\u00030\u008e\u00010\u0012X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010\u0016\"\u0005\b\u0090\u0001\u0010\u0018R$\u0010\u0091\u0001\u001a\t\u0012\u0005\u0012\u00030\u0092\u00010\u0012X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010\u0016\"\u0005\b\u0094\u0001\u0010\u0018R$\u0010\u0095\u0001\u001a\t\u0012\u0005\u0012\u00030\u0096\u00010\u0012X\u0086.¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010\u0016\"\u0005\b\u0098\u0001\u0010\u0018R\u0018\u0010\u0099\u0001\u001a\u00030\u0096\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001¨\u0006º\u0001"}, d2 = {"Lkntr/app/digital/preview/aggregate/DaggerCardPreviewComponent$ShopPreviewComponentImpl;", "Lkntr/app/digital/preview/shop/ShopPreviewComponent;", "cardPreviewComponentImpl", "Lkntr/app/digital/preview/aggregate/DaggerCardPreviewComponent$CardPreviewComponentImpl;", "dlcDetailModelParam", "Lkntr/app/digital/preview/api/CardPreviewModel;", "scopeParam", "Lkotlinx/coroutines/CoroutineScope;", "<init>", "(Lkntr/app/digital/preview/aggregate/DaggerCardPreviewComponent$CardPreviewComponentImpl;Lkntr/app/digital/preview/api/CardPreviewModel;Lkotlinx/coroutines/CoroutineScope;)V", "scope", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "dlcDetailModel", "getDlcDetailModel", "()Lkntr/app/digital/preview/api/CardPreviewModel;", "shopPreviewComponentImpl", "provideDigitalCardListProvider", "Ljavax/inject/Provider;", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/digital/preview/cardlistmapper/CardItem;", "getProvideDigitalCardListProvider", "()Ljavax/inject/Provider;", "setProvideDigitalCardListProvider", "(Ljavax/inject/Provider;)V", "provideInitialPageProvider", RoomRecommendViewModel.EMPTY_CURSOR, "getProvideInitialPageProvider", "setProvideInitialPageProvider", "provideInitialFrontHasMoreProvider", RoomRecommendViewModel.EMPTY_CURSOR, "getProvideInitialFrontHasMoreProvider", "setProvideInitialFrontHasMoreProvider", "provideInitialBackHasMoreProvider", "getProvideInitialBackHasMoreProvider", "setProvideInitialBackHasMoreProvider", "provideInitialRequestExtraParamsProvider", RoomRecommendViewModel.EMPTY_CURSOR, "getProvideInitialRequestExtraParamsProvider", "setProvideInitialRequestExtraParamsProvider", "provideInitialFrontAnchorIdProvider", "getProvideInitialFrontAnchorIdProvider", "setProvideInitialFrontAnchorIdProvider", "provideInitialBackAnchorIdProvider", "getProvideInitialBackAnchorIdProvider", "setProvideInitialBackAnchorIdProvider", "lockStateServiceProvider", "Lkntr/app/digital/preview/lock/LockStateService;", "getLockStateServiceProvider", "setLockStateServiceProvider", "digitalCardStateServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardStateService;", "getDigitalCardStateServiceProvider", "setDigitalCardStateServiceProvider", "digitalVideoCardVolumeServiceProvider", "Lkntr/app/digital/preview/card/video/DigitalVideoCardVolumeService;", "getDigitalVideoCardVolumeServiceProvider", "setDigitalVideoCardVolumeServiceProvider", "digitalVideoPlayServiceProvider", "Lkntr/app/digital/preview/card/video/DigitalVideoPlayService;", "getDigitalVideoPlayServiceProvider", "setDigitalVideoPlayServiceProvider", "videoUIServiceProvider", "Lkntr/app/digital/preview/card/video/VideoUIService;", "getVideoUIServiceProvider", "setVideoUIServiceProvider", "digitalWebCardServiceProvider", "Lkntr/app/digital/preview/card/web/DigitalWebCardService;", "getDigitalWebCardServiceProvider", "setDigitalWebCardServiceProvider", "webCardUIServiceProvider", "Lkntr/app/digital/preview/card/web/WebCardUIService;", "getWebCardUIServiceProvider", "setWebCardUIServiceProvider", "digitalCardListUIServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardListUIService;", "getDigitalCardListUIServiceProvider", "setDigitalCardListUIServiceProvider", "shareDialogServiceProvider", "Lkntr/app/digital/preview/share/ShareDialogService;", "getShareDialogServiceProvider", "setShareDialogServiceProvider", "digitalViewMoreServiceProvider", "Lkntr/app/digital/preview/viewmore/DigitalViewMoreService;", "getDigitalViewMoreServiceProvider", "setDigitalViewMoreServiceProvider", "digitalGiftErrorDialogServiceProvider", "Lkntr/app/digital/preview/gift/DigitalGiftErrorDialogService;", "getDigitalGiftErrorDialogServiceProvider", "setDigitalGiftErrorDialogServiceProvider", "provideHandleActionProvider", "Lkntr/app/digital/preview/action/HandleAction;", "getProvideHandleActionProvider", "setProvideHandleActionProvider", "digitalUsageMenuDialogServiceProvider", "Lkntr/app/digital/preview/usage/DigitalUsageMenuDialogService;", "getDigitalUsageMenuDialogServiceProvider", "setDigitalUsageMenuDialogServiceProvider", "digitalUsageRestrictionDialogServiceProvider", "Lkntr/app/digital/preview/usage/DigitalUsageRestrictionDialogService;", "getDigitalUsageRestrictionDialogServiceProvider", "setDigitalUsageRestrictionDialogServiceProvider", "provideCurrentCardItemProvider", "getProvideCurrentCardItemProvider", "setProvideCurrentCardItemProvider", "dLCSplashSettingNoticeDialogServiceProvider", "Lkntr/app/digital/preview/splashsetting/DLCSplashSettingNoticeDialogService;", "getDLCSplashSettingNoticeDialogServiceProvider", "setDLCSplashSettingNoticeDialogServiceProvider", "wallpaperDownloadingDialogServiceProvider", "Lkntr/app/digital/preview/wallpaper/WallpaperDownloadingDialogService;", "getWallpaperDownloadingDialogServiceProvider", "setWallpaperDownloadingDialogServiceProvider", "wallpaperUnavailableDialogServiceProvider", "Lkntr/app/digital/preview/wallpaper/WallpaperUnavailableDialogService;", "getWallpaperUnavailableDialogServiceProvider", "setWallpaperUnavailableDialogServiceProvider", "wallpaperSettingsDialogServiceProvider", "Lkntr/app/digital/preview/wallpaper/WallpaperSettingsDialogService;", "getWallpaperSettingsDialogServiceProvider", "setWallpaperSettingsDialogServiceProvider", "digitalTopBarUIServiceProvider", "Lkntr/app/digital/preview/topmenu/DigitalTopBarUIService;", "getDigitalTopBarUIServiceProvider", "setDigitalTopBarUIServiceProvider", "unlockCardDialogServiceProvider", "Lkntr/app/digital/preview/lock/UnlockCardDialogService;", "getUnlockCardDialogServiceProvider", "setUnlockCardDialogServiceProvider", "lockUIServiceProvider", "Lkntr/app/digital/preview/lock/LockUIService;", "getLockUIServiceProvider", "setLockUIServiceProvider", "digitalCardDetailInfoUIServiceProvider", "Lkntr/app/digital/preview/card/DigitalCardDetailInfoUIService;", "getDigitalCardDetailInfoUIServiceProvider", "setDigitalCardDetailInfoUIServiceProvider", "digitalButtonsServiceProvider", "Lkntr/app/digital/preview/button/DigitalButtonsService;", "getDigitalButtonsServiceProvider", "setDigitalButtonsServiceProvider", "featureDescDialogServiceProvider", "Lkntr/app/digital/preview/card/web/FeatureDescDialogService;", "getFeatureDescDialogServiceProvider", "setFeatureDescDialogServiceProvider", "featurePanelServiceProvider", "Lkntr/app/digital/preview/card/web/FeaturePanelService;", "getFeaturePanelServiceProvider", "setFeaturePanelServiceProvider", "shopPreviewUIServiceProvider", "Lkntr/app/digital/preview/shop/ShopPreviewUIService;", "getShopPreviewUIServiceProvider", "setShopPreviewUIServiceProvider", "pageService", "getPageService", "()Lkntr/app/digital/preview/shop/ShopPreviewUIService;", "provide", "Lkntr/app/digital/preview/action/ActionModule;", "provide2", "provide3", "provide4", "provide5", "provide6", "provide7", "provide8", "provide10", "Lkntr/app/digital/preview/report/FillCommonReportParams;", "setOfFillCommonReportParams", RoomRecommendViewModel.EMPTY_CURSOR, "reportService", "Lkntr/app/digital/preview/report/ReportService;", "provide9", "provide11", "provide12", "provide13", "provide14", "provide15", "setHomeWallpaper", "Lkntr/app/digital/preview/wallpaper/SetHomeWallpaper;", "setLockscreenWallpaper", "Lkntr/app/digital/preview/wallpaper/SetLockscreenWallpaper;", "provide16", "setOfActionModuleOf", "initialize", RoomRecommendViewModel.EMPTY_CURSOR, "SwitchingProvider", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    private static final class ShopPreviewComponentImpl implements ShopPreviewComponent {
        private final CardPreviewComponentImpl cardPreviewComponentImpl;
        public Provider<DLCSplashSettingNoticeDialogService> dLCSplashSettingNoticeDialogServiceProvider;
        public Provider<DigitalButtonsService> digitalButtonsServiceProvider;
        public Provider<DigitalCardDetailInfoUIService> digitalCardDetailInfoUIServiceProvider;
        public Provider<DigitalCardListUIService> digitalCardListUIServiceProvider;
        public Provider<DigitalCardStateService> digitalCardStateServiceProvider;
        public Provider<DigitalGiftErrorDialogService> digitalGiftErrorDialogServiceProvider;
        public Provider<DigitalTopBarUIService> digitalTopBarUIServiceProvider;
        public Provider<DigitalUsageMenuDialogService> digitalUsageMenuDialogServiceProvider;
        public Provider<DigitalUsageRestrictionDialogService> digitalUsageRestrictionDialogServiceProvider;
        public Provider<DigitalVideoCardVolumeService> digitalVideoCardVolumeServiceProvider;
        public Provider<DigitalVideoPlayService> digitalVideoPlayServiceProvider;
        public Provider<DigitalViewMoreService> digitalViewMoreServiceProvider;
        public Provider<DigitalWebCardService> digitalWebCardServiceProvider;
        private final CardPreviewModel dlcDetailModel;
        public Provider<FeatureDescDialogService> featureDescDialogServiceProvider;
        public Provider<FeaturePanelService> featurePanelServiceProvider;
        public Provider<LockStateService> lockStateServiceProvider;
        public Provider<LockUIService> lockUIServiceProvider;
        public Provider<CardItem<?>> provideCurrentCardItemProvider;
        public Provider<List<CardItem<?>>> provideDigitalCardListProvider;
        public Provider<HandleAction> provideHandleActionProvider;
        public Provider<String> provideInitialBackAnchorIdProvider;
        public Provider<Boolean> provideInitialBackHasMoreProvider;
        public Provider<String> provideInitialFrontAnchorIdProvider;
        public Provider<Boolean> provideInitialFrontHasMoreProvider;
        public Provider<Integer> provideInitialPageProvider;
        public Provider<String> provideInitialRequestExtraParamsProvider;
        private final CoroutineScope scope;
        public Provider<ShareDialogService> shareDialogServiceProvider;
        private final ShopPreviewComponentImpl shopPreviewComponentImpl;
        public Provider<ShopPreviewUIService> shopPreviewUIServiceProvider;
        public Provider<UnlockCardDialogService> unlockCardDialogServiceProvider;
        public Provider<VideoUIService> videoUIServiceProvider;
        public Provider<WallpaperDownloadingDialogService> wallpaperDownloadingDialogServiceProvider;
        public Provider<WallpaperSettingsDialogService> wallpaperSettingsDialogServiceProvider;
        public Provider<WallpaperUnavailableDialogService> wallpaperUnavailableDialogServiceProvider;
        public Provider<WebCardUIService> webCardUIServiceProvider;

        public ShopPreviewComponentImpl(CardPreviewComponentImpl cardPreviewComponentImpl, CardPreviewModel dlcDetailModelParam, CoroutineScope scopeParam) {
            Intrinsics.checkNotNullParameter(cardPreviewComponentImpl, "cardPreviewComponentImpl");
            Intrinsics.checkNotNullParameter(dlcDetailModelParam, "dlcDetailModelParam");
            Intrinsics.checkNotNullParameter(scopeParam, "scopeParam");
            this.shopPreviewComponentImpl = this;
            this.cardPreviewComponentImpl = cardPreviewComponentImpl;
            this.scope = scopeParam;
            this.dlcDetailModel = dlcDetailModelParam;
            initialize(dlcDetailModelParam, scopeParam);
        }

        public final CoroutineScope getScope() {
            return this.scope;
        }

        public final CardPreviewModel getDlcDetailModel() {
            return this.dlcDetailModel;
        }

        public final Provider<List<CardItem<?>>> getProvideDigitalCardListProvider() {
            Provider<List<CardItem<?>>> provider = this.provideDigitalCardListProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("provideDigitalCardListProvider");
            return null;
        }

        public final void setProvideDigitalCardListProvider(Provider<List<CardItem<?>>> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.provideDigitalCardListProvider = provider;
        }

        public final Provider<Integer> getProvideInitialPageProvider() {
            Provider<Integer> provider = this.provideInitialPageProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("provideInitialPageProvider");
            return null;
        }

        public final void setProvideInitialPageProvider(Provider<Integer> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.provideInitialPageProvider = provider;
        }

        public final Provider<Boolean> getProvideInitialFrontHasMoreProvider() {
            Provider<Boolean> provider = this.provideInitialFrontHasMoreProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("provideInitialFrontHasMoreProvider");
            return null;
        }

        public final void setProvideInitialFrontHasMoreProvider(Provider<Boolean> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.provideInitialFrontHasMoreProvider = provider;
        }

        public final Provider<Boolean> getProvideInitialBackHasMoreProvider() {
            Provider<Boolean> provider = this.provideInitialBackHasMoreProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("provideInitialBackHasMoreProvider");
            return null;
        }

        public final void setProvideInitialBackHasMoreProvider(Provider<Boolean> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.provideInitialBackHasMoreProvider = provider;
        }

        public final Provider<String> getProvideInitialRequestExtraParamsProvider() {
            Provider<String> provider = this.provideInitialRequestExtraParamsProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("provideInitialRequestExtraParamsProvider");
            return null;
        }

        public final void setProvideInitialRequestExtraParamsProvider(Provider<String> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.provideInitialRequestExtraParamsProvider = provider;
        }

        public final Provider<String> getProvideInitialFrontAnchorIdProvider() {
            Provider<String> provider = this.provideInitialFrontAnchorIdProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("provideInitialFrontAnchorIdProvider");
            return null;
        }

        public final void setProvideInitialFrontAnchorIdProvider(Provider<String> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.provideInitialFrontAnchorIdProvider = provider;
        }

        public final Provider<String> getProvideInitialBackAnchorIdProvider() {
            Provider<String> provider = this.provideInitialBackAnchorIdProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("provideInitialBackAnchorIdProvider");
            return null;
        }

        public final void setProvideInitialBackAnchorIdProvider(Provider<String> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.provideInitialBackAnchorIdProvider = provider;
        }

        public final Provider<LockStateService> getLockStateServiceProvider() {
            Provider<LockStateService> provider = this.lockStateServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("lockStateServiceProvider");
            return null;
        }

        public final void setLockStateServiceProvider(Provider<LockStateService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.lockStateServiceProvider = provider;
        }

        public final Provider<DigitalCardStateService> getDigitalCardStateServiceProvider() {
            Provider<DigitalCardStateService> provider = this.digitalCardStateServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("digitalCardStateServiceProvider");
            return null;
        }

        public final void setDigitalCardStateServiceProvider(Provider<DigitalCardStateService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.digitalCardStateServiceProvider = provider;
        }

        public final Provider<DigitalVideoCardVolumeService> getDigitalVideoCardVolumeServiceProvider() {
            Provider<DigitalVideoCardVolumeService> provider = this.digitalVideoCardVolumeServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("digitalVideoCardVolumeServiceProvider");
            return null;
        }

        public final void setDigitalVideoCardVolumeServiceProvider(Provider<DigitalVideoCardVolumeService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.digitalVideoCardVolumeServiceProvider = provider;
        }

        public final Provider<DigitalVideoPlayService> getDigitalVideoPlayServiceProvider() {
            Provider<DigitalVideoPlayService> provider = this.digitalVideoPlayServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("digitalVideoPlayServiceProvider");
            return null;
        }

        public final void setDigitalVideoPlayServiceProvider(Provider<DigitalVideoPlayService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.digitalVideoPlayServiceProvider = provider;
        }

        public final Provider<VideoUIService> getVideoUIServiceProvider() {
            Provider<VideoUIService> provider = this.videoUIServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("videoUIServiceProvider");
            return null;
        }

        public final void setVideoUIServiceProvider(Provider<VideoUIService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.videoUIServiceProvider = provider;
        }

        public final Provider<DigitalWebCardService> getDigitalWebCardServiceProvider() {
            Provider<DigitalWebCardService> provider = this.digitalWebCardServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("digitalWebCardServiceProvider");
            return null;
        }

        public final void setDigitalWebCardServiceProvider(Provider<DigitalWebCardService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.digitalWebCardServiceProvider = provider;
        }

        public final Provider<WebCardUIService> getWebCardUIServiceProvider() {
            Provider<WebCardUIService> provider = this.webCardUIServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("webCardUIServiceProvider");
            return null;
        }

        public final void setWebCardUIServiceProvider(Provider<WebCardUIService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.webCardUIServiceProvider = provider;
        }

        public final Provider<DigitalCardListUIService> getDigitalCardListUIServiceProvider() {
            Provider<DigitalCardListUIService> provider = this.digitalCardListUIServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("digitalCardListUIServiceProvider");
            return null;
        }

        public final void setDigitalCardListUIServiceProvider(Provider<DigitalCardListUIService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.digitalCardListUIServiceProvider = provider;
        }

        public final Provider<ShareDialogService> getShareDialogServiceProvider() {
            Provider<ShareDialogService> provider = this.shareDialogServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("shareDialogServiceProvider");
            return null;
        }

        public final void setShareDialogServiceProvider(Provider<ShareDialogService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.shareDialogServiceProvider = provider;
        }

        public final Provider<DigitalViewMoreService> getDigitalViewMoreServiceProvider() {
            Provider<DigitalViewMoreService> provider = this.digitalViewMoreServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("digitalViewMoreServiceProvider");
            return null;
        }

        public final void setDigitalViewMoreServiceProvider(Provider<DigitalViewMoreService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.digitalViewMoreServiceProvider = provider;
        }

        public final Provider<DigitalGiftErrorDialogService> getDigitalGiftErrorDialogServiceProvider() {
            Provider<DigitalGiftErrorDialogService> provider = this.digitalGiftErrorDialogServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("digitalGiftErrorDialogServiceProvider");
            return null;
        }

        public final void setDigitalGiftErrorDialogServiceProvider(Provider<DigitalGiftErrorDialogService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.digitalGiftErrorDialogServiceProvider = provider;
        }

        public final Provider<HandleAction> getProvideHandleActionProvider() {
            Provider<HandleAction> provider = this.provideHandleActionProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("provideHandleActionProvider");
            return null;
        }

        public final void setProvideHandleActionProvider(Provider<HandleAction> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.provideHandleActionProvider = provider;
        }

        public final Provider<DigitalUsageMenuDialogService> getDigitalUsageMenuDialogServiceProvider() {
            Provider<DigitalUsageMenuDialogService> provider = this.digitalUsageMenuDialogServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("digitalUsageMenuDialogServiceProvider");
            return null;
        }

        public final void setDigitalUsageMenuDialogServiceProvider(Provider<DigitalUsageMenuDialogService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.digitalUsageMenuDialogServiceProvider = provider;
        }

        public final Provider<DigitalUsageRestrictionDialogService> getDigitalUsageRestrictionDialogServiceProvider() {
            Provider<DigitalUsageRestrictionDialogService> provider = this.digitalUsageRestrictionDialogServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("digitalUsageRestrictionDialogServiceProvider");
            return null;
        }

        public final void setDigitalUsageRestrictionDialogServiceProvider(Provider<DigitalUsageRestrictionDialogService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.digitalUsageRestrictionDialogServiceProvider = provider;
        }

        public final Provider<CardItem<?>> getProvideCurrentCardItemProvider() {
            Provider<CardItem<?>> provider = this.provideCurrentCardItemProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("provideCurrentCardItemProvider");
            return null;
        }

        public final void setProvideCurrentCardItemProvider(Provider<CardItem<?>> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.provideCurrentCardItemProvider = provider;
        }

        public final Provider<DLCSplashSettingNoticeDialogService> getDLCSplashSettingNoticeDialogServiceProvider() {
            Provider<DLCSplashSettingNoticeDialogService> provider = this.dLCSplashSettingNoticeDialogServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("dLCSplashSettingNoticeDialogServiceProvider");
            return null;
        }

        public final void setDLCSplashSettingNoticeDialogServiceProvider(Provider<DLCSplashSettingNoticeDialogService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.dLCSplashSettingNoticeDialogServiceProvider = provider;
        }

        public final Provider<WallpaperDownloadingDialogService> getWallpaperDownloadingDialogServiceProvider() {
            Provider<WallpaperDownloadingDialogService> provider = this.wallpaperDownloadingDialogServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("wallpaperDownloadingDialogServiceProvider");
            return null;
        }

        public final void setWallpaperDownloadingDialogServiceProvider(Provider<WallpaperDownloadingDialogService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.wallpaperDownloadingDialogServiceProvider = provider;
        }

        public final Provider<WallpaperUnavailableDialogService> getWallpaperUnavailableDialogServiceProvider() {
            Provider<WallpaperUnavailableDialogService> provider = this.wallpaperUnavailableDialogServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("wallpaperUnavailableDialogServiceProvider");
            return null;
        }

        public final void setWallpaperUnavailableDialogServiceProvider(Provider<WallpaperUnavailableDialogService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.wallpaperUnavailableDialogServiceProvider = provider;
        }

        public final Provider<WallpaperSettingsDialogService> getWallpaperSettingsDialogServiceProvider() {
            Provider<WallpaperSettingsDialogService> provider = this.wallpaperSettingsDialogServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("wallpaperSettingsDialogServiceProvider");
            return null;
        }

        public final void setWallpaperSettingsDialogServiceProvider(Provider<WallpaperSettingsDialogService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.wallpaperSettingsDialogServiceProvider = provider;
        }

        public final Provider<DigitalTopBarUIService> getDigitalTopBarUIServiceProvider() {
            Provider<DigitalTopBarUIService> provider = this.digitalTopBarUIServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("digitalTopBarUIServiceProvider");
            return null;
        }

        public final void setDigitalTopBarUIServiceProvider(Provider<DigitalTopBarUIService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.digitalTopBarUIServiceProvider = provider;
        }

        public final Provider<UnlockCardDialogService> getUnlockCardDialogServiceProvider() {
            Provider<UnlockCardDialogService> provider = this.unlockCardDialogServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("unlockCardDialogServiceProvider");
            return null;
        }

        public final void setUnlockCardDialogServiceProvider(Provider<UnlockCardDialogService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.unlockCardDialogServiceProvider = provider;
        }

        public final Provider<LockUIService> getLockUIServiceProvider() {
            Provider<LockUIService> provider = this.lockUIServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("lockUIServiceProvider");
            return null;
        }

        public final void setLockUIServiceProvider(Provider<LockUIService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.lockUIServiceProvider = provider;
        }

        public final Provider<DigitalCardDetailInfoUIService> getDigitalCardDetailInfoUIServiceProvider() {
            Provider<DigitalCardDetailInfoUIService> provider = this.digitalCardDetailInfoUIServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("digitalCardDetailInfoUIServiceProvider");
            return null;
        }

        public final void setDigitalCardDetailInfoUIServiceProvider(Provider<DigitalCardDetailInfoUIService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.digitalCardDetailInfoUIServiceProvider = provider;
        }

        public final Provider<DigitalButtonsService> getDigitalButtonsServiceProvider() {
            Provider<DigitalButtonsService> provider = this.digitalButtonsServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("digitalButtonsServiceProvider");
            return null;
        }

        public final void setDigitalButtonsServiceProvider(Provider<DigitalButtonsService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.digitalButtonsServiceProvider = provider;
        }

        public final Provider<FeatureDescDialogService> getFeatureDescDialogServiceProvider() {
            Provider<FeatureDescDialogService> provider = this.featureDescDialogServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("featureDescDialogServiceProvider");
            return null;
        }

        public final void setFeatureDescDialogServiceProvider(Provider<FeatureDescDialogService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.featureDescDialogServiceProvider = provider;
        }

        public final Provider<FeaturePanelService> getFeaturePanelServiceProvider() {
            Provider<FeaturePanelService> provider = this.featurePanelServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("featurePanelServiceProvider");
            return null;
        }

        public final void setFeaturePanelServiceProvider(Provider<FeaturePanelService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.featurePanelServiceProvider = provider;
        }

        public final Provider<ShopPreviewUIService> getShopPreviewUIServiceProvider() {
            Provider<ShopPreviewUIService> provider = this.shopPreviewUIServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("shopPreviewUIServiceProvider");
            return null;
        }

        public final void setShopPreviewUIServiceProvider(Provider<ShopPreviewUIService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.shopPreviewUIServiceProvider = provider;
        }

        @Override // kntr.app.digital.preview.shop.ShopPreviewComponent
        public ShopPreviewUIService getPageService() {
            ShopPreviewUIService shopPreviewUIService = getShopPreviewUIServiceProvider().get();
            Intrinsics.checkNotNullExpressionValue(shopPreviewUIService, "get(...)");
            return shopPreviewUIService;
        }

        public final ActionModule<?> provide() {
            return ClosingActionModule_ProvideFactory.Companion.provide(this.cardPreviewComponentImpl.dismissRequest());
        }

        public final ActionModule<?> provide2() {
            ShareActionModule_ProvideFactory.Companion companion = ShareActionModule_ProvideFactory.Companion;
            DigitalVideoPlayService digitalVideoPlayService = getDigitalVideoPlayServiceProvider().get();
            Intrinsics.checkNotNullExpressionValue(digitalVideoPlayService, "get(...)");
            ShareDialogService shareDialogService = getShareDialogServiceProvider().get();
            Intrinsics.checkNotNullExpressionValue(shareDialogService, "get(...)");
            return companion.provide(digitalVideoPlayService, shareDialogService, this.scope);
        }

        public final ActionModule<?> provide3() {
            ViewMoreActionModule_ProvideFactory.Companion companion = ViewMoreActionModule_ProvideFactory.Companion;
            DigitalViewMoreService digitalViewMoreService = getDigitalViewMoreServiceProvider().get();
            Intrinsics.checkNotNullExpressionValue(digitalViewMoreService, "get(...)");
            return companion.provide(digitalViewMoreService);
        }

        public final ActionModule<?> provide4() {
            GiftActionModule_ProvideFactory.Companion companion = GiftActionModule_ProvideFactory.Companion;
            Integer num = this.cardPreviewComponentImpl.getProvideActivityIdProvider().get();
            Intrinsics.checkNotNullExpressionValue(num, "get(...)");
            int intValue = num.intValue();
            RequestGiftInfo requestGiftInfo = this.cardPreviewComponentImpl.requestGiftInfo();
            CoroutineScope coroutineScope = this.scope;
            DigitalCardStateService digitalCardStateService = getDigitalCardStateServiceProvider().get();
            Intrinsics.checkNotNullExpressionValue(digitalCardStateService, "get(...)");
            Toaster toaster = this.cardPreviewComponentImpl.getToaster();
            Router router = this.cardPreviewComponentImpl.getRouter();
            DigitalGiftErrorDialogService digitalGiftErrorDialogService = getDigitalGiftErrorDialogServiceProvider().get();
            Intrinsics.checkNotNullExpressionValue(digitalGiftErrorDialogService, "get(...)");
            return companion.provide(intValue, requestGiftInfo, coroutineScope, digitalCardStateService, toaster, router, digitalGiftErrorDialogService);
        }

        public final ActionModule<?> provide5() {
            return ViewBlockchainInfoActionModule_ProvideFactory.Companion.provide(this.cardPreviewComponentImpl.getRouter());
        }

        public final ActionModule<?> provide6() {
            UsageActionModule_ProvideFactory.Companion companion = UsageActionModule_ProvideFactory.Companion;
            CoroutineScope coroutineScope = this.scope;
            DigitalUsageMenuDialogService digitalUsageMenuDialogService = getDigitalUsageMenuDialogServiceProvider().get();
            Intrinsics.checkNotNullExpressionValue(digitalUsageMenuDialogService, "get(...)");
            return companion.provide(coroutineScope, digitalUsageMenuDialogService, this.cardPreviewComponentImpl.getToaster());
        }

        public final ActionModule<?> provide7() {
            return RouterActionModule_ProvideFactory.Companion.provide(this.cardPreviewComponentImpl.getRouter());
        }

        public final ActionModule<?> provide8() {
            ChangeAvatarActionModule_ProvideFactory.Companion companion = ChangeAvatarActionModule_ProvideFactory.Companion;
            DigitalUsageRestrictionDialogService digitalUsageRestrictionDialogService = getDigitalUsageRestrictionDialogServiceProvider().get();
            Intrinsics.checkNotNullExpressionValue(digitalUsageRestrictionDialogService, "get(...)");
            CoroutineScope coroutineScope = this.scope;
            KomponentScope<Unit> komponentScope = this.cardPreviewComponentImpl.getKomponentScope();
            DigitalCardStateService digitalCardStateService = getDigitalCardStateServiceProvider().get();
            Intrinsics.checkNotNullExpressionValue(digitalCardStateService, "get(...)");
            return companion.provide(digitalUsageRestrictionDialogService, coroutineScope, komponentScope, digitalCardStateService);
        }

        public final FillCommonReportParams provide10() {
            return BusinessReportParamsProvider_ProvideFactory.Companion.provide(getProvideCurrentCardItemProvider());
        }

        public final Set<FillCommonReportParams> setOfFillCommonReportParams() {
            return SetsKt.setOf(new FillCommonReportParams[]{this.cardPreviewComponentImpl.provide(), provide10()});
        }

        public final ReportService reportService() {
            return new ReportService(setOfFillCommonReportParams());
        }

        public final ActionModule<?> provide9() {
            ChangeHeaderActionModule_ProvideFactory.Companion companion = ChangeHeaderActionModule_ProvideFactory.Companion;
            DigitalUsageRestrictionDialogService digitalUsageRestrictionDialogService = getDigitalUsageRestrictionDialogServiceProvider().get();
            Intrinsics.checkNotNullExpressionValue(digitalUsageRestrictionDialogService, "get(...)");
            return companion.provide(digitalUsageRestrictionDialogService, this.scope, reportService(), this.cardPreviewComponentImpl.getRouter(), this.cardPreviewComponentImpl.dismissRequest());
        }

        public final ActionModule<?> provide11() {
            SplashSettingActionModule_ProvideFactory.Companion companion = SplashSettingActionModule_ProvideFactory.Companion;
            ReportService reportService = reportService();
            CoroutineScope coroutineScope = this.scope;
            SplashSettingInfo splashSettingInfo = this.cardPreviewComponentImpl.splashSettingInfo();
            DLCSplashSettingNoticeDialogService dLCSplashSettingNoticeDialogService = getDLCSplashSettingNoticeDialogServiceProvider().get();
            Intrinsics.checkNotNullExpressionValue(dLCSplashSettingNoticeDialogService, "get(...)");
            return companion.provide(reportService, coroutineScope, splashSettingInfo, dLCSplashSettingNoticeDialogService, this.cardPreviewComponentImpl.getToaster(), this.cardPreviewComponentImpl.getRouter());
        }

        public final ActionModule<?> provide12() {
            return AppWidgetActionModule_ProvideFactory.Companion.provide(this.cardPreviewComponentImpl.getRouter());
        }

        public final ActionModule<?> provide13() {
            return ToastActionModule_ProvideFactory.Companion.provide(this.cardPreviewComponentImpl.getToaster());
        }

        public final ActionModule<?> provide14() {
            return SmeltingTutorialActionModule_ProvideFactory.Companion.provide(this.cardPreviewComponentImpl.getRouter());
        }

        public final ActionModule<?> provide15() {
            return ReshapingActionModule_ProvideFactory.Companion.provide(this.cardPreviewComponentImpl.dismissRequest(), this.cardPreviewComponentImpl.getKomponentScope());
        }

        public final SetHomeWallpaper setHomeWallpaper() {
            Toaster toaster = this.cardPreviewComponentImpl.getToaster();
            DismissRequest dismissRequest = this.cardPreviewComponentImpl.dismissRequest();
            WallpaperDownloadingDialogService wallpaperDownloadingDialogService = getWallpaperDownloadingDialogServiceProvider().get();
            Intrinsics.checkNotNullExpressionValue(wallpaperDownloadingDialogService, "get(...)");
            WallpaperDownloadingDialogService wallpaperDownloadingDialogService2 = wallpaperDownloadingDialogService;
            WallpaperUnavailableDialogService wallpaperUnavailableDialogService = getWallpaperUnavailableDialogServiceProvider().get();
            Intrinsics.checkNotNullExpressionValue(wallpaperUnavailableDialogService, "get(...)");
            return new SetHomeWallpaper(toaster, dismissRequest, wallpaperDownloadingDialogService2, wallpaperUnavailableDialogService, this.scope);
        }

        public final SetLockscreenWallpaper setLockscreenWallpaper() {
            Toaster toaster = this.cardPreviewComponentImpl.getToaster();
            DismissRequest dismissRequest = this.cardPreviewComponentImpl.dismissRequest();
            WallpaperDownloadingDialogService wallpaperDownloadingDialogService = getWallpaperDownloadingDialogServiceProvider().get();
            Intrinsics.checkNotNullExpressionValue(wallpaperDownloadingDialogService, "get(...)");
            WallpaperDownloadingDialogService wallpaperDownloadingDialogService2 = wallpaperDownloadingDialogService;
            WallpaperUnavailableDialogService wallpaperUnavailableDialogService = getWallpaperUnavailableDialogServiceProvider().get();
            Intrinsics.checkNotNullExpressionValue(wallpaperUnavailableDialogService, "get(...)");
            return new SetLockscreenWallpaper(toaster, dismissRequest, wallpaperDownloadingDialogService2, wallpaperUnavailableDialogService, this.scope);
        }

        public final ActionModule<?> provide16() {
            WallpaperActionModule_ProvideFactory.Companion companion = WallpaperActionModule_ProvideFactory.Companion;
            CoroutineScope coroutineScope = this.scope;
            WallpaperSettingsDialogService wallpaperSettingsDialogService = getWallpaperSettingsDialogServiceProvider().get();
            Intrinsics.checkNotNullExpressionValue(wallpaperSettingsDialogService, "get(...)");
            DigitalCardStateService digitalCardStateService = getDigitalCardStateServiceProvider().get();
            Intrinsics.checkNotNullExpressionValue(digitalCardStateService, "get(...)");
            return companion.provide(coroutineScope, wallpaperSettingsDialogService, digitalCardStateService, this.cardPreviewComponentImpl.getKomponentScope());
        }

        public final Set<ActionModule<?>> setOfActionModuleOf() {
            return SetsKt.setOf(new ActionModule[]{provide(), provide2(), provide3(), provide4(), provide5(), provide6(), provide7(), provide8(), provide9(), provide11(), provide12(), provide13(), provide14(), provide15(), provide16()});
        }

        private final void initialize(CardPreviewModel dlcDetailModelParam, CoroutineScope scopeParam) {
            Provider<List<CardItem<?>>> provider = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 3));
            Intrinsics.checkNotNullExpressionValue(provider, "provider(...)");
            setProvideDigitalCardListProvider(provider);
            Provider<Integer> provider2 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 4));
            Intrinsics.checkNotNullExpressionValue(provider2, "provider(...)");
            setProvideInitialPageProvider(provider2);
            Provider<Boolean> provider3 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 5));
            Intrinsics.checkNotNullExpressionValue(provider3, "provider(...)");
            setProvideInitialFrontHasMoreProvider(provider3);
            Provider<Boolean> provider4 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 6));
            Intrinsics.checkNotNullExpressionValue(provider4, "provider(...)");
            setProvideInitialBackHasMoreProvider(provider4);
            Provider<String> provider5 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 7));
            Intrinsics.checkNotNullExpressionValue(provider5, "provider(...)");
            setProvideInitialRequestExtraParamsProvider(provider5);
            Provider<String> provider6 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 8));
            Intrinsics.checkNotNullExpressionValue(provider6, "provider(...)");
            setProvideInitialFrontAnchorIdProvider(provider6);
            Provider<String> provider7 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 9));
            Intrinsics.checkNotNullExpressionValue(provider7, "provider(...)");
            setProvideInitialBackAnchorIdProvider(provider7);
            Provider<LockStateService> provider8 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 10));
            Intrinsics.checkNotNullExpressionValue(provider8, "provider(...)");
            setLockStateServiceProvider(provider8);
            Provider<DigitalCardStateService> provider9 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 2));
            Intrinsics.checkNotNullExpressionValue(provider9, "provider(...)");
            setDigitalCardStateServiceProvider(provider9);
            Provider<DigitalVideoCardVolumeService> provider10 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 13));
            Intrinsics.checkNotNullExpressionValue(provider10, "provider(...)");
            setDigitalVideoCardVolumeServiceProvider(provider10);
            Provider<DigitalVideoPlayService> provider11 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 12));
            Intrinsics.checkNotNullExpressionValue(provider11, "provider(...)");
            setDigitalVideoPlayServiceProvider(provider11);
            Provider<VideoUIService> provider12 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 11));
            Intrinsics.checkNotNullExpressionValue(provider12, "provider(...)");
            setVideoUIServiceProvider(provider12);
            Provider<DigitalWebCardService> provider13 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 15));
            Intrinsics.checkNotNullExpressionValue(provider13, "provider(...)");
            setDigitalWebCardServiceProvider(provider13);
            Provider<WebCardUIService> provider14 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 14));
            Intrinsics.checkNotNullExpressionValue(provider14, "provider(...)");
            setWebCardUIServiceProvider(provider14);
            Provider<DigitalCardListUIService> provider15 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 1));
            Intrinsics.checkNotNullExpressionValue(provider15, "provider(...)");
            setDigitalCardListUIServiceProvider(provider15);
            Provider<ShareDialogService> provider16 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 18));
            Intrinsics.checkNotNullExpressionValue(provider16, "provider(...)");
            setShareDialogServiceProvider(provider16);
            Provider<DigitalViewMoreService> provider17 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 19));
            Intrinsics.checkNotNullExpressionValue(provider17, "provider(...)");
            setDigitalViewMoreServiceProvider(provider17);
            Provider<DigitalGiftErrorDialogService> provider18 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 20));
            Intrinsics.checkNotNullExpressionValue(provider18, "provider(...)");
            setDigitalGiftErrorDialogServiceProvider(provider18);
            setProvideHandleActionProvider((Provider) new DelegateFactory());
            Provider<DigitalUsageMenuDialogService> provider19 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 21));
            Intrinsics.checkNotNullExpressionValue(provider19, "provider(...)");
            setDigitalUsageMenuDialogServiceProvider(provider19);
            Provider<DigitalUsageRestrictionDialogService> provider20 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 22));
            Intrinsics.checkNotNullExpressionValue(provider20, "provider(...)");
            setDigitalUsageRestrictionDialogServiceProvider(provider20);
            setProvideCurrentCardItemProvider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 23));
            Provider<DLCSplashSettingNoticeDialogService> provider21 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 24));
            Intrinsics.checkNotNullExpressionValue(provider21, "provider(...)");
            setDLCSplashSettingNoticeDialogServiceProvider(provider21);
            Provider<WallpaperDownloadingDialogService> provider22 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 26));
            Intrinsics.checkNotNullExpressionValue(provider22, "provider(...)");
            setWallpaperDownloadingDialogServiceProvider(provider22);
            Provider<WallpaperUnavailableDialogService> provider23 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 27));
            Intrinsics.checkNotNullExpressionValue(provider23, "provider(...)");
            setWallpaperUnavailableDialogServiceProvider(provider23);
            Provider<WallpaperSettingsDialogService> provider24 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 25));
            Intrinsics.checkNotNullExpressionValue(provider24, "provider(...)");
            setWallpaperSettingsDialogServiceProvider(provider24);
            DelegateFactory.setDelegate(getProvideHandleActionProvider(), DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 17)));
            Provider<DigitalTopBarUIService> provider25 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 16));
            Intrinsics.checkNotNullExpressionValue(provider25, "provider(...)");
            setDigitalTopBarUIServiceProvider(provider25);
            Provider<UnlockCardDialogService> provider26 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 30));
            Intrinsics.checkNotNullExpressionValue(provider26, "provider(...)");
            setUnlockCardDialogServiceProvider(provider26);
            Provider<LockUIService> provider27 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 29));
            Intrinsics.checkNotNullExpressionValue(provider27, "provider(...)");
            setLockUIServiceProvider(provider27);
            Provider<DigitalCardDetailInfoUIService> provider28 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 28));
            Intrinsics.checkNotNullExpressionValue(provider28, "provider(...)");
            setDigitalCardDetailInfoUIServiceProvider(provider28);
            Provider<DigitalButtonsService> provider29 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 31));
            Intrinsics.checkNotNullExpressionValue(provider29, "provider(...)");
            setDigitalButtonsServiceProvider(provider29);
            Provider<FeatureDescDialogService> provider30 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 33));
            Intrinsics.checkNotNullExpressionValue(provider30, "provider(...)");
            setFeatureDescDialogServiceProvider(provider30);
            Provider<FeaturePanelService> provider31 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 32));
            Intrinsics.checkNotNullExpressionValue(provider31, "provider(...)");
            setFeaturePanelServiceProvider(provider31);
            Provider<ShopPreviewUIService> provider32 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, this.shopPreviewComponentImpl, 0));
            Intrinsics.checkNotNullExpressionValue(provider32, "provider(...)");
            setShopPreviewUIServiceProvider(provider32);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: DaggerCardPreviewComponent.kt */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkntr/app/digital/preview/aggregate/DaggerCardPreviewComponent$ShopPreviewComponentImpl$SwitchingProvider;", "T", "Ljavax/inject/Provider;", "cardPreviewComponentImpl", "Lkntr/app/digital/preview/aggregate/DaggerCardPreviewComponent$CardPreviewComponentImpl;", "shopPreviewComponentImpl", "Lkntr/app/digital/preview/aggregate/DaggerCardPreviewComponent$ShopPreviewComponentImpl;", ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/digital/preview/aggregate/DaggerCardPreviewComponent$CardPreviewComponentImpl;Lkntr/app/digital/preview/aggregate/DaggerCardPreviewComponent$ShopPreviewComponentImpl;I)V", "get", "()Ljava/lang/Object;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class SwitchingProvider<T> implements Provider<T> {
            private final CardPreviewComponentImpl cardPreviewComponentImpl;
            private final int id;
            private final ShopPreviewComponentImpl shopPreviewComponentImpl;

            public SwitchingProvider(CardPreviewComponentImpl cardPreviewComponentImpl, ShopPreviewComponentImpl shopPreviewComponentImpl, int id) {
                Intrinsics.checkNotNullParameter(cardPreviewComponentImpl, "cardPreviewComponentImpl");
                Intrinsics.checkNotNullParameter(shopPreviewComponentImpl, "shopPreviewComponentImpl");
                this.cardPreviewComponentImpl = cardPreviewComponentImpl;
                this.shopPreviewComponentImpl = shopPreviewComponentImpl;
                this.id = id;
            }

            @Override // javax.inject.Provider
            public T get() {
                switch (this.id) {
                    case 0:
                        DigitalCardListUIService digitalCardListUIService = this.shopPreviewComponentImpl.getDigitalCardListUIServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(digitalCardListUIService, "get(...)");
                        DigitalTopBarUIService digitalTopBarUIService = this.shopPreviewComponentImpl.getDigitalTopBarUIServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(digitalTopBarUIService, "get(...)");
                        DigitalCardStateService digitalCardStateService = this.shopPreviewComponentImpl.getDigitalCardStateServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(digitalCardStateService, "get(...)");
                        DigitalCardDetailInfoUIService digitalCardDetailInfoUIService = this.shopPreviewComponentImpl.getDigitalCardDetailInfoUIServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(digitalCardDetailInfoUIService, "get(...)");
                        DigitalButtonsService digitalButtonsService = this.shopPreviewComponentImpl.getDigitalButtonsServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(digitalButtonsService, "get(...)");
                        FeaturePanelService featurePanelService = this.shopPreviewComponentImpl.getFeaturePanelServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(featurePanelService, "get(...)");
                        return (T) new ShopPreviewUIService(digitalCardListUIService, digitalTopBarUIService, digitalCardStateService, digitalCardDetailInfoUIService, digitalButtonsService, featurePanelService);
                    case 1:
                        DigitalCardStateService digitalCardStateService2 = this.shopPreviewComponentImpl.getDigitalCardStateServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(digitalCardStateService2, "get(...)");
                        VideoUIService videoUIService = this.shopPreviewComponentImpl.getVideoUIServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(videoUIService, "get(...)");
                        WebCardUIService webCardUIService = this.shopPreviewComponentImpl.getWebCardUIServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(webCardUIService, "get(...)");
                        return (T) new DigitalCardListUIService(digitalCardStateService2, videoUIService, webCardUIService);
                    case 2:
                        CoroutineScope scope = this.shopPreviewComponentImpl.getScope();
                        List<CardItem<?>> list = this.shopPreviewComponentImpl.getProvideDigitalCardListProvider().get();
                        Intrinsics.checkNotNullExpressionValue(list, "get(...)");
                        Map<String, String> map = this.cardPreviewComponentImpl.getProvideFromParamsProvider().get();
                        Intrinsics.checkNotNullExpressionValue(map, "get(...)");
                        Integer num = this.shopPreviewComponentImpl.getProvideInitialPageProvider().get();
                        Intrinsics.checkNotNullExpressionValue(num, "get(...)");
                        int intValue = num.intValue();
                        GetCardList.RequestParams requestParams = this.cardPreviewComponentImpl.getProvideRequestParamsProvider().get();
                        Intrinsics.checkNotNullExpressionValue(requestParams, "get(...)");
                        Long l = this.cardPreviewComponentImpl.getProvideVMidProvider().get();
                        Intrinsics.checkNotNullExpressionValue(l, "get(...)");
                        long longValue = l.longValue();
                        Boolean bool = this.shopPreviewComponentImpl.getProvideInitialFrontHasMoreProvider().get();
                        Intrinsics.checkNotNullExpressionValue(bool, "get(...)");
                        boolean booleanValue = bool.booleanValue();
                        Boolean bool2 = this.shopPreviewComponentImpl.getProvideInitialBackHasMoreProvider().get();
                        Intrinsics.checkNotNullExpressionValue(bool2, "get(...)");
                        boolean booleanValue2 = bool2.booleanValue();
                        String str = this.shopPreviewComponentImpl.getProvideInitialRequestExtraParamsProvider().get();
                        Intrinsics.checkNotNullExpressionValue(str, "get(...)");
                        String str2 = this.shopPreviewComponentImpl.getProvideInitialFrontAnchorIdProvider().get();
                        Intrinsics.checkNotNullExpressionValue(str2, "get(...)");
                        String str3 = this.shopPreviewComponentImpl.getProvideInitialBackAnchorIdProvider().get();
                        Intrinsics.checkNotNullExpressionValue(str3, "get(...)");
                        GetCardList cardList = this.cardPreviewComponentImpl.getCardList();
                        LockStateService lockStateService = this.shopPreviewComponentImpl.getLockStateServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(lockStateService, "get(...)");
                        return (T) new DigitalCardStateService(scope, list, map, intValue, requestParams, longValue, booleanValue, booleanValue2, str, str2, str3, cardList, lockStateService);
                    case 3:
                        ShopPreviewPageDataModule_ProvideDigitalCardListFactory.Companion companion = ShopPreviewPageDataModule_ProvideDigitalCardListFactory.Companion;
                        Long l2 = this.cardPreviewComponentImpl.getProvideVMidProvider().get();
                        Intrinsics.checkNotNullExpressionValue(l2, "get(...)");
                        long longValue2 = l2.longValue();
                        Map<String, String> map2 = this.cardPreviewComponentImpl.getProvideFromParamsProvider().get();
                        Intrinsics.checkNotNullExpressionValue(map2, "get(...)");
                        return (T) companion.provideDigitalCardList(longValue2, map2, this.shopPreviewComponentImpl.getDlcDetailModel());
                    case 4:
                        ShopPreviewPageDataModule shopPreviewPageDataModule = ShopPreviewPageDataModule.INSTANCE;
                        List<CardItem<?>> list2 = this.shopPreviewComponentImpl.getProvideDigitalCardListProvider().get();
                        Intrinsics.checkNotNullExpressionValue(list2, "get(...)");
                        return (T) Integer.valueOf(shopPreviewPageDataModule.provideInitialPage(list2));
                    case 5:
                        return (T) Boolean.valueOf(ShopPreviewPageDataModule.INSTANCE.provideInitialFrontHasMore(this.shopPreviewComponentImpl.getDlcDetailModel()));
                    case 6:
                        return (T) Boolean.valueOf(ShopPreviewPageDataModule.INSTANCE.provideInitialBackHasMore(this.shopPreviewComponentImpl.getDlcDetailModel()));
                    case 7:
                        return (T) ShopPreviewPageDataModule_ProvideInitialRequestExtraParamsFactory.Companion.provideInitialRequestExtraParams(this.shopPreviewComponentImpl.getDlcDetailModel());
                    case 8:
                        return (T) ShopPreviewPageDataModule_ProvideInitialFrontAnchorIdFactory.Companion.provideInitialFrontAnchorId(this.shopPreviewComponentImpl.getDlcDetailModel());
                    case 9:
                        return (T) ShopPreviewPageDataModule_ProvideInitialBackAnchorIdFactory.Companion.provideInitialBackAnchorId(this.shopPreviewComponentImpl.getDlcDetailModel());
                    case 10:
                        ToggleLockCard toggleLockCard = this.cardPreviewComponentImpl.toggleLockCard();
                        Integer num2 = this.cardPreviewComponentImpl.getProvideActivityIdProvider().get();
                        Intrinsics.checkNotNullExpressionValue(num2, "get(...)");
                        return (T) new LockStateService(toggleLockCard, num2.intValue(), this.shopPreviewComponentImpl.getScope(), this.cardPreviewComponentImpl.getToaster());
                    case AdditionVote2.ADDITION_VOTE_PIC_FIELD_NUMBER /* 11 */:
                        DigitalVideoPlayService digitalVideoPlayService = this.shopPreviewComponentImpl.getDigitalVideoPlayServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(digitalVideoPlayService, "get(...)");
                        DigitalCardStateService digitalCardStateService3 = this.shopPreviewComponentImpl.getDigitalCardStateServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(digitalCardStateService3, "get(...)");
                        return (T) new VideoUIService(digitalVideoPlayService, digitalCardStateService3, this.cardPreviewComponentImpl.getRouter());
                    case AdditionVote2.ADDITION_VOTE_DEFAULE_FIELD_NUMBER /* 12 */:
                        Lifecycle lifecycle = this.cardPreviewComponentImpl.getLifecycle();
                        CoroutineScope scope2 = this.shopPreviewComponentImpl.getScope();
                        DigitalCardStateService digitalCardStateService4 = this.shopPreviewComponentImpl.getDigitalCardStateServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(digitalCardStateService4, "get(...)");
                        DownloadCaptions downloadCaptions = this.cardPreviewComponentImpl.downloadCaptions();
                        DigitalVideoCardVolumeService digitalVideoCardVolumeService = this.shopPreviewComponentImpl.getDigitalVideoCardVolumeServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(digitalVideoCardVolumeService, "get(...)");
                        return (T) new DigitalVideoPlayService(lifecycle, scope2, digitalCardStateService4, downloadCaptions, digitalVideoCardVolumeService);
                    case AdditionVote2.BIZ_TYPE_FIELD_NUMBER /* 13 */:
                        DigitalCardStateService digitalCardStateService5 = this.shopPreviewComponentImpl.getDigitalCardStateServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(digitalCardStateService5, "get(...)");
                        return (T) new DigitalVideoCardVolumeService(digitalCardStateService5);
                    case AdditionVote2.TOTAL_FIELD_NUMBER /* 14 */:
                        DigitalCardStateService digitalCardStateService6 = this.shopPreviewComponentImpl.getDigitalCardStateServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(digitalCardStateService6, "get(...)");
                        DigitalWebCardService digitalWebCardService = this.shopPreviewComponentImpl.getDigitalWebCardServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(digitalWebCardService, "get(...)");
                        return (T) new WebCardUIService(digitalCardStateService6, digitalWebCardService);
                    case AdditionVote2.CARD_TYPE_FIELD_NUMBER /* 15 */:
                        CoroutineScope scope3 = this.shopPreviewComponentImpl.getScope();
                        DigitalCardStateService digitalCardStateService7 = this.shopPreviewComponentImpl.getDigitalCardStateServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(digitalCardStateService7, "get(...)");
                        DigitalVideoCardVolumeService digitalVideoCardVolumeService2 = this.shopPreviewComponentImpl.getDigitalVideoCardVolumeServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(digitalVideoCardVolumeService2, "get(...)");
                        return (T) new DigitalWebCardService(scope3, digitalCardStateService7, digitalVideoCardVolumeService2);
                    case AdditionVote2.TIPS_FIELD_NUMBER /* 16 */:
                        HandleAction handleAction = this.shopPreviewComponentImpl.getProvideHandleActionProvider().get();
                        Intrinsics.checkNotNullExpressionValue(handleAction, "get(...)");
                        DigitalViewMoreService digitalViewMoreService = this.shopPreviewComponentImpl.getDigitalViewMoreServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(digitalViewMoreService, "get(...)");
                        DigitalCardStateService digitalCardStateService8 = this.shopPreviewComponentImpl.getDigitalCardStateServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(digitalCardStateService8, "get(...)");
                        return (T) new DigitalTopBarUIService(handleAction, digitalViewMoreService, digitalCardStateService8);
                    case AdditionVote2.URI_FIELD_NUMBER /* 17 */:
                        return (T) HandleActionModule_ProvideHandleActionFactory.Companion.provideHandleAction(this.shopPreviewComponentImpl.setOfActionModuleOf(), this.shopPreviewComponentImpl.reportService());
                    case AdditionVote2.IS_VOTED_FIELD_NUMBER /* 18 */:
                        Toaster toaster = this.cardPreviewComponentImpl.getToaster();
                        DialogService dialogService = this.cardPreviewComponentImpl.getDialogServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(dialogService, "get(...)");
                        return (T) new ShareDialogService(toaster, dialogService, this.shopPreviewComponentImpl.getScope());
                    case AdditionVote2.CHOICE_CNT_FIELD_NUMBER /* 19 */:
                        return (T) new DigitalViewMoreService();
                    case AdditionVote2.DEFAULE_SELECT_SHARE_FIELD_NUMBER /* 20 */:
                        DialogService dialogService2 = this.cardPreviewComponentImpl.getDialogServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(dialogService2, "get(...)");
                        return (T) new DigitalGiftErrorDialogService(dialogService2);
                    case AdditionVote2.ONLY_FANS_VOTE_FIELD_NUMBER /* 21 */:
                        Lazy lazy = DoubleCheck.lazy(this.shopPreviewComponentImpl.getProvideHandleActionProvider());
                        Intrinsics.checkNotNullExpressionValue(lazy, "lazy(...)");
                        Usage usage = this.cardPreviewComponentImpl.usage();
                        DigitalCardStateService digitalCardStateService9 = this.shopPreviewComponentImpl.getDigitalCardStateServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(digitalCardStateService9, "get(...)");
                        Integer num3 = this.cardPreviewComponentImpl.getProvideActivityIdProvider().get();
                        Intrinsics.checkNotNullExpressionValue(num3, "get(...)");
                        int intValue2 = num3.intValue();
                        DialogService dialogService3 = this.cardPreviewComponentImpl.getDialogServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(dialogService3, "get(...)");
                        return (T) new DigitalUsageMenuDialogService(lazy, usage, digitalCardStateService9, intValue2, dialogService3);
                    case AdditionVote2.VOTE_OWNER_MID_FIELD_NUMBER /* 22 */:
                        DialogService dialogService4 = this.cardPreviewComponentImpl.getDialogServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(dialogService4, "get(...)");
                        return (T) new DigitalUsageRestrictionDialogService(dialogService4);
                    case 23:
                        BusinessReportParamsProvider_ProvideCurrentCardItemFactory.Companion companion2 = BusinessReportParamsProvider_ProvideCurrentCardItemFactory.Companion;
                        DigitalCardStateService digitalCardStateService10 = this.shopPreviewComponentImpl.getDigitalCardStateServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(digitalCardStateService10, "get(...)");
                        return (T) companion2.provideCurrentCardItem(digitalCardStateService10);
                    case 24:
                        DialogService dialogService5 = this.cardPreviewComponentImpl.getDialogServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(dialogService5, "get(...)");
                        return (T) new DLCSplashSettingNoticeDialogService(dialogService5);
                    case 25:
                        KomponentScope<Unit> komponentScope = this.cardPreviewComponentImpl.getKomponentScope();
                        ReportService reportService = this.shopPreviewComponentImpl.reportService();
                        SetHomeWallpaper homeWallpaper = this.shopPreviewComponentImpl.setHomeWallpaper();
                        SetLockscreenWallpaper lockscreenWallpaper = this.shopPreviewComponentImpl.setLockscreenWallpaper();
                        DialogService dialogService6 = this.cardPreviewComponentImpl.getDialogServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(dialogService6, "get(...)");
                        return (T) new WallpaperSettingsDialogService(komponentScope, reportService, homeWallpaper, lockscreenWallpaper, dialogService6);
                    case 26:
                        DialogService dialogService7 = this.cardPreviewComponentImpl.getDialogServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(dialogService7, "get(...)");
                        return (T) new WallpaperDownloadingDialogService(dialogService7);
                    case 27:
                        DialogService dialogService8 = this.cardPreviewComponentImpl.getDialogServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(dialogService8, "get(...)");
                        return (T) new WallpaperUnavailableDialogService(dialogService8);
                    case 28:
                        DigitalCardStateService digitalCardStateService11 = this.shopPreviewComponentImpl.getDigitalCardStateServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(digitalCardStateService11, "get(...)");
                        DigitalVideoCardVolumeService digitalVideoCardVolumeService3 = this.shopPreviewComponentImpl.getDigitalVideoCardVolumeServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(digitalVideoCardVolumeService3, "get(...)");
                        Router router = this.cardPreviewComponentImpl.getRouter();
                        LockUIService lockUIService = this.shopPreviewComponentImpl.getLockUIServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(lockUIService, "get(...)");
                        return (T) new DigitalCardDetailInfoUIService(digitalCardStateService11, digitalVideoCardVolumeService3, router, lockUIService);
                    case 29:
                        CoroutineScope scope4 = this.shopPreviewComponentImpl.getScope();
                        UnlockCardDialogService unlockCardDialogService = this.shopPreviewComponentImpl.getUnlockCardDialogServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(unlockCardDialogService, "get(...)");
                        LockStateService lockStateService2 = this.shopPreviewComponentImpl.getLockStateServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(lockStateService2, "get(...)");
                        DigitalCardStateService digitalCardStateService12 = this.shopPreviewComponentImpl.getDigitalCardStateServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(digitalCardStateService12, "get(...)");
                        return (T) new LockUIService(scope4, unlockCardDialogService, lockStateService2, digitalCardStateService12);
                    case 30:
                        DialogService dialogService9 = this.cardPreviewComponentImpl.getDialogServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(dialogService9, "get(...)");
                        return (T) new UnlockCardDialogService(dialogService9);
                    case 31:
                        DigitalCardStateService digitalCardStateService13 = this.shopPreviewComponentImpl.getDigitalCardStateServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(digitalCardStateService13, "get(...)");
                        HandleAction handleAction2 = this.shopPreviewComponentImpl.getProvideHandleActionProvider().get();
                        Intrinsics.checkNotNullExpressionValue(handleAction2, "get(...)");
                        return (T) new DigitalButtonsService(digitalCardStateService13, handleAction2);
                    case 32:
                        FeatureDescDialogService featureDescDialogService = this.shopPreviewComponentImpl.getFeatureDescDialogServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(featureDescDialogService, "get(...)");
                        Long l3 = this.cardPreviewComponentImpl.getProvideVMidProvider().get();
                        Intrinsics.checkNotNullExpressionValue(l3, "get(...)");
                        long longValue3 = l3.longValue();
                        CoroutineScope scope5 = this.shopPreviewComponentImpl.getScope();
                        DigitalCardStateService digitalCardStateService14 = this.shopPreviewComponentImpl.getDigitalCardStateServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(digitalCardStateService14, "get(...)");
                        return (T) new FeaturePanelService(featureDescDialogService, longValue3, scope5, digitalCardStateService14, this.cardPreviewComponentImpl.getWebCardDescInfo());
                    case 33:
                        DialogService dialogService10 = this.cardPreviewComponentImpl.getDialogServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(dialogService10, "get(...)");
                        return (T) new FeatureDescDialogService(dialogService10);
                    default:
                        throw new AssertionError(this.id);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DaggerCardPreviewComponent.kt */
    @Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001:\u0001SB5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0006\u0010?\u001a\u00020@J\u0006\u0010A\u001a\u00020BJ\u0006\u0010C\u001a\u00020DJ\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020HJ\u0006\u0010I\u001a\u00020JJ\u0006\u0010K\u001a\u00020LJ\u0006\u0010M\u001a\u00020NJ\u0006\u0010O\u001a\u00020PJ6\u0010Q\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\b\u0010R\u001a\u00020/H\u0016R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0 X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010#\"\u0004\b)\u0010%R \u0010*\u001a\b\u0012\u0004\u0012\u00020+0 X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010#\"\u0004\b-\u0010%R \u0010.\u001a\b\u0012\u0004\u0012\u00020/0 X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%R \u00102\u001a\b\u0012\u0004\u0012\u0002030 X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010#\"\u0004\b5\u0010%R,\u00106\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u000208070 X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010#\"\u0004\b:\u0010%R \u0010;\u001a\b\u0012\u0004\u0012\u00020<0 X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010#\"\u0004\b>\u0010%¨\u0006T"}, d2 = {"Lkntr/app/digital/preview/aggregate/DaggerCardPreviewComponent$CardPreviewComponentImpl;", "Lkntr/app/digital/preview/aggregate/CardPreviewComponent;", "lifecycleParam", "Landroidx/lifecycle/Lifecycle;", "paramsParam", "Lkntr/app/digital/preview/RouterParams;", "toasterParam", "Lkntr/common/trio/toast/Toaster;", "routerParam", "Lkntr/base/router/Router;", "komponentScopeParam", "Lkntr/common/komponent/KomponentScope;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Landroidx/lifecycle/Lifecycle;Lkntr/app/digital/preview/RouterParams;Lkntr/common/trio/toast/Toaster;Lkntr/base/router/Router;Lkntr/common/komponent/KomponentScope;)V", "params", "getParams", "()Lkntr/app/digital/preview/RouterParams;", "toaster", "getToaster", "()Lkntr/common/trio/toast/Toaster;", "lifecycle", "getLifecycle", "()Landroidx/lifecycle/Lifecycle;", "router", "getRouter", "()Lkntr/base/router/Router;", "komponentScope", "getKomponentScope", "()Lkntr/common/komponent/KomponentScope;", "cardPreviewComponentImpl", "provideRequestParamsProvider", "Ljavax/inject/Provider;", "Lkntr/app/digital/preview/api/GetCardList$RequestParams;", "getProvideRequestParamsProvider", "()Ljavax/inject/Provider;", "setProvideRequestParamsProvider", "(Ljavax/inject/Provider;)V", "provideSimpleCardProvider", "Lkntr/app/digital/preview/SimpleCard;", "getProvideSimpleCardProvider", "setProvideSimpleCardProvider", "dialogServiceProvider", "Lkntr/app/digital/preview/DialogService;", "getDialogServiceProvider", "setDialogServiceProvider", "cardPreviewPageModelProvider", "Lkntr/app/digital/preview/CardPreviewPageModel;", "getCardPreviewPageModelProvider", "setCardPreviewPageModelProvider", "provideVMidProvider", RoomRecommendViewModel.EMPTY_CURSOR, "getProvideVMidProvider", "setProvideVMidProvider", "provideFromParamsProvider", RoomRecommendViewModel.EMPTY_CURSOR, RoomRecommendViewModel.EMPTY_CURSOR, "getProvideFromParamsProvider", "setProvideFromParamsProvider", "provideActivityIdProvider", RoomRecommendViewModel.EMPTY_CURSOR, "getProvideActivityIdProvider", "setProvideActivityIdProvider", "getCardList", "Lkntr/app/digital/preview/api/GetCardList;", "toggleLockCard", "Lkntr/app/digital/preview/lock/ToggleLockCard;", "downloadCaptions", "Lkntr/app/digital/preview/card/video/DownloadCaptions;", "dismissRequest", "Lkntr/app/digital/preview/closing/DismissRequest;", "requestGiftInfo", "Lkntr/app/digital/preview/gift/RequestGiftInfo;", "usage", "Lkntr/app/digital/preview/usage/Usage;", "provide", "Lkntr/app/digital/preview/report/FillCommonReportParams;", "splashSettingInfo", "Lkntr/app/digital/preview/splashsetting/SplashSettingInfo;", "getWebCardDescInfo", "Lkntr/app/digital/preview/card/web/GetWebCardDescInfo;", "initialize", "pageModel", "SwitchingProvider", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class CardPreviewComponentImpl implements CardPreviewComponent {
        private final CardPreviewComponentImpl cardPreviewComponentImpl;
        public Provider<CardPreviewPageModel> cardPreviewPageModelProvider;
        public Provider<DialogService> dialogServiceProvider;
        private final KomponentScope<Unit> komponentScope;
        private final Lifecycle lifecycle;
        private final RouterParams params;
        public Provider<Integer> provideActivityIdProvider;
        public Provider<Map<String, String>> provideFromParamsProvider;
        public Provider<GetCardList.RequestParams> provideRequestParamsProvider;
        public Provider<SimpleCard> provideSimpleCardProvider;
        public Provider<Long> provideVMidProvider;
        private final Router router;
        private final Toaster toaster;

        public CardPreviewComponentImpl(Lifecycle lifecycleParam, RouterParams paramsParam, Toaster toasterParam, Router routerParam, KomponentScope<? super Unit> komponentScope) {
            Intrinsics.checkNotNullParameter(lifecycleParam, "lifecycleParam");
            Intrinsics.checkNotNullParameter(paramsParam, "paramsParam");
            Intrinsics.checkNotNullParameter(toasterParam, "toasterParam");
            Intrinsics.checkNotNullParameter(routerParam, "routerParam");
            Intrinsics.checkNotNullParameter(komponentScope, "komponentScopeParam");
            this.cardPreviewComponentImpl = this;
            this.params = paramsParam;
            this.toaster = toasterParam;
            this.lifecycle = lifecycleParam;
            this.router = routerParam;
            this.komponentScope = komponentScope;
            initialize(lifecycleParam, paramsParam, toasterParam, routerParam, komponentScope);
        }

        public final RouterParams getParams() {
            return this.params;
        }

        public final Toaster getToaster() {
            return this.toaster;
        }

        public final Lifecycle getLifecycle() {
            return this.lifecycle;
        }

        public final Router getRouter() {
            return this.router;
        }

        public final KomponentScope<Unit> getKomponentScope() {
            return this.komponentScope;
        }

        public final Provider<GetCardList.RequestParams> getProvideRequestParamsProvider() {
            Provider<GetCardList.RequestParams> provider = this.provideRequestParamsProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("provideRequestParamsProvider");
            return null;
        }

        public final void setProvideRequestParamsProvider(Provider<GetCardList.RequestParams> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.provideRequestParamsProvider = provider;
        }

        public final Provider<SimpleCard> getProvideSimpleCardProvider() {
            Provider<SimpleCard> provider = this.provideSimpleCardProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("provideSimpleCardProvider");
            return null;
        }

        public final void setProvideSimpleCardProvider(Provider<SimpleCard> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.provideSimpleCardProvider = provider;
        }

        public final Provider<DialogService> getDialogServiceProvider() {
            Provider<DialogService> provider = this.dialogServiceProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("dialogServiceProvider");
            return null;
        }

        public final void setDialogServiceProvider(Provider<DialogService> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.dialogServiceProvider = provider;
        }

        public final Provider<CardPreviewPageModel> getCardPreviewPageModelProvider() {
            Provider<CardPreviewPageModel> provider = this.cardPreviewPageModelProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("cardPreviewPageModelProvider");
            return null;
        }

        public final void setCardPreviewPageModelProvider(Provider<CardPreviewPageModel> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.cardPreviewPageModelProvider = provider;
        }

        public final Provider<Long> getProvideVMidProvider() {
            Provider<Long> provider = this.provideVMidProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("provideVMidProvider");
            return null;
        }

        public final void setProvideVMidProvider(Provider<Long> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.provideVMidProvider = provider;
        }

        public final Provider<Map<String, String>> getProvideFromParamsProvider() {
            Provider<Map<String, String>> provider = this.provideFromParamsProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("provideFromParamsProvider");
            return null;
        }

        public final void setProvideFromParamsProvider(Provider<Map<String, String>> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.provideFromParamsProvider = provider;
        }

        public final Provider<Integer> getProvideActivityIdProvider() {
            Provider<Integer> provider = this.provideActivityIdProvider;
            if (provider != null) {
                return provider;
            }
            Intrinsics.throwUninitializedPropertyAccessException("provideActivityIdProvider");
            return null;
        }

        public final void setProvideActivityIdProvider(Provider<Integer> provider) {
            Intrinsics.checkNotNullParameter(provider, "<set-?>");
            this.provideActivityIdProvider = provider;
        }

        public final GetCardList getCardList() {
            return CardPreviewComponent_Impl_ProvideGetCardListFactory.Companion.provideGetCardList(CardPreviewComponent_Impl_ProvideHttpClientFactory.Companion.provideHttpClient());
        }

        public final ToggleLockCard toggleLockCard() {
            return CardPreviewComponent_Impl_ProvideToggleLockCardFactory.Companion.provideToggleLockCard(CardPreviewComponent_Impl_ProvideHttpClientFactory.Companion.provideHttpClient());
        }

        public final DownloadCaptions downloadCaptions() {
            return CardPreviewComponent_Impl_ProvideDownloadCaptionsFactory.Companion.provideDownloadCaptions(CardPreviewComponent_Impl_ProvideHttpClientFactory.Companion.provideHttpClient());
        }

        public final DismissRequest dismissRequest() {
            return CardPreviewComponent_Impl_ProvideDismissRequestFactory.Companion.provideDismissRequest(this.komponentScope);
        }

        public final RequestGiftInfo requestGiftInfo() {
            return CardPreviewComponent_Impl_ProvideRequestGiftInfoFactory.Companion.provideRequestGiftInfo(CardPreviewComponent_Impl_ProvideHttpClientFactory.Companion.provideHttpClient());
        }

        public final Usage usage() {
            return CardPreviewComponent_Impl_ProvideUsageFactory.Companion.provideUsage(CardPreviewComponent_Impl_ProvideHttpClientFactory.Companion.provideHttpClient());
        }

        public final FillCommonReportParams provide() {
            return PageReportParamsProvider_ProvideFactory.Companion.provide(this.params);
        }

        public final SplashSettingInfo splashSettingInfo() {
            return CardPreviewComponent_Impl_ProvideSplashSettingInfoFactory.Companion.provideSplashSettingInfo(CardPreviewComponent_Impl_ProvideHttpClientFactory.Companion.provideHttpClient());
        }

        public final GetWebCardDescInfo getWebCardDescInfo() {
            return CardPreviewComponent_Impl_ProvideWebCardDescInfoFactory.Companion.provideWebCardDescInfo(CardPreviewComponent_Impl_ProvideHttpClientFactory.Companion.provideHttpClient());
        }

        private final void initialize(Lifecycle lifecycleParam, RouterParams paramsParam, Toaster toasterParam, Router routerParam, KomponentScope<? super Unit> komponentScope) {
            Provider<GetCardList.RequestParams> provider = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, 1));
            Intrinsics.checkNotNullExpressionValue(provider, "provider(...)");
            setProvideRequestParamsProvider(provider);
            Provider<SimpleCard> provider2 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, 2));
            Intrinsics.checkNotNullExpressionValue(provider2, "provider(...)");
            setProvideSimpleCardProvider(provider2);
            Provider<DialogService> provider3 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, 3));
            Intrinsics.checkNotNullExpressionValue(provider3, "provider(...)");
            setDialogServiceProvider(provider3);
            Provider<CardPreviewPageModel> provider4 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, 0));
            Intrinsics.checkNotNullExpressionValue(provider4, "provider(...)");
            setCardPreviewPageModelProvider(provider4);
            Provider<Long> provider5 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, 4));
            Intrinsics.checkNotNullExpressionValue(provider5, "provider(...)");
            setProvideVMidProvider(provider5);
            Provider<Map<String, String>> provider6 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, 5));
            Intrinsics.checkNotNullExpressionValue(provider6, "provider(...)");
            setProvideFromParamsProvider(provider6);
            Provider<Integer> provider7 = DoubleCheck.provider(new SwitchingProvider(this.cardPreviewComponentImpl, 6));
            Intrinsics.checkNotNullExpressionValue(provider7, "provider(...)");
            setProvideActivityIdProvider(provider7);
        }

        @Override // kntr.app.digital.preview.aggregate.CardPreviewComponent
        public CardPreviewPageModel pageModel() {
            CardPreviewPageModel cardPreviewPageModel = getCardPreviewPageModelProvider().get();
            Intrinsics.checkNotNullExpressionValue(cardPreviewPageModel, "get(...)");
            return cardPreviewPageModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: DaggerCardPreviewComponent.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkntr/app/digital/preview/aggregate/DaggerCardPreviewComponent$CardPreviewComponentImpl$SwitchingProvider;", "T", "Ljavax/inject/Provider;", "cardPreviewComponentImpl", "Lkntr/app/digital/preview/aggregate/DaggerCardPreviewComponent$CardPreviewComponentImpl;", ReportBuildInParam.ID, RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "(Lkntr/app/digital/preview/aggregate/DaggerCardPreviewComponent$CardPreviewComponentImpl;I)V", "get", "()Ljava/lang/Object;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
        public static final class SwitchingProvider<T> implements Provider<T> {
            private final CardPreviewComponentImpl cardPreviewComponentImpl;
            private final int id;

            public SwitchingProvider(CardPreviewComponentImpl cardPreviewComponentImpl, int id) {
                Intrinsics.checkNotNullParameter(cardPreviewComponentImpl, "cardPreviewComponentImpl");
                this.cardPreviewComponentImpl = cardPreviewComponentImpl;
                this.id = id;
            }

            @Override // javax.inject.Provider
            public T get() {
                switch (this.id) {
                    case 0:
                        ShopPreviewComponentFactory shopPreviewComponentFactory = new ShopPreviewComponentFactory(this.cardPreviewComponentImpl);
                        GetCardList.RequestParams requestParams = this.cardPreviewComponentImpl.getProvideRequestParamsProvider().get();
                        Intrinsics.checkNotNullExpressionValue(requestParams, "get(...)");
                        GetCardList.RequestParams requestParams2 = requestParams;
                        GetCardList cardList = this.cardPreviewComponentImpl.getCardList();
                        SimpleCard simpleCard = this.cardPreviewComponentImpl.getProvideSimpleCardProvider().get();
                        DialogService dialogService = this.cardPreviewComponentImpl.getDialogServiceProvider().get();
                        Intrinsics.checkNotNullExpressionValue(dialogService, "get(...)");
                        return (T) new CardPreviewPageModel(shopPreviewComponentFactory, requestParams2, cardList, simpleCard, dialogService);
                    case 1:
                        return (T) RouterParamsBackedModule_ProvideRequestParamsFactory.Companion.provideRequestParams(this.cardPreviewComponentImpl.getParams());
                    case 2:
                        return (T) RouterParamsBackedModule.INSTANCE.provideSimpleCard(this.cardPreviewComponentImpl.getParams());
                    case 3:
                        return (T) new DialogService();
                    case 4:
                        return (T) Long.valueOf(RouterParamsBackedModule.INSTANCE.provideVMid(this.cardPreviewComponentImpl.getParams()));
                    case 5:
                        return (T) RouterParamsBackedModule_ProvideFromParamsFactory.Companion.provideFromParams(this.cardPreviewComponentImpl.getParams());
                    case 6:
                        return (T) Integer.valueOf(RouterParamsBackedModule.INSTANCE.provideActivityId(this.cardPreviewComponentImpl.getParams()));
                    default:
                        throw new AssertionError(this.id);
                }
            }
        }
    }

    /* compiled from: DaggerCardPreviewComponent.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lkntr/app/digital/preview/aggregate/DaggerCardPreviewComponent$Companion;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "factory", "Lkntr/app/digital/preview/aggregate/CardPreviewComponent$Factory;", "preview_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5/202602280713022b24dde5-650f-44d6-87eb-e24b0df191b5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CardPreviewComponent.Factory factory() {
            return new Factory();
        }
    }
}