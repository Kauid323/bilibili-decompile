package tv.danmaku.bili.ui.videodownload.diagnosis;

import android.content.Context;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import bili.resource.downloads.R;
import com.bilibili.videodownloader.directory.file.VideoFile;
import com.bilibili.videodownloader.model.VideoDownloadAVPageEntry;
import com.bilibili.videodownloader.model.VideoDownloadEntry;
import com.bilibili.videodownloader.model.VideoDownloadSeasonEpEntry;
import java.util.List;
import java.util.Locale;
import tv.danmaku.bili.services.videodownload.strategy.VideoDownloadStorageStrategy;
import tv.danmaku.bili.ui.videodownload.utils.TransformHelper;

public class ScanEntry implements Parcelable {
    public static final Parcelable.Creator<ScanEntry> CREATOR = new Parcelable.Creator<ScanEntry>() { // from class: tv.danmaku.bili.ui.videodownload.diagnosis.ScanEntry.1
        @Override // android.os.Parcelable.Creator
        public ScanEntry createFromParcel(Parcel source) {
            return new ScanEntry(source);
        }

        @Override // android.os.Parcelable.Creator
        public ScanEntry[] newArray(int size) {
            return new ScanEntry[size];
        }
    };
    static final int STEP_DIR = 2;
    static final int STEP_ROOT = 1;
    static final int STEP_SUB_DIR = 3;
    static final int STEP_SUB_DIR_ENTRY = 4;
    static final int STEP_SUB_DIR_ENTRY_DESERIALIZE = 5;
    static final int STEP_SUB_DIR_ENTRY_DESERIALIZE_SUCCESS = 6;
    private static final String TREE_END = "\n";
    private static final String TREE_INTERVAL_VERTICAL = " |     ";
    private static final String TREE_LAST_START = " \\--- ";
    private static final String TREE_START = "+--- ";
    VideoDownloadEntry entry;
    int step;
    String storagePath;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScanEntry(int step, String storagePath) {
        this.step = step;
        this.storagePath = storagePath;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ScanEntry(int step, String storagePath, VideoDownloadEntry entry) {
        this.entry = entry;
        this.step = step;
        this.storagePath = storagePath;
    }

    public boolean isValid() {
        return this.step == 6;
    }

    public boolean isCompleted() {
        return this.entry != null && this.entry.isCompleted();
    }

    public String getTitle(Context context) {
        if (this.entry == null) {
            return context.getString(R.string.downloads_global_string_26);
        }
        StringBuilder builder = new StringBuilder(this.entry.mTitle);
        if (this.entry instanceof VideoDownloadAVPageEntry) {
            String title = this.entry.mPageData.title;
            String pTitle = "P" + String.valueOf(this.entry.mPageData.page);
            if (pTitle.equals(title)) {
                builder.append(" ").append(pTitle);
            } else {
                builder.append(" ").append(pTitle).append("-").append(title);
            }
        } else if (this.entry instanceof VideoDownloadSeasonEpEntry) {
            builder.append("-").append(TransformHelper.getReadableIndexTitle(this.entry));
        }
        return builder.toString();
    }

    public String getContent(Context context) {
        int i;
        if (this.entry == null || !this.entry.isValid()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder append = sb.append(context.getString(bili.resource.homepage.R.string.homepage_global_string_228));
        if (this.entry.isCompleted()) {
            i = bili.resource.common.R.string.common_global_string_254;
        } else {
            i = R.string.downloads_global_string_59;
        }
        append.append(context.getString(i)).append("\n");
        if (this.entry instanceof VideoDownloadAVPageEntry) {
            sb.append(context.getString(bili.resource.homepage.R.string.homepage_global_string_226)).append(" ").append(this.entry.getAvid()).append(String.format(Locale.US, context.getString(bili.resource.homepage.R.string.homepage_global_string_143), this.entry.mTitle));
            String title = this.entry.mPageData.title;
            String pTitle = "P" + String.valueOf(this.entry.mPageData.page);
            if (pTitle.equals(title)) {
                sb.append(pTitle);
            } else {
                sb.append(pTitle).append("-").append(title);
            }
        } else if (this.entry instanceof VideoDownloadSeasonEpEntry) {
            sb.append(context.getString(bili.resource.homepage.R.string.homepage_global_string_226)).append(" ").append(this.entry.getAvid()).append(String.format(Locale.US, context.getString(bili.resource.homepage.R.string.homepage_global_string_254), this.entry.mTitle, TransformHelper.getReadableIndexTitle(this.entry)));
        }
        return sb.toString();
    }

    public String getDownloadPath(Context context) {
        VideoFile tempFile = VideoFile.fromPath(context, this.storagePath);
        if (this.entry != null && this.entry.mStoragePath != null) {
            tempFile = VideoFile.fromPath(context, VideoDownloadStorageStrategy.getDownloadPath(context, this.entry));
        }
        return tempFile.getAbsolutePath();
    }

    public String getDirectoryTree(Context context) {
        if (TextUtils.isEmpty(this.storagePath)) {
            return "";
        }
        VideoFile rootDir = getDownloadVideoFile(context);
        if (rootDir == null || !rootDir.isDirectory()) {
            return context.getString(R.string.downloads_global_string_104);
        }
        StringBuilder sb = new StringBuilder();
        int floor = initTree(context, sb);
        generateSubTree(floor, rootDir.listFiles(), sb);
        return sb.toString();
    }

    private VideoFile getDownloadVideoFile(Context context) {
        VideoFile file = VideoFile.fromPath(context, this.storagePath);
        if (this.step == 1 || this.step == 2 || this.step == 3) {
            return file;
        }
        return file.getParentFile();
    }

    private int initTree(Context context, StringBuilder sb) {
        VideoFile file;
        VideoFile file2 = VideoFile.fromPath(context, this.storagePath);
        if (this.step == 3) {
            file = file2.getParentFile();
        } else {
            file = file2.getParentFile().getParentFile();
        }
        List<String> originSegments = Uri.parse(Uri.decode(this.storagePath)).getPathSegments();
        List<String> rootSegments = Uri.parse(Uri.decode(file.getAbsolutePath())).getPathSegments();
        int diff = originSegments.size() - rootSegments.size();
        if (diff == 0) {
            sb.append("+--- ").append(file.getName()).append("\n");
            return 1;
        }
        int rootLastIndex = rootSegments.size() - 1;
        for (int i = 0; i < diff; i++) {
            if (i > 0) {
                for (int j = 0; j < i; j++) {
                    sb.append(" |     ");
                }
            }
            sb.append("+--- ").append(originSegments.get(rootLastIndex + i)).append("\n");
        }
        return diff + 1;
    }

    private void generateSubTree(int floor, VideoFile[] fileList, StringBuilder sb) {
        if (fileList != null) {
            int i = 0;
            while (i < fileList.length) {
                if (floor > 1) {
                    for (int j = 0; j < floor - 1; j++) {
                        sb.append(" |     ");
                    }
                }
                VideoFile file = fileList[i];
                sb.append(i == fileList.length - 1 ? " \\--- " : "+--- ").append(file.getName()).append("\n");
                if (file.isDirectory()) {
                    generateSubTree(floor + 1, file.listFiles(), sb);
                }
                i++;
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.step);
        dest.writeString(this.storagePath);
        dest.writeParcelable(this.entry, flags);
    }

    protected ScanEntry(Parcel in) {
        this.step = in.readInt();
        this.storagePath = in.readString();
        this.entry = in.readParcelable(VideoDownloadEntry.class.getClassLoader());
    }
}