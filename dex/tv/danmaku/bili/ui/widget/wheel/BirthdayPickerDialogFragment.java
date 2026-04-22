package tv.danmaku.bili.ui.widget.wheel;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bilibili.app.auth.R;
import com.bilibili.app.auth.databinding.DialogBirthdayPickerFragmentBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BirthdayPickerDialogFragment.kt */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J&\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0012H\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016J\u001e\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007J\u0016\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u000eJ\u000e\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0010J\u0018\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020.J\b\u0010/\u001a\u00020\u0014H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Ltv/danmaku/bili/ui/widget/wheel/BirthdayPickerDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/bilibili/app/auth/databinding/DialogBirthdayPickerFragmentBinding;", "initYear", "", "Ljava/lang/Integer;", "initMonth", "initDay", "minYear", "maxYear", "titleText", "", "onChooseListener", "Ltv/danmaku/bili/ui/widget/wheel/OnBirthdayChooseListener;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onStart", "onDestroyView", "setInitDate", "year", "month", "day", "setYearRange", "min", "max", "setTitle", "text", "setOnChooseListener", "listener", "safeShow", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "ensureArgs", "Companion", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BirthdayPickerDialogFragment extends DialogFragment {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_INIT_DAY = "init_day";
    private static final String KEY_INIT_MONTH = "init_month";
    private static final String KEY_INIT_YEAR = "init_year";
    private static final String KEY_MAX_YEAR = "max_year";
    private static final String KEY_MIN_YEAR = "min_year";
    private static final String KEY_TITLE = "title_text";
    private static final String TAG = "BirthdayPickerDialogFragment";
    private DialogBirthdayPickerFragmentBinding binding;
    private Integer initDay;
    private Integer initMonth;
    private Integer initYear;
    private Integer maxYear;
    private Integer minYear;
    private OnBirthdayChooseListener onChooseListener;
    private CharSequence titleText;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            dismissAllowingStateLoss();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        int view2 = R.layout.dialog_birthday_picker_fragment;
        View it = inflater.inflate(view2, container, false);
        this.binding = DialogBirthdayPickerFragmentBinding.bind(it);
        return it;
    }

    public void onViewCreated(View view2, Bundle savedInstanceState) {
        BirthdayPickerView picker;
        Intrinsics.checkNotNullParameter(view2, "view");
        super.onViewCreated(view2, savedInstanceState);
        DialogBirthdayPickerFragmentBinding dialogBirthdayPickerFragmentBinding = this.binding;
        if (dialogBirthdayPickerFragmentBinding == null || (picker = dialogBirthdayPickerFragmentBinding.birthdayPicker) == null) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        picker.bindLifecycleScope((CoroutineScope) LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner));
        Bundle args = getArguments();
        if (args != null) {
            if (args.containsKey(KEY_MIN_YEAR) || args.containsKey(KEY_MAX_YEAR)) {
                Integer min = Integer.valueOf(args.getInt(KEY_MIN_YEAR, Integer.MIN_VALUE));
                if ((min.intValue() != Integer.MIN_VALUE ? 1 : 0) == 0) {
                    min = null;
                }
                Integer valueOf = Integer.valueOf(args.getInt(KEY_MAX_YEAR, Integer.MIN_VALUE));
                Integer max = valueOf.intValue() != Integer.MIN_VALUE ? valueOf : null;
                if (min != null && max != null) {
                    picker.setYearRange(min.intValue(), max.intValue());
                }
            }
            if (args.containsKey(KEY_INIT_YEAR) && args.containsKey(KEY_INIT_MONTH) && args.containsKey(KEY_INIT_DAY)) {
                int y = args.getInt(KEY_INIT_YEAR);
                int m = args.getInt(KEY_INIT_MONTH);
                int d = args.getInt(KEY_INIT_DAY);
                picker.setDate(y, m, d, false);
            }
            CharSequence it = args.getCharSequence(KEY_TITLE);
            if (it != null) {
                picker.setTitle(it);
            }
        }
        if (this.minYear != null && this.maxYear != null) {
            Integer num = this.minYear;
            Intrinsics.checkNotNull(num);
            int intValue = num.intValue();
            Integer num2 = this.maxYear;
            Intrinsics.checkNotNull(num2);
            picker.setYearRange(intValue, num2.intValue());
        }
        if (this.initYear != null && this.initMonth != null && this.initDay != null) {
            Integer num3 = this.initYear;
            Intrinsics.checkNotNull(num3);
            int intValue2 = num3.intValue();
            Integer num4 = this.initMonth;
            Intrinsics.checkNotNull(num4);
            int intValue3 = num4.intValue();
            Integer num5 = this.initDay;
            Intrinsics.checkNotNull(num5);
            picker.setDate(intValue2, intValue3, num5.intValue(), false);
        }
        CharSequence it2 = this.titleText;
        if (it2 != null) {
            picker.setTitle(it2);
        }
        picker.setOnCancelListener(new Function0() { // from class: tv.danmaku.bili.ui.widget.wheel.BirthdayPickerDialogFragment$$ExternalSyntheticLambda0
            public final Object invoke() {
                Unit onViewCreated$lambda$2;
                onViewCreated$lambda$2 = BirthdayPickerDialogFragment.onViewCreated$lambda$2(BirthdayPickerDialogFragment.this);
                return onViewCreated$lambda$2;
            }
        });
        picker.setOnConfirmListener(new Function3() { // from class: tv.danmaku.bili.ui.widget.wheel.BirthdayPickerDialogFragment$$ExternalSyntheticLambda1
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                Unit onViewCreated$lambda$3;
                onViewCreated$lambda$3 = BirthdayPickerDialogFragment.onViewCreated$lambda$3(BirthdayPickerDialogFragment.this, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
                return onViewCreated$lambda$3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$2(BirthdayPickerDialogFragment this$0) {
        this$0.dismissAllowingStateLoss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onViewCreated$lambda$3(BirthdayPickerDialogFragment this$0, int y, int m, int d) {
        OnBirthdayChooseListener onBirthdayChooseListener = this$0.onChooseListener;
        if (onBirthdayChooseListener != null) {
            onBirthdayChooseListener.onChoose(y, m, d);
        }
        this$0.dismissAllowingStateLoss();
        return Unit.INSTANCE;
    }

    public void onStart() {
        Window w;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (w = dialog.getWindow()) != null) {
            w.setBackgroundDrawable(new ColorDrawable(0));
            w.setLayout(-1, -2);
            w.setGravity(80);
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    public final BirthdayPickerDialogFragment setInitDate(int year, int month, int day) {
        BirthdayPickerDialogFragment $this$setInitDate_u24lambda_u240 = this;
        $this$setInitDate_u24lambda_u240.initYear = Integer.valueOf(year);
        $this$setInitDate_u24lambda_u240.initMonth = Integer.valueOf(month);
        $this$setInitDate_u24lambda_u240.initDay = Integer.valueOf(day);
        Bundle $this$setInitDate_u24lambda_u240_u240 = $this$setInitDate_u24lambda_u240.ensureArgs();
        $this$setInitDate_u24lambda_u240_u240.putInt(KEY_INIT_YEAR, year);
        $this$setInitDate_u24lambda_u240_u240.putInt(KEY_INIT_MONTH, month);
        $this$setInitDate_u24lambda_u240_u240.putInt(KEY_INIT_DAY, day);
        return this;
    }

    public final BirthdayPickerDialogFragment setYearRange(int min, int max) {
        BirthdayPickerDialogFragment $this$setYearRange_u24lambda_u240 = this;
        $this$setYearRange_u24lambda_u240.minYear = Integer.valueOf(min);
        $this$setYearRange_u24lambda_u240.maxYear = Integer.valueOf(max);
        Bundle $this$setYearRange_u24lambda_u240_u240 = $this$setYearRange_u24lambda_u240.ensureArgs();
        $this$setYearRange_u24lambda_u240_u240.putInt(KEY_MIN_YEAR, min);
        $this$setYearRange_u24lambda_u240_u240.putInt(KEY_MAX_YEAR, max);
        return this;
    }

    public final BirthdayPickerDialogFragment setTitle(CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        BirthdayPickerDialogFragment $this$setTitle_u24lambda_u240 = this;
        $this$setTitle_u24lambda_u240.titleText = text;
        Bundle $this$setTitle_u24lambda_u240_u240 = $this$setTitle_u24lambda_u240.ensureArgs();
        $this$setTitle_u24lambda_u240_u240.putCharSequence(KEY_TITLE, text);
        return this;
    }

    public final BirthdayPickerDialogFragment setOnChooseListener(OnBirthdayChooseListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        BirthdayPickerDialogFragment $this$setOnChooseListener_u24lambda_u240 = this;
        $this$setOnChooseListener_u24lambda_u240.onChooseListener = listener;
        return this;
    }

    public static /* synthetic */ void safeShow$default(BirthdayPickerDialogFragment birthdayPickerDialogFragment, FragmentManager fragmentManager, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = TAG;
        }
        birthdayPickerDialogFragment.safeShow(fragmentManager, str);
    }

    public final void safeShow(FragmentManager manager, String tag) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            super.show(manager, tag);
        } catch (IllegalStateException e) {
            BLog.e(TAG, "show error : " + e);
        }
    }

    private final Bundle ensureArgs() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            Bundle it = new Bundle();
            setArguments(it);
            return it;
        }
        return arguments;
    }

    /* compiled from: BirthdayPickerDialogFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/ui/widget/wheel/BirthdayPickerDialogFragment$Companion;", "", "<init>", "()V", "TAG", "", "KEY_INIT_YEAR", "KEY_INIT_MONTH", "KEY_INIT_DAY", "KEY_MIN_YEAR", "KEY_MAX_YEAR", "KEY_TITLE", "newInstance", "Ltv/danmaku/bili/ui/widget/wheel/BirthdayPickerDialogFragment;", "auth_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BirthdayPickerDialogFragment newInstance() {
            return new BirthdayPickerDialogFragment();
        }
    }
}