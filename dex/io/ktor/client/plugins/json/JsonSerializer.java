package io.ktor.client.plugins.json;

import im.setting.UtilsKt;
import io.ktor.http.ContentType;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.reflect.TypeInfo;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Source;

/* compiled from: JsonSerializer.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "Please use ContentNegotiation plugin and its converters: https://ktor.io/docs/migration-to-20x.html#serialization-client")
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0006\u0010\bJ#\u0010\u000e\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\n\u0010\r\u001a\u00060\u000bj\u0002`\fH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/ktor/client/plugins/json/JsonSerializer;", "", UtilsKt.DATA_KEY, "Lio/ktor/http/ContentType;", "contentType", "Lio/ktor/http/content/OutgoingContent;", "write", "(Ljava/lang/Object;Lio/ktor/http/ContentType;)Lio/ktor/http/content/OutgoingContent;", "(Ljava/lang/Object;)Lio/ktor/http/content/OutgoingContent;", "Lio/ktor/util/reflect/TypeInfo;", "type", "Lkotlinx/io/Source;", "Lio/ktor/utils/io/core/Input;", "body", "read", "(Lio/ktor/util/reflect/TypeInfo;Lkotlinx/io/Source;)Ljava/lang/Object;", "ktor-client-json"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface JsonSerializer {
    Object read(TypeInfo typeInfo, Source source);

    OutgoingContent write(Object obj);

    OutgoingContent write(Object obj, ContentType contentType);

    /* compiled from: JsonSerializer.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DefaultImpls {
        public static OutgoingContent write(JsonSerializer $this, Object data) {
            Intrinsics.checkNotNullParameter(data, UtilsKt.DATA_KEY);
            return $this.write(data, ContentType.Application.INSTANCE.getJson());
        }
    }
}