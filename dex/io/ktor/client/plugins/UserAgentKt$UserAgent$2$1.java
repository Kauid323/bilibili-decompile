package io.ktor.client.plugins;

import com.tencent.open.SocialConstants;
import io.ktor.client.plugins.api.OnRequestContext;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.UtilsKt;
import io.ktor.http.HttpHeaders;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;
import org.slf4j.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UserAgent.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n"}, d2 = {"<anonymous>", "", "Lio/ktor/client/plugins/api/OnRequestContext;", SocialConstants.TYPE_REQUEST, "Lio/ktor/client/request/HttpRequestBuilder;", "<unused var>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.UserAgentKt$UserAgent$2$1", f = "UserAgent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class UserAgentKt$UserAgent$2$1 extends SuspendLambda implements Function4<OnRequestContext, HttpRequestBuilder, Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $agent;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserAgentKt$UserAgent$2$1(String str, Continuation<? super UserAgentKt$UserAgent$2$1> continuation) {
        super(4, continuation);
        this.$agent = str;
    }

    public final Object invoke(OnRequestContext onRequestContext, HttpRequestBuilder httpRequestBuilder, Object obj, Continuation<? super Unit> continuation) {
        UserAgentKt$UserAgent$2$1 userAgentKt$UserAgent$2$1 = new UserAgentKt$UserAgent$2$1(this.$agent, continuation);
        userAgentKt$UserAgent$2$1.L$0 = httpRequestBuilder;
        return userAgentKt$UserAgent$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Logger logger;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                HttpRequestBuilder request = (HttpRequestBuilder) this.L$0;
                logger = UserAgentKt.LOGGER;
                logger.trace("Adding User-Agent header: agent for " + request.getUrl());
                UtilsKt.header(request, HttpHeaders.INSTANCE.getUserAgent(), this.$agent);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}