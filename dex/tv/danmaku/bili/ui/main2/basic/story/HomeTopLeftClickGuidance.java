package tv.danmaku.bili.ui.main2.basic.story;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.widget.PopupWindowCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bilibili.app.comm.list.widget.utils.ListExtentionsKt;
import com.bilibili.app.comm.list.widget.utils.SharedPreferencesField;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.ui.main2.reporter.NavigationReporter;
import tv.danmaku.bili.ui.main2.resource.MainResourceManager;
import tv.danmaku.bili.ui.main2.userprotocol.ReportEvent;

/* compiled from: HomeTopLeftClickGuidance.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0010X\u008a\u008e\u0002"}, d2 = {"Ltv/danmaku/bili/ui/main2/basic/story/HomeTopLeftClickGuidance;", "Landroid/widget/PopupWindow;", "<init>", "()V", ReportEvent.EVENT_TYPE_SHOW, "", "anchorView", "Landroid/view/View;", "bubble", "Ltv/danmaku/bili/ui/main2/resource/MainResourceManager$TopLeftBubble;", "recordId", "", "fragment", "Landroidx/fragment/app/Fragment;", "core_apinkDebug", "displayed", ""}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HomeTopLeftClickGuidance extends PopupWindow {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty0(new MutablePropertyReference0Impl(HomeTopLeftClickGuidance.class, "displayed", "<v#0>", 0))};
    public static final int $stable = 8;

    public final void show(View anchorView, MainResourceManager.TopLeftBubble bubble, String recordId, final Fragment fragment) {
        TextView textView;
        Intrinsics.checkNotNullParameter(anchorView, "anchorView");
        Intrinsics.checkNotNullParameter(bubble, "bubble");
        Intrinsics.checkNotNullParameter(recordId, "recordId");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        if (!fragment.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
            BLog.i("[Home]HomeTopLeftClickGuidance", "home fragment invisible");
            return;
        }
        fragment.getLifecycle().addObserver(new DefaultLifecycleObserver() { // from class: tv.danmaku.bili.ui.main2.basic.story.HomeTopLeftClickGuidance$show$1
            public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.-CC.$default$onCreate(this, lifecycleOwner);
            }

            public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.-CC.$default$onDestroy(this, lifecycleOwner);
            }

            public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.-CC.$default$onPause(this, lifecycleOwner);
            }

            public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.-CC.$default$onResume(this, lifecycleOwner);
            }

            public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
                DefaultLifecycleObserver.-CC.$default$onStart(this, lifecycleOwner);
            }

            public void onStop(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                DefaultLifecycleObserver.-CC.$default$onStop(this, owner);
                fragment.getLifecycle().removeObserver((LifecycleObserver) this);
                this.dismiss();
            }
        });
        boolean z = false;
        SharedPreferencesField displayed$delegate = new SharedPreferencesField(recordId, false, (SharedPreferences) null, 4, (DefaultConstructorMarker) null);
        if (show$lambda$0(displayed$delegate)) {
            return;
        }
        setAnimationStyle(R.style.HomeStoryEntranceGuidePopup);
        setContentView(LayoutInflater.from(anchorView.getContext()).inflate(R.layout.bili_app_list_home_topleft_click_guidance, (ViewGroup) null));
        setWidth(-2);
        setHeight(-2);
        String it = bubble.text;
        String str = it;
        if (str == null || StringsKt.isBlank(str)) {
            z = true;
        }
        if (z) {
            it = null;
        }
        if (it != null) {
            String it2 = it;
            View contentView = getContentView();
            if (contentView != null && (textView = (TextView) contentView.findViewById(R.id.notice)) != null) {
                textView.setText(it2);
            }
        }
        setOutsideTouchable(true);
        setSoftInputMode(2);
        setBackgroundDrawable(new ColorDrawable());
        PopupWindowCompat.showAsDropDown(this, anchorView, ListExtentionsKt.toPx(-4), ListExtentionsKt.toPx(-3), 8388611);
        NavigationReporter.reportHomeAvatarGuideShow(bubble);
        show$lambda$1(displayed$delegate, true);
        BuildersKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new HomeTopLeftClickGuidance$show$4(this, null), 3, (Object) null);
    }

    private static final boolean show$lambda$0(SharedPreferencesField<Boolean> sharedPreferencesField) {
        return ((Boolean) sharedPreferencesField.getValue((Object) null, $$delegatedProperties[0])).booleanValue();
    }

    private static final void show$lambda$1(SharedPreferencesField<Boolean> sharedPreferencesField, boolean z) {
        sharedPreferencesField.setValue((Object) null, $$delegatedProperties[0], Boolean.valueOf(z));
    }
}