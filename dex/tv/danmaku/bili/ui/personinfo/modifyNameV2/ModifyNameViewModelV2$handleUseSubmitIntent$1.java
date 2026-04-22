package tv.danmaku.bili.ui.personinfo.modifyNameV2;

import com.bapis.bilibili.account.interfaces.v1.UpdateNameReply;
import com.bilibili.lib.moss.api.BusinessException;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.ui.personinfo.api.PersonInfoMossApiService;
import tv.danmaku.bili.ui.personinfo.modifyNameV2.ModifyNameV2Event;
import tv.danmaku.bili.utils.PersonInfoReport;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ModifyNameViewModelV2.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@DebugMetadata(c = "tv.danmaku.bili.ui.personinfo.modifyNameV2.ModifyNameViewModelV2$handleUseSubmitIntent$1", f = "ModifyNameViewModelV2.kt", i = {1, 3, 4}, l = {145, 149, 154, 157, 164, 170}, m = "invokeSuspend", n = {"it", "it", "e"}, s = {"L$2", "L$2", "L$0"}, v = 1)
public final class ModifyNameViewModelV2$handleUseSubmitIntent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $from;
    final /* synthetic */ String $scene;
    final /* synthetic */ String $source;
    final /* synthetic */ String $uname;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ModifyNameViewModelV2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModifyNameViewModelV2$handleUseSubmitIntent$1(ModifyNameViewModelV2 modifyNameViewModelV2, String str, String str2, String str3, String str4, Continuation<? super ModifyNameViewModelV2$handleUseSubmitIntent$1> continuation) {
        super(2, continuation);
        this.this$0 = modifyNameViewModelV2;
        this.$uname = str;
        this.$source = str2;
        this.$from = str3;
        this.$scene = str4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ModifyNameViewModelV2$handleUseSubmitIntent$1(this.this$0, this.$uname, this.$source, this.$from, this.$scene, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0083 A[Catch: Exception -> 0x0137, TryCatch #0 {Exception -> 0x0137, blocks: (B:50:0x0131, B:24:0x007f, B:26:0x0083, B:28:0x0093, B:34:0x00c2, B:36:0x00cc, B:38:0x00db, B:43:0x00fa), top: B:68:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0175  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        MutableSharedFlow mutableSharedFlow;
        UnameMessageBean unameMessageBean;
        MutableSharedFlow mutableSharedFlow2;
        UnameMessageBean unameMessageBean2;
        UnameMessageBean unameMessageBean3;
        Object $result2;
        UpdateNameReply resp;
        MutableSharedFlow mutableSharedFlow3;
        String str;
        String str2;
        boolean z;
        UpdateNameReply it;
        MutableSharedFlow mutableSharedFlow4;
        boolean z2;
        MutableSharedFlow mutableSharedFlow5;
        String str3;
        String str4;
        boolean z3;
        UpdateNameReply it2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Exception e) {
            e = e;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                unameMessageBean = this.this$0.unameMsg;
                if (!unameMessageBean.getRealNameOrTel()) {
                    mutableSharedFlow2 = this.this$0._eventFlow;
                    unameMessageBean2 = this.this$0.unameMsg;
                    String conditionMessage = unameMessageBean2.getConditionMessage();
                    unameMessageBean3 = this.this$0.unameMsg;
                    this.label = 6;
                    if (mutableSharedFlow2.emit(new ModifyNameV2Event.ShowBindPhoneDialog(conditionMessage, unameMessageBean3.getBindTel()), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                PersonInfoReport.reportModifyNickNameSumitClick("1");
                this.label = 1;
                Object upDateNameV2 = PersonInfoMossApiService.INSTANCE.upDateNameV2(this.$uname, this.$source, (Continuation) this);
                if (upDateNameV2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result2 = $result;
                $result = upDateNameV2;
                try {
                    resp = (UpdateNameReply) $result;
                    if (resp != null) {
                        ModifyNameViewModelV2 modifyNameViewModelV2 = this.this$0;
                        String str5 = this.$uname;
                        String str6 = this.$from;
                        String str7 = this.$scene;
                        if (((int) resp.getCode()) == 0) {
                            mutableSharedFlow5 = modifyNameViewModelV2._eventFlow;
                            ModifyNameV2Event.SubmitSuccess submitSuccess = new ModifyNameV2Event.SubmitSuccess(str5);
                            this.L$0 = str6;
                            this.L$1 = str7;
                            this.L$2 = resp;
                            this.label = 2;
                            if (mutableSharedFlow5.emit(submitSuccess, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            str3 = str6;
                            str4 = str7;
                            z3 = false;
                            Object obj = $result2;
                            it2 = resp;
                            $result = obj;
                            PersonInfoReport.reportModifyNickNameCodeShow2(String.valueOf((int) it2.getCode()), "1", true, str3, str4);
                            $result2 = $result;
                            Unit unit = Unit.INSTANCE;
                        } else {
                            if (((int) resp.getCode()) == 40014) {
                                List nameListList = resp.getNameListList();
                                Intrinsics.checkNotNullExpressionValue(nameListList, "getNameListList(...)");
                                if (nameListList.isEmpty()) {
                                    mutableSharedFlow3 = modifyNameViewModelV2._eventFlow;
                                    String msg = resp.getMsg();
                                    Intrinsics.checkNotNullExpressionValue(msg, "getMsg(...)");
                                    ModifyNameV2Event.ShowToast showToast = new ModifyNameV2Event.ShowToast(msg);
                                    this.L$0 = str6;
                                    this.L$1 = str7;
                                    this.L$2 = resp;
                                    this.label = 4;
                                    if (mutableSharedFlow3.emit(showToast, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    str = str6;
                                    str2 = str7;
                                    z = false;
                                    Object obj2 = $result2;
                                    it = resp;
                                    $result = obj2;
                                    PersonInfoReport.reportModifyNickNameCodeShow2(String.valueOf((int) it.getCode()), "1", false, str, str2);
                                    $result2 = $result;
                                } else {
                                    mutableSharedFlow4 = modifyNameViewModelV2._eventFlow;
                                    List nameListList2 = resp.getNameListList();
                                    Intrinsics.checkNotNullExpressionValue(nameListList2, "getNameListList(...)");
                                    ModifyNameV2Event.ShowNameRetryDialog showNameRetryDialog = new ModifyNameV2Event.ShowNameRetryDialog(nameListList2);
                                    this.label = 3;
                                    if (mutableSharedFlow4.emit(showNameRetryDialog, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    $result = $result2;
                                    z2 = false;
                                    $result2 = $result;
                                }
                            }
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                } catch (Exception e2) {
                    e = e2;
                    $result = $result2;
                    BLog.e("ModifyNameViewModel", "saveSubmit request throwable " + e);
                    mutableSharedFlow = this.this$0._eventFlow;
                    this.L$0 = e;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 5;
                    if (mutableSharedFlow.emit(new ModifyNameV2Event.SubmitFailed(e), (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (e instanceof BusinessException) {
                    }
                    Unit unit3 = Unit.INSTANCE;
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 1:
                ResultKt.throwOnFailure($result);
                $result2 = $result;
                resp = (UpdateNameReply) $result;
                if (resp != null) {
                }
                return Unit.INSTANCE;
            case 2:
                z3 = false;
                it2 = (UpdateNameReply) this.L$2;
                str4 = (String) this.L$1;
                str3 = (String) this.L$0;
                ResultKt.throwOnFailure($result);
                PersonInfoReport.reportModifyNickNameCodeShow2(String.valueOf((int) it2.getCode()), "1", true, str3, str4);
                $result2 = $result;
                Unit unit22 = Unit.INSTANCE;
                return Unit.INSTANCE;
            case 3:
                z2 = false;
                ResultKt.throwOnFailure($result);
                $result2 = $result;
                Unit unit222 = Unit.INSTANCE;
                return Unit.INSTANCE;
            case 4:
                z = false;
                it = (UpdateNameReply) this.L$2;
                str2 = (String) this.L$1;
                str = (String) this.L$0;
                ResultKt.throwOnFailure($result);
                PersonInfoReport.reportModifyNickNameCodeShow2(String.valueOf((int) it.getCode()), "1", false, str, str2);
                $result2 = $result;
                Unit unit2222 = Unit.INSTANCE;
                return Unit.INSTANCE;
            case 5:
                e = (Exception) this.L$0;
                ResultKt.throwOnFailure($result);
                if (e instanceof BusinessException) {
                    PersonInfoReport.reportModifyNickNameCodeShow2(String.valueOf(e.getCode()), "1", false, this.$from, this.$scene);
                }
                Unit unit32 = Unit.INSTANCE;
                return Unit.INSTANCE;
            case 6:
                ResultKt.throwOnFailure($result);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}