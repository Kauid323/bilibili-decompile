package tv.danmaku.bili.ui.splash.common.search;

import androidx.lifecycle.MutableLiveData;
import com.bilibili.search.DefaultWordItem;
import com.bilibili.search.SplashSearchService;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashSearchServiceImpl.kt */
@Singleton
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\nH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00050\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00050\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/ui/splash/common/search/SplashSearchServiceImpl;", "Lcom/bilibili/search/SplashSearchService;", "<init>", "()V", "isBrandShow", "", "()Z", "setBrandShow", "(Z)V", "refreshLiveData", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "keepOnceRefresh", "defaultWordItemLiveData", "Lcom/bilibili/search/DefaultWordItem;", "getDefaultWordItem", "refreshDefaultWord", "keepOnceRefreshLiveData", "isBrandSplashShow", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Named("SPLASH_SEARCH_SERVICE")
public final class SplashSearchServiceImpl implements SplashSearchService {
    public static final int $stable = 8;
    private boolean isBrandShow;
    private final MutableLiveData<Boolean> refreshLiveData = new MutableLiveData<>(false);
    private final MutableLiveData<Boolean> keepOnceRefresh = new MutableLiveData<>(false);
    private final MutableLiveData<DefaultWordItem> defaultWordItemLiveData = new MutableLiveData<>();

    public final boolean isBrandShow() {
        return this.isBrandShow;
    }

    public final void setBrandShow(boolean z) {
        this.isBrandShow = z;
    }

    public MutableLiveData<DefaultWordItem> getDefaultWordItem() {
        return this.defaultWordItemLiveData;
    }

    public MutableLiveData<Boolean> refreshDefaultWord() {
        return this.refreshLiveData;
    }

    public MutableLiveData<Boolean> keepOnceRefreshLiveData() {
        return this.keepOnceRefresh;
    }

    public boolean isBrandSplashShow() {
        return this.isBrandShow;
    }
}