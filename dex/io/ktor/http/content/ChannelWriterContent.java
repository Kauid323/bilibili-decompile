package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChannelWriterContent.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\u0018\u00002\u00020\u0001BR\u0012'\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0002¢\u0006\u0002\b\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0003H\u0096@¢\u0006\u0004\b\u0012\u0010\u0013R5\u0010\b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0002¢\u0006\u0002\b\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0014R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lio/ktor/http/content/ChannelWriterContent;", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "Lkotlin/Function2;", "Lio/ktor/utils/io/ByteWriteChannel;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "body", "Lio/ktor/http/ContentType;", "contentType", "Lio/ktor/http/HttpStatusCode;", "status", "", "contentLength", "<init>", "(Lkotlin/jvm/functions/Function2;Lio/ktor/http/ContentType;Lio/ktor/http/HttpStatusCode;Ljava/lang/Long;)V", "channel", "writeTo", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/jvm/functions/Function2;", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "Ljava/lang/Long;", "getContentLength", "()Ljava/lang/Long;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ChannelWriterContent extends OutgoingContent.WriteChannelContent {
    private final Function2<ByteWriteChannel, Continuation<? super Unit>, Object> body;
    private final Long contentLength;
    private final ContentType contentType;
    private final HttpStatusCode status;

    public /* synthetic */ ChannelWriterContent(Function2 function2, ContentType contentType, HttpStatusCode httpStatusCode, Long l, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(function2, contentType, (i2 & 4) != 0 ? null : httpStatusCode, (i2 & 8) != 0 ? null : l);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType getContentType() {
        return this.contentType;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public HttpStatusCode getStatus() {
        return this.status;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long getContentLength() {
        return this.contentLength;
    }

    public ChannelWriterContent(Function2<? super ByteWriteChannel, ? super Continuation<? super Unit>, ? extends Object> function2, ContentType contentType, HttpStatusCode status, Long contentLength) {
        Intrinsics.checkNotNullParameter(function2, "body");
        this.body = function2;
        this.contentType = contentType;
        this.status = status;
        this.contentLength = contentLength;
    }

    @Override // io.ktor.http.content.OutgoingContent.WriteChannelContent
    public Object writeTo(ByteWriteChannel channel, Continuation<? super Unit> continuation) {
        Object invoke = this.body.invoke(channel, continuation);
        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }
}