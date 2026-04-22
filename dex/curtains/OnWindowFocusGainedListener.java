package curtains;

import kotlin.Metadata;

/* compiled from: Listeners.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lcurtains/OnWindowFocusGainedListener;", "Lcurtains/OnWindowFocusChangedListener;", "onWindowFocusChanged", "", "hasFocus", "", "onWindowFocusGained", "curtains_release"}, k = 1, mv = {1, 4, 1})
public interface OnWindowFocusGainedListener extends OnWindowFocusChangedListener {
    @Override // curtains.OnWindowFocusChangedListener
    void onWindowFocusChanged(boolean z);

    void onWindowFocusGained();

    /* compiled from: Listeners.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class DefaultImpls {
        public static void onWindowFocusChanged(OnWindowFocusGainedListener $this, boolean hasFocus) {
            if (hasFocus) {
                $this.onWindowFocusGained();
            }
        }
    }
}