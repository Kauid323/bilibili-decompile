package kntr.app.mall.product.details.page.ui.floatingLayer;

import androidx.compose.runtime.MutableState;
import kntr.app.mall.product.details.page.api.LiveInfoApiService;
import kntr.app.mall.product.details.page.utils.DateFormatKt;
import kntr.app.mall.product.details.page.vm.PageViewModel;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.watch.later.watchlater.edit.MediaAttrUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LotteryDashFloatingLayer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.app.mall.product.details.page.ui.floatingLayer.LotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1", f = "LotteryDashFloatingLayer.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {119}, m = "invokeSuspend", n = {"activityInfo", "userActivityInfo", "status", "publishTime", "nowSec", "countDownText", "isSubmitted", "diff"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "J$0"}, v = 1)
public final class LotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<LotteryDashDisplayState> $displayState$delegate;
    final /* synthetic */ LiveInfoApiService.LiveInfoData $liveInfoData;
    final /* synthetic */ PageViewModel $pageViewModel;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1(LiveInfoApiService.LiveInfoData liveInfoData, PageViewModel pageViewModel, MutableState<LotteryDashDisplayState> mutableState, Continuation<? super LotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1> continuation) {
        super(2, continuation);
        this.$liveInfoData = liveInfoData;
        this.$pageViewModel = pageViewModel;
        this.$displayState$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1(this.$liveInfoData, this.$pageViewModel, this.$displayState$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00e5  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x010c -> B:27:0x0118). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        boolean isSubmitted;
        LotteryDashDisplayState calculateDisplayState;
        LotteryDashDisplayState calculateDisplayState2;
        LiveInfoApiService.LiveInfoData.LotteryDash.ActivityInfo activityInfo;
        LiveInfoApiService.LiveInfoData.LotteryDash.UserActivityInfo userActivityInfo;
        String status;
        LotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1 lotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1;
        Object obj;
        Integer publishTime;
        Function0 nowSec;
        long diff;
        LotteryDashDisplayState calculateDisplayState3;
        LotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1 lotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$12;
        boolean isSubmitted2;
        LiveInfoApiService.LiveInfoData.LotteryDash.ActivityInfo activityInfo2;
        LiveInfoApiService.LiveInfoData.LotteryDash.UserActivityInfo userActivityInfo2;
        String status2;
        Integer publishTime2;
        Function0 nowSec2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                LiveInfoApiService.LiveInfoData.LotteryDash.ActivityInfo activityInfo3 = this.$liveInfoData.getLotteryDash().getActivityInfo();
                LiveInfoApiService.LiveInfoData.LotteryDash.UserActivityInfo userActivityInfo3 = this.$liveInfoData.getLotteryDash().getUserActivityInfo();
                isSubmitted = Intrinsics.areEqual(activityInfo3.isSubmitted(), Boxing.boxBoolean(true));
                String status3 = activityInfo3.getTaskStatus();
                Integer publishTime3 = activityInfo3.getPublishTime();
                if (!Intrinsics.areEqual(status3, "end") || isSubmitted) {
                    MutableState<LotteryDashDisplayState> mutableState = this.$displayState$delegate;
                    calculateDisplayState = LotteryDashFloatingLayerKt.calculateDisplayState(activityInfo3, userActivityInfo3, "");
                    mutableState.setValue(calculateDisplayState);
                }
                if (Intrinsics.areEqual(status3, "end") && !isSubmitted) {
                    Function0 nowSec3 = new Function0() { // from class: kntr.app.mall.product.details.page.ui.floatingLayer.LotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1$$ExternalSyntheticLambda0
                        public final Object invoke() {
                            long invokeSuspend$lambda$0;
                            invokeSuspend$lambda$0 = LotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1.invokeSuspend$lambda$0();
                            return Long.valueOf(invokeSuspend$lambda$0);
                        }
                    };
                    if (publishTime3 == null || publishTime3.intValue() <= ((Number) nowSec3.invoke()).longValue()) {
                        this.$pageViewModel.reloadProductDetails$product_details_page_debug();
                        return Unit.INSTANCE;
                    }
                    activityInfo = activityInfo3;
                    userActivityInfo = userActivityInfo3;
                    status = status3;
                    lotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1 = this;
                    obj = coroutine_suspended;
                    publishTime = publishTime3;
                    nowSec = nowSec3;
                    diff = RangesKt.coerceAtLeast(publishTime.intValue() - ((Number) nowSec.invoke()).longValue(), 0L);
                    String countDownText = LotteryDashFloatingLayerKt.formatDiffSeconds((int) diff);
                    MutableState<LotteryDashDisplayState> mutableState2 = lotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1.$displayState$delegate;
                    calculateDisplayState3 = LotteryDashFloatingLayerKt.calculateDisplayState(activityInfo, userActivityInfo, countDownText);
                    mutableState2.setValue(calculateDisplayState3);
                    if (diff == 0) {
                        lotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1.$pageViewModel.reloadProductDetails$product_details_page_debug();
                        return Unit.INSTANCE;
                    }
                    lotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1.L$0 = activityInfo;
                    lotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1.L$1 = userActivityInfo;
                    lotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1.L$2 = SpillingKt.nullOutSpilledVariable(status);
                    lotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1.L$3 = publishTime;
                    lotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1.L$4 = nowSec;
                    lotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1.L$5 = SpillingKt.nullOutSpilledVariable(countDownText);
                    lotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1.Z$0 = isSubmitted;
                    lotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1.J$0 = diff;
                    lotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1.label = 1;
                    if (DelayKt.delay(300L, (Continuation) lotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1) == obj) {
                        return obj;
                    }
                    lotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$12 = lotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1;
                    isSubmitted2 = isSubmitted;
                    activityInfo2 = activityInfo;
                    userActivityInfo2 = userActivityInfo;
                    status2 = status;
                    publishTime2 = publishTime;
                    nowSec2 = nowSec;
                    lotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1 = lotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$12;
                    isSubmitted = isSubmitted2;
                    nowSec = nowSec2;
                    publishTime = publishTime2;
                    status = status2;
                    userActivityInfo = userActivityInfo2;
                    activityInfo = activityInfo2;
                    diff = RangesKt.coerceAtLeast(publishTime.intValue() - ((Number) nowSec.invoke()).longValue(), 0L);
                    String countDownText2 = LotteryDashFloatingLayerKt.formatDiffSeconds((int) diff);
                    MutableState<LotteryDashDisplayState> mutableState22 = lotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1.$displayState$delegate;
                    calculateDisplayState3 = LotteryDashFloatingLayerKt.calculateDisplayState(activityInfo, userActivityInfo, countDownText2);
                    mutableState22.setValue(calculateDisplayState3);
                    if (diff == 0) {
                    }
                } else {
                    MutableState<LotteryDashDisplayState> mutableState3 = this.$displayState$delegate;
                    calculateDisplayState2 = LotteryDashFloatingLayerKt.calculateDisplayState(activityInfo3, userActivityInfo3, "");
                    mutableState3.setValue(calculateDisplayState2);
                    return Unit.INSTANCE;
                }
                break;
            case 1:
                long j = this.J$0;
                boolean isSubmitted3 = this.Z$0;
                String str = (String) this.L$5;
                ResultKt.throwOnFailure($result);
                lotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$12 = this;
                activityInfo2 = (LiveInfoApiService.LiveInfoData.LotteryDash.ActivityInfo) this.L$0;
                userActivityInfo2 = (LiveInfoApiService.LiveInfoData.LotteryDash.UserActivityInfo) this.L$1;
                status2 = (String) this.L$2;
                publishTime2 = (Integer) this.L$3;
                nowSec2 = (Function0) this.L$4;
                isSubmitted2 = isSubmitted3;
                obj = coroutine_suspended;
                lotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1 = lotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$12;
                isSubmitted = isSubmitted2;
                nowSec = nowSec2;
                publishTime = publishTime2;
                status = status2;
                userActivityInfo = userActivityInfo2;
                activityInfo = activityInfo2;
                diff = RangesKt.coerceAtLeast(publishTime.intValue() - ((Number) nowSec.invoke()).longValue(), 0L);
                String countDownText22 = LotteryDashFloatingLayerKt.formatDiffSeconds((int) diff);
                MutableState<LotteryDashDisplayState> mutableState222 = lotteryDashFloatingLayerKt$LotteryDashFloatingLayer$3$1.$displayState$delegate;
                calculateDisplayState3 = LotteryDashFloatingLayerKt.calculateDisplayState(activityInfo, userActivityInfo, countDownText22);
                mutableState222.setValue(calculateDisplayState3);
                if (diff == 0) {
                }
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long invokeSuspend$lambda$0() {
        return DateFormatKt.getCurrentTimeMillis() / ((long) MediaAttrUtils.TYPE_PAY_SEASON);
    }
}