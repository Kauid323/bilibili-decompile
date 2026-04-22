package kntr.app.game.base.ui;

import java.util.LinkedHashMap;
import java.util.Map;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Exposer.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J9\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00060\fR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkntr/app/game/base/ui/CollectorHolder;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "collectorList", RoomRecommendViewModel.EMPTY_CURSOR, "Lkntr/app/game/base/ui/IExposureCollector;", "get", "key", "config", "Lkntr/app/game/base/ui/ExposureConfig;", "factory", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "base-ui_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CollectorHolder {
    public static final int $stable = 8;
    private final Map<Object, IExposureCollector> collectorList = new LinkedHashMap();

    public final IExposureCollector get(Object key, ExposureConfig config, Function1<? super ExposureConfig, ? extends IExposureCollector> function1) {
        IExposureCollector iExposureCollector;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(function1, "factory");
        Map $this$getOrPut$iv = this.collectorList;
        IExposureCollector iExposureCollector2 = $this$getOrPut$iv.get(key);
        if (iExposureCollector2 == null) {
            iExposureCollector = (IExposureCollector) function1.invoke(config);
            $this$getOrPut$iv.put(key, iExposureCollector);
        } else {
            iExposureCollector = iExposureCollector2;
        }
        return iExposureCollector;
    }
}