package com.edu.nju.clockcourier.dao.mapper;

import com.edu.nju.clockcourier.po.MvnProjPO;
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

import static com.edu.nju.clockcourier.dao.support.MvnProjDSS.*;

@Mapper
public interface MvnProjMapper {

    BasicColumn[] selectList = BasicColumn.columnList(projectId, version, groupId, artifactId, name, url, description);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "record.projectId", before = false, resultType = Integer.class)
    int insert(InsertStatementProvider<MvnProjPO> insertStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<MvnProjPO> multipleInsertStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "MvnProjectResult", value = {
            @Result(column = "project_id", property = "projectId", jdbcType = JdbcType.INTEGER),
            @Result(column = "version", property = "version", jdbcType = JdbcType.VARCHAR),
            @Result(column = "group_id", property = "groupId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "artifact_id", property = "artifactId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "url", property = "url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "description", property = "description", jdbcType = JdbcType.VARCHAR)
    })
    Optional<MvnProjPO> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("MvnProjectResult")
    List<MvnProjPO> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, mvnProject, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, mvnProject, completer);
    }

    default int insert(MvnProjPO record) {
        return MyBatis3Utils.insert(this::insert, record, mvnProject, c ->
                c.map(projectId)
                        .toProperty("projectId")
                        .map(version).toProperty("version")
                        .map(groupId).toProperty("groupId")
                        .map(artifactId).toProperty("artifactId")
                        .map(name).toProperty("name")
                        .map(url).toProperty("url")
                        .map(description).toProperty("description")
        );
    }

    default int insertMultiple(Collection<MvnProjPO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, mvnProject, c ->
                c.map(projectId).toProperty("projectId")
                        .map(version).toProperty("version")
                        .map(groupId).toProperty("groupId")
                        .map(artifactId).toProperty("artifactId")
                        .map(name).toProperty("name")
                        .map(url).toProperty("url")
                        .map(description).toProperty("description")
        );
    }

    default int insertSelective(MvnProjPO record) {
        return MyBatis3Utils.insert(this::insert, record, mvnProject, c ->
                c.map(projectId).toPropertyWhenPresent("projectId", record::getProjectId)
                        .map(version).toPropertyWhenPresent("version", record::getVersion)
                        .map(groupId).toPropertyWhenPresent("groupId", record::getGroupId)
                        .map(artifactId).toPropertyWhenPresent("artifactId", record::getArtifactId)
                        .map(name).toPropertyWhenPresent("name", record::getName)
                        .map(url).toPropertyWhenPresent("url", record::getUrl)
                        .map(description).toPropertyWhenPresent("description", record::getDescription)
        );
    }

    default Optional<MvnProjPO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, mvnProject, completer);
    }

    default List<MvnProjPO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, mvnProject, completer);
    }

    default List<MvnProjPO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, mvnProject, completer);
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, mvnProject, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(MvnProjPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(projectId).equalTo(record::getProjectId)
                .set(version).equalTo(record::getVersion)
                .set(groupId).equalTo(record::getGroupId)
                .set(artifactId).equalTo(record::getArtifactId)
                .set(name).equalTo(record::getName)
                .set(url).equalTo(record::getUrl)
                .set(description).equalTo(record::getDescription);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(MvnProjPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(projectId).equalToWhenPresent(record::getProjectId)
                .set(version).equalToWhenPresent(record::getVersion)
                .set(groupId).equalToWhenPresent(record::getGroupId)
                .set(artifactId).equalToWhenPresent(record::getArtifactId)
                .set(name).equalToWhenPresent(record::getName)
                .set(url).equalToWhenPresent(record::getUrl)
                .set(description).equalToWhenPresent(record::getDescription);
    }

}