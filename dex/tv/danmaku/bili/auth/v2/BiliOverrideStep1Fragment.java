package tv.danmaku.bili.auth.v2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.app.auth.R;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.view.BiliImageView;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.api.bean.OverrideSummary;
import tv.danmaku.bili.auth.BiliAuthActivity;
import tv.danmaku.bili.router.ChannelRoutes;

/* compiled from: BiliOverrideStep1Fragment.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J \u0010\u001c\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u0011H\u0002J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001aH\u0016J\u0012\u0010%\u001a\u00020\u001a2\b\u0010&\u001a\u0004\u0018\u00010\rH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Ltv/danmaku/bili/auth/v2/BiliOverrideStep1Fragment;", "Ltv/danmaku/bili/auth/v2/BaseAuthFragmentV2;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "mRealTips", "Landroid/widget/TextView;", "mAvatar", "Lcom/bilibili/lib/image2/view/BiliImageView;", "mUserName", "mFans", "mFollowing", "mGoTo", "Landroid/view/View;", "requestId", "", "summary", "Ltv/danmaku/bili/api/bean/OverrideSummary;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "requestData", "overrideMid", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshUI", ChannelRoutes.CHANNEL_NAME, "data", "shouldHandleAgreement", "", "refreshUi", "onClick", "v", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliOverrideStep1Fragment extends BaseAuthFragmentV2 implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "BiliOverrideStep1Fragment";
    private BiliImageView mAvatar;
    private TextView mFans;
    private TextView mFollowing;
    private View mGoTo;
    private TextView mRealTips;
    private TextView mUserName;
    private String requestId;
    private OverrideSummary summary;

    /* compiled from: BiliOverrideStep1Fragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/auth/v2/BiliOverrideStep1Fragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Ltv/danmaku/bili/auth/v2/BiliOverrideStep1Fragment;", "params", "Landroid/os/Bundle;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BiliOverrideStep1Fragment newInstance(Bundle params) {
            BiliOverrideStep1Fragment fragment = new BiliOverrideStep1Fragment();
            if (params != null) {
                fragment.setArguments(params);
            }
            return fragment;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view = inflater.inflate(R.layout.fragment_override_1, container, false);
        Intrinsics.checkNotNullExpressionValue(view, "inflate(...)");
        this.mRealTips = (TextView) view.findViewById(R.id.real_tips);
        this.mAvatar = view.findViewById(R.id.ic_avatar_real);
        this.mUserName = (TextView) view.findViewById(R.id.tv_user_name);
        this.mFans = (TextView) view.findViewById(R.id.tv_fans);
        this.mFollowing = (TextView) view.findViewById(R.id.tv_following);
        this.mGoTo = view.findViewById(R.id.btn_auth_enter);
        View view2 = this.mGoTo;
        if (view2 != null) {
            view2.setOnClickListener(this);
        }
        return view;
    }

    @Override // tv.danmaku.bili.auth.v2.BaseAuthFragmentV2
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Bundle extra = getArguments();
        if (extra != null) {
            String name = extra.getString("key_real_name");
            if (name == null) {
                name = "";
            }
            String string = extra.getString(BiliAuthActivity.BUNDLE_KEY_REQUEST_ID);
            if (string == null) {
                string = "";
            }
            this.requestId = string;
            String string2 = extra.getString(BiliAuthActivity.BUNDLE_KEY_OVERRIDE_MID);
            String overrideMid = string2 != null ? string2 : "";
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new BiliOverrideStep1Fragment$onViewCreated$1(this, overrideMid, name, null), 3, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object requestData(String requestId, String overrideMid, Continuation<? super OverrideSummary> continuation) {
        return BuildersKt.withContext(Dispatchers.getDefault(), new BiliOverrideStep1Fragment$requestData$2(requestId, overrideMid, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshUI(String name, OverrideSummary data) {
        TextView textView = this.mRealTips;
        if (textView != null) {
            textView.setText(getString(R.string.auth_override_info, new Object[]{name}));
        }
        BiliImageView it = this.mAvatar;
        if (it != null) {
            BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
            Context context = it.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            biliImageLoader.with(context).url(data.overrideUser.face).into(it);
        }
        TextView textView2 = this.mUserName;
        if (textView2 != null) {
            textView2.setText(data.overrideUser.name);
        }
        TextView textView3 = this.mFans;
        if (textView3 != null) {
            textView3.setText(getString(R.string.auth_override_followers, new Object[]{String.valueOf(data.overrideUser.follower)}));
        }
        TextView textView4 = this.mFollowing;
        if (textView4 != null) {
            textView4.setText(getString(R.string.auth_override_following, new Object[]{String.valueOf(data.overrideUser.following)}));
        }
    }

    @Override // tv.danmaku.bili.auth.v2.BaseAuthFragmentV2
    public boolean shouldHandleAgreement() {
        return false;
    }

    @Override // tv.danmaku.bili.auth.v2.BaseAuthFragmentV2
    public void refreshUi() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer valueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.btn_auth_enter;
        if (valueOf != null && valueOf.intValue() == i) {
            setAuthStatus(5, this.requestId);
            if (isAdded()) {
                Bundle $this$onClick_u24lambda_u240 = getArguments();
                if ($this$onClick_u24lambda_u240 != null) {
                    $this$onClick_u24lambda_u240.putParcelable(BiliAuthActivity.BUNDLE_KEY_OVERRIDE_SUMMARY, this.summary);
                }
                showFragment(5, getArguments(), (Fragment) this);
            }
        }
    }
}