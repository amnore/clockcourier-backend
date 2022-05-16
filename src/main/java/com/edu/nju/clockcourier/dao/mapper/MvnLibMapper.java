package com.edu.nju.clockcourier.dao.mapper;

import com.edu.nju.clockcourier.po.MvnLibPO;
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

import static com.edu.nju.clockcourier.dao.support.MvnLibDSS.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface MvnLibMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(libId, groupId, artifactId, mvnCtrUrl, githubUrl);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type = SqlProviderAdapter.class, method = "delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    int insert(InsertStatementProvider<MvnLibPO> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<MvnLibPO> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "MvnLibResult", value = {
            @Result(column = "lib_id", property = "libId", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "group_id", property = "groupId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "artifact_id", property = "artifactId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "mvn_ctr_url", property = "mvnCtrUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "github_url", property = "githubUrl", jdbcType = JdbcType.VARCHAR)
    })
    Optional<MvnLibPO> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @ResultMap("MvnLibResult")
    List<MvnLibPO> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type = SqlProviderAdapter.class, method = "update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, mvnLib, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, mvnLib, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer libId_) {
        return delete(c ->
                c.where(libId, isEqualTo(libId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(MvnLibPO record) {
        return MyBatis3Utils.insert(this::insert, record, mvnLib, c ->
                c.map(libId).toProperty("libId")
                        .map(groupId).toProperty("groupId")
                        .map(artifactId).toProperty("artifactId")
                        .map(mvnCtrUrl).toProperty("mvnCtrUrl")
                        .map(githubUrl).toProperty("githubUrl")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<MvnLibPO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, mvnLib, c ->
                c.map(libId).toProperty("libId")
                        .map(groupId).toProperty("groupId")
                        .map(artifactId).toProperty("artifactId")
                        .map(mvnCtrUrl).toProperty("mvnCtrUrl")
                        .map(githubUrl).toProperty("githubUrl")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(MvnLibPO record) {
        return MyBatis3Utils.insert(this::insert, record, mvnLib, c ->
                c.map(libId).toPropertyWhenPresent("libId", record::getLibId)
                        .map(groupId).toPropertyWhenPresent("groupId", record::getGroupId)
                        .map(artifactId).toPropertyWhenPresent("artifactId", record::getArtifactId)
                        .map(mvnCtrUrl).toPropertyWhenPresent("mvnCtrUrl", record::getMvnCtrUrl)
                        .map(githubUrl).toPropertyWhenPresent("githubUrl", record::getGithubUrl)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<MvnLibPO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, mvnLib, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<MvnLibPO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, mvnLib, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<MvnLibPO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, mvnLib, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<MvnLibPO> selectByPrimaryKey(Integer libId_) {
        return selectOne(c ->
                c.where(libId, isEqualTo(libId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, mvnLib, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(MvnLibPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(libId).equalTo(record::getLibId)
                .set(groupId).equalTo(record::getGroupId)
                .set(artifactId).equalTo(record::getArtifactId)
                .set(mvnCtrUrl).equalTo(record::getMvnCtrUrl)
                .set(githubUrl).equalTo(record::getGithubUrl);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(MvnLibPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(libId).equalToWhenPresent(record::getLibId)
                .set(groupId).equalToWhenPresent(record::getGroupId)
                .set(artifactId).equalToWhenPresent(record::getArtifactId)
                .set(mvnCtrUrl).equalToWhenPresent(record::getMvnCtrUrl)
                .set(githubUrl).equalToWhenPresent(record::getGithubUrl);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(MvnLibPO record) {
        return update(c ->
                c.set(groupId).equalTo(record::getGroupId)
                        .set(artifactId).equalTo(record::getArtifactId)
                        .set(mvnCtrUrl).equalTo(record::getMvnCtrUrl)
                        .set(githubUrl).equalTo(record::getGithubUrl)
                        .where(libId, isEqualTo(record::getLibId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(MvnLibPO record) {
        return update(c ->
                c.set(groupId).equalToWhenPresent(record::getGroupId)
                        .set(artifactId).equalToWhenPresent(record::getArtifactId)
                        .set(mvnCtrUrl).equalToWhenPresent(record::getMvnCtrUrl)
                        .set(githubUrl).equalToWhenPresent(record::getGithubUrl)
                        .where(libId, isEqualTo(record::getLibId))
        );
    }
}