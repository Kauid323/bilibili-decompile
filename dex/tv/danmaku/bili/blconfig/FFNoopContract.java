package tv.danmaku.bili.blconfig;

import android.content.SharedPreferences;
import com.bilibili.lib.blconfig.Contract;
import com.bilibili.lib.blconfig.FeatureFlagContract;
import com.bilibili.lib.blkv.SharedPrefX;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;

/* compiled from: DebugConfigHelper.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002BK\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\t\u0012\"\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0003H\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Ltv/danmaku/bili/blconfig/FFNoopContract;", "Lcom/bilibili/lib/blconfig/FeatureFlagContract;", "Ltv/danmaku/bili/blconfig/NoopTypedContract;", "", "dir", "Ljava/io/File;", "typed", "Ltv/danmaku/bili/blconfig/DebugTyped;", "delegate", "Lcom/bilibili/lib/blconfig/Contract;", "getter", "Lkotlin/Function3;", "Landroid/content/SharedPreferences;", "", "<init>", "(Ljava/io/File;Ltv/danmaku/bili/blconfig/DebugTyped;Lcom/bilibili/lib/blconfig/Contract;Lkotlin/jvm/functions/Function3;)V", "d", "getWithDefault", "key", "defaultValue", "core_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public final class FFNoopContract extends NoopTypedContract<Boolean> implements FeatureFlagContract {
    public static final int $stable = 8;
    private final FeatureFlagContract d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FFNoopContract(File dir, DebugTyped typed, Contract<Boolean> contract, Function3<? super SharedPreferences, ? super String, ? super Boolean, Boolean> function3) {
        super(dir, typed, contract, function3);
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(typed, "typed");
        Intrinsics.checkNotNullParameter(function3, "getter");
        this.d = contract instanceof FeatureFlagContract ? (FeatureFlagContract) contract : null;
    }

    public boolean getWithDefault(String key, boolean defaultValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Function3<SharedPreferences, String, Boolean, Boolean> getter = getGetter();
        SharedPrefX dataSp = getDataSp();
        FeatureFlagContract featureFlagContract = this.d;
        Boolean bool = (Boolean) getter.invoke(dataSp, key, featureFlagContract != null ? Boolean.valueOf(featureFlagContract.getWithDefault(key, defaultValue)) : null);
        return bool != null ? bool.booleanValue() : defaultValue;
    }
}