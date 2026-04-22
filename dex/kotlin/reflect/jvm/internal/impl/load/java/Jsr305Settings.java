package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: Jsr305Settings.kt */
public final class Jsr305Settings {
    private final Lazy description$delegate;
    private final ReportLevel globalLevel;
    private final boolean isDisabled;
    private final ReportLevel migrationLevel;
    private final Map<FqName, ReportLevel> userDefinedLevelForSpecificAnnotation;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Jsr305Settings) {
            Jsr305Settings jsr305Settings = (Jsr305Settings) obj;
            return this.globalLevel == jsr305Settings.globalLevel && this.migrationLevel == jsr305Settings.migrationLevel && Intrinsics.areEqual(this.userDefinedLevelForSpecificAnnotation, jsr305Settings.userDefinedLevelForSpecificAnnotation);
        }
        return false;
    }

    public int hashCode() {
        return (((this.globalLevel.hashCode() * 31) + (this.migrationLevel == null ? 0 : this.migrationLevel.hashCode())) * 31) + this.userDefinedLevelForSpecificAnnotation.hashCode();
    }

    public String toString() {
        return "Jsr305Settings(globalLevel=" + this.globalLevel + ", migrationLevel=" + this.migrationLevel + ", userDefinedLevelForSpecificAnnotation=" + this.userDefinedLevelForSpecificAnnotation + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Jsr305Settings(ReportLevel globalLevel, ReportLevel migrationLevel, Map<FqName, ? extends ReportLevel> userDefinedLevelForSpecificAnnotation) {
        Intrinsics.checkNotNullParameter(globalLevel, "globalLevel");
        Intrinsics.checkNotNullParameter(userDefinedLevelForSpecificAnnotation, "userDefinedLevelForSpecificAnnotation");
        this.globalLevel = globalLevel;
        this.migrationLevel = migrationLevel;
        this.userDefinedLevelForSpecificAnnotation = userDefinedLevelForSpecificAnnotation;
        this.description$delegate = LazyKt.lazy(new Function0(this) { // from class: kotlin.reflect.jvm.internal.impl.load.java.Jsr305Settings$$Lambda$0
            private final Jsr305Settings arg$0;

            {
                this.arg$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                String[] description_delegate$lambda$0;
                description_delegate$lambda$0 = Jsr305Settings.description_delegate$lambda$0(this.arg$0);
                return description_delegate$lambda$0;
            }
        });
        this.isDisabled = this.globalLevel == ReportLevel.IGNORE && this.migrationLevel == ReportLevel.IGNORE && this.userDefinedLevelForSpecificAnnotation.isEmpty();
    }

    public /* synthetic */ Jsr305Settings(ReportLevel reportLevel, ReportLevel reportLevel2, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(reportLevel, (i & 2) != 0 ? null : reportLevel2, (i & 4) != 0 ? MapsKt.emptyMap() : map);
    }

    public final ReportLevel getGlobalLevel() {
        return this.globalLevel;
    }

    public final ReportLevel getMigrationLevel() {
        return this.migrationLevel;
    }

    public final Map<FqName, ReportLevel> getUserDefinedLevelForSpecificAnnotation() {
        return this.userDefinedLevelForSpecificAnnotation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String[] description_delegate$lambda$0(Jsr305Settings this$0) {
        List $this$description_delegate_u24lambda_u240_u240 = CollectionsKt.createListBuilder();
        $this$description_delegate_u24lambda_u240_u240.add(this$0.globalLevel.getDescription());
        ReportLevel it = this$0.migrationLevel;
        if (it != null) {
            $this$description_delegate_u24lambda_u240_u240.add("under-migration:" + it.getDescription());
        }
        Map $this$forEach$iv = this$0.userDefinedLevelForSpecificAnnotation;
        for (Map.Entry element$iv : $this$forEach$iv.entrySet()) {
            $this$description_delegate_u24lambda_u240_u240.add('@' + element$iv.getKey() + AbstractJsonLexerKt.COLON + element$iv.getValue().getDescription());
        }
        Collection $this$toTypedArray$iv = CollectionsKt.build($this$description_delegate_u24lambda_u240_u240);
        return (String[]) $this$toTypedArray$iv.toArray(new String[0]);
    }

    public final boolean isDisabled() {
        return this.isDisabled;
    }
}