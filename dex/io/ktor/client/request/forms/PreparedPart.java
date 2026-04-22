package io.ktor.client.request.forms;

import io.ktor.http.ContentDisposition;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Source;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FormDataContent.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB\u001b\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r\u0082\u0001\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/ktor/client/request/forms/PreparedPart;", "", "", "headers", "", ContentDisposition.Parameters.Size, "<init>", "([BLjava/lang/Long;)V", "[B", "getHeaders", "()[B", "Ljava/lang/Long;", "getSize", "()Ljava/lang/Long;", "InputPart", "ChannelPart", "Lio/ktor/client/request/forms/PreparedPart$ChannelPart;", "Lio/ktor/client/request/forms/PreparedPart$InputPart;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class PreparedPart {
    private final byte[] headers;
    private final Long size;

    public /* synthetic */ PreparedPart(byte[] bArr, Long l, DefaultConstructorMarker defaultConstructorMarker) {
        this(bArr, l);
    }

    private PreparedPart(byte[] headers, Long size) {
        this.headers = headers;
        this.size = size;
    }

    public final byte[] getHeaders() {
        return this.headers;
    }

    public final Long getSize() {
        return this.size;
    }

    /* compiled from: FormDataContent.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0010\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bR!\u0010\u0007\u001a\f\u0012\b\u0012\u00060\u0005j\u0002`\u00060\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lio/ktor/client/request/forms/PreparedPart$InputPart;", "Lio/ktor/client/request/forms/PreparedPart;", "", "headers", "Lkotlin/Function0;", "Lkotlinx/io/Source;", "Lio/ktor/utils/io/core/Input;", "provider", "", ContentDisposition.Parameters.Size, "<init>", "([BLkotlin/jvm/functions/Function0;Ljava/lang/Long;)V", "Lkotlin/jvm/functions/Function0;", "getProvider", "()Lkotlin/jvm/functions/Function0;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class InputPart extends PreparedPart {
        private final Function0<Source> provider;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InputPart(byte[] headers, Function0<? extends Source> function0, Long size) {
            super(headers, size, null);
            Intrinsics.checkNotNullParameter(headers, "headers");
            Intrinsics.checkNotNullParameter(function0, "provider");
            this.provider = function0;
        }

        public final Function0<Source> getProvider() {
            return this.provider;
        }
    }

    /* compiled from: FormDataContent.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/ktor/client/request/forms/PreparedPart$ChannelPart;", "Lio/ktor/client/request/forms/PreparedPart;", "", "headers", "Lkotlin/Function0;", "Lio/ktor/utils/io/ByteReadChannel;", "provider", "", ContentDisposition.Parameters.Size, "<init>", "([BLkotlin/jvm/functions/Function0;Ljava/lang/Long;)V", "Lkotlin/jvm/functions/Function0;", "getProvider", "()Lkotlin/jvm/functions/Function0;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class ChannelPart extends PreparedPart {
        private final Function0<ByteReadChannel> provider;

        public final Function0<ByteReadChannel> getProvider() {
            return this.provider;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelPart(byte[] headers, Function0<? extends ByteReadChannel> function0, Long size) {
            super(headers, size, null);
            Intrinsics.checkNotNullParameter(headers, "headers");
            Intrinsics.checkNotNullParameter(function0, "provider");
            this.provider = function0;
        }
    }
}