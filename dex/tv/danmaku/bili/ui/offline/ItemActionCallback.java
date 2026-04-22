package tv.danmaku.bili.ui.offline;

import android.content.Context;
import com.bilibili.offline.OfflineInfo;

public interface ItemActionCallback {

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface Downloaded extends ItemActionCallback, PlayAction {
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface Downloading extends ItemActionCallback, PauseResumeAction, PlayAction {
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface PauseResumeAction {
        void pauseResume(OfflineInfo offlineInfo);
    }

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface PlayAction {
        void play(Context context, OfflineInfo offlineInfo);
    }

    void enterEditMode();

    void onCheckedItemCountChange(int i, boolean z);

    void onItemCountChange(int i);
}