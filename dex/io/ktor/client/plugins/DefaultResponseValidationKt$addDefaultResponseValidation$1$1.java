package io.ktor.client.plugins;

import host.R;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedCallKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import io.ktor.utils.io.charsets.MalformedInputException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.slf4j.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultResponseValidation.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "response", "Lio/ktor/client/statement/HttpResponse;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.DefaultResponseValidationKt$addDefaultResponseValidation$1$1", f = "DefaultResponseValidation.kt", i = {0, 0, 1, 1, 1}, l = {R.styleable.CameraView_cameraSnapshotMaxHeight, 46}, m = "invokeSuspend", n = {"response", "statusCode", "response", "exceptionResponse", "statusCode"}, s = {"L$0", "I$0", "L$0", "L$1", "I$0"})
public final class DefaultResponseValidationKt$addDefaultResponseValidation$1$1 extends SuspendLambda implements Function2<HttpResponse, Continuation<? super Unit>, Object> {
    int I$0;
    /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultResponseValidationKt$addDefaultResponseValidation$1$1(Continuation<? super DefaultResponseValidationKt$addDefaultResponseValidation$1$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> defaultResponseValidationKt$addDefaultResponseValidation$1$1 = new DefaultResponseValidationKt$addDefaultResponseValidation$1$1(continuation);
        defaultResponseValidationKt$addDefaultResponseValidation$1$1.L$0 = obj;
        return defaultResponseValidationKt$addDefaultResponseValidation$1$1;
    }

    public final Object invoke(HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        return create(httpResponse, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|2|42|43|44|(1:46)(9:47|10|11|12|(0)|34|(0)(0)|27|28)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00e8, code lost:
        r13 = r1;
        r0 = r4;
        r4 = r5;
        r1 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        int statusCode;
        AttributeKey attributeKey;
        Object $result2;
        HttpResponse response;
        Logger logger;
        AttributeKey attributeKey2;
        HttpResponse exceptionResponse;
        int statusCode2;
        HttpResponse response2;
        String exceptionResponseText;
        ResponseException redirectResponseException;
        Logger logger2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        boolean z = true;
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                HttpResponse response3 = (HttpResponse) this.L$0;
                boolean expectSuccess = ((Boolean) response3.getCall().getAttributes().get(HttpCallValidatorKt.getExpectSuccessAttributeKey())).booleanValue();
                if (!expectSuccess) {
                    logger = DefaultResponseValidationKt.LOGGER;
                    logger.trace("Skipping default response validation for " + response3.getCall().getRequest().getUrl());
                    return Unit.INSTANCE;
                }
                statusCode = response3.getStatus().getValue();
                HttpClientCall originCall = response3.getCall();
                if (statusCode >= 300) {
                    Attributes attributes = originCall.getAttributes();
                    attributeKey = DefaultResponseValidationKt.ValidateMark;
                    if (!attributes.contains(attributeKey)) {
                        this.L$0 = response3;
                        this.I$0 = statusCode;
                        this.label = 1;
                        Object save = SavedCallKt.save(originCall, (Continuation) this);
                        if (save != coroutine_suspended) {
                            $result2 = $result;
                            $result = save;
                            response = response3;
                            break;
                        } else {
                            return coroutine_suspended;
                        }
                    }
                }
                return Unit.INSTANCE;
            case 1:
                int statusCode3 = this.I$0;
                ResultKt.throwOnFailure($result);
                response = (HttpResponse) this.L$0;
                statusCode = statusCode3;
                $result2 = $result;
                break;
            case 2:
                statusCode2 = this.I$0;
                HttpResponse exceptionResponse2 = (HttpResponse) this.L$1;
                response2 = (HttpResponse) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    exceptionResponse = exceptionResponse2;
                    $result2 = $result;
                    try {
                        exceptionResponseText = (String) $result;
                    } catch (MalformedInputException e2) {
                        $result = $result2;
                        exceptionResponse2 = exceptionResponse;
                        exceptionResponse = exceptionResponse2;
                        exceptionResponseText = "<body failed decoding>";
                        if (300 > statusCode2 && statusCode2 < 400) {
                        }
                        ResponseException exception = redirectResponseException;
                        logger2 = DefaultResponseValidationKt.LOGGER;
                        logger2.trace("Default response validation for " + response2.getCall().getRequest().getUrl() + " failed with " + exception);
                        throw exception;
                    }
                } catch (MalformedInputException e3) {
                    exceptionResponse = exceptionResponse2;
                    exceptionResponseText = "<body failed decoding>";
                    if (300 > statusCode2 && statusCode2 < 400) {
                    }
                    ResponseException exception2 = redirectResponseException;
                    logger2 = DefaultResponseValidationKt.LOGGER;
                    logger2.trace("Default response validation for " + response2.getCall().getRequest().getUrl() + " failed with " + exception2);
                    throw exception2;
                }
                if (300 > statusCode2 && statusCode2 < 400) {
                    redirectResponseException = new RedirectResponseException(exceptionResponse, exceptionResponseText);
                } else {
                    if (400 <= statusCode2 && statusCode2 < 500) {
                        redirectResponseException = new ClientRequestException(exceptionResponse, exceptionResponseText);
                    } else {
                        if (500 > statusCode2 || statusCode2 >= 600) {
                            z = false;
                        }
                        redirectResponseException = z ? new ServerResponseException(exceptionResponse, exceptionResponseText) : new ResponseException(exceptionResponse, exceptionResponseText);
                    }
                }
                ResponseException exception22 = redirectResponseException;
                logger2 = DefaultResponseValidationKt.LOGGER;
                logger2.trace("Default response validation for " + response2.getCall().getRequest().getUrl() + " failed with " + exception22);
                throw exception22;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        HttpClientCall $this$invokeSuspend_u24lambda_u240 = (HttpClientCall) $result;
        Attributes attributes2 = $this$invokeSuspend_u24lambda_u240.getAttributes();
        attributeKey2 = DefaultResponseValidationKt.ValidateMark;
        attributes2.put(attributeKey2, Unit.INSTANCE);
        HttpClientCall exceptionCall = (HttpClientCall) $result;
        exceptionResponse = exceptionCall.getResponse();
        this.L$0 = response;
        this.L$1 = exceptionResponse;
        this.I$0 = statusCode;
        this.label = 2;
        $result = HttpResponseKt.bodyAsText$default(exceptionResponse, null, (Continuation) this, 1, null);
        if ($result == coroutine_suspended) {
            return coroutine_suspended;
        }
        statusCode2 = statusCode;
        response2 = response;
        exceptionResponseText = (String) $result;
        if (300 > statusCode2 && statusCode2 < 400) {
        }
        ResponseException exception222 = redirectResponseException;
        logger2 = DefaultResponseValidationKt.LOGGER;
        logger2.trace("Default response validation for " + response2.getCall().getRequest().getUrl() + " failed with " + exception222);
        throw exception222;
    }
}