package tv.danmaku.bili.ui.filechooser;

import android.content.Context;
import android.os.FileObserver;
import androidx.loader.content.AsyncTaskLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FileLoader extends AsyncTaskLoader<List<File>> {
    private static final int FILE_OBSERVER_MASK = 4034;
    private static final String ROOT = "/";
    private List<File> mData;
    private FileObserver mFileObserver;
    private String mPath;

    public FileLoader(Context context, String path) {
        super(context);
        this.mPath = path;
    }

    public List<File> loadInBackground() {
        ArrayList<File> list = new ArrayList<>();
        File pathDir = new File(this.mPath);
        File[] dirs = pathDir.listFiles(FileUtils.sDirFilter);
        if (dirs != null) {
            Arrays.sort(dirs, FileUtils.sComparator);
            if (!this.mPath.equals(ROOT)) {
                list.add(new File(pathDir, ".."));
            }
            Collections.addAll(list, dirs);
        } else {
            File hasParentFile = pathDir.getParentFile();
            if (hasParentFile != null && !hasParentFile.getAbsolutePath().equals(ROOT)) {
                list.add(new File(pathDir, ".."));
            }
        }
        return list;
    }

    public void deliverResult(List<File> data) {
        if (isReset()) {
            onReleaseResources(data);
            return;
        }
        List<File> oldData = this.mData;
        this.mData = data;
        if (isStarted()) {
            super.deliverResult(data);
        }
        if (oldData != null && oldData != data) {
            onReleaseResources(oldData);
        }
    }

    protected void onStartLoading() {
        if (this.mData != null) {
            deliverResult(this.mData);
        }
        if (this.mFileObserver == null) {
            this.mFileObserver = new FileObserver(this.mPath, FILE_OBSERVER_MASK) { // from class: tv.danmaku.bili.ui.filechooser.FileLoader.1
                @Override // android.os.FileObserver
                public void onEvent(int event, String path) {
                    FileLoader.this.onContentChanged();
                }
            };
        }
        this.mFileObserver.startWatching();
        if (takeContentChanged() || this.mData == null) {
            forceLoad();
        }
    }

    protected void onStopLoading() {
        cancelLoad();
    }

    protected void onReset() {
        onStopLoading();
        if (this.mData != null) {
            onReleaseResources(this.mData);
            this.mData = null;
        }
    }

    public void onCanceled(List<File> data) {
        super.onCanceled(data);
        onReleaseResources(data);
    }

    protected void onReleaseResources(List<File> data) {
        if (this.mFileObserver != null) {
            this.mFileObserver.stopWatching();
            this.mFileObserver = null;
        }
    }
}