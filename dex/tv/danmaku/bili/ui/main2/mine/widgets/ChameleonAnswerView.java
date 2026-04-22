package tv.danmaku.bili.ui.main2.mine.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.MutableBundleLike;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.ui.garb.Garb;
import com.bilibili.lib.ui.garb.GarbManager;
import com.bilibili.lib.ui.util.MultipleThemeUtils;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.Tintable;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.android.util.DigitsUtil;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.appwidget.upcard.utils.ReportUtilKt;
import tv.danmaku.bili.router.MainRouteUris;
import tv.danmaku.bili.splash.ad.config.BusinessSplashDefineKt;
import tv.danmaku.bili.ui.answer.AnswerActivity;
import tv.danmaku.bili.ui.main2.mine.modularvip.MineVipServiceKt;

/* compiled from: ChameleonAnswerView.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 32\u00020\u00012\u00020\u00022\u00020\u0003:\f()*+,-./0123B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J$\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00142\b\u0010 \u001a\u0004\u0018\u00010\u00142\b\u0010!\u001a\u0004\u0018\u00010\u0014J\u0012\u0010\"\u001a\u00020\t2\b\b\u0001\u0010#\u001a\u00020\tH\u0003J\b\u0010$\u001a\u00020\u001eH\u0016J\u0012\u0010%\u001a\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u00064"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView;", "Landroid/widget/FrameLayout;", "Lcom/bilibili/magicasakura/widgets/Tintable;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mPercentView", "Landroid/widget/TextView;", "mContentView", "mArrow", "Landroid/widget/ImageView;", "mIsAnswering", "", "mPercentText", "", "mContentText", "mJumpUrl", "mPercentSpace", "Landroid/widget/Space;", "status", "Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView$Status;", "getStatus", "()Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView$Status;", ReportUtilKt.POS_UPDATE, "", "percent", "url", "content", "getColor", "res", "tint", "onClick", "v", "Landroid/view/View;", "GrabThemeNoAnswer", "GrabThemeAnswer", "NightThemeAnswer", "NightThemeNoAnswer", "ColorfulThemeNoAnswer", "ColorfulThemeAnswer", "WhiteThemeNoAnswer", "WhiteThemeAnswer", "NoAnswer", "Answer", "Status", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class ChameleonAnswerView extends FrameLayout implements Tintable, View.OnClickListener {
    public static final String ANSWER_DEFAULT_URL = "https://www.bilibili.com/h5/newbie/entry?navhide=1";
    public static final String ANSWER_SPMID_MAIN = "main.my-page.answer.0";
    private final ImageView mArrow;
    private String mContentText;
    private final TextView mContentView;
    private boolean mIsAnswering;
    private String mJumpUrl;
    private Space mPercentSpace;
    private String mPercentText;
    private final TextView mPercentView;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChameleonAnswerView.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bb\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078'X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView$Status;", "", "contentText", "", "getContentText", "()Ljava/lang/String;", "percentTextColor", "", "getPercentTextColor", "()I", "contentTextColor", "getContentTextColor", BusinessSplashDefineKt.SPLASH_OPEN_EVENT_BACKGROUND, "Landroid/graphics/drawable/Drawable;", "getBackground", "()Landroid/graphics/drawable/Drawable;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public interface Status {
        Drawable getBackground();

        String getContentText();

        int getContentTextColor();

        int getPercentTextColor();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChameleonAnswerView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ChameleonAnswerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChameleonAnswerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mPercentText = "";
        this.mContentText = "";
        this.mJumpUrl = "";
        FrameLayout.inflate(getContext(), R.layout.bili_layout_main_user_center_answer_view, this);
        View findViewById = findViewById(R.id.percent);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.mPercentView = (TextView) findViewById;
        View findViewById2 = findViewById(R.id.content);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.mContentView = (TextView) findViewById2;
        this.mPercentSpace = (Space) findViewById(R.id.left_layout);
        View findViewById3 = findViewById(R.id.arrow);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.mArrow = (ImageView) findViewById3;
        setOnClickListener(this);
    }

    public /* synthetic */ ChameleonAnswerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final Status getStatus() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        Garb garb = GarbManager.getGarbWithNightMode(context);
        if (garb.isPure()) {
            if (garb.isNight()) {
                return this.mIsAnswering ? new NightThemeAnswer() : new NightThemeNoAnswer();
            } else if (garb.isWhite()) {
                return this.mIsAnswering ? new WhiteThemeAnswer() : new WhiteThemeNoAnswer();
            } else {
                return this.mIsAnswering ? new ColorfulThemeAnswer() : new ColorfulThemeNoAnswer();
            }
        } else if (garb.isPrimaryOnly()) {
            if (MultipleThemeUtils.isNightTheme(getContext())) {
                return this.mIsAnswering ? new NightThemeAnswer() : new NightThemeNoAnswer();
            }
            return this.mIsAnswering ? new WhiteThemeAnswer() : new WhiteThemeNoAnswer();
        } else {
            return this.mIsAnswering ? new GrabThemeAnswer() : new GrabThemeNoAnswer();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (kotlin.text.StringsKt.endsWith$default(r2, "%", false, 2, (java.lang.Object) null) == true) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void update() {
        boolean z;
        Status status = getStatus();
        if (!TextUtils.isEmpty(this.mPercentText) && this.mIsAnswering) {
            TextView textView = this.mPercentView;
            String str = this.mPercentText;
            if (str != null) {
                z = true;
            }
            z = false;
            String str2 = this.mPercentText;
            if (!z) {
                str2 = str2 + "%";
            }
            textView.setText(str2);
            this.mPercentView.setTextColor(status.getPercentTextColor());
            this.mPercentView.setVisibility(0);
            Space space = this.mPercentSpace;
            if (space != null) {
                space.setVisibility(0);
            }
        } else {
            this.mPercentView.setVisibility(8);
            Space space2 = this.mPercentSpace;
            if (space2 != null) {
                space2.setVisibility(8);
            }
        }
        this.mContentView.setText(!TextUtils.isEmpty(this.mContentText) ? this.mContentText : status.getContentText());
        this.mContentView.setTextColor(status.getContentTextColor());
        this.mArrow.setColorFilter(status.getContentTextColor());
        ViewCompat.setBackground(this, status.getBackground());
    }

    public final void update(String percent, String url, String content) {
        this.mPercentText = percent;
        this.mIsAnswering = DigitsUtil.parseInt(this.mPercentText) != 0;
        this.mContentText = content;
        this.mJumpUrl = url;
        update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getColor(int res) {
        return ResourcesCompat.getColor(getResources(), res, getContext().getTheme());
    }

    public void tint() {
        update();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChameleonAnswerView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView$GrabThemeNoAnswer;", "Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView$NoAnswer;", "Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView;", "<init>", "(Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView;)V", "contentTextColor", "", "getContentTextColor", "()I", "backgroundColor", "getBackgroundColor$core_apinkDebug", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final class GrabThemeNoAnswer extends NoAnswer {
        public GrabThemeNoAnswer() {
            super();
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Status
        public int getContentTextColor() {
            return ChameleonAnswerView.this.getColor(R.color.bili_mine_grab_theme_no_answer_text);
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.NoAnswer
        public int getBackgroundColor$core_apinkDebug() {
            return ChameleonAnswerView.this.getColor(R.color.bili_mine_grab_theme_no_answer_background);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChameleonAnswerView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView$GrabThemeAnswer;", "Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView$Answer;", "Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView;", "<init>", "(Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView;)V", "percentTextColor", "", "getPercentTextColor", "()I", "contentTextColor", "getContentTextColor", "leftBackgroundColor", "getLeftBackgroundColor$core_apinkDebug", "rightBackgroundColor", "getRightBackgroundColor$core_apinkDebug", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final class GrabThemeAnswer extends Answer {
        public GrabThemeAnswer() {
            super();
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Status
        public int getPercentTextColor() {
            return ChameleonAnswerView.this.getColor(R.color.bili_mine_grab_theme_answer_percent);
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Status
        public int getContentTextColor() {
            return ChameleonAnswerView.this.getColor(R.color.bili_mine_grab_theme_answer_text);
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Answer
        public int getLeftBackgroundColor$core_apinkDebug() {
            return ChameleonAnswerView.this.getColor(R.color.bili_mine_grab_theme_answer_background_left);
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Answer
        public int getRightBackgroundColor$core_apinkDebug() {
            return ChameleonAnswerView.this.getColor(R.color.bili_mine_grab_theme_answer_background_right);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChameleonAnswerView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView$NightThemeAnswer;", "Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView$Answer;", "Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView;", "<init>", "(Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView;)V", "percentTextColor", "", "getPercentTextColor", "()I", "contentTextColor", "getContentTextColor", "leftBackgroundColor", "getLeftBackgroundColor$core_apinkDebug", "rightBackgroundColor", "getRightBackgroundColor$core_apinkDebug", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final class NightThemeAnswer extends Answer {
        public NightThemeAnswer() {
            super();
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Status
        public int getPercentTextColor() {
            return ChameleonAnswerView.this.getColor(R.color.bili_mine_night_theme_answer_percent);
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Status
        public int getContentTextColor() {
            return ChameleonAnswerView.this.getColor(R.color.bili_mine_night_theme_answer_text);
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Answer
        public int getLeftBackgroundColor$core_apinkDebug() {
            return ChameleonAnswerView.this.getColor(R.color.bili_mine_night_theme_answer_background_left);
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Answer
        public int getRightBackgroundColor$core_apinkDebug() {
            return ChameleonAnswerView.this.getColor(R.color.bili_mine_night_theme_answer_background_right);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChameleonAnswerView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView$NightThemeNoAnswer;", "Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView$NoAnswer;", "Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView;", "<init>", "(Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView;)V", "contentTextColor", "", "getContentTextColor", "()I", "backgroundColor", "getBackgroundColor$core_apinkDebug", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final class NightThemeNoAnswer extends NoAnswer {
        public NightThemeNoAnswer() {
            super();
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Status
        public int getContentTextColor() {
            return ChameleonAnswerView.this.getColor(R.color.bili_mine_night_theme_no_answer_text);
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.NoAnswer
        public int getBackgroundColor$core_apinkDebug() {
            return ChameleonAnswerView.this.getColor(R.color.bili_mine_night_theme_no_answer_background);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChameleonAnswerView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView$ColorfulThemeNoAnswer;", "Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView$NoAnswer;", "Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView;", "<init>", "(Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView;)V", "contentTextColor", "", "getContentTextColor", "()I", "backgroundColor", "getBackgroundColor$core_apinkDebug", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final class ColorfulThemeNoAnswer extends NoAnswer {
        public ColorfulThemeNoAnswer() {
            super();
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Status
        public int getContentTextColor() {
            return ThemeUtils.getColorById(ChameleonAnswerView.this.getContext(), com.bilibili.app.comm.baseres.R.color.theme_color_primary);
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.NoAnswer
        public int getBackgroundColor$core_apinkDebug() {
            return ChameleonAnswerView.this.getColor(R.color.bili_mine_colorful_theme_no_answer_background);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChameleonAnswerView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView$ColorfulThemeAnswer;", "Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView$Answer;", "Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView;", "<init>", "(Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView;)V", "percentTextColor", "", "getPercentTextColor", "()I", "contentTextColor", "getContentTextColor", "leftBackgroundColor", "getLeftBackgroundColor$core_apinkDebug", "rightBackgroundColor", "getRightBackgroundColor$core_apinkDebug", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final class ColorfulThemeAnswer extends Answer {
        public ColorfulThemeAnswer() {
            super();
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Status
        public int getPercentTextColor() {
            return ThemeUtils.getColorById(ChameleonAnswerView.this.getContext(), com.bilibili.app.comm.baseres.R.color.theme_color_primary);
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Status
        public int getContentTextColor() {
            return ThemeUtils.getColorById(ChameleonAnswerView.this.getContext(), com.bilibili.app.comm.baseres.R.color.theme_color_primary);
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Answer
        public int getLeftBackgroundColor$core_apinkDebug() {
            return ColorUtils.setAlphaComponent(ThemeUtils.getColorById(ChameleonAnswerView.this.getContext(), com.bilibili.app.comm.baseres.R.color.theme_color_primary), 51);
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Answer
        public int getRightBackgroundColor$core_apinkDebug() {
            return ChameleonAnswerView.this.getColor(R.color.bili_mine_colorful_theme_answer_background_right);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChameleonAnswerView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView$WhiteThemeNoAnswer;", "Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView$NoAnswer;", "Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView;", "<init>", "(Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView;)V", "contentTextColor", "", "getContentTextColor", "()I", "backgroundColor", "getBackgroundColor$core_apinkDebug", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final class WhiteThemeNoAnswer extends NoAnswer {
        public WhiteThemeNoAnswer() {
            super();
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Status
        public int getContentTextColor() {
            return ChameleonAnswerView.this.getColor(R.color.bili_mine_white_theme_answer_text);
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.NoAnswer
        public int getBackgroundColor$core_apinkDebug() {
            return ChameleonAnswerView.this.getColor(R.color.bili_mine_white_theme_no_answer_background);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ChameleonAnswerView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView$WhiteThemeAnswer;", "Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView$Answer;", "Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView;", "<init>", "(Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView;)V", "percentTextColor", "", "getPercentTextColor", "()I", "contentTextColor", "getContentTextColor", "leftBackgroundColor", "getLeftBackgroundColor$core_apinkDebug", "rightBackgroundColor", "getRightBackgroundColor$core_apinkDebug", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public final class WhiteThemeAnswer extends Answer {
        public WhiteThemeAnswer() {
            super();
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Status
        public int getPercentTextColor() {
            return ChameleonAnswerView.this.getColor(R.color.bili_mine_white_theme_answer_percent);
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Status
        public int getContentTextColor() {
            return ChameleonAnswerView.this.getColor(R.color.bili_mine_white_theme_answer_text);
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Answer
        public int getLeftBackgroundColor$core_apinkDebug() {
            return ChameleonAnswerView.this.getColor(R.color.bili_mine_white_theme_answer_background_left);
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Answer
        public int getRightBackgroundColor$core_apinkDebug() {
            return ChameleonAnswerView.this.getColor(R.color.bili_mine_white_theme_answer_background_right);
        }
    }

    /* compiled from: ChameleonAnswerView.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b¢\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u0004\u0018\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00058!X \u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView$NoAnswer;", "Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView$Status;", "<init>", "(Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView;)V", "percentTextColor", "", "getPercentTextColor", "()I", "contentText", "", "getContentText", "()Ljava/lang/String;", BusinessSplashDefineKt.SPLASH_OPEN_EVENT_BACKGROUND, "Landroid/graphics/drawable/Drawable;", "getBackground", "()Landroid/graphics/drawable/Drawable;", "backgroundColor", "getBackgroundColor$core_apinkDebug", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private abstract class NoAnswer implements Status {
        public abstract int getBackgroundColor$core_apinkDebug();

        public NoAnswer() {
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Status
        public int getPercentTextColor() {
            return 0;
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Status
        public String getContentText() {
            String string = ChameleonAnswerView.this.getContext().getString(bili.resource.homepage.R.string.homepage_global_string_43);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Status
        public Drawable getBackground() {
            Drawable drawable = ResourcesCompat.getDrawable(ChameleonAnswerView.this.getResources(), R.drawable.bili_background_mine_no_answer, ChameleonAnswerView.this.getContext().getTheme());
            GradientDrawable drawable2 = (GradientDrawable) (drawable != null ? drawable.mutate() : null);
            if (drawable2 != null) {
                drawable2.setColor(getBackgroundColor$core_apinkDebug());
            }
            return drawable2;
        }
    }

    /* compiled from: ChameleonAnswerView.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b¢\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00010\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8!X \u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8!X \u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView$Answer;", "Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView$Status;", "<init>", "(Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView;)V", "contentText", "", "getContentText", "()Ljava/lang/String;", BusinessSplashDefineKt.SPLASH_OPEN_EVENT_BACKGROUND, "Landroid/graphics/drawable/Drawable;", "getBackground", "()Landroid/graphics/drawable/Drawable;", "leftBackgroundColor", "", "getLeftBackgroundColor$core_apinkDebug", "()I", "rightBackgroundColor", "getRightBackgroundColor$core_apinkDebug", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    private abstract class Answer implements Status {
        public abstract int getLeftBackgroundColor$core_apinkDebug();

        public abstract int getRightBackgroundColor$core_apinkDebug();

        public Answer() {
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Status
        public String getContentText() {
            String string = ChameleonAnswerView.this.getContext().getString(bili.resource.homepage.R.string.homepage_global_string_42);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }

        @Override // tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView.Status
        public Drawable getBackground() {
            Drawable drawable = ResourcesCompat.getDrawable(ChameleonAnswerView.this.getResources(), R.drawable.bili_background_mine_ansering_status, ChameleonAnswerView.this.getContext().getTheme());
            LayerDrawable drawable2 = (LayerDrawable) (drawable != null ? drawable.mutate() : null);
            if (drawable2 != null) {
                Drawable findDrawableByLayerId = drawable2.findDrawableByLayerId(R.id.left);
                Intrinsics.checkNotNull(findDrawableByLayerId, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                GradientDrawable drawableLeft = (GradientDrawable) findDrawableByLayerId;
                drawableLeft.setColor(getLeftBackgroundColor$core_apinkDebug());
                Drawable findDrawableByLayerId2 = drawable2.findDrawableByLayerId(R.id.right);
                Intrinsics.checkNotNull(findDrawableByLayerId2, "null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                GradientDrawable drawableRight = (GradientDrawable) findDrawableByLayerId2;
                drawableRight.setColor(getRightBackgroundColor$core_apinkDebug());
            }
            return drawable2;
        }
    }

    /* compiled from: ChameleonAnswerView.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Ltv/danmaku/bili/ui/main2/mine/widgets/ChameleonAnswerView$Companion;", "", "<init>", "()V", "ANSWER_DEFAULT_URL", "", "ANSWER_SPMID_MAIN", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Neurons.reportClick(false, "main.my-information.answer-in-guide.0.click", MapsKt.mapOf(TuplesKt.to("type", MineVipServiceKt.VIP_REPORT_VALUE_NORMAL)));
        Uri parse = Uri.parse(MainRouteUris.ROUTE_URI_ANSWER);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(...)");
        RouteRequest request = new RouteRequest.Builder(parse).extras(new Function1() { // from class: tv.danmaku.bili.ui.main2.mine.widgets.ChameleonAnswerView$$ExternalSyntheticLambda0
            public final Object invoke(Object obj) {
                Unit onClick$lambda$0;
                onClick$lambda$0 = ChameleonAnswerView.onClick$lambda$0(ChameleonAnswerView.this, (MutableBundleLike) obj);
                return onClick$lambda$0;
            }
        }).build();
        BLRouter.routeTo$default(request, (Context) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onClick$lambda$0(ChameleonAnswerView this$0, MutableBundleLike $this$extras) {
        String str;
        Intrinsics.checkNotNullParameter($this$extras, "$this$extras");
        if (TextUtils.isEmpty(this$0.mJumpUrl)) {
            str = "https://www.bilibili.com/h5/newbie/entry?navhide=1";
        } else {
            str = this$0.mJumpUrl;
            Intrinsics.checkNotNull(str);
        }
        $this$extras.put(AnswerActivity.KEY_DYNAMIC_URL, str);
        $this$extras.put(AnswerActivity.KEY_DYNAMIC_URL_SPMID, ANSWER_SPMID_MAIN);
        return Unit.INSTANCE;
    }
}