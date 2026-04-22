package kntr.base.upos;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: IUpOS.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\u000bH&J\n\u0010\f\u001a\u0004\u0018\u00010\u0003H&J\b\u0010\r\u001a\u00020\bH&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u000fÀ\u0006\u0003"}, d2 = {"Lkntr/base/upos/UpOSTaskInfo;", "", "getTaskID", "", "getFilePath", "getFileName", "getFileLength", "getStatus", "", "getCurrentStep", "isFreeTraffic", "", "getUpOSUri", "getUploadError", "getUploadErrorMsg", "upos_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface UpOSTaskInfo {
    int getCurrentStep();

    String getFileLength();

    String getFileName();

    String getFilePath();

    int getStatus();

    String getTaskID();

    String getUpOSUri();

    int getUploadError();

    String getUploadErrorMsg();

    boolean isFreeTraffic();
}