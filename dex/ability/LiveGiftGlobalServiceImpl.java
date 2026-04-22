package ability;

import androidx.fragment.app.FragmentActivity;
import bili.resource.live.R;
import com.bilibili.bililive.componentbridge.provider.BridgeProviders;
import com.bilibili.bililive.shared.router.LiveRouterHelper;
import com.bilibili.droid.ToastHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LiveGiftGlobalServiceImpl.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0016\u0010\u0017\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0019H\u0016J\u001e\u0010\u001a\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u00192\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0016\u0010\u001d\u001a\u00020\u00102\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u0019H\u0016J\b\u0010\u001e\u001a\u00020\u0010H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\n\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r¨\u0006\u001f"}, d2 = {"Lability/LiveGiftGlobalServiceImpl;", "Lability/ILiveGiftGlobalService;", "<init>", "()V", "basicService", "Lability/ILiveGiftBasicService;", "getBasicService", "()Lability/ILiveGiftBasicService;", "basicService$delegate", "Lkotlin/Lazy;", "activity", "Landroidx/fragment/app/FragmentActivity;", "getActivity", "()Landroidx/fragment/app/FragmentActivity;", "activity$delegate", "toast", "", "stringId", "", "message", "", "jumpToLogin", "requestCode", "postOnUiThread", "block", "Lkotlin/Function0;", "postDelayedOnUiThread", "delay", "", "removeCallbacks", "removeAllMsgs", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LiveGiftGlobalServiceImpl implements ILiveGiftGlobalService {
    private final Lazy basicService$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: ability.LiveGiftGlobalServiceImpl$$ExternalSyntheticLambda0
        public final Object invoke() {
            ILiveGiftBasicService basicService_delegate$lambda$0;
            basicService_delegate$lambda$0 = LiveGiftGlobalServiceImpl.basicService_delegate$lambda$0();
            return basicService_delegate$lambda$0;
        }
    });
    private final Lazy activity$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: ability.LiveGiftGlobalServiceImpl$$ExternalSyntheticLambda1
        public final Object invoke() {
            FragmentActivity activity_delegate$lambda$0;
            activity_delegate$lambda$0 = LiveGiftGlobalServiceImpl.activity_delegate$lambda$0(LiveGiftGlobalServiceImpl.this);
            return activity_delegate$lambda$0;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILiveGiftBasicService basicService_delegate$lambda$0() {
        return (ILiveGiftBasicService) BridgeProviders.Companion.getInstance().getOrNull(ILiveGiftBasicService.class);
    }

    private final ILiveGiftBasicService getBasicService() {
        return (ILiveGiftBasicService) this.basicService$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FragmentActivity activity_delegate$lambda$0(LiveGiftGlobalServiceImpl this$0) {
        ILiveGiftBasicService basicService = this$0.getBasicService();
        if (basicService != null) {
            return basicService.getActivity();
        }
        return null;
    }

    private final FragmentActivity getActivity() {
        return (FragmentActivity) this.activity$delegate.getValue();
    }

    @Override // ability.ILiveGiftGlobalService
    public void toast(int stringId) {
        if (getActivity() == null) {
            return;
        }
        ToastHelper.showToastShort(getActivity(), stringId);
    }

    @Override // ability.ILiveGiftGlobalService
    public void toast(String message) {
        if (getActivity() == null || message == null) {
            return;
        }
        ToastHelper.showToastShort(getActivity(), message);
    }

    @Override // ability.ILiveGiftGlobalService
    public void jumpToLogin(int requestCode) {
        toast(R.string.live_global_string_1959);
        LiveRouterHelper.intentToLogin(getActivity(), requestCode);
    }

    @Override // ability.ILiveGiftGlobalService
    public void postOnUiThread(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        ILiveGiftBasicService basicService = getBasicService();
        if (basicService != null) {
            basicService.postOnUiThread(function0);
        }
    }

    @Override // ability.ILiveGiftGlobalService
    public void postDelayedOnUiThread(Function0<Unit> function0, long delay) {
        Intrinsics.checkNotNullParameter(function0, "block");
        ILiveGiftBasicService basicService = getBasicService();
        if (basicService != null) {
            basicService.postDelayedOnUiThread(function0, delay);
        }
    }

    @Override // ability.ILiveGiftGlobalService
    public void removeCallbacks(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        ILiveGiftBasicService basicService = getBasicService();
        if (basicService != null) {
            basicService.removeCallbacks(function0);
        }
    }

    @Override // ability.ILiveGiftGlobalService
    public void removeAllMsgs() {
        ILiveGiftBasicService basicService = getBasicService();
        if (basicService != null) {
            basicService.removeAllMsgs();
        }
    }
}