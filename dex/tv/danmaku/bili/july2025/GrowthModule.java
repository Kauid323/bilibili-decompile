package tv.danmaku.bili.july2025;

import com.bilibili.app.comm.list.common.growth.july2025.GrowthCenter;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: GrowthCenterViewModel.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/july2025/GrowthModule;", "", "<init>", "()V", "bindGrowthCenter", "Lcom/bilibili/app/comm/list/common/growth/july2025/GrowthCenter;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
@Module
public final class GrowthModule {
    public static final int $stable = 0;
    public static final GrowthModule INSTANCE = new GrowthModule();

    private GrowthModule() {
    }

    @Provides
    @Singleton
    public final GrowthCenter bindGrowthCenter() {
        return GrowthCenterImpl.INSTANCE;
    }
}