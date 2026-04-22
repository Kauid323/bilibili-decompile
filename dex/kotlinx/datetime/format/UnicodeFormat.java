package kotlinx.datetime.format;

import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.datetime.format.DateTimeFormatBuilder;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: Unicode.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u0000 \u00022\u00020\u0001:\u0005\u0002\u0003\u0004\u0005\u0006\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat;", "", "Companion", "Directive", "OptionalGroup", "Sequence", "StringLiteral", "Lkotlinx/datetime/format/UnicodeFormat$Directive;", "Lkotlinx/datetime/format/UnicodeFormat$OptionalGroup;", "Lkotlinx/datetime/format/UnicodeFormat$Sequence;", "Lkotlinx/datetime/format/UnicodeFormat$StringLiteral;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface UnicodeFormat {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Unicode.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Companion;", "", "()V", "parse", "Lkotlinx/datetime/format/UnicodeFormat;", "pattern", "", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final UnicodeFormat parse(String pattern) {
            List list;
            List list2;
            UnicodeFormat unicodeDirective;
            List list3;
            UnicodeFormat unicodeDirective2;
            Intrinsics.checkNotNullParameter(pattern, "pattern");
            List groups = CollectionsKt.mutableListOf(new ArrayList());
            boolean insideLiteral = false;
            String literal = "";
            Character lastCharacter = null;
            int lastCharacterCount = 0;
            int length = pattern.length();
            for (int i = 0; i < length; i++) {
                char character = pattern.charAt(i);
                if (lastCharacter != null && character == lastCharacter.charValue()) {
                    lastCharacterCount++;
                } else if (insideLiteral) {
                    if (character == '\'') {
                        List list4 = (List) CollectionsKt.last((List<? extends Object>) groups);
                        if (list4 != null) {
                            String str = literal;
                            if (str.length() == 0) {
                                str = "'";
                            }
                            list4.add(new StringLiteral(str));
                        }
                        insideLiteral = false;
                        literal = "";
                    } else {
                        literal = literal + character;
                    }
                } else {
                    if (lastCharacterCount > 0) {
                        List list5 = (List) CollectionsKt.last((List<? extends Object>) groups);
                        if (list5 != null) {
                            Intrinsics.checkNotNull(lastCharacter);
                            unicodeDirective2 = UnicodeKt.unicodeDirective(lastCharacter.charValue(), lastCharacterCount);
                            list5.add(unicodeDirective2);
                        }
                        lastCharacter = null;
                        lastCharacterCount = 0;
                    }
                    list3 = UnicodeKt.nonPlainCharacters;
                    if (!list3.contains(Character.valueOf(character))) {
                        literal = literal + character;
                    } else {
                        if (!Intrinsics.areEqual(literal, "")) {
                            List list6 = (List) CollectionsKt.last((List<? extends Object>) groups);
                            if (list6 != null) {
                                list6.add(new StringLiteral(literal));
                            }
                            literal = "";
                        }
                        if (character == '\'') {
                            insideLiteral = true;
                            literal = "";
                        } else if (character == '[') {
                            groups.add(new ArrayList());
                        } else if (character == ']') {
                            List group = (List) CollectionsKt.removeLast(groups);
                            if (group == null) {
                                throw new IllegalArgumentException("Unmatched closing bracket");
                            }
                            List list7 = (List) CollectionsKt.last((List<? extends Object>) groups);
                            if (list7 != null) {
                                list7.add(new OptionalGroup(new Sequence(group)));
                            }
                        } else {
                            lastCharacter = Character.valueOf(character);
                            lastCharacterCount = 1;
                        }
                    }
                }
            }
            if (lastCharacterCount > 0 && (list2 = (List) CollectionsKt.last((List<? extends Object>) groups)) != null) {
                Intrinsics.checkNotNull(lastCharacter);
                unicodeDirective = UnicodeKt.unicodeDirective(lastCharacter.charValue(), lastCharacterCount);
                list2.add(unicodeDirective);
            }
            if (!Intrinsics.areEqual(literal, "") && (list = (List) CollectionsKt.last((List<? extends Object>) groups)) != null) {
                list.add(new StringLiteral(literal));
            }
            List list8 = (List) CollectionsKt.removeLast(groups);
            if (list8 != null) {
                return new Sequence(list8);
            }
            throw new IllegalArgumentException("Unmatched opening bracket");
        }
    }

    /* compiled from: Unicode.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\t\u0010\u0006\u001a\u00020\u0001HÆ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001HÆ\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0010"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$OptionalGroup;", "Lkotlinx/datetime/format/UnicodeFormat;", "format", "(Lkotlinx/datetime/format/UnicodeFormat;)V", "getFormat", "()Lkotlinx/datetime/format/UnicodeFormat;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class OptionalGroup implements UnicodeFormat {
        private final UnicodeFormat format;

        public static /* synthetic */ OptionalGroup copy$default(OptionalGroup optionalGroup, UnicodeFormat unicodeFormat, int i, Object obj) {
            if ((i & 1) != 0) {
                unicodeFormat = optionalGroup.format;
            }
            return optionalGroup.copy(unicodeFormat);
        }

        public final UnicodeFormat component1() {
            return this.format;
        }

        public final OptionalGroup copy(UnicodeFormat format) {
            Intrinsics.checkNotNullParameter(format, "format");
            return new OptionalGroup(format);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof OptionalGroup) && Intrinsics.areEqual(this.format, ((OptionalGroup) obj).format);
        }

        public int hashCode() {
            return this.format.hashCode();
        }

        public OptionalGroup(UnicodeFormat format) {
            Intrinsics.checkNotNullParameter(format, "format");
            this.format = format;
        }

        public final UnicodeFormat getFormat() {
            return this.format;
        }

        public String toString() {
            return new StringBuilder().append(AbstractJsonLexerKt.BEGIN_LIST).append(this.format).append(AbstractJsonLexerKt.END_LIST).toString();
        }
    }

    /* compiled from: Unicode.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0003J\u0019\u0010\b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Sequence;", "Lkotlinx/datetime/format/UnicodeFormat;", "formats", "", "(Ljava/util/List;)V", "getFormats", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class Sequence implements UnicodeFormat {
        private final List<UnicodeFormat> formats;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Sequence copy$default(Sequence sequence, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = sequence.formats;
            }
            return sequence.copy(list);
        }

        public final List<UnicodeFormat> component1() {
            return this.formats;
        }

        public final Sequence copy(List<? extends UnicodeFormat> formats) {
            Intrinsics.checkNotNullParameter(formats, "formats");
            return new Sequence(formats);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Sequence) && Intrinsics.areEqual(this.formats, ((Sequence) obj).formats);
        }

        public int hashCode() {
            return this.formats.hashCode();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Sequence(List<? extends UnicodeFormat> formats) {
            Intrinsics.checkNotNullParameter(formats, "formats");
            this.formats = formats;
        }

        public final List<UnicodeFormat> getFormats() {
            return this.formats;
        }

        public String toString() {
            return CollectionsKt.joinToString$default(this.formats, "", null, null, 0, null, null, 62, null);
        }
    }

    /* compiled from: Unicode.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$StringLiteral;", "Lkotlinx/datetime/format/UnicodeFormat;", "literal", "", "(Ljava/lang/String;)V", "getLiteral", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static final class StringLiteral implements UnicodeFormat {
        private final String literal;

        public static /* synthetic */ StringLiteral copy$default(StringLiteral stringLiteral, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = stringLiteral.literal;
            }
            return stringLiteral.copy(str);
        }

        public final String component1() {
            return this.literal;
        }

        public final StringLiteral copy(String literal) {
            Intrinsics.checkNotNullParameter(literal, "literal");
            return new StringLiteral(literal);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StringLiteral) && Intrinsics.areEqual(this.literal, ((StringLiteral) obj).literal);
        }

        public int hashCode() {
            return this.literal.hashCode();
        }

        public StringLiteral(String literal) {
            Intrinsics.checkNotNullParameter(literal, "literal");
            this.literal = literal;
        }

        public final String getLiteral() {
            return this.literal;
        }

        public String toString() {
            CharSequence $this$any$iv;
            if (Intrinsics.areEqual(this.literal, "'")) {
                return "''";
            }
            CharSequence $this$any$iv2 = this.literal;
            int i = 0;
            while (true) {
                if (i < $this$any$iv2.length()) {
                    char element$iv = $this$any$iv2.charAt(i);
                    if (Character.isLetter(element$iv)) {
                        $this$any$iv = 1;
                        break;
                    }
                    i++;
                } else {
                    $this$any$iv = null;
                    break;
                }
            }
            if ($this$any$iv != null) {
                return '\'' + this.literal + '\'';
            }
            return this.literal.length() == 0 ? "" : this.literal;
        }
    }

    /* compiled from: Unicode.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0012\u0013\u0014\u0015B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u0005\u0016\u0017\u0018\u0019\u001a¨\u0006\u001b"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive;", "Lkotlinx/datetime/format/UnicodeFormat;", "()V", "formatLength", "", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "equals", "", "other", "", "hashCode", "toString", "", "DateBased", "OffsetBased", "TimeBased", "ZoneBased", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$OffsetBased;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$ZoneBased;", "Lkotlinx/datetime/format/UnknownUnicodeDirective;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
    public static abstract class Directive implements UnicodeFormat {
        public /* synthetic */ Directive(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract int getFormatLength();

        public abstract char getFormatLetter();

        private Directive() {
        }

        public String toString() {
            return StringsKt.repeat(String.valueOf(getFormatLetter()), getFormatLength());
        }

        public boolean equals(Object other) {
            return (other instanceof Directive) && getFormatLetter() == ((Directive) other).getFormatLetter() && getFormatLength() == ((Directive) other).getFormatLength();
        }

        public int hashCode() {
            return (getFormatLetter() * 31) + getFormatLength();
        }

        /* compiled from: Unicode.kt */
        @Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0013\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&\u0082\u0001\u0013\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,¨\u0006-"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased;", "Lkotlinx/datetime/format/UnicodeFormat$Directive;", "()V", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "CyclicYearName", "DayOfMonth", "DayOfWeek", "DayOfWeekInMonth", "DayOfYear", "Era", "LocalizedDayOfWeek", "ModifiedJulianDay", "MonthOfYear", "QuarterOfYear", "RelatedGregorianYear", "StandaloneLocalizedDayOfWeek", "StandaloneMonthOfYear", "StandaloneQuarterOfYear", "WeekBasedYear", "WeekOfMonth", "WeekOfWeekBasedYear", "Year", "YearOfEra", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$CyclicYearName;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$DayOfMonth;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$DayOfWeek;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$DayOfWeekInMonth;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$DayOfYear;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$Era;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$LocalizedDayOfWeek;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$ModifiedJulianDay;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$MonthOfYear;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$QuarterOfYear;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$RelatedGregorianYear;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$StandaloneLocalizedDayOfWeek;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$StandaloneMonthOfYear;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$StandaloneQuarterOfYear;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$WeekBasedYear;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$WeekOfMonth;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$WeekOfWeekBasedYear;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$Year;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$YearOfEra;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static abstract class DateBased extends Directive {
            public /* synthetic */ DateBased(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: addToFormat */
            public abstract void mo1485addToFormat(DateTimeFormatBuilder.WithDate withDate);

            private DateBased() {
                super(null);
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$Era;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class Era extends DateBased {
                private final int formatLength;
                private final char formatLetter;

                public Era(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'G';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.DateBased
                /* renamed from: addToFormat */
                public Void mo1485addToFormat(DateTimeFormatBuilder.WithDate builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    UnicodeKt.localizedDirective$default(this, null, 1, null);
                    throw new KotlinNothingValueException();
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$Year;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class Year extends DateBased {
                private final int formatLength;
                private final char formatLetter;

                public Year(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = AbstractJsonLexerKt.UNICODE_ESC;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.DateBased
                /* renamed from: addToFormat */
                public void mo1485addToFormat(DateTimeFormatBuilder.WithDate builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    switch (getFormatLength()) {
                        case 1:
                            builder.year(Padding.NONE);
                            return;
                        case 2:
                            builder.yearTwoDigits(2000);
                            return;
                        case 3:
                            UnicodeKt.unsupportedPadding(this, getFormatLength());
                            throw new KotlinNothingValueException();
                        case 4:
                            builder.year(Padding.ZERO);
                            return;
                        default:
                            UnicodeKt.unsupportedPadding(this, getFormatLength());
                            throw new KotlinNothingValueException();
                    }
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$YearOfEra;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class YearOfEra extends DateBased {
                private final int formatLength;
                private final char formatLetter;

                public YearOfEra(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'y';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.DateBased
                /* renamed from: addToFormat */
                public void mo1485addToFormat(DateTimeFormatBuilder.WithDate builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    switch (getFormatLength()) {
                        case 1:
                            LocalDateFormatKt.yearOfEra(builder, Padding.NONE);
                            return;
                        case 2:
                            LocalDateFormatKt.yearOfEraTwoDigits(builder, 2000);
                            return;
                        case 3:
                            UnicodeKt.unsupportedPadding(this, getFormatLength());
                            throw new KotlinNothingValueException();
                        case 4:
                            LocalDateFormatKt.yearOfEra(builder, Padding.ZERO);
                            return;
                        default:
                            UnicodeKt.unsupportedPadding(this, getFormatLength());
                            throw new KotlinNothingValueException();
                    }
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$CyclicYearName;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class CyclicYearName extends DateBased {
                private final int formatLength;
                private final char formatLetter;

                public CyclicYearName(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'U';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.DateBased
                /* renamed from: addToFormat */
                public Void mo1485addToFormat(DateTimeFormatBuilder.WithDate builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    UnicodeKt.unsupportedDirective$default("cyclic-year", null, 2, null);
                    throw new KotlinNothingValueException();
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$RelatedGregorianYear;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class RelatedGregorianYear extends DateBased {
                private final int formatLength;
                private final char formatLetter;

                public RelatedGregorianYear(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'r';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.DateBased
                /* renamed from: addToFormat */
                public Void mo1485addToFormat(DateTimeFormatBuilder.WithDate builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    UnicodeKt.unsupportedDirective$default("related-gregorian-year", null, 2, null);
                    throw new KotlinNothingValueException();
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$DayOfYear;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class DayOfYear extends DateBased {
                private final int formatLength;
                private final char formatLetter;

                public DayOfYear(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'D';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.DateBased
                /* renamed from: addToFormat */
                public Void mo1485addToFormat(DateTimeFormatBuilder.WithDate builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    UnicodeKt.unsupportedDirective$default("day-of-year", null, 2, null);
                    throw new KotlinNothingValueException();
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$MonthOfYear;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class MonthOfYear extends DateBased {
                private final int formatLength;
                private final char formatLetter;

                public MonthOfYear(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'M';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.DateBased
                /* renamed from: addToFormat */
                public void mo1485addToFormat(DateTimeFormatBuilder.WithDate builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    switch (getFormatLength()) {
                        case 1:
                            builder.monthNumber(Padding.NONE);
                            return;
                        case 2:
                            builder.monthNumber(Padding.ZERO);
                            return;
                        case 3:
                        case 4:
                        case 5:
                            UnicodeKt.localizedDirective$default(this, null, 1, null);
                            throw new KotlinNothingValueException();
                        default:
                            UnicodeKt.unknownLength(this);
                            throw new KotlinNothingValueException();
                    }
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$StandaloneMonthOfYear;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class StandaloneMonthOfYear extends DateBased {
                private final int formatLength;
                private final char formatLetter;

                public StandaloneMonthOfYear(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'L';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.DateBased
                /* renamed from: addToFormat */
                public void mo1485addToFormat(DateTimeFormatBuilder.WithDate builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    switch (getFormatLength()) {
                        case 1:
                            builder.monthNumber(Padding.NONE);
                            return;
                        case 2:
                            builder.monthNumber(Padding.ZERO);
                            return;
                        case 3:
                        case 4:
                        case 5:
                            UnicodeKt.localizedDirective$default(this, null, 1, null);
                            throw new KotlinNothingValueException();
                        default:
                            UnicodeKt.unknownLength(this);
                            throw new KotlinNothingValueException();
                    }
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$DayOfMonth;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class DayOfMonth extends DateBased {
                private final int formatLength;
                private final char formatLetter;

                public DayOfMonth(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'd';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.DateBased
                /* renamed from: addToFormat */
                public void mo1485addToFormat(DateTimeFormatBuilder.WithDate builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    switch (getFormatLength()) {
                        case 1:
                            builder.dayOfMonth(Padding.NONE);
                            return;
                        case 2:
                            builder.dayOfMonth(Padding.ZERO);
                            return;
                        default:
                            UnicodeKt.unknownLength(this);
                            throw new KotlinNothingValueException();
                    }
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$ModifiedJulianDay;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class ModifiedJulianDay extends DateBased {
                private final int formatLength;
                private final char formatLetter;

                public ModifiedJulianDay(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'g';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.DateBased
                /* renamed from: addToFormat */
                public Void mo1485addToFormat(DateTimeFormatBuilder.WithDate builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    UnicodeKt.unsupportedDirective$default("modified-julian-day", null, 2, null);
                    throw new KotlinNothingValueException();
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$QuarterOfYear;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class QuarterOfYear extends DateBased {
                private final int formatLength;
                private final char formatLetter;

                public QuarterOfYear(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'Q';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.DateBased
                /* renamed from: addToFormat */
                public void mo1485addToFormat(DateTimeFormatBuilder.WithDate builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    switch (getFormatLength()) {
                        case 1:
                        case 2:
                            UnicodeKt.unsupportedDirective$default("quarter-of-year", null, 2, null);
                            throw new KotlinNothingValueException();
                        case 3:
                        case 4:
                        case 5:
                            UnicodeKt.localizedDirective$default(this, null, 1, null);
                            throw new KotlinNothingValueException();
                        default:
                            UnicodeKt.unknownLength(this);
                            throw new KotlinNothingValueException();
                    }
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$StandaloneQuarterOfYear;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class StandaloneQuarterOfYear extends DateBased {
                private final int formatLength;
                private final char formatLetter;

                public StandaloneQuarterOfYear(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'q';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.DateBased
                /* renamed from: addToFormat */
                public void mo1485addToFormat(DateTimeFormatBuilder.WithDate builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    switch (getFormatLength()) {
                        case 1:
                        case 2:
                            UnicodeKt.unsupportedDirective$default("standalone-quarter-of-year", null, 2, null);
                            throw new KotlinNothingValueException();
                        case 3:
                        case 4:
                        case 5:
                            UnicodeKt.localizedDirective$default(this, null, 1, null);
                            throw new KotlinNothingValueException();
                        default:
                            UnicodeKt.unknownLength(this);
                            throw new KotlinNothingValueException();
                    }
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$WeekBasedYear;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class WeekBasedYear extends DateBased {
                private final int formatLength;
                private final char formatLetter;

                public WeekBasedYear(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'Y';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.DateBased
                /* renamed from: addToFormat */
                public Void mo1485addToFormat(DateTimeFormatBuilder.WithDate builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    UnicodeKt.unsupportedDirective$default("week-based-year", null, 2, null);
                    throw new KotlinNothingValueException();
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$WeekOfWeekBasedYear;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class WeekOfWeekBasedYear extends DateBased {
                private final int formatLength;
                private final char formatLetter;

                public WeekOfWeekBasedYear(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'w';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.DateBased
                /* renamed from: addToFormat */
                public Void mo1485addToFormat(DateTimeFormatBuilder.WithDate builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    UnicodeKt.unsupportedDirective$default("week-of-week-based-year", null, 2, null);
                    throw new KotlinNothingValueException();
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$WeekOfMonth;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class WeekOfMonth extends DateBased {
                private final int formatLength;
                private final char formatLetter;

                public WeekOfMonth(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'W';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.DateBased
                /* renamed from: addToFormat */
                public Void mo1485addToFormat(DateTimeFormatBuilder.WithDate builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    UnicodeKt.unsupportedDirective$default("week-of-month", null, 2, null);
                    throw new KotlinNothingValueException();
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$DayOfWeek;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class DayOfWeek extends DateBased {
                private final int formatLength;
                private final char formatLetter;

                public DayOfWeek(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'E';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.DateBased
                /* renamed from: addToFormat */
                public Void mo1485addToFormat(DateTimeFormatBuilder.WithDate builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    UnicodeKt.localizedDirective$default(this, null, 1, null);
                    throw new KotlinNothingValueException();
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$LocalizedDayOfWeek;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class LocalizedDayOfWeek extends DateBased {
                private final int formatLength;
                private final char formatLetter;

                public LocalizedDayOfWeek(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'e';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.DateBased
                /* renamed from: addToFormat */
                public Void mo1485addToFormat(DateTimeFormatBuilder.WithDate builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    UnicodeKt.localizedDirective$default(this, null, 1, null);
                    throw new KotlinNothingValueException();
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$StandaloneLocalizedDayOfWeek;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class StandaloneLocalizedDayOfWeek extends DateBased {
                private final int formatLength;
                private final char formatLetter;

                public StandaloneLocalizedDayOfWeek(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'c';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.DateBased
                /* renamed from: addToFormat */
                public Void mo1485addToFormat(DateTimeFormatBuilder.WithDate builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    UnicodeKt.localizedDirective$default(this, null, 1, null);
                    throw new KotlinNothingValueException();
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased$DayOfWeekInMonth;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$DateBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDate;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class DayOfWeekInMonth extends DateBased {
                private final int formatLength;
                private final char formatLetter;

                public DayOfWeekInMonth(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'F';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.DateBased
                /* renamed from: addToFormat */
                public Void mo1485addToFormat(DateTimeFormatBuilder.WithDate builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    UnicodeKt.unsupportedDirective$default("day-of-week-in-month", null, 2, null);
                    throw new KotlinNothingValueException();
                }
            }
        }

        /* compiled from: Unicode.kt */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0007\b\t\n\u000b\fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&\u0082\u0001\u0005\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased;", "Lkotlinx/datetime/format/UnicodeFormat$Directive;", "()V", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithTime;", "AmPmHourOfDay", "AmPmMarker", "HourOfDay", "MinuteOfHour", "WithSecondPrecision", "WithSubsecondPrecision", "Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$AmPmHourOfDay;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$AmPmMarker;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$HourOfDay;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$MinuteOfHour;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$WithSecondPrecision;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static abstract class TimeBased extends Directive {
            public /* synthetic */ TimeBased(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: addToFormat */
            public abstract void mo1487addToFormat(DateTimeFormatBuilder.WithTime withTime);

            private TimeBased() {
                super(null);
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$AmPmMarker;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithTime;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class AmPmMarker extends TimeBased {
                private final int formatLength;
                private final char formatLetter;

                public AmPmMarker(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'a';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.TimeBased
                /* renamed from: addToFormat */
                public Void mo1487addToFormat(DateTimeFormatBuilder.WithTime builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    UnicodeKt.localizedDirective$default(this, null, 1, null);
                    throw new KotlinNothingValueException();
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$AmPmHourOfDay;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithTime;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class AmPmHourOfDay extends TimeBased {
                private final int formatLength;
                private final char formatLetter;

                public AmPmHourOfDay(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'h';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.TimeBased
                /* renamed from: addToFormat */
                public Void mo1487addToFormat(DateTimeFormatBuilder.WithTime builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    UnicodeKt.localizedDirective$default(this, null, 1, null);
                    throw new KotlinNothingValueException();
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$HourOfDay;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithTime;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class HourOfDay extends TimeBased {
                private final int formatLength;
                private final char formatLetter;

                public HourOfDay(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'H';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.TimeBased
                /* renamed from: addToFormat */
                public void mo1487addToFormat(DateTimeFormatBuilder.WithTime builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    switch (getFormatLength()) {
                        case 1:
                            builder.hour(Padding.NONE);
                            return;
                        case 2:
                            builder.hour(Padding.ZERO);
                            return;
                        default:
                            UnicodeKt.unknownLength(this);
                            throw new KotlinNothingValueException();
                    }
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$MinuteOfHour;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithTime;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class MinuteOfHour extends TimeBased {
                private final int formatLength;
                private final char formatLetter;

                public MinuteOfHour(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'm';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.TimeBased
                /* renamed from: addToFormat */
                public void mo1487addToFormat(DateTimeFormatBuilder.WithTime builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    switch (getFormatLength()) {
                        case 1:
                            builder.minute(Padding.NONE);
                            return;
                        case 2:
                            builder.minute(Padding.ZERO);
                            return;
                        default:
                            UnicodeKt.unknownLength(this);
                            throw new KotlinNothingValueException();
                    }
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$WithSecondPrecision;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased;", "()V", "SecondOfMinute", "Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$WithSecondPrecision$SecondOfMinute;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$WithSubsecondPrecision;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static abstract class WithSecondPrecision extends TimeBased {
                public /* synthetic */ WithSecondPrecision(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                /* compiled from: Unicode.kt */
                @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$WithSecondPrecision$SecondOfMinute;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$WithSecondPrecision;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithTime;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
                /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
                public static final class SecondOfMinute extends WithSecondPrecision {
                    private final int formatLength;
                    private final char formatLetter;

                    public SecondOfMinute(int formatLength) {
                        super(null);
                        this.formatLength = formatLength;
                        this.formatLetter = 's';
                    }

                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                    public int getFormatLength() {
                        return this.formatLength;
                    }

                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                    public char getFormatLetter() {
                        return this.formatLetter;
                    }

                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive.TimeBased
                    /* renamed from: addToFormat */
                    public void mo1487addToFormat(DateTimeFormatBuilder.WithTime builder) {
                        Intrinsics.checkNotNullParameter(builder, "builder");
                        switch (getFormatLength()) {
                            case 1:
                                builder.second(Padding.NONE);
                                return;
                            case 2:
                                builder.second(Padding.ZERO);
                                return;
                            default:
                                UnicodeKt.unknownLength(this);
                                throw new KotlinNothingValueException();
                        }
                    }
                }

                private WithSecondPrecision() {
                    super(null);
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$WithSubsecondPrecision;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$WithSecondPrecision;", "()V", "FractionOfSecond", "MilliOfDay", "NanoOfDay", "NanoOfSecond", "Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$WithSubsecondPrecision$FractionOfSecond;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$WithSubsecondPrecision$MilliOfDay;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$WithSubsecondPrecision$NanoOfDay;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$WithSubsecondPrecision$NanoOfSecond;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static abstract class WithSubsecondPrecision extends WithSecondPrecision {
                public /* synthetic */ WithSubsecondPrecision(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                /* compiled from: Unicode.kt */
                @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$WithSubsecondPrecision$FractionOfSecond;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$WithSubsecondPrecision;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithTime;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
                /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
                public static final class FractionOfSecond extends WithSubsecondPrecision {
                    private final int formatLength;
                    private final char formatLetter;

                    public FractionOfSecond(int formatLength) {
                        super(null);
                        this.formatLength = formatLength;
                        this.formatLetter = 'S';
                    }

                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                    public int getFormatLength() {
                        return this.formatLength;
                    }

                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                    public char getFormatLetter() {
                        return this.formatLetter;
                    }

                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive.TimeBased
                    /* renamed from: addToFormat */
                    public void mo1487addToFormat(DateTimeFormatBuilder.WithTime builder) {
                        Intrinsics.checkNotNullParameter(builder, "builder");
                        builder.secondFraction(getFormatLength());
                    }
                }

                private WithSubsecondPrecision() {
                    super(null);
                }

                /* compiled from: Unicode.kt */
                @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$WithSubsecondPrecision$MilliOfDay;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$WithSubsecondPrecision;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithTime;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
                /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
                public static final class MilliOfDay extends WithSubsecondPrecision {
                    private final int formatLength;
                    private final char formatLetter;

                    public MilliOfDay(int formatLength) {
                        super(null);
                        this.formatLength = formatLength;
                        this.formatLetter = 'A';
                    }

                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                    public int getFormatLength() {
                        return this.formatLength;
                    }

                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                    public char getFormatLetter() {
                        return this.formatLetter;
                    }

                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive.TimeBased
                    /* renamed from: addToFormat */
                    public Void mo1487addToFormat(DateTimeFormatBuilder.WithTime builder) {
                        Intrinsics.checkNotNullParameter(builder, "builder");
                        UnicodeKt.unsupportedDirective$default("millisecond-of-day", null, 2, null);
                        throw new KotlinNothingValueException();
                    }
                }

                /* compiled from: Unicode.kt */
                @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$WithSubsecondPrecision$NanoOfSecond;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$WithSubsecondPrecision;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithTime;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
                /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
                public static final class NanoOfSecond extends WithSubsecondPrecision {
                    private final int formatLength;
                    private final char formatLetter;

                    public NanoOfSecond(int formatLength) {
                        super(null);
                        this.formatLength = formatLength;
                        this.formatLetter = 'n';
                    }

                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                    public int getFormatLength() {
                        return this.formatLength;
                    }

                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                    public char getFormatLetter() {
                        return this.formatLetter;
                    }

                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive.TimeBased
                    /* renamed from: addToFormat */
                    public Void mo1487addToFormat(DateTimeFormatBuilder.WithTime builder) {
                        Intrinsics.checkNotNullParameter(builder, "builder");
                        UnicodeKt.unsupportedDirective("nano-of-second", "Maybe you meant 'S' instead of 'n'?");
                        throw new KotlinNothingValueException();
                    }
                }

                /* compiled from: Unicode.kt */
                @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$WithSubsecondPrecision$NanoOfDay;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$TimeBased$WithSubsecondPrecision;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithTime;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
                /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
                public static final class NanoOfDay extends WithSubsecondPrecision {
                    private final int formatLength;
                    private final char formatLetter;

                    public NanoOfDay(int formatLength) {
                        super(null);
                        this.formatLength = formatLength;
                        this.formatLetter = 'N';
                    }

                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                    public int getFormatLength() {
                        return this.formatLength;
                    }

                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                    public char getFormatLetter() {
                        return this.formatLetter;
                    }

                    @Override // kotlinx.datetime.format.UnicodeFormat.Directive.TimeBased
                    /* renamed from: addToFormat */
                    public Void mo1487addToFormat(DateTimeFormatBuilder.WithTime builder) {
                        Intrinsics.checkNotNullParameter(builder, "builder");
                        UnicodeKt.unsupportedDirective$default("nanosecond-of-day", null, 2, null);
                        throw new KotlinNothingValueException();
                    }
                }
            }
        }

        /* compiled from: Unicode.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&\u0082\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$ZoneBased;", "Lkotlinx/datetime/format/UnicodeFormat$Directive;", "()V", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTimeComponents;", "GenericTimeZoneName", "TimeZoneId", "TimeZoneName", "Lkotlinx/datetime/format/UnicodeFormat$Directive$ZoneBased$GenericTimeZoneName;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$ZoneBased$TimeZoneId;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$ZoneBased$TimeZoneName;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static abstract class ZoneBased extends Directive {
            public /* synthetic */ ZoneBased(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: addToFormat */
            public abstract void mo1488addToFormat(DateTimeFormatBuilder.WithDateTimeComponents withDateTimeComponents);

            private ZoneBased() {
                super(null);
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$ZoneBased$TimeZoneId;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$ZoneBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTimeComponents;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class TimeZoneId extends ZoneBased {
                private final int formatLength;
                private final char formatLetter;

                public TimeZoneId(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'V';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.ZoneBased
                /* renamed from: addToFormat */
                public void mo1488addToFormat(DateTimeFormatBuilder.WithDateTimeComponents builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    if (getFormatLength() != 2) {
                        UnicodeKt.unknownLength(this);
                        throw new KotlinNothingValueException();
                    } else {
                        builder.timeZoneId();
                    }
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$ZoneBased$GenericTimeZoneName;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$ZoneBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTimeComponents;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class GenericTimeZoneName extends ZoneBased {
                private final int formatLength;
                private final char formatLetter;

                public GenericTimeZoneName(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'v';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.ZoneBased
                /* renamed from: addToFormat */
                public Void mo1488addToFormat(DateTimeFormatBuilder.WithDateTimeComponents builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    UnicodeKt.localizedDirective$default(this, null, 1, null);
                    throw new KotlinNothingValueException();
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$ZoneBased$TimeZoneName;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$ZoneBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithDateTimeComponents;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class TimeZoneName extends ZoneBased {
                private final int formatLength;
                private final char formatLetter;

                public TimeZoneName(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'z';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.ZoneBased
                /* renamed from: addToFormat */
                public Void mo1488addToFormat(DateTimeFormatBuilder.WithDateTimeComponents builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    UnicodeKt.localizedDirective(this, "Format 'V' can be used to format time zone IDs in a locale-invariant manner.");
                    throw new KotlinNothingValueException();
                }
            }
        }

        /* compiled from: Unicode.kt */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u000e\u000f\u0010\u0011B\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\u001a\u0010\n\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f\u0082\u0001\u0004\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$OffsetBased;", "Lkotlinx/datetime/format/UnicodeFormat$Directive;", "()V", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithUtcOffset;", "outputMinutes", "Lkotlinx/datetime/format/WhenToOutput;", "outputSeconds", "offset", "zOnZero", "", "useSeparator", "LocalizedZoneOffset", "ZoneOffset1", "ZoneOffset2", "ZoneOffset3", "Lkotlinx/datetime/format/UnicodeFormat$Directive$OffsetBased$LocalizedZoneOffset;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$OffsetBased$ZoneOffset1;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$OffsetBased$ZoneOffset2;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$OffsetBased$ZoneOffset3;", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
        /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
        public static abstract class OffsetBased extends Directive {
            public /* synthetic */ OffsetBased(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* renamed from: addToFormat */
            public abstract void mo1486addToFormat(DateTimeFormatBuilder.WithUtcOffset withUtcOffset);

            public abstract WhenToOutput outputMinutes();

            public abstract WhenToOutput outputSeconds();

            private OffsetBased() {
                super(null);
            }

            public final void offset(DateTimeFormatBuilder.WithUtcOffset $this$offset, boolean zOnZero, boolean useSeparator) {
                Intrinsics.checkNotNullParameter($this$offset, "<this>");
                UtcOffsetFormatKt.isoOffset($this$offset, zOnZero, useSeparator, outputMinutes(), outputSeconds());
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$OffsetBased$LocalizedZoneOffset;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$OffsetBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithUtcOffset;", "outputMinutes", "Lkotlinx/datetime/format/WhenToOutput;", "outputSeconds", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class LocalizedZoneOffset extends OffsetBased {
                private final int formatLength;
                private final char formatLetter;

                public LocalizedZoneOffset(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'O';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.OffsetBased
                /* renamed from: addToFormat */
                public Void mo1486addToFormat(DateTimeFormatBuilder.WithUtcOffset builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    UnicodeKt.localizedDirective$default(this, null, 1, null);
                    throw new KotlinNothingValueException();
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.OffsetBased
                public WhenToOutput outputMinutes() {
                    UnicodeKt.localizedDirective$default(this, null, 1, null);
                    throw new KotlinNothingValueException();
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.OffsetBased
                public WhenToOutput outputSeconds() {
                    UnicodeKt.localizedDirective$default(this, null, 1, null);
                    throw new KotlinNothingValueException();
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$OffsetBased$ZoneOffset1;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$OffsetBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithUtcOffset;", "outputMinutes", "Lkotlinx/datetime/format/WhenToOutput;", "outputSeconds", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class ZoneOffset1 extends OffsetBased {
                private final int formatLength;
                private final char formatLetter;

                public ZoneOffset1(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'X';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.OffsetBased
                /* renamed from: addToFormat */
                public void mo1486addToFormat(DateTimeFormatBuilder.WithUtcOffset builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    switch (getFormatLength()) {
                        case 1:
                            offset(builder, true, false);
                            return;
                        case 2:
                            offset(builder, true, false);
                            return;
                        case 3:
                            offset(builder, true, true);
                            return;
                        case 4:
                            offset(builder, true, false);
                            return;
                        case 5:
                            offset(builder, true, true);
                            return;
                        default:
                            UnicodeKt.unknownLength(this);
                            throw new KotlinNothingValueException();
                    }
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.OffsetBased
                public WhenToOutput outputMinutes() {
                    return getFormatLength() == 1 ? WhenToOutput.IF_NONZERO : WhenToOutput.ALWAYS;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.OffsetBased
                public WhenToOutput outputSeconds() {
                    return getFormatLength() <= 3 ? WhenToOutput.NEVER : WhenToOutput.IF_NONZERO;
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$OffsetBased$ZoneOffset2;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$OffsetBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithUtcOffset;", "outputMinutes", "Lkotlinx/datetime/format/WhenToOutput;", "outputSeconds", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class ZoneOffset2 extends OffsetBased {
                private final int formatLength;
                private final char formatLetter;

                public ZoneOffset2(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'x';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.OffsetBased
                /* renamed from: addToFormat */
                public void mo1486addToFormat(DateTimeFormatBuilder.WithUtcOffset builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    switch (getFormatLength()) {
                        case 1:
                            offset(builder, false, false);
                            return;
                        case 2:
                            offset(builder, false, false);
                            return;
                        case 3:
                            offset(builder, false, true);
                            return;
                        case 4:
                            offset(builder, false, false);
                            return;
                        case 5:
                            offset(builder, false, true);
                            return;
                        default:
                            UnicodeKt.unknownLength(this);
                            throw new KotlinNothingValueException();
                    }
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.OffsetBased
                public WhenToOutput outputMinutes() {
                    return getFormatLength() == 1 ? WhenToOutput.IF_NONZERO : WhenToOutput.ALWAYS;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.OffsetBased
                public WhenToOutput outputSeconds() {
                    return getFormatLength() <= 3 ? WhenToOutput.NEVER : WhenToOutput.IF_NONZERO;
                }
            }

            /* compiled from: Unicode.kt */
            @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lkotlinx/datetime/format/UnicodeFormat$Directive$OffsetBased$ZoneOffset3;", "Lkotlinx/datetime/format/UnicodeFormat$Directive$OffsetBased;", "formatLength", "", "(I)V", "getFormatLength", "()I", "formatLetter", "", "getFormatLetter", "()C", "addToFormat", "", "builder", "Lkotlinx/datetime/format/DateTimeFormatBuilder$WithUtcOffset;", "outputMinutes", "Lkotlinx/datetime/format/WhenToOutput;", "outputSeconds", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
            /* loaded from: /data/np/file-convert/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce/202602280715434a3b7a31-7f03-42ef-8e70-679c858cd1ce.dex */
            public static final class ZoneOffset3 extends OffsetBased {
                private final int formatLength;
                private final char formatLetter;

                public ZoneOffset3(int formatLength) {
                    super(null);
                    this.formatLength = formatLength;
                    this.formatLetter = 'Z';
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public int getFormatLength() {
                    return this.formatLength;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive
                public char getFormatLetter() {
                    return this.formatLetter;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.OffsetBased
                /* renamed from: addToFormat */
                public void mo1486addToFormat(DateTimeFormatBuilder.WithUtcOffset builder) {
                    Intrinsics.checkNotNullParameter(builder, "builder");
                    switch (getFormatLength()) {
                        case 1:
                        case 2:
                        case 3:
                            offset(builder, false, false);
                            return;
                        case 4:
                            new LocalizedZoneOffset(4).mo1486addToFormat(builder);
                            throw new KotlinNothingValueException();
                        case 5:
                            offset(builder, false, true);
                            return;
                        default:
                            UnicodeKt.unknownLength(this);
                            throw new KotlinNothingValueException();
                    }
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.OffsetBased
                public WhenToOutput outputMinutes() {
                    return WhenToOutput.ALWAYS;
                }

                @Override // kotlinx.datetime.format.UnicodeFormat.Directive.OffsetBased
                public WhenToOutput outputSeconds() {
                    return getFormatLength() <= 3 ? WhenToOutput.NEVER : WhenToOutput.IF_NONZERO;
                }
            }
        }
    }
}