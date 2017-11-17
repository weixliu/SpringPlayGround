package com.xw.io.springboot.druid;


import com.alibaba.druid.sql.PagerUtils;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.visitor.MySqlExportParameterVisitor;
import com.alibaba.druid.sql.visitor.ExportParameterVisitor;
import com.alibaba.druid.sql.visitor.ParameterizedOutputVisitorUtils;
import com.alibaba.druid.sql.visitor.SQLEvalVisitorUtils;
import com.alibaba.druid.sql.visitor.SchemaStatVisitor;
import com.alibaba.druid.stat.TableStat;
import com.alibaba.druid.util.JdbcConstants;
import com.alibaba.druid.util.JdbcUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by xiaowei.liu on 14/11/2017.
 */
public class DruidLearn {
    public static void main(String[] args) {
        System.out.println( SQLEvalVisitorUtils.evalExpr(JdbcConstants.MYSQL, "? between 1 and 3", 0) );
        System.out.println( SQLEvalVisitorUtils.evalExpr(JdbcConstants.MYSQL, "? between 1 and 3", 1) );

        System.out.println("=======================================");

        //ExportParameterVistor_demo_cn
        String sql = "select * from series_genres, genres where series_genres.genre_id=genres.id and series_genres.`series_id`='99cb14ab-6b1d-4221-a94a-ba0fa65fb114'";
        List<SQLStatement> stmtList = SQLUtils.parseStatements(sql, JdbcConstants.MYSQL);

        StringBuilder out = new StringBuilder();
        List lst = new ArrayList();
        ExportParameterVisitor vistor = new MySqlExportParameterVisitor(lst, out, true);
        for(SQLStatement sqlStatement : stmtList) {
            sqlStatement.accept(vistor);
        }

        String prepareSqlStatement = out.toString();
        System.out.println(prepareSqlStatement);

        System.out.println("=======================================");

        List<Object> parameters = vistor.getParameters();
        for(Object o : parameters) {
            System.out.println(o);
        }

        System.out.println("=======================================");

        for(Object o : lst) {
            System.out.println(o);
        }

        System.out.println("=======================================");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_druid", "root", "123qWe!@#");
            String createDatabaseSql = JdbcUtils.getCreateTableScript(conn, JdbcConstants.MYSQL);

            System.out.println(createDatabaseSql);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("=======================================");

        List<Object> outputList = new ArrayList<Object>();
        System.out.println(ParameterizedOutputVisitorUtils.parameterize(sql, JdbcConstants.MYSQL, outputList) );
        for(Object o : outputList) {
            System.out.println(o);
        }

        System.out.println("=======================================");

        SQLStatement stmt = stmtList.get(0);
        SchemaStatVisitor schemaStatVisitor = SQLUtils.createSchemaStatVisitor(JdbcConstants.MYSQL);
        stmt.accept(schemaStatVisitor);

        System.out.println(schemaStatVisitor.getColumns());
        System.out.println(schemaStatVisitor.getTables());
        System.out.println(schemaStatVisitor.getConditions());

        Set<TableStat.Relationship> relationshipSet = schemaStatVisitor.getRelationships();
        for(TableStat.Relationship relationship : relationshipSet) {
            System.out.println(relationship);
        }

        System.out.println("=======================================");

        String createSql = "create table t_org (fid int, name varchar(20))";
        List<SQLStatement> listSqlStatement = SQLUtils.parseStatements(createSql, JdbcConstants.MYSQL);
        SQLStatement cStmt = listSqlStatement.get(0);
        SchemaStatVisitor cSchemaStatVisitor = SQLUtils.createSchemaStatVisitor(JdbcConstants.MYSQL);
        cStmt.accept(cSchemaStatVisitor);

        System.out.println(cSchemaStatVisitor.getTables());
        System.out.println(cSchemaStatVisitor.getColumns());

        System.out.println("=======================================");

        System.out.println(SQLUtils.format(sql, JdbcConstants.MYSQL, SQLUtils.DEFAULT_FORMAT_OPTION));
        System.out.println(SQLUtils.format(sql, JdbcConstants.MYSQL, SQLUtils.DEFAULT_LCASE_FORMAT_OPTION));

        System.out.println("=======================================");

        String sql1 = "select id, name from t_bad order by id";
        System.out.println( PagerUtils.count(sql1, JdbcConstants.MYSQL) );

        System.out.println("=======================================");

        String sql2 = "select * from t";
        String result = PagerUtils.limit(sql2, JdbcConstants.MYSQL, 20, 10);
        System.out.println(result);

        System.out.println("=======================================");

        String sql3 = " select * from test t limit 5";
        System.out.println( PagerUtils.hasUnorderedLimit(sql3, JdbcConstants.MYSQL));

        System.out.println("=======================================");

    }
}
