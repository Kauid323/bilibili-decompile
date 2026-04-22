package tv.danmaku.bili.fullscreen.page;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.danmaku.bili.BR;
import tv.danmaku.bili.eula.EulaLinkType;

/* compiled from: Common.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\b\u0002\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Ltv/danmaku/bili/fullscreen/page/EulaLinkEnum;", "", "getType", "Lkotlin/Function1;", "", "Ltv/danmaku/bili/eula/EulaLinkType;", "<init>", "(Ljava/lang/String;ILkotlin/jvm/functions/Function1;)V", "getGetType", "()Lkotlin/jvm/functions/Function1;", "Agreement", "Privacy", "IspAgreement", "Help", "accountui_apinkDebug"}, k = 1, mv = {2, 0, 0}, xi = BR.badgeVisibility)
public enum EulaLinkEnum {
    Agreement(new Function1() { // from class: tv.danmaku.bili.fullscreen.page.EulaLinkEnum$$ExternalSyntheticLambda0
        public final Object invoke(Object obj) {
            EulaLinkType _init_$lambda$0;
            _init_$lambda$0 = EulaLinkEnum._init_$lambda$0((String) obj);
            return _init_$lambda$0;
        }
    }),
    Privacy(new Function1() { // from class: tv.danmaku.bili.fullscreen.page.EulaLinkEnum$$ExternalSyntheticLambda1
        public final Object invoke(Object obj) {
            EulaLinkType _init_$lambda$1;
            _init_$lambda$1 = EulaLinkEnum._init_$lambda$1((String) obj);
            return _init_$lambda$1;
        }
    }),
    IspAgreement(new Function1() { // from class: tv.danmaku.bili.fullscreen.page.EulaLinkEnum$$ExternalSyntheticLambda2
        public final Object invoke(Object obj) {
            EulaLinkType _init_$lambda$2;
            _init_$lambda$2 = EulaLinkEnum._init_$lambda$2((String) obj);
            return _init_$lambda$2;
        }
    }),
    Help(new Function1() { // from class: tv.danmaku.bili.fullscreen.page.EulaLinkEnum$$ExternalSyntheticLambda3
        public final Object invoke(Object obj) {
            EulaLinkType _init_$lambda$3;
            _init_$lambda$3 = EulaLinkEnum._init_$lambda$3((String) obj);
            return _init_$lambda$3;
        }
    });
    
    private final Function1<String, EulaLinkType> getType;
    private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

    public static EnumEntries<EulaLinkEnum> getEntries() {
        return $ENTRIES;
    }

    EulaLinkEnum(Function1 getType) {
        this.getType = getType;
    }

    public final Function1<String, EulaLinkType> getGetType() {
        return this.getType;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EulaLinkType _init_$lambda$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new EulaLinkType.Agreement(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EulaLinkType _init_$lambda$1(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new EulaLinkType.Privacy(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EulaLinkType _init_$lambda$2(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new EulaLinkType.IspAgreement(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EulaLinkType _init_$lambda$3(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new EulaLinkType.Help(it);
    }
}