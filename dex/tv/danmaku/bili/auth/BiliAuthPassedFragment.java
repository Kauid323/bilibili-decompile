package tv.danmaku.bili.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.app.auth.R;
import com.bilibili.lib.foundation.FoundationAlias;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.DefaultAuthReporter;

/* compiled from: BiliAuthPassedFragment.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/auth/BiliAuthPassedFragment;", "Ltv/danmaku/bili/auth/BaseAuthFragment;", "<init>", "()V", "mName", "Landroid/widget/TextView;", "mCard", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "refreshUi", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BiliAuthPassedFragment extends BaseAuthFragment {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "BiliAuthPassedFragment";
    private TextView mCard;
    private TextView mName;

    /* compiled from: BiliAuthPassedFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/auth/BiliAuthPassedFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Ltv/danmaku/bili/auth/BiliAuthPassedFragment;", "params", "Landroid/os/Bundle;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BiliAuthPassedFragment newInstance(Bundle params) {
            BiliAuthPassedFragment fragment = new BiliAuthPassedFragment();
            if (params != null) {
                fragment.setArguments(params);
            }
            return fragment;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view = inflater.inflate(R.layout.fragment_auth_sucess, container, false);
        Intrinsics.checkNotNullExpressionValue(view, "inflate(...)");
        this.mName = (TextView) view.findViewById(R.id.tv_realname);
        this.mCard = (TextView) view.findViewById(R.id.tv_card);
        View close = view.findViewById(R.id.btn_auth_close);
        Intrinsics.checkNotNullExpressionValue(close, "findViewById(...)");
        close.requestFocus();
        close.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.auth.BiliAuthPassedFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BiliAuthPassedFragment.onCreateView$lambda$0(BiliAuthPassedFragment.this, view2);
            }
        });
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$0(BiliAuthPassedFragment this$0, View it) {
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    @Override // tv.danmaku.bili.auth.BaseAuthFragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        refreshUi();
        DefaultAuthReporter.reportAuthResultShow$default(DefaultAuthReporter.INSTANCE, sourceEvent(), 1, null, 4, null);
    }

    @Override // tv.danmaku.bili.auth.BaseAuthFragment
    public void refreshUi() {
        Bundle extra = getArguments();
        if (extra != null) {
            String name = extra.getString("key_real_name");
            if (name == null) {
                name = "";
            }
            String string = extra.getString("key_card");
            String card = string != null ? string : "";
            TextView textView = this.mName;
            if (textView != null) {
                textView.setText(FoundationAlias.getFapp().getString(bili.resource.account.R.string.account_global_string_307, new Object[]{name}));
            }
            TextView textView2 = this.mCard;
            if (textView2 != null) {
                textView2.setText(FoundationAlias.getFapp().getString(bili.resource.account.R.string.account_global_string_332, new Object[]{card}));
            }
        }
    }
}