package tv.danmaku.bili.push.pushsetting.manager;

import com.bilibili.lib.biliid.api.BuvidHelper;
import com.bilibili.lib.coroutineextension.BiliCallExtKt;
import com.bilibili.okretro.ServiceGenerator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.push.pushsetting.service.PushSettingService;

/* compiled from: PushGuidanceManager.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@DebugMetadata(c = "tv.danmaku.bili.push.pushsetting.manager.PushGuidanceManagerKt$clearServerPushGuidanceHistory$1", f = "PushGuidanceManager.kt", i = {1, 1}, l = {BR.height, BR.imageBadge, BR.indexTitleColor}, m = "invokeSuspend", n = {"localBuvid", "index"}, s = {"L$0", "I$0"}, v = 1)
final class PushGuidanceManagerKt$clearServerPushGuidanceHistory$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PushGuidanceManagerKt$clearServerPushGuidanceHistory$1(Continuation<? super PushGuidanceManagerKt$clearServerPushGuidanceHistory$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PushGuidanceManagerKt$clearServerPushGuidanceHistory$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b0  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0097 -> B:20:0x009a). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        PushGuidanceManagerKt$clearServerPushGuidanceHistory$1 pushGuidanceManagerKt$clearServerPushGuidanceHistory$1;
        String localBuvid;
        int index;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                if (BiliCallExtKt.getResult(((PushSettingService) ServiceGenerator.createService(PushSettingService.class)).reportAppFirstStart(1), (Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                String localBuvid2 = BuvidHelper.getLocalBuvid();
                BLog.i("[Push]NotificationGuidanceManager", "clearHistory remote:" + BuvidHelper.getRemoteBuvid() + " Buvid:" + BuvidHelper.getLocalBuvid());
                pushGuidanceManagerKt$clearServerPushGuidanceHistory$1 = this;
                localBuvid = localBuvid2;
                index = 0;
                if (!StringsKt.isBlank(BuvidHelper.getRemoteBuvid()) && index < 100) {
                    pushGuidanceManagerKt$clearServerPushGuidanceHistory$1.L$0 = localBuvid;
                    pushGuidanceManagerKt$clearServerPushGuidanceHistory$1.I$0 = index;
                    pushGuidanceManagerKt$clearServerPushGuidanceHistory$1.label = 2;
                    if (DelayKt.delay(200L, (Continuation) pushGuidanceManagerKt$clearServerPushGuidanceHistory$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    index++;
                    if (!StringsKt.isBlank(BuvidHelper.getRemoteBuvid())) {
                    }
                    if (!StringsKt.isBlank(BuvidHelper.getRemoteBuvid())) {
                    }
                } else if (!StringsKt.isBlank(BuvidHelper.getRemoteBuvid())) {
                    BLog.i("[Push]NotificationGuidanceManager", "get remote buvid timeout");
                    return Unit.INSTANCE;
                } else if (Intrinsics.areEqual(localBuvid, BuvidHelper.getRemoteBuvid())) {
                    BLog.i("[Push]NotificationGuidanceManager", "buvid not change");
                    return Unit.INSTANCE;
                } else {
                    BLog.i("[Push]NotificationGuidanceManager", "clear history remoteBuvid " + BuvidHelper.getRemoteBuvid());
                    pushGuidanceManagerKt$clearServerPushGuidanceHistory$1.L$0 = null;
                    pushGuidanceManagerKt$clearServerPushGuidanceHistory$1.label = 3;
                    if (BiliCallExtKt.getResult(((PushSettingService) ServiceGenerator.createService(PushSettingService.class)).reportAppFirstStart(1), (Continuation) pushGuidanceManagerKt$clearServerPushGuidanceHistory$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                String localBuvid22 = BuvidHelper.getLocalBuvid();
                BLog.i("[Push]NotificationGuidanceManager", "clearHistory remote:" + BuvidHelper.getRemoteBuvid() + " Buvid:" + BuvidHelper.getLocalBuvid());
                pushGuidanceManagerKt$clearServerPushGuidanceHistory$1 = this;
                localBuvid = localBuvid22;
                index = 0;
                if (!StringsKt.isBlank(BuvidHelper.getRemoteBuvid())) {
                }
                if (!StringsKt.isBlank(BuvidHelper.getRemoteBuvid())) {
                }
                break;
            case 2:
                index = this.I$0;
                localBuvid = (String) this.L$0;
                ResultKt.throwOnFailure($result);
                pushGuidanceManagerKt$clearServerPushGuidanceHistory$1 = this;
                index++;
                if (!StringsKt.isBlank(BuvidHelper.getRemoteBuvid())) {
                }
                if (!StringsKt.isBlank(BuvidHelper.getRemoteBuvid())) {
                }
                break;
            case 3:
                ResultKt.throwOnFailure($result);
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}