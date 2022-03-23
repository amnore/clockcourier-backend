package com.edu.nju.clockcourier.dao.mapper;

import static com.edu.nju.clockcourier.dao.support.MvnProjectDSS.*;

import com.edu.nju.clockcourier.po.MvnProject;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
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

@Mapper
public interface MvnProjectMapper {

    BasicColumn[] selectList = BasicColumn.columnList(projectId, version, groupId, artifactId, name, url, description);


    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);


    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);


    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<MvnProject> insertStatement);


    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<MvnProject> multipleInsertStatement);


    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="MvnProjectResult", value = {
        @Result(column="project_id", property="projectId", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.VARCHAR),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.VARCHAR),
        @Result(column="artifact_id", property="artifactId", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    Optional<MvnProject> selectOne(SelectStatementProvider selectStatement);


    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="MvnProjectResult", value = {
        @Result(column="project_id", property="projectId", jdbcType=JdbcType.INTEGER),
        @Result(column="version", property="version", jdbcType=JdbcType.VARCHAR),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.VARCHAR),
        @Result(column="artifact_id", property="artifactId", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    List<MvnProject> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, mvnProject, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, mvnProject, completer);
    }

    default int insert(MvnProject record) {
        return MyBatis3Utils.insert(this::insert, record, mvnProject, c ->
            c.map(projectId).toProperty("projectId")
            .map(version).toProperty("version")
            .map(groupId).toProperty("groupId")
            .map(artifactId).toProperty("artifactId")
            .map(name).toProperty("name")
            .map(url).toProperty("url")
            .map(description).toProperty("description")
        );
    }


    default int insertMultiple(Collection<MvnProject> records) {
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


    default int insertSelective(MvnProject record) {
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


    default Optional<MvnProject> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, mvnProject, completer);
    }


    default List<MvnProject> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, mvnProject, completer);
    }


    default List<MvnProject> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, mvnProject, completer);
    }


    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, mvnProject, completer);
    }


    static UpdateDSL<UpdateModel> updateAllColumns(MvnProject record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(projectId).equalTo(record::getProjectId)
                .set(version).equalTo(record::getVersion)
                .set(groupId).equalTo(record::getGroupId)
                .set(artifactId).equalTo(record::getArtifactId)
                .set(name).equalTo(record::getName)
                .set(url).equalTo(record::getUrl)
                .set(description).equalTo(record::getDescription);
    }


    static UpdateDSL<UpdateModel> updateSelectiveColumns(MvnProject record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(projectId).equalToWhenPresent(record::getProjectId)
                .set(version).equalToWhenPresent(record::getVersion)
                .set(groupId).equalToWhenPresent(record::getGroupId)
                .set(artifactId).equalToWhenPresent(record::getArtifactId)
                .set(name).equalToWhenPresent(record::getName)
                .set(url).equalToWhenPresent(record::getUrl)
                .set(description).equalToWhenPresent(record::getDescription);
    }
}