package tv.danmaku.bili.ui.widget.wheel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bilibili.app.auth.R;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BirthdayPickerView.kt */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020,JU\u0010-\u001a\u00020\"2M\u0010.\u001aI\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\"\u0018\u00010\u001cJU\u0010/\u001a\u00020\"2M\u0010.\u001aI\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\"\u0018\u00010\u001cJ\u0016\u00100\u001a\u00020\"2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010%J\u0016\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007J\u000e\u00104\u001a\u00020\"2\u0006\u00105\u001a\u000206J\u0018\u00107\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000708J(\u00109\u001a\u00020\"2\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u00072\b\b\u0002\u0010=\u001a\u00020>J\b\u0010?\u001a\u00020\u0007H\u0002J\b\u0010@\u001a\u00020\u0007H\u0002J\b\u0010A\u001a\u00020\u0007H\u0002J\b\u0010B\u001a\u00020\"H\u0002J\u0018\u0010C\u001a\u00020\u00072\u0006\u0010:\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u0007H\u0002J\u0010\u0010D\u001a\u00020>2\u0006\u0010:\u001a\u00020\u0007H\u0002J\u0018\u0010E\u001a\u00020\"2\u0006\u0010F\u001a\u00020\u00072\u0006\u0010G\u001a\u00020\u0007H\u0014J\u0010\u0010H\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u0007H\u0002J\u0010\u0010H\u001a\u00020J2\u0006\u0010I\u001a\u00020JH\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000RU\u0010\u001b\u001aI\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\"\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000RU\u0010#\u001aI\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\"\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070'X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Ltv/danmaku/bili/ui/widget/wheel/BirthdayPickerView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "headerBar", "Landroid/widget/LinearLayout;", "btnCancel", "Landroid/widget/TextView;", "btnConfirm", "tvTitle", "wheelsRow", "yearWheel", "Ltv/danmaku/bili/ui/widget/wheel/WheelView;", "monthWheel", "dayWheel", "minYear", "maxYear", "todayYear", "todayMonth", "todayDay", "onDateChanged", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "y", "m", "d", "", "onConfirm", "onCancel", "Lkotlin/Function0;", "years", "", "months", "days", "bindLifecycleScope", "scope", "Lkotlinx/coroutines/CoroutineScope;", "setOnDateChangedListener", "listener", "setOnConfirmListener", "setOnCancelListener", "setYearRange", "min", "max", "setTitle", "text", "", "getSelectedDate", "Lkotlin/Triple;", "setDate", "year", "month", "day", "smooth", "", "getYear", "getMonth", "getDay", "ensureMonthAndDayAdapters", "daysInMonth", "isLeapYear", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "dp", "v", "", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BirthdayPickerView extends FrameLayout {
    private final TextView btnCancel;
    private final TextView btnConfirm;
    private final WheelView<Integer> dayWheel;
    private List<Integer> days;
    private final LinearLayout headerBar;
    private int maxYear;
    private int minYear;
    private final WheelView<Integer> monthWheel;
    private List<Integer> months;
    private Function0<Unit> onCancel;
    private Function3<? super Integer, ? super Integer, ? super Integer, Unit> onConfirm;
    private Function3<? super Integer, ? super Integer, ? super Integer, Unit> onDateChanged;
    private final int todayDay;
    private final int todayMonth;
    private final int todayYear;
    private final TextView tvTitle;
    private final LinearLayout wheelsRow;
    private final WheelView<Integer> yearWheel;
    private List<Integer> years;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BirthdayPickerView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BirthdayPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BirthdayPickerView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BirthdayPickerView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        Intrinsics.checkNotNullParameter(context, "context");
        this.todayYear = Calendar.getInstance().get(1);
        this.todayMonth = Calendar.getInstance().get(2) + 1;
        this.todayDay = Calendar.getInstance().get(5);
        this.months = CollectionsKt.toList(new IntRange(1, 12));
        this.days = CollectionsKt.toList(new IntRange(1, 31));
        LayoutInflater.from(context).inflate(R.layout.auth_birthday_picker_view, (ViewGroup) this, true);
        Calendar cal = Calendar.getInstance();
        this.maxYear = cal.get(1);
        this.minYear = this.maxYear - 120;
        this.years = CollectionsKt.toList(new IntRange(this.minYear, this.maxYear));
        View findViewById = findViewById(R.id.auth_header_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.headerBar = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R.id.auth_btn_cancel);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(...)");
        this.btnCancel = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.auth_btn_confirm);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(...)");
        this.btnConfirm = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.auth_tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(...)");
        this.tvTitle = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.auth_wheels_row);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(...)");
        this.wheelsRow = (LinearLayout) findViewById5;
        View findViewById6 = findViewById(R.id.auth_wheel_year);
        Intrinsics.checkNotNull(findViewById6, "null cannot be cast to non-null type tv.danmaku.bili.ui.widget.wheel.WheelView<kotlin.Int>");
        WheelView yw = (WheelView) findViewById6;
        View findViewById7 = findViewById(R.id.auth_wheel_month);
        Intrinsics.checkNotNull(findViewById7, "null cannot be cast to non-null type tv.danmaku.bili.ui.widget.wheel.WheelView<kotlin.Int>");
        WheelView mw = (WheelView) findViewById7;
        View findViewById8 = findViewById(R.id.auth_wheel_day);
        Intrinsics.checkNotNull(findViewById8, "null cannot be cast to non-null type tv.danmaku.bili.ui.widget.wheel.WheelView<kotlin.Int>");
        WheelView dw = (WheelView) findViewById8;
        this.yearWheel = yw;
        this.monthWheel = mw;
        this.dayWheel = dw;
        this.btnCancel.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.widget.wheel.BirthdayPickerView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BirthdayPickerView._init_$lambda$0(BirthdayPickerView.this, view2);
            }
        });
        this.btnConfirm.setOnClickListener(new View.OnClickListener() { // from class: tv.danmaku.bili.ui.widget.wheel.BirthdayPickerView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                BirthdayPickerView._init_$lambda$1(BirthdayPickerView.this, view2);
            }
        });
        Iterable $this$forEach$iv = CollectionsKt.listOf(new WheelView[]{this.yearWheel, this.monthWheel, this.dayWheel});
        for (Object element$iv : $this$forEach$iv) {
            WheelView wheel = (WheelView) element$iv;
            wheel.setLoop(false);
            wheel.setItemsVisibleCount(7);
            wheel.setTextSize(22.0f);
            wheel.setTextColorOut(ContextCompat.getColor(context, com.bilibili.lib.theme.R.color.Text3));
            wheel.setTextColorCenter(ContextCompat.getColor(context, com.bilibili.lib.theme.R.color.Text1));
        }
        WheelView.setAdapter$default(this.yearWheel, new NumberWheelAdapter(this.years), 0, 2, null);
        WheelView.setAdapter$default(this.monthWheel, new NumberWheelAdapter(this.months), 0, 2, null);
        WheelView.setAdapter$default(this.dayWheel, new NumberWheelAdapter(this.days), 0, 2, null);
        this.yearWheel.setOnItemSelectedListener(new OnItemSelectedListener() { // from class: tv.danmaku.bili.ui.widget.wheel.BirthdayPickerView$$ExternalSyntheticLambda2
            @Override // tv.danmaku.bili.ui.widget.wheel.OnItemSelectedListener
            public final void onItemSelected(int i) {
                BirthdayPickerView._init_$lambda$3(BirthdayPickerView.this, i);
            }
        });
        this.monthWheel.setOnItemSelectedListener(new OnItemSelectedListener() { // from class: tv.danmaku.bili.ui.widget.wheel.BirthdayPickerView$$ExternalSyntheticLambda3
            @Override // tv.danmaku.bili.ui.widget.wheel.OnItemSelectedListener
            public final void onItemSelected(int i) {
                BirthdayPickerView._init_$lambda$4(BirthdayPickerView.this, i);
            }
        });
        this.dayWheel.setOnItemSelectedListener(new OnItemSelectedListener() { // from class: tv.danmaku.bili.ui.widget.wheel.BirthdayPickerView$$ExternalSyntheticLambda4
            @Override // tv.danmaku.bili.ui.widget.wheel.OnItemSelectedListener
            public final void onItemSelected(int i) {
                BirthdayPickerView._init_$lambda$5(BirthdayPickerView.this, i);
            }
        });
        setDate(this.maxYear, cal.get(2) + 1, cal.get(5), false);
    }

    public /* synthetic */ BirthdayPickerView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(BirthdayPickerView this$0, View it) {
        Function0<Unit> function0 = this$0.onCancel;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(BirthdayPickerView this$0, View it) {
        Triple<Integer, Integer, Integer> selectedDate = this$0.getSelectedDate();
        int y = ((Number) selectedDate.component1()).intValue();
        int m = ((Number) selectedDate.component2()).intValue();
        int d = ((Number) selectedDate.component3()).intValue();
        Function3<? super Integer, ? super Integer, ? super Integer, Unit> function3 = this$0.onConfirm;
        if (function3 != null) {
            function3.invoke(Integer.valueOf(y), Integer.valueOf(m), Integer.valueOf(d));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(BirthdayPickerView this$0, int i) {
        this$0.ensureMonthAndDayAdapters();
        Function3<? super Integer, ? super Integer, ? super Integer, Unit> function3 = this$0.onDateChanged;
        if (function3 != null) {
            function3.invoke(Integer.valueOf(this$0.getYear()), Integer.valueOf(this$0.getMonth()), Integer.valueOf(this$0.getDay()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4(BirthdayPickerView this$0, int i) {
        this$0.ensureMonthAndDayAdapters();
        Function3<? super Integer, ? super Integer, ? super Integer, Unit> function3 = this$0.onDateChanged;
        if (function3 != null) {
            function3.invoke(Integer.valueOf(this$0.getYear()), Integer.valueOf(this$0.getMonth()), Integer.valueOf(this$0.getDay()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$5(BirthdayPickerView this$0, int i) {
        Function3<? super Integer, ? super Integer, ? super Integer, Unit> function3 = this$0.onDateChanged;
        if (function3 != null) {
            function3.invoke(Integer.valueOf(this$0.getYear()), Integer.valueOf(this$0.getMonth()), Integer.valueOf(this$0.getDay()));
        }
    }

    public final void bindLifecycleScope(CoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        this.yearWheel.bindLifecycleScope(scope);
        this.monthWheel.bindLifecycleScope(scope);
        this.dayWheel.bindLifecycleScope(scope);
    }

    public final void setOnDateChangedListener(Function3<? super Integer, ? super Integer, ? super Integer, Unit> function3) {
        this.onDateChanged = function3;
    }

    public final void setOnConfirmListener(Function3<? super Integer, ? super Integer, ? super Integer, Unit> function3) {
        this.onConfirm = function3;
    }

    public final void setOnCancelListener(Function0<Unit> function0) {
        this.onCancel = function0;
    }

    public final void setYearRange(int min, int max) {
        if (!(min <= max)) {
            throw new IllegalArgumentException("minYear must be <= maxYear".toString());
        }
        this.minYear = min;
        this.maxYear = max;
        this.years = CollectionsKt.toList(new IntRange(this.minYear, this.maxYear));
        int y = RangesKt.coerceIn(getYear(), this.minYear, this.maxYear);
        this.yearWheel.setAdapter(new NumberWheelAdapter(this.years), this.years.indexOf(Integer.valueOf(y)));
        ensureMonthAndDayAdapters();
    }

    public final void setTitle(CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.tvTitle.setText(text);
    }

    public final Triple<Integer, Integer, Integer> getSelectedDate() {
        return new Triple<>(Integer.valueOf(getYear()), Integer.valueOf(getMonth()), Integer.valueOf(getDay()));
    }

    public static /* synthetic */ void setDate$default(BirthdayPickerView birthdayPickerView, int i, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 8) != 0) {
            z = true;
        }
        birthdayPickerView.setDate(i, i2, i3, z);
    }

    public final void setDate(int year, int month, int day, boolean smooth) {
        int y = RangesKt.coerceIn(year, this.minYear, this.maxYear);
        this.yearWheel.setAdapter(new NumberWheelAdapter(this.years), this.years.indexOf(Integer.valueOf(y)));
        int maxMonth = y == this.todayYear ? this.todayMonth : 12;
        List newMonths = CollectionsKt.toList(new IntRange(1, maxMonth));
        int targetMonth = RangesKt.coerceIn(month, 1, maxMonth);
        this.months = newMonths;
        this.monthWheel.setAdapter(new NumberWheelAdapter(this.months), this.months.indexOf(Integer.valueOf(targetMonth)));
        int maxDOverall = daysInMonth(y, targetMonth);
        int maxDayThisSelection = (y == this.todayYear && targetMonth == this.todayMonth) ? this.todayDay : maxDOverall;
        int targetDay = RangesKt.coerceIn(day, 1, maxDayThisSelection);
        this.days = CollectionsKt.toList(new IntRange(1, maxDayThisSelection));
        this.dayWheel.setAdapter(new NumberWheelAdapter(this.days), targetDay - 1);
        if (smooth) {
            this.yearWheel.onItemSelected();
            this.monthWheel.onItemSelected();
            this.dayWheel.onItemSelected();
        }
    }

    private final int getYear() {
        Integer num = (Integer) CollectionsKt.getOrNull(this.years, this.yearWheel.getCurrentItem());
        return num != null ? num.intValue() : ((Number) CollectionsKt.first(this.years)).intValue();
    }

    private final int getMonth() {
        Integer num = (Integer) CollectionsKt.getOrNull(this.months, this.monthWheel.getCurrentItem());
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    private final int getDay() {
        Integer num = (Integer) CollectionsKt.getOrNull(CollectionsKt.toList(new IntRange(1, this.days.size())), this.dayWheel.getCurrentItem());
        if (num != null) {
            return num.intValue();
        }
        return 1;
    }

    private final void ensureMonthAndDayAdapters() {
        int y = getYear();
        int oldMonth = getMonth();
        int maxMonth = y == this.todayYear ? this.todayMonth : 12;
        List newMonths = CollectionsKt.toList(new IntRange(1, maxMonth));
        int adjustedMonth = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(oldMonth, maxMonth), 1);
        if (!Intrinsics.areEqual(this.months, newMonths)) {
            this.months = newMonths;
            this.monthWheel.setAdapter(new NumberWheelAdapter(this.months), this.months.indexOf(Integer.valueOf(adjustedMonth)));
        } else if (oldMonth != adjustedMonth) {
            this.monthWheel.setAdapter(new NumberWheelAdapter(this.months), this.months.indexOf(Integer.valueOf(adjustedMonth)));
        }
        int oldDay = getDay();
        int maxDOverall = daysInMonth(y, adjustedMonth);
        int maxDayThisSelection = (y == this.todayYear && adjustedMonth == this.todayMonth) ? this.todayDay : maxDOverall;
        List newDays = CollectionsKt.toList(new IntRange(1, maxDayThisSelection));
        int adjustedDay = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(oldDay, maxDayThisSelection), 1);
        if (!Intrinsics.areEqual(this.days, newDays)) {
            this.days = newDays;
            this.dayWheel.setAdapter(new NumberWheelAdapter(this.days), adjustedDay - 1);
        } else if (oldDay != adjustedDay) {
            this.dayWheel.setAdapter(new NumberWheelAdapter(this.days), adjustedDay - 1);
        }
    }

    private final int daysInMonth(int year, int month) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
            default:
                return 30;
        }
    }

    private final boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private final int dp(int v) {
        return (int) (v * getResources().getDisplayMetrics().density);
    }

    private final float dp(float v) {
        return getResources().getDisplayMetrics().density * v;
    }
}