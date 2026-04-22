package io.ktor.http.content;

import io.ktor.http.content.OutgoingContent;
import io.ktor.util.ContentEncoder;
import io.ktor.utils.io.ByteChannelCtorKt;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CompressedContent.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0005\u001a\u0004\u0018\u00010\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/http/content/OutgoingContent;", "Lio/ktor/util/ContentEncoder;", "contentEncoder", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "compressed", "(Lio/ktor/http/content/OutgoingContent;Lio/ktor/util/ContentEncoder;Lkotlin/coroutines/CoroutineContext;)Lio/ktor/http/content/OutgoingContent;", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CompressedContentKt {
    public static /* synthetic */ OutgoingContent compressed$default(OutgoingContent outgoingContent, ContentEncoder contentEncoder, CoroutineContext coroutineContext, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            coroutineContext = (CoroutineContext) EmptyCoroutineContext.INSTANCE;
        }
        return compressed(outgoingContent, contentEncoder, coroutineContext);
    }

    public static final OutgoingContent compressed(final OutgoingContent $this$compressed, ContentEncoder contentEncoder, CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter($this$compressed, "<this>");
        Intrinsics.checkNotNullParameter(contentEncoder, "contentEncoder");
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        if ($this$compressed instanceof OutgoingContent.ReadChannelContent) {
            return new CompressedReadChannelResponse($this$compressed, new Function0() { // from class: io.ktor.http.content.CompressedContentKt$$ExternalSyntheticLambda0
                public final Object invoke() {
                    ByteReadChannel compressed$lambda$0;
                    compressed$lambda$0 = CompressedContentKt.compressed$lambda$0(OutgoingContent.this);
                    return compressed$lambda$0;
                }
            }, contentEncoder, coroutineContext);
        }
        if ($this$compressed instanceof OutgoingContent.WriteChannelContent) {
            return new CompressedWriteChannelResponse((OutgoingContent.WriteChannelContent) $this$compressed, contentEncoder, coroutineContext);
        }
        if ($this$compressed instanceof OutgoingContent.ByteArrayContent) {
            return new CompressedReadChannelResponse($this$compressed, new Function0() { // from class: io.ktor.http.content.CompressedContentKt$$ExternalSyntheticLambda1
                public final Object invoke() {
                    ByteReadChannel compressed$lambda$1;
                    compressed$lambda$1 = CompressedContentKt.compressed$lambda$1(OutgoingContent.this);
                    return compressed$lambda$1;
                }
            }, contentEncoder, coroutineContext);
        }
        if (!($this$compressed instanceof OutgoingContent.NoContent) && !($this$compressed instanceof OutgoingContent.ProtocolUpgrade)) {
            if ($this$compressed instanceof OutgoingContent.ContentWrapper) {
                return compressed(((OutgoingContent.ContentWrapper) $this$compressed).delegate(), contentEncoder, coroutineContext);
            }
            throw new NoWhenBranchMatchedException();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel compressed$lambda$0(OutgoingContent $this_compressed) {
        return ((OutgoingContent.ReadChannelContent) $this_compressed).readFrom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel compressed$lambda$1(OutgoingContent $this_compressed) {
        return ByteChannelCtorKt.ByteReadChannel$default(((OutgoingContent.ByteArrayContent) $this_compressed).bytes(), 0, 0, 6, (Object) null);
    }
}