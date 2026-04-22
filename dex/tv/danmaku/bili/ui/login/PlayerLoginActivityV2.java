package tv.danmaku.bili.ui.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import com.bilibili.app.comm.baseres.R;
import com.bilibili.base.BiliContext;
import com.bilibili.droid.BundleUtil;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.subscribe.PassportObserver;
import com.bilibili.lib.accounts.subscribe.Topic;
import com.bilibili.lib.accountsui.captcha.JsBridgeCallHandlerSecure;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import java.util.Map;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.loginv2.LoginOriginalActivityV2;
import tv.danmaku.bili.ui.util.AccountUtils;
import tv.danmaku.biliplayerv2.utils.NavigationHelper;

public class PlayerLoginActivityV2 extends BaseAppCompatActivity implements JsBridgeCallHandlerSecure.CaptchaCallback, PassportObserver {
    PlayerLoginFragmentV2 fragment;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundleLike;
        super.onCreate(savedInstanceState);
        Activity topActivity = BiliContext.topActivitiy();
        if (topActivity != null && topActivity != this && topActivity.getClass() == getClass()) {
            finish();
            return;
        }
        this.fragment = getSupportFragmentManager().findFragmentByTag(PlayerLoginFragmentV2.TAG);
        if (this.fragment == null) {
            Bundle extra = getIntent().getExtras();
            if (extra != null && (bundleLike = extra.getBundle(BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE)) != null) {
                extra.putAll(bundleLike);
            }
            boolean enableSms = BundleUtil.getBoolean(extra, "smsEnable", new boolean[]{false});
            boolean enableQuick = BundleUtil.getBoolean(extra, "quickEnable", new boolean[]{false});
            String promptScene = BundleUtil.getString(extra, LoginOriginalActivityV2.KEY_PROMPT_SCENE, new String[0]);
            this.fragment = PlayerLoginFragmentV2.newInstance(enableSms, enableQuick, promptScene, AccountUtils.getRouterFrom(this));
            getSupportFragmentManager().beginTransaction().add(16908290, this.fragment, PlayerLoginFragmentV2.TAG).commitAllowingStateLoss();
        }
        BiliAccounts.get(this).subscribe(Topic.SIGN_IN, this);
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, PlayerLoginActivityV2.class);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Window window = getWindow();
        DisplayMetrics dm = getResources().getDisplayMetrics();
        if (dm.widthPixels > dm.heightPixels) {
            window.setFlags(MisakaHelper.MAX_REPORT_SIZE, MisakaHelper.MAX_REPORT_SIZE);
            NavigationHelper.INSTANCE.hideNavigationImmersive(this);
        } else {
            window.setFlags(2048, 2048);
        }
        window.getDecorView().findViewById(16908290).setFitsSystemWindows(true);
        window.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.black_alpha40)));
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = -1;
        params.height = -1;
        window.setAttributes(params);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    public void replyWithGeeCaptcha(Map<String, String> innerMap) {
        if (this.fragment != null) {
            this.fragment.replyWithGeeCaptcha(innerMap);
        }
    }

    public void closeCaptchaDialog() {
        if (this.fragment != null) {
            this.fragment.closeCaptchaDialog();
        }
    }

    public void replyWithImageCaptcha(int callbackId, Map<String, String> param) {
        if (this.fragment != null) {
            this.fragment.replyWithImageCaptcha(callbackId, param);
        }
    }

    public void onChange(Topic topic) {
        if (topic == Topic.SIGN_IN && this != BiliContext.topActivitiy()) {
            finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDestroy() {
        super.onDestroy();
        BiliAccounts.get(this).unsubscribe(Topic.SIGN_IN, this);
    }
}