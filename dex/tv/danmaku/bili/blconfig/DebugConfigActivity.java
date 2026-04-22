package tv.danmaku.bili.blconfig;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.SwitchCompat;
import com.bilibili.lib.blconfig.ConfigManager;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import com.bilibili.magicasakura.widgets.TintToolbar;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;

/* compiled from: DebugConfigActivity.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u000bH\u0002J\u000e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Ltv/danmaku/bili/blconfig/DebugConfigActivity;", "Lcom/bilibili/lib/ui/BaseToolbarActivity;", "<init>", "()V", "mToolBar", "Lcom/bilibili/magicasakura/widgets/TintToolbar;", "mSwitcher", "Landroidx/appcompat/widget/SwitchCompat;", "mTvContent", "Landroid/widget/TextView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "triggerLazyLoad", "handleData", "switchDetail", "v", "Landroid/view/View;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class DebugConfigActivity extends BaseToolbarActivity {
    public static final int $stable = 8;
    private SwitchCompat mSwitcher;
    private TintToolbar mToolBar;
    private TextView mTvContent;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleData();
        setContentView(R.layout.bili_app_activity_ffconfig_debugger);
        ensureToolbar();
        showBackButton();
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle("blconfig-debug");
        }
        this.mToolBar = findViewById(R.id.nav_top_bar);
        this.mSwitcher = findViewById(R.id.switch_button);
        this.mTvContent = (TextView) findViewById(R.id.tv_content);
        SwitchCompat switchCompat = this.mSwitcher;
        if (switchCompat != null) {
            switchCompat.setChecked(DebugConfigActivityKt.isFFConfigDebugged());
        }
        SwitchCompat switchCompat2 = this.mSwitcher;
        if (switchCompat2 != null) {
            switchCompat2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.blconfig.DebugConfigActivity$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    DebugConfigActivity.onCreate$lambda$0(compoundButton, z);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(CompoundButton compoundButton, boolean isChecked) {
        DebugConfigActivityKt.setFFConfigDebugged(isChecked);
        if (isChecked) {
            NoopDebugConfigManager.INSTANCE.attachNoopConfigManager();
        } else {
            NoopDebugConfigManager.INSTANCE.detachNoopConfigManager();
        }
    }

    private final void triggerLazyLoad() {
        ConfigManager.Companion.config();
        ConfigManager.Companion.ab();
    }

    private final void handleData() {
        Uri data;
        String data2;
        Object obj;
        Intent intent = getIntent();
        if (intent != null && (data = intent.getData()) != null && (data2 = data.getQueryParameter("data")) != null) {
            if (!(data2.length() == 0)) {
                String data3 = URLDecoder.decode(data2, "UTF-8");
                try {
                    Result.Companion companion = Result.Companion;
                    DebugConfigActivity debugConfigActivity = this;
                    obj = Result.constructor-impl(new JSONObject(data3));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                if (Result.isFailure-impl(obj)) {
                    obj = null;
                }
                if (((JSONObject) obj) == null) {
                    return;
                }
                DebugConfigActivityKt.setFFConfigDebugged(true);
                SwitchCompat switchCompat = this.mSwitcher;
                if (switchCompat != null) {
                    switchCompat.setChecked(true);
                }
                DebugConfigHelperKt.hookConfigManagerIfNeed();
                triggerLazyLoad();
                try {
                    NoopDebugConfigManager noopDebugConfigManager = NoopDebugConfigManager.INSTANCE;
                    Intrinsics.checkNotNull(data3);
                    noopDebugConfigManager.setData(data3);
                } catch (Exception e) {
                    BLog.e("FFConfigDebugger", "setJsonData：error json = " + data3);
                }
            }
        }
    }

    public final void switchDetail(View v) {
        TextView textView;
        Intrinsics.checkNotNullParameter(v, "v");
        TextView it = this.mTvContent;
        if (it != null) {
            if (it.getVisibility() == 8) {
                textView = v instanceof TextView ? (TextView) v : null;
                if (textView != null) {
                    textView.setText("点击收起详情");
                }
                it.setVisibility(0);
                triggerLazyLoad();
                it.setText(NoopDebugConfigManager.INSTANCE.getData());
                return;
            }
            textView = v instanceof TextView ? (TextView) v : null;
            if (textView != null) {
                textView.setText("点击展开详情");
            }
            it.setVisibility(8);
        }
    }
}