package tv.danmaku.bili.core.test;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import com.bilibili.app.comm.list.widget.utils.SharedPreferencesField;
import com.bilibili.droid.ToastHelper;
import com.bilibili.list.test.AbsButtonTestItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import tv.danmaku.bili.BR;

/* compiled from: MainTestPageActivity.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Ltv/danmaku/bili/core/test/CleanTopLeftGuidanceRecord;", "Lcom/bilibili/list/test/AbsButtonTestItem;", "<init>", "()V", "<set-?>", "", "hasShowTopLeftClickGuidance", "getHasShowTopLeftClickGuidance", "()Z", "setHasShowTopLeftClickGuidance", "(Z)V", "hasShowTopLeftClickGuidance$delegate", "Lcom/bilibili/app/comm/list/widget/utils/SharedPreferencesField;", "getButtonText", "", "context", "Landroid/content/Context;", "onClick", "", "v", "Landroid/view/View;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CleanTopLeftGuidanceRecord extends AbsButtonTestItem {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(CleanTopLeftGuidanceRecord.class, "hasShowTopLeftClickGuidance", "getHasShowTopLeftClickGuidance()Z", 0))};
    public static final int $stable = AbsButtonTestItem.$stable | SharedPreferencesField.$stable;
    private final SharedPreferencesField hasShowTopLeftClickGuidance$delegate = new SharedPreferencesField("sp_has_shown_top_left_click_guidance", false, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);

    private final boolean getHasShowTopLeftClickGuidance() {
        return ((Boolean) this.hasShowTopLeftClickGuidance$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    private final void setHasShowTopLeftClickGuidance(boolean z) {
        this.hasShowTopLeftClickGuidance$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    public CharSequence getButtonText(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return "清除左上角点击引导记录";
    }

    public void onClick(View v) {
        setHasShowTopLeftClickGuidance(false);
        ToastHelper.showToastShort(v != null ? v.getContext() : null, "清除左上角点击引导记录成功");
    }
}