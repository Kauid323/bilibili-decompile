package kntr.common.photonic.aphro.ui.preview.model;

import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* compiled from: ImagePreviewDataSource.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0010\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkntr/common/photonic/aphro/ui/preview/model/ImagePreviewDataNotifier;", "", "<init>", "()V", "imagePreviewDataSource", "Lkntr/common/photonic/aphro/ui/preview/model/ImagePreviewDataSource;", "getImagePreviewDataSource", "()Lkntr/common/photonic/aphro/ui/preview/model/ImagePreviewDataSource;", "setImagePreviewDataSource", "(Lkntr/common/photonic/aphro/ui/preview/model/ImagePreviewDataSource;)V", "resultMap", "", "", "Lkotlinx/coroutines/channels/Channel;", "Lkntr/common/photonic/aphro/ui/preview/model/ImagePreviewSelectResult;", "getPreviewSelectResultChannel", "matchKey", "clearPreviewSelectResultChannel", "", "ui_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class ImagePreviewDataNotifier {
    private static ImagePreviewDataSource imagePreviewDataSource;
    public static final ImagePreviewDataNotifier INSTANCE = new ImagePreviewDataNotifier();
    private static final Map<String, Channel<ImagePreviewSelectResult>> resultMap = new LinkedHashMap();
    public static final int $stable = 8;

    private ImagePreviewDataNotifier() {
    }

    public final ImagePreviewDataSource getImagePreviewDataSource() {
        return imagePreviewDataSource;
    }

    public final void setImagePreviewDataSource(ImagePreviewDataSource imagePreviewDataSource2) {
        imagePreviewDataSource = imagePreviewDataSource2;
    }

    public final Channel<ImagePreviewSelectResult> getPreviewSelectResultChannel(String matchKey) {
        Channel<ImagePreviewSelectResult> channel;
        Intrinsics.checkNotNullParameter(matchKey, "matchKey");
        Map $this$getOrPut$iv = resultMap;
        Channel<ImagePreviewSelectResult> channel2 = $this$getOrPut$iv.get(matchKey);
        if (channel2 == null) {
            channel = ChannelKt.Channel$default(0, (BufferOverflow) null, (Function1) null, 7, (Object) null);
            $this$getOrPut$iv.put(matchKey, channel);
        } else {
            channel = channel2;
        }
        return channel;
    }

    public final void clearPreviewSelectResultChannel(String matchKey) {
        Intrinsics.checkNotNullParameter(matchKey, "matchKey");
        resultMap.remove(matchKey);
    }
}