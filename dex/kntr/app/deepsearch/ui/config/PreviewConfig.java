package kntr.app.deepsearch.ui.config;

import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.config.SerializableSharedPreferencesProperty;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.serialization.internal.BooleanSerializer;

/* compiled from: PreviewConfig.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lkntr/app/deepsearch/ui/config/PreviewConfig;", RoomRecommendViewModel.EMPTY_CURSOR, "<init>", "()V", "<set-?>", RoomRecommendViewModel.EMPTY_CURSOR, "showType", "getShowType", "()Z", "setShowType", "(Z)V", "showType$delegate", "Lkntr/base/config/SerializableSharedPreferencesProperty;", "compose_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewConfig {
    public static final int $stable;
    private static final SerializableSharedPreferencesProperty showType$delegate;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(PreviewConfig.class, "showType", "getShowType()Z", 0))};
    public static final PreviewConfig INSTANCE = new PreviewConfig();

    private PreviewConfig() {
    }

    public final boolean getShowType() {
        return ((Boolean) showType$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setShowType(boolean z) {
        showType$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showType_delegate$lambda$0() {
        return false;
    }

    static {
        Function0 initializer$iv = new Function0() { // from class: kntr.app.deepsearch.ui.config.PreviewConfig$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean showType_delegate$lambda$0;
                showType_delegate$lambda$0 = PreviewConfig.showType_delegate$lambda$0();
                return Boolean.valueOf(showType_delegate$lambda$0);
            }
        };
        showType$delegate = new SerializableSharedPreferencesProperty("deepsearch", false, BooleanSerializer.INSTANCE, "showType", initializer$iv, (Function2) null);
        $stable = 8;
    }
}