package kntr.app.mall.product.details.page.vm;

import kntr.app.mall.product.details.page.api.LiveInfoApiService;
import kntr.app.mall.product.details.page.utils.DateFormatKt;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.log.KLog_androidKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PageViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.vm.PageViewModel$fetchDataSuccessAfter$1", f = "PageViewModel.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {708, 722}, m = "invokeSuspend", n = {"$this$launch", "liveInfoDeferred", "$this$launch", "liveInfoDeferred", "liveInfoResponse", "lotteryDash", "activityInfo", "status", "publishTime", "isSubmitted", "nowSec"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "J$0"}, v = 1)
public final class PageViewModel$fetchDataSuccessAfter$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    final /* synthetic */ PageViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageViewModel$fetchDataSuccessAfter$1(PageViewModel pageViewModel, Continuation<? super PageViewModel$fetchDataSuccessAfter$1> continuation) {
        super(2, continuation);
        this.this$0 = pageViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> pageViewModel$fetchDataSuccessAfter$1 = new PageViewModel$fetchDataSuccessAfter$1(this.this$0, continuation);
        pageViewModel$fetchDataSuccessAfter$1.L$0 = obj;
        return pageViewModel$fetchDataSuccessAfter$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0095 A[Catch: Exception -> 0x015b, TryCatch #0 {Exception -> 0x015b, blocks: (B:7:0x0036, B:46:0x0155, B:10:0x003f, B:16:0x0074, B:17:0x007d, B:19:0x008f, B:21:0x0095, B:25:0x009e, B:29:0x00a7, B:32:0x00b7, B:35:0x00bf, B:36:0x00c3, B:40:0x00d0, B:42:0x00e1, B:13:0x0049), top: B:57:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009e A[Catch: Exception -> 0x015b, TryCatch #0 {Exception -> 0x015b, blocks: (B:7:0x0036, B:46:0x0155, B:10:0x003f, B:16:0x0074, B:17:0x007d, B:19:0x008f, B:21:0x0095, B:25:0x009e, B:29:0x00a7, B:32:0x00b7, B:35:0x00bf, B:36:0x00c3, B:40:0x00d0, B:42:0x00e1, B:13:0x0049), top: B:57:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7 A[Catch: Exception -> 0x015b, TryCatch #0 {Exception -> 0x015b, blocks: (B:7:0x0036, B:46:0x0155, B:10:0x003f, B:16:0x0074, B:17:0x007d, B:19:0x008f, B:21:0x0095, B:25:0x009e, B:29:0x00a7, B:32:0x00b7, B:35:0x00bf, B:36:0x00c3, B:40:0x00d0, B:42:0x00e1, B:13:0x0049), top: B:57:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b7 A[Catch: Exception -> 0x015b, TryCatch #0 {Exception -> 0x015b, blocks: (B:7:0x0036, B:46:0x0155, B:10:0x003f, B:16:0x0074, B:17:0x007d, B:19:0x008f, B:21:0x0095, B:25:0x009e, B:29:0x00a7, B:32:0x00b7, B:35:0x00bf, B:36:0x00c3, B:40:0x00d0, B:42:0x00e1, B:13:0x0049), top: B:57:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bf A[Catch: Exception -> 0x015b, TryCatch #0 {Exception -> 0x015b, blocks: (B:7:0x0036, B:46:0x0155, B:10:0x003f, B:16:0x0074, B:17:0x007d, B:19:0x008f, B:21:0x0095, B:25:0x009e, B:29:0x00a7, B:32:0x00b7, B:35:0x00bf, B:36:0x00c3, B:40:0x00d0, B:42:0x00e1, B:13:0x0049), top: B:57:0x000f }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e1 A[Catch: Exception -> 0x015b, TryCatch #0 {Exception -> 0x015b, blocks: (B:7:0x0036, B:46:0x0155, B:10:0x003f, B:16:0x0074, B:17:0x007d, B:19:0x008f, B:21:0x0095, B:25:0x009e, B:29:0x00a7, B:32:0x00b7, B:35:0x00bf, B:36:0x00c3, B:40:0x00d0, B:42:0x00e1, B:13:0x0049), top: B:57:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        MutableStateFlow $this$update$iv;
        Object prevValue$iv;
        String it;
        Deferred liveInfoDeferred;
        Object await;
        LiveInfoApiService.LiveInfoResponse liveInfoResponse;
        MutableStateFlow $this$update$iv2;
        Object prevValue$iv2;
        String status;
        Integer publishTime;
        long nowSec;
        CoroutineScope $this$launch = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Exception e) {
            $this$update$iv = this.this$0._errorState;
            do {
                prevValue$iv = $this$update$iv.getValue();
                String str = (String) prevValue$iv;
                String message = e.getMessage();
                if (message == null) {
                    message = "Failed to refresh live info";
                }
                it = message;
            } while (!$this$update$iv.compareAndSet(prevValue$iv, it));
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                liveInfoDeferred = BuildersKt.async$default($this$launch, (CoroutineContext) null, (CoroutineStart) null, new PageViewModel$fetchDataSuccessAfter$1$liveInfoDeferred$1(this.this$0, null), 3, (Object) null);
                this.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                this.L$1 = SpillingKt.nullOutSpilledVariable(liveInfoDeferred);
                this.label = 1;
                await = liveInfoDeferred.await((Continuation) this);
                if (await == coroutine_suspended) {
                    return coroutine_suspended;
                }
                liveInfoResponse = (LiveInfoApiService.LiveInfoResponse) await;
                $this$update$iv2 = this.this$0._liveApiResponse;
                do {
                    prevValue$iv2 = $this$update$iv2.getValue();
                    LiveInfoApiService.LiveInfoResponse liveInfoResponse2 = (LiveInfoApiService.LiveInfoResponse) prevValue$iv2;
                } while (!$this$update$iv2.compareAndSet(prevValue$iv2, liveInfoResponse));
                LiveInfoApiService.LiveInfoData data = liveInfoResponse.getData();
                LiveInfoApiService.LiveInfoData.LotteryDash lotteryDash = data == null ? data.getLotteryDash() : null;
                LiveInfoApiService.LiveInfoData.LotteryDash.ActivityInfo activityInfo = lotteryDash == null ? lotteryDash.getActivityInfo() : null;
                int areEqual = activityInfo == null ? Intrinsics.areEqual(activityInfo.isSubmitted(), Boxing.boxBoolean(true)) : 0;
                status = activityInfo == null ? activityInfo.getTaskStatus() : null;
                publishTime = activityInfo != null ? activityInfo.getPublishTime() : null;
                if (Intrinsics.areEqual(status, "end") && areEqual == 0 && publishTime != null) {
                    nowSec = DateFormatKt.getCurrentTimeMillis() / ((long) MediaAttrUtils.TYPE_PAY_SEASON);
                    if (publishTime.intValue() <= nowSec) {
                        KLog_androidKt.getKLog().e("manlu", "检测到抽签购倒计时结束，publishTime: " + publishTime + ", nowSec: " + nowSec + "，准备重新请求接口");
                        this.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(liveInfoDeferred);
                        this.L$2 = SpillingKt.nullOutSpilledVariable(liveInfoResponse);
                        this.L$3 = SpillingKt.nullOutSpilledVariable(lotteryDash);
                        this.L$4 = SpillingKt.nullOutSpilledVariable(activityInfo);
                        this.L$5 = SpillingKt.nullOutSpilledVariable(status);
                        this.L$6 = SpillingKt.nullOutSpilledVariable(publishTime);
                        this.I$0 = areEqual;
                        this.J$0 = nowSec;
                        this.label = 2;
                        if (DelayKt.delay(200L, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        this.this$0.reloadProductDetails$product_details_page_debug();
                    }
                }
                return Unit.INSTANCE;
            case 1:
                liveInfoDeferred = (Deferred) this.L$1;
                ResultKt.throwOnFailure($result);
                await = $result;
                liveInfoResponse = (LiveInfoApiService.LiveInfoResponse) await;
                $this$update$iv2 = this.this$0._liveApiResponse;
                do {
                    prevValue$iv2 = $this$update$iv2.getValue();
                    LiveInfoApiService.LiveInfoResponse liveInfoResponse22 = (LiveInfoApiService.LiveInfoResponse) prevValue$iv2;
                } while (!$this$update$iv2.compareAndSet(prevValue$iv2, liveInfoResponse));
                LiveInfoApiService.LiveInfoData data2 = liveInfoResponse.getData();
                LiveInfoApiService.LiveInfoData.LotteryDash lotteryDash2 = data2 == null ? data2.getLotteryDash() : null;
                LiveInfoApiService.LiveInfoData.LotteryDash.ActivityInfo activityInfo2 = lotteryDash2 == null ? lotteryDash2.getActivityInfo() : null;
                if (activityInfo2 == null) {
                }
                if (activityInfo2 == null) {
                }
                publishTime = activityInfo2 != null ? activityInfo2.getPublishTime() : null;
                if (Intrinsics.areEqual(status, "end")) {
                    nowSec = DateFormatKt.getCurrentTimeMillis() / ((long) MediaAttrUtils.TYPE_PAY_SEASON);
                    if (publishTime.intValue() <= nowSec) {
                    }
                }
                return Unit.INSTANCE;
            case 2:
                long j = this.J$0;
                int i = this.I$0;
                Integer num = (Integer) this.L$6;
                String str2 = (String) this.L$5;
                LiveInfoApiService.LiveInfoData.LotteryDash.ActivityInfo activityInfo3 = (LiveInfoApiService.LiveInfoData.LotteryDash.ActivityInfo) this.L$4;
                LiveInfoApiService.LiveInfoData.LotteryDash lotteryDash3 = (LiveInfoApiService.LiveInfoData.LotteryDash) this.L$3;
                LiveInfoApiService.LiveInfoResponse liveInfoResponse3 = (LiveInfoApiService.LiveInfoResponse) this.L$2;
                Deferred deferred = (Deferred) this.L$1;
                ResultKt.throwOnFailure($result);
                this.this$0.reloadProductDetails$product_details_page_debug();
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}