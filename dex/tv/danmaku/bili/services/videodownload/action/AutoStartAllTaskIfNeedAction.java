package tv.danmaku.bili.services.videodownload.action;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Parcel;
import android.os.Parcelable;
import com.bilibili.app.preferences.Settings;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.videodownloader.action.ServiceCustomizableAction;
import com.bilibili.videodownloader.action.VideoDownloadEntryWrapper;
import tv.danmaku.bili.services.videodownload.utils.VideoDownloadEntryUIState;
import tv.danmaku.bili.services.videodownload.utils.VideoDownloadNetworkHelper;

public class AutoStartAllTaskIfNeedAction extends ServiceCustomizableAction {
    public static final Parcelable.Creator<AutoStartAllTaskIfNeedAction> CREATOR = new Parcelable.Creator<AutoStartAllTaskIfNeedAction>() { // from class: tv.danmaku.bili.services.videodownload.action.AutoStartAllTaskIfNeedAction.1
        @Override // android.os.Parcelable.Creator
        public AutoStartAllTaskIfNeedAction createFromParcel(Parcel source) {
            return new AutoStartAllTaskIfNeedAction(source);
        }

        @Override // android.os.Parcelable.Creator
        public AutoStartAllTaskIfNeedAction[] newArray(int size) {
            return new AutoStartAllTaskIfNeedAction[size];
        }
    };

    public static void start(Context context) {
        VideoDownloadActionServiceHelper.startByService(context, new AutoStartAllTaskIfNeedAction());
    }

    public boolean cancelPerform(Context context) {
        return context == null || !Settings.Download.isDownloadAutoStartEnable(context) || isDisConnected(context) || !VideoDownloadNetworkHelper.isActiveNetworkSafe(context, "");
    }

    public boolean isNoneDistinction(Context context) {
        return BiliAccounts.get(context).isLogin();
    }

    public boolean isMeetActionCondition(VideoDownloadEntryWrapper entryWrapper, Context context) {
        return !VideoDownloadEntryUIState.isFullHDQuality(entryWrapper.getQuality());
    }

    public int performAction() {
        return 1;
    }

    private boolean isDisConnected(Context context) {
        NetworkInfo networkInfo;
        try {
            ConnectivityManager service = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (service == null || (networkInfo = service.getActiveNetworkInfo()) == null) {
                return true;
            }
            return !networkInfo.isConnected();
        } catch (Exception e) {
        }
        return true;
    }

    public String getSimpleName() {
        return "AutoStartAllDownloadTask";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
    }

    public AutoStartAllTaskIfNeedAction() {
    }

    protected AutoStartAllTaskIfNeedAction(Parcel in) {
    }
}