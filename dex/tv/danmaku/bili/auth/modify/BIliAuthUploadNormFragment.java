package tv.danmaku.bili.auth.modify;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.ActionBar;
import com.bilibili.app.auth.R;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.view.BiliImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: BIliAuthUploadNormFragment.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0016\u0010\u0013\u001a\u00020\u0011*\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/auth/modify/BIliAuthUploadNormFragment;", "Ltv/danmaku/bili/auth/modify/BaseAuthModifyFragment;", "<init>", "()V", "URL_NORM_HAND", "", "URL_NORM_FRONT", "URL_NORM_BACK", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "initViews", "", "view", "intoImage", "Lcom/bilibili/lib/image2/view/BiliImageView;", "url", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class BIliAuthUploadNormFragment extends BaseAuthModifyFragment {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "BIliAuthUploadNormFragment";
    private String URL_NORM_HAND = "https://i0.hdslb.com/bfs/activity-plat/static/20240119/9ccf041718e5d6d6dfaebc91b85c791c/spmoJSpWM1.png";
    private String URL_NORM_FRONT = "https://i0.hdslb.com/bfs/activity-plat/static/20240119/9ccf041718e5d6d6dfaebc91b85c791c/yIzURcmLd6.png";
    private String URL_NORM_BACK = "https://i0.hdslb.com/bfs/activity-plat/static/20240119/9ccf041718e5d6d6dfaebc91b85c791c/iyMNvOLenv.png";

    /* compiled from: BIliAuthUploadNormFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ltv/danmaku/bili/auth/modify/BIliAuthUploadNormFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Ltv/danmaku/bili/auth/modify/BIliAuthUploadNormFragment;", "params", "Landroid/os/Bundle;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BIliAuthUploadNormFragment newInstance(Bundle params) {
            BIliAuthUploadNormFragment fragment = new BIliAuthUploadNormFragment();
            if (params != null) {
                fragment.setArguments(params);
            }
            return fragment;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View view = inflater.inflate(R.layout.fragment_auth_upload_photo_norm, container, false);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle(bili.resource.account.R.string.account_global_string_287);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setDisplayHomeAsUpEnabled(true);
        }
        Intrinsics.checkNotNull(view);
        initViews(view);
        return view;
    }

    private final void initViews(View view) {
        BiliImageView mExampleImage1 = (BiliImageView) view.findViewById(R.id.img_example1);
        BiliImageView mExampleImage2 = (BiliImageView) view.findViewById(R.id.img_example2);
        BiliImageView mExampleImage3 = (BiliImageView) view.findViewById(R.id.img_example3);
        Intrinsics.checkNotNull(mExampleImage1);
        intoImage(mExampleImage1, this.URL_NORM_HAND);
        Intrinsics.checkNotNull(mExampleImage2);
        intoImage(mExampleImage2, this.URL_NORM_FRONT);
        Intrinsics.checkNotNull(mExampleImage3);
        intoImage(mExampleImage3, this.URL_NORM_BACK);
    }

    private final void intoImage(BiliImageView $this$intoImage, String url) {
        BiliImageLoader biliImageLoader = BiliImageLoader.INSTANCE;
        Context context = $this$intoImage.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        biliImageLoader.with(context).url(url == null ? "" : url).into($this$intoImage);
    }
}