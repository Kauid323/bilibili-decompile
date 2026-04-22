package tv.danmaku.bili.ui.main2.basic.story;

import com.bilibili.homepage.HomeStoryEntranceService;
import com.bilibili.lib.blrouter.BLRouter;
import kotlin.Metadata;
import tv.danmaku.bili.BR;

/* compiled from: HomeStoryEntranceServiceImpl.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\u0000¨\u0006\u0002"}, d2 = {"getStoryEntranceServiceImpl", "Ltv/danmaku/bili/ui/main2/basic/story/HomeStoryEntranceServiceImpl;", "core_apinkDebug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HomeStoryEntranceServiceImplKt {
    public static final HomeStoryEntranceServiceImpl getStoryEntranceServiceImpl() {
        Object obj = BLRouter.get$default(BLRouter.INSTANCE, HomeStoryEntranceService.class, (String) null, 2, (Object) null);
        if (obj instanceof HomeStoryEntranceServiceImpl) {
            return (HomeStoryEntranceServiceImpl) obj;
        }
        return null;
    }
}