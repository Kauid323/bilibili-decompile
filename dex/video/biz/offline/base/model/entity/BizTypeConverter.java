package video.biz.offline.base.model.entity;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import video.biz.offline.base.model.entity.OfflineVideoEntity;

/* compiled from: TypeConverter.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\t"}, d2 = {"Lvideo/biz/offline/base/model/entity/BizTypeConverter;", "", "<init>", "()V", "revertBizType", "Lvideo/biz/offline/base/model/entity/OfflineVideoEntity$BizType;", "value", "", "converterBizType", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BizTypeConverter {
    public static final int $stable = 0;

    /* compiled from: TypeConverter.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OfflineVideoEntity.BizType.values().length];
            try {
                iArr[OfflineVideoEntity.BizType.UGC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[OfflineVideoEntity.BizType.OGV.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[OfflineVideoEntity.BizType.PUGV.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final OfflineVideoEntity.BizType revertBizType(int value) {
        switch (value) {
            case 1:
                return OfflineVideoEntity.BizType.UGC;
            case 2:
                return OfflineVideoEntity.BizType.OGV;
            case 3:
                return OfflineVideoEntity.BizType.PUGV;
            default:
                return OfflineVideoEntity.BizType.UGC;
        }
    }

    public final int converterBizType(OfflineVideoEntity.BizType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        switch (WhenMappings.$EnumSwitchMapping$0[value.ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}