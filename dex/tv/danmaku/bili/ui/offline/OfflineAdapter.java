package tv.danmaku.bili.ui.offline;

import com.bilibili.offline.OfflineInfo;
import kotlin.Metadata;
import tv.danmaku.bili.ui.offline.ItemActionCallback;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: OfflineAdapter.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\nH&J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\f\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/offline/OfflineAdapter;", "", "isEditMode", "", "isChecked", "info", "Lcom/bilibili/offline/OfflineInfo;", "getPlayAction", "Ltv/danmaku/bili/ui/offline/ItemActionCallback$PlayAction;", "enterEditMode", "", "check", "unCheck", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public interface OfflineAdapter {
    void check(OfflineInfo offlineInfo);

    void enterEditMode();

    ItemActionCallback.PlayAction getPlayAction();

    boolean isChecked(OfflineInfo offlineInfo);

    boolean isEditMode();

    void unCheck(OfflineInfo offlineInfo);
}