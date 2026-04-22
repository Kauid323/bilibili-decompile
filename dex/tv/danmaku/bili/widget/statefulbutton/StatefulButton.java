package tv.danmaku.bili.widget.statefulbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.content.res.AppCompatResources;
import com.bilibili.lib.widget.R;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.TintImageView;
import com.bilibili.magicasakura.widgets.TintLinearLayout;
import com.bilibili.magicasakura.widgets.TintTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerimpl.toast.left.viewholder.ActionMessageWithAnimationVH;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: StatefulButton.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u000bB\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\fJ\u0010\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020bH\u0002J\u0010\u0010c\u001a\u00020`2\u0006\u0010d\u001a\u00020eH\u0017J&\u0010f\u001a\u00020`2\b\b\u0001\u0010g\u001a\u00020\b2\b\b\u0001\u0010h\u001a\u00020\b2\b\b\u0001\u0010i\u001a\u00020\bH\u0002J\u000e\u0010j\u001a\u00020`2\u0006\u0010[\u001a\u00020DJ\u0010\u0010j\u001a\u00020`2\b\b\u0001\u0010k\u001a\u00020\bJ\u0012\u0010l\u001a\u00020`2\b\b\u0001\u0010m\u001a\u00020\bH\u0017R&\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR&\u0010\u001f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R&\u0010\"\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u001e\u0010%\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0012R\u001e\u0010(\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010\u0012R\u001e\u0010+\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010\u0012R\u001e\u0010.\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0010\"\u0004\b0\u0010\u0012R\u001e\u00101\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0010\"\u0004\b3\u0010\u0012R\u001e\u00104\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0010\"\u0004\b6\u0010\u0012R&\u00107\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0010\"\u0004\b9\u0010\u0012R&\u0010:\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0010\"\u0004\b<\u0010\u0012R\u001e\u0010=\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0010\"\u0004\b?\u0010\u0012R\u001e\u0010@\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0010\"\u0004\bB\u0010\u0012R\u001c\u0010C\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001c\u0010I\u001a\u0004\u0018\u00010DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010F\"\u0004\bK\u0010HR\u001e\u0010L\u001a\u00020M8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u001a\u0010R\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0010\"\u0004\bT\u0010\u0012R\u0014\u0010U\u001a\u00020VX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\bW\u0010XR\u000e\u0010Y\u001a\u00020ZX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010[\u001a\u00020\\X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^¨\u0006n"}, d2 = {"Ltv/danmaku/bili/widget/statefulbutton/StatefulButton;", "Lcom/bilibili/magicasakura/widgets/TintLinearLayout;", "Ltv/danmaku/bili/widget/statefulbutton/IStatefulWidget;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "positiveBackground", "getPositiveBackground", "()I", "setPositiveBackground", "(I)V", "negativeBackground", "getNegativeBackground", "setNegativeBackground", "positiveBackgroundDrawable", "Landroid/graphics/drawable/Drawable;", "getPositiveBackgroundDrawable", "()Landroid/graphics/drawable/Drawable;", "setPositiveBackgroundDrawable", "(Landroid/graphics/drawable/Drawable;)V", "negativeBackgroundDrawable", "getNegativeBackgroundDrawable", "setNegativeBackgroundDrawable", "positiveTextColor", "getPositiveTextColor", "setPositiveTextColor", "negativeTextColor", "getNegativeTextColor", "setNegativeTextColor", "positiveTextColorInt", "getPositiveTextColorInt", "setPositiveTextColorInt", "negativeTextColorInt", "getNegativeTextColorInt", "setNegativeTextColorInt", "positiveIcon", "getPositiveIcon", "setPositiveIcon", "negativeIcon", "getNegativeIcon", "setNegativeIcon", "iconSize", "getIconSize", "setIconSize", "iconMargin", "getIconMargin", "setIconMargin", "positiveIconTint", "getPositiveIconTint", "setPositiveIconTint", "negativeIconTint", "getNegativeIconTint", "setNegativeIconTint", "positiveIconTintColorInt", "getPositiveIconTintColorInt", "setPositiveIconTintColorInt", "negativeIconTintColorInt", "getNegativeIconTintColorInt", "setNegativeIconTintColorInt", "positiveText", "", "getPositiveText", "()Ljava/lang/CharSequence;", "setPositiveText", "(Ljava/lang/CharSequence;)V", "negativeText", "getNegativeText", "setNegativeText", "textSize", "", "getTextSize", "()F", "setTextSize", "(F)V", "textMaxLine", "getTextMaxLine", "setTextMaxLine", "icon", "Lcom/bilibili/magicasakura/widgets/TintImageView;", "getIcon", "()Lcom/bilibili/magicasakura/widgets/TintImageView;", "iconLp", "Landroid/widget/LinearLayout$LayoutParams;", "text", "Lcom/bilibili/magicasakura/widgets/TintTextView;", "getText", "()Lcom/bilibili/magicasakura/widgets/TintTextView;", "init", "", "attr", "Landroid/content/res/TypedArray;", "updateUI", "newState", "", "setIcon", "iconRes", "colorRes", "colorInt", "setText", "textRes", "setButtonStyle", "styleRes", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public class StatefulButton extends TintLinearLayout implements IStatefulWidget {
    private final TintImageView icon;
    private final LinearLayout.LayoutParams iconLp;
    private int iconMargin;
    private int iconSize;
    private int negativeBackground;
    private Drawable negativeBackgroundDrawable;
    private int negativeIcon;
    private int negativeIconTint;
    private int negativeIconTintColorInt;
    private CharSequence negativeText;
    private int negativeTextColor;
    private int negativeTextColorInt;
    private int positiveBackground;
    private Drawable positiveBackgroundDrawable;
    private int positiveIcon;
    private int positiveIconTint;
    private int positiveIconTintColorInt;
    private CharSequence positiveText;
    private int positiveTextColor;
    private int positiveTextColorInt;
    private final TintTextView text;
    private int textMaxLine;
    private float textSize;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatefulButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.positiveText = "";
        this.negativeText = "";
        this.textMaxLine = ActionMessageWithAnimationVH.INVALID_COLOR_INT;
        this.icon = new TintImageView(context);
        this.iconLp = new LinearLayout.LayoutParams(-2, -2);
        this.text = new TintTextView(context);
        TypedArray attr = context.obtainStyledAttributes(attrs, R.styleable.StatefulButton);
        Intrinsics.checkNotNullExpressionValue(attr, "obtainStyledAttributes(...)");
        init(attr);
        attr.recycle();
        setOrientation(0);
        setGravity(17);
        this.icon.setLayoutParams(this.iconLp);
        addView((View) this.icon);
        this.text.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.text.setEllipsize(TextUtils.TruncateAt.END);
        addView((View) this.text);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatefulButton(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StatefulButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final int getPositiveBackground() {
        return this.positiveBackground;
    }

    public final void setPositiveBackground(int value) {
        this.positiveBackground = value;
        this.positiveBackgroundDrawable = null;
    }

    public final int getNegativeBackground() {
        return this.negativeBackground;
    }

    public final void setNegativeBackground(int value) {
        this.negativeBackground = value;
        this.negativeBackgroundDrawable = null;
    }

    public final Drawable getPositiveBackgroundDrawable() {
        return this.positiveBackgroundDrawable;
    }

    public final void setPositiveBackgroundDrawable(Drawable drawable) {
        this.positiveBackgroundDrawable = drawable;
    }

    public final Drawable getNegativeBackgroundDrawable() {
        return this.negativeBackgroundDrawable;
    }

    public final void setNegativeBackgroundDrawable(Drawable drawable) {
        this.negativeBackgroundDrawable = drawable;
    }

    public final int getPositiveTextColor() {
        return this.positiveTextColor;
    }

    public final void setPositiveTextColor(int value) {
        this.positiveTextColor = value;
        this.positiveTextColorInt = 0;
    }

    public final int getNegativeTextColor() {
        return this.negativeTextColor;
    }

    public final void setNegativeTextColor(int value) {
        this.negativeTextColor = value;
        this.negativeTextColorInt = 0;
    }

    public final int getPositiveTextColorInt() {
        return this.positiveTextColorInt;
    }

    public final void setPositiveTextColorInt(int i) {
        this.positiveTextColorInt = i;
    }

    public final int getNegativeTextColorInt() {
        return this.negativeTextColorInt;
    }

    public final void setNegativeTextColorInt(int i) {
        this.negativeTextColorInt = i;
    }

    public final int getPositiveIcon() {
        return this.positiveIcon;
    }

    public final void setPositiveIcon(int i) {
        this.positiveIcon = i;
    }

    public final int getNegativeIcon() {
        return this.negativeIcon;
    }

    public final void setNegativeIcon(int i) {
        this.negativeIcon = i;
    }

    public final int getIconSize() {
        return this.iconSize;
    }

    public final void setIconSize(int i) {
        this.iconSize = i;
    }

    public final int getIconMargin() {
        return this.iconMargin;
    }

    public final void setIconMargin(int i) {
        this.iconMargin = i;
    }

    public final int getPositiveIconTint() {
        return this.positiveIconTint;
    }

    public final void setPositiveIconTint(int value) {
        this.positiveIconTint = value;
        this.positiveIconTintColorInt = 0;
    }

    public final int getNegativeIconTint() {
        return this.negativeIconTint;
    }

    public final void setNegativeIconTint(int value) {
        this.negativeIconTint = value;
        this.negativeIconTintColorInt = 0;
    }

    public final int getPositiveIconTintColorInt() {
        return this.positiveIconTintColorInt;
    }

    public final void setPositiveIconTintColorInt(int i) {
        this.positiveIconTintColorInt = i;
    }

    public final int getNegativeIconTintColorInt() {
        return this.negativeIconTintColorInt;
    }

    public final void setNegativeIconTintColorInt(int i) {
        this.negativeIconTintColorInt = i;
    }

    public final CharSequence getPositiveText() {
        return this.positiveText;
    }

    public final void setPositiveText(CharSequence charSequence) {
        this.positiveText = charSequence;
    }

    public final CharSequence getNegativeText() {
        return this.negativeText;
    }

    public final void setNegativeText(CharSequence charSequence) {
        this.negativeText = charSequence;
    }

    public final float getTextSize() {
        return this.textSize;
    }

    public final void setTextSize(float f) {
        this.textSize = f;
    }

    public final int getTextMaxLine() {
        return this.textMaxLine;
    }

    public final void setTextMaxLine(int i) {
        this.textMaxLine = i;
    }

    protected final TintImageView getIcon() {
        return this.icon;
    }

    protected final TintTextView getText() {
        return this.text;
    }

    private final void init(TypedArray attr) {
        setPositiveBackground(attr.getResourceId(R.styleable.StatefulButton_positiveBackground, 0));
        setNegativeBackground(attr.getResourceId(R.styleable.StatefulButton_negativeBackground, 0));
        setPositiveTextColor(attr.getResourceId(R.styleable.StatefulButton_positiveTextColor, 0));
        setNegativeTextColor(attr.getResourceId(R.styleable.StatefulButton_negativeTextColor, 0));
        this.positiveIcon = attr.getResourceId(R.styleable.StatefulButton_positiveIcon, 0);
        this.negativeIcon = attr.getResourceId(R.styleable.StatefulButton_negativeIcon, 0);
        this.iconSize = attr.getDimensionPixelSize(R.styleable.StatefulButton_iconSize, 0);
        this.iconMargin = attr.getDimensionPixelSize(R.styleable.StatefulButton_iconMargin, 0);
        setPositiveIconTint(attr.getResourceId(R.styleable.StatefulButton_positiveIconTint, 0));
        setNegativeIconTint(attr.getResourceId(R.styleable.StatefulButton_negativeIconTint, 0));
        this.positiveText = attr.getText(R.styleable.StatefulButton_positiveText);
        this.negativeText = attr.getText(R.styleable.StatefulButton_negativeText);
        this.textSize = attr.getDimension(R.styleable.StatefulButton_textSize, 36.0f);
        this.textMaxLine = attr.getInt(R.styleable.StatefulButton_textMaxLines, this.textMaxLine);
        this.text.setMaxLines(this.textMaxLine);
        this.text.setTextSize(0, this.textSize);
    }

    @Override // tv.danmaku.bili.widget.statefulbutton.IStatefulWidget
    public void updateUI(boolean newState) {
        if (newState) {
            if (this.positiveBackgroundDrawable != null) {
                setBackground(this.positiveBackgroundDrawable);
            } else {
                setBackgroundResource(this.positiveBackground);
            }
            setIcon(this.positiveIcon, this.positiveIconTint, this.positiveIconTintColorInt);
            if (this.positiveTextColorInt != 0) {
                this.text.setTextColor(this.positiveTextColorInt);
            } else {
                this.text.setTextColorById(this.positiveTextColor);
            }
            this.text.setText(this.positiveText);
            return;
        }
        if (this.negativeBackgroundDrawable != null) {
            setBackground(this.negativeBackgroundDrawable);
        } else {
            setBackgroundResource(this.negativeBackground);
        }
        setIcon(this.negativeIcon, this.negativeIconTint, this.negativeIconTintColorInt);
        if (this.negativeTextColorInt != 0) {
            this.text.setTextColor(this.negativeTextColorInt);
        } else {
            this.text.setTextColorById(this.negativeTextColor);
        }
        this.text.setText(this.negativeText);
    }

    private final void setIcon(int iconRes, int colorRes, int colorInt) {
        if (iconRes != 0) {
            Drawable drawable = AppCompatResources.getDrawable(getContext(), iconRes);
            if (drawable != null) {
                drawable.setBounds(0, 0, this.iconSize, this.iconSize);
            }
            if (colorInt != 0 && drawable != null) {
                this.icon.setImageDrawable(ThemeUtils.tintDrawable(drawable, colorInt));
            } else {
                this.icon.setImageDrawable(drawable);
                this.icon.setImageTintList(colorRes);
            }
            if (this.iconSize != 0) {
                this.iconLp.width = this.iconSize;
                this.iconLp.height = this.iconSize;
            } else {
                this.iconLp.height = -2;
                this.iconLp.width = -2;
            }
            this.iconLp.rightMargin = this.iconMargin;
            this.icon.setVisibility(0);
            return;
        }
        this.icon.setVisibility(8);
    }

    public final void setText(CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text.setText(text);
    }

    public final void setText(int textRes) {
        this.text.setText(textRes);
    }

    public void setButtonStyle(int styleRes) {
        TypedArray attr = getContext().obtainStyledAttributes(styleRes, R.styleable.StatefulButton);
        Intrinsics.checkNotNullExpressionValue(attr, "obtainStyledAttributes(...)");
        init(attr);
        attr.recycle();
    }
}