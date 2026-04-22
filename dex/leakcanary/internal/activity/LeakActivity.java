package leakcanary.internal.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.bilibili.lib.tribe.core.internal.Hooks;
import com.squareup.leakcanary.core.R;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import leakcanary.EventListener;
import leakcanary.internal.InternalLeakCanary;
import leakcanary.internal.activity.db.Db;
import leakcanary.internal.activity.screen.AboutScreen;
import leakcanary.internal.activity.screen.HeapAnalysisFailureScreen;
import leakcanary.internal.activity.screen.HeapDumpScreen;
import leakcanary.internal.activity.screen.HeapDumpsScreen;
import leakcanary.internal.activity.screen.LeaksScreen;
import leakcanary.internal.navigation.NavigatingActivity;
import leakcanary.internal.navigation.Screen;
import shark.SharkLog;

/* compiled from: LeakActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u0000\u0018\u0000 52\u00020\u0001:\u00015B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0010\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$H\u0002J\"\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010!H\u0014J\u0012\u0010*\u001a\u00020\u001f2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\b\u0010-\u001a\u00020\u001fH\u0014J\u0010\u0010.\u001a\u00020\u001f2\u0006\u0010/\u001a\u00020\u001dH\u0014J\u0016\u00100\u001a\b\u0012\u0004\u0012\u00020\u001d012\u0006\u0010 \u001a\u00020!H\u0016J\u0006\u00102\u001a\u00020\u001fJ\u0010\u00103\u001a\u00020\u001f2\u0006\u00104\u001a\u00020'H\u0016R#\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R#\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R#\u0010\r\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u000e\u0010\u0007R#\u0010\u0010\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0011\u0010\u0007R#\u0010\u0013\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0014\u0010\u0007R#\u0010\u0016\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0017\u0010\u0007R#\u0010\u0019\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001a\u0010\u0007¨\u00066"}, d2 = {"Lleakcanary/internal/activity/LeakActivity;", "Lleakcanary/internal/navigation/NavigatingActivity;", "()V", "aboutButton", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getAboutButton", "()Landroid/view/View;", "aboutButton$delegate", "Lkotlin/Lazy;", "aboutButtonIconView", "getAboutButtonIconView", "aboutButtonIconView$delegate", "bottomNavigationBar", "getBottomNavigationBar", "bottomNavigationBar$delegate", "heapDumpsButton", "getHeapDumpsButton", "heapDumpsButton$delegate", "heapDumpsButtonIconView", "getHeapDumpsButtonIconView", "heapDumpsButtonIconView$delegate", "leaksButton", "getLeaksButton", "leaksButton$delegate", "leaksButtonIconView", "getLeaksButtonIconView", "leaksButtonIconView$delegate", "getLauncherScreen", "Lleakcanary/internal/navigation/Screen;", "handleViewHprof", "", "intent", "Landroid/content/Intent;", "importHprof", "fileUri", "Landroid/net/Uri;", "onActivityResult", "requestCode", "", "resultCode", "returnIntent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewScreen", "screen", "parseIntentScreens", "", "requestImportHprof", "setTheme", "resid", "Companion", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class LeakActivity extends NavigatingActivity {
    public static final Companion Companion = new Companion(null);
    private static final int FILE_REQUEST_CODE = 0;
    private final Lazy leaksButton$delegate = LazyKt.lazy(new Function0<View>() { // from class: leakcanary.internal.activity.LeakActivity$leaksButton$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final View invoke() {
            return LeakActivity.this.findViewById(R.id.leak_canary_navigation_button_leaks);
        }
    });
    private final Lazy leaksButtonIconView$delegate = LazyKt.lazy(new Function0<View>() { // from class: leakcanary.internal.activity.LeakActivity$leaksButtonIconView$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final View invoke() {
            return LeakActivity.this.findViewById(R.id.leak_canary_navigation_button_leaks_icon);
        }
    });
    private final Lazy heapDumpsButton$delegate = LazyKt.lazy(new Function0<View>() { // from class: leakcanary.internal.activity.LeakActivity$heapDumpsButton$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final View invoke() {
            return LeakActivity.this.findViewById(R.id.leak_canary_navigation_button_heap_dumps);
        }
    });
    private final Lazy heapDumpsButtonIconView$delegate = LazyKt.lazy(new Function0<View>() { // from class: leakcanary.internal.activity.LeakActivity$heapDumpsButtonIconView$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final View invoke() {
            return LeakActivity.this.findViewById(R.id.leak_canary_navigation_button_heap_dumps_icon);
        }
    });
    private final Lazy aboutButton$delegate = LazyKt.lazy(new Function0<View>() { // from class: leakcanary.internal.activity.LeakActivity$aboutButton$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final View invoke() {
            return LeakActivity.this.findViewById(R.id.leak_canary_navigation_button_about);
        }
    });
    private final Lazy aboutButtonIconView$delegate = LazyKt.lazy(new Function0<View>() { // from class: leakcanary.internal.activity.LeakActivity$aboutButtonIconView$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final View invoke() {
            return LeakActivity.this.findViewById(R.id.leak_canary_navigation_button_about_icon);
        }
    });
    private final Lazy bottomNavigationBar$delegate = LazyKt.lazy(new Function0<View>() { // from class: leakcanary.internal.activity.LeakActivity$bottomNavigationBar$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final View invoke() {
            return LeakActivity.this.findViewById(R.id.leak_canary_bottom_navigation_bar);
        }
    });

    private void _attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    private final View getAboutButton() {
        return (View) this.aboutButton$delegate.getValue();
    }

    private final View getAboutButtonIconView() {
        return (View) this.aboutButtonIconView$delegate.getValue();
    }

    private final View getBottomNavigationBar() {
        return (View) this.bottomNavigationBar$delegate.getValue();
    }

    private final View getHeapDumpsButton() {
        return (View) this.heapDumpsButton$delegate.getValue();
    }

    private final View getHeapDumpsButtonIconView() {
        return (View) this.heapDumpsButtonIconView$delegate.getValue();
    }

    private final View getLeaksButton() {
        return (View) this.leaksButton$delegate.getValue();
    }

    private final View getLeaksButtonIconView() {
        return (View) this.leaksButtonIconView$delegate.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void attachBaseContext(Context context) {
        _attachBaseContext(Hooks.hookAttachContext(this, context));
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leak_canary_leak_activity);
        View findViewById = findViewById(R.id.leak_canary_main_container);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.leak_canary_main_container)");
        installNavigation(savedInstanceState, (ViewGroup) findViewById);
        getLeaksButton().setOnClickListener(new View.OnClickListener() { // from class: leakcanary.internal.activity.LeakActivity$onCreate$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                LeakActivity.this.resetTo(new LeaksScreen());
            }
        });
        getHeapDumpsButton().setOnClickListener(new View.OnClickListener() { // from class: leakcanary.internal.activity.LeakActivity$onCreate$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                LeakActivity.this.resetTo(new HeapDumpsScreen());
            }
        });
        getAboutButton().setOnClickListener(new View.OnClickListener() { // from class: leakcanary.internal.activity.LeakActivity$onCreate$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                LeakActivity.this.resetTo(new AboutScreen());
            }
        });
        handleViewHprof(getIntent());
    }

    private final void handleViewHprof(Intent intent) {
        final Uri uri;
        if (!Intrinsics.areEqual(intent != null ? intent.getAction() : null, "android.intent.action.VIEW") || (uri = intent.getData()) == null) {
            return;
        }
        Intrinsics.checkExpressionValueIsNotNull(uri, "intent.data ?: return");
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null || !StringsKt.endsWith$default(lastPathSegment, ".hprof", false, 2, (Object) null)) {
            Toast.makeText((Context) this, getString(R.string.leak_canary_import_unsupported_file_extension, new Object[]{uri.getLastPathSegment()}), 1).show();
            return;
        }
        resetTo(new HeapDumpsScreen());
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: leakcanary.internal.activity.LeakActivity$handleViewHprof$1
            @Override // java.lang.Runnable
            public final void run() {
                LeakActivity.this.importHprof(uri);
            }
        });
    }

    @Override // leakcanary.internal.navigation.NavigatingActivity
    protected void onNewScreen(Screen screen) {
        Intrinsics.checkParameterIsNotNull(screen, "screen");
        if (screen instanceof LeaksScreen) {
            View bottomNavigationBar = getBottomNavigationBar();
            Intrinsics.checkExpressionValueIsNotNull(bottomNavigationBar, "bottomNavigationBar");
            bottomNavigationBar.setVisibility(0);
            View leaksButton = getLeaksButton();
            Intrinsics.checkExpressionValueIsNotNull(leaksButton, "leaksButton");
            leaksButton.setSelected(true);
            View leaksButtonIconView = getLeaksButtonIconView();
            Intrinsics.checkExpressionValueIsNotNull(leaksButtonIconView, "leaksButtonIconView");
            leaksButtonIconView.setAlpha(1.0f);
            View heapDumpsButton = getHeapDumpsButton();
            Intrinsics.checkExpressionValueIsNotNull(heapDumpsButton, "heapDumpsButton");
            heapDumpsButton.setSelected(false);
            View heapDumpsButtonIconView = getHeapDumpsButtonIconView();
            Intrinsics.checkExpressionValueIsNotNull(heapDumpsButtonIconView, "heapDumpsButtonIconView");
            heapDumpsButtonIconView.setAlpha(0.4f);
            View aboutButton = getAboutButton();
            Intrinsics.checkExpressionValueIsNotNull(aboutButton, "aboutButton");
            aboutButton.setSelected(false);
            View aboutButtonIconView = getAboutButtonIconView();
            Intrinsics.checkExpressionValueIsNotNull(aboutButtonIconView, "aboutButtonIconView");
            aboutButtonIconView.setAlpha(0.4f);
        } else if (screen instanceof HeapDumpsScreen) {
            View bottomNavigationBar2 = getBottomNavigationBar();
            Intrinsics.checkExpressionValueIsNotNull(bottomNavigationBar2, "bottomNavigationBar");
            bottomNavigationBar2.setVisibility(0);
            View leaksButton2 = getLeaksButton();
            Intrinsics.checkExpressionValueIsNotNull(leaksButton2, "leaksButton");
            leaksButton2.setSelected(false);
            View leaksButtonIconView2 = getLeaksButtonIconView();
            Intrinsics.checkExpressionValueIsNotNull(leaksButtonIconView2, "leaksButtonIconView");
            leaksButtonIconView2.setAlpha(0.4f);
            View heapDumpsButton2 = getHeapDumpsButton();
            Intrinsics.checkExpressionValueIsNotNull(heapDumpsButton2, "heapDumpsButton");
            heapDumpsButton2.setSelected(true);
            View heapDumpsButtonIconView2 = getHeapDumpsButtonIconView();
            Intrinsics.checkExpressionValueIsNotNull(heapDumpsButtonIconView2, "heapDumpsButtonIconView");
            heapDumpsButtonIconView2.setAlpha(1.0f);
            View aboutButton2 = getAboutButton();
            Intrinsics.checkExpressionValueIsNotNull(aboutButton2, "aboutButton");
            aboutButton2.setSelected(false);
            View aboutButtonIconView2 = getAboutButtonIconView();
            Intrinsics.checkExpressionValueIsNotNull(aboutButtonIconView2, "aboutButtonIconView");
            aboutButtonIconView2.setAlpha(0.4f);
        } else if (screen instanceof AboutScreen) {
            View bottomNavigationBar3 = getBottomNavigationBar();
            Intrinsics.checkExpressionValueIsNotNull(bottomNavigationBar3, "bottomNavigationBar");
            bottomNavigationBar3.setVisibility(0);
            View leaksButton3 = getLeaksButton();
            Intrinsics.checkExpressionValueIsNotNull(leaksButton3, "leaksButton");
            leaksButton3.setSelected(false);
            View leaksButtonIconView3 = getLeaksButtonIconView();
            Intrinsics.checkExpressionValueIsNotNull(leaksButtonIconView3, "leaksButtonIconView");
            leaksButtonIconView3.setAlpha(0.4f);
            View heapDumpsButton3 = getHeapDumpsButton();
            Intrinsics.checkExpressionValueIsNotNull(heapDumpsButton3, "heapDumpsButton");
            heapDumpsButton3.setSelected(false);
            View heapDumpsButtonIconView3 = getHeapDumpsButtonIconView();
            Intrinsics.checkExpressionValueIsNotNull(heapDumpsButtonIconView3, "heapDumpsButtonIconView");
            heapDumpsButtonIconView3.setAlpha(0.4f);
            View aboutButton3 = getAboutButton();
            Intrinsics.checkExpressionValueIsNotNull(aboutButton3, "aboutButton");
            aboutButton3.setSelected(true);
            View aboutButtonIconView3 = getAboutButtonIconView();
            Intrinsics.checkExpressionValueIsNotNull(aboutButtonIconView3, "aboutButtonIconView");
            aboutButtonIconView3.setAlpha(1.0f);
        } else {
            View bottomNavigationBar4 = getBottomNavigationBar();
            Intrinsics.checkExpressionValueIsNotNull(bottomNavigationBar4, "bottomNavigationBar");
            bottomNavigationBar4.setVisibility(8);
        }
    }

    @Override // leakcanary.internal.navigation.NavigatingActivity
    public Screen getLauncherScreen() {
        return new LeaksScreen();
    }

    public final void requestImportHprof() {
        Intent requestFileIntent = new Intent("android.intent.action.GET_CONTENT");
        requestFileIntent.setType("*/*");
        requestFileIntent.addCategory("android.intent.category.OPENABLE");
        Intent chooserIntent = Intent.createChooser(requestFileIntent, getResources().getString(R.string.leak_canary_import_from_title));
        startActivityForResult(chooserIntent, 0);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent returnIntent) {
        final Uri fileUri;
        SharkLog this_$iv = SharkLog.INSTANCE;
        SharkLog.Logger logger$iv = this_$iv.getLogger();
        if (logger$iv != null) {
            logger$iv.d("Got activity result with requestCode=" + requestCode + " resultCode=" + resultCode + " returnIntent=" + returnIntent);
        }
        if (requestCode == 0 && resultCode == -1 && returnIntent != null && (fileUri = returnIntent.getData()) != null) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable() { // from class: leakcanary.internal.activity.LeakActivity$onActivityResult$$inlined$let$lambda$1
                @Override // java.lang.Runnable
                public final void run() {
                    LeakActivity leakActivity = this;
                    Uri fileUri2 = fileUri;
                    Intrinsics.checkExpressionValueIsNotNull(fileUri2, "fileUri");
                    leakActivity.importHprof(fileUri2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void importHprof(Uri fileUri) {
        FileDescriptor fileDescriptor;
        try {
            try {
                ParcelFileDescriptor openFileDescriptor = getContentResolver().openFileDescriptor(fileUri, "r");
                if (openFileDescriptor != null && (fileDescriptor = openFileDescriptor.getFileDescriptor()) != null) {
                    FileInputStream inputStream = new FileInputStream(fileDescriptor);
                    File target = InternalLeakCanary.INSTANCE.createLeakDirectoryProvider((Context) this).newHeapDumpFile();
                    if (target != null) {
                        FileInputStream fileInputStream = inputStream;
                        Throwable th = null;
                        FileInputStream input = fileInputStream;
                        FileOutputStream fileOutputStream = new FileOutputStream(target);
                        Throwable th2 = null;
                        try {
                            FileOutputStream output = fileOutputStream;
                            ByteStreamsKt.copyTo(input, output, 8192);
                            CloseableKt.closeFinally(fileOutputStream, null);
                            CloseableKt.closeFinally(fileInputStream, null);
                            InternalLeakCanary internalLeakCanary = InternalLeakCanary.INSTANCE;
                            String uuid = UUID.randomUUID().toString();
                            Intrinsics.checkExpressionValueIsNotNull(uuid, "UUID.randomUUID().toString()");
                            internalLeakCanary.sendEvent(new EventListener.Event.HeapDump(uuid, target, -1L, "Imported by user"));
                        } catch (Throwable th3) {
                            try {
                                throw th3;
                            } catch (Throwable th4) {
                                CloseableKt.closeFinally(fileOutputStream, th3);
                                throw th4;
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e = e;
                SharkLog this_$iv = SharkLog.INSTANCE;
                SharkLog.Logger logger$iv = this_$iv.getLogger();
                if (logger$iv != null) {
                    logger$iv.d(e, "Could not import Hprof file");
                }
            }
        } catch (IOException e2) {
            e = e2;
        }
    }

    @Override // leakcanary.internal.navigation.NavigatingActivity
    protected void onDestroy() {
        super.onDestroy();
        if (!isChangingConfigurations()) {
            Db.INSTANCE.closeDatabase();
        }
    }

    public void setTheme(int resid) {
        if (resid != R.style.leak_canary_LeakCanary_Base) {
            return;
        }
        super.setTheme(resid);
    }

    @Override // leakcanary.internal.navigation.NavigatingActivity
    public List<Screen> parseIntentScreens(Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        long heapAnalysisId = intent.getLongExtra("heapAnalysisId", -1L);
        if (heapAnalysisId == -1) {
            return CollectionsKt.emptyList();
        }
        boolean success = intent.getBooleanExtra("success", false);
        return success ? CollectionsKt.arrayListOf(new HeapDumpsScreen(), new HeapDumpScreen(heapAnalysisId)) : CollectionsKt.arrayListOf(new HeapDumpsScreen(), new HeapAnalysisFailureScreen(heapAnalysisId));
    }

    /* compiled from: LeakActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lleakcanary/internal/activity/LeakActivity$Companion;", "", "()V", "FILE_REQUEST_CODE", "", "createFailureIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "heapAnalysisId", "", "createHomeIntent", "createSuccessIntent", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final Intent createHomeIntent(Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intent intent = new Intent(context, LeakActivity.class);
            intent.setFlags(335544320);
            return intent;
        }

        public final Intent createSuccessIntent(Context context, long heapAnalysisId) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intent intent = createHomeIntent(context);
            intent.putExtra("heapAnalysisId", heapAnalysisId);
            intent.putExtra("success", true);
            return intent;
        }

        public final Intent createFailureIntent(Context context, long heapAnalysisId) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intent intent = createHomeIntent(context);
            intent.putExtra("heapAnalysisId", heapAnalysisId);
            intent.putExtra("success", false);
            return intent;
        }
    }
}