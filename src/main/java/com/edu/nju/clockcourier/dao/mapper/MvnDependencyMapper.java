package com.edu.nju.clockcourier.dao.mapper;

import com.edu.nju.clockcourier.po.MvnDependencyPO;
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

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.edu.nju.clockcourier.dao.support.MvnDepDSS.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface MvnDependencyMapper {

    BasicColumn[] selectList = BasicColumn.columnList(projectId, version, libId, libVersion);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    int insert(InsertStatementProvider<MvnDependencyPO> insertStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<MvnDependencyPO> multipleInsertStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "MvnDependencyResult", value = {
            @Result(column = "project_id", property = "projectId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "version", property = "version", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "lib_id", property = "libId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "lib_version", property = "libVersion", jdbcType = JdbcType.VARCHAR)
    })
    Optional<MvnDependencyPO> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("MvnDependencyResult")
    List<MvnDependencyPO> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, mvnDependency, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, mvnDependency, completer);
    }

    default int deleteByPrimaryKey(Integer projectId_, String version_, Integer libId_) {
        return delete(c ->
                c.where(projectId, isEqualTo(projectId_))
                        .and(version, isEqualTo(version_))
                        .and(libId, isEqualTo(libId_))
        );
    }

    default int insert(MvnDependencyPO record) {
        return MyBatis3Utils.insert(this::insert, record, mvnDependency, c ->
                c.map(projectId).toProperty("projectId")
                        .map(version).toProperty("version")
                        .map(libId).toProperty("libId")
                        .map(libVersion).toProperty("libVersion")
        );
    }

    default int insertMultiple(Collection<MvnDependencyPO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, mvnDependency, c ->
                c.map(projectId).toProperty("projectId")
                        .map(version).toProperty("version")
                        .map(libId).toProperty("libId")
                        .map(libVersion).toProperty("libVersion")
        );
    }

    default int insertSelective(MvnDependencyPO record) {
        return MyBatis3Utils.insert(this::insert, record, mvnDependency, c ->
                c.map(projectId).toPropertyWhenPresent("projectId", record::getProjectId)
                        .map(version).toPropertyWhenPresent("version", record::getVersion)
                        .map(libId).toPropertyWhenPresent("libId", record::getLibId)
                        .map(libVersion).toPropertyWhenPresent("libVersion", record::getLibVersion)
        );
    }

    default Optional<MvnDependencyPO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, mvnDependency, completer);
    }

    default List<MvnDependencyPO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, mvnDependency, completer);
    }

    default List<MvnDependencyPO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, mvnDependency, completer);
    }

    default Optional<MvnDependencyPO> selectByPrimaryKey(Integer projectId_, String version_, Integer libId_) {
        return selectOne(c ->
                c.where(projectId, isEqualTo(projectId_))
                        .and(version, isEqualTo(version_))
                        .and(libId, isEqualTo(libId_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, mvnDependency, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(MvnDependencyPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(projectId).equalTo(record::getProjectId)
                .set(version).equalTo(record::getVersion)
                .set(libId).equalTo(record::getLibId)
                .set(libVersion).equalTo(record::getLibVersion);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(MvnDependencyPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(projectId).equalToWhenPresent(record::getProjectId)
                .set(version).equalToWhenPresent(record::getVersion)
                .set(libId).equalToWhenPresent(record::getLibId)
                .set(libVersion).equalToWhenPresent(record::getLibVersion);
    }

    default int updateByPrimaryKey(MvnDependencyPO record) {
        return update(c ->
                c.set(libVersion).equalTo(record::getLibVersion)
                        .where(projectId, isEqualTo(record::getProjectId))
                        .and(version, isEqualTo(record::getVersion))
                        .and(libId, isEqualTo(record::getLibId))
        );
    }

    default int updateByPrimaryKeySelective(MvnDependencyPO record) {
        return update(c ->
                c.set(libVersion).equalToWhenPresent(record::getLibVersion)
                        .where(projectId, isEqualTo(record::getProjectId))
                        .and(version, isEqualTo(record::getVersion))
                        .and(libId, isEqualTo(record::getLibId))
        );
    }

}