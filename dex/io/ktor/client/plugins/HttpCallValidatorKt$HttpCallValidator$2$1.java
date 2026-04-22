package io.ktor.client.plugins;

import com.tencent.open.SocialConstants;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCallValidator.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", SocialConstants.TYPE_REQUEST, "Lio/ktor/client/request/HttpRequestBuilder;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpCallValidatorKt$HttpCallValidator$2$1", f = "HttpCallValidator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class HttpCallValidatorKt$HttpCallValidator$2$1 extends SuspendLambda implements Function2<HttpRequestBuilder, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $expectSuccess;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCallValidatorKt$HttpCallValidator$2$1(boolean z, Continuation<? super HttpCallValidatorKt$HttpCallValidator$2$1> continuation) {
        super(2, continuation);
        this.$expectSuccess = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> httpCallValidatorKt$HttpCallValidator$2$1 = new HttpCallValidatorKt$HttpCallValidator$2$1(this.$expectSuccess, continuation);
        httpCallValidatorKt$HttpCallValidator$2$1.L$0 = obj;
        return httpCallValidatorKt$HttpCallValidator$2$1;
    }

    public final Object invoke(HttpRequestBuilder httpRequestBuilder, Continuation<? super Unit> continuation) {
        return create(httpRequestBuilder, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                HttpRequestBuilder request = (HttpRequestBuilder) this.L$0;
                Attributes attributes = request.getAttributes();
                AttributeKey<Boolean> expectSuccessAttributeKey = HttpCallValidatorKt.getExpectSuccessAttributeKey();
                final boolean z = this.$expectSuccess;
                attributes.computeIfAbsent(expectSuccessAttributeKey, new Function0() { // from class: io.ktor.client.plugins.HttpCallValidatorKt$HttpCallValidator$2$1$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        boolean invokeSuspend$lambda$0;
                        invokeSuspend$lambda$0 = HttpCallValidatorKt$HttpCallValidator$2$1.invokeSuspend$lambda$0(z);
                        return Boolean.valueOf(invokeSuspend$lambda$0);
                    }
                });
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$lambda$0(boolean $expectSuccess) {
        return $expectSuccess;
    }
}