package tv.danmaku.bili.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bili.resource.account.R;
import com.alibaba.fastjson.JSONObject;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import com.bilibili.okretro.BiliApiDataCallback;
import com.bilibili.pvtracker.IPvTracker;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.auth.ScopeInfoResponse;
import tv.danmaku.bili.auth.api.AuthLoginApiServiceHelper;
import tv.danmaku.bili.auth.api.AuthLoginResponse;
import tv.danmaku.bili.auth.report.AuthLoginReportHelper;
import tv.danmaku.bili.ui.login.LoginReporterV2;

/* compiled from: AuthLoginActivity.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0012\u0010\u0014\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0011H\u0002J\u001a\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u001e\u001a\u00020\u0011H\u0002J\u001c\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0018\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\"\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010*\u001a\u00020\u0011H\u0002J\b\u0010+\u001a\u00020\u0013H\u0016J\b\u0010,\u001a\u00020\u0006H\u0016J\u000e\u0010-\u001a\u00020\u0006*\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010.\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u0006H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Ltv/danmaku/bili/auth/AuthLoginActivity;", "Lcom/bilibili/lib/ui/BaseToolbarActivity;", "Lcom/bilibili/pvtracker/IPvTracker;", "<init>", "()V", "mTargetPackageName", "", "mTargetSessionId", "mTargetSignature", "mTargetClientId", "mRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "mScrollBottomView", "Landroid/view/View;", "adapter", "Ltv/danmaku/bili/auth/AuthLoginAdapter;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "showMoveToBottom", "recyclerView", "checkIsValidParams", "", "intent", "Landroid/content/Intent;", "authLogin", "onAuthLoginResult", "success", LoginReporterV2.Show.SIGNUP_KEY_CODE, "loadScopeInfo", "showScopeInfo", "status", "", "data", "Ltv/danmaku/bili/auth/ScopeInfoResponse;", "convertToAuthLoginModel", "", "Ltv/danmaku/bili/auth/AuthLoginModel;", "onActivityResult", "requestCode", "resultCode", "notifyAccountInfo", "getPvExtra", "getPvEventId", "toNonNullString", "deepLinkTrack", "message", "Companion", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AuthLoginActivity extends BaseToolbarActivity implements IPvTracker {
    private static final String EXTRA_CLIENT_ID = "clientId";
    private static final String EXTRA_PACKAGE_NAME = "packageName";
    private static final String EXTRA_SESSION_ID = "sessionId";
    private static final String EXTRA_SIGNATURE = "signature";
    public static final int REQ_CODE_LOGIN = 100;
    public static final int STATUS_FAILED = 2;
    public static final int STATUS_LOADING = 3;
    public static final int STATUS_SUCCESS = 1;
    private static final String TAG = "AuthLoginActivity";
    private AuthLoginAdapter adapter;
    private RecyclerView mRecyclerView;
    private View mScrollBottomView;
    private String mTargetClientId;
    private String mTargetPackageName;
    private String mTargetSessionId;
    private String mTargetSignature;
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

    /* compiled from: AuthLoginActivity.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/auth/AuthLoginActivity$Companion;", "", "<init>", "()V", "TAG", "", "REQ_CODE_LOGIN", "", "STATUS_SUCCESS", "STATUS_FAILED", "STATUS_LOADING", "EXTRA_CLIENT_ID", "EXTRA_SESSION_ID", "EXTRA_PACKAGE_NAME", "EXTRA_SIGNATURE", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
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
        deepLinkTrack("AuthLoginActivity onCreate");
        if (!checkIsValidParams(getIntent())) {
            ToastHelper.showToastLong((Context) this, R.string.account_global_string_51);
            finish();
            return;
        }
        setContentView(com.bilibili.app.accountui.R.layout.bili_app_activity_auth_login);
        ensureToolbar();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(R.string.account_global_string_23);
        }
        showBackButton();
        this.mRecyclerView = findViewById(com.bilibili.app.accountui.R.id.recycler_view);
        this.mScrollBottomView = findViewById(com.bilibili.app.accountui.R.id.auth_login_scroll_bottom);
        AuthLoginAdapter $this$onCreate_u24lambda_u240 = new AuthLoginAdapter((Context) this);
        this.adapter = $this$onCreate_u24lambda_u240;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.setAdapter($this$onCreate_u24lambda_u240);
        }
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(new LinearLayoutManager((Context) this));
        }
        RecyclerView recyclerView3 = this.mRecyclerView;
        if (recyclerView3 != null) {
            recyclerView3.setHasFixedSize(true);
        }
        RecyclerView recyclerView4 = this.mRecyclerView;
        if (recyclerView4 != null) {
            recyclerView4.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: tv.danmaku.bili.auth.AuthLoginActivity$onCreate$2
                public void onScrolled(RecyclerView recyclerView5, int dx, int dy) {
                    RecyclerView recyclerView6;
                    Intrinsics.checkNotNullParameter(recyclerView5, "recyclerView");
                    super.onScrolled(recyclerView5, dx, dy);
                    AuthLoginActivity authLoginActivity = AuthLoginActivity.this;
                    recyclerView6 = AuthLoginActivity.this.mRecyclerView;
                    authLoginActivity.showMoveToBottom(recyclerView6);
                }
            });
        }
        View view = this.mScrollBottomView;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.auth.AuthLoginActivity$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AuthLoginActivity.onCreate$lambda$1(AuthLoginActivity.this, view2);
                }
            });
        }
        AuthLoginAdapter authLoginAdapter = this.adapter;
        if (authLoginAdapter != null) {
            authLoginAdapter.setAuthLoginClickCallback(new Function0() { // from class: tv.danmaku.bili.auth.AuthLoginActivity$$ExternalSyntheticLambda1
                public final Object invoke() {
                    Unit onCreate$lambda$2;
                    onCreate$lambda$2 = AuthLoginActivity.onCreate$lambda$2(AuthLoginActivity.this);
                    return onCreate$lambda$2;
                }
            });
        }
        AuthLoginAdapter authLoginAdapter2 = this.adapter;
        if (authLoginAdapter2 != null) {
            authLoginAdapter2.setLoadErrorCallback(new Function0() { // from class: tv.danmaku.bili.auth.AuthLoginActivity$$ExternalSyntheticLambda2
                public final Object invoke() {
                    Unit onCreate$lambda$3;
                    onCreate$lambda$3 = AuthLoginActivity.onCreate$lambda$3(AuthLoginActivity.this);
                    return onCreate$lambda$3;
                }
            });
        }
        AuthLoginAdapter authLoginAdapter3 = this.adapter;
        if (authLoginAdapter3 != null) {
            authLoginAdapter3.addHeader();
        }
        loadScopeInfo();
        if (!BiliAccounts.get((Context) this).isLogin()) {
            RouteRequest request = new RouteRequest.Builder("activity://main/login/").extras(new Function1() { // from class: tv.danmaku.bili.auth.AuthLoginActivity$$ExternalSyntheticLambda3
                public final Object invoke(Object obj) {
                    Unit onCreate$lambda$4;
                    onCreate$lambda$4 = AuthLoginActivity.onCreate$lambda$4((MutableBundleLike) obj);
                    return onCreate$lambda$4;
                }
            }).requestCode(100).build();
            BLRouter.routeTo(request, (Context) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(AuthLoginActivity this$0, View it) {
        RecyclerView recyclerView;
        AuthLoginAdapter $this$onCreate_u24lambda_u241_u240 = this$0.adapter;
        if ($this$onCreate_u24lambda_u241_u240 == null || (recyclerView = this$0.mRecyclerView) == null) {
            return;
        }
        recyclerView.smoothScrollToPosition($this$onCreate_u24lambda_u241_u240.getItemCount() - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$2(AuthLoginActivity this$0) {
        this$0.authLogin();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$3(AuthLoginActivity this$0) {
        this$0.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onCreate$lambda$4(MutableBundleLike $this$extras) {
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        $this$extras.put("from_spmid", "main.authorize.0.0.pv");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showMoveToBottom(RecyclerView recyclerView) {
        if (recyclerView != null) {
            LinearLayoutManager layoutManager = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            int lastPosition = layoutManager.findLastCompletelyVisibleItemPosition();
            RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager2);
            if (lastPosition == layoutManager2.getItemCount() - 1) {
                View view = this.mScrollBottomView;
                if (view != null) {
                    view.setVisibility(8);
                    return;
                }
                return;
            }
            View view2 = this.mScrollBottomView;
            if (view2 != null) {
                view2.setVisibility(0);
            }
        }
    }

    private final boolean checkIsValidParams(Intent intent) {
        this.mTargetPackageName = intent != null ? intent.getStringExtra(EXTRA_PACKAGE_NAME) : null;
        this.mTargetClientId = intent != null ? intent.getStringExtra(EXTRA_CLIENT_ID) : null;
        this.mTargetSessionId = intent != null ? intent.getStringExtra(EXTRA_SESSION_ID) : null;
        this.mTargetSignature = intent != null ? intent.getStringExtra(EXTRA_SIGNATURE) : null;
        AuthLoginReportHelper.INSTANCE.reportAuthGrowth(this.mTargetClientId, this.mTargetSessionId, this.mTargetPackageName);
        deepLinkTrack("reportAuthGrowth success");
        if (this.mTargetPackageName == null || this.mTargetClientId == null || this.mTargetSessionId == null || this.mTargetSignature == null) {
            return false;
        }
        return true;
    }

    private final void authLogin() {
        Iterable mData;
        Integer isChecked;
        if (!BiliAccounts.get((Context) this).isLogin()) {
            ToastHelper.showToastShort((Context) this, R.string.account_global_string_170);
            return;
        }
        StringBuilder scopesBuilder = new StringBuilder();
        Map jSONObject = new JSONObject();
        int permissionIndex = 0;
        AuthLoginAdapter authLoginAdapter = this.adapter;
        if (authLoginAdapter != null && (mData = authLoginAdapter.getMData()) != null) {
            Iterable $this$forEach$iv = mData;
            for (Object element$iv : $this$forEach$iv) {
                AuthLoginModel it = (AuthLoginModel) element$iv;
                if (it instanceof AuthPermissionModel) {
                    Integer isChecked2 = ((AuthPermissionModel) it).isChecked();
                    if ((isChecked2 != null && isChecked2.intValue() == -1) || ((isChecked = ((AuthPermissionModel) it).isChecked()) != null && isChecked.intValue() == 1)) {
                        scopesBuilder.append(((AuthPermissionModel) it).getScope()).append(",");
                    }
                    permissionIndex++;
                    Map map = jSONObject;
                    String scope = ((AuthPermissionModel) it).getScope();
                    if (scope == null) {
                        scope = "权限" + permissionIndex;
                    }
                    map.put(scope, Integer.valueOf(((AuthPermissionModel) it).isPermissionChecked() ? 1 : 0));
                }
            }
        }
        String scopes = scopesBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(scopes, "toString(...)");
        if ((scopes.length() > 0 ? 1 : null) != null) {
            String substring = scopes.substring(0, scopes.length() - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            scopes = substring;
        }
        AuthLoginReportHelper.INSTANCE.reportAuthLoginClick(this.mTargetClientId, this.mTargetSessionId, this.mTargetPackageName, jSONObject.toJSONString());
        AuthLoginApiServiceHelper.INSTANCE.authLogin(toNonNullString(this.mTargetClientId), scopes, toNonNullString(this.mTargetPackageName), toNonNullString(this.mTargetSignature), toNonNullString(this.mTargetSessionId), new BiliApiDataCallback<AuthLoginResponse>() { // from class: tv.danmaku.bili.auth.AuthLoginActivity$authLogin$2
            public void onDataSuccess(AuthLoginResponse data) {
                AuthLoginActivity.this.onAuthLoginResult(true, data != null ? data.getCode() : null);
            }

            public void onError(Throwable t) {
                AuthLoginActivity.this.onAuthLoginResult(false, t != null ? t.getMessage() : null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onAuthLoginResult(boolean success, String code) {
        if (success) {
            ToastHelper.showToastShort((Context) this, R.string.account_global_string_55);
            Intent intent = new Intent();
            intent.putExtra(LoginReporterV2.Show.SIGNUP_KEY_CODE, code);
            setResult(-1, intent);
            finish();
            return;
        }
        ToastHelper.showToastShort((Context) this, code);
    }

    private final void loadScopeInfo() {
        showScopeInfo$default(this, 3, null, 2, null);
        if (this.mTargetClientId != null) {
            String $this$loadScopeInfo_u24lambda_u240 = this.mTargetClientId;
            if ($this$loadScopeInfo_u24lambda_u240 != null) {
                AuthLoginApiServiceHelper.INSTANCE.getScopeInfo($this$loadScopeInfo_u24lambda_u240, toNonNullString(this.mTargetSessionId), new BiliApiDataCallback<ScopeInfoResponse>() { // from class: tv.danmaku.bili.auth.AuthLoginActivity$loadScopeInfo$1$1
                    public void onDataSuccess(ScopeInfoResponse data) {
                        AuthLoginActivity.this.showScopeInfo(1, data);
                    }

                    public void onError(Throwable t) {
                        AuthLoginActivity.showScopeInfo$default(AuthLoginActivity.this, 2, null, 2, null);
                    }
                });
                return;
            }
            return;
        }
        showScopeInfo$default(this, 2, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void showScopeInfo$default(AuthLoginActivity authLoginActivity, int i, ScopeInfoResponse scopeInfoResponse, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            scopeInfoResponse = null;
        }
        authLoginActivity.showScopeInfo(i, scopeInfoResponse);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001b, code lost:
        if (r9.agreement != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void showScopeInfo(int status, ScopeInfoResponse data) {
        ScopeInfoResponse.AppInfo $this$showScopeInfo_u24lambda_u240;
        AuthLoginAdapter authLoginAdapter;
        int localStatus = status;
        if (localStatus == 1) {
            if (data != null) {
                List<ScopeInfoResponse.Scope> list = data.scopes;
                if (!(list == null || list.isEmpty())) {
                }
            }
            localStatus = 2;
            BLog.d(TAG, "scopes = " + (data != null ? data.scopes : null) + " ,and agreement = " + (data != null ? data.agreement : null));
        }
        switch (localStatus) {
            case 1:
                AuthLoginAdapter authLoginAdapter2 = this.adapter;
                if (authLoginAdapter2 != null) {
                    authLoginAdapter2.updateHeader(data != null ? data.appInfo : null);
                }
                AuthLoginAdapter authLoginAdapter3 = this.adapter;
                if (authLoginAdapter3 != null) {
                    authLoginAdapter3.updateInfo(1, convertToAuthLoginModel(data));
                    return;
                }
                return;
            case 2:
                if (data != null && ($this$showScopeInfo_u24lambda_u240 = data.appInfo) != null && (authLoginAdapter = this.adapter) != null) {
                    authLoginAdapter.updateHeader($this$showScopeInfo_u24lambda_u240);
                }
                AuthLoginAdapter authLoginAdapter4 = this.adapter;
                if (authLoginAdapter4 != null) {
                    AuthLoginAdapter.updateInfo$default(authLoginAdapter4, 2, null, 2, null);
                    return;
                }
                return;
            case 3:
                AuthLoginAdapter authLoginAdapter5 = this.adapter;
                if (authLoginAdapter5 != null) {
                    AuthLoginAdapter.updateInfo$default(authLoginAdapter5, 3, null, 2, null);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private final List<AuthLoginModel> convertToAuthLoginModel(ScopeInfoResponse data) {
        ScopeInfoResponse.Agreement it;
        Iterable iterable;
        ArrayList modelList = new ArrayList();
        if (data != null && (iterable = data.scopes) != null) {
            Iterable $this$forEach$iv = iterable;
            for (Object element$iv : $this$forEach$iv) {
                ScopeInfoResponse.Scope it2 = (ScopeInfoResponse.Scope) element$iv;
                AuthPermissionModel $this$convertToAuthLoginModel_u24lambda_u240_u240 = new AuthPermissionModel();
                $this$convertToAuthLoginModel_u24lambda_u240_u240.setChecked(Integer.valueOf(it2.isSelected));
                $this$convertToAuthLoginModel_u24lambda_u240_u240.setTitle(it2.title);
                $this$convertToAuthLoginModel_u24lambda_u240_u240.setContent(it2.desc);
                $this$convertToAuthLoginModel_u24lambda_u240_u240.setScope(it2.scope);
                modelList.add($this$convertToAuthLoginModel_u24lambda_u240_u240);
            }
        }
        if (data != null && (it = data.agreement) != null) {
            AuthButtonModel $this$convertToAuthLoginModel_u24lambda_u241_u240 = new AuthButtonModel();
            $this$convertToAuthLoginModel_u24lambda_u241_u240.setAgreement(it);
            modelList.add($this$convertToAuthLoginModel_u24lambda_u241_u240);
        }
        return modelList;
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == -1) {
                notifyAccountInfo();
            } else {
                finish();
            }
        }
    }

    private final void notifyAccountInfo() {
        AuthLoginAdapter authLoginAdapter = this.adapter;
        if (authLoginAdapter != null) {
            authLoginAdapter.updateAccountInfo();
        }
    }

    public Bundle getPvExtra() {
        return new Bundle();
    }

    public String getPvEventId() {
        return AuthLoginReportHelper.PV_EVENT_ID_AUTHORIZE;
    }

    private final String toNonNullString(String $this$toNonNullString) {
        return $this$toNonNullString == null ? "" : $this$toNonNullString;
    }

    private final void deepLinkTrack(String message) {
        BLog.i(AuthLoginActivityKt.DEEPLINK_TRACKER_TAG, message);
    }
}