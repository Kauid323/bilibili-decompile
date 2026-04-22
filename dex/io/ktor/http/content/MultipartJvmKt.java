package io.ktor.http.content;

import io.ktor.http.content.PartData;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.BlockingKt;
import java.io.InputStream;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* compiled from: MultipartJvm.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lio/ktor/http/content/PartData$FileItem;", "Lkotlin/Function0;", "Ljava/io/InputStream;", "getStreamProvider", "(Lio/ktor/http/content/PartData$FileItem;)Lkotlin/jvm/functions/Function0;", "getStreamProvider$annotations", "(Lio/ktor/http/content/PartData$FileItem;)V", "streamProvider", "ktor-http"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class MultipartJvmKt {
    @Deprecated(message = "This API uses blocking InputStream. Please use provider() directly.")
    public static /* synthetic */ void getStreamProvider$annotations(PartData.FileItem fileItem) {
    }

    public static final Function0<InputStream> getStreamProvider(final PartData.FileItem $this$streamProvider) {
        Intrinsics.checkNotNullParameter($this$streamProvider, "<this>");
        return new Function0() { // from class: io.ktor.http.content.MultipartJvmKt$$ExternalSyntheticLambda0
            public final Object invoke() {
                InputStream _get_streamProvider_$lambda$0;
                _get_streamProvider_$lambda$0 = MultipartJvmKt._get_streamProvider_$lambda$0(PartData.FileItem.this);
                return _get_streamProvider_$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InputStream _get_streamProvider_$lambda$0(PartData.FileItem $this_streamProvider) {
        return BlockingKt.toInputStream$default((ByteReadChannel) $this_streamProvider.getProvider().invoke(), (Job) null, 1, (Object) null);
    }
}