package tv.danmaku.bili.ui.zhima;

import android.app.Activity;
import android.net.Uri;
import com.bilibili.lib.ui.BaseFragment;
import java.util.Map;
import tv.danmaku.bili.utils.TimerCount;

public class ZhiMaProfileContract {

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    interface Presenter {
        void confirmAuthResult();

        void openAlbum(BaseFragment baseFragment);

        void replyWithGeeCaptcha(Map<String, String> map);

        void reportShow();

        void sendCaptcha(TimerCount timerCount);

        void startCamera(BaseFragment baseFragment);

        void submitAuthInfo(String str, String str2, String str3, String str4);

        void uploadCardPic(Uri uri);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface View {
        void dismissProgress();

        Activity getActivity();

        void hideCaptchaDialog();

        boolean isActivityDie();

        void showCaptchaDialog(String str);

        void showProgressDialog(String str, boolean z);

        void showTip(int i);

        void showTip(String str);

        void updateUIAfterConfirmGeeCaptcha();

        void updateUIAfterSubmitSuccess();

        void updateUIAfterUpPic(String str);
    }
}