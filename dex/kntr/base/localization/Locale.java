package kntr.base.localization;

import kntr.app.upcomingEpisode.ConstantsKt;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;

/* compiled from: Locale.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0015\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0005\u0010\tJ\b\u0010\u0018\u001a\u00020\bH\u0007J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010#\u001a\u00020\bH\u0007R\u001a\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0015\u001a\u00020\b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u000f\u001a\u0004\b\u0017\u0010\u0011R\u001b\u0010\u001f\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b \u0010\u0011¨\u0006%"}, d2 = {"Lkntr/base/localization/Locale;", "", "platformLocale", "Ljava/util/Locale;", "Lkntr/base/localization/PlatformLocale;", "<init>", "(Ljava/util/Locale;)V", "languageTag", "", "(Ljava/lang/String;)V", "getPlatformLocale$localization_debug", "()Ljava/util/Locale;", "Ljava/util/Locale;", "language", "getLanguage$annotations", "()V", "getLanguage", "()Ljava/lang/String;", "script", "getScript$annotations", "getScript", "region", "getRegion$annotations", "getRegion", "toLanguageTag", "equals", "", "other", "hashCode", "", "toString", "biliLanguageTag", "getBiliLanguageTag", "biliLanguageTag$delegate", "Lkotlin/Lazy;", "toBiliLanguageTag", "Companion", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
@Serializable(with = LocaleSerializer.class)
public final class Locale {
    public static final int $stable = 0;
    private final Lazy biliLanguageTag$delegate;
    private final java.util.Locale platformLocale;
    public static final Companion Companion = new Companion(null);
    private static final Lazy<Locale> SIMPLIFIED_CHINESE_DEPRECATED$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.Locale$$ExternalSyntheticLambda0
        public final Object invoke() {
            Locale SIMPLIFIED_CHINESE_DEPRECATED_delegate$lambda$0;
            SIMPLIFIED_CHINESE_DEPRECATED_delegate$lambda$0 = Locale.SIMPLIFIED_CHINESE_DEPRECATED_delegate$lambda$0();
            return SIMPLIFIED_CHINESE_DEPRECATED_delegate$lambda$0;
        }
    });
    private static final Lazy<Locale> SIMPLIFIED_CHINESE$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.Locale$$ExternalSyntheticLambda10
        public final Object invoke() {
            Locale SIMPLIFIED_CHINESE_delegate$lambda$0;
            SIMPLIFIED_CHINESE_delegate$lambda$0 = Locale.SIMPLIFIED_CHINESE_delegate$lambda$0();
            return SIMPLIFIED_CHINESE_delegate$lambda$0;
        }
    });
    private static final Lazy<Locale> TRADITIONAL_CHINESE$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.Locale$$ExternalSyntheticLambda11
        public final Object invoke() {
            Locale TRADITIONAL_CHINESE_delegate$lambda$0;
            TRADITIONAL_CHINESE_delegate$lambda$0 = Locale.TRADITIONAL_CHINESE_delegate$lambda$0();
            return TRADITIONAL_CHINESE_delegate$lambda$0;
        }
    });
    private static final Lazy<Locale> ENGLISH$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.Locale$$ExternalSyntheticLambda12
        public final Object invoke() {
            Locale ENGLISH_delegate$lambda$0;
            ENGLISH_delegate$lambda$0 = Locale.ENGLISH_delegate$lambda$0();
            return ENGLISH_delegate$lambda$0;
        }
    });
    private static final Lazy<Locale> FRENCH$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.Locale$$ExternalSyntheticLambda13
        public final Object invoke() {
            Locale FRENCH_delegate$lambda$0;
            FRENCH_delegate$lambda$0 = Locale.FRENCH_delegate$lambda$0();
            return FRENCH_delegate$lambda$0;
        }
    });
    private static final Lazy<Locale> GERMAN$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.Locale$$ExternalSyntheticLambda14
        public final Object invoke() {
            Locale GERMAN_delegate$lambda$0;
            GERMAN_delegate$lambda$0 = Locale.GERMAN_delegate$lambda$0();
            return GERMAN_delegate$lambda$0;
        }
    });
    private static final Lazy<Locale> ITALIAN$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.Locale$$ExternalSyntheticLambda1
        public final Object invoke() {
            Locale ITALIAN_delegate$lambda$0;
            ITALIAN_delegate$lambda$0 = Locale.ITALIAN_delegate$lambda$0();
            return ITALIAN_delegate$lambda$0;
        }
    });
    private static final Lazy<Locale> JAPANESE$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.Locale$$ExternalSyntheticLambda2
        public final Object invoke() {
            Locale JAPANESE_delegate$lambda$0;
            JAPANESE_delegate$lambda$0 = Locale.JAPANESE_delegate$lambda$0();
            return JAPANESE_delegate$lambda$0;
        }
    });
    private static final Lazy<Locale> SPANISH$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.Locale$$ExternalSyntheticLambda3
        public final Object invoke() {
            Locale SPANISH_delegate$lambda$0;
            SPANISH_delegate$lambda$0 = Locale.SPANISH_delegate$lambda$0();
            return SPANISH_delegate$lambda$0;
        }
    });
    private static final Lazy<Locale> RUSSIAN$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.Locale$$ExternalSyntheticLambda4
        public final Object invoke() {
            Locale RUSSIAN_delegate$lambda$0;
            RUSSIAN_delegate$lambda$0 = Locale.RUSSIAN_delegate$lambda$0();
            return RUSSIAN_delegate$lambda$0;
        }
    });
    private static final Lazy<Locale> KOREAN$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.Locale$$ExternalSyntheticLambda6
        public final Object invoke() {
            Locale KOREAN_delegate$lambda$0;
            KOREAN_delegate$lambda$0 = Locale.KOREAN_delegate$lambda$0();
            return KOREAN_delegate$lambda$0;
        }
    });
    private static final Lazy<Locale> PORTUGUESE$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.Locale$$ExternalSyntheticLambda7
        public final Object invoke() {
            Locale PORTUGUESE_delegate$lambda$0;
            PORTUGUESE_delegate$lambda$0 = Locale.PORTUGUESE_delegate$lambda$0();
            return PORTUGUESE_delegate$lambda$0;
        }
    });
    private static final Lazy<Locale> ARABIC$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.Locale$$ExternalSyntheticLambda8
        public final Object invoke() {
            Locale ARABIC_delegate$lambda$0;
            ARABIC_delegate$lambda$0 = Locale.ARABIC_delegate$lambda$0();
            return ARABIC_delegate$lambda$0;
        }
    });
    private static final Lazy<Locale> THAI$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.Locale$$ExternalSyntheticLambda9
        public final Object invoke() {
            Locale THAI_delegate$lambda$0;
            THAI_delegate$lambda$0 = Locale.THAI_delegate$lambda$0();
            return THAI_delegate$lambda$0;
        }
    });

    public static /* synthetic */ void getLanguage$annotations() {
    }

    public static /* synthetic */ void getRegion$annotations() {
    }

    public static /* synthetic */ void getScript$annotations() {
    }

    public Locale(java.util.Locale platformLocale) {
        Intrinsics.checkNotNullParameter(platformLocale, "platformLocale");
        this.platformLocale = platformLocale;
        this.biliLanguageTag$delegate = LazyKt.lazy(new Function0() { // from class: kntr.base.localization.Locale$$ExternalSyntheticLambda5
            public final Object invoke() {
                String biliLanguageTag_delegate$lambda$0;
                biliLanguageTag_delegate$lambda$0 = Locale.biliLanguageTag_delegate$lambda$0(Locale.this);
                return biliLanguageTag_delegate$lambda$0;
            }
        });
    }

    public final java.util.Locale getPlatformLocale$localization_debug() {
        return this.platformLocale;
    }

    /* compiled from: Locale.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000505R\u0014\u0010\u0004\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R!\u0010\b\u001a\u00020\u00058FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u0007R\u001b\u0010\r\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u000e\u0010\u0007R\u001b\u0010\u0010\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0011\u0010\u0007R\u001b\u0010\u0013\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0014\u0010\u0007R\u001b\u0010\u0016\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0017\u0010\u0007R\u001b\u0010\u0019\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\f\u001a\u0004\b\u001a\u0010\u0007R\u001b\u0010\u001c\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\f\u001a\u0004\b\u001d\u0010\u0007R\u001b\u0010\u001f\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\f\u001a\u0004\b \u0010\u0007R\u001b\u0010\"\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\f\u001a\u0004\b#\u0010\u0007R\u001b\u0010%\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\f\u001a\u0004\b&\u0010\u0007R\u001b\u0010(\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\f\u001a\u0004\b)\u0010\u0007R\u001b\u0010+\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\f\u001a\u0004\b,\u0010\u0007R\u001b\u0010.\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u0010\f\u001a\u0004\b/\u0010\u0007R\u001b\u00101\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b3\u0010\f\u001a\u0004\b2\u0010\u0007¨\u00066"}, d2 = {"Lkntr/base/localization/Locale$Companion;", "", "<init>", "()V", "current", "Lkntr/base/localization/Locale;", "getCurrent$localization_debug", "()Lkntr/base/localization/Locale;", "SIMPLIFIED_CHINESE_DEPRECATED", "getSIMPLIFIED_CHINESE_DEPRECATED$annotations", "getSIMPLIFIED_CHINESE_DEPRECATED", "SIMPLIFIED_CHINESE_DEPRECATED$delegate", "Lkotlin/Lazy;", "SIMPLIFIED_CHINESE", "getSIMPLIFIED_CHINESE", "SIMPLIFIED_CHINESE$delegate", "TRADITIONAL_CHINESE", "getTRADITIONAL_CHINESE", "TRADITIONAL_CHINESE$delegate", "ENGLISH", "getENGLISH", "ENGLISH$delegate", "FRENCH", "getFRENCH", "FRENCH$delegate", "GERMAN", "getGERMAN", "GERMAN$delegate", "ITALIAN", "getITALIAN", "ITALIAN$delegate", "JAPANESE", "getJAPANESE", "JAPANESE$delegate", "SPANISH", "getSPANISH", "SPANISH$delegate", "RUSSIAN", "getRUSSIAN", "RUSSIAN$delegate", "KOREAN", "getKOREAN", "KOREAN$delegate", "PORTUGUESE", "getPORTUGUESE", "PORTUGUESE$delegate", "ARABIC", "getARABIC", "ARABIC$delegate", "THAI", "getTHAI", "THAI$delegate", "serializer", "Lkotlinx/serialization/KSerializer;", "localization_debug"}, k = 1, mv = {2, 2, 0}, xi = ConstantsKt.OGV_UPDATE_CALENDAR_CARD_COVER_WIDTH)
    /* loaded from: /data/np/file-convert/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135/2026022807143238e8ee96-c751-4ccd-b696-f1bdbd379135.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Deprecated(message = "pls use `SIMPLIFIED_CHINESE` instead", replaceWith = @ReplaceWith(expression = "SIMPLIFIED_CHINESE", imports = {}))
        public static /* synthetic */ void getSIMPLIFIED_CHINESE_DEPRECATED$annotations() {
        }

        private Companion() {
        }

        public final KSerializer<Locale> serializer() {
            return LocaleSerializer.INSTANCE;
        }

        public final Locale getCurrent$localization_debug() {
            return PlatformLocaleKt.getPlatformLocaleDelegate().getCurrent().get(0);
        }

        public final Locale getSIMPLIFIED_CHINESE_DEPRECATED() {
            return (Locale) Locale.SIMPLIFIED_CHINESE_DEPRECATED$delegate.getValue();
        }

        public final Locale getSIMPLIFIED_CHINESE() {
            return (Locale) Locale.SIMPLIFIED_CHINESE$delegate.getValue();
        }

        public final Locale getTRADITIONAL_CHINESE() {
            return (Locale) Locale.TRADITIONAL_CHINESE$delegate.getValue();
        }

        public final Locale getENGLISH() {
            return (Locale) Locale.ENGLISH$delegate.getValue();
        }

        public final Locale getFRENCH() {
            return (Locale) Locale.FRENCH$delegate.getValue();
        }

        public final Locale getGERMAN() {
            return (Locale) Locale.GERMAN$delegate.getValue();
        }

        public final Locale getITALIAN() {
            return (Locale) Locale.ITALIAN$delegate.getValue();
        }

        public final Locale getJAPANESE() {
            return (Locale) Locale.JAPANESE$delegate.getValue();
        }

        public final Locale getSPANISH() {
            return (Locale) Locale.SPANISH$delegate.getValue();
        }

        public final Locale getRUSSIAN() {
            return (Locale) Locale.RUSSIAN$delegate.getValue();
        }

        public final Locale getKOREAN() {
            return (Locale) Locale.KOREAN$delegate.getValue();
        }

        public final Locale getPORTUGUESE() {
            return (Locale) Locale.PORTUGUESE$delegate.getValue();
        }

        public final Locale getARABIC() {
            return (Locale) Locale.ARABIC$delegate.getValue();
        }

        public final Locale getTHAI() {
            return (Locale) Locale.THAI$delegate.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale SIMPLIFIED_CHINESE_DEPRECATED_delegate$lambda$0() {
        return new Locale("zh-CN");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale SIMPLIFIED_CHINESE_delegate$lambda$0() {
        return new Locale("zh-Hans-CN");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale TRADITIONAL_CHINESE_delegate$lambda$0() {
        return new Locale("zh-Hant-HK");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale ENGLISH_delegate$lambda$0() {
        return new Locale("en");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale FRENCH_delegate$lambda$0() {
        return new Locale("fr");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale GERMAN_delegate$lambda$0() {
        return new Locale("de");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale ITALIAN_delegate$lambda$0() {
        return new Locale("it");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale JAPANESE_delegate$lambda$0() {
        return new Locale("ja");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale SPANISH_delegate$lambda$0() {
        return new Locale("es");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale RUSSIAN_delegate$lambda$0() {
        return new Locale("ru");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale KOREAN_delegate$lambda$0() {
        return new Locale("ko");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale PORTUGUESE_delegate$lambda$0() {
        return new Locale("pt");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale ARABIC_delegate$lambda$0() {
        return new Locale("ar");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale THAI_delegate$lambda$0() {
        return new Locale("th");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Locale(String languageTag) {
        this(PlatformLocaleKt.getPlatformLocaleDelegate().parseLanguageTag(languageTag));
        Intrinsics.checkNotNullParameter(languageTag, "languageTag");
    }

    public final String getLanguage() {
        return PlatformLocale_androidKt.getLanguage(this.platformLocale);
    }

    public final String getScript() {
        return PlatformLocale_androidKt.getScript(this.platformLocale);
    }

    public final String getRegion() {
        return PlatformLocale_androidKt.getRegion(this.platformLocale);
    }

    public final String toLanguageTag() {
        return PlatformLocale_androidKt.getLanguageTag(this.platformLocale);
    }

    public boolean equals(Object other) {
        if (other == null || !(other instanceof Locale)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        return Intrinsics.areEqual(toLanguageTag(), ((Locale) other).toLanguageTag());
    }

    public int hashCode() {
        return toLanguageTag().hashCode();
    }

    public String toString() {
        return toLanguageTag();
    }

    private final String getBiliLanguageTag() {
        return (String) this.biliLanguageTag$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String biliLanguageTag_delegate$lambda$0(Locale this$0) {
        String sc = this$0.getScript().length() > 0 ? "-" + this$0.getScript() : "";
        String re = this$0.getRegion().length() > 0 ? "_" + this$0.getRegion() : "";
        return this$0.getLanguage() + sc + re;
    }

    public final String toBiliLanguageTag() {
        return getBiliLanguageTag();
    }
}