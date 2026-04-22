package kntr.common.behavior.prediction.predictor;

import com.bapis.bilibili.app.mine.v1.KDeviceFeatureReq;
import com.bapis.bilibili.app.mine.v1.KDeviceFeatureResp;
import com.bapis.bilibili.app.mine.v1.KMineMoss;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.moss.api.KCallOptions;
import kntr.common.behavior.prediction.KBehaviorPredictor;
import kntr.common.behavior.prediction.impl.UtilsKt;
import kntr.common.behavior.prediction.model.VideoQualityDeviceBehaviorData;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoQualityPredictor.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@DebugMetadata(c = "kntr.common.behavior.prediction.predictor.DeviceFeatureFetcher$fetch$1", f = "VideoQualityPredictor.kt", i = {0, 0, 0, 0}, l = {727}, m = "invokeSuspend", n = {"$this$launch", "tag", "$this$invokeSuspend_u24lambda_u240", "$i$a$-runCatching-DeviceFeatureFetcher$fetch$1$1"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
public final class DeviceFeatureFetcher$fetch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeviceFeatureFetcher$fetch$1(Continuation<? super DeviceFeatureFetcher$fetch$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> deviceFeatureFetcher$fetch$1 = new DeviceFeatureFetcher$fetch$1(continuation);
        deviceFeatureFetcher$fetch$1.L$0 = obj;
        return deviceFeatureFetcher$fetch$1;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object m2636constructorimpl;
        String tag;
        Object deviceFeature;
        CoroutineScope $this$launch = (CoroutineScope) this.L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    tag = "DeviceFeatureFetcher";
                    UtilsKt.logI("DeviceFeatureFetcher", "fetch start.");
                    Result.Companion companion = Result.Companion;
                    KMineMoss kMineMoss = new KMineMoss((KCallOptions) null, 1, (DefaultConstructorMarker) null);
                    KDeviceFeatureReq kDeviceFeatureReq = new KDeviceFeatureReq();
                    this.L$0 = SpillingKt.nullOutSpilledVariable($this$launch);
                    this.L$1 = "DeviceFeatureFetcher";
                    this.L$2 = SpillingKt.nullOutSpilledVariable($this$launch);
                    this.I$0 = 0;
                    this.label = 1;
                    deviceFeature = kMineMoss.deviceFeature(kDeviceFeatureReq, this);
                    if (deviceFeature != coroutine_suspended) {
                        break;
                    } else {
                        return coroutine_suspended;
                    }
                case 1:
                    int i = this.I$0;
                    CoroutineScope coroutineScope = (CoroutineScope) this.L$2;
                    tag = (String) this.L$1;
                    ResultKt.throwOnFailure($result);
                    deviceFeature = $result;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String actionData = ((KDeviceFeatureResp) deviceFeature).getActionData();
            UtilsKt.logI(tag, "fetch end, action data length = " + actionData.length() + ".");
            KBehaviorPredictor.INSTANCE.update(new VideoQualityDeviceBehaviorData(null, actionData, false, 1, null));
            m2636constructorimpl = Result.m2636constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m2636constructorimpl = Result.m2636constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m2639exceptionOrNullimpl(m2636constructorimpl) != null) {
            UtilsKt.logE(tag, "fetch end, has network error.");
        }
        return Unit.INSTANCE;
    }
}