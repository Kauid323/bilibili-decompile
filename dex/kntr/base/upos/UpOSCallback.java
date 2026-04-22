package kntr.base.upos;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;

/* compiled from: IUpOS.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H&¨\u0006\u0015À\u0006\u0003"}, d2 = {"Lkntr/base/upos/UpOSCallback;", "", "onSuccess", "", "taskInfo", "Lkntr/base/upos/UpOSTaskInfo;", "resultFile", "", "onFail", "error", "", "onProgress", "progress", "", "onStart", "onPause", "onResume", "onCancel", "onSpeed", "speed", "remainTime", "upos_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface UpOSCallback {
    void onCancel(UpOSTaskInfo upOSTaskInfo);

    void onFail(UpOSTaskInfo upOSTaskInfo, int i);

    void onPause(UpOSTaskInfo upOSTaskInfo);

    void onProgress(UpOSTaskInfo upOSTaskInfo, float f);

    void onResume(UpOSTaskInfo upOSTaskInfo);

    void onSpeed(UpOSTaskInfo upOSTaskInfo, String str, String str2);

    void onStart(UpOSTaskInfo upOSTaskInfo);

    void onSuccess(UpOSTaskInfo upOSTaskInfo, String str);
}