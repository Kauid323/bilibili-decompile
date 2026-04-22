package tv.danmaku.bili.ui.splash;

import androidx.lifecycle.MutableLiveData;
import com.bilibili.homepage.HomePageJumpService;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: ClipboardJumpHelper.kt */
@Singleton
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/ui/splash/HomePageJumpServiceImpl;", "Lcom/bilibili/homepage/HomePageJumpService;", "<init>", "()V", "jumpStatus", "Landroidx/lifecycle/MutableLiveData;", "", "getJumpStatus", "onSceneRedirected", "", "jumped", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
@Named("HomePageJumpService")
public final class HomePageJumpServiceImpl implements HomePageJumpService {
    public static final int $stable = 8;
    private final MutableLiveData<Integer> jumpStatus = new MutableLiveData<>();

    public MutableLiveData<Integer> getJumpStatus() {
        return this.jumpStatus;
    }

    public void onSceneRedirected(boolean jumped) {
        ClipboardJumpHelper.setSceneRedirected(jumped);
    }
}