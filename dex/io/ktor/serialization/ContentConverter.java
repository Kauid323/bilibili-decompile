package io.ktor.serialization;

import faceverify.q;
import io.ktor.http.ContentType;
import io.ktor.http.auth.HttpAuthHeader;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* compiled from: ContentConverter.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J8\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0001H¦@¢\u0006\u0004\b\u000b\u0010\fJ.\u0010\u000f\u001a\u0004\u0018\u00010\u00012\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH¦@¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lio/ktor/serialization/ContentConverter;", "", "Lio/ktor/http/ContentType;", "contentType", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", HttpAuthHeader.Parameters.Charset, "Lio/ktor/util/reflect/TypeInfo;", "typeInfo", "value", "Lio/ktor/http/content/OutgoingContent;", "serialize", "(Lio/ktor/http/ContentType;Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/utils/io/ByteReadChannel;", q.KEY_RES_9_CONTENT, "deserialize", "(Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-serialization"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ContentConverter {
    Object deserialize(Charset charset, TypeInfo typeInfo, ByteReadChannel byteReadChannel, Continuation<Object> continuation);

    Object serialize(ContentType contentType, Charset charset, TypeInfo typeInfo, Object obj, Continuation<? super OutgoingContent> continuation);
}