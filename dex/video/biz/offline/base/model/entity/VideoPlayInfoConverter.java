package video.biz.offline.base.model.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.model.VideoPlayInfo;

/* compiled from: TypeConverter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\t"}, d2 = {"Lvideo/biz/offline/base/model/entity/VideoPlayInfoConverter;", "", "<init>", "()V", "revertVideoInfo", "Lvideo/biz/offline/base/model/model/VideoPlayInfo;", "value", "", "converterVideoInfo", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class VideoPlayInfoConverter {
    public static final int $stable = 0;

    public final VideoPlayInfo revertVideoInfo(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            Json this_$iv = TypeConverterKt.access$getJson$p();
            this_$iv.getSerializersModule();
            return (VideoPlayInfo) this_$iv.decodeFromString(VideoPlayInfo.Companion.serializer(), value);
        } catch (Exception e) {
            return new VideoPlayInfo(0, 0, (String) null, (String) null, 0, 0, 0, (String) null, 0, 0, 0, 0, 0, 0, false, 0, 0L, false, 0L, 524287, (DefaultConstructorMarker) null);
        }
    }

    public final String converterVideoInfo(VideoPlayInfo value) {
        Intrinsics.checkNotNullParameter(value, "value");
        try {
            Json $this$encodeToJsonElement$iv = TypeConverterKt.access$getJson$p();
            $this$encodeToJsonElement$iv.getSerializersModule();
            return $this$encodeToJsonElement$iv.encodeToJsonElement(VideoPlayInfo.Companion.serializer(), value).toString();
        } catch (Exception e) {
            return "";
        }
    }
}