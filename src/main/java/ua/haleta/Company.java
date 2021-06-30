package ua.haleta;

import java.util.Objects;

public class Company {
    private final Company parent;
    private final long employeeCount;

    public Company(final Company parent, final long employeeCount) {
        this.parent = parent;
        this.employeeCount = employeeCount;
    }

    public Company getParent() {
        return this.parent;
    }

    public long getEmployeeCount() {
        return this.employeeCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return this.employeeCount == company.employeeCount &&
                Objects.equals(parent, company.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parent, employeeCount);
    }
}
