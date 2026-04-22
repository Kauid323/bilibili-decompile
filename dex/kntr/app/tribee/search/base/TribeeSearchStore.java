package kntr.app.tribee.search.base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.SerializableSharedPreferencesProperty;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializersKt;

/* compiled from: TribeeSearchStore.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\u0016\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0005J\u0006\u0010\u0019\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000RS\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b\u0018\u00010\n2\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b\u0018\u00010\n8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lkntr/app/tribee/search/base/TribeeSearchStore;", "", "<init>", "()V", "SP_NAME", "", "SEARCH_HISTORY_KEY", "MAX_HISTORY_SIZE", "", "<set-?>", "", "", "searchHistoryPreference", "getSearchHistoryPreference", "()Ljava/util/Map;", "setSearchHistoryPreference", "(Ljava/util/Map;)V", "searchHistoryPreference$delegate", "Lkntr/base/config/SerializableSharedPreferencesProperty;", "store", "", "keyword", "tribeeId", "getHistories", "clearSearchHistory", "clearAllSearchHistory", "search_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeeSearchStore {
    public static final int $stable;
    private static final int MAX_HISTORY_SIZE = 50;
    private static final String SEARCH_HISTORY_KEY = "search-history";
    private static final String SP_NAME = "tribee-search";
    private static final SerializableSharedPreferencesProperty searchHistoryPreference$delegate;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(TribeeSearchStore.class, "searchHistoryPreference", "getSearchHistoryPreference()Ljava/util/Map;", 0))};
    public static final TribeeSearchStore INSTANCE = new TribeeSearchStore();

    private TribeeSearchStore() {
    }

    private final Map<String, List<String>> getSearchHistoryPreference() {
        return (Map) searchHistoryPreference$delegate.getValue(this, $$delegatedProperties[0]);
    }

    private final void setSearchHistoryPreference(Map<String, ? extends List<String>> map) {
        searchHistoryPreference$delegate.setValue(this, $$delegatedProperties[0], map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map searchHistoryPreference_delegate$lambda$0() {
        return null;
    }

    public final void store(String keyword, String tribeeId) {
        ArrayList currentHistory;
        List trimmedHistory;
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        if (StringsKt.isBlank(keyword)) {
            return;
        }
        Map currentMap = getSearchHistoryPreference();
        if (currentMap == null) {
            currentMap = MapsKt.emptyMap();
        }
        List<String> list = currentMap.get(tribeeId);
        if (list == null || (currentHistory = CollectionsKt.toMutableList(list)) == null) {
            currentHistory = new ArrayList();
        }
        currentHistory.remove(keyword);
        currentHistory.add(0, keyword);
        if (currentHistory.size() > 50) {
            trimmedHistory = CollectionsKt.take(currentHistory, 50);
        } else {
            trimmedHistory = currentHistory;
        }
        Map $this$store_u24lambda_u240 = MapsKt.toMutableMap(currentMap);
        $this$store_u24lambda_u240.put(tribeeId, trimmedHistory);
        setSearchHistoryPreference($this$store_u24lambda_u240);
    }

    public final List<String> getHistories(String tribeeId) {
        List<String> list;
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Map<String, List<String>> searchHistoryPreference = getSearchHistoryPreference();
        return (searchHistoryPreference == null || (list = searchHistoryPreference.get(tribeeId)) == null) ? CollectionsKt.emptyList() : list;
    }

    public final void clearSearchHistory(String tribeeId) {
        Intrinsics.checkNotNullParameter(tribeeId, "tribeeId");
        Map currentMap = getSearchHistoryPreference();
        if (currentMap == null) {
            return;
        }
        Map $this$clearSearchHistory_u24lambda_u240 = MapsKt.toMutableMap(currentMap);
        $this$clearSearchHistory_u24lambda_u240.remove(tribeeId);
        setSearchHistoryPreference($this$clearSearchHistory_u24lambda_u240);
    }

    public final void clearAllSearchHistory() {
        setSearchHistoryPreference(null);
    }

    static {
        Function0 initializer$iv = new Function0() { // from class: kntr.app.tribee.search.base.TribeeSearchStore$$ExternalSyntheticLambda0
            public final Object invoke() {
                Map searchHistoryPreference_delegate$lambda$0;
                searchHistoryPreference_delegate$lambda$0 = TribeeSearchStore.searchHistoryPreference_delegate$lambda$0();
                return searchHistoryPreference_delegate$lambda$0;
            }
        };
        KType nullableTypeOf = Reflection.nullableTypeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)))));
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        searchHistoryPreference$delegate = new SerializableSharedPreferencesProperty(SP_NAME, false, SerializersKt.serializer(nullableTypeOf), SEARCH_HISTORY_KEY, initializer$iv, null);
        $stable = 8;
    }
}