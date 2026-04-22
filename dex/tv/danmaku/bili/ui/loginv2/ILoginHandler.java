package tv.danmaku.bili.ui.loginv2;

import androidx.fragment.app.FragmentActivity;
import com.bilibili.lib.accountsui.LoginCallback;

public interface ILoginHandler {
    void login(String str, String str2, boolean z);

    void onCreateView();

    void onDestroy();

    void setLoginExperimentValue(String str);

    void setPromptScene(String str);

    /* renamed from: tv.danmaku.bili.ui.loginv2.ILoginHandler$-CC  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final /* synthetic */ class CC {
        public static ILoginHandler getHandler(FragmentActivity context, LoginCallback loginCallback) {
            return new LoginHandlerImp(context, loginCallback);
        }
    }
}