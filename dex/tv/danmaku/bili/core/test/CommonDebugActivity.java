package tv.danmaku.bili.core.test;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.ContextCompat;
import bolts.Task;
import com.bilibili.app.lib.abtest.ExpServiceFactory;
import com.bilibili.droid.ToastHelper;
import com.bilibili.droid.thread.BThreadPoolExecutor;
import com.bilibili.droid.thread.BThreadPoolType;
import com.bilibili.lib.blrouter.BLRouter;
import com.bilibili.lib.blrouter.RouteRequest;
import com.bilibili.lib.blrouter.RouteRequestKt;
import com.bilibili.lib.storage.StorageConfig;
import com.bilibili.lib.storage.StorageEvent;
import com.bilibili.lib.storage.StorageManager;
import com.bilibili.lib.storage.StorageTrimCallback;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.bilibili.lib.ui.BaseAppCompatActivity;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tv.danmaku.android.log.BLog;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.R;
import tv.danmaku.bili.report.misaka.MisakaHelper;
import tv.danmaku.bili.ui.main2.reporter.MineReporter;

/* compiled from: CommonDebugActivity.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u0012\u0010!\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0002J\u0018\u0010'\u001a\u00020\u001e2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a¨\u0006,"}, d2 = {"Ltv/danmaku/bili/core/test/CommonDebugActivity;", "Lcom/bilibili/lib/ui/BaseAppCompatActivity;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "btn1", "Landroid/widget/Button;", "btn2", "btnCreate", "editAbId", "Landroid/widget/EditText;", "editPath", "editSize", "editFormat", "editName", "rmPath", "rmSize", "rmStrategy", "rmWhiteList", "rmBlackList", "rmFake", "Landroidx/appcompat/widget/SwitchCompat;", "btnDelete", "threadPoolExecutor", "Lcom/bilibili/droid/thread/BThreadPoolExecutor;", "getThreadPoolExecutor", "()Lcom/bilibili/droid/thread/BThreadPoolExecutor;", "threadPoolExecutor$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onClick", "v", "Landroid/view/View;", "getExactDir", "", "str", "createFixLengthFile", "file", "Ljava/io/File;", "length", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class CommonDebugActivity extends BaseAppCompatActivity implements View.OnClickListener {
    public static final int $stable = 8;
    private Button btn1;
    private Button btn2;
    private Button btnCreate;
    private Button btnDelete;
    private EditText editAbId;
    private EditText editFormat;
    private EditText editName;
    private EditText editPath;
    private EditText editSize;
    private EditText rmBlackList;
    private SwitchCompat rmFake;
    private EditText rmPath;
    private EditText rmSize;
    private EditText rmStrategy;
    private EditText rmWhiteList;
    private final Lazy threadPoolExecutor$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.core.test.CommonDebugActivity$$ExternalSyntheticLambda5
        public final Object invoke() {
            BThreadPoolExecutor threadPoolExecutor_delegate$lambda$0;
            threadPoolExecutor_delegate$lambda$0 = CommonDebugActivity.threadPoolExecutor_delegate$lambda$0();
            return threadPoolExecutor_delegate$lambda$0;
        }
    });

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    private final BThreadPoolExecutor getThreadPoolExecutor() {
        return (BThreadPoolExecutor) this.threadPoolExecutor$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BThreadPoolExecutor threadPoolExecutor_delegate$lambda$0() {
        return new BThreadPoolExecutor("CommonDebugActivity", (BThreadPoolType) null, 2, (DefaultConstructorMarker) null);
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_debug);
        this.btn1 = (Button) findViewById(R.id.btn_1);
        this.btn2 = (Button) findViewById(R.id.btn_2);
        this.btnCreate = (Button) findViewById(R.id.btn_create);
        this.editAbId = (EditText) findViewById(R.id.ab_id);
        this.editPath = (EditText) findViewById(R.id.path);
        this.editSize = (EditText) findViewById(R.id.size);
        this.editFormat = (EditText) findViewById(R.id.format);
        this.rmPath = (EditText) findViewById(R.id.rm_path);
        this.rmStrategy = (EditText) findViewById(R.id.rm_strategy);
        this.rmSize = (EditText) findViewById(R.id.rm_size);
        this.editName = (EditText) findViewById(R.id.rm_name);
        this.rmWhiteList = (EditText) findViewById(R.id.rm_wl);
        this.rmBlackList = (EditText) findViewById(R.id.rm_bl);
        this.rmFake = findViewById(R.id.rm_fake);
        this.btnDelete = (Button) findViewById(R.id.btn_delete);
        Button button = this.btn1;
        if (button != null) {
            button.setOnClickListener(this);
        }
        Button button2 = this.btn2;
        if (button2 != null) {
            button2.setOnClickListener(this);
        }
        Button button3 = this.btnCreate;
        if (button3 != null) {
            button3.setOnClickListener(this);
        }
        Button button4 = this.btnDelete;
        if (button4 != null) {
            button4.setOnClickListener(this);
        }
        View findViewById = findViewById(R.id.btn_trigger_start);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        View findViewById2 = findViewById(R.id.btn_trigger_minor);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(this);
        }
        View findViewById3 = findViewById(R.id.btn_trigger_critical);
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        int i;
        double d;
        Integer valueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i2 = R.id.btn_1;
        if (valueOf != null && valueOf.intValue() == i2) {
            RouteRequest request = RouteRequestKt.toRouteRequest("https://activity.bilibili.com/preview/redpack/activity-AnlFcyHpPt.html");
            BLRouter.routeTo(request, (Context) this);
            return;
        }
        int i3 = R.id.btn_2;
        if (valueOf != null && valueOf.intValue() == i3) {
            try {
                EditText editText = this.editAbId;
                long abId = Long.parseLong(StringsKt.trim(String.valueOf(editText != null ? editText.getText() : null)).toString());
                int bucket = ExpServiceFactory.INSTANCE.getExpService().abTest(abId);
                ToastHelper.showToastShort(v.getContext(), "id = " + abId + " , bucket = " + bucket);
                return;
            } catch (Exception e) {
                ToastHelper.showToastShort(v.getContext(), "abid解析失败");
                return;
            }
        }
        int i4 = R.id.btn_create;
        if (valueOf != null && valueOf.intValue() == i4) {
            EditText editText2 = this.editPath;
            List path = StringsKt.split$default(StringsKt.trim(String.valueOf(editText2 != null ? editText2.getText() : null)).toString(), new String[]{":"}, false, 0, 6, (Object) null);
            if (path.size() < 2) {
                ToastHelper.showToastShort(v.getContext(), "创建文件失败,请检查格式");
                return;
            }
            final String createPath = getExactDir((String) path.get(0)) + File.separator + path.get(1);
            EditText editText3 = this.editFormat;
            final String createFormat = StringsKt.trim(String.valueOf(editText3 != null ? editText3.getText() : null)).toString();
            EditText editText4 = this.editSize;
            final String createSize = StringsKt.trim(String.valueOf(editText4 != null ? editText4.getText() : null)).toString();
            Task.callInBackground(new Callable() { // from class: tv.danmaku.bili.core.test.CommonDebugActivity$$ExternalSyntheticLambda0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Object onClick$lambda$0;
                    onClick$lambda$0 = CommonDebugActivity.onClick$lambda$0(createFormat, createPath, this, createSize);
                    return onClick$lambda$0;
                }
            });
            return;
        }
        int i5 = R.id.btn_delete;
        if (valueOf != null && valueOf.intValue() == i5) {
            EditText editText5 = this.editName;
            String rName = StringsKt.trim(String.valueOf(editText5 != null ? editText5.getText() : null)).toString();
            EditText editText6 = this.rmPath;
            String rPath = StringsKt.trim(String.valueOf(editText6 != null ? editText6.getText() : null)).toString();
            EditText editText7 = this.rmWhiteList;
            String rWl = StringsKt.trim(String.valueOf(editText7 != null ? editText7.getText() : null)).toString();
            EditText editText8 = this.rmBlackList;
            String rBl = StringsKt.trim(String.valueOf(editText8 != null ? editText8.getText() : null)).toString();
            SwitchCompat switchCompat = this.rmFake;
            boolean fake = switchCompat != null && switchCompat.isChecked();
            EditText editText9 = this.rmStrategy;
            String it = StringsKt.trim(String.valueOf(editText9 != null ? editText9.getText() : null)).toString();
            try {
                i = Integer.parseInt(it);
            } catch (Exception e2) {
                i = 0;
            }
            int rStrategy = i;
            EditText editText10 = this.rmSize;
            String it2 = StringsKt.trim(String.valueOf(editText10 != null ? editText10.getText() : null)).toString();
            try {
                d = Double.parseDouble(it2);
            } catch (Exception e3) {
                d = 0.0d;
            }
            double rSize = d;
            StorageConfig.ConfigItem item = new StorageConfig.ConfigItem(rName).path(rPath).fake(fake).expireStrategy(rStrategy).limitSize(rSize).expireTime(((long) rSize) * 1000);
            if (rWl.length() > 0) {
                item.whiteList(rWl);
            }
            if (rBl.length() > 0) {
                item.blackList(rBl);
            }
            StorageConfig $this$onClick_u24lambda_u244 = new StorageConfig().addConfigItem(item);
            StorageManager.INSTANCE.autoClearDirectory($this$onClick_u24lambda_u244, new Function2() { // from class: tv.danmaku.bili.core.test.CommonDebugActivity$$ExternalSyntheticLambda1
                public final Object invoke(Object obj, Object obj2) {
                    Unit onClick$lambda$4$0;
                    onClick$lambda$4$0 = CommonDebugActivity.onClick$lambda$4$0((List) obj, (List) obj2);
                    return onClick$lambda$4$0;
                }
            });
            return;
        }
        int i6 = R.id.btn_trigger_start;
        if (valueOf != null && valueOf.intValue() == i6) {
            getThreadPoolExecutor().execute(new Runnable() { // from class: tv.danmaku.bili.core.test.CommonDebugActivity$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    CommonDebugActivity.onClick$lambda$5();
                }
            });
            return;
        }
        int i7 = R.id.btn_trigger_minor;
        if (valueOf != null && valueOf.intValue() == i7) {
            getThreadPoolExecutor().execute(new Runnable() { // from class: tv.danmaku.bili.core.test.CommonDebugActivity$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    CommonDebugActivity.onClick$lambda$6();
                }
            });
            return;
        }
        int i8 = R.id.btn_trigger_critical;
        if (valueOf != null && valueOf.intValue() == i8) {
            getThreadPoolExecutor().execute(new Runnable() { // from class: tv.danmaku.bili.core.test.CommonDebugActivity$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    CommonDebugActivity.onClick$lambda$7();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object onClick$lambda$0(String $createFormat, String $createPath, CommonDebugActivity this$0, String $createSize) {
        try {
            if (Intrinsics.areEqual($createFormat, "auto")) {
                new File($createPath).mkdirs();
                for (int i = 0; i < 10; i++) {
                    if (i == 4) {
                        String dName = $createPath + "/testD" + i;
                        new File(dName).mkdirs();
                        for (int j = 0; j < 5; j++) {
                            File file = new File(dName, "testSubFile" + j + ".txt");
                            file.createNewFile();
                            long parseLong = Long.parseLong($createSize);
                            long j2 = (long) MisakaHelper.MAX_REPORT_SIZE;
                            this$0.createFixLengthFile(file, parseLong * j2 * j2);
                            Thread.sleep(1000L);
                        }
                    } else {
                        File file2 = new File($createPath, "testFile" + i + ".txt");
                        file2.createNewFile();
                        long parseLong2 = Long.parseLong($createSize);
                        long j3 = (long) MisakaHelper.MAX_REPORT_SIZE;
                        this$0.createFixLengthFile(file2, parseLong2 * j3 * j3);
                    }
                    Thread.sleep(1000L);
                }
                return Unit.INSTANCE;
            } else if (TextUtils.isEmpty($createFormat)) {
                return Boolean.valueOf(new File($createPath).mkdirs());
            } else {
                File file3 = new File($createPath, $createFormat);
                file3.createNewFile();
                long parseLong3 = Long.parseLong($createSize);
                long j4 = (long) MisakaHelper.MAX_REPORT_SIZE;
                this$0.createFixLengthFile(file3, parseLong3 * j4 * j4);
                return Unit.INSTANCE;
            }
        } catch (Exception e) {
            BLog.d("btn_create", "创建文件失败");
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onClick$lambda$4$0(List success, List failed) {
        if (success != null) {
            List $this$forEach$iv = success;
            for (Object element$iv : $this$forEach$iv) {
                String it = (String) element$iv;
                BLog.d("auto remove", "remove success file:" + it);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClick$lambda$5() {
        StorageManager.notifyTrimAction$default(StorageManager.INSTANCE, StorageEvent.start, (StorageTrimCallback) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClick$lambda$6() {
        StorageManager.notifyTrimAction$default(StorageManager.INSTANCE, StorageEvent.minor, (StorageTrimCallback) null, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClick$lambda$7() {
        StorageManager.notifyTrimAction$default(StorageManager.INSTANCE, StorageEvent.critical, (StorageTrimCallback) null, 2, (Object) null);
    }

    private final String getExactDir(String str) {
        File cacheDir;
        String absolutePath;
        File filesDir;
        String absolutePath2;
        File dataDir;
        String absolutePath3;
        File externalCacheDir;
        String absolutePath4;
        File externalFilesDir;
        String absolutePath5;
        switch (str.hashCode()) {
            case 1536:
                return (!str.equals(MineReporter.LIVE_TYPE_NOT_UPPER_NO_LIVE) || (cacheDir = getCacheDir()) == null || (absolutePath = cacheDir.getAbsolutePath()) == null) ? "" : absolutePath;
            case 1537:
                return (!str.equals(MineReporter.LIVE_TYPE_UPPER_NO_LIVE) || (filesDir = getFilesDir()) == null || (absolutePath2 = filesDir.getAbsolutePath()) == null) ? "" : absolutePath2;
            case 1538:
                return (!str.equals("02") || (dataDir = ContextCompat.getDataDir((Context) this)) == null || (absolutePath3 = dataDir.getAbsolutePath()) == null) ? "" : absolutePath3;
            case 1567:
                return (!str.equals("10") || (externalCacheDir = getExternalCacheDir()) == null || (absolutePath4 = externalCacheDir.getAbsolutePath()) == null) ? "" : absolutePath4;
            case 1568:
                return (!str.equals("11") || (externalFilesDir = getExternalFilesDir(null)) == null || (absolutePath5 = externalFilesDir.getAbsolutePath()) == null) ? "" : absolutePath5;
            default:
                return "";
        }
    }

    public final void createFixLengthFile(File file, long length) throws IOException {
        long start = System.currentTimeMillis();
        FileOutputStream fos = null;
        FileChannel output = null;
        try {
            fos = new FileOutputStream(file);
            output = fos.getChannel();
            output.write(ByteBuffer.allocate(1), length - 1);
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            fos.close();
            long end = System.currentTimeMillis();
            System.out.println((Object) ("total times " + (end - start)));
        } catch (Throwable th) {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                    throw th;
                }
            }
            if (fos != null) {
                fos.close();
            }
            throw th;
        }
    }
}