package j$.util;

import java.util.Arrays;

public final class StringJoiner {
    private final String delimiter;
    private String[] elts;
    private String emptyValue;
    private int len;
    private final String prefix;
    private int size;
    private final String suffix;

    public StringJoiner(CharSequence delimiter) {
        this(delimiter, "", "");
    }

    public StringJoiner(CharSequence delimiter, CharSequence prefix, CharSequence suffix) {
        Objects.requireNonNull(prefix, "The prefix must not be null");
        Objects.requireNonNull(delimiter, "The delimiter must not be null");
        Objects.requireNonNull(suffix, "The suffix must not be null");
        this.prefix = prefix.toString();
        this.delimiter = delimiter.toString();
        this.suffix = suffix.toString();
    }

    public StringJoiner setEmptyValue(CharSequence emptyValue) {
        this.emptyValue = ((CharSequence) Objects.requireNonNull(emptyValue, "The empty value must not be null")).toString();
        return this;
    }

    private static int getChars(String s, char[] chars, int start) {
        int len = s.length();
        s.getChars(0, len, chars, start);
        return len;
    }

    public String toString() {
        String[] elts = this.elts;
        if (elts == null && this.emptyValue != null) {
            return this.emptyValue;
        }
        int size = this.size;
        int addLen = this.prefix.length() + this.suffix.length();
        if (addLen == 0) {
            compactElts();
            return size == 0 ? "" : elts[0];
        }
        String delimiter = this.delimiter;
        char[] chars = new char[this.len + addLen];
        int k = getChars(this.prefix, chars, 0);
        if (size > 0) {
            k += getChars(elts[0], chars, k);
            for (int i = 1; i < size; i++) {
                int k2 = k + getChars(delimiter, chars, k);
                k = k2 + getChars(elts[i], chars, k2);
            }
        }
        int chars2 = k + getChars(this.suffix, chars, k);
        return new String(chars);
    }

    public StringJoiner add(CharSequence newElement) {
        String elt = String.valueOf(newElement);
        if (this.elts == null) {
            this.elts = new String[8];
        } else {
            if (this.size == this.elts.length) {
                this.elts = (String[]) Arrays.copyOf(this.elts, this.size * 2);
            }
            this.len += this.delimiter.length();
        }
        this.len += elt.length();
        String[] strArr = this.elts;
        int i = this.size;
        this.size = i + 1;
        strArr[i] = elt;
        return this;
    }

    public StringJoiner merge(StringJoiner other) {
        Objects.requireNonNull(other);
        if (other.elts == null) {
            return this;
        }
        other.compactElts();
        return add(other.elts[0]);
    }

    private void compactElts() {
        if (this.size > 1) {
            char[] chars = new char[this.len];
            int i = 1;
            int k = getChars(this.elts[0], chars, 0);
            do {
                int k2 = k + getChars(this.delimiter, chars, k);
                k = k2 + getChars(this.elts[i], chars, k2);
                this.elts[i] = null;
                i++;
            } while (i < this.size);
            this.size = 1;
            this.elts[0] = new String(chars);
        }
    }

    public int length() {
        return (this.size != 0 || this.emptyValue == null) ? this.len + this.prefix.length() + this.suffix.length() : this.emptyValue.length();
    }
}