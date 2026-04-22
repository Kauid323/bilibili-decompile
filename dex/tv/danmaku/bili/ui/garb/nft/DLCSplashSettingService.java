package tv.danmaku.bili.ui.garb.nft;

import android.content.Context;
import android.net.Uri;
import android.util.DisplayMetrics;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.ogv.infra.router.RouterRequestKt;
import com.bilibili.okretro.response.BiliApiResponse;
import com.bilibili.okretro.response.BiliApiResponseKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.garb.nft.api.DLCApiService;
import tv.danmaku.bili.ui.garb.nft.model.DLCSplashCardInfo;
import tv.danmaku.bili.ui.splash.brand.config.BrandSplashStorage;

/* compiled from: DLCSplashSettingService.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Ltv/danmaku/bili/ui/garb/nft/DLCSplashSettingService;", "", "context", "Landroid/content/Context;", "service", "Ltv/danmaku/bili/ui/garb/nft/api/DLCApiService;", "splashSettingNoticeDialogService", "Ltv/danmaku/bili/ui/garb/nft/DLCSplashSettingNoticeDialogService;", "<init>", "(Landroid/content/Context;Ltv/danmaku/bili/ui/garb/nft/api/DLCApiService;Ltv/danmaku/bili/ui/garb/nft/DLCSplashSettingNoticeDialogService;)V", "splashSetting", "", "actId", "", "cardTypeId", "", "(IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DLCSplashSettingService {
    public static final int $stable = 8;
    private final Context context;
    private final DLCApiService service;
    private final DLCSplashSettingNoticeDialogService splashSettingNoticeDialogService;

    public DLCSplashSettingService(Context context, DLCApiService service, DLCSplashSettingNoticeDialogService splashSettingNoticeDialogService) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(service, "service");
        Intrinsics.checkNotNullParameter(splashSettingNoticeDialogService, "splashSettingNoticeDialogService");
        this.context = context;
        this.service = service;
        this.splashSettingNoticeDialogService = splashSettingNoticeDialogService;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object splashSetting(int i, long cardTypeId, Continuation<? super Unit> continuation) {
        Continuation<? super Unit> dLCSplashSettingService$splashSetting$1;
        final DLCSplashSettingService dLCSplashSettingService;
        Object dlcSplashInfo;
        long cardTypeId2;
        Object infoResult;
        boolean z;
        if (continuation instanceof DLCSplashSettingService$splashSetting$1) {
            dLCSplashSettingService$splashSetting$1 = (DLCSplashSettingService$splashSetting$1) continuation;
            if ((dLCSplashSettingService$splashSetting$1.label & Integer.MIN_VALUE) != 0) {
                dLCSplashSettingService$splashSetting$1.label -= Integer.MIN_VALUE;
                Object $result = dLCSplashSettingService$splashSetting$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                boolean z2 = true;
                switch (dLCSplashSettingService$splashSetting$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        dLCSplashSettingService = this;
                        DisplayMetrics metrics = dLCSplashSettingService.context.getResources().getDisplayMetrics();
                        int min = Math.min(metrics.widthPixels, metrics.heightPixels);
                        int max = Math.max(metrics.widthPixels, metrics.heightPixels);
                        DLCApiService dLCApiService = dLCSplashSettingService.service;
                        dLCSplashSettingService$splashSetting$1.J$0 = cardTypeId;
                        dLCSplashSettingService$splashSetting$1.label = 1;
                        dlcSplashInfo = dLCApiService.getDlcSplashInfo(i, cardTypeId, min, max, dLCSplashSettingService$splashSetting$1);
                        if (dlcSplashInfo != coroutine_suspended) {
                            cardTypeId2 = cardTypeId;
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    case 1:
                        cardTypeId2 = dLCSplashSettingService$splashSetting$1.J$0;
                        ResultKt.throwOnFailure($result);
                        dLCSplashSettingService = this;
                        dlcSplashInfo = $result;
                        break;
                    case 2:
                        z = false;
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                infoResult = BiliApiResponseKt.asResult((BiliApiResponse) dlcSplashInfo);
                if (Result.isSuccess-impl(infoResult)) {
                    ToastHelper.showToast(dLCSplashSettingService.context, "请稍后再试", 0);
                } else {
                    if (Result.isFailure-impl(infoResult)) {
                        infoResult = null;
                    }
                    DLCSplashCardInfo dLCSplashCardInfo = (DLCSplashCardInfo) infoResult;
                    final String cardInfoJson = dLCSplashCardInfo != null ? dLCSplashCardInfo.getResult() : null;
                    String str = cardInfoJson;
                    if (str != null && !StringsKt.isBlank(str)) {
                        z2 = false;
                    }
                    if (z2) {
                        ToastHelper.showToast(dLCSplashSettingService.context, "请稍后再试", 0);
                        return Unit.INSTANCE;
                    }
                    Object result = BrandSplashStorage.INSTANCE.addCustomSplash-IoAF18A(cardInfoJson);
                    Throwable e = Result.exceptionOrNull-impl(result);
                    if (e == null) {
                        Unit unit = (Unit) result;
                        Neurons.reportClick(false, "sqzz.dressing.single-card.screen-set.click", MapsKt.mapOf(TuplesKt.to("dlc_id", String.valueOf(cardTypeId2))));
                        ToastHelper.showToast(dLCSplashSettingService.context, "设置成功", 0);
                    } else if (e instanceof BrandSplashStorage.BrandsOverflowException) {
                        DLCSplashSettingNoticeDialogService dLCSplashSettingNoticeDialogService = dLCSplashSettingService.splashSettingNoticeDialogService;
                        Function0<Unit> function0 = new Function0() { // from class: tv.danmaku.bili.ui.garb.nft.DLCSplashSettingService$$ExternalSyntheticLambda0
                            public final Object invoke() {
                                Unit splashSetting$lambda$1$0;
                                splashSetting$lambda$1$0 = DLCSplashSettingService.splashSetting$lambda$1$0(cardInfoJson, dLCSplashSettingService);
                                return splashSetting$lambda$1$0;
                            }
                        };
                        dLCSplashSettingService$splashSetting$1.label = 2;
                        if (dLCSplashSettingNoticeDialogService.keepDialogShowing(function0, dLCSplashSettingService$splashSetting$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        z = false;
                    } else if (e instanceof BrandSplashStorage.RepeatAdditionException) {
                        ToastHelper.showToast(dLCSplashSettingService.context, "请勿重复设置", 0);
                    } else {
                        ToastHelper.showToast(dLCSplashSettingService.context, "请稍后再试", 0);
                    }
                }
                return Unit.INSTANCE;
            }
        }
        dLCSplashSettingService$splashSetting$1 = new DLCSplashSettingService$splashSetting$1(this, continuation);
        Object $result2 = dLCSplashSettingService$splashSetting$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z22 = true;
        switch (dLCSplashSettingService$splashSetting$1.label) {
        }
        infoResult = BiliApiResponseKt.asResult((BiliApiResponse) dlcSplashInfo);
        if (Result.isSuccess-impl(infoResult)) {
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit splashSetting$lambda$1$0(String $cardInfoJson, DLCSplashSettingService this$0) {
        Uri url = Uri.parse("bilibili://splash/brand-setting").buildUpon().appendQueryParameter("brandSplash", $cardInfoJson).appendQueryParameter("autoOpenFloat", "1").build();
        Intrinsics.checkNotNull(url);
        RouterRequestKt.openWith(RouteRequestKt.toRouteRequest(url), this$0.context);
        return Unit.INSTANCE;
    }
}