package tv.danmaku.bili.widget.preference;

import android.content.Context;
import android.util.AttributeSet;
import androidx.preference.SwitchPreferenceCompat;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.biliplayerv2.widget.toast.PlayerToastConfig;

/* compiled from: BLKVSwitchPreference.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/widget/preference/BLKVSwitchPreference;", "Landroidx/preference/SwitchPreferenceCompat;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "store", "Ltv/danmaku/bili/widget/preference/BLKVPreferenceDataStore;", "getStore", "()Ltv/danmaku/bili/widget/preference/BLKVPreferenceDataStore;", "store$delegate", "Lkotlin/Lazy;", "widget_debug"}, k = 1, mv = {2, 0, 0}, xi = PlayerToastConfig.QUEUE_INSERT)
public final class BLKVSwitchPreference extends SwitchPreferenceCompat {
    private final Lazy store$delegate;

    private final BLKVPreferenceDataStore getStore() {
        return (BLKVPreferenceDataStore) this.store$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BLKVPreferenceDataStore store_delegate$lambda$0() {
        return new BLKVPreferenceDataStore(null, 1, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BLKVSwitchPreference(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.store$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.widget.preference.BLKVSwitchPreference$$ExternalSyntheticLambda0
            public final Object invoke() {
                BLKVPreferenceDataStore store_delegate$lambda$0;
                store_delegate$lambda$0 = BLKVSwitchPreference.store_delegate$lambda$0();
                return store_delegate$lambda$0;
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BLKVSwitchPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        this.store$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.widget.preference.BLKVSwitchPreference$$ExternalSyntheticLambda0
            public final Object invoke() {
                BLKVPreferenceDataStore store_delegate$lambda$0;
                store_delegate$lambda$0 = BLKVSwitchPreference.store_delegate$lambda$0();
                return store_delegate$lambda$0;
            }
        });
        setPreferenceDataStore(getStore());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BLKVSwitchPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this.store$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.widget.preference.BLKVSwitchPreference$$ExternalSyntheticLambda0
            public final Object invoke() {
                BLKVPreferenceDataStore store_delegate$lambda$0;
                store_delegate$lambda$0 = BLKVSwitchPreference.store_delegate$lambda$0();
                return store_delegate$lambda$0;
            }
        });
        setPreferenceDataStore(getStore());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BLKVSwitchPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        Intrinsics.checkNotNullParameter(context, "context");
        this.store$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.widget.preference.BLKVSwitchPreference$$ExternalSyntheticLambda0
            public final Object invoke() {
                BLKVPreferenceDataStore store_delegate$lambda$0;
                store_delegate$lambda$0 = BLKVSwitchPreference.store_delegate$lambda$0();
                return store_delegate$lambda$0;
            }
        });
        setPreferenceDataStore(getStore());
    }
}