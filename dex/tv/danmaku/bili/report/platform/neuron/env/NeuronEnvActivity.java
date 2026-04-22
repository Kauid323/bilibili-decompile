package tv.danmaku.bili.report.platform.neuron.env;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import com.bilibili.droid.thread.HandlerThreads;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.neuron.api.Neurons;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseToolbarActivity;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.report.biz.api.produce.model.ReportEvent;

/* compiled from: NeuronEnvActivity.kt */
@Deprecated(message = "使用 BuriedPointEnvActivity")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0016H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Ltv/danmaku/bili/report/platform/neuron/env/NeuronEnvActivity;", "Lcom/bilibili/lib/ui/BaseToolbarActivity;", "<init>", "()V", "switch", "Landroid/widget/Switch;", "editText", "Landroid/widget/EditText;", "uuidText", "Landroid/widget/TextView;", "TAG", "", "queryKeyIp", "queryKeyRealTime", "queryKeyUUID", "queryKeyHost", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "parseConfig", "intent", "Landroid/content/Intent;", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class NeuronEnvActivity extends BaseToolbarActivity {
    public static final int $stable = 8;
    private EditText editText;

    /* renamed from: switch  reason: not valid java name */
    private Switch f11switch;
    private TextView uuidText;
    private final String TAG = "neuron.redirect.ui.new";
    private final String queryKeyIp = "ip";
    private final String queryKeyRealTime = "realtime";
    private final String queryKeyUUID = "uuid";
    private final String queryKeyHost = ReportEvent.Tag.HOST;

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bili_app_activity_neuron_env);
        showBackButton();
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        parseConfig(intent);
        this.f11switch = (Switch) findViewById(R.id.switcher);
        this.editText = (EditText) findViewById(R.id.et_ip);
        this.uuidText = (TextView) findViewById(R.id.tv_neuron_test_page_uuid);
        Switch r0 = this.f11switch;
        Intrinsics.checkNotNull(r0);
        boolean z = false;
        r0.setChecked(BLKV.getBLSharedPreferences$default((Context) this, "neuron_config", true, 0, 4, (Object) null).getBoolean("is_testing", false));
        String text = BLKV.getBLSharedPreferences$default((Context) this, "neuron_config", true, 0, 4, (Object) null).getString("custom_ip", (String) null);
        String str = text;
        if (!((str == null || StringsKt.isBlank(str)) ? true : true)) {
            EditText editText = this.editText;
            Intrinsics.checkNotNull(editText);
            editText.setText(text);
        }
        TextView textView = this.uuidText;
        if (textView != null) {
            textView.setText(BLKV.getBLSharedPreferences$default((Context) this, "neuron_config", true, 0, 4, (Object) null).getString("test_uuid", ""));
        }
        Switch r1 = this.f11switch;
        Intrinsics.checkNotNull(r1);
        r1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: tv.danmaku.bili.report.platform.neuron.env.NeuronEnvActivity$$ExternalSyntheticLambda1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                Neurons.setTesting(z2);
            }
        });
        EditText editText2 = this.editText;
        Intrinsics.checkNotNull(editText2);
        editText2.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: tv.danmaku.bili.report.platform.neuron.env.NeuronEnvActivity$$ExternalSyntheticLambda2
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView2, int i, KeyEvent keyEvent) {
                boolean onCreate$lambda$1;
                onCreate$lambda$1 = NeuronEnvActivity.onCreate$lambda$1(NeuronEnvActivity.this, textView2, i, keyEvent);
                return onCreate$lambda$1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreate$lambda$1(NeuronEnvActivity this$0, TextView textView, int action, KeyEvent keyEvent) {
        if (action == 6) {
            EditText editText = this$0.editText;
            Intrinsics.checkNotNull(editText);
            Neurons.setCustomReportIP(editText.getText().toString());
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0023 A[Catch: Exception -> 0x007e, TryCatch #0 {Exception -> 0x007e, blocks: (B:2:0x0001, B:4:0x0008, B:6:0x0010, B:8:0x0017, B:14:0x0023, B:16:0x0028, B:18:0x0030, B:20:0x0035, B:26:0x0041, B:30:0x004a, B:32:0x004f, B:35:0x0059, B:36:0x005f, B:38:0x0064, B:42:0x006d), top: B:47:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0028 A[Catch: Exception -> 0x007e, TryCatch #0 {Exception -> 0x007e, blocks: (B:2:0x0001, B:4:0x0008, B:6:0x0010, B:8:0x0017, B:14:0x0023, B:16:0x0028, B:18:0x0030, B:20:0x0035, B:26:0x0041, B:30:0x004a, B:32:0x004f, B:35:0x0059, B:36:0x005f, B:38:0x0064, B:42:0x006d), top: B:47:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0041 A[Catch: Exception -> 0x007e, TryCatch #0 {Exception -> 0x007e, blocks: (B:2:0x0001, B:4:0x0008, B:6:0x0010, B:8:0x0017, B:14:0x0023, B:16:0x0028, B:18:0x0030, B:20:0x0035, B:26:0x0041, B:30:0x004a, B:32:0x004f, B:35:0x0059, B:36:0x005f, B:38:0x0064, B:42:0x006d), top: B:47:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004f A[Catch: Exception -> 0x007e, TryCatch #0 {Exception -> 0x007e, blocks: (B:2:0x0001, B:4:0x0008, B:6:0x0010, B:8:0x0017, B:14:0x0023, B:16:0x0028, B:18:0x0030, B:20:0x0035, B:26:0x0041, B:30:0x004a, B:32:0x004f, B:35:0x0059, B:36:0x005f, B:38:0x0064, B:42:0x006d), top: B:47:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0059 A[Catch: Exception -> 0x007e, TryCatch #0 {Exception -> 0x007e, blocks: (B:2:0x0001, B:4:0x0008, B:6:0x0010, B:8:0x0017, B:14:0x0023, B:16:0x0028, B:18:0x0030, B:20:0x0035, B:26:0x0041, B:30:0x004a, B:32:0x004f, B:35:0x0059, B:36:0x005f, B:38:0x0064, B:42:0x006d), top: B:47:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0064 A[Catch: Exception -> 0x007e, TryCatch #0 {Exception -> 0x007e, blocks: (B:2:0x0001, B:4:0x0008, B:6:0x0010, B:8:0x0017, B:14:0x0023, B:16:0x0028, B:18:0x0030, B:20:0x0035, B:26:0x0041, B:30:0x004a, B:32:0x004f, B:35:0x0059, B:36:0x005f, B:38:0x0064, B:42:0x006d), top: B:47:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006d A[Catch: Exception -> 0x007e, TRY_LEAVE, TryCatch #0 {Exception -> 0x007e, blocks: (B:2:0x0001, B:4:0x0008, B:6:0x0010, B:8:0x0017, B:14:0x0023, B:16:0x0028, B:18:0x0030, B:20:0x0035, B:26:0x0041, B:30:0x004a, B:32:0x004f, B:35:0x0059, B:36:0x005f, B:38:0x0064, B:42:0x006d), top: B:47:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void parseConfig(Intent intent) {
        boolean z;
        String str;
        boolean z2;
        String str2;
        try {
            Uri uri = intent.getData();
            String ip = uri != null ? uri.getQueryParameter(this.queryKeyIp) : null;
            String str3 = ip;
            boolean z3 = false;
            if (str3 != null && !StringsKt.isBlank(str3)) {
                z = false;
                if (!z) {
                    Neurons.setCustomReportIP(ip);
                }
                String realtimeStr = uri == null ? uri.getQueryParameter(this.queryKeyRealTime) : null;
                str = realtimeStr;
                if (str != null && !StringsKt.isBlank(str)) {
                    z2 = false;
                    if (!z2) {
                        boolean realtime = 1 == Integer.parseInt(realtimeStr);
                        Neurons.setTesting(realtime);
                    }
                    final String uuid = uri == null ? uri.getQueryParameter(this.queryKeyUUID) : null;
                    final String host = uri != null ? uri.getQueryParameter(this.queryKeyHost) : null;
                    str2 = uuid;
                    if (str2 != null || StringsKt.isBlank(str2)) {
                        z3 = true;
                    }
                    if (z3) {
                        Neurons.setUUID(uuid);
                        HandlerThreads.getHandler(2).post(new Runnable() { // from class: tv.danmaku.bili.report.platform.neuron.env.NeuronEnvActivity$$ExternalSyntheticLambda0
                            @Override // java.lang.Runnable
                            public final void run() {
                                NeuronEnvActivity.parseConfig$lambda$0(uuid, host);
                            }
                        });
                        return;
                    }
                    return;
                }
                z2 = true;
                if (!z2) {
                }
                if (uri == null) {
                }
                if (uri != null) {
                }
                str2 = uuid;
                if (str2 != null) {
                }
                z3 = true;
                if (z3) {
                }
            }
            z = true;
            if (!z) {
            }
            if (uri == null) {
            }
            str = realtimeStr;
            if (str != null) {
                z2 = false;
                if (!z2) {
                }
                if (uri == null) {
                }
                if (uri != null) {
                }
                str2 = uuid;
                if (str2 != null) {
                }
                z3 = true;
                if (z3) {
                }
            }
            z2 = true;
            if (!z2) {
            }
            if (uri == null) {
            }
            if (uri != null) {
            }
            str2 = uuid;
            if (str2 != null) {
            }
            z3 = true;
            if (z3) {
            }
        } catch (Exception e) {
            BLog.e(this.TAG, e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void parseConfig$lambda$0(String $uuid, String $host) {
        NeuronEnvTestPageUtils.Companion.sendScanMessage($uuid, $host);
    }
}