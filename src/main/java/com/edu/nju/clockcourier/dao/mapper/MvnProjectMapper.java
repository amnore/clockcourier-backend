package com.edu.nju.clockcourier.dao.mapper;

import com.edu.nju.clockcourier.po.MvnProjectPO;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import javax.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.edu.nju.clockcourier.dao.support.MvnProjectDSS.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
@Generated("org.mybatis.generator.api.MyBatisGenerator")
public interface MvnProjectMapper {
    BasicColumn[] selectList = BasicColumn.columnList(projectId, name, url);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    int insert(InsertStatementProvider<MvnProjectPO> insertStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<MvnProjectPO> multipleInsertStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "MvnProjectResult", value = {
            @Result(column = "project_id", property = "projectId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "url", property = "url", jdbcType = JdbcType.VARCHAR)
    })
    Optional<MvnProjectPO> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("MvnProjectResult")
    List<MvnProjectPO> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, mvnProject, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, mvnProject, completer);
    }

    default int deleteByPrimaryKey(Integer projectId_) {
        return delete(c ->
                c.where(projectId, isEqualTo(projectId_))
        );
    }

    default int insert(MvnProjectPO record) {
        return MyBatis3Utils.insert(this::insert, record, mvnProject, c ->
                c.map(projectId).toProperty("projectId")
                        .map(name).toProperty("name")
                        .map(url).toProperty("url")
        );
    }

    default int insertMultiple(Collection<MvnProjectPO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, mvnProject, c ->
                c.map(projectId).toProperty("projectId")
                        .map(name).toProperty("name")
                        .map(url).toProperty("url")
        );
    }

    default int insertSelective(MvnProjectPO record) {
        return MyBatis3Utils.insert(this::insert, record, mvnProject, c ->
                c.map(projectId).toPropertyWhenPresent("projectId", record::getProjectId)
                        .map(name).toPropertyWhenPresent("name", record::getName)
                        .map(url).toPropertyWhenPresent("url", record::getUrl)
        );
    }

    default Optional<MvnProjectPO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, mvnProject, completer);
    }

    default List<MvnProjectPO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, mvnProject, completer);
    }

    default List<MvnProjectPO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, mvnProject, completer);
    }

    default Optional<MvnProjectPO> selectByPrimaryKey(Integer projectId_) {
        return selectOne(c ->
                c.where(projectId, isEqualTo(projectId_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, mvnProject, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(MvnProjectPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(projectId).equalTo(record::getProjectId)
                .set(name).equalTo(record::getName)
                .set(url).equalTo(record::getUrl);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(MvnProjectPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(projectId).equalToWhenPresent(record::getProjectId)
                .set(name).equalToWhenPresent(record::getName)
                .set(url).equalToWhenPresent(record::getUrl);
    }

    default int updateByPrimaryKey(MvnProjectPO record) {
        return update(c ->
                c.set(name).equalTo(record::getName)
                        .set(url).equalTo(record::getUrl)
                        .where(projectId, isEqualTo(record::getProjectId))
        );
    }

    default int updateByPrimaryKeySelective(MvnProjectPO record) {
        return update(c ->
                c.set(name).equalToWhenPresent(record::getName)
                        .set(url).equalToWhenPresent(record::getUrl)
                        .where(projectId, isEqualTo(record::getProjectId))
        );
    }

}