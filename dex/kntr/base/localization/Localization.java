package kntr.base.localization;

import java.util.Iterator;
import java.util.List;
import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.appinfo.KPackageInfo;
import kntr.base.config.SerializableSharedPreferencesProperty;
import kntr.base.log.KLog_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: Localization.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR!\u0010\u000f\u001a\u00020\u00058FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\t\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0007R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\u001e*\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050 X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\"8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b&\u0010\t\u0012\u0004\b#\u0010\u0003\u001a\u0004\b$\u0010%R*\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u00058F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b)\u0010\u0003\u001a\u0004\b*\u0010\u0007\"\u0004\b+\u0010\u001e¨\u0006,"}, d2 = {"Lkntr/base/localization/Localization;", "", "<init>", "()V", "DEFAULT", "Lkntr/base/localization/Locale;", "getDEFAULT", "()Lkntr/base/localization/Locale;", "DEFAULT$delegate", "Lkotlin/Lazy;", "SUPPORTED_LIST", "", "getSUPPORTED_LIST", "()Ljava/util/List;", "SUPPORTED_LIST$delegate", "SYSTEM", "getSYSTEM$annotations", "getSYSTEM", "SYSTEM$delegate", "SP", "", "KEY", "preferencesProperty", "Lkntr/base/config/SerializableSharedPreferencesProperty;", "<set-?>", "localePreferences", "getLocalePreferences$delegate", "(Lkntr/base/localization/Localization;)Ljava/lang/Object;", "getLocalePreferences", "setLocalePreferences", "(Lkntr/base/localization/Locale;)V", "_localeFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "localeFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getLocaleFlow$annotations", "getLocaleFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "localeFlow$delegate", "value", "current", "getCurrent$annotations", "getCurrent", "setCurrent", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Localization {
    public static final int $stable;
    private static final String KEY = "custom-locale";
    private static final String SP = "localization";
    private static final MutableStateFlow<Locale> _localeFlow;
    private static final Lazy localeFlow$delegate;
    private static final SerializableSharedPreferencesProperty<Locale> preferencesProperty;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(Localization.class, "localePreferences", "getLocalePreferences()Lkntr/base/localization/Locale;", 0))};
    public static final Localization INSTANCE = new Localization();
    private static final Lazy DEFAULT$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.Localization$$ExternalSyntheticLambda0
        public final Object invoke() {
            Locale DEFAULT_delegate$lambda$0;
            DEFAULT_delegate$lambda$0 = Localization.DEFAULT_delegate$lambda$0();
            return DEFAULT_delegate$lambda$0;
        }
    });
    private static final Lazy SUPPORTED_LIST$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.Localization$$ExternalSyntheticLambda1
        public final Object invoke() {
            List SUPPORTED_LIST_delegate$lambda$0;
            SUPPORTED_LIST_delegate$lambda$0 = Localization.SUPPORTED_LIST_delegate$lambda$0();
            return SUPPORTED_LIST_delegate$lambda$0;
        }
    });
    private static final Lazy SYSTEM$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.Localization$$ExternalSyntheticLambda2
        public final Object invoke() {
            Locale SYSTEM_delegate$lambda$0;
            SYSTEM_delegate$lambda$0 = Localization.SYSTEM_delegate$lambda$0();
            return SYSTEM_delegate$lambda$0;
        }
    });

    public static /* synthetic */ void getCurrent$annotations() {
    }

    public static /* synthetic */ void getLocaleFlow$annotations() {
    }

    public static /* synthetic */ void getSYSTEM$annotations() {
    }

    private Localization() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale DEFAULT_delegate$lambda$0() {
        return Locale.Companion.getSIMPLIFIED_CHINESE();
    }

    public final Locale getDEFAULT() {
        return (Locale) DEFAULT$delegate.getValue();
    }

    public final List<Locale> getSUPPORTED_LIST() {
        return (List) SUPPORTED_LIST$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List SUPPORTED_LIST_delegate$lambda$0() {
        return CollectionsKt.listOf(new Locale[]{Locale.Companion.getSIMPLIFIED_CHINESE(), Locale.Companion.getTRADITIONAL_CHINESE(), Locale.Companion.getENGLISH(), Locale.Companion.getJAPANESE(), Locale.Companion.getSPANISH(), Locale.Companion.getPORTUGUESE(), Locale.Companion.getARABIC()});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale SYSTEM_delegate$lambda$0() {
        return Localization_androidKt.getSystemLocale();
    }

    public final Locale getSYSTEM() {
        return (Locale) SYSTEM$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale preferencesProperty$lambda$0() {
        Locale systemLocale;
        Object obj;
        KLog_androidKt.getKLog().i("Localization", "preferencesProperty init, enableLocalization: " + Localization_androidKt.getEnableLocalization());
        if (Localization_androidKt.getEnableLocalization()) {
            Locale systemLocale2 = LocaleKt.getNormalized(INSTANCE.getSYSTEM());
            if (LocaleKt.isTraditionalChinese(systemLocale2)) {
                systemLocale = Locale.Companion.getTRADITIONAL_CHINESE();
            } else if (!KPackageInfo.INSTANCE.isFirstLaunch() || LocaleKt.isChinese(systemLocale2)) {
                systemLocale = INSTANCE.getDEFAULT();
            } else {
                Iterator<T> it = INSTANCE.getSUPPORTED_LIST().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    Locale it2 = (Locale) obj;
                    if (Intrinsics.areEqual(it2, systemLocale2)) {
                        break;
                    }
                }
                Locale locale = (Locale) obj;
                if (locale == null) {
                    systemLocale = LocalizationKt.access$getLanguageFamilyFallback(systemLocale2);
                    if (systemLocale == null) {
                        systemLocale = Locale.Companion.getENGLISH();
                    }
                } else {
                    systemLocale = locale;
                }
            }
            Locale it3 = systemLocale;
            KLog_androidKt.getKLog().i("Localization", "determined initial locale: " + it3);
            return systemLocale;
        }
        return INSTANCE.getDEFAULT();
    }

    private final Locale getLocalePreferences() {
        return preferencesProperty.getValue(this, $$delegatedProperties[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLocalePreferences(Locale locale) {
        preferencesProperty.setValue(this, $$delegatedProperties[0], locale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StateFlow localeFlow_delegate$lambda$0() {
        return FlowKt.asStateFlow(_localeFlow);
    }

    public final StateFlow<Locale> getLocaleFlow() {
        return (StateFlow) localeFlow$delegate.getValue();
    }

    public final Locale getCurrent() {
        return (Locale) _localeFlow.getValue();
    }

    public final void setCurrent(Locale value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (Localization_androidKt.getEnableLocalization() && !Intrinsics.areEqual(value, _localeFlow.getValue())) {
            KLog_androidKt.getKLog().i("Localization", "update locale, old: " + _localeFlow.getValue() + ", new: " + value);
            _localeFlow.setValue(value);
            Localization_androidKt.applyLocale(value);
        }
    }

    /* compiled from: Localization.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.base.localization.Localization$1", f = "Localization.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.base.localization.Localization$1  reason: invalid class name */
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object $result) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    this.label = 1;
                    if (Localization.preferencesProperty.asFlow().collect(new FlowCollector() { // from class: kntr.base.localization.Localization.1.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit((Locale) value, (Continuation<? super Unit>) $completion);
                        }

                        public final Object emit(Locale it, Continuation<? super Unit> continuation) {
                            Locale fixedLocale = !Intrinsics.areEqual(it, Locale.Companion.getSIMPLIFIED_CHINESE_DEPRECATED()) ? it : null;
                            if (fixedLocale == null) {
                                fixedLocale = Locale.Companion.getSIMPLIFIED_CHINESE();
                            }
                            Localization.INSTANCE.setCurrent(fixedLocale);
                            return Unit.INSTANCE;
                        }
                    }, (Continuation) this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    static {
        Function0 initializer$iv = new Function0() { // from class: kntr.base.localization.Localization$$ExternalSyntheticLambda3
            public final Object invoke() {
                Locale preferencesProperty$lambda$0;
                preferencesProperty$lambda$0 = Localization.preferencesProperty$lambda$0();
                return preferencesProperty$lambda$0;
            }
        };
        preferencesProperty = new SerializableSharedPreferencesProperty<>(SP, true, Locale.Companion.serializer(), KEY, initializer$iv, null);
        MutableStateFlow $this$_localeFlow_u24lambda_u240 = StateFlowKt.MutableStateFlow(Localization_androidKt.getEnableLocalization() ? INSTANCE.getLocalePreferences() : INSTANCE.getDEFAULT());
        if (Localization_androidKt.getEnableLocalization() && Localization_androidKt.isMainProcess()) {
            BuildersKt.launch$default(ScopeUtilsKt.getDefaultScope(), (CoroutineContext) null, (CoroutineStart) null, new Localization$_localeFlow$1$1($this$_localeFlow_u24lambda_u240, null), 3, (Object) null);
        }
        _localeFlow = $this$_localeFlow_u24lambda_u240;
        localeFlow$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.Localization$$ExternalSyntheticLambda4
            public final Object invoke() {
                StateFlow localeFlow_delegate$lambda$0;
                localeFlow_delegate$lambda$0 = Localization.localeFlow_delegate$lambda$0();
                return localeFlow_delegate$lambda$0;
            }
        });
        if (Intrinsics.areEqual(INSTANCE.getCurrent(), Locale.Companion.getSIMPLIFIED_CHINESE_DEPRECATED())) {
            KLog_androidKt.getKLog().i("Localization", "init, current is deprecated Simplified Chinese Locale, updating to new one");
            INSTANCE.setCurrent(Locale.Companion.getSIMPLIFIED_CHINESE());
        } else {
            Localization_androidKt.applyLocale(INSTANCE.getCurrent());
        }
        KLog_androidKt.getKLog().i("Localization", "init, isFirstLaunch " + KPackageInfo.INSTANCE.isFirstLaunch() + ", system: " + INSTANCE.getSYSTEM() + ", current: " + INSTANCE.getCurrent());
        if (Localization_androidKt.getEnableLocalization()) {
            BuildersKt.launch$default(ScopeUtilsKt.getMainScope(), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
        }
        $stable = 8;
    }
}