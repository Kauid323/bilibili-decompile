package leakcanary.internal.activity.screen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.CharsKt;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

/* compiled from: LeakTraceWrapper.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ(\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\u000e2\u0006\u0010\u000f\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lleakcanary/internal/activity/screen/LeakTraceWrapper;", "", "()V", "PERIOD", "", "SPACE", "TILDE", "ZERO_SPACE_WIDTH", "wrap", "", "sourceMultilineString", "maxWidth", "", "wrapLine", "", "currentLine", "nextLineWithUnderline", "leakcanary-android-core_release"}, k = 1, mv = {1, 4, 1})
public final class LeakTraceWrapper {
    public static final LeakTraceWrapper INSTANCE = new LeakTraceWrapper();
    private static final char PERIOD = '.';
    private static final char SPACE = ' ';
    private static final char TILDE = '~';
    private static final char ZERO_SPACE_WIDTH = 8203;

    private LeakTraceWrapper() {
    }

    public final String wrap(String sourceMultilineString, int maxWidth) {
        Intrinsics.checkParameterIsNotNull(sourceMultilineString, "sourceMultilineString");
        List linesNotWrapped = StringsKt.lines(sourceMultilineString);
        List linesWrapped = new ArrayList();
        int size = linesNotWrapped.size();
        int currentLineIndex = 0;
        while (currentLineIndex < size) {
            String currentLine = linesNotWrapped.get(currentLineIndex);
            String str = null;
            if (StringsKt.contains$default((CharSequence) currentLine, (char) TILDE, false, 2, (Object) null)) {
                if (!(currentLineIndex > 0)) {
                    throw new IllegalStateException("A ~ character cannot be placed on the first line of a leak trace".toString());
                }
            } else {
                if (currentLineIndex < CollectionsKt.getLastIndex(linesNotWrapped)) {
                    String $this$run = linesNotWrapped.get(currentLineIndex + 1);
                    if (StringsKt.contains$default((CharSequence) $this$run, (char) TILDE, false, 2, (Object) null)) {
                        str = $this$run;
                    }
                }
                String nextLineWithUnderline = str;
                if (currentLine == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                String currentLineTrimmed = StringsKt.trimEnd((CharSequence) currentLine).toString();
                if (currentLineTrimmed.length() <= maxWidth) {
                    linesWrapped.add(currentLineTrimmed);
                    if (nextLineWithUnderline != null) {
                        linesWrapped.add(nextLineWithUnderline);
                    }
                } else {
                    CollectionsKt.addAll(linesWrapped, wrapLine(currentLineTrimmed, nextLineWithUnderline, maxWidth));
                }
            }
            currentLineIndex++;
        }
        return CollectionsKt.joinToString$default(linesWrapped, IOUtils.LINE_SEPARATOR_UNIX, null, null, 0, null, new Function1<String, CharSequence>() { // from class: leakcanary.internal.activity.screen.LeakTraceWrapper$wrap$2
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(String it) {
                Intrinsics.checkParameterIsNotNull(it, "it");
                return StringsKt.trimEnd((CharSequence) it).toString();
            }
        }, 30, null);
    }

    private final List<String> wrapLine(String currentLine, String nextLineWithUnderline, int maxWidth) {
        String prefixFirstLine;
        String prefixPastFirstLine;
        int underlineStart;
        int updatedUnderlineStart;
        String prefixPastFirstLine2;
        String prefixFirstLine2;
        boolean z;
        int underlinedLineIndex;
        String str;
        boolean z2 = false;
        Map twoCharPrefixes = MapsKt.mapOf(TuplesKt.to("├─", "│ "), TuplesKt.to("│ ", "│ "), TuplesKt.to("╰→", "\u200b "), TuplesKt.to("\u200b ", "\u200b "));
        if (currentLine != null) {
            String twoCharPrefix = currentLine.substring(0, 2);
            Intrinsics.checkNotNullExpressionValue(twoCharPrefix, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            if (!twoCharPrefixes.containsKey(twoCharPrefix)) {
                prefixFirstLine = "";
                prefixPastFirstLine = "";
            } else if (currentLine == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            } else {
                CharSequence substring = currentLine.substring(2);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                CharSequence $this$indexOfFirst$iv = substring;
                int length = $this$indexOfFirst$iv.length();
                int index$iv = 0;
                while (true) {
                    if (index$iv >= length) {
                        index$iv = -1;
                        break;
                    } else if (!CharsKt.isWhitespace($this$indexOfFirst$iv.charAt(index$iv))) {
                        break;
                    } else {
                        index$iv++;
                    }
                }
                int indexOfFirstNonWhitespace = index$iv + 2;
                if (currentLine == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String substring2 = currentLine.substring(0, indexOfFirstNonWhitespace);
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                prefixFirstLine = substring2;
                String str2 = (String) twoCharPrefixes.get(twoCharPrefix);
                if (currentLine == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String substring3 = currentLine.substring(2, indexOfFirstNonWhitespace);
                Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                prefixPastFirstLine = Intrinsics.stringPlus(str2, substring3);
            }
            int length2 = prefixFirstLine.length();
            if (currentLine != null) {
                String lineRemainingChars = currentLine.substring(length2);
                Intrinsics.checkNotNullExpressionValue(lineRemainingChars, "(this as java.lang.String).substring(startIndex)");
                int maxWidthWithoutOffset = maxWidth - prefixFirstLine.length();
                List lineWrapped = new ArrayList();
                int periodsFound = 0;
                if (nextLineWithUnderline != null) {
                    underlineStart = StringsKt.indexOf$default((CharSequence) nextLineWithUnderline, (char) TILDE, 0, false, 6, (Object) null);
                    updatedUnderlineStart = underlineStart - prefixFirstLine.length();
                } else {
                    underlineStart = -1;
                    updatedUnderlineStart = -1;
                }
                int underlinedLineIndex2 = -1;
                while (true) {
                    if (!(lineRemainingChars.length() > 0 ? true : z2)) {
                        prefixPastFirstLine2 = prefixPastFirstLine;
                        prefixFirstLine2 = prefixFirstLine;
                        z = z2;
                        break;
                    } else if (lineRemainingChars.length() <= maxWidthWithoutOffset) {
                        prefixPastFirstLine2 = prefixPastFirstLine;
                        prefixFirstLine2 = prefixFirstLine;
                        z = false;
                        break;
                    } else if (lineRemainingChars == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    } else {
                        String stringBeforeLimit = lineRemainingChars.substring(0, maxWidthWithoutOffset);
                        Intrinsics.checkNotNullExpressionValue(stringBeforeLimit, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        int lastIndexOfSpace = StringsKt.lastIndexOf$default((CharSequence) stringBeforeLimit, (char) SPACE, 0, false, 6, (Object) null);
                        Map twoCharPrefixes2 = twoCharPrefixes;
                        int lastIndexOfPeriod = StringsKt.lastIndexOf$default((CharSequence) stringBeforeLimit, '.', 0, false, 6, (Object) null);
                        String twoCharPrefix2 = twoCharPrefix;
                        int it = RangesKt.coerceAtLeast(lastIndexOfSpace, lastIndexOfPeriod);
                        if (it == -1) {
                            it = StringsKt.getLastIndex(stringBeforeLimit);
                        }
                        int lastIndexOfCurrentLine = it;
                        if (lastIndexOfCurrentLine == lastIndexOfPeriod) {
                            periodsFound++;
                        }
                        int wrapIndex = lastIndexOfCurrentLine + 1;
                        List list = lineWrapped;
                        if (stringBeforeLimit == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        String prefixPastFirstLine3 = prefixPastFirstLine;
                        String prefixFirstLine3 = prefixFirstLine;
                        String prefixFirstLine4 = stringBeforeLimit.substring(0, wrapIndex);
                        Intrinsics.checkNotNullExpressionValue(prefixFirstLine4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        if (prefixFirstLine4 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        list.add(StringsKt.trimEnd((CharSequence) prefixFirstLine4).toString());
                        if (nextLineWithUnderline != null && underlinedLineIndex2 == -1) {
                            if (lastIndexOfCurrentLine < updatedUnderlineStart) {
                                updatedUnderlineStart -= wrapIndex;
                            } else {
                                underlinedLineIndex2 = CollectionsKt.getLastIndex(lineWrapped);
                            }
                        }
                        int length3 = lineRemainingChars.length();
                        if (lineRemainingChars == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        String substring4 = lineRemainingChars.substring(wrapIndex, length3);
                        Intrinsics.checkNotNullExpressionValue(substring4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        lineRemainingChars = substring4;
                        z2 = false;
                        prefixFirstLine = prefixFirstLine3;
                        twoCharPrefix = twoCharPrefix2;
                        prefixPastFirstLine = prefixPastFirstLine3;
                        twoCharPrefixes = twoCharPrefixes2;
                    }
                }
                if (lineRemainingChars.length() > 0 ? true : z) {
                    lineWrapped.add(lineRemainingChars);
                }
                if (nextLineWithUnderline != null) {
                    if (underlinedLineIndex2 == -1) {
                        underlinedLineIndex2 = CollectionsKt.getLastIndex(lineWrapped);
                    }
                    int underlineEnd = StringsKt.lastIndexOf$default((CharSequence) nextLineWithUnderline, (char) TILDE, 0, false, 6, (Object) null);
                    int underlineLength = (underlineEnd - underlineStart) + 1;
                    String spacesBeforeTilde = StringsKt.repeat(" ", updatedUnderlineStart);
                    String underlineTildes = StringsKt.repeat("~", underlineLength);
                    lineWrapped.add(underlinedLineIndex2 + 1, spacesBeforeTilde + underlineTildes);
                }
                List $this$mapIndexed$iv = lineWrapped;
                int $i$f$mapIndexed = 0;
                Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
                int index$iv$iv = 0;
                for (Object item$iv$iv : $this$mapIndexed$iv) {
                    int index$iv$iv2 = index$iv$iv + 1;
                    if (index$iv$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    Iterable $this$mapIndexed$iv2 = $this$mapIndexed$iv;
                    String line = (String) item$iv$iv;
                    int $i$f$mapIndexed2 = $i$f$mapIndexed;
                    StringBuilder sb = new StringBuilder();
                    if (index$iv$iv == 0) {
                        underlinedLineIndex = underlinedLineIndex2;
                        str = prefixFirstLine2;
                    } else {
                        underlinedLineIndex = underlinedLineIndex2;
                        str = prefixPastFirstLine2;
                    }
                    String sb2 = sb.append(str).append(line).toString();
                    if (sb2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    String line2 = StringsKt.trimEnd((CharSequence) sb2).toString();
                    destination$iv$iv.add(line2);
                    index$iv$iv = index$iv$iv2;
                    $this$mapIndexed$iv = $this$mapIndexed$iv2;
                    $i$f$mapIndexed = $i$f$mapIndexed2;
                    underlinedLineIndex2 = underlinedLineIndex;
                }
                return (List) destination$iv$iv;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}