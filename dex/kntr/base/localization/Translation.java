package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kntr.base.appinfo.KPackageInfo;
import kntr.base.config.SerializableSharedPreferencesProperty;
import kntr.base.log.KLog_androidKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
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
import kotlinx.serialization.internal.BooleanSerializer;

/* compiled from: Translation.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011*\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u00168FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u0012\u0004\b\u0017\u0010\u0003\u001a\u0004\b\u0018\u0010\u0019R*\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t8F@FX\u0087\u000e¢\u0006\u0012\u0012\u0004\b\u001e\u0010\u0003\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R'\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u00168FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b$\u0010\u001b\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010\u0019R\u001a\u0010%\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b&\u0010\u0003\u001a\u0004\b'\u0010\u000f¨\u0006("}, d2 = {"Lkntr/base/localization/Translation;", "", "<init>", "()V", "SP", "", "KEY", "preferencesProperty", "Lkntr/base/config/SerializableSharedPreferencesProperty;", "", "<set-?>", "preferences", "getPreferences$delegate", "(Lkntr/base/localization/Translation;)Ljava/lang/Object;", "getPreferences", "()Z", "setPreferences", "(Z)V", "_userEnabledFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_alwaysTranslateFlow", "userEnabledFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getUserEnabledFlow$annotations", "getUserEnabledFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "userEnabledFlow$delegate", "Lkotlin/Lazy;", "value", "userEnabled", "getUserEnabled$annotations", "getUserEnabled", "setUserEnabled", "alwaysTranslateFlow", "getAlwaysTranslateFlow$annotations", "getAlwaysTranslateFlow", "alwaysTranslateFlow$delegate", "alwaysTranslate", "getAlwaysTranslate$annotations", "getAlwaysTranslate", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
public final class Translation {
    public static final int $stable;
    private static final String KEY = "user-enabled";
    private static final String SP = "translation";
    private static final MutableStateFlow<Boolean> _alwaysTranslateFlow;
    private static final MutableStateFlow<Boolean> _userEnabledFlow;
    private static final Lazy alwaysTranslateFlow$delegate;
    private static final SerializableSharedPreferencesProperty<Boolean> preferencesProperty;
    private static final Lazy userEnabledFlow$delegate;
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.mutableProperty1(new MutablePropertyReference1Impl(Translation.class, "preferences", "getPreferences()Z", 0))};
    public static final Translation INSTANCE = new Translation();

    public static /* synthetic */ void getAlwaysTranslate$annotations() {
    }

    public static /* synthetic */ void getAlwaysTranslateFlow$annotations() {
    }

    public static /* synthetic */ void getUserEnabled$annotations() {
    }

    public static /* synthetic */ void getUserEnabledFlow$annotations() {
    }

    private Translation() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean preferencesProperty$lambda$0() {
        Locale currentLocale = Localization.INSTANCE.getCurrent();
        boolean z = true;
        if (!LocaleKt.isTraditionalChinese(currentLocale) && (!KPackageInfo.INSTANCE.isFirstLaunch() || LocaleKt.isChinese(currentLocale))) {
            z = false;
        }
        boolean it = z;
        KLog_androidKt.getKLog().i("Localization", "determine initial always translate: " + it);
        return z;
    }

    private final boolean getPreferences() {
        return preferencesProperty.getValue(this, $$delegatedProperties[0]).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setPreferences(boolean z) {
        preferencesProperty.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StateFlow userEnabledFlow_delegate$lambda$0() {
        return FlowKt.asStateFlow(_userEnabledFlow);
    }

    public final StateFlow<Boolean> getUserEnabledFlow() {
        return (StateFlow) userEnabledFlow$delegate.getValue();
    }

    public final boolean getUserEnabled() {
        return ((Boolean) _userEnabledFlow.getValue()).booleanValue();
    }

    public final void setUserEnabled(boolean value) {
        if (((Boolean) _userEnabledFlow.getValue()).booleanValue() != value) {
            KLog_androidKt.getKLog().i("Localization", "update userEnabled, old: " + _userEnabledFlow.getValue() + ", new: " + value);
            _userEnabledFlow.setValue(Boolean.valueOf(value));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StateFlow alwaysTranslateFlow_delegate$lambda$0() {
        return FlowKt.asStateFlow(_alwaysTranslateFlow);
    }

    public final StateFlow<Boolean> getAlwaysTranslateFlow() {
        return (StateFlow) alwaysTranslateFlow$delegate.getValue();
    }

    public final boolean getAlwaysTranslate() {
        return ((Boolean) getAlwaysTranslateFlow().getValue()).booleanValue();
    }

    /* compiled from: Translation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    @DebugMetadata(c = "kntr.base.localization.Translation$1", f = "Translation.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    /* renamed from: kntr.base.localization.Translation$1  reason: invalid class name */
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
                    if (Translation.preferencesProperty.asFlow().collect(new FlowCollector() { // from class: kntr.base.localization.Translation.1.1
                        public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                            return emit(((Boolean) value).booleanValue(), $completion);
                        }

                        public final Object emit(boolean it, Continuation<? super Unit> continuation) {
                            Translation.INSTANCE.setUserEnabled(it);
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
        Function0 initializer$iv = new Function0() { // from class: kntr.base.localization.Translation$$ExternalSyntheticLambda0
            public final Object invoke() {
                boolean preferencesProperty$lambda$0;
                preferencesProperty$lambda$0 = Translation.preferencesProperty$lambda$0();
                return Boolean.valueOf(preferencesProperty$lambda$0);
            }
        };
        preferencesProperty = new SerializableSharedPreferencesProperty<>(SP, true, BooleanSerializer.INSTANCE, KEY, initializer$iv, null);
        MutableStateFlow $this$_userEnabledFlow_u24lambda_u240 = StateFlowKt.MutableStateFlow(Boolean.valueOf(INSTANCE.getPreferences()));
        if (Localization_androidKt.isMainProcess()) {
            BuildersKt.launch$default(ScopeUtilsKt.getDefaultScope(), (CoroutineContext) null, (CoroutineStart) null, new Translation$_userEnabledFlow$1$1($this$_userEnabledFlow_u24lambda_u240, null), 3, (Object) null);
        }
        _userEnabledFlow = $this$_userEnabledFlow_u24lambda_u240;
        MutableStateFlow $this$_alwaysTranslateFlow_u24lambda_u240 = StateFlowKt.MutableStateFlow(Boolean.valueOf(TranslationKt.allowAlwaysTranslate$default(false, null, 3, null)));
        BuildersKt.launch$default(ScopeUtilsKt.getDefaultScope(), (CoroutineContext) null, (CoroutineStart) null, new Translation$_alwaysTranslateFlow$1$1($this$_alwaysTranslateFlow_u24lambda_u240, null), 3, (Object) null);
        BuildersKt.launch$default(ScopeUtilsKt.getDefaultScope(), (CoroutineContext) null, (CoroutineStart) null, new Translation$_alwaysTranslateFlow$1$2($this$_alwaysTranslateFlow_u24lambda_u240, null), 3, (Object) null);
        _alwaysTranslateFlow = $this$_alwaysTranslateFlow_u24lambda_u240;
        userEnabledFlow$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.Translation$$ExternalSyntheticLambda1
            public final Object invoke() {
                StateFlow userEnabledFlow_delegate$lambda$0;
                userEnabledFlow_delegate$lambda$0 = Translation.userEnabledFlow_delegate$lambda$0();
                return userEnabledFlow_delegate$lambda$0;
            }
        });
        alwaysTranslateFlow$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.Translation$$ExternalSyntheticLambda2
            public final Object invoke() {
                StateFlow alwaysTranslateFlow_delegate$lambda$0;
                alwaysTranslateFlow_delegate$lambda$0 = Translation.alwaysTranslateFlow_delegate$lambda$0();
                return alwaysTranslateFlow_delegate$lambda$0;
            }
        });
        KLog_androidKt.getKLog().i("Localization", "init, userEnabled: " + INSTANCE.getUserEnabled() + ", alwaysTranslate: " + INSTANCE.getAlwaysTranslate());
        BuildersKt.launch$default(ScopeUtilsKt.getMainScope(), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
        $stable = 8;
    }
}