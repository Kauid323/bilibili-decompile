package tv.danmaku.bili.ui.garb;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.bililive.bililive.infra.hybrid.ui.fragment.comm.CommonWebFragment;
import com.bililive.bililive.infra.hybrid.utils.LiveHybridUriDispatcher;
import com.bililive.bililive.infra.hybrid.utils.ScreenOrientationLockable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.fullscreen.page.CommonKt;

/* compiled from: GrabDigitalWebFragment.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/ui/garb/GrabDigitalWebFragment;", "Lcom/bililive/bililive/infra/hybrid/ui/fragment/comm/CommonWebFragment;", "<init>", "()V", "onAttach", "", "context", "Landroid/content/Context;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class GrabDigitalWebFragment extends CommonWebFragment {
    private static final String URL = "url";
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: GrabDigitalWebFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/garb/GrabDigitalWebFragment$Companion;", "", "<init>", "()V", CommonKt.URL_TAG, "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void onAttach(Context context) {
        LiveHybridUriDispatcher.ExtraParam extraParam;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        if (context.getResources().getConfiguration().orientation == 1) {
            extraParam = new LiveHybridUriDispatcher.ExtraParam(1, (ScreenOrientationLockable) null, (Map) null, (Map) null, 14, (DefaultConstructorMarker) null);
        } else {
            extraParam = new LiveHybridUriDispatcher.ExtraParam(2, (ScreenOrientationLockable) null, (Map) null, (Map) null, 14, (DefaultConstructorMarker) null);
        }
        setMExtraParam(extraParam);
        Bundle arguments = getArguments();
        setMOriginUrl((arguments == null || (r1 = arguments.getString("url")) == null) ? "" : "");
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getMWindowCloseIcon().setVisibility(8);
    }
}