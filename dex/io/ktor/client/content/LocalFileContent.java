package io.ktor.client.content;

import io.ktor.http.ContentType;
import io.ktor.http.FileContentTypeJvmKt;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.cio.FileChannelsKt;
import io.ktor.utils.io.ByteReadChannel;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;

/* compiled from: LocalFileContent.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\t\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lio/ktor/client/content/LocalFileContent;", "Lio/ktor/http/content/OutgoingContent$ReadChannelContent;", "Ljava/io/File;", "file", "Lio/ktor/http/ContentType;", "contentType", "<init>", "(Ljava/io/File;Lio/ktor/http/ContentType;)V", "Lio/ktor/utils/io/ByteReadChannel;", "readFrom", "()Lio/ktor/utils/io/ByteReadChannel;", "Lkotlin/ranges/LongRange;", "range", "(Lkotlin/ranges/LongRange;)Lio/ktor/utils/io/ByteReadChannel;", "Ljava/io/File;", "getFile", "()Ljava/io/File;", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "", "getContentLength", "()Ljava/lang/Long;", "contentLength", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LocalFileContent extends OutgoingContent.ReadChannelContent {
    private final ContentType contentType;
    private final File file;

    public /* synthetic */ LocalFileContent(File file, ContentType contentType, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i2 & 2) != 0 ? FileContentTypeJvmKt.defaultForFile(ContentType.Companion, file) : contentType);
    }

    public final File getFile() {
        return this.file;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType getContentType() {
        return this.contentType;
    }

    public LocalFileContent(File file, ContentType contentType) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        this.file = file;
        this.contentType = contentType;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long getContentLength() {
        return Long.valueOf(this.file.length());
    }

    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
    public ByteReadChannel readFrom() {
        return FileChannelsKt.readChannel$default(this.file, 0L, 0L, (CoroutineContext) null, 7, (Object) null);
    }

    @Override // io.ktor.http.content.OutgoingContent.ReadChannelContent
    public ByteReadChannel readFrom(LongRange range) {
        Intrinsics.checkNotNullParameter(range, "range");
        return FileChannelsKt.readChannel$default(this.file, range.getFirst(), range.getLast(), (CoroutineContext) null, 4, (Object) null);
    }
}