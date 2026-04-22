package im.chat.sticker.migration;

import java.util.List;
import kntr.app.im.chat.sticker.service.StickerManagerService;
import kntr.base.account.AccountState;
import kntr.base.log.KLog_androidKt;
import kntr.common.photonic.Asset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StickerMigration.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
public final class StickerMigrationKt$performMigration$3<T> implements FlowCollector {
    final /* synthetic */ LegacyStickerCollectionProvider $provider;
    final /* synthetic */ StickerManagerService $service;
    final /* synthetic */ MigrationStorage $storage;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StickerMigrationKt$performMigration$3(LegacyStickerCollectionProvider legacyStickerCollectionProvider, MigrationStorage migrationStorage, StickerManagerService stickerManagerService) {
        this.$provider = legacyStickerCollectionProvider;
        this.$storage = migrationStorage;
        this.$service = stickerManagerService;
    }

    public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
        return emit((AccountState.Logged) value, (Continuation<? super Unit>) $completion);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emit(AccountState.Logged it, Continuation<? super Unit> continuation) {
        StickerMigrationKt$performMigration$3$emit$1 stickerMigrationKt$performMigration$3$emit$1;
        Ref.IntRef totalCount;
        Ref.IntRef failedCount;
        if (continuation instanceof StickerMigrationKt$performMigration$3$emit$1) {
            stickerMigrationKt$performMigration$3$emit$1 = (StickerMigrationKt$performMigration$3$emit$1) continuation;
            if ((stickerMigrationKt$performMigration$3$emit$1.label & Integer.MIN_VALUE) != 0) {
                stickerMigrationKt$performMigration$3$emit$1.label -= Integer.MIN_VALUE;
                Object $result = stickerMigrationKt$performMigration$3$emit$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (stickerMigrationKt$performMigration$3$emit$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        totalCount = new Ref.IntRef();
                        Ref.IntRef failedCount2 = new Ref.IntRef();
                        stickerMigrationKt$performMigration$3$emit$1.L$0 = it;
                        stickerMigrationKt$performMigration$3$emit$1.L$1 = totalCount;
                        stickerMigrationKt$performMigration$3$emit$1.L$2 = failedCount2;
                        stickerMigrationKt$performMigration$3$emit$1.label = 1;
                        if (this.$provider.getLegacyStickerCollection().collect(new AnonymousClass1(totalCount, failedCount2, this.$service), stickerMigrationKt$performMigration$3$emit$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        failedCount = failedCount2;
                        break;
                    case 1:
                        failedCount = (Ref.IntRef) stickerMigrationKt$performMigration$3$emit$1.L$2;
                        totalCount = (Ref.IntRef) stickerMigrationKt$performMigration$3$emit$1.L$1;
                        it = (AccountState.Logged) stickerMigrationKt$performMigration$3$emit$1.L$0;
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                KLog_androidKt.getKLog().i("StickerMigration", "Migration completed for mid: " + it.getUserInfo().getMid() + ", total: " + totalCount.element + ", failed: " + failedCount.element);
                this.$storage.addMigratedMid(it.getUserInfo().getMid());
                return Unit.INSTANCE;
            }
        }
        stickerMigrationKt$performMigration$3$emit$1 = new StickerMigrationKt$performMigration$3$emit$1(this, continuation);
        Object $result2 = stickerMigrationKt$performMigration$3$emit$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (stickerMigrationKt$performMigration$3$emit$1.label) {
        }
        KLog_androidKt.getKLog().i("StickerMigration", "Migration completed for mid: " + it.getUserInfo().getMid() + ", total: " + totalCount.element + ", failed: " + failedCount.element);
        this.$storage.addMigratedMid(it.getUserInfo().getMid());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StickerMigration.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: im.chat.sticker.migration.StickerMigrationKt$performMigration$3$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
    public static final class AnonymousClass1<T> implements FlowCollector {
        final /* synthetic */ Ref.IntRef $failedCount;
        final /* synthetic */ StickerManagerService $service;
        final /* synthetic */ Ref.IntRef $totalCount;

        AnonymousClass1(Ref.IntRef intRef, Ref.IntRef intRef2, StickerManagerService stickerManagerService) {
            this.$totalCount = intRef;
            this.$failedCount = intRef2;
            this.$service = stickerManagerService;
        }

        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
            return emit((Asset) value, (Continuation<? super Unit>) $completion);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:13:0x003c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(Asset it, Continuation<? super Unit> continuation) {
            StickerMigrationKt$performMigration$3$1$emit$1 stickerMigrationKt$performMigration$3$1$emit$1;
            Ref.IntRef intRef;
            Object saveStickers;
            int i2;
            if (continuation instanceof StickerMigrationKt$performMigration$3$1$emit$1) {
                stickerMigrationKt$performMigration$3$1$emit$1 = (StickerMigrationKt$performMigration$3$1$emit$1) continuation;
                if ((stickerMigrationKt$performMigration$3$1$emit$1.label & Integer.MIN_VALUE) != 0) {
                    stickerMigrationKt$performMigration$3$1$emit$1.label -= Integer.MIN_VALUE;
                    Object $result = stickerMigrationKt$performMigration$3$1$emit$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (stickerMigrationKt$performMigration$3$1$emit$1.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            this.$totalCount.element++;
                            intRef = this.$failedCount;
                            int i3 = this.$failedCount.element;
                            StickerManagerService stickerManagerService = this.$service;
                            List listOf = CollectionsKt.listOf(it);
                            stickerMigrationKt$performMigration$3$1$emit$1.L$0 = SpillingKt.nullOutSpilledVariable(it);
                            stickerMigrationKt$performMigration$3$1$emit$1.L$1 = intRef;
                            stickerMigrationKt$performMigration$3$1$emit$1.I$0 = i3;
                            stickerMigrationKt$performMigration$3$1$emit$1.label = 1;
                            saveStickers = stickerManagerService.saveStickers(listOf, stickerMigrationKt$performMigration$3$1$emit$1);
                            if (saveStickers == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            i2 = i3;
                            break;
                        case 1:
                            i2 = stickerMigrationKt$performMigration$3$1$emit$1.I$0;
                            intRef = (Ref.IntRef) stickerMigrationKt$performMigration$3$1$emit$1.L$1;
                            Asset asset = (Asset) stickerMigrationKt$performMigration$3$1$emit$1.L$0;
                            ResultKt.throwOnFailure($result);
                            saveStickers = $result;
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    intRef.element = i2 + ((Number) saveStickers).intValue();
                    return Unit.INSTANCE;
                }
            }
            stickerMigrationKt$performMigration$3$1$emit$1 = new StickerMigrationKt$performMigration$3$1$emit$1(this, continuation);
            Object $result2 = stickerMigrationKt$performMigration$3$1$emit$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (stickerMigrationKt$performMigration$3$1$emit$1.label) {
            }
            intRef.element = i2 + ((Number) saveStickers).intValue();
            return Unit.INSTANCE;
        }
    }
}