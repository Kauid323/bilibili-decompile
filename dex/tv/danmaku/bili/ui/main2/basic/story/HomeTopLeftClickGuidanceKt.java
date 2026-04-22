package tv.danmaku.bili.ui.main2.basic.story;

import android.content.SharedPreferences;
import com.bilibili.app.comm.list.widget.utils.SharedPreferencesField;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import tv.danmaku.bili.BR;

/* compiled from: HomeTopLeftClickGuidance.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005²\u0006\n\u0010\u0006\u001a\u00020\u0001X\u008a\u0084\u0002"}, d2 = {"canShowTopLeftClickGuidance", "", "recordId", "", "TAG", "core_apinkDebug", "displayed"}, k = 2, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HomeTopLeftClickGuidanceKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property0(new PropertyReference0Impl(HomeTopLeftClickGuidanceKt.class, "displayed", "<v#0>", 1))};
    private static final String TAG = "[Home]HomeTopLeftClickGuidance";

    public static final boolean canShowTopLeftClickGuidance(String recordId) {
        Intrinsics.checkNotNullParameter(recordId, "recordId");
        SharedPreferencesField displayed$delegate = new SharedPreferencesField(recordId, false, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);
        return !canShowTopLeftClickGuidance$lambda$0(displayed$delegate);
    }

    private static final boolean canShowTopLeftClickGuidance$lambda$0(SharedPreferencesField<Boolean> sharedPreferencesField) {
        return ((Boolean) sharedPreferencesField.getValue((Object) null, $$delegatedProperties[0])).booleanValue();
    }
}