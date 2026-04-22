package io.ktor.client.request.forms;

import faceverify.q;
import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.HttpUrlEncodedKt;
import io.ktor.http.Parameters;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: FormDataContent.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001a\u0010\u000f\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u00020\u00138\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lio/ktor/client/request/forms/FormDataContent;", "Lio/ktor/http/content/OutgoingContent$ByteArrayContent;", "Lio/ktor/http/Parameters;", "formData", "<init>", "(Lio/ktor/http/Parameters;)V", "", "bytes", "()[B", "Lio/ktor/http/Parameters;", "getFormData", "()Lio/ktor/http/Parameters;", q.KEY_RES_9_CONTENT, "[B", "", "contentLength", "J", "getContentLength", "()Ljava/lang/Long;", "Lio/ktor/http/ContentType;", "contentType", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FormDataContent extends OutgoingContent.ByteArrayContent {
    private final byte[] content;
    private final long contentLength;
    private final ContentType contentType;
    private final Parameters formData;

    public final Parameters getFormData() {
        return this.formData;
    }

    public FormDataContent(Parameters formData) {
        Intrinsics.checkNotNullParameter(formData, "formData");
        this.formData = formData;
        this.content = StringsKt.toByteArray$default(HttpUrlEncodedKt.formUrlEncode(this.formData), (Charset) null, 1, (Object) null);
        this.contentLength = this.content.length;
        this.contentType = ContentTypesKt.withCharset(ContentType.Application.INSTANCE.getFormUrlEncoded(), Charsets.UTF_8);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long getContentLength() {
        return Long.valueOf(this.contentLength);
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType getContentType() {
        return this.contentType;
    }

    @Override // io.ktor.http.content.OutgoingContent.ByteArrayContent
    public byte[] bytes() {
        return this.content;
    }
}