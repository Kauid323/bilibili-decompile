package io.ktor.serialization;

import io.ktor.utils.io.ByteReadChannel;
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
/* compiled from: ContentConverter.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.serialization.ContentConverterKt$deserialize$result$2", f = "ContentConverter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ContentConverterKt$deserialize$result$2 extends SuspendLambda implements Function2<Object, Continuation<? super Boolean>, Object> {
    final /* synthetic */ ByteReadChannel $body;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentConverterKt$deserialize$result$2(ByteReadChannel byteReadChannel, Continuation<? super ContentConverterKt$deserialize$result$2> continuation) {
        super(2, continuation);
        this.$body = byteReadChannel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Continuation<Unit> contentConverterKt$deserialize$result$2 = new ContentConverterKt$deserialize$result$2(this.$body, continuation);
        contentConverterKt$deserialize$result$2.L$0 = obj;
        return contentConverterKt$deserialize$result$2;
    }

    public final Object invoke(Object obj, Continuation<? super Boolean> continuation) {
        return create(obj, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                Object it = this.L$0;
                return Boxing.boxBoolean(it != null || this.$body.isClosedForRead());
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}