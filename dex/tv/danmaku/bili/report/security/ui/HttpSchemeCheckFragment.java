package tv.danmaku.bili.report.security.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import com.bilibili.base.BiliGlobalPreferenceHelper;
import com.bilibili.lib.foundation.FoundationAlias;
import com.bilibili.lib.ui.BaseToolbarFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.report.security.internal.config.HttpSchemeCheckConfig;

/* compiled from: HttpSchemeCheckFragment.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/report/security/ui/HttpSchemeCheckFragment;", "Lcom/bilibili/lib/ui/BaseToolbarFragment;", "<init>", "()V", "switch", "Landroidx/appcompat/widget/SwitchCompat;", "sp", "Landroid/content/SharedPreferences;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class HttpSchemeCheckFragment extends BaseToolbarFragment {
    public static final int $stable = 8;
    private final SharedPreferences sp;

    /* renamed from: switch  reason: not valid java name */
    private SwitchCompat f12switch;

    public HttpSchemeCheckFragment() {
        SharedPreferences bLKVSharedPreference = BiliGlobalPreferenceHelper.getBLKVSharedPreference(FoundationAlias.getFapp());
        Intrinsics.checkNotNullExpressionValue(bLKVSharedPreference, "getBLKVSharedPreference(...)");
        this.sp = bLKVSharedPreference;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View rootView = inflater.inflate(R.layout.bili_app_fragment_debug_http_check, container, false);
        SwitchCompat findViewById = rootView.findViewById(R.id.switcher);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(...)");
        this.f12switch = findViewById;
        Intrinsics.checkNotNull(rootView);
        return rootView;
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setTitle(bili.resource.homepage.R.string.homepage_global_string_231);
        SwitchCompat switchCompat = this.f12switch;
        SwitchCompat switchCompat2 = null;
        if (switchCompat == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switch");
            switchCompat = null;
        }
        switchCompat.setChecked(this.sp.getBoolean(HttpSchemeCheckConfig.DEBUG_TOAST_ENABLE_KEY, true));
        SwitchCompat switchCompat3 = this.f12switch;
        if (switchCompat3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("switch");
        } else {
            switchCompat2 = switchCompat3;
        }
        switchCompat2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.report.security.ui.HttpSchemeCheckFragment$$ExternalSyntheticLambda0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                HttpSchemeCheckFragment.onViewCreated$lambda$0(HttpSchemeCheckFragment.this, compoundButton, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$0(HttpSchemeCheckFragment this$0, CompoundButton compoundButton, boolean isChecked) {
        this$0.sp.edit().putBoolean(HttpSchemeCheckConfig.DEBUG_TOAST_ENABLE_KEY, isChecked).apply();
    }
}