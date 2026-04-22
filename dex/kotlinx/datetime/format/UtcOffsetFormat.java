package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.UtcOffset;
import kotlinx.datetime.format.AbstractDateTimeFormatBuilder;
import kotlinx.datetime.format.AbstractWithOffsetBuilder;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.datetime.internal.format.AppendableFormatStructure;
import kotlinx.datetime.internal.format.CachedFormatStructure;
import kotlinx.datetime.internal.format.FormatStructure;

/* compiled from: UtcOffsetFormat.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 \u00122\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0011\u0012B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0003H\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lkotlinx/datetime/format/UtcOffsetFormat;", "Lkotlinx/datetime/format/AbstractDateTimeFormat;", "Lkotlinx/datetime/UtcOffset;", "Lkotlinx/datetime/format/IncompleteUtcOffset;", "actualFormat", "Lkotlinx/datetime/internal/format/CachedFormatStructure;", "Lkotlinx/datetime/format/UtcOffsetFieldContainer;", "(Lkotlinx/datetime/internal/format/CachedFormatStructure;)V", "getActualFormat", "()Lkotlinx/datetime/internal/format/CachedFormatStructure;", "emptyIntermediate", "getEmptyIntermediate", "()Lkotlinx/datetime/format/IncompleteUtcOffset;", "intermediateFromValue", "value", "valueFromIntermediate", "intermediate", "Builder", "Companion", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UtcOffsetFormat extends AbstractDateTimeFormat<UtcOffset, IncompleteUtcOffset> {
    public static final Companion Companion = new Companion(null);
    private final CachedFormatStructure<UtcOffsetFieldContainer> actualFormat;

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public CachedFormatStructure<IncompleteUtcOffset> getActualFormat() {
        return this.actualFormat;
    }

    /* compiled from: UtcOffsetFormat.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¨\u0006\n"}, d2 = {"Lkotlinx/datetime/format/UtcOffsetFormat$Companion;", "", "()V", "build", "Lkotlinx/datetime/format/UtcOffsetFormat;", "block", "Lkotlin/Function1;", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithUtcOffset;", "", "Lkotlin/ExtensionFunctionType;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UtcOffsetFormat build(Function1<? super DateTimeFormatBuilder.WithUtcOffset, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Builder builder = new Builder(new AppendableFormatStructure());
            block.invoke(builder);
            return new UtcOffsetFormat(builder.build());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public UtcOffsetFormat(CachedFormatStructure<? super UtcOffsetFieldContainer> actualFormat) {
        super(null);
        Intrinsics.checkNotNullParameter(actualFormat, "actualFormat");
        this.actualFormat = actualFormat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UtcOffsetFormat.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u0000H\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lkotlinx/datetime/format/UtcOffsetFormat$Builder;", "Lkotlinx/datetime/format/AbstractDateTimeFormatBuilder;", "Lkotlinx/datetime/format/UtcOffsetFieldContainer;", "Lkotlinx/datetime/format/AbstractWithOffsetBuilder;", "actualBuilder", "Lkotlinx/datetime/internal/format/AppendableFormatStructure;", "(Lkotlinx/datetime/internal/format/AppendableFormatStructure;)V", "getActualBuilder", "()Lkotlinx/datetime/internal/format/AppendableFormatStructure;", "addFormatStructureForOffset", "", "structure", "Lkotlinx/datetime/internal/format/FormatStructure;", "createEmpty", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Builder implements AbstractDateTimeFormatBuilder<UtcOffsetFieldContainer, Builder>, AbstractWithOffsetBuilder {
        private final AppendableFormatStructure<UtcOffsetFieldContainer> actualBuilder;

        public Builder(AppendableFormatStructure<UtcOffsetFieldContainer> actualBuilder) {
            Intrinsics.checkNotNullParameter(actualBuilder, "actualBuilder");
            this.actualBuilder = actualBuilder;
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public void appendAlternativeParsingImpl(Function1<? super Builder, Unit>[] function1Arr, Function1<? super Builder, Unit> function1) {
            AbstractDateTimeFormatBuilder.DefaultImpls.appendAlternativeParsingImpl(this, function1Arr, function1);
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public void appendOptionalImpl(String onZero, Function1<? super Builder, Unit> function1) {
            AbstractDateTimeFormatBuilder.DefaultImpls.appendOptionalImpl(this, onZero, function1);
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public CachedFormatStructure<UtcOffsetFieldContainer> build() {
            return AbstractDateTimeFormatBuilder.DefaultImpls.build(this);
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder, kotlinx.datetime.format.DateTimeFormatBuilder
        public void chars(String value) {
            AbstractDateTimeFormatBuilder.DefaultImpls.chars(this, value);
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public AppendableFormatStructure<UtcOffsetFieldContainer> getActualBuilder() {
            return this.actualBuilder;
        }

        @Override // kotlinx.datetime.format.AbstractWithOffsetBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
        public void offset(DateTimeFormat<UtcOffset> dateTimeFormat) {
            AbstractWithOffsetBuilder.DefaultImpls.offset(this, dateTimeFormat);
        }

        @Override // kotlinx.datetime.format.AbstractWithOffsetBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
        public void offsetHours(Padding padding) {
            AbstractWithOffsetBuilder.DefaultImpls.offsetHours(this, padding);
        }

        @Override // kotlinx.datetime.format.AbstractWithOffsetBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
        public void offsetMinutesOfHour(Padding padding) {
            AbstractWithOffsetBuilder.DefaultImpls.offsetMinutesOfHour(this, padding);
        }

        @Override // kotlinx.datetime.format.AbstractWithOffsetBuilder, kotlinx.datetime.format.DateTimeFormatBuilder.WithUtcOffset
        public void offsetSecondsOfMinute(Padding padding) {
            AbstractWithOffsetBuilder.DefaultImpls.offsetSecondsOfMinute(this, padding);
        }

        @Override // kotlinx.datetime.format.AbstractWithOffsetBuilder
        public void addFormatStructureForOffset(FormatStructure<? super UtcOffsetFieldContainer> structure) {
            Intrinsics.checkNotNullParameter(structure, "structure");
            getActualBuilder().add(structure);
        }

        @Override // kotlinx.datetime.format.AbstractDateTimeFormatBuilder
        public Builder createEmpty() {
            return new Builder(new AppendableFormatStructure());
        }
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public IncompleteUtcOffset intermediateFromValue(UtcOffset value) {
        Intrinsics.checkNotNullParameter(value, "value");
        IncompleteUtcOffset $this$intermediateFromValue_u24lambda_u240 = new IncompleteUtcOffset(null, null, null, null, 15, null);
        $this$intermediateFromValue_u24lambda_u240.populateFrom(value);
        return $this$intermediateFromValue_u24lambda_u240;
    }

    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public UtcOffset valueFromIntermediate(IncompleteUtcOffset intermediate) {
        Intrinsics.checkNotNullParameter(intermediate, "intermediate");
        return intermediate.toUtcOffset();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlinx.datetime.format.AbstractDateTimeFormat
    public IncompleteUtcOffset getEmptyIntermediate() {
        return UtcOffsetFormatKt.access$getEmptyIncompleteUtcOffset$p();
    }
}