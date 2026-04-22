package kotlinx.datetime.format;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: UtcOffsetFormat.kt */
@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0000\u001a<\u0010\u0017\u001a\u00020\u000f\"\b\b\u0000\u0010\u0018*\u00020\u0019*\u0002H\u00182\u0006\u0010\u001a\u001a\u00020\u00152\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u000f0\u001c¢\u0006\u0002\b\u001dH\u0000¢\u0006\u0002\u0010\u001e\"\u001b\u0010\u0000\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0003\"\u001b\u0010\u0006\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\u0007\u0010\u0003\"\u001b\u0010\t\u001a\u00020\u00018@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\n\u0010\u0003\"\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"FOUR_DIGIT_OFFSET", "Lkotlinx/datetime/format/UtcOffsetFormat;", "getFOUR_DIGIT_OFFSET", "()Lkotlinx/datetime/format/UtcOffsetFormat;", "FOUR_DIGIT_OFFSET$delegate", "Lkotlin/Lazy;", "ISO_OFFSET", "getISO_OFFSET", "ISO_OFFSET$delegate", "ISO_OFFSET_BASIC", "getISO_OFFSET_BASIC", "ISO_OFFSET_BASIC$delegate", "emptyIncompleteUtcOffset", "Lkotlinx/datetime/format/IncompleteUtcOffset;", "isoOffset", "", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithUtcOffset;", "zOnZero", "", "useSeparator", "outputMinute", "Lkotlinx/datetime/format/WhenToOutput;", "outputSecond", "outputIfNeeded", "T", "Lkotlinx/datetime/format/DateTimeFormatBuilder;", "whenToOutput", "format", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/datetime/format/DateTimeFormatBuilder;Lkotlinx/datetime/format/WhenToOutput;Lkotlin/jvm/functions/Function1;)V", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UtcOffsetFormatKt {
    private static final Lazy ISO_OFFSET$delegate = LazyKt.lazy(new Function0<UtcOffsetFormat>() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$ISO_OFFSET$2
        @Override // kotlin.jvm.functions.Function0
        public final UtcOffsetFormat invoke() {
            return UtcOffsetFormat.Companion.build(new Function1<DateTimeFormatBuilder.WithUtcOffset, Unit>() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$ISO_OFFSET$2.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithUtcOffset withUtcOffset) {
                    invoke2(withUtcOffset);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(DateTimeFormatBuilder.WithUtcOffset build) {
                    Intrinsics.checkNotNullParameter(build, "$this$build");
                    DateTimeFormatBuilderKt.alternativeParsing(build, new Function1[]{new Function1<DateTimeFormatBuilder.WithUtcOffset, Unit>() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt.ISO_OFFSET.2.1.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithUtcOffset withUtcOffset) {
                            invoke2(withUtcOffset);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(DateTimeFormatBuilder.WithUtcOffset alternativeParsing) {
                            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                            alternativeParsing.chars("z");
                        }
                    }}, new Function1<DateTimeFormatBuilder.WithUtcOffset, Unit>() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt.ISO_OFFSET.2.1.2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithUtcOffset withUtcOffset) {
                            invoke2(withUtcOffset);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(DateTimeFormatBuilder.WithUtcOffset alternativeParsing) {
                            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                            DateTimeFormatBuilderKt.optional(alternativeParsing, "Z", new Function1<DateTimeFormatBuilder.WithUtcOffset, Unit>() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt.ISO_OFFSET.2.1.2.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithUtcOffset withUtcOffset) {
                                    invoke2(withUtcOffset);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(DateTimeFormatBuilder.WithUtcOffset optional) {
                                    Intrinsics.checkNotNullParameter(optional, "$this$optional");
                                    DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.offsetHours$default(optional, null, 1, null);
                                    DateTimeFormatBuilderKt.m1484char(optional, AbstractJsonLexerKt.COLON);
                                    DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.offsetMinutesOfHour$default(optional, null, 1, null);
                                    DateTimeFormatBuilderKt.optional$default(optional, null, new Function1<DateTimeFormatBuilder.WithUtcOffset, Unit>() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt.ISO_OFFSET.2.1.2.1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithUtcOffset withUtcOffset) {
                                            invoke2(withUtcOffset);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                        public final void invoke2(DateTimeFormatBuilder.WithUtcOffset optional2) {
                                            Intrinsics.checkNotNullParameter(optional2, "$this$optional");
                                            DateTimeFormatBuilderKt.m1484char(optional2, AbstractJsonLexerKt.COLON);
                                            DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.offsetSecondsOfMinute$default(optional2, null, 1, null);
                                        }
                                    }, 1, null);
                                }
                            });
                        }
                    });
                }
            });
        }
    });
    private static final Lazy ISO_OFFSET_BASIC$delegate = LazyKt.lazy(new Function0<UtcOffsetFormat>() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$ISO_OFFSET_BASIC$2
        @Override // kotlin.jvm.functions.Function0
        public final UtcOffsetFormat invoke() {
            return UtcOffsetFormat.Companion.build(new Function1<DateTimeFormatBuilder.WithUtcOffset, Unit>() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$ISO_OFFSET_BASIC$2.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithUtcOffset withUtcOffset) {
                    invoke2(withUtcOffset);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(DateTimeFormatBuilder.WithUtcOffset build) {
                    Intrinsics.checkNotNullParameter(build, "$this$build");
                    DateTimeFormatBuilderKt.alternativeParsing(build, new Function1[]{new Function1<DateTimeFormatBuilder.WithUtcOffset, Unit>() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt.ISO_OFFSET_BASIC.2.1.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithUtcOffset withUtcOffset) {
                            invoke2(withUtcOffset);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(DateTimeFormatBuilder.WithUtcOffset alternativeParsing) {
                            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                            alternativeParsing.chars("z");
                        }
                    }}, new Function1<DateTimeFormatBuilder.WithUtcOffset, Unit>() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt.ISO_OFFSET_BASIC.2.1.2
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithUtcOffset withUtcOffset) {
                            invoke2(withUtcOffset);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(DateTimeFormatBuilder.WithUtcOffset alternativeParsing) {
                            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                            DateTimeFormatBuilderKt.optional(alternativeParsing, "Z", new Function1<DateTimeFormatBuilder.WithUtcOffset, Unit>() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt.ISO_OFFSET_BASIC.2.1.2.1
                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithUtcOffset withUtcOffset) {
                                    invoke2(withUtcOffset);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                public final void invoke2(DateTimeFormatBuilder.WithUtcOffset optional) {
                                    Intrinsics.checkNotNullParameter(optional, "$this$optional");
                                    DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.offsetHours$default(optional, null, 1, null);
                                    DateTimeFormatBuilderKt.optional$default(optional, null, new Function1<DateTimeFormatBuilder.WithUtcOffset, Unit>() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt.ISO_OFFSET_BASIC.2.1.2.1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithUtcOffset withUtcOffset) {
                                            invoke2(withUtcOffset);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                        public final void invoke2(DateTimeFormatBuilder.WithUtcOffset optional2) {
                                            Intrinsics.checkNotNullParameter(optional2, "$this$optional");
                                            DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.offsetMinutesOfHour$default(optional2, null, 1, null);
                                            DateTimeFormatBuilderKt.optional$default(optional2, null, new Function1<DateTimeFormatBuilder.WithUtcOffset, Unit>() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt.ISO_OFFSET_BASIC.2.1.2.1.1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithUtcOffset withUtcOffset) {
                                                    invoke2(withUtcOffset);
                                                    return Unit.INSTANCE;
                                                }

                                                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                                public final void invoke2(DateTimeFormatBuilder.WithUtcOffset optional3) {
                                                    Intrinsics.checkNotNullParameter(optional3, "$this$optional");
                                                    DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.offsetSecondsOfMinute$default(optional3, null, 1, null);
                                                }
                                            }, 1, null);
                                        }
                                    }, 1, null);
                                }
                            });
                        }
                    });
                }
            });
        }
    });
    private static final Lazy FOUR_DIGIT_OFFSET$delegate = LazyKt.lazy(new Function0<UtcOffsetFormat>() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$FOUR_DIGIT_OFFSET$2
        @Override // kotlin.jvm.functions.Function0
        public final UtcOffsetFormat invoke() {
            return UtcOffsetFormat.Companion.build(new Function1<DateTimeFormatBuilder.WithUtcOffset, Unit>() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$FOUR_DIGIT_OFFSET$2.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithUtcOffset withUtcOffset) {
                    invoke2(withUtcOffset);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(DateTimeFormatBuilder.WithUtcOffset build) {
                    Intrinsics.checkNotNullParameter(build, "$this$build");
                    DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.offsetHours$default(build, null, 1, null);
                    DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.offsetMinutesOfHour$default(build, null, 1, null);
                }
            });
        }
    });
    private static final IncompleteUtcOffset emptyIncompleteUtcOffset = new IncompleteUtcOffset(null, null, null, null, 15, null);

    /* compiled from: UtcOffsetFormat.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WhenToOutput.values().length];
            try {
                iArr[WhenToOutput.NEVER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[WhenToOutput.IF_NONZERO.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[WhenToOutput.ALWAYS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final /* synthetic */ IncompleteUtcOffset access$getEmptyIncompleteUtcOffset$p() {
        return emptyIncompleteUtcOffset;
    }

    public static final <T extends DateTimeFormatBuilder> void outputIfNeeded(T t, WhenToOutput whenToOutput, final Function1<? super T, Unit> format) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(whenToOutput, "whenToOutput");
        Intrinsics.checkNotNullParameter(format, "format");
        switch (WhenMappings.$EnumSwitchMapping$0[whenToOutput.ordinal()]) {
            case 1:
            default:
                return;
            case 2:
                DateTimeFormatBuilderKt.optional$default(t, null, new Function1<T, Unit>() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$outputIfNeeded$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object p1) {
                        invoke((DateTimeFormatBuilder) p1);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Incorrect types in method signature: (TT;)V */
                    public final void invoke(DateTimeFormatBuilder optional) {
                        Intrinsics.checkNotNullParameter(optional, "$this$optional");
                        format.invoke(optional);
                    }
                }, 1, null);
                return;
            case 3:
                format.invoke(t);
                return;
        }
    }

    public static final void isoOffset(DateTimeFormatBuilder.WithUtcOffset $this$isoOffset, boolean zOnZero, final boolean useSeparator, final WhenToOutput outputMinute, final WhenToOutput outputSecond) {
        Intrinsics.checkNotNullParameter($this$isoOffset, "<this>");
        Intrinsics.checkNotNullParameter(outputMinute, "outputMinute");
        Intrinsics.checkNotNullParameter(outputSecond, "outputSecond");
        if (!(outputMinute.compareTo(outputSecond) >= 0)) {
            throw new IllegalArgumentException("Seconds cannot be included without minutes".toString());
        }
        if (zOnZero) {
            DateTimeFormatBuilderKt.optional($this$isoOffset, "Z", new Function1<DateTimeFormatBuilder.WithUtcOffset, Unit>() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$isoOffset$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithUtcOffset withUtcOffset) {
                    invoke2(withUtcOffset);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(DateTimeFormatBuilder.WithUtcOffset optional) {
                    Intrinsics.checkNotNullParameter(optional, "$this$optional");
                    Function1[] function1Arr = {new Function1<DateTimeFormatBuilder.WithUtcOffset, Unit>() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$isoOffset$2.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithUtcOffset withUtcOffset) {
                            invoke2(withUtcOffset);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(DateTimeFormatBuilder.WithUtcOffset alternativeParsing) {
                            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                            DateTimeFormatBuilderKt.m1484char(alternativeParsing, 'z');
                        }
                    }};
                    final WhenToOutput whenToOutput = WhenToOutput.this;
                    final boolean z = useSeparator;
                    final WhenToOutput whenToOutput2 = outputSecond;
                    DateTimeFormatBuilderKt.alternativeParsing(optional, function1Arr, new Function1<DateTimeFormatBuilder.WithUtcOffset, Unit>() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$isoOffset$2.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithUtcOffset withUtcOffset) {
                            invoke2(withUtcOffset);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke  reason: avoid collision after fix types in other method */
                        public final void invoke2(DateTimeFormatBuilder.WithUtcOffset alternativeParsing) {
                            Intrinsics.checkNotNullParameter(alternativeParsing, "$this$alternativeParsing");
                            UtcOffsetFormatKt.isoOffset$appendIsoOffsetWithoutZOnZero(alternativeParsing, WhenToOutput.this, z, whenToOutput2);
                        }
                    });
                }
            });
        } else {
            isoOffset$appendIsoOffsetWithoutZOnZero($this$isoOffset, outputMinute, useSeparator, outputSecond);
        }
    }

    public static final void isoOffset$appendIsoOffsetWithoutZOnZero(DateTimeFormatBuilder.WithUtcOffset $this$isoOffset_u24appendIsoOffsetWithoutZOnZero, WhenToOutput $outputMinute, final boolean $useSeparator, final WhenToOutput $outputSecond) {
        DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.offsetHours$default($this$isoOffset_u24appendIsoOffsetWithoutZOnZero, null, 1, null);
        outputIfNeeded($this$isoOffset_u24appendIsoOffsetWithoutZOnZero, $outputMinute, new Function1<DateTimeFormatBuilder.WithUtcOffset, Unit>() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$isoOffset$appendIsoOffsetWithoutZOnZero$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithUtcOffset withUtcOffset) {
                invoke2(withUtcOffset);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DateTimeFormatBuilder.WithUtcOffset outputIfNeeded) {
                Intrinsics.checkNotNullParameter(outputIfNeeded, "$this$outputIfNeeded");
                if ($useSeparator) {
                    DateTimeFormatBuilderKt.m1484char(outputIfNeeded, AbstractJsonLexerKt.COLON);
                }
                DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.offsetMinutesOfHour$default(outputIfNeeded, null, 1, null);
                WhenToOutput whenToOutput = $outputSecond;
                final boolean z = $useSeparator;
                UtcOffsetFormatKt.outputIfNeeded(outputIfNeeded, whenToOutput, new Function1<DateTimeFormatBuilder.WithUtcOffset, Unit>() { // from class: kotlinx.datetime.format.UtcOffsetFormatKt$isoOffset$appendIsoOffsetWithoutZOnZero$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(DateTimeFormatBuilder.WithUtcOffset withUtcOffset) {
                        invoke2(withUtcOffset);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(DateTimeFormatBuilder.WithUtcOffset outputIfNeeded2) {
                        Intrinsics.checkNotNullParameter(outputIfNeeded2, "$this$outputIfNeeded");
                        if (z) {
                            DateTimeFormatBuilderKt.m1484char(outputIfNeeded2, AbstractJsonLexerKt.COLON);
                        }
                        DateTimeFormatBuilder.WithUtcOffset.DefaultImpls.offsetSecondsOfMinute$default(outputIfNeeded2, null, 1, null);
                    }
                });
            }
        });
    }

    public static final UtcOffsetFormat getISO_OFFSET() {
        return (UtcOffsetFormat) ISO_OFFSET$delegate.getValue();
    }

    public static final UtcOffsetFormat getISO_OFFSET_BASIC() {
        return (UtcOffsetFormat) ISO_OFFSET_BASIC$delegate.getValue();
    }

    public static final UtcOffsetFormat getFOUR_DIGIT_OFFSET() {
        return (UtcOffsetFormat) FOUR_DIGIT_OFFSET$delegate.getValue();
    }
}