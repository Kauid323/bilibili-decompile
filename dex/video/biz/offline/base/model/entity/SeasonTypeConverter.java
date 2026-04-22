package video.biz.offline.base.model.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: TypeConverter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\t"}, d2 = {"Lvideo/biz/offline/base/model/entity/SeasonTypeConverter;", "", "<init>", "()V", "revertSeasonType", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$SeasonType;", "value", "", "converterSeasonType", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SeasonTypeConverter {
    public static final int $stable = 0;

    public final OfflineVideoEntity.SeasonType revertSeasonType(int value) {
        switch (value) {
            case 1:
                return OfflineVideoEntity.SeasonType.BANGUMI;
            case 2:
                return OfflineVideoEntity.SeasonType.MOVIE;
            case 3:
                return OfflineVideoEntity.SeasonType.DOCUMENTARY;
            case 4:
                return OfflineVideoEntity.SeasonType.CN_BANGUMI;
            case 5:
                return OfflineVideoEntity.SeasonType.TV_SERIES;
            case 6:
            default:
                return OfflineVideoEntity.SeasonType.UNKNOWN;
            case 7:
                return OfflineVideoEntity.SeasonType.VARIETY;
        }
    }

    public final int converterSeasonType(OfflineVideoEntity.SeasonType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return value.getSeasonType();
    }
}