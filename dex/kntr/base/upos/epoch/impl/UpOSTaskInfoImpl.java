package kntr.base.upos.epoch.impl;

import com.bilibili.gripper.upos.GUpOS;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.upos.UpOSTaskInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KUpOS.android.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkntr/base/upos/epoch/impl/UpOSTaskInfoImpl;", "Lkntr/base/upos/UpOSTaskInfo;", "gInfo", "Lcom/bilibili/gripper/upos/GUpOS$UploadTaskInfo;", "<init>", "(Lcom/bilibili/gripper/upos/GUpOS$UploadTaskInfo;)V", "getTaskID", "", "getFilePath", "getFileName", "getFileLength", "getStatus", "", "getCurrentStep", "isFreeTraffic", "", "getUpOSUri", "getUploadError", "getUploadErrorMsg", "upos_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
final class UpOSTaskInfoImpl implements UpOSTaskInfo {
    private final GUpOS.UploadTaskInfo gInfo;

    public UpOSTaskInfoImpl(GUpOS.UploadTaskInfo gInfo) {
        Intrinsics.checkNotNullParameter(gInfo, "gInfo");
        this.gInfo = gInfo;
    }

    @Override // kntr.base.upos.UpOSTaskInfo
    public String getTaskID() {
        return this.gInfo.getTaskID();
    }

    @Override // kntr.base.upos.UpOSTaskInfo
    public String getFilePath() {
        return this.gInfo.getFilePath();
    }

    @Override // kntr.base.upos.UpOSTaskInfo
    public String getFileName() {
        return this.gInfo.getFileName();
    }

    @Override // kntr.base.upos.UpOSTaskInfo
    public String getFileLength() {
        return String.valueOf(this.gInfo.getFileLength());
    }

    @Override // kntr.base.upos.UpOSTaskInfo
    public int getStatus() {
        return this.gInfo.getStatus();
    }

    @Override // kntr.base.upos.UpOSTaskInfo
    public int getCurrentStep() {
        return this.gInfo.getCurrentStep();
    }

    @Override // kntr.base.upos.UpOSTaskInfo
    public boolean isFreeTraffic() {
        return this.gInfo.isFreeTraffic();
    }

    @Override // kntr.base.upos.UpOSTaskInfo
    public String getUpOSUri() {
        return this.gInfo.getUpOSUri();
    }

    @Override // kntr.base.upos.UpOSTaskInfo
    public int getUploadError() {
        return this.gInfo.getUploadError();
    }

    @Override // kntr.base.upos.UpOSTaskInfo
    public String getUploadErrorMsg() {
        return this.gInfo.getUploadErrorMsg();
    }
}