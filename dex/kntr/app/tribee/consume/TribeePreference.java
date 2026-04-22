package kntr.app.tribee.consume;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.config.SerializableSharedPreferencesProperty;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.LongSerializer;

/* compiled from: TribeePreference.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u000f\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R+\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR+\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0012\u0010\f\"\u0004\b\u0013\u0010\u000eR+\u0010\u0015\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0010\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR+\u0010\u0019\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u00188F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR+\u0010\u001f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0010\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR+\u0010#\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b&\u0010\u0010\u001a\u0004\b$\u0010\f\"\u0004\b%\u0010\u000e¨\u0006'"}, d2 = {"Lkntr/app/tribee/consume/TribeePreference;", "", "<init>", "()V", "SP_USER_CENTER", "", "SP_STEAM", "SP_REPOST", "<set-?>", "", "hasDidTapEntryGameStats", "getHasDidTapEntryGameStats", "()Z", "setHasDidTapEntryGameStats", "(Z)V", "hasDidTapEntryGameStats$delegate", "Lkntr/base/config/SerializableSharedPreferencesProperty;", "showRevisitGuide", "getShowRevisitGuide", "setShowRevisitGuide", "showRevisitGuide$delegate", "isShowAllGamePreferences", "setShowAllGamePreferences", "isShowAllGamePreferences$delegate", "", "defaultRepostTribeeId", "getDefaultRepostTribeeId", "()J", "setDefaultRepostTribeeId", "(J)V", "defaultRepostTribeeId$delegate", "enableRepostToFollowing", "getEnableRepostToFollowing", "setEnableRepostToFollowing", "enableRepostToFollowing$delegate", "enableRepostWithSource", "getEnableRepostWithSource", "setEnableRepostWithSource", "enableRepostWithSource$delegate", "consume_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class TribeePreference {
    public static final int $stable;
    public static final String SP_REPOST = "tribee_repost";
    public static final String SP_STEAM = "tribee_steam_home";
    public static final String SP_USER_CENTER = "tribee_home_user_center";
    private static final SerializableSharedPreferencesProperty defaultRepostTribeeId$delegate;
    private static final SerializableSharedPreferencesProperty enableRepostToFollowing$delegate;
    private static final SerializableSharedPreferencesProperty enableRepostWithSource$delegate;
    private static final SerializableSharedPreferencesProperty hasDidTapEntryGameStats$delegate;
    private static final SerializableSharedPreferencesProperty isShowAllGamePreferences$delegate;
    private static final SerializableSharedPreferencesProperty showRevisitGuide$delegate;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(TribeePreference.class, "hasDidTapEntryGameStats", "getHasDidTapEntryGameStats()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TribeePreference.class, "showRevisitGuide", "getShowRevisitGuide()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TribeePreference.class, "isShowAllGamePreferences", "isShowAllGamePreferences()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TribeePreference.class, "defaultRepostTribeeId", "getDefaultRepostTribeeId()J", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TribeePreference.class, "enableRepostToFollowing", "getEnableRepostToFollowing()Z", 0)), Reflection.mutableProperty1(new MutablePropertyReference1Impl(TribeePreference.class, "enableRepostWithSource", "getEnableRepostWithSource()Z", 0))};
    public static final TribeePreference INSTANCE = new TribeePreference();

    private TribeePreference() {
    }

    public final boolean getHasDidTapEntryGameStats() {
        return ((Boolean) hasDidTapEntryGameStats$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setHasDidTapEntryGameStats(boolean z) {
        hasDidTapEntryGameStats$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean hasDidTapEntryGameStats_delegate$lambda$0() {
        return false;
    }

    public final boolean getShowRevisitGuide() {
        return ((Boolean) showRevisitGuide$delegate.getValue(this, $$delegatedProperties[1])).booleanValue();
    }

    public final void setShowRevisitGuide(boolean z) {
        showRevisitGuide$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean showRevisitGuide_delegate$lambda$0() {
        return true;
    }

    public final boolean isShowAllGamePreferences() {
        return ((Boolean) isShowAllGamePreferences$delegate.getValue(this, $$delegatedProperties[2])).booleanValue();
    }

    public final void setShowAllGamePreferences(boolean z) {
        isShowAllGamePreferences$delegate.setValue(this, $$delegatedProperties[2], Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isShowAllGamePreferences_delegate$lambda$0() {
        return false;
    }

    public final long getDefaultRepostTribeeId() {
        return ((Number) defaultRepostTribeeId$delegate.getValue(this, $$delegatedProperties[3])).longValue();
    }

    public final void setDefaultRepostTribeeId(long j) {
        defaultRepostTribeeId$delegate.setValue(this, $$delegatedProperties[3], Long.valueOf(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long defaultRepostTribeeId_delegate$lambda$0() {
        return 0L;
    }

    public final boolean getEnableRepostToFollowing() {
        return ((Boolean) enableRepostToFollowing$delegate.getValue(this, $$delegatedProperties[4])).booleanValue();
    }

    public final void setEnableRepostToFollowing(boolean z) {
        enableRepostToFollowing$delegate.setValue(this, $$delegatedProperties[4], Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enableRepostToFollowing_delegate$lambda$0() {
        return true;
    }

    public final boolean getEnableRepostWithSource() {
        return ((Boolean) enableRepostWithSource$delegate.getValue(this, $$delegatedProperties[5])).booleanValue();
    }

    public final void setEnableRepostWithSource(boolean z) {
        enableRepostWithSource$delegate.setValue(this, $$delegatedProperties[5], Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enableRepostWithSource_delegate$lambda$0() {
        return true;
    }

    static {
        Function0 initializer$iv = new Function0() { // from class: kntr.app.tribee.consume.TribeePreference$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean hasDidTapEntryGameStats_delegate$lambda$0;
                hasDidTapEntryGameStats_delegate$lambda$0 = TribeePreference.hasDidTapEntryGameStats_delegate$lambda$0();
                return Boolean.valueOf(hasDidTapEntryGameStats_delegate$lambda$0);
            }
        };
        hasDidTapEntryGameStats$delegate = new SerializableSharedPreferencesProperty(SP_USER_CENTER, false, BooleanSerializer.INSTANCE, "game_stats", initializer$iv, null);
        Function0 initializer$iv2 = new Function0() { // from class: kntr.app.tribee.consume.TribeePreference$$ExternalSyntheticLambda1
            public final Object invoke() {
                boolean showRevisitGuide_delegate$lambda$0;
                showRevisitGuide_delegate$lambda$0 = TribeePreference.showRevisitGuide_delegate$lambda$0();
                return Boolean.valueOf(showRevisitGuide_delegate$lambda$0);
            }
        };
        showRevisitGuide$delegate = new SerializableSharedPreferencesProperty(SP_USER_CENTER, false, BooleanSerializer.INSTANCE, "show_revisit_guide", initializer$iv2, null);
        Function0 initializer$iv3 = new Function0() { // from class: kntr.app.tribee.consume.TribeePreference$$ExternalSyntheticLambda2
            public final Object invoke() {
                boolean isShowAllGamePreferences_delegate$lambda$0;
                isShowAllGamePreferences_delegate$lambda$0 = TribeePreference.isShowAllGamePreferences_delegate$lambda$0();
                return Boolean.valueOf(isShowAllGamePreferences_delegate$lambda$0);
            }
        };
        isShowAllGamePreferences$delegate = new SerializableSharedPreferencesProperty(SP_STEAM, false, BooleanSerializer.INSTANCE, "show_all_game", initializer$iv3, null);
        Function0 initializer$iv4 = new Function0() { // from class: kntr.app.tribee.consume.TribeePreference$$ExternalSyntheticLambda3
            public final Object invoke() {
                long defaultRepostTribeeId_delegate$lambda$0;
                defaultRepostTribeeId_delegate$lambda$0 = TribeePreference.defaultRepostTribeeId_delegate$lambda$0();
                return Long.valueOf(defaultRepostTribeeId_delegate$lambda$0);
            }
        };
        defaultRepostTribeeId$delegate = new SerializableSharedPreferencesProperty(SP_REPOST, false, LongSerializer.INSTANCE, "default_repost_tribee_id", initializer$iv4, null);
        Function0 initializer$iv5 = new Function0() { // from class: kntr.app.tribee.consume.TribeePreference$$ExternalSyntheticLambda4
            public final Object invoke() {
                boolean enableRepostToFollowing_delegate$lambda$0;
                enableRepostToFollowing_delegate$lambda$0 = TribeePreference.enableRepostToFollowing_delegate$lambda$0();
                return Boolean.valueOf(enableRepostToFollowing_delegate$lambda$0);
            }
        };
        enableRepostToFollowing$delegate = new SerializableSharedPreferencesProperty(SP_REPOST, false, BooleanSerializer.INSTANCE, "enable_repost_to_following", initializer$iv5, null);
        Function0 initializer$iv6 = new Function0() { // from class: kntr.app.tribee.consume.TribeePreference$$ExternalSyntheticLambda5
            public final Object invoke() {
                boolean enableRepostWithSource_delegate$lambda$0;
                enableRepostWithSource_delegate$lambda$0 = TribeePreference.enableRepostWithSource_delegate$lambda$0();
                return Boolean.valueOf(enableRepostWithSource_delegate$lambda$0);
            }
        };
        enableRepostWithSource$delegate = new SerializableSharedPreferencesProperty(SP_REPOST, false, BooleanSerializer.INSTANCE, "enable_repost_with_source", initializer$iv6, null);
        $stable = 8;
    }
}