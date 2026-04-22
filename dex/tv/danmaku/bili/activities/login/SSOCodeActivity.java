package tv.danmaku.bili.activities.login;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import bili.resource.homepage.R;
import com.bilibili.base.BiliContext;
import com.bilibili.biligame.utils.GameDownloadUtils;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.accounts.model.AuthorizeCode;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.image2.bean.BitmapTransformation;
import com.bilibili.lib.image2.bean.ImageLoadingListener;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.bean.ThumbnailUrlTransformStrategy;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.imageviewer.utils.ImageExtentionKt;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import com.bilibili.magicasakura.widgets.TintProgressDialog;
import com.bilibili.privacy.PrivacyHelper;
import com.bilibili.pvtracker.IPvTracker;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.activities.login.AuthLoginRepoter;

/* compiled from: SSOCodeActivity.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0001/B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\"\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\b\u0010!\u001a\u00020\u0018H\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020 H\u0002J\b\u0010%\u001a\u00020\u0018H\u0002J\b\u0010&\u001a\u00020\u0018H\u0002J\b\u0010'\u001a\u00020\u0018H\u0002J\u0012\u0010(\u001a\u00020\u00182\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u001dH\u0002J\b\u0010-\u001a\u00020\u0006H\u0016J\b\u0010.\u001a\u00020\u001aH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Ltv/danmaku/bili/activities/login/SSOCodeActivity;", "Lcom/bilibili/lib/ui/BaseToolbarActivity;", "Lcom/bilibili/pvtracker/IPvTracker;", "<init>", "()V", "mTargetPackageName", "", "mTargetSubId", "mTargetAppKey", "mTargetSignature", "mAvatar", "Lcom/bilibili/lib/image2/view/BiliImageView;", "mAccount", "Landroid/widget/TextView;", "mBtnOk", "Landroid/view/View;", "mDialog", "Lcom/bilibili/magicasakura/widgets/TintProgressDialog;", "authedAppName", "", "mAgreementText", "mLoading", "Landroid/widget/ProgressBar;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "loadAgreement", "checkIsValidParams", "", "intent", "getAccountInfo", "doAuthorizing", "targetSignatureSync", "setAuthorizeResult", "authorizeCode", "Lcom/bilibili/lib/accounts/model/AuthorizeCode;", "isLogout", "code", "getPvEventId", "getPvExtra", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class SSOCodeActivity extends BaseToolbarActivity implements IPvTracker {
    private static final String ACTION_AUTHORIZE = "tv.danmaku.bili.action.sso.authorize";
    private static final String EXTRA_CODE = "code";
    private static final String EXTRA_TARGET_APPKEY = "target_appkey";
    private static final String EXTRA_TARGET_SUBID = "target_subid";
    public static final String LOGIN_ROUTE = "activity://main/login/";
    private static final int REQ_CODE_LOGIN = 109;
    private CharSequence authedAppName;
    private TextView mAccount;
    private TextView mAgreementText;
    private BiliImageView mAvatar;
    private View mBtnOk;
    private TintProgressDialog mDialog;
    private ProgressBar mLoading;
    private String mTargetAppKey;
    private String mTargetPackageName = "";
    private String mTargetSignature;
    private String mTargetSubId;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public /* synthetic */ boolean appendEndExtra() {
        return IPvTracker.-CC.$default$appendEndExtra(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    public /* synthetic */ String getUniqueKey() {
        return IPvTracker.-CC.$default$getUniqueKey(this);
    }

    public /* synthetic */ boolean shouldReport() {
        return IPvTracker.-CC.$default$shouldReport(this);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        if (!checkIsValidParams(intent)) {
            ToastHelper.showToastLong(BiliContext.application(), R.string.homepage_global_string_141);
            finish();
        }
        setContentView(tv.danmaku.bili.R.layout.bili_app_activity_sso);
        ensureToolbar();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(bili.resource.others.R.string.others_global_string_393);
        }
        showBackButton();
        PackageManager packageManager = getPackageManager();
        ApplicationInfo info = null;
        ApplicationInfo biliInfo = null;
        try {
            info = packageManager.getApplicationInfo(this.mTargetPackageName, 0);
            biliInfo = packageManager.getApplicationInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            ToastHelper.showToastLong(BiliContext.application(), R.string.homepage_global_string_196);
        }
        if (info == null || biliInfo == null) {
            finish();
            return;
        }
        Drawable biliIcon = biliInfo.loadIcon(packageManager);
        ImageView biliImageView = (ImageView) findViewById(tv.danmaku.bili.R.id.image1);
        biliImageView.setImageDrawable(biliIcon);
        Drawable appIcon = info.loadIcon(packageManager);
        ImageView appImageView = (ImageView) findViewById(tv.danmaku.bili.R.id.image2);
        appImageView.setImageDrawable(appIcon);
        TextView appTextView = (TextView) findViewById(tv.danmaku.bili.R.id.text2);
        this.authedAppName = info.loadLabel(packageManager);
        appTextView.setText(this.authedAppName);
        this.mAvatar = findViewById(tv.danmaku.bili.R.id.avatar);
        this.mAccount = (TextView) findViewById(tv.danmaku.bili.R.id.account);
        this.mBtnOk = findViewById(tv.danmaku.bili.R.id.ok);
        View view = this.mBtnOk;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.activities.login.SSOCodeActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    SSOCodeActivity.this.doAuthorizing();
                }
            });
        }
        this.mAgreementText = (TextView) findViewById(tv.danmaku.bili.R.id.agreement);
        this.mLoading = (ProgressBar) findViewById(tv.danmaku.bili.R.id.progress_bar);
        loadAgreement();
        if (BiliAccounts.get((Context) this).isLogin()) {
            getAccountInfo();
            return;
        }
        RouteRequest request = new RouteRequest.Builder("activity://main/login/").requestCode(109).build();
        BLRouter.routeTo(request, (Context) this);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 109) {
            if (resultCode == -1) {
                getAccountInfo();
            } else {
                finish();
            }
        }
    }

    private final void loadAgreement() {
        TextView textView = this.mAgreementText;
        if (textView != null) {
            textView.setVisibility(8);
        }
        ProgressBar progressBar = this.mLoading;
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new SSOCodeActivity$loadAgreement$1(this, null), 3, (Object) null);
    }

    private final boolean checkIsValidParams(Intent intent) {
        ComponentName component = getCallingActivity();
        if (component == null) {
            return false;
        }
        String packageName = component.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        this.mTargetPackageName = packageName;
        if (Intrinsics.areEqual(ACTION_AUTHORIZE, intent.getAction())) {
            this.mTargetAppKey = intent.getStringExtra(EXTRA_TARGET_APPKEY);
            String str = this.mTargetAppKey;
            if (str == null || StringsKt.isBlank(str)) {
                return false;
            }
            this.mTargetSubId = intent.getStringExtra(EXTRA_TARGET_SUBID);
            return true;
        }
        return false;
    }

    private final void getAccountInfo() {
        BiliImageView biliImageView;
        AccountInfo myInfo = BiliAccountInfo.Companion.get().getAccountInfoFromCache();
        if (myInfo != null) {
            View view = this.mBtnOk;
            if (view != null) {
                view.setEnabled(true);
            }
            if (!TextUtils.isEmpty(myInfo.getAvatar()) && (biliImageView = this.mAvatar) != null) {
                ImageExtentionKt.displayImage$default(biliImageView, myInfo.getAvatar(), (ThumbnailUrlTransformStrategy) null, (ImageLoadingListener) null, 0, 0, false, false, (ScaleType) null, (BitmapTransformation) null, false, 1022, (Object) null);
            }
            TextView textView = this.mAccount;
            if (textView != null) {
                textView.setText(myInfo.getUserName());
                return;
            }
            return;
        }
        TextView textView2 = this.mAccount;
        if (textView2 != null) {
            textView2.setText(R.string.homepage_global_string_326);
        }
        View view2 = this.mBtnOk;
        if (view2 != null) {
            view2.setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doAuthorizing() {
        AuthLoginRepoter.report(AuthLoginRepoter.Click.APP_AUTHORIZE_LOGIN_CONFIRM_CLICK, String.valueOf(this.authedAppName));
        TintProgressDialog $this$doAuthorizing_u24lambda_u240 = this.mDialog;
        if ($this$doAuthorizing_u24lambda_u240 != null) {
            $this$doAuthorizing_u24lambda_u240.dismiss();
        }
        this.mDialog = TintProgressDialog.show((Context) this, (CharSequence) null, getString(R.string.homepage_global_string_132), true, false);
        LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this).launchWhenStarted(new SSOCodeActivity$doAuthorizing$2(this, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void targetSignatureSync() {
        try {
            PackageInfo packageInfo = __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo(getPackageManager(), this.mTargetPackageName, 64);
            this.mTargetSignature = GameDownloadUtils.parseApkSignature(packageInfo);
        } catch (PackageManager.NameNotFoundException ignore) {
            ignore.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0049, code lost:
        if (kotlin.text.StringsKt.contains$default(r5, r9, false, 2, (java.lang.Object) null) == true) goto L19;
     */
    @JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static PackageInfo __Ghost$Insertion$com_bilibili_privacy_PrivacyGhost_getPackageInfo(PackageManager pm, String pkg, int flag) {
        boolean agreeGetPackageInfo;
        Intrinsics.checkNotNullParameter(pm, "pm");
        Intrinsics.checkNotNullParameter(pkg, "pkg");
        boolean inPkgWhiteLst = true;
        try {
            agreeGetPackageInfo = ConfigManager.Companion.ab2().getWithDefault("ff.privacy.hook.agree.get_package_info", true);
        } catch (Exception e) {
            agreeGetPackageInfo = true;
        }
        if (!PrivacyHelper.INSTANCE.checkPrivacy$privacy_debug("pm_get_package_info") || !agreeGetPackageInfo) {
            try {
                String str = (String) ConfigManager.Companion.config().get("privacy.pkg_info_whitelist", (Object) null);
                if (str != null) {
                }
                inPkgWhiteLst = false;
            } catch (Exception e2) {
            }
            if (!inPkgWhiteLst) {
                if (Intrinsics.areEqual(pkg, FoundationAlias.getFapps().getAppId())) {
                    PackageInfo fake = pm.getPackageArchiveInfo(FoundationAlias.getFapp().getPackageCodePath(), 0);
                    if (fake == null) {
                        PackageInfo it = new PackageInfo();
                        it.versionCode = 2233;
                        return it;
                    }
                    return fake;
                }
                throw new PackageManager.NameNotFoundException(pkg);
            }
        }
        PackageInfo packageInfo = pm.getPackageInfo(pkg, Integer.valueOf(flag).intValue());
        if (packageInfo instanceof PackageInfo) {
            return packageInfo;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setAuthorizeResult(AuthorizeCode authorizeCode) {
        BLog.event("Authorized " + getCallingPackage());
        if (authorizeCode != null && !TextUtils.isEmpty(authorizeCode.code)) {
            Intent result = new Intent();
            result.putExtra("code", authorizeCode.code);
            setResult(-1, result);
        } else {
            ToastHelper.showToastLong((Context) this, R.string.homepage_global_string_223);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isLogout(int code) {
        return code == -101 || code == -2 || code == -904 || code == -901;
    }

    public String getPvEventId() {
        return AuthLoginRepoter.Show.PVID_AUTHORIZE_LOGIN;
    }

    public Bundle getPvExtra() {
        Bundle bundle = new Bundle();
        bundle.putString("appname", String.valueOf(this.authedAppName));
        return bundle;
    }

    /* compiled from: SSOCodeActivity.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/activities/login/SSOCodeActivity$Companion;", "", "<init>", "()V", "ACTION_AUTHORIZE", "", "EXTRA_TARGET_SUBID", "EXTRA_TARGET_APPKEY", "LOGIN_ROUTE", "REQ_CODE_LOGIN", "", "EXTRA_CODE", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}