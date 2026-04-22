package tv.danmaku.bili.services.videodownload.monitor;

import com.bilibili.base.BiliContext;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.videodownloader.utils.monitor.VideoDownloadLoginStateMonitor;

public class VideoDownloadLoginStateMonitorImpl implements VideoDownloadLoginStateMonitor {
    private VideoDownloadLoginStateMonitor.LoginStateListener mListener;
    private PassportObserver passportObserver = new PassportObserver() { // from class: tv.danmaku.bili.services.videodownload.monitor.VideoDownloadLoginStateMonitorImpl.1
        public void onChange(Topic topic) {
            if (topic == Topic.SIGN_IN) {
                if (VideoDownloadLoginStateMonitorImpl.this.mListener != null) {
                    VideoDownloadLoginStateMonitorImpl.this.mListener.onLogin();
                }
            } else if (topic == Topic.SIGN_OUT && VideoDownloadLoginStateMonitorImpl.this.mListener != null) {
                VideoDownloadLoginStateMonitorImpl.this.mListener.onLogout();
            }
        }
    };

    public void setLoginListener(VideoDownloadLoginStateMonitor.LoginStateListener listener) {
        if (listener != null) {
            BiliAccounts.get(BiliContext.application()).subscribe(this.passportObserver, new Topic[]{Topic.SIGN_IN, Topic.SIGN_OUT});
        } else {
            BiliAccounts.get(BiliContext.application()).unsubscribe(this.passportObserver, new Topic[]{Topic.SIGN_IN, Topic.SIGN_OUT});
        }
        this.mListener = listener;
    }
}