package quarkruntime;

public class Symbol {
    public final String value;

    public Symbol(String value) {
        this.value = value;
    }

    public String text() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }

    // Optional: equals and hashCode if you plan to compare symbols
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Symbol)) return false;
        Symbol other = (Symbol) obj;
        return value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
