package shark.internal.aosp;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteArrayTimSort.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\b\u0000\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002J(\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J(\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lshark/internal/aosp/ByteArrayTimSort;", "", "a", "", "c", "Lshark/internal/aosp/ByteArrayComparator;", "entrySize", "", "([BLshark/internal/aosp/ByteArrayComparator;I)V", "minGallop", "runBase", "", "runLen", "stackSize", "tmp", "ensureCapacity", "minCapacity", "mergeAt", "", "i", "mergeCollapse", "mergeForceCollapse", "mergeHi", "base1", "len1", "base2", "len2", "mergeLo", "pushRun", "Companion", "shark-graph"}, k = 1, mv = {1, 4, 1})
public final class ByteArrayTimSort {
    public static final Companion Companion = new Companion(null);
    private static final boolean DEBUG = false;
    private static final int INITIAL_TMP_STORAGE_LENGTH = 256;
    private static final int MIN_GALLOP = 7;
    private static final int MIN_MERGE = 32;
    private final byte[] a;
    private final ByteArrayComparator c;
    private final int entrySize;
    private int minGallop;
    private final int[] runBase;
    private final int[] runLen;
    private int stackSize;
    private byte[] tmp;

    public /* synthetic */ ByteArrayTimSort(byte[] a, ByteArrayComparator c, int entrySize, DefaultConstructorMarker $constructor_marker) {
        this(a, c, entrySize);
    }

    private ByteArrayTimSort(byte[] a, ByteArrayComparator c, int entrySize) {
        int i;
        int stackLen;
        this.a = a;
        this.c = c;
        this.entrySize = entrySize;
        this.minGallop = 7;
        int len = this.a.length / this.entrySize;
        int i2 = this.entrySize;
        if (len < 512) {
            i = len >>> 1;
        } else {
            i = 256;
        }
        byte[] newArray = new byte[i2 * i];
        this.tmp = newArray;
        if (len < 120) {
            stackLen = 5;
        } else if (len < 1542) {
            stackLen = 10;
        } else {
            stackLen = len < 119151 ? 19 : 40;
        }
        this.runBase = new int[stackLen];
        this.runLen = new int[stackLen];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pushRun(int runBase, int runLen) {
        this.runBase[this.stackSize] = runBase;
        this.runLen[this.stackSize] = runLen;
        this.stackSize++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mergeCollapse() {
        while (this.stackSize > 1) {
            int n = this.stackSize - 2;
            if ((n >= 1 && this.runLen[n - 1] <= this.runLen[n] + this.runLen[n + 1]) || (n >= 2 && this.runLen[n - 2] <= this.runLen[n] + this.runLen[n - 1])) {
                if (this.runLen[n - 1] < this.runLen[n + 1]) {
                    n--;
                }
            } else if (this.runLen[n] > this.runLen[n + 1]) {
                return;
            }
            mergeAt(n);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mergeForceCollapse() {
        while (this.stackSize > 1) {
            int n = this.stackSize - 2;
            if (n > 0 && this.runLen[n - 1] < this.runLen[n + 1]) {
                n--;
            }
            mergeAt(n);
        }
    }

    private final void mergeAt(int i) {
        int len2;
        int base1 = this.runBase[i];
        int len1 = this.runLen[i];
        int base2 = this.runBase[i + 1];
        int len22 = this.runLen[i + 1];
        this.runLen[i] = len1 + len22;
        if (i == this.stackSize - 3) {
            this.runBase[i + 1] = this.runBase[i + 2];
            this.runLen[i + 1] = this.runLen[i + 2];
        }
        this.stackSize--;
        int k = Companion.gallopRight(this.a, base2, this.a, base1, len1, 0, this.entrySize, this.c);
        int base12 = base1 + k;
        int len12 = len1 - k;
        if (len12 == 0 || (len2 = Companion.gallopLeft(this.a, (base12 + len12) - 1, this.a, base2, len22, len22 - 1, this.entrySize, this.c)) == 0) {
            return;
        }
        if (len12 <= len2) {
            mergeLo(base12, len12, base2, len2);
        } else {
            mergeHi(base12, len12, base2, len2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d2, code lost:
        r21 = r20;
        r20 = r19;
        r19 = r18;
        r18 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00de, code lost:
        r24 = r10;
        r15 = r11;
        r11 = shark.internal.aosp.ByteArrayTimSort.Companion.gallopRight(r12, r20, r14, r19, r1, 0, r13, r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00f4, code lost:
        if (r11 == 0) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00f6, code lost:
        java.lang.System.arraycopy(r14, r19 * r13, r12, r21 * r13, r11 * r13);
        r3 = r21 + r11;
        r4 = r19 + r11;
        r1 = r1 - r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0104, code lost:
        if (r1 > r15) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0106, code lost:
        r11 = r18;
        r19 = r20;
        r20 = r3;
        r18 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0110, code lost:
        r21 = r3;
        r19 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0114, code lost:
        r22 = r21 * r13;
        r25 = r20 * r13;
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0119, code lost:
        if (r3 >= r13) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x011b, code lost:
        r12[r22 + r3] = r12[r25 + r3];
        r3 = r3 + r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0126, code lost:
        r21 = r21 + 1;
        r20 = r20 + 1;
        r2 = r2 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x012c, code lost:
        if (r2 != 0) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x012e, code lost:
        r11 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0137, code lost:
        r3 = shark.internal.aosp.ByteArrayTimSort.Companion.gallopLeft(r14, r19, r12, r20, r2, 0, r13, r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x014a, code lost:
        if (r3 == 0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x014c, code lost:
        java.lang.System.arraycopy(r12, r20 * r13, r12, r21 * r13, r3 * r13);
        r4 = r21 + r3;
        r5 = r20 + r3;
        r2 = r2 - r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x015a, code lost:
        if (r2 != 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x015c, code lost:
        r20 = r4;
        r11 = r18;
        r18 = r19;
        r19 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0165, code lost:
        r21 = r4;
        r20 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0169, code lost:
        r4 = r21 * r13;
        r5 = r19 * r13;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x016e, code lost:
        if (r6 >= r13) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0170, code lost:
        r12[r4 + r6] = r14[r5 + r6];
        r6 = r6 + r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x017b, code lost:
        r21 = r21 + 1;
        r19 = r19 + 1;
        r1 = r1 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0181, code lost:
        if (r1 != r15) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0183, code lost:
        r11 = r18;
        r18 = r19;
        r19 = r20;
        r20 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01cb, code lost:
        r18 = r18 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x01d0, code lost:
        if (r11 < 7) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01d2, code lost:
        r11 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01d4, code lost:
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01d5, code lost:
        if (r3 < 7) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01d7, code lost:
        r6 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01d9, code lost:
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01db, code lost:
        if ((r6 | r11) != 0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01dd, code lost:
        if (r18 >= 0) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01df, code lost:
        r18 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01ef, code lost:
        r11 = r15;
        r10 = r24;
     */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01f9 A[LOOP:3: B:17:0x0072->B:86:0x01f9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00d2 A[EDGE_INSN: B:97:0x00d2->B:35:0x00d2 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void mergeLo(int base1, int len1, int base2, int len2) {
        int i;
        int minGallop;
        int cursor2;
        int dest;
        int i2;
        int minGallop2;
        int dest2;
        int cursor22;
        int cursor1;
        int minGallop3;
        ByteArrayComparator c;
        int len12 = len1;
        byte[] a = this.a;
        int entrySize = this.entrySize;
        byte[] tmp = ensureCapacity(len12);
        int i3 = 0;
        System.arraycopy(a, base1 * entrySize, tmp, 0, len12 * entrySize);
        int cursor12 = 0;
        int destIndex = base1 * entrySize;
        int cursor2Index = base2 * entrySize;
        int i4 = 0;
        while (true) {
            i = 1;
            if (i4 >= entrySize) {
                break;
            }
            a[destIndex + i4] = a[cursor2Index + i4];
            i4++;
        }
        int dest3 = base1 + 1;
        int cursor23 = base2 + 1;
        int len22 = len2 - 1;
        if (len22 == 0) {
            System.arraycopy(tmp, 0 * entrySize, a, dest3 * entrySize, len12 * entrySize);
        } else if (len12 == 1) {
            System.arraycopy(a, cursor23 * entrySize, a, dest3 * entrySize, len22 * entrySize);
            int destLen2Index = (dest3 + len22) * entrySize;
            int cursor1Index = 0 * entrySize;
            while (i3 < entrySize) {
                int i5 = i3;
                a[destLen2Index + i5] = tmp[cursor1Index + i5];
                i3 = i5 + 1;
            }
        } else {
            ByteArrayComparator c2 = this.c;
            int minGallop4 = this.minGallop;
            loop2: while (true) {
                minGallop = cursor12;
                cursor2 = cursor23;
                dest = dest3;
                int count1 = 0;
                int count2 = 0;
                while (true) {
                    if (c2.compare(entrySize, a, cursor2, tmp, minGallop) < 0) {
                        int destIndex2 = dest * entrySize;
                        int cursor2Index2 = cursor2 * entrySize;
                        for (int i6 = i3; i6 < entrySize; i6 += i) {
                            a[destIndex2 + i6] = a[cursor2Index2 + i6];
                        }
                        dest++;
                        cursor2++;
                        count2++;
                        len22--;
                        if (len22 == 0) {
                            i2 = i;
                            minGallop2 = minGallop4;
                            break loop2;
                        }
                        count1 = 0;
                        if ((count1 | count2) < minGallop4) {
                            break;
                        }
                        i3 = 0;
                    } else {
                        int destIndex3 = dest * entrySize;
                        int cursor1Index2 = minGallop * entrySize;
                        for (int i7 = i3; i7 < entrySize; i7 += i) {
                            a[destIndex3 + i7] = tmp[cursor1Index2 + i7];
                        }
                        dest++;
                        minGallop++;
                        count1++;
                        len12--;
                        if (len12 == i) {
                            i2 = i;
                            minGallop2 = minGallop4;
                            break loop2;
                        }
                        count2 = 0;
                        if ((count1 | count2) < minGallop4) {
                        }
                    }
                }
                minGallop4 = minGallop3 + 2;
                i = i2;
                cursor12 = cursor1;
                cursor23 = cursor22;
                dest3 = dest2;
                c2 = c;
                i3 = 0;
            }
            this.minGallop = minGallop2 < i2 ? i2 : minGallop2;
            switch (len12) {
                case 0:
                    throw new IllegalArgumentException("Comparison method violates its general contract!");
                case 1:
                    System.arraycopy(a, cursor2 * entrySize, a, dest * entrySize, len22 * entrySize);
                    int destLen2Index2 = (dest + len22) * entrySize;
                    int cursor1Index3 = minGallop * entrySize;
                    for (int i8 = 0; i8 < entrySize; i8 += i2) {
                        a[destLen2Index2 + i8] = tmp[cursor1Index3 + i8];
                    }
                    return;
                default:
                    System.arraycopy(tmp, minGallop * entrySize, a, dest * entrySize, len12 * entrySize);
                    return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00e3, code lost:
        r20 = r19;
        r19 = r18;
        r18 = r17;
        r17 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00ef, code lost:
        r23 = r10;
        r24 = r15;
        r15 = r11;
        r11 = r1 - shark.internal.aosp.ByteArrayTimSort.Companion.gallopRight(r13, r19, r12, r28, r1, r1 - 1, r14, r23);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x010a, code lost:
        if (r11 == 0) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010c, code lost:
        r3 = r20 - r11;
        r4 = r18 - r11;
        r1 = r1 - r11;
        java.lang.System.arraycopy(r12, (r4 + 1) * r14, r12, (r3 + 1) * r14, r11 * r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x011d, code lost:
        if (r1 != 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x011f, code lost:
        r18 = r19;
        r11 = r24;
        r19 = r3;
        r17 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x012b, code lost:
        r20 = r3;
        r18 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x012f, code lost:
        r17 = r20 * r14;
        r21 = r19 * r14;
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0134, code lost:
        if (r3 >= r14) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0136, code lost:
        r12[r17 + r3] = r13[r21 + r3];
        r3 = r3 + r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0141, code lost:
        r20 = r20 - 1;
        r19 = r19 - 1;
        r2 = r2 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0147, code lost:
        if (r2 != r15) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0149, code lost:
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r11 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0154, code lost:
        r3 = r2 - shark.internal.aosp.ByteArrayTimSort.Companion.gallopLeft(r12, r18, r13, 0, r2, r2 - 1, r14, r23);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0169, code lost:
        if (r3 == 0) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x016b, code lost:
        r4 = r20 - r3;
        r5 = r19 - r3;
        r2 = r2 - r3;
        java.lang.System.arraycopy(r13, (r5 + 1) * r14, r12, (r4 + 1) * r14, r3 * r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x017c, code lost:
        if (r2 > r15) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x017e, code lost:
        r19 = r4;
        r17 = r18;
        r11 = r24;
        r18 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0189, code lost:
        r20 = r4;
        r19 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x018d, code lost:
        r4 = r20 * r14;
        r5 = r18 * r14;
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0192, code lost:
        if (r6 >= r14) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0194, code lost:
        r12[r4 + r6] = r12[r5 + r6];
        r6 = r6 + r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x019f, code lost:
        r20 = r20 - 1;
        r18 = r18 - 1;
        r1 = r1 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x01a5, code lost:
        if (r1 != 0) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01a7, code lost:
        r17 = r18;
        r18 = r19;
        r19 = r20;
        r11 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01f8, code lost:
        r7 = r24 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x01fe, code lost:
        if (r11 < 7) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0200, code lost:
        r11 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0202, code lost:
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0203, code lost:
        if (r3 < 7) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0205, code lost:
        r8 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0207, code lost:
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0209, code lost:
        if ((r8 | r11) != 0) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x020b, code lost:
        if (r7 >= 0) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x020d, code lost:
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x021e, code lost:
        r11 = r15;
        r10 = r23;
        r15 = r7;
     */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0228 A[LOOP:3: B:16:0x007c->B:85:0x0228, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00e3 A[EDGE_INSN: B:96:0x00e3->B:34:0x00e3 ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void mergeHi(int base1, int len1, int base2, int len2) {
        int cursor1;
        int cursor12;
        int dest;
        int minGallop;
        int minGallop2;
        int dest2;
        int cursor2;
        int cursor13;
        int destIndex;
        ByteArrayComparator c;
        int minGallop3;
        int len22 = len2;
        byte[] a = this.a;
        byte[] tmp = ensureCapacity(len22);
        int entrySize = this.entrySize;
        int i = 0;
        System.arraycopy(a, base2 * entrySize, tmp, 0, len22 * entrySize);
        int i2 = 1;
        int cursor14 = (base1 + len1) - 1;
        int cursor22 = len22 - 1;
        int dest3 = (base2 + len22) - 1;
        int destIndex2 = dest3 * entrySize;
        int cursor1Index = cursor14 * entrySize;
        for (int i3 = 0; i3 < entrySize; i3++) {
            a[destIndex2 + i3] = a[cursor1Index + i3];
        }
        int dest4 = dest3 - 1;
        int cursor15 = cursor14 - 1;
        int len12 = len1 - 1;
        if (len12 == 0) {
            System.arraycopy(tmp, 0, a, (dest4 - (len22 - 1)) * entrySize, len22 * entrySize);
        } else if (len22 == 1) {
            int dest5 = dest4 - len12;
            System.arraycopy(a, ((cursor15 - len12) + 1) * entrySize, a, (dest5 + 1) * entrySize, len12 * entrySize);
            int destIndex3 = dest5 * entrySize;
            int cursor2Index = cursor22 * entrySize;
            while (i < entrySize) {
                int i4 = i;
                a[destIndex3 + i4] = tmp[cursor2Index + i4];
                i = i4 + 1;
            }
        } else {
            ByteArrayComparator c2 = this.c;
            int destIndex4 = destIndex2;
            int minGallop4 = this.minGallop;
            loop2: while (true) {
                cursor1 = cursor15;
                cursor12 = cursor22;
                dest = dest4;
                int count1 = 0;
                int count2 = 0;
                while (true) {
                    int minGallop5 = minGallop4;
                    int minGallop6 = cursor1;
                    if (c2.compare(entrySize, tmp, cursor12, a, minGallop6) < 0) {
                        int destIndex5 = dest * entrySize;
                        int cursor1Index2 = cursor1 * entrySize;
                        for (int i5 = 0; i5 < entrySize; i5 += i2) {
                            a[destIndex5 + i5] = a[cursor1Index2 + i5];
                        }
                        dest--;
                        cursor1--;
                        count1++;
                        len12--;
                        if (len12 == 0) {
                            minGallop = i2;
                            minGallop2 = minGallop5;
                            break loop2;
                        }
                        count2 = 0;
                        if ((count1 | count2) < minGallop5) {
                            break;
                        }
                        minGallop4 = minGallop5;
                    } else {
                        int destIndex6 = dest * entrySize;
                        int cursor2Index2 = cursor12 * entrySize;
                        for (int i6 = 0; i6 < entrySize; i6 += i2) {
                            a[destIndex6 + i6] = tmp[cursor2Index2 + i6];
                        }
                        dest--;
                        cursor12--;
                        count2++;
                        len22--;
                        if (len22 == i2) {
                            minGallop = i2;
                            minGallop2 = minGallop5;
                            break loop2;
                        }
                        count1 = 0;
                        if ((count1 | count2) < minGallop5) {
                        }
                    }
                }
                minGallop4 = minGallop3 + 2;
                i2 = minGallop;
                destIndex4 = destIndex;
                cursor15 = cursor13;
                cursor22 = cursor2;
                dest4 = dest2;
                c2 = c;
            }
            this.minGallop = minGallop2 < minGallop ? minGallop : minGallop2;
            switch (len22) {
                case 0:
                    throw new IllegalArgumentException("Comparison method violates its general contract!");
                case 1:
                    int dest6 = dest - len12;
                    System.arraycopy(a, ((cursor1 - len12) + 1) * entrySize, a, (dest6 + 1) * entrySize, len12 * entrySize);
                    int destIndex7 = dest6 * entrySize;
                    int cursor2Index3 = cursor12 * entrySize;
                    for (int i7 = 0; i7 < entrySize; i7 += minGallop) {
                        a[destIndex7 + i7] = tmp[cursor2Index3 + i7];
                    }
                    return;
                default:
                    System.arraycopy(tmp, 0, a, (dest - (len22 - 1)) * entrySize, len22 * entrySize);
                    return;
            }
        }
    }

    private final byte[] ensureCapacity(int minCapacity) {
        int newSize;
        byte[] bArr = this.tmp;
        if (bArr == null) {
            Intrinsics.throwNpe();
        }
        if (bArr.length < this.entrySize * minCapacity) {
            int newSize2 = minCapacity | (minCapacity >> 1);
            int newSize3 = newSize2 | (newSize2 >> 2);
            int newSize4 = newSize3 | (newSize3 >> 4);
            int newSize5 = newSize4 | (newSize4 >> 8);
            int newSize6 = (newSize5 | (newSize5 >> 16)) + 1;
            if (newSize6 < 0) {
                newSize = minCapacity;
            } else {
                newSize = Math.min(newSize6, (this.a.length / this.entrySize) >>> 1);
            }
            byte[] newArray = new byte[this.entrySize * newSize];
            this.tmp = newArray;
        }
        byte[] bArr2 = this.tmp;
        if (bArr2 == null) {
            Intrinsics.throwNpe();
        }
        return bArr2;
    }

    /* compiled from: ByteArrayTimSort.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0006H\u0002J0\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002JH\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002JH\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u0006H\u0002J(\u0010\u001f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J.\u0010 \u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012J\u001e\u0010 \u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lshark/internal/aosp/ByteArrayTimSort$Companion;", "", "()V", "DEBUG", "", "INITIAL_TMP_STORAGE_LENGTH", "", "MIN_GALLOP", "MIN_MERGE", "binarySort", "", "a", "", "lo", "hi", "start", "entrySize", "c", "Lshark/internal/aosp/ByteArrayComparator;", "checkStartAndEnd", "len", "end", "countRunAndMakeAscending", "gallopLeft", "keyArray", "keyIndex", "base", "hint", "gallopRight", "minRunLength", "n", "reverseRange", "sort", "shark-graph"}, k = 1, mv = {1, 4, 1})
    /* loaded from: /data/np/file-convert/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745/202602280716530a65f01f-b074-44ce-b792-9505fbe7f745.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        public final void sort(byte[] a, int entrySize, ByteArrayComparator c) {
            Intrinsics.checkParameterIsNotNull(a, "a");
            Intrinsics.checkParameterIsNotNull(c, "c");
            sort(a, 0, a.length / entrySize, entrySize, c);
        }

        public final void sort(byte[] a, int lo, int hi, int entrySize, ByteArrayComparator c) {
            Intrinsics.checkParameterIsNotNull(a, "a");
            Intrinsics.checkParameterIsNotNull(c, "c");
            int lo2 = lo;
            checkStartAndEnd(a.length / entrySize, lo2, hi);
            int nRemaining = hi - lo2;
            if (nRemaining < 2) {
                return;
            }
            if (nRemaining < 32) {
                int initRunLen = countRunAndMakeAscending(a, lo2, hi, entrySize, c);
                binarySort(a, lo2, hi, lo2 + initRunLen, entrySize, c);
                return;
            }
            ByteArrayTimSort ts = new ByteArrayTimSort(a, c, entrySize, null);
            int minRun = minRunLength(nRemaining);
            do {
                int runLen = countRunAndMakeAscending(a, lo2, hi, entrySize, c);
                if (runLen < minRun) {
                    int force = nRemaining <= minRun ? nRemaining : minRun;
                    binarySort(a, lo2, lo2 + force, lo2 + runLen, entrySize, c);
                    runLen = force;
                }
                ts.pushRun(lo2, runLen);
                ts.mergeCollapse();
                lo2 += runLen;
                nRemaining -= runLen;
            } while (nRemaining != 0);
            ts.mergeForceCollapse();
        }

        private final void checkStartAndEnd(int len, int start, int end) {
            if (start < 0 || end > len) {
                throw new ArrayIndexOutOfBoundsException("start < 0 || end > len. start=" + start + ", end=" + end + ", len=" + len);
            }
            if (start > end) {
                throw new IllegalArgumentException("start > end: " + start + " > " + end);
            }
        }

        private final void binarySort(byte[] a, int lo, int hi, int start, int entrySize, ByteArrayComparator c) {
            int start2 = start;
            if (start2 == lo) {
                start2++;
            }
            byte[] pivot = new byte[entrySize];
            for (int start3 = start2; start3 < hi; start3++) {
                int startIndex = start3 * entrySize;
                int i = 0;
                for (int i2 = 0; i2 < entrySize; i2++) {
                    pivot[i2] = a[startIndex + i2];
                }
                int right = start3;
                int left = lo;
                int right2 = right;
                while (left < right2) {
                    int mid = (left + right2) >>> 1;
                    if (c.compare(entrySize, pivot, 0, a, mid) < 0) {
                        right2 = mid;
                    } else {
                        int right3 = mid + 1;
                        left = right3;
                    }
                }
                int n = start3 - left;
                switch (n) {
                    case 1:
                        int leftIndex = left * entrySize;
                        int leftPlusOneIndex = (left + 1) * entrySize;
                        for (int i3 = 0; i3 < entrySize; i3++) {
                            a[leftPlusOneIndex + i3] = a[leftIndex + i3];
                        }
                        break;
                    case 2:
                        int leftIndex2 = left * entrySize;
                        int leftPlusOneIndex2 = (left + 1) * entrySize;
                        int leftPlusTwoIndex = (left + 2) * entrySize;
                        for (int i4 = 0; i4 < entrySize; i4++) {
                            a[leftPlusTwoIndex + i4] = a[leftPlusOneIndex2 + i4];
                        }
                        for (int i5 = 0; i5 < entrySize; i5++) {
                            a[leftPlusOneIndex2 + i5] = a[leftIndex2 + i5];
                        }
                        break;
                    default:
                        System.arraycopy(a, left * entrySize, a, (left + 1) * entrySize, n * entrySize);
                        break;
                }
                int leftIndex3 = left * entrySize;
                while (i < entrySize) {
                    int i6 = i;
                    a[leftIndex3 + i6] = pivot[i6];
                    i = i6 + 1;
                }
            }
        }

        private final int countRunAndMakeAscending(byte[] a, int lo, int hi, int entrySize, ByteArrayComparator c) {
            int runHi = lo + 1;
            if (runHi == hi) {
                return 1;
            }
            int comparison = c.compare(entrySize, a, runHi, a, lo);
            int runHi2 = runHi + 1;
            if (comparison < 0) {
                while (runHi2 < hi) {
                    if (c.compare(entrySize, a, runHi2, a, runHi2 - 1) >= 0) {
                        break;
                    }
                    runHi2++;
                }
                reverseRange(a, lo, runHi2, entrySize);
            } else {
                while (runHi2 < hi) {
                    if (c.compare(entrySize, a, runHi2, a, runHi2 - 1) < 0) {
                        break;
                    }
                    runHi2++;
                }
            }
            return runHi2 - lo;
        }

        private final void reverseRange(byte[] a, int lo, int hi, int entrySize) {
            int lo2 = lo;
            for (int hi2 = hi - 1; lo2 < hi2; hi2--) {
                int loIndex = lo2 * entrySize;
                int hiIndex = hi2 * entrySize;
                for (int i = 0; i < entrySize; i++) {
                    byte t = a[loIndex + i];
                    a[loIndex + i] = a[hiIndex + i];
                    a[hiIndex + i] = t;
                }
                lo2++;
            }
        }

        private final int minRunLength(int n) {
            int n2 = n;
            int r = 0;
            while (n2 >= 32) {
                r |= n2 & 1;
                n2 >>= 1;
            }
            return n2 + r;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int gallopLeft(byte[] keyArray, int keyIndex, byte[] a, int base, int len, int hint, int entrySize, ByteArrayComparator c) {
            int lastOfs;
            int ofs;
            int lastOfs2 = 0;
            int ofs2 = 1;
            if (c.compare(entrySize, keyArray, keyIndex, a, base + hint) > 0) {
                int maxOfs = len - hint;
                while (ofs2 < maxOfs && c.compare(entrySize, keyArray, keyIndex, a, base + hint + ofs2) > 0) {
                    lastOfs2 = ofs2;
                    int ofs3 = (ofs2 * 2) + 1;
                    if (ofs3 > 0) {
                        ofs2 = ofs3;
                    } else {
                        ofs2 = maxOfs;
                    }
                }
                if (ofs2 > maxOfs) {
                    ofs2 = maxOfs;
                }
                lastOfs = lastOfs2 + hint;
                ofs = ofs2 + hint;
            } else {
                int maxOfs2 = hint + 1;
                while (ofs2 < maxOfs2 && c.compare(entrySize, keyArray, keyIndex, a, (base + hint) - ofs2) <= 0) {
                    lastOfs2 = ofs2;
                    int ofs4 = (ofs2 * 2) + 1;
                    if (ofs4 > 0) {
                        ofs2 = ofs4;
                    } else {
                        ofs2 = maxOfs2;
                    }
                }
                if (ofs2 > maxOfs2) {
                    ofs2 = maxOfs2;
                }
                int tmp = lastOfs2;
                lastOfs = hint - ofs2;
                ofs = hint - tmp;
            }
            int lastOfs3 = lastOfs + 1;
            while (lastOfs3 < ofs) {
                int m = ((ofs - lastOfs3) >>> 1) + lastOfs3;
                if (c.compare(entrySize, keyArray, keyIndex, a, base + m) > 0) {
                    lastOfs3 = m + 1;
                } else {
                    ofs = m;
                }
            }
            return ofs;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int gallopRight(byte[] keyArray, int keyIndex, byte[] a, int base, int len, int hint, int entrySize, ByteArrayComparator c) {
            int lastOfs;
            int ofs;
            int ofs2 = 1;
            int lastOfs2 = 0;
            if (c.compare(entrySize, keyArray, keyIndex, a, base + hint) < 0) {
                int maxOfs = hint + 1;
                while (ofs2 < maxOfs && c.compare(entrySize, keyArray, keyIndex, a, (base + hint) - ofs2) < 0) {
                    lastOfs2 = ofs2;
                    int ofs3 = (ofs2 * 2) + 1;
                    if (ofs3 > 0) {
                        ofs2 = ofs3;
                    } else {
                        ofs2 = maxOfs;
                    }
                }
                if (ofs2 > maxOfs) {
                    ofs2 = maxOfs;
                }
                int tmp = lastOfs2;
                lastOfs = hint - ofs2;
                ofs = hint - tmp;
            } else {
                int maxOfs2 = len - hint;
                while (ofs2 < maxOfs2 && c.compare(entrySize, keyArray, keyIndex, a, base + hint + ofs2) >= 0) {
                    lastOfs2 = ofs2;
                    int ofs4 = (ofs2 * 2) + 1;
                    if (ofs4 > 0) {
                        ofs2 = ofs4;
                    } else {
                        ofs2 = maxOfs2;
                    }
                }
                if (ofs2 > maxOfs2) {
                    ofs2 = maxOfs2;
                }
                lastOfs = lastOfs2 + hint;
                ofs = ofs2 + hint;
            }
            int lastOfs3 = lastOfs + 1;
            while (lastOfs3 < ofs) {
                int m = ((ofs - lastOfs3) >>> 1) + lastOfs3;
                if (c.compare(entrySize, keyArray, keyIndex, a, base + m) < 0) {
                    ofs = m;
                } else {
                    lastOfs3 = m + 1;
                }
            }
            return ofs;
        }
    }
}