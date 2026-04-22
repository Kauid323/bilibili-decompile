package tv.danmaku.bili.services.videodownload.action;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.bilibili.videodownloader.action.ServiceCustomizableAction;
import com.bilibili.videodownloader.action.VideoDownloadEntryWrapper;
import com.bilibili.videodownloader.directory.file.VideoFile;
import com.bilibili.videodownloader.model.VideoDownloadEntry;
import com.bilibili.videodownloader.model.VideoDownloadEntryFactory;
import com.bilibili.videodownloader.utils.log.LogHelper;
import java.util.ArrayList;
import java.util.Iterator;
import tv.danmaku.bili.services.videodownload.strategy.VideoDownloadStorageStrategy;
import tv.danmaku.bili.utils.storage.dp.DocumentProviderCompatHelper;

public class HideOldFolderTaskAction extends ServiceCustomizableAction {
    public static final Parcelable.Creator<HideOldFolderTaskAction> CREATOR = new Parcelable.Creator<HideOldFolderTaskAction>() { // from class: tv.danmaku.bili.services.videodownload.action.HideOldFolderTaskAction.1
        @Override // android.os.Parcelable.Creator
        public HideOldFolderTaskAction createFromParcel(Parcel source) {
            return new HideOldFolderTaskAction(source);
        }

        @Override // android.os.Parcelable.Creator
        public HideOldFolderTaskAction[] newArray(int size) {
            return new HideOldFolderTaskAction[size];
        }
    };
    private ArrayList<VideoDownloadEntry<?>> mCustomEntries;
    private String mNewFolder;
    private String mOldFolder;

    public HideOldFolderTaskAction(String oldFolder, String newFolder) {
        this.mOldFolder = oldFolder;
        this.mNewFolder = newFolder;
    }

    public boolean cancelPerform(Context context) {
        try {
            VideoFile customDir = DocumentProviderCompatHelper.getVideoFileFromFile(context, VideoDownloadStorageStrategy.getCustomDirectory(context, this.mOldFolder));
            if (customDir != null) {
                this.mCustomEntries = VideoDownloadEntryFactory.loadAllEntriesInDirectory(context, customDir);
                if (this.mCustomEntries != null) {
                    return this.mCustomEntries.size() == 0;
                }
                return true;
            }
        } catch (Exception e) {
            LogHelper.printStackTrace(e);
        }
        return true;
    }

    public boolean isMeetActionCondition(VideoDownloadEntryWrapper entryWrapper, Context context) {
        Iterator<VideoDownloadEntry<?>> it = this.mCustomEntries.iterator();
        while (it.hasNext()) {
            VideoDownloadEntry entry = it.next();
            if (entryWrapper.getKey().equals(entry.getKey())) {
                return true;
            }
        }
        return false;
    }

    public int performAction() {
        return 4;
    }

    public String getSimpleName() {
        return "HiddenOldFolderTaskAction";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mOldFolder);
        dest.writeString(this.mNewFolder);
    }

    protected HideOldFolderTaskAction(Parcel in) {
        this.mOldFolder = in.readString();
        this.mNewFolder = in.readString();
    }
}