package com.edu.nju.clockcourier.dao.mapper;

import static com.edu.nju.clockcourier.dao.support.MvnLibDSS.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.edu.nju.clockcourier.po.MvnLibPO;
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
public interface MvnLibMapper {

    BasicColumn[] selectList = BasicColumn.columnList(libId, groupId, artifactId);


    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);


    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);


    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<MvnLibPO> insertStatement);


    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<MvnLibPO> multipleInsertStatement);


    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="MvnLibResult", value = {
        @Result(column="lib_id", property="libId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.VARCHAR),
        @Result(column="artifact_id", property="artifactId", jdbcType=JdbcType.VARCHAR)
    })
    Optional<MvnLibPO> selectOne(SelectStatementProvider selectStatement);


    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="MvnLibResult", value = {
        @Result(column="lib_id", property="libId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.VARCHAR),
        @Result(column="artifact_id", property="artifactId", jdbcType=JdbcType.VARCHAR)
    })
    List<MvnLibPO> selectMany(SelectStatementProvider selectStatement);


    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);


    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, mvnLib, completer);
    }


    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, mvnLib, completer);
    }


    default int deleteByPrimaryKey(Integer libId_) {
        return delete(c -> 
            c.where(libId, isEqualTo(libId_))
        );
    }


    default int insert(MvnLibPO record) {
        return MyBatis3Utils.insert(this::insert, record, mvnLib, c ->
            c.map(libId).toProperty("libId")
            .map(groupId).toProperty("groupId")
            .map(artifactId).toProperty("artifactId")
        );
    }


    default int insertMultiple(Collection<MvnLibPO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, mvnLib, c ->
            c.map(libId).toProperty("libId")
            .map(groupId).toProperty("groupId")
            .map(artifactId).toProperty("artifactId")
        );
    }


    default int insertSelective(MvnLibPO record) {
        return MyBatis3Utils.insert(this::insert, record, mvnLib, c ->
            c.map(libId).toPropertyWhenPresent("libId", record::getLibId)
            .map(groupId).toPropertyWhenPresent("groupId", record::getGroupId)
            .map(artifactId).toPropertyWhenPresent("artifactId", record::getArtifactId)
        );
    }


    default Optional<MvnLibPO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, mvnLib, completer);
    }


    default List<MvnLibPO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, mvnLib, completer);
    }


    default List<MvnLibPO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, mvnLib, completer);
    }


    default Optional<MvnLibPO> selectByPrimaryKey(Integer libId_) {
        return selectOne(c ->
            c.where(libId, isEqualTo(libId_))
        );
    }


    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, mvnLib, completer);
    }


    static UpdateDSL<UpdateModel> updateAllColumns(MvnLibPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(libId).equalTo(record::getLibId)
                .set(groupId).equalTo(record::getGroupId)
                .set(artifactId).equalTo(record::getArtifactId);
    }


    static UpdateDSL<UpdateModel> updateSelectiveColumns(MvnLibPO record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(libId).equalToWhenPresent(record::getLibId)
                .set(groupId).equalToWhenPresent(record::getGroupId)
                .set(artifactId).equalToWhenPresent(record::getArtifactId);
    }


    default int updateByPrimaryKey(MvnLibPO record) {
        return update(c ->
            c.set(groupId).equalTo(record::getGroupId)
            .set(artifactId).equalTo(record::getArtifactId)
            .where(libId, isEqualTo(record::getLibId))
        );
    }


    default int updateByPrimaryKeySelective(MvnLibPO record) {
        return update(c ->
            c.set(groupId).equalToWhenPresent(record::getGroupId)
            .set(artifactId).equalToWhenPresent(record::getArtifactId)
            .where(libId, isEqualTo(record::getLibId))
        );
    }
}