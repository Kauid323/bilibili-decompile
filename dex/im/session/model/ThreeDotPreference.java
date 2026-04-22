package im.session.model;

import kntr.base.config.SerializableSharedPreferencesProperty;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.serialization.internal.BooleanSerializer;

/* compiled from: IMThreeDotItem.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lim/session/model/ThreeDotPreference;", "", "<init>", "()V", "<set-?>", "", "hasVisitPushMsg", "getHasVisitPushMsg", "()Z", "setHasVisitPushMsg", "(Z)V", "hasVisitPushMsg$delegate", "Lkntr/base/config/SerializableSharedPreferencesProperty;", "session_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ThreeDotPreference {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(ThreeDotPreference.class, "hasVisitPushMsg", "getHasVisitPushMsg()Z", 0))};
    private final SerializableSharedPreferencesProperty hasVisitPushMsg$delegate;

    public ThreeDotPreference() {
        Function0 initializer$iv = new Function0() { // from class: im.session.model.ThreeDotPreference$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean hasVisitPushMsg_delegate$lambda$0;
                hasVisitPushMsg_delegate$lambda$0 = ThreeDotPreference.hasVisitPushMsg_delegate$lambda$0();
                return Boolean.valueOf(hasVisitPushMsg_delegate$lambda$0);
            }
        };
        this.hasVisitPushMsg$delegate = new SerializableSharedPreferencesProperty("im_session_three_dot", false, BooleanSerializer.INSTANCE, "push_msg", initializer$iv, (Function2) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasVisitPushMsg_delegate$lambda$0() {
        return false;
    }

    public final boolean getHasVisitPushMsg() {
        return ((Boolean) this.hasVisitPushMsg$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setHasVisitPushMsg(boolean z) {
        this.hasVisitPushMsg$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }
}