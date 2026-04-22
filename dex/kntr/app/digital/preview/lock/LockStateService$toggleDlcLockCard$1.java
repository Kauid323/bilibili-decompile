package kntr.app.digital.preview.lock;

import com.bilibili.ktor.KApiResponse;
import java.util.Map;
import kntr.app.digital.preview.api.CardData;
import kntr.app.digital.preview.card.CardBasic;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.trio.toast.ToastDuration;
import kntr.common.trio.toast.Toaster;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.serialization.json.JsonObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LockStateService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.digital.preview.lock.LockStateService$toggleDlcLockCard$1", f = "LockStateService.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class LockStateService$toggleDlcLockCard$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CardBasic $cardBasic;
    final /* synthetic */ JsonObject $json;
    final /* synthetic */ boolean $shouldLock;
    int label;
    final /* synthetic */ LockStateService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LockStateService$toggleDlcLockCard$1(LockStateService lockStateService, JsonObject jsonObject, CardBasic cardBasic, boolean z, Continuation<? super LockStateService$toggleDlcLockCard$1> continuation) {
        super(2, continuation);
        this.this$0 = lockStateService;
        this.$json = jsonObject;
        this.$cardBasic = cardBasic;
        this.$shouldLock = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LockStateService$toggleDlcLockCard$1(this.this$0, this.$json, this.$cardBasic, this.$shouldLock, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        ToggleLockCard toggleLockCard;
        Object invoke;
        Map map;
        Toaster toaster;
        Toaster toaster2;
        Toaster toaster3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                toggleLockCard = this.this$0.toggleLockCard;
                this.label = 1;
                invoke = toggleLockCard.invoke(this.$json, (Continuation) this);
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
        KApiResponse.BusinessFailure businessFailure = (KApiResponse) invoke;
        LockStateService lockStateService = this.this$0;
        CardBasic cardBasic = this.$cardBasic;
        boolean z = this.$shouldLock;
        LockStateService lockStateService2 = this.this$0;
        LockStateService lockStateService3 = this.this$0;
        if (businessFailure instanceof KApiResponse.BusinessFailure) {
            KApiResponse.BusinessFailure $this$invokeSuspend_u24lambda_u241 = businessFailure;
            toaster3 = lockStateService2.toaster;
            String message = $this$invokeSuspend_u24lambda_u241.getMessage();
            Toaster.-CC.showToast$default(toaster3, message != null ? message : "锁定失败，请重试", (ToastDuration) null, 2, (Object) null);
        } else if (businessFailure instanceof KApiResponse.ServiceUnavailable) {
            ((KApiResponse.ServiceUnavailable) businessFailure).getException();
            toaster2 = lockStateService3.toaster;
            Toaster.-CC.showToast$default(toaster2, "锁定失败，请重试", (ToastDuration) null, 2, (Object) null);
        } else if (businessFailure instanceof KApiResponse.Success) {
            Unit unit = (Unit) ((KApiResponse.Success) businessFailure).getData();
            map = lockStateService.lockStatusMap;
            map.put(cardBasic.getUniqueId(), z ? CardData.Data.CardLockStatus.LOCKED : CardData.Data.CardLockStatus.UNLOCKED);
            String toastText = z ? "锁定成功，卡牌将不可分解" : "解锁成功";
            toaster = lockStateService.toaster;
            Toaster.-CC.showToast$default(toaster, toastText, (ToastDuration) null, 2, (Object) null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return Unit.INSTANCE;
    }
}