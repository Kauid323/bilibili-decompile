package tv.danmaku.bili.ui.zhima;

import android.content.Context;
import android.content.Intent;
import com.bilibili.lib.ui.BaseFragment;

public class ZhiMaEnterContract {

    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    interface Presenter {
        void aliAuth();

        void manualAuth();

        void onActivityResult(int i, int i2, Intent intent);

        void reportShow();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public interface View {
        void dismissProgress();

        Context getContext();

        BaseFragment getSelf();

        boolean isActivityDie();

        void showProgressDialog(String str, boolean z);

        void showTip(int i);
    }
}