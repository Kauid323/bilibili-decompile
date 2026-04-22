package tv.danmaku.bili.ui.notice.api;

import com.bilibili.api.BiliConfig;
import com.bilibili.okretro.BiliApiCallback;
import com.bilibili.okretro.ServiceGenerator;
import com.bilibili.okretro.call.BiliCall;

public class NoticeApiHelper {
    private static final int NOTICE_TYPE_DRAWER = 1;
    private static String mNoticeVer;

    public static BiliCall getNotice(final BiliApiCallback<BiliNotice> callback) {
        BiliCall<BiliNotice> call = ((NoticeService) ServiceGenerator.createService(NoticeService.class)).getNotice(BiliConfig.getChannel(), 1, mNoticeVer);
        call.enqueue(new BiliApiCallback<BiliNotice>() { // from class: tv.danmaku.bili.ui.notice.api.NoticeApiHelper.1
            public void onSuccess(BiliNotice result) {
                if (result != null && result.code == -304) {
                    return;
                }
                if (result != null) {
                    NoticeApiHelper.mNoticeVer = result.ver;
                }
                callback.onSuccess(result);
            }

            public void onError(Throwable t) {
                callback.onError(t);
            }
        });
        return call;
    }
}