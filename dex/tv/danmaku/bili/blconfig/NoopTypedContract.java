package tv.danmaku.bili.blconfig;

import android.content.SharedPreferences;
import com.bilibili.lib.blconfig.Contract;
import com.bilibili.lib.blkv.BLKV;
import com.bilibili.lib.blkv.SharedPrefX;
import com.bilibili.lib.foundation.FoundationAlias;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.report.InfoEyesOperatingDataPublicQueryString;
import tv.danmaku.bili.ui.favorites.consts.FavoritesConstsKt;

/* compiled from: DebugConfigHelper.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0011\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BK\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002\u0012\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u000bH\u0016J'\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000!2\u0006\u0010/\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u00101J\"\u00102\u001a\u0004\u0018\u00018\u00002\u0006\u0010/\u001a\u00020\u000b2\b\u00100\u001a\u0004\u0018\u00018\u0000H\u0096\u0002¢\u0006\u0002\u00103J\b\u00104\u001a\u00020,H\u0007J\u0006\u00105\u001a\u00020\u0011J\b\u00106\u001a\u00020,H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0010\u001a\u00020\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR!\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0!8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u0015\u001a\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020&8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020&0!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010#¨\u00067"}, d2 = {"Ltv/danmaku/bili/blconfig/NoopTypedContract;", "T", "Lcom/bilibili/lib/blconfig/Contract;", "dir", "Ljava/io/File;", "typed", "Ltv/danmaku/bili/blconfig/DebugTyped;", "delegate", "getter", "Lkotlin/Function3;", "Landroid/content/SharedPreferences;", "", "<init>", "(Ljava/io/File;Ltv/danmaku/bili/blconfig/DebugTyped;Lcom/bilibili/lib/blconfig/Contract;Lkotlin/jvm/functions/Function3;)V", "getGetter", "()Lkotlin/jvm/functions/Function3;", "dataSp", "Lcom/bilibili/lib/blkv/SharedPrefX;", "getDataSp", "()Lcom/bilibili/lib/blkv/SharedPrefX;", "dataSp$delegate", "Lkotlin/Lazy;", "keyPublisher", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "getKeyPublisher", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "keyPublisher$delegate", "dataListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "headerName", "getHeaderName", "()Ljava/lang/String;", "keyObservable", "Lkotlinx/coroutines/flow/Flow;", "getKeyObservable", "()Lkotlinx/coroutines/flow/Flow;", "keyObservable$delegate", "version", "", "getVersion", "()J", "versionObservable", "getVersionObservable", "onVersion", "", InfoEyesOperatingDataPublicQueryString.KEY_VER, "getAsync", "key", "defVal", "(Ljava/lang/String;Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "get", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "clearData", "sp", FavoritesConstsKt.CLEAR_INVALID_CLEAR, "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public class NoopTypedContract<T> implements Contract<T> {
    public static final int $stable = 8;
    private final SharedPreferences.OnSharedPreferenceChangeListener dataListener;
    private final Lazy dataSp$delegate;
    private final Contract<T> delegate;
    private final File dir;
    private final Function3<SharedPreferences, String, T, T> getter;
    private final Lazy keyObservable$delegate;
    private final Lazy keyPublisher$delegate;
    private final DebugTyped typed;

    /* JADX WARN: Multi-variable type inference failed */
    public NoopTypedContract(File dir, DebugTyped typed, Contract<T> contract, Function3<? super SharedPreferences, ? super String, ? super T, ? extends T> function3) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(typed, "typed");
        Intrinsics.checkNotNullParameter(function3, "getter");
        this.dir = dir;
        this.typed = typed;
        this.delegate = contract;
        this.getter = function3;
        this.dataSp$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.blconfig.NoopTypedContract$$ExternalSyntheticLambda0
            public final Object invoke() {
                SharedPrefX dataSp_delegate$lambda$0;
                dataSp_delegate$lambda$0 = NoopTypedContract.dataSp_delegate$lambda$0(NoopTypedContract.this);
                return dataSp_delegate$lambda$0;
            }
        });
        this.keyPublisher$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.blconfig.NoopTypedContract$$ExternalSyntheticLambda1
            public final Object invoke() {
                MutableSharedFlow keyPublisher_delegate$lambda$0;
                keyPublisher_delegate$lambda$0 = NoopTypedContract.keyPublisher_delegate$lambda$0(NoopTypedContract.this);
                return keyPublisher_delegate$lambda$0;
            }
        });
        this.dataListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: tv.danmaku.bili.blconfig.NoopTypedContract$$ExternalSyntheticLambda2
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                NoopTypedContract.dataListener$lambda$0(NoopTypedContract.this, sharedPreferences, str);
            }
        };
        this.keyObservable$delegate = LazyKt.lazy(new Function0() { // from class: tv.danmaku.bili.blconfig.NoopTypedContract$$ExternalSyntheticLambda3
            public final Object invoke() {
                Flow keyObservable_delegate$lambda$0;
                keyObservable_delegate$lambda$0 = NoopTypedContract.keyObservable_delegate$lambda$0(NoopTypedContract.this);
                return keyObservable_delegate$lambda$0;
            }
        });
    }

    public final Function3<SharedPreferences, String, T, T> getGetter() {
        return this.getter;
    }

    public final SharedPrefX getDataSp() {
        return (SharedPrefX) this.dataSp$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SharedPrefX dataSp_delegate$lambda$0(NoopTypedContract this$0) {
        SharedPrefX sp = BLKV.getBLSharedPreferences(FoundationAlias.getFapp(), new File(this$0.dir, this$0.typed.getDataSpName()), true, this$0.typed.getDataSize());
        sp.registerOnSharedPreferenceChangeListener(this$0.dataListener);
        return sp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MutableSharedFlow<String> getKeyPublisher() {
        return (MutableSharedFlow) this.keyPublisher$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableSharedFlow keyPublisher_delegate$lambda$0(NoopTypedContract this$0) {
        this$0.getDataSp();
        return SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dataListener$lambda$0(NoopTypedContract this$0, SharedPreferences sharedPreferences, String key) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "<unused var>");
        if (key == null) {
            return;
        }
        BuildersKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new NoopTypedContract$dataListener$1$1(this$0, key, null), 3, (Object) null);
    }

    public String getHeaderName() {
        String headerName;
        Contract<T> contract = this.delegate;
        return (contract == null || (headerName = contract.getHeaderName()) == null) ? "" : headerName;
    }

    public Flow<String> getKeyObservable() {
        return (Flow) this.keyObservable$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Flow keyObservable_delegate$lambda$0(NoopTypedContract this$0) {
        if (this$0.delegate != null) {
            return FlowKt.zip(this$0.getKeyPublisher(), this$0.delegate.getKeyObservable(), new NoopTypedContract$keyObservable$2$1(null));
        }
        return this$0.getKeyPublisher();
    }

    public long getVersion() {
        Contract<T> contract = this.delegate;
        if (contract != null) {
            return contract.getVersion();
        }
        return 0L;
    }

    public Flow<Long> getVersionObservable() {
        Flow<Long> versionObservable;
        Contract<T> contract = this.delegate;
        return (contract == null || (versionObservable = contract.getVersionObservable()) == null) ? SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null) : versionObservable;
    }

    public void onVersion(String ver) {
    }

    public Flow<T> getAsync(String key, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        return FlowKt.flowOn(FlowKt.distinctUntilChanged(FlowKt.onCompletion(FlowKt.flow(new NoopTypedContract$getAsync$1(this, key, t, null)), new NoopTypedContract$getAsync$2(this, key, t, null))), Dispatchers.getIO());
    }

    public T get(String key, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t2 = (T) this.getter.invoke(getDataSp(), key, t);
        if (t2 == null) {
            Contract<T> contract = this.delegate;
            T t3 = contract != null ? (T) contract.get(key, t) : null;
            return t3 == null ? t : t3;
        }
        return t2;
    }

    public final void clearData() {
        getDataSp().edit().clear().apply();
    }

    public final SharedPrefX sp() {
        return getDataSp();
    }

    public void clear() {
    }
}