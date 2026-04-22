package base;

import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bilibili.upper.BR;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LiveBaseGiftController.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u00020\u0003H\u0086\b¢\u0006\u0002\u0010\u0004\u001a \u0010\u0005\u001a\u0004\u0018\u0001H\u0006\"\n\b\u0000\u0010\u0006\u0018\u0001*\u00020\u0007*\u00020\u0003H\u0086\b¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"getViewModel", "VM", "Landroidx/lifecycle/ViewModel;", "Landroid/content/Context;", "(Landroid/content/Context;)Landroidx/lifecycle/ViewModel;", "getLifecycleOwner", "T", "Landroidx/lifecycle/LifecycleOwner;", "(Landroid/content/Context;)Landroidx/lifecycle/LifecycleOwner;", "giftCommon_debug"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class LiveBaseGiftControllerKt {
    public static final /* synthetic */ <VM extends ViewModel> VM getViewModel(Context $this$getViewModel) {
        Intrinsics.checkNotNullParameter($this$getViewModel, "<this>");
        ViewModelProvider viewModelProvider = new ViewModelProvider((ViewModelStoreOwner) $this$getViewModel);
        Intrinsics.reifiedOperationMarker(4, "VM");
        return (VM) viewModelProvider.get(ViewModel.class);
    }

    public static final /* synthetic */ <T extends LifecycleOwner> T getLifecycleOwner(Context $this$getLifecycleOwner) {
        Intrinsics.checkNotNullParameter($this$getLifecycleOwner, "<this>");
        if ($this$getLifecycleOwner instanceof LifecycleOwner) {
            Intrinsics.reifiedOperationMarker(1, "T");
            return (T) $this$getLifecycleOwner;
        }
        return null;
    }
}