package tv.danmaku.bili.activities.login;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import bolts.Continuation;
import bolts.Task;
import com.bilibili.api.BiliApiException;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import com.bilibili.lib.accounts.AccountException;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.model.OAuthInfo;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.view.legacy.ScalableImageView2;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.R;
import tv.danmaku.bili.utils.passport.PassportHelper;

public class SSOActivity extends BaseToolbarActivity implements View.OnClickListener {
    private static final String ACTION_AUTHORIZE = "tv.danmaku.bili.action.AUTHORIZE";
    private static final String EXTRA_ACCESS_KEY = "access_key";
    private static final String EXTRA_PACKAGE_NAME = "package_name";
    private TextView mAccount;
    private ScalableImageView2 mAvatar;
    private View mBtnOk;
    private TintProgressDialog mDialog;
    private Task<OAuthInfo>.TaskCompletionSource mVerifyTask;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (!ACTION_AUTHORIZE.equals(intent.getAction())) {
            finish();
        }
        setContentView(R.layout.bili_app_activity_sso_old);
        this.mAvatar = findViewById(R.id.avatar);
        this.mAccount = (TextView) findViewById(R.id.account);
        this.mBtnOk = findViewById(R.id.ok);
        setupView(intent);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(bili.resource.others.R.string.others_global_string_393);
        }
        showBackButton();
        BLog.event(getCallingPackage() + " try to get authority");
    }

    private void setupView(Intent intent) {
        this.mBtnOk.setOnClickListener(this);
        TextView appTextView = (TextView) findViewById(R.id.text2);
        ImageView appImageView = (ImageView) findViewById(R.id.image2);
        String packageName = intent.getStringExtra(EXTRA_PACKAGE_NAME);
        try {
            ApplicationInfo info = getPackageManager().getApplicationInfo(packageName, 0);
            Drawable icon = info.loadIcon(getPackageManager());
            appImageView.setImageDrawable(icon);
            appTextView.setText(info.loadLabel(getPackageManager()));
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        performLoadMyinfoTask();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void performLoadMyinfoTask() {
        this.mDialog = TintProgressDialog.show(this, (CharSequence) null, getString(bili.resource.homepage.R.string.homepage_global_string_132), true, false);
        if (this.mVerifyTask != null && !this.mVerifyTask.getTask().isCompleted()) {
            this.mVerifyTask.trySetCancelled();
        }
        this.mVerifyTask = Task.create();
        PassportHelper.verify(getApplicationContext()).continueWith(new Continuation<OAuthInfo, Void>() { // from class: tv.danmaku.bili.activities.login.SSOActivity.1
            public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                return m657then((Task<OAuthInfo>) task);
            }

            /* renamed from: then  reason: collision with other method in class */
            public Void m657then(Task<OAuthInfo> task) throws Exception {
                if (task.isCancelled()) {
                    SSOActivity.this.mVerifyTask.trySetCancelled();
                    return null;
                } else if (task.isFaulted()) {
                    SSOActivity.this.mVerifyTask.trySetError(task.getError());
                    return null;
                } else {
                    SSOActivity.this.mVerifyTask.trySetResult((OAuthInfo) task.getResult());
                    return null;
                }
            }
        });
        this.mVerifyTask.getTask().continueWith(loadMyinfo(), Task.BACKGROUND_EXECUTOR).continueWith(handleAuthResult(), Task.UI_THREAD_EXECUTOR);
    }

    private Continuation<OAuthInfo, AccountInfo> loadMyinfo() {
        return new Continuation<OAuthInfo, AccountInfo>() { // from class: tv.danmaku.bili.activities.login.SSOActivity.2
            /* renamed from: then  reason: collision with other method in class */
            public /* bridge */ /* synthetic */ Object m658then(Task task) throws Exception {
                return then((Task<OAuthInfo>) task);
            }

            public AccountInfo then(Task<OAuthInfo> task) throws Exception {
                if (task.isFaulted()) {
                    AccountException error = task.getError();
                    if ((error instanceof AccountException) && SSOActivity.this.isTokenInvalid(error.code())) {
                        throw new BiliApiException(error.code());
                    }
                    return BiliAccountInfo.get().requestForMyAccountInfo();
                } else if (task.isCancelled()) {
                    return BiliAccountInfo.get().getAccountInfoFromCache();
                } else {
                    return BiliAccountInfo.get().requestForMyAccountInfo();
                }
            }
        };
    }

    private Continuation<AccountInfo, Void> handleAuthResult() {
        return new Continuation<AccountInfo, Void>() { // from class: tv.danmaku.bili.activities.login.SSOActivity.3
            public /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
                return m659then((Task<AccountInfo>) task);
            }

            /* renamed from: then  reason: collision with other method in class */
            public Void m659then(Task<AccountInfo> task) throws Exception {
                SSOActivity.this.mDialog.dismiss();
                if (task.isCancelled()) {
                    return null;
                }
                SSOActivity.this.setAccount((AccountInfo) task.getResult());
                SSOActivity.this.mVerifyTask = null;
                return null;
            }
        };
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v.getId() == R.id.ok) {
            BLog.event("Authorized " + getCallingPackage());
            Intent result = new Intent();
            result.putExtra(EXTRA_ACCESS_KEY, BiliAccounts.get(getApplicationContext()).getAccessKey());
            setResult(-1, result);
            finish();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.mVerifyTask != null && !this.mVerifyTask.getTask().isCompleted()) {
            this.mVerifyTask.trySetCancelled();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void setAccount(AccountInfo myInfo) {
        String accessKey = BiliAccounts.get(getApplicationContext()).getAccessKey();
        if (accessKey == null) {
            ToastHelper.showToastShort(this, bili.resource.homepage.R.string.homepage_global_string_157);
            finish();
        } else if (myInfo != null) {
            this.mBtnOk.setEnabled(true);
            if (!TextUtils.isEmpty(myInfo.getAvatar())) {
                BiliImageLoader.INSTANCE.with(this.mAvatar.getContext()).url(myInfo.getAvatar()).placeholderImageResId(com.bilibili.bilifeed.R.drawable.default_avater).into(this.mAvatar);
            }
            this.mAccount.setText(myInfo.getUserName());
        } else {
            this.mAccount.setText(bili.resource.homepage.R.string.homepage_global_string_326);
            this.mBtnOk.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isTokenInvalid(int code) {
        return code == -101 || code == -2 || code == -904 || code == -901 || code == -905 || code == -902 || code == -903 || code == 61000;
    }
}