package ro.teamnet.zth.api.em;

import org.junit.Assert;
import org.junit.Test;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.appl.domain.Department;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Nicolescu on 07.07.2016.
 */
public class EntityUtilsTest {
    @Test
    public void testGetTableNameMethod() {
        String tableName = EntityUtils.getTableName(Department.class);
        assertEquals("Table name should be departments!", "departments", tableName);
    }

    @Test
    public void testGetColumn(){
        //Department.class;
        String expectedId="id";
        List<ColumnInfo> result=EntityUtils.getColumn(Department.class);
        assertNotNull(result);
        ColumnInfo testColumnInfo=EntityUtils.getColumn(Department.class).get(0);
        assertEquals(expectedId,testColumnInfo.getColumnName());
    }

    @Test
    public void testCastFromSqlType(){
        BigDecimal value=new BigDecimal(100);
        Object result;

        result=EntityUtils.castFromSqlType(value,Integer.class);
        Assert.assertTrue(result instanceof Integer);
    }

    @Test
    public void testGetFieldsByAnnotations(){
       List<Field> result=null;
        result=EntityUtils.getFieldsByAnnotations(Department.class,Id.class);
        assertEquals(1,result.size());
    }

    @Test
    public void testGetSqlValue(){
        Department dep=new Department();
        dep.setId(10);
        Object result=EntityUtils.getSqlValue(dep);
        long expected=10;
        Assert.assertEquals(expected,(long)result);
    }

}
