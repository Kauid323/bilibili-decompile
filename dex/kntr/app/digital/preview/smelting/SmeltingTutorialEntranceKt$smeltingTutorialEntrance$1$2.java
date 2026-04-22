package kntr.app.digital.preview.smelting;

import androidx.compose.runtime.MutableState;
import com.bilibili.ktor.KApiResponse;
import kntr.app.digital.preview.smelting.State;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.common.compose.launcher.LocalToasterKt;
import kntr.common.komponent.KomponentLocalAccessScope;
import kntr.common.komponent.KomponentScope;
import kntr.common.komponent.LocalOnFinishKt;
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

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SmeltingTutorialEntrance.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", RoomRecommendViewModel.EMPTY_CURSOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "kntr.app.digital.preview.smelting.SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$2", f = "SmeltingTutorialEntrance.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<State> $state$delegate;
    final /* synthetic */ KomponentScope<Unit> $this_Komponent;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$2(MutableState<State> mutableState, KomponentScope<? super Unit> komponentScope, Continuation<? super SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$2> continuation) {
        super(2, continuation);
        this.$state$delegate = mutableState;
        this.$this_Komponent = komponentScope;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SmeltingTutorialEntranceKt$smeltingTutorialEntrance$1$2(this.$state$delegate, this.$this_Komponent, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object smeltingTutorialEntrance$lambda$0$getSmeltingTutorialInfo;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                this.label = 1;
                smeltingTutorialEntrance$lambda$0$getSmeltingTutorialInfo = SmeltingTutorialEntranceKt.smeltingTutorialEntrance$lambda$0$getSmeltingTutorialInfo((Continuation) this);
                if (smeltingTutorialEntrance$lambda$0$getSmeltingTutorialInfo == coroutine_suspended) {
                    return coroutine_suspended;
                }
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                smeltingTutorialEntrance$lambda$0$getSmeltingTutorialInfo = $result;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        KApiResponse.BusinessFailure businessFailure = (KApiResponse) smeltingTutorialEntrance$lambda$0$getSmeltingTutorialInfo;
        MutableState<State> mutableState = this.$state$delegate;
        KomponentLocalAccessScope komponentLocalAccessScope = this.$this_Komponent;
        if (businessFailure instanceof KApiResponse.BusinessFailure) {
            int code = businessFailure.getCode();
            new IllegalStateException("code:" + code + ",message:" + businessFailure.getMessage());
            Toaster.-CC.showToast$default((Toaster) komponentLocalAccessScope.getCurrent(LocalToasterKt.getLocalToaster()), "加载失败，请重新尝试", (ToastDuration) null, 2, (Object) null);
            LocalOnFinishKt.getFinishHost(komponentLocalAccessScope).invoke();
        } else if (businessFailure instanceof KApiResponse.ServiceUnavailable) {
            ((KApiResponse.ServiceUnavailable) businessFailure).getException();
            Toaster.-CC.showToast$default((Toaster) komponentLocalAccessScope.getCurrent(LocalToasterKt.getLocalToaster()), "加载失败，请重新尝试", (ToastDuration) null, 2, (Object) null);
            LocalOnFinishKt.getFinishHost(komponentLocalAccessScope).invoke();
        } else if (!(businessFailure instanceof KApiResponse.Success)) {
            throw new NoWhenBranchMatchedException();
        } else {
            SmeltingTutorialInfo it = (SmeltingTutorialInfo) ((KApiResponse.Success) businessFailure).getData();
            mutableState.setValue(new State.Success(it.getTutorialItemInfoList()));
        }
        return Unit.INSTANCE;
    }
}