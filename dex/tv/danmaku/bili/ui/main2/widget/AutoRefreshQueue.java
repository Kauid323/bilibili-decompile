package tv.danmaku.bili.ui.main2.widget;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.homepage.HomeFragmentListener;
import com.bilibili.homepage.HomeTabService;
import com.bilibili.lib.blrouter.BLRouter;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;

/* compiled from: AutoRefreshQueue.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J4\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00052\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\"0!J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\"H\u0002J\u0014\u0010%\u001a\u00020\"2\n\u0010&\u001a\u00060'j\u0002`(H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006)"}, d2 = {"Ltv/danmaku/bili/ui/main2/widget/AutoRefreshQueue;", "", "<init>", "()V", "REFRESH_TYPE_DEFAULT", "", "REFRESH_TYPE_AUTO", "REFRESH_TYPE_FORCE", "TAG", "", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "setJob", "(Lkotlinx/coroutines/Job;)V", "value", "", "searchBarVisible", "getSearchBarVisible", "()Z", "setSearchBarVisible", "(Z)V", "fragmentVisible", "getFragmentVisible", "setFragmentVisible", "requestUntil", "time", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "type", "requestInvoker", "Lkotlin/Function1;", "", "cancelRequest", "handleCancellation", "handleError", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AutoRefreshQueue {
    public static final int $stable;
    public static final int REFRESH_TYPE_AUTO = 1;
    public static final int REFRESH_TYPE_DEFAULT = 0;
    public static final int REFRESH_TYPE_FORCE = 2;
    public static final String TAG = "AutoSearchWord";
    private static Job job;
    public static final AutoRefreshQueue INSTANCE = new AutoRefreshQueue();
    private static boolean searchBarVisible = true;
    private static boolean fragmentVisible = true;

    private AutoRefreshQueue() {
    }

    public final Job getJob() {
        return job;
    }

    public final void setJob(Job job2) {
        job = job2;
    }

    static {
        HomeTabService service = (HomeTabService) BLRouter.INSTANCE.get(HomeTabService.class, "HOME_TAB_SERVICE");
        HomeFragmentListener homeFragmentListener = new HomeFragmentListener() { // from class: tv.danmaku.bili.ui.main2.widget.AutoRefreshQueue$homeFragmentListener$1
            public void onViewCreated(LifecycleCoroutineScope scope) {
            }

            public void onHide() {
                AutoRefreshQueue.INSTANCE.setFragmentVisible(false);
            }

            public void onShow() {
                AutoRefreshQueue.INSTANCE.setFragmentVisible(true);
            }
        };
        if (service != null) {
            service.registerHomeFragmentListener(homeFragmentListener);
        }
        $stable = 8;
    }

    public final boolean getSearchBarVisible() {
        return searchBarVisible;
    }

    public final void setSearchBarVisible(boolean value) {
        searchBarVisible = value;
        BLog.d(TAG, "searchBarVisible " + searchBarVisible);
        if (!searchBarVisible) {
            cancelRequest();
        }
    }

    public final boolean getFragmentVisible() {
        return fragmentVisible;
    }

    public final void setFragmentVisible(boolean value) {
        fragmentVisible = value;
        BLog.d(TAG, "fragmentVisible " + fragmentVisible);
        if (!fragmentVisible) {
            cancelRequest();
        }
    }

    public final Job requestUntil(long time, LifecycleOwner owner, int type, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(function1, "requestInvoker");
        Job job2 = job;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        if (searchBarVisible && fragmentVisible) {
            job = LifecycleOwnerKt.getLifecycleScope(owner).launchWhenStarted(new AutoRefreshQueue$requestUntil$1(time, function1, type, null));
        } else {
            job = null;
            boolean z = searchBarVisible;
            BLog.d(TAG, "searchBarVisible " + z + " fragmentVisible " + fragmentVisible);
        }
        return job;
    }

    private final void cancelRequest() {
        Job job2 = job;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
        job = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleCancellation() {
        BLog.d(TAG, "handleCancellation");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleError(Exception e) {
        BLog.d(TAG, "handleError", e);
    }
}