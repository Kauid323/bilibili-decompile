package tv.danmaku.bili.auth.v2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.app.auth.R;
import com.bilibili.droid.BundleUtil;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.view.BiliImageView;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.api.bean.OverrideSummary;
import tv.danmaku.bili.auth.BiliAuthActivity;
import tv.danmaku.bili.auth.BiliAuthConstants;
import tv.danmaku.bili.auth.BiliAuthFragment;
import tv.danmaku.bili.cb.AuthResultCbHelper;
import tv.danmaku.bili.router.ChannelRoutes;
import tv.danmaku.bili.widget.dialog.BiliCommonDialog;
import tv.danmaku.bili.widget.dialog.CustomButtonInfo;

/* compiled from: BiliOverrideStep2Fragment.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u001f\u001a\u0004\u0018\u00010\u00132\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u001a\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J \u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020\u0019H\u0002J\b\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020'H\u0016J\"\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u001b2\b\u0010,\u001a\u0004\u0018\u000103H\u0016J\u0012\u00104\u001a\u00020'2\b\u00105\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u00106\u001a\u00020'H\u0002J\b\u00107\u001a\u00020'H\u0002J\b\u00108\u001a\u00020'H\u0002J\b\u00109\u001a\u00020'H\u0002J&\u0010:\u001a\b\u0012\u0004\u0012\u00020.0;2\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010<\u001a\u00020\u0015H\u0082@¢\u0006\u0004\b=\u0010>R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Ltv/danmaku/bili/auth/v2/BiliOverrideStep2Fragment;", "Ltv/danmaku/bili/auth/v2/BaseAuthFragmentV2;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "mAvatar1", "Lcom/bilibili/lib/image2/view/BiliImageView;", "mUserName1", "Landroid/widget/TextView;", "mFans1", "mFollowing1", "mAvatar2", "mUserName2", "mFans2", "mFollowing2", "mName", "mCard", "mDetails", "mGoTo", "Landroid/view/View;", "mNameStr", "", "mCardStr", "requestId", "summary", "Ltv/danmaku/bili/api/bean/OverrideSummary;", "intervals", "", "mOverrideMid", "mConfirmDialog", "Ltv/danmaku/bili/widget/dialog/BiliCommonDialog;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "refreshUI", ChannelRoutes.CHANNEL_NAME, "card", "data", "shouldHandleAgreement", "", "refreshUi", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onClick", "v", "gotoSuccessPage", "gotoSuccessPageAfter14", "executeOverride", "showConfirmDialog", "requestData", "Lkotlin/Result;", "overrideMid", "requestData-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliOverrideStep2Fragment extends BaseAuthFragmentV2 implements View.OnClickListener {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "BiliOverrideStep2Fragment";
    private int intervals;
    private BiliImageView mAvatar1;
    private BiliImageView mAvatar2;
    private TextView mCard;
    private String mCardStr;
    private BiliCommonDialog mConfirmDialog;
    private TextView mDetails;
    private TextView mFans1;
    private TextView mFans2;
    private TextView mFollowing1;
    private TextView mFollowing2;
    private View mGoTo;
    private TextView mName;
    private String mNameStr;
    private String mOverrideMid;
    private TextView mUserName1;
    private TextView mUserName2;
    private String requestId;
    private OverrideSummary summary;

    /* compiled from: BiliOverrideStep2Fragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/auth/v2/BiliOverrideStep2Fragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Ltv/danmaku/bili/auth/v2/BiliOverrideStep2Fragment;", "params", "Landroid/os/Bundle;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BiliOverrideStep2Fragment newInstance(Bundle params) {
            BiliOverrideStep2Fragment fragment = new BiliOverrideStep2Fragment();
            if (params != null) {
                fragment.setArguments(params);
            }
            return fragment;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view = inflater.inflate(R.layout.fragment_override_2, container, false);
        Intrinsics.checkNotNullExpressionValue(view, "inflate(...)");
        View userInfo1 = view.findViewById(R.id.item_user_info_1);
        this.mAvatar1 = userInfo1.findViewById(R.id.ic_avatar_real);
        this.mUserName1 = (TextView) userInfo1.findViewById(R.id.tv_user_name);
        this.mFans1 = (TextView) userInfo1.findViewById(R.id.tv_fans);
        this.mFollowing1 = (TextView) userInfo1.findViewById(R.id.tv_following);
        View userInfo2 = view.findViewById(R.id.item_user_info_2);
        this.mAvatar2 = userInfo2.findViewById(R.id.ic_avatar_real);
        this.mUserName2 = (TextView) userInfo2.findViewById(R.id.tv_user_name);
        this.mFans2 = (TextView) userInfo2.findViewById(R.id.tv_fans);
        this.mFollowing2 = (TextView) userInfo2.findViewById(R.id.tv_following);
        this.mName = (TextView) view.findViewById(R.id.name);
        this.mCard = (TextView) view.findViewById(R.id.card);
        this.mDetails = (TextView) view.findViewById(R.id.tips_details);
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
            String string = extra.getString("key_real_name");
            if (string == null) {
                string = "";
            }
            this.mNameStr = string;
            String string2 = extra.getString("key_card");
            if (string2 == null) {
                string2 = "";
            }
            this.mCardStr = string2;
            String string3 = extra.getString(BiliAuthActivity.BUNDLE_KEY_REQUEST_ID);
            if (string3 == null) {
                string3 = "";
            }
            this.requestId = string3;
            String string4 = extra.getString(BiliAuthActivity.BUNDLE_KEY_OVERRIDE_MID);
            if (string4 == null) {
                string4 = "";
            }
            this.mOverrideMid = string4;
            OverrideSummary data = (OverrideSummary) extra.getParcelable(BiliAuthActivity.BUNDLE_KEY_OVERRIDE_SUMMARY);
            if (data != null) {
                this.summary = data;
                String str = this.mNameStr;
                if (str == null) {
                    str = "";
                }
                String str2 = this.mCardStr;
                refreshUI(str, str2 != null ? str2 : "", data);
            }
        }
    }

    private final void refreshUI(String name, String card, OverrideSummary data) {
        TextView textView = this.mName;
        if (textView != null) {
            textView.setText(name);
        }
        TextView textView2 = this.mCard;
        if (textView2 != null) {
            textView2.setText(card);
        }
        OverrideSummary.User it = data.overrideUser;
        if (it != null) {
            BiliImageView avatar = this.mAvatar1;
            if (avatar != null) {
                BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
                Context context = avatar.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                biliImageLoader.with(context).url(it.face).into(avatar);
            }
            TextView textView3 = this.mUserName1;
            if (textView3 != null) {
                textView3.setText(it.name);
            }
            TextView textView4 = this.mFans1;
            if (textView4 != null) {
                textView4.setText(getString(R.string.auth_override_followers, new Object[]{String.valueOf(it.follower)}));
            }
            TextView textView5 = this.mFollowing1;
            if (textView5 != null) {
                textView5.setText(getString(R.string.auth_override_following, new Object[]{String.valueOf(it.following)}));
            }
        }
        OverrideSummary.User it2 = data.currentUser;
        if (it2 != null) {
            BiliImageView avatar2 = this.mAvatar2;
            if (avatar2 != null) {
                BiliImageLoader biliImageLoader2 = BiliImageLoader.INSTANCE;
                Context context2 = avatar2.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
                biliImageLoader2.with(context2).url(it2.face).into(avatar2);
            }
            TextView textView6 = this.mUserName2;
            if (textView6 != null) {
                textView6.setText(it2.name);
            }
            TextView textView7 = this.mFans2;
            if (textView7 != null) {
                textView7.setText(getString(R.string.auth_override_followers, new Object[]{String.valueOf(it2.follower)}));
            }
            TextView textView8 = this.mFollowing2;
            if (textView8 != null) {
                textView8.setText(getString(R.string.auth_override_following, new Object[]{String.valueOf(it2.following)}));
            }
        }
        OverrideSummary.Config config = data.config;
        this.intervals = config != null ? config.intervalDays : BR.matchBtnText;
        TextView textView9 = this.mDetails;
        if (textView9 != null) {
            textView9.setText(getString(R.string.auth_override_tips_details, new Object[]{name, name, name, String.valueOf(this.intervals)}));
        }
    }

    @Override // tv.danmaku.bili.auth.v2.BaseAuthFragmentV2
    public boolean shouldHandleAgreement() {
        return false;
    }

    @Override // tv.danmaku.bili.auth.v2.BaseAuthFragmentV2
    public void refreshUi() {
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 302) {
            Activity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
            if (resultCode == -1) {
                AuthResultCbHelper.setResultToActivityWithRequestId(requireActivity, 3, this.requestId);
                requireActivity.finish();
                return;
            }
            boolean not14 = Intrinsics.areEqual((data == null || (r2 = data.getStringExtra(BiliAuthFragment.KEY_FAIL)) == null) ? "" : "", BiliAuthFragment.FAIL_NOT_14);
            if (!not14) {
                AuthResultCbHelper.setResultToActivity(requireActivity, -1);
                requireActivity.finish();
                return;
            }
            HandlerThreads.runOn(0, new Runnable() { // from class: tv.danmaku.bili.auth.v2.BiliOverrideStep2Fragment$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    BiliOverrideStep2Fragment.onActivityResult$lambda$0(BiliOverrideStep2Fragment.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onActivityResult$lambda$0(BiliOverrideStep2Fragment this$0) {
        BLog.i(TAG, "real name override::toSuccessPage");
        this$0.gotoSuccessPageAfter14();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer valueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.btn_auth_enter;
        if (valueOf != null && valueOf.intValue() == i) {
            showConfirmDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void gotoSuccessPage() {
        Intent intent;
        setAuthStatus(1, this.requestId);
        FragmentActivity activity = getActivity();
        if (BundleUtil.getBoolean((activity == null || (intent = activity.getIntent()) == null) ? null : intent.getExtras(), BiliAuthConstants.BUNDLE_KEY_AFTER_14, new boolean[]{false})) {
            BLRouter.routeTo(new RouteRequest.Builder("bilibili://main/teenagersmode/guardian-bind").requestCode(302).build(), (Fragment) this);
        } else {
            showFragment(1, getArguments(), (Fragment) this);
        }
    }

    private final void gotoSuccessPageAfter14() {
        setAuthStatus(1, this.requestId);
        showFragment(1, getArguments(), (Fragment) this);
    }

    private final void executeOverride() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope((LifecycleOwner) this), (CoroutineContext) null, (CoroutineStart) null, new BiliOverrideStep2Fragment$executeOverride$1(this, null), 3, (Object) null);
    }

    private final void showConfirmDialog() {
        FragmentActivity activity;
        Context context;
        OverrideSummary.User user;
        String str;
        OverrideSummary.User user2;
        BiliCommonDialog biliCommonDialog = this.mConfirmDialog;
        if ((biliCommonDialog != null && biliCommonDialog.isVisible()) || (activity = getActivity()) == null || activity.isFinishing() || activity.isDestroyed() || (context = getContext()) == null) {
            return;
        }
        String realName = this.mNameStr;
        String overrideUser = "";
        if (realName == null) {
            realName = "";
        }
        OverrideSummary overrideSummary = this.summary;
        String currentUser = (overrideSummary == null || (user2 = overrideSummary.currentUser) == null || (currentUser = user2.name) == null) ? "" : "";
        OverrideSummary overrideSummary2 = this.summary;
        if (overrideSummary2 != null && (user = overrideSummary2.overrideUser) != null && (str = user.name) != null) {
            overrideUser = str;
        }
        BiliCommonDialog.Builder builder = new BiliCommonDialog.Builder(context);
        String string = getString(R.string.auth_override_tips_confirm);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        BiliCommonDialog.Builder title = builder.setTitle(string);
        String string2 = getString(R.string.auth_override_tips_confirm_details_1, new Object[]{realName, overrideUser, currentUser});
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        BiliCommonDialog.Builder contentText = title.setContentText(string2);
        String string3 = getString(R.string.auth_override_tips_confirm_details_2, new Object[]{String.valueOf(this.intervals)});
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        BiliCommonDialog.Builder canceledOnTouchOutside = contentText.setContentTip(string3).setCanceledOnTouchOutside(false);
        String string4 = getString(bili.resource.common.R.string.common_global_string_194);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        BiliCommonDialog.Builder positiveButton$default = BiliCommonDialog.Builder.setPositiveButton$default(canceledOnTouchOutside, string4, new BiliCommonDialog.OnDialogTextClickListener() { // from class: tv.danmaku.bili.auth.v2.BiliOverrideStep2Fragment$$ExternalSyntheticLambda1
            public final void onDialogTextClicked(View view, BiliCommonDialog biliCommonDialog2) {
                BiliOverrideStep2Fragment.showConfirmDialog$lambda$0(BiliOverrideStep2Fragment.this, view, biliCommonDialog2);
            }
        }, false, (CustomButtonInfo) null, 12, (Object) null);
        String string5 = getString(bili.resource.account.R.string.account_global_string_57);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        this.mConfirmDialog = BiliCommonDialog.Builder.setNegativeButton$default(positiveButton$default, string5, (BiliCommonDialog.OnDialogTextClickListener) null, true, (CustomButtonInfo) null, 10, (Object) null).setButtonStyle(1).build();
        BiliCommonDialog biliCommonDialog2 = this.mConfirmDialog;
        if (biliCommonDialog2 != null) {
            biliCommonDialog2.setCancelable(false);
        }
        BiliCommonDialog biliCommonDialog3 = this.mConfirmDialog;
        if (biliCommonDialog3 != null) {
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
            biliCommonDialog3.show(supportFragmentManager, TAG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showConfirmDialog$lambda$0(BiliOverrideStep2Fragment this$0, View view, BiliCommonDialog dialog) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        dialog.dismissAllowingStateLoss();
        this$0.executeOverride();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0031  */
    /* renamed from: requestData-0E7RQCE  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m732requestData0E7RQCE(String requestId, String overrideMid, Continuation<? super Result<Boolean>> continuation) {
        BiliOverrideStep2Fragment$requestData$1 biliOverrideStep2Fragment$requestData$1;
        Object withContext;
        if (continuation instanceof BiliOverrideStep2Fragment$requestData$1) {
            biliOverrideStep2Fragment$requestData$1 = (BiliOverrideStep2Fragment$requestData$1) continuation;
            if ((biliOverrideStep2Fragment$requestData$1.label & Integer.MIN_VALUE) != 0) {
                biliOverrideStep2Fragment$requestData$1.label -= Integer.MIN_VALUE;
                Object $result = biliOverrideStep2Fragment$requestData$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (biliOverrideStep2Fragment$requestData$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        biliOverrideStep2Fragment$requestData$1.label = 1;
                        withContext = BuildersKt.withContext(Dispatchers.getDefault(), new BiliOverrideStep2Fragment$requestData$2(requestId, overrideMid, null), biliOverrideStep2Fragment$requestData$1);
                        if (withContext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        withContext = $result;
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return ((Result) withContext).unbox-impl();
            }
        }
        biliOverrideStep2Fragment$requestData$1 = new BiliOverrideStep2Fragment$requestData$1(this, continuation);
        Object $result2 = biliOverrideStep2Fragment$requestData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (biliOverrideStep2Fragment$requestData$1.label) {
        }
        return ((Result) withContext).unbox-impl();
    }
}