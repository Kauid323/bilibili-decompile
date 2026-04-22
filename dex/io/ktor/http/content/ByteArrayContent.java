package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteArrayContent.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lio/ktor/http/content/ByteArrayContent;", "Lio/ktor/http/content/OutgoingContent$ByteArrayContent;", "", "bytes", "Lio/ktor/http/ContentType;", "contentType", "Lio/ktor/http/HttpStatusCode;", "status", "<init>", "([BLio/ktor/http/ContentType;Lio/ktor/http/HttpStatusCode;)V", "()[B", "[B", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "Lio/ktor/http/HttpStatusCode;", "getStatus", "()Lio/ktor/http/HttpStatusCode;", "", "getContentLength", "()Ljava/lang/Long;", "contentLength", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ByteArrayContent extends OutgoingContent.ByteArrayContent {
    private final byte[] bytes;
    private final ContentType contentType;
    private final HttpStatusCode status;

    public /* synthetic */ ByteArrayContent(byte[] bArr, ContentType contentType, HttpStatusCode httpStatusCode, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, (i2 & 2) != 0 ? null : contentType, (i2 & 4) != 0 ? null : httpStatusCode);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType getContentType() {
        return this.contentType;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public HttpStatusCode getStatus() {
        return this.status;
    }

    public ByteArrayContent(byte[] bytes, ContentType contentType, HttpStatusCode status) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.bytes = bytes;
        this.contentType = contentType;
        this.status = status;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long getContentLength() {
        return Long.valueOf(this.bytes.length);
    }

    @Override // io.ktor.http.content.OutgoingContent.ByteArrayContent
    public byte[] bytes() {
        return this.bytes;
    }
}