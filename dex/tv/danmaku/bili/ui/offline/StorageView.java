package tv.danmaku.bili.ui.offline;

import android.content.Context;
import android.content.res.ColorStateList;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.bilibili.app.preferences.Settings;
import com.bilibili.droid.DimenUtilsKt;
import com.bilibili.lib.theme.R;
import com.bilibili.magicasakura.utils.ThemeUtils;
import com.bilibili.magicasakura.widgets.TintTextView;
import com.bilibili.offline.StorageInfo;
import com.bilibili.playerbizcommonv2.utils.NumberExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import tv.danmaku.android.log.BLog;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: StorageView.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J \u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u000eJ\b\u0010#\u001a\u00020\u001cH\u0016J\u0006\u0010$\u001a\u00020\u001cJ\u0006\u0010%\u001a\u00020\u001cJ+\u0010&\u001a\u00020'2\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010)\u001a\u00020*H\u0002¢\u0006\u0002\u0010+J\u001a\u0010,\u001a\u00020'2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010-\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u00061"}, d2 = {"Ltv/danmaku/bili/ui/offline/StorageView;", "Lcom/bilibili/magicasakura/widgets/TintTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mStorage", "", "Lcom/bilibili/offline/StorageInfo;", "[Lcom/bilibili/offline/StorageInfo;", "mCurrentStorage", "", "viewLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "getViewLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "registry", "Landroidx/lifecycle/LifecycleRegistry;", "getRegistry", "()Landroidx/lifecycle/LifecycleRegistry;", "scope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "getScope", "()Landroidx/lifecycle/LifecycleCoroutineScope;", "init", "", "attach", "mContainer", "Landroid/view/ViewGroup;", "params", "Landroid/view/ViewGroup$LayoutParams;", "pos", "tint", "checkStorage", "updateStorageIfStorageTypeChanged", "buildStorageString", "", "storageInfos", "isPrimary", "", "(Landroid/content/Context;[Lcom/bilibili/offline/StorageInfo;Z)Ljava/lang/CharSequence;", "createSpannableString", "info", "createTextColorSpan", "Landroid/text/style/TextAppearanceSpan;", "Companion", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class StorageView extends TintTextView {
    private static final String TAG = "StorageView";
    private int mCurrentStorage;
    private StorageInfo[] mStorage;
    private final LifecycleRegistry registry;
    private final LifecycleOwner viewLifecycleOwner;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public final LifecycleOwner getViewLifecycleOwner() {
        return this.viewLifecycleOwner;
    }

    public final LifecycleRegistry getRegistry() {
        return this.registry;
    }

    public final LifecycleCoroutineScope getScope() {
        return LifecycleKt.getCoroutineScope(this.viewLifecycleOwner.getLifecycle());
    }

    public StorageView(Context context) {
        super(context);
        this.mCurrentStorage = 1;
        this.viewLifecycleOwner = new LifecycleOwner() { // from class: tv.danmaku.bili.ui.offline.StorageView$viewLifecycleOwner$1
            public Lifecycle getLifecycle() {
                return StorageView.this.getRegistry();
            }
        };
        this.registry = new LifecycleRegistry(this.viewLifecycleOwner);
        init();
    }

    public StorageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mCurrentStorage = 1;
        this.viewLifecycleOwner = new LifecycleOwner() { // from class: tv.danmaku.bili.ui.offline.StorageView$viewLifecycleOwner$1
            public Lifecycle getLifecycle() {
                return StorageView.this.getRegistry();
            }
        };
        this.registry = new LifecycleRegistry(this.viewLifecycleOwner);
        init();
    }

    private final void init() {
        setBackgroundResource(R.color.Ga1);
        setGravity(17);
        setTextSize(0, getResources().getDimensionPixelSize(com.bilibili.lib.basecomponent.R.dimen.text_size_supplementary));
        setTextColor(ContextCompat.getColor(getContext(), R.color.Text3));
        setMinHeight((int) TypedValue.applyDimension(1, 20.0f, getResources().getDisplayMetrics()));
        final View $this$doOnAttach$iv = (View) this;
        if ($this$doOnAttach$iv.isAttachedToWindow()) {
            getRegistry().setCurrentState(Lifecycle.State.RESUMED);
        } else {
            $this$doOnAttach$iv.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: tv.danmaku.bili.ui.offline.StorageView$init$$inlined$doOnAttach$1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                    $this$doOnAttach$iv.removeOnAttachStateChangeListener(this);
                    this.getRegistry().setCurrentState(Lifecycle.State.RESUMED);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                }
            });
        }
        final View $this$doOnDetach$iv = (View) this;
        if (!$this$doOnDetach$iv.isAttachedToWindow()) {
            if (getRegistry().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                getRegistry().setCurrentState(Lifecycle.State.DESTROYED);
                return;
            }
            return;
        }
        $this$doOnDetach$iv.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: tv.danmaku.bili.ui.offline.StorageView$init$$inlined$doOnDetach$1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view2) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view2) {
                $this$doOnDetach$iv.removeOnAttachStateChangeListener(this);
                if (!this.getRegistry().getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
                    return;
                }
                this.getRegistry().setCurrentState(Lifecycle.State.DESTROYED);
            }
        });
    }

    public final void attach(ViewGroup mContainer, ViewGroup.LayoutParams params, int pos) {
        Intrinsics.checkNotNullParameter(mContainer, "mContainer");
        mContainer.addView((View) this, pos, params);
    }

    public void tint() {
        super.tint();
        if (this.mStorage != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            StorageInfo[] storageInfoArr = this.mStorage;
            Intrinsics.checkNotNull(storageInfoArr);
            setText(buildStorageString(context, storageInfoArr, this.mCurrentStorage != 2));
        }
    }

    public final void checkStorage() {
        this.mCurrentStorage = Settings.Download.getDownloadStorage(getContext());
        BuildersKt.launch$default(getScope(), Dispatchers.getMain(), (CoroutineStart) null, new StorageView$checkStorage$1(this, null), 2, (Object) null);
    }

    public final void updateStorageIfStorageTypeChanged() {
        if (Settings.Download.getDownloadStorage(getContext()) != this.mCurrentStorage) {
            StorageInfo[] storageInfoArr = this.mStorage;
            boolean z = false;
            if (storageInfoArr != null) {
                if (!(storageInfoArr.length == 0)) {
                    z = true;
                }
            }
            if (z) {
                checkStorage();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CharSequence buildStorageString(Context context, StorageInfo[] storageInfos, boolean isPrimary) {
        if (storageInfos.length == 0) {
            return "";
        }
        return createSpannableString(context, (isPrimary || storageInfos.length <= 1) ? storageInfos[0] : storageInfos[1]);
    }

    private final CharSequence createSpannableString(Context context, StorageInfo info) {
        if (info == null) {
            BLog.i(TAG, "user storage error");
            return "";
        }
        SpannableStringBuilder builder = new SpannableStringBuilder();
        String free = NumberExtensionKt.toFileSize(info.diskAvailableBytes);
        if (info.offlineUsedBytes == 0) {
            String text1 = context.getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_101, free);
            Intrinsics.checkNotNullExpressionValue(text1, "getString(...)");
            BLog.i(TAG, "user storage overview > " + text1);
            builder.append((CharSequence) text1);
            int index = StringsKt.indexOf$default(text1, free, 0, false, 6, (Object) null);
            builder.setSpan(createTextColorSpan(context), index, text1.length(), 17);
        } else {
            String used = NumberExtensionKt.toFileSize(info.offlineUsedBytes);
            String text12 = context.getString(bili.resource.playerbaseres.R.string.playerbaseres_global_string_966, used, free);
            Intrinsics.checkNotNullExpressionValue(text12, "getString(...)");
            BLog.i(TAG, "user storage overview > " + text12);
            int usedIndex = StringsKt.indexOf$default(text12, used, 0, false, 6, (Object) null);
            int freeIndex = StringsKt.indexOf$default(text12, free, 0, false, 6, (Object) null);
            builder.append((CharSequence) text12);
            builder.setSpan(createTextColorSpan(context), usedIndex, used.length() + usedIndex, 17);
            builder.setSpan(createTextColorSpan(context), freeIndex, free.length() + freeIndex, 17);
        }
        return builder;
    }

    private final TextAppearanceSpan createTextColorSpan(Context context) {
        int textSize = DimenUtilsKt.dpToPx(10.0f);
        ColorStateList textColor = ColorStateList.valueOf(ThemeUtils.getColorById(context, R.color.Text1));
        Intrinsics.checkNotNullExpressionValue(textColor, "valueOf(...)");
        return new TextAppearanceSpan(null, 0, textSize, textColor, null);
    }

    /* compiled from: StorageView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Ltv/danmaku/bili/ui/offline/StorageView$Companion;", "", "<init>", "()V", "TAG", "", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
    /* loaded from: /data/np/file-convert/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a/20260228071740acaead6b-f6d3-43df-b685-c5417486b61a.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}