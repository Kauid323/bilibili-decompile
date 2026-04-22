package curtains;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Listeners.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcurtains/OnRootViewAddedListener;", "Lcurtains/OnRootViewsChangedListener;", "onRootViewAdded", "", "view", "Landroid/view/View;", "onRootViewsChanged", "added", "", "curtains_release"}, k = 1, mv = {1, 4, 1})
public interface OnRootViewAddedListener extends OnRootViewsChangedListener {
    void onRootViewAdded(View view);

    @Override // curtains.OnRootViewsChangedListener
    void onRootViewsChanged(View view, boolean z);

    /* compiled from: Listeners.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DefaultImpls {
        public static void onRootViewsChanged(OnRootViewAddedListener $this, View view, boolean added) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (added) {
                $this.onRootViewAdded(view);
            }
        }
    }
}