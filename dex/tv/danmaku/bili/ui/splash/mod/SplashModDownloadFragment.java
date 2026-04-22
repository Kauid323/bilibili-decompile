package tv.danmaku.bili.ui.splash.mod;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import bili.resource.homepage.R;
import com.bilibili.lib.ui.BaseFragment;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.TintProgressBar;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import tv.danmaku.bili.ui.splash.ad.page.ISplash;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: SplashModDownloadFragment.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0019\u001a\u00020\rH\u0002J\b\u0010\u001a\u001a\u00020\rH\u0002J\b\u0010\u001b\u001a\u00020\rH\u0002J\u0017\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Ltv/danmaku/bili/ui/splash/mod/SplashModDownloadFragment;", "Lcom/bilibili/lib/ui/BaseFragment;", "<init>", "()V", "mTvDesc", "Landroid/widget/TextView;", "mProgressBar", "Lcom/bilibili/magicasakura/widgets/TintProgressBar;", "mDescfmt", "", "mCallback", "Ltv/danmaku/bili/ui/splash/mod/SplashModDownloadFragment$ModDownloadCallback;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "onSuccess", "onError", "updateMod", "onProgress", "progress", "", "(Ljava/lang/Float;)V", "onDestroy", "ModDownloadCallback", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class SplashModDownloadFragment extends BaseFragment {
    public static final int $stable = 8;
    private ModDownloadCallback mCallback = new ModDownloadCallback(this);
    private String mDescfmt;
    private TintProgressBar mProgressBar;
    private TextView mTvDesc;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String string = getString(R.string.homepage_global_string_150);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.mDescfmt = string;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return inflater.inflate(tv.danmaku.bili.ui.splash.R.layout.bili_layout_fragment_splash_mod_download, container, false);
    }

    public void onViewCreated(View view2, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view2, "view");
        super.onViewCreated(view2, savedInstanceState);
        initView(view2);
        if (savedInstanceState == null) {
            updateMod();
        }
    }

    private final void initView(View view2) {
        View findViewById = view2.findViewById(tv.danmaku.bili.ui.splash.R.id.download_desc);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mTvDesc = (TextView) findViewById;
        TintProgressBar findViewById2 = view2.findViewById(tv.danmaku.bili.ui.splash.R.id.download_progress);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mProgressBar = findViewById2;
        TextView textView = this.mTvDesc;
        TintProgressBar tintProgressBar = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvDesc");
            textView = null;
        }
        textView.setText(getString(bili.resource.common.R.string.common_global_string_348));
        TintProgressBar tintProgressBar2 = this.mProgressBar;
        if (tintProgressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgressBar");
        } else {
            tintProgressBar = tintProgressBar2;
        }
        tintProgressBar.getLayoutParams().width = (int) ((getResources().getDisplayMetrics().widthPixels / 3.0f) * 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onSuccess() {
        TintProgressBar tintProgressBar = this.mProgressBar;
        if (tintProgressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mProgressBar");
            tintProgressBar = null;
        }
        tintProgressBar.setProgress(100);
        TextView textView = this.mTvDesc;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvDesc");
            textView = null;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.US;
        String str = this.mDescfmt;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDescfmt");
            str = null;
        }
        String format = String.format(locale, str, Arrays.copyOf(new Object[]{100}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
        FragmentActivity activity = getActivity();
        ISplash.SplashHost splashHost = activity instanceof ISplash.SplashHost ? (ISplash.SplashHost) activity : null;
        if (splashHost != null) {
            splashHost.onModLoadSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onError() {
        TextView textView = this.mTvDesc;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvDesc");
            textView = null;
        }
        textView.setText(getString(bili.resource.common.R.string.common_global_string_347));
        TextView textView3 = this.mTvDesc;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvDesc");
        } else {
            textView2 = textView3;
        }
        textView2.setTextColor(ThemeUtils.getColorById(getContext(), com.bilibili.lib.ui.R.color.red_kit));
    }

    private final void updateMod() {
        SplashModHelper.INSTANCE.getSplashMod(this.mCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onProgress(Float progress) {
        if (progress != null) {
            progress.floatValue();
            int progressNum = (int) (progress.floatValue() * 100);
            TintProgressBar tintProgressBar = this.mProgressBar;
            String str = null;
            if (tintProgressBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mProgressBar");
                tintProgressBar = null;
            }
            tintProgressBar.setProgress(progressNum);
            TextView textView = this.mTvDesc;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvDesc");
                textView = null;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Locale locale = Locale.US;
            String str2 = this.mDescfmt;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDescfmt");
            } else {
                str = str2;
            }
            String format = String.format(locale, str, Arrays.copyOf(new Object[]{Integer.valueOf(progressNum)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        ModDownloadCallback modDownloadCallback = this.mCallback;
        if (modDownloadCallback != null) {
            modDownloadCallback.release();
        }
        this.mCallback = null;
    }

    /* compiled from: SplashModDownloadFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0006\u0010\u0012\u001a\u00020\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/ui/splash/mod/SplashModDownloadFragment$ModDownloadCallback;", "Ltv/danmaku/bili/ui/splash/mod/SplashModCallback;", "fragment", "Ltv/danmaku/bili/ui/splash/mod/SplashModDownloadFragment;", "<init>", "(Ltv/danmaku/bili/ui/splash/mod/SplashModDownloadFragment;)V", "getFragment", "()Ltv/danmaku/bili/ui/splash/mod/SplashModDownloadFragment;", "setFragment", "onProgress", "", "progress", "", "(Ljava/lang/Float;)V", "onSuccess", "onFail", "isCancel", "", "release", "splash_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class ModDownloadCallback implements SplashModCallback {
        public static final int $stable = 8;
        private SplashModDownloadFragment fragment;

        public ModDownloadCallback(SplashModDownloadFragment fragment) {
            this.fragment = fragment;
        }

        public final SplashModDownloadFragment getFragment() {
            return this.fragment;
        }

        public final void setFragment(SplashModDownloadFragment splashModDownloadFragment) {
            this.fragment = splashModDownloadFragment;
        }

        @Override // tv.danmaku.bili.ui.splash.mod.SplashModCallback
        public void onProgress(Float progress) {
            SplashModDownloadFragment splashModDownloadFragment = this.fragment;
            if (splashModDownloadFragment != null) {
                splashModDownloadFragment.onProgress(progress);
            }
        }

        @Override // tv.danmaku.bili.ui.splash.mod.SplashModCallback
        public void onSuccess() {
            SplashModDownloadFragment splashModDownloadFragment = this.fragment;
            if (splashModDownloadFragment != null) {
                splashModDownloadFragment.onSuccess();
            }
        }

        @Override // tv.danmaku.bili.ui.splash.mod.SplashModCallback
        public void onFail() {
            SplashModDownloadFragment splashModDownloadFragment = this.fragment;
            if (splashModDownloadFragment != null) {
                splashModDownloadFragment.onError();
            }
        }

        @Override // tv.danmaku.bili.ui.splash.mod.SplashModCallback
        public boolean isCancel() {
            SplashModDownloadFragment splashModDownloadFragment = this.fragment;
            if (splashModDownloadFragment != null) {
                return splashModDownloadFragment.activityDie();
            }
            return true;
        }

        public final void release() {
            this.fragment = null;
        }
    }
}