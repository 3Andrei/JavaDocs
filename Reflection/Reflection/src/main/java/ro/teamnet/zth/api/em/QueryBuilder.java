package ro.teamnet.zth.api.em;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;

/**
 * Created by Nicolescu on 07.07.2016.
 */
public class QueryBuilder {
    private Object tableName;
    private List<ColumnInfo> queryColumns;
    private QueryType queryType;
    private List<Condition> conditions;

    public static String getValueForQuery(Object value){
        String result=null;

        if(value instanceof String){
            result="'"+value+"'";
        }else if(value instanceof Date){
            DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
            result="TO_DATE('"+dateFormat.format((Date)value)+"','mm-dd-YYYY'";
        }
        return result;
    }


    public QueryBuilder addCondition(Condition condition){
        conditions.add(condition);
        return this;
    }


    public QueryBuilder setTableName(Object tableName){
       this.tableName=tableName;
        return this;
    }

    public QueryBuilder addQueryColumns(List<ColumnInfo>queryColumns){
        this.queryColumns=queryColumns;
        return this;
    }

    public QueryBuilder setQueryType(QueryType queryType){
        this.queryType=queryType;
        return this;
    }
}
