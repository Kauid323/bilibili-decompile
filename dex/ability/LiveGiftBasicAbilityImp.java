package ability;

import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.bililive.componentbridge.BridgeInterface;
import com.bilibili.bililive.componentbridge.BridgeObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LiveGiftBasicAbilityImpl.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fH\u0016J\u001e\u0010\r\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fH\u0016J\b\u0010\u0011\u001a\u00020\nH\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lability/LiveGiftBasicAbilityImp;", "Lability/ILiveGiftBasicService;", "activity", "Landroidx/fragment/app/FragmentActivity;", "<init>", "(Landroidx/fragment/app/FragmentActivity;)V", "uiHandler", "Landroid/os/Handler;", "getActivity", "postOnUiThread", "", "block", "Lkotlin/Function0;", "postDelayedOnUiThread", "delay", "", "removeCallbacks", "removeAllMsgs", "onClear", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LiveGiftBasicAbilityImp implements ILiveGiftBasicService {
    private final FragmentActivity activity;
    private final Handler uiHandler = new Handler(Looper.getMainLooper());

    public /* synthetic */ Unit notifyDataChanged(String str, Object obj) {
        return BridgeInterface.-CC.$default$notifyDataChanged(this, str, obj);
    }

    public /* synthetic */ Unit notifyDataChangedNullable(String str, Object obj) {
        return BridgeInterface.-CC.$default$notifyDataChangedNullable(this, str, obj);
    }

    public /* synthetic */ Unit notifyIfDataChanged(String str, Object obj) {
        return BridgeInterface.-CC.$default$notifyIfDataChanged(this, str, obj);
    }

    public /* synthetic */ Unit observe(String str, BridgeObserver bridgeObserver) {
        return BridgeInterface.-CC.$default$observe(this, str, bridgeObserver);
    }

    public /* synthetic */ Unit observe(String[] strArr, BridgeObserver bridgeObserver) {
        return BridgeInterface.-CC.$default$observe(this, strArr, bridgeObserver);
    }

    public /* synthetic */ void onCreate() {
        BridgeInterface.-CC.$default$onCreate(this);
    }

    public /* synthetic */ Unit removeBridges(String str) {
        return BridgeInterface.-CC.$default$removeBridges(this, str);
    }

    public LiveGiftBasicAbilityImp(FragmentActivity activity) {
        this.activity = activity;
    }

    @Override // ability.ILiveGiftBasicService
    public FragmentActivity getActivity() {
        return this.activity;
    }

    @Override // ability.ILiveGiftBasicService
    public void postOnUiThread(final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.uiHandler.postDelayed(new Runnable() { // from class: ability.LiveGiftBasicAbilityImp$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                function0.invoke();
            }
        }, 0L);
    }

    @Override // ability.ILiveGiftBasicService
    public void postDelayedOnUiThread(final Function0<Unit> function0, long delay) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.uiHandler.postDelayed(new Runnable() { // from class: ability.LiveGiftBasicAbilityImp$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                function0.invoke();
            }
        }, delay);
    }

    @Override // ability.ILiveGiftBasicService
    public void removeCallbacks(final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.uiHandler.removeCallbacks(new Runnable() { // from class: ability.LiveGiftBasicAbilityImp$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                function0.invoke();
            }
        });
    }

    @Override // ability.ILiveGiftBasicService
    public void removeAllMsgs() {
        this.uiHandler.removeCallbacksAndMessages(null);
    }

    public void onClear() {
        removeAllMsgs();
    }
}