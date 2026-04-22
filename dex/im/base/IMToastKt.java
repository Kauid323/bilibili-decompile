package im.base;

import bili.resource.common.CommonRes;
import bili.resource.common.Res;
import bili.resource.common.String0_commonMainKt;
import kntr.base.moss.api.KBusinessException;
import kntr.base.moss.api.KNetworkException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: IMToast.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001aF\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00012(\b\u0002\u0010\u0004\u001a\"\b\u0001\u0012\u0004\u0012\u00020\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005H\u0086@¢\u0006\u0002\u0010\b\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0001¨\u0006\n"}, d2 = {"toDisplayString", "", "", "default", "extraHandler", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/lang/Throwable;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toDisplayStringBlocking", "base_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class IMToastKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object toDisplayString(Throwable $this$toDisplayString, String str, Function2<? super Throwable, ? super Continuation<? super String>, ? extends Object> function2, Continuation<? super String> continuation) {
        IMToastKt$toDisplayString$1 iMToastKt$toDisplayString$1;
        Object invoke;
        Function1 defaultErrorMessage;
        String str2;
        String str3;
        if (continuation instanceof IMToastKt$toDisplayString$1) {
            iMToastKt$toDisplayString$1 = (IMToastKt$toDisplayString$1) continuation;
            if ((iMToastKt$toDisplayString$1.label & Integer.MIN_VALUE) != 0) {
                iMToastKt$toDisplayString$1.label -= Integer.MIN_VALUE;
                Object $result = iMToastKt$toDisplayString$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (iMToastKt$toDisplayString$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        Function1 defaultErrorMessage2 = new IMToastKt$toDisplayString$defaultErrorMessage$1(null);
                        if ($this$toDisplayString instanceof IMMossBusinessException) {
                            return ((IMMossBusinessException) $this$toDisplayString).getErrorMsg();
                        }
                        if ($this$toDisplayString instanceof KBusinessException) {
                            String message = $this$toDisplayString.getMessage();
                            if (message == null) {
                                str2 = StringsKt.isBlank(str) ? null : str;
                                if (str2 == null) {
                                    iMToastKt$toDisplayString$1.L$0 = SpillingKt.nullOutSpilledVariable($this$toDisplayString);
                                    iMToastKt$toDisplayString$1.L$1 = SpillingKt.nullOutSpilledVariable(str);
                                    iMToastKt$toDisplayString$1.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                                    iMToastKt$toDisplayString$1.L$3 = SpillingKt.nullOutSpilledVariable(defaultErrorMessage2);
                                    iMToastKt$toDisplayString$1.label = 1;
                                    Object invoke2 = defaultErrorMessage2.invoke(iMToastKt$toDisplayString$1);
                                    return invoke2 == coroutine_suspended ? coroutine_suspended : invoke2;
                                }
                                return str2;
                            }
                            return message;
                        } else if ($this$toDisplayString instanceof KNetworkException) {
                            str2 = StringsKt.isBlank(str) ? null : str;
                            if (str2 == null) {
                                iMToastKt$toDisplayString$1.L$0 = SpillingKt.nullOutSpilledVariable($this$toDisplayString);
                                iMToastKt$toDisplayString$1.L$1 = SpillingKt.nullOutSpilledVariable(str);
                                iMToastKt$toDisplayString$1.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                                iMToastKt$toDisplayString$1.L$3 = SpillingKt.nullOutSpilledVariable(defaultErrorMessage2);
                                iMToastKt$toDisplayString$1.label = 2;
                                Object invoke3 = defaultErrorMessage2.invoke(iMToastKt$toDisplayString$1);
                                return invoke3 == coroutine_suspended ? coroutine_suspended : invoke3;
                            }
                            return str2;
                        } else {
                            if (function2 != null) {
                                iMToastKt$toDisplayString$1.L$0 = SpillingKt.nullOutSpilledVariable($this$toDisplayString);
                                iMToastKt$toDisplayString$1.L$1 = str;
                                iMToastKt$toDisplayString$1.L$2 = SpillingKt.nullOutSpilledVariable(function2);
                                iMToastKt$toDisplayString$1.L$3 = SpillingKt.nullOutSpilledVariable(defaultErrorMessage2);
                                iMToastKt$toDisplayString$1.label = 3;
                                invoke = function2.invoke($this$toDisplayString, iMToastKt$toDisplayString$1);
                                if (invoke == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                defaultErrorMessage = defaultErrorMessage2;
                                str3 = (String) invoke;
                                if (str3 == null) {
                                    return str3;
                                }
                            }
                            return str;
                        }
                    case 1:
                        Function1 function1 = (Function1) iMToastKt$toDisplayString$1.L$3;
                        Function2 function22 = (Function2) iMToastKt$toDisplayString$1.L$2;
                        String str4 = (String) iMToastKt$toDisplayString$1.L$1;
                        Throwable th = (Throwable) iMToastKt$toDisplayString$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    case 2:
                        Function1 function12 = (Function1) iMToastKt$toDisplayString$1.L$3;
                        Function2 function23 = (Function2) iMToastKt$toDisplayString$1.L$2;
                        String str5 = (String) iMToastKt$toDisplayString$1.L$1;
                        Throwable th2 = (Throwable) iMToastKt$toDisplayString$1.L$0;
                        ResultKt.throwOnFailure($result);
                        return $result;
                    case 3:
                        defaultErrorMessage = (Function1) iMToastKt$toDisplayString$1.L$3;
                        Function2 function24 = (Function2) iMToastKt$toDisplayString$1.L$2;
                        str = (String) iMToastKt$toDisplayString$1.L$1;
                        Throwable th3 = (Throwable) iMToastKt$toDisplayString$1.L$0;
                        ResultKt.throwOnFailure($result);
                        invoke = $result;
                        str3 = (String) invoke;
                        if (str3 == null) {
                        }
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        iMToastKt$toDisplayString$1 = new IMToastKt$toDisplayString$1(continuation);
        Object $result2 = iMToastKt$toDisplayString$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (iMToastKt$toDisplayString$1.label) {
        }
    }

    public static /* synthetic */ Object toDisplayString$default(Throwable th, String str, Function2 function2, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        if ((i2 & 2) != 0) {
            function2 = null;
        }
        return toDisplayString(th, str, function2, continuation);
    }

    public static /* synthetic */ String toDisplayStringBlocking$default(Throwable th, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        return toDisplayStringBlocking(th, str);
    }

    public static final String toDisplayStringBlocking(Throwable $this$toDisplayStringBlocking, String str) {
        Intrinsics.checkNotNullParameter($this$toDisplayStringBlocking, "<this>");
        Intrinsics.checkNotNullParameter(str, "default");
        Function0 defaultErrorMessage = new Function0() { // from class: im.base.IMToastKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                String displayStringBlocking$lambda$0;
                displayStringBlocking$lambda$0 = IMToastKt.toDisplayStringBlocking$lambda$0();
                return displayStringBlocking$lambda$0;
            }
        };
        if ($this$toDisplayStringBlocking instanceof IMMossBusinessException) {
            return ((IMMossBusinessException) $this$toDisplayStringBlocking).getErrorMsg();
        }
        if (!($this$toDisplayStringBlocking instanceof KBusinessException)) {
            if ($this$toDisplayStringBlocking instanceof KNetworkException) {
                String str2 = !StringsKt.isBlank(str) ? str : null;
                return str2 == null ? (String) defaultErrorMessage.invoke() : str2;
            }
            return str;
        }
        String message = $this$toDisplayStringBlocking.getMessage();
        if (message != null) {
            return message;
        }
        String str3 = !StringsKt.isBlank(str) ? str : null;
        return str3 == null ? (String) defaultErrorMessage.invoke() : str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toDisplayStringBlocking$lambda$0() {
        return CommonRes.INSTANCE.getString(String0_commonMainKt.getCommon_global_string_378(Res.string.INSTANCE));
    }
}