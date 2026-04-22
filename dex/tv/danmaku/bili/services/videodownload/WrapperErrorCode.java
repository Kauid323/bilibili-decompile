package tv.danmaku.bili.services.videodownload;

import com.bilibili.videodownloader.exceptions.ErrCode;

public class WrapperErrorCode {
    public static final int UNICON_RESOLVE_UNSUPPORT_THIRD = ErrCode.freeDataErrorCodeStart();
    public static final int UNICON_RESOLVE_CONDITION_NOT_MATHCED = UNICON_RESOLVE_UNSUPPORT_THIRD + 1;
    public static final int UNICON_RESOLVE_TRANSFORM_IP = UNICON_RESOLVE_CONDITION_NOT_MATHCED + 1;
    public static final int UNICON_RESOLVE_TRANSFORM_SEGMENT = UNICON_RESOLVE_TRANSFORM_IP + 1;
    public static final int UNICON_RESOLVE_TRANSFORM_DANMAKU = UNICON_RESOLVE_TRANSFORM_SEGMENT + 1;
    public static final int FHD_QUALITY_NOT_LOGIN = ErrCode.otherErrorCodeStart();
}