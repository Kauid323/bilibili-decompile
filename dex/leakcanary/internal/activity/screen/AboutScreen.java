package leakcanary.internal.activity.screen;

import android.app.Application;
import android.content.Context;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import com.squareup.leakcanary.core.R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import leakcanary.internal.HeapDumpControl;
import leakcanary.internal.InternalLeakCanary;
import leakcanary.internal.navigation.Screen;
import leakcanary.internal.navigation.ViewsKt;

/* compiled from: AboutScreen.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"Lleakcanary/internal/activity/screen/AboutScreen;", "Lleakcanary/internal/navigation/Screen;", "()V", "createView", "Landroid/view/View;", "container", "Landroid/view/ViewGroup;", "updateHeapDumpTextView", "", "view", "Landroid/widget/TextView;", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class AboutScreen extends Screen {
    @Override // leakcanary.internal.navigation.Screen
    public View createView(ViewGroup container) {
        Intrinsics.checkParameterIsNotNull(container, "container");
        View $this$apply = ViewsKt.inflate(container, R.layout.leak_canary_about_screen);
        ViewsKt.getActivity($this$apply).setTitle($this$apply.getResources().getString(R.string.leak_canary_about_title, "2.13"));
        TextView aboutTextView = (TextView) $this$apply.findViewById(R.id.leak_canary_about_text);
        Intrinsics.checkExpressionValueIsNotNull(aboutTextView, "aboutTextView");
        aboutTextView.setMovementMethod(LinkMovementMethod.getInstance());
        Application application = ViewsKt.getActivity($this$apply).getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "application");
        CharSequence appName = application.getPackageManager().getApplicationLabel(application.getApplicationInfo());
        Intrinsics.checkExpressionValueIsNotNull(appName, "application.packageManag…lication.applicationInfo)");
        Context context = $this$apply.getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        String appPackageName = context.getPackageName();
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = $this$apply.getResources().getString(R.string.leak_canary_about_message);
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.st…eak_canary_about_message)");
        String format = String.format(string, Arrays.copyOf(new Object[]{appName, appPackageName}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        aboutTextView.setText(Html.fromHtml(format));
        final TextView heapDumpTextView = (TextView) $this$apply.findViewById(R.id.leak_canary_about_heap_dump_text);
        Intrinsics.checkExpressionValueIsNotNull(heapDumpTextView, "heapDumpTextView");
        updateHeapDumpTextView(heapDumpTextView);
        Switch heapDumpSwitchView = (Switch) $this$apply.findViewById(R.id.leak_canary_about_heap_dump_switch_button);
        Intrinsics.checkExpressionValueIsNotNull(heapDumpSwitchView, "heapDumpSwitchView");
        heapDumpSwitchView.setChecked(InternalLeakCanary.INSTANCE.getDumpEnabledInAboutScreen$leakcanary_android_core_release());
        heapDumpSwitchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: leakcanary.internal.activity.screen.AboutScreen$createView$$inlined$apply$lambda$1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton $noName_0, boolean checked) {
                InternalLeakCanary.INSTANCE.setDumpEnabledInAboutScreen$leakcanary_android_core_release(checked);
                AboutScreen aboutScreen = this;
                TextView heapDumpTextView2 = heapDumpTextView;
                Intrinsics.checkExpressionValueIsNotNull(heapDumpTextView2, "heapDumpTextView");
                aboutScreen.updateHeapDumpTextView(heapDumpTextView2);
            }
        });
        return $this$apply;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateHeapDumpTextView(TextView view) {
        String string;
        HeapDumpControl.ICanHazHeap iCanHasHeap = HeapDumpControl.INSTANCE.iCanHasHeap();
        if (iCanHasHeap instanceof HeapDumpControl.ICanHazHeap.Yup) {
            string = view.getResources().getString(R.string.leak_canary_heap_dump_enabled_text);
        } else if (iCanHasHeap instanceof HeapDumpControl.ICanHazHeap.Nope) {
            string = view.getResources().getString(R.string.leak_canary_heap_dump_disabled_text, ((HeapDumpControl.ICanHazHeap.Nope) iCanHasHeap).getReason().invoke());
        } else {
            throw new NoWhenBranchMatchedException();
        }
        view.setText(string);
    }
}