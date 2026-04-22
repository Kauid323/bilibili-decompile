package io.ktor.http.content;

import io.ktor.http.ContentDisposition;
import io.ktor.http.ContentType;
import io.ktor.http.Headers;
import io.ktor.http.HttpHeaders;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Source;

/* compiled from: Multipart.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u001e\u001f !B\u001f\b\u0004\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u000f8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0082\u0001\u0004\"#$%¨\u0006&"}, d2 = {"Lio/ktor/http/content/PartData;", "", "Lkotlin/Function0;", "", "dispose", "Lio/ktor/http/Headers;", "headers", "<init>", "(Lkotlin/jvm/functions/Function0;Lio/ktor/http/Headers;)V", "Lkotlin/jvm/functions/Function0;", "getDispose", "()Lkotlin/jvm/functions/Function0;", "Lio/ktor/http/Headers;", "getHeaders", "()Lio/ktor/http/Headers;", "Lio/ktor/http/ContentDisposition;", "contentDisposition$delegate", "Lkotlin/Lazy;", "getContentDisposition", "()Lio/ktor/http/ContentDisposition;", "contentDisposition", "Lio/ktor/http/ContentType;", "contentType$delegate", "getContentType", "()Lio/ktor/http/ContentType;", "contentType", "", "getName", "()Ljava/lang/String;", ContentDisposition.Parameters.Name, "FormItem", "FileItem", "BinaryItem", "BinaryChannelItem", "Lio/ktor/http/content/PartData$BinaryChannelItem;", "Lio/ktor/http/content/PartData$BinaryItem;", "Lio/ktor/http/content/PartData$FileItem;", "Lio/ktor/http/content/PartData$FormItem;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class PartData {
    private final Lazy contentDisposition$delegate;
    private final Lazy contentType$delegate;
    private final Function0<Unit> dispose;
    private final Headers headers;

    public /* synthetic */ PartData(Function0 function0, Headers headers, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, headers);
    }

    private PartData(Function0<Unit> function0, Headers headers) {
        this.dispose = function0;
        this.headers = headers;
        this.contentDisposition$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: io.ktor.http.content.PartData$$ExternalSyntheticLambda0
            public final Object invoke() {
                ContentDisposition contentDisposition_delegate$lambda$1;
                contentDisposition_delegate$lambda$1 = PartData.contentDisposition_delegate$lambda$1(PartData.this);
                return contentDisposition_delegate$lambda$1;
            }
        });
        this.contentType$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: io.ktor.http.content.PartData$$ExternalSyntheticLambda1
            public final Object invoke() {
                ContentType contentType_delegate$lambda$3;
                contentType_delegate$lambda$3 = PartData.contentType_delegate$lambda$3(PartData.this);
                return contentType_delegate$lambda$3;
            }
        });
    }

    public final Function0<Unit> getDispose() {
        return this.dispose;
    }

    public final Headers getHeaders() {
        return this.headers;
    }

    /* compiled from: Multipart.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/http/content/PartData$FormItem;", "Lio/ktor/http/content/PartData;", "", "value", "Lkotlin/Function0;", "", "dispose", "Lio/ktor/http/Headers;", "partHeaders", "<init>", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lio/ktor/http/Headers;)V", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class FormItem extends PartData {
        private final String value;

        public final String getValue() {
            return this.value;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FormItem(String value, Function0<Unit> function0, Headers partHeaders) {
            super(function0, partHeaders, null);
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(function0, "dispose");
            Intrinsics.checkNotNullParameter(partHeaders, "partHeaders");
            this.value = value;
        }
    }

    /* compiled from: Multipart.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lio/ktor/http/content/PartData$FileItem;", "Lio/ktor/http/content/PartData;", "Lkotlin/Function0;", "Lio/ktor/utils/io/ByteReadChannel;", "provider", "", "dispose", "Lio/ktor/http/Headers;", "partHeaders", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lio/ktor/http/Headers;)V", "Lkotlin/jvm/functions/Function0;", "getProvider", "()Lkotlin/jvm/functions/Function0;", "", "originalFileName", "Ljava/lang/String;", "getOriginalFileName", "()Ljava/lang/String;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class FileItem extends PartData {
        private final String originalFileName;
        private final Function0<ByteReadChannel> provider;

        public final Function0<ByteReadChannel> getProvider() {
            return this.provider;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FileItem(Function0<? extends ByteReadChannel> function0, Function0<Unit> function02, Headers partHeaders) {
            super(function02, partHeaders, null);
            Intrinsics.checkNotNullParameter(function0, "provider");
            Intrinsics.checkNotNullParameter(function02, "dispose");
            Intrinsics.checkNotNullParameter(partHeaders, "partHeaders");
            this.provider = function0;
            ContentDisposition contentDisposition = getContentDisposition();
            this.originalFileName = contentDisposition != null ? contentDisposition.parameter("filename") : null;
        }

        public final String getOriginalFileName() {
            return this.originalFileName;
        }
    }

    /* compiled from: Multipart.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0010\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR!\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/http/content/PartData$BinaryItem;", "Lio/ktor/http/content/PartData;", "Lkotlin/Function0;", "Lkotlinx/io/Source;", "Lio/ktor/utils/io/core/Input;", "provider", "", "dispose", "Lio/ktor/http/Headers;", "partHeaders", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lio/ktor/http/Headers;)V", "Lkotlin/jvm/functions/Function0;", "getProvider", "()Lkotlin/jvm/functions/Function0;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class BinaryItem extends PartData {
        private final Function0<Source> provider;

        public final Function0<Source> getProvider() {
            return this.provider;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BinaryItem(Function0<? extends Source> function0, Function0<Unit> function02, Headers partHeaders) {
            super(function02, partHeaders, null);
            Intrinsics.checkNotNullParameter(function0, "provider");
            Intrinsics.checkNotNullParameter(function02, "dispose");
            Intrinsics.checkNotNullParameter(partHeaders, "partHeaders");
            this.provider = function0;
        }
    }

    /* compiled from: Multipart.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/ktor/http/content/PartData$BinaryChannelItem;", "Lio/ktor/http/content/PartData;", "Lkotlin/Function0;", "Lio/ktor/utils/io/ByteReadChannel;", "provider", "Lio/ktor/http/Headers;", "partHeaders", "<init>", "(Lkotlin/jvm/functions/Function0;Lio/ktor/http/Headers;)V", "Lkotlin/jvm/functions/Function0;", "getProvider", "()Lkotlin/jvm/functions/Function0;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class BinaryChannelItem extends PartData {
        private final Function0<ByteReadChannel> provider;

        public final Function0<ByteReadChannel> getProvider() {
            return this.provider;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BinaryChannelItem(Function0<? extends ByteReadChannel> function0, Headers partHeaders) {
            super(new Function0() { // from class: io.ktor.http.content.PartData$BinaryChannelItem$$ExternalSyntheticLambda0
                public final Object invoke() {
                    Unit unit;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            }, partHeaders, null);
            Intrinsics.checkNotNullParameter(function0, "provider");
            Intrinsics.checkNotNullParameter(partHeaders, "partHeaders");
            this.provider = function0;
        }
    }

    public final ContentDisposition getContentDisposition() {
        return (ContentDisposition) this.contentDisposition$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentDisposition contentDisposition_delegate$lambda$1(PartData this$0) {
        String it = this$0.headers.get(HttpHeaders.INSTANCE.getContentDisposition());
        if (it != null) {
            return ContentDisposition.Companion.parse(it);
        }
        return null;
    }

    public final ContentType getContentType() {
        return (ContentType) this.contentType$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentType contentType_delegate$lambda$3(PartData this$0) {
        String it = this$0.headers.get(HttpHeaders.INSTANCE.getContentType());
        if (it != null) {
            return ContentType.Companion.parse(it);
        }
        return null;
    }

    public final String getName() {
        ContentDisposition contentDisposition = getContentDisposition();
        if (contentDisposition != null) {
            return contentDisposition.getName();
        }
        return null;
    }
}