package im.chat.sticker.migration;

import com.bilibili.lib.gripper.api.PreTrigger;
import com.tencent.smtt.sdk.TbsListener;
import im.base.config.IMConfigSetting;
import kntr.app.im.chat.sticker.service.StickerManagerService;
import kntr.base.account.AccountState;
import kntr.base.account.KAccountStore;
import kntr.base.log.KLog_androidKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* compiled from: StickerMigration.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0087@¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"performMigration", "", "provider", "Lim/chat/sticker/migration/LegacyStickerCollectionProvider;", "service", "Lkntr/app/im/chat/sticker/service/StickerManagerService;", "accountStore", "Lkntr/base/account/KAccountStore;", "config", "Lim/base/config/IMConfigSetting;", "(Lim/chat/sticker/migration/LegacyStickerCollectionProvider;Lkntr/app/im/chat/sticker/service/StickerManagerService;Lkntr/base/account/KAccountStore;Lim/base/config/IMConfigSetting;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "migration_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class StickerMigrationKt {
    @PreTrigger(trigger = "OnPrivacyAllowed")
    public static final Object performMigration(LegacyStickerCollectionProvider provider, StickerManagerService service, KAccountStore accountStore, IMConfigSetting config, Continuation<? super Unit> continuation) {
        if (config.getBffChatEnabled()) {
            KLog_androidKt.getKLog().i("StickerMigration", "BFF chat is enabled, start migration.");
            final MigrationStorage storage = new MigrationStorage();
            final Flow $this$filterIsInstance$iv = accountStore.getState();
            final Flow $this$filter$iv = new Flow<Object>() { // from class: im.chat.sticker.migration.StickerMigrationKt$performMigration$$inlined$filterIsInstance$1

                /* compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", "kotlinx/coroutines/flow/FlowKt__TransformKt$filterIsInstance$$inlined$filter$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                /* renamed from: im.chat.sticker.migration.StickerMigrationKt$performMigration$$inlined$filterIsInstance$1$2  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "im.chat.sticker.migration.StickerMigrationKt$performMigration$$inlined$filterIsInstance$1$2", f = "StickerMigration.kt", i = {0, 0, 0, 0, 0}, l = {TbsListener.ErrorCode.RENAME_EXCEPTION}, m = "emit", n = {"value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                    /* renamed from: im.chat.sticker.migration.StickerMigrationKt$performMigration$$inlined$filterIsInstance$1$2$1  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, (Continuation) this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector) {
                        this.$this_unsafeFlow = flowCollector;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
                    /* JADX WARN: Removed duplicated region for block: B:13:0x003e  */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object value, Continuation $completion) {
                        Continuation $continuation;
                        if ($completion instanceof AnonymousClass1) {
                            $continuation = (AnonymousClass1) $completion;
                            if (($continuation.label & Integer.MIN_VALUE) != 0) {
                                $continuation.label -= Integer.MIN_VALUE;
                                Object $result = $continuation.result;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch ($continuation.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        FlowCollector $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                                        AnonymousClass1 anonymousClass1 = $continuation;
                                        if (value instanceof AccountState.Logged) {
                                            $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                            $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                            $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                            $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$filter_u24lambda_u240);
                                            $continuation.I$0 = 0;
                                            $continuation.label = 1;
                                            if ($this$filter_u24lambda_u240.emit(value, $continuation) != coroutine_suspended) {
                                                break;
                                            } else {
                                                return coroutine_suspended;
                                            }
                                        }
                                        break;
                                    case 1:
                                        int i2 = $continuation.I$0;
                                        FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                        Object obj = $continuation.L$2;
                                        AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
                                        Object value2 = $continuation.L$0;
                                        ResultKt.throwOnFailure($result);
                                        break;
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        $continuation = new AnonymousClass1($completion);
                        Object $result2 = $continuation.result;
                        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch ($continuation.label) {
                        }
                        return Unit.INSTANCE;
                    }
                }

                public Object collect(FlowCollector collector, Continuation $completion) {
                    Object collect = $this$filterIsInstance$iv.collect(new AnonymousClass2(collector), $completion);
                    return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                }
            };
            Object collect = new Flow<AccountState.Logged>() { // from class: im.chat.sticker.migration.StickerMigrationKt$performMigration$$inlined$filter$1

                /* compiled from: Emitters.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2"}, k = 3, mv = {2, 2, 0}, xi = 48)
                /* renamed from: im.chat.sticker.migration.StickerMigrationKt$performMigration$$inlined$filter$1$2  reason: invalid class name */
                /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                public static final class AnonymousClass2<T> implements FlowCollector {
                    final /* synthetic */ MigrationStorage $storage$inlined;
                    final /* synthetic */ FlowCollector $this_unsafeFlow;

                    /* compiled from: Emitters.kt */
                    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
                    @DebugMetadata(c = "im.chat.sticker.migration.StickerMigrationKt$performMigration$$inlined$filter$1$2", f = "StickerMigration.kt", i = {0, 0, 0, 0, 0}, l = {TbsListener.ErrorCode.RENAME_EXCEPTION}, m = "emit", n = {"value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 1)
                    /* renamed from: im.chat.sticker.migration.StickerMigrationKt$performMigration$$inlined$filter$1$2$1  reason: invalid class name */
                    /* loaded from: /data/np/file-convert/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f/202602280712075a92ca67-5c1c-4f01-bfdc-12257d748e5f.dex */
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        int I$0;
                        Object L$0;
                        Object L$1;
                        Object L$2;
                        Object L$3;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, (Continuation) this);
                        }
                    }

                    public AnonymousClass2(FlowCollector flowCollector, MigrationStorage migrationStorage) {
                        this.$this_unsafeFlow = flowCollector;
                        this.$storage$inlined = migrationStorage;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
                    /* JADX WARN: Removed duplicated region for block: B:12:0x0030  */
                    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object emit(Object value, Continuation $completion) {
                        Continuation $continuation;
                        if ($completion instanceof AnonymousClass1) {
                            $continuation = (AnonymousClass1) $completion;
                            if (($continuation.label & Integer.MIN_VALUE) != 0) {
                                $continuation.label -= Integer.MIN_VALUE;
                                Object $result = $continuation.result;
                                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                switch ($continuation.label) {
                                    case 0:
                                        ResultKt.throwOnFailure($result);
                                        FlowCollector $this$filter_u24lambda_u240 = this.$this_unsafeFlow;
                                        AnonymousClass1 anonymousClass1 = $continuation;
                                        AccountState.Logged account = (AccountState.Logged) value;
                                        boolean it = this.$storage$inlined.getMigratedMid().contains(Boxing.boxLong(account.getUserInfo().getMid()));
                                        KLog_androidKt.getKLog().i("StickerMigration", "Check migration for mid: " + account.getUserInfo().getMid() + ", migrated: " + (it));
                                        if (!it) {
                                            $continuation.L$0 = SpillingKt.nullOutSpilledVariable(value);
                                            $continuation.L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                                            $continuation.L$2 = SpillingKt.nullOutSpilledVariable(value);
                                            $continuation.L$3 = SpillingKt.nullOutSpilledVariable($this$filter_u24lambda_u240);
                                            $continuation.I$0 = 0;
                                            $continuation.label = 1;
                                            if ($this$filter_u24lambda_u240.emit(value, $continuation) != coroutine_suspended) {
                                                break;
                                            } else {
                                                return coroutine_suspended;
                                            }
                                        } else {
                                            break;
                                        }
                                    case 1:
                                        int i2 = $continuation.I$0;
                                        FlowCollector flowCollector = (FlowCollector) $continuation.L$3;
                                        Object obj = $continuation.L$2;
                                        AnonymousClass1 anonymousClass12 = (AnonymousClass1) $continuation.L$1;
                                        Object obj2 = $continuation.L$0;
                                        ResultKt.throwOnFailure($result);
                                        break;
                                    default:
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                return Unit.INSTANCE;
                            }
                        }
                        $continuation = new AnonymousClass1($completion);
                        Object $result2 = $continuation.result;
                        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch ($continuation.label) {
                        }
                        return Unit.INSTANCE;
                    }
                }

                public Object collect(FlowCollector collector, Continuation $completion) {
                    Object collect2 = $this$filter$iv.collect(new AnonymousClass2(collector, storage), $completion);
                    return collect2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect2 : Unit.INSTANCE;
                }
            }.collect(new StickerMigrationKt$performMigration$3(provider, storage, service), continuation);
            return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
        }
        KLog_androidKt.getKLog().i("StickerMigration", "BFF chat is not enabled, skipping migration.");
        return Unit.INSTANCE;
    }
}