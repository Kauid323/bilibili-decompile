package kntr.watch.later.watchlater.consts;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.PrimitiveSharedPreferencesProperty;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* compiled from: WatchLaterConsts.android.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080D¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"CREATE_COLLECTION_URL", "", "getCREATE_COLLECTION_URL", "()Ljava/lang/String;", "SP_NAME", "<set-?>", "", "watchLaterInitialPageIndex", "getWatchLaterInitialPageIndex", "()I", "setWatchLaterInitialPageIndex", "(I)V", "watchLaterInitialPageIndex$delegate", "Lkntr/base/config/PrimitiveSharedPreferencesProperty;", "watch_later_debug"}, k = 2, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class WatchLaterConsts_androidKt {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty0(new MutablePropertyReference0Impl(WatchLaterConsts_androidKt.class, "watchLaterInitialPageIndex", "getWatchLaterInitialPageIndex()I", 1))};
    private static final String CREATE_COLLECTION_URL = "activity://playset/box/create";
    public static final String SP_NAME = "instance.bili_preference";
    private static final PrimitiveSharedPreferencesProperty watchLaterInitialPageIndex$delegate = new PrimitiveSharedPreferencesProperty(SP_NAME, "watch_later_initial_page_index", Reflection.getOrCreateKotlinClass(Integer.TYPE), false, new Function0() { // from class: kntr.watch.later.watchlater.consts.WatchLaterConsts_androidKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            int watchLaterInitialPageIndex_delegate$lambda$0;
            watchLaterInitialPageIndex_delegate$lambda$0 = WatchLaterConsts_androidKt.watchLaterInitialPageIndex_delegate$lambda$0();
            return Integer.valueOf(watchLaterInitialPageIndex_delegate$lambda$0);
        }
    }, 8, null);

    public static final String getCREATE_COLLECTION_URL() {
        return CREATE_COLLECTION_URL;
    }

    public static final int getWatchLaterInitialPageIndex() {
        return ((Number) watchLaterInitialPageIndex$delegate.getValue(null, $$delegatedProperties[0])).intValue();
    }

    public static final void setWatchLaterInitialPageIndex(int i) {
        watchLaterInitialPageIndex$delegate.setValue(null, $$delegatedProperties[0], Integer.valueOf(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int watchLaterInitialPageIndex_delegate$lambda$0() {
        return 0;
    }
}