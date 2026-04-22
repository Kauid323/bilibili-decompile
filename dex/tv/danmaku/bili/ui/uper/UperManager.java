package tv.danmaku.bili.ui.uper;

public class UperManager {
    private static UperManager instance = new UperManager();
    private boolean mHotCreate;
    private boolean mUploadCreate;

    private UperManager() {
    }

    public static UperManager getInstance() {
        return instance;
    }

    public void setUploadCreate(boolean uploadCreate) {
        this.mUploadCreate = uploadCreate;
    }

    public void setHotCreate(boolean hotCreate) {
        this.mHotCreate = hotCreate;
    }

    public boolean isUploadCreate() {
        return this.mUploadCreate;
    }

    public boolean isHotCreate() {
        return this.mHotCreate;
    }

    public void reset() {
        this.mHotCreate = false;
        this.mUploadCreate = false;
    }
}