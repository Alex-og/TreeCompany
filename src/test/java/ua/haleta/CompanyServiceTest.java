package ua.haleta;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CompanyServiceTest {

    private final Company root = new Company(null, 10);
    private final Company manager = new Company(root, 10);
    private final Company dev = new Company(manager, 10);
    private final ICompanyService service = new CompanyServiceImpl();
    List<Company> comps = Arrays.asList(root, manager, dev);

    @Test
    public void whenCompanySingleThenTopTheSameCompany() {
        Company result = this.service.getTopLevelParent(root);
        assertThat(result, is(root));
    }

    @Test
    public void whenCompanyInChainThenTopCompanyWithParentNull() {
        Company result = this.service.getTopLevelParent(dev);
        assertThat(result, is(root));
    }

    @Test
    public void whenCompanySingleThenEmployeesOnlyInIt() {
        long result = this.service.getEmployeeCountForCompanyAndChildren(dev, comps);
        assertThat(result, is(10L));
    }

    @Test
    public void whenThreeCompanyThenSummEmployees() {
        long result = this.service.getEmployeeCountForCompanyAndChildren(root, comps);
        assertThat(result, is(30L));
    }

}