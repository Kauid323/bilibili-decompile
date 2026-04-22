package tv.danmaku.bili.ui.main;

import android.content.Context;
import android.graphics.PointF;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.ImageRequestBuilder;
import com.bilibili.lib.image2.bean.BiliAnimatable;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.tribe.core.internal.Hooks;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.report.misaka.MisakaHelper;

/* compiled from: MineGuideActivity.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\bH\u0014J\b\u0010\u0013\u001a\u00020\bH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/ui/main/MineGuideActivity;", "Landroidx/fragment/app/FragmentActivity;", "<init>", "()V", "mTopAnimatable", "Lcom/bilibili/lib/image2/bean/BiliAnimatable;", "mBottomAnimatable", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onPostCreate", "setupBottomImage", "imageView", "Lcom/bilibili/lib/image2/view/BiliImageView;", "file", "", "setupTopImage", "onDestroy", "finish", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class MineGuideActivity extends FragmentActivity {
    public static final String BUNDLE_KEY_BOTTOM_PATH = "bundle_key_bottom_path";
    public static final String BUNDLE_KEY_TOP_PATH = "bundle_key_top_path";
    private BiliAnimatable mBottomAnimatable;
    private BiliAnimatable mTopAnimatable;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    /* compiled from: MineGuideActivity.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/ui/main/MineGuideActivity$Companion;", "", "<init>", "()V", "BUNDLE_KEY_TOP_PATH", "", "BUNDLE_KEY_BOTTOM_PATH", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        View decorView;
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT != 26) {
            setRequestedOrientation(1);
        }
        setContentView(R.layout.bili_app_dialog_navigation_guide);
        final BiliImageView topImage = findViewById(R.id.top_image);
        final BiliImageView bottomImage = findViewById(R.id.bottom_image);
        Window window = getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        decorView.post(new Runnable() { // from class: tv.danmaku.bili.ui.main.MineGuideActivity$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MineGuideActivity.onCreate$lambda$0(MineGuideActivity.this, topImage, bottomImage);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(MineGuideActivity this$0, BiliImageView $topImage, BiliImageView $bottomImage) {
        Bundle it = this$0.getIntent().getExtras();
        if (it != null) {
            Intrinsics.checkNotNull($topImage);
            String string = it.getString(BUNDLE_KEY_TOP_PATH, "");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            this$0.setupTopImage($topImage, string);
            Intrinsics.checkNotNull($bottomImage);
            String string2 = it.getString(BUNDLE_KEY_BOTTOM_PATH, "");
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            this$0.setupBottomImage($bottomImage, string2);
        }
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        window.getDecorView().setSystemUiVisibility(systemUiVisibility | MisakaHelper.MAX_REPORT_SIZE | BR.hallEnterHotText);
        getWindow().setStatusBarColor(0);
    }

    private final void setupBottomImage(BiliImageView imageView, String file) {
        ImageRequestBuilder.enableAnimate$default(BiliImageLoader.INSTANCE.with(this).uri(Uri.fromFile(new File(file))), true, (Boolean) null, 2, (Object) null).animationPlayLoopCount(1).imageLoadingListener(new MineGuideActivity$setupBottomImage$1(this)).into(imageView);
    }

    private final void setupTopImage(BiliImageView imageView, String file) {
        ImageRequestBuilder.enableAnimate$default(BiliImageLoader.INSTANCE.with(this).uri(Uri.fromFile(new File(file))), true, (Boolean) null, 2, (Object) null).actualImageFocusPoint(new PointF(0.0f, 0.0f)).animationPlayLoopCount(1).imageLoadingListener(new MineGuideActivity$setupTopImage$1(this)).into(imageView);
    }

    protected void onDestroy() {
        super.onDestroy();
        MainDialogManager.showNextDialog("navigation_guide", false, (Context) this);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }
}