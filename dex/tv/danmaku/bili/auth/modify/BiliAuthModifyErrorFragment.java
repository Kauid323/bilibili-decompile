package tv.danmaku.bili.auth.modify;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bilibili.app.auth.R;
import com.bilibili.droid.InputMethodManagerHelper;
import com.bilibili.lib.foundation.FoundationAlias;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.auth.AuthAgreementLinkHelper;
import tv.danmaku.bili.auth.LinkItemListener;
import tv.danmaku.bili.report.DefaultAuthReporter;

/* compiled from: BiliAuthModifyErrorFragment.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/auth/modify/BiliAuthModifyErrorFragment;", "Ltv/danmaku/bili/auth/modify/BaseAuthModifyFragment;", "<init>", "()V", "tv_tips", "Landroid/widget/TextView;", "mTitle", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "refreshUi", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthModifyErrorFragment extends BaseAuthModifyFragment {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "BiliAuthModifySuccessFragment";
    private TextView mTitle;
    private TextView tv_tips;

    /* compiled from: BiliAuthModifyErrorFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/auth/modify/BiliAuthModifyErrorFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Ltv/danmaku/bili/auth/modify/BiliAuthModifyErrorFragment;", "params", "Landroid/os/Bundle;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BiliAuthModifyErrorFragment newInstance(Bundle params) {
            BiliAuthModifyErrorFragment fragment = new BiliAuthModifyErrorFragment();
            if (params != null) {
                fragment.setArguments(params);
            }
            return fragment;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        final View view = inflater.inflate(R.layout.fragment_auth_modify_error, container, false);
        Intrinsics.checkNotNullExpressionValue(view, "inflate(...)");
        this.mTitle = (TextView) view.findViewById(R.id.error_title);
        this.tv_tips = (TextView) view.findViewById(R.id.auth_check_tips);
        TextView tv_agreement = (TextView) view.findViewById(R.id.tv_modify_agreement);
        String highLight = getString(bili.resource.account.R.string.account_global_string_312);
        Intrinsics.checkNotNullExpressionValue(highLight, "getString(...)");
        AuthAgreementLinkHelper authAgreementLinkHelper = AuthAgreementLinkHelper.INSTANCE;
        String string = getString(bili.resource.account.R.string.account_global_string_238);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        authAgreementLinkHelper.attachContentLink(tv_agreement, string, highLight, AuthAgreementLinkHelper.INSTANCE.getAuthAgreementLink(), FoundationAlias.getFapp().getResources().getColor(R.color.text_blue_kit), new LinkItemListener() { // from class: tv.danmaku.bili.auth.modify.BiliAuthModifyErrorFragment$onCreateView$1
            @Override // tv.danmaku.bili.auth.LinkItemListener
            public void onItemClick() {
                InputMethodManagerHelper.hideSoftInput(BiliAuthModifyErrorFragment.this.getActivity(), view, 0);
                DefaultAuthReporter.INSTANCE.reportManualCheckClick(BiliAuthModifyErrorFragment.this.sourceEvent());
            }
        }, (r23 & 64) != 0 ? "" : null, (r23 & BR.cover) != 0 ? "" : null, (r23 & BR.hallEnterHotText) != 0 ? MapsKt.emptyMap() : null);
        return view;
    }

    @Override // tv.danmaku.bili.auth.modify.BaseAuthModifyFragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        refreshUi();
    }

    @Override // tv.danmaku.bili.auth.modify.BaseAuthModifyFragment
    public void refreshUi() {
        Bundle arguments = getArguments();
        ArrayList<String> stringArrayList = arguments != null ? arguments.getStringArrayList(getBUNDLE_KEY_FAIL_TIPS$auth_debug()) : null;
        ArrayList<String> arrayList = stringArrayList;
        if (!(arrayList == null || arrayList.isEmpty())) {
            String string = getString(bili.resource.account.R.string.account_global_string_206);
            Intrinsics.checkNotNull(stringArrayList);
            String tips = string + CollectionsKt.joinToString$default(stringArrayList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
            TextView textView = this.tv_tips;
            if (textView != null) {
                textView.setText(tips);
            }
        }
    }
}