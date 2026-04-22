package im.chat.sticker.migration;

import java.util.List;
import kntr.base.config.SerializableSharedPreferencesProperty;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.SerializersKt;

/* compiled from: StickerMigration.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006J\b\u0010\u0013\u001a\u00020\u0011H\u0007R7\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\t¨\u0006\u0014"}, d2 = {"Lim/chat/sticker/migration/MigrationStorage;", "", "<init>", "()V", "<set-?>", "", "", "_migratedMid", "get_migratedMid", "()Ljava/util/List;", "set_migratedMid", "(Ljava/util/List;)V", "_migratedMid$delegate", "Lkntr/base/config/SerializableSharedPreferencesProperty;", "migratedMid", "getMigratedMid", "addMigratedMid", "", "mid", "clear", "migration_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MigrationStorage {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(MigrationStorage.class, "_migratedMid", "get_migratedMid()Ljava/util/List;", 0))};
    private final SerializableSharedPreferencesProperty _migratedMid$delegate;

    public MigrationStorage() {
        Function0 initializer$iv = new Function0() { // from class: im.chat.sticker.migration.MigrationStorage$$ExternalSyntheticLambda0
            public final Object invoke() {
                List _migratedMid_delegate$lambda$0;
                _migratedMid_delegate$lambda$0 = MigrationStorage._migratedMid_delegate$lambda$0();
                return _migratedMid_delegate$lambda$0;
            }
        };
        KType typeOf = Reflection.typeOf(List.class, KTypeProjection.Companion.invariant(Reflection.typeOf(Long.TYPE)));
        MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.simple");
        this._migratedMid$delegate = new SerializableSharedPreferencesProperty("im_sticker", false, SerializersKt.serializer(typeOf), "migrated_mid", initializer$iv, (Function2) null);
    }

    private final List<Long> get_migratedMid() {
        return (List) this._migratedMid$delegate.getValue(this, $$delegatedProperties[0]);
    }

    private final void set_migratedMid(List<Long> list) {
        this._migratedMid$delegate.setValue(this, $$delegatedProperties[0], list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List _migratedMid_delegate$lambda$0() {
        return CollectionsKt.emptyList();
    }

    public final List<Long> getMigratedMid() {
        return get_migratedMid();
    }

    public final void addMigratedMid(long mid) {
        if (!get_migratedMid().contains(Long.valueOf(mid))) {
            set_migratedMid(CollectionsKt.plus(get_migratedMid(), Long.valueOf(mid)));
        }
    }

    public final void clear() {
        set_migratedMid(CollectionsKt.emptyList());
    }
}