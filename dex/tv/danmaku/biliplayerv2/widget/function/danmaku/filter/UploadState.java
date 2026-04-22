package tv.danmaku.biliplayerv2.widget.function.danmaku.filter;

import java.util.ArrayList;
import java.util.List;

public class UploadState {
    private static UploadState sUploadState;
    private boolean isUploading = false;
    private List<Observer> mObservers;

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface Observer {
        void onChanged(boolean z);
    }

    public static UploadState obtain() {
        if (sUploadState == null) {
            sUploadState = new UploadState();
        }
        return sUploadState;
    }

    public boolean isUploading() {
        return this.isUploading;
    }

    public void setUploading(boolean uploading) {
        if (this.isUploading != uploading) {
            this.isUploading = uploading;
            notifyChanged();
        }
    }

    public void register(Observer observer) {
        if (this.mObservers == null) {
            this.mObservers = new ArrayList();
        }
        if (!this.mObservers.contains(observer)) {
            this.mObservers.add(observer);
        }
    }

    public void unregister(Observer observer) {
        if (this.mObservers != null && this.mObservers.contains(observer)) {
            this.mObservers.remove(observer);
        }
    }

    private void notifyChanged() {
        if (this.mObservers != null && !this.mObservers.isEmpty()) {
            for (Observer observer : this.mObservers) {
                observer.onChanged(this.isUploading);
            }
        }
    }
}