package io.ktor.util.date;

import com.bilibili.studio.editor.moudle.intelligence.media.AlbumIntelligenceConstants;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GMTDateParser.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000f\u001a\u00020\u000e*\u00020\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011¨\u0006\u0013"}, d2 = {"Lio/ktor/util/date/GMTDateParser;", "", "", "pattern", "<init>", "(Ljava/lang/String;)V", "dateString", "Lio/ktor/util/date/GMTDate;", "parse", "(Ljava/lang/String;)Lio/ktor/util/date/GMTDate;", "Lio/ktor/util/date/GMTDateBuilder;", "", LynxError.LYNX_ERROR_KEY_RESOURCE_TYPE, "chunk", "", "handleToken", "(Lio/ktor/util/date/GMTDateBuilder;CLjava/lang/String;)V", "Ljava/lang/String;", "Companion", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GMTDateParser {
    public static final char ANY = '*';
    public static final Companion Companion = new Companion(null);
    public static final char DAY_OF_MONTH = 'd';
    public static final char HOURS = 'h';
    public static final char MINUTES = 'm';
    public static final char MONTH = 'M';
    public static final char SECONDS = 's';
    public static final char YEAR = 'Y';
    public static final char ZONE = 'z';
    private final String pattern;

    public GMTDateParser(String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        this.pattern = pattern;
        if (!(this.pattern.length() > 0)) {
            throw new IllegalStateException("Date parser pattern shouldn't be empty.".toString());
        }
    }

    public final GMTDate parse(String dateString) {
        Intrinsics.checkNotNullParameter(dateString, "dateString");
        GMTDateBuilder builder = new GMTDateBuilder();
        int start = 0;
        char current = this.pattern.charAt(0);
        int chunkStart = 0;
        int index = 1;
        while (index < this.pattern.length()) {
            try {
                if (this.pattern.charAt(index) == current) {
                    index++;
                } else {
                    int chunkEnd = (chunkStart + index) - start;
                    String substring = dateString.substring(chunkStart, chunkEnd);
                    Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
                    handleToken(builder, current, substring);
                    chunkStart = chunkEnd;
                    start = index;
                    current = this.pattern.charAt(index);
                    index++;
                }
            } catch (Throwable th) {
                throw new InvalidDateStringException(dateString, chunkStart, this.pattern);
            }
        }
        if (chunkStart < dateString.length()) {
            String substring2 = dateString.substring(chunkStart);
            Intrinsics.checkNotNullExpressionValue(substring2, "substring(...)");
            handleToken(builder, current, substring2);
        }
        return builder.build();
    }

    private final void handleToken(GMTDateBuilder $this$handleToken, char type, String chunk) {
        switch (type) {
            case '*':
                return;
            case 'M':
                $this$handleToken.setMonth(Month.Companion.from(chunk));
                return;
            case 'Y':
                $this$handleToken.setYear(Integer.valueOf(Integer.parseInt(chunk)));
                return;
            case 'd':
                $this$handleToken.setDayOfMonth(Integer.valueOf(Integer.parseInt(chunk)));
                return;
            case 'h':
                $this$handleToken.setHours(Integer.valueOf(Integer.parseInt(chunk)));
                return;
            case 'm':
                $this$handleToken.setMinutes(Integer.valueOf(Integer.parseInt(chunk)));
                return;
            case 's':
                $this$handleToken.setSeconds(Integer.valueOf(Integer.parseInt(chunk)));
                return;
            case 'z':
                if (!Intrinsics.areEqual(chunk, "GMT")) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                return;
            default:
                String $this$all$iv = chunk;
                boolean z = false;
                int i = 0;
                while (true) {
                    if (i < $this$all$iv.length()) {
                        char element$iv = $this$all$iv.charAt(i);
                        if (element$iv == type) {
                            i++;
                        }
                    } else {
                        z = true;
                    }
                }
                if (!z) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                return;
        }
    }

    /* compiled from: GMTDateParser.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0006¨\u0006\u000e"}, d2 = {"Lio/ktor/util/date/GMTDateParser$Companion;", "", "<init>", "()V", "", "SECONDS", AlbumIntelligenceConstants.GRAY_C, "MINUTES", "HOURS", "DAY_OF_MONTH", "MONTH", "YEAR", "ZONE", "ANY", "ktor-utils"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* loaded from: /data/np/file-convert/202602230614216d888f0a-efdb-42c6-942f-a4b7baea1519/202602230614216d888f0a-efdb-42c6-942f-a4b7baea1519.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}