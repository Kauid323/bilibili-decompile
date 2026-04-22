package io.ktor.http.content;

import io.ktor.http.ContentType;
import io.ktor.http.FileContentTypeKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.ReadingKt;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: URIFileContent.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB\u001b\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/http/content/URIFileContent;", "Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "Ljava/net/URI;", "uri", "Lio/ktor/http/ContentType;", "contentType", "", "contentLength", "<init>", "(Ljava/net/URI;Lio/ktor/http/ContentType;Ljava/lang/Long;)V", "Ljava/net/URL;", "url", "(Ljava/net/URL;Lio/ktor/http/ContentType;)V", "Lio/ktor/utils/io/ByteReadChannel;", "readFrom", "()Lio/ktor/utils/io/ByteReadChannel;", "Ljava/net/URI;", "getUri", "()Ljava/net/URI;", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "Ljava/lang/Long;", "getContentLength", "()Ljava/lang/Long;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class URIFileContent extends OutgoingContent.ReadChannelContent {
    private final Long contentLength;
    private final ContentType contentType;
    private final URI uri;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ URIFileContent(URI uri, ContentType contentType, Long l, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(uri, contentType, (i2 & 4) != 0 ? null : l);
        if ((i2 & 2) != 0) {
            ContentType.Companion companion = ContentType.Companion;
            String path = uri.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
            contentType = FileContentTypeKt.defaultForFilePath(companion, path);
        }
    }

    public final URI getUri() {
        return this.uri;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType getContentType() {
        return this.contentType;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long getContentLength() {
        return this.contentLength;
    }

    public URIFileContent(URI uri, ContentType contentType, Long contentLength) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        this.uri = uri;
        this.contentType = contentType;
        this.contentLength = contentLength;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public URIFileContent(URL url, ContentType contentType) {
        this(r2, contentType, null, 4, null);
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        URI uri = url.toURI();
        Intrinsics.checkNotNullExpressionValue(uri, "toURI(...)");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ URIFileContent(URL url, ContentType contentType, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(url, contentType);
        if ((i2 & 2) != 0) {
            ContentType.Companion companion = ContentType.Companion;
            String path = url.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
            contentType = FileContentTypeKt.defaultForFilePath(companion, path);
        }
    }

    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
    public ByteReadChannel readFrom() {
        InputStream openStream = this.uri.toURL().openStream();
        Intrinsics.checkNotNullExpressionValue(openStream, "openStream(...)");
        return ReadingKt.toByteReadChannel$default(openStream, (CoroutineContext) null, ByteBufferPoolKt.getKtorDefaultPool(), 1, (Object) null);
    }
}