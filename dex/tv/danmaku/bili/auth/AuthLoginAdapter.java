package tv.danmaku.bili.auth;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.app.accountui.R;
import com.bilibili.droid.ToastHelper;
import com.bilibili.lib.accountinfo.BiliAccountInfo;
import com.bilibili.lib.accountinfo.model.AccountInfo;
import com.bilibili.lib.accounts.BiliAccounts;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.ScaleType;
import com.bilibili.lib.image2.view.BiliImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.auth.AuthLoginAdapter;
import tv.danmaku.bili.auth.ScopeInfoResponse;
import tv.danmaku.bili.auth.report.AuthLoginReportHelper;

/* compiled from: AuthLoginAdapter.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006345678B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020!H\u0016J \u0010#\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020!2\u0010\b\u0002\u0010%\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010&J\u0006\u0010'\u001a\u00020\u000fJ\u0018\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020!H\u0016J&\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020!2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020,0&H\u0016J\u0010\u0010-\u001a\u00020!2\u0006\u0010*\u001a\u00020!H\u0016J\u0010\u0010.\u001a\u00020\t2\u0006\u0010*\u001a\u00020!H\u0002J\u0006\u0010/\u001a\u00020\u000fJ\u0010\u00100\u001a\u00020\u000f2\b\u00101\u001a\u0004\u0018\u000102R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u00069"}, d2 = {"Ltv/danmaku/bili/auth/AuthLoginAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ltv/danmaku/bili/auth/AuthLoginAdapter$BaseAuthLoginVH;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mData", "Ljava/util/ArrayList;", "Ltv/danmaku/bili/auth/AuthLoginModel;", "Lkotlin/collections/ArrayList;", "getMData", "()Ljava/util/ArrayList;", "authLoginClickCallback", "Lkotlin/Function0;", "", "getAuthLoginClickCallback", "()Lkotlin/jvm/functions/Function0;", "setAuthLoginClickCallback", "(Lkotlin/jvm/functions/Function0;)V", "loadErrorCallback", "getLoadErrorCallback", "setLoadErrorCallback", "headerModel", "Ltv/danmaku/bili/auth/AuthHeaderModel;", "getHeaderModel", "()Ltv/danmaku/bili/auth/AuthHeaderModel;", "setHeaderModel", "(Ltv/danmaku/bili/auth/AuthHeaderModel;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "getItemCount", "updateInfo", "status", "list", "", "addHeader", "onBindViewHolder", "holder", "position", "payloads", "", "getItemViewType", "getItem", "updateAccountInfo", "updateHeader", "appInfo", "Ltv/danmaku/bili/auth/ScopeInfoResponse$AppInfo;", "Companion", "BaseAuthLoginVH", "AuthLoginPermissionVH", "AuthLoginButtonVH", "AuthLoginHeaderVH", "AuthLoginEmptyVH", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class AuthLoginAdapter extends RecyclerView.Adapter<BaseAuthLoginVH> {
    public static final int ITEM_VIEW_TYPE_BUTTON = 2;
    public static final int ITEM_VIEW_TYPE_EMPTY = 4;
    public static final int ITEM_VIEW_TYPE_HEADER = 3;
    public static final int ITEM_VIEW_TYPE_PERMISSION = 1;
    public static final String PAY_LOAD_ACCOUNT = "pay_load_account";
    private Function0<Unit> authLoginClickCallback;
    private final Context context;
    private AuthHeaderModel headerModel;
    private Function0<Unit> loadErrorCallback;
    private final ArrayList<AuthLoginModel> mData;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: AuthLoginAdapter.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/auth/AuthLoginAdapter$Companion;", "", "<init>", "()V", "ITEM_VIEW_TYPE_PERMISSION", "", "ITEM_VIEW_TYPE_BUTTON", "ITEM_VIEW_TYPE_HEADER", "ITEM_VIEW_TYPE_EMPTY", "PAY_LOAD_ACCOUNT", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public AuthLoginAdapter(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mData = new ArrayList<>();
    }

    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder p0, int p1, List p2) {
        onBindViewHolder((BaseAuthLoginVH) p0, p1, (List<Object>) p2);
    }

    public final ArrayList<AuthLoginModel> getMData() {
        return this.mData;
    }

    public final Function0<Unit> getAuthLoginClickCallback() {
        return this.authLoginClickCallback;
    }

    public final void setAuthLoginClickCallback(Function0<Unit> function0) {
        this.authLoginClickCallback = function0;
    }

    public final Function0<Unit> getLoadErrorCallback() {
        return this.loadErrorCallback;
    }

    public final void setLoadErrorCallback(Function0<Unit> function0) {
        this.loadErrorCallback = function0;
    }

    public final AuthHeaderModel getHeaderModel() {
        return this.headerModel;
    }

    public final void setHeaderModel(AuthHeaderModel authHeaderModel) {
        this.headerModel = authHeaderModel;
    }

    public BaseAuthLoginVH onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 2:
                View it = LayoutInflater.from(this.context).inflate(R.layout.bili_app_layout_auth_item_button, parent, false);
                Intrinsics.checkNotNull(it);
                return new AuthLoginButtonVH(it, this.authLoginClickCallback);
            case 3:
                View it2 = LayoutInflater.from(this.context).inflate(R.layout.bili_app_layout_auth_item_header, parent, false);
                Intrinsics.checkNotNull(it2);
                return new AuthLoginHeaderVH(it2);
            case 4:
                View it3 = LayoutInflater.from(this.context).inflate(R.layout.bili_app_layout_auth_item_empty, parent, false);
                Intrinsics.checkNotNull(it3);
                return new AuthLoginEmptyVH(it3, this.loadErrorCallback);
            default:
                View it4 = LayoutInflater.from(this.context).inflate(R.layout.bili_app_layout_auth_item_permission, parent, false);
                Intrinsics.checkNotNull(it4);
                return new AuthLoginPermissionVH(it4);
        }
    }

    public int getItemCount() {
        return this.mData.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void updateInfo$default(AuthLoginAdapter authLoginAdapter, int i, List list, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            list = null;
        }
        authLoginAdapter.updateInfo(i, list);
    }

    public final void updateInfo(int status, List<AuthLoginModel> list) {
        this.mData.clear();
        ArrayList<AuthLoginModel> arrayList = this.mData;
        AuthHeaderModel authHeaderModel = this.headerModel;
        Intrinsics.checkNotNull(authHeaderModel);
        arrayList.add(authHeaderModel);
        this.mData.add(new AuthEmptyModel(Integer.valueOf(status)));
        if (list != null) {
            this.mData.addAll(list);
        }
        notifyDataSetChanged();
    }

    public final void addHeader() {
        this.mData.clear();
        this.headerModel = new AuthHeaderModel();
        ArrayList<AuthLoginModel> arrayList = this.mData;
        AuthHeaderModel authHeaderModel = this.headerModel;
        Intrinsics.checkNotNull(authHeaderModel);
        arrayList.add(authHeaderModel);
    }

    public void onBindViewHolder(BaseAuthLoginVH holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        AuthLoginModel $this$onBindViewHolder_u24lambda_u240 = getItem(position);
        holder.onBindViewHolder($this$onBindViewHolder_u24lambda_u240, position);
    }

    public void onBindViewHolder(BaseAuthLoginVH holder, int position, List<Object> list) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        super.onBindViewHolder(holder, position, list);
        AuthLoginModel $this$onBindViewHolder_u24lambda_u241 = getItem(position);
        holder.onBindViewHolder($this$onBindViewHolder_u24lambda_u241, position, list);
    }

    public int getItemViewType(int position) {
        if (position == 0) {
            return 3;
        }
        AuthLoginModel item = getItem(position);
        if (item instanceof AuthButtonModel) {
            return 2;
        }
        return item instanceof AuthEmptyModel ? 4 : 1;
    }

    private final AuthLoginModel getItem(int position) {
        AuthLoginModel authLoginModel = this.mData.get(position);
        Intrinsics.checkNotNullExpressionValue(authLoginModel, "get(...)");
        return authLoginModel;
    }

    public final void updateAccountInfo() {
        notifyItemChanged(0, PAY_LOAD_ACCOUNT);
    }

    public final void updateHeader(ScopeInfoResponse.AppInfo appInfo) {
        AuthHeaderModel authHeaderModel = this.headerModel;
        if (authHeaderModel != null) {
            authHeaderModel.setAppInfo(appInfo);
        }
    }

    /* compiled from: AuthLoginAdapter.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0000\b'\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J&\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/auth/AuthLoginAdapter$BaseAuthLoginVH;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "onBindViewHolder", "", "model", "Ltv/danmaku/bili/auth/AuthLoginModel;", "position", "", "payloads", "", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static abstract class BaseAuthLoginVH extends RecyclerView.ViewHolder {
        public static final int $stable = 8;

        public abstract void onBindViewHolder(AuthLoginModel authLoginModel, int i);

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BaseAuthLoginVH(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }

        public void onBindViewHolder(AuthLoginModel model, int position, List<Object> list) {
            Intrinsics.checkNotNullParameter(model, "model");
            Intrinsics.checkNotNullParameter(list, "payloads");
        }
    }

    /* compiled from: AuthLoginAdapter.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR#\u0010\r\u001a\n \b*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0012\u001a\n \b*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u001b"}, d2 = {"Ltv/danmaku/bili/auth/AuthLoginAdapter$AuthLoginPermissionVH;", "Ltv/danmaku/bili/auth/AuthLoginAdapter$BaseAuthLoginVH;", "item", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "kotlin.jvm.PlatformType", "getCheckBox", "()Landroid/widget/CheckBox;", "checkBox$delegate", "Lkotlin/Lazy;", "permissionTitle", "Landroid/widget/TextView;", "getPermissionTitle", "()Landroid/widget/TextView;", "permissionTitle$delegate", "permissionContent", "getPermissionContent", "permissionContent$delegate", "onBindViewHolder", "", "model", "Ltv/danmaku/bili/auth/AuthLoginModel;", "position", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AuthLoginPermissionVH extends BaseAuthLoginVH {
        public static final int $stable = 8;
        private final Lazy checkBox$delegate;
        private final Lazy permissionContent$delegate;
        private final Lazy permissionTitle$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuthLoginPermissionVH(View item) {
            super(item);
            Intrinsics.checkNotNullParameter(item, "item");
            this.checkBox$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.auth.AuthLoginAdapter$AuthLoginPermissionVH$$ExternalSyntheticLambda1
                public final Object invoke() {
                    CheckBox checkBox_delegate$lambda$0;
                    checkBox_delegate$lambda$0 = AuthLoginAdapter.AuthLoginPermissionVH.checkBox_delegate$lambda$0(AuthLoginAdapter.AuthLoginPermissionVH.this);
                    return checkBox_delegate$lambda$0;
                }
            });
            this.permissionTitle$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.auth.AuthLoginAdapter$AuthLoginPermissionVH$$ExternalSyntheticLambda2
                public final Object invoke() {
                    TextView permissionTitle_delegate$lambda$0;
                    permissionTitle_delegate$lambda$0 = AuthLoginAdapter.AuthLoginPermissionVH.permissionTitle_delegate$lambda$0(AuthLoginAdapter.AuthLoginPermissionVH.this);
                    return permissionTitle_delegate$lambda$0;
                }
            });
            this.permissionContent$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.auth.AuthLoginAdapter$AuthLoginPermissionVH$$ExternalSyntheticLambda3
                public final Object invoke() {
                    TextView permissionContent_delegate$lambda$0;
                    permissionContent_delegate$lambda$0 = AuthLoginAdapter.AuthLoginPermissionVH.permissionContent_delegate$lambda$0(AuthLoginAdapter.AuthLoginPermissionVH.this);
                    return permissionContent_delegate$lambda$0;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CheckBox checkBox_delegate$lambda$0(AuthLoginPermissionVH this$0) {
            return (CheckBox) this$0.itemView.findViewById(R.id.check_box);
        }

        private final CheckBox getCheckBox() {
            return (CheckBox) this.checkBox$delegate.getValue();
        }

        private final TextView getPermissionTitle() {
            return (TextView) this.permissionTitle$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final TextView permissionTitle_delegate$lambda$0(AuthLoginPermissionVH this$0) {
            return (TextView) this$0.itemView.findViewById(R.id.permission_title);
        }

        private final TextView getPermissionContent() {
            return (TextView) this.permissionContent$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final TextView permissionContent_delegate$lambda$0(AuthLoginPermissionVH this$0) {
            return (TextView) this$0.itemView.findViewById(R.id.permission_content);
        }

        @Override // tv.danmaku.bili.auth.AuthLoginAdapter.BaseAuthLoginVH
        public void onBindViewHolder(AuthLoginModel model, int position) {
            boolean z;
            Intrinsics.checkNotNullParameter(model, "model");
            final AuthPermissionModel permissionModel = (AuthPermissionModel) model;
            CheckBox checkBox = getCheckBox();
            Integer isChecked = permissionModel.isChecked();
            boolean z2 = false;
            if ((isChecked != null && isChecked.intValue() == -1) || (isChecked != null && isChecked.intValue() == 1)) {
                z = true;
            } else {
                z = false;
            }
            checkBox.setChecked(z);
            CheckBox checkBox2 = getCheckBox();
            Integer isChecked2 = permissionModel.isChecked();
            if (isChecked2 == null || isChecked2.intValue() != -1) {
                z2 = true;
            }
            checkBox2.setEnabled(z2);
            getCheckBox().setAlpha(getCheckBox().isEnabled() ? 1.0f : 0.4f);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.auth.AuthLoginAdapter$AuthLoginPermissionVH$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AuthLoginAdapter.AuthLoginPermissionVH.onBindViewHolder$lambda$0(AuthLoginAdapter.AuthLoginPermissionVH.this, permissionModel, view);
                }
            });
            getPermissionTitle().setText(permissionModel.getTitle());
            getPermissionContent().setText(permissionModel.getContent());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBindViewHolder$lambda$0(AuthLoginPermissionVH this$0, AuthPermissionModel $permissionModel, View it) {
            if (this$0.getCheckBox().isEnabled()) {
                this$0.getCheckBox().setChecked(!this$0.getCheckBox().isChecked());
                $permissionModel.setChecked(this$0.getCheckBox().isChecked() ? 1 : 0);
            }
        }
    }

    /* compiled from: AuthLoginAdapter.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR#\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0011\u0010\rR#\u0010\u0013\u001a\n \u000b*\u0004\u0018\u00010\u00140\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0015\u0010\u0016¨\u0006!"}, d2 = {"Ltv/danmaku/bili/auth/AuthLoginAdapter$AuthLoginButtonVH;", "Ltv/danmaku/bili/auth/AuthLoginAdapter$BaseAuthLoginVH;", "itemView", "Landroid/view/View;", "authLoginClickCallback", "Lkotlin/Function0;", "", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "authBtn", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getAuthBtn", "()Landroid/widget/TextView;", "authBtn$delegate", "Lkotlin/Lazy;", "agreementTv", "getAgreementTv", "agreementTv$delegate", "checkBox", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "checkBox$delegate", "onBindViewHolder", "model", "Ltv/danmaku/bili/auth/AuthLoginModel;", "position", "", "generateLinkCharSequence", "Landroid/text/SpannableString;", "agreement", "Ltv/danmaku/bili/auth/ScopeInfoResponse$Agreement;", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AuthLoginButtonVH extends BaseAuthLoginVH {
        public static final int $stable = 8;
        private final Lazy agreementTv$delegate;
        private final Lazy authBtn$delegate;
        private final Function0<Unit> authLoginClickCallback;
        private final Lazy checkBox$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuthLoginButtonVH(final View itemView, Function0<Unit> function0) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.authLoginClickCallback = function0;
            this.authBtn$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.auth.AuthLoginAdapter$AuthLoginButtonVH$$ExternalSyntheticLambda0
                public final Object invoke() {
                    TextView authBtn_delegate$lambda$0;
                    authBtn_delegate$lambda$0 = AuthLoginAdapter.AuthLoginButtonVH.authBtn_delegate$lambda$0(itemView);
                    return authBtn_delegate$lambda$0;
                }
            });
            this.agreementTv$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.auth.AuthLoginAdapter$AuthLoginButtonVH$$ExternalSyntheticLambda1
                public final Object invoke() {
                    TextView agreementTv_delegate$lambda$0;
                    agreementTv_delegate$lambda$0 = AuthLoginAdapter.AuthLoginButtonVH.agreementTv_delegate$lambda$0(itemView);
                    return agreementTv_delegate$lambda$0;
                }
            });
            this.checkBox$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.auth.AuthLoginAdapter$AuthLoginButtonVH$$ExternalSyntheticLambda2
                public final Object invoke() {
                    CheckBox checkBox_delegate$lambda$0;
                    checkBox_delegate$lambda$0 = AuthLoginAdapter.AuthLoginButtonVH.checkBox_delegate$lambda$0(itemView);
                    return checkBox_delegate$lambda$0;
                }
            });
        }

        public /* synthetic */ AuthLoginButtonVH(View view, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(view, (i & 2) != 0 ? null : function0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final TextView authBtn_delegate$lambda$0(View $itemView) {
            return (TextView) $itemView.findViewById(R.id.auth_login_btn);
        }

        private final TextView getAuthBtn() {
            return (TextView) this.authBtn$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final TextView agreementTv_delegate$lambda$0(View $itemView) {
            return (TextView) $itemView.findViewById(R.id.auth_login_agreement);
        }

        private final TextView getAgreementTv() {
            return (TextView) this.agreementTv$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final CheckBox checkBox_delegate$lambda$0(View $itemView) {
            return (CheckBox) $itemView.findViewById(R.id.check_box);
        }

        private final CheckBox getCheckBox() {
            return (CheckBox) this.checkBox$delegate.getValue();
        }

        @Override // tv.danmaku.bili.auth.AuthLoginAdapter.BaseAuthLoginVH
        public void onBindViewHolder(final AuthLoginModel model, int position) {
            Intrinsics.checkNotNullParameter(model, "model");
            if (model instanceof AuthButtonModel) {
                getAuthBtn().setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.auth.AuthLoginAdapter$AuthLoginButtonVH$$ExternalSyntheticLambda3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        AuthLoginAdapter.AuthLoginButtonVH.onBindViewHolder$lambda$0(AuthLoginModel.this, this, view);
                    }
                });
                getAgreementTv().setText(((AuthButtonModel) model).getAgreement() != null ? generateLinkCharSequence(((AuthButtonModel) model).getAgreement()) : null);
                getAgreementTv().setMovementMethod(LinkMovementMethod.getInstance());
                ScopeInfoResponse.Agreement agreement = ((AuthButtonModel) model).getAgreement();
                boolean z = true;
                if (agreement != null && agreement.isSelect == 1) {
                    ScopeInfoResponse.Agreement agreement2 = ((AuthButtonModel) model).getAgreement();
                    String str = agreement2 != null ? agreement2.str : null;
                    if (str != null && !StringsKt.isBlank(str)) {
                        z = false;
                    }
                    if (!z) {
                        getCheckBox().setVisibility(0);
                        return;
                    }
                }
                getCheckBox().setVisibility(8);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onBindViewHolder$lambda$0(AuthLoginModel $model, AuthLoginButtonVH this$0, View it) {
            ScopeInfoResponse.Agreement agreement = ((AuthButtonModel) $model).getAgreement();
            boolean z = true;
            if ((agreement != null && agreement.isSelect == 1) && !this$0.getCheckBox().isChecked()) {
                ScopeInfoResponse.Agreement agreement2 = ((AuthButtonModel) $model).getAgreement();
                String str = null;
                String str2 = agreement2 != null ? agreement2.toastNotify : null;
                if (str2 != null && !StringsKt.isBlank(str2)) {
                    z = false;
                }
                if (!z) {
                    ScopeInfoResponse.Agreement agreement3 = ((AuthButtonModel) $model).getAgreement();
                    if (agreement3 != null) {
                        str = agreement3.toastNotify;
                    }
                } else {
                    str = this$0.getAuthBtn().getContext().getString(bili.resource.account.R.string.account_global_string_79);
                }
                String toastText = str;
                ToastHelper.showToastShort(this$0.getAuthBtn().getContext(), toastText);
                return;
            }
            Function0<Unit> function0 = this$0.authLoginClickCallback;
            if (function0 != null) {
                function0.invoke();
            }
        }

        private final SpannableString generateLinkCharSequence(ScopeInfoResponse.Agreement agreement) {
            if ((agreement != null ? agreement.str : null) == null) {
                return null;
            }
            SpannableString ss = new SpannableString(agreement.str);
            List $this$generateLinkCharSequence_u24lambda_u240 = agreement.list;
            if ($this$generateLinkCharSequence_u24lambda_u240 != null) {
                for (final ScopeInfoResponse.Agreement.Match match : $this$generateLinkCharSequence_u24lambda_u240) {
                    if (match.name != null && match.url != null) {
                        String str = match.name;
                        Intrinsics.checkNotNull(str);
                        Pattern pattern = Pattern.compile(str);
                        Matcher matcher = pattern.matcher(ss);
                        while (matcher.find()) {
                            int start = matcher.start();
                            int end = matcher.end();
                            ss.setSpan(new ClickableSpan() { // from class: tv.danmaku.bili.auth.AuthLoginAdapter$AuthLoginButtonVH$generateLinkCharSequence$1$1
                                @Override // android.text.style.ClickableSpan
                                public void onClick(View widget) {
                                    Intrinsics.checkNotNullParameter(widget, "widget");
                                    String str2 = ScopeInfoResponse.Agreement.Match.this.url;
                                    Intrinsics.checkNotNull(str2);
                                    RouteRequest $this$onClick_u24lambda_u240 = RouteRequestKt.toRouteRequest(str2);
                                    ScopeInfoResponse.Agreement.Match match2 = ScopeInfoResponse.Agreement.Match.this;
                                    AuthLoginAdapter.AuthLoginButtonVH authLoginButtonVH = this;
                                    AuthLoginReportHelper.INSTANCE.reportAuthAgreementClick(match2.name);
                                    BLRouter.routeTo($this$onClick_u24lambda_u240, authLoginButtonVH.itemView.getContext());
                                }

                                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                                public void updateDrawState(TextPaint ds) {
                                    Intrinsics.checkNotNullParameter(ds, "ds");
                                    ds.setUnderlineText(false);
                                    ds.setColor(ContextCompat.getColor(this.itemView.getContext(), com.bilibili.lib.theme.R.color.Lb6));
                                }
                            }, start, end, 33);
                        }
                    }
                }
            }
            return ss;
        }
    }

    /* compiled from: AuthLoginAdapter.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J&\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J\u0012\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\b\u0010'\u001a\u00020\u001cH\u0002R#\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR#\u0010\r\u001a\n \b*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0012\u001a\n \b*\u0004\u0018\u00010\u00070\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0013\u0010\nR#\u0010\u0015\u001a\n \b*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0016\u0010\u0010R#\u0010\u0018\u001a\n \b*\u0004\u0018\u00010\u000e0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u0019\u0010\u0010¨\u0006("}, d2 = {"Ltv/danmaku/bili/auth/AuthLoginAdapter$AuthLoginHeaderVH;", "Ltv/danmaku/bili/auth/AuthLoginAdapter$BaseAuthLoginVH;", "item", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "mThirdAppIcon", "Lcom/bilibili/lib/image2/view/BiliImageView;", "kotlin.jvm.PlatformType", "getMThirdAppIcon", "()Lcom/bilibili/lib/image2/view/BiliImageView;", "mThirdAppIcon$delegate", "Lkotlin/Lazy;", "mThirdAppName", "Landroid/widget/TextView;", "getMThirdAppName", "()Landroid/widget/TextView;", "mThirdAppName$delegate", "mAvatar", "getMAvatar", "mAvatar$delegate", "mAccountName", "getMAccountName", "mAccountName$delegate", "mAccountUid", "getMAccountUid", "mAccountUid$delegate", "onBindViewHolder", "", "model", "Ltv/danmaku/bili/auth/AuthLoginModel;", "position", "", "payloads", "", "", "showThirdAppInfo", "appInfo", "Ltv/danmaku/bili/auth/ScopeInfoResponse$AppInfo;", "loadAccountInfo", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AuthLoginHeaderVH extends BaseAuthLoginVH {
        public static final int $stable = 8;
        private final Lazy mAccountName$delegate;
        private final Lazy mAccountUid$delegate;
        private final Lazy mAvatar$delegate;
        private final Lazy mThirdAppIcon$delegate;
        private final Lazy mThirdAppName$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuthLoginHeaderVH(final View item) {
            super(item);
            Intrinsics.checkNotNullParameter(item, "item");
            this.mThirdAppIcon$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.auth.AuthLoginAdapter$AuthLoginHeaderVH$$ExternalSyntheticLambda0
                public final Object invoke() {
                    BiliImageView mThirdAppIcon_delegate$lambda$0;
                    mThirdAppIcon_delegate$lambda$0 = AuthLoginAdapter.AuthLoginHeaderVH.mThirdAppIcon_delegate$lambda$0(item);
                    return mThirdAppIcon_delegate$lambda$0;
                }
            });
            this.mThirdAppName$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.auth.AuthLoginAdapter$AuthLoginHeaderVH$$ExternalSyntheticLambda1
                public final Object invoke() {
                    TextView mThirdAppName_delegate$lambda$0;
                    mThirdAppName_delegate$lambda$0 = AuthLoginAdapter.AuthLoginHeaderVH.mThirdAppName_delegate$lambda$0(item);
                    return mThirdAppName_delegate$lambda$0;
                }
            });
            this.mAvatar$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.auth.AuthLoginAdapter$AuthLoginHeaderVH$$ExternalSyntheticLambda2
                public final Object invoke() {
                    BiliImageView mAvatar_delegate$lambda$0;
                    mAvatar_delegate$lambda$0 = AuthLoginAdapter.AuthLoginHeaderVH.mAvatar_delegate$lambda$0(item);
                    return mAvatar_delegate$lambda$0;
                }
            });
            this.mAccountName$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.auth.AuthLoginAdapter$AuthLoginHeaderVH$$ExternalSyntheticLambda3
                public final Object invoke() {
                    TextView mAccountName_delegate$lambda$0;
                    mAccountName_delegate$lambda$0 = AuthLoginAdapter.AuthLoginHeaderVH.mAccountName_delegate$lambda$0(item);
                    return mAccountName_delegate$lambda$0;
                }
            });
            this.mAccountUid$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.auth.AuthLoginAdapter$AuthLoginHeaderVH$$ExternalSyntheticLambda4
                public final Object invoke() {
                    TextView mAccountUid_delegate$lambda$0;
                    mAccountUid_delegate$lambda$0 = AuthLoginAdapter.AuthLoginHeaderVH.mAccountUid_delegate$lambda$0(item);
                    return mAccountUid_delegate$lambda$0;
                }
            });
        }

        private final BiliImageView getMThirdAppIcon() {
            return (BiliImageView) this.mThirdAppIcon$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BiliImageView mThirdAppIcon_delegate$lambda$0(View $item) {
            return $item.findViewById(R.id.image_third_app);
        }

        private final TextView getMThirdAppName() {
            return (TextView) this.mThirdAppName$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final TextView mThirdAppName_delegate$lambda$0(View $item) {
            return (TextView) $item.findViewById(R.id.text2);
        }

        private final BiliImageView getMAvatar() {
            return (BiliImageView) this.mAvatar$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final BiliImageView mAvatar_delegate$lambda$0(View $item) {
            return $item.findViewById(R.id.avatar);
        }

        private final TextView getMAccountName() {
            return (TextView) this.mAccountName$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final TextView mAccountName_delegate$lambda$0(View $item) {
            return (TextView) $item.findViewById(R.id.account_name);
        }

        private final TextView getMAccountUid() {
            return (TextView) this.mAccountUid$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final TextView mAccountUid_delegate$lambda$0(View $item) {
            return (TextView) $item.findViewById(R.id.account_uid);
        }

        @Override // tv.danmaku.bili.auth.AuthLoginAdapter.BaseAuthLoginVH
        public void onBindViewHolder(AuthLoginModel model, int position) {
            Intrinsics.checkNotNullParameter(model, "model");
            AuthHeaderModel headerModel = (AuthHeaderModel) model;
            showThirdAppInfo(headerModel.getAppInfo());
            if (BiliAccounts.get(this.itemView.getContext()).isLogin()) {
                loadAccountInfo();
            }
        }

        @Override // tv.danmaku.bili.auth.AuthLoginAdapter.BaseAuthLoginVH
        public void onBindViewHolder(AuthLoginModel model, int position, List<Object> list) {
            Intrinsics.checkNotNullParameter(model, "model");
            Intrinsics.checkNotNullParameter(list, "payloads");
            super.onBindViewHolder(model, position, list);
            if (list.contains(AuthLoginAdapter.PAY_LOAD_ACCOUNT)) {
                loadAccountInfo();
            }
        }

        private final void showThirdAppInfo(ScopeInfoResponse.AppInfo appInfo) {
            BiliImageView $this$showThirdAppInfo_u24lambda_u240 = getMThirdAppIcon();
            if ($this$showThirdAppInfo_u24lambda_u240 != null) {
                BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
                Context context = this.itemView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                ImageRequestBuilder.placeholderImageResId$default(biliImageLoader.with(context).url(appInfo != null ? appInfo.icon : null), R.drawable.ic_third_app_default, (ScaleType) null, 2, (Object) null).into($this$showThirdAppInfo_u24lambda_u240);
            }
            TextView mThirdAppName = getMThirdAppName();
            if (mThirdAppName != null) {
                mThirdAppName.setText(appInfo != null ? appInfo.name : null);
            }
        }

        private final void loadAccountInfo() {
            AccountInfo accountInfo = BiliAccountInfo.Companion.get().getAccountInfoFromCache();
            if (accountInfo != null) {
                BiliImageView $this$loadAccountInfo_u24lambda_u240 = getMAvatar();
                if ($this$loadAccountInfo_u24lambda_u240 != null) {
                    BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
                    Context context = $this$loadAccountInfo_u24lambda_u240.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                    biliImageLoader.with(context).url(accountInfo.getAvatar()).into($this$loadAccountInfo_u24lambda_u240);
                }
                TextView mAccountName = getMAccountName();
                if (mAccountName != null) {
                    mAccountName.setText(accountInfo.getUserName());
                }
                TextView mAccountUid = getMAccountUid();
                if (mAccountUid != null) {
                    mAccountUid.setText(this.itemView.getContext().getString(R.string.auth_login_uid, String.valueOf(accountInfo.getMid())));
                }
            }
        }
    }

    /* compiled from: AuthLoginAdapter.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00030\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR#\u0010\u000f\u001a\n \n*\u0004\u0018\u00010\u00030\u00038BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\fR#\u0010\u0012\u001a\n \n*\u0004\u0018\u00010\u00130\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Ltv/danmaku/bili/auth/AuthLoginAdapter$AuthLoginEmptyVH;", "Ltv/danmaku/bili/auth/AuthLoginAdapter$BaseAuthLoginVH;", "itemView", "Landroid/view/View;", "loadErrorCallback", "Lkotlin/Function0;", "", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "loadFailedContainer", "kotlin.jvm.PlatformType", "getLoadFailedContainer", "()Landroid/view/View;", "loadFailedContainer$delegate", "Lkotlin/Lazy;", "loadingContainer", "getLoadingContainer", "loadingContainer$delegate", "loadFailedBtn", "Landroid/widget/TextView;", "getLoadFailedBtn", "()Landroid/widget/TextView;", "loadFailedBtn$delegate", "loadingAnimator", "Landroid/animation/ObjectAnimator;", "getLoadingAnimator", "()Landroid/animation/ObjectAnimator;", "setLoadingAnimator", "(Landroid/animation/ObjectAnimator;)V", "onBindViewHolder", "model", "Ltv/danmaku/bili/auth/AuthLoginModel;", "position", "", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class AuthLoginEmptyVH extends BaseAuthLoginVH {
        public static final int $stable = 8;
        private final Function0<Unit> loadErrorCallback;
        private final Lazy loadFailedBtn$delegate;
        private final Lazy loadFailedContainer$delegate;
        private ObjectAnimator loadingAnimator;
        private final Lazy loadingContainer$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AuthLoginEmptyVH(final View itemView, Function0<Unit> function0) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.loadErrorCallback = function0;
            this.loadFailedContainer$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.auth.AuthLoginAdapter$AuthLoginEmptyVH$$ExternalSyntheticLambda0
                public final Object invoke() {
                    View loadFailedContainer_delegate$lambda$0;
                    loadFailedContainer_delegate$lambda$0 = AuthLoginAdapter.AuthLoginEmptyVH.loadFailedContainer_delegate$lambda$0(itemView);
                    return loadFailedContainer_delegate$lambda$0;
                }
            });
            this.loadingContainer$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.auth.AuthLoginAdapter$AuthLoginEmptyVH$$ExternalSyntheticLambda1
                public final Object invoke() {
                    View loadingContainer_delegate$lambda$0;
                    loadingContainer_delegate$lambda$0 = AuthLoginAdapter.AuthLoginEmptyVH.loadingContainer_delegate$lambda$0(itemView);
                    return loadingContainer_delegate$lambda$0;
                }
            });
            this.loadFailedBtn$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.auth.AuthLoginAdapter$AuthLoginEmptyVH$$ExternalSyntheticLambda2
                public final Object invoke() {
                    TextView loadFailedBtn_delegate$lambda$0;
                    loadFailedBtn_delegate$lambda$0 = AuthLoginAdapter.AuthLoginEmptyVH.loadFailedBtn_delegate$lambda$0(itemView);
                    return loadFailedBtn_delegate$lambda$0;
                }
            });
            getLoadFailedBtn().setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.auth.AuthLoginAdapter$AuthLoginEmptyVH$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AuthLoginAdapter.AuthLoginEmptyVH._init_$lambda$0(AuthLoginAdapter.AuthLoginEmptyVH.this, view);
                }
            });
        }

        public /* synthetic */ AuthLoginEmptyVH(View view, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(view, (i & 2) != 0 ? null : function0);
        }

        private final View getLoadFailedContainer() {
            return (View) this.loadFailedContainer$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final View loadFailedContainer_delegate$lambda$0(View $itemView) {
            return $itemView.findViewById(R.id.load_failed_container);
        }

        private final View getLoadingContainer() {
            return (View) this.loadingContainer$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final View loadingContainer_delegate$lambda$0(View $itemView) {
            return $itemView.findViewById(R.id.loading_container);
        }

        private final TextView getLoadFailedBtn() {
            return (TextView) this.loadFailedBtn$delegate.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final TextView loadFailedBtn_delegate$lambda$0(View $itemView) {
            return (TextView) $itemView.findViewById(R.id.load_failed_btn);
        }

        public final ObjectAnimator getLoadingAnimator() {
            return this.loadingAnimator;
        }

        public final void setLoadingAnimator(ObjectAnimator objectAnimator) {
            this.loadingAnimator = objectAnimator;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$0(AuthLoginEmptyVH this$0, View it) {
            Function0<Unit> function0 = this$0.loadErrorCallback;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // tv.danmaku.bili.auth.AuthLoginAdapter.BaseAuthLoginVH
        public void onBindViewHolder(AuthLoginModel model, int position) {
            Intrinsics.checkNotNullParameter(model, "model");
            if (model instanceof AuthEmptyModel) {
                if (((AuthEmptyModel) model).showLoading()) {
                    getLoadingContainer().setVisibility(0);
                    getLoadFailedContainer().setVisibility(8);
                    ObjectAnimator $this$onBindViewHolder_u24lambda_u240 = ObjectAnimator.ofFloat(getLoadingContainer(), "rotation", 0.0f, 360.0f);
                    $this$onBindViewHolder_u24lambda_u240.setDuration(350L);
                    $this$onBindViewHolder_u24lambda_u240.setRepeatMode(1);
                    $this$onBindViewHolder_u24lambda_u240.setRepeatCount(-1);
                    $this$onBindViewHolder_u24lambda_u240.start();
                    this.loadingAnimator = $this$onBindViewHolder_u24lambda_u240;
                } else if (((AuthEmptyModel) model).showSuccess()) {
                    getLoadingContainer().setVisibility(8);
                    getLoadFailedContainer().setVisibility(8);
                    ObjectAnimator objectAnimator = this.loadingAnimator;
                    if (objectAnimator != null) {
                        objectAnimator.end();
                    }
                    this.loadingAnimator = null;
                } else {
                    getLoadFailedContainer().setVisibility(0);
                    getLoadingContainer().setVisibility(8);
                    ObjectAnimator objectAnimator2 = this.loadingAnimator;
                    if (objectAnimator2 != null) {
                        objectAnimator2.end();
                    }
                    this.loadingAnimator = null;
                }
            }
        }
    }
}