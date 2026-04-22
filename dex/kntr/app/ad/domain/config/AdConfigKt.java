package kntr.app.ad.domain.config;

import kntr.app.ad.common.model.AdKModules;
import kntr.app.ad.common.model.CompressType;
import kntr.app.ad.common.model.MMAReplaceDefault;
import kntr.app.ad.common.model.MMAReplaceUrls;
import kntr.app.ad.common.utils.JsonExtKt;
import kntr.app.ad.common.utils.Logger_androidKt;
import kntr.app.ad.common.utils.StringExtKt;
import kntr.app.live.room.recommend.RoomRecommendViewModel;
import kntr.base.config.IPlatformConfig;
import kntr.base.config.KConfig;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: AdConfig.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\"!\u0010\u0000\u001a\u00020\u00018FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"!\u0010\b\u001a\u00020\u00018FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\u0007\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u0005\"!\u0010\f\u001a\u00020\u00018FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0007\u0012\u0004\b\r\u0010\u0003\u001a\u0004\b\u000e\u0010\u0005\"!\u0010\u0010\u001a\u00020\u00018FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0007\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\u0005\"!\u0010\u0014\u001a\u00020\u00018FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0007\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\u0005\"!\u0010\u0018\u001a\u00020\u00018FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u0007\u0012\u0004\b\u0019\u0010\u0003\u001a\u0004\b\u001a\u0010\u0005\"\u001b\u0010\u001c\u001a\u00020\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u0007\u001a\u0004\b\u001e\u0010\u001f\"\u001d\u0010!\u001a\u0004\u0018\u00010\"8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0007\u001a\u0004\b#\u0010$\"\u001d\u0010&\u001a\u0004\u0018\u00010'8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u0007\u001a\u0004\b(\u0010)\"\u001b\u0010+\u001a\u00020,8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0007\u001a\u0004\b-\u0010.\"!\u00100\u001a\u00020\u00018FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b3\u0010\u0007\u0012\u0004\b1\u0010\u0003\u001a\u0004\b2\u0010\u0005\"!\u00104\u001a\u0002058FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b9\u0010\u0007\u0012\u0004\b6\u0010\u0003\u001a\u0004\b7\u00108¨\u0006:"}, d2 = {"useKNTR", RoomRecommendViewModel.EMPTY_CURSOR, "getUseKNTR$annotations", "()V", "getUseKNTR", "()Z", "useKNTR$delegate", "Lkotlin/Lazy;", "useKNTRExtra", "getUseKNTRExtra$annotations", "getUseKNTRExtra", "useKNTRExtra$delegate", "useKNTRReport", "getUseKNTRReport$annotations", "getUseKNTRReport", "useKNTRReport$delegate", "useKNTRClick", "getUseKNTRClick$annotations", "getUseKNTRClick", "useKNTRClick$delegate", "enableSearch150VM", "getEnableSearch150VM$annotations", "getEnableSearch150VM", "enableSearch150VM$delegate", "enableLiveBrandCardVm", "getEnableLiveBrandCardVm$annotations", "getEnableLiveBrandCardVm", "enableLiveBrandCardVm$delegate", "aesKey", RoomRecommendViewModel.EMPTY_CURSOR, "getAesKey", "()Ljava/lang/String;", "aesKey$delegate", "mmaReplaceUrls", "Lkntr/app/ad/common/model/MMAReplaceUrls;", "getMmaReplaceUrls", "()Lkntr/app/ad/common/model/MMAReplaceUrls;", "mmaReplaceUrls$delegate", "mmaReplaceDefault", "Lkntr/app/ad/common/model/MMAReplaceDefault;", "getMmaReplaceDefault", "()Lkntr/app/ad/common/model/MMAReplaceDefault;", "mmaReplaceDefault$delegate", "httpCompressType", "Lkntr/app/ad/common/model/CompressType;", "getHttpCompressType", "()Lkntr/app/ad/common/model/CompressType;", "httpCompressType$delegate", "useInspector", "getUseInspector$annotations", "getUseInspector", "useInspector$delegate", "kModules", "Lkntr/app/ad/common/model/AdKModules;", "getKModules$annotations", "getKModules", "()Lkntr/app/ad/common/model/AdKModules;", "kModules$delegate", "config_debug"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AdConfigKt {
    private static final Lazy useKNTR$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.config.AdConfigKt$$ExternalSyntheticLambda0
        public final Object invoke() {
            boolean useKNTR_delegate$lambda$0;
            useKNTR_delegate$lambda$0 = AdConfigKt.useKNTR_delegate$lambda$0();
            return Boolean.valueOf(useKNTR_delegate$lambda$0);
        }
    });
    private static final Lazy useKNTRExtra$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.config.AdConfigKt$$ExternalSyntheticLambda5
        public final Object invoke() {
            boolean useKNTRExtra_delegate$lambda$0;
            useKNTRExtra_delegate$lambda$0 = AdConfigKt.useKNTRExtra_delegate$lambda$0();
            return Boolean.valueOf(useKNTRExtra_delegate$lambda$0);
        }
    });
    private static final Lazy useKNTRReport$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: kntr.app.ad.domain.config.AdConfigKt$$ExternalSyntheticLambda6
        public final Object invoke() {
            boolean useKNTRReport_delegate$lambda$0;
            useKNTRReport_delegate$lambda$0 = AdConfigKt.useKNTRReport_delegate$lambda$0();
            return Boolean.valueOf(useKNTRReport_delegate$lambda$0);
        }
    });
    private static final Lazy useKNTRClick$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.config.AdConfigKt$$ExternalSyntheticLambda7
        public final Object invoke() {
            boolean useKNTRClick_delegate$lambda$0;
            useKNTRClick_delegate$lambda$0 = AdConfigKt.useKNTRClick_delegate$lambda$0();
            return Boolean.valueOf(useKNTRClick_delegate$lambda$0);
        }
    });
    private static final Lazy enableSearch150VM$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.config.AdConfigKt$$ExternalSyntheticLambda8
        public final Object invoke() {
            boolean enableSearch150VM_delegate$lambda$0;
            enableSearch150VM_delegate$lambda$0 = AdConfigKt.enableSearch150VM_delegate$lambda$0();
            return Boolean.valueOf(enableSearch150VM_delegate$lambda$0);
        }
    });
    private static final Lazy enableLiveBrandCardVm$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.config.AdConfigKt$$ExternalSyntheticLambda9
        public final Object invoke() {
            boolean enableLiveBrandCardVm_delegate$lambda$0;
            enableLiveBrandCardVm_delegate$lambda$0 = AdConfigKt.enableLiveBrandCardVm_delegate$lambda$0();
            return Boolean.valueOf(enableLiveBrandCardVm_delegate$lambda$0);
        }
    });
    private static final Lazy aesKey$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0() { // from class: kntr.app.ad.domain.config.AdConfigKt$$ExternalSyntheticLambda10
        public final Object invoke() {
            String aesKey_delegate$lambda$0;
            aesKey_delegate$lambda$0 = AdConfigKt.aesKey_delegate$lambda$0();
            return aesKey_delegate$lambda$0;
        }
    });
    private static final Lazy mmaReplaceUrls$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.config.AdConfigKt$$ExternalSyntheticLambda11
        public final Object invoke() {
            MMAReplaceUrls mmaReplaceUrls_delegate$lambda$0;
            mmaReplaceUrls_delegate$lambda$0 = AdConfigKt.mmaReplaceUrls_delegate$lambda$0();
            return mmaReplaceUrls_delegate$lambda$0;
        }
    });
    private static final Lazy mmaReplaceDefault$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.config.AdConfigKt$$ExternalSyntheticLambda1
        public final Object invoke() {
            MMAReplaceDefault mmaReplaceDefault_delegate$lambda$0;
            mmaReplaceDefault_delegate$lambda$0 = AdConfigKt.mmaReplaceDefault_delegate$lambda$0();
            return mmaReplaceDefault_delegate$lambda$0;
        }
    });
    private static final Lazy httpCompressType$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.config.AdConfigKt$$ExternalSyntheticLambda2
        public final Object invoke() {
            CompressType httpCompressType_delegate$lambda$0;
            httpCompressType_delegate$lambda$0 = AdConfigKt.httpCompressType_delegate$lambda$0();
            return httpCompressType_delegate$lambda$0;
        }
    });
    private static final Lazy useInspector$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.config.AdConfigKt$$ExternalSyntheticLambda3
        public final Object invoke() {
            boolean useInspector_delegate$lambda$0;
            useInspector_delegate$lambda$0 = AdConfigKt.useInspector_delegate$lambda$0();
            return Boolean.valueOf(useInspector_delegate$lambda$0);
        }
    });
    private static final Lazy kModules$delegate = LazyKt.lazy(new Function0() { // from class: kntr.app.ad.domain.config.AdConfigKt$$ExternalSyntheticLambda4
        public final Object invoke() {
            AdKModules kModules_delegate$lambda$0;
            kModules_delegate$lambda$0 = AdConfigKt.kModules_delegate$lambda$0();
            return kModules_delegate$lambda$0;
        }
    });

    @Deprecated(message = "use kModules.kVM.contains(AdSlot.xx) instead")
    public static /* synthetic */ void getEnableLiveBrandCardVm$annotations() {
    }

    @Deprecated(message = "use kModules.kVM.contains(AdSlot.xx) instead")
    public static /* synthetic */ void getEnableSearch150VM$annotations() {
    }

    public static /* synthetic */ void getKModules$annotations() {
    }

    public static /* synthetic */ void getUseInspector$annotations() {
    }

    @Deprecated(message = "use kModules.kModel.contains(AdSlot.xx) instead")
    public static /* synthetic */ void getUseKNTR$annotations() {
    }

    @Deprecated(message = "use kModules.kClicker.contains(AdSlot.xx) instead")
    public static /* synthetic */ void getUseKNTRClick$annotations() {
    }

    @Deprecated(message = "use kModules.kExtraFetcher.contains(AdSlot.xx) instead")
    public static /* synthetic */ void getUseKNTRExtra$annotations() {
    }

    @Deprecated(message = "use kModules.kReporter.contains(AdSlot.xx) instead")
    public static /* synthetic */ void getUseKNTRReport$annotations() {
    }

    public static final boolean getUseKNTR() {
        return ((Boolean) useKNTR$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean useKNTR_delegate$lambda$0() {
        return IPlatformConfig.-CC.ff$default(KConfig.INSTANCE, "dd_ad_kntr_model_v1", false, 2, (Object) null);
    }

    public static final boolean getUseKNTRExtra() {
        return ((Boolean) useKNTRExtra$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean useKNTRExtra_delegate$lambda$0() {
        return !IPlatformConfig.-CC.ff$default(KConfig.INSTANCE, "dd_ad_kntr_adextra_disable", false, 2, (Object) null);
    }

    public static final boolean getUseKNTRReport() {
        return ((Boolean) useKNTRReport$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean useKNTRReport_delegate$lambda$0() {
        return IPlatformConfig.-CC.ff$default(KConfig.INSTANCE, "dd_ad_kntr_report_v1", false, 2, (Object) null);
    }

    public static final boolean getUseKNTRClick() {
        return ((Boolean) useKNTRClick$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean useKNTRClick_delegate$lambda$0() {
        return !IPlatformConfig.-CC.ff$default(KConfig.INSTANCE, "dd_ad_kntr_click_disable", false, 2, (Object) null);
    }

    public static final boolean getEnableSearch150VM() {
        return ((Boolean) enableSearch150VM$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enableSearch150VM_delegate$lambda$0() {
        return IPlatformConfig.-CC.ff$default(KConfig.INSTANCE, "dd_ad_use_vm_search_150_card", false, 2, (Object) null);
    }

    public static final boolean getEnableLiveBrandCardVm() {
        return ((Boolean) enableLiveBrandCardVm$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean enableLiveBrandCardVm_delegate$lambda$0() {
        return !IPlatformConfig.-CC.ff$default(KConfig.INSTANCE, "dd_ad_disable_vm_live_brand_card", false, 2, (Object) null);
    }

    public static final String getAesKey() {
        return (String) aesKey$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String aesKey_delegate$lambda$0() {
        String config$default = IPlatformConfig.-CC.config$default(KConfig.INSTANCE, "cm.aes-key", (String) null, 2, (Object) null);
        return config$default == null ? "e08be2d68aaaaf27" : config$default;
    }

    public static final MMAReplaceUrls getMmaReplaceUrls() {
        return (MMAReplaceUrls) mmaReplaceUrls$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMAReplaceUrls mmaReplaceUrls_delegate$lambda$0() {
        Object obj;
        MMAReplaceUrls mMAReplaceUrls = null;
        String $this$parseToObj$iv = IPlatformConfig.-CC.config$default(KConfig.INSTANCE, "cm.mma_replace_urls", (String) null, 2, (Object) null);
        String str = $this$parseToObj$iv;
        if (!(str == null || StringsKt.isBlank(str))) {
            try {
                Result.Companion companion = Result.Companion;
                Json this_$iv$iv = JsonExtKt.getAdJson();
                SerializersModule serializersModule = this_$iv$iv.getSerializersModule();
                KType nullableTypeOf = Reflection.nullableTypeOf(MMAReplaceUrls.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
                obj = Result.constructor-impl(this_$iv$iv.decodeFromString(SerializersKt.serializer(serializersModule, nullableTypeOf), $this$parseToObj$iv));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable it$iv = Result.exceptionOrNull-impl(obj);
            if (it$iv != null) {
                Logger_androidKt.getAdLog().e("JsonExt", it$iv.toString());
            }
            if (!Result.isFailure-impl(obj)) {
                mMAReplaceUrls = obj;
            }
        }
        return mMAReplaceUrls;
    }

    public static final MMAReplaceDefault getMmaReplaceDefault() {
        return (MMAReplaceDefault) mmaReplaceDefault$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMAReplaceDefault mmaReplaceDefault_delegate$lambda$0() {
        Object obj;
        MMAReplaceDefault mMAReplaceDefault = null;
        String $this$parseToObj$iv = IPlatformConfig.-CC.config$default(KConfig.INSTANCE, "cm.mma_replace_default", (String) null, 2, (Object) null);
        String str = $this$parseToObj$iv;
        if (!(str == null || StringsKt.isBlank(str))) {
            try {
                Result.Companion companion = Result.Companion;
                Json this_$iv$iv = JsonExtKt.getAdJson();
                SerializersModule serializersModule = this_$iv$iv.getSerializersModule();
                KType nullableTypeOf = Reflection.nullableTypeOf(MMAReplaceDefault.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
                obj = Result.constructor-impl(this_$iv$iv.decodeFromString(SerializersKt.serializer(serializersModule, nullableTypeOf), $this$parseToObj$iv));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable it$iv = Result.exceptionOrNull-impl(obj);
            if (it$iv != null) {
                Logger_androidKt.getAdLog().e("JsonExt", it$iv.toString());
            }
            if (!Result.isFailure-impl(obj)) {
                mMAReplaceDefault = obj;
            }
        }
        return mMAReplaceDefault;
    }

    public static final CompressType getHttpCompressType() {
        return (CompressType) httpCompressType$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CompressType httpCompressType_delegate$lambda$0() {
        return (CompressType) CompressType.getEntries().get(StringExtKt.toIntOrZero(IPlatformConfig.-CC.config$default(KConfig.INSTANCE, "cm.compress_strategy_v2", (String) null, 2, (Object) null)));
    }

    public static final boolean getUseInspector() {
        return ((Boolean) useInspector$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean useInspector_delegate$lambda$0() {
        return IPlatformConfig.-CC.ff$default(KConfig.INSTANCE, "dd_ad_enable_inspector", false, 2, (Object) null);
    }

    public static final AdKModules getKModules() {
        return (AdKModules) kModules$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AdKModules kModules_delegate$lambda$0() {
        Object obj;
        AdKModules adKModules = null;
        String $this$parseToObj$iv = IPlatformConfig.-CC.config$default(KConfig.INSTANCE, "dd_ad_kntr_modules", (String) null, 2, (Object) null);
        String str = $this$parseToObj$iv;
        if (!(str == null || StringsKt.isBlank(str))) {
            try {
                Result.Companion companion = Result.Companion;
                Json this_$iv$iv = JsonExtKt.getAdJson();
                SerializersModule serializersModule = this_$iv$iv.getSerializersModule();
                KType nullableTypeOf = Reflection.nullableTypeOf(AdKModules.class);
                MagicApiIntrinsics.voidMagicApiCall("kotlinx.serialization.serializer.withModule");
                obj = Result.constructor-impl(this_$iv$iv.decodeFromString(SerializersKt.serializer(serializersModule, nullableTypeOf), $this$parseToObj$iv));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable it$iv = Result.exceptionOrNull-impl(obj);
            if (it$iv != null) {
                Logger_androidKt.getAdLog().e("JsonExt", it$iv.toString());
            }
            if (!Result.isFailure-impl(obj)) {
                adKModules = obj;
            }
        }
        AdKModules adKModules2 = adKModules;
        return adKModules2 == null ? new AdKModules(null, null, null, null, null, null, null, 127, null) : adKModules2;
    }
}