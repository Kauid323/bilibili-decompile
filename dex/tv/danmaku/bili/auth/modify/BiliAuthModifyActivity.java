package tv.danmaku.bili.auth.modify;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bilibili.lib.basecomponent.R;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.app.AppConfig;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.auth.BiliAuthConstants;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.cb.AuthResultCbMsg;

/* compiled from: BiliAuthModifyActivity.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 (2\u00020\u0001:\u0002()B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\"\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J$\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ*\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010\"\u001a\u00020\u000eH\u0016J\u0006\u0010#\u001a\u00020\u000eJ\u000e\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Ltv/danmaku/bili/auth/modify/BiliAuthModifyActivity;", "Lcom/bilibili/lib/ui/BaseToolbarActivity;", "<init>", "()V", "mSourceEvent", "", "mAuthModifyFragment", "Ltv/danmaku/bili/auth/modify/BiliAuthModifyFragment;", "mAuthModifySuccessFragment", "Ltv/danmaku/bili/auth/modify/BiliAuthModifySuccessFragment;", "mAuthModifyErrorFragment", "Ltv/danmaku/bili/auth/modify/BiliAuthModifyErrorFragment;", "loadingMessage", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "toFragment", "status", "bundle", "pre", "Landroidx/fragment/app/Fragment;", "showFragment", "isAdd", "", "fragment", "Ltv/danmaku/bili/auth/modify/BaseAuthModifyFragment;", AppConfig.HOST_TAG, "onBackPressed", "exit", "finishWithCallBack", "authResultCbMsg", "Ltv/danmaku/bili/cb/AuthResultCbMsg;", "getSourceEvent", "Companion", "ModifyJumpGuide", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthModifyActivity extends BaseToolbarActivity {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "BiliAuthModifyActivity";
    private String loadingMessage;
    private BiliAuthModifyErrorFragment mAuthModifyErrorFragment;
    private BiliAuthModifyFragment mAuthModifyFragment;
    private BiliAuthModifySuccessFragment mAuthModifySuccessFragment;
    private String mSourceEvent = "";

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* compiled from: BiliAuthModifyActivity.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/auth/modify/BiliAuthModifyActivity$Companion;", "", "<init>", "()V", "TAG", "", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bili_app_activity_with_toolbar);
        ensureToolbar();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(bili.resource.account.R.string.account_global_string_263);
        }
        showBackButton();
        Bundle bundleExtra = getIntent().getBundleExtra("modify_bundle_key");
        this.mSourceEvent = (bundleExtra == null || (r0 = bundleExtra.getString(BiliAuthConstants.BUNDLE_KEY_SOURCE_EVENT)) == null) ? "" : "";
        toFragment$default(this, ModifyJumpGuide.Companion.getMODIFY(), getIntent().getBundleExtra("modify_bundle_key"), null, 4, null);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        BLog.i(TAG, "onActivityResult requestCode = " + requestCode);
    }

    public static /* synthetic */ void toFragment$default(BiliAuthModifyActivity biliAuthModifyActivity, int i, Bundle bundle, Fragment fragment, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            fragment = null;
        }
        biliAuthModifyActivity.toFragment(i, bundle, fragment);
    }

    public final void toFragment(int status, Bundle bundle, Fragment pre) {
        boolean z = true;
        if (status == ModifyJumpGuide.Companion.getMODIFY()) {
            BiliAuthModifyFragment findFragmentByTag = getSupportFragmentManager().findFragmentByTag(BiliAuthModifyFragment.TAG);
            this.mAuthModifyFragment = findFragmentByTag instanceof BiliAuthModifyFragment ? findFragmentByTag : null;
            if (this.mAuthModifyFragment == null) {
                this.mAuthModifyFragment = BiliAuthModifyFragment.Companion.newInstance(bundle);
            } else {
                z = false;
            }
            boolean isAdd = z;
            BiliAuthModifyFragment biliAuthModifyFragment = this.mAuthModifyFragment;
            Intrinsics.checkNotNull(biliAuthModifyFragment);
            showFragment(isAdd, biliAuthModifyFragment, BiliAuthModifyFragment.TAG, pre);
        } else if (status == ModifyJumpGuide.Companion.getMODIFY_SUCCESS()) {
            BiliAuthModifySuccessFragment findFragmentByTag2 = getSupportFragmentManager().findFragmentByTag("BiliAuthModifySuccessFragment");
            this.mAuthModifySuccessFragment = findFragmentByTag2 instanceof BiliAuthModifySuccessFragment ? findFragmentByTag2 : null;
            if (this.mAuthModifySuccessFragment == null) {
                this.mAuthModifySuccessFragment = BiliAuthModifySuccessFragment.Companion.newInstance(bundle);
            } else {
                z = false;
            }
            boolean isAdd2 = z;
            BiliAuthModifySuccessFragment biliAuthModifySuccessFragment = this.mAuthModifySuccessFragment;
            Intrinsics.checkNotNull(biliAuthModifySuccessFragment);
            showFragment(isAdd2, biliAuthModifySuccessFragment, "BiliAuthModifySuccessFragment", pre);
        } else if (status == ModifyJumpGuide.Companion.getMODIFY_ERROR()) {
            Fragment findFragmentByTag3 = getSupportFragmentManager().findFragmentByTag("BiliAuthModifySuccessFragment");
            this.mAuthModifyErrorFragment = findFragmentByTag3 instanceof BiliAuthModifyErrorFragment ? (BiliAuthModifyErrorFragment) findFragmentByTag3 : null;
            if (this.mAuthModifyErrorFragment == null) {
                this.mAuthModifyErrorFragment = BiliAuthModifyErrorFragment.Companion.newInstance(bundle);
            } else {
                z = false;
            }
            boolean isAdd3 = z;
            BiliAuthModifyErrorFragment biliAuthModifyErrorFragment = this.mAuthModifyErrorFragment;
            Intrinsics.checkNotNull(biliAuthModifyErrorFragment);
            showFragment(isAdd3, biliAuthModifyErrorFragment, "BiliAuthModifySuccessFragment", pre);
        }
    }

    private final void showFragment(boolean isAdd, BaseAuthModifyFragment fragment, String tag, Fragment pre) {
        if (isAdd) {
            getSupportFragmentManager().beginTransaction().add(com.bilibili.base.R.id.content_layout, (Fragment) fragment, tag).commitAllowingStateLoss();
            return;
        }
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        Intrinsics.checkNotNullExpressionValue(transaction, "beginTransaction(...)");
        if (pre != null) {
            transaction.hide(pre);
        }
        transaction.show((Fragment) fragment).commitAllowingStateLoss();
        transaction.addToBackStack(tag);
        fragment.refreshUi();
    }

    public void onBackPressed() {
        super.onBackPressed();
        FragmentManager fragmentManager = getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(fragmentManager, "getSupportFragmentManager(...)");
        int fragmentCount = fragmentManager.getBackStackEntryCount();
        if (fragmentCount > 1) {
            fragmentManager.popBackStack();
            return;
        }
        AuthResultCbHelper.setResultToActivity((Activity) this, -1);
        exit();
    }

    public final void exit() {
        super.onBackPressed();
    }

    public final void finishWithCallBack(AuthResultCbMsg authResultCbMsg) {
        Intrinsics.checkNotNullParameter(authResultCbMsg, "authResultCbMsg");
        Intent intent = new Intent();
        intent.putExtra(AuthResultCbHelper.ARGS_CBM, authResultCbMsg);
        setResult(-1, intent);
        finish();
    }

    public final String getSourceEvent() {
        return this.mSourceEvent;
    }

    /* compiled from: BiliAuthModifyActivity.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ltv/danmaku/bili/auth/modify/BiliAuthModifyActivity$ModifyJumpGuide;", "", "<init>", "()V", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class ModifyJumpGuide {
        private static final int MODIFY = 0;
        public static final Companion Companion = new Companion(null);
        private static final int MODIFY_SUCCESS = 1;
        private static final int MODIFY_ERROR = 2;

        /* compiled from: BiliAuthModifyActivity.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Ltv/danmaku/bili/auth/modify/BiliAuthModifyActivity$ModifyJumpGuide$Companion;", "", "<init>", "()V", "MODIFY", "", "getMODIFY", "()I", "MODIFY_SUCCESS", "getMODIFY_SUCCESS", "MODIFY_ERROR", "getMODIFY_ERROR", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
        /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final int getMODIFY() {
                return ModifyJumpGuide.MODIFY;
            }

            public final int getMODIFY_SUCCESS() {
                return ModifyJumpGuide.MODIFY_SUCCESS;
            }

            public final int getMODIFY_ERROR() {
                return ModifyJumpGuide.MODIFY_ERROR;
            }
        }
    }
}