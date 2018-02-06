package com.luxoft.logeek;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.luxoft.logeek.entity.Child;
import com.luxoft.logeek.entity.Parent;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.annotation.Commit;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@Commit
@DatabaseSetup("/ChildRepositoryTest.xml")
public class ChildRepositoryTest extends TestBase {

    @Test
    public void testNamedQuery() {
        List<Child> children = childRepository.findByParentName("мама");
        assertEquals(2, children.size());
    }

    @Test
    public void testQueryWithExplicitJoin() {
        List<Child> children = childRepository.findByParentNameWithExplicitJoin("мама");
        assertEquals(2, children.size());
    }

    @Test
    public void testQueryWithoutExplicitJoin() {
        List<Child> children = childRepository.findByParentNameNoExplicitJoin("мама");
        assertEquals(2, children.size());
    }

    @Test
    public void findByParentId() {
        childRepository.findByParentId(1L);
    }

    @Test
    public void findByParentIdWithExplicitJoin() {
        childRepository.findByParentIdWithExplicitJoin(1L);
    }

    @Test
    public void findByParentIdWithoutExplicitJoin() {
        childRepository.findByParentIdWithoutExplicitJoin(1L);
    }

    @Test
    public void testFindWithTemplate() {
        List<Child> children = childRepository.findUsingTemplate(false, false, false);
        assertFalse(children.isEmpty());
    }


}
