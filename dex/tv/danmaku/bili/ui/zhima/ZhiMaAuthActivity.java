package tv.danmaku.bili.ui.zhima;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;
import com.bilibili.captcha.SecureJSBridge;
import com.bilibili.lib.basecomponent.R;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.cb.AuthResultCbMsg;
import tv.danmaku.bili.ui.reply.AuthReplyObservable;
import tv.danmaku.bili.ui.zhima.impl.AuthCheckListener;

public class ZhiMaAuthActivity extends BaseToolbarActivity implements SecureJSBridge.CaptchaCallback, AuthCheckListener, Observer {
    public static final String TAG = "ZhiMaAuthActivity";
    private ZhiMaEnterFragment mZhiMaEnterFragment;
    private ZhiMaProfileFragment mZhiMaProfileFragment;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bili_app_activity_with_toolbar);
        getSupportActionBar().setTitle(bili.resource.account.R.string.account_global_string_285);
        showBackButton();
        setupFragment(savedInstanceState, getSupportFragmentManager());
        AuthReplyObservable.registerAuthReplyObserver(this);
    }

    protected void onDestroy() {
        super.onDestroy();
        AuthReplyObservable.unRegisterAuthReplyObserver(this);
    }

    public void replyWithGeeCaptcha(Map<String, String> innerMap) {
        if (this.mZhiMaProfileFragment != null && this.mZhiMaProfileFragment.getPresenter() != null) {
            this.mZhiMaProfileFragment.getPresenter().replyWithGeeCaptcha(innerMap);
        }
    }

    @Deprecated
    public void replyWithImageCaptcha(int callbackId, Map<String, String> param) {
    }

    public void closeCaptchaDialog() {
        if (this.mZhiMaProfileFragment != null) {
            this.mZhiMaProfileFragment.hideCaptchaDialog();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Observer
    public void update(Observable o, Object arg) {
        if (arg instanceof AuthResultCbMsg) {
            AuthResultCbHelper.setResultToActivity(this, (AuthResultCbMsg) arg);
        }
        finish();
    }

    @Override // tv.danmaku.bili.ui.zhima.impl.AuthCheckListener
    public void checkDone(String telNum) {
        if (this.mZhiMaProfileFragment == null) {
            this.mZhiMaProfileFragment = ZhiMaProfileFragment.newInstance(telNum);
            getSupportFragmentManager().beginTransaction().hide(this.mZhiMaEnterFragment).add(com.bilibili.base.R.id.content_layout, this.mZhiMaProfileFragment, ZhiMaProfileFragment.TAG).commitAllowingStateLoss();
            return;
        }
        getSupportFragmentManager().beginTransaction().hide(this.mZhiMaEnterFragment).show(this.mZhiMaProfileFragment).commitAllowingStateLoss();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBackPressed() {
        if (this.mZhiMaProfileFragment != null && this.mZhiMaProfileFragment.isVisible()) {
            AlertDialog dialog = new AlertDialog.Builder(this).setTitle(bili.resource.account.R.string.account_global_string_276).setMessage(bili.resource.account.R.string.account_global_string_229).setPositiveButton(bili.resource.account.R.string.account_global_string_212, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.ui.zhima.ZhiMaAuthActivity$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ZhiMaAuthActivity.this.m1864lambda$onBackPressed$0$tvdanmakubiliuizhimaZhiMaAuthActivity(dialogInterface, i);
                }
            }).setNegativeButton(bili.resource.account.R.string.account_global_string_203, new DialogInterface.OnClickListener() { // from class: tv.danmaku.bili.ui.zhima.ZhiMaAuthActivity$$ExternalSyntheticLambda1
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    ZhiMaAuthActivity.lambda$onBackPressed$1(dialogInterface, i);
                }
            }).create();
            dialog.show();
            return;
        }
        AuthResultCbHelper.setResultToActivity(this, -1);
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$onBackPressed$0$tv-danmaku-bili-ui-zhima-ZhiMaAuthActivity  reason: not valid java name */
    public /* synthetic */ void m1864lambda$onBackPressed$0$tvdanmakubiliuizhimaZhiMaAuthActivity(DialogInterface dialog1, int which) {
        AuthResultCbHelper.setResultToActivity(this, -1);
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onBackPressed$1(DialogInterface dialog1, int which) {
    }

    private void setupFragment(Bundle savedInstanceState, FragmentManager fragmentManager) {
        if (savedInstanceState != null) {
            this.mZhiMaEnterFragment = fragmentManager.findFragmentByTag(ZhiMaEnterFragment.TAG);
            this.mZhiMaProfileFragment = fragmentManager.findFragmentByTag(ZhiMaProfileFragment.TAG);
        }
        if (this.mZhiMaEnterFragment == null) {
            this.mZhiMaEnterFragment = ZhiMaEnterFragment.newInstance(this);
            fragmentManager.beginTransaction().add(com.bilibili.base.R.id.content_layout, this.mZhiMaEnterFragment, ZhiMaEnterFragment.TAG).commit();
        } else if (this.mZhiMaProfileFragment != null) {
            fragmentManager.beginTransaction().hide(this.mZhiMaEnterFragment).show(this.mZhiMaProfileFragment).commit();
        } else {
            fragmentManager.beginTransaction().show(this.mZhiMaEnterFragment).commit();
        }
    }
}