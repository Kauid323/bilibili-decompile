package kntr.common.share.domain.http;

import com.bilibili.ktor.KApiResponse;
import io.ktor.http.HttpUrlEncodedKt;
import io.ktor.http.Parameters;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.ParametersKt;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.device.KDevice;
import kntr.common.share.common.ShareLog;
import kntr.common.share.domain.model.ShareResponse;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.functions.Function1;

/* compiled from: ShareApiService.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\u001a>\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0000\u0010\u00052\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007H\u0082@¢\u0006\u0002\u0010\u000b\u001a>\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00050\t\"\u0004\b\u0000\u0010\u00052\"\u0010\r\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\t0\b\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007H\u0082@¢\u0006\u0002\u0010\u000b\u001a\u0018\u0010\u000e\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u000fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"HTTPS_API_BILIBILI_COM", "", "TAG", "handleResponse", "Lkntr/common/share/domain/model/ShareResponse;", "T", "response", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lcom/bilibili/ktor/KApiResponse;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleApiException", "block", "toParameters", "", "domain_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ShareApiServiceKt {
    public static final String HTTPS_API_BILIBILI_COM = "https://api.bilibili.com";
    private static final String TAG = "ShareApiService";

    public static final /* synthetic */ Object access$handleResponse(Function1 response, Continuation $completion) {
        return handleResponse(response, $completion);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0096  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object handleResponse(Function1<? super Continuation<? super KApiResponse<? extends T>>, ? extends Object> function1, Continuation<? super ShareResponse<? extends T>> continuation) {
        ShareApiServiceKt$handleResponse$1 shareApiServiceKt$handleResponse$1;
        Object invoke;
        KApiResponse.BusinessFailure businessFailure;
        if (continuation instanceof ShareApiServiceKt$handleResponse$1) {
            shareApiServiceKt$handleResponse$1 = (ShareApiServiceKt$handleResponse$1) continuation;
            if ((shareApiServiceKt$handleResponse$1.label & Integer.MIN_VALUE) != 0) {
                shareApiServiceKt$handleResponse$1.label -= Integer.MIN_VALUE;
                Object $result = shareApiServiceKt$handleResponse$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (shareApiServiceKt$handleResponse$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        shareApiServiceKt$handleResponse$1.L$0 = SpillingKt.nullOutSpilledVariable(function1);
                        shareApiServiceKt$handleResponse$1.label = 1;
                        invoke = function1.invoke(shareApiServiceKt$handleResponse$1);
                        if (invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        Function1 function12 = (Function1) shareApiServiceKt$handleResponse$1.L$0;
                        ResultKt.throwOnFailure($result);
                        invoke = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                businessFailure = (KApiResponse) invoke;
                if (!(businessFailure instanceof KApiResponse.BusinessFailure)) {
                    KApiResponse.BusinessFailure $this$handleResponse_u24lambda_u241 = businessFailure;
                    ShareLog.Companion.e(TAG, "Request business failure, code: " + $this$handleResponse_u24lambda_u241.getCode() + ",  message: " + $this$handleResponse_u24lambda_u241.getMessage());
                    int code = $this$handleResponse_u24lambda_u241.getCode();
                    String message = $this$handleResponse_u24lambda_u241.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    return new ShareResponse.Failure(code, message);
                } else if (businessFailure instanceof KApiResponse.ServiceUnavailable) {
                    Exception ex = ((KApiResponse.ServiceUnavailable) businessFailure).getException();
                    ShareLog.Companion.e(TAG, "Request service unavailable, code: " + ex.getCause() + ", message: " + ex.getMessage());
                    return new ShareResponse.Error(ex);
                } else if (businessFailure instanceof KApiResponse.Success) {
                    Object data = ((KApiResponse.Success) businessFailure).getData();
                    ShareLog.Companion.i(TAG, "Request success, data: " + data);
                    return new ShareResponse.Success(data);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }
        shareApiServiceKt$handleResponse$1 = new ShareApiServiceKt$handleResponse$1(continuation);
        Object $result2 = shareApiServiceKt$handleResponse$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (shareApiServiceKt$handleResponse$1.label) {
        }
        businessFailure = (KApiResponse) invoke;
        if (!(businessFailure instanceof KApiResponse.BusinessFailure)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object handleApiException(Function1<? super Continuation<? super KApiResponse<? extends T>>, ? extends Object> function1, Continuation<? super KApiResponse<? extends T>> continuation) {
        ShareApiServiceKt$handleApiException$1 shareApiServiceKt$handleApiException$1;
        Object invoke;
        try {
            if (continuation instanceof ShareApiServiceKt$handleApiException$1) {
                shareApiServiceKt$handleApiException$1 = (ShareApiServiceKt$handleApiException$1) continuation;
                if ((shareApiServiceKt$handleApiException$1.label & Integer.MIN_VALUE) != 0) {
                    shareApiServiceKt$handleApiException$1.label -= Integer.MIN_VALUE;
                    Object $result = shareApiServiceKt$handleApiException$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (shareApiServiceKt$handleApiException$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            shareApiServiceKt$handleApiException$1.L$0 = SpillingKt.nullOutSpilledVariable(function1);
                            shareApiServiceKt$handleApiException$1.label = 1;
                            invoke = function1.invoke(shareApiServiceKt$handleApiException$1);
                            if (invoke == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            break;
                        case 1:
                            Function1 function12 = (Function1) shareApiServiceKt$handleApiException$1.L$0;
                            ResultKt.throwOnFailure($result);
                            invoke = $result;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return (KApiResponse) invoke;
                }
            }
            switch (shareApiServiceKt$handleApiException$1.label) {
            }
            return (KApiResponse) invoke;
        } catch (CancellationException e) {
            ShareLog.Companion.e(TAG, "Share Api Exception: " + e.getMessage() + " ", e);
            return new KApiResponse.ServiceUnavailable(e);
        } catch (Exception e2) {
            ShareLog.Companion.e(TAG, "Share Api Exception error: " + e2.getMessage(), e2);
            return new KApiResponse.ServiceUnavailable(e2);
        }
        shareApiServiceKt$handleApiException$1 = new ShareApiServiceKt$handleApiException$1(continuation);
        Object $result2 = shareApiServiceKt$handleApiException$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String toParameters(Map<String, String> map) {
        ShareLog.Companion.i(TAG, "params = " + map);
        Parameters.Companion companion = Parameters.Companion;
        ParametersBuilder $this$toParameters_u24lambda_u240 = ParametersKt.ParametersBuilder$default(0, 1, (Object) null);
        for (Map.Entry element$iv : map.entrySet()) {
            String key = element$iv.getKey();
            String value = element$iv.getValue();
            $this$toParameters_u24lambda_u240.append(key, value);
        }
        $this$toParameters_u24lambda_u240.append("buvid", KDevice.INSTANCE.getBuvid());
        return HttpUrlEncodedKt.formUrlEncode($this$toParameters_u24lambda_u240.build());
    }
}