package ability;

import androidx.fragment.app.FragmentActivity;
import com.bilibili.bililive.componentbridge.BridgeInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: ILiveGiftBasicService.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u0016\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H&J\u001e\u0010\b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\t\u001a\u00020\nH&J\u0016\u0010\u000b\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007H&J\b\u0010\f\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Lability/ILiveGiftBasicService;", "Lcom/bilibili/bililive/componentbridge/BridgeInterface;", "getActivity", "Landroidx/fragment/app/FragmentActivity;", "postOnUiThread", "", "block", "Lkotlin/Function0;", "postDelayedOnUiThread", "delay", "", "removeCallbacks", "removeAllMsgs", "giftCommon_debug"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ILiveGiftBasicService extends BridgeInterface {
    FragmentActivity getActivity();

    void postDelayedOnUiThread(Function0<Unit> function0, long j);

    void postOnUiThread(Function0<Unit> function0);

    void removeAllMsgs();

    void removeCallbacks(Function0<Unit> function0);
}