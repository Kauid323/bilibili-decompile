package io.ktor.client.request.forms;

import io.ktor.client.request.forms.PreparedPart;
import io.ktor.http.ContentType;
import io.ktor.http.HttpHeaders;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.PartData;
import io.ktor.sse.ServerSentEventKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelOperationsKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelOperationsKt;
import io.ktor.utils.io.core.BytePacketBuilderKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.io.Buffer;
import kotlinx.io.Sink;
import kotlinx.io.Source;
import kotlinx.io.SourcesKt;

/* compiled from: FormDataContent.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001cR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R(\u0010#\u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010!8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lio/ktor/client/request/forms/MultiPartFormDataContent;", "Lio/ktor/http/content/OutgoingContent$WriteChannelContent;", "", "Lio/ktor/http/content/PartData;", "parts", "", "boundary", "Lio/ktor/http/ContentType;", "contentType", "<init>", "(Ljava/util/List;Ljava/lang/String;Lio/ktor/http/ContentType;)V", "Lio/ktor/utils/io/ByteWriteChannel;", "channel", "", "writeTo", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ljava/lang/String;", "getBoundary", "()Ljava/lang/String;", "Lio/ktor/http/ContentType;", "getContentType", "()Lio/ktor/http/ContentType;", "", "BOUNDARY_BYTES", "[B", "LAST_BOUNDARY_BYTES", "", "BODY_OVERHEAD_SIZE", "I", "PART_OVERHEAD_SIZE", "Lio/ktor/client/request/forms/PreparedPart;", "rawParts", "Ljava/util/List;", "", "value", "contentLength", "Ljava/lang/Long;", "getContentLength", "()Ljava/lang/Long;", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MultiPartFormDataContent extends OutgoingContent.WriteChannelContent {
    private final int BODY_OVERHEAD_SIZE;
    private final byte[] BOUNDARY_BYTES;
    private final byte[] LAST_BOUNDARY_BYTES;
    private final int PART_OVERHEAD_SIZE;
    private final String boundary;
    private Long contentLength;
    private final ContentType contentType;
    private final List<PreparedPart> rawParts;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ MultiPartFormDataContent(List list, String str, ContentType contentType, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, (i2 & 4) != 0 ? ContentType.MultiPart.INSTANCE.getFormData().withParameter("boundary", str) : contentType);
        str = (i2 & 2) != 0 ? FormDataContentKt.access$generateBoundary() : str;
    }

    public final String getBoundary() {
        return this.boundary;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public ContentType getContentType() {
        return this.contentType;
    }

    public MultiPartFormDataContent(List<? extends PartData> list, String boundary, ContentType contentType) {
        Iterable $this$map$iv;
        boolean z;
        PreparedPart channelPart;
        Intrinsics.checkNotNullParameter(list, "parts");
        Intrinsics.checkNotNullParameter(boundary, "boundary");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        this.boundary = boundary;
        this.contentType = contentType;
        this.BOUNDARY_BYTES = StringsKt.toByteArray$default("--" + this.boundary + ServerSentEventKt.END_OF_LINE, (Charset) null, 1, (Object) null);
        this.LAST_BOUNDARY_BYTES = StringsKt.toByteArray$default("--" + this.boundary + "--\r\n", (Charset) null, 1, (Object) null);
        this.BODY_OVERHEAD_SIZE = this.LAST_BOUNDARY_BYTES.length;
        this.PART_OVERHEAD_SIZE = (FormDataContentKt.access$getRN_BYTES$p().length * 2) + this.BOUNDARY_BYTES.length;
        List<? extends PartData> $this$map$iv2 = list;
        boolean z2 = false;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv : $this$map$iv2) {
            PartData part = (PartData) item$iv$iv;
            Sink headersBuilder = BytePacketBuilderKt.BytePacketBuilder();
            for (Map.Entry entry : part.getHeaders().entries()) {
                String key = (String) entry.getKey();
                List values = (List) entry.getValue();
                StringsKt.writeText$default(headersBuilder, key + ": " + CollectionsKt.joinToString$default(values, "; ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), 0, 0, (Charset) null, 14, (Object) null);
                BytePacketBuilderKt.writeFully$default(headersBuilder, FormDataContentKt.access$getRN_BYTES$p(), 0, 0, 6, (Object) null);
            }
            String str = part.getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
            Long bodySize = str != null ? Long.valueOf(Long.parseLong(str)) : null;
            if (part instanceof PartData.FileItem) {
                byte[] headers = SourcesKt.readByteArray(BytePacketBuilderKt.build(headersBuilder));
                channelPart = new PreparedPart.ChannelPart(headers, ((PartData.FileItem) part).getProvider(), bodySize != null ? Long.valueOf(bodySize.longValue() + this.PART_OVERHEAD_SIZE + headers.length) : null);
                $this$map$iv = $this$map$iv2;
                z = z2;
            } else if (part instanceof PartData.BinaryItem) {
                byte[] headers2 = SourcesKt.readByteArray(BytePacketBuilderKt.build(headersBuilder));
                channelPart = new PreparedPart.InputPart(headers2, ((PartData.BinaryItem) part).getProvider(), bodySize != null ? Long.valueOf(bodySize.longValue() + this.PART_OVERHEAD_SIZE + headers2.length) : null);
                $this$map$iv = $this$map$iv2;
                z = z2;
            } else if (!(part instanceof PartData.FormItem)) {
                $this$map$iv = $this$map$iv2;
                z = z2;
                if (!(part instanceof PartData.BinaryChannelItem)) {
                    throw new NoWhenBranchMatchedException();
                }
                byte[] headers3 = SourcesKt.readByteArray(BytePacketBuilderKt.build(headersBuilder));
                channelPart = new PreparedPart.ChannelPart(headers3, ((PartData.BinaryChannelItem) part).getProvider(), bodySize != null ? Long.valueOf(bodySize.longValue() + this.PART_OVERHEAD_SIZE + headers3.length) : null);
            } else {
                Source buffer = new Buffer();
                Sink $this$rawParts_u24lambda_u243_u24lambda_u240 = (Sink) buffer;
                StringsKt.writeText$default($this$rawParts_u24lambda_u243_u24lambda_u240, ((PartData.FormItem) part).getValue(), 0, 0, (Charset) null, 14, (Object) null);
                final byte[] bytes = SourcesKt.readByteArray(buffer);
                Function0 provider = new Function0() { // from class: io.ktor.client.request.forms.MultiPartFormDataContent$$ExternalSyntheticLambda0
                    public final Object invoke() {
                        Source rawParts$lambda$3$lambda$2;
                        rawParts$lambda$3$lambda$2 = MultiPartFormDataContent.rawParts$lambda$3$lambda$2(bytes);
                        return rawParts$lambda$3$lambda$2;
                    }
                };
                if (bodySize == null) {
                    StringsKt.writeText$default(headersBuilder, HttpHeaders.INSTANCE.getContentLength() + ": " + bytes.length, 0, 0, (Charset) null, 14, (Object) null);
                    BytePacketBuilderKt.writeFully$default(headersBuilder, FormDataContentKt.access$getRN_BYTES$p(), 0, 0, 6, (Object) null);
                }
                byte[] headers4 = SourcesKt.readByteArray(BytePacketBuilderKt.build(headersBuilder));
                $this$map$iv = $this$map$iv2;
                z = z2;
                channelPart = new PreparedPart.InputPart(headers4, provider, Long.valueOf(bytes.length + this.PART_OVERHEAD_SIZE + headers4.length));
            }
            destination$iv$iv.add(channelPart);
            $this$map$iv2 = $this$map$iv;
            z2 = z;
        }
        this.rawParts = (List) destination$iv$iv;
        Long rawLength = 0L;
        Iterator<PreparedPart> it = this.rawParts.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Long size = it.next().getSize();
            if (size == null) {
                rawLength = null;
                break;
            }
            rawLength = rawLength != null ? Long.valueOf(rawLength.longValue() + size.longValue()) : null;
        }
        this.contentLength = rawLength != null ? Long.valueOf(rawLength.longValue() + this.BODY_OVERHEAD_SIZE) : rawLength;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Source rawParts$lambda$3$lambda$2(byte[] $bytes) {
        Source buffer = new Buffer();
        Sink $this$rawParts_u24lambda_u243_u24lambda_u242_u24lambda_u241 = (Sink) buffer;
        BytePacketBuilderKt.writeFully$default($this$rawParts_u24lambda_u243_u24lambda_u242_u24lambda_u241, $bytes, 0, 0, 6, (Object) null);
        return buffer;
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long getContentLength() {
        return this.contentLength;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:3|(4:5|6|7|8))|121|6|7|8|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0227, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d2, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d3, code lost:
        r7 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0197, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0198, code lost:
        r7 = r9;
     */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00d3: MOVE  (r7 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY] A[D('channel' io.ktor.utils.io.ByteWriteChannel)]), block:B:38:0x00d3 */
    /* JADX WARN: Not initialized variable reg: 9, insn: 0x0198: MOVE  (r7 I:??[OBJECT, ARRAY]) = (r9 I:??[OBJECT, ARRAY] A[D('channel' io.ktor.utils.io.ByteWriteChannel)]), block:B:68:0x0198 */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0225 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x023d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ec A[Catch: all -> 0x01fd, TryCatch #8 {all -> 0x01fd, blocks: (B:42:0x00e6, B:44:0x00ec, B:48:0x0115, B:52:0x0138, B:85:0x01d2, B:96:0x0200), top: B:126:0x00e6 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0135 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0158 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0161 A[Catch: all -> 0x01fb, TRY_LEAVE, TryCatch #7 {all -> 0x01fb, blocks: (B:57:0x015d, B:59:0x0161, B:78:0x01ac, B:80:0x01b0, B:90:0x01f5, B:91:0x01fa), top: B:124:0x015d }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ac A[Catch: all -> 0x01fb, TRY_ENTER, TryCatch #7 {all -> 0x01fb, blocks: (B:57:0x015d, B:59:0x0161, B:78:0x01ac, B:80:0x01b0, B:90:0x01f5, B:91:0x01fa), top: B:124:0x015d }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01ed A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0200 A[Catch: all -> 0x01fd, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x01fd, blocks: (B:42:0x00e6, B:44:0x00ec, B:48:0x0115, B:52:0x0138, B:85:0x01d2, B:96:0x0200), top: B:126:0x00e6 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x01ee -> B:126:0x00e6). Please submit an issue!!! */
    @Override // io.ktor.http.content.OutgoingContent.WriteChannelContent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object writeTo(ByteWriteChannel channel, Continuation<? super Unit> continuation) {
        MultiPartFormDataContent$writeTo$1 multiPartFormDataContent$writeTo$1;
        MultiPartFormDataContent$writeTo$1 multiPartFormDataContent$writeTo$12;
        ByteWriteChannel channel2;
        MultiPartFormDataContent multiPartFormDataContent;
        ByteWriteChannel channel3;
        Iterator<PreparedPart> it;
        PreparedPart part;
        MultiPartFormDataContent multiPartFormDataContent2;
        MultiPartFormDataContent multiPartFormDataContent3;
        MultiPartFormDataContent multiPartFormDataContent4;
        AutoCloseable autoCloseable;
        Iterator<PreparedPart> it2;
        ByteWriteChannel channel4;
        MultiPartFormDataContent multiPartFormDataContent5;
        Iterator<PreparedPart> it3;
        MultiPartFormDataContent multiPartFormDataContent6;
        byte[] access$getRN_BYTES$p;
        byte[] access$getRN_BYTES$p2;
        byte[] headers;
        ByteWriteChannel channel5;
        if (continuation instanceof MultiPartFormDataContent$writeTo$1) {
            multiPartFormDataContent$writeTo$1 = (MultiPartFormDataContent$writeTo$1) continuation;
            if ((multiPartFormDataContent$writeTo$1.label & Integer.MIN_VALUE) != 0) {
                multiPartFormDataContent$writeTo$1.label -= Integer.MIN_VALUE;
                multiPartFormDataContent$writeTo$12 = multiPartFormDataContent$writeTo$1;
                Object $result = multiPartFormDataContent$writeTo$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (multiPartFormDataContent$writeTo$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        multiPartFormDataContent = this;
                        channel3 = channel;
                        it = multiPartFormDataContent.rawParts.iterator();
                        try {
                        } catch (Throwable th) {
                            cause = th;
                            channel2 = channel3;
                            try {
                                ByteWriteChannelOperationsKt.close(channel2, cause);
                                multiPartFormDataContent$writeTo$12.L$0 = null;
                                multiPartFormDataContent$writeTo$12.L$1 = null;
                                multiPartFormDataContent$writeTo$12.L$2 = null;
                                multiPartFormDataContent$writeTo$12.L$3 = null;
                                multiPartFormDataContent$writeTo$12.label = 9;
                                if (channel2.flushAndClose(multiPartFormDataContent$writeTo$12) == coroutine_suspended) {
                                }
                                return Unit.INSTANCE;
                            } catch (Throwable th2) {
                                multiPartFormDataContent$writeTo$12.L$0 = th2;
                                multiPartFormDataContent$writeTo$12.L$1 = null;
                                multiPartFormDataContent$writeTo$12.L$2 = null;
                                multiPartFormDataContent$writeTo$12.L$3 = null;
                                multiPartFormDataContent$writeTo$12.label = 10;
                                if (channel2.flushAndClose(multiPartFormDataContent$writeTo$12) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                throw th2;
                            }
                        }
                        if (it.hasNext()) {
                            PreparedPart part2 = it.next();
                            byte[] bArr = multiPartFormDataContent.BOUNDARY_BYTES;
                            multiPartFormDataContent$writeTo$12.L$0 = multiPartFormDataContent;
                            multiPartFormDataContent$writeTo$12.L$1 = channel3;
                            multiPartFormDataContent$writeTo$12.L$2 = it;
                            multiPartFormDataContent$writeTo$12.L$3 = part2;
                            multiPartFormDataContent$writeTo$12.label = 1;
                            if (ByteWriteChannelOperationsKt.writeFully$default(channel3, bArr, 0, 0, multiPartFormDataContent$writeTo$12, 6, (Object) null) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            multiPartFormDataContent2 = multiPartFormDataContent;
                            part = part2;
                            headers = part.getHeaders();
                            multiPartFormDataContent$writeTo$12.L$0 = multiPartFormDataContent2;
                            multiPartFormDataContent$writeTo$12.L$1 = channel3;
                            multiPartFormDataContent$writeTo$12.L$2 = it;
                            multiPartFormDataContent$writeTo$12.L$3 = part;
                            multiPartFormDataContent$writeTo$12.label = 2;
                            MultiPartFormDataContent multiPartFormDataContent7 = multiPartFormDataContent2;
                            if (ByteWriteChannelOperationsKt.writeFully$default(channel3, headers, 0, 0, multiPartFormDataContent$writeTo$12, 6, (Object) null) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            multiPartFormDataContent3 = multiPartFormDataContent7;
                            access$getRN_BYTES$p2 = FormDataContentKt.access$getRN_BYTES$p();
                            multiPartFormDataContent$writeTo$12.L$0 = multiPartFormDataContent3;
                            multiPartFormDataContent$writeTo$12.L$1 = channel3;
                            multiPartFormDataContent$writeTo$12.L$2 = it;
                            multiPartFormDataContent$writeTo$12.L$3 = part;
                            multiPartFormDataContent$writeTo$12.label = 3;
                            MultiPartFormDataContent multiPartFormDataContent8 = multiPartFormDataContent3;
                            if (ByteWriteChannelOperationsKt.writeFully$default(channel3, access$getRN_BYTES$p2, 0, 0, multiPartFormDataContent$writeTo$12, 6, (Object) null) != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            channel2 = channel3;
                            multiPartFormDataContent4 = multiPartFormDataContent8;
                            try {
                            } catch (Throwable th3) {
                                cause = th3;
                                ByteWriteChannelOperationsKt.close(channel2, cause);
                                multiPartFormDataContent$writeTo$12.L$0 = null;
                                multiPartFormDataContent$writeTo$12.L$1 = null;
                                multiPartFormDataContent$writeTo$12.L$2 = null;
                                multiPartFormDataContent$writeTo$12.L$3 = null;
                                multiPartFormDataContent$writeTo$12.label = 9;
                                if (channel2.flushAndClose(multiPartFormDataContent$writeTo$12) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                return Unit.INSTANCE;
                            }
                            if (part instanceof PreparedPart.InputPart) {
                                AutoCloseable autoCloseable2 = (AutoCloseable) ((PreparedPart.InputPart) part).getProvider().invoke();
                                try {
                                    Source input = (Source) autoCloseable2;
                                    multiPartFormDataContent$writeTo$12.L$0 = multiPartFormDataContent4;
                                    multiPartFormDataContent$writeTo$12.L$1 = channel2;
                                    multiPartFormDataContent$writeTo$12.L$2 = it;
                                    multiPartFormDataContent$writeTo$12.L$3 = autoCloseable2;
                                    multiPartFormDataContent$writeTo$12.label = 4;
                                    if (FormDataContentKt.access$copyTo(input, channel2, multiPartFormDataContent$writeTo$12) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    multiPartFormDataContent5 = multiPartFormDataContent4;
                                    it2 = it;
                                    channel4 = channel2;
                                    autoCloseable = autoCloseable2;
                                    try {
                                        Unit unit = Unit.INSTANCE;
                                        AutoCloseableKt.closeFinally(autoCloseable, (Throwable) null);
                                        Unit unit2 = Unit.INSTANCE;
                                        it3 = it2;
                                        channel3 = channel4;
                                        multiPartFormDataContent6 = multiPartFormDataContent5;
                                        access$getRN_BYTES$p = FormDataContentKt.access$getRN_BYTES$p();
                                        multiPartFormDataContent$writeTo$12.L$0 = multiPartFormDataContent6;
                                        multiPartFormDataContent$writeTo$12.L$1 = channel3;
                                        multiPartFormDataContent$writeTo$12.L$2 = it3;
                                        multiPartFormDataContent$writeTo$12.L$3 = null;
                                        multiPartFormDataContent$writeTo$12.label = 6;
                                        if (ByteWriteChannelOperationsKt.writeFully$default(channel3, access$getRN_BYTES$p, 0, 0, multiPartFormDataContent$writeTo$12, 6, (Object) null) != coroutine_suspended) {
                                        }
                                    } catch (Throwable th4) {
                                        throw th4;
                                    }
                                } catch (Throwable th5) {
                                    throw th5;
                                }
                            } else if (!(part instanceof PreparedPart.ChannelPart)) {
                                throw new NoWhenBranchMatchedException();
                            } else {
                                multiPartFormDataContent$writeTo$12.L$0 = multiPartFormDataContent4;
                                multiPartFormDataContent$writeTo$12.L$1 = channel2;
                                multiPartFormDataContent$writeTo$12.L$2 = it;
                                multiPartFormDataContent$writeTo$12.L$3 = null;
                                multiPartFormDataContent$writeTo$12.label = 5;
                                if (ByteReadChannelOperationsKt.copyTo((ByteReadChannel) ((PreparedPart.ChannelPart) part).getProvider().invoke(), channel2, multiPartFormDataContent$writeTo$12) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                it3 = it;
                                channel3 = channel2;
                                multiPartFormDataContent6 = multiPartFormDataContent4;
                                access$getRN_BYTES$p = FormDataContentKt.access$getRN_BYTES$p();
                                multiPartFormDataContent$writeTo$12.L$0 = multiPartFormDataContent6;
                                multiPartFormDataContent$writeTo$12.L$1 = channel3;
                                multiPartFormDataContent$writeTo$12.L$2 = it3;
                                multiPartFormDataContent$writeTo$12.L$3 = null;
                                multiPartFormDataContent$writeTo$12.label = 6;
                                if (ByteWriteChannelOperationsKt.writeFully$default(channel3, access$getRN_BYTES$p, 0, 0, multiPartFormDataContent$writeTo$12, 6, (Object) null) != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                MultiPartFormDataContent multiPartFormDataContent9 = multiPartFormDataContent6;
                                it = it3;
                                multiPartFormDataContent = multiPartFormDataContent9;
                                if (it.hasNext()) {
                                    byte[] bArr2 = multiPartFormDataContent.LAST_BOUNDARY_BYTES;
                                    multiPartFormDataContent$writeTo$12.L$0 = channel3;
                                    multiPartFormDataContent$writeTo$12.L$1 = null;
                                    multiPartFormDataContent$writeTo$12.L$2 = null;
                                    multiPartFormDataContent$writeTo$12.label = 7;
                                    if (ByteWriteChannelOperationsKt.writeFully$default(channel3, bArr2, 0, 0, multiPartFormDataContent$writeTo$12, 6, (Object) null) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    channel5 = channel3;
                                    multiPartFormDataContent$writeTo$12.L$0 = null;
                                    multiPartFormDataContent$writeTo$12.label = 8;
                                    if (channel5.flushAndClose(multiPartFormDataContent$writeTo$12) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                        }
                    case 1:
                        part = (PreparedPart) multiPartFormDataContent$writeTo$12.L$3;
                        Iterator<PreparedPart> it4 = (Iterator) multiPartFormDataContent$writeTo$12.L$2;
                        ByteWriteChannel channel6 = (ByteWriteChannel) multiPartFormDataContent$writeTo$12.L$1;
                        MultiPartFormDataContent multiPartFormDataContent10 = (MultiPartFormDataContent) multiPartFormDataContent$writeTo$12.L$0;
                        ResultKt.throwOnFailure($result);
                        it = it4;
                        channel3 = channel6;
                        multiPartFormDataContent2 = multiPartFormDataContent10;
                        headers = part.getHeaders();
                        multiPartFormDataContent$writeTo$12.L$0 = multiPartFormDataContent2;
                        multiPartFormDataContent$writeTo$12.L$1 = channel3;
                        multiPartFormDataContent$writeTo$12.L$2 = it;
                        multiPartFormDataContent$writeTo$12.L$3 = part;
                        multiPartFormDataContent$writeTo$12.label = 2;
                        MultiPartFormDataContent multiPartFormDataContent72 = multiPartFormDataContent2;
                        if (ByteWriteChannelOperationsKt.writeFully$default(channel3, headers, 0, 0, multiPartFormDataContent$writeTo$12, 6, (Object) null) != coroutine_suspended) {
                        }
                        break;
                    case 2:
                        part = (PreparedPart) multiPartFormDataContent$writeTo$12.L$3;
                        Iterator<PreparedPart> it5 = (Iterator) multiPartFormDataContent$writeTo$12.L$2;
                        ByteWriteChannel channel7 = (ByteWriteChannel) multiPartFormDataContent$writeTo$12.L$1;
                        MultiPartFormDataContent multiPartFormDataContent11 = (MultiPartFormDataContent) multiPartFormDataContent$writeTo$12.L$0;
                        ResultKt.throwOnFailure($result);
                        it = it5;
                        channel3 = channel7;
                        multiPartFormDataContent3 = multiPartFormDataContent11;
                        access$getRN_BYTES$p2 = FormDataContentKt.access$getRN_BYTES$p();
                        multiPartFormDataContent$writeTo$12.L$0 = multiPartFormDataContent3;
                        multiPartFormDataContent$writeTo$12.L$1 = channel3;
                        multiPartFormDataContent$writeTo$12.L$2 = it;
                        multiPartFormDataContent$writeTo$12.L$3 = part;
                        multiPartFormDataContent$writeTo$12.label = 3;
                        MultiPartFormDataContent multiPartFormDataContent82 = multiPartFormDataContent3;
                        if (ByteWriteChannelOperationsKt.writeFully$default(channel3, access$getRN_BYTES$p2, 0, 0, multiPartFormDataContent$writeTo$12, 6, (Object) null) != coroutine_suspended) {
                        }
                        break;
                    case 3:
                        part = (PreparedPart) multiPartFormDataContent$writeTo$12.L$3;
                        Iterator<PreparedPart> it6 = (Iterator) multiPartFormDataContent$writeTo$12.L$2;
                        ByteWriteChannel channel8 = (ByteWriteChannel) multiPartFormDataContent$writeTo$12.L$1;
                        MultiPartFormDataContent multiPartFormDataContent12 = (MultiPartFormDataContent) multiPartFormDataContent$writeTo$12.L$0;
                        ResultKt.throwOnFailure($result);
                        it = it6;
                        channel2 = channel8;
                        multiPartFormDataContent4 = multiPartFormDataContent12;
                        if (part instanceof PreparedPart.InputPart) {
                        }
                        break;
                    case 4:
                        autoCloseable = (AutoCloseable) multiPartFormDataContent$writeTo$12.L$3;
                        it2 = (Iterator) multiPartFormDataContent$writeTo$12.L$2;
                        channel4 = (ByteWriteChannel) multiPartFormDataContent$writeTo$12.L$1;
                        multiPartFormDataContent5 = (MultiPartFormDataContent) multiPartFormDataContent$writeTo$12.L$0;
                        try {
                            ResultKt.throwOnFailure($result);
                            Unit unit3 = Unit.INSTANCE;
                            AutoCloseableKt.closeFinally(autoCloseable, (Throwable) null);
                            Unit unit22 = Unit.INSTANCE;
                            it3 = it2;
                            channel3 = channel4;
                            multiPartFormDataContent6 = multiPartFormDataContent5;
                            access$getRN_BYTES$p = FormDataContentKt.access$getRN_BYTES$p();
                            multiPartFormDataContent$writeTo$12.L$0 = multiPartFormDataContent6;
                            multiPartFormDataContent$writeTo$12.L$1 = channel3;
                            multiPartFormDataContent$writeTo$12.L$2 = it3;
                            multiPartFormDataContent$writeTo$12.L$3 = null;
                            multiPartFormDataContent$writeTo$12.label = 6;
                            if (ByteWriteChannelOperationsKt.writeFully$default(channel3, access$getRN_BYTES$p, 0, 0, multiPartFormDataContent$writeTo$12, 6, (Object) null) != coroutine_suspended) {
                            }
                        } catch (Throwable th6) {
                            throw th6;
                        }
                        break;
                    case 5:
                        it3 = (Iterator) multiPartFormDataContent$writeTo$12.L$2;
                        channel2 = (ByteWriteChannel) multiPartFormDataContent$writeTo$12.L$1;
                        multiPartFormDataContent4 = (MultiPartFormDataContent) multiPartFormDataContent$writeTo$12.L$0;
                        ResultKt.throwOnFailure($result);
                        channel3 = channel2;
                        multiPartFormDataContent6 = multiPartFormDataContent4;
                        access$getRN_BYTES$p = FormDataContentKt.access$getRN_BYTES$p();
                        multiPartFormDataContent$writeTo$12.L$0 = multiPartFormDataContent6;
                        multiPartFormDataContent$writeTo$12.L$1 = channel3;
                        multiPartFormDataContent$writeTo$12.L$2 = it3;
                        multiPartFormDataContent$writeTo$12.L$3 = null;
                        multiPartFormDataContent$writeTo$12.label = 6;
                        if (ByteWriteChannelOperationsKt.writeFully$default(channel3, access$getRN_BYTES$p, 0, 0, multiPartFormDataContent$writeTo$12, 6, (Object) null) != coroutine_suspended) {
                        }
                        break;
                    case 6:
                        Iterator<PreparedPart> it7 = (Iterator) multiPartFormDataContent$writeTo$12.L$2;
                        ByteWriteChannel channel9 = (ByteWriteChannel) multiPartFormDataContent$writeTo$12.L$1;
                        MultiPartFormDataContent multiPartFormDataContent13 = (MultiPartFormDataContent) multiPartFormDataContent$writeTo$12.L$0;
                        ResultKt.throwOnFailure($result);
                        it = it7;
                        channel3 = channel9;
                        multiPartFormDataContent = multiPartFormDataContent13;
                        if (it.hasNext()) {
                        }
                        break;
                    case 7:
                        channel5 = (ByteWriteChannel) multiPartFormDataContent$writeTo$12.L$0;
                        ResultKt.throwOnFailure($result);
                        multiPartFormDataContent$writeTo$12.L$0 = null;
                        multiPartFormDataContent$writeTo$12.label = 8;
                        if (channel5.flushAndClose(multiPartFormDataContent$writeTo$12) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    case 8:
                    case 9:
                        ResultKt.throwOnFailure($result);
                        return Unit.INSTANCE;
                    case 10:
                        Throwable th7 = (Throwable) multiPartFormDataContent$writeTo$12.L$0;
                        ResultKt.throwOnFailure($result);
                        throw th7;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        multiPartFormDataContent$writeTo$1 = new MultiPartFormDataContent$writeTo$1(this, continuation);
        multiPartFormDataContent$writeTo$12 = multiPartFormDataContent$writeTo$1;
        Object $result2 = multiPartFormDataContent$writeTo$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (multiPartFormDataContent$writeTo$12.label) {
        }
    }
}