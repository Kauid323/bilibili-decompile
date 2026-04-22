package io.ktor.client.plugins.cookies;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HttpCookies.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookies$initializer$1", f = "HttpCookies.kt", i = {}, l = {32}, m = "invokeSuspend", n = {}, s = {})
public final class HttpCookies$initializer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ HttpCookies this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCookies$initializer$1(HttpCookies httpCookies, Continuation<? super HttpCookies$initializer$1> continuation) {
        super(2, continuation);
        this.this$0 = httpCookies;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HttpCookies$initializer$1(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0057 -> B:14:0x005b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        Iterable iterable;
        Iterator it;
        HttpCookies httpCookies;
        HttpCookies$initializer$1 httpCookies$initializer$1;
        CookiesStorage cookiesStorage;
        HttpCookies httpCookies2;
        Iterator it2;
        HttpCookies$initializer$1 httpCookies$initializer$12;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                iterable = this.this$0.defaults;
                Iterable $this$forEach$iv = iterable;
                HttpCookies httpCookies3 = this.this$0;
                it = $this$forEach$iv.iterator();
                httpCookies = httpCookies3;
                httpCookies$initializer$1 = this;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                httpCookies2 = (HttpCookies) this.L$0;
                it2 = (Iterator) this.L$1;
                httpCookies$initializer$12 = this;
                httpCookies$initializer$1 = httpCookies$initializer$12;
                it = it2;
                httpCookies = httpCookies2;
                break;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!it.hasNext()) {
            Object element$iv = it.next();
            Function2 it3 = (Function2) element$iv;
            cookiesStorage = httpCookies.storage;
            httpCookies$initializer$1.L$0 = httpCookies;
            httpCookies$initializer$1.L$1 = it;
            httpCookies$initializer$1.label = 1;
            if (it3.invoke(cookiesStorage, httpCookies$initializer$1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            httpCookies2 = httpCookies;
            it2 = it;
            httpCookies$initializer$12 = httpCookies$initializer$1;
            httpCookies$initializer$1 = httpCookies$initializer$12;
            it = it2;
            httpCookies = httpCookies2;
            if (!it.hasNext()) {
                return Unit.INSTANCE;
            }
        }
    }
}