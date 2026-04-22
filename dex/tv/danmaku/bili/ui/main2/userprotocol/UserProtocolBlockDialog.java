package tv.danmaku.bili.ui.main2.userprotocol;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bilibili.droid.ScreenUtil;
import com.bilibili.homepage.ExperimentGroup;
import com.bilibili.lib.ui.helper.NotchCompat;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.report.misaka.MisakaHelper;

/* compiled from: UserProtocolBlockDialog.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\b\u0010-\u001a\u00020*H\u0002J\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020%2\b\b\u0002\u00101\u001a\u000202J\u001a\u00103\u001a\u00020*2\u0006\u00100\u001a\u00020%2\b\b\u0002\u00101\u001a\u000202H\u0002J\b\u00104\u001a\u00020*H\u0002J\b\u00105\u001a\u00020*H\u0014J\b\u00106\u001a\u00020*H\u0003J\u0012\u00107\u001a\u00020*2\b\u00108\u001a\u0004\u0018\u00010\u001eH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Ltv/danmaku/bili/ui/main2/userprotocol/UserProtocolBlockDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "TAG", "", "mTvContent", "Landroid/widget/TextView;", "getMTvContent", "()Landroid/widget/TextView;", "setMTvContent", "(Landroid/widget/TextView;)V", "mTvTitle", "mTvConfirm", "getMTvConfirm", "setMTvConfirm", "mTvConfirmLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getMTvConfirmLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "setMTvConfirmLayout", "(Landroidx/constraintlayout/widget/ConstraintLayout;)V", "mTvCancel", "getMTvCancel", "setMTvCancel", "mTvPrivacyInfo", "mSpaceView", "Landroid/view/View;", "getMSpaceView", "()Landroid/view/View;", "setMSpaceView", "(Landroid/view/View;)V", "mRootContainer", "mDialogBg", "Landroid/widget/ImageView;", "mDialogBgTop", "mDialogBgMiddle", "mDialogBgBottom", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "refreshBackground", "matrix", "Landroid/graphics/Matrix;", "imageView", "changeHeight", "", "trimImageScale", "addBackground", "onStart", "init", "onClick", "v", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class UserProtocolBlockDialog extends AppCompatDialog implements View.OnClickListener {
    public static final int $stable = 8;
    private final String TAG;
    private ImageView mDialogBg;
    private ImageView mDialogBgBottom;
    private ImageView mDialogBgMiddle;
    private ImageView mDialogBgTop;
    private View mRootContainer;
    private View mSpaceView;
    private TextView mTvCancel;
    private TextView mTvConfirm;
    private ConstraintLayout mTvConfirmLayout;
    private TextView mTvContent;
    private TextView mTvPrivacyInfo;
    private TextView mTvTitle;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProtocolBlockDialog(Activity context) {
        super(context, R.style.AppTheme_AppCompat_Dialog_Alert_NoTitle);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "UserProtocolBlockDialog";
        UserProtocolBlockDialogEntrepot.INSTANCE.getActivityRef().add(new WeakReference<>(context));
        setOwnerActivity(context);
    }

    public final TextView getMTvContent() {
        return this.mTvContent;
    }

    public final void setMTvContent(TextView textView) {
        this.mTvContent = textView;
    }

    public final TextView getMTvConfirm() {
        return this.mTvConfirm;
    }

    public final void setMTvConfirm(TextView textView) {
        this.mTvConfirm = textView;
    }

    public final ConstraintLayout getMTvConfirmLayout() {
        return this.mTvConfirmLayout;
    }

    public final void setMTvConfirmLayout(ConstraintLayout constraintLayout) {
        this.mTvConfirmLayout = constraintLayout;
    }

    public final TextView getMTvCancel() {
        return this.mTvCancel;
    }

    public final void setMTvCancel(TextView textView) {
        this.mTvCancel = textView;
    }

    public final View getMSpaceView() {
        return this.mSpaceView;
    }

    public final void setMSpaceView(View view) {
        this.mSpaceView = view;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (UserProtocolExperiment.INSTANCE.hit(ExperimentGroup.EXPERIMENT_GROUP_BB) || UserProtocolExperiment.INSTANCE.hit(ExperimentGroup.EXPERIMENT_GROUP_CC)) {
            setContentView(R.layout.bili_app_dialog_user_protocol_test);
        } else {
            setContentView(R.layout.bili_app_dialog_user_protocol);
        }
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        init();
        refreshBackground();
    }

    private final void refreshBackground() {
        if (UserProtocolBlockDialogEntrepot.INSTANCE.getShowBackground()) {
            addBackground();
            return;
        }
        if (UserProtocolBlockDialogEntrepot.INSTANCE.getMFirstStep() && UserProtocolExperiment.hitSpecificBg()) {
            addBackground();
        } else if (!UserProtocolBlockDialogEntrepot.INSTANCE.getMFirstStep()) {
            if (UserProtocolBlockDialogEntrepot.INSTANCE.hitVisitorMod()) {
                Window window = getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                TextView it = this.mTvTitle;
                if (it != null) {
                    ViewGroup.LayoutParams layoutParams = it.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) layoutParams;
                    lp.topMargin = ScreenUtil.dip2px(getContext(), 26.0f);
                }
            } else {
                addBackground();
            }
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    public static /* synthetic */ Matrix matrix$default(UserProtocolBlockDialog userProtocolBlockDialog, ImageView imageView, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return userProtocolBlockDialog.matrix(imageView, z);
    }

    public final Matrix matrix(ImageView imageView, boolean changeHeight) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Drawable drawable = imageView.getDrawable();
        float dwidth = drawable.getIntrinsicWidth();
        float dheight = drawable.getIntrinsicHeight();
        float vwidth = imageView.getMeasuredWidth();
        float vheight = imageView.getMeasuredHeight();
        float scale = vwidth / dwidth;
        float dx = 0.0f;
        if (dwidth * vheight > vwidth * dheight) {
            dx = (vwidth - (dwidth * scale)) * 0.5f;
        }
        if (changeHeight) {
            ViewGroup.LayoutParams lp = imageView.getLayoutParams();
            lp.height = (int) (dheight * scale);
            imageView.setLayoutParams(lp);
        }
        Matrix matrix = new Matrix();
        matrix.setScale(scale, scale);
        matrix.postTranslate(dx, 0.0f);
        return matrix;
    }

    static /* synthetic */ void trimImageScale$default(UserProtocolBlockDialog userProtocolBlockDialog, ImageView imageView, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        userProtocolBlockDialog.trimImageScale(imageView, z);
    }

    private final void trimImageScale(final ImageView imageView, final boolean changeHeight) {
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: tv.danmaku.bili.ui.main2.userprotocol.UserProtocolBlockDialog$trimImageScale$1
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ViewTreeObserver viewTreeObserver2 = imageView.getViewTreeObserver();
                    if (viewTreeObserver2 != null) {
                        viewTreeObserver2.removeOnGlobalLayoutListener(this);
                    }
                    try {
                        imageView.setImageMatrix(this.matrix(imageView, changeHeight));
                    } catch (Exception e) {
                    }
                }
            });
        }
    }

    private final void addBackground() {
        final Window window = getWindow();
        if (window != null) {
            if (UserProtocolExperiment.INSTANCE.hit(ExperimentGroup.EXPERIMENT_GROUP_AA)) {
                window.setBackgroundDrawableResource(tv.danmaku.bili.ui.splash.R.drawable.layerlist_splash);
                View view = this.mRootContainer;
                if (view != null) {
                    view.setBackground(new ColorDrawable(Color.parseColor("#80000000")));
                }
            } else if (UserProtocolExperiment.hitSpecificBg()) {
                ImageView it = this.mDialogBgTop;
                if (it != null) {
                    it.setVisibility(0);
                    it.setImageResource(R.drawable.img_user_protocol_bg_test2_top);
                    trimImageScale(it, true);
                }
                ImageView it2 = this.mDialogBgMiddle;
                if (it2 != null) {
                    it2.setVisibility(0);
                    it2.setImageResource(R.drawable.img_user_protocol_bg_test2_middle);
                    trimImageScale$default(this, it2, false, 2, null);
                }
                ImageView it3 = this.mDialogBgBottom;
                if (it3 != null) {
                    it3.setVisibility(0);
                    it3.setImageResource(R.drawable.img_user_protocol_bg_test2_bottom);
                    trimImageScale(it3, true);
                }
            }
            window.addFlags(MisakaHelper.MAX_REPORT_SIZE);
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            int systemUiVisibility = 1024 | window.getDecorView().getSystemUiVisibility() | BR.hallEnterHotText | 2 | 4096;
            window.getDecorView().setSystemUiVisibility(systemUiVisibility);
            window.setStatusBarColor(0);
            ViewTreeObserver viewTreeObserver = window.getDecorView().getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.addOnWindowAttachListener(new ViewTreeObserver.OnWindowAttachListener() { // from class: tv.danmaku.bili.ui.main2.userprotocol.UserProtocolBlockDialog$addBackground$1$4
                    @Override // android.view.ViewTreeObserver.OnWindowAttachListener
                    public void onWindowAttached() {
                        if (NotchCompat.hasDisplayCutout(window)) {
                            NotchCompat.immersiveDisplayCutout(window);
                        }
                        window.getDecorView().getViewTreeObserver().removeOnWindowAttachListener(this);
                    }

                    @Override // android.view.ViewTreeObserver.OnWindowAttachListener
                    public void onWindowDetached() {
                    }
                });
            }
        }
    }

    protected void onStart() {
        super.onStart();
        if (UserProtocolBlockDialogEntrepot.INSTANCE.getShowBackground() || UserProtocolExperiment.hitSpecificBg()) {
            Window $this$onStart_u24lambda_u240 = getWindow();
            if ($this$onStart_u24lambda_u240 != null) {
                $this$onStart_u24lambda_u240.setGravity(17);
                $this$onStart_u24lambda_u240.setLayout(-1, -1);
                return;
            }
            return;
        }
        Window $this$onStart_u24lambda_u241 = getWindow();
        if ($this$onStart_u24lambda_u241 != null) {
            $this$onStart_u24lambda_u241.setGravity(17);
            $this$onStart_u24lambda_u241.setLayout(-2, -2);
        }
    }

    private final void init() {
        this.mTvTitle = (TextView) findViewById(R.id.title);
        this.mTvContent = (TextView) findViewById(R.id.content);
        this.mTvConfirm = (TextView) findViewById(R.id.agree);
        this.mTvCancel = (TextView) findViewById(R.id.disagree);
        this.mTvPrivacyInfo = (TextView) findViewById(R.id.privacy_info);
        this.mSpaceView = findViewById(R.id.space);
        View view = this.mSpaceView;
        if (view != null) {
            view.setVisibility(UserProtocolBlockDialogEntrepot.INSTANCE.getSpaceViewVisible());
        }
        this.mDialogBg = (ImageView) findViewById(R.id.dialog_background);
        this.mDialogBgTop = (ImageView) findViewById(R.id.dialog_background_top);
        this.mDialogBgMiddle = (ImageView) findViewById(R.id.dialog_background_middle);
        this.mDialogBgBottom = (ImageView) findViewById(R.id.dialog_background_bottom);
        TextView textView = this.mTvTitle;
        if (textView != null) {
            textView.setText(getContext().getString(bili.resource.homepage.R.string.homepage_global_string_28));
        }
        TextView textView2 = this.mTvContent;
        if (textView2 != null) {
            textView2.setMovementMethod(ScrollingMovementMethod.getInstance());
        }
        TextView textView3 = this.mTvPrivacyInfo;
        if (textView3 != null) {
            textView3.setMovementMethod(LinkMovementMethod.getInstance());
        }
        TextView textView4 = this.mTvContent;
        if (textView4 != null) {
            UserProtocolBlockDialogEntrepot userProtocolBlockDialogEntrepot = UserProtocolBlockDialogEntrepot.INSTANCE;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            textView4.setText(userProtocolBlockDialogEntrepot.getTvContent(context));
        }
        TextView textView5 = this.mTvContent;
        if (textView5 != null) {
            textView5.scrollTo(0, 0);
        }
        TextView textView6 = this.mTvConfirm;
        if (textView6 != null) {
            UserProtocolBlockDialogEntrepot userProtocolBlockDialogEntrepot2 = UserProtocolBlockDialogEntrepot.INSTANCE;
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            textView6.setText(userProtocolBlockDialogEntrepot2.getTvConfirm(context2));
        }
        TextView textView7 = this.mTvCancel;
        if (textView7 != null) {
            UserProtocolBlockDialogEntrepot userProtocolBlockDialogEntrepot3 = UserProtocolBlockDialogEntrepot.INSTANCE;
            Context context3 = getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            textView7.setText(userProtocolBlockDialogEntrepot3.getTvCancel(context3));
        }
        TextView textView8 = this.mTvPrivacyInfo;
        if (textView8 != null) {
            UserProtocolBlockDialogEntrepot userProtocolBlockDialogEntrepot4 = UserProtocolBlockDialogEntrepot.INSTANCE;
            Context context4 = getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
            textView8.setText(userProtocolBlockDialogEntrepot4.getDefaultLinkString(context4));
        }
        TextView textView9 = this.mTvConfirm;
        if (textView9 != null) {
            textView9.setOnClickListener(this);
        }
        ConstraintLayout constraintLayout = this.mTvConfirmLayout;
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(this);
        }
        TextView textView10 = this.mTvCancel;
        if (textView10 != null) {
            textView10.setOnClickListener(this);
        }
        TextView textView11 = this.mTvContent;
        if (textView11 != null) {
            textView11.setOnTouchListener(new View.OnTouchListener() { // from class: tv.danmaku.bili.ui.main2.userprotocol.UserProtocolBlockDialog$$ExternalSyntheticLambda0
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    boolean init$lambda$0;
                    init$lambda$0 = UserProtocolBlockDialog.init$lambda$0(view2, motionEvent);
                    return init$lambda$0;
                }
            });
        }
        this.mRootContainer = findViewById(R.id.root_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean init$lambda$0(View v, MotionEvent event) {
        switch (event.getAction()) {
            case 0:
            case 2:
                ViewParent parent = v.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                    break;
                }
                break;
            case 1:
                ViewParent parent2 = v.getParent();
                if (parent2 != null) {
                    parent2.requestDisallowInterceptTouchEvent(false);
                    break;
                }
                break;
        }
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        if (v == null) {
            return;
        }
        int id = v.getId();
        if (id == R.id.agree) {
            UserProtocolBlockDialogEntrepot.INSTANCE.agree(this);
        } else if (id == R.id.disagree) {
            UserProtocolBlockDialogEntrepot.INSTANCE.disagree(this);
        }
    }
}