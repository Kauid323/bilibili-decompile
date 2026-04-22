package j$.time.zone;

import j$.time.Clock;
import j$.time.DesugarLocalDate$$ExternalSyntheticBackport0;
import j$.time.Duration;
import j$.time.Duration$DurationUnits$$ExternalSyntheticBackport0;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentMap;

public final class ZoneRules implements Serializable {
    private static final int LAST_CACHED_YEAR = 2100;
    private static final long serialVersionUID = 3044319355680032515L;
    private final ZoneOffsetTransitionRule[] lastRules;
    private final transient ConcurrentMap<Integer, ZoneOffsetTransition[]> lastRulesCache;
    private final long[] savingsInstantTransitions;
    private final LocalDateTime[] savingsLocalTransitions;
    private final ZoneOffset[] standardOffsets;
    private final long[] standardTransitions;
    private final TimeZone timeZone;
    private final ZoneOffset[] wallOffsets;
    private static final long[] EMPTY_LONG_ARRAY = new long[0];
    private static final ZoneOffsetTransitionRule[] EMPTY_LASTRULES = new ZoneOffsetTransitionRule[0];
    private static final LocalDateTime[] EMPTY_LDT_ARRAY = new LocalDateTime[0];
    private static final ZoneOffsetTransition[] NO_TRANSITIONS = new ZoneOffsetTransition[0];

    public static ZoneRules of(ZoneOffset baseStandardOffset, ZoneOffset baseWallOffset, List<ZoneOffsetTransition> list, List<ZoneOffsetTransition> list2, List<ZoneOffsetTransitionRule> list3) {
        Objects.requireNonNull(baseStandardOffset, "baseStandardOffset");
        Objects.requireNonNull(baseWallOffset, "baseWallOffset");
        Objects.requireNonNull(list, "standardOffsetTransitionList");
        Objects.requireNonNull(list2, "transitionList");
        Objects.requireNonNull(list3, "lastRules");
        return new ZoneRules(baseStandardOffset, baseWallOffset, list, list2, list3);
    }

    public static ZoneRules of(ZoneOffset offset) {
        Objects.requireNonNull(offset, "offset");
        return new ZoneRules(offset);
    }

    ZoneRules(ZoneOffset baseStandardOffset, ZoneOffset baseWallOffset, List<ZoneOffsetTransition> list, List<ZoneOffsetTransition> list2, List<ZoneOffsetTransitionRule> list3) {
        this.lastRulesCache = new ConcurrentHashMap();
        this.standardTransitions = new long[list.size()];
        this.standardOffsets = new ZoneOffset[list.size() + 1];
        this.standardOffsets[0] = baseStandardOffset;
        for (int i = 0; i < list.size(); i++) {
            this.standardTransitions[i] = list.get(i).toEpochSecond();
            this.standardOffsets[i + 1] = list.get(i).getOffsetAfter();
        }
        List<java.time.LocalDateTime> localTransitionList = new ArrayList<>();
        List<java.time.ZoneOffset> localTransitionOffsetList = new ArrayList<>();
        localTransitionOffsetList.add(baseWallOffset);
        for (ZoneOffsetTransition trans : list2) {
            if (trans.isGap()) {
                localTransitionList.add(trans.getDateTimeBefore());
                localTransitionList.add(trans.getDateTimeAfter());
            } else {
                localTransitionList.add(trans.getDateTimeAfter());
                localTransitionList.add(trans.getDateTimeBefore());
            }
            localTransitionOffsetList.add(trans.getOffsetAfter());
        }
        this.savingsLocalTransitions = (LocalDateTime[]) localTransitionList.toArray(new LocalDateTime[localTransitionList.size()]);
        this.wallOffsets = (ZoneOffset[]) localTransitionOffsetList.toArray(new ZoneOffset[localTransitionOffsetList.size()]);
        this.savingsInstantTransitions = new long[list2.size()];
        for (int i2 = 0; i2 < list2.size(); i2++) {
            this.savingsInstantTransitions[i2] = list2.get(i2).toEpochSecond();
        }
        int i3 = list3.size();
        if (i3 > 16) {
            throw new IllegalArgumentException("Too many transition rules");
        }
        this.lastRules = (ZoneOffsetTransitionRule[]) list3.toArray(new ZoneOffsetTransitionRule[list3.size()]);
        this.timeZone = null;
    }

    private ZoneRules(long[] standardTransitions, ZoneOffset[] standardOffsets, long[] savingsInstantTransitions, ZoneOffset[] wallOffsets, ZoneOffsetTransitionRule[] lastRules) {
        this.lastRulesCache = new ConcurrentHashMap();
        this.standardTransitions = standardTransitions;
        this.standardOffsets = standardOffsets;
        this.savingsInstantTransitions = savingsInstantTransitions;
        this.wallOffsets = wallOffsets;
        this.lastRules = lastRules;
        if (savingsInstantTransitions.length == 0) {
            this.savingsLocalTransitions = EMPTY_LDT_ARRAY;
        } else {
            List<java.time.LocalDateTime> localTransitionList = new ArrayList<>();
            for (int i = 0; i < savingsInstantTransitions.length; i++) {
                ZoneOffset before = wallOffsets[i];
                ZoneOffset after = wallOffsets[i + 1];
                ZoneOffsetTransition trans = new ZoneOffsetTransition(savingsInstantTransitions[i], before, after);
                if (trans.isGap()) {
                    localTransitionList.add(trans.getDateTimeBefore());
                    localTransitionList.add(trans.getDateTimeAfter());
                } else {
                    localTransitionList.add(trans.getDateTimeAfter());
                    localTransitionList.add(trans.getDateTimeBefore());
                }
            }
            int i2 = localTransitionList.size();
            this.savingsLocalTransitions = (LocalDateTime[]) localTransitionList.toArray(new LocalDateTime[i2]);
        }
        this.timeZone = null;
    }

    private ZoneRules(ZoneOffset offset) {
        this.lastRulesCache = new ConcurrentHashMap();
        this.standardOffsets = new ZoneOffset[1];
        this.standardOffsets[0] = offset;
        this.standardTransitions = EMPTY_LONG_ARRAY;
        this.savingsInstantTransitions = EMPTY_LONG_ARRAY;
        this.savingsLocalTransitions = EMPTY_LDT_ARRAY;
        this.wallOffsets = this.standardOffsets;
        this.lastRules = EMPTY_LASTRULES;
        this.timeZone = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZoneRules(TimeZone tz) {
        this.lastRulesCache = new ConcurrentHashMap();
        this.standardOffsets = new ZoneOffset[1];
        this.standardOffsets[0] = offsetFromMillis(tz.getRawOffset());
        this.standardTransitions = EMPTY_LONG_ARRAY;
        this.savingsInstantTransitions = EMPTY_LONG_ARRAY;
        this.savingsLocalTransitions = EMPTY_LDT_ARRAY;
        this.wallOffsets = this.standardOffsets;
        this.lastRules = EMPTY_LASTRULES;
        this.timeZone = tz;
    }

    private static ZoneOffset offsetFromMillis(int offsetMillis) {
        return ZoneOffset.ofTotalSeconds(offsetMillis / 1000);
    }

    private void readObject(ObjectInputStream s) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser(this.timeZone != null ? (byte) 100 : (byte) 1, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternal(DataOutput out) {
        long[] jArr;
        ZoneOffset[] zoneOffsetArr;
        long[] jArr2;
        ZoneOffset[] zoneOffsetArr2;
        ZoneOffsetTransitionRule[] zoneOffsetTransitionRuleArr;
        out.writeInt(this.standardTransitions.length);
        for (long trans : this.standardTransitions) {
            Ser.writeEpochSec(trans, out);
        }
        for (ZoneOffset offset : this.standardOffsets) {
            Ser.writeOffset(offset, out);
        }
        out.writeInt(this.savingsInstantTransitions.length);
        for (long trans2 : this.savingsInstantTransitions) {
            Ser.writeEpochSec(trans2, out);
        }
        for (ZoneOffset offset2 : this.wallOffsets) {
            Ser.writeOffset(offset2, out);
        }
        out.writeByte(this.lastRules.length);
        for (ZoneOffsetTransitionRule rule : this.lastRules) {
            rule.writeExternal(out);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeExternalTimeZone(DataOutput out) {
        out.writeUTF(this.timeZone.getID());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneRules readExternal(DataInput in) {
        int stdSize = in.readInt();
        long[] stdTrans = stdSize == 0 ? EMPTY_LONG_ARRAY : new long[stdSize];
        for (int i = 0; i < stdSize; i++) {
            stdTrans[i] = Ser.readEpochSec(in);
        }
        int i2 = stdSize + 1;
        ZoneOffset[] stdOffsets = new ZoneOffset[i2];
        for (int i3 = 0; i3 < stdOffsets.length; i3++) {
            stdOffsets[i3] = Ser.readOffset(in);
        }
        int savSize = in.readInt();
        long[] savTrans = savSize == 0 ? EMPTY_LONG_ARRAY : new long[savSize];
        for (int i4 = 0; i4 < savSize; i4++) {
            savTrans[i4] = Ser.readEpochSec(in);
        }
        int i5 = savSize + 1;
        ZoneOffset[] savOffsets = new ZoneOffset[i5];
        for (int i6 = 0; i6 < savOffsets.length; i6++) {
            savOffsets[i6] = Ser.readOffset(in);
        }
        int ruleSize = in.readByte();
        ZoneOffsetTransitionRule[] rules = ruleSize == 0 ? EMPTY_LASTRULES : new ZoneOffsetTransitionRule[ruleSize];
        for (int i7 = 0; i7 < ruleSize; i7++) {
            rules[i7] = ZoneOffsetTransitionRule.readExternal(in);
        }
        return new ZoneRules(stdTrans, stdOffsets, savTrans, savOffsets, rules);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ZoneRules readExternalTimeZone(DataInput in) {
        TimeZone timeZone = TimeZone.getTimeZone(in.readUTF());
        return new ZoneRules(timeZone);
    }

    public boolean isFixedOffset() {
        return this.timeZone != null ? !this.timeZone.useDaylightTime() && this.timeZone.getDSTSavings() == 0 && previousTransition(Instant.now()) == null : this.savingsInstantTransitions.length == 0;
    }

    public ZoneOffset getOffset(Instant instant) {
        if (this.timeZone != null) {
            return offsetFromMillis(this.timeZone.getOffset(instant.toEpochMilli()));
        }
        if (this.savingsInstantTransitions.length == 0) {
            return this.standardOffsets[0];
        }
        long epochSec = instant.getEpochSecond();
        if (this.lastRules.length > 0 && epochSec > this.savingsInstantTransitions[this.savingsInstantTransitions.length - 1]) {
            int year = findYear(epochSec, this.wallOffsets[this.wallOffsets.length - 1]);
            ZoneOffsetTransition[] transArray = findTransitionArray(year);
            ZoneOffsetTransition trans = null;
            for (int i = 0; i < transArray.length; i++) {
                trans = transArray[i];
                if (epochSec < trans.toEpochSecond()) {
                    return trans.getOffsetBefore();
                }
            }
            return trans.getOffsetAfter();
        }
        int index = Arrays.binarySearch(this.savingsInstantTransitions, epochSec);
        if (index < 0) {
            index = (-index) - 2;
        }
        return this.wallOffsets[index + 1];
    }

    public ZoneOffset getOffset(LocalDateTime localDateTime) {
        Object info = getOffsetInfo(localDateTime);
        if (info instanceof ZoneOffsetTransition) {
            return ((ZoneOffsetTransition) info).getOffsetBefore();
        }
        return (ZoneOffset) info;
    }

    public List<ZoneOffset> getValidOffsets(LocalDateTime localDateTime) {
        Object info = getOffsetInfo(localDateTime);
        if (info instanceof ZoneOffsetTransition) {
            return ((ZoneOffsetTransition) info).getValidOffsets();
        }
        return Collections.singletonList((ZoneOffset) info);
    }

    public ZoneOffsetTransition getTransition(LocalDateTime localDateTime) {
        Object info = getOffsetInfo(localDateTime);
        if (info instanceof ZoneOffsetTransition) {
            return (ZoneOffsetTransition) info;
        }
        return null;
    }

    private Object getOffsetInfo(LocalDateTime dt) {
        int i = 0;
        if (this.timeZone != null) {
            ZoneOffsetTransition[] transArray = findTransitionArray(dt.getYear());
            if (transArray.length == 0) {
                return offsetFromMillis(this.timeZone.getOffset(dt.toEpochSecond(this.standardOffsets[0]) * 1000));
            }
            Object info = null;
            int length = transArray.length;
            while (i < length) {
                ZoneOffsetTransition trans = transArray[i];
                info = findOffsetInfo(dt, trans);
                if (!(info instanceof ZoneOffsetTransition) && !info.equals(trans.getOffsetBefore())) {
                    i++;
                } else {
                    return info;
                }
            }
            return info;
        } else if (this.savingsInstantTransitions.length == 0) {
            return this.standardOffsets[0];
        } else {
            if (this.lastRules.length > 0 && dt.isAfter(this.savingsLocalTransitions[this.savingsLocalTransitions.length - 1])) {
                ZoneOffsetTransition[] transArray2 = findTransitionArray(dt.getYear());
                Object info2 = null;
                int length2 = transArray2.length;
                while (i < length2) {
                    ZoneOffsetTransition trans2 = transArray2[i];
                    info2 = findOffsetInfo(dt, trans2);
                    if (!(info2 instanceof ZoneOffsetTransition) && !info2.equals(trans2.getOffsetBefore())) {
                        i++;
                    } else {
                        return info2;
                    }
                }
                return info2;
            }
            int index = Arrays.binarySearch(this.savingsLocalTransitions, dt);
            if (index == -1) {
                return this.wallOffsets[0];
            }
            if (index < 0) {
                index = (-index) - 2;
            } else if (index < this.savingsLocalTransitions.length - 1 && this.savingsLocalTransitions[index].equals(this.savingsLocalTransitions[index + 1])) {
                index++;
            }
            if ((index & 1) == 0) {
                LocalDateTime dtBefore = this.savingsLocalTransitions[index];
                LocalDateTime dtAfter = this.savingsLocalTransitions[index + 1];
                ZoneOffset offsetBefore = this.wallOffsets[index / 2];
                ZoneOffset offsetAfter = this.wallOffsets[(index / 2) + 1];
                if (offsetAfter.getTotalSeconds() > offsetBefore.getTotalSeconds()) {
                    return new ZoneOffsetTransition(dtBefore, offsetBefore, offsetAfter);
                }
                return new ZoneOffsetTransition(dtAfter, offsetBefore, offsetAfter);
            }
            return this.wallOffsets[(index / 2) + 1];
        }
    }

    private Object findOffsetInfo(LocalDateTime dt, ZoneOffsetTransition trans) {
        LocalDateTime localTransition = trans.getDateTimeBefore();
        if (trans.isGap()) {
            if (dt.isBefore(localTransition)) {
                return trans.getOffsetBefore();
            }
            if (dt.isBefore(trans.getDateTimeAfter())) {
                return trans;
            }
            return trans.getOffsetAfter();
        } else if (!dt.isBefore(localTransition)) {
            return trans.getOffsetAfter();
        } else {
            if (dt.isBefore(trans.getDateTimeAfter())) {
                return trans.getOffsetBefore();
            }
            return trans;
        }
    }

    private ZoneOffsetTransition[] findTransitionArray(int year) {
        LocalDateTime newYearsEve;
        long max;
        Integer yearObj = Integer.valueOf(year);
        ZoneOffsetTransition[] transArray = this.lastRulesCache.get(yearObj);
        if (transArray != null) {
            return transArray;
        }
        if (this.timeZone != null) {
            if (year < 1800) {
                return NO_TRANSITIONS;
            }
            LocalDateTime newYearsEve2 = LocalDateTime.of(year - 1, 12, 31, 0, 0);
            long lower = newYearsEve2.toEpochSecond(this.standardOffsets[0]);
            long j = 1000;
            int curOffsetMillis = this.timeZone.getOffset(lower * 1000);
            long max2 = 31968000 + lower;
            ZoneOffsetTransition[] transArray2 = NO_TRANSITIONS;
            while (lower < max2) {
                long upper = 7776000 + lower;
                long lower2 = lower;
                if (curOffsetMillis == this.timeZone.getOffset(upper * j)) {
                    newYearsEve = newYearsEve2;
                    max = max2;
                } else {
                    long lower3 = lower2;
                    while (upper - lower3 > 1) {
                        LocalDateTime newYearsEve3 = newYearsEve2;
                        long middle = DesugarLocalDate$$ExternalSyntheticBackport0.m(upper + lower3, 2L);
                        long max3 = max2;
                        if (this.timeZone.getOffset(middle * 1000) == curOffsetMillis) {
                            lower3 = middle;
                        } else {
                            upper = middle;
                        }
                        newYearsEve2 = newYearsEve3;
                        max2 = max3;
                    }
                    newYearsEve = newYearsEve2;
                    max = max2;
                    if (this.timeZone.getOffset(lower3 * 1000) != curOffsetMillis) {
                        upper = lower3;
                    }
                    ZoneOffset old = offsetFromMillis(curOffsetMillis);
                    j = 1000;
                    int curOffsetMillis2 = this.timeZone.getOffset(upper * 1000);
                    ZoneOffset next = offsetFromMillis(curOffsetMillis2);
                    if (findYear(upper, next) != year) {
                        curOffsetMillis = curOffsetMillis2;
                    } else {
                        transArray2 = (ZoneOffsetTransition[]) Arrays.copyOf(transArray2, transArray2.length + 1);
                        transArray2[transArray2.length - 1] = new ZoneOffsetTransition(upper, old, next);
                        curOffsetMillis = curOffsetMillis2;
                    }
                }
                lower = upper;
                newYearsEve2 = newYearsEve;
                max2 = max;
            }
            if (1916 <= year && year < LAST_CACHED_YEAR) {
                this.lastRulesCache.putIfAbsent(yearObj, transArray2);
            }
            return transArray2;
        }
        ZoneOffsetTransitionRule[] ruleArray = this.lastRules;
        ZoneOffsetTransition[] transArray3 = new ZoneOffsetTransition[ruleArray.length];
        for (int i = 0; i < ruleArray.length; i++) {
            transArray3[i] = ruleArray[i].createTransition(year);
        }
        if (year < LAST_CACHED_YEAR) {
            this.lastRulesCache.putIfAbsent(yearObj, transArray3);
        }
        return transArray3;
    }

    public ZoneOffset getStandardOffset(Instant instant) {
        if (this.timeZone != null) {
            return offsetFromMillis(this.timeZone.getRawOffset());
        }
        if (this.savingsInstantTransitions.length == 0) {
            return this.standardOffsets[0];
        }
        long epochSec = instant.getEpochSecond();
        int index = Arrays.binarySearch(this.standardTransitions, epochSec);
        if (index < 0) {
            index = (-index) - 2;
        }
        return this.standardOffsets[index + 1];
    }

    public Duration getDaylightSavings(Instant instant) {
        if (this.timeZone != null) {
            int offset = this.timeZone.getOffset(instant.toEpochMilli());
            return Duration.ofMillis(offset - this.timeZone.getRawOffset());
        } else if (this.savingsInstantTransitions.length == 0) {
            return Duration.ZERO;
        } else {
            ZoneOffset standardOffset = getStandardOffset(instant);
            ZoneOffset actualOffset = getOffset(instant);
            return Duration.ofSeconds(actualOffset.getTotalSeconds() - standardOffset.getTotalSeconds());
        }
    }

    public boolean isDaylightSavings(Instant instant) {
        return !getStandardOffset(instant).equals(getOffset(instant));
    }

    public boolean isValidOffset(LocalDateTime localDateTime, ZoneOffset offset) {
        return getValidOffsets(localDateTime).contains(offset);
    }

    public ZoneOffsetTransition nextTransition(Instant instant) {
        if (this.timeZone == null) {
            if (this.savingsInstantTransitions.length == 0) {
                return null;
            }
            long epochSec = instant.getEpochSecond();
            if (epochSec >= this.savingsInstantTransitions[this.savingsInstantTransitions.length - 1]) {
                if (this.lastRules.length != 0) {
                    int year = findYear(epochSec, this.wallOffsets[this.wallOffsets.length - 1]);
                    ZoneOffsetTransition[] transArray = findTransitionArray(year);
                    for (ZoneOffsetTransition trans : transArray) {
                        if (epochSec < trans.toEpochSecond()) {
                            return trans;
                        }
                    }
                    if (year < 999999999) {
                        return findTransitionArray(year + 1)[0];
                    }
                    return null;
                }
                return null;
            }
            int index = Arrays.binarySearch(this.savingsInstantTransitions, epochSec);
            int index2 = index < 0 ? (-index) - 1 : index + 1;
            return new ZoneOffsetTransition(this.savingsInstantTransitions[index2], this.wallOffsets[index2], this.wallOffsets[index2 + 1]);
        }
        long epochSec2 = instant.getEpochSecond();
        int year2 = findYear(epochSec2, getOffset(instant));
        ZoneOffsetTransition[] transArray2 = findTransitionArray(year2);
        for (ZoneOffsetTransition trans2 : transArray2) {
            if (epochSec2 < trans2.toEpochSecond()) {
                return trans2;
            }
        }
        if (year2 < 999999999) {
            ZoneOffsetTransition[] transArray3 = findTransitionArray(year2 + 1);
            for (ZoneOffsetTransition trans3 : transArray3) {
                if (epochSec2 < trans3.toEpochSecond()) {
                    return trans3;
                }
            }
        }
        int curOffsetMillis = this.timeZone.getOffset((1 + epochSec2) * 1000);
        long max = (Clock.systemUTC().millis() / 1000) + 31968000;
        for (long probeSec = 31104000 + epochSec2; probeSec <= max; probeSec += 7776000) {
            int probeOffsetMillis = this.timeZone.getOffset(probeSec * 1000);
            if (curOffsetMillis != probeOffsetMillis) {
                int year3 = findYear(probeSec, offsetFromMillis(probeOffsetMillis));
                ZoneOffsetTransition[] transArray4 = findTransitionArray(year3 - 1);
                for (ZoneOffsetTransition trans4 : transArray4) {
                    if (epochSec2 < trans4.toEpochSecond()) {
                        return trans4;
                    }
                }
                return findTransitionArray(year3)[0];
            }
        }
        return null;
    }

    public ZoneOffsetTransition previousTransition(Instant instant) {
        if (this.timeZone == null) {
            if (this.savingsInstantTransitions.length == 0) {
                return null;
            }
            long epochSec = instant.getEpochSecond();
            if (instant.getNano() > 0 && epochSec < Long.MAX_VALUE) {
                epochSec++;
            }
            long lastHistoric = this.savingsInstantTransitions[this.savingsInstantTransitions.length - 1];
            if (this.lastRules.length > 0 && epochSec > lastHistoric) {
                ZoneOffset lastHistoricOffset = this.wallOffsets[this.wallOffsets.length - 1];
                int year = findYear(epochSec, lastHistoricOffset);
                ZoneOffsetTransition[] transArray = findTransitionArray(year);
                for (int i = transArray.length - 1; i >= 0; i--) {
                    if (epochSec > transArray[i].toEpochSecond()) {
                        return transArray[i];
                    }
                }
                int lastHistoricYear = findYear(lastHistoric, lastHistoricOffset);
                int year2 = year - 1;
                if (year2 > lastHistoricYear) {
                    ZoneOffsetTransition[] transArray2 = findTransitionArray(year2);
                    return transArray2[transArray2.length - 1];
                }
            }
            int index = Arrays.binarySearch(this.savingsInstantTransitions, epochSec);
            if (index < 0) {
                index = (-index) - 1;
            }
            if (index <= 0) {
                return null;
            }
            return new ZoneOffsetTransition(this.savingsInstantTransitions[index - 1], this.wallOffsets[index - 1], this.wallOffsets[index]);
        }
        long epochSec2 = instant.getEpochSecond();
        if (instant.getNano() > 0 && epochSec2 < Long.MAX_VALUE) {
            epochSec2++;
        }
        int year3 = findYear(epochSec2, getOffset(instant));
        ZoneOffsetTransition[] transArray3 = findTransitionArray(year3);
        for (int i2 = transArray3.length - 1; i2 >= 0; i2--) {
            if (epochSec2 > transArray3[i2].toEpochSecond()) {
                return transArray3[i2];
            }
        }
        if (year3 > 1800) {
            ZoneOffsetTransition[] transArray4 = findTransitionArray(year3 - 1);
            for (int i3 = transArray4.length - 1; i3 >= 0; i3--) {
                if (epochSec2 > transArray4[i3].toEpochSecond()) {
                    return transArray4[i3];
                }
            }
            int curOffsetMillis = this.timeZone.getOffset((epochSec2 - 1) * 1000);
            long min = LocalDate.of(1800, 1, 1).toEpochDay() * 86400;
            for (long probeSec = Math.min(epochSec2 - 31104000, (Clock.systemUTC().millis() / 1000) + 31968000); min <= probeSec; probeSec -= 7776000) {
                int probeOffsetMillis = this.timeZone.getOffset(probeSec * 1000);
                if (curOffsetMillis != probeOffsetMillis) {
                    int year4 = findYear(probeSec, offsetFromMillis(probeOffsetMillis));
                    ZoneOffsetTransition[] transArray5 = findTransitionArray(year4 + 1);
                    for (int i4 = transArray5.length - 1; i4 >= 0; i4--) {
                        if (epochSec2 > transArray5[i4].toEpochSecond()) {
                            return transArray5[i4];
                        }
                    }
                    ZoneOffsetTransition[] transArray6 = findTransitionArray(year4);
                    return transArray6[transArray6.length - 1];
                }
            }
            return null;
        }
        return null;
    }

    private int findYear(long epochSecond, ZoneOffset offset) {
        long localSecond = offset.getTotalSeconds() + epochSecond;
        long localEpochDay = ZoneRules$$ExternalSyntheticBackport0.m(localSecond, 86400);
        return LocalDate.ofEpochDay(localEpochDay).getYear();
    }

    public List<ZoneOffsetTransition> getTransitions() {
        List<java.time.zone.ZoneOffsetTransition> list = new ArrayList<>();
        for (int i = 0; i < this.savingsInstantTransitions.length; i++) {
            list.add(new ZoneOffsetTransition(this.savingsInstantTransitions[i], this.wallOffsets[i], this.wallOffsets[i + 1]));
        }
        return Collections.unmodifiableList(list);
    }

    public List<ZoneOffsetTransitionRule> getTransitionRules() {
        return Duration$DurationUnits$$ExternalSyntheticBackport0.m(this.lastRules);
    }

    public boolean equals(Object otherRules) {
        if (this == otherRules) {
            return true;
        }
        if (otherRules instanceof ZoneRules) {
            ZoneRules other = (ZoneRules) otherRules;
            return Objects.equals(this.timeZone, other.timeZone) && Arrays.equals(this.standardTransitions, other.standardTransitions) && Arrays.equals(this.standardOffsets, other.standardOffsets) && Arrays.equals(this.savingsInstantTransitions, other.savingsInstantTransitions) && Arrays.equals(this.wallOffsets, other.wallOffsets) && Arrays.equals(this.lastRules, other.lastRules);
        }
        return false;
    }

    public int hashCode() {
        return ((((Objects.hashCode(this.timeZone) ^ Arrays.hashCode(this.standardTransitions)) ^ Arrays.hashCode(this.standardOffsets)) ^ Arrays.hashCode(this.savingsInstantTransitions)) ^ Arrays.hashCode(this.wallOffsets)) ^ Arrays.hashCode(this.lastRules);
    }

    public String toString() {
        if (this.timeZone != null) {
            return "ZoneRules[timeZone=" + this.timeZone.getID() + "]";
        }
        return "ZoneRules[currentStandardOffset=" + this.standardOffsets[this.standardOffsets.length - 1] + "]";
    }
}