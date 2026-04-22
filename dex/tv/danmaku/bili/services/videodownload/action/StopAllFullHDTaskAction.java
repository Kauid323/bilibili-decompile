package tv.danmaku.bili.services.videodownload.action;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.bilibili.videodownloader.action.ServiceCustomizableAction;
import com.bilibili.videodownloader.action.VideoDownloadEntryWrapper;
import tv.danmaku.bili.services.videodownload.utils.VideoDownloadEntryUIState;

public class StopAllFullHDTaskAction extends ServiceCustomizableAction {
    public static final Parcelable.Creator<StopAllFullHDTaskAction> CREATOR = new Parcelable.Creator<StopAllFullHDTaskAction>() { // from class: tv.danmaku.bili.services.videodownload.action.StopAllFullHDTaskAction.1
        @Override // android.os.Parcelable.Creator
        public StopAllFullHDTaskAction createFromParcel(Parcel source) {
            return new StopAllFullHDTaskAction(source);
        }

        @Override // android.os.Parcelable.Creator
        public StopAllFullHDTaskAction[] newArray(int size) {
            return new StopAllFullHDTaskAction[size];
        }
    };

    public static void start(Context context) {
        VideoDownloadActionServiceHelper.startByService(context, new StopAllFullHDTaskAction());
    }

    public int performAction() {
        return 2;
    }

    public boolean isMeetActionCondition(VideoDownloadEntryWrapper entryWrapper, Context context) {
        return VideoDownloadEntryUIState.isFullHDQuality(entryWrapper.getQuality()) || entryWrapper.isDolby();
    }

    public String getSimpleName() {
        return "StopAllFullHDTask";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
    }

    public StopAllFullHDTaskAction() {
    }

    protected StopAllFullHDTaskAction(Parcel in) {
    }
}