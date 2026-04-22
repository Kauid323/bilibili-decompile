package video.biz.offline.base.model.error;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import tv.danmaku.bili.ui.personinfo.PersonInfoLoadFragment;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* compiled from: DownloadException.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u0000 \u00182\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0018B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0012\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\bR\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0019"}, d2 = {"Lvideo/biz/offline/base/model/error/DownloadErrorType;", "Lvideo/biz/offline/base/model/error/OfflineErrorCode;", "", "code", "", "<init>", "(Ljava/lang/String;II)V", "getCode", "()I", "UNKNOWN", "ADDRESS_EMPTY", "STORAGE_SPACE_FULL", "NOT_WIFI", "NETWORK_DISCONNECT", "LOGOUT", "NOT_VIP_DOWNLOAD_VIP_VIDEO", "TOO_LARGE", "PLAYVIEW_ERROR", "errorCode", "getErrorCode", "trackMsg", "", "getTrackMsg", "()Ljava/lang/String;", "Companion", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public enum DownloadErrorType implements OfflineErrorCode {
    UNKNOWN(PersonInfoLoadFragment.ERROR_CODE_MODIFY_FORBIDDEN),
    ADDRESS_EMPTY(10001),
    STORAGE_SPACE_FULL(10002),
    NOT_WIFI(10003),
    NETWORK_DISCONNECT(IMediaPlayer.MEDIA_INFO_VIDEO_DECODED_START),
    LOGOUT(10005),
    NOT_VIP_DOWNLOAD_VIP_VIDEO(IMediaPlayer.MEDIA_INFO_FIND_STREAM_INFO),
    TOO_LARGE(10007),
    PLAYVIEW_ERROR(IMediaPlayer.MEDIA_INFO_VIDEO_SEEK_RENDERING_START);
    
    private final int code;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);
    public static final Companion Companion = new Companion(null);

    /* compiled from: DownloadException.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DownloadErrorType.values().length];
            try {
                iArr[DownloadErrorType.UNKNOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[DownloadErrorType.ADDRESS_EMPTY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[DownloadErrorType.STORAGE_SPACE_FULL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[DownloadErrorType.NOT_WIFI.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[DownloadErrorType.NETWORK_DISCONNECT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                iArr[DownloadErrorType.LOGOUT.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                iArr[DownloadErrorType.NOT_VIP_DOWNLOAD_VIP_VIDEO.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                iArr[DownloadErrorType.TOO_LARGE.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                iArr[DownloadErrorType.PLAYVIEW_ERROR.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static EnumEntries<DownloadErrorType> getEntries() {
        return $ENTRIES;
    }

    DownloadErrorType(int code) {
        this.code = code;
    }

    @Override // video.biz.offline.base.model.error.OfflineErrorCode
    public int getCode() {
        return this.code;
    }

    /* compiled from: DownloadException.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lvideo/biz/offline/base/model/error/DownloadErrorType$Companion;", "", "<init>", "()V", "from", "Lvideo/biz/offline/base/model/error/DownloadErrorType;", "value", "", "model_debug"}, k = 1, mv = {2, 2, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DownloadErrorType from(int value) {
            Object element$iv;
            boolean z;
            Iterable $this$firstOrNull$iv = DownloadErrorType.getEntries();
            Iterator it = $this$firstOrNull$iv.iterator();
            while (true) {
                if (it.hasNext()) {
                    element$iv = it.next();
                    DownloadErrorType it2 = (DownloadErrorType) element$iv;
                    if (it2.getCode() == value) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    element$iv = null;
                    break;
                }
            }
            DownloadErrorType downloadErrorType = (DownloadErrorType) element$iv;
            return downloadErrorType == null ? DownloadErrorType.UNKNOWN : downloadErrorType;
        }
    }

    public final int getErrorCode() {
        return OfflineError.INSTANCE.generateErrorCode(OfflineErrorType.DOWNLOAD_ERROR, this);
    }

    public final String getTrackMsg() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return "未知错误类型";
            case 2:
                return "下载地址为空";
            case 3:
                return "存储空间不足";
            case 4:
                return "非wifi网络";
            case 5:
                return "网络断开";
            case 6:
                return "用户未登录";
            case 7:
                return "非VIP下载vip资源";
            case 8:
                return "视频超过4G";
            case 9:
                return "playview请求失败";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}