package tv.danmaku.bili.ui.personinfo.modifyNameV2;

import bili.resource.common.R;
import com.bapis.bilibili.account.interfaces.v1.UnameMessageReply;
import com.bilibili.lib.moss.api.BusinessException;
import com.bilibili.lib.moss.api.MossException;
import com.bilibili.lib.moss.api.NetworkException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.personinfo.api.PersonInfoMossApiService;
import tv.danmaku.bili.ui.personinfo.modifyNameV2.ModifyNameV2Event;
import tv.danmaku.bili.ui.personinfo.modifyNameV2.PageState;
import tv.danmaku.biliplayerv2.service.interact.biz.chronos.chronosrpc.methods.send.AddCustomDanmaku;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkCpuInfo;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ModifyNameViewModelV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.personinfo.modifyNameV2.ModifyNameViewModelV2$getNickNameCopyWrite$1", f = "ModifyNameViewModelV2.kt", i = {}, l = {IjkCpuInfo.CPU_IMPL_ARM_LIMITED, AddCustomDanmaku.TYPE_LIVE_DANMU_V2, 112}, m = "invokeSuspend", n = {}, s = {}, v = 1)
public final class ModifyNameViewModelV2$getNickNameCopyWrite$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ModifyNameViewModelV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModifyNameViewModelV2$getNickNameCopyWrite$1(ModifyNameViewModelV2 modifyNameViewModelV2, Continuation<? super ModifyNameViewModelV2$getNickNameCopyWrite$1> continuation) {
        super(2, continuation);
        this.this$0 = modifyNameViewModelV2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ModifyNameViewModelV2$getNickNameCopyWrite$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003f A[Catch: MossException -> 0x00ee, TryCatch #0 {MossException -> 0x00ee, blocks: (B:17:0x003b, B:19:0x003f, B:20:0x0089, B:22:0x00a2, B:23:0x00c8), top: B:45:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a2 A[Catch: MossException -> 0x00ee, TryCatch #0 {MossException -> 0x00ee, blocks: (B:17:0x003b, B:19:0x003f, B:20:0x0089, B:22:0x00a2, B:23:0x00c8), top: B:45:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c8 A[Catch: MossException -> 0x00ee, TRY_LEAVE, TryCatch #0 {MossException -> 0x00ee, blocks: (B:17:0x003b, B:19:0x003f, B:20:0x0089, B:22:0x00a2, B:23:0x00c8), top: B:45:0x003b }] */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v10, types: [com.bapis.bilibili.account.interfaces.v1.UnameMessageReply] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        MutableStateFlow mutableStateFlow;
        MutableStateFlow mutableStateFlow2;
        UnameMessageBean unameMessageBean;
        MutableSharedFlow mutableSharedFlow;
        MutableSharedFlow mutableSharedFlow2;
        Object $result2;
        Object $result3;
        Object $result4;
        Object $result5;
        MutableStateFlow mutableStateFlow3;
        UnameMessageBean unameMessageBean2;
        MutableStateFlow mutableStateFlow4;
        UnameMessageBean unameMessageBean3;
        MutableStateFlow mutableStateFlow5;
        UnameMessageBean unameMessageBean4;
        UnameMessageBean $this$invokeSuspend_u24lambda_u240_u240;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (MossException e) {
            e = e;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure((Object) $result);
                this.label = 1;
                Object nameMessage = PersonInfoMossApiService.INSTANCE.getNameMessage((Continuation) this);
                if (nameMessage == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result4 = $result;
                $result5 = nameMessage;
                try {
                    $result = (UnameMessageReply) $result5;
                    if ($result != 0) {
                        $this$invokeSuspend_u24lambda_u240_u240 = this.this$0.unameMsg;
                        $this$invokeSuspend_u24lambda_u240_u240.setAllow($result.getAllow());
                        $this$invokeSuspend_u24lambda_u240_u240.setRealNameOrTel($result.getRealnameOrTel());
                        String unameMessage = $result.getUnameMessage();
                        Intrinsics.checkNotNullExpressionValue(unameMessage, "getUnameMessage(...)");
                        $this$invokeSuspend_u24lambda_u240_u240.setUMsg(unameMessage);
                        String confirmMessage = $result.getConfirmMessage();
                        Intrinsics.checkNotNullExpressionValue(confirmMessage, "getConfirmMessage(...)");
                        $this$invokeSuspend_u24lambda_u240_u240.setConfirmMessage(confirmMessage);
                        String conditionMessage = $result.getConditionMessage();
                        Intrinsics.checkNotNullExpressionValue(conditionMessage, "getConditionMessage(...)");
                        $this$invokeSuspend_u24lambda_u240_u240.setConditionMessage(conditionMessage);
                        String bindTel = $result.getBindTel();
                        Intrinsics.checkNotNullExpressionValue(bindTel, "getBindTel(...)");
                        $this$invokeSuspend_u24lambda_u240_u240.setBindTel(bindTel);
                    }
                    mutableStateFlow3 = this.this$0._stateFlow;
                    ViewState currentState = (ViewState) mutableStateFlow3.getValue();
                    unameMessageBean2 = this.this$0.unameMsg;
                    if (unameMessageBean2.getAllow()) {
                        mutableStateFlow4 = this.this$0._stateFlow;
                        EditState editState = currentState.getEditState();
                        unameMessageBean3 = this.this$0.unameMsg;
                        mutableStateFlow4.setValue(currentState.copy(PageState.ShowEditState.INSTANCE, editState.copy(unameMessageBean3.getUMsg(), false)));
                    } else {
                        mutableStateFlow5 = this.this$0._stateFlow;
                        EditState editState2 = currentState.getEditState();
                        unameMessageBean4 = this.this$0.unameMsg;
                        mutableStateFlow5.setValue(currentState.copy(PageState.ShowEditState.INSTANCE, editState2.copy(unameMessageBean4.getUMsg(), true)));
                    }
                } catch (MossException e2) {
                    Object obj = $result4;
                    e = e2;
                    $result = obj;
                    BLog.e("ModifyNameViewModel", "getNameMessage request throwable " + e);
                    mutableStateFlow = this.this$0._stateFlow;
                    ViewState currentState2 = (ViewState) mutableStateFlow.getValue();
                    mutableStateFlow2 = this.this$0._stateFlow;
                    EditState editState3 = currentState2.getEditState();
                    unameMessageBean = this.this$0.unameMsg;
                    mutableStateFlow2.setValue(currentState2.copy(PageState.ShowEditState.INSTANCE, editState3.copy(unameMessageBean.getUMsg(), false)));
                    if (e instanceof BusinessException) {
                        String it = e.getMessage();
                        $result3 = $result;
                        if (it != null) {
                            mutableSharedFlow2 = this.this$0._eventFlow;
                            ModifyNameV2Event.ShowToast showToast = new ModifyNameV2Event.ShowToast(it);
                            this.label = 2;
                            if (mutableSharedFlow2.emit(showToast, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            $result2 = $result;
                            return Unit.INSTANCE;
                        }
                    } else {
                        $result3 = $result;
                        if (e instanceof NetworkException) {
                            mutableSharedFlow = this.this$0._eventFlow;
                            this.label = 3;
                            $result3 = $result;
                            if (mutableSharedFlow.emit(new ModifyNameV2Event.ShowToast(Boxing.boxInt(R.string.common_global_string_186)), (Continuation) this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    }
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure((Object) $result);
                $result4 = $result;
                $result5 = $result;
                $result = (UnameMessageReply) $result5;
                if ($result != 0) {
                }
                mutableStateFlow3 = this.this$0._stateFlow;
                ViewState currentState3 = (ViewState) mutableStateFlow3.getValue();
                unameMessageBean2 = this.this$0.unameMsg;
                if (unameMessageBean2.getAllow()) {
                }
                return Unit.INSTANCE;
            case 2:
                ResultKt.throwOnFailure((Object) $result);
                $result2 = $result;
                return Unit.INSTANCE;
            case 3:
                ResultKt.throwOnFailure((Object) $result);
                $result3 = $result;
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}