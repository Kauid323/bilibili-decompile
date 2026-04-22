package tv.danmaku.bili.ui.offline;

import android.view.ViewTreeObserver;
import kotlin.Metadata;
import tv.danmaku.bili.widget.SearchView;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineSearchActivity.kt */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"tv/danmaku/bili/ui/offline/OfflineSearchActivity$requestFocus$1$1", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class OfflineSearchActivity$requestFocus$1$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ SearchView $it;
    final /* synthetic */ OfflineSearchActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OfflineSearchActivity$requestFocus$1$1(SearchView $it, OfflineSearchActivity $receiver) {
        this.$it = $it;
        this.this$0 = $receiver;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.$it.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        SearchView searchView = this.$it;
        final OfflineSearchActivity offlineSearchActivity = this.this$0;
        searchView.postDelayed(new Runnable() { // from class: tv.danmaku.bili.ui.offline.OfflineSearchActivity$requestFocus$1$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                OfflineSearchActivity.access$forceRequestFocus(OfflineSearchActivity.this);
            }
        }, 100L);
    }
}