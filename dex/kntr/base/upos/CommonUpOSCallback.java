package kntr.base.upos;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IUpOS.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0016¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lkntr/base/upos/CommonUpOSCallback;", "Lkntr/base/upos/UpOSCallback;", "onStart", "", "taskInfo", "Lkntr/base/upos/UpOSTaskInfo;", "onPause", "onResume", "onCancel", "onSpeed", "speed", "", "remainTime", "upos_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public interface CommonUpOSCallback extends UpOSCallback {
    @Override // kntr.base.upos.UpOSCallback
    void onCancel(UpOSTaskInfo upOSTaskInfo);

    @Override // kntr.base.upos.UpOSCallback
    void onPause(UpOSTaskInfo upOSTaskInfo);

    @Override // kntr.base.upos.UpOSCallback
    void onResume(UpOSTaskInfo upOSTaskInfo);

    @Override // kntr.base.upos.UpOSCallback
    void onSpeed(UpOSTaskInfo upOSTaskInfo, String str, String str2);

    @Override // kntr.base.upos.UpOSCallback
    void onStart(UpOSTaskInfo upOSTaskInfo);

    /* compiled from: IUpOS.kt */
    /* renamed from: kntr.base.upos.CommonUpOSCallback$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public final /* synthetic */ class CC {
        public static void $default$onSpeed(CommonUpOSCallback _this, UpOSTaskInfo taskInfo, String speed, String remainTime) {
            Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
            Intrinsics.checkNotNullParameter(speed, "speed");
            Intrinsics.checkNotNullParameter(remainTime, "remainTime");
        }
    }

    /* compiled from: IUpOS.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class DefaultImpls {
        @Deprecated
        public static void onStart(CommonUpOSCallback $this, UpOSTaskInfo taskInfo) {
            Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
            Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        }

        @Deprecated
        public static void onPause(CommonUpOSCallback $this, UpOSTaskInfo taskInfo) {
            Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
            Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        }

        @Deprecated
        public static void onResume(CommonUpOSCallback $this, UpOSTaskInfo taskInfo) {
            Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
            Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        }

        @Deprecated
        public static void onCancel(CommonUpOSCallback $this, UpOSTaskInfo taskInfo) {
            Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
            Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
        }

        @Deprecated
        public static void onSpeed(CommonUpOSCallback $this, UpOSTaskInfo taskInfo, String speed, String remainTime) {
            Intrinsics.checkNotNullParameter(taskInfo, "taskInfo");
            Intrinsics.checkNotNullParameter(speed, "speed");
            Intrinsics.checkNotNullParameter(remainTime, "remainTime");
            CC.$default$onSpeed($this, taskInfo, speed, remainTime);
        }
    }
}