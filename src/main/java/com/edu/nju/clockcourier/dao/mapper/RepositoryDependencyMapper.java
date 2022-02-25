package com.edu.nju.clockcourier.dao.mapper;

import static com.edu.nju.clockcourier.dao.support.RepositoryDependencyDSS.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.edu.nju.clockcourier.po.RepositoryDependencyPO;
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
public interface RepositoryDependencyMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(dependencyId, repositoryId, repositoryName, repositoryOwner, hostType, dependencyProjectId, dependencyProjectName, dependencyRequirements, dependencyType);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<RepositoryDependencyPO> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<RepositoryDependencyPO> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RepositoryDependencyPOResult", value = {
        @Result(column="dependency_id", property="dependencyId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="repository_id", property="repositoryId", jdbcType=JdbcType.INTEGER),
        @Result(column="repository_name", property="repositoryName", jdbcType=JdbcType.VARCHAR),
        @Result(column="repository_owner", property="repositoryOwner", jdbcType=JdbcType.VARCHAR),
        @Result(column="host_type", property="hostType", jdbcType=JdbcType.VARCHAR),
        @Result(column="dependency_project_id", property="dependencyProjectId", jdbcType=JdbcType.INTEGER),
        @Result(column="dependency_project_name", property="dependencyProjectName", jdbcType=JdbcType.VARCHAR),
        @Result(column="dependency_requirements", property="dependencyRequirements", jdbcType=JdbcType.VARCHAR),
        @Result(column="dependency_type", property="dependencyType", jdbcType=JdbcType.VARCHAR)
    })
    Optional<RepositoryDependencyPO> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="RepositoryDependencyPOResult2", value = {
        @Result(column="dependency_id", property="dependencyId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="repository_id", property="repositoryId", jdbcType=JdbcType.INTEGER),
        @Result(column="repository_name", property="repositoryName", jdbcType=JdbcType.VARCHAR),
        @Result(column="repository_owner", property="repositoryOwner", jdbcType=JdbcType.VARCHAR),
        @Result(column="host_type", property="hostType", jdbcType=JdbcType.VARCHAR),
        @Result(column="dependency_project_id", property="dependencyProjectId", jdbcType=JdbcType.INTEGER),
        @Result(column="dependency_project_name", property="dependencyProjectName", jdbcType=JdbcType.VARCHAR),
        @Result(column="dependency_requirements", property="dependencyRequirements", jdbcType=JdbcType.VARCHAR),
        @Result(column="dependency_type", property="dependencyType", jdbcType=JdbcType.VARCHAR)
    })
    List<RepositoryDependencyPO> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, repositoryDependencyPO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, repositoryDependencyPO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer dependencyId_) {
        return delete(c -> 
            c.where(dependencyId, isEqualTo(dependencyId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(RepositoryDependencyPO record) {
        return MyBatis3Utils.insert(this::insert, record, repositoryDependencyPO, c ->
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

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<RepositoryDependencyPO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, repositoryDependencyPO, c ->
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

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(RepositoryDependencyPO record) {
        return MyBatis3Utils.insert(this::insert, record, repositoryDependencyPO, c ->
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

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<RepositoryDependencyPO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, repositoryDependencyPO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<RepositoryDependencyPO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, repositoryDependencyPO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<RepositoryDependencyPO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, repositoryDependencyPO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<RepositoryDependencyPO> selectByPrimaryKey(Integer dependencyId_) {
        return selectOne(c ->
            c.where(dependencyId, isEqualTo(dependencyId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, repositoryDependencyPO, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
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

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
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

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
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

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
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