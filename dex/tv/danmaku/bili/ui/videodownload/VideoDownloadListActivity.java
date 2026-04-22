package tv.danmaku.bili.ui.videodownload;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.R;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.util.StatusBarCompat;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.playerbizcommon.miniplayer.IMiniPlayerContainer;
import tv.danmaku.bili.services.videodownload.utils.DownloadTaskTransfer;
import tv.danmaku.bili.ui.offline.OfflineHomeFragment;

public class VideoDownloadListActivity extends BaseAppCompatActivity implements IMiniPlayerContainer {
    private OfflineHomeFragment mOfflineFragment;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, VideoDownloadListActivity.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tintStatusBar(this);
        String tag = OfflineHomeFragment.class.getSimpleName();
        this.mOfflineFragment = getSupportFragmentManager().findFragmentByTag(tag);
        if (this.mOfflineFragment == null) {
            this.mOfflineFragment = new OfflineHomeFragment();
            getSupportFragmentManager().beginTransaction().add(16908290, this.mOfflineFragment, tag).commit();
        }
        DownloadTaskTransfer.INSTANCE.checkIsNeedTransfer(this);
    }

    private void tintStatusBar(Activity activity) {
        if (activity == null) {
            return;
        }
        Garb garb = GarbManager.getCurGarb();
        if (garb.isPure() || garb.isPrimaryOnly()) {
            StatusBarCompat.tintStatusBar(activity, ThemeUtils.getThemeAttrColor(activity, R.attr.colorPrimary));
        } else {
            StatusBarCompat.tintStatusBar(activity, garb.getSecondaryPageColor(), garb.isDarkMode() ? 1 : 2);
        }
        View rootView = activity.findViewById(16908290);
        if (rootView == null) {
            return;
        }
        rootView.setPadding(0, StatusBarCompat.getStatusBarHeight(activity), 0, 0);
    }

    public void onBackPressed() {
        if (this.mOfflineFragment != null && this.mOfflineFragment.mIsEditMode) {
            this.mOfflineFragment.toggleEditMode();
        } else {
            super.onBackPressed();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        DownloadTaskTransfer.INSTANCE.onActivityResult(this, requestCode, resultCode, data);
    }

    public String getMiniPlayerContainerKey() {
        return "video_download_list_page";
    }

    public Rect getContainerUnavailableRect() {
        return new Rect();
    }
}