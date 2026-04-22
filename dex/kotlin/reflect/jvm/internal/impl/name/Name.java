package kotlin.reflect.jvm.internal.impl.name;

public final class Name implements Comparable<Name> {
    private final String name;
    private final boolean special;

    private static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str;
        int i2;
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                i2 = 2;
                break;
            default:
                i2 = 3;
                break;
        }
        Object[] objArr = new Object[i2];
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
                break;
            default:
                objArr[0] = "name";
                break;
        }
        switch (i) {
            case 1:
                objArr[1] = "asString";
                break;
            case 2:
                objArr[1] = "getIdentifier";
                break;
            case 3:
            case 4:
                objArr[1] = "asStringStripSpecialMarkers";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
                break;
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                break;
            case 5:
                objArr[2] = "identifier";
                break;
            case 6:
                objArr[2] = "isValidIdentifier";
                break;
            case 7:
                objArr[2] = "identifierIfValid";
                break;
            case 8:
                objArr[2] = "special";
                break;
            case 9:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    private Name(String name, boolean special) {
        if (name == null) {
            $$$reportNull$$$0(0);
        }
        this.name = name;
        this.special = special;
    }

    public String asString() {
        String str = this.name;
        if (str == null) {
            $$$reportNull$$$0(1);
        }
        return str;
    }

    public String getIdentifier() {
        if (this.special) {
            throw new IllegalStateException("not identifier: " + this);
        }
        String asString = asString();
        if (asString == null) {
            $$$reportNull$$$0(2);
        }
        return asString;
    }

    public boolean isSpecial() {
        return this.special;
    }

    @Override // java.lang.Comparable
    public int compareTo(Name that) {
        return this.name.compareTo(that.name);
    }

    public static Name identifier(String name) {
        if (name == null) {
            $$$reportNull$$$0(5);
        }
        return new Name(name, false);
    }

    public static boolean isValidIdentifier(String name) {
        if (name == null) {
            $$$reportNull$$$0(6);
        }
        if (name.isEmpty() || name.startsWith("<")) {
            return false;
        }
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            if (ch == '.' || ch == '/' || ch == '\\') {
                return false;
            }
        }
        return true;
    }

    public static Name special(String name) {
        if (name == null) {
            $$$reportNull$$$0(8);
        }
        if (!name.startsWith("<")) {
            throw new IllegalArgumentException("special name must start with '<': " + name);
        }
        return new Name(name, true);
    }

    public static Name guessByFirstCharacter(String name) {
        if (name == null) {
            $$$reportNull$$$0(9);
        }
        if (name.startsWith("<")) {
            return special(name);
        }
        return identifier(name);
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Name) {
            Name name1 = (Name) o;
            return this.special == name1.special && this.name.equals(name1.name);
        }
        return false;
    }

    public int hashCode() {
        int result = this.name.hashCode();
        return (result * 31) + (this.special ? 1 : 0);
    }
}