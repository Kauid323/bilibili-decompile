package tv.danmaku.bili.widget.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.bplus.followingcard.R;
import com.bilibili.bplus.followingcard.api.entity.GoodLikeInfo;
import com.bilibili.bplus.followingcard.helper.TextLinesCalculator;
import com.bilibili.magicasakura.utils.ThemeUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.bili.widget.VectorTextView;
import tv.danmaku.biliplayerv2.service.interact.core.model.DanmakuConfig;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: GoodLikeTextView.kt */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010$\u001a\u00020\u00182\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020)H\u0002J\u0018\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0+2\u0006\u0010,\u001a\u00020\nH\u0002J\b\u0010-\u001a\u00020\u001aH\u0002J\b\u0010.\u001a\u00020\u001aH\u0002J\u0010\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u000207H\u0014J\u0012\u00108\u001a\u00020\n2\b\b\u0001\u00109\u001a\u00020\nH\u0007J\u001c\u0010:\u001a\u00020\u00182\u0014\u0010;\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00180\u0017R\"\u0010\f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rj\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0016\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006<"}, d2 = {"Ltv/danmaku/bili/widget/widget/GoodLikeTextView;", "Ltv/danmaku/bili/widget/VectorTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mutableList", "Ljava/util/ArrayList;", "Lcom/bilibili/bplus/followingcard/api/entity/GoodLikeInfo$LikeUsersBean;", "Lkotlin/collections/ArrayList;", "mTextCalculator", "Lcom/bilibili/bplus/followingcard/helper/TextLinesCalculator;", "getMTextCalculator", "()Lcom/bilibili/bplus/followingcard/helper/TextLinesCalculator;", "mTextCalculator$delegate", "Lkotlin/Lazy;", "mListener", "Lkotlin/Function1;", "", "isInitDraw", "", "mIconSize", "mPaddingOfDrawable", "mTips", "", "colorResName", "getColorResName", "()I", "setColorResName", "(I)V", "init", "setTextContent", "data", "Lcom/bilibili/bplus/followingcard/api/entity/GoodLikeInfo;", "buildContent", "Landroid/text/SpannableStringBuilder;", "likeClickableSpan", "Ltv/danmaku/bili/widget/widget/LikeClickableSpan;", "i", "isContentToLong", "hasMoreSpace", "getFinallyTis", "remainSpace", "", "dispatchTouchEvent", "event", "Landroid/view/MotionEvent;", "onDraw", "canvas", "Landroid/graphics/Canvas;", "updateColor", "initColor", "setSpanItemClickListener", "listener", "followingCard_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class GoodLikeTextView extends VectorTextView {
    public static final int $stable = 8;
    private int colorResName;
    private boolean isInitDraw;
    private final int mIconSize;
    private Function1<? super GoodLikeInfo.LikeUsersBean, Unit> mListener;
    private int mPaddingOfDrawable;
    private final Lazy mTextCalculator$delegate;
    private String mTips;
    private final ArrayList<GoodLikeInfo.LikeUsersBean> mutableList;

    private final TextLinesCalculator getMTextCalculator() {
        return (TextLinesCalculator) this.mTextCalculator$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextLinesCalculator mTextCalculator_delegate$lambda$0(GoodLikeTextView this$0) {
        TextPaint paint = this$0.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "getPaint(...)");
        return new TextLinesCalculator(paint);
    }

    public final int getColorResName() {
        return this.colorResName;
    }

    public final void setColorResName(int i) {
        this.colorResName = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoodLikeTextView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mutableList = new ArrayList<>();
        this.mTextCalculator$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.widget.widget.GoodLikeTextView$$ExternalSyntheticLambda0
            public final Object invoke() {
                TextLinesCalculator mTextCalculator_delegate$lambda$0;
                mTextCalculator_delegate$lambda$0 = GoodLikeTextView.mTextCalculator_delegate$lambda$0(GoodLikeTextView.this);
                return mTextCalculator_delegate$lambda$0;
            }
        });
        this.isInitDraw = true;
        this.mIconSize = ListExtentionsKt.toPx(12.0f);
        this.mPaddingOfDrawable = ListExtentionsKt.toPx(6.0f);
        this.mTips = "";
        this.colorResName = -1;
        init(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoodLikeTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mutableList = new ArrayList<>();
        this.mTextCalculator$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.widget.widget.GoodLikeTextView$$ExternalSyntheticLambda0
            public final Object invoke() {
                TextLinesCalculator mTextCalculator_delegate$lambda$0;
                mTextCalculator_delegate$lambda$0 = GoodLikeTextView.mTextCalculator_delegate$lambda$0(GoodLikeTextView.this);
                return mTextCalculator_delegate$lambda$0;
            }
        });
        this.isInitDraw = true;
        this.mIconSize = ListExtentionsKt.toPx(12.0f);
        this.mPaddingOfDrawable = ListExtentionsKt.toPx(6.0f);
        this.mTips = "";
        this.colorResName = -1;
        init(context, attrs);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GoodLikeTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mutableList = new ArrayList<>();
        this.mTextCalculator$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.widget.widget.GoodLikeTextView$$ExternalSyntheticLambda0
            public final Object invoke() {
                TextLinesCalculator mTextCalculator_delegate$lambda$0;
                mTextCalculator_delegate$lambda$0 = GoodLikeTextView.mTextCalculator_delegate$lambda$0(GoodLikeTextView.this);
                return mTextCalculator_delegate$lambda$0;
            }
        });
        this.isInitDraw = true;
        this.mIconSize = ListExtentionsKt.toPx(12.0f);
        this.mPaddingOfDrawable = ListExtentionsKt.toPx(6.0f);
        this.mTips = "";
        this.colorResName = -1;
        init(context, attrs);
    }

    private final void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.GoodLikeTextView);
            Intrinsics.checkNotNullExpressionValue(array, "obtainStyledAttributes(...)");
            this.colorResName = array.getResourceId(R.styleable.GoodLikeTextView_upNameColor, this.colorResName);
            array.recycle();
        }
        setMovementMethod(LinkMovementMethod.getInstance());
        setHighlightColor(getResources().getColor(17170445));
    }

    public final void setTextContent(GoodLikeInfo data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (this.mutableList.size() != 0) {
            this.mutableList.clear();
        }
        String str = data.display_text;
        if (str == null) {
            str = "";
        }
        this.mTips = " " + str;
        ArrayList<GoodLikeInfo.LikeUsersBean> arrayList = this.mutableList;
        List list = data.likeUsers;
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        arrayList.addAll(list);
        this.isInitDraw = true;
        invalidate();
    }

    private final SpannableStringBuilder buildContent() {
        String str;
        float totalWidth = DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN;
        int actualViewWidth = ((getWidth() - getPaddingLeft()) - getPaddingRight()) - (this.mIconSize + this.mPaddingOfDrawable);
        SpannableStringBuilder result = new SpannableStringBuilder();
        int start = 0;
        String finallyText = "...";
        float ellipWidth = getPaint().measureText("...");
        float dashWidth = getPaint().measureText(GoodLikeTextViewKt.BETWEEN_DASH);
        int i = 0;
        this.isInitDraw = false;
        String str2 = "";
        if (isContentToLong() && hasMoreSpace()) {
            int i2 = 0;
            int size = this.mutableList.size();
            for (int i3 = 1; i2 < size && i2 <= i3; i3 = 1) {
                GoodLikeInfo.LikeUsersBean likeUsersBean = this.mutableList.get(i2);
                String name = likeUsersBean != null ? likeUsersBean.uname : null;
                if (name == null) {
                    name = "";
                }
                if (!StringsKt.isBlank(name)) {
                    if (i2 == i3) {
                        GoodLikeInfo.LikeUsersBean likeUsersBean2 = this.mutableList.get(i2 - 1);
                        String str3 = likeUsersBean2 != null ? likeUsersBean2.uname : null;
                        if (((str3 == null || StringsKt.isBlank(str3)) ? i3 : 0) == 0) {
                            result.append((CharSequence) GoodLikeTextViewKt.BETWEEN_DASH);
                            totalWidth += dashWidth;
                        }
                    }
                    float itemWidth = Layout.getDesiredWidth(name, getPaint());
                    if (itemWidth > actualViewWidth - totalWidth) {
                        break;
                    }
                    result.append((CharSequence) name);
                    LikeClickableSpan spanClick = likeClickableSpan(i2);
                    result.setSpan(spanClick, start, result.length(), 0);
                    start += name.length();
                    totalWidth = Layout.getDesiredWidth(result, getPaint());
                }
                i2++;
            }
            result.append((CharSequence) getFinallyTis((actualViewWidth - Layout.getDesiredWidth(result, getPaint())) - ellipWidth));
        } else if (isContentToLong() && !hasMoreSpace()) {
            int i4 = 0;
            int size2 = this.mutableList.size();
            while (true) {
                if (i4 >= size2 || i4 > 1) {
                    break;
                }
                GoodLikeInfo.LikeUsersBean likeUsersBean3 = this.mutableList.get(i4);
                String name2 = likeUsersBean3 != null ? likeUsersBean3.uname : null;
                if (name2 == null) {
                    name2 = str2;
                }
                if (StringsKt.isBlank(name2)) {
                    str = str2;
                } else {
                    if (i4 == 1) {
                        GoodLikeInfo.LikeUsersBean likeUsersBean4 = this.mutableList.get(i4 - 1);
                        String str4 = likeUsersBean4 != null ? likeUsersBean4.uname : null;
                        if (((str4 == null || StringsKt.isBlank(str4)) ? 1 : i) == 0) {
                            result.append((CharSequence) GoodLikeTextViewKt.BETWEEN_DASH);
                            totalWidth += dashWidth;
                        }
                    }
                    float itemWidth2 = Layout.getDesiredWidth(name2, getPaint());
                    if (itemWidth2 <= (actualViewWidth - totalWidth) - ellipWidth) {
                        result.append((CharSequence) name2);
                        LikeClickableSpan spanClick2 = likeClickableSpan(i4);
                        str = str2;
                        result.setSpan(spanClick2, start, result.length(), i);
                        start += name2.length();
                        totalWidth = Layout.getDesiredWidth(result, getPaint());
                    } else {
                        int textEnd = name2.length();
                        StaticLayout layout = getMTextCalculator().width((int) ((actualViewWidth - totalWidth) - ellipWidth)).layout(name2, 0, textEnd);
                        switch (layout != null ? layout.getLineCount() : 0) {
                            case 0:
                                break;
                            case 1:
                                finallyText = name2;
                                break;
                            default:
                                Intrinsics.checkNotNull(layout);
                                String substring = name2.substring(0, layout.getLineEnd(0));
                                Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                                finallyText = substring + "...";
                                break;
                        }
                        result.append((CharSequence) finallyText);
                        LikeClickableSpan spanClick3 = likeClickableSpan(i4);
                        result.setSpan(spanClick3, start, result.length(), 0);
                        int length = start + finallyText.length();
                    }
                }
                i4++;
                str2 = str;
                i = 0;
            }
            Unit unit = Unit.INSTANCE;
        } else {
            int size3 = this.mutableList.size();
            for (int i5 = 0; i5 < size3 && i5 <= 1; i5++) {
                GoodLikeInfo.LikeUsersBean likeUsersBean5 = this.mutableList.get(i5);
                String name3 = likeUsersBean5 != null ? likeUsersBean5.uname : null;
                if (name3 == null) {
                    name3 = "";
                }
                if (!StringsKt.isBlank(name3)) {
                    if (i5 == 1) {
                        GoodLikeInfo.LikeUsersBean likeUsersBean6 = this.mutableList.get(i5 - 1);
                        String str5 = likeUsersBean6 != null ? likeUsersBean6.uname : null;
                        if (!(str5 == null || StringsKt.isBlank(str5))) {
                            result.append((CharSequence) GoodLikeTextViewKt.BETWEEN_DASH);
                            totalWidth += dashWidth;
                        }
                    }
                    float itemWidth3 = Layout.getDesiredWidth(name3, getPaint());
                    if (itemWidth3 > actualViewWidth - totalWidth) {
                        break;
                    }
                    result.append((CharSequence) name3);
                    LikeClickableSpan spanClick4 = likeClickableSpan(i5);
                    result.setSpan(spanClick4, start, result.length(), 0);
                    start += name3.length();
                    totalWidth = Layout.getDesiredWidth(result, getPaint());
                }
            }
            result.append((CharSequence) this.mTips);
        }
        return result;
    }

    private final LikeClickableSpan<GoodLikeInfo.LikeUsersBean> likeClickableSpan(int i) {
        final GoodLikeInfo.LikeUsersBean likeUsersBean = this.mutableList.get(i);
        return new LikeClickableSpan<GoodLikeInfo.LikeUsersBean>(likeUsersBean) { // from class: tv.danmaku.bili.widget.widget.GoodLikeTextView$likeClickableSpan$1
            @Override // tv.danmaku.bili.widget.widget.LikeClickableSpan
            public void onDataClick(GoodLikeInfo.LikeUsersBean t) {
                Function1 function1;
                function1 = GoodLikeTextView.this.mListener;
                if (function1 != null) {
                    function1.invoke(t);
                }
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint ds) {
                Intrinsics.checkNotNullParameter(ds, "ds");
                ds.setColor(GoodLikeTextView.this.updateColor(GoodLikeTextView.this.getColorResName()));
                ds.bgColor = 0;
                ds.setUnderlineText(false);
                ds.setFakeBoldText(true);
            }
        };
    }

    private final boolean isContentToLong() {
        StringBuilder result = new StringBuilder();
        int size = this.mutableList.size();
        for (int i = 0; i < size && i < 2; i++) {
            GoodLikeInfo.LikeUsersBean likeUsersBean = this.mutableList.get(i);
            String str = likeUsersBean != null ? likeUsersBean.uname : null;
            if (str == null) {
                str = "";
            }
            result.append(str);
            if (i == 0) {
                result.append(GoodLikeTextViewKt.BETWEEN_DASH);
            }
        }
        result.append(this.mTips);
        return Layout.getDesiredWidth(result, getPaint()) > ((float) ((((getWidth() - this.mIconSize) - this.mPaddingOfDrawable) - getPaddingLeft()) - getPaddingRight()));
    }

    private final boolean hasMoreSpace() {
        StringBuilder result = new StringBuilder();
        int size = this.mutableList.size();
        for (int i = 0; i < size && i < 2; i++) {
            GoodLikeInfo.LikeUsersBean likeUsersBean = this.mutableList.get(i);
            String str = likeUsersBean != null ? likeUsersBean.uname : null;
            if (str == null) {
                str = "";
            }
            result.append(str);
            if (i == 0) {
                result.append(GoodLikeTextViewKt.BETWEEN_DASH);
            }
        }
        int i2 = getWidth();
        return ((float) ((((i2 - this.mIconSize) - this.mPaddingOfDrawable) - getPaddingLeft()) - getPaddingRight())) - Layout.getDesiredWidth(result, getPaint()) > getPaint().measureText("...");
    }

    private final String getFinallyTis(float remainSpace) {
        int end = this.mTips.length();
        StaticLayout layout = getMTextCalculator().width((int) remainSpace).layout(this.mTips, 0, end);
        switch (layout != null ? layout.getLineCount() : 0) {
            case 0:
                return "...";
            case 1:
                return this.mTips + "...";
            default:
                String str = this.mTips;
                Intrinsics.checkNotNull(layout);
                return ((Object) str.subSequence(0, layout.getLineEnd(0))) + "...";
        }
    }

    public boolean dispatchTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event.getX() >= DanmakuConfig.DANMAKU_SCREEN_DOMAIN_UNKNOWN && event.getX() <= getPaddingLeft() + this.mIconSize + this.mPaddingOfDrawable) {
            return true;
        }
        return super.dispatchTouchEvent(event);
    }

    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.isInitDraw) {
            setText(buildContent());
        }
    }

    public final int updateColor(int initColor) {
        if (initColor == -1) {
            return -1;
        }
        return ThemeUtils.getColorById(getContext(), initColor, getViewThemeId());
    }

    public final void setSpanItemClickListener(Function1<? super GoodLikeInfo.LikeUsersBean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "listener");
        this.mListener = function1;
    }
}