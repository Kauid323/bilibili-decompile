package tv.danmaku.bili.ui.main.imagerecognize;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import bolts.Task;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.app.dialogmanager.MainDialogManager;
import com.bilibili.droid.BundleUtil;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.image2.BiliImageLoader;
import com.bilibili.lib.image2.view.BiliImageView;
import com.bilibili.lib.resmanager.ResManager;
import com.bilibili.lib.resmanager.ResRequest;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefine;
import tv.danmaku.bili.widget.PendantAvatarFrameLayout;

/* compiled from: ImageRecognizeUpDialogActivity.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000b\u001a\u00020\bH\u0014J\b\u0010\u000e\u001a\u00020\bH\u0014J\b\u0010\u000f\u001a\u00020\bH\u0016J\b\u0010\u0010\u001a\u00020\bH\u0002J\u0012\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/ui/main/imagerecognize/ImageRecognizeUpDialogActivity;", "Lcom/bilibili/lib/ui/BaseAppCompatActivity;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "mUrlInfo", "Ltv/danmaku/bili/ui/main/imagerecognize/ImageUrlInfo;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "mRunnable", "Ljava/lang/Runnable;", "onDestroy", "finish", "initView", "onClick", "v", "Landroid/view/View;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ImageRecognizeUpDialogActivity extends BaseAppCompatActivity implements View.OnClickListener {
    public static final int $stable = 8;
    private final Runnable mRunnable = new Runnable() { // from class: tv.danmaku.bili.ui.main.imagerecognize.ImageRecognizeUpDialogActivity$$ExternalSyntheticLambda1
        @Override // java.lang.Runnable
        public final void run() {
            ImageRecognizeUpDialogActivity.this.finish();
        }
    };
    private ImageUrlInfo mUrlInfo;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        Bundle bundleExtra;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bili_app_layout_image_recognize_up_dialog);
        Intent intent = getIntent();
        this.mUrlInfo = (intent == null || (bundleExtra = intent.getBundleExtra(BundleUtil.KEY_DEFAULT_EXTRA_BUNDLE)) == null) ? null : (ImageUrlInfo) bundleExtra.getParcelable(ImageRecognizeDialogActivityKt.ARGS_IMAGE_URL_INFO);
        if (this.mUrlInfo == null) {
            finish();
            return;
        }
        initView();
        ImageRecognizeHelper imageRecognizeHelper = ImageRecognizeHelper.INSTANCE;
        ImageUrlInfo imageUrlInfo = this.mUrlInfo;
        Intrinsics.checkNotNull(imageUrlInfo);
        imageRecognizeHelper.reportDialogShow$core_apinkDebug(imageUrlInfo);
    }

    protected void onStart() {
        super.onStart();
        Window $this$onStart_u24lambda_u240 = getWindow();
        if ($this$onStart_u24lambda_u240 != null) {
            $this$onStart_u24lambda_u240.setGravity(17);
            $this$onStart_u24lambda_u240.setLayout(-2, -2);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        HandlerThreads.remove(0, this.mRunnable);
        MainDialogManager.showNextDialog("share_image_recognize", false, (Context) this);
        Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.ui.main.imagerecognize.ImageRecognizeUpDialogActivity$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Unit onDestroy$lambda$0;
                onDestroy$lambda$0 = ImageRecognizeUpDialogActivity.onDestroy$lambda$0(ImageRecognizeUpDialogActivity.this);
                return onDestroy$lambda$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onDestroy$lambda$0(ImageRecognizeUpDialogActivity this$0) {
        ImageUrlInfo it = this$0.mUrlInfo;
        if (it != null) {
            ResManager.delete(new ResRequest(it.getPicUrl(), (String) null, 2, (DefaultConstructorMarker) null));
        }
        return Unit.INSTANCE;
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, R.anim.anim_op_biz_dialog_out);
    }

    private final void initView() {
        float f;
        BiliImageView findViewById = findViewById(R.id.up_background);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        BiliImageView upBackground = findViewById;
        PendantAvatarFrameLayout findViewById2 = findViewById(R.id.up_avatar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        PendantAvatarFrameLayout upAvatar = findViewById2;
        View findViewById3 = findViewById(R.id.up_name);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        TextView upName = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.up_official_title);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        TextView upOfficialTitle = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.up_fans_count);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        TextView upFans = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.up_publish_count);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(...)");
        TextView upPublish = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.up_like_count);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(...)");
        TextView upLikes = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.up_space);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(...)");
        TextView upSpace = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.hint);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(...)");
        TextView hint = (TextView) findViewById9;
        findViewById(R.id.up_root).setOnClickListener(this);
        ((ImageView) findViewById(R.id.close_btn)).setOnClickListener(this);
        ImageUrlInfo $this$initView_u24lambda_u240 = this.mUrlInfo;
        if ($this$initView_u24lambda_u240 != null) {
            BiliImageLoader.INSTANCE.with((FragmentActivity) this).url(BusinessSplashDefine.FILE_URI_PREFIX + $this$initView_u24lambda_u240.getImageLocalPath()).into(upBackground);
            boolean isNightTheme = MultipleThemeUtils.isNightTheme((Context) this);
            if (isNightTheme && $this$initView_u24lambda_u240.hasHonor()) {
                f = 0.25f;
            } else {
                f = (isNightTheme || $this$initView_u24lambda_u240.hasHonor()) ? 0.4f : 0.2f;
            }
            upBackground.setAlpha(f);
            boolean z = false;
            if (!TextUtils.isEmpty($this$initView_u24lambda_u240.getMessage())) {
                hint.setText($this$initView_u24lambda_u240.getMessage());
                hint.setVisibility(0);
            } else {
                hint.setVisibility(8);
            }
            if ($this$initView_u24lambda_u240.getAutoClose()) {
                int delay = $this$initView_u24lambda_u240.getAutoCloseTime() > 0 ? $this$initView_u24lambda_u240.getAutoCloseTime() : 5;
                HandlerThreads.postDelayed(0, this.mRunnable, delay * 1000);
            }
            ShareAuthor $this$initView_u24lambda_u240_u240 = $this$initView_u24lambda_u240.getAuthor();
            if ($this$initView_u24lambda_u240_u240 != null) {
                PendantAvatarFrameLayout.ShowParams showParams = new PendantAvatarFrameLayout.ShowParams().avatarImgUrl($this$initView_u24lambda_u240_u240.getAvatarUrl()).badgeImgRes($this$initView_u24lambda_u240_u240.getVerifyIcon()).borderWidth(0.5f).borderColor(com.bilibili.lib.theme.R.color.Ga1).defaultAvatar(com.bilibili.app.comm.baseres.R.drawable.ic_default_avatar);
                upAvatar.show(showParams);
                upName.setText($this$initView_u24lambda_u240_u240.getNickname());
                upFans.setText($this$initView_u24lambda_u240_u240.getFollower());
                upPublish.setText($this$initView_u24lambda_u240_u240.getArchiveNumber());
                upLikes.setText($this$initView_u24lambda_u240_u240.getLike());
                String officialTitle = $this$initView_u24lambda_u240_u240.getOfficialTitle();
                if (officialTitle == null || StringsKt.isBlank(officialTitle)) {
                    upOfficialTitle.setVisibility(8);
                    upName.setPadding(0, ListExtentionsKt.toPx(10), 0, 0);
                } else {
                    upOfficialTitle.setVisibility(0);
                    upOfficialTitle.setText($this$initView_u24lambda_u240_u240.getOfficialTitle());
                }
            }
            String buttonText = $this$initView_u24lambda_u240.getButtonText();
            if (!((buttonText == null || StringsKt.isBlank(buttonText)) ? true : true)) {
                upSpace.setText($this$initView_u24lambda_u240.getButtonText());
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v == null) {
            return;
        }
        int id = v.getId();
        if (id == R.id.up_root) {
            ImageRecognizeHelperKt.routerToSchema((Activity) this, this.mUrlInfo);
        } else if (id == R.id.close_btn) {
            finish();
        }
    }
}