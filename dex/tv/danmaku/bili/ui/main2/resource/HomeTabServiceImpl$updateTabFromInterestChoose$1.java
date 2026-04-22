package tv.danmaku.bili.ui.main2.resource;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.ui.main2.HomeFragOperator;
import tv.danmaku.bili.ui.main2.resource.MainResourceManager;

/* compiled from: HomeTabServiceImpl.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"tv/danmaku/bili/ui/main2/resource/HomeTabServiceImpl$updateTabFromInterestChoose$1", "Ltv/danmaku/bili/ui/main2/resource/MainResourceManager$ShowTabApiListener;", "onSuccessSaveToDisk", "", "response", "Ltv/danmaku/bili/ui/main2/resource/MainResourceManager$TabResponse;", "onNothingToSave", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HomeTabServiceImpl$updateTabFromInterestChoose$1 implements MainResourceManager.ShowTabApiListener {
    final /* synthetic */ HomeTabServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HomeTabServiceImpl$updateTabFromInterestChoose$1(HomeTabServiceImpl $receiver) {
        this.this$0 = $receiver;
    }

    @Override // tv.danmaku.bili.ui.main2.resource.MainResourceManager.ShowTabApiListener
    public void onSuccessSaveToDisk(MainResourceManager.TabResponse response) {
        Handler handler;
        Intrinsics.checkNotNullParameter(response, "response");
        handler = this.this$0.mHandler;
        final HomeTabServiceImpl homeTabServiceImpl = this.this$0;
        handler.post(new Runnable() { // from class: tv.danmaku.bili.ui.main2.resource.HomeTabServiceImpl$updateTabFromInterestChoose$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                HomeTabServiceImpl$updateTabFromInterestChoose$1.onSuccessSaveToDisk$lambda$0(HomeTabServiceImpl.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSuccessSaveToDisk$lambda$0(HomeTabServiceImpl this$0) {
        HomeFragOperator homeFragmentOperator = this$0.getHomeFragmentOperator();
        if (homeFragmentOperator != null) {
            homeFragmentOperator.forceUpdateHomeTab();
        }
    }

    @Override // tv.danmaku.bili.ui.main2.resource.MainResourceManager.ShowTabApiListener
    public void onNothingToSave() {
    }
}