package tv.danmaku.bili.push.pushsetting.manufacturer;

import androidx.activity.ComponentActivity;
import com.bilibili.gripper.api.push.GNotificationPermissionCallback;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.BPushHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ManufacturerPushHelper.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Ltv/danmaku/bili/push/pushsetting/manufacturer/ManufacturerCallbackData;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.pushsetting.manufacturer.ManufacturerPushHelperKt$requestManufacturerDialogSuspend$2", f = "ManufacturerPushHelper.kt", i = {}, l = {BR.buttonBackground}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ManufacturerPushHelperKt$requestManufacturerDialogSuspend$2 extends SuspendLambda implements Function2<ProducerScope<? super ManufacturerCallbackData>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ComponentActivity $activity;
    final /* synthetic */ String $showFrom;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ManufacturerPushHelperKt$requestManufacturerDialogSuspend$2(ComponentActivity componentActivity, String str, Continuation<? super ManufacturerPushHelperKt$requestManufacturerDialogSuspend$2> continuation) {
        super(2, continuation);
        this.$activity = componentActivity;
        this.$showFrom = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> manufacturerPushHelperKt$requestManufacturerDialogSuspend$2 = new ManufacturerPushHelperKt$requestManufacturerDialogSuspend$2(this.$activity, this.$showFrom, continuation);
        manufacturerPushHelperKt$requestManufacturerDialogSuspend$2.L$0 = obj;
        return manufacturerPushHelperKt$requestManufacturerDialogSuspend$2;
    }

    public final Object invoke(ProducerScope<? super ManufacturerCallbackData> producerScope, Continuation<? super Unit> continuation) {
        return create(producerScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                final ProducerScope $this$callbackFlow = (ProducerScope) this.L$0;
                BLog.i("[Push]ManufacturerPushHelper", "requestManufacturerDialogSuspend, start");
                ManufacturerPushHelperKt.setLastRequestManufacturerPushTimestamp(System.currentTimeMillis());
                ManufacturerPushHelperKt.setTotalRequestManufacturerPushCount(ManufacturerPushHelperKt.getTotalRequestManufacturerPushCount() + 1);
                ComponentActivity componentActivity = this.$activity;
                final String str = this.$showFrom;
                try {
                    Result.Companion companion = Result.Companion;
                    BPushHelper.requestNotificationPermission(componentActivity, 1000, new GNotificationPermissionCallback() { // from class: tv.danmaku.bili.push.pushsetting.manufacturer.ManufacturerPushHelperKt$requestManufacturerDialogSuspend$2$1$1
                        public void onResult(boolean success, int pushType, boolean hasShow, int code, String msg) {
                            BLog.i("[Push]ManufacturerPushHelper", "requestManufacturerDialog, success = " + success + ", pushType = " + pushType + ",hasShow = " + hasShow + " code = " + code);
                            $this$callbackFlow.trySend-JP2dKIU(new ManufacturerCallbackData(hasShow, str, success, code, pushType));
                        }
                    });
                    obj = Result.constructor-impl(Unit.INSTANCE);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                String str2 = this.$showFrom;
                Throwable it = Result.exceptionOrNull-impl(obj);
                if (it != null) {
                    BLog.i("[Push]ManufacturerPushHelper", "requestManufacturerDialogSuspend, failure = " + it.getMessage());
                    $this$callbackFlow.trySend-JP2dKIU(new ManufacturerCallbackData(false, str2, false, -1, BPushHelper.currentPushType()));
                }
                this.label = 1;
                if (ProduceKt.awaitClose$default($this$callbackFlow, (Function0) null, (Continuation) this, 1, (Object) null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}