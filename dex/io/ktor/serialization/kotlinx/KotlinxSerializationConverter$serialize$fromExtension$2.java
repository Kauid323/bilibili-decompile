package io.ktor.serialization.kotlinx;

import io.ktor.http.content.OutgoingContent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: KotlinxSerializationConverter.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lio/ktor/http/content/OutgoingContent;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serialize$fromExtension$2", f = "KotlinxSerializationConverter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class KotlinxSerializationConverter$serialize$fromExtension$2 extends SuspendLambda implements Function2<OutgoingContent, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KotlinxSerializationConverter$serialize$fromExtension$2(Continuation<? super KotlinxSerializationConverter$serialize$fromExtension$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> kotlinxSerializationConverter$serialize$fromExtension$2 = new KotlinxSerializationConverter$serialize$fromExtension$2(continuation);
        kotlinxSerializationConverter$serialize$fromExtension$2.L$0 = obj;
        return kotlinxSerializationConverter$serialize$fromExtension$2;
    }

    public final Object invoke(OutgoingContent outgoingContent, Continuation<? super Boolean> continuation) {
        return create(outgoingContent, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                OutgoingContent it = (OutgoingContent) this.L$0;
                return Boxing.boxBoolean(it != null);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}