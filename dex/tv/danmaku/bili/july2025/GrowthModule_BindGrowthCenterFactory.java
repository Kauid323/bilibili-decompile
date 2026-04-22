package tv.danmaku.bili.july2025;

import com.bilibili.app.comm.list.common.growth.july2025.GrowthCenter;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class GrowthModule_BindGrowthCenterFactory implements Factory<GrowthCenter> {
    /* renamed from: get */
    public GrowthCenter m1176get() {
        return bindGrowthCenter();
    }

    public static GrowthModule_BindGrowthCenterFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static GrowthCenter bindGrowthCenter() {
        return (GrowthCenter) Preconditions.checkNotNullFromProvides(GrowthModule.INSTANCE.bindGrowthCenter());
    }

    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private static final class InstanceHolder {
        static final GrowthModule_BindGrowthCenterFactory INSTANCE = new GrowthModule_BindGrowthCenterFactory();

        private InstanceHolder() {
        }
    }
}