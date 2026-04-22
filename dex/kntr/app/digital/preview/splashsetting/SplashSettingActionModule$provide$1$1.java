package kntr.app.digital.preview.splashsetting;

import com.bilibili.ktor.KApiResponse;
import com.bilibili.ktor.KApiResponseKt;
import kntr.app.digital.preview.action.Action;
import kntr.app.digital.preview.report.ReportService;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.device.KDevice;
import kntr.base.router.Router;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

/* compiled from: SplashSettingActionModule.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.digital.preview.splashsetting.SplashSettingActionModule$provide$1$1", f = "SplashSettingActionModule.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class SplashSettingActionModule$provide$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ ReportService $reportService;
    final /* synthetic */ Router $router;
    final /* synthetic */ SplashSettingInfo $splashSettingInfo;
    final /* synthetic */ DLCSplashSettingNoticeDialogService $splashSettingNoticeDialogService;
    final /* synthetic */ Action<SplashSettingAction> $this_ActionModule;
    final /* synthetic */ Toaster $toaster;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashSettingActionModule$provide$1$1(SplashSettingInfo splashSettingInfo, Action<SplashSettingAction> action, Toaster toaster, ReportService reportService, CoroutineScope coroutineScope, DLCSplashSettingNoticeDialogService dLCSplashSettingNoticeDialogService, Router router, Continuation<? super SplashSettingActionModule$provide$1$1> continuation) {
        super(2, continuation);
        this.$splashSettingInfo = splashSettingInfo;
        this.$this_ActionModule = action;
        this.$toaster = toaster;
        this.$reportService = reportService;
        this.$coroutineScope = coroutineScope;
        this.$splashSettingNoticeDialogService = dLCSplashSettingNoticeDialogService;
        this.$router = router;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SplashSettingActionModule$provide$1$1(this.$splashSettingInfo, this.$this_ActionModule, this.$toaster, this.$reportService, this.$coroutineScope, this.$splashSettingNoticeDialogService, this.$router, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object invoke;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                invoke = this.$splashSettingInfo.invoke(this.$this_ActionModule.getData().getActivityId(), this.$this_ActionModule.getData().getCardTypeId(), KDevice.INSTANCE.getScreenDimensions().getWidth(), KDevice.INSTANCE.getScreenDimensions().getHeight(), (Continuation) this);
                if (invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                invoke = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Object infoResult = KApiResponseKt.asResult((KApiResponse) invoke);
        if (Result.isSuccess-impl(infoResult)) {
            DLCSplashCardInfo dLCSplashCardInfo = (DLCSplashCardInfo) (Result.isFailure-impl(infoResult) ? null : infoResult);
            String cardInfoJson = dLCSplashCardInfo != null ? dLCSplashCardInfo.resultJsonString() : null;
            String str = cardInfoJson;
            if (str != null && !StringsKt.isBlank(str)) {
                z = false;
            }
            if (z) {
                Toaster.-CC.showToast$default(this.$toaster, "请稍后再试", (ToastDuration) null, 2, (Object) null);
                return Unit.INSTANCE;
            }
            Object result = AddCustomSplash_androidKt.getAddCustomSplash().m1014invokeIoAF18A(cardInfoJson);
            ReportService reportService = this.$reportService;
            Action<SplashSettingAction> action = this.$this_ActionModule;
            Toaster toaster = this.$toaster;
            CoroutineScope coroutineScope = this.$coroutineScope;
            Toaster toaster2 = this.$toaster;
            DLCSplashSettingNoticeDialogService dLCSplashSettingNoticeDialogService = this.$splashSettingNoticeDialogService;
            Router router = this.$router;
            Throwable e = Result.exceptionOrNull-impl(result);
            if (e == null) {
                Unit unit = (Unit) result;
                reportService.report("sqzz.dressing.single-card.screen-set.click", MapsKt.mapOf(TuplesKt.to("dlc_id", String.valueOf(action.getData().getCardTypeId()))));
                Toaster.-CC.showToast$default(toaster, "设置成功", (ToastDuration) null, 2, (Object) null);
            } else if (e instanceof BrandsOverflowException) {
                BuildersKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new SplashSettingActionModule$provide$1$1$2$1(dLCSplashSettingNoticeDialogService, cardInfoJson, router, null), 3, (Object) null);
            } else if (e instanceof RepeatAdditionException) {
                Toaster.-CC.showToast$default(toaster2, "请勿重复设置", (ToastDuration) null, 2, (Object) null);
            } else {
                Toaster.-CC.showToast$default(toaster2, "请稍后再试", (ToastDuration) null, 2, (Object) null);
            }
        } else {
            Toaster.-CC.showToast$default(this.$toaster, "请稍后再试", (ToastDuration) null, 2, (Object) null);
        }
        return Unit.INSTANCE;
    }
}