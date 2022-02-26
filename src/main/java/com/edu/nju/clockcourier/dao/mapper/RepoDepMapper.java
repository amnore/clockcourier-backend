package com.edu.nju.clockcourier.dao.mapper;

import com.edu.nju.clockcourier.po.RepositoryDependencyPO;
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

import javax.annotation.processing.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static com.edu.nju.clockcourier.dao.support.RepoDepDSS.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
@Generated("org.mybatis.generator.api.MyBatisGenerator")
public interface RepoDepMapper {

    BasicColumn[] selectList = BasicColumn.columnList(dependencyId, repositoryId, repositoryName, repositoryOwner, hostType, dependencyProjectId, dependencyProjectName, dependencyRequirements, dependencyType);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    int insert(InsertStatementProvider<RepositoryDependencyPO> insertStatement);

    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<RepositoryDependencyPO> multipleInsertStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "RepositoryDependencyPOResult", value = {
            @Result(column = "dependency_id", property = "dependencyId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "repository_id", property = "repositoryId", jdbcType = JdbcType.INTEGER),
            @Result(column = "repository_name", property = "repositoryName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "repository_owner", property = "repositoryOwner", jdbcType = JdbcType.VARCHAR),
            @Result(column = "host_type", property = "hostType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "dependency_project_id", property = "dependencyProjectId", jdbcType = JdbcType.INTEGER),
            @Result(column = "dependency_project_name", property = "dependencyProjectName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "dependency_requirements", property = "dependencyRequirements", jdbcType = JdbcType.VARCHAR),
            @Result(column = "dependency_type", property = "dependencyType", jdbcType = JdbcType.VARCHAR)
    })
    Optional<RepositoryDependencyPO> selectOne(SelectStatementProvider selectStatement);

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "RepositoryDependencyPOResult2", value = {
            @Result(column = "dependency_id", property = "dependencyId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "repository_id", property = "repositoryId", jdbcType = JdbcType.INTEGER),
            @Result(column = "repository_name", property = "repositoryName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "repository_owner", property = "repositoryOwner", jdbcType = JdbcType.VARCHAR),
            @Result(column = "host_type", property = "hostType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "dependency_project_id", property = "dependencyProjectId", jdbcType = JdbcType.INTEGER),
            @Result(column = "dependency_project_name", property = "dependencyProjectName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "dependency_requirements", property = "dependencyRequirements", jdbcType = JdbcType.VARCHAR),
            @Result(column = "dependency_type", property = "dependencyType", jdbcType = JdbcType.VARCHAR)
    })
    List<RepositoryDependencyPO> selectMany(SelectStatementProvider selectStatement);

    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, REPOSITORY_DEPENDENCIES, completer);
    }

    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, REPOSITORY_DEPENDENCIES, completer);
    }

    default int deleteByPrimaryKey(Integer dependencyId_) {
        return delete(c ->
                c.where(dependencyId, isEqualTo(dependencyId_))
        );
    }

    default int insert(RepositoryDependencyPO record) {
        return MyBatis3Utils.insert(this::insert, record, REPOSITORY_DEPENDENCIES, c ->
                c.map(dependencyId).toProperty("dependencyId")
                        .map(repositoryId).toProperty("repositoryId")
                        .map(repositoryName).toProperty("repositoryName")
                        .map(repositoryOwner).toProperty("repositoryOwner")
                        .map(hostType).toProperty("hostType")
                        .map(dependencyProjectId).toProperty("dependencyProjectId")
                        .map(dependencyProjectName).toProperty("dependencyProjectName")
                        .map(dependencyRequirements).toProperty("dependencyRequirements")
                        .map(dependencyType).toProperty("dependencyType")
        );
    }

    default int insertMultiple(Collection<RepositoryDependencyPO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, REPOSITORY_DEPENDENCIES, c ->
                c.map(dependencyId).toProperty("dependencyId")
                        .map(repositoryId).toProperty("repositoryId")
                        .map(repositoryName).toProperty("repositoryName")
                        .map(repositoryOwner).toProperty("repositoryOwner")
                        .map(hostType).toProperty("hostType")
                        .map(dependencyProjectId).toProperty("dependencyProjectId")
                        .map(dependencyProjectName).toProperty("dependencyProjectName")
                        .map(dependencyRequirements).toProperty("dependencyRequirements")
                        .map(dependencyType).toProperty("dependencyType")
        );
    }

    default int insertSelective(RepositoryDependencyPO record) {
        return MyBatis3Utils.insert(this::insert, record, REPOSITORY_DEPENDENCIES, c ->
                c.map(dependencyId).toPropertyWhenPresent("dependencyId", record::getDependencyId)
                        .map(repositoryId).toPropertyWhenPresent("repositoryId", record::getRepositoryId)
                        .map(repositoryName).toPropertyWhenPresent("repositoryName", record::getRepositoryName)
                        .map(repositoryOwner).toPropertyWhenPresent("repositoryOwner", record::getRepositoryOwner)
                        .map(hostType).toPropertyWhenPresent("hostType", record::getHostType)
                        .map(dependencyProjectId).toPropertyWhenPresent("dependencyProjectId", record::getDependencyProjectId)
                        .map(dependencyProjectName).toPropertyWhenPresent("dependencyProjectName", record::getDependencyProjectName)
                        .map(dependencyRequirements).toPropertyWhenPresent("dependencyRequirements", record::getDependencyRequirements)
                        .map(dependencyType).toPropertyWhenPresent("dependencyType", record::getDependencyType)
        );
    }

    default Optional<RepositoryDependencyPO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, REPOSITORY_DEPENDENCIES, completer);
    }

    default List<RepositoryDependencyPO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, REPOSITORY_DEPENDENCIES, completer);
    }

    default List<RepositoryDependencyPO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, REPOSITORY_DEPENDENCIES, completer);
    }

    default Optional<RepositoryDependencyPO> selectByPrimaryKey(Integer dependencyId_) {
        return selectOne(c ->
                c.where(dependencyId, isEqualTo(dependencyId_))
        );
    }

    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, REPOSITORY_DEPENDENCIES, completer);
    }

    static UpdateDSL<UpdateModel> updateAllColumns(RepositoryDependencyPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(dependencyId).equalTo(record::getDependencyId)
                .set(repositoryId).equalTo(record::getRepositoryId)
                .set(repositoryName).equalTo(record::getRepositoryName)
                .set(repositoryOwner).equalTo(record::getRepositoryOwner)
                .set(hostType).equalTo(record::getHostType)
                .set(dependencyProjectId).equalTo(record::getDependencyProjectId)
                .set(dependencyProjectName).equalTo(record::getDependencyProjectName)
                .set(dependencyRequirements).equalTo(record::getDependencyRequirements)
                .set(dependencyType).equalTo(record::getDependencyType);
    }

    static UpdateDSL<UpdateModel> updateSelectiveColumns(RepositoryDependencyPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(dependencyId).equalToWhenPresent(record::getDependencyId)
                .set(repositoryId).equalToWhenPresent(record::getRepositoryId)
                .set(repositoryName).equalToWhenPresent(record::getRepositoryName)
                .set(repositoryOwner).equalToWhenPresent(record::getRepositoryOwner)
                .set(hostType).equalToWhenPresent(record::getHostType)
                .set(dependencyProjectId).equalToWhenPresent(record::getDependencyProjectId)
                .set(dependencyProjectName).equalToWhenPresent(record::getDependencyProjectName)
                .set(dependencyRequirements).equalToWhenPresent(record::getDependencyRequirements)
                .set(dependencyType).equalToWhenPresent(record::getDependencyType);
    }

    default int updateByPrimaryKey(RepositoryDependencyPO record) {
        return update(c ->
                c.set(repositoryId).equalTo(record::getRepositoryId)
                        .set(repositoryName).equalTo(record::getRepositoryName)
                        .set(repositoryOwner).equalTo(record::getRepositoryOwner)
                        .set(hostType).equalTo(record::getHostType)
                        .set(dependencyProjectId).equalTo(record::getDependencyProjectId)
                        .set(dependencyProjectName).equalTo(record::getDependencyProjectName)
                        .set(dependencyRequirements).equalTo(record::getDependencyRequirements)
                        .set(dependencyType).equalTo(record::getDependencyType)
                        .where(dependencyId, isEqualTo(record::getDependencyId))
        );
    }

    default int updateByPrimaryKeySelective(RepositoryDependencyPO record) {
        return update(c ->
                c.set(repositoryId).equalToWhenPresent(record::getRepositoryId)
                        .set(repositoryName).equalToWhenPresent(record::getRepositoryName)
                        .set(repositoryOwner).equalToWhenPresent(record::getRepositoryOwner)
                        .set(hostType).equalToWhenPresent(record::getHostType)
                        .set(dependencyProjectId).equalToWhenPresent(record::getDependencyProjectId)
                        .set(dependencyProjectName).equalToWhenPresent(record::getDependencyProjectName)
                        .set(dependencyRequirements).equalToWhenPresent(record::getDependencyRequirements)
                        .set(dependencyType).equalToWhenPresent(record::getDependencyType)
                        .where(dependencyId, isEqualTo(record::getDependencyId))
        );
    }

}