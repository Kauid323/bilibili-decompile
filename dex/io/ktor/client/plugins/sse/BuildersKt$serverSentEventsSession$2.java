package io.ktor.client.plugins.sse;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.util.reflect.TypeInfo;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: builders.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.sse.BuildersKt$serverSentEventsSession$2", f = "builders.kt", i = {0, 1, 1}, l = {258, 261, 280, 280}, m = "invokeSuspend", n = {"this_$iv", "this_$iv", "response$iv"}, s = {"L$0", "L$0", "L$2"})
public final class BuildersKt$serverSentEventsSession$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CompletableDeferred<ClientSSESession> $sessionDeferred;
    final /* synthetic */ HttpStatement $statement;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuildersKt$serverSentEventsSession$2(HttpStatement httpStatement, CompletableDeferred<ClientSSESession> completableDeferred, Continuation<? super BuildersKt$serverSentEventsSession$2> continuation) {
        super(2, continuation);
        this.$statement = httpStatement;
        this.$sessionDeferred = completableDeferred;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BuildersKt$serverSentEventsSession$2(this.$statement, this.$sessionDeferred, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x0126: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY] A[D('$result' java.lang.Object)]), block:B:70:0x0126 */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ce A[Catch: all -> 0x004d, TRY_ENTER, TRY_LEAVE, TryCatch #6 {all -> 0x004d, blocks: (B:17:0x0047, B:47:0x00ce, B:53:0x00f2, B:54:0x00fa), top: B:85:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f2 A[Catch: all -> 0x004d, TRY_ENTER, TryCatch #6 {all -> 0x004d, blocks: (B:17:0x0047, B:47:0x00ce, B:53:0x00f2, B:54:0x00fa), top: B:85:0x0047 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x010f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $completion) {
        Throwable mapToSSEException;
        Object $result;
        CancellationException cause$iv$iv;
        HttpStatement this_$iv;
        CompletableDeferred<ClientSSESession> completableDeferred;
        boolean z;
        Object fetchStreamingResponse;
        HttpStatement this_$iv2;
        CompletableDeferred<ClientSSESession> completableDeferred2;
        boolean z2;
        boolean z3;
        HttpResponse response$iv;
        Throwable th;
        HttpResponse response$iv2;
        KType kType;
        Object bodyNullable;
        Object obj;
        CompletableDeferred<ClientSSESession> completableDeferred3;
        boolean z4;
        Object $result2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
                try {
                } catch (CancellationException e2) {
                    cause$iv$iv = e2;
                }
            } catch (Throwable th2) {
                cause = th2;
                CompletableDeferred<ClientSSESession> completableDeferred4 = this.$sessionDeferred;
                mapToSSEException = BuildersKt.mapToSSEException(null, cause);
                completableDeferred4.completeExceptionally(mapToSSEException);
            }
        } catch (Throwable th3) {
            cause = th3;
            CompletableDeferred<ClientSSESession> completableDeferred42 = this.$sessionDeferred;
            mapToSSEException = BuildersKt.mapToSSEException(null, cause);
            completableDeferred42.completeExceptionally(mapToSSEException);
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($completion);
                $result = $completion;
                try {
                    this_$iv = this.$statement;
                    completableDeferred = this.$sessionDeferred;
                    z = false;
                } catch (CancellationException e3) {
                    cause$iv$iv = e3;
                    this.$sessionDeferred.cancel(cause$iv$iv);
                }
                try {
                    this.L$0 = this_$iv;
                    this.L$1 = completableDeferred;
                    this.label = 1;
                    fetchStreamingResponse = this_$iv.fetchStreamingResponse(this);
                    if (fetchStreamingResponse == $result2) {
                        return $result2;
                    }
                    this_$iv2 = this_$iv;
                    completableDeferred2 = completableDeferred;
                    z2 = false;
                    z3 = false;
                    response$iv = (HttpResponse) fetchStreamingResponse;
                    try {
                        HttpClientCall call = response$iv.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ClientSSESession.class);
                        try {
                            kType = Reflection.typeOf(ClientSSESession.class);
                        } catch (Throwable th4) {
                            kType = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                        this.L$0 = this_$iv2;
                        this.L$1 = completableDeferred2;
                        this.L$2 = response$iv;
                        this.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, this);
                        if (bodyNullable != $result2) {
                            return $result2;
                        }
                        obj = bodyNullable;
                        completableDeferred3 = completableDeferred2;
                        z4 = z;
                        response$iv2 = response$iv;
                        if (obj == null) {
                            Object result$iv = (ClientSSESession) obj;
                            Continuation continuation = (Continuation) this;
                            completableDeferred3.complete(result$iv);
                            this.L$0 = Unit.INSTANCE;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.label = 3;
                            return this_$iv2.cleanup(response$iv2, this) == $result2 ? $result2 : Unit.INSTANCE;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type io.ktor.client.plugins.sse.ClientSSESession");
                    } catch (Throwable th5) {
                        th = th5;
                        response$iv2 = response$iv;
                        this.L$0 = th;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 4;
                        if (this_$iv2.cleanup(response$iv2, this) != $result2) {
                            return $result2;
                        }
                        throw th;
                    }
                } catch (CancellationException e4) {
                    cause$iv$iv = e4;
                    $result2 = $result;
                    try {
                        throw ExceptionUtilsJvmKt.unwrapCancellationException(cause$iv$iv);
                    } catch (CancellationException e5) {
                        cause$iv$iv = e5;
                        $result = $result2;
                        this.$sessionDeferred.cancel(cause$iv$iv);
                    }
                }
            case 1:
                $result = $completion;
                z2 = false;
                z3 = false;
                completableDeferred2 = (CompletableDeferred) this.L$1;
                HttpStatement this_$iv3 = (HttpStatement) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    fetchStreamingResponse = $result;
                    this_$iv2 = this_$iv3;
                    z = false;
                    response$iv = (HttpResponse) fetchStreamingResponse;
                    HttpClientCall call2 = response$iv.getCall();
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(ClientSSESession.class);
                    kType = Reflection.typeOf(ClientSSESession.class);
                    TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                    this.L$0 = this_$iv2;
                    this.L$1 = completableDeferred2;
                    this.L$2 = response$iv;
                    this.label = 2;
                    bodyNullable = call2.bodyNullable(typeInfo2, this);
                    if (bodyNullable != $result2) {
                    }
                } catch (CancellationException e6) {
                    cause$iv$iv = e6;
                    $result2 = $result;
                    throw ExceptionUtilsJvmKt.unwrapCancellationException(cause$iv$iv);
                }
                break;
            case 2:
                $result = $completion;
                z2 = false;
                z3 = false;
                z4 = false;
                response$iv2 = (HttpResponse) this.L$2;
                completableDeferred3 = (CompletableDeferred) this.L$1;
                this_$iv2 = (HttpStatement) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    obj = $result;
                    if (obj == null) {
                    }
                } catch (Throwable th6) {
                    th = th6;
                    this.L$0 = th;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 4;
                    if (this_$iv2.cleanup(response$iv2, this) != $result2) {
                    }
                }
                break;
            case 3:
                Unit unit = (Unit) this.L$0;
                ResultKt.throwOnFailure($completion);
            case 4:
                Throwable th7 = (Throwable) this.L$0;
                ResultKt.throwOnFailure($completion);
                throw th7;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}