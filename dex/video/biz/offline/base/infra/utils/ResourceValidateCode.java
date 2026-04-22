package video.biz.offline.base.infra.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IjkMediaPlayerTracker;

/* compiled from: ResourceValidateCode.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lvideo/biz/offline/base/infra/utils/ResourceValidateCode;", "", "errCode", "", "<init>", "(Ljava/lang/String;II)V", "getErrCode", "()I", "SUCCESS", "ERROR_STORAGE_DIR_NOT_FOUND", "ERROR_INVALID_ENTRY", "ERROR_ENTRY_NO_TYPE_TAG", "ERROR_MEDIA_DIR_NOT_FOUND", "ERROR_INVALID_INDEX", "ERROR_DASH_NOT_FOUND", "infra_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public enum ResourceValidateCode {
    SUCCESS(0),
    ERROR_STORAGE_DIR_NOT_FOUND(IjkMediaPlayerTracker.BLIJK_EV_HTTP_WILL_REBUILD),
    ERROR_INVALID_ENTRY(IjkMediaPlayerTracker.BLIJK_EV_DNS_BUILD),
    ERROR_ENTRY_NO_TYPE_TAG(IjkMediaPlayerTracker.BLIJK_EV_TRANSPORT_BUILD),
    ERROR_MEDIA_DIR_NOT_FOUND(IjkMediaPlayerTracker.BLIJK_EV_HTTP_BUILD),
    ERROR_INVALID_INDEX(IjkMediaPlayerTracker.BLIJK_EV_FIRST_AUDIO_DATA),
    ERROR_DASH_NOT_FOUND(IjkMediaPlayerTracker.BLIJK_EV_FIRST_AUDIO_PKG);
    
    private final int errCode;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<ResourceValidateCode> getEntries() {
        return $ENTRIES;
    }

    ResourceValidateCode(int errCode) {
        this.errCode = errCode;
    }

    public final int getErrCode() {
        return this.errCode;
    }
}