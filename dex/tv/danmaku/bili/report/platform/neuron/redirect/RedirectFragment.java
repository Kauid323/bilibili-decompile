package tv.danmaku.bili.report.platform.neuron.redirect;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bilibili.lib.neuron.model.config.RedirectConfig;
import com.bilibili.lib.ui.BaseFragment;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.widget.RecyclerView;

/* compiled from: RedirectFragment.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/report/platform/neuron/redirect/RedirectFragment;", "Lcom/bilibili/lib/ui/BaseFragment;", "<init>", "()V", "mConfig", "Lcom/bilibili/lib/neuron/model/config/RedirectConfig;", "mTvUuid", "Landroid/widget/TextView;", "mRvProxy", "Ltv/danmaku/bili/widget/RecyclerView;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class RedirectFragment extends BaseFragment {
    public static final int $stable = 8;
    private RedirectConfig mConfig;
    private RecyclerView mRvProxy;
    private TextView mTvUuid;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Bundle arguments = getArguments();
        this.mConfig = arguments != null ? (RedirectConfig) arguments.getParcelable(RedirectFragmentKt.BUNDLE_KEY_REDIRECT_CONFIG) : null;
        View view = inflater.inflate(R.layout.bili_app_fragment_neuron_redirect, container, false);
        this.mTvUuid = (TextView) view.findViewById(R.id.tv_uuid);
        this.mRvProxy = view.findViewById(R.id.rv_proxy);
        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RedirectConfig it = this.mConfig;
        if (it != null) {
            TextView textView = this.mTvUuid;
            if (textView != null) {
                textView.setText(it.uuid);
            }
            RecyclerView recyclerView = this.mRvProxy;
            if (recyclerView != null) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            }
            List list = it.proxy;
            Intrinsics.checkNotNull(list);
            RecyclerView.Adapter adapter = new Adapter(list);
            tv.danmaku.bili.widget.RecyclerView recyclerView2 = this.mRvProxy;
            if (recyclerView2 != null) {
                recyclerView2.setAdapter(adapter);
            }
        }
    }
}