package io.ktor.client.plugins.websocket;

import com.tencent.smtt.sdk.TbsListener;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* compiled from: builders.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2", f = "builders.kt", i = {0, 1, 1, 2, 2}, l = {TbsListener.ErrorCode.TPATCH_VERSION_FAILED, TbsListener.ErrorCode.DOWNLOAD_FAILED_FOR_PREINIT_CALLBACK, 49, 262, 262}, m = "invokeSuspend", n = {"this_$iv", "this_$iv", "response$iv", "this_$iv", "response$iv"}, s = {"L$0", "L$0", "L$2", "L$0", "L$1"})
final class BuildersKt$webSocketSession$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CompletableDeferred<DefaultClientWebSocketSession> $sessionDeferred;
    final /* synthetic */ HttpStatement $statement;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BuildersKt$webSocketSession$2(HttpStatement httpStatement, CompletableDeferred<DefaultClientWebSocketSession> completableDeferred, Continuation<? super BuildersKt$webSocketSession$2> continuation) {
        super(2, continuation);
        this.$statement = httpStatement;
        this.$sessionDeferred = completableDeferred;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BuildersKt$webSocketSession$2(this.$statement, this.$sessionDeferred, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00e3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00ec A[Catch: all -> 0x0144, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0144, blocks: (B:52:0x00ec, B:68:0x0149, B:69:0x0151), top: B:93:0x00ea }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0149 A[Catch: all -> 0x0144, TRY_ENTER, TryCatch #1 {all -> 0x0144, blocks: (B:52:0x00ec, B:68:0x0149, B:69:0x0151), top: B:93:0x00ea }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0168 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0169  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $completion) {
        Object $result;
        Object fetchStreamingResponse;
        CompletableDeferred<DefaultClientWebSocketSession> completableDeferred;
        boolean z;
        boolean z2;
        boolean z3;
        HttpStatement this_$iv;
        HttpResponse response$iv;
        Object $result2;
        Throwable th;
        HttpResponse response$iv2;
        KType kType;
        Object bodyNullable;
        boolean z4;
        CompletableDeferred<DefaultClientWebSocketSession> completableDeferred2;
        Object $result3;
        boolean z5;
        boolean z6;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
            try {
                try {
                    try {
                    } catch (Throwable th2) {
                        cause$iv$iv = th2;
                        this.$sessionDeferred.completeExceptionally(cause$iv$iv);
                    }
                } catch (CancellationException e2) {
                    cause$iv$iv = e2;
                }
            } catch (Throwable th3) {
                cause$iv$iv = th3;
                this.$sessionDeferred.completeExceptionally(cause$iv$iv);
            }
        } catch (Throwable th4) {
            cause$iv$iv = th4;
            this.$sessionDeferred.completeExceptionally(cause$iv$iv);
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($completion);
                $result = $completion;
                HttpStatement this_$iv2 = this.$statement;
                CompletableDeferred<DefaultClientWebSocketSession> completableDeferred3 = this.$sessionDeferred;
                try {
                    this.L$0 = this_$iv2;
                    this.L$1 = completableDeferred3;
                    this.label = 1;
                    fetchStreamingResponse = this_$iv2.fetchStreamingResponse(this);
                    if (fetchStreamingResponse == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    completableDeferred = completableDeferred3;
                    z = false;
                    z2 = false;
                    z3 = false;
                    this_$iv = this_$iv2;
                    response$iv = (HttpResponse) fetchStreamingResponse;
                    try {
                        HttpClientCall call = response$iv.getCall();
                        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(DefaultClientWebSocketSession.class);
                        try {
                            kType = Reflection.typeOf(DefaultClientWebSocketSession.class);
                        } catch (Throwable th5) {
                            kType = null;
                        }
                        TypeInfo typeInfo = new TypeInfo(orCreateKotlinClass, kType);
                        this.L$0 = this_$iv;
                        this.L$1 = completableDeferred;
                        this.L$2 = response$iv;
                        this.label = 2;
                        bodyNullable = call.bodyNullable(typeInfo, this);
                        if (bodyNullable != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        $result2 = $result;
                        z4 = z3;
                        response$iv2 = response$iv;
                        completableDeferred2 = completableDeferred;
                        $result3 = bodyNullable;
                        try {
                            if ($result3 != null) {
                                throw new NullPointerException("null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession");
                            }
                            DefaultClientWebSocketSession session = (DefaultClientWebSocketSession) $result3;
                            Continuation continuation = (Continuation) this;
                            final CompletableDeferred sessionCompleted = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
                            completableDeferred2.complete(session);
                            session.getOutgoing().invokeOnClose(new Function1<Throwable, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$2$1$1
                                public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                                    invoke((Throwable) p1);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Throwable it) {
                                    if (it != null) {
                                        sessionCompleted.completeExceptionally(it);
                                    } else {
                                        sessionCompleted.complete(Unit.INSTANCE);
                                    }
                                }
                            });
                            this.L$0 = this_$iv;
                            this.L$1 = response$iv2;
                            this.L$2 = null;
                            this.label = 3;
                            if (sessionCompleted.await(this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            z5 = z;
                            z6 = z2;
                            try {
                                try {
                                    this.L$0 = Unit.INSTANCE;
                                    this.L$1 = null;
                                    this.label = 4;
                                    return this_$iv.cleanup(response$iv2, this) != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                                } catch (CancellationException e3) {
                                    cause$iv$iv = e3;
                                    Object $result4 = cause$iv$iv;
                                    throw ExceptionUtilsJvmKt.unwrapCancellationException((Throwable) $result4);
                                }
                            } catch (Throwable th6) {
                                boolean z7 = z5;
                                th = th6;
                                z = z7;
                                try {
                                    this.L$0 = th;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.label = 5;
                                    if (this_$iv.cleanup(response$iv2, this) == coroutine_suspended) {
                                    }
                                } catch (CancellationException e4) {
                                    cause$iv$iv = e4;
                                    Object $result42 = cause$iv$iv;
                                    throw ExceptionUtilsJvmKt.unwrapCancellationException((Throwable) $result42);
                                }
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            this.L$0 = th;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.label = 5;
                            if (this_$iv.cleanup(response$iv2, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            throw th;
                        }
                    } catch (Throwable th8) {
                        $result2 = $result;
                        th = th8;
                        response$iv2 = response$iv;
                        this.L$0 = th;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.label = 5;
                        if (this_$iv.cleanup(response$iv2, this) == coroutine_suspended) {
                        }
                    }
                } catch (CancellationException e5) {
                    cause$iv$iv = e5;
                    Object $result422 = cause$iv$iv;
                    throw ExceptionUtilsJvmKt.unwrapCancellationException((Throwable) $result422);
                }
            case 1:
                $result = $completion;
                z = false;
                z2 = false;
                CompletableDeferred<DefaultClientWebSocketSession> completableDeferred4 = (CompletableDeferred) this.L$1;
                this_$iv = (HttpStatement) this.L$0;
                try {
                    ResultKt.throwOnFailure($result);
                    fetchStreamingResponse = $result;
                    completableDeferred = completableDeferred4;
                    z3 = false;
                    response$iv = (HttpResponse) fetchStreamingResponse;
                    HttpClientCall call2 = response$iv.getCall();
                    KClass orCreateKotlinClass2 = Reflection.getOrCreateKotlinClass(DefaultClientWebSocketSession.class);
                    kType = Reflection.typeOf(DefaultClientWebSocketSession.class);
                    TypeInfo typeInfo2 = new TypeInfo(orCreateKotlinClass2, kType);
                    this.L$0 = this_$iv;
                    this.L$1 = completableDeferred;
                    this.L$2 = response$iv;
                    this.label = 2;
                    bodyNullable = call2.bodyNullable(typeInfo2, this);
                    if (bodyNullable != coroutine_suspended) {
                    }
                } catch (CancellationException e6) {
                    cause$iv$iv = e6;
                    Object $result4222 = cause$iv$iv;
                    throw ExceptionUtilsJvmKt.unwrapCancellationException((Throwable) $result4222);
                }
                break;
            case 2:
                $result3 = $completion;
                z = false;
                z2 = false;
                HttpResponse response$iv3 = (HttpResponse) this.L$2;
                completableDeferred2 = (CompletableDeferred) this.L$1;
                HttpStatement this_$iv3 = (HttpStatement) this.L$0;
                try {
                    ResultKt.throwOnFailure($result3);
                    $result2 = $result3;
                    z4 = false;
                    response$iv2 = response$iv3;
                    this_$iv = this_$iv3;
                    if ($result3 != null) {
                    }
                } catch (Throwable th9) {
                    $result2 = $result3;
                    th = th9;
                    response$iv2 = response$iv3;
                    this_$iv = this_$iv3;
                    this.L$0 = th;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 5;
                    if (this_$iv.cleanup(response$iv2, this) == coroutine_suspended) {
                    }
                }
                break;
            case 3:
                $result2 = $completion;
                z5 = false;
                z6 = false;
                response$iv2 = (HttpResponse) this.L$1;
                this_$iv = (HttpStatement) this.L$0;
                try {
                    ResultKt.throwOnFailure($result2);
                    z4 = false;
                    this.L$0 = Unit.INSTANCE;
                    this.L$1 = null;
                    this.label = 4;
                    if (this_$iv.cleanup(response$iv2, this) != coroutine_suspended) {
                    }
                } catch (Throwable th10) {
                    z = false;
                    th = th10;
                    this.L$0 = th;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.label = 5;
                    if (this_$iv.cleanup(response$iv2, this) == coroutine_suspended) {
                    }
                }
                break;
            case 4:
                Unit unit = (Unit) this.L$0;
                ResultKt.throwOnFailure($completion);
            case 5:
                th = (Throwable) this.L$0;
                ResultKt.throwOnFailure($completion);
                throw th;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}